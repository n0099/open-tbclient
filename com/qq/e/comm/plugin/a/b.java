package com.qq.e.comm.plugin.a;

import android.annotation.SuppressLint;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes3.dex */
public class b {
    @SuppressLint({"DefaultLocale"})
    private static String a(int i, c cVar) {
        return (String) gdtadv.getobjresult(0, 1, Integer.valueOf(i), cVar);
    }

    @SuppressLint({"DefaultLocale"})
    private static String a(int i, c cVar, boolean z) {
        return (String) gdtadv.getobjresult(1, 1, Integer.valueOf(i), cVar, Boolean.valueOf(z));
    }

    public static JSONObject a(c cVar) {
        return (JSONObject) gdtadv.getobjresult(2, 1, cVar);
    }

    public static void a(c cVar, boolean z) {
        gdtadv.getVresult(3, 1, cVar, Boolean.valueOf(z));
    }

    private static boolean b(c cVar) {
        return gdtadv.getZresult(4, 1, cVar);
    }
}
