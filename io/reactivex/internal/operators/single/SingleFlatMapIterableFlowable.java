package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.c.h;
import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.y;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.a.c;
/* loaded from: classes7.dex */
public final class SingleFlatMapIterableFlowable<T, R> extends g<R> {
    final h<? super T, ? extends Iterable<? extends R>> mapper;
    final aa<T> source;

    @Override // io.reactivex.g
    protected void a(c<? super R> cVar) {
        this.source.a(new FlatMapIterableObserver(cVar, this.mapper));
    }

    /* loaded from: classes7.dex */
    static final class FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements y<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        final c<? super R> actual;
        volatile boolean cancelled;
        io.reactivex.disposables.b d;
        volatile Iterator<? extends R> it;
        final h<? super T, ? extends Iterable<? extends R>> mapper;
        boolean outputFused;
        final AtomicLong requested = new AtomicLong();

        FlatMapIterableObserver(c<? super R> cVar, h<? super T, ? extends Iterable<? extends R>> hVar) {
            this.actual = cVar;
            this.mapper = hVar;
        }

        @Override // io.reactivex.y
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.d, bVar)) {
                this.d = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.y
        public void onSuccess(T t) {
            try {
                Iterator<? extends R> it = this.mapper.apply(t).iterator();
                if (!it.hasNext()) {
                    this.actual.onComplete();
                    return;
                }
                this.it = it;
                drain();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.L(th);
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            this.d = DisposableHelper.DISPOSED;
            this.actual.onError(th);
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            this.d.dispose();
            this.d = DisposableHelper.DISPOSED;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                c<? super R> cVar = this.actual;
                Iterator<? extends R> it = this.it;
                if (this.outputFused && it != null) {
                    cVar.onNext(null);
                    cVar.onComplete();
                    return;
                }
                int i = 1;
                Iterator<? extends R> it2 = it;
                while (true) {
                    if (it2 != null) {
                        long j = this.requested.get();
                        if (j == Long.MAX_VALUE) {
                            slowPath(cVar, it2);
                            return;
                        }
                        long j2 = 0;
                        while (j2 != j) {
                            if (!this.cancelled) {
                                try {
                                    cVar.onNext((Object) io.reactivex.internal.functions.a.h(it2.next(), "The iterator returned a null value"));
                                    if (!this.cancelled) {
                                        j2++;
                                        try {
                                            if (!it2.hasNext()) {
                                                cVar.onComplete();
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            io.reactivex.exceptions.a.L(th);
                                            cVar.onError(th);
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } catch (Throwable th2) {
                                    io.reactivex.exceptions.a.L(th2);
                                    cVar.onError(th2);
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        if (j2 != 0) {
                            io.reactivex.internal.util.b.c(this.requested, j2);
                        }
                    }
                    int addAndGet = addAndGet(-i);
                    if (addAndGet != 0) {
                        if (it2 == null) {
                            i = addAndGet;
                            it2 = this.it;
                        } else {
                            i = addAndGet;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: R, ? super R */
        void slowPath(c<? super R> cVar, Iterator<? extends R> it) {
            while (!this.cancelled) {
                try {
                    cVar.onNext((R) it.next());
                    if (!this.cancelled) {
                        try {
                            if (!it.hasNext()) {
                                cVar.onComplete();
                                return;
                            }
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.L(th);
                            cVar.onError(th);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.L(th2);
                    cVar.onError(th2);
                    return;
                }
            }
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
        public void clear() {
            this.it = null;
        }

        @Override // io.reactivex.internal.a.g
        public boolean isEmpty() {
            return this.it == null;
        }

        @Override // io.reactivex.internal.a.g
        public R poll() throws Exception {
            Iterator<? extends R> it = this.it;
            if (it != null) {
                R r = (R) io.reactivex.internal.functions.a.h(it.next(), "The iterator returned a null value");
                if (!it.hasNext()) {
                    this.it = null;
                    return r;
                }
                return r;
            }
            return null;
        }
    }
}
