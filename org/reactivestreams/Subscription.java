package org.reactivestreams;
/* loaded from: classes10.dex */
public interface Subscription {
    void cancel();

    void request(long j);
}
