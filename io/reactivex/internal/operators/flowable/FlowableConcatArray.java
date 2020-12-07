package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.a.d;
/* loaded from: classes9.dex */
public final class FlowableConcatArray<T> extends g<T> {
    final boolean delayError;
    final org.a.b<? extends T>[] sources;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super T> cVar) {
        ConcatArraySubscriber concatArraySubscriber = new ConcatArraySubscriber(this.sources, this.delayError, cVar);
        cVar.onSubscribe(concatArraySubscriber);
        concatArraySubscriber.onComplete();
    }

    /* loaded from: classes9.dex */
    static final class ConcatArraySubscriber<T> extends SubscriptionArbiter implements j<T> {
        private static final long serialVersionUID = -8158322871608889516L;
        final org.a.c<? super T> actual;
        final boolean delayError;
        List<Throwable> errors;
        int index;
        long produced;
        final org.a.b<? extends T>[] sources;
        final AtomicInteger wip = new AtomicInteger();

        ConcatArraySubscriber(org.a.b<? extends T>[] bVarArr, boolean z, org.a.c<? super T> cVar) {
            this.actual = cVar;
            this.sources = bVarArr;
            this.delayError = z;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            setSubscription(dVar);
        }

        @Override // org.a.c
        public void onNext(T t) {
            this.produced++;
            this.actual.onNext(t);
        }

        @Override // org.a.c
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

        @Override // org.a.c
        public void onComplete() {
            if (this.wip.getAndIncrement() == 0) {
                org.a.b<? extends T>[] bVarArr = this.sources;
                int length = bVarArr.length;
                int i = this.index;
                while (i != length) {
                    org.a.b<? extends T> bVar = bVarArr[i];
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
                        int i2 = i + 1;
                        this.index = i2;
                        if (this.wip.decrementAndGet() == 0) {
                            return;
                        }
                        i = i2;
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
    }
}
