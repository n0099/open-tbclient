package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes7.dex */
public final class r extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f39391a;

    /* renamed from: b  reason: collision with root package name */
    public long f39392b;

    /* renamed from: c  reason: collision with root package name */
    public InsideNotificationItem f39393c;

    public r(String str, long j, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.f39391a = str;
        this.f39392b = j;
        this.f39393c = insideNotificationItem;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f39391a);
        aVar.a("notify_id", this.f39392b);
        aVar.a("notification_v1", com.vivo.push.util.q.b(this.f39393c));
    }

    public final String d() {
        return this.f39391a;
    }

    public final long e() {
        return this.f39392b;
    }

    public final InsideNotificationItem f() {
        return this.f39393c;
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f39391a = aVar.a("package_name");
        this.f39392b = aVar.b("notify_id", -1L);
        String a2 = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(a2)) {
            this.f39393c = com.vivo.push.util.q.a(a2);
        }
        InsideNotificationItem insideNotificationItem = this.f39393c;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.f39392b);
        }
    }

    public r() {
        super(5);
    }
}
