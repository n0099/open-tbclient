package rx.internal.operators;

import com.baidu.tieba.c8b;
import com.baidu.tieba.j7b;
import com.baidu.tieba.n7b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public final class OnSubscribeRange$RangeProducer extends AtomicLong implements j7b {
    public static final long serialVersionUID = 4114392207069098388L;
    public final n7b<? super Integer> childSubscriber;
    public long currentIndex;
    public final int endOfRange;

    public OnSubscribeRange$RangeProducer(n7b<? super Integer> n7bVar, int i, int i2) {
        this.childSubscriber = n7bVar;
        this.currentIndex = i;
        this.endOfRange = i2;
    }

    public void fastPath() {
        long j = this.endOfRange + 1;
        n7b<? super Integer> n7bVar = this.childSubscriber;
        for (long j2 = this.currentIndex; j2 != j; j2++) {
            if (n7bVar.isUnsubscribed()) {
                return;
            }
            n7bVar.onNext(Integer.valueOf((int) j2));
        }
        if (!n7bVar.isUnsubscribed()) {
            n7bVar.onCompleted();
        }
    }

    @Override // com.baidu.tieba.j7b
    public void request(long j) {
        if (get() == Long.MAX_VALUE) {
            return;
        }
        if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
            fastPath();
        } else if (j > 0 && c8b.b(this, j) == 0) {
            slowPath(j);
        }
    }

    public void slowPath(long j) {
        long j2 = this.endOfRange + 1;
        long j3 = this.currentIndex;
        n7b<? super Integer> n7bVar = this.childSubscriber;
        do {
            long j4 = 0;
            while (true) {
                if (j4 != j && j3 != j2) {
                    if (n7bVar.isUnsubscribed()) {
                        return;
                    }
                    n7bVar.onNext(Integer.valueOf((int) j3));
                    j3++;
                    j4++;
                } else if (n7bVar.isUnsubscribed()) {
                    return;
                } else {
                    if (j3 == j2) {
                        n7bVar.onCompleted();
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
