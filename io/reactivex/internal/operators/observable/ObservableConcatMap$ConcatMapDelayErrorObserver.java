package io.reactivex.internal.operators.observable;

import f.b.a0.a;
import f.b.n;
import f.b.o;
import f.b.t.b;
import f.b.w.h;
import f.b.x.c.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableConcatMap$ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements o<T>, b {
    public static final long serialVersionUID = -6951100001833242599L;
    public volatile boolean active;
    public final o<? super R> actual;
    public final int bufferSize;
    public volatile boolean cancelled;

    /* renamed from: d  reason: collision with root package name */
    public b f69212d;
    public volatile boolean done;
    public final AtomicThrowable error = new AtomicThrowable();
    public final h<? super T, ? extends n<? extends R>> mapper;
    public final DelayErrorInnerObserver<R> observer;
    public f<T> queue;
    public int sourceMode;
    public final boolean tillTheEnd;

    /* loaded from: classes7.dex */
    public static final class DelayErrorInnerObserver<R> extends AtomicReference<b> implements o<R> {
        public static final long serialVersionUID = 2620149119579502636L;
        public final o<? super R> actual;
        public final ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> parent;

        public DelayErrorInnerObserver(o<? super R> oVar, ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> observableConcatMap$ConcatMapDelayErrorObserver) {
            this.actual = oVar;
            this.parent = observableConcatMap$ConcatMapDelayErrorObserver;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // f.b.o
        public void onComplete() {
            ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> observableConcatMap$ConcatMapDelayErrorObserver = this.parent;
            observableConcatMap$ConcatMapDelayErrorObserver.active = false;
            observableConcatMap$ConcatMapDelayErrorObserver.drain();
        }

        @Override // f.b.o
        public void onError(Throwable th) {
            ObservableConcatMap$ConcatMapDelayErrorObserver<?, R> observableConcatMap$ConcatMapDelayErrorObserver = this.parent;
            if (observableConcatMap$ConcatMapDelayErrorObserver.error.addThrowable(th)) {
                if (!observableConcatMap$ConcatMapDelayErrorObserver.tillTheEnd) {
                    observableConcatMap$ConcatMapDelayErrorObserver.f69212d.dispose();
                }
                observableConcatMap$ConcatMapDelayErrorObserver.active = false;
                observableConcatMap$ConcatMapDelayErrorObserver.drain();
                return;
            }
            a.f(th);
        }

        @Override // f.b.o
        public void onNext(R r) {
            this.actual.onNext(r);
        }

        @Override // f.b.o
        public void onSubscribe(b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }

    public ObservableConcatMap$ConcatMapDelayErrorObserver(o<? super R> oVar, h<? super T, ? extends n<? extends R>> hVar, int i, boolean z) {
        this.actual = oVar;
        this.mapper = hVar;
        this.bufferSize = i;
        this.tillTheEnd = z;
        this.observer = new DelayErrorInnerObserver<>(oVar, this);
    }

    @Override // f.b.t.b
    public void dispose() {
        this.cancelled = true;
        this.f69212d.dispose();
        this.observer.dispose();
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        o<? super R> oVar = this.actual;
        f<T> fVar = this.queue;
        AtomicThrowable atomicThrowable = this.error;
        while (true) {
            if (!this.active) {
                if (this.cancelled) {
                    fVar.clear();
                    return;
                } else if (!this.tillTheEnd && atomicThrowable.get() != null) {
                    fVar.clear();
                    this.cancelled = true;
                    oVar.onError(atomicThrowable.terminate());
                    return;
                } else {
                    boolean z = this.done;
                    try {
                        T poll = fVar.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.cancelled = true;
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate != null) {
                                oVar.onError(terminate);
                                return;
                            } else {
                                oVar.onComplete();
                                return;
                            }
                        } else if (!z2) {
                            try {
                                n<? extends R> apply = this.mapper.apply(poll);
                                f.b.x.b.a.b(apply, "The mapper returned a null ObservableSource");
                                n<? extends R> nVar = apply;
                                if (nVar instanceof Callable) {
                                    try {
                                        Object obj = (Object) ((Callable) nVar).call();
                                        if (obj != 0 && !this.cancelled) {
                                            oVar.onNext(obj);
                                        }
                                    } catch (Throwable th) {
                                        f.b.u.a.a(th);
                                        atomicThrowable.addThrowable(th);
                                    }
                                } else {
                                    this.active = true;
                                    nVar.subscribe(this.observer);
                                }
                            } catch (Throwable th2) {
                                f.b.u.a.a(th2);
                                this.cancelled = true;
                                this.f69212d.dispose();
                                fVar.clear();
                                atomicThrowable.addThrowable(th2);
                                oVar.onError(atomicThrowable.terminate());
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        f.b.u.a.a(th3);
                        this.cancelled = true;
                        this.f69212d.dispose();
                        atomicThrowable.addThrowable(th3);
                        oVar.onError(atomicThrowable.terminate());
                        return;
                    }
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // f.b.o
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        if (this.error.addThrowable(th)) {
            this.done = true;
            drain();
            return;
        }
        a.f(th);
    }

    @Override // f.b.o
    public void onNext(T t) {
        if (this.sourceMode == 0) {
            this.queue.offer(t);
        }
        drain();
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f69212d, bVar)) {
            this.f69212d = bVar;
            if (bVar instanceof f.b.x.c.b) {
                f.b.x.c.b bVar2 = (f.b.x.c.b) bVar;
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
            this.queue = new f.b.x.f.a(this.bufferSize);
            this.actual.onSubscribe(this);
        }
    }
}
