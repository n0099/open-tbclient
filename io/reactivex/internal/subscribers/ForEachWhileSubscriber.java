package io.reactivex.internal.subscribers;

import f.b.g;
import f.b.t.b;
import f.b.w.a;
import f.b.w.i;
import g.d.d;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ForEachWhileSubscriber<T> extends AtomicReference<d> implements g<T>, b {
    public static final long serialVersionUID = -4403180040475402120L;
    public boolean done;
    public final a onComplete;
    public final f.b.w.g<? super Throwable> onError;
    public final i<? super T> onNext;

    public ForEachWhileSubscriber(i<? super T> iVar, f.b.w.g<? super Throwable> gVar, a aVar) {
        this.onNext = iVar;
        this.onError = gVar;
        this.onComplete = aVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return SubscriptionHelper.isCancelled(get());
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            f.b.u.a.a(th);
            f.b.a0.a.f(th);
        }
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.done) {
            f.b.a0.a.f(th);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            f.b.u.a.a(th2);
            f.b.a0.a.f(new CompositeException(th, th2));
        }
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
            if (this.onNext.test(t)) {
                return;
            }
            dispose();
            onComplete();
        } catch (Throwable th) {
            f.b.u.a.a(th);
            dispose();
            onError(th);
        }
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            dVar.request(Long.MAX_VALUE);
        }
    }
}
