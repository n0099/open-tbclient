package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.iq;
import com.xiaomi.push.service.bc;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class x extends bc.a {
    final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ k f936a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(String str, long j, XMPushService xMPushService, k kVar) {
        super(str, j);
        this.a = xMPushService;
        this.f936a = kVar;
    }

    @Override // com.xiaomi.push.service.bc.a
    void a(bc bcVar) {
        String a = bcVar.a("GAID", "gaid");
        String b = com.xiaomi.push.i.b((Context) this.a);
        com.xiaomi.channel.commonutils.logger.b.c("gaid :" + b);
        if (TextUtils.isEmpty(b) || TextUtils.equals(a, b)) {
            return;
        }
        bcVar.a("GAID", "gaid", b);
        Cif cif = new Cif();
        cif.b(this.f936a.d);
        cif.c(hq.ClientInfoUpdate.f489a);
        cif.a(aj.a());
        cif.a(new HashMap());
        cif.m414a().put("gaid", b);
        this.a.a(this.a.getPackageName(), iq.a(w.a(this.a.getPackageName(), this.f936a.d, cif, hg.Notification)), true);
    }
}
