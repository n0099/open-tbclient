package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableGenerate<T, S> extends io.reactivex.g<T> {
    final io.reactivex.c.g<? super S> disposeState;
    final io.reactivex.c.c<S, io.reactivex.f<T>, S> generator;
    final Callable<S> mSi;

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> cVar) {
        try {
            cVar.onSubscribe(new GeneratorSubscription(cVar, this.generator, this.disposeState, this.mSi.call()));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.L(th);
            EmptySubscription.error(th, cVar);
        }
    }

    /* loaded from: classes7.dex */
    static final class GeneratorSubscription<T, S> extends AtomicLong implements io.reactivex.f<T>, org.a.d {
        private static final long serialVersionUID = 7565982551505011832L;
        final org.a.c<? super T> actual;
        volatile boolean cancelled;
        final io.reactivex.c.g<? super S> disposeState;
        final io.reactivex.c.c<S, ? super io.reactivex.f<T>, S> generator;
        boolean hasNext;
        S state;
        boolean terminate;

        GeneratorSubscription(org.a.c<? super T> cVar, io.reactivex.c.c<S, ? super io.reactivex.f<T>, S> cVar2, io.reactivex.c.g<? super S> gVar, S s) {
            this.actual = cVar;
            this.generator = cVar2;
            this.disposeState = gVar;
            this.state = s;
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j) && io.reactivex.internal.util.b.a(this, j) == 0) {
                S s = this.state;
                io.reactivex.c.c<S, ? super io.reactivex.f<T>, S> cVar = this.generator;
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (this.cancelled) {
                            this.state = null;
                            bu(s);
                            return;
                        }
                        this.hasNext = false;
                        try {
                            s = cVar.apply(s, this);
                            if (this.terminate) {
                                this.cancelled = true;
                                this.state = null;
                                bu(s);
                                return;
                            }
                            j2++;
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.L(th);
                            this.cancelled = true;
                            this.state = null;
                            onError(th);
                            bu(s);
                            return;
                        }
                    } else {
                        j = get();
                        if (j2 == j) {
                            this.state = s;
                            j = addAndGet(-j2);
                            if (j == 0) {
                                return;
                            }
                            j2 = 0;
                        } else {
                            continue;
                        }
                    }
                }
            }
        }

        private void bu(S s) {
            try {
                this.disposeState.accept(s);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.L(th);
                io.reactivex.e.a.onError(th);
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (io.reactivex.internal.util.b.a(this, 1L) == 0) {
                    S s = this.state;
                    this.state = null;
                    bu(s);
                }
            }
        }

        @Override // io.reactivex.f
        public void onNext(T t) {
            if (!this.terminate) {
                if (this.hasNext) {
                    onError(new IllegalStateException("onNext already called in this generate turn"));
                } else if (t == null) {
                    onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else {
                    this.hasNext = true;
                    this.actual.onNext(t);
                }
            }
        }

        @Override // io.reactivex.f
        public void onError(Throwable th) {
            if (this.terminate) {
                io.reactivex.e.a.onError(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.terminate = true;
            this.actual.onError(th);
        }

        @Override // io.reactivex.f
        public void onComplete() {
            if (!this.terminate) {
                this.terminate = true;
                this.actual.onComplete();
            }
        }
    }
}
