package com.cmic.sso.sdk.b.c;

import android.os.SystemClock;
import com.baidu.pass.ecommerce.common.request.BaseRequest;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.b;
import com.cmic.sso.sdk.b.b.e;
import com.cmic.sso.sdk.b.b.f;
import com.cmic.sso.sdk.b.b.h;
import com.cmic.sso.sdk.d.i;
import com.cmic.sso.sdk.d.j;
import com.cmic.sso.sdk.d.k;
import com.cmic.sso.sdk.d.n;
import com.cmic.sso.sdk.d.p;
import com.cmic.sso.sdk.d.q;
import com.cmic.sso.sdk.d.r;
import com.cmic.sso.sdk.d.s;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.yy.hiidostatis.inner.BaseStatisContent;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f30706a;

    public static a a() {
        if (f30706a == null) {
            synchronized (a.class) {
                if (f30706a == null) {
                    f30706a = new a();
                }
            }
        }
        return f30706a;
    }

    public void a(boolean z, com.cmic.sso.sdk.a aVar, d dVar) {
        com.cmic.sso.sdk.b.b.b bVar = new com.cmic.sso.sdk.b.b.b();
        bVar.b("1.0");
        bVar.c("Android");
        bVar.d(k.b("AID", ""));
        bVar.e(z ? "1" : "0");
        bVar.f(AuthnHelper.SDK_VERSION);
        bVar.g(aVar.b("appid"));
        bVar.h(bVar.w("iYm0HAnkxQtpvN44"));
        a(new c("https://config2.cmpassport.com/client/uniConfig", bVar, "POST", aVar.b("traceId")), dVar, aVar);
    }

    public void a(com.cmic.sso.sdk.a aVar, d dVar) {
        String a2;
        c bVar;
        int c2 = aVar.c("networktype");
        h hVar = new h();
        hVar.b("1.0");
        hVar.c(AuthnHelper.SDK_VERSION);
        hVar.d(aVar.b("appid"));
        hVar.e(aVar.b(BaseStatisContent.IMSI));
        hVar.f(aVar.b("operatortype"));
        hVar.g(c2 + "");
        hVar.h(n.a());
        hVar.i(n.b());
        hVar.j(n.c());
        hVar.k("0");
        hVar.l("1.0");
        hVar.m(s.a());
        hVar.n(p.a());
        hVar.o(j.a().d());
        hVar.q(aVar.b("apppackage"));
        hVar.r(aVar.b("appsign"));
        hVar.a_(k.b("AID", ""));
        if (aVar.c("logintype") == 3) {
            hVar.u("pre");
        } else {
            hVar.y(aVar.b("userCapaid"));
            if (aVar.c("logintype") == 1) {
                hVar.y("200");
            } else {
                hVar.y("50");
            }
            hVar.u("authz");
        }
        s.a(aVar, "scripAndToken");
        if (aVar.b("isCacheScrip", false)) {
            hVar.s(r.a(false));
            hVar.t(r.a(false, false));
            hVar.x(aVar.b("phonescrip"));
            hVar.p(hVar.w(aVar.b("appkey")));
            bVar = new c(q.g() + "/rs/scripAndToken", hVar, "POST", aVar.b("traceId"));
            bVar.a("defendEOF", "0");
        } else {
            e eVar = new e();
            eVar.a(aVar.a(b.a.f30651a));
            eVar.a(hVar);
            eVar.a(false);
            aVar.a("isCloseIpv4", q.b());
            aVar.a("isCloseIpv6", q.c());
            String str = q.e() + "/rs/scripAndToken";
            if (aVar.b("use2048PublicKey", false)) {
                com.cmic.sso.sdk.d.c.a(BaseRequest.TAG, "使用2对应的编码");
                eVar.b("2");
                a2 = i.a().b(aVar.a(b.a.f30651a));
            } else {
                a2 = i.a().a(aVar.a(b.a.f30651a));
            }
            eVar.c(a2);
            bVar = new b(str, eVar, "POST", aVar.b("traceId"));
            bVar.a("defendEOF", "1");
            if (c2 == 3) {
                bVar.a(true);
                aVar.a("doNetworkSwitch", true);
            } else {
                bVar.a(false);
                aVar.a("doNetworkSwitch", false);
            }
        }
        bVar.a("interfaceVersion", "1.0");
        a(bVar, dVar, aVar);
    }

    public void a(JSONObject jSONObject, com.cmic.sso.sdk.a aVar, d dVar) {
        f fVar = new f();
        f.a aVar2 = new f.a();
        f.b bVar = new f.b();
        bVar.e(s.a());
        bVar.f(p.a());
        bVar.b("2.0");
        bVar.c(aVar.b("appid", ""));
        bVar.d(bVar.w(""));
        aVar2.a(jSONObject);
        fVar.a(aVar2);
        fVar.a(bVar);
        a(new c(q.i(), fVar, "POST", aVar.b("traceId")), dVar, aVar);
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
                    } catch (Exception e2) {
                        e2.printStackTrace();
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
