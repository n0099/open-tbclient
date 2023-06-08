package rx.internal.producers;

import com.baidu.tieba.pmb;
import com.baidu.tieba.tmb;
import com.baidu.tieba.zmb;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class SingleProducer<T> extends AtomicBoolean implements pmb {
    public static final long serialVersionUID = -3353584923995471404L;
    public final tmb<? super T> child;
    public final T value;

    public SingleProducer(tmb<? super T> tmbVar, T t) {
        this.child = tmbVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.pmb
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                tmb<? super T> tmbVar = this.child;
                if (tmbVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    tmbVar.onNext(obj);
                    if (tmbVar.isUnsubscribed()) {
                        return;
                    }
                    tmbVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    zmb.g(th, tmbVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
