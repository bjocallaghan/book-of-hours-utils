(ns net.bjoc.book-of-hours.dashboard-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [net.bjoc.book-of-hours.dashboard :refer []]))

(deftest commutative-test
  (is (= (+ 2 3) (+ 3 2))))
