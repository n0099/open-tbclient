package com.vivo.push.b;
/* loaded from: classes3.dex */
public class u extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    private String f13889a;

    /* renamed from: b  reason: collision with root package name */
    private int f13890b;

    public u(int i) {
        super(i);
        this.f13889a = null;
        this.f13890b = 0;
    }

    public final String g() {
        return this.f13889a;
    }

    public final int h() {
        return this.f13890b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a("req_id", this.f13889a);
        aVar.a("status_msg_code", this.f13890b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.f13889a = aVar.a("req_id");
        this.f13890b = aVar.b("status_msg_code", this.f13890b);
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "OnReceiveCommand";
    }
}
