package rx.internal.operators;

import com.baidu.tieba.cpc;
import com.baidu.tieba.foc;
import com.baidu.tieba.joc;
import com.baidu.tieba.qoc;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorWindowWithSize$WindowOverlap<T> extends joc<T> implements qoc {
    public final int e;
    public final int f;
    public final AtomicLong g;

    public abstract void i();

    /* loaded from: classes2.dex */
    public final class WindowOverlapProducer extends AtomicBoolean implements foc {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowOverlapProducer() {
        }

        @Override // com.baidu.tieba.foc
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorWindowWithSize$WindowOverlap operatorWindowWithSize$WindowOverlap = OperatorWindowWithSize$WindowOverlap.this;
                    if (!get() && compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowOverlap.e(cpc.a(cpc.c(operatorWindowWithSize$WindowOverlap.f, j - 1), operatorWindowWithSize$WindowOverlap.e));
                    } else {
                        OperatorWindowWithSize$WindowOverlap.this.e(cpc.c(operatorWindowWithSize$WindowOverlap.f, j));
                    }
                    cpc.b(operatorWindowWithSize$WindowOverlap.g, j);
                    operatorWindowWithSize$WindowOverlap.i();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }
}
