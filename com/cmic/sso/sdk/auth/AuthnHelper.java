package com.cmic.sso.sdk.auth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.cmic.sso.sdk.d.e;
import com.cmic.sso.sdk.d.g;
import com.cmic.sso.sdk.d.h;
import com.cmic.sso.sdk.d.j;
import com.cmic.sso.sdk.d.k;
import com.cmic.sso.sdk.d.n;
import com.cmic.sso.sdk.d.o;
import com.cmic.sso.sdk.d.p;
import com.cmic.sso.sdk.d.q;
import com.cmic.sso.sdk.d.s;
import com.cmic.sso.sdk.d.t;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AuthnHelper {
    public static final int ConcurrentBundle_DEFAULT_SIZE = 64;
    public static final String SDK_VERSION = "quick_login_android_9.2.2";
    public static final String TAG = "AuthnHelper";
    @SuppressLint({"StaticFieldLeak"})
    public static AuthnHelper mInstance;
    public com.cmic.sso.sdk.auth.a authnBusiness;
    public Context mContext;
    public Handler mHandler;
    public final Object mObject;
    public long overTime;
    public String use2048PublicKey;

    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public com.cmic.sso.sdk.a f30254b;

        public a(com.cmic.sso.sdk.a aVar) {
            this.f30254b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject a2;
            if (!t.a(AuthnHelper.this.mContext).a() && this.f30254b.b("doNetworkSwitch", false)) {
                a2 = c.a("102508", "数据网络切换失败");
            } else {
                a2 = c.a("200023", "登录超时");
            }
            AuthnHelper.this.callBackResult(a2.optString(MiPushCommandMessage.KEY_RESULT_CODE, "200023"), a2.optString("resultString", "登录超时"), this.f30254b, a2);
        }
    }

    public AuthnHelper(Context context) {
        this.overTime = 8000L;
        this.mObject = new Object();
        this.mContext = context.getApplicationContext();
        this.mHandler = new Handler(this.mContext.getMainLooper());
        this.authnBusiness = com.cmic.sso.sdk.auth.a.a(this.mContext);
        t.a(this.mContext);
        k.a(this.mContext);
        j.a(this.mContext);
        o.a(new o.a() { // from class: com.cmic.sso.sdk.auth.AuthnHelper.1
            @Override // com.cmic.sso.sdk.d.o.a
            public void a() {
                String b2 = k.b("AID", "");
                com.cmic.sso.sdk.d.c.b(AuthnHelper.TAG, "aid = " + b2);
                if (TextUtils.isEmpty(b2)) {
                    AuthnHelper.this.generateAID();
                }
                if (com.cmic.sso.sdk.d.b.a(AuthnHelper.this.mContext, true)) {
                    com.cmic.sso.sdk.d.c.b(AuthnHelper.TAG, "生成androidkeystore成功");
                } else {
                    com.cmic.sso.sdk.d.c.b(AuthnHelper.TAG, "生成androidkeystore失败");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean commonInit(com.cmic.sso.sdk.a aVar, String str, String str2, String str3, int i, TokenListener tokenListener) {
        boolean a2;
        aVar.a("CLOSE_CERT_VERIFY", q.h());
        aVar.a("use2048PublicKey", "rsa2048".equals(this.use2048PublicKey));
        aVar.a("systemStartTime", SystemClock.elapsedRealtime());
        aVar.a("starttime", p.a());
        aVar.a("loginMethod", str3);
        aVar.a("appkey", str2);
        aVar.a("appid", str);
        aVar.a("timeOut", String.valueOf(this.overTime));
        boolean a3 = g.a(this.mContext, "android.permission.READ_PHONE_STATE");
        com.cmic.sso.sdk.d.c.a(TAG, "有READ_PHONE_STATE权限？" + a3);
        aVar.a("hsaReadPhoneStatePermission", a3);
        com.cmic.sso.sdk.a.b.a().a(this.mContext, a3);
        aVar.a("networkClass", com.cmic.sso.sdk.a.b.a().a(this.mContext));
        aVar.a("simCardNum", String.valueOf(com.cmic.sso.sdk.a.b.a().b().g()));
        String b2 = j.a().b();
        String d2 = j.d();
        String a4 = j.a().a(false);
        aVar.a("imsi", b2);
        aVar.a("operatortype", a4);
        aVar.a("iccid", d2);
        aVar.a("logintype", i);
        com.cmic.sso.sdk.d.c.b(TAG, "iccid=" + d2);
        com.cmic.sso.sdk.d.c.b(TAG, "imsi=" + b2);
        if (TextUtils.isEmpty(b2)) {
            com.cmic.sso.sdk.d.c.a(TAG, "使用iccid作为缓存key");
            aVar.a("keyIsSimKeyICCID", true);
        }
        int a5 = n.a(this.mContext, a4);
        aVar.a("networktype", a5);
        synchronized (this.mObject) {
            a2 = h.a(aVar);
            if (a2) {
                aVar.a("securityphone", k.b("securityphone", ""));
                if (3 != i && a5 != 0) {
                    String a6 = h.a(this.mContext);
                    if (TextUtils.isEmpty(a6)) {
                        a2 = false;
                    } else {
                        aVar.a("sourceid", k.b("sourceid", ""));
                        aVar.a("phonescrip", a6);
                    }
                    h.a(true, false);
                }
            }
            aVar.a("isCacheScrip", a2);
            StringBuilder sb = new StringBuilder();
            sb.append("isCachePhoneScrip = ");
            sb.append(a2);
            com.cmic.sso.sdk.d.c.b(TAG, sb.toString());
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
                aVar.a("authtype", String.valueOf(0));
                callBackResult("200010", "无法识别sim卡或没有sim卡", aVar, null);
                return false;
            } else if (a5 == 2 && !a2) {
                callBackResult("102103", "无数据网络", aVar, null);
                return false;
            } else if ("2".equals(a4) && q.i()) {
                callBackResult("200082", "服务器繁忙，请稍后重试", aVar, null);
                return false;
            } else if ("3".equals(a4) && q.j()) {
                callBackResult("200082", "服务器繁忙，请稍后重试", aVar, null);
                return false;
            } else {
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void generateAID() {
        String str = "%" + s.a();
        com.cmic.sso.sdk.d.c.b(TAG, "generate aid = " + str);
        k.a a2 = k.a();
        a2.a("AID", str);
        a2.b();
    }

    private com.cmic.sso.sdk.a getBundle(TokenListener tokenListener) {
        com.cmic.sso.sdk.a aVar = new com.cmic.sso.sdk.a(64);
        String b2 = s.b();
        aVar.a("traceId", b2);
        if (tokenListener != null) {
            e.a(b2, tokenListener);
        }
        return aVar;
    }

    public static AuthnHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (AuthnHelper.class) {
                if (mInstance == null) {
                    mInstance = new AuthnHelper(context);
                }
            }
        }
        return mInstance;
    }

    private void sendLog(Context context, String str, com.cmic.sso.sdk.a aVar) {
        if (q.k()) {
            return;
        }
        new com.cmic.sso.sdk.c.b().a(context, str, aVar);
    }

    public static void setDebugMode(boolean z) {
        com.cmic.sso.sdk.d.c.a(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startGetPrePhonescript(com.cmic.sso.sdk.a aVar) {
        final a aVar2 = new a(aVar);
        this.mHandler.postDelayed(aVar2, this.overTime);
        this.authnBusiness.a(aVar, new b() { // from class: com.cmic.sso.sdk.auth.AuthnHelper.5
            @Override // com.cmic.sso.sdk.auth.b
            public void a(String str, String str2, com.cmic.sso.sdk.a aVar3, JSONObject jSONObject) {
                AuthnHelper.this.mHandler.removeCallbacks(aVar2);
                AuthnHelper.this.callBackResult(str, str2, aVar3, jSONObject);
            }
        });
    }

    public void callBackResult(String str, String str2, final com.cmic.sso.sdk.a aVar, JSONObject jSONObject) {
        final JSONObject a2;
        try {
            String b2 = aVar.b("traceId");
            if (!e.a(b2)) {
                synchronized (this) {
                    final TokenListener c2 = e.c(b2);
                    e.b(b2);
                    if (c2 == null) {
                        return;
                    }
                    aVar.a("systemEndTime", SystemClock.elapsedRealtime());
                    aVar.a("endtime", p.a());
                    int b3 = aVar.b("logintype", -1);
                    if (jSONObject == null) {
                        jSONObject = c.a(str, str2);
                    }
                    if (b3 == 3) {
                        a2 = c.a(str, aVar, jSONObject);
                    } else {
                        a2 = c.a(str, str2, aVar, jSONObject);
                    }
                    this.mHandler.post(new Runnable() { // from class: com.cmic.sso.sdk.auth.AuthnHelper.6
                        @Override // java.lang.Runnable
                        public void run() {
                            c2.onGetTokenComplete(a2);
                        }
                    });
                    sendLog(this.mContext, str, aVar);
                    if (aVar.b("isNeedToGetCert", false) || q.a()) {
                        o.a(new o.a() { // from class: com.cmic.sso.sdk.auth.AuthnHelper.7
                            @Override // com.cmic.sso.sdk.d.o.a
                            public void a() {
                                q.a(aVar);
                            }
                        });
                    }
                }
            }
            if (e.a()) {
                t.a(this.mContext).b();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void delScrip() {
        try {
            h.a(true, true);
            com.cmic.sso.sdk.d.c.b(TAG, "删除scrip");
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
            com.cmic.sso.sdk.d.c.b(TAG, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("运营商类型: ");
            sb3.append(a2);
            com.cmic.sso.sdk.d.c.b(TAG, sb3.toString());
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
        final com.cmic.sso.sdk.a bundle = getBundle(tokenListener);
        o.a(new o.a(this.mContext, bundle) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.4
            @Override // com.cmic.sso.sdk.d.o.a
            public void a() {
                if (AuthnHelper.this.commonInit(bundle, str, str2, "preGetMobile", 3, tokenListener)) {
                    AuthnHelper.this.startGetPrePhonescript(bundle);
                }
            }
        });
    }

    public void loginAuth(final String str, final String str2, final TokenListener tokenListener) {
        final com.cmic.sso.sdk.a bundle = getBundle(tokenListener);
        o.a(new o.a(this.mContext, bundle) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.2
            @Override // com.cmic.sso.sdk.d.o.a
            public void a() {
                if (AuthnHelper.this.commonInit(bundle, str, str2, "loginAuth", 1, tokenListener)) {
                    AuthnHelper.this.startGetPrePhonescript(bundle);
                }
            }
        });
    }

    public void mobileAuth(final String str, final String str2, final TokenListener tokenListener) {
        final com.cmic.sso.sdk.a bundle = getBundle(tokenListener);
        o.a(new o.a(this.mContext, bundle) { // from class: com.cmic.sso.sdk.auth.AuthnHelper.3
            @Override // com.cmic.sso.sdk.d.o.a
            public void a() {
                if (AuthnHelper.this.commonInit(bundle, str, str2, "mobileAuth", 0, tokenListener)) {
                    AuthnHelper.this.startGetPrePhonescript(bundle);
                }
            }
        });
    }

    public void setOverTime(long j) {
        this.overTime = j;
    }

    public static AuthnHelper getInstance(Context context, String str) {
        if (mInstance == null) {
            synchronized (AuthnHelper.class) {
                if (mInstance == null) {
                    mInstance = new AuthnHelper(context, str);
                }
            }
        }
        return mInstance;
    }

    public AuthnHelper(Context context, String str) {
        this(context);
        this.use2048PublicKey = str;
    }
}
