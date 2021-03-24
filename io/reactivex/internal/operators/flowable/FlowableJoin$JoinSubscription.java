package io.reactivex.internal.operators.flowable;

import f.a.e;
import f.a.t.a;
import f.a.w.h;
import f.a.x.c.f;
import f.a.x.e.a.g;
import g.d.b;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableJoin$JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements d, g {
    public static final long serialVersionUID = -6071216598687999801L;
    public final c<? super R> actual;
    public volatile boolean cancelled;
    public final h<? super TLeft, ? extends b<TLeftEnd>> leftEnd;
    public int leftIndex;
    public final f.a.w.c<? super TLeft, ? super TRight, ? extends R> resultSelector;
    public final h<? super TRight, ? extends b<TRightEnd>> rightEnd;
    public int rightIndex;
    public static final Integer LEFT_VALUE = 1;
    public static final Integer RIGHT_VALUE = 2;
    public static final Integer LEFT_CLOSE = 3;
    public static final Integer RIGHT_CLOSE = 4;
    public final AtomicLong requested = new AtomicLong();
    public final a disposables = new a();
    public final f.a.x.f.a<Object> queue = new f.a.x.f.a<>(e.a());
    public final Map<Integer, TLeft> lefts = new LinkedHashMap();
    public final Map<Integer, TRight> rights = new LinkedHashMap();
    public final AtomicReference<Throwable> error = new AtomicReference<>();
    public final AtomicInteger active = new AtomicInteger(2);

    public FlowableJoin$JoinSubscription(c<? super R> cVar, h<? super TLeft, ? extends b<TLeftEnd>> hVar, h<? super TRight, ? extends b<TRightEnd>> hVar2, f.a.w.c<? super TLeft, ? super TRight, ? extends R> cVar2) {
        this.actual = cVar;
        this.leftEnd = hVar;
        this.rightEnd = hVar2;
        this.resultSelector = cVar2;
    }

    @Override // g.d.d
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        cancelAll();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public void cancelAll() {
        this.disposables.dispose();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: java.util.Map<java.lang.Integer, TRight> */
    /* JADX DEBUG: Multi-variable search result rejected for r7v8, resolved type: java.util.Map<java.lang.Integer, TLeft> */
    /* JADX WARN: Multi-variable type inference failed */
    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        f.a.x.f.a<Object> aVar = this.queue;
        c<? super R> cVar = this.actual;
        boolean z = true;
        int i = 1;
        while (!this.cancelled) {
            if (this.error.get() != null) {
                aVar.clear();
                cancelAll();
                errorAll(cVar);
                return;
            }
            boolean z2 = this.active.get() == 0;
            Integer num = (Integer) aVar.poll();
            boolean z3 = num == null;
            if (z2 && z3) {
                this.lefts.clear();
                this.rights.clear();
                this.disposables.dispose();
                cVar.onComplete();
                return;
            } else if (z3) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                Object poll = aVar.poll();
                if (num == LEFT_VALUE) {
                    int i2 = this.leftIndex;
                    this.leftIndex = i2 + 1;
                    this.lefts.put(Integer.valueOf(i2), poll);
                    try {
                        b apply = this.leftEnd.apply(poll);
                        f.a.x.b.a.b(apply, "The leftEnd returned a null Publisher");
                        b bVar = apply;
                        FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber = new FlowableGroupJoin$LeftRightEndSubscriber(this, z, i2);
                        this.disposables.b(flowableGroupJoin$LeftRightEndSubscriber);
                        bVar.subscribe(flowableGroupJoin$LeftRightEndSubscriber);
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
                                Object obj = (R) this.resultSelector.apply(poll, tright);
                                f.a.x.b.a.b(obj, "The resultSelector returned a null value");
                                if (j2 != j) {
                                    cVar.onNext(obj);
                                    j2++;
                                } else {
                                    ExceptionHelper.a(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
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
                            f.a.x.i.b.e(this.requested, j2);
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
                        b apply2 = this.rightEnd.apply(poll);
                        f.a.x.b.a.b(apply2, "The rightEnd returned a null Publisher");
                        b bVar2 = apply2;
                        FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber2 = new FlowableGroupJoin$LeftRightEndSubscriber(this, false, i3);
                        this.disposables.b(flowableGroupJoin$LeftRightEndSubscriber2);
                        bVar2.subscribe(flowableGroupJoin$LeftRightEndSubscriber2);
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
                                Object obj2 = (R) this.resultSelector.apply(tleft, poll);
                                f.a.x.b.a.b(obj2, "The resultSelector returned a null value");
                                if (j4 != j3) {
                                    cVar.onNext(obj2);
                                    j4++;
                                } else {
                                    ExceptionHelper.a(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
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
                            f.a.x.i.b.e(this.requested, j4);
                        }
                    } catch (Throwable th4) {
                        fail(th4, cVar, aVar);
                        return;
                    }
                } else if (num == LEFT_CLOSE) {
                    FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber3 = (FlowableGroupJoin$LeftRightEndSubscriber) poll;
                    this.lefts.remove(Integer.valueOf(flowableGroupJoin$LeftRightEndSubscriber3.index));
                    this.disposables.a(flowableGroupJoin$LeftRightEndSubscriber3);
                } else if (num == RIGHT_CLOSE) {
                    FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber4 = (FlowableGroupJoin$LeftRightEndSubscriber) poll;
                    this.rights.remove(Integer.valueOf(flowableGroupJoin$LeftRightEndSubscriber4.index));
                    this.disposables.a(flowableGroupJoin$LeftRightEndSubscriber4);
                }
                z = true;
            }
        }
        aVar.clear();
    }

    public void errorAll(c<?> cVar) {
        Throwable b2 = ExceptionHelper.b(this.error);
        this.lefts.clear();
        this.rights.clear();
        cVar.onError(b2);
    }

    public void fail(Throwable th, c<?> cVar, f<?> fVar) {
        f.a.u.a.a(th);
        ExceptionHelper.a(this.error, th);
        fVar.clear();
        cancelAll();
        errorAll(cVar);
    }

    @Override // f.a.x.e.a.g
    public void innerClose(boolean z, FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber) {
        synchronized (this) {
            this.queue.l(z ? LEFT_CLOSE : RIGHT_CLOSE, flowableGroupJoin$LeftRightEndSubscriber);
        }
        drain();
    }

    @Override // f.a.x.e.a.g
    public void innerCloseError(Throwable th) {
        if (ExceptionHelper.a(this.error, th)) {
            drain();
        } else {
            f.a.a0.a.f(th);
        }
    }

    @Override // f.a.x.e.a.g
    public void innerComplete(FlowableGroupJoin$LeftRightSubscriber flowableGroupJoin$LeftRightSubscriber) {
        this.disposables.c(flowableGroupJoin$LeftRightSubscriber);
        this.active.decrementAndGet();
        drain();
    }

    @Override // f.a.x.e.a.g
    public void innerError(Throwable th) {
        if (ExceptionHelper.a(this.error, th)) {
            this.active.decrementAndGet();
            drain();
            return;
        }
        f.a.a0.a.f(th);
    }

    @Override // f.a.x.e.a.g
    public void innerValue(boolean z, Object obj) {
        synchronized (this) {
            this.queue.l(z ? LEFT_VALUE : RIGHT_VALUE, obj);
        }
        drain();
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            f.a.x.i.b.a(this.requested, j);
        }
    }
}
