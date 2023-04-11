package rx.internal.producers;

import com.baidu.tieba.h1b;
import com.baidu.tieba.l1b;
import com.baidu.tieba.r1b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class SingleProducer<T> extends AtomicBoolean implements h1b {
    public static final long serialVersionUID = -3353584923995471404L;
    public final l1b<? super T> child;
    public final T value;

    public SingleProducer(l1b<? super T> l1bVar, T t) {
        this.child = l1bVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.h1b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                l1b<? super T> l1bVar = this.child;
                if (l1bVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    l1bVar.onNext(obj);
                    if (l1bVar.isUnsubscribed()) {
                        return;
                    }
                    l1bVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    r1b.g(th, l1bVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
