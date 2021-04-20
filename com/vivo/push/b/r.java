package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes7.dex */
public final class r extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f39681a;

    /* renamed from: b  reason: collision with root package name */
    public long f39682b;

    /* renamed from: c  reason: collision with root package name */
    public InsideNotificationItem f39683c;

    public r(String str, long j, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.f39681a = str;
        this.f39682b = j;
        this.f39683c = insideNotificationItem;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f39681a);
        aVar.a("notify_id", this.f39682b);
        aVar.a("notification_v1", com.vivo.push.util.q.b(this.f39683c));
    }

    public final String d() {
        return this.f39681a;
    }

    public final long e() {
        return this.f39682b;
    }

    public final InsideNotificationItem f() {
        return this.f39683c;
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f39681a = aVar.a("package_name");
        this.f39682b = aVar.b("notify_id", -1L);
        String a2 = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(a2)) {
            this.f39683c = com.vivo.push.util.q.a(a2);
        }
        InsideNotificationItem insideNotificationItem = this.f39683c;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.f39682b);
        }
    }

    public r() {
        super(5);
    }
}
