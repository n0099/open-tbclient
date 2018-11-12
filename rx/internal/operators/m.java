package rx.internal.operators;

import java.util.concurrent.Callable;
import rx.d;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes2.dex */
public final class m<T> implements d.a<T> {
    private final Callable<? extends T> ivw;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public m(Callable<? extends T> callable) {
        this.ivw = callable;
    }

    public void call(rx.j<? super T> jVar) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(jVar);
        jVar.setProducer(singleDelayedProducer);
        try {
            singleDelayedProducer.setValue(this.ivw.call());
        } catch (Throwable th) {
            rx.exceptions.a.a(th, jVar);
        }
    }
}
