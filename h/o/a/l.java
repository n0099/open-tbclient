package h.o.a;

import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public class l<T, R> implements d.b<R, T> {

    /* renamed from: e  reason: collision with root package name */
    public final Class<R> f67770e;

    /* loaded from: classes7.dex */
    public static final class a<T, R> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super R> f67771e;

        /* renamed from: f  reason: collision with root package name */
        public final Class<R> f67772f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f67773g;

        public a(h.j<? super R> jVar, Class<R> cls) {
            this.f67771e = jVar;
            this.f67772f = cls;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f67773g) {
                return;
            }
            this.f67771e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f67773g) {
                h.r.c.j(th);
                return;
            }
            this.f67773g = true;
            this.f67771e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                this.f67771e.onNext(this.f67772f.cast(t));
            } catch (Throwable th) {
                h.m.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.f67771e.setProducer(fVar);
        }
    }

    public l(Class<R> cls) {
        this.f67770e = cls;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super R> jVar) {
        a aVar = new a(jVar, this.f67770e);
        jVar.add(aVar);
        return aVar;
    }
}
