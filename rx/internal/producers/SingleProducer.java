package rx.internal.producers;

import com.baidu.tieba.p7c;
import com.baidu.tieba.t7c;
import com.baidu.tieba.z7c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class SingleProducer<T> extends AtomicBoolean implements p7c {
    public static final long serialVersionUID = -3353584923995471404L;
    public final t7c<? super T> child;
    public final T value;

    public SingleProducer(t7c<? super T> t7cVar, T t) {
        this.child = t7cVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.p7c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                t7c<? super T> t7cVar = this.child;
                if (t7cVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    t7cVar.onNext(obj);
                    if (t7cVar.isUnsubscribed()) {
                        return;
                    }
                    t7cVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    z7c.g(th, t7cVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
