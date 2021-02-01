package com.vivo.push.b;
/* loaded from: classes15.dex */
public class u extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    private String f13592a;

    /* renamed from: b  reason: collision with root package name */
    private int f13593b;

    public u(int i) {
        super(i);
        this.f13592a = null;
        this.f13593b = 0;
    }

    public final String g() {
        return this.f13592a;
    }

    public final int h() {
        return this.f13593b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a("req_id", this.f13592a);
        aVar.a("status_msg_code", this.f13593b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.f13592a = aVar.a("req_id");
        this.f13593b = aVar.b("status_msg_code", this.f13593b);
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "OnReceiveCommand";
    }
}
