package com.cmic.sso.sdk.b.c;

import com.cmic.sso.sdk.b.b.e;
import com.cmic.sso.sdk.d.r;
/* loaded from: classes6.dex */
public class b extends c {

    /* renamed from: b  reason: collision with root package name */
    public e f31361b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f31362c;

    public b(String str, e eVar, String str2, String str3) {
        super(str, eVar, str2, str3);
        this.f31362c = false;
        this.f31361b = eVar;
    }

    public void a(com.cmic.sso.sdk.a aVar) {
        if (this.f31362c) {
            return;
        }
        String a2 = r.a(true);
        String a3 = r.a(true, "1".equals(aVar.b("operatortype", "")));
        aVar.a("ipv4List", a2);
        aVar.a("ipv6List", a3);
        e.a c2 = this.f31361b.c();
        if (!aVar.b("isCloseIpv4", false)) {
            c2.a(a2);
        }
        if (!aVar.b("isCloseIpv6", false)) {
            c2.b(a3);
        }
        c2.t(c2.u(aVar.b("appkey")));
        this.f31361b.a(c2);
        this.f31361b.a(true);
        this.f31363a = this.f31361b.b().toString();
        this.f31362c = true;
    }
}
