package com.vivo.push.b;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public final class k extends u {

    /* renamed from: a  reason: collision with root package name */
    public String f40221a;

    /* renamed from: b  reason: collision with root package name */
    public String f40222b;

    /* renamed from: c  reason: collision with root package name */
    public String f40223c;

    public k(int i2) {
        super(i2);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a(Constants.APP_ID, this.f40221a);
        aVar.a("client_id", this.f40222b);
        aVar.a("client_token", this.f40223c);
    }

    public final String d() {
        return this.f40221a;
    }

    public final String e() {
        return this.f40223c;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnBindCommand";
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f40221a = aVar.a(Constants.APP_ID);
        this.f40222b = aVar.a("client_id");
        this.f40223c = aVar.a("client_token");
    }
}
