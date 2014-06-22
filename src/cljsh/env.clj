(ns cljsh.env
  (:require [clojure.java.io :as io]
            [clojure.string :as str])
  (:import (java.net InetAddress))
  (:use cljsh.pwd))

(def user (System/getProperty "user.name"))
(def home (System/getProperty "user.home"))
(def os (.getHostName (InetAddress/getLocalHost)))
(def absolute-path (.getAbsolutePath (io/file ".")))

(defn cur-path []
  (str user "@" os " " (str/replace absolute-path home "~")))

