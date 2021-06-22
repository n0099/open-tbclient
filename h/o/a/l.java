package h.o.a;

import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes8.dex */
public class l<T, R> implements d.b<R, T> {

    /* renamed from: e  reason: collision with root package name */
    public final Class<R> f71864e;

    /* loaded from: classes8.dex */
    public static final class a<T, R> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super R> f71865e;

        /* renamed from: f  reason: collision with root package name */
        public final Class<R> f71866f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f71867g;

        public a(h.j<? super R> jVar, Class<R> cls) {
            this.f71865e = jVar;
            this.f71866f = cls;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f71867g) {
                return;
            }
            this.f71865e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f71867g) {
                h.r.c.j(th);
                return;
            }
            this.f71867g = true;
            this.f71865e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                this.f71865e.onNext(this.f71866f.cast(t));
            } catch (Throwable th) {
                h.m.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.f71865e.setProducer(fVar);
        }
    }

    public l(Class<R> cls) {
        this.f71864e = cls;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super R> jVar) {
        a aVar = new a(jVar, this.f71864e);
        jVar.add(aVar);
        return aVar;
    }
}
