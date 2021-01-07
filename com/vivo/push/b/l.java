package com.vivo.push.b;
/* loaded from: classes4.dex */
public final class l extends u {

    /* renamed from: a  reason: collision with root package name */
    private int f13879a;

    /* renamed from: b  reason: collision with root package name */
    private int f13880b;

    public l() {
        super(12);
        this.f13879a = -1;
        this.f13880b = -1;
    }

    public final int d() {
        return this.f13879a;
    }

    public final int e() {
        return this.f13880b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f13879a);
        aVar.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f13880b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f13879a = aVar.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f13879a);
        this.f13880b = aVar.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f13880b);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnChangePushStatusCommand";
    }
}
