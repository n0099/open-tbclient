package rx.internal.operators;

import com.baidu.tieba.hdc;
import com.baidu.tieba.mcc;
import com.baidu.tieba.qcc;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements mcc {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final qcc<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(qcc<? super T> qccVar, T[] tArr) {
        this.child = qccVar;
        this.array = tArr;
    }

    public void fastPath() {
        qcc<? super T> qccVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (qccVar.isUnsubscribed()) {
                return;
            }
            qccVar.onNext(obj);
        }
        if (qccVar.isUnsubscribed()) {
            return;
        }
        qccVar.onCompleted();
    }

    @Override // com.baidu.tieba.mcc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (hdc.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && hdc.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        qcc<? super T> qccVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (qccVar.isUnsubscribed()) {
                        return;
                    }
                    qccVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!qccVar.isUnsubscribed()) {
                            qccVar.onCompleted();
                            return;
                        }
                        return;
                    }
                    j--;
                    j2--;
                } else {
                    j = get() + j2;
                    if (j == 0) {
                        this.index = i;
                        j = addAndGet(j2);
                    }
                }
            }
        } while (j != 0);
    }
}
