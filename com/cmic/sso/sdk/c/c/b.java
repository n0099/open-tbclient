package com.cmic.sso.sdk.c.c;

import com.cmic.sso.sdk.c.b.e;
import com.cmic.sso.sdk.e.r;
/* loaded from: classes7.dex */
public class b extends c {
    private boolean c;
    private e nta;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, e eVar, String str2, String str3) {
        super(str, eVar, str2, str3);
        this.c = false;
        this.nta = eVar;
    }

    public void b(com.cmic.sso.sdk.a aVar) {
        if (!this.c) {
            String a = r.a(true);
            String aC = r.aC(true, "1".equals(aVar.b("operatortype", "")));
            aVar.a("ipv4List", a);
            aVar.a("ipv6List", aC);
            e.a dRp = this.nta.dRp();
            if (!aVar.b("isCloseIpv4", false)) {
                dRp.a(a);
            }
            if (!aVar.b("isCloseIpv6", false)) {
                dRp.b(aC);
            }
            dRp.v(dRp.UH(aVar.b("appkey")));
            this.nta.a(dRp);
            this.nta.a(true);
            this.a = this.nta.b().toString();
            this.c = true;
        }
    }
}
