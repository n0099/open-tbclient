package com.vivo.push.b;
/* loaded from: classes7.dex */
public final class p extends u {

    /* renamed from: a  reason: collision with root package name */
    public String f39772a;

    /* renamed from: b  reason: collision with root package name */
    public int f39773b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39774c;

    public p() {
        super(7);
        this.f39773b = 0;
        this.f39774c = false;
    }

    public final void a(int i) {
        this.f39773b = i;
    }

    public final void b(String str) {
        this.f39772a = str;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.f39772a);
        aVar.a("log_level", this.f39773b);
        aVar.a("is_server_log", this.f39774c);
    }

    public final String d() {
        return this.f39772a;
    }

    public final int e() {
        return this.f39773b;
    }

    public final boolean f() {
        return this.f39774c;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnLogCommand";
    }

    public final void a(boolean z) {
        this.f39774c = z;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f39772a = aVar.a("content");
        this.f39773b = aVar.b("log_level", 0);
        this.f39774c = aVar.d("is_server_log");
    }
}
