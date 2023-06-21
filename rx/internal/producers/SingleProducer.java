package rx.internal.producers;

import com.baidu.tieba.iob;
import com.baidu.tieba.mob;
import com.baidu.tieba.sob;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class SingleProducer<T> extends AtomicBoolean implements iob {
    public static final long serialVersionUID = -3353584923995471404L;
    public final mob<? super T> child;
    public final T value;

    public SingleProducer(mob<? super T> mobVar, T t) {
        this.child = mobVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.iob
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                mob<? super T> mobVar = this.child;
                if (mobVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    mobVar.onNext(obj);
                    if (mobVar.isUnsubscribed()) {
                        return;
                    }
                    mobVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    sob.g(th, mobVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
