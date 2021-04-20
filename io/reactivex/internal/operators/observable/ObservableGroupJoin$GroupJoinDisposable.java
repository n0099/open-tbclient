package io.reactivex.internal.operators.observable;

import f.b.l;
import f.b.n;
import f.b.o;
import f.b.t.a;
import f.b.t.b;
import f.b.w.c;
import f.b.w.h;
import f.b.x.e.c.f;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableGroupJoin$GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements b, f {
    public static final long serialVersionUID = -6071216598687999801L;
    public final o<? super R> actual;
    public volatile boolean cancelled;
    public final h<? super TLeft, ? extends n<TLeftEnd>> leftEnd;
    public int leftIndex;
    public final c<? super TLeft, ? super l<TRight>, ? extends R> resultSelector;
    public final h<? super TRight, ? extends n<TRightEnd>> rightEnd;
    public int rightIndex;
    public static final Integer LEFT_VALUE = 1;
    public static final Integer RIGHT_VALUE = 2;
    public static final Integer LEFT_CLOSE = 3;
    public static final Integer RIGHT_CLOSE = 4;
    public final a disposables = new a();
    public final f.b.x.f.a<Object> queue = new f.b.x.f.a<>(l.a());
    public final Map<Integer, UnicastSubject<TRight>> lefts = new LinkedHashMap();
    public final Map<Integer, TRight> rights = new LinkedHashMap();
    public final AtomicReference<Throwable> error = new AtomicReference<>();
    public final AtomicInteger active = new AtomicInteger(2);

    public ObservableGroupJoin$GroupJoinDisposable(o<? super R> oVar, h<? super TLeft, ? extends n<TLeftEnd>> hVar, h<? super TRight, ? extends n<TRightEnd>> hVar2, c<? super TLeft, ? super l<TRight>, ? extends R> cVar) {
        this.actual = oVar;
        this.leftEnd = hVar;
        this.rightEnd = hVar2;
        this.resultSelector = cVar;
    }

    public void cancelAll() {
        this.disposables.dispose();
    }

    @Override // f.b.t.b
    public void dispose() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        cancelAll();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v10, resolved type: java.util.Map<java.lang.Integer, TRight> */
    /* JADX WARN: Multi-variable type inference failed */
    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        f.b.x.f.a<?> aVar = this.queue;
        o<? super R> oVar = this.actual;
        int i = 1;
        while (!this.cancelled) {
            if (this.error.get() != null) {
                aVar.clear();
                cancelAll();
                errorAll(oVar);
                return;
            }
            boolean z = this.active.get() == 0;
            Integer num = (Integer) aVar.poll();
            boolean z2 = num == null;
            if (z && z2) {
                for (UnicastSubject<TRight> unicastSubject : this.lefts.values()) {
                    unicastSubject.onComplete();
                }
                this.lefts.clear();
                this.rights.clear();
                this.disposables.dispose();
                oVar.onComplete();
                return;
            } else if (z2) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                Object poll = aVar.poll();
                if (num == LEFT_VALUE) {
                    UnicastSubject<TRight> c2 = UnicastSubject.c();
                    int i2 = this.leftIndex;
                    this.leftIndex = i2 + 1;
                    this.lefts.put(Integer.valueOf(i2), c2);
                    try {
                        n apply = this.leftEnd.apply(poll);
                        f.b.x.b.a.b(apply, "The leftEnd returned a null ObservableSource");
                        n nVar = apply;
                        ObservableGroupJoin$LeftRightEndObserver observableGroupJoin$LeftRightEndObserver = new ObservableGroupJoin$LeftRightEndObserver(this, true, i2);
                        this.disposables.b(observableGroupJoin$LeftRightEndObserver);
                        nVar.subscribe(observableGroupJoin$LeftRightEndObserver);
                        if (this.error.get() != null) {
                            aVar.clear();
                            cancelAll();
                            errorAll(oVar);
                            return;
                        }
                        try {
                            Object obj = (R) this.resultSelector.apply(poll, c2);
                            f.b.x.b.a.b(obj, "The resultSelector returned a null value");
                            oVar.onNext(obj);
                            for (TRight tright : this.rights.values()) {
                                c2.onNext(tright);
                            }
                        } catch (Throwable th) {
                            fail(th, oVar, aVar);
                            return;
                        }
                    } catch (Throwable th2) {
                        fail(th2, oVar, aVar);
                        return;
                    }
                } else if (num == RIGHT_VALUE) {
                    int i3 = this.rightIndex;
                    this.rightIndex = i3 + 1;
                    this.rights.put(Integer.valueOf(i3), poll);
                    try {
                        n apply2 = this.rightEnd.apply(poll);
                        f.b.x.b.a.b(apply2, "The rightEnd returned a null ObservableSource");
                        n nVar2 = apply2;
                        ObservableGroupJoin$LeftRightEndObserver observableGroupJoin$LeftRightEndObserver2 = new ObservableGroupJoin$LeftRightEndObserver(this, false, i3);
                        this.disposables.b(observableGroupJoin$LeftRightEndObserver2);
                        nVar2.subscribe(observableGroupJoin$LeftRightEndObserver2);
                        if (this.error.get() != null) {
                            aVar.clear();
                            cancelAll();
                            errorAll(oVar);
                            return;
                        }
                        for (UnicastSubject<TRight> unicastSubject2 : this.lefts.values()) {
                            unicastSubject2.onNext(poll);
                        }
                    } catch (Throwable th3) {
                        fail(th3, oVar, aVar);
                        return;
                    }
                } else if (num == LEFT_CLOSE) {
                    ObservableGroupJoin$LeftRightEndObserver observableGroupJoin$LeftRightEndObserver3 = (ObservableGroupJoin$LeftRightEndObserver) poll;
                    UnicastSubject<TRight> remove = this.lefts.remove(Integer.valueOf(observableGroupJoin$LeftRightEndObserver3.index));
                    this.disposables.a(observableGroupJoin$LeftRightEndObserver3);
                    if (remove != null) {
                        remove.onComplete();
                    }
                } else if (num == RIGHT_CLOSE) {
                    ObservableGroupJoin$LeftRightEndObserver observableGroupJoin$LeftRightEndObserver4 = (ObservableGroupJoin$LeftRightEndObserver) poll;
                    this.rights.remove(Integer.valueOf(observableGroupJoin$LeftRightEndObserver4.index));
                    this.disposables.a(observableGroupJoin$LeftRightEndObserver4);
                }
            }
        }
        aVar.clear();
    }

    public void errorAll(o<?> oVar) {
        Throwable b2 = ExceptionHelper.b(this.error);
        for (UnicastSubject<TRight> unicastSubject : this.lefts.values()) {
            unicastSubject.onError(b2);
        }
        this.lefts.clear();
        this.rights.clear();
        oVar.onError(b2);
    }

    public void fail(Throwable th, o<?> oVar, f.b.x.f.a<?> aVar) {
        f.b.u.a.a(th);
        ExceptionHelper.a(this.error, th);
        aVar.clear();
        cancelAll();
        errorAll(oVar);
    }

    @Override // f.b.x.e.c.f
    public void innerClose(boolean z, ObservableGroupJoin$LeftRightEndObserver observableGroupJoin$LeftRightEndObserver) {
        synchronized (this) {
            this.queue.l(z ? LEFT_CLOSE : RIGHT_CLOSE, observableGroupJoin$LeftRightEndObserver);
        }
        drain();
    }

    @Override // f.b.x.e.c.f
    public void innerCloseError(Throwable th) {
        if (ExceptionHelper.a(this.error, th)) {
            drain();
        } else {
            f.b.a0.a.f(th);
        }
    }

    @Override // f.b.x.e.c.f
    public void innerComplete(ObservableGroupJoin$LeftRightObserver observableGroupJoin$LeftRightObserver) {
        this.disposables.c(observableGroupJoin$LeftRightObserver);
        this.active.decrementAndGet();
        drain();
    }

    @Override // f.b.x.e.c.f
    public void innerError(Throwable th) {
        if (ExceptionHelper.a(this.error, th)) {
            this.active.decrementAndGet();
            drain();
            return;
        }
        f.b.a0.a.f(th);
    }

    @Override // f.b.x.e.c.f
    public void innerValue(boolean z, Object obj) {
        synchronized (this) {
            this.queue.l(z ? LEFT_VALUE : RIGHT_VALUE, obj);
        }
        drain();
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.cancelled;
    }
}
