(ns cljsh.whoami
  (:require [clojure.java.io :as io]
            [cljsh.env :as env]))

(defn whoami
  "显示当前用户
   show current user"
  []
  env/user)