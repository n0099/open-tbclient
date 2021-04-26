package com.vivo.push.b;

import com.baidu.android.imsdk.IMConstants;
/* loaded from: classes6.dex */
public final class y extends com.vivo.push.y {
    public y() {
        super(IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME_SEND_FAIL);
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
    }

    @Override // com.vivo.push.y
    public final boolean c() {
        return true;
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "PushDebugCommand";
    }
}
