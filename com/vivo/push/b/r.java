package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes3.dex */
public final class r extends com.vivo.push.y {

    /* renamed from: a  reason: collision with root package name */
    private String f13885a;

    /* renamed from: b  reason: collision with root package name */
    private long f13886b;
    private InsideNotificationItem c;

    public r(String str, long j, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.f13885a = str;
        this.f13886b = j;
        this.c = insideNotificationItem;
    }

    public r() {
        super(5);
    }

    public final String d() {
        return this.f13885a;
    }

    public final long e() {
        return this.f13886b;
    }

    public final InsideNotificationItem f() {
        return this.c;
    }

    @Override // com.vivo.push.y
    protected final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.f13885a);
        aVar.a("notify_id", this.f13886b);
        aVar.a("notification_v1", com.vivo.push.util.q.b(this.c));
    }

    @Override // com.vivo.push.y
    protected final void d(com.vivo.push.a aVar) {
        this.f13885a = aVar.a("package_name");
        this.f13886b = aVar.b("notify_id", -1L);
        String a2 = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(a2)) {
            this.c = com.vivo.push.util.q.a(a2);
        }
        if (this.c != null) {
            this.c.setMsgId(this.f13886b);
        }
    }

    @Override // com.vivo.push.y
    public final String toString() {
        return "OnNotificationClickCommand";
    }
}
