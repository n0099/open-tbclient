package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes7.dex */
public final class r extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f40232a;

    /* renamed from: b  reason: collision with root package name */
    public long f40233b;

    /* renamed from: c  reason: collision with root package name */
    public InsideNotificationItem f40234c;

    public r(String str, long j, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.f40232a = str;
        this.f40233b = j;
        this.f40234c = insideNotificationItem;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f40232a);
        aVar.a("notify_id", this.f40233b);
        aVar.a("notification_v1", com.vivo.push.util.q.b(this.f40234c));
    }

    public final String d() {
        return this.f40232a;
    }

    public final long e() {
        return this.f40233b;
    }

    public final InsideNotificationItem f() {
        return this.f40234c;
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f40232a = aVar.a("package_name");
        this.f40233b = aVar.b("notify_id", -1L);
        String a2 = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(a2)) {
            this.f40234c = com.vivo.push.util.q.a(a2);
        }
        InsideNotificationItem insideNotificationItem = this.f40234c;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.f40233b);
        }
    }

    public r() {
        super(5);
    }
}
