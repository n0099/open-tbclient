package io.reactivex.internal.operators.observable;

import io.reactivex.internal.a.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.schedulers.k;
import io.reactivex.t;
import io.reactivex.u;
import io.reactivex.v;
/* loaded from: classes7.dex */
public final class ObservableObserveOn<T> extends a<T, T> {
    final int bufferSize;
    final boolean delayError;
    final v scheduler;

    public ObservableObserveOn(t<T> tVar, v vVar, boolean z, int i) {
        super(tVar);
        this.scheduler = vVar;
        this.delayError = z;
        this.bufferSize = i;
    }

    @Override // io.reactivex.q
    protected void a(u<? super T> uVar) {
        if (this.scheduler instanceof k) {
            this.source.subscribe(uVar);
            return;
        }
        this.source.subscribe(new ObserveOnObserver(uVar, this.scheduler.dJI(), this.delayError, this.bufferSize));
    }

    /* loaded from: classes7.dex */
    static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements u<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final u<? super T> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        boolean outputFused;
        g<T> queue;
        io.reactivex.disposables.b s;
        int sourceMode;
        final v.c worker;

        ObserveOnObserver(u<? super T> uVar, v.c cVar, boolean z, int i) {
            this.actual = uVar;
            this.worker = cVar;
            this.delayError = z;
            this.bufferSize = i;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                if (bVar instanceof io.reactivex.internal.a.b) {
                    io.reactivex.internal.a.b bVar2 = (io.reactivex.internal.a.b) bVar;
                    int requestFusion = bVar2.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = bVar2;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        schedule();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = bVar2;
                        this.actual.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 2) {
                    this.queue.offer(t);
                }
                schedule();
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                schedule();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.s.dispose();
                this.worker.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.D(this);
            }
        }

        void drainNormal() {
            g<T> gVar = this.queue;
            u<? super T> uVar = this.actual;
            int i = 1;
            while (!checkTerminated(this.done, gVar.isEmpty(), uVar)) {
                while (true) {
                    boolean z = this.done;
                    try {
                        Object obj = (T) gVar.poll();
                        boolean z2 = obj == null;
                        if (!checkTerminated(z, z2, uVar)) {
                            if (!z2) {
                                uVar.onNext(obj);
                            } else {
                                i = addAndGet(-i);
                                if (i == 0) {
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.H(th);
                        this.s.dispose();
                        gVar.clear();
                        uVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
            }
        }

        void drainFused() {
            int i = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                Throwable th = this.error;
                if (!this.delayError && z && th != null) {
                    this.actual.onError(this.error);
                    this.worker.dispose();
                    return;
                }
                this.actual.onNext(null);
                if (z) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.actual.onError(th2);
                    } else {
                        this.actual.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, u<? super T> uVar) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (z) {
                Throwable th = this.error;
                if (this.delayError) {
                    if (z2) {
                        if (th != null) {
                            uVar.onError(th);
                        } else {
                            uVar.onComplete();
                        }
                        this.worker.dispose();
                        return true;
                    }
                } else if (th != null) {
                    this.queue.clear();
                    uVar.onError(th);
                    this.worker.dispose();
                    return true;
                } else if (z2) {
                    uVar.onComplete();
                    this.worker.dispose();
                    return true;
                }
            }
            return false;
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            if ((i & 2) != 0) {
                this.outputFused = true;
                return 2;
            }
            return 0;
        }

        @Override // io.reactivex.internal.a.g
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // io.reactivex.internal.a.g
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.internal.a.g
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }
}
