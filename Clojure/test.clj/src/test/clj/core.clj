(ns test.clj.core
  (:gen-class))

(defn -main []
  (println "Hello, World!"))

(defn factorial [n]
  (if (= n 0) 1
      (* n (factorial (dec n)))))


(defn factorial-bigint [n]
  (if (= n 0) 1
      (*' n (factorial-bigint (dec n)))))

(defn factorial-bigint-loop [n]
  (if (= n 0) 1
    (loop [val n i n]
      (if (<= i 1) val
        (recur (*' val (dec i)) (dec i))))))

(defn factorial-recur [x]
    (loop [n x f 1]
        (if (= n 1)
            f
            (recur (dec n) (* f n)))))

(defn fizz-buzz []
  (loop [i 1]
    (if (<= i 100)
      (do
        (if (and (= (rem i 3) 0) (= (rem i 5) 0))
          (println "FizzBuzz")
          (if (= (rem i 5) 0)
            (println "Buzz")
            (println i))))
      (recur (inc i)))))

(defn fizzbuzz [start finish]
  (map (fn [n]
         (cond
           (zero? (mod n 15)) "Fizzbuzz"
           (zero? (mod n 3)) "Fizz"
           (zero? (mod n 5)) "Buzz"
           :else n))
    (range start finish)))