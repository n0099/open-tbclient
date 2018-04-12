package com.meizu.cloud.pushsdk.platform;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.List;
/* loaded from: classes3.dex */
public class PlatformMessageSender {
    public static final String TAG = "PlatformMessageSender";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface OnUpdateIntent {
        BasicPushStatus getBasicStatus();

        String getBasicStatusExtra();

        String getMethod();
    }

    public static void sendPushStatus(Context context, final PushSwitchStatus pushSwitchStatus) {
        sendPlatformStatus(context, new OnUpdateIntent() { // from class: com.meizu.cloud.pushsdk.platform.PlatformMessageSender.1
            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.OnUpdateIntent
            public String getMethod() {
                return PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PUSH_STATUS;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.OnUpdateIntent
            public BasicPushStatus getBasicStatus() {
                return PushSwitchStatus.this;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.OnUpdateIntent
            public String getBasicStatusExtra() {
                return PushConstants.EXTRA_APP_PUSH_SWITCH_STATUS;
            }
        });
    }

    public static void sendRegisterStatus(Context context, final RegisterStatus registerStatus) {
        sendPlatformStatus(context, new OnUpdateIntent() { // from class: com.meizu.cloud.pushsdk.platform.PlatformMessageSender.2
            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.OnUpdateIntent
            public String getMethod() {
                return PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_REGISTER_STATUS;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.OnUpdateIntent
            public BasicPushStatus getBasicStatus() {
                return RegisterStatus.this;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.OnUpdateIntent
            public String getBasicStatusExtra() {
                return PushConstants.EXTRA_APP_PUSH_REGISTER_STATUS;
            }
        });
    }

    public static void sendUnRegisterStatus(Context context, final UnRegisterStatus unRegisterStatus) {
        sendPlatformStatus(context, new OnUpdateIntent() { // from class: com.meizu.cloud.pushsdk.platform.PlatformMessageSender.3
            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.OnUpdateIntent
            public String getMethod() {
                return PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_UNREGISTER_STATUS;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.OnUpdateIntent
            public BasicPushStatus getBasicStatus() {
                return UnRegisterStatus.this;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.OnUpdateIntent
            public String getBasicStatusExtra() {
                return PushConstants.EXTRA_APP_PUSH_UNREGISTER_STATUS;
            }
        });
    }

    public static void sendSubTags(Context context, final SubTagsStatus subTagsStatus) {
        sendPlatformStatus(context, new OnUpdateIntent() { // from class: com.meizu.cloud.pushsdk.platform.PlatformMessageSender.4
            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.OnUpdateIntent
            public String getMethod() {
                return PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBTAGS_STATUS;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.OnUpdateIntent
            public BasicPushStatus getBasicStatus() {
                return SubTagsStatus.this;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.OnUpdateIntent
            public String getBasicStatusExtra() {
                return PushConstants.EXTRA_APP_PUSH_SUBTAGS_STATUS;
            }
        });
    }

    public static void sendSubAlias(Context context, final SubAliasStatus subAliasStatus) {
        sendPlatformStatus(context, new OnUpdateIntent() { // from class: com.meizu.cloud.pushsdk.platform.PlatformMessageSender.5
            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.OnUpdateIntent
            public String getMethod() {
                return PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBALIAS_STATUS;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.OnUpdateIntent
            public BasicPushStatus getBasicStatus() {
                return SubAliasStatus.this;
            }

            @Override // com.meizu.cloud.pushsdk.platform.PlatformMessageSender.OnUpdateIntent
            public String getBasicStatusExtra() {
                return PushConstants.EXTRA_APP_PUSH_SUBALIAS_STATUS;
            }
        });
    }

    private static void sendPlatformStatus(Context context, OnUpdateIntent onUpdateIntent) {
        String packageName = context.getPackageName();
        Intent intent = new Intent();
        intent.addCategory(packageName);
        intent.setPackage(packageName);
        intent.putExtra("method", onUpdateIntent.getMethod());
        intent.putExtra(onUpdateIntent.getBasicStatusExtra(), onUpdateIntent.getBasicStatus());
        sendMessageFromBroadcast(context, intent, PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, context.getPackageName());
        sendMessageFromBroadcast(context, new Intent("com.meizu.cloud.pushservice.action.PUSH_SERVICE_START"), null, context.getPackageName());
    }

    public static void switchPushMessageSetting(Context context, int i, boolean z, String str) {
        String appVersionName = MzSystemUtils.getAppVersionName(context, "com.meizu.cloud");
        com.meizu.cloud.a.a.i(TAG, context.getPackageName() + " switchPushMessageSetting cloudVersion_name " + appVersionName);
        if (!TextUtils.isEmpty(appVersionName) && appVersionName.startsWith("6")) {
            Intent intent = new Intent(PushConstants.MZ_PUSH_ON_MESSAGE_SWITCH_SETTING);
            intent.putExtra(PushConstants.EXTRA_APP_PUSH_SWITCH_SETTING_TYPE, i);
            intent.putExtra(PushConstants.EXTRA_APP_PUSH_SWITCH_SETTING_STATUS, z);
            intent.putExtra(PushConstants.EXTRA_APP_PUSH_SWITCH_SETTING_PACKAGE_NAME, str);
            intent.setClassName("com.meizu.cloud", "com.meizu.cloud.pushsdk.pushservice.MzPushService");
            context.startService(intent);
        }
    }

    public static void launchStartActivity(Context context, String str, String str2, String str3) {
        MessageV3 parse = MessageV3.parse("", str, "", str3);
        parse.setUploadDataPackageName(str2);
        Intent intent = new Intent();
        intent.setData(Uri.parse("custom://" + System.currentTimeMillis()));
        intent.putExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE, parse);
        intent.putExtra("method", PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE);
        intent.setAction(PushConstants.MZ_PUSH_ON_MESSAGE_ACTION);
        if (!TextUtils.isEmpty(str2)) {
            intent.setPackage(str2);
            intent.setClassName(str2, "com.meizu.cloud.pushsdk.NotificationService");
        }
        intent.putExtra("command_type", "reflect_receiver");
        com.meizu.cloud.a.a.i(TAG, "start notification service " + parse);
        try {
            context.startService(intent);
        } catch (Exception e) {
            com.meizu.cloud.a.a.e(TAG, "launchStartActivity error " + e.getMessage());
        }
    }

    public static void sendMessageFromBroadcast(Context context, Intent intent, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            intent.setAction(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.setPackage(str2);
        }
        String findReceiver = findReceiver(context, str, str2);
        if (!TextUtils.isEmpty(findReceiver)) {
            intent.setClassName(str2, findReceiver);
        }
        context.sendBroadcast(intent);
    }

    private static String findReceiver(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.setPackage(str2);
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            return null;
        }
        return queryBroadcastReceivers.get(0).activityInfo.name;
    }
}
