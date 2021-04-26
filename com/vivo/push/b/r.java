package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes6.dex */
public final class r extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f37379a;

    /* renamed from: b  reason: collision with root package name */
    public long f37380b;

    /* renamed from: c  reason: collision with root package name */
    public InsideNotificationItem f37381c;

    public r(String str, long j, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.f37379a = str;
        this.f37380b = j;
        this.f37381c = insideNotificationItem;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f37379a);
        aVar.a("notify_id", this.f37380b);
        aVar.a("notification_v1", com.vivo.push.util.q.b(this.f37381c));
    }

    public final String d() {
        return this.f37379a;
    }

    public final long e() {
        return this.f37380b;
    }

    public final InsideNotificationItem f() {
        return this.f37381c;
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f37379a = aVar.a("package_name");
        this.f37380b = aVar.b("notify_id", -1L);
        String a2 = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(a2)) {
            this.f37381c = com.vivo.push.util.q.a(a2);
        }
        InsideNotificationItem insideNotificationItem = this.f37381c;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.f37380b);
        }
    }

    public r() {
        super(5);
    }
}
