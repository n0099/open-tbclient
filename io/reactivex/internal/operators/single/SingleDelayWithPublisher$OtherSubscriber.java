package io.reactivex.internal.operators.single;

import f.a.a0.a;
import f.a.g;
import f.a.r;
import f.a.s;
import f.a.t.b;
import f.a.x.d.c;
import g.d.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleDelayWithPublisher$OtherSubscriber<T, U> extends AtomicReference<b> implements g<U>, b {
    public static final long serialVersionUID = -8565274649390031272L;
    public final r<? super T> actual;
    public boolean done;
    public d s;
    public final s<T> source;

    public SingleDelayWithPublisher$OtherSubscriber(r<? super T> rVar, s<T> sVar) {
        this.actual = rVar;
        this.source = sVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        this.s.cancel();
        DisposableHelper.dispose(this);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.source.a(new c(this, this.actual));
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.done) {
            a.f(th);
            return;
        }
        this.done = true;
        this.actual.onError(th);
    }

    @Override // g.d.c
    public void onNext(U u) {
        this.s.cancel();
        onComplete();
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }
}
