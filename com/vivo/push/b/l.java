package com.vivo.push.b;
/* loaded from: classes7.dex */
public final class l extends u {

    /* renamed from: a  reason: collision with root package name */
    public int f40224a;

    /* renamed from: b  reason: collision with root package name */
    public int f40225b;

    public l() {
        super(12);
        this.f40224a = -1;
        this.f40225b = -1;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f40224a);
        aVar.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f40225b);
    }

    public final int d() {
        return this.f40224a;
    }

    public final int e() {
        return this.f40225b;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnChangePushStatusCommand";
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f40224a = aVar.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f40224a);
        this.f40225b = aVar.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f40225b);
    }
}
