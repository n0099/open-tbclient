package org.reactivestreams;
/* loaded from: classes8.dex */
public interface Publisher<T> {
    void subscribe(Subscriber<? super T> subscriber);
}
