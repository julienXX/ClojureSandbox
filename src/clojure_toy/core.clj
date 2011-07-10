; (add-classpath "file:///Users/julien/Code/clojure_toy/lib/redis-clojure.jar")

(ns clojure_toy.core
  (:use compojure.core, hiccup.core)
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            redis ))


(defn hello [params]
 (html [:h1 (str "Hello " (params :name)) ]
       [:p (str "Params: " (zipmap (keys params) (vals params)))]))

(defroutes main-routes
  (GET "/" [] "<h1>Hello from Compojure!</h1>")
  (GET "/:name" {params :params} 
       (println "GET /:name with params" (zipmap (keys params) (vals params)))
       (redis/with-server
         {:host "127.0.0.1" :port 6379 :db 0}
         (do
           (redis/set (params :name) (zipmap (keys params) (vals params)))))
       (hello params))
  (route/resources "/")
  (route/not-found "Page not found"))

(def app
  (handler/site main-routes))


