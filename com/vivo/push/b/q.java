package com.vivo.push.b;

import android.content.Intent;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes3.dex */
public final class q extends v {
    protected InsideNotificationItem a;
    private String b;

    public q() {
        super(4);
    }

    public final InsideNotificationItem d() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    public final void d(Intent intent) {
        super.d(intent);
        this.b = com.vivo.push.util.n.b(this.a);
        intent.putExtra("notification_v1", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    public final void e(Intent intent) {
        super.e(intent);
        this.b = intent.getStringExtra("notification_v1");
        if (!TextUtils.isEmpty(this.b)) {
            this.a = com.vivo.push.util.n.a(this.b);
            this.a.setMsgId(f());
        }
    }

    public final String e() {
        if (TextUtils.isEmpty(this.b)) {
            if (this.a == null) {
                return null;
            }
            return com.vivo.push.util.n.b(this.a);
        }
        return this.b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }
}
