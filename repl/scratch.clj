(use 'looping-is-recursion :reload)

; Write the function (cut-at-repetition a-seq) that takes in
; a sequence and returns elements from the sequence up to the first repetition.

(cut-at-repetition [1 1 1 1 1])
;=> [1] doesn't have to be a vector, a sequence is fine too
(cut-at-repetition [:cat :dog :house :milk 1 :cat :dog])
;=> [:cat :dog :house :milk 1]
(cut-at-repetition [0 1 2 3 4 5])
