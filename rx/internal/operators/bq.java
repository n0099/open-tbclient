package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class bq<T> implements d.b<T, T> {
    private final rx.d<? extends T> izB;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public bq(rx.d<? extends T> dVar) {
        this.izB = dVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        rx.subscriptions.d dVar = new rx.subscriptions.d();
        rx.internal.producers.a aVar = new rx.internal.producers.a();
        b bVar = new b(jVar, dVar, aVar, this.izB);
        dVar.g(bVar);
        jVar.add(dVar);
        jVar.setProducer(aVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b<T> extends rx.j<T> {
        private final rx.j<? super T> child;
        private final rx.internal.producers.a its;
        private final rx.d<? extends T> izB;
        private boolean izC = true;
        private final rx.subscriptions.d serial;

        b(rx.j<? super T> jVar, rx.subscriptions.d dVar, rx.internal.producers.a aVar, rx.d<? extends T> dVar2) {
            this.child = jVar;
            this.serial = dVar;
            this.its = aVar;
            this.izB = dVar2;
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.its.setProducer(fVar);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.izC) {
                this.child.onCompleted();
            } else if (!this.child.isUnsubscribed()) {
                cct();
            }
        }

        private void cct() {
            a aVar = new a(this.child, this.its);
            this.serial.g(aVar);
            this.izB.unsafeSubscribe(aVar);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.child.onError(th);
        }

        @Override // rx.e
        public void onNext(T t) {
            this.izC = false;
            this.child.onNext(t);
            this.its.dJ(1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> {
        private final rx.j<? super T> child;
        private final rx.internal.producers.a its;

        a(rx.j<? super T> jVar, rx.internal.producers.a aVar) {
            this.child = jVar;
            this.its = aVar;
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.its.setProducer(fVar);
        }

        @Override // rx.e
        public void onCompleted() {
            this.child.onCompleted();
        }

        @Override // rx.e
        public void onError(Throwable th) {
            this.child.onError(th);
        }

        @Override // rx.e
        public void onNext(T t) {
            this.child.onNext(t);
            this.its.dJ(1L);
        }
    }
}
