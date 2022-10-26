package io.reactivex;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
/* loaded from: classes8.dex */
public interface FlowableSubscriber extends Subscriber {
    @Override // org.reactivestreams.Subscriber
    void onSubscribe(Subscription subscription);
}
