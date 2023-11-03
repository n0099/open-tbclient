package rx.internal.producers;

import com.baidu.tieba.kjc;
import com.baidu.tieba.ojc;
import com.baidu.tieba.ujc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class SingleProducer<T> extends AtomicBoolean implements kjc {
    public static final long serialVersionUID = -3353584923995471404L;
    public final ojc<? super T> child;
    public final T value;

    public SingleProducer(ojc<? super T> ojcVar, T t) {
        this.child = ojcVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.kjc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                ojc<? super T> ojcVar = this.child;
                if (ojcVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    ojcVar.onNext(obj);
                    if (ojcVar.isUnsubscribed()) {
                        return;
                    }
                    ojcVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    ujc.g(th, ojcVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
