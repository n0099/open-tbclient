package rx.internal.operators;

import com.baidu.tieba.dpc;
import com.baidu.tieba.goc;
import com.baidu.tieba.koc;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements goc {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final koc<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(koc<? super T> kocVar, T[] tArr) {
        this.child = kocVar;
        this.array = tArr;
    }

    public void fastPath() {
        koc<? super T> kocVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (kocVar.isUnsubscribed()) {
                return;
            }
            kocVar.onNext(obj);
        }
        if (kocVar.isUnsubscribed()) {
            return;
        }
        kocVar.onCompleted();
    }

    @Override // com.baidu.tieba.goc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (dpc.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && dpc.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        koc<? super T> kocVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (kocVar.isUnsubscribed()) {
                        return;
                    }
                    kocVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!kocVar.isUnsubscribed()) {
                            kocVar.onCompleted();
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
