package com.repackage;

import rx.subjects.ReplaySubject$ReplayProducer;
/* loaded from: classes6.dex */
public interface m2a<T> {
    void a(ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer);

    void complete();

    void error(Throwable th);

    void next(T t);
}
