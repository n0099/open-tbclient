package d.a.h0.l.l.h.c;

import androidx.annotation.NonNull;
import d.a.h0.l.h.g;
import d.a.h0.l.l.h.f.d;
import d.a.h0.l.l.h.f.f;
import d.a.h0.l.l.h.f.h;
import d.a.h0.l.l.h.f.i;
import d.a.h0.l.l.j.a;
import d.a.h0.l.l.j.b;
import d.a.h0.l.l.j.c;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    @NonNull
    public static i a(d.a.h0.l.l.j.a aVar, g gVar) {
        List<f<a.C0991a>> e2 = h.e(aVar.f47209a, gVar);
        i iVar = new i(gVar);
        for (f<a.C0991a> fVar : e2) {
            iVar.c(d.b().a(fVar));
        }
        return iVar;
    }

    public static synchronized void b(b bVar, g gVar) {
        synchronized (a.class) {
            f<d.a.h0.l.k.d> d2 = h.d(bVar.f47219c, gVar);
            f<d.a.h0.l.k.f> f2 = h.f(bVar.f47217a, gVar);
            f<d.a.h0.l.k.b> c2 = h.c(bVar.f47221e, gVar);
            List<f<d.a.h0.l.k.g>> g2 = h.g(bVar.f47218b, gVar);
            i iVar = new i(gVar);
            iVar.c(d.b().a(d2));
            iVar.c(d.b().a(f2));
            iVar.c(d.b().a(c2));
            for (f<d.a.h0.l.k.g> fVar : g2) {
                iVar.c(d.b().a(fVar));
            }
            iVar.e();
        }
    }

    public static synchronized void c(c cVar, g gVar) {
        synchronized (a.class) {
            f<d.a.h0.l.k.h> h2 = h.h(cVar.f47222a, gVar);
            i iVar = new i(gVar);
            iVar.c(d.b().a(h2));
            iVar.e();
        }
    }

    public static synchronized void d(d.a.h0.l.l.j.d dVar, g gVar) {
        synchronized (a.class) {
            List<f<d.a.h0.l.k.g>> g2 = h.g(dVar.f47223a, gVar);
            i iVar = new i(gVar);
            for (f<d.a.h0.l.k.g> fVar : g2) {
                iVar.c(d.b().a(fVar));
            }
            iVar.e();
        }
    }

    public static synchronized void e(d.a.h0.l.m.k.a aVar, g gVar) {
        synchronized (a.class) {
            f<d.a.h0.l.k.d> d2 = h.d(aVar.f47284b, gVar);
            f<d.a.h0.l.k.d> d3 = h.d(aVar.f47283a, gVar);
            f<d.a.h0.l.k.b> c2 = h.c(aVar.f47285c, gVar);
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
            if (aVar.f47286d != null) {
                for (d.a.h0.l.k.i iVar2 : aVar.f47286d) {
                    f<d.a.h0.l.k.i> i2 = h.i(iVar2, gVar);
                    if (i2 != null) {
                        iVar.c(d.b().a(i2));
                    }
                }
            }
            iVar.e();
        }
    }
}
