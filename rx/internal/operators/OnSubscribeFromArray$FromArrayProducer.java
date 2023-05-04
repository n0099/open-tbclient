package rx.internal.operators;

import com.baidu.tieba.e6b;
import com.baidu.tieba.l5b;
import com.baidu.tieba.p5b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements l5b {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final p5b<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(p5b<? super T> p5bVar, T[] tArr) {
        this.child = p5bVar;
        this.array = tArr;
    }

    public void fastPath() {
        p5b<? super T> p5bVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (p5bVar.isUnsubscribed()) {
                return;
            }
            p5bVar.onNext(obj);
        }
        if (p5bVar.isUnsubscribed()) {
            return;
        }
        p5bVar.onCompleted();
    }

    @Override // com.baidu.tieba.l5b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (e6b.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && e6b.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        p5b<? super T> p5bVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (p5bVar.isUnsubscribed()) {
                        return;
                    }
                    p5bVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!p5bVar.isUnsubscribed()) {
                            p5bVar.onCompleted();
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
