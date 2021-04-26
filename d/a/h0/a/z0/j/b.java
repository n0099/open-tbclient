package d.a.h0.a.z0.j;

import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class b implements d.a.h0.a.z0.j.a {

    /* loaded from: classes.dex */
    public class a implements d.a.h0.c.i.a<d.a.h0.a.p.d.d> {
        public a(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.c.i.a
        /* renamed from: b */
        public void a(@NonNull d.a.h0.a.p.d.d dVar) {
            dVar.N();
        }
    }

    /* renamed from: d.a.h0.a.z0.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0864b implements d.a.h0.c.i.a<d.a.h0.a.p.d.d> {
        public C0864b(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.c.i.a
        /* renamed from: b */
        public void a(@NonNull d.a.h0.a.p.d.d dVar) {
            dVar.q();
        }
    }

    public final void a(@NonNull d.a.h0.c.i.a<d.a.h0.a.p.d.d> aVar) {
        for (d.a.h0.a.p.d.d dVar : d.a.h0.a.e0.w.d.L().M().values()) {
            if (dVar != null) {
                aVar.a(dVar);
            }
        }
    }

    @Override // d.a.h0.a.z0.j.a
    public void onPause() {
        a(new a(this));
    }

    @Override // d.a.h0.a.z0.j.a
    public void onResume() {
        a(new C0864b(this));
    }
}
