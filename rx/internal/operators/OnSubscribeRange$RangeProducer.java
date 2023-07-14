package rx.internal.operators;

import com.baidu.tieba.a2c;
import com.baidu.tieba.q2c;
import com.baidu.tieba.w1c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeRange$RangeProducer extends AtomicLong implements w1c {
    public static final long serialVersionUID = 4114392207069098388L;
    public final a2c<? super Integer> childSubscriber;
    public long currentIndex;
    public final int endOfRange;

    public OnSubscribeRange$RangeProducer(a2c<? super Integer> a2cVar, int i, int i2) {
        this.childSubscriber = a2cVar;
        this.currentIndex = i;
        this.endOfRange = i2;
    }

    public void fastPath() {
        long j = this.endOfRange + 1;
        a2c<? super Integer> a2cVar = this.childSubscriber;
        for (long j2 = this.currentIndex; j2 != j; j2++) {
            if (a2cVar.isUnsubscribed()) {
                return;
            }
            a2cVar.onNext(Integer.valueOf((int) j2));
        }
        if (!a2cVar.isUnsubscribed()) {
            a2cVar.onCompleted();
        }
    }

    @Override // com.baidu.tieba.w1c
    public void request(long j) {
        if (get() == Long.MAX_VALUE) {
            return;
        }
        if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
            fastPath();
        } else if (j > 0 && q2c.b(this, j) == 0) {
            slowPath(j);
        }
    }

    public void slowPath(long j) {
        long j2 = this.endOfRange + 1;
        long j3 = this.currentIndex;
        a2c<? super Integer> a2cVar = this.childSubscriber;
        do {
            long j4 = 0;
            while (true) {
                if (j4 != j && j3 != j2) {
                    if (a2cVar.isUnsubscribed()) {
                        return;
                    }
                    a2cVar.onNext(Integer.valueOf((int) j3));
                    j3++;
                    j4++;
                } else if (a2cVar.isUnsubscribed()) {
                    return;
                } else {
                    if (j3 == j2) {
                        a2cVar.onCompleted();
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
