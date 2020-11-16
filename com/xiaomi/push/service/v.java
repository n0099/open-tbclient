package com.xiaomi.push.service;

import android.content.Context;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.xiaomi.push.gd;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes18.dex */
final class v extends XMPushService.i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ii f5120a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f936a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f937a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(int i, XMPushService xMPushService, ii iiVar, String str, String str2) {
        super(i);
        this.f936a = xMPushService;
        this.f5120a = iiVar;
        this.f937a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send wrong message ack for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ii a2 = p.a((Context) this.f936a, this.f5120a);
            a2.f602a.a(BdStatsConstant.StatsType.ERROR, this.f937a);
            a2.f602a.a(TiebaInitialize.LogFields.REASON, this.b);
            w.a(this.f936a, a2);
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f936a.a(10, e);
        }
    }
}
