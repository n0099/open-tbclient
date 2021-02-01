package com.vivo.push.b;
/* loaded from: classes15.dex */
public final class p extends u {

    /* renamed from: a  reason: collision with root package name */
    private String f13585a;

    /* renamed from: b  reason: collision with root package name */
    private int f13586b;
    private boolean c;

    public p() {
        super(7);
        this.f13586b = 0;
        this.c = false;
    }

    public final String d() {
        return this.f13585a;
    }

    public final void b(String str) {
        this.f13585a = str;
    }

    public final int e() {
        return this.f13586b;
    }

    public final void a(int i) {
        this.f13586b = i;
    }

    public final boolean f() {
        return this.c;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.f13585a);
        aVar.a("log_level", this.f13586b);
        aVar.a("is_server_log", this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f13585a = aVar.a("content");
        this.f13586b = aVar.b("log_level", 0);
        this.c = aVar.d("is_server_log");
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnLogCommand";
    }
}
