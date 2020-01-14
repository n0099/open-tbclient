package io.reactivex.internal.operators.parallel;

import com.google.android.exoplayer2.Format;
import io.reactivex.c.c;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.parallel.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;
/* loaded from: classes5.dex */
public final class ParallelReduceFull<T> extends g<T> {
    final a<? extends T> nxR;
    final c<T, T, T> reducer;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        ParallelReduceFullMainSubscriber parallelReduceFullMainSubscriber = new ParallelReduceFullMainSubscriber(cVar, this.nxR.dIi(), this.reducer);
        cVar.onSubscribe(parallelReduceFullMainSubscriber);
        this.nxR.a(parallelReduceFullMainSubscriber.subscribers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ParallelReduceFullMainSubscriber<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = -5370107872170712765L;
        final AtomicReference<SlotPair<T>> current;
        final AtomicReference<Throwable> error;
        final c<T, T, T> reducer;
        final AtomicInteger remaining;
        final ParallelReduceFullInnerSubscriber<T>[] subscribers;

        ParallelReduceFullMainSubscriber(org.a.c<? super T> cVar, int i, c<T, T, T> cVar2) {
            super(cVar);
            this.current = new AtomicReference<>();
            this.remaining = new AtomicInteger();
            this.error = new AtomicReference<>();
            ParallelReduceFullInnerSubscriber<T>[] parallelReduceFullInnerSubscriberArr = new ParallelReduceFullInnerSubscriber[i];
            for (int i2 = 0; i2 < i; i2++) {
                parallelReduceFullInnerSubscriberArr[i2] = new ParallelReduceFullInnerSubscriber<>(this, cVar2);
            }
            this.subscribers = parallelReduceFullInnerSubscriberArr;
            this.reducer = cVar2;
            this.remaining.lazySet(i);
        }

        SlotPair<T> addValue(T t) {
            SlotPair<T> slotPair;
            int tryAcquireSlot;
            while (true) {
                slotPair = this.current.get();
                if (slotPair == null) {
                    slotPair = new SlotPair<>();
                    if (!this.current.compareAndSet(null, slotPair)) {
                        continue;
                    }
                }
                tryAcquireSlot = slotPair.tryAcquireSlot();
                if (tryAcquireSlot >= 0) {
                    break;
                }
                this.current.compareAndSet(slotPair, null);
            }
            if (tryAcquireSlot == 0) {
                slotPair.first = t;
            } else {
                slotPair.second = t;
            }
            if (slotPair.releaseSlot()) {
                this.current.compareAndSet(slotPair, null);
                return slotPair;
            }
            return null;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.a.d
        public void cancel() {
            for (ParallelReduceFullInnerSubscriber<T> parallelReduceFullInnerSubscriber : this.subscribers) {
                parallelReduceFullInnerSubscriber.cancel();
            }
        }

        void innerError(Throwable th) {
            if (this.error.compareAndSet(null, th)) {
                cancel();
                this.actual.onError(th);
            } else if (th != this.error.get()) {
                io.reactivex.e.a.onError(th);
            }
        }

        void innerComplete(T t) {
            if (t != null) {
                while (true) {
                    SlotPair<T> addValue = addValue(t);
                    if (addValue == null) {
                        break;
                    }
                    try {
                        t = (T) io.reactivex.internal.functions.a.h(this.reducer.apply(addValue.first, addValue.second), "The reducer returned a null value");
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.I(th);
                        innerError(th);
                        return;
                    }
                }
            }
            if (this.remaining.decrementAndGet() == 0) {
                SlotPair<T> slotPair = this.current.get();
                this.current.lazySet(null);
                if (slotPair != null) {
                    complete(slotPair.first);
                } else {
                    this.actual.onComplete();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ParallelReduceFullInnerSubscriber<T> extends AtomicReference<d> implements j<T> {
        private static final long serialVersionUID = -7954444275102466525L;
        boolean done;
        final ParallelReduceFullMainSubscriber<T> parent;
        final c<T, T, T> reducer;
        T value;

        ParallelReduceFullInnerSubscriber(ParallelReduceFullMainSubscriber<T> parallelReduceFullMainSubscriber, c<T, T, T> cVar) {
            this.parent = parallelReduceFullMainSubscriber;
            this.reducer = cVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            SubscriptionHelper.setOnce(this, dVar, Format.OFFSET_SAMPLE_RELATIVE);
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!this.done) {
                T t2 = this.value;
                if (t2 == null) {
                    this.value = t;
                    return;
                }
                try {
                    this.value = (T) io.reactivex.internal.functions.a.h(this.reducer.apply(t2, t), "The reducer returned a null value");
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.I(th);
                    get().cancel();
                    onError(th);
                }
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            this.parent.innerError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.parent.innerComplete(this.value);
            }
        }

        void cancel() {
            SubscriptionHelper.cancel(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class SlotPair<T> extends AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;
        T first;
        final AtomicInteger releaseIndex = new AtomicInteger();
        T second;

        SlotPair() {
        }

        int tryAcquireSlot() {
            int i;
            do {
                i = get();
                if (i >= 2) {
                    return -1;
                }
            } while (!compareAndSet(i, i + 1));
            return i;
        }

        boolean releaseSlot() {
            return this.releaseIndex.incrementAndGet() == 2;
        }
    }
}
