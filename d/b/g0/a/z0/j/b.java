package d.b.g0.a.z0.j;

import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public class b implements d.b.g0.a.z0.j.a {

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.c.i.a<d.b.g0.a.p.d.d> {
        public a(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.c.i.a
        /* renamed from: b */
        public void a(@NonNull d.b.g0.a.p.d.d dVar) {
            dVar.C();
        }
    }

    /* renamed from: d.b.g0.a.z0.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0905b implements d.b.g0.c.i.a<d.b.g0.a.p.d.d> {
        public C0905b(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.c.i.a
        /* renamed from: b */
        public void a(@NonNull d.b.g0.a.p.d.d dVar) {
            dVar.A();
        }
    }

    public final void a(@NonNull d.b.g0.c.i.a<d.b.g0.a.p.d.d> aVar) {
        for (d.b.g0.a.p.d.d dVar : d.b.g0.a.e0.w.d.L().M().values()) {
            if (dVar != null) {
                aVar.a(dVar);
            }
        }
    }

    @Override // d.b.g0.a.z0.j.a
    public void onPause() {
        a(new a(this));
    }

    @Override // d.b.g0.a.z0.j.a
    public void onResume() {
        a(new C0905b(this));
    }
}
