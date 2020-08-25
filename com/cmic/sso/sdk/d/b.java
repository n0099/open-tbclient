package com.cmic.sso.sdk.d;

import android.content.Context;
import android.text.TextUtils;
import com.cmic.sso.sdk.c.c.d;
import com.cmic.sso.sdk.e.c;
import com.cmic.sso.sdk.e.f;
import com.cmic.sso.sdk.e.h;
import com.cmic.sso.sdk.e.j;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.n;
import com.cmic.sso.sdk.e.o;
import com.cmic.sso.sdk.e.q;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private com.cmic.sso.sdk.a nif;

    private static void a(a aVar, com.cmic.sso.sdk.a aVar2) {
        if (aVar != null && aVar2 != null) {
            aVar.a(aVar2.b("appid", ""));
            aVar.e(h.a() ? "1" : "0");
            aVar.f(n.a());
            aVar.i(aVar2.b("interfaceType", ""));
            aVar.h(aVar2.b("interfaceCode", ""));
            aVar.g(aVar2.b("interfaceElasped", ""));
            aVar.l(aVar2.b("timeOut"));
            aVar.t(aVar2.b("traceId"));
            aVar.v(aVar2.b("networkClass"));
            aVar.o(aVar2.b("simCardNum"));
            aVar.p(aVar2.b("operatortype"));
            aVar.q(n.b());
            aVar.r(n.c());
            aVar.y("quick_login_android_9.2.0.2");
            aVar.z(String.valueOf(aVar2.b("networktype", 0)));
            aVar.u(aVar2.b(LogBuilder.KEY_START_TIME));
            aVar.w(aVar2.b(LogBuilder.KEY_END_TIME));
            aVar.m(String.valueOf(aVar2.b("systemEndTime", 0L) - aVar2.b("systemStartTime", 0L)));
            aVar.c(aVar2.b("imsiState"));
            aVar.A(k.b("AID", ""));
            aVar.TP(j.dNo().f());
            c.a("SendLog", "traceId" + aVar2.b("traceId"));
        }
    }

    public void b(Context context, String str, com.cmic.sso.sdk.a aVar) {
        try {
            a aVar2 = new a();
            String b = f.b(context);
            aVar2.d(str);
            aVar2.x(aVar.b("loginMethod", ""));
            if (aVar.b("isCacheScrip", false)) {
                aVar2.s("scrip");
            } else {
                aVar2.s("pgw");
            }
            aVar2.j(f.a(context));
            if (TextUtils.isEmpty(b)) {
                b = "";
            }
            aVar2.k(b);
            aVar2.b(aVar.b("hsaReadPhoneStatePermission", false) ? "1" : "0");
            a(aVar2, aVar);
            JSONArray jSONArray = null;
            if (a.niN.size() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<Throwable> it = a.niN.iterator();
                while (it.hasNext()) {
                    Throwable next = it.next();
                    StringBuffer stringBuffer = new StringBuffer();
                    JSONObject jSONObject = new JSONObject();
                    for (StackTraceElement stackTraceElement : next.getStackTrace()) {
                        stringBuffer.append("\n").append(stackTraceElement.toString());
                    }
                    jSONObject.put("message", next.toString());
                    jSONObject.put("stack", stringBuffer.toString());
                    jSONArray2.put(jSONObject);
                }
                a.niN.clear();
                jSONArray = jSONArray2;
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                aVar2.a(jSONArray);
            }
            c.a("SendLog", "登录日志");
            a(aVar2.b(), aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(final JSONObject jSONObject, com.cmic.sso.sdk.a aVar) {
        this.nif = aVar;
        o.a(new o.a() { // from class: com.cmic.sso.sdk.d.b.1
            @Override // com.cmic.sso.sdk.e.o.a
            protected void a() {
                b.this.a(jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        if (q.m() == 0 || q.l() == 0 || System.currentTimeMillis() > k.L("logCloseTime", 0L) + q.m()) {
            com.cmic.sso.sdk.c.c.a.dNj().a(jSONObject, this.nif, new d() { // from class: com.cmic.sso.sdk.d.b.2
                @Override // com.cmic.sso.sdk.c.c.d
                public void j(String str, String str2, JSONObject jSONObject2) {
                    if (!str.equals("103000")) {
                        if (q.m() != 0 && q.l() != 0) {
                            int a = k.a("logFailTimes", 0) + 1;
                            k.a dNp = k.dNp();
                            if (a >= q.l()) {
                                dNp.a("logFailTimes", 0);
                                dNp.a("logCloseTime", System.currentTimeMillis());
                            } else {
                                dNp.a("logFailTimes", a);
                            }
                            dNp.b();
                        }
                        c.a("SendLog", "request failed , url : " + q.g() + ">>>>>errorMsg : " + jSONObject2.toString());
                        return;
                    }
                    c.b("SendLog", "request success , url : " + q.g() + ">>>>result : " + jSONObject2.toString());
                }
            });
        }
    }
}
