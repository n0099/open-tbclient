package com.vivo.push.b;
/* loaded from: classes7.dex */
public final class p extends u {

    /* renamed from: a  reason: collision with root package name */
    public String f40228a;

    /* renamed from: b  reason: collision with root package name */
    public int f40229b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40230c;

    public p() {
        super(7);
        this.f40229b = 0;
        this.f40230c = false;
    }

    public final void a(int i2) {
        this.f40229b = i2;
    }

    public final void b(String str) {
        this.f40228a = str;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.f40228a);
        aVar.a("log_level", this.f40229b);
        aVar.a("is_server_log", this.f40230c);
    }

    public final String d() {
        return this.f40228a;
    }

    public final int e() {
        return this.f40229b;
    }

    public final boolean f() {
        return this.f40230c;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnLogCommand";
    }

    public final void a(boolean z) {
        this.f40230c = z;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f40228a = aVar.a("content");
        this.f40229b = aVar.b("log_level", 0);
        this.f40230c = aVar.d("is_server_log");
    }
}
