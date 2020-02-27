package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes8.dex */
public final class p extends com.vivo.push.y {
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

    @Override // com.vivo.push.y
    protected final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.a);
        aVar.a("notify_id", this.b);
        aVar.a("notification_v1", com.vivo.push.util.q.b(this.c));
    }

    @Override // com.vivo.push.y
    protected final void d(com.vivo.push.a aVar) {
        this.a = aVar.a("package_name");
        this.b = aVar.b("notify_id", -1L);
        String a = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(a)) {
            this.c = com.vivo.push.util.q.a(a);
        }
        if (this.c != null) {
            this.c.setMsgId(this.b);
        }
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "OnNotificationClickCommand";
    }
}
