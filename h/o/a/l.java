package h.o.a;

import h.d;
import rx.exceptions.OnErrorThrowable;
/* loaded from: classes7.dex */
public class l<T, R> implements d.b<R, T> {

    /* renamed from: e  reason: collision with root package name */
    public final Class<R> f68504e;

    /* loaded from: classes7.dex */
    public static final class a<T, R> extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public final h.j<? super R> f68505e;

        /* renamed from: f  reason: collision with root package name */
        public final Class<R> f68506f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f68507g;

        public a(h.j<? super R> jVar, Class<R> cls) {
            this.f68505e = jVar;
            this.f68506f = cls;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f68507g) {
                return;
            }
            this.f68505e.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f68507g) {
                h.r.c.j(th);
                return;
            }
            this.f68507g = true;
            this.f68505e.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                this.f68505e.onNext(this.f68506f.cast(t));
            } catch (Throwable th) {
                h.m.a.e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // h.j
        public void setProducer(h.f fVar) {
            this.f68505e.setProducer(fVar);
        }
    }

    public l(Class<R> cls) {
        this.f68504e = cls;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super R> jVar) {
        a aVar = new a(jVar, this.f68504e);
        jVar.add(aVar);
        return aVar;
    }
}
