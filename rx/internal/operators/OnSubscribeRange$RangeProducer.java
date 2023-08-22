package rx.internal.operators;

import com.baidu.tieba.k8c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.t7c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeRange$RangeProducer extends AtomicLong implements p7c {
    public static final long serialVersionUID = 4114392207069098388L;
    public final t7c<? super Integer> childSubscriber;
    public long currentIndex;
    public final int endOfRange;

    public OnSubscribeRange$RangeProducer(t7c<? super Integer> t7cVar, int i, int i2) {
        this.childSubscriber = t7cVar;
        this.currentIndex = i;
        this.endOfRange = i2;
    }

    public void fastPath() {
        long j = this.endOfRange + 1;
        t7c<? super Integer> t7cVar = this.childSubscriber;
        for (long j2 = this.currentIndex; j2 != j; j2++) {
            if (t7cVar.isUnsubscribed()) {
                return;
            }
            t7cVar.onNext(Integer.valueOf((int) j2));
        }
        if (!t7cVar.isUnsubscribed()) {
            t7cVar.onCompleted();
        }
    }

    @Override // com.baidu.tieba.p7c
    public void request(long j) {
        if (get() == Long.MAX_VALUE) {
            return;
        }
        if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
            fastPath();
        } else if (j > 0 && k8c.b(this, j) == 0) {
            slowPath(j);
        }
    }

    public void slowPath(long j) {
        long j2 = this.endOfRange + 1;
        long j3 = this.currentIndex;
        t7c<? super Integer> t7cVar = this.childSubscriber;
        do {
            long j4 = 0;
            while (true) {
                if (j4 != j && j3 != j2) {
                    if (t7cVar.isUnsubscribed()) {
                        return;
                    }
                    t7cVar.onNext(Integer.valueOf((int) j3));
                    j3++;
                    j4++;
                } else if (t7cVar.isUnsubscribed()) {
                    return;
                } else {
                    if (j3 == j2) {
                        t7cVar.onCompleted();
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
