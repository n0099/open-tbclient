package h.o.a;

import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public class l<T, R> implements d.b<R, T> {

    /* renamed from: e  reason: collision with root package name */
    public final Class<R> f67781e;

    /* loaded from: classes7.dex */
    public static final class a<T, R> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super R> f67782e;

        /* renamed from: f  reason: collision with root package name */
        public final Class<R> f67783f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f67784g;

        public a(h.j<? super R> jVar, Class<R> cls) {
            this.f67782e = jVar;
            this.f67783f = cls;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f67784g) {
                return;
            }
            this.f67782e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f67784g) {
                h.r.c.j(th);
                return;
            }
            this.f67784g = true;
            this.f67782e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                this.f67782e.onNext(this.f67783f.cast(t));
            } catch (Throwable th) {
                h.m.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.f67782e.setProducer(fVar);
        }
    }

    public l(Class<R> cls) {
        this.f67781e = cls;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super R> jVar) {
        a aVar = new a(jVar, this.f67781e);
        jVar.add(aVar);
        return aVar;
    }
}
