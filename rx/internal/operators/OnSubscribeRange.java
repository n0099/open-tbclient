package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.d;
/* loaded from: classes7.dex */
public final class OnSubscribeRange implements d.a<Integer> {
    private final int btx;
    private final int bty;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.b
    public void call(rx.j<? super Integer> jVar) {
        jVar.setProducer(new RangeProducer(jVar, this.btx, this.bty));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class RangeProducer extends AtomicLong implements rx.f {
        private static final long serialVersionUID = 4114392207069098388L;
        private final rx.j<? super Integer> childSubscriber;
        private long currentIndex;
        private final int endOfRange;

        RangeProducer(rx.j<? super Integer> jVar, int i, int i2) {
            this.childSubscriber = jVar;
            this.currentIndex = i;
            this.endOfRange = i2;
        }

        @Override // rx.f
        public void request(long j) {
            if (get() != Long.MAX_VALUE) {
                if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                    fastPath();
                } else if (j > 0 && a.e(this, j) == 0) {
                    slowPath(j);
                }
            }
        }

        void slowPath(long j) {
            long j2 = this.endOfRange + 1;
            long j3 = this.currentIndex;
            rx.j<? super Integer> jVar = this.childSubscriber;
            long j4 = 0;
            while (true) {
                if (j4 != j && j3 != j2) {
                    if (!jVar.isUnsubscribed()) {
                        jVar.onNext(Integer.valueOf((int) j3));
                        j3++;
                        j4++;
                    } else {
                        return;
                    }
                } else if (!jVar.isUnsubscribed()) {
                    if (j3 == j2) {
                        jVar.onCompleted();
                        return;
                    }
                    j = get();
                    if (j == j4) {
                        this.currentIndex = j3;
                        j = addAndGet(-j4);
                        if (j == 0) {
                            return;
                        }
                        j4 = 0;
                    } else {
                        continue;
                    }
                } else {
                    return;
                }
            }
        }

        void fastPath() {
            long j = this.endOfRange + 1;
            rx.j<? super Integer> jVar = this.childSubscriber;
            for (long j2 = this.currentIndex; j2 != j; j2++) {
                if (!jVar.isUnsubscribed()) {
                    jVar.onNext(Integer.valueOf((int) j2));
                } else {
                    return;
                }
            }
            if (!jVar.isUnsubscribed()) {
                jVar.onCompleted();
            }
        }
    }
}
