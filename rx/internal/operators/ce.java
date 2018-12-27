package rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import rx.d;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes2.dex */
public final class ce<T> implements d.b<List<T>, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        static final ce<Object> iMt = new ce<>();
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> ce<T> ceK() {
        return (ce<T>) a.iMt;
    }

    ce() {
    }

    public rx.j<? super T> call(final rx.j<? super List<T>> jVar) {
        final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(jVar);
        rx.j jVar2 = (rx.j<T>) new rx.j<T>() { // from class: rx.internal.operators.ce.1
            boolean completed;
            List<T> list = new LinkedList();

            @Override // rx.j
            public void onStart() {
                request(Long.MAX_VALUE);
            }

            @Override // rx.e
            public void onCompleted() {
                if (!this.completed) {
                    this.completed = true;
                    try {
                        ArrayList arrayList = new ArrayList(this.list);
                        this.list = null;
                        singleDelayedProducer.setValue(arrayList);
                    } catch (Throwable th) {
                        rx.exceptions.a.a(th, this);
                    }
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
                jVar.onError(th);
            }

            @Override // rx.e
            public void onNext(T t) {
                if (!this.completed) {
                    this.list.add(t);
                }
            }
        };
        jVar.add(jVar2);
        jVar.setProducer(singleDelayedProducer);
        return jVar2;
    }
}
