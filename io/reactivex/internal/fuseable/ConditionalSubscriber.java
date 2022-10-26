package io.reactivex.internal.fuseable;

import io.reactivex.FlowableSubscriber;
/* loaded from: classes8.dex */
public interface ConditionalSubscriber extends FlowableSubscriber {
    boolean tryOnNext(Object obj);
}
