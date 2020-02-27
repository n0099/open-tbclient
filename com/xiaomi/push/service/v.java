package com.xiaomi.push.service;

import android.content.Context;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.xiaomi.push.fx;
import com.xiaomi.push.ic;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes8.dex */
final class v extends XMPushService.i {
    final /* synthetic */ ic a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f935a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f936a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(int i, XMPushService xMPushService, ic icVar, String str, String str2) {
        super(i);
        this.f935a = xMPushService;
        this.a = icVar;
        this.f936a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        return "send wrong message ack for message.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            ic a = p.a((Context) this.f935a, this.a);
            a.f612a.a(BdStatsConstant.StatsType.ERROR, this.f936a);
            a.f612a.a(TiebaInitialize.LogFields.REASON, this.b);
            w.a(this.f935a, a);
        } catch (fx e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.f935a.a(10, e);
        }
    }
}
