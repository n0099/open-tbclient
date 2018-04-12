package com.meizu.cloud.pushsdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.common.base.WorkReceiver;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.meizu.cloud.pushsdk.util.c;
/* loaded from: classes3.dex */
public class SystemReceiver extends WorkReceiver {
    private static final String TAG = "SystemReceiver";

    @Override // com.meizu.cloud.pushsdk.common.base.WorkReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            super.onReceive(context, intent);
        } catch (Exception e) {
            com.meizu.cloud.a.a.e(TAG, "Event core error " + e.getMessage());
            c.a(context, context.getPackageName(), (String) null, (String) null, PushManager.TAG, "SystemReceiver " + e.getMessage(), (int) PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
        }
    }

    @Override // com.meizu.cloud.pushsdk.common.base.WorkReceiver
    public void onHandleIntent(Context context, Intent intent) {
        if (intent != null) {
            try {
                if ("com.meizu.cloud.pushservice.action.PUSH_SERVICE_START".equals(intent.getAction())) {
                    restartCloudService(context);
                }
            } catch (Exception e) {
                com.meizu.cloud.a.a.e(TAG, "onHandleIntent Exception " + e.getMessage());
            }
        }
    }

    public void startPushService(Context context, Intent intent) {
        try {
            context.startService(intent);
        } catch (SecurityException e) {
            com.meizu.cloud.a.a.e(TAG, "start service error " + e.getMessage());
        }
    }

    public void restartCloudService(Context context) {
        String appVersionName = MzSystemUtils.getAppVersionName(context, "com.meizu.cloud");
        com.meizu.cloud.a.a.i(TAG, context.getPackageName() + " start register cloudVersion_name " + appVersionName);
        Intent intent = new Intent();
        if ("com.meizu.cloud".equals(MzSystemUtils.getMzPushServicePackageName(context))) {
            com.meizu.cloud.a.a.e(TAG, "cloud pushService start");
            intent.setAction("com.meizu.pushservice.action.START");
            intent.setClassName("com.meizu.cloud", "com.meizu.cloud.pushsdk.pushservice.MzPushService");
        } else if (!TextUtils.isEmpty(appVersionName) && MzSystemUtils.compareVersion(appVersionName, "4.5.7")) {
            com.meizu.cloud.a.a.e(TAG, "flyme 4.x start register cloud versionName " + appVersionName);
            intent.setPackage("com.meizu.cloud");
            intent.setAction(PushConstants.MZ_PUSH_ON_START_PUSH_REGISTER);
        } else if (!TextUtils.isEmpty(appVersionName) && appVersionName.startsWith("3")) {
            com.meizu.cloud.a.a.e(TAG, "flyme 3.x start register cloud versionName " + appVersionName);
            intent.setAction(PushConstants.REQUEST_REGISTRATION_INTENT);
            intent.setPackage("com.meizu.cloud");
        } else {
            com.meizu.cloud.a.a.e(TAG, context.getPackageName() + " start register ");
            intent.setClassName(context.getPackageName(), "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            intent.setAction("com.meizu.pushservice.action.START");
        }
        startPushService(context, intent);
    }
}
