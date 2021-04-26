package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscription;
/* loaded from: classes7.dex */
public final class ArrayCompositeSubscription extends AtomicReferenceArray<Subscription> implements Disposable {
    public static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int i2) {
        super(i2);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Subscription andSet;
        if (get(0) != SubscriptionHelper.CANCELLED) {
            int length = length();
            for (int i2 = 0; i2 < length; i2++) {
                Subscription subscription = get(i2);
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (subscription != subscriptionHelper && (andSet = getAndSet(i2, subscriptionHelper)) != SubscriptionHelper.CANCELLED && andSet != null) {
                    andSet.cancel();
                }
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return get(0) == SubscriptionHelper.CANCELLED;
    }

    public Subscription replaceResource(int i2, Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = get(i2);
            if (subscription2 == SubscriptionHelper.CANCELLED) {
                if (subscription != null) {
                    subscription.cancel();
                    return null;
                }
                return null;
            }
        } while (!compareAndSet(i2, subscription2, subscription));
        return subscription2;
    }

    public boolean setResource(int i2, Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = get(i2);
            if (subscription2 == SubscriptionHelper.CANCELLED) {
                if (subscription != null) {
                    subscription.cancel();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(i2, subscription2, subscription));
        if (subscription2 != null) {
            subscription2.cancel();
            return true;
        }
        return true;
    }
}
