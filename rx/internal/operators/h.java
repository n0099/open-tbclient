package rx.internal.operators;

import rx.d;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes2.dex */
public final class h<T> implements d.b<Boolean, T> {
    final rx.functions.f<? super T, Boolean> jWm;
    final boolean jXg;

    public h(rx.functions.f<? super T, Boolean> fVar, boolean z) {
        this.jWm = fVar;
        this.jXg = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.f
    public rx.j<? super T> call(final rx.j<? super Boolean> jVar) {
        final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(jVar);
        rx.j jVar2 = (rx.j<T>) new rx.j<T>() { // from class: rx.internal.operators.h.1
            boolean done;
            boolean jXh;

            @Override // rx.e
            public void onNext(T t) {
                if (!this.done) {
                    this.jXh = true;
                    try {
                        if (h.this.jWm.call(t).booleanValue()) {
                            this.done = true;
                            singleDelayedProducer.setValue(Boolean.valueOf(!h.this.jXg));
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
                    if (this.jXh) {
                        singleDelayedProducer.setValue(false);
                    } else {
                        singleDelayedProducer.setValue(Boolean.valueOf(h.this.jXg));
                    }
                }
            }
        };
        jVar.add(jVar2);
        jVar.setProducer(singleDelayedProducer);
        return jVar2;
    }
}
