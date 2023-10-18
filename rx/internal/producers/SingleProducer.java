package rx.internal.producers;

import com.baidu.tieba.j6c;
import com.baidu.tieba.n6c;
import com.baidu.tieba.t6c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class SingleProducer<T> extends AtomicBoolean implements j6c {
    public static final long serialVersionUID = -3353584923995471404L;
    public final n6c<? super T> child;
    public final T value;

    public SingleProducer(n6c<? super T> n6cVar, T t) {
        this.child = n6cVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.j6c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                n6c<? super T> n6cVar = this.child;
                if (n6cVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    n6cVar.onNext(obj);
                    if (n6cVar.isUnsubscribed()) {
                        return;
                    }
                    n6cVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    t6c.g(th, n6cVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
