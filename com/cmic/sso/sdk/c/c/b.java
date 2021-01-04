package com.cmic.sso.sdk.c.c;

import com.cmic.sso.sdk.c.b.e;
import com.cmic.sso.sdk.e.r;
/* loaded from: classes7.dex */
public class b extends c {
    private boolean c;
    private e prh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, e eVar, String str2, String str3) {
        super(str, eVar, str2, str3);
        this.c = false;
        this.prh = eVar;
    }

    public void b(com.cmic.sso.sdk.a aVar) {
        if (!this.c) {
            String a2 = r.a(true);
            String aJ = r.aJ(true, "1".equals(aVar.b("operatortype", "")));
            aVar.a("ipv4List", a2);
            aVar.a("ipv6List", aJ);
            e.a esO = this.prh.esO();
            if (!aVar.b("isCloseIpv4", false)) {
                esO.a(a2);
            }
            if (!aVar.b("isCloseIpv6", false)) {
                esO.b(aJ);
            }
            esO.v(esO.Zd(aVar.b("appkey")));
            this.prh.a(esO);
            this.prh.a(true);
            this.f8012a = this.prh.b().toString();
            this.c = true;
        }
    }
}
