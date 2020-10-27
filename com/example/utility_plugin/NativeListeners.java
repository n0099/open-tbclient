package com.example.utility_plugin;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomMessage;
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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.a.g;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
import com.baidu.tbadk.data.m;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.p.a;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.e;
import com.baidu.tieba.tbadkCore.v;
import io.flutter.Log;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class NativeListeners {
    public MethodChannel mMethodChannel;
    private int mLastMainTabIndex = -1;
    private final String MultiRemoveBlockFans = "MultiRemoveBlockFans";
    private final String AppDidEnterBackground = "AppDidEnterBackground";
    private final String AppDidBecomeActive = "AppDidBecomeActive";
    private final String reportFlutterDebugData = "reportFlutterDebugData";
    private final String BookMarkUpdate = "BookMarkUpdate";
    private final String FansCountUpdate = "FansCountUpdate";
    private final String ServiceCenterUpdate = "ServiceCenterUpdate";
    private final String SyncComplete = "SyncComplete";
    private final String ServiceCenterCheck = "ServiceCenterCheck";
    private final String LikeForumsSign = "LikeForumsSign";
    private final String BarBroadcastCopyLink = "BarBroadcastCopyLink";
    private final String ThreadAgreeChanged = "ThreadAgreeChanged";
    private final String ChangePortraitImage = "ChangePortraitImage";
    private final String ChangePendantImage = "ChangePendantImage";
    private final String ChangeUserProfile = "ChangeUserProfile";
    private final String ChangeUserProfileBackground = "ChangeUserProfileBackground";
    private final String kTBCLikeForumsInfoUpdateNotification = "kTBCLikeForumsInfoUpdateNotification";
    private final String kTBCLikeForumsInfoDeletedNotification = "kTBCLikeForumsInfoDeletedNotification";
    private final String kTBCShareSdkResultNotification = "kTBCShareSdkResultNotification";
    private final String kTBCCancleLikeFrsNotification = "kTBCCancleLikeFrsNotification";
    private final String PersonDataChangedNotification = "PersonDataChangedNotification";
    private final String ThreadWriteReplyListener = "ThreadWriteReplyListener";
    private final String kTBCDeleteFrsSection = "kTBCDeleteFrsSection";
    private final String kTBCBroadcastPublishSuccess = "kTBCBroadcastPublishSuccess";
    private final String kTBCBroadcastEdditPageResume = "kTBCBroadcastEdditPageResume";
    private final String AutoRefreshBarEntry = "AutoRefreshBarEntry";
    private final String AutoRefreshCategory = "AutoRefreshCategory";
    private final String AccountInfoUpdated = "AccountInfoUpdated";
    private final CustomMessageListener bookMarksGiftAndFansListener = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.example.utility_plugin.NativeListeners.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (a.dzw().dzs()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uniqueKey", "FansCountUpdate");
                    NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
                } else if (a.dzw().dzt()) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("uniqueKey", "BookMarkUpdate");
                    NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap2);
                }
            }
        }
    };
    private final CustomMessageListener mSignChangedListener = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.example.utility_plugin.NativeListeners.2
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
    private final CustomMessageListener mCopyBarBroadcastLinkListener = new CustomMessageListener(2921472) { // from class: com.example.utility_plugin.NativeListeners.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str = (String) customResponsedMessage.getData();
            if (str != null) {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("threadLink", str);
                hashMap.put("uniqueKey", "BarBroadcastCopyLink");
                hashMap.put("data", hashMap2);
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        }
    };
    private HttpMessageListener mRemoveForbiddenListener = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_ALL_FORBIDDEN_FANS) { // from class: com.example.utility_plugin.NativeListeners.4
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
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_INFO_CHANGED) { // from class: com.example.utility_plugin.NativeListeners.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001247) {
                HashMap hashMap = new HashMap();
                hashMap.put("uniqueKey", "AccountInfoUpdated");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.example.utility_plugin.NativeListeners.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                boolean booleanValue = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (booleanValue) {
                    try {
                        if (booleanValue == UtilHelper.isAppForeground()) {
                            return;
                        }
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                }
                if (booleanValue) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uniqueKey", "AppDidEnterBackground");
                    NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
                    return;
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("uniqueKey", "AppDidBecomeActive");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap2);
            }
        }
    };
    private CustomMessageListener feedBackRedTipListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP_SHOW) { // from class: com.example.utility_plugin.NativeListeners.7
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
    private CustomMessageListener memberCenterRedTipListener = new CustomMessageListener(CmdConfigCustom.CMD_MAINTAB_MEMBER_RED_TIP) { // from class: com.example.utility_plugin.NativeListeners.8
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
    private CustomMessageListener checkFeedBackListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP) { // from class: com.example.utility_plugin.NativeListeners.9
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
    private CustomMessageListener syncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.example.utility_plugin.NativeListeners.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            HashMap hashMap = new HashMap();
            hashMap.put("uniqueKey", "SyncComplete");
            NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
        }
    };
    private CustomMessageListener mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.example.utility_plugin.NativeListeners.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AgreeData agreeData;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e) && (agreeData = ((e) customResponsedMessage.getData()).agreeData) != null) {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("nid", agreeData.nid);
                hashMap2.put("tid", agreeData.threadId);
                hashMap2.put("agreeType", String.valueOf(agreeData.agreeType));
                hashMap2.put("hasAgree", agreeData.hasAgree ? "1" : "0");
                hashMap2.put("diffAgreeNum", String.valueOf(agreeData.diffAgreeNum));
                hashMap2.put("agreeNum", String.valueOf(agreeData.agreeNum));
                hashMap2.put("disAgreeNum", String.valueOf(agreeData.disAgreeNum));
                hashMap.put("uniqueKey", "ThreadAgreeChanged");
                hashMap.put("data", hashMap2);
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        }
    };
    private HttpMessageListener mChangePortraitListener = new HttpMessageListener(1003063) { // from class: com.example.utility_plugin.NativeListeners.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("uniqueKey", "ChangePortraitImage");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        }
    };
    private HttpMessageListener mResetUserPicsListener = new HttpMessageListener(1003064) { // from class: com.example.utility_plugin.NativeListeners.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("uniqueKey", "ChangePendantImage");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        }
    };
    private CustomMessageListener mUpdatePendantListener = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.example.utility_plugin.NativeListeners.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                HashMap hashMap = new HashMap();
                hashMap.put("uniqueKey", "ChangeUserProfile");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        }
    };
    private CustomMessageListener mBgRefreshListener = new CustomMessageListener(CmdConfigCustom.CMD_REFRESH_PERSONAL) { // from class: com.example.utility_plugin.NativeListeners.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            HashMap hashMap = new HashMap();
            hashMap.put("uniqueKey", "ChangeUserProfileBackground");
            NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
        }
    };
    private CustomMessageListener mPersonDataChangedListener = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.example.utility_plugin.NativeListeners.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            HashMap hashMap = new HashMap();
            hashMap.put("uniqueKey", "PersonDataChangedNotification");
            NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
        }
    };
    private CustomMessageListener mThreadWriteReplyListener = new CustomMessageListener(CmdConfigCustom.CMD_FORCE_UPDATE_PREPARE_LOCATION_INFO) { // from class: com.example.utility_plugin.NativeListeners.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            HashMap hashMap = new HashMap();
            if (customResponsedMessage.getData() instanceof g) {
                g gVar = (g) customResponsedMessage.getData();
                if (!y.isEmpty(gVar.mPostData)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= gVar.mPostData.size()) {
                            break;
                        }
                        if (gVar.mPostData.get(i2) != null) {
                            hashMap.put(gVar.mPostData.get(i2).getName(), gVar.mPostData.get(i2).getValue());
                        }
                        i = i2 + 1;
                    }
                }
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("tid", hashMap.get("tid"));
            hashMap2.put("nid", hashMap.get("ori_ugc_nid"));
            HashMap hashMap3 = new HashMap();
            hashMap3.put("uniqueKey", "ThreadWriteReplyListener");
            hashMap3.put("data", hashMap2);
            Log.e("native", hashMap.toString());
            NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap3);
        }
    };
    private CustomMessageListener mMainTabClickListener = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.example.utility_plugin.NativeListeners.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                Integer num = (Integer) customResponsedMessage.getData();
                if (num.intValue() == 1 && NativeListeners.this.mLastMainTabIndex == 1) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uniqueKey", "AutoRefreshBarEntry");
                    NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
                } else if (num.intValue() == 2 && NativeListeners.this.mLastMainTabIndex == 2) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("uniqueKey", "AutoRefreshCategory");
                    NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap2);
                }
                NativeListeners.this.mLastMainTabIndex = num.intValue();
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
        MessageListener<?> listererFromKey = getListererFromKey(str);
        if (listererFromKey != null) {
            MessageManager.getInstance().registerListener(listererFromKey);
        }
    }

    public void removeNotificationObserver(String str) {
        MessageListener<?> listererFromKey = getListererFromKey(str);
        if (listererFromKey != null) {
            MessageManager.getInstance().unRegisterListener(listererFromKey);
        }
    }

    private Message getMessageFromName(String str, Object obj) {
        char c = 65535;
        switch (str.hashCode()) {
            case 406924293:
                if (str.equals("kTBCCancleLikeFrsNotification")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                Object argument = argument(obj, "payload");
                if (argument instanceof String) {
                    return new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, (String) argument);
                }
                break;
        }
        return null;
    }

    private ResponsedMessage getResponsedMessageFromName(String str, Object obj) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1789920843:
                if (str.equals("kTBCBroadcastEdditPageResume")) {
                    c = 5;
                    break;
                }
                break;
            case -1017654699:
                if (str.equals("kTBCLikeForumsInfoUpdateNotification")) {
                    c = 0;
                    break;
                }
                break;
            case 332172237:
                if (str.equals("kTBCShareSdkResultNotification")) {
                    c = 2;
                    break;
                }
                break;
            case 558131307:
                if (str.equals("kTBCBroadcastPublishSuccess")) {
                    c = 4;
                    break;
                }
                break;
            case 1749524275:
                if (str.equals("kTBCDeleteFrsSection")) {
                    c = 3;
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
                String str2 = (String) argument(obj, "payload");
                v vVar = new v();
                vVar.setFid(str2);
                vVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                com.baidu.tieba.tbadkCore.writeModel.a aVar = new com.baidu.tieba.tbadkCore.writeModel.a();
                aVar.forumId = b.toLong(str2, 0L);
                aVar.isSuccess = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_LIKE_FORUM, aVar));
                break;
            case 1:
                String str3 = (String) argument(obj, "payload");
                v vVar2 = new v();
                vVar2.setFid(str3);
                vVar2.setLike(0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar2));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, str3));
                break;
            case 2:
                Object argument = argument(obj, "payload");
                if (argument instanceof Boolean) {
                    return new ShareSDKResultMessage(Boolean.valueOf(((Boolean) argument).booleanValue()));
                }
                break;
            case 3:
                Object argument2 = argument(obj, "payload");
                if (argument2 instanceof Integer) {
                    return new CustomResponsedMessage(2921470, Integer.valueOf(((Integer) argument2).intValue()));
                }
                break;
            case 4:
                Object argument3 = argument(obj, "payload");
                if (argument3 instanceof Map) {
                    return new CustomResponsedMessage(2921477, (Map) argument3);
                }
                break;
            case 5:
                Object argument4 = argument(obj, "payload");
                if (argument4 instanceof Integer) {
                    return new CustomResponsedMessage(2921478, Integer.valueOf(((Integer) argument4).intValue()));
                }
                break;
        }
        return null;
    }

    private MessageListener<?> getListererFromKey(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -2111678678:
                if (str.equals("AutoRefreshCategory")) {
                    c = 18;
                    break;
                }
                break;
            case -1967337156:
                if (str.equals("ChangeUserProfileBackground")) {
                    c = '\r';
                    break;
                }
                break;
            case -1702113870:
                if (str.equals("ThreadAgreeChanged")) {
                    c = '\t';
                    break;
                }
                break;
            case -994250872:
                if (str.equals("AppDidEnterBackground")) {
                    c = 1;
                    break;
                }
                break;
            case -815635840:
                if (str.equals("PersonDataChangedNotification")) {
                    c = 14;
                    break;
                }
                break;
            case -712625697:
                if (str.equals("BookMarkUpdate")) {
                    c = 2;
                    break;
                }
                break;
            case -336540695:
                if (str.equals("ThreadWriteReplyListener")) {
                    c = 15;
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
            case 353880651:
                if (str.equals("AutoRefreshBarEntry")) {
                    c = 16;
                    break;
                }
                break;
            case 401543534:
                if (str.equals("ChangeUserProfile")) {
                    c = '\f';
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
            case 757688464:
                if (str.equals("ChangePortraitImage")) {
                    c = '\n';
                    break;
                }
                break;
            case 790383375:
                if (str.equals("ChangePendantImage")) {
                    c = 11;
                    break;
                }
                break;
            case 1499680061:
                if (str.equals("BarBroadcastCopyLink")) {
                    c = '\b';
                    break;
                }
                break;
            case 1599848416:
                if (str.equals("AccountInfoUpdated")) {
                    c = 17;
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
                this.mRemoveForbiddenListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                return this.mRemoveForbiddenListener;
            case 1:
                this.mBackgroundListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                return this.mBackgroundListener;
            case 2:
                this.bookMarksGiftAndFansListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                return this.bookMarksGiftAndFansListener;
            case 3:
                this.bookMarksGiftAndFansListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                return this.bookMarksGiftAndFansListener;
            case 4:
                this.feedBackRedTipListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                return this.feedBackRedTipListener;
            case 5:
                this.syncFinishListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                return this.syncFinishListener;
            case 6:
                this.checkFeedBackListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                return this.checkFeedBackListener;
            case 7:
                this.mSignChangedListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                return this.mSignChangedListener;
            case '\b':
                this.mCopyBarBroadcastLinkListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                return this.mCopyBarBroadcastLinkListener;
            case '\t':
                return this.mThreadAgreeChangedListener;
            case '\n':
                return this.mChangePortraitListener;
            case 11:
                return this.mResetUserPicsListener;
            case '\f':
                return this.mUpdatePendantListener;
            case '\r':
                return this.mBgRefreshListener;
            case 14:
                return this.mPersonDataChangedListener;
            case 15:
                return this.mThreadWriteReplyListener;
            case 16:
                return this.mMainTabClickListener;
            case 17:
                return this.mAccountChangedListener;
            case 18:
                return this.mMainTabClickListener;
            default:
                return null;
        }
    }
}
