package rx.internal.operators;

import com.baidu.tieba.dtb;
import com.baidu.tieba.ttb;
import com.baidu.tieba.zsb;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements zsb {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final dtb<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(dtb<? super T> dtbVar, T[] tArr) {
        this.child = dtbVar;
        this.array = tArr;
    }

    public void fastPath() {
        dtb<? super T> dtbVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (dtbVar.isUnsubscribed()) {
                return;
            }
            dtbVar.onNext(obj);
        }
        if (dtbVar.isUnsubscribed()) {
            return;
        }
        dtbVar.onCompleted();
    }

    @Override // com.baidu.tieba.zsb
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (ttb.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && ttb.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        dtb<? super T> dtbVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (dtbVar.isUnsubscribed()) {
                        return;
                    }
                    dtbVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!dtbVar.isUnsubscribed()) {
                            dtbVar.onCompleted();
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
