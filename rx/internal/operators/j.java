package rx.internal.operators;

import rx.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes6.dex */
public class j<T, R> implements d.b<R, T> {
    final Class<R> nFS;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public j(Class<R> cls) {
        this.nFS = cls;
    }

    public rx.j<? super T> call(rx.j<? super R> jVar) {
        a aVar = new a(jVar, this.nFS);
        jVar.add(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class a<T, R> extends rx.j<T> {
        final rx.j<? super R> actual;
        boolean done;
        final Class<R> nFS;

        public a(rx.j<? super R> jVar, Class<R> cls) {
            this.actual = jVar;
            this.nFS = cls;
        }

        @Override // rx.e
        public void onNext(T t) {
            try {
                this.actual.onNext(this.nFS.cast(t));
            } catch (Throwable th) {
                rx.exceptions.a.L(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (this.done) {
                rx.c.c.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        @Override // rx.e
        public void onCompleted() {
            if (!this.done) {
                this.actual.onCompleted();
            }
        }

        @Override // rx.j
        public void setProducer(rx.f fVar) {
            this.actual.setProducer(fVar);
        }
    }
}
