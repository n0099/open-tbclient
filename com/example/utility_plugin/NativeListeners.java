package com.example.utility_plugin;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.p.a;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class NativeListeners {
    public MethodChannel mMethodChannel;
    private final String MultiRemoveBlockFans = "MultiRemoveBlockFans";
    private final String AppDidEnterBackground = "AppDidEnterBackground";
    private final String reportFlutterDebugData = "reportFlutterDebugData";
    private final String BookMarkUpdate = "BookMarkUpdate";
    private final String FansCountUpdate = "FansCountUpdate";
    private final String ServiceCenterUpdate = "ServiceCenterUpdate";
    private final String SyncComplete = "SyncComplete";
    private final String ServiceCenterCheck = "ServiceCenterCheck";
    private final String LikeForumsSign = "LikeForumsSign";
    private final String kTBCLikeForumsInfoUpdateNotification = "kTBCLikeForumsInfoUpdateNotification";
    private final String kTBCLikeForumsInfoDeletedNotification = "kTBCLikeForumsInfoDeletedNotification";
    private HttpMessageListener mRemoveForbiddenListener = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_ALL_FORBIDDEN_FANS) { // from class: com.example.utility_plugin.NativeListeners.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("uniqueKey", "MultiRemoveBlockFans");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.example.utility_plugin.NativeListeners.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                HashMap hashMap = new HashMap();
                hashMap.put("uniqueKey", "AppDidEnterBackground");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        }
    };
    private CustomMessageListener feedBackRedTipListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP_SHOW) { // from class: com.example.utility_plugin.NativeListeners.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                HashMap hashMap = new HashMap();
                hashMap.put("uniqueKey", "ServiceCenterUpdate");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        }
    };
    private final CustomMessageListener bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.example.utility_plugin.NativeListeners.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (a.cDP().cDL()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uniqueKey", "FansCountUpdate");
                    NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
                } else if (a.cDP().cDM()) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("uniqueKey", "BookMarkUpdate");
                    NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap2);
                }
            }
        }
    };
    private CustomMessageListener memberCenterRedTipListener = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.example.utility_plugin.NativeListeners.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                HashMap hashMap = new HashMap();
                hashMap.put("uniqueKey", "ServiceCenterUpdate");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        }
    };
    private CustomMessageListener checkFeedBackListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP) { // from class: com.example.utility_plugin.NativeListeners.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2016560) {
                HashMap hashMap = new HashMap();
                hashMap.put("uniqueKey", "ServiceCenterCheck");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        }
    };
    private CustomMessageListener syncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.example.utility_plugin.NativeListeners.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            HashMap hashMap = new HashMap();
            hashMap.put("uniqueKey", "SyncComplete");
            NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
        }
    };
    private final CustomMessageListener mSignChangedListener = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.example.utility_plugin.NativeListeners.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SignData signData;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData) && (signData = (SignData) customResponsedMessage.getData()) != null) {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                hashMap2.put(TbTitleActivityConfig.FORUM_ID, signData.forumId);
                hashMap2.put("signFlag", String.valueOf(signData.is_signed));
                hashMap.put("uniqueKey", "LikeForumsSign");
                hashMap.put("object", hashMap2);
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeListeners(MethodChannel methodChannel) {
        this.mMethodChannel = methodChannel;
    }

    public boolean postNotification(Object obj) {
        String str = (String) argument(obj, "name");
        if (str == null) {
            return false;
        }
        Message<?> messageFromName = getMessageFromName(str, obj);
        if (messageFromName != null) {
            MessageManager.getInstance().sendMessage(messageFromName);
            return true;
        }
        ResponsedMessage<?> responsedMessageFromName = getResponsedMessageFromName(str, obj);
        if (responsedMessageFromName != null) {
            MessageManager.getInstance().dispatchResponsedMessage(responsedMessageFromName);
            return true;
        }
        return false;
    }

    public <T> T argument(Object obj, String str) {
        T t = null;
        if (obj != null) {
            try {
                if (obj instanceof Map) {
                    t = (T) ((Map) obj).get(str);
                } else if (obj instanceof JSONObject) {
                    t = (T) ((JSONObject) obj).opt(str);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        return t;
    }

    public void addNotificationObserver(String str) {
        MessageManager.getInstance().registerListener(getListererFromKey(str));
    }

    public void removeNotificationObserver(String str) {
        MessageManager.getInstance().unRegisterListener(getListererFromKey(str));
    }

    private Message getMessageFromName(String str, Object obj) {
        return null;
    }

    private ResponsedMessage getResponsedMessageFromName(String str, Object obj) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1017654699:
                if (str.equals("kTBCLikeForumsInfoUpdateNotification")) {
                    c = 0;
                    break;
                }
                break;
            case 1973571011:
                if (str.equals("kTBCLikeForumsInfoDeletedNotification")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                Object argument = argument(obj, "userInfo");
                if (argument instanceof String) {
                    return new CustomResponsedMessage(CmdConfigCustom.CMD_LIKE_FORUM, Long.valueOf(b.toLong((String) argument, 0L)));
                }
                break;
            case 1:
                Object argument2 = argument(obj, "userInfo");
                if (argument2 instanceof String) {
                    return new CustomResponsedMessage(CmdConfigCustom.CMD_UNLIKE_FORUM, Long.valueOf(b.toLong((String) argument2, 0L)));
                }
                break;
        }
        return null;
    }

    private MessageListener<?> getListererFromKey(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -994250872:
                if (str.equals("AppDidEnterBackground")) {
                    c = 1;
                    break;
                }
                break;
            case -712625697:
                if (str.equals("BookMarkUpdate")) {
                    c = 2;
                    break;
                }
                break;
            case -241869128:
                if (str.equals("FansCountUpdate")) {
                    c = 3;
                    break;
                }
                break;
            case 215365908:
                if (str.equals("SyncComplete")) {
                    c = 5;
                    break;
                }
                break;
            case 463822814:
                if (str.equals("ServiceCenterCheck")) {
                    c = 6;
                    break;
                }
                break;
            case 483157862:
                if (str.equals("LikeForumsSign")) {
                    c = 7;
                    break;
                }
                break;
            case 541940592:
                if (str.equals("MultiRemoveBlockFans")) {
                    c = 0;
                    break;
                }
                break;
            case 2016286899:
                if (str.equals("ServiceCenterUpdate")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.mRemoveForbiddenListener.setPriority(Integer.MAX_VALUE);
                return this.mRemoveForbiddenListener;
            case 1:
                this.mBackgroundListener.setPriority(Integer.MAX_VALUE);
                return this.mBackgroundListener;
            case 2:
                this.bookMarksGiftAndFansListener.setPriority(Integer.MAX_VALUE);
                return this.bookMarksGiftAndFansListener;
            case 3:
                this.bookMarksGiftAndFansListener.setPriority(Integer.MAX_VALUE);
                return this.bookMarksGiftAndFansListener;
            case 4:
                this.feedBackRedTipListener.setPriority(Integer.MAX_VALUE);
                return this.feedBackRedTipListener;
            case 5:
                this.syncFinishListener.setPriority(Integer.MAX_VALUE);
                return this.syncFinishListener;
            case 6:
                this.checkFeedBackListener.setPriority(Integer.MAX_VALUE);
                return this.checkFeedBackListener;
            case 7:
                this.mSignChangedListener.setPriority(Integer.MAX_VALUE);
                return this.mSignChangedListener;
            default:
                return null;
        }
    }
}
