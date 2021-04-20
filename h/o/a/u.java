package h.o.a;

import h.d;
/* loaded from: classes7.dex */
public final class u<T> implements d.b<T, T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.g<? super T, ? super Integer, Boolean> f68818e;

    /* loaded from: classes7.dex */
    public class a implements h.n.g<T, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h.n.f f68819a;

        public a(h.n.f fVar) {
            this.f68819a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.g
        /* renamed from: b */
        public Boolean a(T t, Integer num) {
            return (Boolean) this.f68819a.call(t);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public int f68820e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f68821f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h.j f68822g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h.j jVar, boolean z, h.j jVar2) {
            super(jVar, z);
            this.f68822g = jVar2;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f68821f) {
                return;
            }
            this.f68822g.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f68821f) {
                return;
            }
            this.f68822g.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                h.n.g<? super T, ? super Integer, Boolean> gVar = u.this.f68818e;
                int i = this.f68820e;
                this.f68820e = i + 1;
                if (gVar.a(t, Integer.valueOf(i)).booleanValue()) {
                    this.f68822g.onNext(t);
                    return;
                }
                this.f68821f = true;
                this.f68822g.onCompleted();
                unsubscribe();
            } catch (Throwable th) {
                this.f68821f = true;
                h.m.a.g(th, this.f68822g, t);
                unsubscribe();
            }
        }
    }

    public u(h.n.f<? super T, Boolean> fVar) {
        this(new a(fVar));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super T> jVar) {
        b bVar = new b(jVar, false, jVar);
        jVar.add(bVar);
        return bVar;
    }

    public u(h.n.g<? super T, ? super Integer, Boolean> gVar) {
        this.f68818e = gVar;
    }
}
