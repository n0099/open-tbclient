package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.xiaomi.channel.commonutils.misc.h;
/* loaded from: classes3.dex */
public class ao extends h.a {
    private Context a;

    public ao(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.xiaomi.push.service.an a = com.xiaomi.push.service.an.a(this.a);
        com.xiaomi.xmpush.thrift.ab abVar = new com.xiaomi.xmpush.thrift.ab();
        abVar.a(com.xiaomi.push.service.ao.a(a, com.xiaomi.xmpush.thrift.h.MISC_CONFIG));
        abVar.b(com.xiaomi.push.service.ao.a(a, com.xiaomi.xmpush.thrift.h.PLUGIN_CONFIG));
        com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai(LivenessStat.TYPE_STRING_DEFAULT, false);
        aiVar.c(com.xiaomi.xmpush.thrift.r.DailyCheckClientConfig.aa);
        aiVar.a(com.xiaomi.xmpush.thrift.at.a(abVar));
        az.a(this.a).a((az) aiVar, com.xiaomi.xmpush.thrift.a.Notification, (com.xiaomi.xmpush.thrift.u) null);
    }
}
