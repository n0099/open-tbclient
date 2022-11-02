package org.reactivestreams;
/* loaded from: classes9.dex */
public interface Subscription {
    void cancel();

    void request(long j);
}
