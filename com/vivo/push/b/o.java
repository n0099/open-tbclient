package com.vivo.push.b;

import android.content.Intent;
import android.text.TextUtils;
import com.vivo.push.model.UnvarnishedMessage;
/* loaded from: classes3.dex */
public final class o extends v {
    protected UnvarnishedMessage a;

    public o() {
        super(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    public final void d(Intent intent) {
        super.d(intent);
        intent.putExtra("msg_v1", this.a.unpackToJson());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    public final void e(Intent intent) {
        super.e(intent);
        String stringExtra = intent.getStringExtra("msg_v1");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.a = new UnvarnishedMessage(stringExtra);
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

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnMessageCommand";
    }
}
