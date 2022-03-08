package io.reactivex.internal.util;

import org.reactivestreams.Subscriber;
/* loaded from: classes8.dex */
public interface QueueDrain<T, U> {
    boolean accept(Subscriber<? super U> subscriber, T t);

    boolean cancelled();

    boolean done();

    boolean enter();

    Throwable error();

    int leave(int i2);

    long produced(long j2);

    long requested();
}
