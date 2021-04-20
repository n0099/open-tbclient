package com.vivo.push.b;
/* loaded from: classes7.dex */
public final class p extends u {

    /* renamed from: a  reason: collision with root package name */
    public String f39677a;

    /* renamed from: b  reason: collision with root package name */
    public int f39678b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39679c;

    public p() {
        super(7);
        this.f39678b = 0;
        this.f39679c = false;
    }

    public final void a(int i) {
        this.f39678b = i;
    }

    public final void b(String str) {
        this.f39677a = str;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.f39677a);
        aVar.a("log_level", this.f39678b);
        aVar.a("is_server_log", this.f39679c);
    }

    public final String d() {
        return this.f39677a;
    }

    public final int e() {
        return this.f39678b;
    }

    public final boolean f() {
        return this.f39679c;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnLogCommand";
    }

    public final void a(boolean z) {
        this.f39679c = z;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f39677a = aVar.a("content");
        this.f39678b = aVar.b("log_level", 0);
        this.f39679c = aVar.d("is_server_log");
    }
}
