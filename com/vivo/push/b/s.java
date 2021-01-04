package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes3.dex */
public final class s extends x {

    /* renamed from: a  reason: collision with root package name */
    protected InsideNotificationItem f13887a;

    /* renamed from: b  reason: collision with root package name */
    private String f13888b;

    public s() {
        super(4);
    }

    public final InsideNotificationItem d() {
        return this.f13887a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        this.f13888b = com.vivo.push.util.q.b(this.f13887a);
        aVar.a("notification_v1", this.f13888b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f13888b = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(this.f13888b)) {
            this.f13887a = com.vivo.push.util.q.a(this.f13888b);
            if (this.f13887a != null) {
                this.f13887a.setMsgId(f());
            }
        }
    }

    public final String e() {
        if (TextUtils.isEmpty(this.f13888b)) {
            if (this.f13887a == null) {
                return null;
            }
            return com.vivo.push.util.q.b(this.f13887a);
        }
        return this.f13888b;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }
}
