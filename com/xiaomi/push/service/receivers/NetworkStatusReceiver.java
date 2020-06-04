package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.mipush.sdk.COSPushHelper;
import com.xiaomi.mipush.sdk.FTOSPushHelper;
import com.xiaomi.mipush.sdk.HWPushHelper;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.ag;
import com.xiaomi.mipush.sdk.aq;
import com.xiaomi.mipush.sdk.av;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.az;
import com.xiaomi.push.gx;
import com.xiaomi.push.service.bb;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {

    /* renamed from: b  reason: collision with other field name */
    private boolean f926b;
    private static int a = 1;
    private static int b = 1;
    private static int c = 2;

    /* renamed from: a  reason: collision with other field name */
    private static BlockingQueue<Runnable> f923a = new LinkedBlockingQueue();

    /* renamed from: a  reason: collision with other field name */
    private static ThreadPoolExecutor f924a = new ThreadPoolExecutor(a, b, c, TimeUnit.SECONDS, f923a);

    /* renamed from: a  reason: collision with other field name */
    private static boolean f925a = false;

    public NetworkStatusReceiver() {
        this.f926b = false;
        this.f926b = true;
    }

    public NetworkStatusReceiver(Object obj) {
        this.f926b = false;
        f925a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (!aq.a(context).m84a() && b.m91a(context).m100c() && !b.m91a(context).m102e()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                bb.a(context).m555a(intent);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        gx.m327a(context);
        if (az.b(context) && aq.a(context).m87b()) {
            aq.a(context).m88c();
        }
        if (az.b(context)) {
            if ("syncing".equals(ag.a(context).a(av.DISABLE_PUSH))) {
                MiPushClient.disablePush(context);
            }
            if ("syncing".equals(ag.a(context).a(av.ENABLE_PUSH))) {
                MiPushClient.enablePush(context);
            }
            if ("syncing".equals(ag.a(context).a(av.UPLOAD_HUAWEI_TOKEN))) {
                MiPushClient.syncAssemblePushToken(context);
            }
            if ("syncing".equals(ag.a(context).a(av.UPLOAD_FCM_TOKEN))) {
                MiPushClient.syncAssembleFCMPushToken(context);
            }
            if ("syncing".equals(ag.a(context).a(av.UPLOAD_COS_TOKEN))) {
                MiPushClient.syncAssembleCOSPushToken(context);
            }
            if ("syncing".equals(ag.a(context).a(av.UPLOAD_FTOS_TOKEN))) {
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
        return f925a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f926b) {
            return;
        }
        f924a.execute(new a(this, context));
    }
}
