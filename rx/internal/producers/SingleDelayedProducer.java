package rx.internal.producers;

import com.baidu.tieba.j7b;
import com.baidu.tieba.n7b;
import com.baidu.tieba.t7b;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class SingleDelayedProducer<T> extends AtomicInteger implements j7b {
    public static final int HAS_REQUEST_HAS_VALUE = 3;
    public static final int HAS_REQUEST_NO_VALUE = 2;
    public static final int NO_REQUEST_HAS_VALUE = 1;
    public static final int NO_REQUEST_NO_VALUE = 0;
    public static final long serialVersionUID = -2873467947112093874L;
    public final n7b<? super T> child;
    public T value;

    public SingleDelayedProducer(n7b<? super T> n7bVar) {
        this.child = n7bVar;
    }

    @Override // com.baidu.tieba.j7b
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
    public static <T> void emit(n7b<? super T> n7bVar, T t) {
        if (n7bVar.isUnsubscribed()) {
            return;
        }
        try {
            n7bVar.onNext(t);
            if (n7bVar.isUnsubscribed()) {
                return;
            }
            n7bVar.onCompleted();
        } catch (Throwable th) {
            t7b.g(th, n7bVar, t);
        }
    }
}
