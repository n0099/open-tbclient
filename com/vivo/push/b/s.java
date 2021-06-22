package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes7.dex */
public final class s extends x {

    /* renamed from: a  reason: collision with root package name */
    public InsideNotificationItem f40338a;

    /* renamed from: b  reason: collision with root package name */
    public String f40339b;

    public s() {
        super(4);
    }

    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        String b2 = com.vivo.push.util.q.b(this.f40338a);
        this.f40339b = b2;
        aVar.a("notification_v1", b2);
    }

    public final InsideNotificationItem d() {
        return this.f40338a;
    }

    public final String e() {
        if (TextUtils.isEmpty(this.f40339b)) {
            InsideNotificationItem insideNotificationItem = this.f40338a;
            if (insideNotificationItem == null) {
                return null;
            }
            return com.vivo.push.util.q.b(insideNotificationItem);
        }
        return this.f40339b;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }

    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        String a2 = aVar.a("notification_v1");
        this.f40339b = a2;
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        InsideNotificationItem a3 = com.vivo.push.util.q.a(this.f40339b);
        this.f40338a = a3;
        if (a3 != null) {
            a3.setMsgId(f());
        }
    }
}
