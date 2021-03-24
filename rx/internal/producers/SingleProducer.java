package rx.internal.producers;

import h.f;
import h.j;
import h.m.a;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class SingleProducer<T> extends AtomicBoolean implements f {
    public static final long serialVersionUID = -3353584923995471404L;
    public final j<? super T> child;
    public final T value;

    public SingleProducer(j<? super T> jVar, T t) {
        this.child = jVar;
        this.value = t;
    }

    @Override // h.f
    public void request(long j) {
        if (j >= 0) {
            if (j != 0 && compareAndSet(false, true)) {
                j<? super T> jVar = this.child;
                if (jVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    jVar.onNext(obj);
                    if (jVar.isUnsubscribed()) {
                        return;
                    }
                    jVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    a.g(th, jVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
