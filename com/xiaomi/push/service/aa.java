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
    public final /* synthetic */ XMPushService f40931a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ l f868a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(String str, long j, XMPushService xMPushService, l lVar) {
        super(str, j);
        this.f40931a = xMPushService;
        this.f868a = lVar;
    }

    @Override // com.xiaomi.push.service.bk.a
    public void a(bk bkVar) {
        com.xiaomi.push.ax a2 = com.xiaomi.push.ax.a(this.f40931a);
        String a3 = bkVar.a("MSAID", "msaid");
        String str = a2.a() + a2.mo130b() + a2.c() + a2.d();
        if (TextUtils.isEmpty(str) || TextUtils.equals(a3, str)) {
            return;
        }
        bkVar.a("MSAID", "msaid", str);
        ie ieVar = new ie();
        ieVar.b(this.f868a.f41046d);
        ieVar.c(hp.ClientInfoUpdate.f506a);
        ieVar.a(at.a());
        ieVar.a(new HashMap());
        a2.a(ieVar.m447a());
        byte[] a4 = ip.a(y.a(this.f40931a.getPackageName(), this.f868a.f41046d, ieVar, hf.Notification));
        XMPushService xMPushService = this.f40931a;
        xMPushService.a(xMPushService.getPackageName(), a4, true);
    }
}
