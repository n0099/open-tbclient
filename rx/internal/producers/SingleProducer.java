package rx.internal.producers;

import com.baidu.tieba.j7b;
import com.baidu.tieba.n7b;
import com.baidu.tieba.t7b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class SingleProducer<T> extends AtomicBoolean implements j7b {
    public static final long serialVersionUID = -3353584923995471404L;
    public final n7b<? super T> child;
    public final T value;

    public SingleProducer(n7b<? super T> n7bVar, T t) {
        this.child = n7bVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.j7b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                n7b<? super T> n7bVar = this.child;
                if (n7bVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    n7bVar.onNext(obj);
                    if (n7bVar.isUnsubscribed()) {
                        return;
                    }
                    n7bVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    t7b.g(th, n7bVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
