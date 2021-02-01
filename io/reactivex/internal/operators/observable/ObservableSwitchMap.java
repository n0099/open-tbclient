package io.reactivex.internal.operators.observable;

import io.reactivex.b.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class ObservableSwitchMap<T, R> extends a<T, R> {
    final int bufferSize;
    final boolean delayErrors;
    final h<? super T, ? extends t<? extends R>> mapper;

    @Override // io.reactivex.q
    public void a(u<? super R> uVar) {
        if (!ObservableScalarXMap.a(this.source, uVar, this.mapper)) {
            this.source.subscribe(new SwitchMapObserver(uVar, this.mapper, this.bufferSize, this.delayErrors));
        }
    }

    /* loaded from: classes5.dex */
    static final class SwitchMapObserver<T, R> extends AtomicInteger implements io.reactivex.disposables.b, u<T> {
        static final SwitchMapInnerObserver<Object, Object> CANCELLED = new SwitchMapInnerObserver<>(null, -1, 1);
        private static final long serialVersionUID = -3491074160481096299L;
        final u<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final h<? super T, ? extends t<? extends R>> mapper;
        io.reactivex.disposables.b s;
        volatile long unique;
        final AtomicReference<SwitchMapInnerObserver<T, R>> active = new AtomicReference<>();
        final AtomicThrowable errors = new AtomicThrowable();

        static {
            CANCELLED.cancel();
        }

        SwitchMapObserver(u<? super R> uVar, h<? super T, ? extends t<? extends R>> hVar, int i, boolean z) {
            this.actual = uVar;
            this.mapper = hVar;
            this.bufferSize = i;
            this.delayErrors = z;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            SwitchMapInnerObserver<T, R> switchMapInnerObserver;
            long j = 1 + this.unique;
            this.unique = j;
            SwitchMapInnerObserver<T, R> switchMapInnerObserver2 = this.active.get();
            if (switchMapInnerObserver2 != null) {
                switchMapInnerObserver2.cancel();
            }
            try {
                t tVar = (t) io.reactivex.internal.functions.a.m(this.mapper.apply(t), "The ObservableSource returned is null");
                SwitchMapInnerObserver<T, R> switchMapInnerObserver3 = new SwitchMapInnerObserver<>(this, j, this.bufferSize);
                do {
                    switchMapInnerObserver = this.active.get();
                    if (switchMapInnerObserver == CANCELLED) {
                        return;
                    }
                } while (!this.active.compareAndSet(switchMapInnerObserver, switchMapInnerObserver3));
                tVar.subscribe(switchMapInnerObserver3);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.N(th);
                this.s.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.done || !this.errors.addThrowable(th)) {
                if (!this.delayErrors) {
                    disposeInner();
                }
                io.reactivex.d.a.onError(th);
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.s.dispose();
                disposeInner();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableSwitchMap$SwitchMapInnerObserver<T, R>> */
        /* JADX WARN: Multi-variable type inference failed */
        void disposeInner() {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver;
            if (this.active.get() != CANCELLED && (switchMapInnerObserver = (SwitchMapInnerObserver) this.active.getAndSet(CANCELLED)) != CANCELLED && switchMapInnerObserver != null) {
                switchMapInnerObserver.cancel();
            }
        }

        void drain() {
            boolean z;
            if (getAndIncrement() == 0) {
                u<? super R> uVar = this.actual;
                int i = 1;
                while (!this.cancelled) {
                    if (this.done) {
                        boolean z2 = this.active.get() == null;
                        if (this.delayErrors) {
                            if (z2) {
                                Throwable th = this.errors.get();
                                if (th != null) {
                                    uVar.onError(th);
                                    return;
                                } else {
                                    uVar.onComplete();
                                    return;
                                }
                            }
                        } else if (this.errors.get() != null) {
                            uVar.onError(this.errors.terminate());
                            return;
                        } else if (z2) {
                            uVar.onComplete();
                            return;
                        }
                    }
                    SwitchMapInnerObserver<T, R> switchMapInnerObserver = this.active.get();
                    if (switchMapInnerObserver != null) {
                        io.reactivex.internal.queue.a<R> aVar = switchMapInnerObserver.queue;
                        if (switchMapInnerObserver.done) {
                            boolean isEmpty = aVar.isEmpty();
                            if (this.delayErrors) {
                                if (isEmpty) {
                                    this.active.compareAndSet(switchMapInnerObserver, null);
                                }
                            } else if (this.errors.get() != null) {
                                uVar.onError(this.errors.terminate());
                                return;
                            } else if (isEmpty) {
                                this.active.compareAndSet(switchMapInnerObserver, null);
                            }
                        }
                        while (!this.cancelled) {
                            if (switchMapInnerObserver != this.active.get()) {
                                z = true;
                            } else if (!this.delayErrors && this.errors.get() != null) {
                                uVar.onError(this.errors.terminate());
                                return;
                            } else {
                                boolean z3 = switchMapInnerObserver.done;
                                Object obj = (R) aVar.poll();
                                boolean z4 = obj == null;
                                if (z3 && z4) {
                                    this.active.compareAndSet(switchMapInnerObserver, null);
                                    z = true;
                                } else if (z4) {
                                    z = false;
                                } else {
                                    uVar.onNext(obj);
                                }
                            }
                            if (z) {
                                continue;
                            }
                        }
                        return;
                    }
                    int addAndGet = addAndGet(-i);
                    if (addAndGet == 0) {
                        return;
                    }
                    i = addAndGet;
                }
            }
        }

        void innerError(SwitchMapInnerObserver<T, R> switchMapInnerObserver, Throwable th) {
            if (switchMapInnerObserver.index == this.unique && this.errors.addThrowable(th)) {
                if (!this.delayErrors) {
                    this.s.dispose();
                }
                switchMapInnerObserver.done = true;
                drain();
                return;
            }
            io.reactivex.d.a.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class SwitchMapInnerObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements u<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        volatile boolean done;
        final long index;
        final SwitchMapObserver<T, R> parent;
        final io.reactivex.internal.queue.a<R> queue;

        SwitchMapInnerObserver(SwitchMapObserver<T, R> switchMapObserver, long j, int i) {
            this.parent = switchMapObserver;
            this.index = j;
            this.queue = new io.reactivex.internal.queue.a<>(i);
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(R r) {
            if (this.index == this.parent.unique) {
                this.queue.offer(r);
                this.parent.drain();
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.parent.innerError(this, th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (this.index == this.parent.unique) {
                this.done = true;
                this.parent.drain();
            }
        }

        public void cancel() {
            DisposableHelper.dispose(this);
        }
    }
}
