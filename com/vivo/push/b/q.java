package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.UnvarnishedMessage;
/* loaded from: classes15.dex */
public final class q extends x {

    /* renamed from: a  reason: collision with root package name */
    protected UnvarnishedMessage f13587a;

    public q() {
        super(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("msg_v1", this.f13587a.unpackToJson());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        String a2 = aVar.a("msg_v1");
        if (!TextUtils.isEmpty(a2)) {
            this.f13587a = new UnvarnishedMessage(a2);
            this.f13587a.setMsgId(f());
        }
    }

    public final String d() {
        if (this.f13587a == null) {
            return null;
        }
        return this.f13587a.unpackToJson();
    }

    public final UnvarnishedMessage e() {
        return this.f13587a;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnMessageCommand";
    }
}
