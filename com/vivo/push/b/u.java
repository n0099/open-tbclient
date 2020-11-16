package com.vivo.push.b;
/* loaded from: classes11.dex */
public class u extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    private String f4650a;
    private int b;

    public u(int i) {
        super(i);
        this.f4650a = null;
        this.b = 0;
    }

    public final String g() {
        return this.f4650a;
    }

    public final int h() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a("req_id", this.f4650a);
        aVar.a("status_msg_code", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.f4650a = aVar.a("req_id");
        this.b = aVar.b("status_msg_code", this.b);
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "OnReceiveCommand";
    }
}
