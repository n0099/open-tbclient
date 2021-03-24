package io.reactivex.internal.operators.flowable;

import f.a.w.h;
import f.a.x.c.a;
import f.a.x.i.e;
import g.d.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class FlowableWithLatestFromMany$WithLatestFromSubscriber<T, R> extends AtomicInteger implements a<T>, d {
    public static final long serialVersionUID = 1577321883966341961L;
    public final c<? super R> actual;
    public final h<? super Object[], R> combiner;
    public volatile boolean done;
    public final AtomicThrowable error;
    public final AtomicLong requested;
    public final AtomicReference<d> s;
    public final FlowableWithLatestFromMany$WithLatestInnerSubscriber[] subscribers;
    public final AtomicReferenceArray<Object> values;

    public FlowableWithLatestFromMany$WithLatestFromSubscriber(c<? super R> cVar, h<? super Object[], R> hVar, int i) {
        this.actual = cVar;
        this.combiner = hVar;
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] flowableWithLatestFromMany$WithLatestInnerSubscriberArr = new FlowableWithLatestFromMany$WithLatestInnerSubscriber[i];
        for (int i2 = 0; i2 < i; i2++) {
            flowableWithLatestFromMany$WithLatestInnerSubscriberArr[i2] = new FlowableWithLatestFromMany$WithLatestInnerSubscriber(this, i2);
        }
        this.subscribers = flowableWithLatestFromMany$WithLatestInnerSubscriberArr;
        this.values = new AtomicReferenceArray<>(i);
        this.s = new AtomicReference<>();
        this.requested = new AtomicLong();
        this.error = new AtomicThrowable();
    }

    @Override // g.d.d
    public void cancel() {
        SubscriptionHelper.cancel(this.s);
        for (FlowableWithLatestFromMany$WithLatestInnerSubscriber flowableWithLatestFromMany$WithLatestInnerSubscriber : this.subscribers) {
            flowableWithLatestFromMany$WithLatestInnerSubscriber.dispose();
        }
    }

    public void cancelAllBut(int i) {
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] flowableWithLatestFromMany$WithLatestInnerSubscriberArr = this.subscribers;
        for (int i2 = 0; i2 < flowableWithLatestFromMany$WithLatestInnerSubscriberArr.length; i2++) {
            if (i2 != i) {
                flowableWithLatestFromMany$WithLatestInnerSubscriberArr[i2].dispose();
            }
        }
    }

    public void innerComplete(int i, boolean z) {
        if (z) {
            return;
        }
        this.done = true;
        SubscriptionHelper.cancel(this.s);
        cancelAllBut(i);
        e.b(this.actual, this, this.error);
    }

    public void innerError(int i, Throwable th) {
        this.done = true;
        SubscriptionHelper.cancel(this.s);
        cancelAllBut(i);
        e.d(this.actual, th, this, this.error);
    }

    public void innerNext(int i, Object obj) {
        this.values.set(i, obj);
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        cancelAllBut(-1);
        e.b(this.actual, this, this.error);
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.done) {
            f.a.a0.a.f(th);
            return;
        }
        this.done = true;
        cancelAllBut(-1);
        e.d(this.actual, th, this, this.error);
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (tryOnNext(t) || this.done) {
            return;
        }
        this.s.get().request(1L);
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        SubscriptionHelper.deferredSetOnce(this.s, this.requested, dVar);
    }

    @Override // g.d.d
    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.s, this.requested, j);
    }

    public void subscribe(b<?>[] bVarArr, int i) {
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] flowableWithLatestFromMany$WithLatestInnerSubscriberArr = this.subscribers;
        AtomicReference<d> atomicReference = this.s;
        for (int i2 = 0; i2 < i && !SubscriptionHelper.isCancelled(atomicReference.get()); i2++) {
            bVarArr[i2].subscribe(flowableWithLatestFromMany$WithLatestInnerSubscriberArr[i2]);
        }
    }

    @Override // f.a.x.c.a
    public boolean tryOnNext(T t) {
        if (this.done) {
            return false;
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.values;
        int length = atomicReferenceArray.length();
        Object[] objArr = new Object[length + 1];
        objArr[0] = t;
        int i = 0;
        while (i < length) {
            Object obj = atomicReferenceArray.get(i);
            if (obj == null) {
                return false;
            }
            i++;
            objArr[i] = obj;
        }
        try {
            R apply = this.combiner.apply(objArr);
            f.a.x.b.a.b(apply, "The combiner returned a null value");
            e.f(this.actual, apply, this, this.error);
            return true;
        } catch (Throwable th) {
            f.a.u.a.a(th);
            cancel();
            onError(th);
            return false;
        }
    }
}
