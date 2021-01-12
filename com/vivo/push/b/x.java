package com.vivo.push.b;
/* loaded from: classes3.dex */
public abstract class x extends u {

    /* renamed from: a  reason: collision with root package name */
    private String f13596a;

    /* renamed from: b  reason: collision with root package name */
    private long f13597b;

    public x(int i) {
        super(i);
    }

    public final long f() {
        return this.f13597b;
    }

    public final String i() {
        return this.f13596a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.f13596a);
        aVar.a("notify_id", this.f13597b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f13596a = aVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.f13597b = aVar.b("notify_id", -1L);
    }
}
