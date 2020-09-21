package io.reactivex.internal.operators.flowable;

import io.reactivex.c.h;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.j;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes25.dex */
public final class FlowableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends a<TLeft, R> {
    final h<? super TLeft, ? extends org.a.b<TLeftEnd>> leftEnd;
    final org.a.b<? extends TRight> oxd;
    final io.reactivex.c.c<? super TLeft, ? super TRight, ? extends R> resultSelector;
    final h<? super TRight, ? extends org.a.b<TRightEnd>> rightEnd;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super R> cVar) {
        JoinSubscription joinSubscription = new JoinSubscription(cVar, this.leftEnd, this.rightEnd, this.resultSelector);
        cVar.onSubscribe(joinSubscription);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, true);
        joinSubscription.disposables.a(leftRightSubscriber);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber2 = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, false);
        joinSubscription.disposables.a(leftRightSubscriber2);
        this.owE.a((j) leftRightSubscriber);
        this.oxd.subscribe(leftRightSubscriber2);
    }

    /* loaded from: classes25.dex */
    static final class JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements FlowableGroupJoin.a, org.a.d {
        private static final long serialVersionUID = -6071216598687999801L;
        final org.a.c<? super R> actual;
        volatile boolean cancelled;
        final h<? super TLeft, ? extends org.a.b<TLeftEnd>> leftEnd;
        int leftIndex;
        final io.reactivex.c.c<? super TLeft, ? super TRight, ? extends R> resultSelector;
        final h<? super TRight, ? extends org.a.b<TRightEnd>> rightEnd;
        int rightIndex;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;
        final AtomicLong requested = new AtomicLong();
        final io.reactivex.disposables.a disposables = new io.reactivex.disposables.a();
        final io.reactivex.internal.queue.a<Object> queue = new io.reactivex.internal.queue.a<>(io.reactivex.g.eiV());
        final Map<Integer, TLeft> lefts = new LinkedHashMap();
        final Map<Integer, TRight> rights = new LinkedHashMap();
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger active = new AtomicInteger(2);

        JoinSubscription(org.a.c<? super R> cVar, h<? super TLeft, ? extends org.a.b<TLeftEnd>> hVar, h<? super TRight, ? extends org.a.b<TRightEnd>> hVar2, io.reactivex.c.c<? super TLeft, ? super TRight, ? extends R> cVar2) {
            this.actual = cVar;
            this.leftEnd = hVar;
            this.rightEnd = hVar2;
            this.resultSelector = cVar2;
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelAll();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        void cancelAll() {
            this.disposables.dispose();
        }

        void errorAll(org.a.c<?> cVar) {
            Throwable terminate = ExceptionHelper.terminate(this.error);
            this.lefts.clear();
            this.rights.clear();
            cVar.onError(terminate);
        }

        void fail(Throwable th, org.a.c<?> cVar, io.reactivex.internal.a.g<?> gVar) {
            io.reactivex.exceptions.a.J(th);
            ExceptionHelper.addThrowable(this.error, th);
            gVar.clear();
            cancelAll();
            errorAll(cVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: java.util.Map<java.lang.Integer, TLeft> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v33, resolved type: java.util.Map<java.lang.Integer, TRight> */
        /* JADX WARN: Multi-variable type inference failed */
        void drain() {
            if (getAndIncrement() == 0) {
                io.reactivex.internal.queue.a<Object> aVar = this.queue;
                org.a.c<? super R> cVar = this.actual;
                int i = 1;
                while (!this.cancelled) {
                    if (this.error.get() != null) {
                        aVar.clear();
                        cancelAll();
                        errorAll(cVar);
                        return;
                    }
                    boolean z = this.active.get() == 0;
                    Integer num = (Integer) aVar.poll();
                    boolean z2 = num == null;
                    if (z && z2) {
                        this.lefts.clear();
                        this.rights.clear();
                        this.disposables.dispose();
                        cVar.onComplete();
                        return;
                    } else if (!z2) {
                        Object poll = aVar.poll();
                        if (num == LEFT_VALUE) {
                            int i2 = this.leftIndex;
                            this.leftIndex = i2 + 1;
                            this.lefts.put(Integer.valueOf(i2), poll);
                            try {
                                org.a.b bVar = (org.a.b) io.reactivex.internal.functions.a.k(this.leftEnd.apply(poll), "The leftEnd returned a null Publisher");
                                FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber = new FlowableGroupJoin.LeftRightEndSubscriber(this, true, i2);
                                this.disposables.a(leftRightEndSubscriber);
                                bVar.subscribe(leftRightEndSubscriber);
                                if (this.error.get() != null) {
                                    aVar.clear();
                                    cancelAll();
                                    errorAll(cVar);
                                    return;
                                }
                                long j = this.requested.get();
                                long j2 = 0;
                                for (TRight tright : this.rights.values()) {
                                    try {
                                        Object obj = (Object) io.reactivex.internal.functions.a.k(this.resultSelector.apply(poll, tright), "The resultSelector returned a null value");
                                        if (j2 != j) {
                                            cVar.onNext(obj);
                                            j2++;
                                        } else {
                                            ExceptionHelper.addThrowable(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                            aVar.clear();
                                            cancelAll();
                                            errorAll(cVar);
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        fail(th, cVar, aVar);
                                        return;
                                    }
                                }
                                if (j2 != 0) {
                                    io.reactivex.internal.util.b.c(this.requested, j2);
                                }
                            } catch (Throwable th2) {
                                fail(th2, cVar, aVar);
                                return;
                            }
                        } else if (num == RIGHT_VALUE) {
                            int i3 = this.rightIndex;
                            this.rightIndex = i3 + 1;
                            this.rights.put(Integer.valueOf(i3), poll);
                            try {
                                org.a.b bVar2 = (org.a.b) io.reactivex.internal.functions.a.k(this.rightEnd.apply(poll), "The rightEnd returned a null Publisher");
                                FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber2 = new FlowableGroupJoin.LeftRightEndSubscriber(this, false, i3);
                                this.disposables.a(leftRightEndSubscriber2);
                                bVar2.subscribe(leftRightEndSubscriber2);
                                if (this.error.get() != null) {
                                    aVar.clear();
                                    cancelAll();
                                    errorAll(cVar);
                                    return;
                                }
                                long j3 = this.requested.get();
                                long j4 = 0;
                                for (TLeft tleft : this.lefts.values()) {
                                    try {
                                        Object obj2 = (Object) io.reactivex.internal.functions.a.k(this.resultSelector.apply(tleft, poll), "The resultSelector returned a null value");
                                        if (j4 != j3) {
                                            cVar.onNext(obj2);
                                            j4++;
                                        } else {
                                            ExceptionHelper.addThrowable(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                            aVar.clear();
                                            cancelAll();
                                            errorAll(cVar);
                                            return;
                                        }
                                    } catch (Throwable th3) {
                                        fail(th3, cVar, aVar);
                                        return;
                                    }
                                }
                                if (j4 != 0) {
                                    io.reactivex.internal.util.b.c(this.requested, j4);
                                }
                            } catch (Throwable th4) {
                                fail(th4, cVar, aVar);
                                return;
                            }
                        } else if (num == LEFT_CLOSE) {
                            FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber3 = (FlowableGroupJoin.LeftRightEndSubscriber) poll;
                            this.lefts.remove(Integer.valueOf(leftRightEndSubscriber3.index));
                            this.disposables.b(leftRightEndSubscriber3);
                        } else if (num == RIGHT_CLOSE) {
                            FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber4 = (FlowableGroupJoin.LeftRightEndSubscriber) poll;
                            this.rights.remove(Integer.valueOf(leftRightEndSubscriber4.index));
                            this.disposables.b(leftRightEndSubscriber4);
                        }
                    } else {
                        int addAndGet = addAndGet(-i);
                        if (addAndGet == 0) {
                            return;
                        }
                        i = addAndGet;
                    }
                }
                aVar.clear();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.a
        public void innerError(Throwable th) {
            if (ExceptionHelper.addThrowable(this.error, th)) {
                this.active.decrementAndGet();
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.a
        public void innerComplete(FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber) {
            this.disposables.c(leftRightSubscriber);
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.a
        public void innerValue(boolean z, Object obj) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_VALUE : RIGHT_VALUE, obj);
            }
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.a
        public void innerClose(boolean z, FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_CLOSE : RIGHT_CLOSE, leftRightEndSubscriber);
            }
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.a
        public void innerCloseError(Throwable th) {
            if (ExceptionHelper.addThrowable(this.error, th)) {
                drain();
            } else {
                io.reactivex.e.a.onError(th);
            }
        }
    }
}
