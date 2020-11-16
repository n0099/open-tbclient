package com.cmic.sso.sdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.cmic.sso.sdk.b;
import com.cmic.sso.sdk.e.h;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.l;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    @SuppressLint({"StaticFieldLeak"})
    private static c oKq = null;
    private Context b;
    private com.cmic.sso.sdk.c.c.a oKp = com.cmic.sso.sdk.c.c.a.eiM();

    private c(Context context) {
        this.b = context.getApplicationContext();
    }

    public static c gT(Context context) {
        if (oKq == null) {
            synchronized (c.class) {
                if (oKq == null) {
                    oKq = new c(context);
                }
            }
        }
        return oKq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.cmic.sso.sdk.a aVar, d dVar) {
        com.cmic.sso.sdk.e.c.b("AuthnBusiness", "LoginCheck method start");
        int b = aVar.b("logintype", 0);
        if (aVar.b("isCacheScrip", false)) {
            String b2 = aVar.b("securityphone", "");
            if (b == 3) {
                dVar.b("103000", "true", aVar, e.a(b2));
                return;
            } else {
                c(aVar, dVar);
                return;
            }
        }
        b(aVar, dVar);
    }

    private void b(final com.cmic.sso.sdk.a aVar, final d dVar) {
        com.cmic.sso.sdk.e.c.b("AuthnBusiness", "getPrePhonescrip start");
        String packageName = this.b.getPackageName();
        String a2 = com.cmic.sso.sdk.e.d.a(l.a(this.b, packageName));
        aVar.a("apppackage", packageName);
        aVar.a("appsign", a2);
        byte[] bArr = new byte[0];
        if (aVar.b("use2048PublicKey", false)) {
            com.cmic.sso.sdk.e.c.a("AuthnBusiness", "使用2048公钥对应的对称秘钥生成方式");
            bArr = com.cmic.sso.sdk.e.a.a();
        } else {
            com.cmic.sso.sdk.e.c.a("AuthnBusiness", "使用1024公钥对应的对称秘钥生成方式");
            try {
                bArr = UUID.randomUUID().toString().substring(0, 16).getBytes("utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        aVar.a(b.a.f4005a, bArr);
        aVar.a("authtype", "3");
        this.oKp.a(aVar, new com.cmic.sso.sdk.c.c.d() { // from class: com.cmic.sso.sdk.b.c.1
            /* JADX WARN: Removed duplicated region for block: B:21:0x00ca  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0121  */
            @Override // com.cmic.sso.sdk.c.c.d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void j(String str, String str2, JSONObject jSONObject) {
                String f;
                String str3;
                String str4;
                String str5;
                String str6;
                JSONObject jSONObject2;
                JSONException e2;
                String str7;
                if ("103000".equals(str)) {
                    String optString = jSONObject.optString("resultdata");
                    if (TextUtils.isEmpty(optString)) {
                        f = jSONObject.toString();
                    } else {
                        f = com.cmic.sso.sdk.e.a.f(aVar.a(b.a.f4005a), optString);
                    }
                    try {
                        jSONObject2 = new JSONObject(f);
                        try {
                            str6 = jSONObject2.optString("phonescrip");
                            try {
                                if (aVar.b("keyIsSimKeyICCID", false)) {
                                    str7 = aVar.b("iccid", "");
                                } else {
                                    str7 = aVar.b("imsi", "");
                                }
                                try {
                                    k.a eiS = k.eiS();
                                    str5 = jSONObject2.optString("securityphone");
                                    try {
                                        eiS.a("securityphone", str5);
                                        str4 = jSONObject2.optString("openId");
                                        try {
                                            if (TextUtils.isEmpty(str4)) {
                                                str4 = jSONObject2.optString("pcid");
                                            }
                                            str3 = jSONObject2.optString(UgcConstant.SOURCE_ID);
                                        } catch (JSONException e3) {
                                            str3 = null;
                                            e2 = e3;
                                        }
                                        try {
                                            eiS.a(UgcConstant.SOURCE_ID, str3);
                                            eiS.a("allcapaids", jSONObject2.optString("capaids", "acd"));
                                            eiS.b();
                                        } catch (JSONException e4) {
                                            e2 = e4;
                                            e2.printStackTrace();
                                            com.cmic.sso.sdk.e.c.b("AuthnBusiness", "securityPhone  = " + str5);
                                            aVar.a("openId", str4);
                                            aVar.a("phonescrip", str6);
                                            aVar.a("securityphone", str5);
                                            aVar.a(UgcConstant.SOURCE_ID, str3);
                                            if (aVar.c("logintype") == 3) {
                                            }
                                        }
                                    } catch (JSONException e5) {
                                        str4 = null;
                                        e2 = e5;
                                        str3 = null;
                                    }
                                } catch (JSONException e6) {
                                    str4 = null;
                                    str5 = null;
                                    str3 = null;
                                    e2 = e6;
                                }
                            } catch (JSONException e7) {
                                str3 = null;
                                str4 = null;
                                str5 = null;
                                e2 = e7;
                                str7 = null;
                            }
                        } catch (JSONException e8) {
                            str3 = null;
                            str4 = null;
                            str5 = null;
                            str6 = null;
                            str7 = null;
                            e2 = e8;
                        }
                    } catch (JSONException e9) {
                        str3 = null;
                        str4 = null;
                        str5 = null;
                        str6 = null;
                        jSONObject2 = null;
                        e2 = e9;
                        str7 = null;
                    }
                    com.cmic.sso.sdk.e.c.b("AuthnBusiness", "securityPhone  = " + str5);
                    aVar.a("openId", str4);
                    aVar.a("phonescrip", str6);
                    aVar.a("securityphone", str5);
                    aVar.a(UgcConstant.SOURCE_ID, str3);
                    if (aVar.c("logintype") == 3) {
                        c.this.c(aVar, dVar);
                        return;
                    }
                    com.cmic.sso.sdk.e.c.a("AuthnBusiness", "预取号==>");
                    if (jSONObject2 != null) {
                        h.a(c.this.b, str6, jSONObject2.optLong("phonescripED"), str7);
                    }
                    dVar.b("103000", "true", aVar, e.a(str5));
                    return;
                }
                dVar.b(str, str2, aVar, jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final com.cmic.sso.sdk.a aVar, final d dVar) {
        com.cmic.sso.sdk.e.c.b("AuthnBusiness", "获取平台token》》》》");
        if (aVar.c("logintype") == 1) {
            aVar.a("userCapaid", BasicPushStatus.SUCCESS_CODE);
        } else if (aVar.c("logintype") == 0) {
            aVar.a("userCapaid", "50");
        }
        this.oKp.b(aVar, new com.cmic.sso.sdk.c.c.d() { // from class: com.cmic.sso.sdk.b.c.2
            @Override // com.cmic.sso.sdk.c.c.d
            public void j(String str, String str2, JSONObject jSONObject) {
                com.cmic.sso.sdk.e.c.c("AuthnBusiness", "获取平台token 》》》》" + jSONObject.toString());
                if (str.equals("103000")) {
                    long optLong = jSONObject.optLong("phonescripED");
                    String optString = jSONObject.optString("phonescrip");
                    if (aVar.b("keyIsSimKeyICCID", false)) {
                        h.a(c.this.b, optString, optLong, aVar.b("iccid", ""));
                    } else {
                        h.a(c.this.b, optString, optLong, aVar.b("imsi", ""));
                    }
                    aVar.a("openId", jSONObject.optString("openId"));
                }
                dVar.b(str, str2, aVar, jSONObject);
            }
        });
    }
}
