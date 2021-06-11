package rx.internal.operators;

import h.f;
import h.j;
import h.o.a.a;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public final class OnSubscribeRange$RangeProducer extends AtomicLong implements f {
    public static final long serialVersionUID = 4114392207069098388L;
    public final j<? super Integer> childSubscriber;
    public long currentIndex;
    public final int endOfRange;

    public OnSubscribeRange$RangeProducer(j<? super Integer> jVar, int i2, int i3) {
        this.childSubscriber = jVar;
        this.currentIndex = i2;
        this.endOfRange = i3;
    }

    public void fastPath() {
        long j = this.endOfRange + 1;
        j<? super Integer> jVar = this.childSubscriber;
        for (long j2 = this.currentIndex; j2 != j; j2++) {
            if (jVar.isUnsubscribed()) {
                return;
            }
            jVar.onNext(Integer.valueOf((int) j2));
        }
        if (jVar.isUnsubscribed()) {
            return;
        }
        jVar.onCompleted();
    }

    @Override // h.f
    public void request(long j) {
        if (get() == Long.MAX_VALUE) {
            return;
        }
        if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
            fastPath();
        } else if (j <= 0 || a.b(this, j) != 0) {
        } else {
            slowPath(j);
        }
    }

    public void slowPath(long j) {
        long j2 = this.endOfRange + 1;
        long j3 = this.currentIndex;
        j<? super Integer> jVar = this.childSubscriber;
        do {
            long j4 = 0;
            while (true) {
                if (j4 != j && j3 != j2) {
                    if (jVar.isUnsubscribed()) {
                        return;
                    }
                    jVar.onNext(Integer.valueOf((int) j3));
                    j3++;
                    j4++;
                } else if (jVar.isUnsubscribed()) {
                    return;
                } else {
                    if (j3 == j2) {
                        jVar.onCompleted();
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
