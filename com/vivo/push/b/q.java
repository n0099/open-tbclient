package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes3.dex */
public final class q extends v {
    protected InsideNotificationItem a;
    private String b;

    public q() {
        super(4);
    }

    public final InsideNotificationItem d() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        this.b = com.vivo.push.util.q.b(this.a);
        aVar.a("notification_v1", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.b = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(this.b)) {
            this.a = com.vivo.push.util.q.a(this.b);
            if (this.a != null) {
                this.a.setMsgId(f());
            }
        }
    }

    public final String e() {
        if (TextUtils.isEmpty(this.b)) {
            if (this.a == null) {
                return null;
            }
            return com.vivo.push.util.q.b(this.a);
        }
        return this.b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.y
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }
}
