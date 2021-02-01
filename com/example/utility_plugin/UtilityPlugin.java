package com.example.utility_plugin;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.card.Align;
import com.baidu.card.ab;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.a.c;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.e.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.messageCenter.f;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mutiprocess.g;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tbadk.util.al;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.tieba.im.settingcache.d;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import com.baidu.tieba.myCollection.baseHistory.a;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UtilityPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private static NativeListeners mNativeListeners;
    private final CacheModel.a<a> callback = new CacheModel.a<a>() { // from class: com.example.utility_plugin.UtilityPlugin.4
        @Override // com.baidu.tbadk.mvc.model.CacheModel.a
        public void onCacheDataGet(ReadCacheRespMsg<List<a>> readCacheRespMsg, ReadCacheMessage<a> readCacheMessage) {
            if (readCacheRespMsg != null && readCacheRespMsg.getData() != null) {
                List<a> data = readCacheRespMsg.getData();
                if (UtilityPlugin.this.mHistoryCountResult != null) {
                    UtilityPlugin.this.mHistoryCountResult.success(String.valueOf(data.size()));
                }
                UtilityPlugin.this.mHistoryCountResult = null;
            }
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.a
        public void onCacheDataWrite(WriteCacheRespMsg<List<a>> writeCacheRespMsg, WriteCacheMessage<a> writeCacheMessage) {
        }
    };
    private MethodChannel.Result mHistoryCountResult;
    ab mNegFeedBackItem;
    MethodChannel.Result mNegativeFeedBackResult;
    private PbHistoryCacheModel model;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "utility_plugin").setMethodCallHandler(new UtilityPlugin());
        mNativeListeners = new NativeListeners(new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "utility_plugin"));
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        String str2;
        if (methodCall.method.equals("getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
        } else if (methodCall.method.equals("getUserTBS")) {
            result.success(TbadkCoreApplication.getInst().getTbs());
        } else if (methodCall.method.equals("getUserUID")) {
            result.success(TbadkCoreApplication.getCurrentAccount());
        } else if (!methodCall.method.equals("isVisitorMode")) {
            if (methodCall.method.equals("goToLogin")) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(TbadkCoreApplication.getInst().getContext(), true)));
            } else if (methodCall.method.equals("getUserSmallPhotoHost")) {
                result.success(TbConfig.getPhotoSmallAddress());
            } else if (methodCall.method.equals("getUserBigPhotoHost")) {
                result.success(TbConfig.getBigPhotoAdress());
            } else if (methodCall.method.equals("preferenceGetStringValue")) {
                preferenceGetStringValue(methodCall, result);
            } else if (methodCall.method.equals("preferenceSetStringValue")) {
                preferenceSetStringValue(methodCall, result);
            } else if (methodCall.method.equals("addNotificationObserver")) {
                if (methodCall.arguments instanceof String) {
                    mNativeListeners.addNotificationObserver((String) methodCall.arguments);
                }
            } else if (methodCall.method.equals("removeNotificationObserver")) {
                if (methodCall.arguments instanceof String) {
                    mNativeListeners.removeNotificationObserver((String) methodCall.arguments);
                }
            } else if (methodCall.method.equals("delAllMsgInForumUser")) {
                delAllMsgInForumUser(methodCall, result);
            } else if (methodCall.method.equals("getIsOfficalForumLetterReminderOpen")) {
                getIsOfficalForumLetterReminderOpen(methodCall, result);
            } else if (methodCall.method.equals("setOfficalForumLetterReminderOpen")) {
                setOfficalForumLetterReminderOpen(methodCall, result);
            } else if (!methodCall.method.equals("resetFansNumCount")) {
                if (methodCall.method.equals("postSignProcess")) {
                    postSignProcess(methodCall, result);
                } else if (methodCall.method.equals("redirectTo")) {
                    redirectTo(methodCall, result);
                } else if (methodCall.method.equals("postNotification")) {
                    mNativeListeners.postNotification(methodCall.arguments);
                } else if (methodCall.method.equals("statLogEvent")) {
                    statLogEvent(methodCall, result);
                } else if (methodCall.method.equals("isLogin")) {
                    result.success(Boolean.valueOf(TbadkCoreApplication.isLogin()));
                } else if (methodCall.method.equals("debugLog")) {
                    debugLog(methodCall, result);
                } else if (!methodCall.method.equals("showTopToast")) {
                    if (methodCall.method.equals("preferenceGetValues")) {
                        preferenceGetValues(methodCall, result);
                    } else if (methodCall.method.equals("preferenceSetValues")) {
                        preferenceSetValues(methodCall, result);
                    } else if (methodCall.method.equals("accessWalletService")) {
                        accessWalletService(methodCall, result);
                    } else if (methodCall.method.equals("openBBASMApp")) {
                        openBBASMApp(methodCall, result);
                    } else if (methodCall.method.equals("readNewMessage")) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("bookmarkNum", Integer.valueOf(com.baidu.tieba.p.a.dEW().dET() ? 1 : 0));
                        hashMap.put("fansNum", Integer.valueOf(com.baidu.tieba.p.a.dEW().dES() ? 1 : 0));
                        result.success(hashMap);
                    } else if (methodCall.method.equals("clearNewMessage")) {
                        clearNewMessage(methodCall, result);
                    } else if (methodCall.method.equals("readVipCenterNewMessage")) {
                        result.success(Boolean.valueOf(com.baidu.tieba.p.a.dEW().dEU()));
                    } else if (methodCall.method.equals("showLoginAwardCell")) {
                        result.success(Boolean.valueOf(TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch()));
                    } else if (methodCall.method.equals("showRedDotForMyTab")) {
                        result.success(Boolean.valueOf(com.baidu.tieba.p.a.dEW().dEV()));
                    } else if (methodCall.method.equals("getThemeMode")) {
                        result.success(ap.bsK());
                    } else if (methodCall.method.equals("getMyPrivateStat")) {
                        result.success(Integer.valueOf(e.mP(((Integer) methodCall.argument("type")).intValue())));
                    } else if (methodCall.method.equals("setMyPrivateStat")) {
                        e.aI(((Integer) methodCall.argument("type")).intValue(), ((Integer) methodCall.argument("stat")).intValue());
                    } else if (methodCall.method.equals("hasOfficialChat")) {
                        result.success(Boolean.valueOf(TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT)));
                    } else if (methodCall.method.equals("delLikeForum")) {
                        TbadkCoreApplication.getInst().delLikeForum((String) methodCall.arguments);
                    } else if (methodCall.method.equals("goToMainTabRefresh")) {
                        b.d(TbadkCoreApplication.getInst(), ((Integer) methodCall.arguments).intValue(), false);
                    } else if ("getLottieBytes".equals(methodCall.method)) {
                        getLottieBytes(methodCall, result);
                    } else if (methodCall.method.equals("agreeThread")) {
                        if (methodCall.argument("item") != null && (methodCall.argument("item") instanceof HashMap)) {
                            if (!(methodCall.argument("obj_source") instanceof String)) {
                                str2 = "";
                            } else {
                                str2 = (String) methodCall.argument("obj_source");
                            }
                            doAgreeAndDisagree(true, new JSONObject((HashMap) methodCall.argument("item")), str2);
                        }
                    } else if (methodCall.method.equals("disagreeThread")) {
                        if (methodCall.argument("item") != null && (methodCall.argument("item") instanceof HashMap)) {
                            if (!(methodCall.argument("obj_source") instanceof String)) {
                                str = "";
                            } else {
                                str = (String) methodCall.argument("obj_source");
                            }
                            doAgreeAndDisagree(false, new JSONObject((HashMap) methodCall.argument("item")), str);
                        }
                    } else if (methodCall.method.equals("shareFrs")) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921463, (String) methodCall.argument(TbTitleActivityConfig.FORUM_ID)));
                    } else if (methodCall.method.equals("getAppVersion")) {
                        result.success(TbConfig.getVersion());
                    } else if (methodCall.method.equals("goToSearch")) {
                        goToSearch((String) methodCall.argument("search"), (String) methodCall.argument(SquareSearchActivityConfig.SEARCH_VALUE));
                    } else if (methodCall.method.equals("goToSendThread")) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new k(1)));
                        TiebaStatic.log(new ar("c13702").dR("uid", TbadkCoreApplication.getCurrentAccount()));
                    } else if (methodCall.method.equals("goToGameCenter")) {
                        goToActivityCenter();
                    } else if (methodCall.method.equals("goToActivityCenter")) {
                        goToActivityCenter();
                    } else if (methodCall.method.equals("getWebViewUserAgent")) {
                        getWebViewUserAgent(result);
                    } else if (methodCall.method.equals("getChannelTabInfo")) {
                        getChannelTabInfo(result);
                    } else if (methodCall.method.equals("recentlyVisitedForumLoadNetData")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921479));
                    } else if (methodCall.method.equals("getHistoryForumStr")) {
                        result.success((String) MessageManager.getInstance().runTask(2921483, String.class).getData());
                    } else if (methodCall.method.equals("getRecnbarShow")) {
                        result.success(Boolean.valueOf(com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)));
                    } else if (methodCall.method.equals("goToSignIn")) {
                        goToSignIn();
                    } else if (methodCall.method.equals("negativeFeedBack")) {
                        this.mNegativeFeedBackResult = result;
                        int round = methodCall.argument("offsetXAndroid") != null ? Math.round(Float.parseFloat(String.valueOf(methodCall.argument("offsetXAndroid")))) : 0;
                        int round2 = methodCall.argument("offsetYAndroid") != null ? Math.round(Float.parseFloat(String.valueOf(methodCall.argument("offsetYAndroid")))) : 0;
                        int round3 = methodCall.argument("width") != null ? Math.round(Float.parseFloat(String.valueOf(methodCall.argument("width")))) : 0;
                        if (methodCall.argument("item") != null) {
                            JSONObject optJSONObject = new JSONObject((HashMap) methodCall.argument("item")).optJSONObject("item");
                            cb cbVar = new cb();
                            cbVar.parserJson(optJSONObject);
                            negativeFeedBack(round, round2, round3, cbVar.blp());
                        }
                    } else if (methodCall.method.equals("experimentTypeForBarEntry")) {
                        if (c.biJ().zq("11_8_forum_guide_b") != null) {
                            result.success(2);
                        } else if (c.biJ().zq("11_8_forum_guide_a") != null) {
                            result.success(1);
                        } else {
                            result.success(1);
                        }
                    } else if (methodCall.method.equals("getAppPosInfo")) {
                        getAppPosInfo(result);
                    } else if (methodCall.method.equals("getHistoryCount")) {
                        this.mHistoryCountResult = result;
                        getHistoryCount();
                    } else if (methodCall.method.equals("deleteRecentlyVisitedForumHistory")) {
                        deleteRecentlyVisitedForumHistory(methodCall, result);
                    } else {
                        result.notImplemented();
                    }
                }
            }
        } else {
            result.success(Boolean.valueOf(!TbadkCoreApplication.isLogin()));
        }
    }

    private void negativeFeedBack(int i, int i2, int i3, av avVar) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof TbPageContextSupport) {
            ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView().findViewById(16908290);
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) currentActivity;
            if (this.mNegFeedBackItem != null && this.mNegFeedBackItem.sT() != null) {
                viewGroup.removeView(this.mNegFeedBackItem.sT());
            }
            this.mNegFeedBackItem = new ab(tbPageContextSupport.getPageContext(), Align.ALIGN_RIGHT_TOP);
            this.mNegFeedBackItem.a(new NEGFeedBackView.a() { // from class: com.example.utility_plugin.UtilityPlugin.1
                @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                public void onNEGFeedbackWindowShow(av avVar2) {
                }

                @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                public void onCheckedChanged(av avVar2, CompoundButton compoundButton, boolean z) {
                }

                @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
                public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar2) {
                    if (UtilityPlugin.this.mNegativeFeedBackResult != null) {
                        UtilityPlugin.this.mNegativeFeedBackResult.success(true);
                    }
                }
            });
            this.mNegFeedBackItem.C(avVar);
            int equipmentWidth = l.getEquipmentWidth(tbPageContextSupport.getPageContext().getPageActivity());
            if (Build.VERSION.SDK_INT >= 11) {
                this.mNegFeedBackItem.sT().setY(i2 - l.dip2px(tbPageContextSupport.getPageContext().getPageActivity(), 16.0f));
                this.mNegFeedBackItem.sT().setX((equipmentWidth - i3) - l.dip2px(tbPageContextSupport.getPageContext().getPageActivity(), 20.0f));
            }
            viewGroup.addView(this.mNegFeedBackItem.sT(), this.mNegFeedBackItem.sS());
            this.mNegFeedBackItem.sT().setVisibility(4);
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.example.utility_plugin.UtilityPlugin.2
                @Override // java.lang.Runnable
                public void run() {
                    UtilityPlugin.this.mNegFeedBackItem.sT().performClick();
                    UtilityPlugin.this.mNegFeedBackItem.sT().setVisibility(8);
                }
            }, 150L);
        }
    }

    private void goToSignIn() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumActivityConfig(TbadkCoreApplication.getInst().getCurrentActivity())));
    }

    private void getWebViewUserAgent(MethodChannel.Result result) {
        result.success(al.bFT());
    }

    private void getChannelTabInfo(MethodChannel.Result result) {
        HashMap hashMap = new HashMap();
        com.baidu.tbadk.coreExtra.data.l byD = TbSingleton.getInstance().getChannelConfigModel().byD();
        if (byD != null) {
            if (!TextUtils.isEmpty(byD.getTid())) {
                hashMap.put("tid", byD.getTid());
            }
            if (!TextUtils.isEmpty(byD.getTabCode())) {
                hashMap.put("tabCode", byD.getTabCode());
            }
            hashMap.put("tabType", String.valueOf(byD.bwn()));
        }
        result.success(hashMap);
    }

    private void goToSearch(String str, String str2) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof TbPageContextSupport) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(currentActivity, "", false, str, str2)));
        }
    }

    private void goToActivityCenter() {
        String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof TbPageContextSupport) {
            bf.bsV().b(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{missionEntranceUrl});
        }
    }

    private void accessWalletService(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.arguments;
        if (!StringUtils.isNull(str)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_OPEN_WALLET_ICASH, str));
        }
    }

    private void preferenceSetValues(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("nameSpace");
        HashMap hashMap = (HashMap) methodCall.argument("keyValueMap");
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry.getValue() instanceof Boolean) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharePrefNameTransform.getAndroidNameFromIos((String) entry.getKey()), ((Boolean) entry.getValue()).booleanValue());
                }
            }
        }
        result.success(true);
    }

    private void preferenceGetValues(MethodCall methodCall, MethodChannel.Result result) {
        ArrayList arrayList = (ArrayList) methodCall.argument("keys");
        String str = (String) methodCall.argument("nameSpace");
        HashMap hashMap = new HashMap();
        for (int i = 0; i < arrayList.size(); i++) {
            if (com.baidu.tbadk.core.sharedPref.b.brQ().isContains(SharePrefNameTransform.getAndroidNameFromIos((String) arrayList.get(i)))) {
                hashMap.put(arrayList.get(i), Boolean.valueOf(com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharePrefNameTransform.getAndroidNameFromIos((String) arrayList.get(i)), false)));
            }
        }
        result.success(hashMap);
    }

    private void debugLog(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("key");
        HashMap hashMap = (HashMap) methodCall.argument("params");
        com.baidu.adp.lib.stats.a aVar = new com.baidu.adp.lib.stats.a("dbg");
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                aVar.addValue(entry.getKey(), entry.getValue());
            }
        }
        BdStatisticsManager.getInstance().debug(str, aVar);
    }

    private void statLogEvent(MethodCall methodCall, MethodChannel.Result result) {
        HashMap hashMap = (HashMap) methodCall.argument("params");
        ar arVar = new ar((String) methodCall.argument("key"));
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry.getValue() instanceof String) {
                    arVar.dR((String) entry.getKey(), (String) entry.getValue());
                } else if (entry.getValue() instanceof Integer) {
                    arVar.ap((String) entry.getKey(), ((Integer) entry.getValue()).intValue());
                } else if (entry.getValue() instanceof Long) {
                    arVar.v((String) entry.getKey(), ((Long) entry.getValue()).longValue());
                } else if (entry.getValue() instanceof Double) {
                    arVar.c((String) entry.getKey(), ((Double) entry.getValue()).doubleValue());
                }
            }
        }
        TiebaStatic.log(arVar);
    }

    private void redirectTo(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("url");
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
            bf.bsV().b(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{str});
        }
    }

    private void postSignProcess(MethodCall methodCall, MethodChannel.Result result) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof TbPageContextSupport) {
            f.byA().a(((TbPageContextSupport) currentActivity).getPageContext(), (ViewGroup) currentActivity.getWindow().getDecorView());
        }
    }

    private void setOfficalForumLetterReminderOpen(MethodCall methodCall, MethodChannel.Result result) {
        final String str = (String) methodCall.argument(TbTitleActivityConfig.FORUM_ID);
        final boolean booleanValue = ((Boolean) methodCall.argument("open")).booleanValue();
        new BdAsyncTask<Void, Void, Void>() { // from class: com.example.utility_plugin.UtilityPlugin.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    d.cXT().D(TbadkApplication.getCurrentAccount(), String.valueOf(str), booleanValue);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void getIsOfficalForumLetterReminderOpen(MethodCall methodCall, MethodChannel.Result result) {
        OfficialSettingItemData fx = d.cXT().fx(TbadkApplication.getCurrentAccount(), (String) methodCall.arguments);
        if (fx != null) {
            result.success(Boolean.valueOf(fx.isAcceptNotify()));
        } else {
            result.success(true);
        }
    }

    private void delAllMsgInForumUser(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument(TbTitleActivityConfig.FORUM_ID);
        if (!au.isEmpty(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(str), 4, null, 1)));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEL_OFFICIAL_DB, String.valueOf(str)));
        }
    }

    private void preferenceSetStringValue(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("nameSpace");
        String str2 = (String) methodCall.argument("key");
        String str3 = (String) methodCall.argument("value");
        if (au.isEmpty(str2) || au.isEmpty(str3)) {
            result.error("input is empty", "", "");
            return;
        }
        SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        edit.commit();
    }

    private void preferenceGetStringValue(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("key");
        String str2 = (String) methodCall.argument("nameSpace");
        if (au.isEmpty(str)) {
            result.error("key is empty", "", "");
        } else {
            result.success(com.baidu.tbadk.core.sharedPref.b.brQ().getString(str, ""));
        }
    }

    private int getResIdBySkin(String str, int i) {
        int d;
        int c;
        if (!au.isEmpty(str)) {
            if ("night".equals(str) && (c = ap.c(TbadkCoreApplication.getInst().getResources(), i)) > 0) {
                i = c;
            }
            return (!"dark".equals(str) || (d = ap.d(TbadkCoreApplication.getInst().getResources(), i)) <= 0) ? i : d;
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [656=4] */
    public byte[] readFileFromRaw(Resources resources, int i) {
        OutputStream outputStream;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = null;
        byte[] bArr2 = new byte[1024];
        try {
            try {
                inputStream = resources.openRawResource(i);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
            inputStream = null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                try {
                    int read = inputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    com.baidu.adp.lib.f.a.close(inputStream);
                    com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                    return bArr;
                }
            }
            byteArrayOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
            com.baidu.adp.lib.f.a.close(inputStream);
            com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
            com.baidu.adp.lib.f.a.close(inputStream);
            com.baidu.adp.lib.f.a.close(outputStream);
            throw th;
        }
        return bArr;
    }

    private void openBBASMApp(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.arguments instanceof String) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                bf.bsV().b(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{(String) methodCall.arguments});
            }
        } else if (methodCall.arguments instanceof HashMap) {
            HashMap hashMap = (HashMap) methodCall.arguments;
            if (!com.baidu.tieba.aiapps.a.b((String) hashMap.get("id"), (String) hashMap.get("link"), "1191000600000000", Integer.valueOf(((Boolean) hashMap.get("is_game")).booleanValue() ? 1 : 0))) {
                if (!au.isEmpty((String) hashMap.get("h5_url"))) {
                    Activity currentActivity2 = TbadkCoreApplication.getInst().getCurrentActivity();
                    if (currentActivity2 instanceof TbPageContextSupport) {
                        bf.bsV().b(((TbPageContextSupport) currentActivity2).getPageContext(), new String[]{(String) hashMap.get("h5_url")});
                    }
                } else {
                    return;
                }
            }
        }
        result.success(true);
    }

    private void clearNewMessage(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.arguments;
        if (!StringUtils.isNull(str)) {
            if ("bookmarkNum".equals(str)) {
                com.baidu.tieba.p.a.dEW().h(3, false, true);
            } else if ("fansNum".equals(str)) {
                com.baidu.tieba.p.a.dEW().h(2, false, true);
            } else if ("giftNum".equals(str)) {
                com.baidu.tieba.p.a.dEW().h(1, false, true);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [721=4] */
    public byte[] readFileFromAsset(String str) {
        OutputStream outputStream;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = null;
        byte[] bArr2 = new byte[1024];
        try {
            try {
                inputStream = BdBaseApplication.getInst().getAssets().open(str);
            } catch (Throwable th) {
                th = th;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = inputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.f.a.close(inputStream);
                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                        return bArr;
                    }
                }
                byteArrayOutputStream.flush();
                bArr = byteArrayOutputStream.toByteArray();
                com.baidu.adp.lib.f.a.close(inputStream);
                com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
            } catch (Exception e2) {
                e = e2;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                com.baidu.adp.lib.f.a.close(inputStream);
                com.baidu.adp.lib.f.a.close(outputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
            inputStream = null;
        }
        return bArr;
    }

    private void getLottieBytes(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("name");
        String str2 = (String) methodCall.argument("themeStr");
        Resources resources = h.kD().getResources();
        String androidAssetsNameFromIos = ResNameTransform.getAndroidAssetsNameFromIos(str);
        if (androidAssetsNameFromIos != null) {
            byte[] readFileFromAsset = readFileFromAsset(androidAssetsNameFromIos);
            if (readFileFromAsset != null && readFileFromAsset.length > 0) {
                result.success(readFileFromAsset);
                return;
            } else {
                result.error("flutter lottie resource data is null :" + str, "bytes:" + readFileFromAsset, "");
                return;
            }
        }
        int resIdBySkin = getResIdBySkin(str2, resources.getIdentifier(ResNameTransform.getAndroidNameFromIos(str), "raw", BdBaseApplication.getInst().getPackageName()));
        if (resIdBySkin != 0) {
            byte[] readFileFromRaw = readFileFromRaw(resources, resIdBySkin);
            if (readFileFromRaw != null && readFileFromRaw.length > 0) {
                result.success(readFileFromRaw);
                return;
            } else {
                result.error("flutter lottie resource data is null :" + str, "bytes:" + readFileFromRaw, "");
                return;
            }
        }
        result.error("flutter lottie resource in package not found :" + str, "", "");
    }

    private void doAgreeAndDisagree(boolean z, JSONObject jSONObject, String str) {
        int i;
        int i2 = 0;
        cb cbVar = new cb();
        cbVar.parserJson(jSONObject);
        AgreeData bpJ = cbVar.bpJ();
        if (z) {
            TbPageContext tbPageContext = null;
            if (TbadkApplication.getInst().getCurrentActivity() != null) {
                tbPageContext = ((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext();
            }
            if (bpJ.hasAgree) {
                if (bpJ.agreeType == 2) {
                    bpJ.agreeType = 2;
                    bpJ.hasAgree = false;
                    bpJ.agreeNum--;
                    i = 1;
                } else {
                    bpJ.agreeType = 2;
                    bpJ.hasAgree = true;
                    bpJ.agreeNum++;
                    com.baidu.tieba.o.a.dCR().J(tbPageContext);
                    i = 0;
                }
            } else {
                bpJ.agreeType = 2;
                bpJ.hasAgree = true;
                bpJ.agreeNum++;
                com.baidu.tieba.o.a.dCR().J(tbPageContext);
                i = 0;
            }
            if (!StringUtil.isEmpty(str)) {
                bpJ.objSource = str;
            }
            sendMesage(i, bpJ);
        } else {
            if (bpJ.hasAgree) {
                if (bpJ.agreeType == 5) {
                    bpJ.agreeType = 5;
                    bpJ.hasAgree = false;
                    NoNetworkView.updateUI();
                    i2 = 1;
                } else {
                    bpJ.agreeType = 5;
                    bpJ.hasAgree = true;
                    bpJ.agreeNum--;
                }
            } else {
                bpJ.agreeType = 5;
                bpJ.hasAgree = true;
            }
            if (!StringUtil.isEmpty(str)) {
                bpJ.objSource = str;
            }
            sendMesage(i2, bpJ);
        }
        com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
        eVar.agreeData = bpJ;
        if (cbVar != null && cbVar.getBaijiahaoData() != null) {
            bpJ.nid = cbVar.getBaijiahaoData().oriUgcNid;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
        dispatchMutiProcessAgree(bpJ, AgreeEvent.IS_THREAD);
    }

    private void dispatchMutiProcessAgree(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.publishEvent(agreeEvent);
    }

    public void sendMesage(int i, AgreeData agreeData) {
        if (agreeData != null) {
            HttpMessage httpMessage = new HttpMessage(1001601);
            httpMessage.addParam("z_id", FH.gz(TbadkCoreApplication.getInst()));
            httpMessage.addParam("thread_id", agreeData.threadId);
            httpMessage.addParam("op_type", i);
            if (agreeData.objType == 0) {
                agreeData.objType = 3;
            }
            httpMessage.addParam("obj_type", agreeData.objType);
            httpMessage.addParam("agree_type", agreeData.agreeType);
            httpMessage.addParam("forum_id", agreeData.forumId);
            if (!TextUtils.isEmpty(agreeData.postId)) {
                httpMessage.addParam("post_id", agreeData.postId);
            }
            if (agreeData.baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", agreeData.baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", agreeData.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", agreeData.baijiahaoData.oriUgcVid);
                httpMessage.addParam("ori_ugc_type", agreeData.baijiahaoData.oriUgcType);
            }
            if (!StringUtil.isEmpty(agreeData.objSource)) {
                httpMessage.addParam("obj_source", agreeData.objSource);
            }
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void getAppPosInfo(MethodChannel.Result result) {
        result.success(com.baidu.tieba.recapp.c.a.dEe().dEk());
    }

    private void getHistoryCount() {
        if (this.model == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                this.model = new PbHistoryCacheModel(((TbPageContextSupport) currentActivity).getPageContext());
                this.model.a(this.callback);
            }
        }
        this.model.bDs();
    }

    private void deleteRecentlyVisitedForumHistory(MethodCall methodCall, MethodChannel.Result result) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2921519, (String) methodCall.argument("forum_id")));
        result.success(true);
    }
}
