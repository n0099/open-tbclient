package com.xiaomi.push.service;

import android.content.Context;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.xiaomi.push.gd;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes9.dex */
final class v extends XMPushService.i {
    final /* synthetic */ ii a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f938a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f939a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(int i, XMPushService xMPushService, ii iiVar, String str, String str2) {
        super(i);
        this.f938a = xMPushService;
        this.a = iiVar;
        this.f939a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send wrong message ack for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ii a = p.a((Context) this.f938a, this.a);
            a.f604a.a(BdStatsConstant.StatsType.ERROR, this.f939a);
            a.f604a.a(TiebaInitialize.LogFields.REASON, this.b);
            w.a(this.f938a, a);
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f938a.a(10, e);
        }
    }
}
