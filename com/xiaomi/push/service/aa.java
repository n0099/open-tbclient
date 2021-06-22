package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.hf;
import com.xiaomi.push.hp;
import com.xiaomi.push.ie;
import com.xiaomi.push.ip;
import com.xiaomi.push.service.bk;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class aa extends bk.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f41816a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ l f868a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(String str, long j, XMPushService xMPushService, l lVar) {
        super(str, j);
        this.f41816a = xMPushService;
        this.f868a = lVar;
    }

    @Override // com.xiaomi.push.service.bk.a
    public void a(bk bkVar) {
        com.xiaomi.push.ax a2 = com.xiaomi.push.ax.a(this.f41816a);
        String a3 = bkVar.a("MSAID", "msaid");
        String str = a2.a() + a2.mo135b() + a2.c() + a2.d();
        if (TextUtils.isEmpty(str) || TextUtils.equals(a3, str)) {
            return;
        }
        bkVar.a("MSAID", "msaid", str);
        ie ieVar = new ie();
        ieVar.b(this.f868a.f41933d);
        ieVar.c(hp.ClientInfoUpdate.f506a);
        ieVar.a(at.a());
        ieVar.a(new HashMap());
        a2.a(ieVar.m452a());
        byte[] a4 = ip.a(y.a(this.f41816a.getPackageName(), this.f868a.f41933d, ieVar, hf.Notification));
        XMPushService xMPushService = this.f41816a;
        xMPushService.a(xMPushService.getPackageName(), a4, true);
    }
}
