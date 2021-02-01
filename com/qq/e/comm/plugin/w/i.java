package com.qq.e.comm.plugin.w;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ab;
import com.qq.e.comm.plugin.util.af;
import com.qq.e.comm.plugin.util.t;
import com.qq.e.comm.plugin.w.a.d;
import com.qq.e.comm.plugin.w.d;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes15.dex */
public class i {
    public static d.a a(com.qq.e.comm.plugin.s.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new d.a(aVar.E(), null, aVar);
    }

    public static String a(String str) {
        if (!StringUtil.isEmpty(str)) {
            String[] strArr = {"__CONN__", "__CELL_NATIVE__"};
            String[] strArr2 = {String.valueOf(GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue()), ab.a()};
            for (int i = 0; i < strArr.length; i++) {
                if (!StringUtil.isEmpty(strArr2[i])) {
                    str = str.replace(strArr[i], strArr2[i]);
                }
            }
        }
        return str;
    }

    public static void a(String str, int i, com.qq.e.comm.plugin.s.a aVar, b bVar, String str2, d.b bVar2) {
        if (aVar == null) {
            return;
        }
        d.a(str, i, str2, bVar, bVar2);
    }

    public static void a(String str, int i, com.qq.e.comm.plugin.s.a aVar, d.b bVar) {
        if (aVar == null) {
            return;
        }
        String b2 = t.b(aVar.N(), com.qq.e.comm.plugin.ad.g.a(str, i));
        GDTLogger.d("append mu_p key and value, modified url( ccr )  = " + b2);
        af.a(b2, new com.qq.e.comm.plugin.t.h(bVar));
    }
}
