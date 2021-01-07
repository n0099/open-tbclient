package com.qq.e.comm.plugin.y;
/* loaded from: classes4.dex */
public class u {
    public static void a(int i, int i2, c cVar) {
        a(i, i2, cVar, null);
    }

    public static void a(int i, int i2, c cVar, d dVar) {
        e b2 = new e(i).b(i2);
        b2.a(cVar);
        b2.a(dVar);
        a(b2);
    }

    public static void a(int i, c cVar) {
        a(i, 0, cVar);
    }

    public static void a(e eVar) {
        if (eVar == null || !h.d()) {
            return;
        }
        s.a().a(l.a(eVar));
    }

    public static void a(g gVar) {
        if (gVar == null || !h.c()) {
            return;
        }
        s.a().a(p.a(gVar));
    }
}
