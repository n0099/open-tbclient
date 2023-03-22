package rx.internal.producers;

import com.baidu.tieba.asa;
import com.baidu.tieba.qra;
import com.baidu.tieba.ura;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class SingleProducer<T> extends AtomicBoolean implements qra {
    public static final long serialVersionUID = -3353584923995471404L;
    public final ura<? super T> child;
    public final T value;

    public SingleProducer(ura<? super T> uraVar, T t) {
        this.child = uraVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.qra
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                ura<? super T> uraVar = this.child;
                if (uraVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    uraVar.onNext(obj);
                    if (uraVar.isUnsubscribed()) {
                        return;
                    }
                    uraVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    asa.g(th, uraVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
