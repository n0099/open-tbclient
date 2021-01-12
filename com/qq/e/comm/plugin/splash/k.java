package com.qq.e.comm.plugin.splash;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.kwai.sodler.lib.ext.PluginError;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ad.q;
import com.qq.e.comm.plugin.splash.b;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class k {
    private static com.qq.e.comm.plugin.y.d a(String str, Exception exc, boolean z, String str2) {
        com.qq.e.comm.plugin.y.d dVar = new com.qq.e.comm.plugin.y.d();
        if (!StringUtil.isEmpty(str)) {
            dVar.a("rs", str);
        }
        if (!StringUtil.isEmpty(str2)) {
            dVar.a("vu", str2);
        }
        if (z) {
            dVar.a("nt", Integer.valueOf(GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue()));
        }
        if (exc != null) {
            dVar.a("ot", exc.getClass().getName() + ":" + exc.getMessage());
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, b.EnumC1204b enumC1204b, boolean z, com.qq.e.comm.plugin.y.c cVar) {
        com.qq.e.comm.plugin.y.d dVar = new com.qq.e.comm.plugin.y.d();
        dVar.a("fd", Integer.valueOf(i));
        if (enumC1204b != b.EnumC1204b.Unknown) {
            u.a(1010062, 3, cVar, dVar);
        } else {
            u.a(1010062, z ? 2 : 1, cVar, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, com.qq.e.comm.plugin.y.c cVar, com.qq.e.comm.plugin.k.a aVar) {
        com.qq.e.comm.plugin.y.d dVar;
        if (i == 0) {
            u.a(1010005, cVar);
        } else if (i != 5001) {
            u.a(1010012, i, cVar);
        } else {
            try {
                dVar = new com.qq.e.comm.plugin.y.d(new JSONObject(aVar.getMessage()));
            } catch (JSONException e) {
                e.printStackTrace();
                dVar = null;
            }
            u.a(1010007, 0, cVar, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, com.qq.e.comm.plugin.y.c cVar, com.qq.e.comm.plugin.y.d dVar) {
        u.a(1010061, i, cVar, dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, com.qq.e.comm.plugin.y.c cVar, Exception exc) {
        if (i == 0) {
            u.a(1010032, cVar);
            return;
        }
        if (i < 1000) {
            i = PluginError.ERROR_INS_CAPACITY;
        }
        u.a(1010004, i, cVar, exc != null ? a((String) null, exc, false, (String) null) : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j, int i, String str, com.qq.e.comm.plugin.y.c cVar) {
        if (j > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            com.qq.e.comm.plugin.y.g gVar = new com.qq.e.comm.plugin.y.g(CmdConfigCustom.CMD_DEBUG_TOOL_START);
            gVar.b(currentTimeMillis - j);
            gVar.b(i);
            gVar.a(cVar);
            gVar.a(a(str, (Exception) null, true, (String) null));
            u.a(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j, com.qq.e.comm.plugin.y.c cVar) {
        com.qq.e.comm.plugin.y.g gVar = new com.qq.e.comm.plugin.y.g(2010004);
        gVar.b(System.currentTimeMillis() - j);
        gVar.a(cVar);
        u.a(gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(q qVar, com.qq.e.comm.plugin.y.c cVar) {
        int i;
        switch (qVar) {
            case IMG:
                i = 1010038;
                break;
            case VIDEO:
                i = 1010039;
                break;
            default:
                return;
        }
        u.a(i, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(b.EnumC1204b enumC1204b, b.EnumC1204b enumC1204b2, com.qq.e.comm.plugin.y.c cVar, int i, Exception exc, String str, String str2) {
        if (enumC1204b != b.EnumC1204b.Unknown) {
            b(enumC1204b, enumC1204b2, cVar, i, exc, str, str2);
        } else if (enumC1204b2 == b.EnumC1204b.Downloaded) {
            u.a(1010016, cVar);
        } else {
            u.a(1010015, i, cVar, a(str, exc, true, (String) null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.y.c cVar) {
        u.a(1010036, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Boolean bool, int i, com.qq.e.comm.plugin.y.c cVar) {
        if (bool == null) {
            u.a(1010059, cVar);
        } else if (bool.booleanValue()) {
            u.a(1010046, cVar);
        } else {
            u.a(1010060, i, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Boolean bool, int i, com.qq.e.comm.plugin.y.c cVar, Exception exc) {
        if (bool == null) {
            u.a(1010037, cVar);
        } else if (bool.booleanValue()) {
            u.a(1010023, cVar);
        } else {
            u.a(1010022, i, cVar, a((String) null, exc, false, (String) null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Boolean bool, int i, com.qq.e.comm.plugin.y.c cVar, String str, Exception exc) {
        u.a(bool == null ? 1010063 : bool.booleanValue() ? 1010049 : 1010050, i, cVar, exc != null ? a(str, exc, false, (String) null) : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Boolean bool, q qVar, com.qq.e.comm.plugin.y.c cVar) {
        if (bool == null) {
            u.a(1010403, cVar);
        } else {
            u.a(bool.booleanValue() ? 10110402 : 1010401, qVar == q.IMG ? 0 : qVar == q.VIDEO ? 1 : 100, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Boolean bool, boolean z, com.qq.e.comm.plugin.y.c cVar) {
        if (bool == null) {
            u.a(1010064, z ? 0 : 1, cVar);
        } else {
            u.a(bool.booleanValue() ? 1010026 : 1010028, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, int i, Exception exc, com.qq.e.comm.plugin.y.c cVar) {
        u.a(1010030, i, cVar, a((String) null, exc, true, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z, com.qq.e.comm.plugin.y.c cVar) {
        u.a(1010404, z ? 1 : 0, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(long j, com.qq.e.comm.plugin.y.c cVar) {
        u.a(1010027, 0, cVar);
        long currentTimeMillis = j > 0 ? System.currentTimeMillis() - j : 0L;
        com.qq.e.comm.plugin.y.g gVar = new com.qq.e.comm.plugin.y.g(2010005);
        gVar.b(currentTimeMillis);
        gVar.a(cVar);
        u.a(gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(q qVar, com.qq.e.comm.plugin.y.c cVar) {
        int i;
        switch (qVar) {
            case IMG:
                i = 1010047;
                break;
            case VIDEO:
                i = 1010048;
                break;
            default:
                return;
        }
        u.a(i, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(b.EnumC1204b enumC1204b, b.EnumC1204b enumC1204b2, com.qq.e.comm.plugin.y.c cVar, int i, Exception exc, String str, String str2) {
        if (enumC1204b == b.EnumC1204b.Downloading || enumC1204b2 == b.EnumC1204b.Downloading) {
            return;
        }
        if (enumC1204b == b.EnumC1204b.Downloaded) {
            u.a(1010040, cVar);
            if (enumC1204b2 == b.EnumC1204b.Failed) {
                u.a(1010043, i, cVar, a(str, exc, true, (String) null));
            }
        } else if (enumC1204b2 == b.EnumC1204b.Downloaded) {
            u.a(1010044, i, cVar, a((String) null, exc, true, str2));
        } else {
            u.a(1010045, i, cVar, a(str, exc, true, str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(long j, com.qq.e.comm.plugin.y.c cVar) {
        long currentTimeMillis = j > 0 ? System.currentTimeMillis() - j : 0L;
        com.qq.e.comm.plugin.y.g gVar = new com.qq.e.comm.plugin.y.g(2010006);
        gVar.b(currentTimeMillis);
        gVar.a(cVar);
        u.a(gVar);
    }
}
