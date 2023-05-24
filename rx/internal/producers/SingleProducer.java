package rx.internal.producers;

import com.baidu.tieba.k7b;
import com.baidu.tieba.o7b;
import com.baidu.tieba.u7b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class SingleProducer<T> extends AtomicBoolean implements k7b {
    public static final long serialVersionUID = -3353584923995471404L;
    public final o7b<? super T> child;
    public final T value;

    public SingleProducer(o7b<? super T> o7bVar, T t) {
        this.child = o7bVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.k7b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                o7b<? super T> o7bVar = this.child;
                if (o7bVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    o7bVar.onNext(obj);
                    if (o7bVar.isUnsubscribed()) {
                        return;
                    }
                    o7bVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    u7b.g(th, o7bVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
