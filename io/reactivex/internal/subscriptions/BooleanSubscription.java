package io.reactivex.internal.subscriptions;

import com.baidu.tbadk.core.data.SmallTailInfo;
import g.d.d;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class BooleanSubscription extends AtomicBoolean implements d {
    public static final long serialVersionUID = -8127758972444290902L;

    @Override // g.d.d
    public void cancel() {
        lazySet(true);
    }

    public boolean isCancelled() {
        return get();
    }

    @Override // g.d.d
    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "BooleanSubscription(cancelled=" + get() + SmallTailInfo.EMOTION_SUFFIX;
    }
}
