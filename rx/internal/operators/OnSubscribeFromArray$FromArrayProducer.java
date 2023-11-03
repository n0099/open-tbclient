package rx.internal.operators;

import com.baidu.tieba.hkc;
import com.baidu.tieba.kjc;
import com.baidu.tieba.ojc;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements kjc {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final ojc<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(ojc<? super T> ojcVar, T[] tArr) {
        this.child = ojcVar;
        this.array = tArr;
    }

    public void fastPath() {
        ojc<? super T> ojcVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (ojcVar.isUnsubscribed()) {
                return;
            }
            ojcVar.onNext(obj);
        }
        if (ojcVar.isUnsubscribed()) {
            return;
        }
        ojcVar.onCompleted();
    }

    @Override // com.baidu.tieba.kjc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (hkc.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && hkc.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        ojc<? super T> ojcVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (ojcVar.isUnsubscribed()) {
                        return;
                    }
                    ojcVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!ojcVar.isUnsubscribed()) {
                            ojcVar.onCompleted();
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
