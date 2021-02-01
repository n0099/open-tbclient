package com.heytap.mcssdk.a;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.mode.CommandMessage;
import com.heytap.mcssdk.mode.Message;
import com.heytap.mcssdk.utils.CryptoUtil;
import com.heytap.mcssdk.utils.LogUtil;
/* loaded from: classes6.dex */
public final class b extends c {
    @Override // com.heytap.mcssdk.a.d
    public final Message a(Context context, int i, Intent intent) {
        if (4105 == i) {
            return a(intent);
        }
        return null;
    }

    @Override // com.heytap.mcssdk.a.c
    public final Message a(Intent intent) {
        try {
            CommandMessage commandMessage = new CommandMessage();
            commandMessage.setCommand(Integer.parseInt(CryptoUtil.desDecrypt(intent.getStringExtra("command"))));
            commandMessage.setResponseCode(Integer.parseInt(CryptoUtil.desDecrypt(intent.getStringExtra("code"))));
            commandMessage.setContent(CryptoUtil.desDecrypt(intent.getStringExtra("content")));
            commandMessage.setAppKey(CryptoUtil.desDecrypt(intent.getStringExtra("appKey")));
            commandMessage.setAppSecret(CryptoUtil.desDecrypt(intent.getStringExtra(CommandMessage.APP_SECRET)));
            commandMessage.setAppPackage(CryptoUtil.desDecrypt(intent.getStringExtra(Message.APP_PACKAGE)));
            LogUtil.d("OnHandleIntent-message:" + commandMessage.toString());
            return commandMessage;
        } catch (Exception e) {
            LogUtil.d("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }
}
