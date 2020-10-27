package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes15.dex */
public final class s extends x {

    /* renamed from: a  reason: collision with root package name */
    protected InsideNotificationItem f4647a;
    private String b;

    public s() {
        super(4);
    }

    public final InsideNotificationItem d() {
        return this.f4647a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        this.b = com.vivo.push.util.q.b(this.f4647a);
        aVar.a("notification_v1", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.b = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(this.b)) {
            this.f4647a = com.vivo.push.util.q.a(this.b);
            if (this.f4647a != null) {
                this.f4647a.setMsgId(f());
            }
        }
    }

    public final String e() {
        if (TextUtils.isEmpty(this.b)) {
            if (this.f4647a == null) {
                return null;
            }
            return com.vivo.push.util.q.b(this.f4647a);
        }
        return this.b;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }
}
