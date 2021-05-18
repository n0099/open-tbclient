package d.a.i0.a.g1.j;

import androidx.annotation.NonNull;
import d.a.i0.a.h0.u.g;
/* loaded from: classes3.dex */
public class b implements d.a.i0.a.g1.j.a {

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.d.i.a<d.a.i0.a.p.e.d> {
        public a(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.d.i.a
        /* renamed from: b */
        public void a(@NonNull d.a.i0.a.p.e.d dVar) {
            dVar.P();
        }
    }

    /* renamed from: d.a.i0.a.g1.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0631b implements d.a.i0.d.i.a<d.a.i0.a.p.e.d> {
        public C0631b(b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.d.i.a
        /* renamed from: b */
        public void a(@NonNull d.a.i0.a.p.e.d dVar) {
            dVar.s();
        }
    }

    public final void a(@NonNull d.a.i0.d.i.a<d.a.i0.a.p.e.d> aVar) {
        for (d.a.i0.a.p.e.d dVar : g.N().O().values()) {
            if (dVar != null) {
                aVar.a(dVar);
            }
        }
    }

    @Override // d.a.i0.a.g1.j.a
    public void onPause() {
        a(new a(this));
    }

    @Override // d.a.i0.a.g1.j.a
    public void onResume() {
        a(new C0631b(this));
    }
}
