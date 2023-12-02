package rx.internal.operators;

import com.baidu.tieba.cpc;
import com.baidu.tieba.foc;
import com.baidu.tieba.joc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class OperatorBufferWithSize$BufferSkip<T> extends joc<T> {
    public final int e;
    public final int f;

    /* loaded from: classes2.dex */
    public final class BufferSkipProducer extends AtomicBoolean implements foc {
        public static final long serialVersionUID = 3428177408082367154L;

        public BufferSkipProducer() {
        }

        @Override // com.baidu.tieba.foc
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorBufferWithSize$BufferSkip operatorBufferWithSize$BufferSkip = OperatorBufferWithSize$BufferSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        operatorBufferWithSize$BufferSkip.e(cpc.c(j, operatorBufferWithSize$BufferSkip.f));
                        return;
                    } else {
                        operatorBufferWithSize$BufferSkip.e(cpc.a(cpc.c(j, operatorBufferWithSize$BufferSkip.e), cpc.c(operatorBufferWithSize$BufferSkip.f - operatorBufferWithSize$BufferSkip.e, j - 1)));
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }
}
