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
/* loaded from: classes5.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {

    /* renamed from: b  reason: collision with other field name */
    private boolean f933b;
    private static int a = 1;
    private static int b = 1;
    private static int c = 2;

    /* renamed from: a  reason: collision with other field name */
    private static BlockingQueue<Runnable> f930a = new LinkedBlockingQueue();

    /* renamed from: a  reason: collision with other field name */
    private static ThreadPoolExecutor f931a = new ThreadPoolExecutor(a, b, c, TimeUnit.SECONDS, f930a);

    /* renamed from: a  reason: collision with other field name */
    private static boolean f932a = false;

    public NetworkStatusReceiver() {
        this.f933b = false;
        this.f933b = true;
    }

    public NetworkStatusReceiver(Object obj) {
        this.f933b = false;
        f932a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (!ay.a(context).m62a() && d.m71a(context).m80c() && !d.m71a(context).m82e()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                ax.a(context).m511a(intent);
            } catch (Exception e) {
                b.a(e);
            }
        }
        gr.m305a(context);
        if (as.b(context) && ay.a(context).m65b()) {
            ay.a(context).m66c();
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
        return f932a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f933b) {
            return;
        }
        f931a.execute(new a(this, context));
    }
}
