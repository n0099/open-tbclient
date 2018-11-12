package rx.internal.operators;

import rx.d;
import rx.internal.util.UtilityFunctions;
/* loaded from: classes2.dex */
public final class ap<T, U> implements d.b<T, T>, rx.functions.g<U, U, Boolean> {
    final rx.functions.f<? super T, ? extends U> iwG;
    final rx.functions.g<? super U, ? super U, Boolean> ixT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {
        static final ap<?, ?> ixX = new ap<>(UtilityFunctions.cct());
    }

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T> ap<T, T> cbr() {
        return (ap<T, T>) a.ixX;
    }

    public ap(rx.functions.f<? super T, ? extends U> fVar) {
        this.iwG = fVar;
        this.ixT = this;
    }

    public ap(rx.functions.g<? super U, ? super U, Boolean> gVar) {
        this.iwG = UtilityFunctions.cct();
        this.ixT = gVar;
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
            U ixU;
            boolean ixV;

            @Override // rx.e
            public void onNext(T t) {
                try {
                    U call = ap.this.iwG.call(t);
                    U u = this.ixU;
                    this.ixU = call;
                    if (this.ixV) {
                        try {
                            if (!ap.this.ixT.j(u, call).booleanValue()) {
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
                    this.ixV = true;
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
