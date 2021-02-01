package com.qq.e.comm.plugin.c;

import com.qq.e.comm.plugin.y.u;
/* loaded from: classes15.dex */
public class g {
    private static com.qq.e.comm.plugin.y.d a(f fVar) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, f fVar) {
        u.a(1101003, i, fVar.z, a(fVar));
    }

    public static void a(int i, Exception exc, com.qq.e.comm.plugin.y.c cVar) {
        com.qq.e.comm.plugin.y.d dVar = null;
        if (exc != null) {
            dVar = new com.qq.e.comm.plugin.y.d();
            dVar.a("ot", exc.toString());
        }
        u.a(1101004, i, cVar, dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z, int i, f fVar) {
        if (z) {
            u.a(1101002, i, fVar.z, a(fVar));
        } else {
            u.a(1101001, fVar.z);
        }
    }
}
