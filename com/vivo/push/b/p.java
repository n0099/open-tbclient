package com.vivo.push.b;
/* loaded from: classes15.dex */
public final class p extends u {

    /* renamed from: a  reason: collision with root package name */
    private String f4646a;
    private int b;
    private boolean c;

    public p() {
        super(7);
        this.b = 0;
        this.c = false;
    }

    public final String d() {
        return this.f4646a;
    }

    public final void b(String str) {
        this.f4646a = str;
    }

    public final int e() {
        return this.b;
    }

    public final void a(int i) {
        this.b = i;
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
        aVar.a("content", this.f4646a);
        aVar.a("log_level", this.b);
        aVar.a("is_server_log", this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f4646a = aVar.a("content");
        this.b = aVar.b("log_level", 0);
        this.c = aVar.d("is_server_log");
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnLogCommand";
    }
}
