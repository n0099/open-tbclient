package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.hh;
import com.xiaomi.push.hr;
import com.xiaomi.push.ig;
import com.xiaomi.push.ir;
import com.xiaomi.push.service.bx;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class ai extends bx.a {
    public final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ t f888a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(String str, long j, XMPushService xMPushService, t tVar) {
        super(str, j);
        this.a = xMPushService;
        this.f888a = tVar;
    }

    @Override // com.xiaomi.push.service.bx.a
    public void a(bx bxVar) {
        com.xiaomi.push.az a = com.xiaomi.push.az.a(this.a);
        String a2 = bxVar.a("MSAID", "msaid");
        String mo267a = a.mo267a();
        if (TextUtils.isEmpty(mo267a) || TextUtils.equals(a2, mo267a)) {
            return;
        }
        bxVar.a("MSAID", "msaid", mo267a);
        ig igVar = new ig();
        igVar.b(this.f888a.d);
        igVar.c(hr.ClientInfoUpdate.f508a);
        igVar.a(bd.a());
        igVar.a(new HashMap());
        a.a(igVar.m642a());
        byte[] a3 = ir.a(ah.a(this.a.getPackageName(), this.f888a.d, igVar, hh.Notification));
        XMPushService xMPushService = this.a;
        xMPushService.a(xMPushService.getPackageName(), a3, true);
    }
}
