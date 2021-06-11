package com.cmic.sso.sdk.auth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.activity.BaseActivity;
import com.cmic.sso.sdk.b;
import com.cmic.sso.sdk.b.c.d;
import com.cmic.sso.sdk.d.h;
import com.cmic.sso.sdk.d.k;
import com.cmic.sso.sdk.d.l;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    public static a f30563c;

    /* renamed from: a  reason: collision with root package name */
    public final com.cmic.sso.sdk.b.c.a f30564a = com.cmic.sso.sdk.b.c.a.a();

    /* renamed from: b  reason: collision with root package name */
    public final Context f30565b;

    public a(Context context) {
        this.f30565b = context.getApplicationContext();
    }

    private void b(final com.cmic.sso.sdk.a aVar, final b bVar) {
        com.cmic.sso.sdk.d.c.b("AuthnBusiness", "getScripAndToken start");
        a(aVar);
        if (!aVar.b("isCacheScrip", false)) {
            b(aVar);
        }
        if (aVar.c("logintype") == 1) {
            aVar.a("userCapaid", "200");
        } else if (aVar.c("logintype") == 0) {
            aVar.a("userCapaid", "50");
        }
        this.f30564a.a(aVar, new d() { // from class: com.cmic.sso.sdk.auth.a.1
            @Override // com.cmic.sso.sdk.b.c.d
            public void a(String str, String str2, JSONObject jSONObject) {
                a.this.a(aVar, bVar, str, str2, jSONObject);
            }
        });
    }

    public static a a(Context context) {
        if (f30563c == null) {
            synchronized (a.class) {
                if (f30563c == null) {
                    f30563c = new a(context);
                }
            }
        }
        return f30563c;
    }

    public void a(com.cmic.sso.sdk.a aVar, b bVar) {
        com.cmic.sso.sdk.d.c.b("AuthnBusiness", "LoginCheck method start");
        int c2 = aVar.c("logintype");
        if (aVar.b("isCacheScrip", false)) {
            String b2 = aVar.b("securityphone", "");
            if (c2 == 3) {
                bVar.a("103000", "true", aVar, c.a(b2));
                return;
            } else {
                b(aVar, bVar);
                return;
            }
        }
        b(aVar, bVar);
    }

    private void b(com.cmic.sso.sdk.a aVar) {
        byte[] bArr = new byte[0];
        if (aVar.b("use2048PublicKey", false)) {
            com.cmic.sso.sdk.d.c.a("AuthnBusiness", "使用2048公钥对应的对称秘钥生成方式");
            bArr = com.cmic.sso.sdk.d.a.a();
        } else {
            com.cmic.sso.sdk.d.c.a("AuthnBusiness", "使用1024公钥对应的对称秘钥生成方式");
            try {
                bArr = UUID.randomUUID().toString().substring(0, 16).getBytes("utf-8");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        aVar.a(b.a.f30569a, bArr);
        aVar.a("authType", "3");
    }

    private void a(com.cmic.sso.sdk.a aVar) {
        String packageName = this.f30565b.getPackageName();
        String a2 = com.cmic.sso.sdk.d.d.a(l.a(this.f30565b, packageName));
        aVar.a("apppackage", packageName);
        aVar.a("appsign", a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.cmic.sso.sdk.a aVar, b bVar, String str, String str2, JSONObject jSONObject) {
        String b2;
        String str3;
        JSONObject jSONObject2;
        String str4;
        String str5;
        String str6;
        JSONObject jSONObject3;
        if ("103000".equals(str)) {
            String optString = jSONObject.optString("resultdata");
            if (TextUtils.isEmpty(optString)) {
                b2 = jSONObject.toString();
            } else {
                b2 = com.cmic.sso.sdk.d.a.b(aVar.a(b.a.f30569a), optString);
            }
            String str7 = null;
            try {
                jSONObject3 = new JSONObject(b2);
                try {
                    String optString2 = jSONObject3.optString("phonescrip");
                    try {
                        k.a a2 = k.a();
                        str4 = jSONObject3.optString("securityphone");
                        try {
                            a2.a("securityphone", str4);
                            str7 = jSONObject3.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID);
                            if (TextUtils.isEmpty(str7)) {
                                str7 = jSONObject3.optString("pcid");
                            }
                            a2.b();
                            str5 = str4;
                            str6 = optString2;
                        } catch (JSONException e2) {
                            e = e2;
                            str3 = str7;
                            str7 = optString2;
                            jSONObject2 = jSONObject3;
                            e.printStackTrace();
                            str5 = str4;
                            str6 = str7;
                            str7 = str3;
                            jSONObject3 = jSONObject2;
                            com.cmic.sso.sdk.d.c.b("AuthnBusiness", "securityPhone  = " + str5);
                            aVar.a(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str7);
                            aVar.a("phonescrip", str6);
                            aVar.a("securityphone", str5);
                            if (jSONObject3 != null) {
                            }
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        str4 = null;
                        str7 = optString2;
                        jSONObject2 = jSONObject3;
                        str3 = str4;
                        e.printStackTrace();
                        str5 = str4;
                        str6 = str7;
                        str7 = str3;
                        jSONObject3 = jSONObject2;
                        com.cmic.sso.sdk.d.c.b("AuthnBusiness", "securityPhone  = " + str5);
                        aVar.a(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str7);
                        aVar.a("phonescrip", str6);
                        aVar.a("securityphone", str5);
                        if (jSONObject3 != null) {
                        }
                    }
                } catch (JSONException e4) {
                    e = e4;
                    str4 = null;
                }
            } catch (JSONException e5) {
                e = e5;
                str3 = null;
                jSONObject2 = null;
                str4 = null;
            }
            com.cmic.sso.sdk.d.c.b("AuthnBusiness", "securityPhone  = " + str5);
            aVar.a(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str7);
            aVar.a("phonescrip", str6);
            aVar.a("securityphone", str5);
            if (jSONObject3 != null) {
                h.a(this.f30565b, str6, Long.parseLong(jSONObject3.optString("scripExpiresIn", "0")), aVar.b("scripKey", ""), aVar.b("scripType", ""));
                if (aVar.c("logintype") == 3) {
                    bVar.a(str, "true", aVar, c.a(str5));
                    return;
                } else {
                    bVar.a(str, str2, aVar, jSONObject3);
                    return;
                }
            }
            com.cmic.sso.sdk.d.c.a("AuthnBusiness", "返回103000，但是数据解析出错");
            bVar.a(String.valueOf(102223), "数据解析异常", aVar, c.a(String.valueOf(102223), "数据解析异常"));
        } else if (aVar.c("logintype") == 3) {
            bVar.a(str, "true", aVar, c.b(str, str2));
        } else {
            bVar.a(str, str2, aVar, jSONObject);
        }
    }
}
