package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableOnBackpressureLatest<T> extends a<T, T> {
    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.mRJ.a((j) new BackpressureLatestSubscriber(cVar));
    }

    /* loaded from: classes7.dex */
    static final class BackpressureLatestSubscriber<T> extends AtomicInteger implements j<T>, org.a.d {
        private static final long serialVersionUID = 163080509307634843L;
        final org.a.c<? super T> actual;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        org.a.d s;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<T> current = new AtomicReference<>();

        BackpressureLatestSubscriber(org.a.c<? super T> cVar) {
            this.actual = cVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.current.lazySet(t);
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            drain();
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
            if (!this.cancelled) {
                this.cancelled = true;
                this.s.cancel();
                if (getAndIncrement() == 0) {
                    this.current.lazySet(null);
                }
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                org.a.c<? super T> cVar = this.actual;
                AtomicLong atomicLong = this.requested;
                AtomicReference<T> atomicReference = this.current;
                int i = 1;
                do {
                    long j = 0;
                    while (j != atomicLong.get()) {
                        boolean z = this.done;
                        Object obj = (T) atomicReference.getAndSet(null);
                        boolean z2 = obj == null;
                        if (!checkTerminated(z, z2, cVar, atomicReference)) {
                            if (z2) {
                                break;
                            }
                            cVar.onNext(obj);
                            j++;
                        } else {
                            return;
                        }
                    }
                    if (j == atomicLong.get()) {
                        if (checkTerminated(this.done, atomicReference.get() == null, cVar, atomicReference)) {
                            return;
                        }
                    }
                    if (j != 0) {
                        io.reactivex.internal.util.b.c(atomicLong, j);
                    }
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }

        boolean checkTerminated(boolean z, boolean z2, org.a.c<?> cVar, AtomicReference<T> atomicReference) {
            if (this.cancelled) {
                atomicReference.lazySet(null);
                return true;
            }
            if (z) {
                Throwable th = this.error;
                if (th != null) {
                    atomicReference.lazySet(null);
                    cVar.onError(th);
                    return true;
                } else if (z2) {
                    cVar.onComplete();
                    return true;
                }
            }
            return false;
        }
    }
}
