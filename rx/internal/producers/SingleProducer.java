package rx.internal.producers;

import com.baidu.tieba.dtb;
import com.baidu.tieba.jtb;
import com.baidu.tieba.zsb;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class SingleProducer<T> extends AtomicBoolean implements zsb {
    public static final long serialVersionUID = -3353584923995471404L;
    public final dtb<? super T> child;
    public final T value;

    public SingleProducer(dtb<? super T> dtbVar, T t) {
        this.child = dtbVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.zsb
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                dtb<? super T> dtbVar = this.child;
                if (dtbVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    dtbVar.onNext(obj);
                    if (dtbVar.isUnsubscribed()) {
                        return;
                    }
                    dtbVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    jtb.g(th, dtbVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
