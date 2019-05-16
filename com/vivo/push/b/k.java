package com.vivo.push.b;

import android.content.Intent;
/* loaded from: classes3.dex */
public final class k extends s {
    private int a;
    private int b;

    public k() {
        super(12);
        this.a = -1;
        this.b = -1;
    }

    public final int d() {
        return this.a;
    }

    public final int e() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void d(Intent intent) {
        super.d(intent);
        intent.putExtra("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.a);
        intent.putExtra("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void e(Intent intent) {
        super.e(intent);
        this.a = intent.getIntExtra("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.a);
        this.b = intent.getIntExtra("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.b);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnChangePushStatusCommand";
    }
}
