package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.PushManager;
import com.heytap.mcssdk.mode.CommandMessage;
/* loaded from: classes6.dex */
public class DataMessageUtil {
    public static final String TYPE = "type";

    public void appArrive(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction(PushManager.getReceiveSdkAction(context));
            intent.setPackage(PushManager.getMcsPackageName(context));
            intent.putExtra("appPackage", context.getPackageName());
            intent.putExtra("messageID", str);
            intent.putExtra("type", CommandMessage.COMMAND_SEND_INSTANT_ACK);
            context.startService(intent);
        } catch (Exception e2) {
            LogUtil.e("statisticMessage--Exception" + e2.getMessage());
        }
    }
}
