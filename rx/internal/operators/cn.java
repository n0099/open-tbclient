package rx.internal.operators;

import java.util.Iterator;
import rx.d;
/* loaded from: classes2.dex */
public final class cn<T1, T2, R> implements d.b<R, T1> {
    final Iterable<? extends T2> iCW;
    final rx.functions.g<? super T1, ? super T2, ? extends R> iCX;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public cn(Iterable<? extends T2> iterable, rx.functions.g<? super T1, ? super T2, ? extends R> gVar) {
        this.iCW = iterable;
        this.iCX = gVar;
    }

    /* JADX DEBUG: Type inference failed for r0v4. Raw type applied. Possible types: rx.j<T1>, rx.j<? super T1> */
    public rx.j<? super T1> call(final rx.j<? super R> jVar) {
        final Iterator<? extends T2> it = this.iCW.iterator();
        try {
            if (!it.hasNext()) {
                jVar.onCompleted();
                return rx.b.g.ccK();
            }
            return (rx.j<T1>) new rx.j<T1>(jVar) { // from class: rx.internal.operators.cn.1
                boolean done;

                @Override // rx.e
                public void onCompleted() {
                    if (!this.done) {
                        this.done = true;
                        jVar.onCompleted();
                    }
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    if (this.done) {
                        rx.exceptions.a.J(th);
                        return;
                    }
                    this.done = true;
                    jVar.onError(th);
                }

                @Override // rx.e
                public void onNext(T1 t1) {
                    if (!this.done) {
                        try {
                            jVar.onNext(cn.this.iCX.j(t1, (Object) it.next()));
                            if (!it.hasNext()) {
                                onCompleted();
                            }
                        } catch (Throwable th) {
                            rx.exceptions.a.a(th, this);
                        }
                    }
                }
            };
        } catch (Throwable th) {
            rx.exceptions.a.a(th, jVar);
            return rx.b.g.ccK();
        }
    }
}
