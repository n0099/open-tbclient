package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes7.dex */
public final class r extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f40335a;

    /* renamed from: b  reason: collision with root package name */
    public long f40336b;

    /* renamed from: c  reason: collision with root package name */
    public InsideNotificationItem f40337c;

    public r(String str, long j, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.f40335a = str;
        this.f40336b = j;
        this.f40337c = insideNotificationItem;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f40335a);
        aVar.a("notify_id", this.f40336b);
        aVar.a("notification_v1", com.vivo.push.util.q.b(this.f40337c));
    }

    public final String d() {
        return this.f40335a;
    }

    public final long e() {
        return this.f40336b;
    }

    public final InsideNotificationItem f() {
        return this.f40337c;
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f40335a = aVar.a("package_name");
        this.f40336b = aVar.b("notify_id", -1L);
        String a2 = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(a2)) {
            this.f40337c = com.vivo.push.util.q.a(a2);
        }
        InsideNotificationItem insideNotificationItem = this.f40337c;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.f40336b);
        }
    }

    public r() {
        super(5);
    }
}
