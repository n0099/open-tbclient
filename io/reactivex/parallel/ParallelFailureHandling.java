package io.reactivex.parallel;

import io.reactivex.c.c;
/* loaded from: classes7.dex */
public enum ParallelFailureHandling implements c<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.c.c
    public ParallelFailureHandling apply(Long l, Throwable th) {
        return this;
    }
}
