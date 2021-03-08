package com.vivo.push.b;
/* loaded from: classes14.dex */
public abstract class x extends u {

    /* renamed from: a  reason: collision with root package name */
    private String f8028a;
    private long b;

    public x(int i) {
        super(i);
    }

    public final long f() {
        return this.b;
    }

    public final String i() {
        return this.f8028a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.f8028a);
        aVar.a("notify_id", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f8028a = aVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.b = aVar.b("notify_id", -1L);
    }
}
