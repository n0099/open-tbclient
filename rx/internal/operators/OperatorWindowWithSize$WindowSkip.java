package rx.internal.operators;

import com.baidu.tieba.cpc;
import com.baidu.tieba.foc;
import com.baidu.tieba.joc;
import com.baidu.tieba.qoc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class OperatorWindowWithSize$WindowSkip<T> extends joc<T> implements qoc {
    public final int e;
    public final int f;

    /* loaded from: classes2.dex */
    public final class WindowSkipProducer extends AtomicBoolean implements foc {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowSkipProducer() {
        }

        @Override // com.baidu.tieba.foc
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = OperatorWindowWithSize$WindowSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowSkip.e(cpc.c(j, operatorWindowWithSize$WindowSkip.f));
                        return;
                    } else {
                        operatorWindowWithSize$WindowSkip.e(cpc.a(cpc.c(j, operatorWindowWithSize$WindowSkip.e), cpc.c(operatorWindowWithSize$WindowSkip.f - operatorWindowWithSize$WindowSkip.e, j - 1)));
                        return;
                    }
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }
}
