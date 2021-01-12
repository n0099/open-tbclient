package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.d;
/* loaded from: classes14.dex */
public final class OperatorElementAt<T> implements d.b<T, T> {
    final T defaultValue;
    final int index;
    final boolean qpS;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public rx.j<? super T> call(final rx.j<? super T> jVar) {
        rx.j jVar2 = (rx.j<T>) new rx.j<T>() { // from class: rx.internal.operators.OperatorElementAt.1
            private int currentIndex;

            @Override // rx.e
            public void onNext(T t) {
                int i = this.currentIndex;
                this.currentIndex = i + 1;
                if (i == OperatorElementAt.this.index) {
                    jVar.onNext(t);
                    jVar.onCompleted();
                    unsubscribe();
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
                jVar.onError(th);
            }

            @Override // rx.e
            public void onCompleted() {
                if (this.currentIndex <= OperatorElementAt.this.index) {
                    if (OperatorElementAt.this.qpS) {
                        jVar.onNext(OperatorElementAt.this.defaultValue);
                        jVar.onCompleted();
                        return;
                    }
                    jVar.onError(new IndexOutOfBoundsException(OperatorElementAt.this.index + " is out of bounds"));
                }
            }

            @Override // rx.j
            public void setProducer(rx.f fVar) {
                jVar.setProducer(new InnerProducer(fVar));
            }
        };
        jVar.add(jVar2);
        return jVar2;
    }

    /* loaded from: classes14.dex */
    static class InnerProducer extends AtomicBoolean implements rx.f {
        private static final long serialVersionUID = 1;
        final rx.f actual;

        public InnerProducer(rx.f fVar) {
            this.actual = fVar;
        }

        @Override // rx.f
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
            if (j > 0 && compareAndSet(false, true)) {
                this.actual.request(Long.MAX_VALUE);
            }
        }
    }
}
