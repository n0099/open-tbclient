package io.reactivex.internal.operators.flowable;

import io.reactivex.b.h;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes5.dex */
public final class FlowableFlatMapCompletable<T> extends a<T, T> {
    final boolean delayErrors;
    final h<? super T, ? extends e> mapper;
    final int maxConcurrency;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.qow.a((j) new FlatMapCompletableMainSubscriber(cVar, this.mapper, this.delayErrors, this.maxConcurrency));
    }

    /* loaded from: classes5.dex */
    static final class FlatMapCompletableMainSubscriber<T> extends BasicIntQueueSubscription<T> implements j<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final org.a.c<? super T> actual;
        volatile boolean cancelled;
        final boolean delayErrors;
        final h<? super T, ? extends e> mapper;
        final int maxConcurrency;
        d s;
        final AtomicThrowable errors = new AtomicThrowable();
        final io.reactivex.disposables.a set = new io.reactivex.disposables.a();

        FlatMapCompletableMainSubscriber(org.a.c<? super T> cVar, h<? super T, ? extends e> hVar, boolean z, int i) {
            this.actual = cVar;
            this.mapper = hVar;
            this.delayErrors = z;
            this.maxConcurrency = i;
            lazySet(1);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                int i = this.maxConcurrency;
                if (i == Integer.MAX_VALUE) {
                    dVar.request(Long.MAX_VALUE);
                } else {
                    dVar.request(i);
                }
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            try {
                e eVar = (e) io.reactivex.internal.functions.a.m(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerConsumer innerConsumer = new InnerConsumer();
                if (!this.cancelled && this.set.a(innerConsumer)) {
                    eVar.a(innerConsumer);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.N(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.delayErrors) {
                    if (decrementAndGet() == 0) {
                        this.actual.onError(this.errors.terminate());
                        return;
                    } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.s.request(1L);
                        return;
                    } else {
                        return;
                    }
                }
                cancel();
                if (getAndSet(0) > 0) {
                    this.actual.onError(this.errors.terminate());
                    return;
                }
                return;
            }
            io.reactivex.d.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.errors.terminate();
                if (terminate != null) {
                    this.actual.onError(terminate);
                } else {
                    this.actual.onComplete();
                }
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.s.request(1L);
            }
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
            this.set.dispose();
        }

        @Override // org.a.d
        public void request(long j) {
        }

        @Override // io.reactivex.internal.a.f
        public T poll() throws Exception {
            return null;
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            return true;
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int i) {
            return i & 2;
        }

        void innerComplete(FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer) {
            this.set.c(innerConsumer);
            onComplete();
        }

        void innerError(FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer, Throwable th) {
            this.set.c(innerConsumer);
            onError(th);
        }

        /* loaded from: classes5.dex */
        final class InnerConsumer extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.c, io.reactivex.disposables.b {
            private static final long serialVersionUID = 8606673141535671828L;

            InnerConsumer() {
            }

            @Override // io.reactivex.c
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.c
            public void onComplete() {
                FlatMapCompletableMainSubscriber.this.innerComplete(this);
            }

            @Override // io.reactivex.c
            public void onError(Throwable th) {
                FlatMapCompletableMainSubscriber.this.innerError(this, th);
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }
        }
    }
}
