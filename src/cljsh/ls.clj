(ns cljsh.ls
  (:require [clojure.java.io :as io]))



(def f (io/file "."))

(def fns (vec (.list f)))

(.isDirectory f)

(defn ls
  ([& param]
   (if (>= (count param) 1)
     (let [path (last param)]
       (-> path io/file .list vec))))
  ([] (ls ".")))


(ls)
(ls ".")
(ls "/")

