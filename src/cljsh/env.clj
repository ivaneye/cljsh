(ns cljsh.env
  (:require [clojure.java.io :as io]
            [clojure.string :as str])
  (:import (java.net InetAddress)))

(def user (System/getProperty "user.name"))
(def home (System/getProperty "user.home"))
(def os (.getHostName (InetAddress/getLocalHost)))
(def absolute-path (.getAbsolutePath (io/file home)))
(def current-path (atom absolute-path))

(defn cur-path []
  (str user "@" os " " (str/replace @current-path home "~")))

