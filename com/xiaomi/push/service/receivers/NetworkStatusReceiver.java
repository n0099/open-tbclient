package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.mipush.sdk.COSPushHelper;
import com.xiaomi.mipush.sdk.FTOSPushHelper;
import com.xiaomi.mipush.sdk.HWPushHelper;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.af;
import com.xiaomi.mipush.sdk.ao;
import com.xiaomi.mipush.sdk.au;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.mipush.sdk.e;
import com.xiaomi.push.bi;
import com.xiaomi.push.ha;
import com.xiaomi.push.l;
import com.xiaomi.push.service.ServiceClient;
/* loaded from: classes8.dex */
public class NetworkStatusReceiver extends BroadcastReceiver {
    public static boolean a;
    public boolean b;

    public NetworkStatusReceiver() {
        this.b = false;
        this.b = true;
    }

    public NetworkStatusReceiver(Object obj) {
        this.b = false;
        a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        if (!ao.a(context).m136a() && b.m143a(context).m152c() && !b.m143a(context).m155f()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                ServiceClient.getInstance(context).startServiceSafely(intent);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        ha.m464a(context);
        if (bi.b(context) && ao.a(context).m139b()) {
            ao.a(context).m140c();
        }
        if (bi.b(context)) {
            if ("syncing".equals(af.a(context).a(au.DISABLE_PUSH))) {
                MiPushClient.disablePush(context);
            }
            if ("syncing".equals(af.a(context).a(au.ENABLE_PUSH))) {
                MiPushClient.enablePush(context);
            }
            if ("syncing".equals(af.a(context).a(au.UPLOAD_HUAWEI_TOKEN))) {
                ao.a(context).a((String) null, au.UPLOAD_HUAWEI_TOKEN, e.ASSEMBLE_PUSH_HUAWEI, "net");
            }
            if ("syncing".equals(af.a(context).a(au.UPLOAD_FCM_TOKEN))) {
                ao.a(context).a((String) null, au.UPLOAD_HUAWEI_TOKEN, e.ASSEMBLE_PUSH_HUAWEI, "net");
            }
            if ("syncing".equals(af.a(context).a(au.UPLOAD_COS_TOKEN))) {
                ao.a(context).a((String) null, au.UPLOAD_COS_TOKEN, e.ASSEMBLE_PUSH_COS, "net");
            }
            if ("syncing".equals(af.a(context).a(au.UPLOAD_FTOS_TOKEN))) {
                ao.a(context).a((String) null, au.UPLOAD_FTOS_TOKEN, e.ASSEMBLE_PUSH_FTOS, "net");
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
        return a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.b) {
            return;
        }
        l.a().post(new a(this, context));
    }
}
