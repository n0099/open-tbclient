package rx.internal.producers;

import com.baidu.tieba.a2c;
import com.baidu.tieba.g2c;
import com.baidu.tieba.w1c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class SingleProducer<T> extends AtomicBoolean implements w1c {
    public static final long serialVersionUID = -3353584923995471404L;
    public final a2c<? super T> child;
    public final T value;

    public SingleProducer(a2c<? super T> a2cVar, T t) {
        this.child = a2cVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.w1c
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                a2c<? super T> a2cVar = this.child;
                if (a2cVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    a2cVar.onNext(obj);
                    if (a2cVar.isUnsubscribed()) {
                        return;
                    }
                    a2cVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    g2c.g(th, a2cVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
