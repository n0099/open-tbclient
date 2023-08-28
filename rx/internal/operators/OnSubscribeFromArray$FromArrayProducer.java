package rx.internal.operators;

import com.baidu.tieba.m8c;
import com.baidu.tieba.r7c;
import com.baidu.tieba.v7c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements r7c {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final v7c<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(v7c<? super T> v7cVar, T[] tArr) {
        this.child = v7cVar;
        this.array = tArr;
    }

    public void fastPath() {
        v7c<? super T> v7cVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (v7cVar.isUnsubscribed()) {
                return;
            }
            v7cVar.onNext(obj);
        }
        if (v7cVar.isUnsubscribed()) {
            return;
        }
        v7cVar.onCompleted();
    }

    @Override // com.baidu.tieba.r7c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (m8c.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && m8c.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        v7c<? super T> v7cVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (v7cVar.isUnsubscribed()) {
                        return;
                    }
                    v7cVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!v7cVar.isUnsubscribed()) {
                            v7cVar.onCompleted();
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
