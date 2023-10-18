package rx.internal.operators;

import com.baidu.tieba.g7c;
import com.baidu.tieba.j6c;
import com.baidu.tieba.n6c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements j6c {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final n6c<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(n6c<? super T> n6cVar, T[] tArr) {
        this.child = n6cVar;
        this.array = tArr;
    }

    public void fastPath() {
        n6c<? super T> n6cVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (n6cVar.isUnsubscribed()) {
                return;
            }
            n6cVar.onNext(obj);
        }
        if (n6cVar.isUnsubscribed()) {
            return;
        }
        n6cVar.onCompleted();
    }

    @Override // com.baidu.tieba.j6c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (g7c.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && g7c.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        n6c<? super T> n6cVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (n6cVar.isUnsubscribed()) {
                        return;
                    }
                    n6cVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!n6cVar.isUnsubscribed()) {
                            n6cVar.onCompleted();
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
