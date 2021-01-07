package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.push.hm;
import com.xiaomi.push.hw;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import com.xiaomi.push.service.bg;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class y extends bg.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f14625a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ k f1016a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(String str, long j, XMPushService xMPushService, k kVar) {
        super(str, j);
        this.f14625a = xMPushService;
        this.f1016a = kVar;
    }

    @Override // com.xiaomi.push.service.bg.a
    void a(bg bgVar) {
        com.xiaomi.push.au a2 = com.xiaomi.push.au.a(this.f14625a);
        String a3 = bgVar.a("MSAID", "msaid");
        String str = a2.a() + a2.mo165b() + a2.c() + a2.d();
        if (TextUtils.isEmpty(str) || TextUtils.equals(a3, str)) {
            return;
        }
        bgVar.a("MSAID", "msaid", str);
        il ilVar = new il();
        ilVar.b(this.f1016a.d);
        ilVar.c(hw.ClientInfoUpdate.f556a);
        ilVar.a(an.a());
        ilVar.a(new HashMap());
        a2.a(ilVar.m463a());
        this.f14625a.a(this.f14625a.getPackageName(), iw.a(w.a(this.f14625a.getPackageName(), this.f1016a.d, ilVar, hm.Notification)), true);
    }
}
