package com.vivo.push.b;
/* loaded from: classes15.dex */
public final class l extends u {

    /* renamed from: a  reason: collision with root package name */
    private int f13581a;

    /* renamed from: b  reason: collision with root package name */
    private int f13582b;

    public l() {
        super(12);
        this.f13581a = -1;
        this.f13582b = -1;
    }

    public final int d() {
        return this.f13581a;
    }

    public final int e() {
        return this.f13582b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f13581a);
        aVar.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f13582b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f13581a = aVar.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f13581a);
        this.f13582b = aVar.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f13582b);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnChangePushStatusCommand";
    }
}
