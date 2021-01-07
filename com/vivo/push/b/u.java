package com.vivo.push.b;
/* loaded from: classes4.dex */
public class u extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    private String f13890a;

    /* renamed from: b  reason: collision with root package name */
    private int f13891b;

    public u(int i) {
        super(i);
        this.f13890a = null;
        this.f13891b = 0;
    }

    public final String g() {
        return this.f13890a;
    }

    public final int h() {
        return this.f13891b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a("req_id", this.f13890a);
        aVar.a("status_msg_code", this.f13891b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.f13890a = aVar.a("req_id");
        this.f13891b = aVar.b("status_msg_code", this.f13891b);
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "OnReceiveCommand";
    }
}
