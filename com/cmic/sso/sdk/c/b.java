package com.cmic.sso.sdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.cmic.sso.sdk.b.c.d;
import com.cmic.sso.sdk.d.c;
import com.cmic.sso.sdk.d.f;
import com.cmic.sso.sdk.d.h;
import com.cmic.sso.sdk.d.j;
import com.cmic.sso.sdk.d.k;
import com.cmic.sso.sdk.d.n;
import com.cmic.sso.sdk.d.q;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public com.cmic.sso.sdk.a f30656a;

    public static void a(a aVar, com.cmic.sso.sdk.a aVar2) {
        if (aVar == null || aVar2 == null) {
            return;
        }
        aVar.b(aVar2.b("appid", ""));
        aVar.f(h.a() ? "1" : "0");
        aVar.g(n.a());
        aVar.j(aVar2.b("interfaceType", ""));
        aVar.i(aVar2.b("interfaceCode", ""));
        aVar.h(aVar2.b("interfaceElasped", ""));
        aVar.m(aVar2.b("timeOut"));
        aVar.t(aVar2.b("traceId"));
        aVar.v(aVar2.b("networkClass"));
        aVar.o(aVar2.b("simCardNum"));
        aVar.p(aVar2.b("operatortype"));
        aVar.q(n.b());
        aVar.r(n.c());
        aVar.z(String.valueOf(aVar2.b("networktype", 0)));
        aVar.u(aVar2.b("starttime"));
        aVar.x(aVar2.b("endtime"));
        aVar.n(String.valueOf(aVar2.b("systemEndTime", 0L) - aVar2.b("systemStartTime", 0L)));
        aVar.d(aVar2.b("imsiState"));
        aVar.A(k.b("AID", ""));
        aVar.B(j.a().f());
        aVar.C(aVar2.b("scripType"));
        aVar.D(aVar2.b("eipKey"));
        c.a("SendLog", "traceId" + aVar2.b("traceId"));
    }

    public void a(Context context, String str, com.cmic.sso.sdk.a aVar) {
        StackTraceElement[] stackTrace;
        String str2 = "";
        try {
            a a2 = aVar.a();
            String b2 = f.b(context);
            a2.e(str);
            a2.y(aVar.b("loginMethod", ""));
            if (aVar.b("isCacheScrip", false)) {
                a2.s("scrip");
            } else {
                a2.s("pgw");
            }
            a2.k(f.a(context));
            if (!TextUtils.isEmpty(b2)) {
                str2 = b2;
            }
            a2.l(str2);
            a2.c(aVar.b("hsaReadPhoneStatePermission", false) ? "1" : "0");
            a(a2, aVar);
            JSONArray jSONArray = null;
            if (a2.f30647a.size() > 0) {
                jSONArray = new JSONArray();
                Iterator<Throwable> it = a2.f30647a.iterator();
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
                a2.f30647a.clear();
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                a2.a(jSONArray);
            }
            c.a("SendLog", "登录日志");
            a(a2.b(), aVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(JSONObject jSONObject, com.cmic.sso.sdk.a aVar) {
        this.f30656a = aVar;
        a(jSONObject);
    }

    private void a(JSONObject jSONObject) {
        if (q.o() == 0 || q.n() == 0 || System.currentTimeMillis() > k.a("logCloseTime", 0L) + q.o()) {
            com.cmic.sso.sdk.b.c.a.a().a(jSONObject, this.f30656a, new d() { // from class: com.cmic.sso.sdk.c.b.1
                @Override // com.cmic.sso.sdk.b.c.d
                public void a(String str, String str2, JSONObject jSONObject2) {
                    if (!str.equals("103000")) {
                        if (q.o() != 0 && q.n() != 0) {
                            int a2 = k.a("logFailTimes", 0) + 1;
                            k.a a3 = k.a();
                            if (a2 >= q.n()) {
                                a3.a("logFailTimes", 0);
                                a3.a("logCloseTime", System.currentTimeMillis());
                            } else {
                                a3.a("logFailTimes", a2);
                            }
                            a3.b();
                        }
                        c.a("SendLog", "request failed , url : " + q.i() + ">>>>>errorMsg : " + jSONObject2.toString());
                        return;
                    }
                    c.b("SendLog", "request success , url : " + q.i() + ">>>>result : " + jSONObject2.toString());
                }
            });
        }
    }
}
