package com.sdk.base.framework.f.k;

import android.content.Context;
import com.alipay.sdk.packet.e;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.a.j;
import com.sdk.base.framework.bean.DataInfo;
import com.sdk.base.framework.c.f;
import java.util.TreeMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f35786a;

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f35787b;

    static {
        new TreeMap();
        f35786a = a.class.getSimpleName();
        f35787b = Boolean.valueOf(f.f35733b);
    }

    public static String a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String a2 = com.sdk.base.framework.f.h.b.a(jSONObject.optString("aesKey"), com.sdk.base.framework.f.b.a.a(context, e.m));
            return com.sdk.base.framework.f.i.a.b(jSONObject.optString("data"), a2.substring(0, 16), a2.substring(16));
        } catch (Throwable th) {
            com.sdk.base.framework.f.f.a.a(th.toString());
            String str2 = f35786a;
            c.b(str2, "SDK解密异常：" + th.toString(), f35787b);
            return null;
        }
    }

    public static void a(Context context, int i2, String str, String str2, int i3) {
        if (i2 == 101005 || i2 == 302001 || i2 == 302002 || i2 == 302003) {
            try {
                com.sdk.base.framework.f.f.a.b().a(i3);
                com.sdk.mobile.c.a aVar = new com.sdk.mobile.c.a(context, new b());
                String a2 = com.sdk.base.framework.f.f.a.a(i2);
                DataInfo dataInfo = new DataInfo();
                dataInfo.putData("status", String.valueOf(i2));
                dataInfo.putData("msg", str);
                dataInfo.putData("obj", a2);
                dataInfo.putData(IAdRequestParam.SEQ, str2);
                aVar.a(aVar.f35743c, "/st/api/v1.0/ses", dataInfo, aVar.a(), 0, j.f35693b);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(String str) {
        try {
            return new JSONObject(str).optLong("exp") < System.currentTimeMillis();
        } catch (Exception e2) {
            String str2 = f35786a;
            c.c(str2, "out data error" + e2, f35787b);
            return true;
        }
    }
}
