package com.vivo.push.b;
/* loaded from: classes6.dex */
public final class p extends u {

    /* renamed from: a  reason: collision with root package name */
    public String f37375a;

    /* renamed from: b  reason: collision with root package name */
    public int f37376b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37377c;

    public p() {
        super(7);
        this.f37376b = 0;
        this.f37377c = false;
    }

    public final void a(int i2) {
        this.f37376b = i2;
    }

    public final void b(String str) {
        this.f37375a = str;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.f37375a);
        aVar.a("log_level", this.f37376b);
        aVar.a("is_server_log", this.f37377c);
    }

    public final String d() {
        return this.f37375a;
    }

    public final int e() {
        return this.f37376b;
    }

    public final boolean f() {
        return this.f37377c;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnLogCommand";
    }

    public final void a(boolean z) {
        this.f37377c = z;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f37375a = aVar.a("content");
        this.f37376b = aVar.b("log_level", 0);
        this.f37377c = aVar.d("is_server_log");
    }
}
