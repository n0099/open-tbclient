package io.reactivex.processors;

import io.reactivex.internal.util.NotificationLite;
import org.a.c;
import org.a.d;
/* loaded from: classes5.dex */
final class b<T> extends a<T> {
    volatile boolean done;
    boolean emitting;
    final a<T> nAm;
    io.reactivex.internal.util.a<Object> queue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a<T> aVar) {
        this.nAm = aVar;
    }

    @Override // io.reactivex.g
    protected void a(c<? super T> cVar) {
        this.nAm.subscribe(cVar);
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d dVar) {
        boolean z = true;
        if (!this.done) {
            synchronized (this) {
                if (!this.done) {
                    if (this.emitting) {
                        io.reactivex.internal.util.a<Object> aVar = this.queue;
                        if (aVar == null) {
                            aVar = new io.reactivex.internal.util.a<>(4);
                            this.queue = aVar;
                        }
                        aVar.add(NotificationLite.subscription(dVar));
                        return;
                    }
                    this.emitting = true;
                    z = false;
                }
            }
        }
        if (z) {
            dVar.cancel();
            return;
        }
        this.nAm.onSubscribe(dVar);
        emitLoop();
    }

    @Override // org.a.c
    public void onNext(T t) {
        if (!this.done) {
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
                    this.nAm.onNext(t);
                    emitLoop();
                }
            }
        }
    }

    @Override // org.a.c
    public void onError(Throwable th) {
        boolean z = true;
        if (this.done) {
            io.reactivex.e.a.onError(th);
            return;
        }
        synchronized (this) {
            if (!this.done) {
                this.done = true;
                if (this.emitting) {
                    io.reactivex.internal.util.a<Object> aVar = this.queue;
                    if (aVar == null) {
                        aVar = new io.reactivex.internal.util.a<>(4);
                        this.queue = aVar;
                    }
                    aVar.bL(NotificationLite.error(th));
                    return;
                }
                z = false;
                this.emitting = true;
            }
            if (z) {
                io.reactivex.e.a.onError(th);
            } else {
                this.nAm.onError(th);
            }
        }
    }

    @Override // org.a.c
    public void onComplete() {
        if (!this.done) {
            synchronized (this) {
                if (!this.done) {
                    this.done = true;
                    if (this.emitting) {
                        io.reactivex.internal.util.a<Object> aVar = this.queue;
                        if (aVar == null) {
                            aVar = new io.reactivex.internal.util.a<>(4);
                            this.queue = aVar;
                        }
                        aVar.add(NotificationLite.complete());
                        return;
                    }
                    this.emitting = true;
                    this.nAm.onComplete();
                }
            }
        }
    }

    void emitLoop() {
        io.reactivex.internal.util.a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.queue;
                if (aVar == null) {
                    this.emitting = false;
                    return;
                }
                this.queue = null;
            }
            aVar.b(this.nAm);
        }
    }
}
