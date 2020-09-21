package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.hm;
import com.xiaomi.push.hw;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import com.xiaomi.push.service.bg;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class y extends bg.a {
    final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ k f936a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(String str, long j, XMPushService xMPushService, k kVar) {
        super(str, j);
        this.a = xMPushService;
        this.f936a = kVar;
    }

    @Override // com.xiaomi.push.service.bg.a
    void a(bg bgVar) {
        com.xiaomi.push.au a = com.xiaomi.push.au.a(this.a);
        String a2 = bgVar.a("MSAID", "msaid");
        String str = a.a() + a.mo135b() + a.c() + a.d();
        if (TextUtils.isEmpty(str) || TextUtils.equals(a2, str)) {
            return;
        }
        bgVar.a("MSAID", "msaid", str);
        il ilVar = new il();
        ilVar.b(this.f936a.d);
        ilVar.c(hw.ClientInfoUpdate.f476a);
        ilVar.a(an.a());
        ilVar.a(new HashMap());
        a.a(ilVar.m433a());
        this.a.a(this.a.getPackageName(), iw.a(w.a(this.a.getPackageName(), this.f936a.d, ilVar, hm.Notification)), true);
    }
}
