package com.cmic.sso.sdk.c.c;

import com.cmic.sso.sdk.c.b.e;
import com.cmic.sso.sdk.e.r;
/* loaded from: classes8.dex */
public class b extends c {
    private boolean c;
    private e nIu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, e eVar, String str2, String str3) {
        super(str, eVar, str2, str3);
        this.c = false;
        this.nIu = eVar;
    }

    public void b(com.cmic.sso.sdk.a aVar) {
        if (!this.c) {
            String a2 = r.a(true);
            String aB = r.aB(true, "1".equals(aVar.b("operatortype", "")));
            aVar.a("ipv4List", a2);
            aVar.a("ipv6List", aB);
            e.a dVa = this.nIu.dVa();
            if (!aVar.b("isCloseIpv4", false)) {
                dVa.a(a2);
            }
            if (!aVar.b("isCloseIpv6", false)) {
                dVa.b(aB);
            }
            dVa.v(dVa.Vv(aVar.b("appkey")));
            this.nIu.a(dVa);
            this.nIu.a(true);
            this.f4015a = this.nIu.b().toString();
            this.c = true;
        }
    }
}
