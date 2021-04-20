package io.reactivex.internal.operators.flowable;

import f.b.f;
import f.b.t.b;
import f.b.x.c.e;
import f.b.x.f.a;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class FlowableCreate$SerializedEmitter<T> extends AtomicInteger implements f<T> {
    public static final long serialVersionUID = 4883307006032401862L;
    public volatile boolean done;
    public final FlowableCreate$BaseEmitter<T> emitter;
    public final AtomicThrowable error = new AtomicThrowable();
    public final e<T> queue = new a(16);

    public FlowableCreate$SerializedEmitter(FlowableCreate$BaseEmitter<T> flowableCreate$BaseEmitter) {
        this.emitter = flowableCreate$BaseEmitter;
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    public void drainLoop() {
        FlowableCreate$BaseEmitter<T> flowableCreate$BaseEmitter = this.emitter;
        e<T> eVar = this.queue;
        AtomicThrowable atomicThrowable = this.error;
        int i = 1;
        while (!flowableCreate$BaseEmitter.isCancelled()) {
            if (atomicThrowable.get() != null) {
                eVar.clear();
                flowableCreate$BaseEmitter.onError(atomicThrowable.terminate());
                return;
            }
            boolean z = this.done;
            T poll = eVar.poll();
            boolean z2 = poll == null;
            if (z && z2) {
                flowableCreate$BaseEmitter.onComplete();
                return;
            } else if (z2) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                flowableCreate$BaseEmitter.onNext(poll);
            }
        }
        eVar.clear();
    }

    public boolean isCancelled() {
        return this.emitter.isCancelled();
    }

    @Override // f.b.d
    public void onComplete() {
        if (this.emitter.isCancelled() || this.done) {
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
        if (this.emitter.isCancelled() || this.done) {
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
            e<T> eVar = this.queue;
            synchronized (eVar) {
                eVar.offer(t);
            }
            if (getAndIncrement() != 0) {
                return;
            }
        }
        drainLoop();
    }

    public long requested() {
        return this.emitter.requested();
    }

    public f<T> serialize() {
        return this;
    }

    public void setCancellable(f.b.w.f fVar) {
        this.emitter.setCancellable(fVar);
    }

    public void setDisposable(b bVar) {
        this.emitter.setDisposable(bVar);
    }

    public boolean tryOnError(Throwable th) {
        if (!this.emitter.isCancelled() && !this.done) {
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
