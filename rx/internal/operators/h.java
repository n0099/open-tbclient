package rx.internal.operators;

import rx.d;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes15.dex */
public final class h<T> implements d.b<Boolean, T> {
    final rx.functions.f<? super T, Boolean> qrG;
    final boolean qsA;

    public h(rx.functions.f<? super T, Boolean> fVar, boolean z) {
        this.qrG = fVar;
        this.qsA = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.f
    public rx.j<? super T> call(final rx.j<? super Boolean> jVar) {
        final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(jVar);
        rx.j jVar2 = (rx.j<T>) new rx.j<T>() { // from class: rx.internal.operators.h.1
            boolean done;
            boolean qsB;

            @Override // rx.e
            public void onNext(T t) {
                if (!this.done) {
                    this.qsB = true;
                    try {
                        if (h.this.qrG.call(t).booleanValue()) {
                            this.done = true;
                            singleDelayedProducer.setValue(Boolean.valueOf(!h.this.qsA));
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
                    if (this.qsB) {
                        singleDelayedProducer.setValue(false);
                    } else {
                        singleDelayedProducer.setValue(Boolean.valueOf(h.this.qsA));
                    }
                }
            }
        };
        jVar.add(jVar2);
        jVar.setProducer(singleDelayedProducer);
        return jVar2;
    }
}
