package com.vivo.push.b;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
/* loaded from: classes7.dex */
public class u extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f36629a;

    /* renamed from: b  reason: collision with root package name */
    public int f36630b;

    public u(int i2) {
        super(i2);
        this.f36629a = null;
        this.f36630b = 0;
    }

    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a(IAdRequestParam.REQ_ID, this.f36629a);
        aVar.a("status_msg_code", this.f36630b);
    }

    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.f36629a = aVar.a(IAdRequestParam.REQ_ID);
        this.f36630b = aVar.b("status_msg_code", this.f36630b);
    }

    public final String g() {
        return this.f36629a;
    }

    public final int h() {
        return this.f36630b;
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "OnReceiveCommand";
    }
}
