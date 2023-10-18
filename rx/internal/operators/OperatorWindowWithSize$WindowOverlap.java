package rx.internal.operators;

import com.baidu.tieba.g7c;
import com.baidu.tieba.j6c;
import com.baidu.tieba.n6c;
import com.baidu.tieba.u6c;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OperatorWindowWithSize$WindowOverlap<T> extends n6c<T> implements u6c {
    public final int e;
    public final int f;
    public final AtomicLong g;

    public abstract void i();

    /* loaded from: classes2.dex */
    public final class WindowOverlapProducer extends AtomicBoolean implements j6c {
        public static final long serialVersionUID = 4625807964358024108L;

        public WindowOverlapProducer() {
        }

        @Override // com.baidu.tieba.j6c
        public void request(long j) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    OperatorWindowWithSize$WindowOverlap operatorWindowWithSize$WindowOverlap = OperatorWindowWithSize$WindowOverlap.this;
                    if (!get() && compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowOverlap.e(g7c.a(g7c.c(operatorWindowWithSize$WindowOverlap.f, j - 1), operatorWindowWithSize$WindowOverlap.e));
                    } else {
                        OperatorWindowWithSize$WindowOverlap.this.e(g7c.c(operatorWindowWithSize$WindowOverlap.f, j));
                    }
                    g7c.b(operatorWindowWithSize$WindowOverlap.g, j);
                    operatorWindowWithSize$WindowOverlap.i();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
    }
}
