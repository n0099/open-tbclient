package com.cmic.sso.sdk.c.c;

import com.cmic.sso.sdk.c.b.e;
import com.cmic.sso.sdk.e.r;
/* loaded from: classes10.dex */
public class b extends c {
    private boolean c;
    private e oKK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, e eVar, String str2, String str3) {
        super(str, eVar, str2, str3);
        this.c = false;
        this.oKK = eVar;
    }

    public void b(com.cmic.sso.sdk.a aVar) {
        if (!this.c) {
            String a2 = r.a(true);
            String aF = r.aF(true, "1".equals(aVar.b("operatortype", "")));
            aVar.a("ipv4List", a2);
            aVar.a("ipv6List", aF);
            e.a eiL = this.oKK.eiL();
            if (!aVar.b("isCloseIpv4", false)) {
                eiL.a(a2);
            }
            if (!aVar.b("isCloseIpv6", false)) {
                eiL.b(aF);
            }
            eiL.v(eiL.Xx(aVar.b("appkey")));
            this.oKK.a(eiL);
            this.oKK.a(true);
            this.f4015a = this.oKK.b().toString();
            this.c = true;
        }
    }
}
