package com.cmic.sso.sdk.auth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.activity.BaseActivity;
import com.cmic.sso.sdk.b;
import com.cmic.sso.sdk.d.d;
import com.cmic.sso.sdk.d.h;
import com.cmic.sso.sdk.d.k;
import com.cmic.sso.sdk.d.l;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    public static a f30449c;

    /* renamed from: a  reason: collision with root package name */
    public com.cmic.sso.sdk.b.c.a f30450a = com.cmic.sso.sdk.b.c.a.a();

    /* renamed from: b  reason: collision with root package name */
    public Context f30451b;

    public a(Context context) {
        this.f30451b = context.getApplicationContext();
    }

    private void b(final com.cmic.sso.sdk.a aVar, final b bVar) {
        com.cmic.sso.sdk.d.c.b("AuthnBusiness", "getPrePhonescrip start");
        String packageName = this.f30451b.getPackageName();
        String a2 = d.a(l.a(this.f30451b, packageName));
        aVar.a("apppackage", packageName);
        aVar.a("appsign", a2);
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
        aVar.a(b.a.f30458a, bArr);
        aVar.a("authtype", "3");
        this.f30450a.a(aVar, new com.cmic.sso.sdk.b.c.d() { // from class: com.cmic.sso.sdk.auth.a.1
            /* JADX WARN: Removed duplicated region for block: B:51:0x00e4  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x0108  */
            @Override // com.cmic.sso.sdk.b.c.d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void a(String str, String str2, JSONObject jSONObject) {
                String b2;
                JSONException e3;
                String str3;
                JSONObject jSONObject2;
                String str4;
                String str5;
                String str6;
                String str7;
                if ("103000".equals(str)) {
                    String optString = jSONObject.optString("resultdata");
                    if (TextUtils.isEmpty(optString)) {
                        b2 = jSONObject.toString();
                    } else {
                        b2 = com.cmic.sso.sdk.d.a.b(aVar.a(b.a.f30458a), optString);
                    }
                    String str8 = null;
                    try {
                        jSONObject2 = new JSONObject(b2);
                    } catch (JSONException e4) {
                        e3 = e4;
                        str3 = null;
                        jSONObject2 = null;
                        str4 = null;
                    }
                    try {
                        str7 = jSONObject2.optString("phonescrip");
                        try {
                            if (aVar.b("keyIsSimKeyICCID", false)) {
                                str4 = aVar.b("iccid", "");
                            } else {
                                str4 = aVar.b("imsi", "");
                            }
                            try {
                                k.a a3 = k.a();
                                str5 = jSONObject2.optString("securityphone");
                                try {
                                    a3.a("securityphone", str5);
                                    str6 = jSONObject2.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID);
                                    try {
                                        if (TextUtils.isEmpty(str6)) {
                                            str6 = jSONObject2.optString("pcid");
                                        }
                                        str8 = jSONObject2.optString("sourceid");
                                        a3.a("sourceid", str8);
                                        a3.a("allcapaids", jSONObject2.optString("capaids", "acd"));
                                        a3.b();
                                    } catch (JSONException e5) {
                                        e3 = e5;
                                        String str9 = str8;
                                        str8 = str7;
                                        str3 = str9;
                                        e3.printStackTrace();
                                        String str10 = str8;
                                        str8 = str3;
                                        str7 = str10;
                                        com.cmic.sso.sdk.d.c.b("AuthnBusiness", "securityPhone  = " + str5);
                                        aVar.a(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str6);
                                        aVar.a("phonescrip", str7);
                                        aVar.a("securityphone", str5);
                                        aVar.a("sourceid", str8);
                                        if (aVar.c("logintype") != 3) {
                                        }
                                    }
                                } catch (JSONException e6) {
                                    e3 = e6;
                                    str6 = null;
                                }
                            } catch (JSONException e7) {
                                e3 = e7;
                                str5 = null;
                                str6 = null;
                                str8 = str7;
                                str3 = null;
                            }
                        } catch (JSONException e8) {
                            str5 = null;
                            str6 = null;
                            e3 = e8;
                            str8 = str7;
                            str3 = null;
                            str4 = null;
                        }
                    } catch (JSONException e9) {
                        e3 = e9;
                        str3 = null;
                        str4 = null;
                        str5 = str4;
                        str6 = str5;
                        e3.printStackTrace();
                        String str102 = str8;
                        str8 = str3;
                        str7 = str102;
                        com.cmic.sso.sdk.d.c.b("AuthnBusiness", "securityPhone  = " + str5);
                        aVar.a(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str6);
                        aVar.a("phonescrip", str7);
                        aVar.a("securityphone", str5);
                        aVar.a("sourceid", str8);
                        if (aVar.c("logintype") != 3) {
                        }
                    }
                    com.cmic.sso.sdk.d.c.b("AuthnBusiness", "securityPhone  = " + str5);
                    aVar.a(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str6);
                    aVar.a("phonescrip", str7);
                    aVar.a("securityphone", str5);
                    aVar.a("sourceid", str8);
                    if (aVar.c("logintype") != 3) {
                        a.this.c(aVar, bVar);
                        return;
                    }
                    com.cmic.sso.sdk.d.c.a("AuthnBusiness", "预取号==>");
                    if (jSONObject2 != null) {
                        h.a(a.this.f30451b, str7, jSONObject2.optLong("phonescripED"), str4);
                    }
                    bVar.a("103000", "true", aVar, c.a(str5));
                    return;
                }
                bVar.a(str, str2, aVar, jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final com.cmic.sso.sdk.a aVar, final b bVar) {
        com.cmic.sso.sdk.d.c.b("AuthnBusiness", "获取平台token》》》》");
        if (aVar.c("logintype") == 1) {
            aVar.a("userCapaid", BasicPushStatus.SUCCESS_CODE);
        } else if (aVar.c("logintype") == 0) {
            aVar.a("userCapaid", "50");
        }
        this.f30450a.b(aVar, new com.cmic.sso.sdk.b.c.d() { // from class: com.cmic.sso.sdk.auth.a.2
            @Override // com.cmic.sso.sdk.b.c.d
            public void a(String str, String str2, JSONObject jSONObject) {
                com.cmic.sso.sdk.d.c.c("AuthnBusiness", "获取平台token 》》》》" + jSONObject.toString());
                if (str.equals("103000")) {
                    long optLong = jSONObject.optLong("phonescripED");
                    String optString = jSONObject.optString("phonescrip");
                    if (aVar.b("keyIsSimKeyICCID", false)) {
                        h.a(a.this.f30451b, optString, optLong, aVar.b("iccid", ""));
                    } else {
                        h.a(a.this.f30451b, optString, optLong, aVar.b("imsi", ""));
                    }
                    aVar.a(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID));
                }
                bVar.a(str, str2, aVar, jSONObject);
            }
        });
    }

    public static a a(Context context) {
        if (f30449c == null) {
            synchronized (a.class) {
                if (f30449c == null) {
                    f30449c = new a(context);
                }
            }
        }
        return f30449c;
    }

    public void a(com.cmic.sso.sdk.a aVar, b bVar) {
        com.cmic.sso.sdk.d.c.b("AuthnBusiness", "LoginCheck method start");
        int b2 = aVar.b("logintype", 0);
        if (aVar.b("isCacheScrip", false)) {
            String b3 = aVar.b("securityphone", "");
            if (b2 == 3) {
                bVar.a("103000", "true", aVar, c.a(b3));
                return;
            } else {
                c(aVar, bVar);
                return;
            }
        }
        b(aVar, bVar);
    }
}
