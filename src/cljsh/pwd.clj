(ns cljsh.pwd
  (:require [clojure.java.io :as io]))

(defn pwd
  "显示当前路径
   show current path"
  []
  (.getAbsolutePath (io/file ".")))

(pwd)
