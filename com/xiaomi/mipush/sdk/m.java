package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.xmpush.thrift.ae;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class m implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        context = MiPushClient.sContext;
        if (com.xiaomi.channel.commonutils.android.e.c(context) != null) {
            ae aeVar = new ae();
            context2 = MiPushClient.sContext;
            aeVar.b(a.a(context2).c());
            aeVar.c("client_info_update");
            aeVar.a(MiPushClient.generatePacketID());
            aeVar.a(new HashMap());
            Map<String, String> i = aeVar.i();
            context3 = MiPushClient.sContext;
            i.put(Constants.EXTRA_KEY_IMEI_MD5, com.xiaomi.channel.commonutils.string.d.a(com.xiaomi.channel.commonutils.android.e.c(context3)));
            int b = com.xiaomi.channel.commonutils.android.e.b();
            if (b >= 0) {
                aeVar.i().put("space_id", Integer.toString(b));
            }
            context4 = MiPushClient.sContext;
            u.a(context4).a(aeVar, com.xiaomi.xmpush.thrift.a.Notification, false, null);
        }
    }
}
