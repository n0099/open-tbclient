package rx.internal.operators;

import com.baidu.tieba.pbc;
import com.baidu.tieba.uac;
import com.baidu.tieba.yac;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorBufferWithSize$BufferOverlap<T> extends yac<T> {
    public final yac<? super List<T>> e;
    public final int f;
    public final int g;
    public final ArrayDeque<List<T>> h;
    public final AtomicLong i;

    /* loaded from: classes2.dex */
    public final class BufferOverlapProducer extends AtomicBoolean implements uac {
        public static final long serialVersionUID = -4015894850868853147L;

        public BufferOverlapProducer() {
        }

        @Override // com.baidu.tieba.uac
        public void request(long j) {
            OperatorBufferWithSize$BufferOverlap operatorBufferWithSize$BufferOverlap = OperatorBufferWithSize$BufferOverlap.this;
            if (pbc.e(operatorBufferWithSize$BufferOverlap.i, j, operatorBufferWithSize$BufferOverlap.h, operatorBufferWithSize$BufferOverlap.e) && j != 0) {
                if (get() || !compareAndSet(false, true)) {
                    operatorBufferWithSize$BufferOverlap.e(pbc.c(operatorBufferWithSize$BufferOverlap.g, j));
                } else {
                    operatorBufferWithSize$BufferOverlap.e(pbc.a(pbc.c(operatorBufferWithSize$BufferOverlap.g, j - 1), operatorBufferWithSize$BufferOverlap.f));
                }
            }
        }
    }
}
