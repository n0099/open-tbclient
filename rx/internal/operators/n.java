package rx.internal.operators;

import rx.d;
/* loaded from: classes5.dex */
public final class n<T> implements d.b<T, T> {
    final rx.functions.g<? super T, ? super Integer, Boolean> qBH;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public n(final rx.functions.f<? super T, Boolean> fVar) {
        this(new rx.functions.g<T, Integer, Boolean>() { // from class: rx.internal.operators.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: a */
            public Boolean n(T t, Integer num) {
                return (Boolean) rx.functions.f.this.call(t);
            }
        });
    }

    public n(rx.functions.g<? super T, ? super Integer, Boolean> gVar) {
        this.qBH = gVar;
    }

    public rx.j<? super T> call(final rx.j<? super T> jVar) {
        rx.j jVar2 = (rx.j<T>) new rx.j<T>(jVar, false) { // from class: rx.internal.operators.n.2
            private int counter;
            private boolean done;

            @Override // rx.e
            public void onNext(T t) {
                try {
                    rx.functions.g<? super T, ? super Integer, Boolean> gVar = n.this.qBH;
                    int i = this.counter;
                    this.counter = i + 1;
                    if (gVar.n(t, Integer.valueOf(i)).booleanValue()) {
                        jVar.onNext(t);
                        return;
                    }
                    this.done = true;
                    jVar.onCompleted();
                    unsubscribe();
                } catch (Throwable th) {
                    this.done = true;
                    rx.exceptions.a.a(th, jVar, t);
                    unsubscribe();
                }
            }

            @Override // rx.e
            public void onCompleted() {
                if (!this.done) {
                    jVar.onCompleted();
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
                if (!this.done) {
                    jVar.onError(th);
                }
            }
        };
        jVar.add(jVar2);
        return jVar2;
    }
}
