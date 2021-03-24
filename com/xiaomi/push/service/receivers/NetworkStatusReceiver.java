package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.mipush.sdk.COSPushHelper;
import com.xiaomi.mipush.sdk.FTOSPushHelper;
import com.xiaomi.mipush.sdk.HWPushHelper;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.ae;
import com.xiaomi.mipush.sdk.an;
import com.xiaomi.mipush.sdk.at;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.bg;
import com.xiaomi.push.gq;
import com.xiaomi.push.service.ServiceClient;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {

    /* renamed from: b  reason: collision with other field name */
    public boolean f970b;

    /* renamed from: a  reason: collision with other field name */
    public static BlockingQueue<Runnable> f967a = new LinkedBlockingQueue();

    /* renamed from: a  reason: collision with root package name */
    public static int f41058a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f41059b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f41060c = 2;

    /* renamed from: a  reason: collision with other field name */
    public static ThreadPoolExecutor f968a = new ThreadPoolExecutor(f41058a, f41059b, f41060c, TimeUnit.SECONDS, f967a);

    /* renamed from: a  reason: collision with other field name */
    public static boolean f969a = false;

    public NetworkStatusReceiver() {
        this.f970b = false;
        this.f970b = true;
    }

    public NetworkStatusReceiver(Object obj) {
        this.f970b = false;
        f969a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (!an.a(context).m85a() && b.m92a(context).m101c() && !b.m92a(context).m104f()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                ServiceClient.getInstance(context).startServiceSafely(intent);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
        gq.m340a(context);
        if (bg.b(context) && an.a(context).m88b()) {
            an.a(context).m89c();
        }
        if (bg.b(context)) {
            if ("syncing".equals(ae.a(context).a(at.DISABLE_PUSH))) {
                MiPushClient.disablePush(context);
            }
            if ("syncing".equals(ae.a(context).a(at.ENABLE_PUSH))) {
                MiPushClient.enablePush(context);
            }
            if ("syncing".equals(ae.a(context).a(at.UPLOAD_HUAWEI_TOKEN))) {
                MiPushClient.syncAssemblePushToken(context);
            }
            if ("syncing".equals(ae.a(context).a(at.UPLOAD_FCM_TOKEN))) {
                MiPushClient.syncAssembleFCMPushToken(context);
            }
            if ("syncing".equals(ae.a(context).a(at.UPLOAD_COS_TOKEN))) {
                MiPushClient.syncAssembleCOSPushToken(context);
            }
            if ("syncing".equals(ae.a(context).a(at.UPLOAD_FTOS_TOKEN))) {
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
        return f969a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f970b) {
            return;
        }
        f968a.execute(new a(this, context));
    }
}
