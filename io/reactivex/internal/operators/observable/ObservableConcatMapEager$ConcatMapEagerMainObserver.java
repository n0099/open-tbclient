package io.reactivex.internal.operators.observable;

import f.a.n;
import f.a.o;
import f.a.t.b;
import f.a.w.h;
import f.a.x.b.a;
import f.a.x.c.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableConcatMapEager$ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements o<T>, b, f.a.x.d.b<R> {
    public static final long serialVersionUID = 8080567949447303262L;
    public int activeCount;
    public final o<? super R> actual;
    public volatile boolean cancelled;
    public InnerQueuedObserver<R> current;

    /* renamed from: d  reason: collision with root package name */
    public b f68060d;
    public volatile boolean done;
    public final ErrorMode errorMode;
    public final h<? super T, ? extends n<? extends R>> mapper;
    public final int maxConcurrency;
    public final int prefetch;
    public f<T> queue;
    public int sourceMode;
    public final AtomicThrowable error = new AtomicThrowable();
    public final ArrayDeque<InnerQueuedObserver<R>> observers = new ArrayDeque<>();

    public ObservableConcatMapEager$ConcatMapEagerMainObserver(o<? super R> oVar, h<? super T, ? extends n<? extends R>> hVar, int i, int i2, ErrorMode errorMode) {
        this.actual = oVar;
        this.mapper = hVar;
        this.maxConcurrency = i;
        this.prefetch = i2;
        this.errorMode = errorMode;
    }

    @Override // f.a.t.b
    public void dispose() {
        this.cancelled = true;
        if (getAndIncrement() == 0) {
            this.queue.clear();
            disposeAll();
        }
    }

    public void disposeAll() {
        InnerQueuedObserver<R> innerQueuedObserver = this.current;
        if (innerQueuedObserver != null) {
            innerQueuedObserver.dispose();
        }
        while (true) {
            InnerQueuedObserver<R> poll = this.observers.poll();
            if (poll == null) {
                return;
            }
            poll.dispose();
        }
    }

    @Override // f.a.x.d.b
    public void drain() {
        R poll;
        boolean z;
        if (getAndIncrement() != 0) {
            return;
        }
        f<T> fVar = this.queue;
        ArrayDeque<InnerQueuedObserver<R>> arrayDeque = this.observers;
        o<? super R> oVar = this.actual;
        ErrorMode errorMode = this.errorMode;
        int i = 1;
        while (true) {
            int i2 = this.activeCount;
            while (i2 != this.maxConcurrency) {
                if (this.cancelled) {
                    fVar.clear();
                    disposeAll();
                    return;
                } else if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                    fVar.clear();
                    disposeAll();
                    oVar.onError(this.error.terminate());
                    return;
                } else {
                    try {
                        T poll2 = fVar.poll();
                        if (poll2 == null) {
                            break;
                        }
                        n<? extends R> apply = this.mapper.apply(poll2);
                        a.b(apply, "The mapper returned a null ObservableSource");
                        n<? extends R> nVar = apply;
                        InnerQueuedObserver<R> innerQueuedObserver = new InnerQueuedObserver<>(this, this.prefetch);
                        arrayDeque.offer(innerQueuedObserver);
                        nVar.subscribe(innerQueuedObserver);
                        i2++;
                    } catch (Throwable th) {
                        f.a.u.a.a(th);
                        this.f68060d.dispose();
                        fVar.clear();
                        disposeAll();
                        this.error.addThrowable(th);
                        oVar.onError(this.error.terminate());
                        return;
                    }
                }
            }
            this.activeCount = i2;
            if (this.cancelled) {
                fVar.clear();
                disposeAll();
                return;
            } else if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                fVar.clear();
                disposeAll();
                oVar.onError(this.error.terminate());
                return;
            } else {
                InnerQueuedObserver<R> innerQueuedObserver2 = this.current;
                if (innerQueuedObserver2 == null) {
                    if (errorMode == ErrorMode.BOUNDARY && this.error.get() != null) {
                        fVar.clear();
                        disposeAll();
                        oVar.onError(this.error.terminate());
                        return;
                    }
                    boolean z2 = this.done;
                    InnerQueuedObserver<R> poll3 = arrayDeque.poll();
                    boolean z3 = poll3 == null;
                    if (z2 && z3) {
                        if (this.error.get() != null) {
                            fVar.clear();
                            disposeAll();
                            oVar.onError(this.error.terminate());
                            return;
                        }
                        oVar.onComplete();
                        return;
                    }
                    if (!z3) {
                        this.current = poll3;
                    }
                    innerQueuedObserver2 = poll3;
                }
                if (innerQueuedObserver2 != null) {
                    f<R> queue = innerQueuedObserver2.queue();
                    while (!this.cancelled) {
                        boolean isDone = innerQueuedObserver2.isDone();
                        if (errorMode == ErrorMode.IMMEDIATE && this.error.get() != null) {
                            fVar.clear();
                            disposeAll();
                            oVar.onError(this.error.terminate());
                            return;
                        }
                        try {
                            poll = queue.poll();
                            z = poll == null;
                        } catch (Throwable th2) {
                            f.a.u.a.a(th2);
                            this.error.addThrowable(th2);
                            this.current = null;
                            this.activeCount--;
                        }
                        if (isDone && z) {
                            this.current = null;
                            this.activeCount--;
                        } else if (!z) {
                            oVar.onNext(poll);
                        }
                    }
                    fVar.clear();
                    disposeAll();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    @Override // f.a.x.d.b
    public void innerComplete(InnerQueuedObserver<R> innerQueuedObserver) {
        innerQueuedObserver.setDone();
        drain();
    }

    @Override // f.a.x.d.b
    public void innerError(InnerQueuedObserver<R> innerQueuedObserver, Throwable th) {
        if (this.error.addThrowable(th)) {
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.f68060d.dispose();
            }
            innerQueuedObserver.setDone();
            drain();
            return;
        }
        f.a.a0.a.f(th);
    }

    @Override // f.a.x.d.b
    public void innerNext(InnerQueuedObserver<R> innerQueuedObserver, R r) {
        innerQueuedObserver.queue().offer(r);
        drain();
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // f.a.o
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        if (this.error.addThrowable(th)) {
            this.done = true;
            drain();
            return;
        }
        f.a.a0.a.f(th);
    }

    @Override // f.a.o
    public void onNext(T t) {
        if (this.sourceMode == 0) {
            this.queue.offer(t);
        }
        drain();
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f68060d, bVar)) {
            this.f68060d = bVar;
            if (bVar instanceof f.a.x.c.b) {
                f.a.x.c.b bVar2 = (f.a.x.c.b) bVar;
                int requestFusion = bVar2.requestFusion(3);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = bVar2;
                    this.done = true;
                    this.actual.onSubscribe(this);
                    drain();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = bVar2;
                    this.actual.onSubscribe(this);
                    return;
                }
            }
            this.queue = new f.a.x.f.a(this.prefetch);
            this.actual.onSubscribe(this);
        }
    }
}
