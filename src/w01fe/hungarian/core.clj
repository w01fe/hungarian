(ns w01fe.hungarian.core
  (:import [w01fe.hungarian HungarianAlgorithm]))

(set! *warn-on-reflection* true)

(defn- aset-double2 [^"[[D" a i j v] (HungarianAlgorithm/set a i j v))

(defn- safe-get [m k]
  (let [p (find m k)]
    (assert p)
    (val p)))

(defn maximum-matching "Edges are [n1 n2 weight].  Returns weight." 
  ([^"[[D" arr] (HungarianAlgorithm/hgAlgorithm arr "max"))
  ([left-nodes right-nodes edges]
  (let [left-nodes    (seq left-nodes)
	right-nodes   (seq right-nodes)
	left-node-ids (into {} (map vector left-nodes (iterate inc 0)))
	right-node-ids (into {} (map vector right-nodes (iterate inc 0)))
	n        (count left-node-ids)
	arr      (make-array Double/TYPE n n)]
    (assert (= n (count right-node-ids)))
    (doseq [i (range n), j (range n)] (aset-double2 arr i j Double/NEGATIVE_INFINITY))
    (doseq [[n1 n2 v] edges] 
      (let [i1 (int (safe-get left-node-ids n1)),
	    i2 (int (safe-get right-node-ids n2))
	    v  (double v)]
	(aset-double2 arr i1 i2 v)))
    (maximum-matching arr))))
