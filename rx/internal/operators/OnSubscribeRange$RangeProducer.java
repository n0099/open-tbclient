package rx.internal.operators;

import com.baidu.tieba.inb;
import com.baidu.tieba.pmb;
import com.baidu.tieba.tmb;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeRange$RangeProducer extends AtomicLong implements pmb {
    public static final long serialVersionUID = 4114392207069098388L;
    public final tmb<? super Integer> childSubscriber;
    public long currentIndex;
    public final int endOfRange;

    public OnSubscribeRange$RangeProducer(tmb<? super Integer> tmbVar, int i, int i2) {
        this.childSubscriber = tmbVar;
        this.currentIndex = i;
        this.endOfRange = i2;
    }

    public void fastPath() {
        long j = this.endOfRange + 1;
        tmb<? super Integer> tmbVar = this.childSubscriber;
        for (long j2 = this.currentIndex; j2 != j; j2++) {
            if (tmbVar.isUnsubscribed()) {
                return;
            }
            tmbVar.onNext(Integer.valueOf((int) j2));
        }
        if (!tmbVar.isUnsubscribed()) {
            tmbVar.onCompleted();
        }
    }

    @Override // com.baidu.tieba.pmb
    public void request(long j) {
        if (get() == Long.MAX_VALUE) {
            return;
        }
        if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
            fastPath();
        } else if (j > 0 && inb.b(this, j) == 0) {
            slowPath(j);
        }
    }

    public void slowPath(long j) {
        long j2 = this.endOfRange + 1;
        long j3 = this.currentIndex;
        tmb<? super Integer> tmbVar = this.childSubscriber;
        do {
            long j4 = 0;
            while (true) {
                if (j4 != j && j3 != j2) {
                    if (tmbVar.isUnsubscribed()) {
                        return;
                    }
                    tmbVar.onNext(Integer.valueOf((int) j3));
                    j3++;
                    j4++;
                } else if (tmbVar.isUnsubscribed()) {
                    return;
                } else {
                    if (j3 == j2) {
                        tmbVar.onCompleted();
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
