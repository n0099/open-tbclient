package com.vivo.push.b;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
/* loaded from: classes7.dex */
public class u extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f40237a;

    /* renamed from: b  reason: collision with root package name */
    public int f40238b;

    public u(int i2) {
        super(i2);
        this.f40237a = null;
        this.f40238b = 0;
    }

    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a(IAdRequestParam.REQ_ID, this.f40237a);
        aVar.a("status_msg_code", this.f40238b);
    }

    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.f40237a = aVar.a(IAdRequestParam.REQ_ID);
        this.f40238b = aVar.b("status_msg_code", this.f40238b);
    }

    public final String g() {
        return this.f40237a;
    }

    public final int h() {
        return this.f40238b;
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "OnReceiveCommand";
    }
}
