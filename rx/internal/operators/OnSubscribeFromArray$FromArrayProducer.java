package rx.internal.operators;

import com.baidu.tieba.ikc;
import com.baidu.tieba.ljc;
import com.baidu.tieba.pjc;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements ljc {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final pjc<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(pjc<? super T> pjcVar, T[] tArr) {
        this.child = pjcVar;
        this.array = tArr;
    }

    public void fastPath() {
        pjc<? super T> pjcVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (pjcVar.isUnsubscribed()) {
                return;
            }
            pjcVar.onNext(obj);
        }
        if (pjcVar.isUnsubscribed()) {
            return;
        }
        pjcVar.onCompleted();
    }

    @Override // com.baidu.tieba.ljc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (ikc.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && ikc.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        pjc<? super T> pjcVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (pjcVar.isUnsubscribed()) {
                        return;
                    }
                    pjcVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!pjcVar.isUnsubscribed()) {
                            pjcVar.onCompleted();
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
