package rx.internal.operators;

import com.baidu.tieba.d8b;
import com.baidu.tieba.k7b;
import com.baidu.tieba.o7b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class OperatorBufferWithSize$BufferSkip<T> extends o7b<T> {
    public final int e;
    public final int f;

    /* loaded from: classes10.dex */
    public final class BufferSkipProducer extends AtomicBoolean implements k7b {
        public static final long serialVersionUID = 3428177408082367154L;

        public BufferSkipProducer() {
        }

        @Override // com.baidu.tieba.k7b
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorBufferWithSize$BufferSkip operatorBufferWithSize$BufferSkip = OperatorBufferWithSize$BufferSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        operatorBufferWithSize$BufferSkip.e(d8b.c(j, operatorBufferWithSize$BufferSkip.f));
                        return;
                    } else {
                        operatorBufferWithSize$BufferSkip.e(d8b.a(d8b.c(j, operatorBufferWithSize$BufferSkip.e), d8b.c(operatorBufferWithSize$BufferSkip.f - operatorBufferWithSize$BufferSkip.e, j - 1)));
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }
}
