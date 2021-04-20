package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.push.hs;
import com.xiaomi.push.ii;
import java.util.List;
/* loaded from: classes7.dex */
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
    public static int pushMode;

    public static MiPushCommandMessage generateCommandMessage(String str, List<String> list, long j, String str2, String str3) {
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        miPushCommandMessage.setCommand(str);
        miPushCommandMessage.setCommandArguments(list);
        miPushCommandMessage.setResultCode(j);
        miPushCommandMessage.setReason(str2);
        miPushCommandMessage.setCategory(str3);
        return miPushCommandMessage;
    }

    public static MiPushMessage generateMessage(ii iiVar, hs hsVar, boolean z) {
        MiPushMessage miPushMessage = new MiPushMessage();
        miPushMessage.setMessageId(iiVar.m471a());
        if (!TextUtils.isEmpty(iiVar.d())) {
            miPushMessage.setMessageType(1);
            miPushMessage.setAlias(iiVar.d());
        } else if (!TextUtils.isEmpty(iiVar.c())) {
            miPushMessage.setMessageType(2);
            miPushMessage.setTopic(iiVar.c());
        } else if (TextUtils.isEmpty(iiVar.f())) {
            miPushMessage.setMessageType(0);
        } else {
            miPushMessage.setMessageType(3);
            miPushMessage.setUserAccount(iiVar.f());
        }
        miPushMessage.setCategory(iiVar.e());
        if (iiVar.a() != null) {
            miPushMessage.setContent(iiVar.a().c());
        }
        if (hsVar != null) {
            if (TextUtils.isEmpty(miPushMessage.getMessageId())) {
                miPushMessage.setMessageId(hsVar.m392a());
            }
            if (TextUtils.isEmpty(miPushMessage.getTopic())) {
                miPushMessage.setTopic(hsVar.m397b());
            }
            miPushMessage.setDescription(hsVar.d());
            miPushMessage.setTitle(hsVar.m400c());
            miPushMessage.setNotifyType(hsVar.a());
            miPushMessage.setNotifyId(hsVar.c());
            miPushMessage.setPassThrough(hsVar.b());
            miPushMessage.setExtra(hsVar.m393a());
        }
        miPushMessage.setNotified(z);
        return miPushMessage;
    }

    public static hs generateMessage(MiPushMessage miPushMessage) {
        hs hsVar = new hs();
        hsVar.a(miPushMessage.getMessageId());
        hsVar.b(miPushMessage.getTopic());
        hsVar.d(miPushMessage.getDescription());
        hsVar.c(miPushMessage.getTitle());
        hsVar.c(miPushMessage.getNotifyId());
        hsVar.a(miPushMessage.getNotifyType());
        hsVar.b(miPushMessage.getPassThrough());
        hsVar.a(miPushMessage.getExtra());
        return hsVar;
    }

    public static int getPushMode(Context context) {
        if (pushMode == 0) {
            setPushMode(isUseCallbackPushMode(context) ? 1 : 2);
        }
        return pushMode;
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                if (!queryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
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

    public static void setPushMode(int i) {
        pushMode = i;
    }
}
