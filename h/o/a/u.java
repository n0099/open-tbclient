package h.o.a;

import h.d;
/* loaded from: classes7.dex */
public final class u<T> implements d.b<T, T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.g<? super T, ? super Integer, Boolean> f68965e;

    /* loaded from: classes7.dex */
    public class a implements h.n.g<T, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h.n.f f68966a;

        public a(h.n.f fVar) {
            this.f68966a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.g
        /* renamed from: b */
        public Boolean a(T t, Integer num) {
            return (Boolean) this.f68966a.call(t);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public int f68967e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f68968f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h.j f68969g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h.j jVar, boolean z, h.j jVar2) {
            super(jVar, z);
            this.f68969g = jVar2;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f68968f) {
                return;
            }
            this.f68969g.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f68968f) {
                return;
            }
            this.f68969g.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                h.n.g<? super T, ? super Integer, Boolean> gVar = u.this.f68965e;
                int i = this.f68967e;
                this.f68967e = i + 1;
                if (gVar.a(t, Integer.valueOf(i)).booleanValue()) {
                    this.f68969g.onNext(t);
                    return;
                }
                this.f68968f = true;
                this.f68969g.onCompleted();
                unsubscribe();
            } catch (Throwable th) {
                this.f68968f = true;
                h.m.a.g(th, this.f68969g, t);
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
        this.f68965e = gVar;
    }
}
