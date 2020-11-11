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
/* loaded from: classes12.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {

    /* renamed from: b  reason: collision with other field name */
    private boolean f927b;

    /* renamed from: a  reason: collision with root package name */
    private static int f5115a = 1;
    private static int b = 1;
    private static int c = 2;

    /* renamed from: a  reason: collision with other field name */
    private static BlockingQueue<Runnable> f924a = new LinkedBlockingQueue();

    /* renamed from: a  reason: collision with other field name */
    private static ThreadPoolExecutor f925a = new ThreadPoolExecutor(f5115a, b, c, TimeUnit.SECONDS, f924a);

    /* renamed from: a  reason: collision with other field name */
    private static boolean f926a = false;

    public NetworkStatusReceiver() {
        this.f927b = false;
        this.f927b = true;
    }

    public NetworkStatusReceiver(Object obj) {
        this.f927b = false;
        f926a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (!aq.a(context).m87a() && b.m94a(context).m103c() && !b.m94a(context).m105e()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                bb.a(context).m558a(intent);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        gx.m330a(context);
        if (az.b(context) && aq.a(context).m90b()) {
            aq.a(context).m91c();
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
        return f926a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f927b) {
            return;
        }
        f925a.execute(new a(this, context));
    }
}
