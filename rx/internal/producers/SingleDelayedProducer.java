package rx.internal.producers;

import com.baidu.tieba.p1b;
import com.baidu.tieba.t1b;
import com.baidu.tieba.z1b;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class SingleDelayedProducer<T> extends AtomicInteger implements p1b {
    public static final int HAS_REQUEST_HAS_VALUE = 3;
    public static final int HAS_REQUEST_NO_VALUE = 2;
    public static final int NO_REQUEST_HAS_VALUE = 1;
    public static final int NO_REQUEST_NO_VALUE = 0;
    public static final long serialVersionUID = -2873467947112093874L;
    public final t1b<? super T> child;
    public T value;

    public SingleDelayedProducer(t1b<? super T> t1bVar) {
        this.child = t1bVar;
    }

    @Override // com.baidu.tieba.p1b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i == 0) {
                return;
            }
            do {
                int i2 = get();
                if (i2 != 0) {
                    if (i2 == 1 && compareAndSet(1, 3)) {
                        emit(this.child, this.value);
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }

    public void setValue(T t) {
        do {
            int i = get();
            if (i == 0) {
                this.value = t;
            } else if (i == 2 && compareAndSet(2, 3)) {
                emit(this.child, t);
                return;
            } else {
                return;
            }
        } while (!compareAndSet(0, 1));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void emit(t1b<? super T> t1bVar, T t) {
        if (t1bVar.isUnsubscribed()) {
            return;
        }
        try {
            t1bVar.onNext(t);
            if (t1bVar.isUnsubscribed()) {
                return;
            }
            t1bVar.onCompleted();
        } catch (Throwable th) {
            z1b.g(th, t1bVar, t);
        }
    }
}
