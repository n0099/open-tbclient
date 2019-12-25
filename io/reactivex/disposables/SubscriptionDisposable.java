package io.reactivex.disposables;

import org.a.d;
/* loaded from: classes4.dex */
final class SubscriptionDisposable extends ReferenceDisposable<d> {
    private static final long serialVersionUID = -707001650852963139L;

    SubscriptionDisposable(d dVar) {
        super(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(d dVar) {
        dVar.cancel();
    }
}
