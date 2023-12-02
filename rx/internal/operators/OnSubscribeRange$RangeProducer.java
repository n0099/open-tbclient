package rx.internal.operators;

import com.baidu.tieba.cpc;
import com.baidu.tieba.foc;
import com.baidu.tieba.joc;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeRange$RangeProducer extends AtomicLong implements foc {
    public static final long serialVersionUID = 4114392207069098388L;
    public final joc<? super Integer> childSubscriber;
    public long currentIndex;
    public final int endOfRange;

    public OnSubscribeRange$RangeProducer(joc<? super Integer> jocVar, int i, int i2) {
        this.childSubscriber = jocVar;
        this.currentIndex = i;
        this.endOfRange = i2;
    }

    public void fastPath() {
        long j = this.endOfRange + 1;
        joc<? super Integer> jocVar = this.childSubscriber;
        for (long j2 = this.currentIndex; j2 != j; j2++) {
            if (jocVar.isUnsubscribed()) {
                return;
            }
            jocVar.onNext(Integer.valueOf((int) j2));
        }
        if (!jocVar.isUnsubscribed()) {
            jocVar.onCompleted();
        }
    }

    @Override // com.baidu.tieba.foc
    public void request(long j) {
        if (get() == Long.MAX_VALUE) {
            return;
        }
        if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
            fastPath();
        } else if (j > 0 && cpc.b(this, j) == 0) {
            slowPath(j);
        }
    }

    public void slowPath(long j) {
        long j2 = this.endOfRange + 1;
        long j3 = this.currentIndex;
        joc<? super Integer> jocVar = this.childSubscriber;
        do {
            long j4 = 0;
            while (true) {
                if (j4 != j && j3 != j2) {
                    if (jocVar.isUnsubscribed()) {
                        return;
                    }
                    jocVar.onNext(Integer.valueOf((int) j3));
                    j3++;
                    j4++;
                } else if (jocVar.isUnsubscribed()) {
                    return;
                } else {
                    if (j3 == j2) {
                        jocVar.onCompleted();
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
