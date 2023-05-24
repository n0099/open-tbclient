package rx.internal.operators;

import com.baidu.tieba.d8b;
import com.baidu.tieba.k7b;
import com.baidu.tieba.o7b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public final class OnSubscribeRange$RangeProducer extends AtomicLong implements k7b {
    public static final long serialVersionUID = 4114392207069098388L;
    public final o7b<? super Integer> childSubscriber;
    public long currentIndex;
    public final int endOfRange;

    public OnSubscribeRange$RangeProducer(o7b<? super Integer> o7bVar, int i, int i2) {
        this.childSubscriber = o7bVar;
        this.currentIndex = i;
        this.endOfRange = i2;
    }

    public void fastPath() {
        long j = this.endOfRange + 1;
        o7b<? super Integer> o7bVar = this.childSubscriber;
        for (long j2 = this.currentIndex; j2 != j; j2++) {
            if (o7bVar.isUnsubscribed()) {
                return;
            }
            o7bVar.onNext(Integer.valueOf((int) j2));
        }
        if (!o7bVar.isUnsubscribed()) {
            o7bVar.onCompleted();
        }
    }

    @Override // com.baidu.tieba.k7b
    public void request(long j) {
        if (get() == Long.MAX_VALUE) {
            return;
        }
        if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
            fastPath();
        } else if (j > 0 && d8b.b(this, j) == 0) {
            slowPath(j);
        }
    }

    public void slowPath(long j) {
        long j2 = this.endOfRange + 1;
        long j3 = this.currentIndex;
        o7b<? super Integer> o7bVar = this.childSubscriber;
        do {
            long j4 = 0;
            while (true) {
                if (j4 != j && j3 != j2) {
                    if (o7bVar.isUnsubscribed()) {
                        return;
                    }
                    o7bVar.onNext(Integer.valueOf((int) j3));
                    j3++;
                    j4++;
                } else if (o7bVar.isUnsubscribed()) {
                    return;
                } else {
                    if (j3 == j2) {
                        o7bVar.onCompleted();
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
