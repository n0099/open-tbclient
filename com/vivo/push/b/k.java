package com.vivo.push.b;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public final class k extends u {

    /* renamed from: a  reason: collision with root package name */
    public String f36613a;

    /* renamed from: b  reason: collision with root package name */
    public String f36614b;

    /* renamed from: c  reason: collision with root package name */
    public String f36615c;

    public k(int i2) {
        super(i2);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a(Constants.APP_ID, this.f36613a);
        aVar.a("client_id", this.f36614b);
        aVar.a("client_token", this.f36615c);
    }

    public final String d() {
        return this.f36613a;
    }

    public final String e() {
        return this.f36615c;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnBindCommand";
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f36613a = aVar.a(Constants.APP_ID);
        this.f36614b = aVar.a("client_id");
        this.f36615c = aVar.a("client_token");
    }
}
