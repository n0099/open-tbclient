package io.reactivex.internal.operators.flowable;

import f.b.e;
import f.b.t.a;
import f.b.w.h;
import f.b.x.c.f;
import f.b.x.e.a.g;
import g.d.b;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableGroupJoin$GroupJoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements d, g {
    public static final long serialVersionUID = -6071216598687999801L;
    public final c<? super R> actual;
    public volatile boolean cancelled;
    public final h<? super TLeft, ? extends b<TLeftEnd>> leftEnd;
    public int leftIndex;
    public final f.b.w.c<? super TLeft, ? super e<TRight>, ? extends R> resultSelector;
    public final h<? super TRight, ? extends b<TRightEnd>> rightEnd;
    public int rightIndex;
    public static final Integer LEFT_VALUE = 1;
    public static final Integer RIGHT_VALUE = 2;
    public static final Integer LEFT_CLOSE = 3;
    public static final Integer RIGHT_CLOSE = 4;
    public final AtomicLong requested = new AtomicLong();
    public final a disposables = new a();
    public final f.b.x.f.a<Object> queue = new f.b.x.f.a<>(e.a());
    public final Map<Integer, UnicastProcessor<TRight>> lefts = new LinkedHashMap();
    public final Map<Integer, TRight> rights = new LinkedHashMap();
    public final AtomicReference<Throwable> error = new AtomicReference<>();
    public final AtomicInteger active = new AtomicInteger(2);

    public FlowableGroupJoin$GroupJoinSubscription(c<? super R> cVar, h<? super TLeft, ? extends b<TLeftEnd>> hVar, h<? super TRight, ? extends b<TRightEnd>> hVar2, f.b.w.c<? super TLeft, ? super e<TRight>, ? extends R> cVar2) {
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

    /* JADX DEBUG: Multi-variable search result rejected for r7v10, resolved type: java.util.Map<java.lang.Integer, TRight> */
    /* JADX WARN: Multi-variable type inference failed */
    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        f.b.x.f.a<Object> aVar = this.queue;
        c<? super R> cVar = this.actual;
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
                for (UnicastProcessor<TRight> unicastProcessor : this.lefts.values()) {
                    unicastProcessor.onComplete();
                }
                this.lefts.clear();
                this.rights.clear();
                this.disposables.dispose();
                cVar.onComplete();
                return;
            } else if (z2) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                Object poll = aVar.poll();
                if (num == LEFT_VALUE) {
                    UnicastProcessor<TRight> e2 = UnicastProcessor.e();
                    int i2 = this.leftIndex;
                    this.leftIndex = i2 + 1;
                    this.lefts.put(Integer.valueOf(i2), e2);
                    try {
                        b apply = this.leftEnd.apply(poll);
                        f.b.x.b.a.b(apply, "The leftEnd returned a null Publisher");
                        b bVar = apply;
                        FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber = new FlowableGroupJoin$LeftRightEndSubscriber(this, true, i2);
                        this.disposables.b(flowableGroupJoin$LeftRightEndSubscriber);
                        bVar.subscribe(flowableGroupJoin$LeftRightEndSubscriber);
                        if (this.error.get() != null) {
                            aVar.clear();
                            cancelAll();
                            errorAll(cVar);
                            return;
                        }
                        try {
                            Object obj = (R) this.resultSelector.apply(poll, e2);
                            f.b.x.b.a.b(obj, "The resultSelector returned a null value");
                            if (this.requested.get() != 0) {
                                cVar.onNext(obj);
                                f.b.x.i.b.e(this.requested, 1L);
                                for (TRight tright : this.rights.values()) {
                                    e2.onNext(tright);
                                }
                            } else {
                                fail(new MissingBackpressureException("Could not emit value due to lack of requests"), cVar, aVar);
                                return;
                            }
                        } catch (Throwable th) {
                            fail(th, cVar, aVar);
                            return;
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
                        f.b.x.b.a.b(apply2, "The rightEnd returned a null Publisher");
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
                        for (UnicastProcessor<TRight> unicastProcessor2 : this.lefts.values()) {
                            unicastProcessor2.onNext(poll);
                        }
                    } catch (Throwable th3) {
                        fail(th3, cVar, aVar);
                        return;
                    }
                } else if (num == LEFT_CLOSE) {
                    FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber3 = (FlowableGroupJoin$LeftRightEndSubscriber) poll;
                    UnicastProcessor<TRight> remove = this.lefts.remove(Integer.valueOf(flowableGroupJoin$LeftRightEndSubscriber3.index));
                    this.disposables.a(flowableGroupJoin$LeftRightEndSubscriber3);
                    if (remove != null) {
                        remove.onComplete();
                    }
                } else if (num == RIGHT_CLOSE) {
                    FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber4 = (FlowableGroupJoin$LeftRightEndSubscriber) poll;
                    this.rights.remove(Integer.valueOf(flowableGroupJoin$LeftRightEndSubscriber4.index));
                    this.disposables.a(flowableGroupJoin$LeftRightEndSubscriber4);
                }
            }
        }
        aVar.clear();
    }

    public void errorAll(c<?> cVar) {
        Throwable b2 = ExceptionHelper.b(this.error);
        for (UnicastProcessor<TRight> unicastProcessor : this.lefts.values()) {
            unicastProcessor.onError(b2);
        }
        this.lefts.clear();
        this.rights.clear();
        cVar.onError(b2);
    }

    public void fail(Throwable th, c<?> cVar, f<?> fVar) {
        f.b.u.a.a(th);
        ExceptionHelper.a(this.error, th);
        fVar.clear();
        cancelAll();
        errorAll(cVar);
    }

    @Override // f.b.x.e.a.g
    public void innerClose(boolean z, FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber) {
        synchronized (this) {
            this.queue.l(z ? LEFT_CLOSE : RIGHT_CLOSE, flowableGroupJoin$LeftRightEndSubscriber);
        }
        drain();
    }

    @Override // f.b.x.e.a.g
    public void innerCloseError(Throwable th) {
        if (ExceptionHelper.a(this.error, th)) {
            drain();
        } else {
            f.b.a0.a.f(th);
        }
    }

    @Override // f.b.x.e.a.g
    public void innerComplete(FlowableGroupJoin$LeftRightSubscriber flowableGroupJoin$LeftRightSubscriber) {
        this.disposables.c(flowableGroupJoin$LeftRightSubscriber);
        this.active.decrementAndGet();
        drain();
    }

    @Override // f.b.x.e.a.g
    public void innerError(Throwable th) {
        if (ExceptionHelper.a(this.error, th)) {
            this.active.decrementAndGet();
            drain();
            return;
        }
        f.b.a0.a.f(th);
    }

    @Override // f.b.x.e.a.g
    public void innerValue(boolean z, Object obj) {
        synchronized (this) {
            this.queue.l(z ? LEFT_VALUE : RIGHT_VALUE, obj);
        }
        drain();
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            f.b.x.i.b.a(this.requested, j);
        }
    }
}
