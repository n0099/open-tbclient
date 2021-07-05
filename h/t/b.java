package h.t;

import rx.subjects.ReplaySubject$ReplayProducer;
/* loaded from: classes10.dex */
public interface b<T> {
    void a(ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer);

    void complete();

    void error(Throwable th);

    void next(T t);
}
