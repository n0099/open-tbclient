package rx.internal.operators;

import com.baidu.tieba.a1c;
import com.baidu.tieba.e1c;
import com.baidu.tieba.u1c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements a1c {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final e1c<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(e1c<? super T> e1cVar, T[] tArr) {
        this.child = e1cVar;
        this.array = tArr;
    }

    public void fastPath() {
        e1c<? super T> e1cVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (e1cVar.isUnsubscribed()) {
                return;
            }
            e1cVar.onNext(obj);
        }
        if (e1cVar.isUnsubscribed()) {
            return;
        }
        e1cVar.onCompleted();
    }

    @Override // com.baidu.tieba.a1c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (u1c.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && u1c.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        e1c<? super T> e1cVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (e1cVar.isUnsubscribed()) {
                        return;
                    }
                    e1cVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!e1cVar.isUnsubscribed()) {
                            e1cVar.onCompleted();
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
