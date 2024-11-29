(ns net.bjoc.book-of-hours.nrepl-morse
  (:require [dev.nu.morse :as morse]
            [nrepl.middleware.print :refer [wrap-print]]
            [nrepl.middleware :refer [set-descriptor!]]
            [nrepl.transport :as transport])
  (:import [nrepl.transport Transport]))


(def thang (atom []))
(def thung (atom []))

(defn send-to-morse! [{:keys [code] :as req} {:keys [value] :as resp}]
  (swap! thang conj req)
  (swap! thung conj resp)
  ;; (def thung resp)
  ;; (println req)
  ;; (println resp)
  (when (and code (contains? resp :value))
    (morse/submit (read-string code) value)
    )
  resp)

(defn- wrap-morse-sender
  "Wraps a `Transport` with code which prints the value of messages sent to
  it using the provided function."
  [{:keys [id op ^Transport transport] :as request}]
  (reify transport/Transport
    (recv [_]
      ;; (println "recv")
      (.recv transport))
    (recv [_ timeout]
      ;; (println "recv timeout")
      (.recv transport timeout))
    (send [this resp]
      ;; (println "send")
      (.send transport
             (send-to-morse! request resp))
      this)))

(defn wrap-morse [handler]
  (fn [{:keys [id op transport] :as request}]
    (if (= op "start-morse-ui")
      (morse/ui)
      (handler (assoc request :transport (wrap-morse-sender request))))))

(comment
  (morse/launch-in-proc)
  (+ 2 3)
  (+ 3 5)

  (morse/inspect thang)
  (morse/inspect thung)
  )
