package com.vivo.push.b;
/* loaded from: classes3.dex */
public class u extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    private String f13590a;

    /* renamed from: b  reason: collision with root package name */
    private int f13591b;

    public u(int i) {
        super(i);
        this.f13590a = null;
        this.f13591b = 0;
    }

    public final String g() {
        return this.f13590a;
    }

    public final int h() {
        return this.f13591b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a("req_id", this.f13590a);
        aVar.a("status_msg_code", this.f13591b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.f13590a = aVar.a("req_id");
        this.f13591b = aVar.b("status_msg_code", this.f13591b);
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "OnReceiveCommand";
    }
}
