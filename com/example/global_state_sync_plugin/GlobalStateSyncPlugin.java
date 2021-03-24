package com.example.global_state_sync_plugin;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import d.b.b.e.p.k;
import d.b.h0.b.d;
import d.b.h0.b.e;
import d.b.h0.b.f.s;
import d.b.h0.c1.b.c;
import d.b.h0.r.d0.b;
import d.b.h0.s.b.a;
import d.b.h0.z0.m0;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class GlobalStateSyncPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static MethodChannel mMethodChannel = null;
    public static boolean updatingSyncDataByFlutter = false;
    public static boolean updatingThemeDataByFlutter = false;
    public static CustomMessageListener skinTypeChangeListener = new CustomMessageListener(2001304) { // from class: com.example.global_state_sync_plugin.GlobalStateSyncPlugin.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001304) {
                return;
            }
            if (GlobalStateSyncPlugin.updatingThemeDataByFlutter) {
                boolean unused = GlobalStateSyncPlugin.updatingThemeDataByFlutter = false;
                return;
            }
            GlobalStateSyncPlugin.write(GlobalStateType.kGlobalStateTheme, GlobalStateSubType.kGlobalStateSubTypeNone, GlobalStateSyncPlugin.readThemeData());
        }
    };
    public static CustomMessageListener mAccountChangeListener = new CustomMessageListener(2005016) { // from class: com.example.global_state_sync_plugin.GlobalStateSyncPlugin.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016) {
                return;
            }
            GlobalStateSyncPlugin.write(GlobalStateType.kGlobalStateLoginUserInfo, GlobalStateSubType.kGlobalStateSubTypeNone, GlobalStateSyncPlugin.readLoginUserData());
        }
    };
    public static CustomMessageListener mSyncFinishListener = new CustomMessageListener(2001371) { // from class: com.example.global_state_sync_plugin.GlobalStateSyncPlugin.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371) {
                return;
            }
            if (GlobalStateSyncPlugin.updatingSyncDataByFlutter) {
                boolean unused = GlobalStateSyncPlugin.updatingSyncDataByFlutter = false;
                return;
            }
            GlobalStateSyncPlugin.write(GlobalStateType.kGlobalStateSyncData, GlobalStateSubType.kGlobalStateSubTypeSyncAll, GlobalStateSyncPlugin.readSyncData());
        }
    };
    public static CustomMessageListener mWriteConfigToFlutterListener = new CustomMessageListener(2921439) { // from class: com.example.global_state_sync_plugin.GlobalStateSyncPlugin.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921439 && (customResponsedMessage.getData() instanceof HashMap)) {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = (HashMap) customResponsedMessage.getData();
                if (!hashMap.containsKey("type")) {
                    hashMap.put("type", Integer.valueOf(GlobalStateType.kGlobalStateSyncData.ordinal()));
                }
                if (!hashMap.containsKey("subType")) {
                    hashMap.put("subType", Integer.valueOf(GlobalStateSubType.kGlobalStateSubTypeNone.ordinal()));
                }
                hashMap.put("data", hashMap2);
                GlobalStateSyncPlugin.write(hashMap2);
            }
        }
    };
    public static CustomMessageListener mPreviewServerChangedListener = new CustomMessageListener(2921508) { // from class: com.example.global_state_sync_plugin.GlobalStateSyncPlugin.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GlobalStateSyncPlugin.write(GlobalStateType.KGlobalStateNetData, GlobalStateSubType.kGlobalStateSubTypeConfigInfo, GlobalStateSyncPlugin.readNetData());
        }
    };
    public static CustomMessageListener mAutoPaySettingChanged = new CustomMessageListener(2921511) { // from class: com.example.global_state_sync_plugin.GlobalStateSyncPlugin.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GlobalStateSyncPlugin.write(GlobalStateType.kGlobalStateCommon, GlobalStateSubType.kGlobalStateSubTypeNone, GlobalStateSyncPlugin.readCommonData());
        }
    };
    public static CustomMessageListener mYoungsterModeChangeListener = new CustomMessageListener(2921509) { // from class: com.example.global_state_sync_plugin.GlobalStateSyncPlugin.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GlobalStateSyncPlugin.write(GlobalStateType.kGlobalStateCommon, GlobalStateSubType.kGlobalStateSubTypeNone, GlobalStateSyncPlugin.readCommonData());
        }
    };

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public enum GlobalStateType {
        kGlobalStateTheme,
        kGlobalStateSyncData,
        KGlobalStateNetData,
        kGlobalStateLoginUserInfo,
        kGlobalStateCommon,
        kGlobalStateAll
    }

    public static String getExperimentID() {
        e b2 = d.b(s.f49743c);
        if (b2 == null || k.isEmpty(b2.f49694a)) {
            return "";
        }
        String str = b2.f49694a;
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 1688589) {
            switch (hashCode) {
                case 1687628:
                    if (str.equals("70_2")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1687629:
                    if (str.equals("70_3")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1687630:
                    if (str.equals("70_4")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1687631:
                    if (str.equals("70_5")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1687632:
                    if (str.equals("70_6")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
        } else if (str.equals("71_2")) {
            c2 = 5;
        }
        return c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? c2 != 4 ? c2 != 5 ? "" : "sid_f" : "sid_e" : "sid_d" : "sid_c" : "sid_b" : "sid_a";
    }

    public static void init() {
        mAccountChangeListener.setPriority(Integer.MAX_VALUE);
        MessageManager.getInstance().registerListener(mAccountChangeListener);
        MessageManager.getInstance().registerListener(skinTypeChangeListener);
        MessageManager.getInstance().registerListener(mSyncFinishListener);
        MessageManager.getInstance().registerListener(mWriteConfigToFlutterListener);
        MessageManager.getInstance().registerListener(mPreviewServerChangedListener);
        MessageManager.getInstance().registerListener(mYoungsterModeChangeListener);
        MessageManager.getInstance().registerListener(mAutoPaySettingChanged);
    }

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
        hashMap.put("isVideoAutoPlay", Boolean.valueOf(m0.d()));
        hashMap.put("cuid", TbadkCoreApplication.getInst().getCuid());
        hashMap.put(TiebaStatic.Params.CUID_GALAXY2, TbadkCoreApplication.getInst().getCuidGalaxy2());
        hashMap.put("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
        hashMap.put(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
        hashMap.put("z_id", TbadkCoreApplication.getInst().getZid());
        hashMap.put("model", Build.MODEL);
        hashMap.put("teenMode", Boolean.valueOf(c.d()));
        hashMap.put("sdk_ver", TbadkCoreApplication.getInst().getSdk_ver());
        hashMap.put("framework_ver", TbadkCoreApplication.getInst().getFramework_ver());
        hashMap.put("swan_game_ver", TbadkCoreApplication.getInst().getSwan_game_ver());
        return hashMap;
    }

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
        hashMap.put(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
        hashMap.put("portrait", TbadkCoreApplication.getCurrentPortrait());
        hashMap.put("isMember", Boolean.valueOf(TbadkCoreApplication.getCurrentMemberType() > 0));
        hashMap.put("isAdvancedMember", Boolean.valueOf(TbadkCoreApplication.getCurrentMemberType() == 2));
        hashMap.put("memberInfo", TbadkCoreApplication.getCurrentMemberType() + "");
        hashMap.put("isVisitorMode", Boolean.valueOf(TbadkCoreApplication.isLogin() ^ true));
        return hashMap;
    }

    public static HashMap<String, Object> readNetData() {
        HashMap<String, Object> hashMap = new HashMap<>();
        String a2 = a.b().a();
        hashMap.put("keepAliveWifi", Integer.valueOf(TbadkCoreApplication.getInst().getKeepaliveWifi()));
        hashMap.put("keepAliveNoWifi", Integer.valueOf(TbadkCoreApplication.getInst().getKeepaliveNonWifi()));
        hashMap.put("puEnvValue", TbSingleton.getInstance().getPubEnvValue());
        hashMap.put("isVisitPreviewServer", Boolean.valueOf(TbSingleton.getInstance().isVisitPreviewServer()));
        hashMap.put("sCookie", a2);
        return hashMap;
    }

    public static HashMap<String, Object> readSwitches() {
        HashMap<String, Object> hashMap = new HashMap<>();
        HashMap<String, Integer> baseSwitchs = SwitchManager.getInstance().getBaseSwitchs();
        if (baseSwitchs != null && baseSwitchs.size() > 0) {
            for (Map.Entry<String, Integer> entry : baseSwitchs.entrySet()) {
                String key = entry.getKey();
                boolean z = true;
                if (entry.getValue().intValue() < 1) {
                    z = false;
                }
                hashMap.put(key, Boolean.valueOf(z));
            }
        }
        return hashMap;
    }

    public static HashMap<String, Object> readSyncData() {
        HashMap<String, Object> hashMap = new HashMap<>();
        HashMap hashMap2 = new HashMap();
        Object hashMap3 = new HashMap();
        Object hashMap4 = new HashMap();
        Object hashMap5 = new HashMap();
        Object hashMap6 = new HashMap();
        hashMap2.put("financeURL", b.i().o("baidu_finance", null));
        hashMap2.put("personalCellText", TbadkCoreApplication.getInst().getActivityPrizeData().e());
        hashMap2.put("loginAwardUrl", TbadkCoreApplication.getInst().getActivityPrizeData().c());
        hashMap2.put("auditPackageSwitch", Integer.valueOf(b.i().g("person_center_show_lite_game", true) ? 1 : 0));
        hashMap2.put("isLiteMode", "0");
        hashMap2.put("isShowShoubaiDynamicGuide", String.valueOf(b.i().j("key_is_show_shoubai_dynamic_guide", 0)));
        hashMap2.put("isShowBaiduFinanceEntrance", String.valueOf(b.i().j("baidu_financial_display", 1)));
        hashMap2.put("experimentID", getExperimentID());
        hashMap2.put("userSmallPhotoHost", TbConfig.getPhotoSmallAddress());
        hashMap2.put("userBigPhotoHost", TbConfig.getBigPhotoAdress());
        hashMap.put("syncData", hashMap2);
        hashMap.put("configInfo", hashMap3);
        hashMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, hashMap4);
        hashMap.put("noticeConfig", hashMap5);
        hashMap.put("adsenseData", hashMap6);
        hashMap.put("switches", readSwitches());
        hashMap.put("experimentCommonFeedCardID", d.g() ? "12_0_B_brand_level_a" : "12_0_B_brand_level");
        hashMap.put("proxyIp", TbadkCoreApplication.getInst().getProxyIp());
        hashMap.put("proxyPort", TbadkCoreApplication.getInst().getProxyPort());
        return hashMap;
    }

    public static HashMap<String, Object> readThemeData() {
        HashMap<String, Object> hashMap = new HashMap<>();
        String currentSkinTypeString = SkinManager.getCurrentSkinTypeString();
        HashMap hashMap2 = new HashMap();
        hashMap.put("mode", currentSkinTypeString);
        hashMap.put("colors", hashMap2);
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        hashMap2.put("default", hashMap3);
        hashMap2.put(SkinManager.SKIN_TYPE_STR_NIGHT, hashMap4);
        return hashMap;
    }

    public static void write(GlobalStateType globalStateType, GlobalStateSubType globalStateSubType, HashMap<String, Object> hashMap) {
        if (hashMap == null || globalStateType.ordinal() < GlobalStateType.kGlobalStateTheme.ordinal() || globalStateType.ordinal() > GlobalStateType.kGlobalStateAll.ordinal() || globalStateSubType.ordinal() < GlobalStateSubType.kGlobalStateSubTypeNone.ordinal() || globalStateSubType.ordinal() >= GlobalStateSubType.kGlobalStateSubTypeCount.ordinal()) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("type", Integer.valueOf(globalStateType.ordinal()));
        hashMap2.put("subType", Integer.valueOf(globalStateSubType.ordinal()));
        hashMap2.put("data", hashMap);
        write(hashMap2);
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

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
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
        } else if (methodCall.method.equals(AlbumActivityConfig.FROM_WRITE)) {
            if (methodCall.arguments == null) {
                BdLog.e("call.arguments error");
            }
            boolean z = false;
            int intValue2 = ((Integer) methodCall.argument("type")).intValue();
            int intValue3 = ((Integer) methodCall.argument("subType")).intValue();
            HashMap<String, Object> hashMap2 = (HashMap) methodCall.argument("data");
            if (GlobalStateType.kGlobalStateTheme.ordinal() == intValue2) {
                z = writeThemeData(((Integer) hashMap2.get("mode")).intValue());
            } else if (GlobalStateType.kGlobalStateSyncData.ordinal() == intValue2) {
                z = writeSyncData(hashMap2, intValue3);
            } else if (GlobalStateType.kGlobalStateLoginUserInfo.ordinal() == intValue2) {
                z = writeLoginUserData(hashMap2);
            }
            result.success(Boolean.valueOf(z));
        } else {
            result.notImplemented();
        }
    }

    public final boolean writeLoginUserData(HashMap<String, Object> hashMap) {
        if (hashMap.containsKey("memberType")) {
            TbadkCoreApplication.setCurrentMemberType(Integer.valueOf((String) hashMap.get("memberType")).intValue());
        }
        if (hashMap.containsKey("isVisitorMode") && ((Boolean) hashMap.get("isVisitorMode")).booleanValue()) {
            TbadkCoreApplication.setCurrentAccount(null, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            return true;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v17, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean writeSyncData(HashMap<String, Object> hashMap, int i) {
        boolean equals;
        if (i != GlobalStateSubType.kGlobalStateSubTypeSyncData.ordinal() && i != GlobalStateSubType.kGlobalStateSubTypeConfigInfo.ordinal() && i != GlobalStateSubType.kGlobalStateSubTypeAppConfig.ordinal() && i != GlobalStateSubType.kGlobalStateSubTypeNoticeConfig.ordinal() && i != GlobalStateSubType.kGlobalStateSubTypeAdsenseData.ordinal() && i == GlobalStateSubType.kGlobalStateSubTypeSwitches.ordinal() && hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                if (entry.getValue() instanceof String) {
                    equals = "false".equals((String) entry.getValue());
                } else if (entry.getValue() instanceof Boolean) {
                    equals = ((Boolean) entry.getValue()).booleanValue();
                }
                int i2 = !equals;
                updatingSyncDataByFlutter = true;
                SwitchManager.getInstance().turn(entry.getKey(), i2);
            }
        }
        return true;
    }

    public final boolean writeThemeData(int i) {
        updatingThemeDataByFlutter = true;
        TbadkCoreApplication.getInst().setSkinType(i);
        return true;
    }

    public static void write(HashMap<String, Object> hashMap) {
        mMethodChannel.invokeMethod(AlbumActivityConfig.FROM_WRITE, hashMap);
    }
}
