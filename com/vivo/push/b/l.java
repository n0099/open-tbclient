package com.vivo.push.b;
/* loaded from: classes15.dex */
public final class l extends u {

    /* renamed from: a  reason: collision with root package name */
    private int f4643a;
    private int b;

    public l() {
        super(12);
        this.f4643a = -1;
        this.b = -1;
    }

    public final int d() {
        return this.f4643a;
    }

    public final int e() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f4643a);
        aVar.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f4643a = aVar.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f4643a);
        this.b = aVar.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.b);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnChangePushStatusCommand";
    }
}
