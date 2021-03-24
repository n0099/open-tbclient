package com.example.utility_plugin;

import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.NetWorkParam;
import com.baidu.tbadk.coreExtra.message.ShareSDKResultMessage;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import d.b.h0.r.a0.b;
import d.b.h0.t.m;
import d.b.i0.c3.h0.e;
import d.b.i0.c3.w;
import d.b.i0.s2.a;
import io.flutter.Log;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class NativeListeners {
    public CustomMessageListener checkFeedBackListener;
    public CustomMessageListener mAnimateToBarEntryForumSquare;
    public CustomMessageListener mBgRefreshListener;
    public HttpMessageListener mChangePortraitListener;
    public CustomMessageListener mMainTabClickListener;
    public MethodChannel mMethodChannel;
    public CustomMessageListener mPersonDataChangedListener;
    public HttpMessageListener mResetUserPicsListener;
    public CustomMessageListener mSendPrePageKeyToFlutterWhenTabChangedListener;
    public CustomMessageListener mSendPrePageKeyToPersonCenterFlutterPage;
    public CustomMessageListener mThreadAgreeChangedListener;
    public CustomMessageListener mThreadWriteReplyListener;
    public CustomMessageListener mUpdatePendantListener;
    public CustomMessageListener mUpdateShareNumListener;
    public CustomMessageListener mWritePostSuccessListener;
    public CustomMessageListener syncFinishListener;
    public int mLastMainTabIndex = -1;
    public CustomMessageListener mVolumeUpOnKeyDownListener = new CustomMessageListener(2921381) { // from class: com.example.utility_plugin.NativeListeners.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof KeyEvent)) {
                return;
            }
            KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                HashMap hashMap = new HashMap();
                hashMap.put("uniqueKey", "VolumeUpOnKeyDownNotification");
                HashMap hashMap2 = new HashMap();
                hashMap2.put("keyValue", 24);
                hashMap.put("data", hashMap2);
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        }
    };
    public final CustomMessageListener bookMarksGiftAndFansListener = new CustomMessageListener(2001120) { // from class: com.example.utility_plugin.NativeListeners.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            if (a.v().B()) {
                HashMap hashMap = new HashMap();
                hashMap.put("uniqueKey", "FansCountUpdate");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            } else if (a.v().A()) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("uniqueKey", "BookMarkUpdate");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap2);
            }
        }
    };
    public final CustomMessageListener mSignChangedListener = new CustomMessageListener(2001222) { // from class: com.example.utility_plugin.NativeListeners.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SignData signData;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof SignData) || (signData = (SignData) customResponsedMessage.getData()) == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap2.put(TbTitleActivityConfig.FORUM_ID, signData.forumId);
            hashMap2.put("signFlag", String.valueOf(signData.is_signed));
            hashMap.put("uniqueKey", "LikeForumsSign");
            hashMap.put("object", hashMap2);
            NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
        }
    };
    public final CustomMessageListener mCopyBarBroadcastLinkListener = new CustomMessageListener(2921472) { // from class: com.example.utility_plugin.NativeListeners.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str = (String) customResponsedMessage.getData();
            if (str == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap2.put(ForumBroadcastHelper.KEY_PARMARS_BCAST_THREADLINK, str);
            hashMap.put("uniqueKey", "BarBroadcastCopyLink");
            hashMap.put("data", hashMap2);
            NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
        }
    };
    public HttpMessageListener mRemoveForbiddenListener = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_ALL_FORBIDDEN_FANS) { // from class: com.example.utility_plugin.NativeListeners.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("uniqueKey", "MultiRemoveBlockFans");
            NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
        }
    };
    public CustomMessageListener mAccountChangedListener = new CustomMessageListener(2001247) { // from class: com.example.utility_plugin.NativeListeners.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001247) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("uniqueKey", "AccountInfoUpdated");
            NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
        }
    };
    public CustomMessageListener mBackgroundListener = new CustomMessageListener(2001011) { // from class: com.example.utility_plugin.NativeListeners.7
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
                    } catch (Exception e2) {
                        BdLog.e(e2);
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
    public CustomMessageListener feedBackRedTipListener = new CustomMessageListener(2016561) { // from class: com.example.utility_plugin.NativeListeners.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("uniqueKey", "ServiceCenterUpdate");
            NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
        }
    };

    public NativeListeners(MethodChannel methodChannel) {
        new CustomMessageListener(2016459) { // from class: com.example.utility_plugin.NativeListeners.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("uniqueKey", "ServiceCenterUpdate");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        };
        this.checkFeedBackListener = new CustomMessageListener(2016560) { // from class: com.example.utility_plugin.NativeListeners.10
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
        this.syncFinishListener = new CustomMessageListener(2001371) { // from class: com.example.utility_plugin.NativeListeners.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                HashMap hashMap = new HashMap();
                hashMap.put("uniqueKey", "SyncComplete");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        };
        this.mThreadAgreeChangedListener = new CustomMessageListener(2016528) { // from class: com.example.utility_plugin.NativeListeners.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AgreeData agreeData;
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof e) || (agreeData = ((e) customResponsedMessage.getData()).f53376b) == null) {
                    return;
                }
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
        };
        this.mChangePortraitListener = new HttpMessageListener(CmdConfigHttp.CMD_CHANGE_PORTRAIT) { // from class: com.example.utility_plugin.NativeListeners.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("uniqueKey", "ChangePortraitImage");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        };
        this.mResetUserPicsListener = new HttpMessageListener(CmdConfigHttp.CMD_SET_USER_PICS) { // from class: com.example.utility_plugin.NativeListeners.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("uniqueKey", "ChangePendantImage");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        };
        this.mUpdatePendantListener = new CustomMessageListener(2016485) { // from class: com.example.utility_plugin.NativeListeners.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof m)) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("uniqueKey", "ChangeUserProfile");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        };
        this.mBgRefreshListener = new CustomMessageListener(2921004) { // from class: com.example.utility_plugin.NativeListeners.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                HashMap hashMap = new HashMap();
                hashMap.put("uniqueKey", "ChangeUserProfileBackground");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        };
        this.mPersonDataChangedListener = new CustomMessageListener(2001380) { // from class: com.example.utility_plugin.NativeListeners.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                HashMap hashMap = new HashMap();
                hashMap.put("uniqueKey", "PersonDataChangedNotification");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        };
        this.mWritePostSuccessListener = new CustomMessageListener(2001375) { // from class: com.example.utility_plugin.NativeListeners.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                HashMap hashMap = new HashMap();
                hashMap.put("uniqueKey", "WritePostSuccess");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        };
        this.mUpdateShareNumListener = new CustomMessageListener(2921417) { // from class: com.example.utility_plugin.NativeListeners.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof String)) {
                    return;
                }
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("tid", str);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("uniqueKey", "KTBShareNumberPlus");
                hashMap2.put("data", hashMap);
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap2);
            }
        };
        this.mThreadWriteReplyListener = new CustomMessageListener(2921344) { // from class: com.example.utility_plugin.NativeListeners.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                HashMap hashMap = new HashMap();
                if (customResponsedMessage.getData() instanceof NetWorkParam) {
                    NetWorkParam netWorkParam = (NetWorkParam) customResponsedMessage.getData();
                    if (!ListUtils.isEmpty(netWorkParam.mPostData)) {
                        for (int i = 0; i < netWorkParam.mPostData.size(); i++) {
                            if (netWorkParam.mPostData.get(i) != null) {
                                hashMap.put(netWorkParam.mPostData.get(i).getName(), netWorkParam.mPostData.get(i).getValue());
                            }
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
        this.mMainTabClickListener = new CustomMessageListener(2001384) { // from class: com.example.utility_plugin.NativeListeners.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Integer)) {
                    return;
                }
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
        };
        this.mSendPrePageKeyToFlutterWhenTabChangedListener = new CustomMessageListener(2921520) { // from class: com.example.utility_plugin.NativeListeners.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || StringUtil.isEmpty((String) customResponsedMessage.getData())) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(TiebaStatic.Params.OBJ_PRE_PAGE, (String) customResponsedMessage.getData());
                HashMap hashMap2 = new HashMap();
                hashMap2.put("uniqueKey", "kUIApplicationSwitchTabNotification");
                hashMap2.put("data", hashMap);
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap2);
            }
        };
        this.mAnimateToBarEntryForumSquare = new CustomMessageListener(2921528) { // from class: com.example.utility_plugin.NativeListeners.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null) {
                    return;
                }
                b.f50415c = b.f50416d;
                HashMap hashMap = new HashMap();
                hashMap.put("uniqueKey", "AnimateToBarEntryForumSquare");
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap);
            }
        };
        this.mSendPrePageKeyToPersonCenterFlutterPage = new CustomMessageListener(2921521) { // from class: com.example.utility_plugin.NativeListeners.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || StringUtil.isEmpty((String) customResponsedMessage.getData())) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(TiebaStatic.Params.OBJ_PRE_PAGE, (String) customResponsedMessage.getData());
                HashMap hashMap2 = new HashMap();
                hashMap2.put("uniqueKey", "kUIApplicationEnterPersonalCenterByClickNotification");
                hashMap2.put("data", hashMap);
                NativeListeners.this.mMethodChannel.invokeMethod("onNotification", hashMap2);
            }
        };
        this.mMethodChannel = methodChannel;
    }

    public void addNotificationObserver(String str) {
        MessageListener<?> listererFromKey = getListererFromKey(str);
        if (listererFromKey != null) {
            MessageManager.getInstance().registerListener(listererFromKey);
        }
        dealBeforeAttachNotification(str);
    }

    public <T> T argument(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        try {
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        if (obj instanceof Map) {
            return (T) ((Map) obj).get(str);
        }
        if (obj instanceof JSONObject) {
            return (T) ((JSONObject) obj).opt(str);
        }
        return null;
    }

    public final void dealBeforeAttachNotification(String str) {
        if ("AnimateToBarEntryForumSquare".equals(str) && b.f50415c == b.f50417e) {
            d.b.b.e.m.e.a().postDelayed(new Runnable(this) { // from class: com.example.utility_plugin.NativeListeners.25
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921528));
                }
            }, 300L);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final MessageListener<?> getListererFromKey(String str) {
        char c2;
        switch (str.hashCode()) {
            case -2135388668:
                if (str.equals("WritePostSuccess")) {
                    c2 = 18;
                    break;
                }
                c2 = 65535;
                break;
            case -2111678678:
                if (str.equals("AutoRefreshCategory")) {
                    c2 = 20;
                    break;
                }
                c2 = 65535;
                break;
            case -1967337156:
                if (str.equals("ChangeUserProfileBackground")) {
                    c2 = '\r';
                    break;
                }
                c2 = 65535;
                break;
            case -1702113870:
                if (str.equals("ThreadAgreeChanged")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case -994250872:
                if (str.equals("AppDidEnterBackground")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case -815635840:
                if (str.equals("PersonDataChangedNotification")) {
                    c2 = 14;
                    break;
                }
                c2 = 65535;
                break;
            case -739728061:
                if (str.equals("AnimateToBarEntryForumSquare")) {
                    c2 = 23;
                    break;
                }
                c2 = 65535;
                break;
            case -712625697:
                if (str.equals("BookMarkUpdate")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -336540695:
                if (str.equals("ThreadWriteReplyListener")) {
                    c2 = 16;
                    break;
                }
                c2 = 65535;
                break;
            case -241869128:
                if (str.equals("FansCountUpdate")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 79574153:
                if (str.equals("KTBShareNumberPlus")) {
                    c2 = 15;
                    break;
                }
                c2 = 65535;
                break;
            case 215365908:
                if (str.equals("SyncComplete")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 220510267:
                if (str.equals("kUIApplicationSwitchTabNotification")) {
                    c2 = 21;
                    break;
                }
                c2 = 65535;
                break;
            case 353880651:
                if (str.equals("AutoRefreshBarEntry")) {
                    c2 = 17;
                    break;
                }
                c2 = 65535;
                break;
            case 401543534:
                if (str.equals("ChangeUserProfile")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case 438746368:
                if (str.equals("kUIApplicationEnterPersonalCenterByClickNotification")) {
                    c2 = 22;
                    break;
                }
                c2 = 65535;
                break;
            case 463822814:
                if (str.equals("ServiceCenterCheck")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 483157862:
                if (str.equals("LikeForumsSign")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 541940592:
                if (str.equals("MultiRemoveBlockFans")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 757688464:
                if (str.equals("ChangePortraitImage")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 790383375:
                if (str.equals("ChangePendantImage")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case 1499680061:
                if (str.equals("BarBroadcastCopyLink")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 1599848416:
                if (str.equals("AccountInfoUpdated")) {
                    c2 = 19;
                    break;
                }
                c2 = 65535;
                break;
            case 1714732632:
                if (str.equals("VolumeUpOnKeyDownNotification")) {
                    c2 = 24;
                    break;
                }
                c2 = 65535;
                break;
            case 2016286899:
                if (str.equals("ServiceCenterUpdate")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
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
            case '\b':
                this.mCopyBarBroadcastLinkListener.setPriority(Integer.MAX_VALUE);
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
                return this.mUpdateShareNumListener;
            case 16:
                return this.mThreadWriteReplyListener;
            case 17:
                if (this.mLastMainTabIndex == -1) {
                    this.mLastMainTabIndex = 1;
                }
                return this.mMainTabClickListener;
            case 18:
                return this.mWritePostSuccessListener;
            case 19:
                return this.mAccountChangedListener;
            case 20:
                if (this.mLastMainTabIndex == -1) {
                    this.mLastMainTabIndex = 2;
                }
                return this.mMainTabClickListener;
            case 21:
                return this.mSendPrePageKeyToFlutterWhenTabChangedListener;
            case 22:
                return this.mSendPrePageKeyToPersonCenterFlutterPage;
            case 23:
                return this.mAnimateToBarEntryForumSquare;
            case 24:
                return this.mVolumeUpOnKeyDownListener;
            default:
                return null;
        }
    }

    public final Message getMessageFromName(String str, Object obj) {
        if (((str.hashCode() == 406924293 && str.equals("kTBCCancleLikeFrsNotification")) ? (char) 0 : (char) 65535) != 0) {
            return null;
        }
        Object argument = argument(obj, "payload");
        if (argument instanceof String) {
            return new CustomMessage(2003004, (String) argument);
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final ResponsedMessage getResponsedMessageFromName(String str, Object obj) {
        char c2;
        switch (str.hashCode()) {
            case -1789920843:
                if (str.equals("kTBCBroadcastEdditPageResume")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -1017654699:
                if (str.equals("kTBCLikeForumsInfoUpdateNotification")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 332172237:
                if (str.equals("kTBCShareSdkResultNotification")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 558131307:
                if (str.equals("kTBCBroadcastPublishSuccess")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1749524275:
                if (str.equals("kTBCDeleteFrsSection")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1973571011:
                if (str.equals("kTBCLikeForumsInfoDeletedNotification")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            String str2 = (String) argument(obj, "payload");
            w wVar = new w();
            wVar.s(str2);
            wVar.v(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
            d.b.i0.c3.q0.e eVar = new d.b.i0.c3.q0.e();
            eVar.f53593a = d.b.b.e.m.b.f(str2, 0L);
            eVar.f53594b = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001437, eVar));
            return null;
        } else if (c2 == 1) {
            String str3 = (String) argument(obj, "payload");
            w wVar2 = new w();
            wVar2.s(str3);
            wVar2.v(0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2003004, str3));
            return null;
        } else if (c2 == 2) {
            Object argument = argument(obj, "payload");
            if (argument instanceof Boolean) {
                return new ShareSDKResultMessage(Boolean.valueOf(((Boolean) argument).booleanValue()));
            }
            return null;
        } else if (c2 == 3) {
            Object argument2 = argument(obj, "payload");
            if (argument2 instanceof Integer) {
                return new CustomResponsedMessage(2921470, Integer.valueOf(((Integer) argument2).intValue()));
            }
            return null;
        } else if (c2 == 4) {
            Object argument3 = argument(obj, "payload");
            if (argument3 instanceof Map) {
                return new CustomResponsedMessage(2921477, (Map) argument3);
            }
            return null;
        } else if (c2 != 5) {
            return null;
        } else {
            Object argument4 = argument(obj, "payload");
            if (argument4 instanceof Integer) {
                return new CustomResponsedMessage(2921478, Integer.valueOf(((Integer) argument4).intValue()));
            }
            return null;
        }
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

    public void removeNotificationObserver(String str) {
        MessageListener<?> listererFromKey = getListererFromKey(str);
        if (listererFromKey != null) {
            MessageManager.getInstance().unRegisterListener(listererFromKey);
        }
    }
}
