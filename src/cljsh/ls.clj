(ns cljsh.ls
  (:require [clojure.java.io :as io]
            [cljsh.env :as env]))

(defn ls
  ([& param]
   (if (>= (count param) 1)
     (let [path (last param)]
       (-> path io/file .list vec))))
  ([] (ls @env/current-path)))

