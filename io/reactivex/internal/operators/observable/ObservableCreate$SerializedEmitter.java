package io.reactivex.internal.operators.observable;

import f.b.m;
import f.b.t.b;
import f.b.w.f;
import f.b.x.f.a;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableCreate$SerializedEmitter<T> extends AtomicInteger implements m<T> {
    public static final long serialVersionUID = 4883307006032401862L;
    public volatile boolean done;
    public final m<T> emitter;
    public final AtomicThrowable error = new AtomicThrowable();
    public final a<T> queue = new a<>(16);

    public ObservableCreate$SerializedEmitter(m<T> mVar) {
        this.emitter = mVar;
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    public void drainLoop() {
        m<T> mVar = this.emitter;
        a<T> aVar = this.queue;
        AtomicThrowable atomicThrowable = this.error;
        int i = 1;
        while (!mVar.isDisposed()) {
            if (atomicThrowable.get() != null) {
                aVar.clear();
                mVar.onError(atomicThrowable.terminate());
                return;
            }
            boolean z = this.done;
            T poll = aVar.poll();
            boolean z2 = poll == null;
            if (z && z2) {
                mVar.onComplete();
                return;
            } else if (z2) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                mVar.onNext(poll);
            }
        }
        aVar.clear();
    }

    @Override // f.b.m, f.b.t.b
    public boolean isDisposed() {
        return this.emitter.isDisposed();
    }

    @Override // f.b.d
    public void onComplete() {
        if (this.emitter.isDisposed() || this.done) {
            return;
        }
        this.done = true;
        drain();
    }

    @Override // f.b.d
    public void onError(Throwable th) {
        if (tryOnError(th)) {
            return;
        }
        f.b.a0.a.f(th);
    }

    @Override // f.b.d
    public void onNext(T t) {
        if (this.emitter.isDisposed() || this.done) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (get() == 0 && compareAndSet(0, 1)) {
            this.emitter.onNext(t);
            if (decrementAndGet() == 0) {
                return;
            }
        } else {
            a<T> aVar = this.queue;
            synchronized (aVar) {
                aVar.offer(t);
            }
            if (getAndIncrement() != 0) {
                return;
            }
        }
        drainLoop();
    }

    public m<T> serialize() {
        return this;
    }

    @Override // f.b.m
    public void setCancellable(f fVar) {
        this.emitter.setCancellable(fVar);
    }

    @Override // f.b.m
    public void setDisposable(b bVar) {
        this.emitter.setDisposable(bVar);
    }

    public boolean tryOnError(Throwable th) {
        if (!this.emitter.isDisposed() && !this.done) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (this.error.addThrowable(th)) {
                this.done = true;
                drain();
                return true;
            }
        }
        return false;
    }
}
