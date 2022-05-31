package com.meizu.cloud.pushsdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.base.IntentReceiver;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.meizu.cloud.pushsdk.util.d;
import com.repackage.ni9;
/* loaded from: classes5.dex */
public class SystemReceiver extends IntentReceiver {
    public void a(Context context) {
        String appVersionName = MzSystemUtils.getAppVersionName(context, "com.meizu.cloud");
        ni9.d("SystemReceiver", context.getPackageName() + " start register cloudVersion_name " + appVersionName);
        Intent intent = new Intent();
        if ("com.meizu.cloud".equals(MzSystemUtils.getMzPushServicePackageName(context))) {
            ni9.b("SystemReceiver", "cloud pushService start");
            intent.setAction("com.meizu.pushservice.action.START");
            intent.setClassName("com.meizu.cloud", "com.meizu.cloud.pushsdk.pushservice.MzPushService");
        } else if (!TextUtils.isEmpty(appVersionName) && MzSystemUtils.compareVersion(appVersionName, "4.5.7")) {
            ni9.b("SystemReceiver", "flyme 4.x start register cloud versionName " + appVersionName);
            intent.setPackage("com.meizu.cloud");
            intent.setAction(PushConstants.MZ_PUSH_ON_START_PUSH_REGISTER);
        } else if (TextUtils.isEmpty(appVersionName) || !appVersionName.startsWith("3")) {
            ni9.b("SystemReceiver", context.getPackageName() + " start register ");
            intent.setClassName(context.getPackageName(), "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            intent.setAction("com.meizu.pushservice.action.START");
        } else {
            ni9.b("SystemReceiver", "flyme 3.x start register cloud versionName " + appVersionName);
            intent.setAction(PushConstants.REQUEST_REGISTRATION_INTENT);
            intent.setPackage("com.meizu.cloud");
        }
        a(context, intent);
    }

    public void a(Context context, Intent intent) {
        try {
            context.startService(intent);
        } catch (SecurityException e) {
            ni9.b("SystemReceiver", "start service error " + e.getMessage());
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.IntentReceiver
    public void onHandleIntent(Context context, Intent intent) {
        if (intent != null) {
            try {
                if ("com.meizu.cloud.pushservice.action.PUSH_SERVICE_START".equals(intent.getAction())) {
                    a(context);
                    com.meizu.cloud.pushsdk.c.a.a(context, false).a();
                }
            } catch (Exception e) {
                ni9.b("SystemReceiver", "onHandleIntent Exception " + e.getMessage());
            }
        }
    }

    @Override // com.meizu.cloud.pushsdk.base.IntentReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            super.onReceive(context, intent);
        } catch (Exception e) {
            ni9.b("SystemReceiver", "Event core error " + e.getMessage());
            String packageName = context.getPackageName();
            d.a(context, packageName, null, null, PushManager.TAG, "SystemReceiver " + e.getMessage(), 3000);
        }
    }
}
