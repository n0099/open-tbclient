package com.vivo.push.b;
/* loaded from: classes7.dex */
public final class l extends u {

    /* renamed from: a  reason: collision with root package name */
    public int f39383a;

    /* renamed from: b  reason: collision with root package name */
    public int f39384b;

    public l() {
        super(12);
        this.f39383a = -1;
        this.f39384b = -1;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f39383a);
        aVar.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f39384b);
    }

    public final int d() {
        return this.f39383a;
    }

    public final int e() {
        return this.f39384b;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnChangePushStatusCommand";
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f39383a = aVar.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f39383a);
        this.f39384b = aVar.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f39384b);
    }
}
