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
/* loaded from: classes18.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {

    /* renamed from: b  reason: collision with other field name */
    private boolean f928b;

    /* renamed from: a  reason: collision with root package name */
    private static int f4885a = 1;
    private static int b = 1;
    private static int c = 2;

    /* renamed from: a  reason: collision with other field name */
    private static BlockingQueue<Runnable> f925a = new LinkedBlockingQueue();

    /* renamed from: a  reason: collision with other field name */
    private static ThreadPoolExecutor f926a = new ThreadPoolExecutor(f4885a, b, c, TimeUnit.SECONDS, f925a);

    /* renamed from: a  reason: collision with other field name */
    private static boolean f927a = false;

    public NetworkStatusReceiver() {
        this.f928b = false;
        this.f928b = true;
    }

    public NetworkStatusReceiver(Object obj) {
        this.f928b = false;
        f927a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (!aq.a(context).m80a() && b.m87a(context).m96c() && !b.m87a(context).m98e()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                bb.a(context).m551a(intent);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        gx.m323a(context);
        if (az.b(context) && aq.a(context).m83b()) {
            aq.a(context).m84c();
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
        return f927a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f928b) {
            return;
        }
        f926a.execute(new a(this, context));
    }
}
