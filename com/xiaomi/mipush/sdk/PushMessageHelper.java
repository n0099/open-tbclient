package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.push.hz;
import com.xiaomi.push.ip;
import java.util.List;
/* loaded from: classes9.dex */
public class PushMessageHelper {
    public static final String ERROR_MESSAGE = "error_message";
    public static final String ERROR_TYPE = "error_type";
    public static final String ERROR_TYPE_NEED_PERMISSION = "error_lack_of_permission";
    public static final String KEY_COMMAND = "key_command";
    public static final String KEY_MESSAGE = "key_message";
    public static final int MESSAGE_COMMAND = 3;
    public static final int MESSAGE_ERROR = 5;
    public static final int MESSAGE_QUIT = 4;
    public static final int MESSAGE_RAW = 1;
    public static final int MESSAGE_SENDMESSAGE = 2;
    public static final String MESSAGE_TYPE = "message_type";
    public static final int PUSH_MODE_BROADCAST = 2;
    public static final int PUSH_MODE_CALLBACK = 1;
    private static int pushMode = 0;

    public static MiPushCommandMessage generateCommandMessage(String str, List<String> list, long j, String str2, String str3) {
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        miPushCommandMessage.setCommand(str);
        miPushCommandMessage.setCommandArguments(list);
        miPushCommandMessage.setResultCode(j);
        miPushCommandMessage.setReason(str2);
        miPushCommandMessage.setCategory(str3);
        return miPushCommandMessage;
    }

    public static MiPushMessage generateMessage(ip ipVar, hz hzVar, boolean z) {
        MiPushMessage miPushMessage = new MiPushMessage();
        miPushMessage.setMessageId(ipVar.m448a());
        if (!TextUtils.isEmpty(ipVar.d())) {
            miPushMessage.setMessageType(1);
            miPushMessage.setAlias(ipVar.d());
        } else if (!TextUtils.isEmpty(ipVar.c())) {
            miPushMessage.setMessageType(2);
            miPushMessage.setTopic(ipVar.c());
        } else if (TextUtils.isEmpty(ipVar.f())) {
            miPushMessage.setMessageType(0);
        } else {
            miPushMessage.setMessageType(3);
            miPushMessage.setUserAccount(ipVar.f());
        }
        miPushMessage.setCategory(ipVar.e());
        if (ipVar.a() != null) {
            miPushMessage.setContent(ipVar.a().c());
        }
        if (hzVar != null) {
            if (TextUtils.isEmpty(miPushMessage.getMessageId())) {
                miPushMessage.setMessageId(hzVar.m372a());
            }
            if (TextUtils.isEmpty(miPushMessage.getTopic())) {
                miPushMessage.setTopic(hzVar.m377b());
            }
            miPushMessage.setDescription(hzVar.d());
            miPushMessage.setTitle(hzVar.m380c());
            miPushMessage.setNotifyType(hzVar.a());
            miPushMessage.setNotifyId(hzVar.c());
            miPushMessage.setPassThrough(hzVar.b());
            miPushMessage.setExtra(hzVar.m373a());
        }
        miPushMessage.setNotified(z);
        return miPushMessage;
    }

    public static hz generateMessage(MiPushMessage miPushMessage) {
        hz hzVar = new hz();
        hzVar.a(miPushMessage.getMessageId());
        hzVar.b(miPushMessage.getTopic());
        hzVar.d(miPushMessage.getDescription());
        hzVar.c(miPushMessage.getTitle());
        hzVar.c(miPushMessage.getNotifyId());
        hzVar.a(miPushMessage.getNotifyType());
        hzVar.b(miPushMessage.getPassThrough());
        hzVar.a(miPushMessage.getExtra());
        return hzVar;
    }

    public static int getPushMode(Context context) {
        if (pushMode == 0) {
            if (isUseCallbackPushMode(context)) {
                setPushMode(1);
            } else {
                setPushMode(2);
            }
        }
        return pushMode;
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                if (!queryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean isUseCallbackPushMode(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setClassName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
        return isIntentAvailable(context, intent);
    }

    public static void sendCommandMessageBroadcast(Context context, MiPushCommandMessage miPushCommandMessage) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra(MESSAGE_TYPE, 3);
        intent.putExtra(KEY_COMMAND, miPushCommandMessage);
        new PushServiceReceiver().onReceive(context, intent);
    }

    public static void sendQuitMessageBroadcast(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra(MESSAGE_TYPE, 4);
        new PushServiceReceiver().onReceive(context, intent);
    }

    private static void setPushMode(int i) {
        pushMode = i;
    }
}
