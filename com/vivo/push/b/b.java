package com.vivo.push.b;

import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
/* loaded from: classes7.dex */
public final class b extends c {

    /* renamed from: a  reason: collision with root package name */
    public String f40311a;

    /* renamed from: b  reason: collision with root package name */
    public String f40312b;

    /* renamed from: c  reason: collision with root package name */
    public String f40313c;

    /* renamed from: d  reason: collision with root package name */
    public String f40314d;

    public b(boolean z, String str) {
        super(z ? 2006 : 2007, null, str);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("sdk_clients", this.f40311a);
        aVar.a(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 293L);
        aVar.a("BaseAppCommand.EXTRA_APPID", this.f40313c);
        aVar.a("BaseAppCommand.EXTRA_APPKEY", this.f40312b);
        aVar.a("PUSH_REGID", this.f40314d);
    }

    public final void d() {
        this.f40313c = null;
    }

    public final void e() {
        this.f40312b = null;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final String toString() {
        return "AppCommand:" + b();
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f40311a = aVar.a("sdk_clients");
        this.f40313c = aVar.a("BaseAppCommand.EXTRA_APPID");
        this.f40312b = aVar.a("BaseAppCommand.EXTRA_APPKEY");
        this.f40314d = aVar.a("PUSH_REGID");
    }
}
