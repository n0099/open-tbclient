package com.vivo.push.b;
/* loaded from: classes4.dex */
public final class j extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    private String f13876a;

    public j() {
        super(2013);
    }

    public j(String str) {
        this();
        this.f13876a = str;
    }

    @Override // com.vivo.push.y
    protected final void c(com.vivo.push.a aVar) {
        aVar.a("MsgArriveCommand.MSG_TAG", this.f13876a);
    }

    @Override // com.vivo.push.y
    protected final void d(com.vivo.push.a aVar) {
        this.f13876a = aVar.a("MsgArriveCommand.MSG_TAG");
    }
}
