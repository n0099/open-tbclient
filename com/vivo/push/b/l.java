package com.vivo.push.b;
/* loaded from: classes7.dex */
public final class l extends u {

    /* renamed from: a  reason: collision with root package name */
    public int f39768a;

    /* renamed from: b  reason: collision with root package name */
    public int f39769b;

    public l() {
        super(12);
        this.f39768a = -1;
        this.f39769b = -1;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f39768a);
        aVar.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f39769b);
    }

    public final int d() {
        return this.f39768a;
    }

    public final int e() {
        return this.f39769b;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnChangePushStatusCommand";
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f39768a = aVar.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f39768a);
        this.f39769b = aVar.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f39769b);
    }
}
