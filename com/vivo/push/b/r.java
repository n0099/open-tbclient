package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes11.dex */
public final class r extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    private String f4418a;
    private long b;
    private InsideNotificationItem c;

    public r(String str, long j, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.f4418a = str;
        this.b = j;
        this.c = insideNotificationItem;
    }

    public r() {
        super(5);
    }

    public final String d() {
        return this.f4418a;
    }

    public final long e() {
        return this.b;
    }

    public final InsideNotificationItem f() {
        return this.c;
    }

    @Override // com.vivo.push.y
    protected final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f4418a);
        aVar.a("notify_id", this.b);
        aVar.a("notification_v1", com.vivo.push.util.q.b(this.c));
    }

    @Override // com.vivo.push.y
    protected final void d(com.vivo.push.a aVar) {
        this.f4418a = aVar.a("package_name");
        this.b = aVar.b("notify_id", -1L);
        String a2 = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(a2)) {
            this.c = com.vivo.push.util.q.a(a2);
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
