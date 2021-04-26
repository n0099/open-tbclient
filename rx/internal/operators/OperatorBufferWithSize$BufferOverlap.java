package rx.internal.operators;

import h.f;
import h.j;
import h.o.a.a;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class OperatorBufferWithSize$BufferOverlap<T> extends j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final j<? super List<T>> f68379e;

    /* renamed from: f  reason: collision with root package name */
    public final int f68380f;

    /* renamed from: g  reason: collision with root package name */
    public final int f68381g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayDeque<List<T>> f68382h;

    /* renamed from: i  reason: collision with root package name */
    public final AtomicLong f68383i;

    /* loaded from: classes7.dex */
    public final class BufferOverlapProducer extends AtomicBoolean implements f {
        public static final long serialVersionUID = -4015894850868853147L;

        public BufferOverlapProducer() {
        }

        @Override // h.f
        public void request(long j) {
            OperatorBufferWithSize$BufferOverlap operatorBufferWithSize$BufferOverlap = OperatorBufferWithSize$BufferOverlap.this;
            if (!a.e(operatorBufferWithSize$BufferOverlap.f68383i, j, operatorBufferWithSize$BufferOverlap.f68382h, operatorBufferWithSize$BufferOverlap.f68379e) || j == 0) {
                return;
            }
            if (get() || !compareAndSet(false, true)) {
                operatorBufferWithSize$BufferOverlap.request(a.c(operatorBufferWithSize$BufferOverlap.f68381g, j));
            } else {
                operatorBufferWithSize$BufferOverlap.request(a.a(a.c(operatorBufferWithSize$BufferOverlap.f68381g, j - 1), operatorBufferWithSize$BufferOverlap.f68380f));
            }
        }
    }
}
