package rx.internal.operators;

import h.f;
import h.j;
import h.o.a.a;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class OperatorBufferWithSize$BufferSkip<T> extends j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final int f69344e;

    /* renamed from: f  reason: collision with root package name */
    public final int f69345f;

    /* loaded from: classes7.dex */
    public final class BufferSkipProducer extends AtomicBoolean implements f {
        public static final long serialVersionUID = 3428177408082367154L;

        public BufferSkipProducer() {
        }

        @Override // h.f
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            } else if (i != 0) {
                OperatorBufferWithSize$BufferSkip operatorBufferWithSize$BufferSkip = OperatorBufferWithSize$BufferSkip.this;
                if (get() || !compareAndSet(false, true)) {
                    operatorBufferWithSize$BufferSkip.request(a.c(j, operatorBufferWithSize$BufferSkip.f69345f));
                } else {
                    operatorBufferWithSize$BufferSkip.request(a.a(a.c(j, operatorBufferWithSize$BufferSkip.f69344e), a.c(operatorBufferWithSize$BufferSkip.f69345f - operatorBufferWithSize$BufferSkip.f69344e, j - 1)));
                }
            }
        }
    }
}
