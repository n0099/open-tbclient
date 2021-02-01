package com.qq.e.comm.plugin.nativeadunified;

import android.os.SystemClock;
import com.qq.e.comm.plugin.y.u;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
class l {
    private static com.qq.e.comm.plugin.y.d a(Exception exc, String str) {
        com.qq.e.comm.plugin.y.d dVar = new com.qq.e.comm.plugin.y.d();
        if (exc != null) {
            dVar.a("ot", exc.getMessage());
        }
        if (str != null) {
            dVar.a("rs", str);
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, com.qq.e.comm.plugin.y.c cVar) {
        u.a(1060002, i, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.j.c cVar, String str, com.qq.e.comm.plugin.y.c cVar2) {
        u.a(1060012, cVar.a(), cVar2, a(cVar, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.k.a aVar, com.qq.e.comm.plugin.y.c cVar) {
        com.qq.e.comm.plugin.y.d dVar;
        int a2 = aVar.a();
        if (a2 == 5018 || a2 == 5019 || a2 == 5013) {
            a(a2, cVar);
        } else if (a2 != 5001) {
            u.a(1060004, a2, cVar, a(aVar, (String) null));
        } else {
            try {
                dVar = new com.qq.e.comm.plugin.y.d(new JSONObject(aVar.getMessage()));
            } catch (JSONException e) {
                dVar = null;
            }
            u.a(1060006, 0, cVar, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.y.c cVar) {
        u.a(1060001, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.y.c cVar, long j) {
        u.a(1060005, cVar);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.qq.e.comm.plugin.y.g gVar = new com.qq.e.comm.plugin.y.g(2030001);
        gVar.a(cVar);
        gVar.b(elapsedRealtime - j);
        u.a(gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Boolean bool, com.qq.e.comm.plugin.y.c cVar, int i) {
        if (bool == null) {
            u.a(1060016, cVar);
        } else if (bool.booleanValue()) {
            u.a(1060017, cVar);
        } else {
            u.a(1060018, i, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z, com.qq.e.comm.plugin.y.c cVar, int i) {
        if (z) {
            u.a(1060015, cVar);
        } else {
            u.a(1060006, i, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.y.c cVar) {
        u.a(1060007, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z, com.qq.e.comm.plugin.y.c cVar, int i) {
        if (z) {
            u.a(1060014, cVar);
        } else {
            u.a(1060013, i, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(com.qq.e.comm.plugin.y.c cVar) {
        u.a(1060011, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(com.qq.e.comm.plugin.y.c cVar) {
        u.a(1060010, cVar);
    }
}
