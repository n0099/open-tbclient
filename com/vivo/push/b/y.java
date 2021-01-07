package com.vivo.push.b;

import com.baidu.android.imsdk.IMConstants;
/* loaded from: classes4.dex */
public final class y extends com.vivo.push.y {
    public y() {
        super(IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME_SEND_FAIL);
    }

    @Override // com.vivo.push.y
    protected final void c(com.vivo.push.a aVar) {
    }

    @Override // com.vivo.push.y
    protected final void d(com.vivo.push.a aVar) {
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "PushDebugCommand";
    }

    @Override // com.vivo.push.y
    public final boolean c() {
        return true;
    }
}
