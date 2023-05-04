package rx.internal.operators;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.l5b;
import com.baidu.tieba.p5b;
import com.baidu.tieba.q5b;
import com.baidu.tieba.u6b;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OperatorPublish$InnerProducer<T> extends AtomicLong implements l5b, q5b {
    public static final long NOT_REQUESTED = -4611686018427387904L;
    public static final long UNSUBSCRIBED = Long.MIN_VALUE;
    public static final long serialVersionUID = -4453897557930727610L;
    public final p5b<? super T> child;
    public final u6b<T> parent;

    public OperatorPublish$InnerProducer(u6b<T> u6bVar, p5b<? super T> p5bVar) {
        this.parent = u6bVar;
        this.child = p5bVar;
        lazySet(-4611686018427387904L);
    }

    @Override // com.baidu.tieba.q5b
    public boolean isUnsubscribed() {
        if (get() == Long.MIN_VALUE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.q5b
    public void unsubscribe() {
        if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
            this.parent.h(this);
            this.parent.g();
        }
    }

    public long produced(long j) {
        long j2;
        long j3;
        if (j > 0) {
            do {
                j2 = get();
                if (j2 != -4611686018427387904L) {
                    if (j2 == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    j3 = j2 - j;
                    if (j3 < 0) {
                        throw new IllegalStateException("More produced (" + j + ") than requested (" + j2 + SmallTailInfo.EMOTION_SUFFIX);
                    }
                } else {
                    throw new IllegalStateException("Produced without request");
                }
            } while (!compareAndSet(j2, j3));
            return j3;
        }
        throw new IllegalArgumentException("Cant produce zero or less");
    }

    @Override // com.baidu.tieba.l5b
    public void request(long j) {
        long j2;
        long j3;
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0) {
            return;
        }
        do {
            j2 = get();
            if (j2 == Long.MIN_VALUE) {
                return;
            }
            if (j2 >= 0 && i == 0) {
                return;
            }
            if (j2 == -4611686018427387904L) {
                j3 = j;
            } else {
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
            }
        } while (!compareAndSet(j2, j3));
        this.parent.g();
    }
}
