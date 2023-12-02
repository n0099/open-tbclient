package rx.internal.producers;

import com.baidu.tieba.foc;
import com.baidu.tieba.joc;
import com.baidu.tieba.poc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class SingleProducer<T> extends AtomicBoolean implements foc {
    public static final long serialVersionUID = -3353584923995471404L;
    public final joc<? super T> child;
    public final T value;

    public SingleProducer(joc<? super T> jocVar, T t) {
        this.child = jocVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.foc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                joc<? super T> jocVar = this.child;
                if (jocVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    jocVar.onNext(obj);
                    if (jocVar.isUnsubscribed()) {
                        return;
                    }
                    jocVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    poc.g(th, jocVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
