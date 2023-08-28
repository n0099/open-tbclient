package rx.internal.producers;

import com.baidu.tieba.b8c;
import com.baidu.tieba.r7c;
import com.baidu.tieba.v7c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class SingleProducer<T> extends AtomicBoolean implements r7c {
    public static final long serialVersionUID = -3353584923995471404L;
    public final v7c<? super T> child;
    public final T value;

    public SingleProducer(v7c<? super T> v7cVar, T t) {
        this.child = v7cVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.r7c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                v7c<? super T> v7cVar = this.child;
                if (v7cVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    v7cVar.onNext(obj);
                    if (v7cVar.isUnsubscribed()) {
                        return;
                    }
                    v7cVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    b8c.g(th, v7cVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
