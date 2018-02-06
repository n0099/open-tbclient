package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.xiaomi.channel.commonutils.misc.f;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.ai;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.aq;
/* loaded from: classes2.dex */
public class o extends f.a {
    private Context a;

    public o(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.channel.commonutils.misc.f.a
    public int a() {
        return 2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ah a = ah.a(this.a);
        com.xiaomi.xmpush.thrift.y yVar = new com.xiaomi.xmpush.thrift.y();
        yVar.a(ai.a(a, com.xiaomi.xmpush.thrift.f.MISC_CONFIG));
        yVar.b(ai.a(a, com.xiaomi.xmpush.thrift.f.PLUGIN_CONFIG));
        ae aeVar = new ae(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, false);
        aeVar.c(com.xiaomi.xmpush.thrift.o.DailyCheckClientConfig.N);
        aeVar.a(aq.a(yVar));
        u.a(this.a).a((u) aeVar, com.xiaomi.xmpush.thrift.a.Notification, (com.xiaomi.xmpush.thrift.r) null);
    }
}
