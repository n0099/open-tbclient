package rx.internal.operators;

import rx.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes2.dex */
public final class aw<T, U, R> implements d.b<rx.d<? extends R>, T> {
    final rx.functions.g<? super T, ? super U, ? extends R> ivF;
    final rx.functions.f<? super T, ? extends rx.d<? extends U>> iyD;

    @Override // rx.functions.f
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.j) ((rx.j) obj));
    }

    public static <T, U> rx.functions.f<T, rx.d<U>> a(final rx.functions.f<? super T, ? extends Iterable<? extends U>> fVar) {
        return new rx.functions.f<T, rx.d<U>>() { // from class: rx.internal.operators.aw.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            /* renamed from: bh */
            public rx.d<U> call(T t) {
                return rx.d.from((Iterable) rx.functions.f.this.call(t));
            }
        };
    }

    public aw(rx.functions.f<? super T, ? extends rx.d<? extends U>> fVar, rx.functions.g<? super T, ? super U, ? extends R> gVar) {
        this.iyD = fVar;
        this.ivF = gVar;
    }

    public rx.j<? super T> call(rx.j<? super rx.d<? extends R>> jVar) {
        a aVar = new a(jVar, this.iyD, this.ivF);
        jVar.add(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a<T, U, R> extends rx.j<T> {
        final rx.j<? super rx.d<? extends R>> actual;
        boolean done;
        final rx.functions.g<? super T, ? super U, ? extends R> ivF;
        final rx.functions.f<? super T, ? extends rx.d<? extends U>> iyD;

        public a(rx.j<? super rx.d<? extends R>> jVar, rx.functions.f<? super T, ? extends rx.d<? extends U>> fVar, rx.functions.g<? super T, ? super U, ? extends R> gVar) {
            this.actual = jVar;
            this.iyD = fVar;
            this.ivF = gVar;
        }

        @Override // rx.e
        public void onNext(T t) {
            try {
                this.actual.onNext(this.iyD.call(t).map(new b(t, this.ivF)));
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

    /* loaded from: classes2.dex */
    static final class b<T, U, R> implements rx.functions.f<U, R> {
        final rx.functions.g<? super T, ? super U, ? extends R> ivF;
        final T iyF;

        public b(T t, rx.functions.g<? super T, ? super U, ? extends R> gVar) {
            this.iyF = t;
            this.ivF = gVar;
        }

        /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: T, ? super T */
        @Override // rx.functions.f
        public R call(U u) {
            return this.ivF.j((T) this.iyF, u);
        }
    }
}
