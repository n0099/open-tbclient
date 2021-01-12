package com.qq.e.comm.plugin.gdtnativead;

import com.qq.e.comm.plugin.y.u;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class c {
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
    public static void a(com.qq.e.comm.plugin.ad.e eVar, com.qq.e.comm.plugin.k.a aVar, com.qq.e.comm.plugin.y.c cVar) {
        com.qq.e.comm.plugin.y.d dVar;
        if (eVar != com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD) {
            return;
        }
        int a2 = aVar.a();
        if (a2 == 5018 || a2 == 5019 || a2 == 5013) {
            u.a(1040002, a2, cVar);
        } else if (a2 != 5001) {
            u.a(1040004, a2, cVar, a(aVar, (String) null));
        } else {
            try {
                dVar = new com.qq.e.comm.plugin.y.d(new JSONObject(aVar.getMessage()));
            } catch (JSONException e) {
                e.printStackTrace();
                dVar = null;
            }
            u.a(1040006, a2, cVar, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.ad.e eVar, com.qq.e.comm.plugin.y.c cVar) {
        if (eVar == com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL) {
            com.qq.e.comm.plugin.intersitial2.c.b(cVar);
        } else if (eVar == com.qq.e.comm.plugin.ad.e.UNIFIED_BANNER) {
            com.qq.e.comm.plugin.b.b.a(cVar);
        } else if (eVar == com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD) {
            u.a(1040011, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.ad.e eVar, com.qq.e.comm.plugin.y.c cVar, String str, int i, Exception exc) {
        if (eVar == com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL) {
            com.qq.e.comm.plugin.intersitial2.c.a(eVar, cVar, str, i, exc);
        } else if (eVar == com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD) {
            u.a(1040012, i, cVar, a(exc, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.ad.e eVar, Boolean bool, com.qq.e.comm.plugin.y.c cVar, int i, Exception exc) {
        int i2;
        com.qq.e.comm.plugin.y.d dVar = null;
        if (eVar == com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL) {
            com.qq.e.comm.plugin.intersitial2.c.a(bool, cVar, i, exc);
        } else if (eVar == com.qq.e.comm.plugin.ad.e.UNIFIED_BANNER) {
            com.qq.e.comm.plugin.b.b.a(bool, cVar, i, exc);
        } else if (eVar == com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD) {
            if (bool == null) {
                i2 = 1040016;
            } else if (bool.booleanValue()) {
                i2 = 1040017;
            } else {
                i2 = 1040018;
                dVar = a(exc, (String) null);
            }
            u.a(i2, i, cVar, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.ad.e eVar, Boolean bool, com.qq.e.comm.plugin.y.c cVar, com.qq.e.comm.plugin.ab.a.a aVar) {
        int i;
        if (eVar == com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL) {
            com.qq.e.comm.plugin.intersitial2.c.a(bool, cVar, aVar);
        } else if (eVar == com.qq.e.comm.plugin.ad.e.UNIFIED_BANNER) {
            com.qq.e.comm.plugin.b.b.a(bool, cVar, aVar);
        } else if (eVar == com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD) {
            com.qq.e.comm.plugin.y.d dVar = null;
            if (bool == null) {
                i = 1040007;
            } else if (bool.booleanValue()) {
                i = 1040009;
            } else {
                i = 1040008;
                dVar = new com.qq.e.comm.plugin.y.d();
                dVar.a("ot", aVar.toString());
            }
            u.a(i, 0, cVar, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.ad.e eVar, boolean z, com.qq.e.comm.plugin.y.c cVar, int i) {
        if (eVar != com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD) {
            return;
        }
        if (z) {
            u.a(1040015, cVar);
        } else {
            u.a(1040006, i, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.ad.e eVar, boolean z, com.qq.e.comm.plugin.y.c cVar, int i, Exception exc) {
        if (eVar == com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL) {
            com.qq.e.comm.plugin.intersitial2.c.a(eVar, z, cVar, i, exc);
        } else if (eVar == com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD) {
            if (z) {
                u.a(1040014, cVar);
            } else {
                u.a(1040013, i, cVar, a(exc, (String) null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.ad.e eVar, com.qq.e.comm.plugin.y.c cVar) {
        if (eVar != com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD) {
            return;
        }
        u.a(1040010, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(com.qq.e.comm.plugin.ad.e eVar, com.qq.e.comm.plugin.y.c cVar) {
        if (eVar != com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD) {
            return;
        }
        u.a(1040019, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(com.qq.e.comm.plugin.ad.e eVar, com.qq.e.comm.plugin.y.c cVar) {
        if (eVar != com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD) {
            return;
        }
        u.a(1040001, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(com.qq.e.comm.plugin.ad.e eVar, com.qq.e.comm.plugin.y.c cVar) {
        if (eVar != com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD) {
            return;
        }
        u.a(1040005, cVar);
    }
}
