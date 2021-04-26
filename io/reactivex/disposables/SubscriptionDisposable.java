package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import org.reactivestreams.Subscription;
/* loaded from: classes7.dex */
public final class SubscriptionDisposable extends ReferenceDisposable<Subscription> {
    public static final long serialVersionUID = -707001650852963139L;

    public SubscriptionDisposable(Subscription subscription) {
        super(subscription);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(@NonNull Subscription subscription) {
        subscription.cancel();
    }
}
