package com.xiaomi.mipush.sdk;

import android.content.Context;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        context = MiPushClient.sContext;
        com.xiaomi.push.service.module.c a = com.xiaomi.push.service.module.d.a(context).a(com.xiaomi.push.service.module.e.MODULE_CDATA);
        if (a != null) {
            try {
                Method method = a.a().loadClass("com.xiaomi.push.mpcd.MpcdPlugin").getMethod("main", Context.class);
                context2 = MiPushClient.sContext;
                method.invoke(null, context2);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a("plugin load fail");
            }
        }
    }
}
