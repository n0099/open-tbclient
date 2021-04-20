package com.cmic.sso.sdk.b.c;

import android.os.SystemClock;
import com.baidu.pass.ecommerce.common.request.BaseRequest;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.b;
import com.cmic.sso.sdk.b.b.a;
import com.cmic.sso.sdk.b.b.e;
import com.cmic.sso.sdk.b.b.f;
import com.cmic.sso.sdk.d.i;
import com.cmic.sso.sdk.d.j;
import com.cmic.sso.sdk.d.k;
import com.cmic.sso.sdk.d.m;
import com.cmic.sso.sdk.d.n;
import com.cmic.sso.sdk.d.p;
import com.cmic.sso.sdk.d.q;
import com.cmic.sso.sdk.d.r;
import com.cmic.sso.sdk.d.s;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f30333a;

    public static a a() {
        if (f30333a == null) {
            synchronized (a.class) {
                if (f30333a == null) {
                    f30333a = new a();
                }
            }
        }
        return f30333a;
    }

    public void b(com.cmic.sso.sdk.a aVar, d dVar) {
        int c2 = aVar.c("networktype");
        com.cmic.sso.sdk.b.b.a aVar2 = new com.cmic.sso.sdk.b.b.a();
        a.C0345a c0345a = new a.C0345a();
        aVar2.f("0.1");
        aVar2.i(aVar.b("phonescrip"));
        aVar2.h(aVar.b("appid"));
        aVar2.g(s.a());
        aVar2.a(SystemClock.elapsedRealtime());
        aVar2.c(p.a());
        aVar2.d("6.0");
        aVar2.e(aVar.b("userCapaid", "50"));
        aVar2.a("0");
        aVar2.b(aVar.b("sourceid"));
        aVar2.k(aVar.b("authenticated_appid"));
        aVar2.l(aVar.b("genTokenByAppid"));
        aVar2.j(aVar2.m(aVar.b("appkey")));
        c0345a.b(n.c());
        c0345a.a(k.b("AID", ""));
        c0345a.c(n.b());
        c0345a.d(n.a());
        c0345a.e(aVar.b("operatortype", ""));
        c0345a.f("0");
        c0345a.g(c2 + "");
        c0345a.h(r.a(false));
        c0345a.i(r.a(false, false));
        c0345a.j(aVar.b("CLOSE_CERT_VERIFY", true) ? "0" : "1");
        String f2 = q.f();
        if (m.a()) {
            c0345a.k("1");
        } else {
            c0345a.k("0");
        }
        aVar2.a(c0345a.a());
        s.a(aVar, "getAuthToken");
        aVar.a("interfaceVersion", "6.0");
        a(new c(f2 + "/api/getAuthToken", aVar2, "POST", aVar.b("traceId")), dVar, aVar);
    }

    public void a(boolean z, com.cmic.sso.sdk.a aVar, d dVar) {
        com.cmic.sso.sdk.b.b.b bVar = new com.cmic.sso.sdk.b.b.b();
        bVar.a("1.0");
        bVar.b("Android");
        bVar.c(k.b("AID", ""));
        bVar.d(z ? "1" : "0");
        bVar.e(AuthnHelper.SDK_VERSION);
        bVar.f(aVar.b("appid"));
        bVar.g(bVar.c());
        a(new c("https://config.cmpassport.com/client/uniConfig", bVar, "POST", aVar.b("traceId")), dVar, aVar);
    }

    public void a(com.cmic.sso.sdk.a aVar, d dVar) {
        String a2;
        int c2 = aVar.c("networktype");
        String b2 = aVar.b("authtype", "");
        e eVar = new e();
        e.a aVar2 = new e.a();
        aVar2.d("1.0");
        aVar2.e(AuthnHelper.SDK_VERSION);
        aVar2.f(aVar.b("appid"));
        aVar2.g(b2);
        aVar2.h(aVar.b("smskey", ""));
        aVar2.i(aVar.b("imsi"));
        aVar2.c(j.a().c());
        aVar2.j(aVar.b("operatortype"));
        aVar2.k(c2 + "");
        aVar2.l(n.a());
        aVar2.m(n.b());
        aVar2.n(n.c());
        aVar2.o("0");
        aVar2.p(s.a());
        aVar2.a(SystemClock.elapsedRealtime());
        aVar2.q(p.a());
        aVar2.r(aVar.b("apppackage"));
        aVar2.s(aVar.b("appsign"));
        eVar.a(aVar.a(b.a.f30264a));
        if (aVar.b("use2048PublicKey", false)) {
            com.cmic.sso.sdk.d.c.a(BaseRequest.TAG, "使用2对应的编码");
            eVar.a("2");
            a2 = i.a().b(aVar.a(b.a.f30264a));
        } else {
            a2 = i.a().a(aVar.a(b.a.f30264a));
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
        if (c2 == 3 && b2.equals("3")) {
            bVar.a(true);
            aVar.a("doNetworkSwitch", true);
        } else {
            bVar.a(false);
            aVar.a("doNetworkSwitch", false);
        }
        a(bVar, dVar, aVar);
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
        com.cmic.sso.sdk.b.a.d dVar2 = new com.cmic.sso.sdk.b.a.d();
        com.cmic.sso.sdk.b.a.c cVar2 = new com.cmic.sso.sdk.b.a.c();
        com.cmic.sso.sdk.b.a.a aVar2 = new com.cmic.sso.sdk.b.a.a();
        dVar2.a(cVar2);
        cVar2.a(aVar2);
        cVar.a(SystemClock.elapsedRealtime());
        dVar2.a(cVar, new com.cmic.sso.sdk.b.d.c() { // from class: com.cmic.sso.sdk.b.c.a.1
            @Override // com.cmic.sso.sdk.b.d.c
            public void a(com.cmic.sso.sdk.b.d.b bVar) {
                String string;
                if (cVar.g()) {
                    try {
                        a();
                        JSONObject jSONObject = new JSONObject(bVar.c());
                        if (jSONObject.has("resultcode")) {
                            string = jSONObject.getString("resultcode");
                        } else {
                            string = jSONObject.getString(MiPushCommandMessage.KEY_RESULT_CODE);
                        }
                        s.b(aVar, string);
                        dVar.a(string, jSONObject.optString("desc"), jSONObject);
                    } catch (Exception unused) {
                        a(com.cmic.sso.sdk.b.d.a.a(102223));
                    }
                }
            }

            @Override // com.cmic.sso.sdk.b.d.c
            public void a(com.cmic.sso.sdk.b.d.a aVar3) {
                if (cVar.g()) {
                    a();
                    s.b(aVar, String.valueOf(aVar3.a()));
                    dVar.a(String.valueOf(aVar3.a()), aVar3.b(), com.cmic.sso.sdk.auth.c.a(String.valueOf(aVar3.a()), aVar3.b()));
                }
            }

            private void a() {
                if (cVar.a().contains("uniConfig")) {
                    return;
                }
                s.c(aVar, String.valueOf(SystemClock.elapsedRealtime() - cVar.i()));
            }
        }, aVar);
    }
}
