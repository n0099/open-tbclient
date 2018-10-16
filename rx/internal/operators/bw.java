package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public final class bw<T> implements d.b<T, T> {
    final rx.functions.f<? super T, Boolean> izO;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public bw(rx.functions.f<? super T, Boolean> fVar) {
        this.izO = fVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        final a aVar = new a(jVar);
        jVar.add(aVar);
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.bw.1
            @Override // rx.f
            public void request(long j) {
                aVar.dz(j);
            }
        });
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class a extends rx.j<T> {
        private final rx.j<? super T> child;
        private boolean done;

        a(rx.j<? super T> jVar) {
            this.child = jVar;
        }

        @Override // rx.e
        public void onNext(T t) {
            this.child.onNext(t);
            try {
                if (bw.this.izO.call(t).booleanValue()) {
                    this.done = true;
                    this.child.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                this.done = true;
                rx.exceptions.a.a(th, this.child, t);
                unsubscribe();
            }
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.done) {
                this.child.onCompleted();
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.done) {
                this.child.onError(th);
            }
        }

        void dz(long j) {
            request(j);
        }
    }
}
