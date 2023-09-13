package rx.internal.operators;

import com.baidu.tieba.pbc;
import com.baidu.tieba.uac;
import com.baidu.tieba.yac;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements uac {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final yac<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(yac<? super T> yacVar, T[] tArr) {
        this.child = yacVar;
        this.array = tArr;
    }

    public void fastPath() {
        yac<? super T> yacVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (yacVar.isUnsubscribed()) {
                return;
            }
            yacVar.onNext(obj);
        }
        if (yacVar.isUnsubscribed()) {
            return;
        }
        yacVar.onCompleted();
    }

    @Override // com.baidu.tieba.uac
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (pbc.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && pbc.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        yac<? super T> yacVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (yacVar.isUnsubscribed()) {
                        return;
                    }
                    yacVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!yacVar.isUnsubscribed()) {
                            yacVar.onCompleted();
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
