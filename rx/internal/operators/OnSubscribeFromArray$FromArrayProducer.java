package rx.internal.operators;

import com.baidu.tieba.cpc;
import com.baidu.tieba.foc;
import com.baidu.tieba.joc;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements foc {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final joc<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(joc<? super T> jocVar, T[] tArr) {
        this.child = jocVar;
        this.array = tArr;
    }

    public void fastPath() {
        joc<? super T> jocVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (jocVar.isUnsubscribed()) {
                return;
            }
            jocVar.onNext(obj);
        }
        if (jocVar.isUnsubscribed()) {
            return;
        }
        jocVar.onCompleted();
    }

    @Override // com.baidu.tieba.foc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (cpc.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && cpc.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        joc<? super T> jocVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (jocVar.isUnsubscribed()) {
                        return;
                    }
                    jocVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!jocVar.isUnsubscribed()) {
                            jocVar.onCompleted();
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
