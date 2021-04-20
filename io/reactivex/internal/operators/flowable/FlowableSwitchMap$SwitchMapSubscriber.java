package io.reactivex.internal.operators.flowable;

import f.b.g;
import f.b.u.a;
import f.b.w.h;
import f.b.x.c.f;
import g.d.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableSwitchMap$SwitchMapSubscriber<T, R> extends AtomicInteger implements g<T>, d {
    public static final FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> CANCELLED;
    public static final long serialVersionUID = -3491074160481096299L;
    public final c<? super R> actual;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final h<? super T, ? extends b<? extends R>> mapper;
    public d s;
    public volatile long unique;
    public final AtomicReference<FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> active = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicThrowable error = new AtomicThrowable();

    static {
        FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> flowableSwitchMap$SwitchMapInnerSubscriber = new FlowableSwitchMap$SwitchMapInnerSubscriber<>(null, -1L, 1);
        CANCELLED = flowableSwitchMap$SwitchMapInnerSubscriber;
        flowableSwitchMap$SwitchMapInnerSubscriber.cancel();
    }

    public FlowableSwitchMap$SwitchMapSubscriber(c<? super R> cVar, h<? super T, ? extends b<? extends R>> hVar, int i, boolean z) {
        this.actual = cVar;
        this.mapper = hVar;
        this.bufferSize = i;
        this.delayErrors = z;
    }

    @Override // g.d.d
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.s.cancel();
        disposeInner();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public void disposeInner() {
        FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> flowableSwitchMap$SwitchMapInnerSubscriber;
        FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> flowableSwitchMap$SwitchMapInnerSubscriber2 = this.active.get();
        FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> flowableSwitchMap$SwitchMapInnerSubscriber3 = CANCELLED;
        if (flowableSwitchMap$SwitchMapInnerSubscriber2 == flowableSwitchMap$SwitchMapInnerSubscriber3 || (flowableSwitchMap$SwitchMapInnerSubscriber = (FlowableSwitchMap$SwitchMapInnerSubscriber) this.active.getAndSet(flowableSwitchMap$SwitchMapInnerSubscriber3)) == CANCELLED || flowableSwitchMap$SwitchMapInnerSubscriber == null) {
            return;
        }
        flowableSwitchMap$SwitchMapInnerSubscriber.cancel();
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x000c, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e5, code lost:
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x011d, code lost:
        if (r12 == 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0121, code lost:
        if (r17.cancelled != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x012a, code lost:
        if (r8 == Long.MAX_VALUE) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x012c, code lost:
        r17.requested.addAndGet(-r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0132, code lost:
        r6.get().request(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x013b, code lost:
        if (r14 == false) goto L77;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        R r;
        if (getAndIncrement() != 0) {
            return;
        }
        c<? super R> cVar = this.actual;
        int i = 1;
        while (!this.cancelled) {
            if (this.done) {
                if (this.delayErrors) {
                    if (this.active.get() == null) {
                        if (this.error.get() != null) {
                            cVar.onError(this.error.terminate());
                            return;
                        } else {
                            cVar.onComplete();
                            return;
                        }
                    }
                } else if (this.error.get() != null) {
                    disposeInner();
                    cVar.onError(this.error.terminate());
                    return;
                } else if (this.active.get() == null) {
                    cVar.onComplete();
                    return;
                }
            }
            FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> flowableSwitchMap$SwitchMapInnerSubscriber = this.active.get();
            f<R> fVar = flowableSwitchMap$SwitchMapInnerSubscriber != null ? flowableSwitchMap$SwitchMapInnerSubscriber.queue : null;
            if (fVar != null) {
                if (flowableSwitchMap$SwitchMapInnerSubscriber.done) {
                    if (!this.delayErrors) {
                        if (this.error.get() != null) {
                            disposeInner();
                            cVar.onError(this.error.terminate());
                            return;
                        } else if (fVar.isEmpty()) {
                            this.active.compareAndSet(flowableSwitchMap$SwitchMapInnerSubscriber, null);
                        }
                    } else if (fVar.isEmpty()) {
                        this.active.compareAndSet(flowableSwitchMap$SwitchMapInnerSubscriber, null);
                    }
                }
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    boolean z = false;
                    if (j2 != j) {
                        if (!this.cancelled) {
                            boolean z2 = flowableSwitchMap$SwitchMapInnerSubscriber.done;
                            try {
                                r = fVar.poll();
                            } catch (Throwable th) {
                                a.a(th);
                                flowableSwitchMap$SwitchMapInnerSubscriber.cancel();
                                this.error.addThrowable(th);
                                r = (Object) null;
                                z2 = true;
                            }
                            boolean z3 = r == null;
                            if (flowableSwitchMap$SwitchMapInnerSubscriber != this.active.get()) {
                                break;
                            }
                            if (z2) {
                                if (!this.delayErrors) {
                                    if (this.error.get() == null) {
                                        if (z3) {
                                            this.active.compareAndSet(flowableSwitchMap$SwitchMapInnerSubscriber, null);
                                            break;
                                        }
                                    } else {
                                        cVar.onError(this.error.terminate());
                                        return;
                                    }
                                } else if (z3) {
                                    this.active.compareAndSet(flowableSwitchMap$SwitchMapInnerSubscriber, null);
                                    break;
                                }
                            }
                            if (z3) {
                                break;
                            }
                            cVar.onNext(r);
                            j2++;
                        } else {
                            return;
                        }
                    } else {
                        break;
                    }
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        this.active.lazySet(null);
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (!this.done && this.error.addThrowable(th)) {
            if (!this.delayErrors) {
                disposeInner();
            }
            this.done = true;
            drain();
            return;
        }
        f.b.a0.a.f(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> flowableSwitchMap$SwitchMapInnerSubscriber;
        if (this.done) {
            return;
        }
        long j = this.unique + 1;
        this.unique = j;
        FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> flowableSwitchMap$SwitchMapInnerSubscriber2 = this.active.get();
        if (flowableSwitchMap$SwitchMapInnerSubscriber2 != null) {
            flowableSwitchMap$SwitchMapInnerSubscriber2.cancel();
        }
        try {
            b<? extends R> apply = this.mapper.apply(t);
            f.b.x.b.a.b(apply, "The publisher returned is null");
            b<? extends R> bVar = apply;
            FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> flowableSwitchMap$SwitchMapInnerSubscriber3 = new FlowableSwitchMap$SwitchMapInnerSubscriber<>(this, j, this.bufferSize);
            do {
                flowableSwitchMap$SwitchMapInnerSubscriber = this.active.get();
                if (flowableSwitchMap$SwitchMapInnerSubscriber == CANCELLED) {
                    return;
                }
            } while (!this.active.compareAndSet(flowableSwitchMap$SwitchMapInnerSubscriber, flowableSwitchMap$SwitchMapInnerSubscriber3));
            bVar.subscribe(flowableSwitchMap$SwitchMapInnerSubscriber3);
        } catch (Throwable th) {
            a.a(th);
            this.s.cancel();
            onError(th);
        }
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            f.b.x.i.b.a(this.requested, j);
            if (this.unique == 0) {
                this.s.request(Long.MAX_VALUE);
            } else {
                drain();
            }
        }
    }
}
