package rx.internal.operators;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.e9c;
import com.baidu.tieba.r7c;
import com.baidu.tieba.v7c;
import com.baidu.tieba.w7c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorPublish$InnerProducer<T> extends AtomicLong implements r7c, w7c {
    public static final long NOT_REQUESTED = -4611686018427387904L;
    public static final long UNSUBSCRIBED = Long.MIN_VALUE;
    public static final long serialVersionUID = -4453897557930727610L;
    public final v7c<? super T> child;
    public final e9c<T> parent;

    public OperatorPublish$InnerProducer(e9c<T> e9cVar, v7c<? super T> v7cVar) {
        this.parent = e9cVar;
        this.child = v7cVar;
        lazySet(-4611686018427387904L);
    }

    @Override // com.baidu.tieba.w7c
    public boolean isUnsubscribed() {
        if (get() == Long.MIN_VALUE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.w7c
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

    @Override // com.baidu.tieba.r7c
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
