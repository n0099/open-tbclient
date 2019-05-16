package com.vivo.push.b;

import android.content.Intent;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public final class p extends com.vivo.push.v {
    private String a;
    private long b;
    private InsideNotificationItem c;

    public p(String str, long j, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.a = str;
        this.b = j;
        this.c = insideNotificationItem;
    }

    public p() {
        super(5);
    }

    public final String d() {
        return this.a;
    }

    public final long e() {
        return this.b;
    }

    public final InsideNotificationItem f() {
        return this.c;
    }

    @Override // com.vivo.push.v
    protected final void d(Intent intent) {
        intent.putExtra(Constants.PACKAGE_NAME, this.a);
        intent.putExtra("notify_id", this.b);
        intent.putExtra("notification_v1", com.vivo.push.util.n.b(this.c));
    }

    @Override // com.vivo.push.v
    protected final void e(Intent intent) {
        this.a = intent.getStringExtra(Constants.PACKAGE_NAME);
        this.b = intent.getLongExtra("notify_id", -1L);
        String stringExtra = intent.getStringExtra("notification_v1");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.c = com.vivo.push.util.n.a(stringExtra);
        }
        if (this.c != null) {
            this.c.setMsgId(this.b);
        }
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "OnNotificationClickCommand";
    }
}
