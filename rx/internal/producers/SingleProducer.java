package rx.internal.producers;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.f;
import rx.j;
/* loaded from: classes7.dex */
public final class SingleProducer<T> extends AtomicBoolean implements f {
    private static final long serialVersionUID = -3353584923995471404L;
    final j<? super T> child;
    final T value;

    public SingleProducer(j<? super T> jVar, T t) {
        this.child = jVar;
        this.value = t;
    }

    @Override // rx.f
    public void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j != 0 && compareAndSet(false, true)) {
            j<? super T> jVar = this.child;
            if (!jVar.isUnsubscribed()) {
                Object obj = (T) this.value;
                try {
                    jVar.onNext(obj);
                    if (!jVar.isUnsubscribed()) {
                        jVar.onCompleted();
                    }
                } catch (Throwable th) {
                    rx.exceptions.a.a(th, jVar, obj);
                }
            }
        }
    }
}
