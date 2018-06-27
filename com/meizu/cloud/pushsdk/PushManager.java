package com.meizu.cloud.pushsdk;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.meizu.cloud.pushsdk.util.b;
import com.tencent.connect.common.Constants;
/* loaded from: classes3.dex */
public class PushManager {
    static final String KEY_PUSH_ID = "pushId";
    static final String PUSH_ID_PREFERENCE_NAME = "com.meizu.flyme.push";
    public static final String TAG = "3.3.170206";

    @Deprecated
    public static void register(Context context) {
        com.meizu.cloud.a.a.db(context);
        String appVersionName = MzSystemUtils.getAppVersionName(context, "com.meizu.cloud");
        com.meizu.cloud.a.a.i(TAG, context.getPackageName() + " start register cloudVersion_name " + appVersionName);
        Intent intent = new Intent(PushConstants.MZ_PUSH_ON_START_PUSH_REGISTER);
        if ("com.meizu.cloud".equals(MzSystemUtils.getMzPushServicePackageName(context))) {
            intent.setClassName("com.meizu.cloud", "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            intent.putExtra("sender", context.getPackageName());
        } else if (!TextUtils.isEmpty(appVersionName) && MzSystemUtils.compareVersion(appVersionName, "4.5.7")) {
            com.meizu.cloud.a.a.e(TAG, "flyme 4.x start register cloud versionName " + appVersionName);
            intent.setPackage("com.meizu.cloud");
            intent.putExtra("sender", context.getPackageName());
        } else if (!TextUtils.isEmpty(appVersionName) && appVersionName.startsWith("3")) {
            com.meizu.cloud.a.a.e(TAG, "flyme 3.x start register cloud versionName " + appVersionName);
            intent.setAction(PushConstants.REQUEST_REGISTRATION_INTENT);
            intent.setPackage("com.meizu.cloud");
            intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
            intent.putExtra("sender", context.getPackageName());
        } else {
            com.meizu.cloud.a.a.e(TAG, context.getPackageName() + " start register ");
            intent.setClassName(context.getPackageName(), "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            intent.putExtra("sender", context.getPackageName());
        }
        context.startService(intent);
    }

    @Deprecated
    public static void unRegister(Context context) {
        String appVersionName = MzSystemUtils.getAppVersionName(context, "com.meizu.cloud");
        com.meizu.cloud.a.a.e(TAG, context.getPackageName() + " start unRegister cloud versionName " + appVersionName);
        Intent intent = new Intent(PushConstants.MZ_PUSH_ON_STOP_PUSH_REGISTER);
        if ("com.meizu.cloud".equals(MzSystemUtils.getMzPushServicePackageName(context))) {
            intent.setClassName("com.meizu.cloud", "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            intent.putExtra("sender", context.getPackageName());
        } else if (!TextUtils.isEmpty(appVersionName) && MzSystemUtils.compareVersion(appVersionName, "4.5.7")) {
            intent.setPackage("com.meizu.cloud");
            intent.putExtra("sender", context.getPackageName());
        } else if (!TextUtils.isEmpty(appVersionName) && appVersionName.startsWith("3")) {
            intent.setAction(PushConstants.REQUEST_UNREGISTRATION_INTENT);
            intent.setPackage("com.meizu.cloud");
            intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
            intent.putExtra("sender", context.getPackageName());
        } else {
            com.meizu.cloud.a.a.e(TAG, context.getPackageName() + " start unRegister ");
            intent.setClassName(context.getPackageName(), "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            intent.putExtra("sender", context.getPackageName());
        }
        context.startService(intent);
    }

    public static String getPushId(Context context) {
        if (System.currentTimeMillis() / 1000 > b.b(context)) {
            return null;
        }
        return b.a(context);
    }

    public static void checkPush(Context context, String str, String str2, String str3) {
        com.meizu.cloud.pushsdk.platform.a.b.a(context).c(str, str2, str3);
    }

    public static void switchPush(Context context, String str, String str2, String str3, int i, boolean z) {
        com.meizu.cloud.pushsdk.platform.a.b.a(context).a(str, str2, str3, i, z);
    }

    public static void register(Context context, String str, String str2) {
        com.meizu.cloud.a.a.db(context);
        com.meizu.cloud.pushsdk.platform.a.b.a(context).a(str, str2);
    }

    public static void unRegister(Context context, String str, String str2) {
        com.meizu.cloud.pushsdk.platform.a.b.a(context).b(str, str2);
    }

    public static void subScribeTags(Context context, String str, String str2, String str3, String str4) {
        com.meizu.cloud.pushsdk.platform.a.b.a(context).a(str, str2, str3, str4);
    }

    public static void unSubScribeTags(Context context, String str, String str2, String str3, String str4) {
        com.meizu.cloud.pushsdk.platform.a.b.a(context).b(str, str2, str3, str4);
    }

    public static void checkSubScribeTags(Context context, String str, String str2, String str3) {
        com.meizu.cloud.pushsdk.platform.a.b.a(context).d(str, str2, str3);
    }

    public static void subScribeAlias(Context context, String str, String str2, String str3, String str4) {
        com.meizu.cloud.pushsdk.platform.a.b.a(context).c(str, str2, str3, str4);
    }

    public static void unSubScribeAlias(Context context, String str, String str2, String str3, String str4) {
        com.meizu.cloud.pushsdk.platform.a.b.a(context).d(str, str2, str3, str4);
    }

    public static void checkSubScribeAlias(Context context, String str, String str2, String str3) {
        com.meizu.cloud.pushsdk.platform.a.b.a(context).e(str, str2, str3);
    }

    public static void checkNotificationMessage(Context context) {
        String appVersionName = MzSystemUtils.getAppVersionName(context, "com.meizu.cloud");
        com.meizu.cloud.a.a.i(TAG, context.getPackageName() + " checkNotificationMessage cloudVersion_name " + appVersionName);
        if (!TextUtils.isEmpty(appVersionName) && appVersionName.startsWith(Constants.VIA_SHARE_TYPE_INFO)) {
            Intent intent = new Intent(PushConstants.MZ_PUSH_ON_GET_NOTIFICATION_MESSAGE);
            intent.putExtra(PushConstants.EXTRA_GET_NOTIFICATION_PACKAGE_NAME, context.getPackageName());
            intent.setClassName("com.meizu.cloud", "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            context.startService(intent);
        }
    }
}
