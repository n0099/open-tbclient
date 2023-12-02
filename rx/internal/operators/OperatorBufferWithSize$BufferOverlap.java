package rx.internal.operators;

import com.baidu.tieba.cpc;
import com.baidu.tieba.foc;
import com.baidu.tieba.joc;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorBufferWithSize$BufferOverlap<T> extends joc<T> {
    public final joc<? super List<T>> e;
    public final int f;
    public final int g;
    public final ArrayDeque<List<T>> h;
    public final AtomicLong i;

    /* loaded from: classes2.dex */
    public final class BufferOverlapProducer extends AtomicBoolean implements foc {
        public static final long serialVersionUID = -4015894850868853147L;

        public BufferOverlapProducer() {
        }

        @Override // com.baidu.tieba.foc
        public void request(long j) {
            OperatorBufferWithSize$BufferOverlap operatorBufferWithSize$BufferOverlap = OperatorBufferWithSize$BufferOverlap.this;
            if (cpc.e(operatorBufferWithSize$BufferOverlap.i, j, operatorBufferWithSize$BufferOverlap.h, operatorBufferWithSize$BufferOverlap.e) && j != 0) {
                if (get() || !compareAndSet(false, true)) {
                    operatorBufferWithSize$BufferOverlap.e(cpc.c(operatorBufferWithSize$BufferOverlap.g, j));
                } else {
                    operatorBufferWithSize$BufferOverlap.e(cpc.a(cpc.c(operatorBufferWithSize$BufferOverlap.g, j - 1), operatorBufferWithSize$BufferOverlap.f));
                }
            }
        }
    }
}
