package io.reactivex.internal.util;

import org.reactivestreams.Subscriber;
/* loaded from: classes8.dex */
public interface QueueDrain {
    boolean accept(Subscriber subscriber, Object obj);

    boolean cancelled();

    boolean done();

    boolean enter();

    Throwable error();

    int leave(int i);

    long produced(long j);

    long requested();
}
