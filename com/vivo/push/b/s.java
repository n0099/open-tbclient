package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
/* loaded from: classes15.dex */
public final class s extends x {

    /* renamed from: a  reason: collision with root package name */
    protected InsideNotificationItem f13590a;

    /* renamed from: b  reason: collision with root package name */
    private String f13591b;

    public s() {
        super(4);
    }

    public final InsideNotificationItem d() {
        return this.f13590a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        this.f13591b = com.vivo.push.util.q.b(this.f13590a);
        aVar.a("notification_v1", this.f13591b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.x, com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f13591b = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(this.f13591b)) {
            this.f13590a = com.vivo.push.util.q.a(this.f13591b);
            if (this.f13590a != null) {
                this.f13590a.setMsgId(f());
            }
        }
    }

    public final String e() {
        if (TextUtils.isEmpty(this.f13591b)) {
            if (this.f13590a == null) {
                return null;
            }
            return com.vivo.push.util.q.b(this.f13590a);
        }
        return this.f13591b;
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }
}
