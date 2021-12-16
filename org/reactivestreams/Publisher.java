package org.reactivestreams;
/* loaded from: classes4.dex */
public interface Publisher<T> {
    void subscribe(Subscriber<? super T> subscriber);
}
