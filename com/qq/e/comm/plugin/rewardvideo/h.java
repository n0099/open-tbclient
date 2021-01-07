package com.qq.e.comm.plugin.rewardvideo;

import com.qq.e.comm.plugin.aa.b.f;
import com.qq.e.comm.plugin.y.u;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
class h {
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
        u.a(1020060, i, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, com.qq.e.comm.plugin.y.c cVar, String str, Exception exc) {
        u.a(1020009, i, cVar, a(exc, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(f.d dVar, com.qq.e.comm.plugin.y.c cVar) {
        int i;
        switch (dVar) {
            case END:
                i = 1020013;
                break;
            case PLAY:
                i = 1020011;
                break;
            case PAUSE:
                i = 1020010;
                break;
            default:
                return;
        }
        u.a(i, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.k.a aVar, com.qq.e.comm.plugin.y.c cVar) {
        com.qq.e.comm.plugin.y.d dVar;
        int a2 = aVar.a();
        if (a2 == 5018 || a2 == 5019 || a2 == 5013) {
            u.a(1020018, cVar);
        } else if (a2 != 5001) {
            u.a(1020002, a2, cVar, a(aVar, (String) null));
        } else {
            try {
                dVar = new com.qq.e.comm.plugin.y.d(new JSONObject(aVar.getMessage()));
            } catch (JSONException e) {
                e.printStackTrace();
                dVar = null;
            }
            u.a(1020060, 0, cVar, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(e eVar, int i, com.qq.e.comm.plugin.y.c cVar) {
        int i2;
        switch (eVar) {
            case PAGE:
                i2 = 1022001;
                break;
            default:
                i2 = 1020007;
                break;
        }
        u.a(i2, i, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(e eVar, com.qq.e.comm.plugin.y.c cVar) {
        int i = 0;
        switch (eVar) {
            case VIDEO:
                i = 1020012;
                break;
            case PAGE:
                i = 1022007;
                break;
        }
        u.a(i, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(e eVar, boolean z, com.qq.e.comm.plugin.y.c cVar) {
        int i = 0;
        switch (eVar) {
            case VIDEO:
                if (!z) {
                    i = 1020022;
                    break;
                } else {
                    i = 1020021;
                    break;
                }
            case PAGE:
                if (!z) {
                    i = 1022006;
                    break;
                } else {
                    i = 1022005;
                    break;
                }
        }
        u.a(i, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(e eVar, boolean z, boolean z2, com.qq.e.comm.plugin.y.c cVar, String str, com.qq.e.comm.plugin.j.c cVar2) {
        int i;
        int i2;
        com.qq.e.comm.plugin.y.d dVar = null;
        switch (eVar) {
            case VIDEO:
                if (!z) {
                    if (!z2) {
                        i = 1020005;
                        int a2 = cVar2 != null ? cVar2.a() : 0;
                        dVar = a(cVar2, str);
                        i2 = a2;
                        break;
                    } else {
                        i = 1020004;
                        i2 = 0;
                        break;
                    }
                } else {
                    i = 1020063;
                    i2 = 0;
                    break;
                }
            case PAGE:
                i = 1022008;
                i2 = 0;
                break;
            default:
                i = 0;
                i2 = 0;
                break;
        }
        u.a(i, i2, cVar, dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.y.c cVar) {
        u.a(1020014, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z, int i, String str, String str2, com.qq.e.comm.plugin.y.c cVar) {
        if (z) {
            u.a(1022002, cVar);
            return;
        }
        com.qq.e.comm.plugin.y.d dVar = new com.qq.e.comm.plugin.y.d();
        dVar.a("rs", str);
        dVar.a("ot", str2);
        u.a(1022003, i, cVar, dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(e eVar, com.qq.e.comm.plugin.y.c cVar) {
        int i = 0;
        switch (eVar) {
            case VIDEO:
                i = 1020008;
                break;
            case PAGE:
                i = 1022004;
                break;
        }
        u.a(i, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(e eVar, boolean z, com.qq.e.comm.plugin.y.c cVar) {
        if (eVar == e.VIDEO && z) {
            return;
        }
        u.a(1020003, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.y.c cVar) {
        u.a(1020006, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(e eVar, com.qq.e.comm.plugin.y.c cVar) {
        u.a(1020062, cVar);
        int i = 0;
        switch (eVar) {
            case VIDEO:
                i = 1020072;
                break;
            case PAGE:
                i = 1022017;
                break;
        }
        u.a(i, cVar);
    }

    static void c(com.qq.e.comm.plugin.y.c cVar) {
        u.a(1020001, cVar);
    }

    static void d(com.qq.e.comm.plugin.y.c cVar) {
        u.a(1020061, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(com.qq.e.comm.plugin.y.c cVar) {
        u.a(1020064, cVar);
    }
}
