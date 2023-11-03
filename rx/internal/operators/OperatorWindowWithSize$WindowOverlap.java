package rx.internal.operators;

import com.baidu.tieba.hkc;
import com.baidu.tieba.kjc;
import com.baidu.tieba.ojc;
import com.baidu.tieba.vjc;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorWindowWithSize$WindowOverlap<T> extends ojc<T> implements vjc {
    public final int e;
    public final int f;
    public final AtomicLong g;

    public abstract void i();

    /* loaded from: classes2.dex */
    public final class WindowOverlapProducer extends AtomicBoolean implements kjc {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowOverlapProducer() {
        }

        @Override // com.baidu.tieba.kjc
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorWindowWithSize$WindowOverlap operatorWindowWithSize$WindowOverlap = OperatorWindowWithSize$WindowOverlap.this;
                    if (!get() && compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowOverlap.e(hkc.a(hkc.c(operatorWindowWithSize$WindowOverlap.f, j - 1), operatorWindowWithSize$WindowOverlap.e));
                    } else {
                        OperatorWindowWithSize$WindowOverlap.this.e(hkc.c(operatorWindowWithSize$WindowOverlap.f, j));
                    }
                    hkc.b(operatorWindowWithSize$WindowOverlap.g, j);
                    operatorWindowWithSize$WindowOverlap.i();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }
}
