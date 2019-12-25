package io.reactivex.internal.subscribers;

import io.reactivex.b.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes4.dex */
public final class BoundedSubscriber<T> extends AtomicReference<d> implements io.reactivex.disposables.b, j<T>, d {
    private static final long serialVersionUID = -7251123623727029452L;
    final int bufferSize;
    int consumed;
    final int limit;
    final io.reactivex.b.a onComplete;
    final g<? super Throwable> onError;
    final g<? super T> onNext;
    final g<? super d> onSubscribe;

    public BoundedSubscriber(g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.b.a aVar, g<? super d> gVar3, int i) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
        this.bufferSize = i;
        this.limit = i - (i >> 2);
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.I(th);
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
                int i = this.consumed + 1;
                if (i == this.limit) {
                    this.consumed = 0;
                    get().request(this.limit);
                } else {
                    this.consumed = i;
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.I(th);
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
                io.reactivex.exceptions.a.I(th2);
                io.reactivex.d.a.onError(new CompositeException(th, th2));
                return;
            }
        }
        io.reactivex.d.a.onError(th);
    }

    @Override // org.a.c
    public void onComplete() {
        if (get() != SubscriptionHelper.CANCELLED) {
            lazySet(SubscriptionHelper.CANCELLED);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.I(th);
                io.reactivex.d.a.onError(th);
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
        return this.onError != Functions.mTm;
    }
}
