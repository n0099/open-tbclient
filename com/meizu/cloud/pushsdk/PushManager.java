package com.meizu.cloud.pushsdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.a.b;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
/* loaded from: classes16.dex */
public class PushManager {
    static final String KEY_PUSH_ID = "pushId";
    static final String PUSH_ID_PREFERENCE_NAME = "com.meizu.flyme.push";
    public static final String TAG = "3.8.3";

    public static void checkNotificationMessage(Context context) {
        String appVersionName = MzSystemUtils.getAppVersionName(context, "com.meizu.cloud");
        com.meizu.cloud.a.a.i(TAG, context.getPackageName() + " checkNotificationMessage cloudVersion_name " + appVersionName);
        if (TextUtils.isEmpty(appVersionName) || !appVersionName.startsWith("6")) {
            return;
        }
        Intent intent = new Intent(PushConstants.MZ_PUSH_ON_GET_NOTIFICATION_MESSAGE);
        intent.putExtra(PushConstants.EXTRA_GET_NOTIFICATION_PACKAGE_NAME, context.getPackageName());
        intent.setClassName("com.meizu.cloud", "com.meizu.cloud.pushsdk.pushservice.MzPushService");
        context.startService(intent);
    }

    public static void checkPush(Context context, String str, String str2, String str3) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            b.a(context).a(str, str2, context.getPackageName(), str3);
        } else {
            com.meizu.cloud.a.a.e(TAG, "please invoke checkPush on meizu device Build-in FlymeOS");
        }
    }

    public static void checkSubScribeAlias(Context context, String str, String str2, String str3) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            b.a(context).d(str, str2, context.getPackageName(), str3);
        } else {
            com.meizu.cloud.a.a.e(TAG, "please invoke checkSubScribeAlias on meizu device Build-in FlymeOS");
        }
    }

    public static void checkSubScribeTags(Context context, String str, String str2, String str3) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            b.a(context).c(str, str2, context.getPackageName(), str3);
        } else {
            com.meizu.cloud.a.a.e(TAG, "please invoke checkSubScribeTags on meizu device Build-in FlymeOS");
        }
    }

    public static void clearNotification(Context context) {
        b.a(context).a(context.getPackageName());
    }

    public static void clearNotification(Context context, int... iArr) {
        b.a(context).a(context.getPackageName(), iArr);
    }

    public static void enableCacheRequest(Context context, boolean z) {
        b.a(context).a(z);
    }

    public static String getPushId(Context context) {
        int b = com.meizu.cloud.pushsdk.util.b.b(context, context.getPackageName());
        if (b == 0 || System.currentTimeMillis() / 1000 <= b) {
            return com.meizu.cloud.pushsdk.util.b.a(context, context.getPackageName());
        }
        return null;
    }

    @Deprecated
    public static void register(Context context) {
        com.meizu.cloud.a.a.hR(context);
        if (!MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.a.a.e(TAG, "please invoke register on meizu device Build-in FlymeOS");
            return;
        }
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
        } else if (TextUtils.isEmpty(appVersionName) || !appVersionName.startsWith("3")) {
            com.meizu.cloud.a.a.e(TAG, context.getPackageName() + " start register ");
            intent.setClassName(context.getPackageName(), "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            intent.putExtra("sender", context.getPackageName());
        } else {
            com.meizu.cloud.a.a.e(TAG, "flyme 3.x start register cloud versionName " + appVersionName);
            intent.setAction(PushConstants.REQUEST_REGISTRATION_INTENT);
            intent.setPackage("com.meizu.cloud");
            intent.putExtra("sender", context.getPackageName());
        }
        context.startService(intent);
    }

    public static void register(Context context, String str, String str2) {
        com.meizu.cloud.a.a.hR(context);
        if (MzSystemUtils.isBrandMeizu(context)) {
            b.a(context).a(str, str2, context.getPackageName());
        } else {
            com.meizu.cloud.a.a.e(TAG, "please invoke register on meizu device Build-in FlymeOS");
        }
    }

    public static void subScribeAlias(Context context, String str, String str2, String str3, String str4) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            b.a(context).c(str, str2, context.getPackageName(), str3, str4);
        } else {
            com.meizu.cloud.a.a.e(TAG, "please invoke subScribeAlias on meizu device Build-in FlymeOS");
        }
    }

    public static void subScribeTags(Context context, String str, String str2, String str3, String str4) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            b.a(context).a(str, str2, context.getPackageName(), str3, str4);
        } else {
            com.meizu.cloud.a.a.e(TAG, "please invoke subScribeTags on meizu device Build-in FlymeOS");
        }
    }

    public static void switchPush(Context context, String str, String str2, String str3, int i, boolean z) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            b.a(context).a(str, str2, context.getPackageName(), str3, i, z);
        } else {
            com.meizu.cloud.a.a.e(TAG, "please invoke switchPush on meizu device Build-in FlymeOS");
        }
    }

    public static void switchPush(Context context, String str, String str2, String str3, boolean z) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            b.a(context).a(str, str2, context.getPackageName(), str3, z);
        } else {
            com.meizu.cloud.a.a.e(TAG, "please invoke switchPush on meizu device Build-in FlymeOS");
        }
    }

    @Deprecated
    public static void unRegister(Context context) {
        if (!MzSystemUtils.isBrandMeizu(context)) {
            com.meizu.cloud.a.a.e(TAG, "please invoke unRegister on meizu device Build-in FlymeOS");
            return;
        }
        String appVersionName = MzSystemUtils.getAppVersionName(context, "com.meizu.cloud");
        com.meizu.cloud.a.a.e(TAG, context.getPackageName() + " start unRegister cloud versionName " + appVersionName);
        Intent intent = new Intent(PushConstants.MZ_PUSH_ON_STOP_PUSH_REGISTER);
        if ("com.meizu.cloud".equals(MzSystemUtils.getMzPushServicePackageName(context))) {
            intent.setClassName("com.meizu.cloud", "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            intent.putExtra("sender", context.getPackageName());
        } else if (!TextUtils.isEmpty(appVersionName) && MzSystemUtils.compareVersion(appVersionName, "4.5.7")) {
            intent.setPackage("com.meizu.cloud");
            intent.putExtra("sender", context.getPackageName());
        } else if (TextUtils.isEmpty(appVersionName) || !appVersionName.startsWith("3")) {
            com.meizu.cloud.a.a.e(TAG, context.getPackageName() + " start unRegister ");
            intent.setClassName(context.getPackageName(), "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            intent.putExtra("sender", context.getPackageName());
        } else {
            intent.setAction(PushConstants.REQUEST_UNREGISTRATION_INTENT);
            intent.setPackage("com.meizu.cloud");
            intent.putExtra("sender", context.getPackageName());
        }
        context.startService(intent);
    }

    public static void unRegister(Context context, String str, String str2) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            b.a(context).b(str, str2, context.getPackageName());
        } else {
            com.meizu.cloud.a.a.e(TAG, "please invoke unRegister on meizu device Build-in FlymeOS");
        }
    }

    public static void unSubScribeAlias(Context context, String str, String str2, String str3, String str4) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            b.a(context).d(str, str2, context.getPackageName(), str3, str4);
        } else {
            com.meizu.cloud.a.a.e(TAG, "please invoke unSubScribeAlias on meizu device Build-in FlymeOS");
        }
    }

    public static void unSubScribeAllTags(Context context, String str, String str2, String str3) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            b.a(context).b(str, str2, context.getPackageName(), str3);
        } else {
            com.meizu.cloud.a.a.e(TAG, "please invoke unSubScribeAllTags on meizu device Build-in FlymeOS");
        }
    }

    public static void unSubScribeTags(Context context, String str, String str2, String str3, String str4) {
        if (MzSystemUtils.isBrandMeizu(context)) {
            b.a(context).b(str, str2, context.getPackageName(), str3, str4);
        } else {
            com.meizu.cloud.a.a.e(TAG, "please invoke unSubScribeTags on meizu device Build-in FlymeOS");
        }
    }
}
