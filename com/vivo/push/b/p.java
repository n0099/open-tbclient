package com.vivo.push.b;
/* loaded from: classes7.dex */
public final class p extends u {

    /* renamed from: a  reason: collision with root package name */
    public String f36620a;

    /* renamed from: b  reason: collision with root package name */
    public int f36621b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36622c;

    public p() {
        super(7);
        this.f36621b = 0;
        this.f36622c = false;
    }

    public final void a(int i2) {
        this.f36621b = i2;
    }

    public final void b(String str) {
        this.f36620a = str;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.f36620a);
        aVar.a("log_level", this.f36621b);
        aVar.a("is_server_log", this.f36622c);
    }

    public final String d() {
        return this.f36620a;
    }

    public final int e() {
        return this.f36621b;
    }

    public final boolean f() {
        return this.f36622c;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnLogCommand";
    }

    public final void a(boolean z) {
        this.f36622c = z;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f36620a = aVar.a("content");
        this.f36621b = aVar.b("log_level", 0);
        this.f36622c = aVar.d("is_server_log");
    }
}
