package com.vivo.push.b;

import android.content.Intent;
/* loaded from: classes3.dex */
public class s extends com.vivo.push.v {
    private String a;
    private int b;

    public s(int i) {
        super(i);
        this.a = null;
        this.b = 0;
    }

    public final String g() {
        return this.a;
    }

    public final int h() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.v
    public void d(Intent intent) {
        intent.putExtra("req_id", this.a);
        intent.putExtra("status_msg_code", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.v
    public void e(Intent intent) {
        this.a = intent.getStringExtra("req_id");
        this.b = intent.getIntExtra("status_msg_code", this.b);
    }

    @Override // com.vivo.push.v
    public String toString() {
        return "OnReceiveCommand";
    }
}
