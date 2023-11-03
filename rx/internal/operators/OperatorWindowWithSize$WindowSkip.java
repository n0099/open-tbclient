package rx.internal.operators;

import com.baidu.tieba.hkc;
import com.baidu.tieba.kjc;
import com.baidu.tieba.ojc;
import com.baidu.tieba.vjc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class OperatorWindowWithSize$WindowSkip<T> extends ojc<T> implements vjc {
    public final int e;
    public final int f;

    /* loaded from: classes2.dex */
    public final class WindowSkipProducer extends AtomicBoolean implements kjc {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowSkipProducer() {
        }

        @Override // com.baidu.tieba.kjc
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = OperatorWindowWithSize$WindowSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowSkip.e(hkc.c(j, operatorWindowWithSize$WindowSkip.f));
                        return;
                    } else {
                        operatorWindowWithSize$WindowSkip.e(hkc.a(hkc.c(j, operatorWindowWithSize$WindowSkip.e), hkc.c(operatorWindowWithSize$WindowSkip.f - operatorWindowWithSize$WindowSkip.e, j - 1)));
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }
}
