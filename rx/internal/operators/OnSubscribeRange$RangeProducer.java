package rx.internal.operators;

import com.baidu.tieba.dnb;
import com.baidu.tieba.kmb;
import com.baidu.tieba.omb;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeRange$RangeProducer extends AtomicLong implements kmb {
    public static final long serialVersionUID = 4114392207069098388L;
    public final omb<? super Integer> childSubscriber;
    public long currentIndex;
    public final int endOfRange;

    public OnSubscribeRange$RangeProducer(omb<? super Integer> ombVar, int i, int i2) {
        this.childSubscriber = ombVar;
        this.currentIndex = i;
        this.endOfRange = i2;
    }

    public void fastPath() {
        long j = this.endOfRange + 1;
        omb<? super Integer> ombVar = this.childSubscriber;
        for (long j2 = this.currentIndex; j2 != j; j2++) {
            if (ombVar.isUnsubscribed()) {
                return;
            }
            ombVar.onNext(Integer.valueOf((int) j2));
        }
        if (!ombVar.isUnsubscribed()) {
            ombVar.onCompleted();
        }
    }

    @Override // com.baidu.tieba.kmb
    public void request(long j) {
        if (get() == Long.MAX_VALUE) {
            return;
        }
        if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
            fastPath();
        } else if (j > 0 && dnb.b(this, j) == 0) {
            slowPath(j);
        }
    }

    public void slowPath(long j) {
        long j2 = this.endOfRange + 1;
        long j3 = this.currentIndex;
        omb<? super Integer> ombVar = this.childSubscriber;
        do {
            long j4 = 0;
            while (true) {
                if (j4 != j && j3 != j2) {
                    if (ombVar.isUnsubscribed()) {
                        return;
                    }
                    ombVar.onNext(Integer.valueOf((int) j3));
                    j3++;
                    j4++;
                } else if (ombVar.isUnsubscribed()) {
                    return;
                } else {
                    if (j3 == j2) {
                        ombVar.onCompleted();
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
