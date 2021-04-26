package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes6.dex */
public final class s extends x {

    /* renamed from: a  reason: collision with root package name */
    public InsideNotificationItem f37382a;

    /* renamed from: b  reason: collision with root package name */
    public String f37383b;

    public s() {
        super(4);
    }

    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        String b2 = com.vivo.push.util.q.b(this.f37382a);
        this.f37383b = b2;
        aVar.a("notification_v1", b2);
    }

    public final InsideNotificationItem d() {
        return this.f37382a;
    }

    public final String e() {
        if (TextUtils.isEmpty(this.f37383b)) {
            InsideNotificationItem insideNotificationItem = this.f37382a;
            if (insideNotificationItem == null) {
                return null;
            }
            return com.vivo.push.util.q.b(insideNotificationItem);
        }
        return this.f37383b;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }

    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        String a2 = aVar.a("notification_v1");
        this.f37383b = a2;
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        InsideNotificationItem a3 = com.vivo.push.util.q.a(this.f37383b);
        this.f37382a = a3;
        if (a3 != null) {
            a3.setMsgId(f());
        }
    }
}
