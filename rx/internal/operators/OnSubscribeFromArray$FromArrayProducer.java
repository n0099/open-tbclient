package rx.internal.operators;

import com.baidu.tieba.d1c;
import com.baidu.tieba.t1c;
import com.baidu.tieba.z0c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements z0c {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final d1c<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(d1c<? super T> d1cVar, T[] tArr) {
        this.child = d1cVar;
        this.array = tArr;
    }

    public void fastPath() {
        d1c<? super T> d1cVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (d1cVar.isUnsubscribed()) {
                return;
            }
            d1cVar.onNext(obj);
        }
        if (d1cVar.isUnsubscribed()) {
            return;
        }
        d1cVar.onCompleted();
    }

    @Override // com.baidu.tieba.z0c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (t1c.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && t1c.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        d1c<? super T> d1cVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (d1cVar.isUnsubscribed()) {
                        return;
                    }
                    d1cVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!d1cVar.isUnsubscribed()) {
                            d1cVar.onCompleted();
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
