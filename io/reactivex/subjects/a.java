package io.reactivex.subjects;

import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.a;
import io.reactivex.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class a<T> extends b<T> implements a.InterfaceC1304a<Object> {
    volatile boolean done;
    boolean emitting;
    final b<T> qsI;
    io.reactivex.internal.util.a<Object> queue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b<T> bVar) {
        this.qsI = bVar;
    }

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        this.qsI.subscribe(uVar);
    }

    @Override // io.reactivex.u
    public void onSubscribe(io.reactivex.disposables.b bVar) {
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
                        aVar.add(NotificationLite.disposable(bVar));
                        return;
                    }
                    this.emitting = true;
                    z = false;
                }
            }
        }
        if (z) {
            bVar.dispose();
            return;
        }
        this.qsI.onSubscribe(bVar);
        emitLoop();
    }

    @Override // io.reactivex.u
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
                    this.qsI.onNext(t);
                    emitLoop();
                }
            }
        }
    }

    @Override // io.reactivex.u
    public void onError(Throwable th) {
        boolean z = true;
        if (this.done) {
            io.reactivex.d.a.onError(th);
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
                    aVar.bN(NotificationLite.error(th));
                    return;
                }
                z = false;
                this.emitting = true;
            }
            if (z) {
                io.reactivex.d.a.onError(th);
            } else {
                this.qsI.onError(th);
            }
        }
    }

    @Override // io.reactivex.u
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
                    this.qsI.onComplete();
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
            aVar.a(this);
        }
    }

    @Override // io.reactivex.internal.util.a.InterfaceC1304a, io.reactivex.b.j
    public boolean test(Object obj) {
        return NotificationLite.acceptFull(obj, this.qsI);
    }
}
