package com.vivo.push.b;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public final class k extends u {

    /* renamed from: a  reason: collision with root package name */
    public String f36542a;

    /* renamed from: b  reason: collision with root package name */
    public String f36543b;

    /* renamed from: c  reason: collision with root package name */
    public String f36544c;

    public k(int i2) {
        super(i2);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a(Constants.APP_ID, this.f36542a);
        aVar.a("client_id", this.f36543b);
        aVar.a("client_token", this.f36544c);
    }

    public final String d() {
        return this.f36542a;
    }

    public final String e() {
        return this.f36544c;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnBindCommand";
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f36542a = aVar.a(Constants.APP_ID);
        this.f36543b = aVar.a("client_id");
        this.f36544c = aVar.a("client_token");
    }
}
