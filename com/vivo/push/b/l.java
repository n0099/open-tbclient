package com.vivo.push.b;
/* loaded from: classes11.dex */
public final class l extends u {

    /* renamed from: a  reason: collision with root package name */
    private int f4413a;
    private int b;

    public l() {
        super(12);
        this.f4413a = -1;
        this.b = -1;
    }

    public final int d() {
        return this.f4413a;
    }

    public final int e() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f4413a);
        aVar.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f4413a = aVar.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f4413a);
        this.b = aVar.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.b);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnChangePushStatusCommand";
    }
}
