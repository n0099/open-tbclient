package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.d;
/* loaded from: classes2.dex */
public final class q<T> implements d.a<T> {
    final rx.d<T> iFW;
    final rx.functions.g<T, T, T> iHN;

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.j) ((rx.j) obj));
    }

    public q(rx.d<T> dVar, rx.functions.g<T, T, T> gVar) {
        this.iFW = dVar;
        this.iHN = gVar;
    }

    public void call(rx.j<? super T> jVar) {
        final a aVar = new a(jVar, this.iHN);
        jVar.add(aVar);
        jVar.setProducer(new rx.f() { // from class: rx.internal.operators.q.1
            @Override // rx.f
            public void request(long j) {
                aVar.dG(j);
            }
        });
        this.iFW.unsafeSubscribe(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T> extends rx.j<T> {
        static final Object EMPTY = new Object();
        final rx.j<? super T> actual;
        boolean done;
        final rx.functions.g<T, T, T> iHN;
        T value = (T) EMPTY;

        public a(rx.j<? super T> jVar, rx.functions.g<T, T, T> gVar) {
            this.actual = jVar;
            this.iHN = gVar;
            request(0L);
        }

        @Override // rx.e
        public void onNext(T t) {
            if (!this.done) {
                T t2 = this.value;
                if (t2 == EMPTY) {
                    this.value = t;
                    return;
                }
                try {
                    this.value = this.iHN.j(t2, t);
                } catch (Throwable th) {
                    rx.exceptions.a.J(th);
                    unsubscribe();
                    onError(th);
                }
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (!this.done) {
                this.done = true;
                this.actual.onError(th);
                return;
            }
            rx.c.c.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                T t = this.value;
                if (t != EMPTY) {
                    this.actual.onNext(t);
                    this.actual.onCompleted();
                    return;
                }
                this.actual.onError(new NoSuchElementException());
            }
        }

        void dG(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
            if (j != 0) {
                request(Long.MAX_VALUE);
            }
        }
    }
}
