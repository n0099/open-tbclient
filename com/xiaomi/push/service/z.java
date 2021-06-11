package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.hf;
import com.xiaomi.push.hp;
import com.xiaomi.push.ie;
import com.xiaomi.push.ip;
import com.xiaomi.push.service.bk;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class z extends bk.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f41853a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ l f981a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(String str, long j, XMPushService xMPushService, l lVar) {
        super(str, j);
        this.f41853a = xMPushService;
        this.f981a = lVar;
    }

    @Override // com.xiaomi.push.service.bk.a
    public void a(bk bkVar) {
        String a2 = bkVar.a("GAID", "gaid");
        String a3 = com.xiaomi.push.i.a((Context) this.f41853a);
        com.xiaomi.channel.commonutils.logger.b.c("gaid :" + a3);
        if (TextUtils.isEmpty(a3) || TextUtils.equals(a2, a3)) {
            return;
        }
        bkVar.a("GAID", "gaid", a3);
        ie ieVar = new ie();
        ieVar.b(this.f981a.f41830d);
        ieVar.c(hp.ClientInfoUpdate.f506a);
        ieVar.a(at.a());
        ieVar.a(new HashMap());
        ieVar.m452a().put("gaid", a3);
        byte[] a4 = ip.a(y.a(this.f41853a.getPackageName(), this.f981a.f41830d, ieVar, hf.Notification));
        XMPushService xMPushService = this.f41853a;
        xMPushService.a(xMPushService.getPackageName(), a4, true);
    }
}
