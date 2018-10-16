package rx.internal.operators;

import rx.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes2.dex */
public class ai<T, R> implements d.b<R, T> {
    final Class<R> ivI;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public ai(Class<R> cls) {
        this.ivI = cls;
    }

    public rx.j<? super T> call(rx.j<? super R> jVar) {
        a aVar = new a(jVar, this.ivI);
        jVar.add(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T, R> extends rx.j<T> {
        final rx.j<? super R> actual;
        boolean done;
        final Class<R> ivI;

        public a(rx.j<? super R> jVar, Class<R> cls) {
            this.actual = jVar;
            this.ivI = cls;
        }

        @Override // rx.e
        public void onNext(T t) {
            try {
                this.actual.onNext(this.ivI.cast(t));
            } catch (Throwable th) {
                rx.exceptions.a.J(th);
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
