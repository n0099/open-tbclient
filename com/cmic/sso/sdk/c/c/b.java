package com.cmic.sso.sdk.c.c;

import com.cmic.sso.sdk.c.b.e;
import com.cmic.sso.sdk.e.r;
/* loaded from: classes15.dex */
public class b extends c {
    private boolean c;
    private e pwS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, e eVar, String str2, String str3) {
        super(str, eVar, str2, str3);
        this.c = false;
        this.pwS = eVar;
    }

    public void b(com.cmic.sso.sdk.a aVar) {
        if (!this.c) {
            String a2 = r.a(true);
            String aJ = r.aJ(true, "1".equals(aVar.b("operatortype", "")));
            aVar.a("ipv4List", a2);
            aVar.a("ipv6List", aJ);
            e.a ern = this.pwS.ern();
            if (!aVar.b("isCloseIpv4", false)) {
                ern.a(a2);
            }
            if (!aVar.b("isCloseIpv6", false)) {
                ern.b(aJ);
            }
            ern.v(ern.YW(aVar.b("appkey")));
            this.pwS.a(ern);
            this.pwS.a(true);
            this.f7715a = this.pwS.b().toString();
            this.c = true;
        }
    }
}
