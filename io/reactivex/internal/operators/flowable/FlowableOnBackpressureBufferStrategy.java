package io.reactivex.internal.operators.flowable;

import com.google.android.exoplayer2.Format;
import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableOnBackpressureBufferStrategy<T> extends a<T, T> {
    final long bufferSize;
    final io.reactivex.c.a onOverflow;
    final BackpressureOverflowStrategy strategy;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        this.nwE.a((j) new OnBackpressureBufferStrategySubscriber(cVar, this.onOverflow, this.strategy, this.bufferSize));
    }

    /* loaded from: classes7.dex */
    static final class OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements j<T>, org.a.d {
        private static final long serialVersionUID = 3240706908776709697L;
        final org.a.c<? super T> actual;
        final long bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        final io.reactivex.c.a onOverflow;
        org.a.d s;
        final BackpressureOverflowStrategy strategy;
        final AtomicLong requested = new AtomicLong();
        final Deque<T> deque = new ArrayDeque();

        OnBackpressureBufferStrategySubscriber(org.a.c<? super T> cVar, io.reactivex.c.a aVar, BackpressureOverflowStrategy backpressureOverflowStrategy, long j) {
            this.actual = cVar;
            this.onOverflow = aVar;
            this.strategy = backpressureOverflowStrategy;
            this.bufferSize = j;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(Format.OFFSET_SAMPLE_RELATIVE);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            boolean z = false;
            boolean z2 = true;
            if (!this.done) {
                Deque<T> deque = this.deque;
                synchronized (deque) {
                    if (deque.size() == this.bufferSize) {
                        switch (this.strategy) {
                            case DROP_LATEST:
                                deque.pollLast();
                                deque.offer(t);
                                break;
                            case DROP_OLDEST:
                                deque.poll();
                                deque.offer(t);
                                break;
                            default:
                                z2 = false;
                                z = true;
                                break;
                        }
                    } else {
                        deque.offer(t);
                        z2 = false;
                    }
                }
                if (z2) {
                    if (this.onOverflow != null) {
                        try {
                            this.onOverflow.run();
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.H(th);
                            this.s.cancel();
                            onError(th);
                        }
                    }
                } else if (z) {
                    this.s.cancel();
                    onError(new MissingBackpressureException());
                } else {
                    drain();
                }
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
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
            this.cancelled = true;
            this.s.cancel();
            if (getAndIncrement() == 0) {
                clear(this.deque);
            }
        }

        void clear(Deque<T> deque) {
            synchronized (deque) {
                deque.clear();
            }
        }

        void drain() {
            boolean isEmpty;
            T poll;
            if (getAndIncrement() == 0) {
                Deque<T> deque = this.deque;
                org.a.c<? super T> cVar = this.actual;
                int i = 1;
                do {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (j2 != j) {
                        if (this.cancelled) {
                            clear(deque);
                            return;
                        }
                        boolean z = this.done;
                        synchronized (deque) {
                            poll = deque.poll();
                        }
                        boolean z2 = poll == null;
                        if (z) {
                            Throwable th = this.error;
                            if (th != null) {
                                clear(deque);
                                cVar.onError(th);
                                return;
                            } else if (z2) {
                                cVar.onComplete();
                                return;
                            }
                        }
                        if (z2) {
                            break;
                        }
                        cVar.onNext(poll);
                        j2 = 1 + j2;
                    }
                    if (j2 == j) {
                        if (this.cancelled) {
                            clear(deque);
                            return;
                        }
                        boolean z3 = this.done;
                        synchronized (deque) {
                            isEmpty = deque.isEmpty();
                        }
                        if (z3) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                clear(deque);
                                cVar.onError(th2);
                                return;
                            } else if (isEmpty) {
                                cVar.onComplete();
                                return;
                            }
                        }
                    }
                    if (j2 != 0) {
                        io.reactivex.internal.util.b.c(this.requested, j2);
                    }
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }
    }
}
