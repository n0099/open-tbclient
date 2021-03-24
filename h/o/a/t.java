package h.o.a;

import h.d;
/* loaded from: classes7.dex */
public final class t<T> implements d.b<T, T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.g<? super T, ? super Integer, Boolean> f67802e;

    /* loaded from: classes7.dex */
    public class a implements h.n.g<T, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h.n.f f67803a;

        public a(h.n.f fVar) {
            this.f67803a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.g
        /* renamed from: b */
        public Boolean a(T t, Integer num) {
            return (Boolean) this.f67803a.call(t);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public int f67804e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f67805f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h.j f67806g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h.j jVar, boolean z, h.j jVar2) {
            super(jVar, z);
            this.f67806g = jVar2;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f67805f) {
                return;
            }
            this.f67806g.onCompleted();
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (this.f67805f) {
                return;
            }
            this.f67806g.onError(th);
        }

        @Override // h.e
        public void onNext(T t) {
            try {
                h.n.g<? super T, ? super Integer, Boolean> gVar = t.this.f67802e;
                int i = this.f67804e;
                this.f67804e = i + 1;
                if (gVar.a(t, Integer.valueOf(i)).booleanValue()) {
                    this.f67806g.onNext(t);
                    return;
                }
                this.f67805f = true;
                this.f67806g.onCompleted();
                unsubscribe();
            } catch (Throwable th) {
                this.f67805f = true;
                h.m.a.g(th, this.f67806g, t);
                unsubscribe();
            }
        }
    }

    public t(h.n.f<? super T, Boolean> fVar) {
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

    public t(h.n.g<? super T, ? super Integer, Boolean> gVar) {
        this.f67802e = gVar;
    }
}
