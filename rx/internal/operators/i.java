package rx.internal.operators;

import rx.d;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes6.dex */
public final class i<T> implements d.b<Boolean, T> {
    final rx.functions.f<? super T, Boolean> obN;
    final boolean ocJ;

    public i(rx.functions.f<? super T, Boolean> fVar, boolean z) {
        this.obN = fVar;
        this.ocJ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.f
    public rx.j<? super T> call(final rx.j<? super Boolean> jVar) {
        final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(jVar);
        rx.j jVar2 = (rx.j<T>) new rx.j<T>() { // from class: rx.internal.operators.i.1
            boolean done;
            boolean ocK;

            @Override // rx.e
            public void onNext(T t) {
                if (!this.done) {
                    this.ocK = true;
                    try {
                        if (i.this.obN.call(t).booleanValue()) {
                            this.done = true;
                            singleDelayedProducer.setValue(Boolean.valueOf(!i.this.ocJ));
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
                    if (this.ocK) {
                        singleDelayedProducer.setValue(false);
                    } else {
                        singleDelayedProducer.setValue(Boolean.valueOf(i.this.ocJ));
                    }
                }
            }
        };
        jVar.add(jVar2);
        jVar.setProducer(singleDelayedProducer);
        return jVar2;
    }
}
