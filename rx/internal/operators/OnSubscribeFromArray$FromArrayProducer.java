package rx.internal.operators;

import com.baidu.tieba.inb;
import com.baidu.tieba.pmb;
import com.baidu.tieba.tmb;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements pmb {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final tmb<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(tmb<? super T> tmbVar, T[] tArr) {
        this.child = tmbVar;
        this.array = tArr;
    }

    public void fastPath() {
        tmb<? super T> tmbVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (tmbVar.isUnsubscribed()) {
                return;
            }
            tmbVar.onNext(obj);
        }
        if (tmbVar.isUnsubscribed()) {
            return;
        }
        tmbVar.onCompleted();
    }

    @Override // com.baidu.tieba.pmb
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (inb.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && inb.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        tmb<? super T> tmbVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (tmbVar.isUnsubscribed()) {
                        return;
                    }
                    tmbVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!tmbVar.isUnsubscribed()) {
                            tmbVar.onCompleted();
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
