package io.reactivex.parallel;

import io.reactivex.annotations.Experimental;
import io.reactivex.functions.BiFunction;
@Experimental
/* loaded from: classes7.dex */
public enum ParallelFailureHandling implements BiFunction<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.functions.BiFunction
    public ParallelFailureHandling apply(Long l, Throwable th) {
        return this;
    }
}
