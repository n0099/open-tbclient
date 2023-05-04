package rx.internal.producers;

import com.baidu.tieba.l5b;
import com.baidu.tieba.p5b;
import com.baidu.tieba.v5b;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class SingleProducer<T> extends AtomicBoolean implements l5b {
    public static final long serialVersionUID = -3353584923995471404L;
    public final p5b<? super T> child;
    public final T value;

    public SingleProducer(p5b<? super T> p5bVar, T t) {
        this.child = p5bVar;
        this.value = t;
    }

    @Override // com.baidu.tieba.l5b
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (i != 0 && compareAndSet(false, true)) {
                p5b<? super T> p5bVar = this.child;
                if (p5bVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    p5bVar.onNext(obj);
                    if (p5bVar.isUnsubscribed()) {
                        return;
                    }
                    p5bVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    v5b.g(th, p5bVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
