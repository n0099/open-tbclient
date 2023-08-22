package rx.internal.operators;

import com.baidu.tieba.k8c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.t7c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements p7c {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final t7c<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(t7c<? super T> t7cVar, T[] tArr) {
        this.child = t7cVar;
        this.array = tArr;
    }

    public void fastPath() {
        t7c<? super T> t7cVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (t7cVar.isUnsubscribed()) {
                return;
            }
            t7cVar.onNext(obj);
        }
        if (t7cVar.isUnsubscribed()) {
            return;
        }
        t7cVar.onCompleted();
    }

    @Override // com.baidu.tieba.p7c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (k8c.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && k8c.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        t7c<? super T> t7cVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (t7cVar.isUnsubscribed()) {
                        return;
                    }
                    t7cVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!t7cVar.isUnsubscribed()) {
                            t7cVar.onCompleted();
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
