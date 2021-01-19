package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.b.f;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.h;
import io.reactivex.i;
import io.reactivex.internal.a.e;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes5.dex */
public final class FlowableCreate<T> extends g<T> {
    final i<T> qef;
    final BackpressureStrategy qeg;

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> cVar) {
        BaseEmitter latestAsyncEmitter;
        switch (this.qeg) {
            case MISSING:
                latestAsyncEmitter = new MissingEmitter(cVar);
                break;
            case ERROR:
                latestAsyncEmitter = new ErrorAsyncEmitter(cVar);
                break;
            case DROP:
                latestAsyncEmitter = new DropAsyncEmitter(cVar);
                break;
            case LATEST:
                latestAsyncEmitter = new LatestAsyncEmitter(cVar);
                break;
            default:
                latestAsyncEmitter = new BufferAsyncEmitter(cVar, eHO());
                break;
        }
        cVar.onSubscribe(latestAsyncEmitter);
        try {
            this.qef.a(latestAsyncEmitter);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.O(th);
            latestAsyncEmitter.onError(th);
        }
    }

    /* loaded from: classes5.dex */
    static final class SerializedEmitter<T> extends AtomicInteger implements h<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final BaseEmitter<T> emitter;
        final AtomicThrowable error = new AtomicThrowable();
        final e<T> queue = new io.reactivex.internal.queue.a(16);

        SerializedEmitter(BaseEmitter<T> baseEmitter) {
            this.emitter = baseEmitter;
        }

        @Override // io.reactivex.f
        public void onNext(T t) {
            if (!this.emitter.isCancelled() && !this.done) {
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
        }

        @Override // io.reactivex.f
        public void onError(Throwable th) {
            if (!tryOnError(th)) {
                io.reactivex.d.a.onError(th);
            }
        }

        public boolean tryOnError(Throwable th) {
            if (this.emitter.isCancelled() || this.done) {
                return false;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (this.error.addThrowable(th)) {
                this.done = true;
                drain();
                return true;
            }
            return false;
        }

        @Override // io.reactivex.f
        public void onComplete() {
            if (!this.emitter.isCancelled() && !this.done) {
                this.done = true;
                drain();
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            BaseEmitter<T> baseEmitter = this.emitter;
            e<T> eVar = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            int i = 1;
            while (!baseEmitter.isCancelled()) {
                if (atomicThrowable.get() != null) {
                    eVar.clear();
                    baseEmitter.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z = this.done;
                T poll = eVar.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    baseEmitter.onComplete();
                    return;
                } else if (!z2) {
                    baseEmitter.onNext(poll);
                } else {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
            eVar.clear();
        }

        public void setDisposable(io.reactivex.disposables.b bVar) {
            this.emitter.setDisposable(bVar);
        }

        public void setCancellable(f fVar) {
            this.emitter.setCancellable(fVar);
        }

        public long requested() {
            return this.emitter.requested();
        }

        public boolean isCancelled() {
            return this.emitter.isCancelled();
        }

        public h<T> serialize() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class BaseEmitter<T> extends AtomicLong implements h<T>, d {
        private static final long serialVersionUID = 7326289992464377023L;
        final org.a.c<? super T> actual;
        final SequentialDisposable serial = new SequentialDisposable();

        BaseEmitter(org.a.c<? super T> cVar) {
            this.actual = cVar;
        }

        @Override // io.reactivex.f
        public void onComplete() {
            complete();
        }

        protected void complete() {
            if (!isCancelled()) {
                try {
                    this.actual.onComplete();
                } finally {
                    this.serial.dispose();
                }
            }
        }

        @Override // io.reactivex.f
        public final void onError(Throwable th) {
            if (!tryOnError(th)) {
                io.reactivex.d.a.onError(th);
            }
        }

        public boolean tryOnError(Throwable th) {
            return error(th);
        }

        protected boolean error(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isCancelled()) {
                return false;
            }
            try {
                this.actual.onError(th);
                this.serial.dispose();
                return true;
            } catch (Throwable th2) {
                this.serial.dispose();
                throw th2;
            }
        }

        @Override // org.a.d
        public final void cancel() {
            this.serial.dispose();
            onUnsubscribed();
        }

        void onUnsubscribed() {
        }

        public final boolean isCancelled() {
            return this.serial.isDisposed();
        }

        @Override // org.a.d
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this, j);
                onRequested();
            }
        }

        void onRequested() {
        }

        public final void setDisposable(io.reactivex.disposables.b bVar) {
            this.serial.update(bVar);
        }

        public final void setCancellable(f fVar) {
            setDisposable(new CancellableDisposable(fVar));
        }

        public final long requested() {
            return get();
        }

        public final h<T> serialize() {
            return new SerializedEmitter(this);
        }
    }

    /* loaded from: classes5.dex */
    static final class MissingEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        MissingEmitter(org.a.c<? super T> cVar) {
            super(cVar);
        }

        @Override // io.reactivex.f
        public void onNext(T t) {
            long j;
            if (!isCancelled()) {
                if (t != null) {
                    this.actual.onNext(t);
                    do {
                        j = get();
                        if (j == 0) {
                            return;
                        }
                    } while (!compareAndSet(j, j - 1));
                    return;
                }
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
        }
    }

    /* loaded from: classes5.dex */
    static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        abstract void onOverflow();

        NoOverflowBaseAsyncEmitter(org.a.c<? super T> cVar) {
            super(cVar);
        }

        @Override // io.reactivex.f
        public final void onNext(T t) {
            if (!isCancelled()) {
                if (t == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else if (get() != 0) {
                    this.actual.onNext(t);
                    io.reactivex.internal.util.b.c(this, 1L);
                } else {
                    onOverflow();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        DropAsyncEmitter(org.a.c<? super T> cVar) {
            super(cVar);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        void onOverflow() {
        }
    }

    /* loaded from: classes5.dex */
    static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;

        ErrorAsyncEmitter(org.a.c<? super T> cVar) {
            super(cVar);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        void onOverflow() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    /* loaded from: classes5.dex */
    static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final io.reactivex.internal.queue.a<T> queue;
        final AtomicInteger wip;

        BufferAsyncEmitter(org.a.c<? super T> cVar, int i) {
            super(cVar);
            this.queue = new io.reactivex.internal.queue.a<>(i);
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.f
        public void onNext(T t) {
            if (!this.done && !isCancelled()) {
                if (t == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                this.queue.offer(t);
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        public boolean tryOnError(Throwable th) {
            if (this.done || isCancelled()) {
                return false;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.error = th;
            this.done = true;
            drain();
            return true;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.f
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onRequested() {
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                org.a.c<? super T> cVar = this.actual;
                io.reactivex.internal.queue.a<T> aVar = this.queue;
                int i = 1;
                do {
                    long j = get();
                    long j2 = 0;
                    while (j2 != j) {
                        if (isCancelled()) {
                            aVar.clear();
                            return;
                        }
                        boolean z = this.done;
                        Object obj = (T) aVar.poll();
                        boolean z2 = obj == null;
                        if (z && z2) {
                            Throwable th = this.error;
                            if (th != null) {
                                error(th);
                                return;
                            } else {
                                complete();
                                return;
                            }
                        } else if (z2) {
                            break;
                        } else {
                            cVar.onNext(obj);
                            j2 = 1 + j2;
                        }
                    }
                    if (j2 == j) {
                        if (isCancelled()) {
                            aVar.clear();
                            return;
                        }
                        boolean z3 = this.done;
                        boolean isEmpty = aVar.isEmpty();
                        if (z3 && isEmpty) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                error(th2);
                                return;
                            } else {
                                complete();
                                return;
                            }
                        }
                    }
                    if (j2 != 0) {
                        io.reactivex.internal.util.b.c(this, j2);
                    }
                    i = this.wip.addAndGet(-i);
                } while (i != 0);
            }
        }
    }

    /* loaded from: classes5.dex */
    static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<T> queue;
        final AtomicInteger wip;

        LatestAsyncEmitter(org.a.c<? super T> cVar) {
            super(cVar);
            this.queue = new AtomicReference<>();
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.f
        public void onNext(T t) {
            if (!this.done && !isCancelled()) {
                if (t == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                this.queue.set(t);
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        public boolean tryOnError(Throwable th) {
            if (this.done || isCancelled()) {
                return false;
            }
            if (th == null) {
                onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.error = th;
            this.done = true;
            drain();
            return true;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.f
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onRequested() {
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                org.a.c<? super T> cVar = this.actual;
                AtomicReference<T> atomicReference = this.queue;
                int i = 1;
                do {
                    long j = get();
                    long j2 = 0;
                    while (j2 != j) {
                        if (isCancelled()) {
                            atomicReference.lazySet(null);
                            return;
                        }
                        boolean z = this.done;
                        Object obj = (T) atomicReference.getAndSet(null);
                        boolean z2 = obj == null;
                        if (z && z2) {
                            Throwable th = this.error;
                            if (th != null) {
                                error(th);
                                return;
                            } else {
                                complete();
                                return;
                            }
                        } else if (z2) {
                            break;
                        } else {
                            cVar.onNext(obj);
                            j2++;
                        }
                    }
                    if (j2 == j) {
                        if (isCancelled()) {
                            atomicReference.lazySet(null);
                            return;
                        }
                        boolean z3 = this.done;
                        boolean z4 = atomicReference.get() == null;
                        if (z3 && z4) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                error(th2);
                                return;
                            } else {
                                complete();
                                return;
                            }
                        }
                    }
                    if (j2 != 0) {
                        io.reactivex.internal.util.b.c(this, j2);
                    }
                    i = this.wip.addAndGet(-i);
                } while (i != 0);
            }
        }
    }
}
