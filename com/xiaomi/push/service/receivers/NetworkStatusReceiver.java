package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.COSPushHelper;
import com.xiaomi.mipush.sdk.FTOSPushHelper;
import com.xiaomi.mipush.sdk.HWPushHelper;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.ao;
import com.xiaomi.mipush.sdk.ay;
import com.xiaomi.mipush.sdk.bd;
import com.xiaomi.mipush.sdk.d;
import com.xiaomi.push.as;
import com.xiaomi.push.gr;
import com.xiaomi.push.service.ax;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {

    /* renamed from: b  reason: collision with other field name */
    private boolean f929b;
    private static int a = 1;
    private static int b = 1;
    private static int c = 2;

    /* renamed from: a  reason: collision with other field name */
    private static BlockingQueue<Runnable> f926a = new LinkedBlockingQueue();

    /* renamed from: a  reason: collision with other field name */
    private static ThreadPoolExecutor f927a = new ThreadPoolExecutor(a, b, c, TimeUnit.SECONDS, f926a);

    /* renamed from: a  reason: collision with other field name */
    private static boolean f928a = false;

    public NetworkStatusReceiver() {
        this.f929b = false;
        this.f929b = true;
    }

    public NetworkStatusReceiver(Object obj) {
        this.f929b = false;
        f928a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (!ay.a(context).m76a() && d.m85a(context).m94c() && !d.m85a(context).m96e()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                ax.a(context).m525a(intent);
            } catch (Exception e) {
                b.a(e);
            }
        }
        gr.m319a(context);
        if (as.b(context) && ay.a(context).m79b()) {
            ay.a(context).m80c();
        }
        if (as.b(context)) {
            if ("syncing".equals(ao.a(context).a(bd.DISABLE_PUSH))) {
                MiPushClient.disablePush(context);
            }
            if ("syncing".equals(ao.a(context).a(bd.ENABLE_PUSH))) {
                MiPushClient.enablePush(context);
            }
            if ("syncing".equals(ao.a(context).a(bd.UPLOAD_HUAWEI_TOKEN))) {
                MiPushClient.syncAssemblePushToken(context);
            }
            if ("syncing".equals(ao.a(context).a(bd.UPLOAD_FCM_TOKEN))) {
                MiPushClient.syncAssembleFCMPushToken(context);
            }
            if ("syncing".equals(ao.a(context).a(bd.UPLOAD_COS_TOKEN))) {
                MiPushClient.syncAssembleCOSPushToken(context);
            }
            if ("syncing".equals(ao.a(context).a(bd.UPLOAD_FTOS_TOKEN))) {
                MiPushClient.syncAssembleFTOSPushToken(context);
            }
            if (HWPushHelper.needConnect() && HWPushHelper.shouldTryConnect(context)) {
                HWPushHelper.setConnectTime(context);
                HWPushHelper.registerHuaWeiAssemblePush(context);
            }
            COSPushHelper.doInNetworkChange(context);
            FTOSPushHelper.doInNetworkChange(context);
        }
    }

    public static boolean a() {
        return f928a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f929b) {
            return;
        }
        f927a.execute(new a(this, context));
    }
}
