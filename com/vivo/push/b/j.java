package com.vivo.push.b;

import com.baidu.android.imsdk.IMConstants;
/* loaded from: classes7.dex */
public final class j extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f40220a;

    public j() {
        super(IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME);
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        aVar.a("MsgArriveCommand.MSG_TAG", this.f40220a);
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f40220a = aVar.a("MsgArriveCommand.MSG_TAG");
    }

    public j(String str) {
        this();
        this.f40220a = str;
    }
}
