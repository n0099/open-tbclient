package rx.internal.producers;

import com.baidu.tieba.ebc;
import com.baidu.tieba.uac;
import com.baidu.tieba.yac;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class SingleDelayedProducer<T> extends AtomicInteger implements uac {
    public static final int HAS_REQUEST_HAS_VALUE = 3;
    public static final int HAS_REQUEST_NO_VALUE = 2;
    public static final int NO_REQUEST_HAS_VALUE = 1;
    public static final int NO_REQUEST_NO_VALUE = 0;
    public static final long serialVersionUID = -2873467947112093874L;
    public final yac<? super T> child;
    public T value;

    public SingleDelayedProducer(yac<? super T> yacVar) {
        this.child = yacVar;
    }

    @Override // com.baidu.tieba.uac
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
    public static <T> void emit(yac<? super T> yacVar, T t) {
        if (yacVar.isUnsubscribed()) {
            return;
        }
        try {
            yacVar.onNext(t);
            if (yacVar.isUnsubscribed()) {
                return;
            }
            yacVar.onCompleted();
        } catch (Throwable th) {
            ebc.g(th, yacVar, t);
        }
    }
}
