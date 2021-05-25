package com.vivo.push.b;

import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
/* loaded from: classes7.dex */
public final class b extends c {

    /* renamed from: a  reason: collision with root package name */
    public String f36529a;

    /* renamed from: b  reason: collision with root package name */
    public String f36530b;

    /* renamed from: c  reason: collision with root package name */
    public String f36531c;

    /* renamed from: d  reason: collision with root package name */
    public String f36532d;

    public b(boolean z, String str) {
        super(z ? 2006 : 2007, null, str);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("sdk_clients", this.f36529a);
        aVar.a(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 293L);
        aVar.a("BaseAppCommand.EXTRA_APPID", this.f36531c);
        aVar.a("BaseAppCommand.EXTRA_APPKEY", this.f36530b);
        aVar.a("PUSH_REGID", this.f36532d);
    }

    public final void d() {
        this.f36531c = null;
    }

    public final void e() {
        this.f36530b = null;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final String toString() {
        return "AppCommand:" + b();
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f36529a = aVar.a("sdk_clients");
        this.f36531c = aVar.a("BaseAppCommand.EXTRA_APPID");
        this.f36530b = aVar.a("BaseAppCommand.EXTRA_APPKEY");
        this.f36532d = aVar.a("PUSH_REGID");
    }
}
