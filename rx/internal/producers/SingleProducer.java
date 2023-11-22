package rx.internal.producers;

import com.baidu.tieba.ljc;
import com.baidu.tieba.pjc;
import com.baidu.tieba.vjc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class SingleProducer<T> extends AtomicBoolean implements ljc {
    public static final long serialVersionUID = -3353584923995471404L;
    public final pjc<? super T> child;
    public final T value;

    public SingleProducer(pjc<? super T> pjcVar, T t) {
        this.child = pjcVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.ljc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                pjc<? super T> pjcVar = this.child;
                if (pjcVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    pjcVar.onNext(obj);
                    if (pjcVar.isUnsubscribed()) {
                        return;
                    }
                    pjcVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    vjc.g(th, pjcVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
