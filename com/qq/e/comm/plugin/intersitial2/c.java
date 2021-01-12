package com.qq.e.comm.plugin.intersitial2;

import com.qq.e.comm.plugin.y.u;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
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

    public static void a(com.qq.e.comm.plugin.ad.e eVar, com.qq.e.comm.plugin.y.c cVar) {
        int i;
        if (eVar == com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL) {
            i = 1031001;
        } else if (eVar != com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL_FULLSCREEN) {
            return;
        } else {
            i = 1030003;
        }
        u.a(i, cVar);
    }

    public static void a(com.qq.e.comm.plugin.ad.e eVar, com.qq.e.comm.plugin.y.c cVar, String str, int i, Exception exc) {
        int i2;
        if (eVar == com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL_FULLSCREEN) {
            i2 = 1030027;
        } else if (eVar != com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL) {
            return;
        } else {
            i2 = 1031006;
        }
        u.a(i2, i, cVar, a(exc, str));
    }

    public static void a(com.qq.e.comm.plugin.ad.e eVar, boolean z, int i, com.qq.e.comm.plugin.y.c cVar) {
        if (eVar == com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL_FULLSCREEN) {
            u.a(1030024, i, cVar);
        } else if (eVar == com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL) {
            u.a(z ? 1031005 : 1031010, i, cVar);
        }
    }

    public static void a(com.qq.e.comm.plugin.ad.e eVar, boolean z, com.qq.e.comm.plugin.y.c cVar) {
        if (eVar == com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL_FULLSCREEN) {
            u.a(1030004, cVar);
        } else if (eVar == com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL) {
            u.a(z ? 1031004 : 1031009, cVar);
        }
    }

    public static void a(com.qq.e.comm.plugin.ad.e eVar, boolean z, com.qq.e.comm.plugin.y.c cVar, int i, Exception exc) {
        int i2;
        if (eVar == com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL_FULLSCREEN) {
            i2 = z ? 1030009 : 1030007;
        } else if (eVar != com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL) {
            return;
        } else {
            i2 = z ? 1031007 : 1031008;
        }
        u.a(i2, i, cVar, z ? null : a(exc, (String) null));
    }

    public static void a(com.qq.e.comm.plugin.k.a aVar, com.qq.e.comm.plugin.y.c cVar) {
        com.qq.e.comm.plugin.y.d dVar;
        int a2 = aVar.a();
        if (a2 == 5018 || a2 == 5019 || a2 == 5013) {
            u.a(1030025, a2, cVar);
        } else if (a2 != 5001) {
            u.a(1030016, a2, cVar, a(aVar, (String) null));
        } else {
            try {
                dVar = new com.qq.e.comm.plugin.y.d(new JSONObject(aVar.getMessage()));
            } catch (JSONException e) {
                e.printStackTrace();
                dVar = null;
            }
            u.a(1030015, 0, cVar, dVar);
        }
    }

    public static void a(com.qq.e.comm.plugin.y.c cVar) {
        u.a(1030013, cVar);
    }

    public static void a(com.qq.e.comm.plugin.y.c cVar, int i) {
        u.a(1030015, i, cVar);
    }

    public static void a(Boolean bool, com.qq.e.comm.plugin.y.c cVar, int i, Exception exc) {
        int i2;
        com.qq.e.comm.plugin.y.d dVar = null;
        if (bool == null) {
            i2 = 1030028;
        } else if (bool.booleanValue()) {
            i2 = 1030010;
        } else {
            i2 = 1030011;
            dVar = a(exc, (String) null);
        }
        u.a(i2, i, cVar, dVar);
    }

    public static void a(Boolean bool, com.qq.e.comm.plugin.y.c cVar, com.qq.e.comm.plugin.ab.a.a aVar) {
        int i;
        com.qq.e.comm.plugin.y.d dVar = null;
        if (bool == null) {
            i = 1031013;
        } else if (bool.booleanValue()) {
            i = 1031002;
        } else {
            i = 1031003;
            dVar = new com.qq.e.comm.plugin.y.d();
            dVar.a("ot", aVar.toString());
        }
        u.a(i, 0, cVar, dVar);
    }

    public static void a(boolean z, com.qq.e.comm.plugin.y.c cVar) {
        u.a(z ? 1030020 : 1030017, cVar);
    }

    public static void b(com.qq.e.comm.plugin.y.c cVar) {
        u.a(1031011, cVar);
    }

    public static void b(boolean z, com.qq.e.comm.plugin.y.c cVar) {
        u.a(z ? 1030023 : 1030022, cVar);
    }

    public static void c(com.qq.e.comm.plugin.y.c cVar) {
        u.a(1030001, cVar);
    }

    public static void d(com.qq.e.comm.plugin.y.c cVar) {
        u.a(1030002, cVar);
    }
}
