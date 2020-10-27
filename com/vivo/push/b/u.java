package com.vivo.push.b;
/* loaded from: classes15.dex */
public class u extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    private String f4648a;
    private int b;

    public u(int i) {
        super(i);
        this.f4648a = null;
        this.b = 0;
    }

    public final String g() {
        return this.f4648a;
    }

    public final int h() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a("req_id", this.f4648a);
        aVar.a("status_msg_code", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.f4648a = aVar.a("req_id");
        this.b = aVar.b("status_msg_code", this.b);
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "OnReceiveCommand";
    }
}
