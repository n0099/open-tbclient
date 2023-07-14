package rx.internal.operators;

import com.baidu.tieba.a2c;
import com.baidu.tieba.q2c;
import com.baidu.tieba.w1c;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorBufferWithSize$BufferOverlap<T> extends a2c<T> {
    public final a2c<? super List<T>> e;
    public final int f;
    public final int g;
    public final ArrayDeque<List<T>> h;
    public final AtomicLong i;

    /* loaded from: classes2.dex */
    public final class BufferOverlapProducer extends AtomicBoolean implements w1c {
        public static final long serialVersionUID = -4015894850868853147L;

        public BufferOverlapProducer() {
        }

        @Override // com.baidu.tieba.w1c
        public void request(long j) {
            OperatorBufferWithSize$BufferOverlap operatorBufferWithSize$BufferOverlap = OperatorBufferWithSize$BufferOverlap.this;
            if (q2c.e(operatorBufferWithSize$BufferOverlap.i, j, operatorBufferWithSize$BufferOverlap.h, operatorBufferWithSize$BufferOverlap.e) && j != 0) {
                if (get() || !compareAndSet(false, true)) {
                    operatorBufferWithSize$BufferOverlap.e(q2c.c(operatorBufferWithSize$BufferOverlap.g, j));
                } else {
                    operatorBufferWithSize$BufferOverlap.e(q2c.a(q2c.c(operatorBufferWithSize$BufferOverlap.g, j - 1), operatorBufferWithSize$BufferOverlap.f));
                }
            }
        }
    }
}
