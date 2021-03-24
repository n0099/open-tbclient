package io.reactivex.internal.operators.flowable;

import f.a.u.a;
import f.a.w.h;
import f.a.x.c.f;
import f.a.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableZip$ZipCoordinator<T, R> extends AtomicInteger implements d {
    public static final long serialVersionUID = -2434867452883857743L;
    public final c<? super R> actual;
    public volatile boolean cancelled;
    public final Object[] current;
    public final boolean delayErrors;
    public final AtomicThrowable errors;
    public final AtomicLong requested;
    public final FlowableZip$ZipSubscriber<T, R>[] subscribers;
    public final h<? super Object[], ? extends R> zipper;

    public FlowableZip$ZipCoordinator(c<? super R> cVar, h<? super Object[], ? extends R> hVar, int i, int i2, boolean z) {
        this.actual = cVar;
        this.zipper = hVar;
        this.delayErrors = z;
        FlowableZip$ZipSubscriber<T, R>[] flowableZip$ZipSubscriberArr = new FlowableZip$ZipSubscriber[i];
        for (int i3 = 0; i3 < i; i3++) {
            flowableZip$ZipSubscriberArr[i3] = new FlowableZip$ZipSubscriber<>(this, i2);
        }
        this.current = new Object[i];
        this.subscribers = flowableZip$ZipSubscriberArr;
        this.requested = new AtomicLong();
        this.errors = new AtomicThrowable();
    }

    @Override // g.d.d
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        cancelAll();
    }

    public void cancelAll() {
        for (FlowableZip$ZipSubscriber<T, R> flowableZip$ZipSubscriber : this.subscribers) {
            flowableZip$ZipSubscriber.cancel();
        }
    }

    public void drain() {
        boolean z;
        T poll;
        boolean z2;
        if (getAndIncrement() != 0) {
            return;
        }
        c<? super R> cVar = this.actual;
        FlowableZip$ZipSubscriber<T, R>[] flowableZip$ZipSubscriberArr = this.subscribers;
        int length = flowableZip$ZipSubscriberArr.length;
        Object[] objArr = this.current;
        int i = 1;
        do {
            long j = this.requested.get();
            long j2 = 0;
            while (j != j2) {
                if (this.cancelled) {
                    return;
                }
                if (!this.delayErrors && this.errors.get() != null) {
                    cancelAll();
                    cVar.onError(this.errors.terminate());
                    return;
                }
                boolean z3 = false;
                for (int i2 = 0; i2 < length; i2++) {
                    FlowableZip$ZipSubscriber<T, R> flowableZip$ZipSubscriber = flowableZip$ZipSubscriberArr[i2];
                    if (objArr[i2] == null) {
                        try {
                            z = flowableZip$ZipSubscriber.done;
                            f<T> fVar = flowableZip$ZipSubscriber.queue;
                            poll = fVar != null ? fVar.poll() : null;
                            z2 = poll == null;
                        } catch (Throwable th) {
                            a.a(th);
                            this.errors.addThrowable(th);
                            if (!this.delayErrors) {
                                cancelAll();
                                cVar.onError(this.errors.terminate());
                                return;
                            }
                        }
                        if (z && z2) {
                            cancelAll();
                            if (this.errors.get() != null) {
                                cVar.onError(this.errors.terminate());
                                return;
                            } else {
                                cVar.onComplete();
                                return;
                            }
                        }
                        if (!z2) {
                            objArr[i2] = poll;
                        }
                        z3 = true;
                    }
                }
                if (z3) {
                    break;
                }
                try {
                    Object obj = (R) this.zipper.apply(objArr.clone());
                    f.a.x.b.a.b(obj, "The zipper returned a null value");
                    cVar.onNext(obj);
                    j2++;
                    Arrays.fill(objArr, (Object) null);
                } catch (Throwable th2) {
                    a.a(th2);
                    cancelAll();
                    this.errors.addThrowable(th2);
                    cVar.onError(this.errors.terminate());
                    return;
                }
            }
            if (j == j2) {
                if (this.cancelled) {
                    return;
                }
                if (!this.delayErrors && this.errors.get() != null) {
                    cancelAll();
                    cVar.onError(this.errors.terminate());
                    return;
                }
                for (int i3 = 0; i3 < length; i3++) {
                    FlowableZip$ZipSubscriber<T, R> flowableZip$ZipSubscriber2 = flowableZip$ZipSubscriberArr[i3];
                    if (objArr[i3] == null) {
                        try {
                            boolean z4 = flowableZip$ZipSubscriber2.done;
                            f<T> fVar2 = flowableZip$ZipSubscriber2.queue;
                            T poll2 = fVar2 != null ? fVar2.poll() : null;
                            boolean z5 = poll2 == null;
                            if (z4 && z5) {
                                cancelAll();
                                if (this.errors.get() != null) {
                                    cVar.onError(this.errors.terminate());
                                    return;
                                } else {
                                    cVar.onComplete();
                                    return;
                                }
                            } else if (!z5) {
                                objArr[i3] = poll2;
                            }
                        } catch (Throwable th3) {
                            a.a(th3);
                            this.errors.addThrowable(th3);
                            if (!this.delayErrors) {
                                cancelAll();
                                cVar.onError(this.errors.terminate());
                                return;
                            }
                        }
                    }
                }
            }
            if (j2 != 0) {
                for (FlowableZip$ZipSubscriber<T, R> flowableZip$ZipSubscriber3 : flowableZip$ZipSubscriberArr) {
                    flowableZip$ZipSubscriber3.request(j2);
                }
                if (j != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
    }

    public void error(FlowableZip$ZipSubscriber<T, R> flowableZip$ZipSubscriber, Throwable th) {
        if (this.errors.addThrowable(th)) {
            flowableZip$ZipSubscriber.done = true;
            drain();
            return;
        }
        f.a.a0.a.f(th);
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            b.a(this.requested, j);
            drain();
        }
    }

    public void subscribe(g.d.b<? extends T>[] bVarArr, int i) {
        FlowableZip$ZipSubscriber<T, R>[] flowableZip$ZipSubscriberArr = this.subscribers;
        for (int i2 = 0; i2 < i && !this.cancelled; i2++) {
            if (!this.delayErrors && this.errors.get() != null) {
                return;
            }
            bVarArr[i2].subscribe(flowableZip$ZipSubscriberArr[i2]);
        }
    }
}
