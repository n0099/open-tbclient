package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes7.dex */
public final class r extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    public String f36553a;

    /* renamed from: b  reason: collision with root package name */
    public long f36554b;

    /* renamed from: c  reason: collision with root package name */
    public InsideNotificationItem f36555c;

    public r(String str, long j, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.f36553a = str;
        this.f36554b = j;
        this.f36555c = insideNotificationItem;
    }

    @Override // com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f36553a);
        aVar.a("notify_id", this.f36554b);
        aVar.a("notification_v1", com.vivo.push.util.q.b(this.f36555c));
    }

    public final String d() {
        return this.f36553a;
    }

    public final long e() {
        return this.f36554b;
    }

    public final InsideNotificationItem f() {
        return this.f36555c;
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    @Override // com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        this.f36553a = aVar.a("package_name");
        this.f36554b = aVar.b("notify_id", -1L);
        String a2 = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(a2)) {
            this.f36555c = com.vivo.push.util.q.a(a2);
        }
        InsideNotificationItem insideNotificationItem = this.f36555c;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.f36554b);
        }
    }

    public r() {
        super(5);
    }
}
