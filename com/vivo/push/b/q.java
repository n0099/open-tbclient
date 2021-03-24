package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.UnvarnishedMessage;
/* loaded from: classes7.dex */
public final class q extends x {

    /* renamed from: a  reason: collision with root package name */
    public UnvarnishedMessage f39390a;

    public q() {
        super(3);
    }

    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("msg_v1", this.f39390a.unpackToJson());
    }

    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        String a2 = aVar.a("msg_v1");
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        UnvarnishedMessage unvarnishedMessage = new UnvarnishedMessage(a2);
        this.f39390a = unvarnishedMessage;
        unvarnishedMessage.setMsgId(f());
    }

    public final UnvarnishedMessage e() {
        return this.f39390a;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnMessageCommand";
    }

    public final String d() {
        UnvarnishedMessage unvarnishedMessage = this.f39390a;
        if (unvarnishedMessage == null) {
            return null;
        }
        return unvarnishedMessage.unpackToJson();
    }
}
