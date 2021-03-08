package io.reactivex.parallel;

import io.reactivex.b.c;
/* loaded from: classes6.dex */
public enum ParallelFailureHandling implements c<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.b.c
    public ParallelFailureHandling apply(Long l, Throwable th) {
        return this;
    }
}
