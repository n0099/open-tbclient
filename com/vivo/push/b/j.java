package com.vivo.push.b;
/* loaded from: classes3.dex */
public final class j extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    private String f13875a;

    public j() {
        super(2013);
    }

    public j(String str) {
        this();
        this.f13875a = str;
    }

    @Override // com.vivo.push.y
    protected final void c(com.vivo.push.a aVar) {
        aVar.a("MsgArriveCommand.MSG_TAG", this.f13875a);
    }

    @Override // com.vivo.push.y
    protected final void d(com.vivo.push.a aVar) {
        this.f13875a = aVar.a("MsgArriveCommand.MSG_TAG");
    }
}
