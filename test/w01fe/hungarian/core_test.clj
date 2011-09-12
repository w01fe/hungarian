(ns w01fe.hungarian.core-test
  (:use clojure.test w01fe.hungarian.core)
  (:require [clojure.contrib.combinatorics :as comb]))

(deftest hungarian-test
  (doseq [n (range 5 10)]
   (let [nn (range n)
         evs (vec (take n (repeatedly (fn [] (vec (take n (repeatedly #(rand-int 10))))))))
         es  (for [i nn, j nn] [i j (nth (nth evs i) j)])
         v   (maximum-matching nn nn es)]
     (is
      (= v 
         (apply max
                (map (fn [p]
                       (apply +
                              (for [[i v] (map vector p evs)]
                                (nth v i))))
		     (comb/permutations nn)))))))
  )




