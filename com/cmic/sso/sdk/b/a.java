package com.cmic.sso.sdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.cmic.sso.sdk.e.g;
import com.cmic.sso.sdk.e.h;
import com.cmic.sso.sdk.e.j;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.n;
import com.cmic.sso.sdk.e.o;
import com.cmic.sso.sdk.e.p;
import com.cmic.sso.sdk.e.q;
import com.cmic.sso.sdk.e.s;
import com.cmic.sso.sdk.e.t;
import com.sina.weibo.sdk.statistic.LogBuilder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    @SuppressLint({"StaticFieldLeak"})
    private static a nst = null;
    private Context mContext;
    private Handler mHandler;
    private final Object mObject;
    private c nss;
    private long nsu;
    private String nsv;

    private a(Context context) {
        this.nsu = 8000L;
        this.mObject = new Object();
        this.mContext = context.getApplicationContext();
        this.mHandler = new Handler(this.mContext.getMainLooper());
        this.nss = c.gt(this.mContext);
        t.gu(this.mContext);
        k.a(this.mContext);
        j.a(this.mContext);
        o.a(new o.a() { // from class: com.cmic.sso.sdk.b.a.1
            @Override // com.cmic.sso.sdk.e.o.a
            protected void a() {
                String b = k.b("AID", "");
                com.cmic.sso.sdk.e.c.b("AuthnHelper", "aid = " + b);
                if (TextUtils.isEmpty(b)) {
                    a.this.dRo();
                }
                if (com.cmic.sso.sdk.e.b.a(a.this.mContext, true)) {
                    com.cmic.sso.sdk.e.c.b("AuthnHelper", "生成androidkeystore成功");
                } else {
                    com.cmic.sso.sdk.e.c.b("AuthnHelper", "生成androidkeystore失败");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRo() {
        String str = "%" + s.a();
        com.cmic.sso.sdk.e.c.b("AuthnHelper", "generate aid = " + str);
        k.a dRw = k.dRw();
        dRw.a("AID", str);
        dRw.b();
    }

    private a(Context context, String str) {
        this(context);
        this.nsv = str;
    }

    public static a gr(Context context) {
        if (nst == null) {
            synchronized (a.class) {
                if (nst == null) {
                    nst = new a(context);
                }
            }
        }
        return nst;
    }

    public static a bl(Context context, String str) {
        if (nst == null) {
            synchronized (a.class) {
                if (nst == null) {
                    nst = new a(context, str);
                }
            }
        }
        return nst;
    }

    public void a(final String str, final String str2, final b bVar) {
        final com.cmic.sso.sdk.a a = a(bVar);
        o.a(new o.a(this.mContext, a) { // from class: com.cmic.sso.sdk.b.a.2
            @Override // com.cmic.sso.sdk.e.o.a
            protected void a() {
                if (a.this.a(a, str, str2, "loginAuth", 1, bVar)) {
                    a.this.a(a);
                }
            }
        });
    }

    public void b(final String str, final String str2, final b bVar) {
        final com.cmic.sso.sdk.a a = a(bVar);
        o.a(new o.a(this.mContext, a) { // from class: com.cmic.sso.sdk.b.a.3
            @Override // com.cmic.sso.sdk.e.o.a
            protected void a() {
                if (a.this.a(a, str, str2, "mobileAuth", 0, bVar)) {
                    a.this.a(a);
                }
            }
        });
    }

    public void c(final String str, final String str2, final b bVar) {
        final com.cmic.sso.sdk.a a = a(bVar);
        o.a(new o.a(this.mContext, a) { // from class: com.cmic.sso.sdk.b.a.4
            @Override // com.cmic.sso.sdk.e.o.a
            protected void a() {
                if (a.this.a(a, str, str2, "preGetMobile", 3, bVar)) {
                    a.this.a(a);
                }
            }
        });
    }

    private com.cmic.sso.sdk.a a(b bVar) {
        com.cmic.sso.sdk.a aVar = new com.cmic.sso.sdk.a(64);
        String b = s.b();
        aVar.a("traceId", b);
        if (bVar != null) {
            com.cmic.sso.sdk.e.e.a(b, bVar);
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.cmic.sso.sdk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0854a implements Runnable {
        private com.cmic.sso.sdk.a nsE;

        RunnableC0854a(com.cmic.sso.sdk.a aVar) {
            this.nsE = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject a;
            if (!t.gu(a.this.mContext).a() && this.nsE.b("doNetworkSwitch", false)) {
                a = e.a("102508", "数据网络切换失败");
            } else {
                a = e.a("200023", "登录超时");
            }
            a.this.a(a.optString("resultCode", "200023"), a.optString("resultString", "登录超时"), this.nsE, a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.cmic.sso.sdk.a aVar) {
        final RunnableC0854a runnableC0854a = new RunnableC0854a(aVar);
        this.mHandler.postDelayed(runnableC0854a, this.nsu);
        this.nss.a(aVar, new d() { // from class: com.cmic.sso.sdk.b.a.5
            @Override // com.cmic.sso.sdk.b.d
            public void b(String str, String str2, com.cmic.sso.sdk.a aVar2, JSONObject jSONObject) {
                a.this.mHandler.removeCallbacks(runnableC0854a);
                a.this.a(str, str2, aVar2, jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.cmic.sso.sdk.a aVar, String str, String str2, String str3, int i, b bVar) {
        boolean z;
        aVar.a("CLOSE_CERT_VERIFY", q.h());
        aVar.a("use2048PublicKey", "rsa2048".equals(this.nsv));
        aVar.a("systemStartTime", SystemClock.elapsedRealtime());
        aVar.a(LogBuilder.KEY_START_TIME, p.a());
        aVar.a("loginMethod", str3);
        aVar.a("appkey", str2);
        aVar.a("appid", str);
        aVar.a("timeOut", String.valueOf(this.nsu));
        boolean z2 = false;
        if (g.a(this.mContext, "android.permission.READ_PHONE_STATE")) {
            z2 = true;
        }
        com.cmic.sso.sdk.e.c.a("AuthnHelper", "有READ_PHONE_STATE权限？" + z2);
        aVar.a("hsaReadPhoneStatePermission", z2);
        com.cmic.sso.sdk.a.b.dRm().a(this.mContext, z2);
        aVar.a("networkClass", com.cmic.sso.sdk.a.b.dRm().a(this.mContext));
        aVar.a("simCardNum", String.valueOf(com.cmic.sso.sdk.a.b.dRm().dRn().i()));
        String b = j.dRv().b();
        String xX = j.dRv().xX(z2);
        String e = j.e();
        String a = j.dRv().a(false);
        aVar.a("imsi", b);
        aVar.a("imei", xX);
        aVar.a("operatortype", a);
        aVar.a("iccid", e);
        aVar.a("logintype", i);
        com.cmic.sso.sdk.e.c.b("AuthnHelper", "iccid=" + e);
        com.cmic.sso.sdk.e.c.b("AuthnHelper", "imsi=" + b);
        if (TextUtils.isEmpty(b)) {
            com.cmic.sso.sdk.e.c.a("AuthnHelper", "使用iccid作为缓存key");
            aVar.a("keyIsSimKeyICCID", true);
        }
        int a2 = n.a(this.mContext, a);
        aVar.a("networktype", a2);
        synchronized (this.mObject) {
            boolean c = h.c(aVar);
            if (c) {
                aVar.a("securityphone", k.b("securityphone", ""));
                if (3 != i && a2 != 0) {
                    String a3 = h.a(this.mContext);
                    if (!TextUtils.isEmpty(a3)) {
                        aVar.a(UgcConstant.SOURCE_ID, k.b(UgcConstant.SOURCE_ID, ""));
                        aVar.a("phonescrip", a3);
                    } else {
                        c = false;
                    }
                    h.a(true, false);
                    z = c;
                    aVar.a("isCacheScrip", z);
                    com.cmic.sso.sdk.e.c.b("AuthnHelper", "isCachePhoneScrip = " + z);
                }
            }
            z = c;
            aVar.a("isCacheScrip", z);
            com.cmic.sso.sdk.e.c.b("AuthnHelper", "isCachePhoneScrip = " + z);
        }
        if (bVar == null) {
            a("102203", "listener不能为空", aVar, null);
            return false;
        } else if (q.d()) {
            a("200082", "服务器繁忙，请稍后重试", aVar, null);
            return false;
        } else {
            if (TextUtils.isEmpty(str == null ? "" : str.trim())) {
                a("102203", "appId 不能为空", aVar, null);
                return false;
            }
            if (TextUtils.isEmpty(str2 == null ? "" : str2.trim())) {
                a("102203", "appkey不能为空", aVar, null);
                return false;
            } else if (a2 == 0) {
                a("102101", "未检测到网络", aVar, null);
                return false;
            } else if (TextUtils.isEmpty(a)) {
                aVar.a("authtype", String.valueOf(0));
                a("200010", "无法识别sim卡或没有sim卡", aVar, null);
                return false;
            } else if (a2 == 2 && !z) {
                a("102103", "无数据网络", aVar, null);
                return false;
            } else if ("2".equals(a) && q.i()) {
                a("200082", "服务器繁忙，请稍后重试", aVar, null);
                return false;
            } else if ("3".equals(a) && q.j()) {
                a("200082", "服务器繁忙，请稍后重试", aVar, null);
                return false;
            } else {
                return true;
            }
        }
    }

    public void a(String str, String str2, final com.cmic.sso.sdk.a aVar, JSONObject jSONObject) {
        final JSONObject c;
        try {
            String b = aVar.b("traceId");
            if (!com.cmic.sso.sdk.e.e.a(b)) {
                synchronized (this) {
                    final b UJ = com.cmic.sso.sdk.e.e.UJ(b);
                    com.cmic.sso.sdk.e.e.b(b);
                    if (UJ != null) {
                        aVar.a("systemEndTime", SystemClock.elapsedRealtime());
                        aVar.a(LogBuilder.KEY_END_TIME, p.a());
                        int b2 = aVar.b("logintype", -1);
                        if (jSONObject == null) {
                            jSONObject = e.a(str, str2);
                        }
                        if (b2 == 3) {
                            c = e.a(str, aVar, jSONObject);
                        } else {
                            c = e.c(str, str2, aVar, jSONObject);
                        }
                        this.mHandler.post(new Runnable() { // from class: com.cmic.sso.sdk.b.a.6
                            @Override // java.lang.Runnable
                            public void run() {
                                UJ.onGetTokenComplete(c);
                            }
                        });
                        a(this.mContext, str, aVar);
                        if (aVar.b("isNeedToGetCert", false) || q.a()) {
                            o.a(new o.a() { // from class: com.cmic.sso.sdk.b.a.7
                                @Override // com.cmic.sso.sdk.e.o.a
                                protected void a() {
                                    q.b(aVar);
                                }
                            });
                        }
                    } else {
                        return;
                    }
                }
            }
            if (com.cmic.sso.sdk.e.e.a()) {
                t.gu(this.mContext).b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(Context context, String str, com.cmic.sso.sdk.a aVar) {
        if (!q.k()) {
            new com.cmic.sso.sdk.d.b().b(context, str, aVar);
        }
    }

    public void gw(long j) {
        this.nsu = j;
    }

    public JSONObject gs(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            com.cmic.sso.sdk.a.b.dRm().a(context, g.a(context, "android.permission.READ_PHONE_STATE"));
            String a = j.dRv().a(true);
            int a2 = n.a(context, a);
            jSONObject.put("operatortype", a);
            jSONObject.put("networktype", a2 + "");
            com.cmic.sso.sdk.e.c.b("AuthnHelper", "网络类型: " + a2);
            com.cmic.sso.sdk.e.c.b("AuthnHelper", "运营商类型: " + a);
        } catch (Exception e) {
            try {
                jSONObject.put("errorDes", "发生未知错误");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }
}
