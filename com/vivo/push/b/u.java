package com.vivo.push.b;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
/* loaded from: classes7.dex */
public class u extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f39686a;

    /* renamed from: b  reason: collision with root package name */
    public int f39687b;

    public u(int i) {
        super(i);
        this.f39686a = null;
        this.f39687b = 0;
    }

    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        aVar.a(IAdRequestParam.REQ_ID, this.f39686a);
        aVar.a("status_msg_code", this.f39687b);
    }

    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        this.f39686a = aVar.a(IAdRequestParam.REQ_ID);
        this.f39687b = aVar.b("status_msg_code", this.f39687b);
    }

    public final String g() {
        return this.f39686a;
    }

    public final int h() {
        return this.f39687b;
    }

    @Override // com.vivo.push.y
    public String toString() {
        return "OnReceiveCommand";
    }
}
