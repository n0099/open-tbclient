package rx.internal.operators;

import com.baidu.tieba.dpc;
import com.baidu.tieba.goc;
import com.baidu.tieba.koc;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeRange$RangeProducer extends AtomicLong implements goc {
    public static final long serialVersionUID = 4114392207069098388L;
    public final koc<? super Integer> childSubscriber;
    public long currentIndex;
    public final int endOfRange;

    public OnSubscribeRange$RangeProducer(koc<? super Integer> kocVar, int i, int i2) {
        this.childSubscriber = kocVar;
        this.currentIndex = i;
        this.endOfRange = i2;
    }

    public void fastPath() {
        long j = this.endOfRange + 1;
        koc<? super Integer> kocVar = this.childSubscriber;
        for (long j2 = this.currentIndex; j2 != j; j2++) {
            if (kocVar.isUnsubscribed()) {
                return;
            }
            kocVar.onNext(Integer.valueOf((int) j2));
        }
        if (!kocVar.isUnsubscribed()) {
            kocVar.onCompleted();
        }
    }

    @Override // com.baidu.tieba.goc
    public void request(long j) {
        if (get() == Long.MAX_VALUE) {
            return;
        }
        if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
            fastPath();
        } else if (j > 0 && dpc.b(this, j) == 0) {
            slowPath(j);
        }
    }

    public void slowPath(long j) {
        long j2 = this.endOfRange + 1;
        long j3 = this.currentIndex;
        koc<? super Integer> kocVar = this.childSubscriber;
        do {
            long j4 = 0;
            while (true) {
                if (j4 != j && j3 != j2) {
                    if (kocVar.isUnsubscribed()) {
                        return;
                    }
                    kocVar.onNext(Integer.valueOf((int) j3));
                    j3++;
                    j4++;
                } else if (kocVar.isUnsubscribed()) {
                    return;
                } else {
                    if (j3 == j2) {
                        kocVar.onCompleted();
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
