package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.UnvarnishedMessage;
/* loaded from: classes9.dex */
public final class q extends x {
    protected UnvarnishedMessage a;

    public q() {
        super(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("msg_v1", this.a.unpackToJson());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        String a = aVar.a("msg_v1");
        if (!TextUtils.isEmpty(a)) {
            this.a = new UnvarnishedMessage(a);
            this.a.setMsgId(f());
        }
    }

    public final String d() {
        if (this.a == null) {
            return null;
        }
        return this.a.unpackToJson();
    }

    public final UnvarnishedMessage e() {
        return this.a;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnMessageCommand";
    }
}
