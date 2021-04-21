package d.b.h0.l.l.h.c;

import androidx.annotation.NonNull;
import d.b.h0.l.h.g;
import d.b.h0.l.l.h.f.d;
import d.b.h0.l.l.h.f.f;
import d.b.h0.l.l.h.f.h;
import d.b.h0.l.l.h.f.i;
import d.b.h0.l.l.j.a;
import d.b.h0.l.l.j.b;
import d.b.h0.l.l.j.c;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    @NonNull
    public static i a(d.b.h0.l.l.j.a aVar, g gVar) {
        List<f<a.C1052a>> e2 = h.e(aVar.f49697a, gVar);
        i iVar = new i(gVar);
        for (f<a.C1052a> fVar : e2) {
            iVar.c(d.b().a(fVar));
        }
        return iVar;
    }

    public static synchronized void b(b bVar, g gVar) {
        synchronized (a.class) {
            f<d.b.h0.l.k.d> d2 = h.d(bVar.f49707c, gVar);
            f<d.b.h0.l.k.f> f2 = h.f(bVar.f49705a, gVar);
            f<d.b.h0.l.k.b> c2 = h.c(bVar.f49709e, gVar);
            List<f<d.b.h0.l.k.g>> g2 = h.g(bVar.f49706b, gVar);
            i iVar = new i(gVar);
            iVar.c(d.b().a(d2));
            iVar.c(d.b().a(f2));
            iVar.c(d.b().a(c2));
            for (f<d.b.h0.l.k.g> fVar : g2) {
                iVar.c(d.b().a(fVar));
            }
            iVar.e();
        }
    }

    public static synchronized void c(c cVar, g gVar) {
        synchronized (a.class) {
            f<d.b.h0.l.k.h> h2 = h.h(cVar.f49710a, gVar);
            i iVar = new i(gVar);
            iVar.c(d.b().a(h2));
            iVar.e();
        }
    }

    public static synchronized void d(d.b.h0.l.l.j.d dVar, g gVar) {
        synchronized (a.class) {
            List<f<d.b.h0.l.k.g>> g2 = h.g(dVar.f49711a, gVar);
            i iVar = new i(gVar);
            for (f<d.b.h0.l.k.g> fVar : g2) {
                iVar.c(d.b().a(fVar));
            }
            iVar.e();
        }
    }

    public static synchronized void e(d.b.h0.l.m.k.a aVar, g gVar) {
        synchronized (a.class) {
            f<d.b.h0.l.k.d> d2 = h.d(aVar.f49770b, gVar);
            f<d.b.h0.l.k.d> d3 = h.d(aVar.f49769a, gVar);
            f<d.b.h0.l.k.b> c2 = h.c(aVar.f49771c, gVar);
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
            if (aVar.f49772d != null) {
                for (d.b.h0.l.k.i iVar2 : aVar.f49772d) {
                    f<d.b.h0.l.k.i> i = h.i(iVar2, gVar);
                    if (i != null) {
                        iVar.c(d.b().a(i));
                    }
                }
            }
            iVar.e();
        }
    }
}
