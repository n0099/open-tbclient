package rx.internal.operators;

import com.baidu.tieba.k8c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.t7c;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorBufferWithSize$BufferOverlap<T> extends t7c<T> {
    public final t7c<? super List<T>> e;
    public final int f;
    public final int g;
    public final ArrayDeque<List<T>> h;
    public final AtomicLong i;

    /* loaded from: classes2.dex */
    public final class BufferOverlapProducer extends AtomicBoolean implements p7c {
        public static final long serialVersionUID = -4015894850868853147L;

        public BufferOverlapProducer() {
        }

        @Override // com.baidu.tieba.p7c
        public void request(long j) {
            OperatorBufferWithSize$BufferOverlap operatorBufferWithSize$BufferOverlap = OperatorBufferWithSize$BufferOverlap.this;
            if (k8c.e(operatorBufferWithSize$BufferOverlap.i, j, operatorBufferWithSize$BufferOverlap.h, operatorBufferWithSize$BufferOverlap.e) && j != 0) {
                if (get() || !compareAndSet(false, true)) {
                    operatorBufferWithSize$BufferOverlap.e(k8c.c(operatorBufferWithSize$BufferOverlap.g, j));
                } else {
                    operatorBufferWithSize$BufferOverlap.e(k8c.a(k8c.c(operatorBufferWithSize$BufferOverlap.g, j - 1), operatorBufferWithSize$BufferOverlap.f));
                }
            }
        }
    }
}
