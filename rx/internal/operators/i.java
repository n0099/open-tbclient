package rx.internal.operators;

import rx.d;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes16.dex */
public final class i<T> implements d.b<Boolean, T> {
    final rx.functions.f<? super T, Boolean> qex;
    final boolean qfs;

    public i(rx.functions.f<? super T, Boolean> fVar, boolean z) {
        this.qex = fVar;
        this.qfs = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.f
    public rx.j<? super T> call(final rx.j<? super Boolean> jVar) {
        final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(jVar);
        rx.j jVar2 = (rx.j<T>) new rx.j<T>() { // from class: rx.internal.operators.i.1
            boolean done;
            boolean qft;

            @Override // rx.e
            public void onNext(T t) {
                if (!this.done) {
                    this.qft = true;
                    try {
                        if (i.this.qex.call(t).booleanValue()) {
                            this.done = true;
                            singleDelayedProducer.setValue(Boolean.valueOf(!i.this.qfs));
                            unsubscribe();
                        }
                    } catch (Throwable th) {
                        rx.exceptions.a.a(th, this, t);
                    }
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
                if (!this.done) {
                    this.done = true;
                    jVar.onError(th);
                    return;
                }
                rx.c.c.onError(th);
            }

            @Override // rx.e
            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    if (this.qft) {
                        singleDelayedProducer.setValue(false);
                    } else {
                        singleDelayedProducer.setValue(Boolean.valueOf(i.this.qfs));
                    }
                }
            }
        };
        jVar.add(jVar2);
        jVar.setProducer(singleDelayedProducer);
        return jVar2;
    }
}
