package com.cmic.sso.sdk.c.c;

import com.cmic.sso.sdk.c.b.e;
import com.cmic.sso.sdk.e.r;
/* loaded from: classes14.dex */
public class b extends c {
    private boolean c;
    private e pzx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, e eVar, String str2, String str3) {
        super(str, eVar, str2, str3);
        this.c = false;
        this.pzx = eVar;
    }

    public void b(com.cmic.sso.sdk.a aVar) {
        if (!this.c) {
            String a2 = r.a(true);
            String aJ = r.aJ(true, "1".equals(aVar.b("operatortype", "")));
            aVar.a("ipv4List", a2);
            aVar.a("ipv6List", aJ);
            e.a erF = this.pzx.erF();
            if (!aVar.b("isCloseIpv4", false)) {
                erF.a(a2);
            }
            if (!aVar.b("isCloseIpv6", false)) {
                erF.b(aJ);
            }
            erF.v(erF.Zo(aVar.b("appkey")));
            this.pzx.a(erF);
            this.pzx.a(true);
            this.f5213a = this.pzx.b().toString();
            this.c = true;
        }
    }
}
