package io.reactivex.internal.subscribers;

import io.reactivex.c.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes25.dex */
public final class LambdaSubscriber<T> extends AtomicReference<d> implements io.reactivex.disposables.b, j<T>, d {
    private static final long serialVersionUID = -7251123623727029452L;
    final io.reactivex.c.a onComplete;
    final g<? super Throwable> onError;
    final g<? super T> onNext;
    final g<? super d> onSubscribe;

    public LambdaSubscriber(g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.c.a aVar, g<? super d> gVar3) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                dVar.cancel();
                onError(th);
            }
        }
    }

    @Override // org.a.c
    public void onNext(T t) {
        if (!isDisposed()) {
            try {
                this.onNext.accept(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                get().cancel();
                onError(th);
            }
        }
    }

    @Override // org.a.c
    public void onError(Throwable th) {
        if (get() != SubscriptionHelper.CANCELLED) {
            lazySet(SubscriptionHelper.CANCELLED);
            try {
                this.onError.accept(th);
                return;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.J(th2);
                io.reactivex.e.a.onError(new CompositeException(th, th2));
                return;
            }
        }
        io.reactivex.e.a.onError(th);
    }

    @Override // org.a.c
    public void onComplete() {
        if (get() != SubscriptionHelper.CANCELLED) {
            lazySet(SubscriptionHelper.CANCELLED);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                io.reactivex.e.a.onError(th);
            }
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        cancel();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // org.a.d
    public void request(long j) {
        get().request(j);
    }

    @Override // org.a.d
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != Functions.own;
    }
}
