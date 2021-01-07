package com.xiaomi.push.service;

import android.content.Context;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.xiaomi.push.gd;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes6.dex */
final class v extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ii f14622a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f1013a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f1014a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f14623b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(int i, XMPushService xMPushService, ii iiVar, String str, String str2) {
        super(i);
        this.f1013a = xMPushService;
        this.f14622a = iiVar;
        this.f1014a = str;
        this.f14623b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send wrong message ack for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ii a2 = p.a((Context) this.f1013a, this.f14622a);
            a2.f679a.a(BdStatsConstant.StatsType.ERROR, this.f1014a);
            a2.f679a.a(TiebaInitialize.LogFields.REASON, this.f14623b);
            w.a(this.f1013a, a2);
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f1013a.a(10, e);
        }
    }
}
