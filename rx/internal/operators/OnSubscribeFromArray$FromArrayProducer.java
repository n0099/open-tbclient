package rx.internal.operators;

import com.baidu.tieba.bpb;
import com.baidu.tieba.iob;
import com.baidu.tieba.mob;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromArray$FromArrayProducer<T> extends AtomicLong implements iob {
    public static final long serialVersionUID = 3534218984725836979L;
    public final T[] array;
    public final mob<? super T> child;
    public int index;

    public OnSubscribeFromArray$FromArrayProducer(mob<? super T> mobVar, T[] tArr) {
        this.child = mobVar;
        this.array = tArr;
    }

    public void fastPath() {
        mob<? super T> mobVar = this.child;
        for (T t : this.array) {
            Object obj = (Object) t;
            if (mobVar.isUnsubscribed()) {
                return;
            }
            mobVar.onNext(obj);
        }
        if (mobVar.isUnsubscribed()) {
            return;
        }
        mobVar.onCompleted();
    }

    @Override // com.baidu.tieba.iob
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (j == Long.MAX_VALUE) {
                if (bpb.b(this, j) == 0) {
                    fastPath();
                    return;
                }
                return;
            } else if (i != 0 && bpb.b(this, j) == 0) {
                slowPath(j);
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j);
    }

    public void slowPath(long j) {
        mob<? super T> mobVar = this.child;
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        do {
            long j2 = 0;
            while (true) {
                if (j != 0 && i != length) {
                    if (mobVar.isUnsubscribed()) {
                        return;
                    }
                    mobVar.onNext((Object) tArr[i]);
                    i++;
                    if (i == length) {
                        if (!mobVar.isUnsubscribed()) {
                            mobVar.onCompleted();
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
