package com.vivo.push.b;
/* loaded from: classes3.dex */
public final class k extends u {

    /* renamed from: a  reason: collision with root package name */
    private String f13577a;

    /* renamed from: b  reason: collision with root package name */
    private String f13578b;
    private String c;

    public k(int i) {
        super(i);
    }

    public final String d() {
        return this.f13577a;
    }

    public final String e() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("app_id", this.f13577a);
        aVar.a("client_id", this.f13578b);
        aVar.a("client_token", this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f13577a = aVar.a("app_id");
        this.f13578b = aVar.a("client_id");
        this.c = aVar.a("client_token");
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnBindCommand";
    }
}
