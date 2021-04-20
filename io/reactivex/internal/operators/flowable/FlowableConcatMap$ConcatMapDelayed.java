package io.reactivex.internal.operators.flowable;

import f.b.w.h;
import f.b.x.b.a;
import f.b.x.e.a.e;
import g.d.b;
import g.d.c;
import java.util.concurrent.Callable;
/* loaded from: classes7.dex */
public final class FlowableConcatMap$ConcatMapDelayed<T, R> extends FlowableConcatMap$BaseConcatMapSubscriber<T, R> {
    public static final long serialVersionUID = -2945777694260521066L;
    public final c<? super R> actual;
    public final boolean veryEnd;

    public FlowableConcatMap$ConcatMapDelayed(c<? super R> cVar, h<? super T, ? extends b<? extends R>> hVar, int i, boolean z) {
        super(hVar, i);
        this.actual = cVar;
        this.veryEnd = z;
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
        if (getAndIncrement() == 0) {
            while (!this.cancelled) {
                if (!this.active) {
                    boolean z = this.done;
                    if (z && !this.veryEnd && this.errors.get() != null) {
                        this.actual.onError(this.errors.terminate());
                        return;
                    }
                    try {
                        T poll = this.queue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable terminate = this.errors.terminate();
                            if (terminate != null) {
                                this.actual.onError(terminate);
                                return;
                            } else {
                                this.actual.onComplete();
                                return;
                            }
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
                                            this.actual.onNext(call);
                                        } else {
                                            this.active = true;
                                            FlowableConcatMap$ConcatMapInner<R> flowableConcatMap$ConcatMapInner = this.inner;
                                            flowableConcatMap$ConcatMapInner.setSubscription(new e(call, flowableConcatMap$ConcatMapInner));
                                        }
                                    } catch (Throwable th) {
                                        f.b.u.a.a(th);
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
                                f.b.u.a.a(th2);
                                this.s.cancel();
                                this.errors.addThrowable(th2);
                                this.actual.onError(this.errors.terminate());
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        f.b.u.a.a(th3);
                        this.s.cancel();
                        this.errors.addThrowable(th3);
                        this.actual.onError(this.errors.terminate());
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, f.b.x.e.a.d
    public void innerError(Throwable th) {
        if (this.errors.addThrowable(th)) {
            if (!this.veryEnd) {
                this.s.cancel();
                this.done = true;
            }
            this.active = false;
            drain();
            return;
        }
        f.b.a0.a.f(th);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, f.b.x.e.a.d
    public void innerNext(R r) {
        this.actual.onNext(r);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber, g.d.c
    public void onError(Throwable th) {
        if (this.errors.addThrowable(th)) {
            this.done = true;
            drain();
            return;
        }
        f.b.a0.a.f(th);
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
