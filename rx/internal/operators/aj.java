package rx.internal.operators;

import rx.d;
import rx.internal.operators.ak;
/* loaded from: classes2.dex */
public final class aj<T, U> implements d.b<T, T> {
    final rx.functions.f<? super T, ? extends rx.d<U>> ivK;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public aj(rx.functions.f<? super T, ? extends rx.d<U>> fVar) {
        this.ivK = fVar;
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
        final /* synthetic */ rx.subscriptions.d itA;
        final ak.a<T> ivL;
        final rx.j<?> ivM;
        final /* synthetic */ rx.b.f ivN;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(rx.j jVar, rx.b.f fVar, rx.subscriptions.d dVar) {
            super(jVar);
            this.ivN = fVar;
            this.itA = dVar;
            this.ivL = new ak.a<>();
            this.ivM = this;
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.e
        public void onNext(T t) {
            try {
                rx.d<U> call = aj.this.ivK.call(t);
                final int bg = this.ivL.bg(t);
                rx.j<U> jVar = new rx.j<U>() { // from class: rx.internal.operators.aj.1.1
                    @Override // rx.e
                    public void onNext(U u) {
                        onCompleted();
                    }

                    @Override // rx.e
                    public void onError(Throwable th) {
                        AnonymousClass1.this.ivM.onError(th);
                    }

                    @Override // rx.e
                    public void onCompleted() {
                        AnonymousClass1.this.ivL.a(bg, AnonymousClass1.this.ivN, AnonymousClass1.this.ivM);
                        unsubscribe();
                    }
                };
                this.itA.g(jVar);
                call.unsafeSubscribe(jVar);
            } catch (Throwable th) {
                rx.exceptions.a.a(th, this);
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.ivN.onError(th);
            unsubscribe();
            this.ivL.clear();
        }

        @Override // rx.e
        public void onCompleted() {
            this.ivL.a(this.ivN, this);
        }
    }
}
