package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.callback.MessageCallback;
import com.heytap.mcssdk.callback.PushCallback;
import com.heytap.mcssdk.mode.CommandMessage;
import com.heytap.mcssdk.mode.Message;
import com.heytap.mcssdk.utils.LogUtil;
import com.heytap.mcssdk.utils.Utils;
/* loaded from: classes12.dex */
public class PushParseHelper {
    public static void parseCommandMessage(Context context, CommandMessage commandMessage, PushManager pushManager) {
        if (context == null) {
            LogUtil.e("context is null , please check param of parseCommandMessage(2)");
        } else if (commandMessage == null) {
            LogUtil.e("message is null , please check param of parseCommandMessage(2)");
        } else if (pushManager == null) {
            LogUtil.e("pushManager is null , please check param of parseCommandMessage(2)");
        } else if (pushManager.getPushCallback() == null) {
            LogUtil.e("pushManager.getPushCallback() is null , please check param of parseCommandMessage(2)");
        } else {
            switch (commandMessage.getCommand()) {
                case 12289:
                    if (commandMessage.getResponseCode() == 0) {
                        pushManager.setRegisterID(commandMessage.getContent());
                    }
                    pushManager.getPushCallback().onRegister(commandMessage.getResponseCode(), commandMessage.getContent());
                    return;
                case CommandMessage.COMMAND_UNREGISTER /* 12290 */:
                    pushManager.getPushCallback().onUnRegister(commandMessage.getResponseCode());
                    return;
                case CommandMessage.COMMAND_STATISTIC /* 12291 */:
                case CommandMessage.COMMAND_PAUSE_PUSH /* 12299 */:
                case CommandMessage.COMMAND_RESUME_PUSH /* 12300 */:
                case 12304:
                case CommandMessage.COMMAND_CLEAR_ALL_NOTIFICATION /* 12305 */:
                case CommandMessage.COMMAND_SET_NOTIFICATION_TYPE /* 12307 */:
                case CommandMessage.COMMAND_CLEAR_NOTIFICATION_TYPE /* 12308 */:
                default:
                    return;
                case CommandMessage.COMMAND_SET_ALIAS /* 12292 */:
                    pushManager.getPushCallback().onSetAliases(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_ALIAS, "aliasId", "aliasName"));
                    return;
                case CommandMessage.COMMAND_GET_ALIAS /* 12293 */:
                    pushManager.getPushCallback().onGetAliases(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_ALIAS, "aliasId", "aliasName"));
                    return;
                case CommandMessage.COMMAND_UNSET_ALIAS /* 12294 */:
                    pushManager.getPushCallback().onUnsetAliases(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_ALIAS, "aliasId", "aliasName"));
                    return;
                case CommandMessage.COMMAND_SET_TAGS /* 12295 */:
                    pushManager.getPushCallback().onSetTags(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "tagId", "tagName"));
                    return;
                case CommandMessage.COMMAND_GET_TAGS /* 12296 */:
                    pushManager.getPushCallback().onGetTags(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "tagId", "tagName"));
                    return;
                case CommandMessage.COMMAND_UNSET_TAGS /* 12297 */:
                    pushManager.getPushCallback().onUnsetTags(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "tagId", "tagName"));
                    return;
                case CommandMessage.COMMAND_SET_PUSH_TIME /* 12298 */:
                    pushManager.getPushCallback().onSetPushTime(commandMessage.getResponseCode(), commandMessage.getContent());
                    return;
                case CommandMessage.COMMAND_SET_ACCOUNTS /* 12301 */:
                    pushManager.getPushCallback().onSetUserAccounts(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "accountId", "accountName"));
                    return;
                case 12302:
                    pushManager.getPushCallback().onGetUserAccounts(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "accountId", "accountName"));
                    return;
                case CommandMessage.COMMAND_UNSET_ACCOUNTS /* 12303 */:
                    pushManager.getPushCallback().onUnsetUserAccounts(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "accountId", "accountName"));
                    return;
                case 12306:
                    pushManager.getPushCallback().onGetPushStatus(commandMessage.getResponseCode(), Utils.parseInt(commandMessage.getContent()));
                    return;
                case CommandMessage.COMMAND_GET_NOTIFICATION_STATUS /* 12309 */:
                    pushManager.getPushCallback().onGetNotificationStatus(commandMessage.getResponseCode(), Utils.parseInt(commandMessage.getContent()));
                    return;
            }
        }
    }

    public static void parseCommandMessage(Context context, CommandMessage commandMessage, PushCallback pushCallback) {
        if (context == null) {
            LogUtil.e("context is null , please check param of parseCommandMessage()");
        } else if (commandMessage == null) {
            LogUtil.e("message is null , please check param of parseCommandMessage()");
        } else if (pushCallback == null) {
            LogUtil.e("callback is null , please check param of parseCommandMessage()");
        } else {
            switch (commandMessage.getCommand()) {
                case 12289:
                    if (commandMessage.getResponseCode() == 0) {
                        PushManager.getInstance().setRegisterID(commandMessage.getContent());
                    }
                    pushCallback.onRegister(commandMessage.getResponseCode(), commandMessage.getContent());
                    return;
                case CommandMessage.COMMAND_UNREGISTER /* 12290 */:
                    pushCallback.onUnRegister(commandMessage.getResponseCode());
                    return;
                case CommandMessage.COMMAND_STATISTIC /* 12291 */:
                case CommandMessage.COMMAND_PAUSE_PUSH /* 12299 */:
                case CommandMessage.COMMAND_RESUME_PUSH /* 12300 */:
                case 12304:
                case CommandMessage.COMMAND_CLEAR_ALL_NOTIFICATION /* 12305 */:
                case CommandMessage.COMMAND_SET_NOTIFICATION_TYPE /* 12307 */:
                case CommandMessage.COMMAND_CLEAR_NOTIFICATION_TYPE /* 12308 */:
                default:
                    return;
                case CommandMessage.COMMAND_SET_ALIAS /* 12292 */:
                    pushCallback.onSetAliases(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_ALIAS, "aliasId", "aliasName"));
                    return;
                case CommandMessage.COMMAND_GET_ALIAS /* 12293 */:
                    pushCallback.onGetAliases(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_ALIAS, "aliasId", "aliasName"));
                    return;
                case CommandMessage.COMMAND_UNSET_ALIAS /* 12294 */:
                    pushCallback.onUnsetAliases(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_ALIAS, "aliasId", "aliasName"));
                    return;
                case CommandMessage.COMMAND_SET_TAGS /* 12295 */:
                    pushCallback.onSetTags(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "tagId", "tagName"));
                    return;
                case CommandMessage.COMMAND_GET_TAGS /* 12296 */:
                    pushCallback.onGetTags(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "tagId", "tagName"));
                    return;
                case CommandMessage.COMMAND_UNSET_TAGS /* 12297 */:
                    pushCallback.onUnsetTags(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "tagId", "tagName"));
                    return;
                case CommandMessage.COMMAND_SET_PUSH_TIME /* 12298 */:
                    pushCallback.onSetPushTime(commandMessage.getResponseCode(), commandMessage.getContent());
                    return;
                case CommandMessage.COMMAND_SET_ACCOUNTS /* 12301 */:
                    pushCallback.onSetUserAccounts(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "accountId", "accountName"));
                    return;
                case 12302:
                    pushCallback.onGetUserAccounts(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "accountId", "accountName"));
                    return;
                case CommandMessage.COMMAND_UNSET_ACCOUNTS /* 12303 */:
                    pushCallback.onUnsetUserAccounts(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "accountId", "accountName"));
                    return;
                case 12306:
                    pushCallback.onGetPushStatus(commandMessage.getResponseCode(), Utils.parseInt(commandMessage.getContent()));
                    return;
                case CommandMessage.COMMAND_GET_NOTIFICATION_STATUS /* 12309 */:
                    pushCallback.onGetNotificationStatus(commandMessage.getResponseCode(), Utils.parseInt(commandMessage.getContent()));
                    return;
            }
        }
    }

    public static void parseIntent(Context context, Intent intent, MessageCallback messageCallback) {
        if (context == null) {
            LogUtil.e("context is null , please check param of parseIntent()");
        } else if (intent == null) {
            LogUtil.e("intent is null , please check param of parseIntent()");
        } else if (messageCallback == null) {
            LogUtil.e("callback is null , please check param of parseIntent()");
        } else {
            for (Message message : com.heytap.mcssdk.a.c.a(context, intent)) {
                if (message != null) {
                    for (com.heytap.mcssdk.b.c cVar : PushManager.getInstance().getProcessors()) {
                        if (cVar != null) {
                            cVar.a(context, message, messageCallback);
                        }
                    }
                }
            }
        }
    }
}
