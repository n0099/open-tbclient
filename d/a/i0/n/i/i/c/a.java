package d.a.i0.n.i.i.c;

import androidx.annotation.NonNull;
import d.a.i0.n.f.g;
import d.a.i0.n.i.i.g.d;
import d.a.i0.n.i.i.g.f;
import d.a.i0.n.i.i.g.h;
import d.a.i0.n.i.i.g.i;
import d.a.i0.n.i.l.a;
import d.a.i0.n.i.l.b;
import d.a.i0.n.i.l.c;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    @NonNull
    public static i a(d.a.i0.n.i.l.a aVar, g gVar) {
        List<f<a.C1067a>> e2 = h.e(aVar.f47904a, gVar);
        i iVar = new i(gVar);
        for (f<a.C1067a> fVar : e2) {
            iVar.c(d.b().a(fVar));
        }
        return iVar;
    }

    public static synchronized void b(b bVar, g gVar) {
        synchronized (a.class) {
            f<d.a.i0.n.h.d> d2 = h.d(bVar.f47914c, gVar);
            f<d.a.i0.n.h.f> f2 = h.f(bVar.f47912a, gVar);
            f<d.a.i0.n.h.b> c2 = h.c(bVar.f47916e, gVar);
            List<f<d.a.i0.n.h.g>> g2 = h.g(bVar.f47913b, gVar);
            i iVar = new i(gVar);
            iVar.c(d.b().a(d2));
            iVar.c(d.b().a(f2));
            iVar.c(d.b().a(c2));
            for (f<d.a.i0.n.h.g> fVar : g2) {
                iVar.c(d.b().a(fVar));
            }
            iVar.e();
        }
    }

    public static synchronized void c(c cVar, g gVar) {
        synchronized (a.class) {
            f<d.a.i0.n.h.h> h2 = h.h(cVar.f47917a, gVar);
            i iVar = new i(gVar);
            iVar.c(d.b().a(h2));
            iVar.e();
        }
    }

    public static synchronized void d(d.a.i0.n.i.l.d dVar, g gVar) {
        synchronized (a.class) {
            List<f<d.a.i0.n.h.g>> g2 = h.g(dVar.f47918a, gVar);
            i iVar = new i(gVar);
            for (f<d.a.i0.n.h.g> fVar : g2) {
                iVar.c(d.b().a(fVar));
            }
            iVar.e();
        }
    }

    public static synchronized void e(d.a.i0.n.j.k.a aVar, g gVar) {
        synchronized (a.class) {
            f<d.a.i0.n.h.d> d2 = h.d(aVar.f47998b, gVar);
            f<d.a.i0.n.h.d> d3 = h.d(aVar.f47997a, gVar);
            f<d.a.i0.n.h.b> c2 = h.c(aVar.f47999c, gVar);
            i iVar = new i(gVar);
            if (d2 != null) {
                iVar.c(d.b().a(d2));
            }
            if (d3 != null) {
                iVar.c(d.b().a(d3));
            }
            if (c2 != null) {
                iVar.c(d.b().a(c2));
            }
            if (aVar.f48000d != null) {
                for (d.a.i0.n.h.i iVar2 : aVar.f48000d) {
                    f<d.a.i0.n.h.i> i2 = h.i(iVar2, gVar);
                    if (i2 != null) {
                        iVar.c(d.b().a(i2));
                    }
                }
            }
            if (aVar.f48001e != null) {
                for (d.a.i0.n.h.h hVar : aVar.f48001e) {
                    f<d.a.i0.n.h.h> h2 = h.h(hVar, gVar);
                    if (h2 != null) {
                        iVar.c(d.b().a(h2));
                    }
                }
            }
            iVar.e();
        }
    }
}
