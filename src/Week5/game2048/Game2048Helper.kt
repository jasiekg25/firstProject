package Week5.game2048


/*
 * This function moves all the non-null elements to the beginning of the list
 * (by removing nulls) and merges equal elements.
 * The parameter 'merge' specifies the way how to merge equal elements:
 * it returns a new element that should be present in the resulting list
 * instead of two merged elements.
 *
 * If the function 'merge("a")' returns "aa",
 * then the function 'moveAndMergeEqual' transforms the input in the following way:
 *   a, a, b -> aa, b
 *   a, null -> a
 *   b, null, a, a -> b, aa
 *   a, a, null, a -> aa, a
 *   a, null, a, a -> aa, a
 *
 * You can find more examples in 'TestGame2048Helper'.
*/
fun <T : Any> List<T?>.moveAndMergeEqual(merge: (T) -> T): List<T> {
    val nonNulls = filterNotNull().toMutableList()
    with(nonNulls) {
        var cnt = 1
        while(cnt < this.size){
            if (this[cnt] == this[cnt - 1]) {
                this[cnt - 1] = merge(this[cnt])
                this.removeAt(cnt)
            }
            ++cnt
        }
    }


//
//    with(nonNulls) {
//        for( i in  1 until size){
//            if(this[i - 1] == this[i]){
//                this[i] = merge(this[i])
//                this.removeAt(i - 1)
//            }
//        }
//    }
    return nonNulls
}
