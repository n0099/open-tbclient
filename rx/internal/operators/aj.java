package rx.internal.operators;

import rx.d;
import rx.internal.operators.ak;
/* loaded from: classes2.dex */
public final class aj<T, U> implements d.b<T, T> {
    final rx.functions.f<? super T, ? extends rx.d<U>> iHN;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public aj(rx.functions.f<? super T, ? extends rx.d<U>> fVar) {
        this.iHN = fVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        rx.b.f fVar = new rx.b.f(jVar);
        rx.subscriptions.d dVar = new rx.subscriptions.d();
        jVar.add(dVar);
        return new AnonymousClass1(jVar, fVar, dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rx.internal.operators.aj$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 extends rx.j<T> {
        final /* synthetic */ rx.subscriptions.d iFD;
        final ak.a<T> iHO;
        final rx.j<?> iHP;
        final /* synthetic */ rx.b.f iHQ;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(rx.j jVar, rx.b.f fVar, rx.subscriptions.d dVar) {
            super(jVar);
            this.iHQ = fVar;
            this.iFD = dVar;
            this.iHO = new ak.a<>();
            this.iHP = this;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(T t) {
            try {
                rx.d<U> call = aj.this.iHN.call(t);
                final int bg = this.iHO.bg(t);
                rx.j<U> jVar = new rx.j<U>() { // from class: rx.internal.operators.aj.1.1
                    @Override // rx.e
                    public void onNext(U u) {
                        onCompleted();
                    }

                    @Override // rx.e
                    public void onError(Throwable th) {
                        AnonymousClass1.this.iHP.onError(th);
                    }

                    @Override // rx.e
                    public void onCompleted() {
                        AnonymousClass1.this.iHO.a(bg, AnonymousClass1.this.iHQ, AnonymousClass1.this.iHP);
                        unsubscribe();
                    }
                };
                this.iFD.g(jVar);
                call.unsafeSubscribe(jVar);
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this);
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.iHQ.onError(th);
            unsubscribe();
            this.iHO.clear();
        }

        @Override // rx.e
        public void onCompleted() {
            this.iHO.a(this.iHQ, this);
        }
    }
}
