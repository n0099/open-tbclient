package com.vivo.push.b;
/* loaded from: classes7.dex */
public class u extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f39397a;

    /* renamed from: b  reason: collision with root package name */
    public int f39398b;

    public u(int i) {
        super(i);
        this.f39397a = null;
        this.f39398b = 0;
    }

    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a("req_id", this.f39397a);
        aVar.a("status_msg_code", this.f39398b);
    }

    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.f39397a = aVar.a("req_id");
        this.f39398b = aVar.b("status_msg_code", this.f39398b);
    }

    public final String g() {
        return this.f39397a;
    }

    public final int h() {
        return this.f39398b;
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "OnReceiveCommand";
    }
}
