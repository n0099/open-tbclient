package rx.internal.operators;

import h.f;
import h.j;
import h.n.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class OperatorWindowWithSize$WindowOverlap<T> extends j<T> implements a {

    /* renamed from: e  reason: collision with root package name */
    public final int f68416e;

    /* renamed from: f  reason: collision with root package name */
    public final int f68417f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicLong f68418g;

    /* loaded from: classes7.dex */
    public final class WindowOverlapProducer extends AtomicBoolean implements f {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowOverlapProducer() {
        }

        @Override // h.f
        public void request(long j) {
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            } else if (i2 != 0) {
                OperatorWindowWithSize$WindowOverlap operatorWindowWithSize$WindowOverlap = OperatorWindowWithSize$WindowOverlap.this;
                if (!get() && compareAndSet(false, true)) {
                    operatorWindowWithSize$WindowOverlap.request(h.o.a.a.a(h.o.a.a.c(operatorWindowWithSize$WindowOverlap.f68417f, j - 1), operatorWindowWithSize$WindowOverlap.f68416e));
                } else {
                    OperatorWindowWithSize$WindowOverlap.this.request(h.o.a.a.c(operatorWindowWithSize$WindowOverlap.f68417f, j));
                }
                h.o.a.a.b(operatorWindowWithSize$WindowOverlap.f68418g, j);
                operatorWindowWithSize$WindowOverlap.d();
            }
        }
    }

    public abstract void d();
}
