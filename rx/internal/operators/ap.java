package rx.internal.operators;

import rx.d;
import rx.internal.util.UtilityFunctions;
/* loaded from: classes2.dex */
public final class ap<T, U> implements d.b<T, T>, rx.functions.g<U, U, Boolean> {
    final rx.functions.f<? super T, ? extends U> iuV;
    final rx.functions.g<? super U, ? super U, Boolean> iwi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        static final ap<?, ?> iwm = new ap<>(UtilityFunctions.ccW());
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> ap<T, T> cbU() {
        return (ap<T, T>) a.iwm;
    }

    public ap(rx.functions.f<? super T, ? extends U> fVar) {
        this.iuV = fVar;
        this.iwi = this;
    }

    public ap(rx.functions.g<? super U, ? super U, Boolean> gVar) {
        this.iuV = UtilityFunctions.ccW();
        this.iwi = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // rx.functions.g
    /* renamed from: k */
    public Boolean j(U u, U u2) {
        return Boolean.valueOf(u == u2 || (u != null && u.equals(u2)));
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: rx.j<T>, rx.j<? super T> */
    public rx.j<? super T> call(final rx.j<? super T> jVar) {
        return (rx.j<T>) new rx.j<T>(jVar) { // from class: rx.internal.operators.ap.1
            U iwj;
            boolean iwk;

            @Override // rx.e
            public void onNext(T t) {
                try {
                    U call = ap.this.iuV.call(t);
                    U u = this.iwj;
                    this.iwj = call;
                    if (this.iwk) {
                        try {
                            if (!ap.this.iwi.j(u, call).booleanValue()) {
                                jVar.onNext(t);
                                return;
                            } else {
                                request(1L);
                                return;
                            }
                        } catch (Throwable th) {
                            rx.exceptions.a.a(th, jVar, call);
                            return;
                        }
                    }
                    this.iwk = true;
                    jVar.onNext(t);
                } catch (Throwable th2) {
                    rx.exceptions.a.a(th2, jVar, t);
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
}
