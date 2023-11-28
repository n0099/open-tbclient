package rx.internal.producers;

import com.baidu.tieba.goc;
import com.baidu.tieba.koc;
import com.baidu.tieba.qoc;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class SingleProducer<T> extends AtomicBoolean implements goc {
    public static final long serialVersionUID = -3353584923995471404L;
    public final koc<? super T> child;
    public final T value;

    public SingleProducer(koc<? super T> kocVar, T t) {
        this.child = kocVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.goc
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                koc<? super T> kocVar = this.child;
                if (kocVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    kocVar.onNext(obj);
                    if (kocVar.isUnsubscribed()) {
                        return;
                    }
                    kocVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    qoc.g(th, kocVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
