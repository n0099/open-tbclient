package rx.internal.producers;

import com.baidu.tieba.p1b;
import com.baidu.tieba.t1b;
import com.baidu.tieba.z1b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class SingleProducer<T> extends AtomicBoolean implements p1b {
    public static final long serialVersionUID = -3353584923995471404L;
    public final t1b<? super T> child;
    public final T value;

    public SingleProducer(t1b<? super T> t1bVar, T t) {
        this.child = t1bVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.p1b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                t1b<? super T> t1bVar = this.child;
                if (t1bVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    t1bVar.onNext(obj);
                    if (t1bVar.isUnsubscribed()) {
                        return;
                    }
                    t1bVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    z1b.g(th, t1bVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
