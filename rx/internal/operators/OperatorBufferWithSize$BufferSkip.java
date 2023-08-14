package rx.internal.operators;

import com.baidu.tieba.a1c;
import com.baidu.tieba.e1c;
import com.baidu.tieba.u1c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class OperatorBufferWithSize$BufferSkip<T> extends e1c<T> {
    public final int e;
    public final int f;

    /* loaded from: classes2.dex */
    public final class BufferSkipProducer extends AtomicBoolean implements a1c {
        public static final long serialVersionUID = 3428177408082367154L;

        public BufferSkipProducer() {
        }

        @Override // com.baidu.tieba.a1c
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorBufferWithSize$BufferSkip operatorBufferWithSize$BufferSkip = OperatorBufferWithSize$BufferSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        operatorBufferWithSize$BufferSkip.e(u1c.c(j, operatorBufferWithSize$BufferSkip.f));
                        return;
                    } else {
                        operatorBufferWithSize$BufferSkip.e(u1c.a(u1c.c(j, operatorBufferWithSize$BufferSkip.e), u1c.c(operatorBufferWithSize$BufferSkip.f - operatorBufferWithSize$BufferSkip.e, j - 1)));
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }
}
