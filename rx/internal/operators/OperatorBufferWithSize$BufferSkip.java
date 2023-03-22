package rx.internal.operators;

import com.baidu.tieba.jsa;
import com.baidu.tieba.qra;
import com.baidu.tieba.ura;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class OperatorBufferWithSize$BufferSkip<T> extends ura<T> {
    public final int e;
    public final int f;

    /* loaded from: classes9.dex */
    public final class BufferSkipProducer extends AtomicBoolean implements qra {
        public static final long serialVersionUID = 3428177408082367154L;

        public BufferSkipProducer() {
        }

        @Override // com.baidu.tieba.qra
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorBufferWithSize$BufferSkip operatorBufferWithSize$BufferSkip = OperatorBufferWithSize$BufferSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        operatorBufferWithSize$BufferSkip.e(jsa.c(j, operatorBufferWithSize$BufferSkip.f));
                        return;
                    } else {
                        operatorBufferWithSize$BufferSkip.e(jsa.a(jsa.c(j, operatorBufferWithSize$BufferSkip.e), jsa.c(operatorBufferWithSize$BufferSkip.f - operatorBufferWithSize$BufferSkip.e, j - 1)));
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }
}
