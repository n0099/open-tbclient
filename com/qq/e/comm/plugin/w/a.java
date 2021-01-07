package com.qq.e.comm.plugin.w;

import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.StringUtil;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes4.dex */
public class a {
    private static void a(int i, String str) {
        gdtadv.getVresult(115, 1, Integer.valueOf(i), str);
    }

    public static void a(String str) {
        a((int) GDiffPatcher.COPY_UBYTE_USHORT, str);
    }

    public static void a(String str, String str2) {
        if (StringUtil.isEmpty(str)) {
            return;
        }
        if (com.qq.e.comm.plugin.a.e.a.a(GDTADManager.getInstance().getAppContext(), str)) {
            a((int) GDiffPatcher.DATA_USHORT, str2);
        } else {
            a((int) GDiffPatcher.DATA_INT, str2);
        }
    }

    public static void a(boolean z, String str) {
        if (z) {
            a((int) GDiffPatcher.DATA_USHORT, str);
        } else {
            a((int) GDiffPatcher.DATA_INT, str);
        }
    }

    public static void a(boolean z, boolean z2, String str) {
        a(z ? z2 ? 266 : 267 : z2 ? 282 : 283, str);
    }

    private static String b(int i, String str) {
        return (String) gdtadv.getobjresult(116, 1, Integer.valueOf(i), str);
    }

    public static void b(String str) {
        a(246, str);
    }
}
