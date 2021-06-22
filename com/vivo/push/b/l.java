package com.vivo.push.b;
/* loaded from: classes7.dex */
public final class l extends u {

    /* renamed from: a  reason: collision with root package name */
    public int f40327a;

    /* renamed from: b  reason: collision with root package name */
    public int f40328b;

    public l() {
        super(12);
        this.f40327a = -1;
        this.f40328b = -1;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f40327a);
        aVar.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f40328b);
    }

    public final int d() {
        return this.f40327a;
    }

    public final int e() {
        return this.f40328b;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnChangePushStatusCommand";
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f40327a = aVar.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f40327a);
        this.f40328b = aVar.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f40328b);
    }
}
