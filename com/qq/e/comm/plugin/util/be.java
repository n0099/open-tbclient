package com.qq.e.comm.plugin.util;

import android.content.Context;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.fsg.base.activity.BaseActivity;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes15.dex */
public class be {
    public static int a() {
        return gdtadv.getIresult(RtcConstants.METHOD_IM_RTC_MSG, 1, new Object[0]);
    }

    private static int a(Context context, String str, String str2, String str3, String str4) {
        return gdtadv.getIresult(231, 1, context, str, str2, str3, str4);
    }

    private static int a(Context context, String str, String str2, String str3, String str4, boolean z) {
        return gdtadv.getIresult(232, 1, context, str, str2, str3, str4, Boolean.valueOf(z));
    }

    private static int a(Object obj) {
        return gdtadv.getIresult(233, 1, obj);
    }

    private static int a(Object obj, String str) {
        return gdtadv.getIresult(234, 1, obj, str);
    }

    public static int a(JSONObject jSONObject) {
        return gdtadv.getIresult(235, 1, jSONObject);
    }

    public static int a(JSONObject jSONObject, boolean z) {
        return gdtadv.getIresult(236, 1, jSONObject, Boolean.valueOf(z));
    }

    public static JSONObject a(com.qq.e.comm.plugin.ad.s sVar) {
        return (JSONObject) gdtadv.getobjresult(237, 1, sVar);
    }

    public static void a(int i, com.qq.e.comm.plugin.y.c cVar, com.qq.e.comm.plugin.y.d dVar, boolean z, boolean z2) {
        gdtadv.getVresult(238, 1, Integer.valueOf(i), cVar, dVar, Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public static int b() {
        return gdtadv.getIresult(239, 1, new Object[0]);
    }

    public static JSONObject b(JSONObject jSONObject) {
        return (JSONObject) gdtadv.getobjresult(240, 1, jSONObject);
    }

    private static JSONObject c() {
        return (JSONObject) gdtadv.getobjresult(BaseActivity.DIALOG_PROMPT, 1, new Object[0]);
    }
}
