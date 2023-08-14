package rx.internal.producers;

import com.baidu.tieba.a1c;
import com.baidu.tieba.e1c;
import com.baidu.tieba.k1c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class SingleProducer<T> extends AtomicBoolean implements a1c {
    public static final long serialVersionUID = -3353584923995471404L;
    public final e1c<? super T> child;
    public final T value;

    public SingleProducer(e1c<? super T> e1cVar, T t) {
        this.child = e1cVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.a1c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                e1c<? super T> e1cVar = this.child;
                if (e1cVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    e1cVar.onNext(obj);
                    if (e1cVar.isUnsubscribed()) {
                        return;
                    }
                    e1cVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    k1c.g(th, e1cVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
