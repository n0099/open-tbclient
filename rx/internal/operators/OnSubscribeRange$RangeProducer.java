package rx.internal.operators;

import com.baidu.tieba.nna;
import com.baidu.tieba.uma;
import com.baidu.tieba.yma;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OnSubscribeRange$RangeProducer extends AtomicLong implements uma {
    public static final long serialVersionUID = 4114392207069098388L;
    public final yma<? super Integer> childSubscriber;
    public long currentIndex;
    public final int endOfRange;

    public OnSubscribeRange$RangeProducer(yma<? super Integer> ymaVar, int i, int i2) {
        this.childSubscriber = ymaVar;
        this.currentIndex = i;
        this.endOfRange = i2;
    }

    public void fastPath() {
        long j = this.endOfRange + 1;
        yma<? super Integer> ymaVar = this.childSubscriber;
        for (long j2 = this.currentIndex; j2 != j; j2++) {
            if (ymaVar.isUnsubscribed()) {
                return;
            }
            ymaVar.onNext(Integer.valueOf((int) j2));
        }
        if (!ymaVar.isUnsubscribed()) {
            ymaVar.onCompleted();
        }
    }

    @Override // com.baidu.tieba.uma
    public void request(long j) {
        if (get() == Long.MAX_VALUE) {
            return;
        }
        if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
            fastPath();
        } else if (j > 0 && nna.b(this, j) == 0) {
            slowPath(j);
        }
    }

    public void slowPath(long j) {
        long j2 = this.endOfRange + 1;
        long j3 = this.currentIndex;
        yma<? super Integer> ymaVar = this.childSubscriber;
        do {
            long j4 = 0;
            while (true) {
                if (j4 != j && j3 != j2) {
                    if (ymaVar.isUnsubscribed()) {
                        return;
                    }
                    ymaVar.onNext(Integer.valueOf((int) j3));
                    j3++;
                    j4++;
                } else if (ymaVar.isUnsubscribed()) {
                    return;
                } else {
                    if (j3 == j2) {
                        ymaVar.onCompleted();
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
