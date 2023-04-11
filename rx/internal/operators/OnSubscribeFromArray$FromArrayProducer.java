package rx.internal.operators;

import com.baidu.tieba.a2b;
import com.baidu.tieba.h1b;
import com.baidu.tieba.l1b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements h1b {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final l1b<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(l1b<? super T> l1bVar, T[] tArr) {
        this.child = l1bVar;
        this.array = tArr;
    }

    public void fastPath() {
        l1b<? super T> l1bVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (l1bVar.isUnsubscribed()) {
                return;
            }
            l1bVar.onNext(obj);
        }
        if (l1bVar.isUnsubscribed()) {
            return;
        }
        l1bVar.onCompleted();
    }

    @Override // com.baidu.tieba.h1b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (a2b.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && a2b.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        l1b<? super T> l1bVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (l1bVar.isUnsubscribed()) {
                        return;
                    }
                    l1bVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!l1bVar.isUnsubscribed()) {
                            l1bVar.onCompleted();
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
