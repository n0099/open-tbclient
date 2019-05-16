package com.vivo.push.b;

import android.content.Intent;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public final class j extends s {
    private String a;
    private String b;
    private String c;

    public j(int i) {
        super(i);
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void d(Intent intent) {
        super.d(intent);
        intent.putExtra(Constants.APP_ID, this.a);
        intent.putExtra("client_id", this.b);
        intent.putExtra("client_token", this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final void e(Intent intent) {
        super.e(intent);
        this.a = intent.getStringExtra(Constants.APP_ID);
        this.b = intent.getStringExtra("client_id");
        this.c = intent.getStringExtra("client_token");
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnBindCommand";
    }
}
