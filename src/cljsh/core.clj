(ns cljsh.core
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [cljsh.env :as env])
  (:import [java.net InetAddress]))

(defn init []
  (eval (read-string "(use '[cljsh.core]
                             '[cljsh.pwd]
                             '[cljsh.whoami])")))

(defn exit []
  :exit)

(defn cljsh []
  (print (str (env/cur-path) " $ "))
  (flush)
  (init)
  (let [expr (read-line)
        value (eval (read-string (str "(" expr ")")))]
      (when (not= :exit value)
      (println value)
      (recur))))


(defn -main [& args]
  (cljsh))

