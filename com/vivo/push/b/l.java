package com.vivo.push.b;
/* loaded from: classes7.dex */
public final class l extends u {

    /* renamed from: a  reason: collision with root package name */
    public int f39673a;

    /* renamed from: b  reason: collision with root package name */
    public int f39674b;

    public l() {
        super(12);
        this.f39673a = -1;
        this.f39674b = -1;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f39673a);
        aVar.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f39674b);
    }

    public final int d() {
        return this.f39673a;
    }

    public final int e() {
        return this.f39674b;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnChangePushStatusCommand";
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f39673a = aVar.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f39673a);
        this.f39674b = aVar.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f39674b);
    }
}
