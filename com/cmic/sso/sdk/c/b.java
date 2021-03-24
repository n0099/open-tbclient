package com.cmic.sso.sdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.b.c.d;
import com.cmic.sso.sdk.d.c;
import com.cmic.sso.sdk.d.f;
import com.cmic.sso.sdk.d.h;
import com.cmic.sso.sdk.d.j;
import com.cmic.sso.sdk.d.k;
import com.cmic.sso.sdk.d.n;
import com.cmic.sso.sdk.d.o;
import com.cmic.sso.sdk.d.q;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public com.cmic.sso.sdk.a f30677a;

    public static void a(a aVar, com.cmic.sso.sdk.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return;
        }
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
        aVar.y(AuthnHelper.SDK_VERSION);
        aVar.z(String.valueOf(aVar2.b("networktype", 0)));
        aVar.u(aVar2.b("starttime"));
        aVar.w(aVar2.b("endtime"));
        aVar.m(String.valueOf(aVar2.b("systemEndTime", 0L) - aVar2.b("systemStartTime", 0L)));
        aVar.c(aVar2.b("imsiState"));
        aVar.A(k.b("AID", ""));
        aVar.B(j.a().e());
        c.a("SendLog", "traceId" + aVar2.b("traceId"));
    }

    public void a(Context context, String str, com.cmic.sso.sdk.a aVar) {
        StackTraceElement[] stackTrace;
        String str2 = "";
        try {
            a aVar2 = new a();
            String b2 = f.b(context);
            aVar2.d(str);
            aVar2.x(aVar.b("loginMethod", ""));
            if (aVar.b("isCacheScrip", false)) {
                aVar2.s("scrip");
            } else {
                aVar2.s("pgw");
            }
            aVar2.j(f.a(context));
            if (!TextUtils.isEmpty(b2)) {
                str2 = b2;
            }
            aVar2.k(str2);
            aVar2.b(aVar.b("hsaReadPhoneStatePermission", false) ? "1" : "0");
            a(aVar2, aVar);
            JSONArray jSONArray = null;
            if (a.f30669a.size() > 0) {
                jSONArray = new JSONArray();
                Iterator<Throwable> it = a.f30669a.iterator();
                while (it.hasNext()) {
                    Throwable next = it.next();
                    StringBuffer stringBuffer = new StringBuffer();
                    JSONObject jSONObject = new JSONObject();
                    for (StackTraceElement stackTraceElement : next.getStackTrace()) {
                        stringBuffer.append("\n");
                        stringBuffer.append(stackTraceElement.toString());
                    }
                    jSONObject.put("message", next.toString());
                    jSONObject.put("stack", stringBuffer.toString());
                    jSONArray.put(jSONObject);
                }
                a.f30669a.clear();
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                aVar2.a(jSONArray);
            }
            c.a("SendLog", "登录日志");
            a(aVar2.b(), aVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(final JSONObject jSONObject, com.cmic.sso.sdk.a aVar) {
        this.f30677a = aVar;
        o.a(new o.a() { // from class: com.cmic.sso.sdk.c.b.1
            @Override // com.cmic.sso.sdk.d.o.a
            public void a() {
                b.this.a(jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        if (q.m() == 0 || q.l() == 0 || System.currentTimeMillis() > k.a("logCloseTime", 0L) + q.m()) {
            com.cmic.sso.sdk.b.c.a.a().a(jSONObject, this.f30677a, new d() { // from class: com.cmic.sso.sdk.c.b.2
                @Override // com.cmic.sso.sdk.b.c.d
                public void a(String str, String str2, JSONObject jSONObject2) {
                    if (!str.equals("103000")) {
                        if (q.m() != 0 && q.l() != 0) {
                            int a2 = k.a("logFailTimes", 0) + 1;
                            k.a a3 = k.a();
                            if (a2 >= q.l()) {
                                a3.a("logFailTimes", 0);
                                a3.a("logCloseTime", System.currentTimeMillis());
                            } else {
                                a3.a("logFailTimes", a2);
                            }
                            a3.b();
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
