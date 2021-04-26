package io.reactivex.internal.subscriptions;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscription;
/* loaded from: classes7.dex */
public final class BooleanSubscription extends AtomicBoolean implements Subscription {
    public static final long serialVersionUID = -8127758972444290902L;

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        lazySet(true);
    }

    public boolean isCancelled() {
        return get();
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "BooleanSubscription(cancelled=" + get() + SmallTailInfo.EMOTION_SUFFIX;
    }
}
