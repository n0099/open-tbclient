package io.reactivex.internal.operators.mixed;

import io.reactivex.c;
import io.reactivex.c.h;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.a.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes7.dex */
public final class FlowableConcatMapCompletable<T> extends io.reactivex.a {
    final ErrorMode errorMode;
    final h<? super T, ? extends e> mapper;
    final g<T> nwt;
    final int prefetch;

    @Override // io.reactivex.a
    protected void b(c cVar) {
        this.nwt.a((j) new ConcatMapCompletableObserver(cVar, this.mapper, this.errorMode, this.prefetch));
    }

    /* loaded from: classes7.dex */
    static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements b, j<T> {
        private static final long serialVersionUID = 3610901111000061034L;
        volatile boolean active;
        int consumed;
        volatile boolean disposed;
        volatile boolean done;
        final c downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final ConcatMapInnerObserver inner = new ConcatMapInnerObserver(this);
        final h<? super T, ? extends e> mapper;
        final int prefetch;
        final f<T> queue;
        d upstream;

        ConcatMapCompletableObserver(c cVar, h<? super T, ? extends e> hVar, ErrorMode errorMode, int i) {
            this.downstream = cVar;
            this.mapper = hVar;
            this.errorMode = errorMode;
            this.prefetch = i;
            this.queue = new SpscArrayQueue(i);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
                dVar.request(this.prefetch);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (this.queue.offer(t)) {
                drain();
                return;
            }
            this.upstream.cancel();
            onError(new MissingBackpressureException("Queue full?!"));
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.errorMode == ErrorMode.IMMEDIATE) {
                    this.inner.dispose();
                    Throwable terminate = this.errors.terminate();
                    if (terminate != ExceptionHelper.TERMINATED) {
                        this.downstream.onError(terminate);
                    }
                    if (getAndIncrement() == 0) {
                        this.queue.clear();
                        return;
                    }
                    return;
                }
                this.done = true;
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.upstream.cancel();
            this.inner.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }

        void innerError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.errorMode == ErrorMode.IMMEDIATE) {
                    this.upstream.cancel();
                    Throwable terminate = this.errors.terminate();
                    if (terminate != ExceptionHelper.TERMINATED) {
                        this.downstream.onError(terminate);
                    }
                    if (getAndIncrement() == 0) {
                        this.queue.clear();
                        return;
                    }
                    return;
                }
                this.active = false;
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                while (!this.disposed) {
                    if (!this.active) {
                        if (this.errorMode == ErrorMode.BOUNDARY && this.errors.get() != null) {
                            this.queue.clear();
                            this.downstream.onError(this.errors.terminate());
                            return;
                        }
                        boolean z = this.done;
                        T poll = this.queue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable terminate = this.errors.terminate();
                            if (terminate != null) {
                                this.downstream.onError(terminate);
                                return;
                            } else {
                                this.downstream.onComplete();
                                return;
                            }
                        } else if (!z2) {
                            int i = this.prefetch - (this.prefetch >> 1);
                            int i2 = this.consumed + 1;
                            if (i2 == i) {
                                this.consumed = 0;
                                this.upstream.request(i);
                            } else {
                                this.consumed = i2;
                            }
                            try {
                                e eVar = (e) io.reactivex.internal.functions.a.h(this.mapper.apply(poll), "The mapper returned a null CompletableSource");
                                this.active = true;
                                eVar.a(this.inner);
                            } catch (Throwable th) {
                                io.reactivex.exceptions.a.H(th);
                                this.queue.clear();
                                this.upstream.cancel();
                                this.errors.addThrowable(th);
                                this.downstream.onError(this.errors.terminate());
                                return;
                            }
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.queue.clear();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes7.dex */
        public static final class ConcatMapInnerObserver extends AtomicReference<b> implements c {
            private static final long serialVersionUID = 5638352172918776687L;
            final ConcatMapCompletableObserver<?> parent;

            ConcatMapInnerObserver(ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
                this.parent = concatMapCompletableObserver;
            }

            @Override // io.reactivex.c
            public void onSubscribe(b bVar) {
                DisposableHelper.replace(this, bVar);
            }

            @Override // io.reactivex.c
            public void onError(Throwable th) {
                this.parent.innerError(th);
            }

            @Override // io.reactivex.c
            public void onComplete() {
                this.parent.innerComplete();
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
