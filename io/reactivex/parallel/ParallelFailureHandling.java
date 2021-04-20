package io.reactivex.parallel;

import f.b.w.c;
/* loaded from: classes7.dex */
public enum ParallelFailureHandling implements c<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // f.b.w.c
    public ParallelFailureHandling apply(Long l, Throwable th) {
        return this;
    }
}
