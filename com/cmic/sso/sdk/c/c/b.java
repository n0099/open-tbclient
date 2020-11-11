package com.cmic.sso.sdk.c.c;

import com.cmic.sso.sdk.c.b.e;
import com.cmic.sso.sdk.e.r;
/* loaded from: classes8.dex */
public class b extends c {
    private boolean c;
    private e oJg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, e eVar, String str2, String str3) {
        super(str, eVar, str2, str3);
        this.c = false;
        this.oJg = eVar;
    }

    public void b(com.cmic.sso.sdk.a aVar) {
        if (!this.c) {
            String a2 = r.a(true);
            String aH = r.aH(true, "1".equals(aVar.b("operatortype", "")));
            aVar.a("ipv4List", a2);
            aVar.a("ipv6List", aH);
            e.a eiN = this.oJg.eiN();
            if (!aVar.b("isCloseIpv4", false)) {
                eiN.a(a2);
            }
            if (!aVar.b("isCloseIpv6", false)) {
                eiN.b(aH);
            }
            eiN.v(eiN.XM(aVar.b("appkey")));
            this.oJg.a(eiN);
            this.oJg.a(true);
            this.f4015a = this.oJg.b().toString();
            this.c = true;
        }
    }
}
