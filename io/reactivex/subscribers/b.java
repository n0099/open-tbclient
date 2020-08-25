package io.reactivex.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.j;
import org.b.c;
import org.b.d;
/* loaded from: classes7.dex */
public final class b<T> implements j<T>, d {
    final c<? super T> actual;
    final boolean delayError;
    volatile boolean done;
    boolean emitting;
    io.reactivex.internal.util.a<Object> queue;
    d subscription;

    public b(c<? super T> cVar) {
        this(cVar, false);
    }

    public b(c<? super T> cVar, boolean z) {
        this.actual = cVar;
        this.delayError = z;
    }

    @Override // io.reactivex.j, org.b.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.subscription, dVar)) {
            this.subscription = dVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // org.b.c
    public void onNext(T t) {
        if (!this.done) {
            if (t == null) {
                this.subscription.cancel();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.done) {
                    if (this.emitting) {
                        io.reactivex.internal.util.a<Object> aVar = this.queue;
                        if (aVar == null) {
                            aVar = new io.reactivex.internal.util.a<>(4);
                            this.queue = aVar;
                        }
                        aVar.add(NotificationLite.next(t));
                        return;
                    }
                    this.emitting = true;
                    this.actual.onNext(t);
                    emitLoop();
                }
            }
        }
    }

    @Override // org.b.c
    public void onError(Throwable th) {
        boolean z = true;
        if (this.done) {
            io.reactivex.e.a.onError(th);
            return;
        }
        synchronized (this) {
            if (!this.done) {
                if (this.emitting) {
                    this.done = true;
                    io.reactivex.internal.util.a<Object> aVar = this.queue;
                    if (aVar == null) {
                        aVar = new io.reactivex.internal.util.a<>(4);
                        this.queue = aVar;
                    }
                    Object error = NotificationLite.error(th);
                    if (this.delayError) {
                        aVar.add(error);
                    } else {
                        aVar.bF(error);
                    }
                    return;
                }
                this.done = true;
                this.emitting = true;
                z = false;
            }
            if (z) {
                io.reactivex.e.a.onError(th);
            } else {
                this.actual.onError(th);
            }
        }
    }

    @Override // org.b.c
    public void onComplete() {
        if (!this.done) {
            synchronized (this) {
                if (!this.done) {
                    if (this.emitting) {
                        io.reactivex.internal.util.a<Object> aVar = this.queue;
                        if (aVar == null) {
                            aVar = new io.reactivex.internal.util.a<>(4);
                            this.queue = aVar;
                        }
                        aVar.add(NotificationLite.complete());
                        return;
                    }
                    this.done = true;
                    this.emitting = true;
                    this.actual.onComplete();
                }
            }
        }
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: org.b.c<? super T>, org.b.c<? super U> */
    void emitLoop() {
        io.reactivex.internal.util.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.queue;
                if (aVar == null) {
                    this.emitting = false;
                    return;
                }
                this.queue = null;
            }
        } while (!aVar.b((c<? super T>) this.actual));
    }

    @Override // org.b.d
    public void request(long j) {
        this.subscription.request(j);
    }

    @Override // org.b.d
    public void cancel() {
        this.subscription.cancel();
    }
}
