package io.reactivex.internal.subscribers;

import f.a.g;
import f.a.t.b;
import f.a.w.a;
import g.d.d;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class LambdaSubscriber<T> extends AtomicReference<d> implements g<T>, d, b {
    public static final long serialVersionUID = -7251123623727029452L;
    public final a onComplete;
    public final f.a.w.g<? super Throwable> onError;
    public final f.a.w.g<? super T> onNext;
    public final f.a.w.g<? super d> onSubscribe;

    public LambdaSubscriber(f.a.w.g<? super T> gVar, f.a.w.g<? super Throwable> gVar2, a aVar, f.a.w.g<? super d> gVar3) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
    }

    @Override // g.d.d
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // f.a.t.b
    public void dispose() {
        cancel();
    }

    public boolean hasCustomOnError() {
        return this.onError != Functions.f68022b;
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // g.d.c
    public void onComplete() {
        d dVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (dVar != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                f.a.u.a.a(th);
                f.a.a0.a.f(th);
            }
        }
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        d dVar = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (dVar != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.onError.accept(th);
                return;
            } catch (Throwable th2) {
                f.a.u.a.a(th2);
                f.a.a0.a.f(new CompositeException(th, th2));
                return;
            }
        }
        f.a.a0.a.f(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t);
        } catch (Throwable th) {
            f.a.u.a.a(th);
            get().cancel();
            onError(th);
        }
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                f.a.u.a.a(th);
                dVar.cancel();
                onError(th);
            }
        }
    }

    @Override // g.d.d
    public void request(long j) {
        get().request(j);
    }
}
