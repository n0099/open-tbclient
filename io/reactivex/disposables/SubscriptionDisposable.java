package io.reactivex.disposables;

import g.d.d;
/* loaded from: classes7.dex */
public final class SubscriptionDisposable extends ReferenceDisposable<d> {
    public static final long serialVersionUID = -707001650852963139L;

    public SubscriptionDisposable(d dVar) {
        super(dVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(d dVar) {
        dVar.cancel();
    }
}
