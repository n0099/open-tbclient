package com.vivo.push.b;
/* loaded from: classes7.dex */
public abstract class x extends u {

    /* renamed from: a  reason: collision with root package name */
    public String f39787a;

    /* renamed from: b  reason: collision with root package name */
    public long f39788b;

    public x(int i) {
        super(i);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.f39787a);
        aVar.a("notify_id", this.f39788b);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f39787a = aVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.f39788b = aVar.b("notify_id", -1L);
    }

    public final long f() {
        return this.f39788b;
    }

    public final String i() {
        return this.f39787a;
    }
}
