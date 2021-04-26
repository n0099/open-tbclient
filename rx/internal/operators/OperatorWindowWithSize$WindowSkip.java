package rx.internal.operators;

import h.f;
import h.j;
import h.n.a;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class OperatorWindowWithSize$WindowSkip<T> extends j<T> implements a {

    /* renamed from: e  reason: collision with root package name */
    public final int f68419e;

    /* renamed from: f  reason: collision with root package name */
    public final int f68420f;

    /* loaded from: classes7.dex */
    public final class WindowSkipProducer extends AtomicBoolean implements f {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowSkipProducer() {
        }

        @Override // h.f
        public void request(long j) {
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            } else if (i2 != 0) {
                OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = OperatorWindowWithSize$WindowSkip.this;
                if (get() || !compareAndSet(false, true)) {
                    operatorWindowWithSize$WindowSkip.request(h.o.a.a.c(j, operatorWindowWithSize$WindowSkip.f68420f));
                } else {
                    operatorWindowWithSize$WindowSkip.request(h.o.a.a.a(h.o.a.a.c(j, operatorWindowWithSize$WindowSkip.f68419e), h.o.a.a.c(operatorWindowWithSize$WindowSkip.f68420f - operatorWindowWithSize$WindowSkip.f68419e, j - 1)));
                }
            }
        }
    }
}
