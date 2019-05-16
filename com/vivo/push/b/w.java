package com.vivo.push.b;

import android.content.Intent;
/* loaded from: classes3.dex */
public final class w extends com.vivo.push.v {
    private int a;

    public w() {
        super(2011);
        this.a = 0;
    }

    public final int d() {
        return this.a;
    }

    public final void a(int i) {
        this.a = i;
    }

    @Override // com.vivo.push.v
    protected final void d(Intent intent) {
        intent.putExtra("com.bbk.push.ikey.MODE_TYPE", this.a);
    }

    @Override // com.vivo.push.v
    protected final void e(Intent intent) {
        this.a = intent.getIntExtra("com.bbk.push.ikey.MODE_TYPE", 0);
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "PushModeCommand";
    }

    @Override // com.vivo.push.v
    public final boolean c() {
        return true;
    }
}
