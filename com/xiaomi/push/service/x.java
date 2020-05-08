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
/* loaded from: classes8.dex */
public final class x extends bg.a {
    final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ k f934a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(String str, long j, XMPushService xMPushService, k kVar) {
        super(str, j);
        this.a = xMPushService;
        this.f934a = kVar;
    }

    @Override // com.xiaomi.push.service.bg.a
    void a(bg bgVar) {
        String a = bgVar.a("GAID", "gaid");
        String b = com.xiaomi.push.i.b((Context) this.a);
        com.xiaomi.channel.commonutils.logger.b.c("gaid :" + b);
        if (TextUtils.isEmpty(b) || TextUtils.equals(a, b)) {
            return;
        }
        bgVar.a("GAID", "gaid", b);
        il ilVar = new il();
        ilVar.b(this.f934a.d);
        ilVar.c(hw.ClientInfoUpdate.f475a);
        ilVar.a(an.a());
        ilVar.a(new HashMap());
        ilVar.m429a().put("gaid", b);
        this.a.a(this.a.getPackageName(), iw.a(w.a(this.a.getPackageName(), this.f934a.d, ilVar, hm.Notification)), true);
    }
}
