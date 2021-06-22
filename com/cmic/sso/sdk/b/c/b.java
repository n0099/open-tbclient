package com.cmic.sso.sdk.b.c;

import com.cmic.sso.sdk.b.b.e;
import com.cmic.sso.sdk.d.r;
/* loaded from: classes6.dex */
public class b extends c {

    /* renamed from: b  reason: collision with root package name */
    public final e f30711b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30712c;

    public b(String str, e eVar, String str2, String str3) {
        super(str, eVar, str2, str3);
        this.f30712c = false;
        this.f30711b = eVar;
    }

    public void a(com.cmic.sso.sdk.a aVar) {
        if (this.f30712c) {
            return;
        }
        String a2 = r.a(true);
        String a3 = r.a(true, "1".equals(aVar.b("operatortype", "")));
        aVar.a("ipv4_list", a2);
        aVar.a("ipv6_list", a3);
        com.cmic.sso.sdk.b.b.a c2 = this.f30711b.c();
        if (!aVar.b("isCloseIpv4", false)) {
            c2.s(a2);
        }
        if (!aVar.b("isCloseIpv6", false)) {
            c2.t(a3);
        }
        c2.p(c2.w(aVar.b("appkey")));
        this.f30711b.a(c2);
        this.f30711b.a(true);
        this.f30713a = this.f30711b.b().toString();
        this.f30712c = true;
    }
}
