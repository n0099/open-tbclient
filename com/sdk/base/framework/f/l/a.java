package com.sdk.base.framework.f.l;

import android.content.Context;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.a.i;
import com.sdk.base.framework.bean.DataInfo;
import com.sdk.base.framework.c.f;
import java.util.TreeMap;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4511a;
    private static Boolean b;

    static {
        new TreeMap();
        f4511a = a.class.getSimpleName();
        b = Boolean.valueOf(f.b);
    }

    public static String a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String a2 = com.sdk.base.framework.f.i.b.a(jSONObject.optString("aesKey"), com.sdk.base.framework.f.b.a.a(context, "public_key"));
            return com.sdk.base.framework.f.j.a.b(jSONObject.optString("data"), a2.substring(0, 16), a2.substring(16));
        } catch (Throwable th) {
            com.sdk.base.framework.f.g.a.a(th.toString());
            c.b(f4511a, "SDK解密异常：" + th.toString(), b);
            return null;
        }
    }

    public static void a(Context context, int i, String str, String str2, int i2) {
        boolean z = false;
        if ((i == 101005 || i == 302001 || i == 302002 || i == 302003) ? true : true) {
            try {
                com.sdk.base.framework.f.g.a.b().a(i2);
                com.sdk.mobile.c.a aVar = new com.sdk.mobile.c.a(context, new b());
                String a2 = com.sdk.base.framework.f.g.a.a(i);
                DataInfo dataInfo = new DataInfo();
                dataInfo.putData("status", String.valueOf(i));
                dataInfo.putData("msg", str);
                dataInfo.putData(MapBundleKey.MapObjKey.OBJ_SL_OBJ, a2);
                dataInfo.putData("seq", str2);
                aVar.a(aVar.c, "/st/api/v1.0/ses", dataInfo, aVar.a(), 0, i.b);
            } catch (Throwable th) {
            }
        }
    }

    public static boolean a(String str) {
        try {
            return new JSONObject(str).optLong("exp") < System.currentTimeMillis();
        } catch (Exception e) {
            c.c(f4511a, "out data error" + e, b);
            return true;
        }
    }
}
