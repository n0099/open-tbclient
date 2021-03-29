package h.o.a;

import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public class l<T, R> implements d.b<R, T> {

    /* renamed from: e  reason: collision with root package name */
    public final Class<R> f67775e;

    /* loaded from: classes7.dex */
    public static final class a<T, R> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super R> f67776e;

        /* renamed from: f  reason: collision with root package name */
        public final Class<R> f67777f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f67778g;

        public a(h.j<? super R> jVar, Class<R> cls) {
            this.f67776e = jVar;
            this.f67777f = cls;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f67778g) {
                return;
            }
            this.f67776e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f67778g) {
                h.r.c.j(th);
                return;
            }
            this.f67778g = true;
            this.f67776e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                this.f67776e.onNext(this.f67777f.cast(t));
            } catch (Throwable th) {
                h.m.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.f67776e.setProducer(fVar);
        }
    }

    public l(Class<R> cls) {
        this.f67775e = cls;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super R> jVar) {
        a aVar = new a(jVar, this.f67775e);
        jVar.add(aVar);
        return aVar;
    }
}
