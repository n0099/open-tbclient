package io.reactivex.internal.operators.flowable;

import f.a.g;
import g.d.b;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class FlowableConcatArray$ConcatArraySubscriber<T> extends SubscriptionArbiter implements g<T> {
    public static final long serialVersionUID = -8158322871608889516L;
    public final c<? super T> actual;
    public final boolean delayError;
    public List<Throwable> errors;
    public int index;
    public long produced;
    public final b<? extends T>[] sources;
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableConcatArray$ConcatArraySubscriber(b<? extends T>[] bVarArr, boolean z, c<? super T> cVar) {
        this.actual = cVar;
        this.sources = bVarArr;
        this.delayError = z;
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.wip.getAndIncrement() == 0) {
            b<? extends T>[] bVarArr = this.sources;
            int length = bVarArr.length;
            int i = this.index;
            while (i != length) {
                b<? extends T> bVar = bVarArr[i];
                if (bVar == null) {
                    NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                    if (this.delayError) {
                        List list = this.errors;
                        if (list == null) {
                            list = new ArrayList((length - i) + 1);
                            this.errors = list;
                        }
                        list.add(nullPointerException);
                        i++;
                    } else {
                        this.actual.onError(nullPointerException);
                        return;
                    }
                } else {
                    long j = this.produced;
                    if (j != 0) {
                        this.produced = 0L;
                        produced(j);
                    }
                    bVar.subscribe(this);
                    i++;
                    this.index = i;
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
            List<Throwable> list2 = this.errors;
            if (list2 != null) {
                if (list2.size() == 1) {
                    this.actual.onError(list2.get(0));
                    return;
                } else {
                    this.actual.onError(new CompositeException(list2));
                    return;
                }
            }
            this.actual.onComplete();
        }
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.delayError) {
            List list = this.errors;
            if (list == null) {
                list = new ArrayList((this.sources.length - this.index) + 1);
                this.errors = list;
            }
            list.add(th);
            onComplete();
            return;
        }
        this.actual.onError(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        this.produced++;
        this.actual.onNext(t);
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        setSubscription(dVar);
    }
}
