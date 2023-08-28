package rx.internal.operators;

import com.baidu.tieba.m8c;
import com.baidu.tieba.r7c;
import com.baidu.tieba.v7c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeRange$RangeProducer extends AtomicLong implements r7c {
    public static final long serialVersionUID = 4114392207069098388L;
    public final v7c<? super Integer> childSubscriber;
    public long currentIndex;
    public final int endOfRange;

    public OnSubscribeRange$RangeProducer(v7c<? super Integer> v7cVar, int i, int i2) {
        this.childSubscriber = v7cVar;
        this.currentIndex = i;
        this.endOfRange = i2;
    }

    public void fastPath() {
        long j = this.endOfRange + 1;
        v7c<? super Integer> v7cVar = this.childSubscriber;
        for (long j2 = this.currentIndex; j2 != j; j2++) {
            if (v7cVar.isUnsubscribed()) {
                return;
            }
            v7cVar.onNext(Integer.valueOf((int) j2));
        }
        if (!v7cVar.isUnsubscribed()) {
            v7cVar.onCompleted();
        }
    }

    @Override // com.baidu.tieba.r7c
    public void request(long j) {
        if (get() == Long.MAX_VALUE) {
            return;
        }
        if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
            fastPath();
        } else if (j > 0 && m8c.b(this, j) == 0) {
            slowPath(j);
        }
    }

    public void slowPath(long j) {
        long j2 = this.endOfRange + 1;
        long j3 = this.currentIndex;
        v7c<? super Integer> v7cVar = this.childSubscriber;
        do {
            long j4 = 0;
            while (true) {
                if (j4 != j && j3 != j2) {
                    if (v7cVar.isUnsubscribed()) {
                        return;
                    }
                    v7cVar.onNext(Integer.valueOf((int) j3));
                    j3++;
                    j4++;
                } else if (v7cVar.isUnsubscribed()) {
                    return;
                } else {
                    if (j3 == j2) {
                        v7cVar.onCompleted();
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
