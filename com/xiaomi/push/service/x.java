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
/* loaded from: classes12.dex */
public final class x extends bg.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f5119a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ k f933a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(String str, long j, XMPushService xMPushService, k kVar) {
        super(str, j);
        this.f5119a = xMPushService;
        this.f933a = kVar;
    }

    @Override // com.xiaomi.push.service.bg.a
    void a(bg bgVar) {
        String a2 = bgVar.a("GAID", "gaid");
        String b = com.xiaomi.push.i.b((Context) this.f5119a);
        com.xiaomi.channel.commonutils.logger.b.c("gaid :" + b);
        if (TextUtils.isEmpty(b) || TextUtils.equals(a2, b)) {
            return;
        }
        bgVar.a("GAID", "gaid", b);
        il ilVar = new il();
        ilVar.b(this.f933a.d);
        ilVar.c(hw.ClientInfoUpdate.f474a);
        ilVar.a(an.a());
        ilVar.a(new HashMap());
        ilVar.m433a().put("gaid", b);
        this.f5119a.a(this.f5119a.getPackageName(), iw.a(w.a(this.f5119a.getPackageName(), this.f933a.d, ilVar, hm.Notification)), true);
    }
}
