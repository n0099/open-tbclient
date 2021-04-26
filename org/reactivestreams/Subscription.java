package org.reactivestreams;
/* loaded from: classes7.dex */
public interface Subscription {
    void cancel();

    void request(long j);
}
