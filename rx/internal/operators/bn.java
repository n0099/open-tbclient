package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class bn<T> implements d.b<T, T> {
    final rx.functions.g<? super T, Integer, Boolean> iKy;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public bn(rx.functions.g<? super T, Integer, Boolean> gVar) {
        this.iKy = gVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: rx.j<T>, rx.j<? super T> */
    public rx.j<? super T> call(final rx.j<? super T> jVar) {
        return (rx.j<T>) new rx.j<T>(jVar) { // from class: rx.internal.operators.bn.1
            boolean iLl = true;
            int index;

            @Override // rx.e
            public void onNext(T t) {
                if (!this.iLl) {
                    jVar.onNext(t);
                    return;
                }
                try {
                    rx.functions.g<? super T, Integer, Boolean> gVar = bn.this.iKy;
                    int i = this.index;
                    this.index = i + 1;
                    if (!gVar.j(t, Integer.valueOf(i)).booleanValue()) {
                        this.iLl = false;
                        jVar.onNext(t);
                        return;
                    }
                    request(1L);
                } catch (Throwable th) {
                    rx.exceptions.a.a(th, jVar, t);
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
                jVar.onError(th);
            }

            @Override // rx.e
            public void onCompleted() {
                jVar.onCompleted();
            }
        };
    }

    public static <T> rx.functions.g<T, Integer, Boolean> c(final rx.functions.f<? super T, Boolean> fVar) {
        return new rx.functions.g<T, Integer, Boolean>() { // from class: rx.internal.operators.bn.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.g
            /* renamed from: a */
            public Boolean j(T t, Integer num) {
                return (Boolean) rx.functions.f.this.call(t);
            }
        };
    }
}
