package rx.internal.operators;

import com.baidu.tieba.i2b;
import com.baidu.tieba.p1b;
import com.baidu.tieba.t1b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OnSubscribeRange$RangeProducer extends AtomicLong implements p1b {
    public static final long serialVersionUID = 4114392207069098388L;
    public final t1b<? super Integer> childSubscriber;
    public long currentIndex;
    public final int endOfRange;

    public OnSubscribeRange$RangeProducer(t1b<? super Integer> t1bVar, int i, int i2) {
        this.childSubscriber = t1bVar;
        this.currentIndex = i;
        this.endOfRange = i2;
    }

    public void fastPath() {
        long j = this.endOfRange + 1;
        t1b<? super Integer> t1bVar = this.childSubscriber;
        for (long j2 = this.currentIndex; j2 != j; j2++) {
            if (t1bVar.isUnsubscribed()) {
                return;
            }
            t1bVar.onNext(Integer.valueOf((int) j2));
        }
        if (!t1bVar.isUnsubscribed()) {
            t1bVar.onCompleted();
        }
    }

    @Override // com.baidu.tieba.p1b
    public void request(long j) {
        if (get() == Long.MAX_VALUE) {
            return;
        }
        if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
            fastPath();
        } else if (j > 0 && i2b.b(this, j) == 0) {
            slowPath(j);
        }
    }

    public void slowPath(long j) {
        long j2 = this.endOfRange + 1;
        long j3 = this.currentIndex;
        t1b<? super Integer> t1bVar = this.childSubscriber;
        do {
            long j4 = 0;
            while (true) {
                if (j4 != j && j3 != j2) {
                    if (t1bVar.isUnsubscribed()) {
                        return;
                    }
                    t1bVar.onNext(Integer.valueOf((int) j3));
                    j3++;
                    j4++;
                } else if (t1bVar.isUnsubscribed()) {
                    return;
                } else {
                    if (j3 == j2) {
                        t1bVar.onCompleted();
                        return;
                    }
                    j = get();
                    if (j == j4) {
                        this.currentIndex = j3;
                        j = addAndGet(-j4);
                    }
                }
            }
        } while (j != 0);
    }
}
