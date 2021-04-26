package com.vivo.push.b;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
/* loaded from: classes6.dex */
public class u extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f37384a;

    /* renamed from: b  reason: collision with root package name */
    public int f37385b;

    public u(int i2) {
        super(i2);
        this.f37384a = null;
        this.f37385b = 0;
    }

    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a(IAdRequestParam.REQ_ID, this.f37384a);
        aVar.a("status_msg_code", this.f37385b);
    }

    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.f37384a = aVar.a(IAdRequestParam.REQ_ID);
        this.f37385b = aVar.b("status_msg_code", this.f37385b);
    }

    public final String g() {
        return this.f37384a;
    }

    public final int h() {
        return this.f37385b;
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "OnReceiveCommand";
    }
}
