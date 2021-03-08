package com.xiaomi.push.service;

import android.content.Context;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.xiaomi.push.gd;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes5.dex */
final class v extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ii f8583a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f933a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f934a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(int i, XMPushService xMPushService, ii iiVar, String str, String str2) {
        super(i);
        this.f933a = xMPushService;
        this.f8583a = iiVar;
        this.f934a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send wrong message ack for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ii a2 = p.a((Context) this.f933a, this.f8583a);
            a2.f599a.a(BdStatsConstant.StatsType.ERROR, this.f934a);
            a2.f599a.a(TiebaInitialize.LogFields.REASON, this.b);
            w.a(this.f933a, a2);
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f933a.a(10, e);
        }
    }
}
