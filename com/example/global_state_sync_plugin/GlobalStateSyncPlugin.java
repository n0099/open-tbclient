package com.example.global_state_sync_plugin;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.a.a.k;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.a.e;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.b.a;
import com.baidu.tbadk.youngster.b.c;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes19.dex */
public class GlobalStateSyncPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private static MethodChannel mMethodChannel;
    private static boolean updatingThemeDataByFlutter = false;
    private static boolean updatingLoginUserInfoByFlutter = false;
    private static boolean updatingSyncDataByFlutter = false;
    private static CustomMessageListener skinTypeChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.example.global_state_sync_plugin.GlobalStateSyncPlugin.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                if (GlobalStateSyncPlugin.updatingThemeDataByFlutter) {
                    boolean unused = GlobalStateSyncPlugin.updatingThemeDataByFlutter = false;
                    return;
                }
                GlobalStateSyncPlugin.write(GlobalStateType.kGlobalStateTheme, GlobalStateSubType.kGlobalStateSubTypeNone, GlobalStateSyncPlugin.readThemeData());
            }
        }
    };
    private static CustomMessageListener mAccountChangeListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.example.global_state_sync_plugin.GlobalStateSyncPlugin.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                GlobalStateSyncPlugin.write(GlobalStateType.kGlobalStateLoginUserInfo, GlobalStateSubType.kGlobalStateSubTypeNone, GlobalStateSyncPlugin.readLoginUserData());
            }
        }
    };
    private static CustomMessageListener mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.example.global_state_sync_plugin.GlobalStateSyncPlugin.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371) {
                if (GlobalStateSyncPlugin.updatingSyncDataByFlutter) {
                    boolean unused = GlobalStateSyncPlugin.updatingSyncDataByFlutter = false;
                    return;
                }
                GlobalStateSyncPlugin.write(GlobalStateType.kGlobalStateSyncData, GlobalStateSubType.kGlobalStateSubTypeSyncAll, GlobalStateSyncPlugin.readSyncData());
            }
        }
    };
    private static CustomMessageListener mWriteConfigToFlutterListener = new CustomMessageListener(2921439) { // from class: com.example.global_state_sync_plugin.GlobalStateSyncPlugin.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921439 && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = (HashMap) customResponsedMessage.getData();
                if (!hashMap.containsKey("type")) {
                    hashMap.put("type", Integer.valueOf(GlobalStateType.kGlobalStateSyncData.ordinal()));
                }
                if (!hashMap.containsKey("subType")) {
                    hashMap.put("subType", Integer.valueOf(GlobalStateSubType.kGlobalStateSubTypeNone.ordinal()));
                }
                GlobalStateSyncPlugin.write(hashMap);
            }
        }
    };
    private static CustomMessageListener mPreviewServerChangedListener = new CustomMessageListener(2921508) { // from class: com.example.global_state_sync_plugin.GlobalStateSyncPlugin.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GlobalStateSyncPlugin.write(GlobalStateType.KGlobalStateNetData, GlobalStateSubType.kGlobalStateSubTypeConfigInfo, GlobalStateSyncPlugin.readNetData());
        }
    };
    private static CustomMessageListener mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.example.global_state_sync_plugin.GlobalStateSyncPlugin.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GlobalStateSyncPlugin.write(GlobalStateType.kGlobalStateCommon, GlobalStateSubType.kGlobalStateSubTypeNone, GlobalStateSyncPlugin.readCommonData());
        }
    };

    /* loaded from: classes19.dex */
    public enum GlobalStateSubType {
        kGlobalStateSubTypeNone,
        kGlobalStateSubTypeSyncAll,
        kGlobalStateSubTypeSyncData,
        kGlobalStateSubTypeConfigInfo,
        kGlobalStateSubTypeAppConfig,
        kGlobalStateSubTypeNoticeConfig,
        kGlobalStateSubTypeAdsenseData,
        kGlobalStateSubTypeSwitches,
        kGlobalStateSubTypeCount
    }

    /* loaded from: classes19.dex */
    public enum GlobalStateType {
        kGlobalStateTheme,
        kGlobalStateSyncData,
        KGlobalStateNetData,
        kGlobalStateLoginUserInfo,
        kGlobalStateCommon,
        kGlobalStateAll
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "global_state_sync_plugin").setMethodCallHandler(new GlobalStateSyncPlugin());
        init();
        mMethodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "global_state_sync_plugin");
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    private static void init() {
        mAccountChangeListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        MessageManager.getInstance().registerListener(mAccountChangeListener);
        MessageManager.getInstance().registerListener(skinTypeChangeListener);
        MessageManager.getInstance().registerListener(mSyncFinishListener);
        MessageManager.getInstance().registerListener(mWriteConfigToFlutterListener);
        MessageManager.getInstance().registerListener(mPreviewServerChangedListener);
        MessageManager.getInstance().registerListener(mYoungsterModeChangeListener);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        boolean z;
        if (methodCall.method.equals("read")) {
            if (methodCall.arguments == null) {
                BdLog.e("call.arguments error");
            }
            int intValue = ((Integer) methodCall.arguments).intValue();
            HashMap<String, Object> hashMap = null;
            if (GlobalStateType.kGlobalStateAll.ordinal() == intValue) {
                hashMap = new HashMap<>();
                hashMap.put("themeData", readThemeData());
                hashMap.put("syncData", readSyncData());
                hashMap.put("loginUserInfo", readLoginUserData());
                hashMap.put("commonStates", readCommonData());
                hashMap.put("netStates", readNetData());
            } else if (GlobalStateType.kGlobalStateTheme.ordinal() == intValue) {
                hashMap = readThemeData();
            } else if (GlobalStateType.kGlobalStateSyncData.ordinal() == intValue) {
                hashMap = readSyncData();
            } else if (GlobalStateType.kGlobalStateLoginUserInfo.ordinal() == intValue) {
                hashMap = readLoginUserData();
            } else if (GlobalStateType.kGlobalStateCommon.ordinal() == intValue) {
                hashMap = readCommonData();
            } else if (GlobalStateType.KGlobalStateNetData.ordinal() == intValue) {
                hashMap = readNetData();
            }
            if (hashMap != null) {
                result.success(hashMap);
            }
        } else if (methodCall.method.equals("write")) {
            if (methodCall.arguments == null) {
                BdLog.e("call.arguments error");
            }
            int intValue2 = ((Integer) methodCall.argument("type")).intValue();
            int intValue3 = ((Integer) methodCall.argument("subType")).intValue();
            HashMap<String, Object> hashMap2 = (HashMap) methodCall.argument("data");
            if (GlobalStateType.kGlobalStateTheme.ordinal() == intValue2) {
                z = writeThemeData(((Integer) hashMap2.get(UbcStatConstant.KEY_CONTENT_EXT_MODE)).intValue());
            } else if (GlobalStateType.kGlobalStateSyncData.ordinal() == intValue2) {
                z = writeSyncData(hashMap2, intValue3);
            } else if (GlobalStateType.kGlobalStateLoginUserInfo.ordinal() != intValue2) {
                z = false;
            } else {
                z = writeLoginUserData(hashMap2);
            }
            result.success(Boolean.valueOf(z));
        } else {
            result.notImplemented();
        }
    }

    private boolean writeLoginUserData(HashMap<String, Object> hashMap) {
        updatingLoginUserInfoByFlutter = true;
        if (hashMap.containsKey("memberType")) {
            TbadkCoreApplication.setCurrentMemberType(Integer.valueOf((String) hashMap.get("memberType")).intValue());
        }
        if (hashMap.containsKey("isVisitorMode") && ((Boolean) hashMap.get("isVisitorMode")).booleanValue()) {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
        }
        return true;
    }

    private boolean writeSyncData(HashMap<String, Object> hashMap, int i) {
        int i2;
        if (i != GlobalStateSubType.kGlobalStateSubTypeSyncData.ordinal() && i != GlobalStateSubType.kGlobalStateSubTypeConfigInfo.ordinal() && i != GlobalStateSubType.kGlobalStateSubTypeAppConfig.ordinal() && i != GlobalStateSubType.kGlobalStateSubTypeNoticeConfig.ordinal() && i != GlobalStateSubType.kGlobalStateSubTypeAdsenseData.ordinal() && i == GlobalStateSubType.kGlobalStateSubTypeSwitches.ordinal() && hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                if (entry.getValue() instanceof String) {
                    i2 = "false".equals((String) entry.getValue()) ? 0 : 1;
                } else if (entry.getValue() instanceof Boolean) {
                    i2 = ((Boolean) entry.getValue()).booleanValue() ? 0 : 1;
                }
                updatingSyncDataByFlutter = true;
                SwitchManager.getInstance().turn(entry.getKey(), i2);
            }
        }
        return true;
    }

    private boolean writeThemeData(int i) {
        updatingThemeDataByFlutter = true;
        TbadkCoreApplication.getInst().setSkinType(i);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void write(GlobalStateType globalStateType, GlobalStateSubType globalStateSubType, HashMap<String, Object> hashMap) {
        if (hashMap != null && globalStateType.ordinal() >= GlobalStateType.kGlobalStateTheme.ordinal() && globalStateType.ordinal() <= GlobalStateType.kGlobalStateAll.ordinal() && globalStateSubType.ordinal() >= GlobalStateSubType.kGlobalStateSubTypeNone.ordinal() && globalStateSubType.ordinal() < GlobalStateSubType.kGlobalStateSubTypeCount.ordinal()) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("type", Integer.valueOf(globalStateType.ordinal()));
            hashMap2.put("subType", Integer.valueOf(globalStateSubType.ordinal()));
            hashMap2.put("data", hashMap);
            write(hashMap2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void write(HashMap<String, Object> hashMap) {
        mMethodChannel.invokeMethod("write", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashMap<String, Object> readSyncData() {
        HashMap<String, Object> hashMap = new HashMap<>();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        HashMap hashMap5 = new HashMap();
        HashMap hashMap6 = new HashMap();
        hashMap2.put("financeURL", b.bqh().getString("baidu_finance", null));
        hashMap2.put("personalCellText", TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText());
        hashMap2.put("loginAwardUrl", TbadkCoreApplication.getInst().getActivityPrizeData().getH5Url());
        hashMap2.put("auditPackageSwitch", Integer.valueOf(b.bqh().getBoolean("person_center_show_lite_game", true) ? 1 : 0));
        hashMap2.put("isLiteMode", "0");
        hashMap2.put("isShowShoubaiDynamicGuide", String.valueOf(b.bqh().getInt("key_is_show_shoubai_dynamic_guide", 0)));
        hashMap2.put("isShowBaiduFinanceEntrance", String.valueOf(b.bqh().getInt("baidu_financial_display", 1)));
        hashMap2.put("experimentID", getExperimentID());
        hashMap.put("syncData", hashMap2);
        hashMap.put("configInfo", hashMap3);
        hashMap.put("appConfig", hashMap4);
        hashMap.put("noticeConfig", hashMap5);
        hashMap.put("adsenseData", hashMap6);
        hashMap.put("switches", readSwitches());
        return hashMap;
    }

    private static String getExperimentID() {
        e j = d.j(k.etU);
        if (j != null && !at.isEmpty(j.etT)) {
            String str = j.etT;
            char c = 65535;
            switch (str.hashCode()) {
                case 1687628:
                    if (str.equals("70_2")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1687629:
                    if (str.equals("70_3")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1687630:
                    if (str.equals("70_4")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1687631:
                    if (str.equals("70_5")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1687632:
                    if (str.equals("70_6")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1688589:
                    if (str.equals("71_2")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return "sid_a";
                case 1:
                    return "sid_b";
                case 2:
                    return "sid_c";
                case 3:
                    return "sid_d";
                case 4:
                    return "sid_e";
                case 5:
                    return "sid_f";
            }
        }
        return "";
    }

    private static HashMap<String, Object> readSwitches() {
        HashMap<String, Object> hashMap = new HashMap<>();
        HashMap<String, Integer> baseSwitchs = SwitchManager.getInstance().getBaseSwitchs();
        if (baseSwitchs != null && baseSwitchs.size() > 0) {
            for (Map.Entry<String, Integer> entry : baseSwitchs.entrySet()) {
                hashMap.put(entry.getKey(), Boolean.valueOf(entry.getValue().intValue() >= 1));
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashMap<String, Object> readNetData() {
        HashMap<String, Object> hashMap = new HashMap<>();
        String buk = a.buh().buk();
        hashMap.put("keepAliveWifi", Integer.valueOf(TbadkCoreApplication.getInst().getKeepaliveWifi()));
        hashMap.put("keepAliveNoWifi", Integer.valueOf(TbadkCoreApplication.getInst().getKeepaliveNonWifi()));
        hashMap.put("puEnvValue", TbSingleton.getInstance().getPubEnvValue());
        hashMap.put("isVisitPreviewServer", Boolean.valueOf(TbSingleton.getInstance().isVisitPreviewServer()));
        hashMap.put("sCookie", buk);
        hashMap.put("proxyIp", TbadkCoreApplication.getInst().getProxyIp());
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashMap<String, Object> readCommonData() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("isOnLine", Boolean.valueOf(!BdBaseApplication.getInst().isDebugMode()));
        hashMap.put("isOfficial", Boolean.valueOf(TbadkCoreApplication.getInst().isOfficial()));
        hashMap.put("clientVersion", TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            hashMap.put("phoneImei", TbadkCoreApplication.getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            hashMap.put("clientID", clientId);
        }
        String subappType = TbConfig.getSubappType();
        if (!TextUtils.isEmpty(subappType)) {
            hashMap.put("subAppType", subappType);
        }
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            hashMap.put("appFrom", from);
        }
        hashMap.put("cuid", TbadkCoreApplication.getInst().getCuid());
        hashMap.put("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        hashMap.put("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
        hashMap.put("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
        hashMap.put("z_id", TbadkCoreApplication.getInst().getZid());
        hashMap.put("model", Build.MODEL);
        hashMap.put("teenMode", Boolean.valueOf(c.bHs()));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashMap<String, Object> readLoginUserData() {
        HashMap<String, Object> hashMap = new HashMap<>();
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        hashMap.put("isValidAccount", Boolean.valueOf(currentAccountInfo != null));
        hashMap.put("id", TbadkCoreApplication.getCurrentAccount());
        if (currentAccountInfo != null) {
            hashMap.put("name", currentAccountInfo.getDisplayName());
            hashMap.put("sToken", currentAccountInfo.getStoken());
            hashMap.put("genderInt", Integer.valueOf(currentAccountInfo.getSex()));
            hashMap.put("level", currentAccountInfo.getLiveLevel() + "");
        } else {
            hashMap.put("name", null);
            hashMap.put("sToken", null);
            hashMap.put("genderInt", 0);
            hashMap.put("level", null);
        }
        hashMap.put("nickName", TbadkCoreApplication.getCurrentAccountNameShow());
        hashMap.put("bduss", TbadkCoreApplication.getCurrentBduss());
        hashMap.put("tbs", TbadkCoreApplication.getInst().getTbs());
        hashMap.put("portrait", TbadkCoreApplication.getCurrentPortrait());
        hashMap.put("isMember", Boolean.valueOf(TbadkCoreApplication.getCurrentMemberType() > 0));
        hashMap.put("isAdvancedMember", Boolean.valueOf(TbadkCoreApplication.getCurrentMemberType() == 2));
        hashMap.put("memberInfo", TbadkCoreApplication.getCurrentMemberType() + "");
        hashMap.put("isVisitorMode", Boolean.valueOf(TbadkCoreApplication.isLogin() ? false : true));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashMap<String, Object> readThemeData() {
        HashMap<String, Object> hashMap = new HashMap<>();
        String brh = ap.brh();
        HashMap hashMap2 = new HashMap();
        hashMap.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, brh);
        hashMap.put("colors", hashMap2);
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        hashMap2.put("default", hashMap3);
        hashMap2.put(ComboPraiseProvider.DIR_PREFIX_NIGHT, hashMap4);
        return hashMap;
    }
}
