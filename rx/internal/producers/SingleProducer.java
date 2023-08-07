package rx.internal.producers;

import com.baidu.tieba.d1c;
import com.baidu.tieba.j1c;
import com.baidu.tieba.z0c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class SingleProducer<T> extends AtomicBoolean implements z0c {
    public static final long serialVersionUID = -3353584923995471404L;
    public final d1c<? super T> child;
    public final T value;

    public SingleProducer(d1c<? super T> d1cVar, T t) {
        this.child = d1cVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.z0c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                d1c<? super T> d1cVar = this.child;
                if (d1cVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    d1cVar.onNext(obj);
                    if (d1cVar.isUnsubscribed()) {
                        return;
                    }
                    d1cVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    j1c.g(th, d1cVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
