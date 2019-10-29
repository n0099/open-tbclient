package com.coloros.mcssdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.coloros.mcssdk.callback.MessageCallback;
import com.coloros.mcssdk.mode.AppMessage;
import com.coloros.mcssdk.mode.CommandMessage;
import com.coloros.mcssdk.mode.Message;
import com.coloros.mcssdk.mode.SptDataMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class PushService extends Service implements MessageCallback {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        List<Message> a = com.coloros.mcssdk.a.c.a(getApplicationContext(), intent);
        List<com.coloros.mcssdk.b.c> processors = PushManager.getInstance().getProcessors();
        if (a == null || a.size() == 0 || processors == null || processors.size() == 0) {
            return super.onStartCommand(intent, i, i2);
        }
        for (Message message : a) {
            if (message != null) {
                for (com.coloros.mcssdk.b.c cVar : processors) {
                    if (cVar != null) {
                        try {
                            cVar.a(getApplicationContext(), message, this);
                        } catch (Exception e) {
                            com.coloros.mcssdk.c.d.b("process Exception:" + e.getMessage());
                        }
                    }
                }
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // com.coloros.mcssdk.callback.MessageCallback
    public void processMessage(Context context, AppMessage appMessage) {
    }

    @Override // com.coloros.mcssdk.callback.MessageCallback
    public void processMessage(Context context, CommandMessage commandMessage) {
        if (PushManager.getInstance().getPushCallback() == null) {
            return;
        }
        switch (commandMessage.getCommand()) {
            case 12289:
                PushManager.getInstance().getPushCallback().onRegister(commandMessage.getResponseCode(), commandMessage.getContent());
                if (commandMessage.getResponseCode() == 0) {
                    PushManager.getInstance().setRegisterID(commandMessage.getContent());
                    return;
                }
                return;
            case CommandMessage.COMMAND_UNREGISTER /* 12290 */:
                PushManager.getInstance().getPushCallback().onUnRegister(commandMessage.getResponseCode());
                return;
            case CommandMessage.COMMAND_STATISTIC /* 12291 */:
            case CommandMessage.COMMAND_PAUSE_PUSH /* 12299 */:
            case CommandMessage.COMMAND_RESUME_PUSH /* 12300 */:
            case CommandMessage.COMMAND_CLEAR_NOTIFICATION /* 12304 */:
            case CommandMessage.COMMAND_CLEAR_ALL_NOTIFICATION /* 12305 */:
            case CommandMessage.COMMAND_SET_NOTIFICATION_TYPE /* 12307 */:
            case CommandMessage.COMMAND_CLEAR_NOTIFICATION_TYPE /* 12308 */:
            default:
                return;
            case CommandMessage.COMMAND_SET_ALIAS /* 12292 */:
                PushManager.getInstance().getPushCallback().onSetAliases(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_ALIAS, "aliasId", "aliasName"));
                return;
            case CommandMessage.COMMAND_GET_ALIAS /* 12293 */:
                PushManager.getInstance().getPushCallback().onGetAliases(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_ALIAS, "aliasId", "aliasName"));
                return;
            case CommandMessage.COMMAND_UNSET_ALIAS /* 12294 */:
                PushManager.getInstance().getPushCallback().onUnsetAliases(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_ALIAS, "aliasId", "aliasName"));
                return;
            case CommandMessage.COMMAND_SET_TAGS /* 12295 */:
                PushManager.getInstance().getPushCallback().onSetTags(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "tagId", "tagName"));
                return;
            case CommandMessage.COMMAND_GET_TAGS /* 12296 */:
                PushManager.getInstance().getPushCallback().onGetTags(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "tagId", "tagName"));
                return;
            case CommandMessage.COMMAND_UNSET_TAGS /* 12297 */:
                PushManager.getInstance().getPushCallback().onUnsetTags(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "tagId", "tagName"));
                return;
            case CommandMessage.COMMAND_SET_PUSH_TIME /* 12298 */:
                PushManager.getInstance().getPushCallback().onSetPushTime(commandMessage.getResponseCode(), commandMessage.getContent());
                return;
            case CommandMessage.COMMAND_SET_ACCOUNTS /* 12301 */:
                PushManager.getInstance().getPushCallback().onSetUserAccounts(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "accountId", "accountName"));
                return;
            case CommandMessage.COMMAND_GET_ACCOUNTS /* 12302 */:
                PushManager.getInstance().getPushCallback().onGetUserAccounts(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "accountId", "accountName"));
                return;
            case CommandMessage.COMMAND_UNSET_ACCOUNTS /* 12303 */:
                PushManager.getInstance().getPushCallback().onUnsetUserAccounts(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "accountId", "accountName"));
                return;
            case 12306:
                PushManager.getInstance().getPushCallback().onGetPushStatus(commandMessage.getResponseCode(), com.coloros.mcssdk.c.e.a(commandMessage.getContent()));
                return;
            case CommandMessage.COMMAND_GET_NOTIFICATION_STATUS /* 12309 */:
                PushManager.getInstance().getPushCallback().onGetNotificationStatus(commandMessage.getResponseCode(), com.coloros.mcssdk.c.e.a(commandMessage.getContent()));
                return;
        }
    }

    @Override // com.coloros.mcssdk.callback.MessageCallback
    public void processMessage(Context context, SptDataMessage sptDataMessage) {
    }
}
