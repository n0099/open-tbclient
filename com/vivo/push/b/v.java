package com.vivo.push.b;

import android.content.Intent;
/* loaded from: classes3.dex */
public abstract class v extends s {
    private String a;
    private long b;

    public v(int i) {
        super(i);
    }

    public final long f() {
        return this.b;
    }

    public final String i() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public void d(Intent intent) {
        super.d(intent);
        intent.putExtra("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.a);
        intent.putExtra("notify_id", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public void e(Intent intent) {
        super.e(intent);
        this.a = intent.getStringExtra("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.b = intent.getLongExtra("notify_id", -1L);
    }
}
