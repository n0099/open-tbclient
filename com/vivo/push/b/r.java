package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes7.dex */
public final class r extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f39392a;

    /* renamed from: b  reason: collision with root package name */
    public long f39393b;

    /* renamed from: c  reason: collision with root package name */
    public InsideNotificationItem f39394c;

    public r(String str, long j, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.f39392a = str;
        this.f39393b = j;
        this.f39394c = insideNotificationItem;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f39392a);
        aVar.a("notify_id", this.f39393b);
        aVar.a("notification_v1", com.vivo.push.util.q.b(this.f39394c));
    }

    public final String d() {
        return this.f39392a;
    }

    public final long e() {
        return this.f39393b;
    }

    public final InsideNotificationItem f() {
        return this.f39394c;
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f39392a = aVar.a("package_name");
        this.f39393b = aVar.b("notify_id", -1L);
        String a2 = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(a2)) {
            this.f39394c = com.vivo.push.util.q.a(a2);
        }
        InsideNotificationItem insideNotificationItem = this.f39394c;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.f39393b);
        }
    }

    public r() {
        super(5);
    }
}
