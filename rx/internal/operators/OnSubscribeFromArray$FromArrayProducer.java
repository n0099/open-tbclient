package rx.internal.operators;

import com.baidu.tieba.a2c;
import com.baidu.tieba.q2c;
import com.baidu.tieba.w1c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements w1c {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final a2c<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(a2c<? super T> a2cVar, T[] tArr) {
        this.child = a2cVar;
        this.array = tArr;
    }

    public void fastPath() {
        a2c<? super T> a2cVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (a2cVar.isUnsubscribed()) {
                return;
            }
            a2cVar.onNext(obj);
        }
        if (a2cVar.isUnsubscribed()) {
            return;
        }
        a2cVar.onCompleted();
    }

    @Override // com.baidu.tieba.w1c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (q2c.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && q2c.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        a2c<? super T> a2cVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (a2cVar.isUnsubscribed()) {
                        return;
                    }
                    a2cVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!a2cVar.isUnsubscribed()) {
                            a2cVar.onCompleted();
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
