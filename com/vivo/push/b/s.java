package com.vivo.push.b;
/* loaded from: classes5.dex */
public class s extends com.vivo.push.y {
    private String a;
    private int b;

    public s(int i) {
        super(i);
        this.a = null;
        this.b = 0;
    }

    public final String g() {
        return this.a;
    }

    public final int h() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a("req_id", this.a);
        aVar.a("status_msg_code", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.a = aVar.a("req_id");
        this.b = aVar.b("status_msg_code", this.b);
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "OnReceiveCommand";
    }
}
