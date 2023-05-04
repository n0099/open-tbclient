package rx.internal.operators;

import com.baidu.tieba.e6b;
import com.baidu.tieba.l5b;
import com.baidu.tieba.p5b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OnSubscribeRange$RangeProducer extends AtomicLong implements l5b {
    public static final long serialVersionUID = 4114392207069098388L;
    public final p5b<? super Integer> childSubscriber;
    public long currentIndex;
    public final int endOfRange;

    public OnSubscribeRange$RangeProducer(p5b<? super Integer> p5bVar, int i, int i2) {
        this.childSubscriber = p5bVar;
        this.currentIndex = i;
        this.endOfRange = i2;
    }

    public void fastPath() {
        long j = this.endOfRange + 1;
        p5b<? super Integer> p5bVar = this.childSubscriber;
        for (long j2 = this.currentIndex; j2 != j; j2++) {
            if (p5bVar.isUnsubscribed()) {
                return;
            }
            p5bVar.onNext(Integer.valueOf((int) j2));
        }
        if (!p5bVar.isUnsubscribed()) {
            p5bVar.onCompleted();
        }
    }

    @Override // com.baidu.tieba.l5b
    public void request(long j) {
        if (get() == Long.MAX_VALUE) {
            return;
        }
        if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
            fastPath();
        } else if (j > 0 && e6b.b(this, j) == 0) {
            slowPath(j);
        }
    }

    public void slowPath(long j) {
        long j2 = this.endOfRange + 1;
        long j3 = this.currentIndex;
        p5b<? super Integer> p5bVar = this.childSubscriber;
        do {
            long j4 = 0;
            while (true) {
                if (j4 != j && j3 != j2) {
                    if (p5bVar.isUnsubscribed()) {
                        return;
                    }
                    p5bVar.onNext(Integer.valueOf((int) j3));
                    j3++;
                    j4++;
                } else if (p5bVar.isUnsubscribed()) {
                    return;
                } else {
                    if (j3 == j2) {
                        p5bVar.onCompleted();
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
