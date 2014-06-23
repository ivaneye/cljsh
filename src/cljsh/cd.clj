(ns cljsh.cd
  (:require [cljsh.env :as env]
            [clojure.java.io :as io]))

(defn cd-fn
  "A function to implement command cd"
  ([] (cd-fn env/home))
  ([path]
   (cond
     (= "." path) ""
     (= ".." path) (if-let [p (.getParent (io/file @env/current-path))]
                     (reset! env/current-path p))
     (not (.startsWith path "/")) (cd-fn (str @env/current-path "/" path))
     :default (reset! env/current-path path))))

(defmacro cd [p]
  `(cd-fn (str '~p)))