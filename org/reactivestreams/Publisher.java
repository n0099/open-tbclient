package org.reactivestreams;
/* loaded from: classes7.dex */
public interface Publisher<T> {
    void subscribe(Subscriber<? super T> subscriber);
}
