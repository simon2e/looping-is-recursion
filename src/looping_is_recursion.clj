(ns looping-is-recursion)

(defn power
  ([base exp] (power base exp 1))
  ([base exp acc]
   (cond (< exp 0)
         (/ 1 (power base (* -1 exp) acc))
         (zero? exp)
         acc
         :else
         (recur base (dec exp) (* acc base)))))

(defn last-element [a-seq]
  (cond
   (empty? a-seq)
   nil
   (empty? (next a-seq))
   (first a-seq)
   :else
   (recur (next a-seq))))

(defn seq= [seq1 seq2]
  (cond
   (and (empty? seq1)
        (empty? seq2))
   true
   (or (empty? seq1)
       (empty? seq2))
   false
   (and (seq? (first seq1))
        (seq? (first seq2)))
   (and (seq= (first seq1) (first seq2))
        (seq= (next seq1)(next seq2)))
   (not (= (first seq1) (first seq2)))
   false
   :else
   (seq= (next seq1) (next seq2))))

(defn find-first-index
  ([pred a-seq] (find-first-index pred a-seq 0))
  ([pred a-seq idx]
   (cond
    (empty? a-seq)
    nil
    (pred (first a-seq))
    idx
    :else
    (recur pred (next a-seq) (inc idx)))))

(defn avg [a-seq]
  (if (empty? a-seq)
    nil
    (loop [nums (next a-seq)
           count 1
           acc (first a-seq)]
      (if (empty? nums)
        (/ acc count)
        (recur (next nums) (inc count) (+ acc (first nums)))))))

(defn toggle [a-set item]
  (if (a-set item)
    (disj a-set item)
    (conj a-set item)))

(defn parity [a-seq]
  (loop [coll a-seq
         results #{}]
    (if (empty? coll)
      results
      (recur (next coll) (toggle results (first coll))))))

(defn fast-fibo [n]
  (if (< n 1)
    0
    (loop [count n
           this 1
           prev 0]
      (if (== 1 count)
        this
        (recur (dec count) (+ this prev) this)))))

(defn cut-at-repetition [a-seq]
  (loop [coll a-seq
         acc []
         seen #{}]
    (if
      (or
       (empty? coll)
       (seen (first coll)))
      acc
      (recur (next coll) (conj acc (first coll)) (conj seen (first coll))))))

