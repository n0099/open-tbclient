package h.o.a;

import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public class m<T, R> implements d.b<R, T> {

    /* renamed from: e  reason: collision with root package name */
    public final Class<R> f68786e;

    /* loaded from: classes7.dex */
    public static final class a<T, R> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super R> f68787e;

        /* renamed from: f  reason: collision with root package name */
        public final Class<R> f68788f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f68789g;

        public a(h.j<? super R> jVar, Class<R> cls) {
            this.f68787e = jVar;
            this.f68788f = cls;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f68789g) {
                return;
            }
            this.f68787e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f68789g) {
                h.r.c.j(th);
                return;
            }
            this.f68789g = true;
            this.f68787e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                this.f68787e.onNext(this.f68788f.cast(t));
            } catch (Throwable th) {
                h.m.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.f68787e.setProducer(fVar);
        }
    }

    public m(Class<R> cls) {
        this.f68786e = cls;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super R> jVar) {
        a aVar = new a(jVar, this.f68786e);
        jVar.add(aVar);
        return aVar;
    }
}
