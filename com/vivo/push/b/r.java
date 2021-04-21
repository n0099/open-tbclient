package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes7.dex */
public final class r extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f39776a;

    /* renamed from: b  reason: collision with root package name */
    public long f39777b;

    /* renamed from: c  reason: collision with root package name */
    public InsideNotificationItem f39778c;

    public r(String str, long j, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.f39776a = str;
        this.f39777b = j;
        this.f39778c = insideNotificationItem;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f39776a);
        aVar.a("notify_id", this.f39777b);
        aVar.a("notification_v1", com.vivo.push.util.q.b(this.f39778c));
    }

    public final String d() {
        return this.f39776a;
    }

    public final long e() {
        return this.f39777b;
    }

    public final InsideNotificationItem f() {
        return this.f39778c;
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f39776a = aVar.a("package_name");
        this.f39777b = aVar.b("notify_id", -1L);
        String a2 = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(a2)) {
            this.f39778c = com.vivo.push.util.q.a(a2);
        }
        InsideNotificationItem insideNotificationItem = this.f39778c;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.f39777b);
        }
    }

    public r() {
        super(5);
    }
}
