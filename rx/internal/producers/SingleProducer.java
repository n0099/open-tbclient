package rx.internal.producers;

import com.baidu.tieba.ena;
import com.baidu.tieba.uma;
import com.baidu.tieba.yma;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class SingleProducer<T> extends AtomicBoolean implements uma {
    public static final long serialVersionUID = -3353584923995471404L;
    public final yma<? super T> child;
    public final T value;

    public SingleProducer(yma<? super T> ymaVar, T t) {
        this.child = ymaVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.uma
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                yma<? super T> ymaVar = this.child;
                if (ymaVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    ymaVar.onNext(obj);
                    if (ymaVar.isUnsubscribed()) {
                        return;
                    }
                    ymaVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    ena.g(th, ymaVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
