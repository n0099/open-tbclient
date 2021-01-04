package com.cmic.sso.sdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.cmic.sso.sdk.b;
import com.cmic.sso.sdk.e.h;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.l;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    @SuppressLint({"StaticFieldLeak"})
    private static c pqN = null;

    /* renamed from: b  reason: collision with root package name */
    private Context f7994b;
    private com.cmic.sso.sdk.c.c.a pqM = com.cmic.sso.sdk.c.c.a.esP();

    private c(Context context) {
        this.f7994b = context.getApplicationContext();
    }

    public static c ie(Context context) {
        if (pqN == null) {
            synchronized (c.class) {
                if (pqN == null) {
                    pqN = new c(context);
                }
            }
        }
        return pqN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.cmic.sso.sdk.a aVar, d dVar) {
        com.cmic.sso.sdk.e.c.b("AuthnBusiness", "LoginCheck method start");
        int b2 = aVar.b("logintype", 0);
        if (aVar.b("isCacheScrip", false)) {
            String b3 = aVar.b("securityphone", "");
            if (b2 == 3) {
                dVar.b("103000", "true", aVar, e.a(b3));
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
        String packageName = this.f7994b.getPackageName();
        String a2 = com.cmic.sso.sdk.e.d.a(l.a(this.f7994b, packageName));
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
        aVar.a(b.a.f7989a, bArr);
        aVar.a("authtype", "3");
        this.pqM.a(aVar, new com.cmic.sso.sdk.c.c.d() { // from class: com.cmic.sso.sdk.b.c.1
            /* JADX WARN: Removed duplicated region for block: B:21:0x00ca  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x011f  */
            @Override // com.cmic.sso.sdk.c.c.d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void i(String str, String str2, JSONObject jSONObject) {
                String b2;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7;
                JSONObject jSONObject2;
                if ("103000".equals(str)) {
                    String optString = jSONObject.optString("resultdata");
                    if (TextUtils.isEmpty(optString)) {
                        b2 = jSONObject.toString();
                    } else {
                        b2 = com.cmic.sso.sdk.e.a.b(aVar.a(b.a.f7989a), optString);
                    }
                    try {
                        jSONObject2 = new JSONObject(b2);
                        try {
                            str7 = jSONObject2.optString("phonescrip");
                            try {
                                if (aVar.b("keyIsSimKeyICCID", false)) {
                                    str3 = aVar.b("iccid", "");
                                } else {
                                    str3 = aVar.b("imsi", "");
                                }
                                try {
                                    k.a esV = k.esV();
                                    str6 = jSONObject2.optString("securityphone");
                                    try {
                                        esV.a("securityphone", str6);
                                        str5 = jSONObject2.optString("openId");
                                        try {
                                            if (TextUtils.isEmpty(str5)) {
                                                str5 = jSONObject2.optString("pcid");
                                            }
                                            str4 = jSONObject2.optString("sourceid");
                                        } catch (JSONException e2) {
                                            e = e2;
                                            str4 = null;
                                        }
                                    } catch (JSONException e3) {
                                        e = e3;
                                        str4 = null;
                                        str5 = null;
                                    }
                                    try {
                                        esV.a("sourceid", str4);
                                        esV.a("allcapaids", jSONObject2.optString("capaids", "acd"));
                                        esV.b();
                                    } catch (JSONException e4) {
                                        e = e4;
                                        e.printStackTrace();
                                        com.cmic.sso.sdk.e.c.b("AuthnBusiness", "securityPhone  = " + str6);
                                        aVar.a("openId", str5);
                                        aVar.a("phonescrip", str7);
                                        aVar.a("securityphone", str6);
                                        aVar.a("sourceid", str4);
                                        if (aVar.c("logintype") == 3) {
                                        }
                                    }
                                } catch (JSONException e5) {
                                    e = e5;
                                    str4 = null;
                                    str5 = null;
                                    str6 = null;
                                }
                            } catch (JSONException e6) {
                                e = e6;
                                str3 = null;
                                str4 = null;
                                str5 = null;
                                str6 = null;
                            }
                        } catch (JSONException e7) {
                            e = e7;
                            str3 = null;
                            str4 = null;
                            str5 = null;
                            str6 = null;
                            str7 = null;
                        }
                    } catch (JSONException e8) {
                        e = e8;
                        str3 = null;
                        str4 = null;
                        str5 = null;
                        str6 = null;
                        str7 = null;
                        jSONObject2 = null;
                    }
                    com.cmic.sso.sdk.e.c.b("AuthnBusiness", "securityPhone  = " + str6);
                    aVar.a("openId", str5);
                    aVar.a("phonescrip", str7);
                    aVar.a("securityphone", str6);
                    aVar.a("sourceid", str4);
                    if (aVar.c("logintype") == 3) {
                        c.this.c(aVar, dVar);
                        return;
                    }
                    com.cmic.sso.sdk.e.c.a("AuthnBusiness", "预取号==>");
                    if (jSONObject2 != null) {
                        h.a(c.this.f7994b, str7, jSONObject2.optLong("phonescripED"), str3);
                    }
                    dVar.b("103000", "true", aVar, e.a(str6));
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
        this.pqM.b(aVar, new com.cmic.sso.sdk.c.c.d() { // from class: com.cmic.sso.sdk.b.c.2
            @Override // com.cmic.sso.sdk.c.c.d
            public void i(String str, String str2, JSONObject jSONObject) {
                com.cmic.sso.sdk.e.c.c("AuthnBusiness", "获取平台token 》》》》" + jSONObject.toString());
                if (str.equals("103000")) {
                    long optLong = jSONObject.optLong("phonescripED");
                    String optString = jSONObject.optString("phonescrip");
                    if (aVar.b("keyIsSimKeyICCID", false)) {
                        h.a(c.this.f7994b, optString, optLong, aVar.b("iccid", ""));
                    } else {
                        h.a(c.this.f7994b, optString, optLong, aVar.b("imsi", ""));
                    }
                    aVar.a("openId", jSONObject.optString("openId"));
                }
                dVar.b(str, str2, aVar, jSONObject);
            }
        });
    }
}
