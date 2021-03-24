package io.reactivex.internal.operators.flowable;

import f.a.w.h;
import f.a.x.b.a;
import f.a.x.e.a.e;
import g.d.b;
import g.d.c;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class FlowableConcatMap$ConcatMapImmediate<T, R> extends FlowableConcatMap$BaseConcatMapSubscriber<T, R> {
    public static final long serialVersionUID = 7898995095634264146L;
    public final c<? super R> actual;
    public final AtomicInteger wip;

    public FlowableConcatMap$ConcatMapImmediate(c<? super R> cVar, h<? super T, ? extends b<? extends R>> hVar, int i) {
        super(hVar, i);
        this.actual = cVar;
        this.wip = new AtomicInteger();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, g.d.d
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.inner.cancel();
        this.s.cancel();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber
    public void drain() {
        if (this.wip.getAndIncrement() == 0) {
            while (!this.cancelled) {
                if (!this.active) {
                    boolean z = this.done;
                    try {
                        T poll = this.queue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.actual.onComplete();
                            return;
                        } else if (!z2) {
                            try {
                                b<? extends R> apply = this.mapper.apply(poll);
                                a.b(apply, "The mapper returned a null Publisher");
                                b<? extends R> bVar = apply;
                                if (this.sourceMode != 1) {
                                    int i = this.consumed + 1;
                                    if (i == this.limit) {
                                        this.consumed = 0;
                                        this.s.request(i);
                                    } else {
                                        this.consumed = i;
                                    }
                                }
                                if (bVar instanceof Callable) {
                                    try {
                                        Object call = ((Callable) bVar).call();
                                        if (call == null) {
                                            continue;
                                        } else if (this.inner.isUnbounded()) {
                                            if (get() == 0 && compareAndSet(0, 1)) {
                                                this.actual.onNext(call);
                                                if (!compareAndSet(1, 0)) {
                                                    this.actual.onError(this.errors.terminate());
                                                    return;
                                                }
                                            }
                                        } else {
                                            this.active = true;
                                            FlowableConcatMap$ConcatMapInner<R> flowableConcatMap$ConcatMapInner = this.inner;
                                            flowableConcatMap$ConcatMapInner.setSubscription(new e(call, flowableConcatMap$ConcatMapInner));
                                        }
                                    } catch (Throwable th) {
                                        f.a.u.a.a(th);
                                        this.s.cancel();
                                        this.errors.addThrowable(th);
                                        this.actual.onError(this.errors.terminate());
                                        return;
                                    }
                                } else {
                                    this.active = true;
                                    bVar.subscribe(this.inner);
                                }
                            } catch (Throwable th2) {
                                f.a.u.a.a(th2);
                                this.s.cancel();
                                this.errors.addThrowable(th2);
                                this.actual.onError(this.errors.terminate());
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        f.a.u.a.a(th3);
                        this.s.cancel();
                        this.errors.addThrowable(th3);
                        this.actual.onError(this.errors.terminate());
                        return;
                    }
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, f.a.x.e.a.d
    public void innerError(Throwable th) {
        if (this.errors.addThrowable(th)) {
            this.s.cancel();
            if (getAndIncrement() == 0) {
                this.actual.onError(this.errors.terminate());
                return;
            }
            return;
        }
        f.a.a0.a.f(th);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, f.a.x.e.a.d
    public void innerNext(R r) {
        if (get() == 0 && compareAndSet(0, 1)) {
            this.actual.onNext(r);
            if (compareAndSet(1, 0)) {
                return;
            }
            this.actual.onError(this.errors.terminate());
        }
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, g.d.c
    public void onError(Throwable th) {
        if (this.errors.addThrowable(th)) {
            this.inner.cancel();
            if (getAndIncrement() == 0) {
                this.actual.onError(this.errors.terminate());
                return;
            }
            return;
        }
        f.a.a0.a.f(th);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, g.d.d
    public void request(long j) {
        this.inner.request(j);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber
    public void subscribeActual() {
        this.actual.onSubscribe(this);
    }
}
