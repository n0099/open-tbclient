package rx.internal.operators;

import com.baidu.tieba.dpc;
import com.baidu.tieba.goc;
import com.baidu.tieba.koc;
import com.baidu.tieba.roc;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorWindowWithSize$WindowOverlap<T> extends koc<T> implements roc {
    public final int e;
    public final int f;
    public final AtomicLong g;

    public abstract void i();

    /* loaded from: classes2.dex */
    public final class WindowOverlapProducer extends AtomicBoolean implements goc {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowOverlapProducer() {
        }

        @Override // com.baidu.tieba.goc
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorWindowWithSize$WindowOverlap operatorWindowWithSize$WindowOverlap = OperatorWindowWithSize$WindowOverlap.this;
                    if (!get() && compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowOverlap.e(dpc.a(dpc.c(operatorWindowWithSize$WindowOverlap.f, j - 1), operatorWindowWithSize$WindowOverlap.e));
                    } else {
                        OperatorWindowWithSize$WindowOverlap.this.e(dpc.c(operatorWindowWithSize$WindowOverlap.f, j));
                    }
                    dpc.b(operatorWindowWithSize$WindowOverlap.g, j);
                    operatorWindowWithSize$WindowOverlap.i();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }
}
