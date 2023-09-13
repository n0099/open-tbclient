package rx.internal.producers;

import com.baidu.tieba.ebc;
import com.baidu.tieba.uac;
import com.baidu.tieba.yac;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class SingleProducer<T> extends AtomicBoolean implements uac {
    public static final long serialVersionUID = -3353584923995471404L;
    public final yac<? super T> child;
    public final T value;

    public SingleProducer(yac<? super T> yacVar, T t) {
        this.child = yacVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.uac
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                yac<? super T> yacVar = this.child;
                if (yacVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    yacVar.onNext(obj);
                    if (yacVar.isUnsubscribed()) {
                        return;
                    }
                    yacVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    ebc.g(th, yacVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
