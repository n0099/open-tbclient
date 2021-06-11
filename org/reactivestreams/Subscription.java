package org.reactivestreams;
/* loaded from: classes8.dex */
public interface Subscription {
    void cancel();

    void request(long j);
}
