package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.callback.MessageCallback;
import com.heytap.mcssdk.callback.PushCallback;
import com.heytap.mcssdk.mode.CommandMessage;
import com.heytap.mcssdk.mode.Message;
import com.heytap.mcssdk.utils.LogUtil;
import com.heytap.mcssdk.utils.Utils;
/* loaded from: classes7.dex */
public class PushParseHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PushParseHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void parseCommandMessage(Context context, CommandMessage commandMessage, PushManager pushManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, commandMessage, pushManager) == null) {
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
                    case 12290:
                        pushManager.getPushCallback().onUnRegister(commandMessage.getResponseCode());
                        return;
                    case 12291:
                    case 12299:
                    case 12300:
                    case 12304:
                    case 12305:
                    case CommandMessage.COMMAND_SET_NOTIFICATION_TYPE /* 12307 */:
                    case CommandMessage.COMMAND_CLEAR_NOTIFICATION_TYPE /* 12308 */:
                    default:
                        return;
                    case 12292:
                        pushManager.getPushCallback().onSetAliases(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), "alias", "aliasId", "aliasName"));
                        return;
                    case 12293:
                        pushManager.getPushCallback().onGetAliases(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), "alias", "aliasId", "aliasName"));
                        return;
                    case 12294:
                        pushManager.getPushCallback().onUnsetAliases(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), "alias", "aliasId", "aliasName"));
                        return;
                    case 12295:
                        pushManager.getPushCallback().onSetTags(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "tagId", "tagName"));
                        return;
                    case 12296:
                        pushManager.getPushCallback().onGetTags(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "tagId", "tagName"));
                        return;
                    case 12297:
                        pushManager.getPushCallback().onUnsetTags(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "tagId", "tagName"));
                        return;
                    case 12298:
                        pushManager.getPushCallback().onSetPushTime(commandMessage.getResponseCode(), commandMessage.getContent());
                        return;
                    case 12301:
                        pushManager.getPushCallback().onSetUserAccounts(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "accountId", "accountName"));
                        return;
                    case 12302:
                        pushManager.getPushCallback().onGetUserAccounts(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "accountId", "accountName"));
                        return;
                    case 12303:
                        pushManager.getPushCallback().onUnsetUserAccounts(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "accountId", "accountName"));
                        return;
                    case CommandMessage.COMMAND_GET_PUSH_STATUS /* 12306 */:
                        pushManager.getPushCallback().onGetPushStatus(commandMessage.getResponseCode(), Utils.parseInt(commandMessage.getContent()));
                        return;
                    case CommandMessage.COMMAND_GET_NOTIFICATION_STATUS /* 12309 */:
                        pushManager.getPushCallback().onGetNotificationStatus(commandMessage.getResponseCode(), Utils.parseInt(commandMessage.getContent()));
                        return;
                }
            }
        }
    }

    public static void parseCommandMessage(Context context, CommandMessage commandMessage, PushCallback pushCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, commandMessage, pushCallback) == null) {
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
                    case 12290:
                        pushCallback.onUnRegister(commandMessage.getResponseCode());
                        return;
                    case 12291:
                    case 12299:
                    case 12300:
                    case 12304:
                    case 12305:
                    case CommandMessage.COMMAND_SET_NOTIFICATION_TYPE /* 12307 */:
                    case CommandMessage.COMMAND_CLEAR_NOTIFICATION_TYPE /* 12308 */:
                    default:
                        return;
                    case 12292:
                        pushCallback.onSetAliases(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), "alias", "aliasId", "aliasName"));
                        return;
                    case 12293:
                        pushCallback.onGetAliases(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), "alias", "aliasId", "aliasName"));
                        return;
                    case 12294:
                        pushCallback.onUnsetAliases(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), "alias", "aliasId", "aliasName"));
                        return;
                    case 12295:
                        pushCallback.onSetTags(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "tagId", "tagName"));
                        return;
                    case 12296:
                        pushCallback.onGetTags(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "tagId", "tagName"));
                        return;
                    case 12297:
                        pushCallback.onUnsetTags(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "tagId", "tagName"));
                        return;
                    case 12298:
                        pushCallback.onSetPushTime(commandMessage.getResponseCode(), commandMessage.getContent());
                        return;
                    case 12301:
                        pushCallback.onSetUserAccounts(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "accountId", "accountName"));
                        return;
                    case 12302:
                        pushCallback.onGetUserAccounts(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "accountId", "accountName"));
                        return;
                    case 12303:
                        pushCallback.onUnsetUserAccounts(commandMessage.getResponseCode(), CommandMessage.parseToSubscribeResultList(commandMessage.getContent(), CommandMessage.TYPE_TAGS, "accountId", "accountName"));
                        return;
                    case CommandMessage.COMMAND_GET_PUSH_STATUS /* 12306 */:
                        pushCallback.onGetPushStatus(commandMessage.getResponseCode(), Utils.parseInt(commandMessage.getContent()));
                        return;
                    case CommandMessage.COMMAND_GET_NOTIFICATION_STATUS /* 12309 */:
                        pushCallback.onGetNotificationStatus(commandMessage.getResponseCode(), Utils.parseInt(commandMessage.getContent()));
                        return;
                }
            }
        }
    }

    public static void parseIntent(Context context, Intent intent, MessageCallback messageCallback) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, intent, messageCallback) == null) {
            if (context == null) {
                str = "context is null , please check param of parseIntent()";
            } else if (intent == null) {
                str = "intent is null , please check param of parseIntent()";
            } else if (messageCallback != null) {
                for (Message message : com.heytap.mcssdk.a.c.a(context, intent)) {
                    if (message != null) {
                        for (com.heytap.mcssdk.b.c cVar : PushManager.getInstance().getProcessors()) {
                            if (cVar != null) {
                                cVar.a(context, message, messageCallback);
                            }
                        }
                    }
                }
                return;
            } else {
                str = "callback is null , please check param of parseIntent()";
            }
            LogUtil.e(str);
        }
    }
}
