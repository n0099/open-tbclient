package com.cmic.sso.sdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
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
    private static a pqA = null;
    private Context mContext;
    private Handler mHandler;
    private final Object mObject;
    private long pqB;
    private String pqC;
    private c pqz;

    private a(Context context) {
        this.pqB = 8000L;
        this.mObject = new Object();
        this.mContext = context.getApplicationContext();
        this.mHandler = new Handler(this.mContext.getMainLooper());
        this.pqz = c.ie(this.mContext);
        t.m59if(this.mContext);
        k.a(this.mContext);
        j.a(this.mContext);
        o.a(new o.a() { // from class: com.cmic.sso.sdk.b.a.1
            @Override // com.cmic.sso.sdk.e.o.a
            protected void a() {
                String b2 = k.b("AID", "");
                com.cmic.sso.sdk.e.c.b("AuthnHelper", "aid = " + b2);
                if (TextUtils.isEmpty(b2)) {
                    a.this.esO();
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
    public void esO() {
        String str = "%" + s.a();
        com.cmic.sso.sdk.e.c.b("AuthnHelper", "generate aid = " + str);
        k.a esW = k.esW();
        esW.a("AID", str);
        esW.b();
    }

    private a(Context context, String str) {
        this(context);
        this.pqC = str;
    }

    public static a ic(Context context) {
        if (pqA == null) {
            synchronized (a.class) {
                if (pqA == null) {
                    pqA = new a(context);
                }
            }
        }
        return pqA;
    }

    public static a by(Context context, String str) {
        if (pqA == null) {
            synchronized (a.class) {
                if (pqA == null) {
                    pqA = new a(context, str);
                }
            }
        }
        return pqA;
    }

    public void a(final String str, final String str2, final b bVar) {
        final com.cmic.sso.sdk.a a2 = a(bVar);
        o.a(new o.a(this.mContext, a2) { // from class: com.cmic.sso.sdk.b.a.2
            @Override // com.cmic.sso.sdk.e.o.a
            protected void a() {
                if (a.this.a(a2, str, str2, "loginAuth", 1, bVar)) {
                    a.this.a(a2);
                }
            }
        });
    }

    public void b(final String str, final String str2, final b bVar) {
        final com.cmic.sso.sdk.a a2 = a(bVar);
        o.a(new o.a(this.mContext, a2) { // from class: com.cmic.sso.sdk.b.a.3
            @Override // com.cmic.sso.sdk.e.o.a
            protected void a() {
                if (a.this.a(a2, str, str2, "mobileAuth", 0, bVar)) {
                    a.this.a(a2);
                }
            }
        });
    }

    public void c(final String str, final String str2, final b bVar) {
        final com.cmic.sso.sdk.a a2 = a(bVar);
        o.a(new o.a(this.mContext, a2) { // from class: com.cmic.sso.sdk.b.a.4
            @Override // com.cmic.sso.sdk.e.o.a
            protected void a() {
                if (a.this.a(a2, str, str2, "preGetMobile", 3, bVar)) {
                    a.this.a(a2);
                }
            }
        });
    }

    private com.cmic.sso.sdk.a a(b bVar) {
        com.cmic.sso.sdk.a aVar = new com.cmic.sso.sdk.a(64);
        String b2 = s.b();
        aVar.a("traceId", b2);
        if (bVar != null) {
            com.cmic.sso.sdk.e.e.a(b2, bVar);
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.cmic.sso.sdk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1050a implements Runnable {
        private com.cmic.sso.sdk.a pqL;

        RunnableC1050a(com.cmic.sso.sdk.a aVar) {
            this.pqL = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject a2;
            if (!t.m59if(a.this.mContext).a() && this.pqL.b("doNetworkSwitch", false)) {
                a2 = e.a("102508", "数据网络切换失败");
            } else {
                a2 = e.a("200023", "登录超时");
            }
            a.this.a(a2.optString("resultCode", "200023"), a2.optString("resultString", "登录超时"), this.pqL, a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.cmic.sso.sdk.a aVar) {
        final RunnableC1050a runnableC1050a = new RunnableC1050a(aVar);
        this.mHandler.postDelayed(runnableC1050a, this.pqB);
        this.pqz.a(aVar, new d() { // from class: com.cmic.sso.sdk.b.a.5
            @Override // com.cmic.sso.sdk.b.d
            public void b(String str, String str2, com.cmic.sso.sdk.a aVar2, JSONObject jSONObject) {
                a.this.mHandler.removeCallbacks(runnableC1050a);
                a.this.a(str, str2, aVar2, jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.cmic.sso.sdk.a aVar, String str, String str2, String str3, int i, b bVar) {
        boolean z;
        aVar.a("CLOSE_CERT_VERIFY", q.h());
        aVar.a("use2048PublicKey", "rsa2048".equals(this.pqC));
        aVar.a("systemStartTime", SystemClock.elapsedRealtime());
        aVar.a(LogBuilder.KEY_START_TIME, p.a());
        aVar.a("loginMethod", str3);
        aVar.a("appkey", str2);
        aVar.a("appid", str);
        aVar.a("timeOut", String.valueOf(this.pqB));
        boolean z2 = false;
        if (g.a(this.mContext, "android.permission.READ_PHONE_STATE")) {
            z2 = true;
        }
        com.cmic.sso.sdk.e.c.a("AuthnHelper", "有READ_PHONE_STATE权限？" + z2);
        aVar.a("hsaReadPhoneStatePermission", z2);
        com.cmic.sso.sdk.a.b.esM().a(this.mContext, z2);
        aVar.a("networkClass", com.cmic.sso.sdk.a.b.esM().a(this.mContext));
        aVar.a("simCardNum", String.valueOf(com.cmic.sso.sdk.a.b.esM().esN().i()));
        String b2 = j.esV().b();
        String AQ = j.esV().AQ(z2);
        String e = j.e();
        String a2 = j.esV().a(false);
        aVar.a("imsi", b2);
        aVar.a("imei", AQ);
        aVar.a("operatortype", a2);
        aVar.a("iccid", e);
        aVar.a("logintype", i);
        com.cmic.sso.sdk.e.c.b("AuthnHelper", "iccid=" + e);
        com.cmic.sso.sdk.e.c.b("AuthnHelper", "imsi=" + b2);
        if (TextUtils.isEmpty(b2)) {
            com.cmic.sso.sdk.e.c.a("AuthnHelper", "使用iccid作为缓存key");
            aVar.a("keyIsSimKeyICCID", true);
        }
        int a3 = n.a(this.mContext, a2);
        aVar.a("networktype", a3);
        synchronized (this.mObject) {
            boolean c = h.c(aVar);
            if (c) {
                aVar.a("securityphone", k.b("securityphone", ""));
                if (3 != i && a3 != 0) {
                    String a4 = h.a(this.mContext);
                    if (!TextUtils.isEmpty(a4)) {
                        aVar.a("sourceid", k.b("sourceid", ""));
                        aVar.a("phonescrip", a4);
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
            } else if (a3 == 0) {
                a("102101", "未检测到网络", aVar, null);
                return false;
            } else if (TextUtils.isEmpty(a2)) {
                aVar.a("authtype", String.valueOf(0));
                a("200010", "无法识别sim卡或没有sim卡", aVar, null);
                return false;
            } else if (a3 == 2 && !z) {
                a("102103", "无数据网络", aVar, null);
                return false;
            } else if ("2".equals(a2) && q.i()) {
                a("200082", "服务器繁忙，请稍后重试", aVar, null);
                return false;
            } else if ("3".equals(a2) && q.j()) {
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
            String b2 = aVar.b("traceId");
            if (!com.cmic.sso.sdk.e.e.a(b2)) {
                synchronized (this) {
                    final b Ze = com.cmic.sso.sdk.e.e.Ze(b2);
                    com.cmic.sso.sdk.e.e.b(b2);
                    if (Ze != null) {
                        aVar.a("systemEndTime", SystemClock.elapsedRealtime());
                        aVar.a(LogBuilder.KEY_END_TIME, p.a());
                        int b3 = aVar.b("logintype", -1);
                        if (jSONObject == null) {
                            jSONObject = e.a(str, str2);
                        }
                        if (b3 == 3) {
                            c = e.a(str, aVar, jSONObject);
                        } else {
                            c = e.c(str, str2, aVar, jSONObject);
                        }
                        this.mHandler.post(new Runnable() { // from class: com.cmic.sso.sdk.b.a.6
                            @Override // java.lang.Runnable
                            public void run() {
                                Ze.onGetTokenComplete(c);
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
                t.m59if(this.mContext).b();
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

    public void iw(long j) {
        this.pqB = j;
    }

    public JSONObject id(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            com.cmic.sso.sdk.a.b.esM().a(context, g.a(context, "android.permission.READ_PHONE_STATE"));
            String a2 = j.esV().a(true);
            int a3 = n.a(context, a2);
            jSONObject.put("operatortype", a2);
            jSONObject.put("networktype", a3 + "");
            com.cmic.sso.sdk.e.c.b("AuthnHelper", "网络类型: " + a3);
            com.cmic.sso.sdk.e.c.b("AuthnHelper", "运营商类型: " + a2);
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
