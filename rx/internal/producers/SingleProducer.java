package rx.internal.producers;

import com.baidu.tieba.mcc;
import com.baidu.tieba.qcc;
import com.baidu.tieba.wcc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class SingleProducer<T> extends AtomicBoolean implements mcc {
    public static final long serialVersionUID = -3353584923995471404L;
    public final qcc<? super T> child;
    public final T value;

    public SingleProducer(qcc<? super T> qccVar, T t) {
        this.child = qccVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.mcc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                qcc<? super T> qccVar = this.child;
                if (qccVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    qccVar.onNext(obj);
                    if (qccVar.isUnsubscribed()) {
                        return;
                    }
                    qccVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    wcc.g(th, qccVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
