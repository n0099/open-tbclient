package com.xiaomi.push.service;

import android.content.Context;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.xiaomi.push.service.XMPushService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ad extends XMPushService.i {
    final /* synthetic */ XMPushService b;
    final /* synthetic */ com.xiaomi.xmpush.thrift.af c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(int i, XMPushService xMPushService, com.xiaomi.xmpush.thrift.af afVar, String str, String str2) {
        super(i);
        this.b = xMPushService;
        this.c = afVar;
        this.d = str;
        this.e = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        try {
            com.xiaomi.xmpush.thrift.af a = x.a((Context) this.b, this.c);
            a.h.a(BdStatsConstant.StatsType.ERROR, this.d);
            a.h.a(TiebaInitialize.LogFields.REASON, this.e);
            af.a(this.b, a);
        } catch (com.xiaomi.smack.l e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            this.b.a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "send wrong message ack for message.";
    }
}
