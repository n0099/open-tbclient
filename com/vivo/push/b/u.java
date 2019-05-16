package com.vivo.push.b;

import android.content.Intent;
/* loaded from: classes3.dex */
public final class u extends v {
    private long a;
    private int b;

    public u() {
        super(20);
        this.a = -1L;
    }

    public final long d() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    public final void d(Intent intent) {
        super.d(intent);
        intent.putExtra("undo_msg_v1", this.a);
        intent.putExtra("undo_msg_type_v1", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    public final void e(Intent intent) {
        super.e(intent);
        this.a = intent.getLongExtra("undo_msg_v1", this.a);
        this.b = intent.getIntExtra("undo_msg_type_v1", 0);
    }

    public final String e() {
        if (this.a != -1) {
            return String.valueOf(this.a);
        }
        return null;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnUndoMsgCommand";
    }
}
