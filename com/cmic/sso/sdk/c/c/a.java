package com.cmic.sso.sdk.c.c;

import android.os.SystemClock;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.cmic.sso.sdk.b;
import com.cmic.sso.sdk.c.b.a;
import com.cmic.sso.sdk.c.b.e;
import com.cmic.sso.sdk.c.b.f;
import com.cmic.sso.sdk.e.i;
import com.cmic.sso.sdk.e.j;
import com.cmic.sso.sdk.e.k;
import com.cmic.sso.sdk.e.m;
import com.cmic.sso.sdk.e.n;
import com.cmic.sso.sdk.e.p;
import com.cmic.sso.sdk.e.q;
import com.cmic.sso.sdk.e.r;
import com.cmic.sso.sdk.e.s;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static a oZv = null;

    private a() {
    }

    public static a eoC() {
        if (oZv == null) {
            synchronized (a.class) {
                if (oZv == null) {
                    oZv = new a();
                }
            }
        }
        return oZv;
    }

    public void a(boolean z, com.cmic.sso.sdk.a aVar, d dVar) {
        com.cmic.sso.sdk.c.b.b bVar = new com.cmic.sso.sdk.c.b.b();
        bVar.a("1.0");
        bVar.b("Android");
        bVar.c(k.b("AID", ""));
        bVar.d(z ? "1" : "0");
        bVar.e("quick_login_android_9.2.0.2");
        bVar.f(aVar.b("appid"));
        bVar.g(bVar.c());
        a(new c("https://config.cmpassport.com/client/uniConfig", bVar, "POST", aVar.b("traceId")), dVar, aVar);
    }

    public void a(com.cmic.sso.sdk.a aVar, d dVar) {
        String a2;
        int c = aVar.c("networktype");
        String b = aVar.b("authtype", "");
        e eVar = new e();
        e.a aVar2 = new e.a();
        aVar2.e("1.0");
        aVar2.f("quick_login_android_9.2.0.2");
        aVar2.g(aVar.b("appid"));
        aVar2.h(b);
        aVar2.i(aVar.b("smskey", ""));
        aVar2.j(aVar.b("imsi"));
        aVar2.k(aVar.b("imei"));
        aVar2.c(j.eoH().c());
        aVar2.d(j.eoH().d());
        aVar2.l(aVar.b("operatortype"));
        aVar2.m(c + "");
        aVar2.n(n.a());
        aVar2.o(n.b());
        aVar2.p(n.c());
        aVar2.q("0");
        aVar2.r(s.a());
        aVar2.a(SystemClock.elapsedRealtime());
        aVar2.s(p.a());
        aVar2.t(aVar.b("apppackage"));
        aVar2.u(aVar.b("appsign"));
        eVar.a(aVar.a(b.a.f4008a));
        if (aVar.b("use2048PublicKey", false)) {
            com.cmic.sso.sdk.e.c.a("BaseRequest", "使用2对应的编码");
            eVar.a("2");
            a2 = i.eoG().b(aVar.a(b.a.f4008a));
        } else {
            a2 = i.eoG().a(aVar.a(b.a.f4008a));
        }
        eVar.b(a2);
        eVar.a(aVar2);
        aVar.a("interfaceVersion", "6.0");
        aVar.a("interfaceType", "getPrePhonescrip");
        aVar.a("isCloseIpv4", q.b());
        aVar.a("isCloseIpv6", q.c());
        b bVar = new b(q.e() + "/rs/getPrePhonescrip", eVar, "POST", aVar.b("traceId"));
        bVar.a("defendEOF", "1");
        bVar.a("appid", aVar.b("appid", ""));
        if (c == 3 && b.equals("3")) {
            bVar.a(true);
            aVar.a("doNetworkSwitch", true);
        } else {
            bVar.a(false);
            aVar.a("doNetworkSwitch", false);
        }
        a(bVar, dVar, aVar);
    }

    public void b(com.cmic.sso.sdk.a aVar, d dVar) {
        int c = aVar.c("networktype");
        com.cmic.sso.sdk.c.b.a aVar2 = new com.cmic.sso.sdk.c.b.a();
        a.C0985a c0985a = new a.C0985a();
        aVar2.f("0.1");
        aVar2.i(aVar.b("phonescrip"));
        aVar2.h(aVar.b("appid"));
        aVar2.g(s.a());
        aVar2.a(SystemClock.elapsedRealtime());
        aVar2.c(p.a());
        aVar2.d("6.0");
        aVar2.e(aVar.b("userCapaid", "50"));
        aVar2.a("0");
        aVar2.b(aVar.b(UgcConstant.SOURCE_ID));
        aVar2.k(aVar.b("authenticated_appid"));
        aVar2.l(aVar.b("genTokenByAppid"));
        aVar2.j(aVar2.YR(aVar.b("appkey")));
        c0985a.b(n.c());
        c0985a.a(k.b("AID", ""));
        c0985a.c(n.b());
        c0985a.d(n.a());
        c0985a.e(aVar.b("operatortype", ""));
        c0985a.f("0");
        c0985a.g(c + "");
        c0985a.h(r.a(false));
        c0985a.i(r.aG(false, false));
        c0985a.j(aVar.b("CLOSE_CERT_VERIFY", true) ? "0" : "1");
        String f = q.f();
        if (m.a()) {
            c0985a.k("1");
        } else {
            c0985a.k("0");
        }
        aVar2.a(c0985a.a());
        s.a(aVar, "getAuthToken");
        aVar.a("interfaceVersion", "6.0");
        a(new c(f + "/api/getAuthToken", aVar2, "POST", aVar.b("traceId")), dVar, aVar);
    }

    public void a(JSONObject jSONObject, com.cmic.sso.sdk.a aVar, d dVar) {
        f fVar = new f();
        f.a aVar2 = new f.a();
        f.b bVar = new f.b();
        bVar.d(s.a());
        bVar.e(p.a());
        bVar.a("2.0");
        bVar.b(aVar.b("appid", ""));
        bVar.c(bVar.f());
        aVar2.a(jSONObject);
        fVar.a(aVar2);
        fVar.a(bVar);
        a(new c(q.g(), fVar, "POST", aVar.b("traceId")), dVar, aVar);
    }

    private void a(final c cVar, final d dVar, final com.cmic.sso.sdk.a aVar) {
        com.cmic.sso.sdk.c.a.d dVar2 = new com.cmic.sso.sdk.c.a.d();
        com.cmic.sso.sdk.c.a.c cVar2 = new com.cmic.sso.sdk.c.a.c();
        com.cmic.sso.sdk.c.a.a aVar2 = new com.cmic.sso.sdk.c.a.a();
        dVar2.a(cVar2);
        cVar2.a(aVar2);
        cVar.a(SystemClock.elapsedRealtime());
        dVar2.a(cVar, new com.cmic.sso.sdk.c.d.c() { // from class: com.cmic.sso.sdk.c.c.a.1
            @Override // com.cmic.sso.sdk.c.d.c
            public void a(com.cmic.sso.sdk.c.d.b bVar) {
                String string;
                if (cVar.g()) {
                    try {
                        a();
                        JSONObject jSONObject = new JSONObject(bVar.c());
                        if (jSONObject.has("resultcode")) {
                            string = jSONObject.getString("resultcode");
                        } else {
                            string = jSONObject.getString("resultCode");
                        }
                        s.b(aVar, string);
                        dVar.j(string, jSONObject.optString("desc"), jSONObject);
                    } catch (Exception e) {
                        a(com.cmic.sso.sdk.c.d.a.PK(102223));
                    }
                }
            }

            @Override // com.cmic.sso.sdk.c.d.c
            public void a(com.cmic.sso.sdk.c.d.a aVar3) {
                if (cVar.g()) {
                    a();
                    s.b(aVar, String.valueOf(aVar3.a()));
                    dVar.j(String.valueOf(aVar3.a()), aVar3.b(), com.cmic.sso.sdk.b.e.a(String.valueOf(aVar3.a()), aVar3.b()));
                }
            }

            private void a() {
                if (!cVar.a().contains("uniConfig")) {
                    s.c(aVar, String.valueOf(SystemClock.elapsedRealtime() - cVar.i()));
                }
            }
        }, aVar);
    }
}
