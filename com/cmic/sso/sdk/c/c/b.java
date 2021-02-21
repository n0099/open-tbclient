package com.cmic.sso.sdk.c.c;

import com.cmic.sso.sdk.c.b.e;
import com.cmic.sso.sdk.e.r;
/* loaded from: classes15.dex */
public class b extends c {
    private boolean c;
    private e pxs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, e eVar, String str2, String str3) {
        super(str, eVar, str2, str3);
        this.c = false;
        this.pxs = eVar;
    }

    public void b(com.cmic.sso.sdk.a aVar) {
        if (!this.c) {
            String a2 = r.a(true);
            String aJ = r.aJ(true, "1".equals(aVar.b("operatortype", "")));
            aVar.a("ipv4List", a2);
            aVar.a("ipv6List", aJ);
            e.a erw = this.pxs.erw();
            if (!aVar.b("isCloseIpv4", false)) {
                erw.a(a2);
            }
            if (!aVar.b("isCloseIpv6", false)) {
                erw.b(aJ);
            }
            erw.v(erw.Zi(aVar.b("appkey")));
            this.pxs.a(erw);
            this.pxs.a(true);
            this.f7715a = this.pxs.b().toString();
            this.c = true;
        }
    }
}
