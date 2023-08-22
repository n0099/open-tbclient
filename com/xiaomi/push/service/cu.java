package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.fw;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes10.dex */
public class cu extends XMPushService.j {
    public final /* synthetic */ XMPushService a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f976a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ byte[] f977a;
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cu(XMPushService xMPushService, int i, int i2, String str, byte[] bArr) {
        super(i);
        this.a = xMPushService;
        this.b = i2;
        this.f976a = str;
        this.f977a = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public String mo755a() {
        return "clear account cache.";
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    /* renamed from: a */
    public void mo472a() {
        fw fwVar;
        u.m838a((Context) this.a);
        bg.a().m796a("5");
        com.xiaomi.push.ab.a(this.b);
        fwVar = this.a.f848a;
        fwVar.c(fw.a());
        com.xiaomi.channel.commonutils.logger.b.m180a("clear account and start registration. " + this.f976a);
        this.a.a(this.f977a, this.f976a);
    }
}
