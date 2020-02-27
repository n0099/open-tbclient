package io.reactivex.internal.operators.mixed;

import io.reactivex.aa;
import io.reactivex.c.h;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.a.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.b;
import io.reactivex.j;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;
/* loaded from: classes7.dex */
public final class FlowableConcatMapSingle<T, R> extends g<R> {
    final ErrorMode errorMode;
    final h<? super T, ? extends aa<? extends R>> mapper;
    final g<T> nwr;
    final int prefetch;

    @Override // io.reactivex.g
    protected void a(c<? super R> cVar) {
        this.nwr.a((j) new ConcatMapSingleSubscriber(cVar, this.mapper, this.prefetch, this.errorMode));
    }

    /* loaded from: classes7.dex */
    static final class ConcatMapSingleSubscriber<T, R> extends AtomicInteger implements j<T>, d {
        static final int STATE_ACTIVE = 1;
        static final int STATE_INACTIVE = 0;
        static final int STATE_RESULT_VALUE = 2;
        private static final long serialVersionUID = -9140123220065488293L;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        final c<? super R> downstream;
        long emitted;
        final ErrorMode errorMode;
        R item;
        final h<? super T, ? extends aa<? extends R>> mapper;
        final int prefetch;
        final f<T> queue;
        volatile int state;
        d upstream;
        final AtomicLong requested = new AtomicLong();
        final AtomicThrowable errors = new AtomicThrowable();
        final ConcatMapSingleObserver<R> inner = new ConcatMapSingleObserver<>(this);

        ConcatMapSingleSubscriber(c<? super R> cVar, h<? super T, ? extends aa<? extends R>> hVar, int i, ErrorMode errorMode) {
            this.downstream = cVar;
            this.mapper = hVar;
            this.prefetch = i;
            this.errorMode = errorMode;
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
            if (!this.queue.offer(t)) {
                this.upstream.cancel();
                onError(new MissingBackpressureException("queue full?!"));
                return;
            }
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.errorMode == ErrorMode.IMMEDIATE) {
                    this.inner.dispose();
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

        @Override // org.a.d
        public void request(long j) {
            b.a(this.requested, j);
            drain();
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.inner.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
                this.item = null;
            }
        }

        void innerSuccess(R r) {
            this.item = r;
            this.state = 2;
            drain();
        }

        void innerError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.errorMode != ErrorMode.END) {
                    this.upstream.cancel();
                }
                this.state = 0;
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        /* JADX DEBUG: Type inference failed for r0v20. Raw type applied. Possible types: R, ? super R */
        void drain() {
            if (getAndIncrement() == 0) {
                c<? super R> cVar = this.downstream;
                ErrorMode errorMode = this.errorMode;
                f<T> fVar = this.queue;
                AtomicThrowable atomicThrowable = this.errors;
                AtomicLong atomicLong = this.requested;
                int i = this.prefetch - (this.prefetch >> 1);
                int i2 = 1;
                while (true) {
                    if (this.cancelled) {
                        fVar.clear();
                        this.item = null;
                    } else {
                        int i3 = this.state;
                        if (atomicThrowable.get() == null || (errorMode != ErrorMode.IMMEDIATE && (errorMode != ErrorMode.BOUNDARY || i3 != 0))) {
                            if (i3 == 0) {
                                boolean z = this.done;
                                T poll = fVar.poll();
                                boolean z2 = poll == null;
                                if (z && z2) {
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate == null) {
                                        cVar.onComplete();
                                        return;
                                    } else {
                                        cVar.onError(terminate);
                                        return;
                                    }
                                } else if (!z2) {
                                    int i4 = this.consumed + 1;
                                    if (i4 == i) {
                                        this.consumed = 0;
                                        this.upstream.request(i);
                                    } else {
                                        this.consumed = i4;
                                    }
                                    try {
                                        aa aaVar = (aa) io.reactivex.internal.functions.a.h(this.mapper.apply(poll), "The mapper returned a null SingleSource");
                                        this.state = 1;
                                        aaVar.a(this.inner);
                                    } catch (Throwable th) {
                                        io.reactivex.exceptions.a.H(th);
                                        this.upstream.cancel();
                                        fVar.clear();
                                        atomicThrowable.addThrowable(th);
                                        cVar.onError(atomicThrowable.terminate());
                                        return;
                                    }
                                }
                            } else if (i3 == 2) {
                                long j = this.emitted;
                                if (j != atomicLong.get()) {
                                    this.item = null;
                                    cVar.onNext((R) this.item);
                                    this.emitted = j + 1;
                                    this.state = 0;
                                }
                            }
                        }
                    }
                    int addAndGet = addAndGet(-i2);
                    if (addAndGet == 0) {
                        return;
                    }
                    i2 = addAndGet;
                }
                fVar.clear();
                this.item = null;
                cVar.onError(atomicThrowable.terminate());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes7.dex */
        public static final class ConcatMapSingleObserver<R> extends AtomicReference<io.reactivex.disposables.b> implements y<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            final ConcatMapSingleSubscriber<?, R> parent;

            ConcatMapSingleObserver(ConcatMapSingleSubscriber<?, R> concatMapSingleSubscriber) {
                this.parent = concatMapSingleSubscriber;
            }

            @Override // io.reactivex.y
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.replace(this, bVar);
            }

            @Override // io.reactivex.y
            public void onSuccess(R r) {
                this.parent.innerSuccess(r);
            }

            @Override // io.reactivex.y
            public void onError(Throwable th) {
                this.parent.innerError(th);
            }

            void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
