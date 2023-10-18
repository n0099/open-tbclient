package rx.internal.operators;

import com.baidu.tieba.g7c;
import com.baidu.tieba.j6c;
import com.baidu.tieba.n6c;
import com.baidu.tieba.u6c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class OperatorWindowWithSize$WindowSkip<T> extends n6c<T> implements u6c {
    public final int e;
    public final int f;

    /* loaded from: classes2.dex */
    public final class WindowSkipProducer extends AtomicBoolean implements j6c {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowSkipProducer() {
        }

        @Override // com.baidu.tieba.j6c
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = OperatorWindowWithSize$WindowSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowSkip.e(g7c.c(j, operatorWindowWithSize$WindowSkip.f));
                        return;
                    } else {
                        operatorWindowWithSize$WindowSkip.e(g7c.a(g7c.c(j, operatorWindowWithSize$WindowSkip.e), g7c.c(operatorWindowWithSize$WindowSkip.f - operatorWindowWithSize$WindowSkip.e, j - 1)));
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }
}
