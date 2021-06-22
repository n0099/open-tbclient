package com.cmic.sso.sdk.auth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.cmic.sso.sdk.d.e;
import com.cmic.sso.sdk.d.g;
import com.cmic.sso.sdk.d.h;
import com.cmic.sso.sdk.d.j;
import com.cmic.sso.sdk.d.k;
import com.cmic.sso.sdk.d.n;
import com.cmic.sso.sdk.d.o;
import com.cmic.sso.sdk.d.p;
import com.cmic.sso.sdk.d.q;
import com.cmic.sso.sdk.d.r;
import com.cmic.sso.sdk.d.s;
import com.cmic.sso.sdk.d.t;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AuthnHelper {
    public static final String SDK_VERSION = "quick_login_android_9.3.0";
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    public static AuthnHelper f30609c;

    /* renamed from: a  reason: collision with root package name */
    public final com.cmic.sso.sdk.auth.a f30610a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f30611b;

    /* renamed from: d  reason: collision with root package name */
    public long f30612d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f30613e;

    /* renamed from: f  reason: collision with root package name */
    public String f30614f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f30615g;

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final com.cmic.sso.sdk.a f30644b;

        public a(com.cmic.sso.sdk.a aVar) {
            this.f30644b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject a2;
            if (!t.a(AuthnHelper.this.f30611b).a() && this.f30644b.b("doNetworkSwitch", false)) {
                a2 = c.a("102508", "数据网络切换失败");
            } else {
                a2 = c.a("200023", "登录超时");
            }
            AuthnHelper.this.callBackResult(a2.optString(MiPushCommandMessage.KEY_RESULT_CODE, "200023"), a2.optString("resultString", "登录超时"), this.f30644b, a2);
        }
    }

    public AuthnHelper(Context context) {
        this.f30612d = 8000L;
        this.f30615g = new Object();
        this.f30611b = context.getApplicationContext();
        this.f30613e = new Handler(this.f30611b.getMainLooper());
        this.f30610a = com.cmic.sso.sdk.auth.a.a(this.f30611b);
        t.a(this.f30611b);
        k.a(this.f30611b);
        j.a(this.f30611b);
        o.a(new o.a() { // from class: com.cmic.sso.sdk.auth.AuthnHelper.1
            @Override // com.cmic.sso.sdk.d.o.a
            public void a() {
                String b2 = k.b("AID", "");
                com.cmic.sso.sdk.d.c.b("AuthnHelper", "aid = " + b2);
                if (TextUtils.isEmpty(b2)) {
                    AuthnHelper.this.a();
                }
                if (com.cmic.sso.sdk.d.b.a(AuthnHelper.this.f30611b, true)) {
                    com.cmic.sso.sdk.d.c.b("AuthnHelper", "生成androidkeystore成功");
                } else {
                    com.cmic.sso.sdk.d.c.b("AuthnHelper", "生成androidkeystore失败");
                }
            }
        });
    }

    public static AuthnHelper getInstance(Context context) {
        if (f30609c == null) {
            synchronized (AuthnHelper.class) {
                if (f30609c == null) {
                    f30609c = new AuthnHelper(context);
                }
            }
        }
        return f30609c;
    }

    public static void setDebugMode(boolean z) {
        com.cmic.sso.sdk.d.c.a(z);
    }

    public void callBackResult(String str, String str2, final com.cmic.sso.sdk.a aVar, JSONObject jSONObject) {
        final JSONObject a2;
        try {
            String b2 = aVar.b("traceId");
            if (e.a(b2)) {
                return;
            }
            synchronized (this) {
                final TokenListener c2 = e.c(b2);
                e.b(b2);
                if (c2 == null) {
                    return;
                }
                aVar.a("systemEndTime", SystemClock.elapsedRealtime());
                aVar.a("endtime", p.a());
                int c3 = aVar.c("logintype");
                if (jSONObject == null) {
                    jSONObject = c.a(str, str2);
                }
                if (c3 == 3) {
                    a2 = c.a(str, aVar, jSONObject);
                } else {
                    a2 = c.a(str, str2, aVar, jSONObject);
                }
                a2.put("scripExpiresIn", String.valueOf(h.b()));
                this.f30613e.post(new Runnable() { // from class: com.cmic.sso.sdk.auth.AuthnHelper.6
                    @Override // java.lang.Runnable
                    public void run() {
                        c2.onGetTokenComplete(a2);
                    }
                });
                a(this.f30611b, str, aVar);
                if (aVar.b("isNeedToGetCert", false) || q.a()) {
                    o.a(new o.a() { // from class: com.cmic.sso.sdk.auth.AuthnHelper.7
                        @Override // com.cmic.sso.sdk.d.o.a
                        public void a() {
                            q.a(aVar);
                        }
                    });
                }
                if (e.a()) {
                    t.a(this.f30611b).b();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void delScrip() {
        try {
            h.a(true, true);
            com.cmic.sso.sdk.d.c.b("AuthnHelper", "删除scrip");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public JSONObject getNetworkType(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            com.cmic.sso.sdk.a.b.a().a(context, g.a(context, "android.permission.READ_PHONE_STATE"));
            String a2 = j.a().a(true);
            int a3 = n.a(context, a2);
            jSONObject.put("operatortype", a2);
            StringBuilder sb = new StringBuilder();
            sb.append(a3);
            sb.append("");
            jSONObject.put("networktype", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("网络类型: ");
            sb2.append(a3);
            com.cmic.sso.sdk.d.c.b("AuthnHelper", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("运营商类型: ");
            sb3.append(a2);
            com.cmic.sso.sdk.d.c.b("AuthnHelper", sb3.toString());
            return jSONObject;
        } catch (Exception unused) {
            try {
                jSONObject.put("errorDes", "发生未知错误");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    public void getPhoneInfo(final String str, final String str2, final TokenListener tokenListener) {
        final com.cmic.sso.sdk.a a2 = a(tokenListener);
        o.a(new o.a(this.f30611b, a2) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.4
            @Override // com.cmic.sso.sdk.d.o.a
            public void a() {
                if (AuthnHelper.this.a(a2, str, str2, "preGetMobile", 3, tokenListener)) {
                    AuthnHelper.this.a(a2);
                }
            }
        });
    }

    public void loginAuth(final String str, final String str2, final TokenListener tokenListener) {
        final com.cmic.sso.sdk.a a2 = a(tokenListener);
        o.a(new o.a(this.f30611b, a2) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.2
            @Override // com.cmic.sso.sdk.d.o.a
            public void a() {
                if (AuthnHelper.this.a(a2, str, str2, "loginAuth", 1, tokenListener)) {
                    AuthnHelper.this.a(a2);
                }
            }
        });
    }

    public void mobileAuth(final String str, final String str2, final TokenListener tokenListener) {
        final com.cmic.sso.sdk.a a2 = a(tokenListener);
        o.a(new o.a(this.f30611b, a2) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.3
            @Override // com.cmic.sso.sdk.d.o.a
            public void a() {
                if (AuthnHelper.this.a(a2, str, str2, "mobileAuth", 0, tokenListener)) {
                    AuthnHelper.this.a(a2);
                }
            }
        });
    }

    public void setOverTime(long j) {
        this.f30612d = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        String str = "%" + s.a();
        com.cmic.sso.sdk.d.c.b("AuthnHelper", "generate aid = " + str);
        k.a a2 = k.a();
        a2.a("AID", str);
        a2.b();
    }

    public static AuthnHelper getInstance(Context context, String str) {
        if (f30609c == null) {
            synchronized (AuthnHelper.class) {
                if (f30609c == null) {
                    f30609c = new AuthnHelper(context, str);
                }
            }
        }
        return f30609c;
    }

    private com.cmic.sso.sdk.a a(TokenListener tokenListener) {
        com.cmic.sso.sdk.a aVar = new com.cmic.sso.sdk.a(64);
        String b2 = s.b();
        aVar.a(new com.cmic.sso.sdk.c.a());
        aVar.a("traceId", b2);
        com.cmic.sso.sdk.d.c.a("traceId", b2);
        if (tokenListener != null) {
            e.a(b2, tokenListener);
        }
        return aVar;
    }

    public AuthnHelper(Context context, String str) {
        this(context);
        this.f30614f = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.cmic.sso.sdk.a aVar) {
        final a aVar2 = new a(aVar);
        this.f30613e.postDelayed(aVar2, this.f30612d);
        this.f30610a.a(aVar, new b() { // from class: com.cmic.sso.sdk.auth.AuthnHelper.5
            @Override // com.cmic.sso.sdk.auth.b
            public void a(String str, String str2, com.cmic.sso.sdk.a aVar3, JSONObject jSONObject) {
                AuthnHelper.this.f30613e.removeCallbacks(aVar2);
                AuthnHelper.this.callBackResult(str, str2, aVar3, jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.cmic.sso.sdk.a aVar, String str, String str2, String str3, int i2, TokenListener tokenListener) {
        boolean a2;
        aVar.a("CLOSE_CERT_VERIFY", q.j());
        aVar.a("use2048PublicKey", "rsa2048".equals(this.f30614f));
        aVar.a("systemStartTime", SystemClock.elapsedRealtime());
        aVar.a("starttime", p.a());
        aVar.a("loginMethod", str3);
        aVar.a("appkey", str2);
        aVar.a("appid", str);
        aVar.a("timeOut", String.valueOf(this.f30612d));
        boolean a3 = g.a(this.f30611b, "android.permission.READ_PHONE_STATE");
        com.cmic.sso.sdk.d.c.a("AuthnHelper", "有READ_PHONE_STATE权限？" + a3);
        aVar.a("hsaReadPhoneStatePermission", a3);
        com.cmic.sso.sdk.a.b.a().a(this.f30611b, a3);
        aVar.a("networkClass", com.cmic.sso.sdk.a.b.a().a(this.f30611b));
        aVar.a("simCardNum", String.valueOf(com.cmic.sso.sdk.a.b.a().b().h()));
        String b2 = j.a().b();
        String e2 = j.a().e();
        String c2 = j.a().c();
        String a4 = j.a().a(false);
        aVar.a(BaseStatisContent.IMSI, b2);
        aVar.a("operatortype", a4);
        aVar.a("iccid", e2);
        aVar.a("logintype", i2);
        com.cmic.sso.sdk.d.c.b("AuthnHelper", "iccid = " + e2);
        com.cmic.sso.sdk.d.c.b("AuthnHelper", "imsi = " + b2);
        com.cmic.sso.sdk.d.c.b("AuthnHelper", "subId = " + c2);
        if (!TextUtils.isEmpty(b2)) {
            com.cmic.sso.sdk.d.c.a("AuthnHelper", "使用imsi作为缓存key = " + b2);
            aVar.a("scripType", BaseStatisContent.IMSI);
            aVar.a("scripKey", b2);
        } else if (!TextUtils.isEmpty(e2)) {
            com.cmic.sso.sdk.d.c.a("AuthnHelper", "使用iccid作为缓存key = " + e2);
            aVar.a("scripType", "iccid");
            aVar.a("scripKey", e2);
        } else if (!TextUtils.isEmpty(c2)) {
            com.cmic.sso.sdk.d.c.a("AuthnHelper", "使用subId作为缓存key = " + c2);
            aVar.a("scripType", "subid");
            aVar.a("scripKey", c2);
        } else if (!TextUtils.isEmpty(a4)) {
            com.cmic.sso.sdk.d.c.a("AuthnHelper", "使用operator作为缓存key = " + a4);
            aVar.a("scripType", "operator");
            aVar.a("scripKey", a4);
        }
        int a5 = n.a(this.f30611b, a4);
        aVar.a("networktype", a5);
        synchronized (this.f30615g) {
            a2 = h.a(aVar);
            if (a2) {
                aVar.a("securityphone", k.b("securityphone", ""));
                if (3 != i2 && a5 != 0) {
                    String a6 = h.a(this.f30611b);
                    if (TextUtils.isEmpty(a6)) {
                        a2 = false;
                    } else {
                        aVar.a("phonescrip", a6);
                    }
                    h.a(true, false);
                }
            }
            aVar.a("isCacheScrip", a2);
            StringBuilder sb = new StringBuilder();
            sb.append("isCachePhoneScrip = ");
            sb.append(a2);
            com.cmic.sso.sdk.d.c.b("AuthnHelper", sb.toString());
        }
        if (tokenListener == null) {
            callBackResult("102203", "listener不能为空", aVar, null);
            return false;
        } else if (q.d()) {
            callBackResult("200082", "服务器繁忙，请稍后重试", aVar, null);
            return false;
        } else {
            if (TextUtils.isEmpty(str == null ? "" : str.trim())) {
                callBackResult("102203", "appId 不能为空", aVar, null);
                return false;
            }
            if (TextUtils.isEmpty(str2 == null ? "" : str2.trim())) {
                callBackResult("102203", "appkey不能为空", aVar, null);
                return false;
            } else if (a5 == 0) {
                callBackResult("102101", "未检测到网络", aVar, null);
                return false;
            } else if (TextUtils.isEmpty(a4)) {
                aVar.a("authType", String.valueOf(0));
                callBackResult("200010", "无法识别sim卡或没有sim卡", aVar, null);
                return false;
            } else if (a5 == 2 && !a2) {
                callBackResult("102103", "无数据网络", aVar, null);
                return false;
            } else if ("2".equals(a4) && q.k()) {
                callBackResult("200082", "服务器繁忙，请稍后重试", aVar, null);
                return false;
            } else if ("3".equals(a4) && q.l()) {
                callBackResult("200082", "服务器繁忙，请稍后重试", aVar, null);
                return false;
            } else {
                return true;
            }
        }
    }

    private void a(final Context context, final String str, final com.cmic.sso.sdk.a aVar) {
        String a2;
        if (q.m()) {
            return;
        }
        try {
            if ("105313".equals(str)) {
                URL url = new URL(q.i());
                int port = url.getPort() == -1 ? Constants.SOCKET_PORT_SSL : url.getPort();
                StringBuilder sb = new StringBuilder();
                sb.append("host = ");
                sb.append(url.getHost());
                sb.append("  port = ");
                sb.append(port);
                com.cmic.sso.sdk.d.c.b("AuthnHelper", sb.toString());
                if (aVar.c("networktype") == 3) {
                    a2 = t.a((Context) null).a(url.getHost(), port);
                } else {
                    a2 = r.a(url.getHost(), port);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("eip = ");
                sb2.append(a2);
                com.cmic.sso.sdk.d.c.b("AuthnHelper", sb2.toString());
                aVar.a("eipKey", a2);
            }
        } catch (Exception unused) {
            com.cmic.sso.sdk.d.c.a("AuthnHelper", "日志上报获取eip失败");
        }
        o.a(new o.a() { // from class: com.cmic.sso.sdk.auth.AuthnHelper.8
            @Override // com.cmic.sso.sdk.d.o.a
            public void a() {
                if ("200023".equals(str)) {
                    SystemClock.sleep(8000L);
                }
                new com.cmic.sso.sdk.c.b().a(context, str, aVar);
            }
        });
    }
}
