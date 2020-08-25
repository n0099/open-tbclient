package com.cmic.sso.sdk.c.c;

import com.cmic.sso.sdk.c.b.e;
import com.cmic.sso.sdk.e.r;
/* loaded from: classes7.dex */
public class b extends c {
    private boolean c;
    private e niI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, e eVar, String str2, String str3) {
        super(str, eVar, str2, str3);
        this.c = false;
        this.niI = eVar;
    }

    public void b(com.cmic.sso.sdk.a aVar) {
        if (!this.c) {
            String a = r.a(true);
            String aA = r.aA(true, "1".equals(aVar.b("operatortype", "")));
            aVar.a("ipv4List", a);
            aVar.a("ipv6List", aA);
            e.a dNi = this.niI.dNi();
            if (!aVar.b("isCloseIpv4", false)) {
                dNi.a(a);
            }
            if (!aVar.b("isCloseIpv6", false)) {
                dNi.b(aA);
            }
            dNi.v(dNi.Uf(aVar.b("appkey")));
            this.niI.a(dNi);
            this.niI.a(true);
            this.a = this.niI.b().toString();
            this.c = true;
        }
    }
}
