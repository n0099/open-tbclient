package rx.internal.producers;

import h.f;
import h.j;
import h.m.a;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class SingleDelayedProducer<T> extends AtomicInteger implements f {
    public static final int HAS_REQUEST_HAS_VALUE = 3;
    public static final int HAS_REQUEST_NO_VALUE = 2;
    public static final int NO_REQUEST_HAS_VALUE = 1;
    public static final int NO_REQUEST_NO_VALUE = 0;
    public static final long serialVersionUID = -2873467947112093874L;
    public final j<? super T> child;
    public T value;

    public SingleDelayedProducer(j<? super T> jVar) {
        this.child = jVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void emit(j<? super T> jVar, T t) {
        if (jVar.isUnsubscribed()) {
            return;
        }
        try {
            jVar.onNext(t);
            if (jVar.isUnsubscribed()) {
                return;
            }
            jVar.onCompleted();
        } catch (Throwable th) {
            a.g(th, jVar, t);
        }
    }

    @Override // h.f
    public void request(long j) {
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (i2 == 0) {
            return;
        }
        do {
            int i3 = get();
            if (i3 != 0) {
                if (i3 == 1 && compareAndSet(1, 3)) {
                    emit(this.child, this.value);
                    return;
                }
                return;
            }
        } while (!compareAndSet(0, 2));
    }

    public void setValue(T t) {
        do {
            int i2 = get();
            if (i2 == 0) {
                this.value = t;
            } else if (i2 == 2 && compareAndSet(2, 3)) {
                emit(this.child, t);
                return;
            } else {
                return;
            }
        } while (!compareAndSet(0, 1));
    }
}
