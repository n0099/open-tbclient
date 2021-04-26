package com.vivo.push.b;
/* loaded from: classes6.dex */
public final class l extends u {

    /* renamed from: a  reason: collision with root package name */
    public int f37371a;

    /* renamed from: b  reason: collision with root package name */
    public int f37372b;

    public l() {
        super(12);
        this.f37371a = -1;
        this.f37372b = -1;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f37371a);
        aVar.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f37372b);
    }

    public final int d() {
        return this.f37371a;
    }

    public final int e() {
        return this.f37372b;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnChangePushStatusCommand";
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f37371a = aVar.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f37371a);
        this.f37372b = aVar.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f37372b);
    }
}
