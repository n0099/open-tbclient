package com.vivo.push.b;

import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes7.dex */
public final class k extends u {

    /* renamed from: a  reason: collision with root package name */
    public String f39380a;

    /* renamed from: b  reason: collision with root package name */
    public String f39381b;

    /* renamed from: c  reason: collision with root package name */
    public String f39382c;

    public k(int i) {
        super(i);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a(Constants.APP_ID, this.f39380a);
        aVar.a("client_id", this.f39381b);
        aVar.a("client_token", this.f39382c);
    }

    public final String d() {
        return this.f39380a;
    }

    public final String e() {
        return this.f39382c;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnBindCommand";
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f39380a = aVar.a(Constants.APP_ID);
        this.f39381b = aVar.a("client_id");
        this.f39382c = aVar.a("client_token");
    }
}
