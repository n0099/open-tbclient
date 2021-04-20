package rx.internal.operators;

import com.baidu.tbadk.core.data.SmallTailInfo;
import h.f;
import h.j;
import h.k;
import h.o.a.s;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class OperatorPublish$InnerProducer<T> extends AtomicLong implements f, k {
    public static final long NOT_REQUESTED = -4611686018427387904L;
    public static final long UNSUBSCRIBED = Long.MIN_VALUE;
    public static final long serialVersionUID = -4453897557930727610L;
    public final j<? super T> child;
    public final s<T> parent;

    public OperatorPublish$InnerProducer(s<T> sVar, j<? super T> jVar) {
        this.parent = sVar;
        this.child = jVar;
        lazySet(-4611686018427387904L);
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return get() == Long.MIN_VALUE;
    }

    public long produced(long j) {
        long j2;
        long j3;
        if (j > 0) {
            do {
                j2 = get();
                if (j2 == -4611686018427387904L) {
                    throw new IllegalStateException("Produced without request");
                }
                if (j2 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                j3 = j2 - j;
                if (j3 < 0) {
                    throw new IllegalStateException("More produced (" + j + ") than requested (" + j2 + SmallTailInfo.EMOTION_SUFFIX);
                }
            } while (!compareAndSet(j2, j3));
            return j3;
        }
        throw new IllegalArgumentException("Cant produce zero or less");
    }

    @Override // h.f
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
        this.parent.b();
    }

    @Override // h.k
    public void unsubscribe() {
        if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
            return;
        }
        this.parent.c(this);
        this.parent.b();
    }
}
