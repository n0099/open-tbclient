package rx.internal.operators;

import com.baidu.tieba.d8b;
import com.baidu.tieba.k7b;
import com.baidu.tieba.o7b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements k7b {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final o7b<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(o7b<? super T> o7bVar, T[] tArr) {
        this.child = o7bVar;
        this.array = tArr;
    }

    public void fastPath() {
        o7b<? super T> o7bVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (o7bVar.isUnsubscribed()) {
                return;
            }
            o7bVar.onNext(obj);
        }
        if (o7bVar.isUnsubscribed()) {
            return;
        }
        o7bVar.onCompleted();
    }

    @Override // com.baidu.tieba.k7b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (d8b.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && d8b.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        o7b<? super T> o7bVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (o7bVar.isUnsubscribed()) {
                        return;
                    }
                    o7bVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!o7bVar.isUnsubscribed()) {
                            o7bVar.onCompleted();
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
