package com.repackage;

import rx.subjects.ReplaySubject$ReplayProducer;
/* loaded from: classes7.dex */
public interface s3a<T> {
    void a(ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer);

    void complete();

    void error(Throwable th);

    void next(T t);
}
