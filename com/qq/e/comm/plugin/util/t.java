package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.qq.e.comm.managers.GDTADManager;
/* loaded from: classes15.dex */
public class t {
    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str.length() + str2.length() <= GDTADManager.getInstance().getSM().getInteger("urlLimit", 2000)) {
            return az.c(str, "mu_p", str2);
        }
        ai.b("gdt_tag_p", "点击url超长 ， url = %s ,p = %s", str, str2);
        com.qq.e.comm.plugin.y.u.a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_END_POINT_NULL, 0, null);
        return str;
    }

    public static boolean a(String str) {
        return az.d(str, "ase", "1");
    }

    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str.length() + str2.length() <= GDTADManager.getInstance().getSM().getInteger("urlLimit", 2000)) {
            return az.c(str, "mu_p", str2);
        }
        ai.b("gdt_tag_p", "点击url超长 ， url = %s ,p = %s", str, str2);
        com.qq.e.comm.plugin.y.u.a(100162, 0, null);
        return str;
    }
}
