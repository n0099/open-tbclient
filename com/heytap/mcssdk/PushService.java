package com.heytap.mcssdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.heytap.mcssdk.callback.MessageCallback;
import com.heytap.mcssdk.mode.AppMessage;
import com.heytap.mcssdk.mode.CommandMessage;
import com.heytap.mcssdk.mode.SptDataMessage;
import com.heytap.mcssdk.utils.LogUtil;
/* loaded from: classes20.dex */
public class PushService extends Service implements MessageCallback {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        PushParseHelper.parseIntent(getApplicationContext(), intent, this);
        return super.onStartCommand(intent, i, i2);
    }

    @Override // com.heytap.mcssdk.callback.MessageCallback
    public void processMessage(Context context, AppMessage appMessage) {
    }

    @Override // com.heytap.mcssdk.callback.MessageCallback
    public void processMessage(Context context, CommandMessage commandMessage) {
        LogUtil.d("mcssdk-processMessage:" + commandMessage.getCommand());
        PushParseHelper.parseCommandMessage(getApplicationContext(), commandMessage, PushManager.getInstance());
    }

    @Override // com.heytap.mcssdk.callback.MessageCallback
    public void processMessage(Context context, SptDataMessage sptDataMessage) {
    }
}
