package rx.internal.operators;

import com.baidu.tieba.c8b;
import com.baidu.tieba.j7b;
import com.baidu.tieba.n7b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements j7b {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final n7b<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(n7b<? super T> n7bVar, T[] tArr) {
        this.child = n7bVar;
        this.array = tArr;
    }

    public void fastPath() {
        n7b<? super T> n7bVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (n7bVar.isUnsubscribed()) {
                return;
            }
            n7bVar.onNext(obj);
        }
        if (n7bVar.isUnsubscribed()) {
            return;
        }
        n7bVar.onCompleted();
    }

    @Override // com.baidu.tieba.j7b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (c8b.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && c8b.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        n7b<? super T> n7bVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (n7bVar.isUnsubscribed()) {
                        return;
                    }
                    n7bVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!n7bVar.isUnsubscribed()) {
                            n7bVar.onCompleted();
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
