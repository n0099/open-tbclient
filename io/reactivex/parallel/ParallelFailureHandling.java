package io.reactivex.parallel;

import f.a.w.c;
/* loaded from: classes7.dex */
public enum ParallelFailureHandling implements c<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // f.a.w.c
    public ParallelFailureHandling apply(Long l, Throwable th) {
        return this;
    }
}
