package io.reactivex.internal.operators.observable;

import f.b.o;
import f.b.p;
import f.b.t.b;
import f.b.u.a;
import f.b.x.c.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
/* loaded from: classes7.dex */
public final class ObservableObserveOn$ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements o<T>, Runnable {
    public static final long serialVersionUID = 6576896619930983584L;
    public final o<? super T> actual;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public boolean outputFused;
    public f<T> queue;
    public b s;
    public int sourceMode;
    public final p.c worker;

    public ObservableObserveOn$ObserveOnObserver(o<? super T> oVar, p.c cVar, boolean z, int i) {
        this.actual = oVar;
        this.worker = cVar;
        this.delayError = z;
        this.bufferSize = i;
    }

    public boolean checkTerminated(boolean z, boolean z2, o<? super T> oVar) {
        if (this.cancelled) {
            this.queue.clear();
            return true;
        } else if (z) {
            Throwable th = this.error;
            if (this.delayError) {
                if (z2) {
                    if (th != null) {
                        oVar.onError(th);
                    } else {
                        oVar.onComplete();
                    }
                    this.worker.dispose();
                    return true;
                }
                return false;
            } else if (th != null) {
                this.queue.clear();
                oVar.onError(th);
                this.worker.dispose();
                return true;
            } else if (z2) {
                oVar.onComplete();
                this.worker.dispose();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.x.c.f
    public void clear() {
        this.queue.clear();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.t.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.s.dispose();
        this.worker.dispose();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public void drainFused() {
        int i = 1;
        while (!this.cancelled) {
            boolean z = this.done;
            Throwable th = this.error;
            if (!this.delayError && z && th != null) {
                this.actual.onError(th);
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

    public void drainNormal() {
        f<T> fVar = this.queue;
        o<? super T> oVar = this.actual;
        int i = 1;
        while (!checkTerminated(this.done, fVar.isEmpty(), oVar)) {
            while (true) {
                boolean z = this.done;
                try {
                    Object obj = (T) fVar.poll();
                    boolean z2 = obj == null;
                    if (checkTerminated(z, z2, oVar)) {
                        return;
                    }
                    if (z2) {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        oVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    a.a(th);
                    this.s.dispose();
                    fVar.clear();
                    oVar.onError(th);
                    this.worker.dispose();
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.t.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.x.c.f
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // f.b.o
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        schedule();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        if (this.done) {
            f.b.a0.a.f(th);
            return;
        }
        this.error = th;
        this.done = true;
        schedule();
    }

    @Override // f.b.o
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.sourceMode != 2) {
            this.queue.offer(t);
        }
        schedule();
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            if (bVar instanceof f.b.x.c.b) {
                f.b.x.c.b bVar2 = (f.b.x.c.b) bVar;
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
            this.queue = new f.b.x.f.a(this.bufferSize);
            this.actual.onSubscribe(this);
        }
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.x.c.f
    public T poll() throws Exception {
        return this.queue.poll();
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.x.c.c
    public int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.outputFused = true;
            return 2;
        }
        return 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.outputFused) {
            drainFused();
        } else {
            drainNormal();
        }
    }

    public void schedule() {
        if (getAndIncrement() == 0) {
            this.worker.b(this);
        }
    }
}
