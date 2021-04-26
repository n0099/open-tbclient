package com.vivo.push.b;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes6.dex */
public final class k extends u {

    /* renamed from: a  reason: collision with root package name */
    public String f37368a;

    /* renamed from: b  reason: collision with root package name */
    public String f37369b;

    /* renamed from: c  reason: collision with root package name */
    public String f37370c;

    public k(int i2) {
        super(i2);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a(Constants.APP_ID, this.f37368a);
        aVar.a("client_id", this.f37369b);
        aVar.a("client_token", this.f37370c);
    }

    public final String d() {
        return this.f37368a;
    }

    public final String e() {
        return this.f37370c;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnBindCommand";
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f37368a = aVar.a(Constants.APP_ID);
        this.f37369b = aVar.a("client_id");
        this.f37370c = aVar.a("client_token");
    }
}
