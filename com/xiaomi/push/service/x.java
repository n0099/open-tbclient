package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.hm;
import com.xiaomi.push.hw;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import com.xiaomi.push.service.bg;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class x extends bg.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f14623a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ k f1014a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(String str, long j, XMPushService xMPushService, k kVar) {
        super(str, j);
        this.f14623a = xMPushService;
        this.f1014a = kVar;
    }

    @Override // com.xiaomi.push.service.bg.a
    void a(bg bgVar) {
        String a2 = bgVar.a("GAID", "gaid");
        String b2 = com.xiaomi.push.i.b((Context) this.f14623a);
        com.xiaomi.channel.commonutils.logger.b.c("gaid :" + b2);
        if (TextUtils.isEmpty(b2) || TextUtils.equals(a2, b2)) {
            return;
        }
        bgVar.a("GAID", "gaid", b2);
        il ilVar = new il();
        ilVar.b(this.f1014a.d);
        ilVar.c(hw.ClientInfoUpdate.f555a);
        ilVar.a(an.a());
        ilVar.a(new HashMap());
        ilVar.m452a().put("gaid", b2);
        this.f14623a.a(this.f14623a.getPackageName(), iw.a(w.a(this.f14623a.getPackageName(), this.f1014a.d, ilVar, hm.Notification)), true);
    }
}
