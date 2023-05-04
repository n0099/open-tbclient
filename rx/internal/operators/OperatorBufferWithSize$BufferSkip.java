package rx.internal.operators;

import com.baidu.tieba.e6b;
import com.baidu.tieba.l5b;
import com.baidu.tieba.p5b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class OperatorBufferWithSize$BufferSkip<T> extends p5b<T> {
    public final int e;
    public final int f;

    /* loaded from: classes9.dex */
    public final class BufferSkipProducer extends AtomicBoolean implements l5b {
        public static final long serialVersionUID = 3428177408082367154L;

        public BufferSkipProducer() {
        }

        @Override // com.baidu.tieba.l5b
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorBufferWithSize$BufferSkip operatorBufferWithSize$BufferSkip = OperatorBufferWithSize$BufferSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        operatorBufferWithSize$BufferSkip.e(e6b.c(j, operatorBufferWithSize$BufferSkip.f));
                        return;
                    } else {
                        operatorBufferWithSize$BufferSkip.e(e6b.a(e6b.c(j, operatorBufferWithSize$BufferSkip.e), e6b.c(operatorBufferWithSize$BufferSkip.f - operatorBufferWithSize$BufferSkip.e, j - 1)));
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }
}
