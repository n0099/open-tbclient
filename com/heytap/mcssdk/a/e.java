package com.heytap.mcssdk.a;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.PushManager;
import com.heytap.mcssdk.mode.Message;
import com.heytap.mcssdk.mode.SptDataMessage;
import com.heytap.mcssdk.utils.CryptoUtil;
import com.heytap.mcssdk.utils.LogUtil;
/* loaded from: classes15.dex */
public final class e extends c {
    @Override // com.heytap.mcssdk.a.d
    public final Message a(Context context, int i, Intent intent) {
        if (4103 == i) {
            Message a2 = a(intent);
            PushManager.statisticMessage(context, (SptDataMessage) a2, PushManager.EVENT_ID_PUSH_TRANSMIT);
            return a2;
        }
        return null;
    }

    @Override // com.heytap.mcssdk.a.c
    public final Message a(Intent intent) {
        try {
            SptDataMessage sptDataMessage = new SptDataMessage();
            sptDataMessage.setMessageID(Integer.parseInt(CryptoUtil.desDecrypt(intent.getStringExtra(Message.MESSAGE_ID))));
            sptDataMessage.setTaskID(CryptoUtil.desDecrypt(intent.getStringExtra(Message.TASK_ID)));
            sptDataMessage.setAppPackage(CryptoUtil.desDecrypt(intent.getStringExtra(Message.APP_PACKAGE)));
            sptDataMessage.setContent(CryptoUtil.desDecrypt(intent.getStringExtra("content")));
            sptDataMessage.setDescription(CryptoUtil.desDecrypt(intent.getStringExtra("description")));
            sptDataMessage.setAppID(CryptoUtil.desDecrypt(intent.getStringExtra(Message.APP_ID)));
            sptDataMessage.setGlobalID(CryptoUtil.desDecrypt(intent.getStringExtra(Message.GLOBAL_ID)));
            return sptDataMessage;
        } catch (Exception e) {
            LogUtil.d("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }
}
