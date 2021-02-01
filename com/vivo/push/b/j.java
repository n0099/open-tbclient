package com.vivo.push.b;

import com.baidu.android.imsdk.IMConstants;
/* loaded from: classes15.dex */
public final class j extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    private String f13578a;

    public j() {
        super(IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME);
    }

    public j(String str) {
        this();
        this.f13578a = str;
    }

    @Override // com.vivo.push.y
    protected final void c(com.vivo.push.a aVar) {
        aVar.a("MsgArriveCommand.MSG_TAG", this.f13578a);
    }

    @Override // com.vivo.push.y
    protected final void d(com.vivo.push.a aVar) {
        this.f13578a = aVar.a("MsgArriveCommand.MSG_TAG");
    }
}
