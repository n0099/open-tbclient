package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fc;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.bb;
/* loaded from: classes9.dex */
public class PingReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        b.c(intent.getPackage() + " is the package name");
        if (!at.o.equals(intent.getAction())) {
            b.m54a("cancel the old ping timer");
            fc.a();
        } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
            b.c("Ping XMChannelService on timer");
            try {
                Intent intent2 = new Intent(context, XMPushService.class);
                intent2.putExtra(ETAG.KEY_TIME_STAMP, System.currentTimeMillis());
                intent2.setAction("com.xiaomi.push.timer");
                bb.a(context).m558a(intent2);
            } catch (Exception e) {
                b.a(e);
            }
        }
    }
}
