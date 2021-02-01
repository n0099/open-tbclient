package com.qq.e.comm.plugin.b;

import com.qq.e.comm.plugin.y.u;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class b {
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
    public static void a(com.qq.e.comm.plugin.k.a aVar, com.qq.e.comm.plugin.y.c cVar) {
        com.qq.e.comm.plugin.y.d dVar;
        int a2 = aVar.a();
        if (a2 == 5018 || a2 == 5019 || a2 == 5013) {
            u.a(1050002, a2, cVar);
        } else if (a2 != 5001) {
            u.a(1050004, a2, cVar, a(aVar, (String) null));
        } else {
            try {
                dVar = new com.qq.e.comm.plugin.y.d(new JSONObject(aVar.getMessage()));
            } catch (JSONException e) {
                e.printStackTrace();
                dVar = null;
            }
            u.a(1050006, 0, cVar, dVar);
        }
    }

    public static void a(com.qq.e.comm.plugin.y.c cVar) {
        u.a(1050011, cVar);
    }

    public static void a(Boolean bool, com.qq.e.comm.plugin.y.c cVar, int i, Exception exc) {
        int i2;
        com.qq.e.comm.plugin.y.d dVar = null;
        if (bool == null) {
            i2 = 1050016;
        } else if (bool.booleanValue()) {
            i2 = 1050017;
        } else {
            i2 = 1050018;
            dVar = a(exc, (String) null);
        }
        u.a(i2, i, cVar, dVar);
    }

    public static void a(Boolean bool, com.qq.e.comm.plugin.y.c cVar, com.qq.e.comm.plugin.ab.a.a aVar) {
        int i;
        com.qq.e.comm.plugin.y.d dVar = null;
        if (bool == null) {
            i = 1050007;
        } else if (bool.booleanValue()) {
            i = 1050009;
        } else {
            i = 1050008;
            dVar = new com.qq.e.comm.plugin.y.d();
            dVar.a("ot", aVar.toString());
        }
        u.a(i, 0, cVar, dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z, com.qq.e.comm.plugin.y.c cVar, int i) {
        if (z) {
            u.a(1050015, cVar);
        } else {
            u.a(1050006, i, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.y.c cVar) {
        u.a(1050001, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(com.qq.e.comm.plugin.y.c cVar) {
        u.a(1050005, cVar);
    }
}
