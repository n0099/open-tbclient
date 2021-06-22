package com.vivo.push.b;
/* loaded from: classes7.dex */
public abstract class x extends u {

    /* renamed from: a  reason: collision with root package name */
    public String f40346a;

    /* renamed from: b  reason: collision with root package name */
    public long f40347b;

    public x(int i2) {
        super(i2);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.f40346a);
        aVar.a("notify_id", this.f40347b);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f40346a = aVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.f40347b = aVar.b("notify_id", -1L);
    }

    public final long f() {
        return this.f40347b;
    }

    public final String i() {
        return this.f40346a;
    }
}
