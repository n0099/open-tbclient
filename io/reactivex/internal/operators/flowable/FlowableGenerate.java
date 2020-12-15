package io.reactivex.internal.operators.flowable;

import io.reactivex.f;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import org.a.d;
/* loaded from: classes9.dex */
public final class FlowableGenerate<T, S> extends g<T> {
    final io.reactivex.b.g<? super S> disposeState;
    final io.reactivex.b.c<S, f<T>, S> generator;
    final Callable<S> pFA;

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> cVar) {
        try {
            cVar.onSubscribe(new GeneratorSubscription(cVar, this.generator, this.disposeState, this.pFA.call()));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.J(th);
            EmptySubscription.error(th, cVar);
        }
    }

    /* loaded from: classes9.dex */
    static final class GeneratorSubscription<T, S> extends AtomicLong implements f<T>, d {
        private static final long serialVersionUID = 7565982551505011832L;
        final org.a.c<? super T> actual;
        volatile boolean cancelled;
        final io.reactivex.b.g<? super S> disposeState;
        final io.reactivex.b.c<S, ? super f<T>, S> generator;
        boolean hasNext;
        S state;
        boolean terminate;

        GeneratorSubscription(org.a.c<? super T> cVar, io.reactivex.b.c<S, ? super f<T>, S> cVar2, io.reactivex.b.g<? super S> gVar, S s) {
            this.actual = cVar;
            this.generator = cVar2;
            this.disposeState = gVar;
            this.state = s;
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j) && io.reactivex.internal.util.b.a(this, j) == 0) {
                S s = this.state;
                io.reactivex.b.c<S, ? super f<T>, S> cVar = this.generator;
                long j2 = 0;
                while (true) {
                    if (j2 != j) {
                        if (this.cancelled) {
                            this.state = null;
                            bJ(s);
                            return;
                        }
                        this.hasNext = false;
                        try {
                            s = cVar.apply(s, this);
                            if (this.terminate) {
                                this.cancelled = true;
                                this.state = null;
                                bJ(s);
                                return;
                            }
                            j2++;
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.J(th);
                            this.cancelled = true;
                            this.state = null;
                            onError(th);
                            bJ(s);
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

        private void bJ(S s) {
            try {
                this.disposeState.accept(s);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                io.reactivex.d.a.onError(th);
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (io.reactivex.internal.util.b.a(this, 1L) == 0) {
                    S s = this.state;
                    this.state = null;
                    bJ(s);
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
                io.reactivex.d.a.onError(th);
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
