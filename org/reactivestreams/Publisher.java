package org.reactivestreams;
/* loaded from: classes10.dex */
public interface Publisher<T> {
    void subscribe(Subscriber<? super T> subscriber);
}
