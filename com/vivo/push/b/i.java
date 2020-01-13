package com.vivo.push.b;
/* loaded from: classes6.dex */
public final class i extends com.vivo.push.y {
    private String a;

    public i() {
        super(2013);
    }

    public i(String str) {
        this();
        this.a = str;
    }

    @Override // com.vivo.push.y
    protected final void c(com.vivo.push.a aVar) {
        aVar.a("MsgArriveCommand.MSG_TAG", this.a);
    }

    @Override // com.vivo.push.y
    protected final void d(com.vivo.push.a aVar) {
        this.a = aVar.a("MsgArriveCommand.MSG_TAG");
    }
}
