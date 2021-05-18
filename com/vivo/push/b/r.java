package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes7.dex */
public final class r extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f36624a;

    /* renamed from: b  reason: collision with root package name */
    public long f36625b;

    /* renamed from: c  reason: collision with root package name */
    public InsideNotificationItem f36626c;

    public r(String str, long j, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.f36624a = str;
        this.f36625b = j;
        this.f36626c = insideNotificationItem;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f36624a);
        aVar.a("notify_id", this.f36625b);
        aVar.a("notification_v1", com.vivo.push.util.q.b(this.f36626c));
    }

    public final String d() {
        return this.f36624a;
    }

    public final long e() {
        return this.f36625b;
    }

    public final InsideNotificationItem f() {
        return this.f36626c;
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f36624a = aVar.a("package_name");
        this.f36625b = aVar.b("notify_id", -1L);
        String a2 = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(a2)) {
            this.f36626c = com.vivo.push.util.q.a(a2);
        }
        InsideNotificationItem insideNotificationItem = this.f36626c;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.f36625b);
        }
    }

    public r() {
        super(5);
    }
}
