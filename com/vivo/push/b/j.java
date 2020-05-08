package com.vivo.push.b;

import com.baidu.android.imsdk.IMConstants;
/* loaded from: classes8.dex */
public final class j extends com.vivo.push.y {
    private String a;

    public j() {
        super(IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME);
    }

    public j(String str) {
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
