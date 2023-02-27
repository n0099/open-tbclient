package rx.internal.producers;

import com.baidu.tieba.ena;
import com.baidu.tieba.uma;
import com.baidu.tieba.yma;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class SingleDelayedProducer<T> extends AtomicInteger implements uma {
    public static final int HAS_REQUEST_HAS_VALUE = 3;
    public static final int HAS_REQUEST_NO_VALUE = 2;
    public static final int NO_REQUEST_HAS_VALUE = 1;
    public static final int NO_REQUEST_NO_VALUE = 0;
    public static final long serialVersionUID = -2873467947112093874L;
    public final yma<? super T> child;
    public T value;

    public SingleDelayedProducer(yma<? super T> ymaVar) {
        this.child = ymaVar;
    }

    @Override // com.baidu.tieba.uma
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
    public static <T> void emit(yma<? super T> ymaVar, T t) {
        if (ymaVar.isUnsubscribed()) {
            return;
        }
        try {
            ymaVar.onNext(t);
            if (ymaVar.isUnsubscribed()) {
                return;
            }
            ymaVar.onCompleted();
        } catch (Throwable th) {
            ena.g(th, ymaVar, t);
        }
    }
}
