package com.vivo.push.b;

import android.content.Intent;
/* loaded from: classes3.dex */
public final class i extends com.vivo.push.v {
    private String a;

    public i() {
        super(2013);
    }

    public i(String str) {
        this();
        this.a = str;
    }

    @Override // com.vivo.push.v
    protected final void d(Intent intent) {
        intent.putExtra("MsgArriveCommand.MSG_TAG", this.a);
    }

    @Override // com.vivo.push.v
    protected final void e(Intent intent) {
        this.a = intent.getStringExtra("MsgArriveCommand.MSG_TAG");
    }
}
