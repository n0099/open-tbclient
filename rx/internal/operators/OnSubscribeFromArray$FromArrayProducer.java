package rx.internal.operators;

import com.baidu.tieba.jsa;
import com.baidu.tieba.qra;
import com.baidu.tieba.ura;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements qra {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final ura<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(ura<? super T> uraVar, T[] tArr) {
        this.child = uraVar;
        this.array = tArr;
    }

    public void fastPath() {
        ura<? super T> uraVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (uraVar.isUnsubscribed()) {
                return;
            }
            uraVar.onNext(obj);
        }
        if (uraVar.isUnsubscribed()) {
            return;
        }
        uraVar.onCompleted();
    }

    @Override // com.baidu.tieba.qra
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (jsa.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && jsa.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        ura<? super T> uraVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (uraVar.isUnsubscribed()) {
                        return;
                    }
                    uraVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!uraVar.isUnsubscribed()) {
                            uraVar.onCompleted();
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
