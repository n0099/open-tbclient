package rx.internal.operators;

import com.baidu.tieba.dnb;
import com.baidu.tieba.kmb;
import com.baidu.tieba.omb;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements kmb {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final omb<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(omb<? super T> ombVar, T[] tArr) {
        this.child = ombVar;
        this.array = tArr;
    }

    public void fastPath() {
        omb<? super T> ombVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (ombVar.isUnsubscribed()) {
                return;
            }
            ombVar.onNext(obj);
        }
        if (ombVar.isUnsubscribed()) {
            return;
        }
        ombVar.onCompleted();
    }

    @Override // com.baidu.tieba.kmb
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (dnb.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && dnb.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        omb<? super T> ombVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (ombVar.isUnsubscribed()) {
                        return;
                    }
                    ombVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!ombVar.isUnsubscribed()) {
                            ombVar.onCompleted();
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
