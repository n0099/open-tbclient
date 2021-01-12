package com.vivo.push.b;
/* loaded from: classes3.dex */
public final class p extends u {

    /* renamed from: a  reason: collision with root package name */
    private String f13583a;

    /* renamed from: b  reason: collision with root package name */
    private int f13584b;
    private boolean c;

    public p() {
        super(7);
        this.f13584b = 0;
        this.c = false;
    }

    public final String d() {
        return this.f13583a;
    }

    public final void b(String str) {
        this.f13583a = str;
    }

    public final int e() {
        return this.f13584b;
    }

    public final void a(int i) {
        this.f13584b = i;
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
        aVar.a("content", this.f13583a);
        aVar.a("log_level", this.f13584b);
        aVar.a("is_server_log", this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f13583a = aVar.a("content");
        this.f13584b = aVar.b("log_level", 0);
        this.c = aVar.d("is_server_log");
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnLogCommand";
    }
}
