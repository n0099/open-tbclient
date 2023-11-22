package rx.internal.operators;

import com.baidu.tieba.ikc;
import com.baidu.tieba.ljc;
import com.baidu.tieba.pjc;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeRange$RangeProducer extends AtomicLong implements ljc {
    public static final long serialVersionUID = 4114392207069098388L;
    public final pjc<? super Integer> childSubscriber;
    public long currentIndex;
    public final int endOfRange;

    public OnSubscribeRange$RangeProducer(pjc<? super Integer> pjcVar, int i, int i2) {
        this.childSubscriber = pjcVar;
        this.currentIndex = i;
        this.endOfRange = i2;
    }

    public void fastPath() {
        long j = this.endOfRange + 1;
        pjc<? super Integer> pjcVar = this.childSubscriber;
        for (long j2 = this.currentIndex; j2 != j; j2++) {
            if (pjcVar.isUnsubscribed()) {
                return;
            }
            pjcVar.onNext(Integer.valueOf((int) j2));
        }
        if (!pjcVar.isUnsubscribed()) {
            pjcVar.onCompleted();
        }
    }

    @Override // com.baidu.tieba.ljc
    public void request(long j) {
        if (get() == Long.MAX_VALUE) {
            return;
        }
        if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
            fastPath();
        } else if (j > 0 && ikc.b(this, j) == 0) {
            slowPath(j);
        }
    }

    public void slowPath(long j) {
        long j2 = this.endOfRange + 1;
        long j3 = this.currentIndex;
        pjc<? super Integer> pjcVar = this.childSubscriber;
        do {
            long j4 = 0;
            while (true) {
                if (j4 != j && j3 != j2) {
                    if (pjcVar.isUnsubscribed()) {
                        return;
                    }
                    pjcVar.onNext(Integer.valueOf((int) j3));
                    j3++;
                    j4++;
                } else if (pjcVar.isUnsubscribed()) {
                    return;
                } else {
                    if (j3 == j2) {
                        pjcVar.onCompleted();
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
