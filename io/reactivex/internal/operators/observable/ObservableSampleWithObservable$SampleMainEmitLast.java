package io.reactivex.internal.operators.observable;

import f.a.n;
import f.a.o;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableSampleWithObservable$SampleMainEmitLast<T> extends ObservableSampleWithObservable$SampleMainObserver<T> {
    public static final long serialVersionUID = -3029755663834015785L;
    public volatile boolean done;
    public final AtomicInteger wip;

    public ObservableSampleWithObservable$SampleMainEmitLast(o<? super T> oVar, n<?> nVar) {
        super(oVar, nVar);
        this.wip = new AtomicInteger();
    }

    @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver
    public void completeMain() {
        this.done = true;
        if (this.wip.getAndIncrement() == 0) {
            emit();
            this.actual.onComplete();
        }
    }

    @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver
    public void completeOther() {
        this.done = true;
        if (this.wip.getAndIncrement() == 0) {
            emit();
            this.actual.onComplete();
        }
    }

    @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainObserver
    public void run() {
        if (this.wip.getAndIncrement() == 0) {
            do {
                boolean z = this.done;
                emit();
                if (z) {
                    this.actual.onComplete();
                    return;
                }
            } while (this.wip.decrementAndGet() != 0);
        }
    }
}
