(defproject clojure_toy "1.0.0-SNAPSHOT"
  :description "First Clojure app."
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [compojure "0.6.4"]
                 [hiccup "0.3.6"]
                 [redis-clojure "1.0.4"]]
  :dev-dependencies [[lein-ring "0.4.5"]]
  :ring {:handler clojure_toy.core/app})

