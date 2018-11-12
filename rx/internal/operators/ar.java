package rx.internal.operators;

import rx.d;
/* loaded from: classes2.dex */
public class ar<T> implements d.b<T, T> {
    final rx.functions.b<? super Long> ixZ;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public ar(rx.functions.b<? super Long> bVar) {
        this.ixZ = bVar;
    }

    public rx.j<? super T> call(rx.j<? super T> jVar) {
        final a aVar = new a(jVar);
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.ar.1
            @Override // rx.f
            public void request(long j) {
                ar.this.ixZ.call(Long.valueOf(j));
                aVar.dv(j);
            }
        });
        jVar.add(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> {
        private final rx.j<? super T> child;

        a(rx.j<? super T> jVar) {
            this.child = jVar;
            request(0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dv(long j) {
            request(j);
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
        }
    }
}
