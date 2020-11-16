package io.reactivex.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.u;
/* loaded from: classes5.dex */
public final class b<T> implements io.reactivex.disposables.b, u<T> {
    final u<? super T> actual;
    final boolean delayError;
    volatile boolean done;
    boolean emitting;
    io.reactivex.internal.util.a<Object> queue;
    io.reactivex.disposables.b s;

    public b(u<? super T> uVar) {
        this(uVar, false);
    }

    public b(u<? super T> uVar, boolean z) {
        this.actual = uVar;
        this.delayError = z;
    }

    @Override // io.reactivex.u
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.s.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.s.isDisposed();
    }

    @Override // io.reactivex.u
    public void onNext(T t) {
        if (!this.done) {
            if (t == null) {
                this.s.dispose();
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

    @Override // io.reactivex.u
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
                        aVar.bP(error);
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

    @Override // io.reactivex.u
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

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.u<? super T>, io.reactivex.u<? super U> */
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
        } while (!aVar.b((u<? super T>) this.actual));
    }
}
