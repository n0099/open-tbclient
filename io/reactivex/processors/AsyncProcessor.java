package io.reactivex.processors;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;
/* loaded from: classes9.dex */
public final class AsyncProcessor<T> extends a<T> {
    static final AsyncSubscription[] pJk = new AsyncSubscription[0];
    static final AsyncSubscription[] pJl = new AsyncSubscription[0];
    Throwable error;
    final AtomicReference<AsyncSubscription<T>[]> subscribers;
    T value;

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d dVar) {
        if (this.subscribers.get() == pJl) {
            dVar.cancel();
        } else {
            dVar.request(Long.MAX_VALUE);
        }
    }

    @Override // org.a.c
    public void onNext(T t) {
        io.reactivex.internal.functions.a.m(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.subscribers.get() != pJl) {
            this.value = t;
        }
    }

    @Override // org.a.c
    public void onError(Throwable th) {
        io.reactivex.internal.functions.a.m(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.subscribers.get() == pJl) {
            io.reactivex.d.a.onError(th);
            return;
        }
        this.value = null;
        this.error = th;
        for (AsyncSubscription<T> asyncSubscription : this.subscribers.getAndSet(pJl)) {
            asyncSubscription.onError(th);
        }
    }

    @Override // org.a.c
    public void onComplete() {
        int i = 0;
        if (this.subscribers.get() != pJl) {
            T t = this.value;
            AsyncSubscription<T>[] andSet = this.subscribers.getAndSet(pJl);
            if (t == null) {
                int length = andSet.length;
                while (i < length) {
                    andSet[i].onComplete();
                    i++;
                }
                return;
            }
            int length2 = andSet.length;
            while (i < length2) {
                andSet[i].complete(t);
                i++;
            }
        }
    }

    @Override // io.reactivex.g
    protected void a(c<? super T> cVar) {
        AsyncSubscription<T> asyncSubscription = new AsyncSubscription<>(cVar, this);
        cVar.onSubscribe(asyncSubscription);
        if (a(asyncSubscription)) {
            if (asyncSubscription.isCancelled()) {
                b(asyncSubscription);
                return;
            }
            return;
        }
        Throwable th = this.error;
        if (th != null) {
            cVar.onError(th);
            return;
        }
        T t = this.value;
        if (t != null) {
            asyncSubscription.complete(t);
        } else {
            asyncSubscription.onComplete();
        }
    }

    boolean a(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription<T>[] asyncSubscriptionArr;
        AsyncSubscription<T>[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = this.subscribers.get();
            if (asyncSubscriptionArr == pJl) {
                return false;
            }
            int length = asyncSubscriptionArr.length;
            asyncSubscriptionArr2 = new AsyncSubscription[length + 1];
            System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr2, 0, length);
            asyncSubscriptionArr2[length] = asyncSubscription;
        } while (!this.subscribers.compareAndSet(asyncSubscriptionArr, asyncSubscriptionArr2));
        return true;
    }

    void b(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription<T>[] asyncSubscriptionArr;
        AsyncSubscription<T>[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = this.subscribers.get();
            int length = asyncSubscriptionArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (asyncSubscriptionArr[i2] == asyncSubscription) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        asyncSubscriptionArr2 = pJk;
                    } else {
                        asyncSubscriptionArr2 = new AsyncSubscription[length - 1];
                        System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr2, 0, i);
                        System.arraycopy(asyncSubscriptionArr, i + 1, asyncSubscriptionArr2, i, (length - i) - 1);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.subscribers.compareAndSet(asyncSubscriptionArr, asyncSubscriptionArr2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncProcessor<T> parent;

        AsyncSubscription(c<? super T> cVar, AsyncProcessor<T> asyncProcessor) {
            super(cVar);
            this.parent = asyncProcessor;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            if (super.tryCancel()) {
                this.parent.b(this);
            }
        }

        void onComplete() {
            if (!isCancelled()) {
                this.actual.onComplete();
            }
        }

        void onError(Throwable th) {
            if (isCancelled()) {
                io.reactivex.d.a.onError(th);
            } else {
                this.actual.onError(th);
            }
        }
    }
}
