package com.vivo.push.b;
/* loaded from: classes7.dex */
public final class p extends u {

    /* renamed from: a  reason: collision with root package name */
    public String f40331a;

    /* renamed from: b  reason: collision with root package name */
    public int f40332b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40333c;

    public p() {
        super(7);
        this.f40332b = 0;
        this.f40333c = false;
    }

    public final void a(int i2) {
        this.f40332b = i2;
    }

    public final void b(String str) {
        this.f40331a = str;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.f40331a);
        aVar.a("log_level", this.f40332b);
        aVar.a("is_server_log", this.f40333c);
    }

    public final String d() {
        return this.f40331a;
    }

    public final int e() {
        return this.f40332b;
    }

    public final boolean f() {
        return this.f40333c;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnLogCommand";
    }

    public final void a(boolean z) {
        this.f40333c = z;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f40331a = aVar.a("content");
        this.f40332b = aVar.b("log_level", 0);
        this.f40333c = aVar.d("is_server_log");
    }
}
