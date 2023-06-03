package rx.internal.producers;

import com.baidu.tieba.kmb;
import com.baidu.tieba.omb;
import com.baidu.tieba.umb;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class SingleProducer<T> extends AtomicBoolean implements kmb {
    public static final long serialVersionUID = -3353584923995471404L;
    public final omb<? super T> child;
    public final T value;

    public SingleProducer(omb<? super T> ombVar, T t) {
        this.child = ombVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.kmb
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                omb<? super T> ombVar = this.child;
                if (ombVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    ombVar.onNext(obj);
                    if (ombVar.isUnsubscribed()) {
                        return;
                    }
                    ombVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    umb.g(th, ombVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
