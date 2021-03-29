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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.card.Align;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tbadk.mvc.message.ReadCacheMessage;
import com.baidu.tbadk.mvc.message.ReadCacheRespMsg;
import com.baidu.tbadk.mvc.message.WriteCacheMessage;
import com.baidu.tbadk.mvc.message.WriteCacheRespMsg;
import com.baidu.tbadk.mvc.model.CacheModel;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import d.b.b.a.h;
import d.b.b.e.p.k;
import d.b.h0.b.c;
import d.b.h0.f0.g;
import d.b.h0.r.a0.b;
import d.b.h0.r.l.f;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.v0;
import d.b.h0.s.c.l;
import d.b.h0.t.j;
import d.b.h0.z0.m0;
import d.b.h0.z0.n0;
import d.b.i.b0;
import d.b.i0.c3.h0.e;
import d.b.i0.d1.t.d;
import d.b.i0.i2.n;
import d.b.i0.v1.h.a;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes6.dex */
public class UtilityPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static NativeListeners mNativeListeners;
    public final CacheModel.c<a> callback = new CacheModel.c<a>() { // from class: com.example.utility_plugin.UtilityPlugin.4
        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void onCacheDataGet(ReadCacheRespMsg<List<a>> readCacheRespMsg, ReadCacheMessage<a> readCacheMessage) {
            if (readCacheRespMsg == null || readCacheRespMsg.getData() == null) {
                return;
            }
            List<a> data = readCacheRespMsg.getData();
            if (UtilityPlugin.this.mHistoryCountResult != null) {
                UtilityPlugin.this.mHistoryCountResult.success(String.valueOf(data.size()));
            }
            UtilityPlugin.this.mHistoryCountResult = null;
        }

        @Override // com.baidu.tbadk.mvc.model.CacheModel.c
        public void onCacheDataWrite(WriteCacheRespMsg<List<a>> writeCacheRespMsg, WriteCacheMessage<a> writeCacheMessage) {
        }
    };
    public MethodChannel.Result mHistoryCountResult;
    public b0 mNegFeedBackItem;
    public MethodChannel.Result mNegativeFeedBackResult;
    public PbHistoryCacheModel model;

    public final void accessWalletService(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.arguments;
        if (StringUtils.isNull(str)) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2001447, str));
    }

    public final void clearNewMessage(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.arguments;
        if (StringUtils.isNull(str)) {
            return;
        }
        if ("bookmarkNum".equals(str)) {
            d.b.i0.s2.a.v().L(3, false, true);
        } else if ("fansNum".equals(str)) {
            d.b.i0.s2.a.v().L(2, false, true);
        } else if ("giftNum".equals(str)) {
            d.b.i0.s2.a.v().L(1, false, true);
        }
    }

    public final void debugLog(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("key");
        HashMap hashMap = (HashMap) methodCall.argument("params");
        d.b.b.e.n.a aVar = new d.b.b.e.n.a("dbg");
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
        }
        BdStatisticsManager.getInstance().debug(str, aVar);
    }

    public final void delAllMsgInForumUser(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument(TbTitleActivityConfig.FORUM_ID);
        if (k.isEmpty(str)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(str), 4, null, 1)));
        MessageManager.getInstance().sendMessage(new CustomMessage(2001151, String.valueOf(str)));
    }

    public final void deleteRecentlyVisitedForumHistory(MethodCall methodCall, MethodChannel.Result result) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2921519, (String) methodCall.argument("forum_id")));
        result.success(Boolean.TRUE);
    }

    public final void dispatchMutiProcessAgree(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        g.g(agreeEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void doAgreeAndDisagree(boolean z, JSONObject jSONObject, String str) {
        a2 a2Var = new a2();
        a2Var.P2(jSONObject);
        AgreeData L = a2Var.L();
        int i = 1;
        if (z) {
            TbPageContext pageContext = TbadkApplication.getInst().getCurrentActivity() != null ? ((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext() : null;
            if (L.hasAgree) {
                if (L.agreeType == 2) {
                    L.agreeType = 2;
                    L.hasAgree = false;
                    L.agreeNum--;
                    if (!StringUtil.isEmpty(str)) {
                        L.objSource = str;
                    }
                    sendMesage(i, L);
                } else {
                    L.agreeType = 2;
                    L.hasAgree = true;
                    L.agreeNum++;
                    d.b.i0.q2.a.g().l(pageContext);
                }
            } else {
                L.agreeType = 2;
                L.hasAgree = true;
                L.agreeNum++;
                d.b.i0.q2.a.g().l(pageContext);
            }
            i = 0;
            if (!StringUtil.isEmpty(str)) {
            }
            sendMesage(i, L);
        } else {
            if (L.hasAgree) {
                if (L.agreeType == 5) {
                    L.agreeType = 5;
                    L.hasAgree = false;
                    NoNetworkView.f();
                    if (!StringUtil.isEmpty(str)) {
                        L.objSource = str;
                    }
                    sendMesage(i, L);
                } else {
                    L.agreeType = 5;
                    L.hasAgree = true;
                    L.agreeNum--;
                }
            } else {
                L.agreeType = 5;
                L.hasAgree = true;
            }
            i = 0;
            if (!StringUtil.isEmpty(str)) {
            }
            sendMesage(i, L);
        }
        e eVar = new e();
        eVar.f53377b = L;
        if (a2Var.V() != null) {
            L.nid = a2Var.V().oriUgcNid;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
        dispatchMutiProcessAgree(L, AgreeEvent.IS_THREAD);
    }

    public final void getAppPosInfo(MethodChannel.Result result) {
        result.success(d.b.i0.r2.a0.a.e().b());
    }

    public final void getChannelTabInfo(MethodChannel.Result result) {
        HashMap hashMap = new HashMap();
        l c2 = TbSingleton.getInstance().getChannelConfigModel().c();
        if (c2 != null) {
            if (!TextUtils.isEmpty(c2.e())) {
                hashMap.put("tid", c2.e());
            }
            if (!TextUtils.isEmpty(c2.d())) {
                hashMap.put("tabCode", c2.d());
            }
            hashMap.put("tabType", String.valueOf(c2.a()));
        }
        result.success(hashMap);
    }

    public final void getHistoryCount() {
        if (this.model == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(((TbPageContextSupport) currentActivity).getPageContext());
                this.model = pbHistoryCacheModel;
                pbHistoryCacheModel.K(this.callback);
            }
        }
        PbHistoryCacheModel pbHistoryCacheModel2 = this.model;
        if (pbHistoryCacheModel2 != null) {
            pbHistoryCacheModel2.H();
        }
    }

    public final void getIsOfficalForumLetterReminderOpen(MethodCall methodCall, MethodChannel.Result result) {
        OfficialSettingItemData a2 = d.j().a(TbadkCoreApplication.getCurrentAccount(), (String) methodCall.arguments);
        if (a2 != null) {
            result.success(Boolean.valueOf(a2.isAcceptNotify()));
        } else {
            result.success(Boolean.TRUE);
        }
    }

    public final void getLottieBytes(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("name");
        String str2 = (String) methodCall.argument("themeStr");
        Resources b2 = h.a().b();
        String androidAssetsNameFromIos = ResNameTransform.getAndroidAssetsNameFromIos(str);
        if (androidAssetsNameFromIos != null) {
            byte[] readFileFromAsset = readFileFromAsset(androidAssetsNameFromIos);
            if (readFileFromAsset != null && readFileFromAsset.length > 0) {
                result.success(readFileFromAsset);
                return;
            }
            result.error("flutter lottie resource data is null :" + str, "bytes:" + readFileFromAsset, "");
            return;
        }
        int resIdBySkin = getResIdBySkin(str2, b2.getIdentifier(ResNameTransform.getAndroidNameFromIos(str), "raw", BdBaseApplication.getInst().getPackageName()));
        if (resIdBySkin != 0) {
            byte[] readFileFromRaw = readFileFromRaw(b2, resIdBySkin);
            if (readFileFromRaw != null && readFileFromRaw.length > 0) {
                result.success(readFileFromRaw);
                return;
            }
            result.error("flutter lottie resource data is null :" + str, "bytes:" + readFileFromRaw, "");
            return;
        }
        result.error("flutter lottie resource in package not found :" + str, "", "");
    }

    public final int getResIdBySkin(String str, int i) {
        int darkResourceId;
        int nightResouceId;
        if (k.isEmpty(str)) {
            return i;
        }
        if (SkinManager.SKIN_TYPE_STR_NIGHT.equals(str) && (nightResouceId = SkinManager.getNightResouceId(TbadkCoreApplication.getInst().getResources(), i)) > 0) {
            i = nightResouceId;
        }
        return (!"dark".equals(str) || (darkResourceId = SkinManager.getDarkResourceId(TbadkCoreApplication.getInst().getResources(), i)) <= 0) ? i : darkResourceId;
    }

    public final void getWebViewUserAgent(MethodChannel.Result result) {
        result.success(n0.b());
    }

    public final void goToActivityCenter() {
        String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof TbPageContextSupport) {
            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{missionEntranceUrl});
        }
    }

    public final void goToSearch(String str, String str2) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof TbPageContextSupport) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(currentActivity, "", false, str, str2)));
        }
    }

    public final void goToSignIn() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(TbadkCoreApplication.getInst().getCurrentActivity())));
    }

    public final void negativeFeedBack(int i, int i2, int i3, v0 v0Var) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof TbPageContextSupport) {
            ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView().findViewById(16908290);
            TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) currentActivity;
            b0 b0Var = this.mNegFeedBackItem;
            if (b0Var != null && b0Var.b() != null) {
                viewGroup.removeView(this.mNegFeedBackItem.b());
            }
            b0 b0Var2 = new b0(tbPageContextSupport.getPageContext(), Align.ALIGN_RIGHT_TOP);
            this.mNegFeedBackItem = b0Var2;
            b0Var2.u(new NEGFeedBackView.b() { // from class: com.example.utility_plugin.UtilityPlugin.1
                @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
                public void onCheckedChanged(v0 v0Var2, CompoundButton compoundButton, boolean z) {
                }

                @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
                public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, v0 v0Var2) {
                    MethodChannel.Result result = UtilityPlugin.this.mNegativeFeedBackResult;
                    if (result != null) {
                        result.success(Boolean.TRUE);
                    }
                }

                @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
                public void onNEGFeedbackWindowShow(v0 v0Var2) {
                }
            });
            this.mNegFeedBackItem.a(v0Var);
            int k = d.b.b.e.p.l.k(tbPageContextSupport.getPageContext().getPageActivity());
            if (Build.VERSION.SDK_INT >= 11) {
                this.mNegFeedBackItem.b().setY(i2 - d.b.b.e.p.l.e(tbPageContextSupport.getPageContext().getPageActivity(), 16.0f));
                this.mNegFeedBackItem.b().setX((k - i3) - d.b.b.e.p.l.e(tbPageContextSupport.getPageContext().getPageActivity(), 20.0f));
            }
            viewGroup.addView(this.mNegFeedBackItem.b(), this.mNegFeedBackItem.c());
            this.mNegFeedBackItem.b().setVisibility(4);
            d.b.b.e.m.e.a().postDelayed(new Runnable() { // from class: com.example.utility_plugin.UtilityPlugin.2
                @Override // java.lang.Runnable
                public void run() {
                    UtilityPlugin.this.mNegFeedBackItem.b().performClick();
                    UtilityPlugin.this.mNegFeedBackItem.b().setVisibility(8);
                }
            }, 150L);
        }
    }

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
        if (methodCall.method.equals("getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
        } else if (methodCall.method.equals("getUserTBS")) {
            result.success(TbadkCoreApplication.getInst().getTbs());
        } else if (methodCall.method.equals("getUserUID")) {
            result.success(TbadkCoreApplication.getCurrentAccount());
        } else {
            boolean z = true;
            if (methodCall.method.equals("isVisitorMode")) {
                result.success(Boolean.valueOf(!TbadkCoreApplication.isLogin()));
            } else if (methodCall.method.equals("goToLogin")) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig(TbadkCoreApplication.getInst().getContext(), true)));
            } else if (methodCall.method.equals("getUserSmallPhotoHost")) {
                result.success(TbConfig.getPhotoSmallAddress());
            } else if (methodCall.method.equals("getUserBigPhotoHost")) {
                result.success(TbConfig.getBigPhotoAdress());
            } else if (methodCall.method.equals("preferenceGetStringValue")) {
                preferenceGetStringValue(methodCall, result);
            } else if (methodCall.method.equals("preferenceSetStringValue")) {
                preferenceSetStringValue(methodCall, result);
            } else if (methodCall.method.equals("addNotificationObserver")) {
                Object obj = methodCall.arguments;
                if (obj instanceof String) {
                    mNativeListeners.addNotificationObserver((String) obj);
                }
            } else if (methodCall.method.equals("removeNotificationObserver")) {
                Object obj2 = methodCall.arguments;
                if (obj2 instanceof String) {
                    mNativeListeners.removeNotificationObserver((String) obj2);
                }
            } else if (methodCall.method.equals("delAllMsgInForumUser")) {
                delAllMsgInForumUser(methodCall, result);
            } else if (methodCall.method.equals("getIsOfficalForumLetterReminderOpen")) {
                getIsOfficalForumLetterReminderOpen(methodCall, result);
            } else if (methodCall.method.equals("setOfficalForumLetterReminderOpen")) {
                setOfficalForumLetterReminderOpen(methodCall, result);
            } else if (methodCall.method.equals("resetFansNumCount")) {
            } else {
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
                } else if (methodCall.method.equals("showTopToast")) {
                } else {
                    if (methodCall.method.equals("preferenceGetValues")) {
                        preferenceGetValues(methodCall, result);
                    } else if (methodCall.method.equals("preferenceSetValues")) {
                        preferenceSetValues(methodCall, result);
                    } else if (methodCall.method.equals(LightappBusinessClient.METHOD_ACCESS_WALLET_SERVICE)) {
                        accessWalletService(methodCall, result);
                    } else if (methodCall.method.equals("openBBASMApp")) {
                        openBBASMApp(methodCall, result);
                    } else if (methodCall.method.equals("readNewMessage")) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("bookmarkNum", Integer.valueOf(d.b.i0.s2.a.v().A() ? 1 : 0));
                        hashMap.put("fansNum", Integer.valueOf(d.b.i0.s2.a.v().B() ? 1 : 0));
                        result.success(hashMap);
                    } else if (methodCall.method.equals("clearNewMessage")) {
                        clearNewMessage(methodCall, result);
                    } else if (methodCall.method.equals("readVipCenterNewMessage")) {
                        result.success(Boolean.valueOf(d.b.i0.s2.a.v().C()));
                    } else if (methodCall.method.equals("showLoginAwardCell")) {
                        result.success(Boolean.valueOf(TbadkCoreApplication.getInst().getActivityPrizeData().f()));
                    } else if (methodCall.method.equals("showRedDotForMyTab")) {
                        result.success(Boolean.valueOf(d.b.i0.s2.a.v().z()));
                    } else if (methodCall.method.equals("getThemeMode")) {
                        result.success(SkinManager.getCurrentSkinTypeString());
                    } else if (methodCall.method.equals("getMyPrivateStat")) {
                        result.success(Integer.valueOf(f.a(((Integer) methodCall.argument("type")).intValue())));
                    } else if (methodCall.method.equals("setMyPrivateStat")) {
                        f.c(((Integer) methodCall.argument("type")).intValue(), ((Integer) methodCall.argument("stat")).intValue());
                    } else if (methodCall.method.equals("hasOfficialChat")) {
                        result.success(Boolean.valueOf(TbadkCoreApplication.getInst().appResponseToCmd(2002006)));
                    } else if (methodCall.method.equals("delLikeForum")) {
                        TbadkCoreApplication.getInst().delLikeForum((String) methodCall.arguments);
                    } else {
                        if (methodCall.method.equals("goToMainTabRefresh")) {
                            b.g(TbadkCoreApplication.getInst(), ((Integer) methodCall.arguments).intValue(), false);
                        } else if ("getLottieBytes".equals(methodCall.method)) {
                            getLottieBytes(methodCall, result);
                        } else {
                            if (methodCall.method.equals("agreeThread")) {
                                if (methodCall.argument("item") == null || !(methodCall.argument("item") instanceof HashMap)) {
                                    return;
                                }
                                doAgreeAndDisagree(true, new JSONObject((HashMap) methodCall.argument("item")), methodCall.argument("obj_source") instanceof String ? (String) methodCall.argument("obj_source") : "");
                            } else if (methodCall.method.equals("disagreeThread")) {
                                if (methodCall.argument("item") == null || !(methodCall.argument("item") instanceof HashMap)) {
                                    return;
                                }
                                doAgreeAndDisagree(false, new JSONObject((HashMap) methodCall.argument("item")), methodCall.argument("obj_source") instanceof String ? (String) methodCall.argument("obj_source") : "");
                            } else if (methodCall.method.equals("shareFrs")) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921463, (String) methodCall.argument(TbTitleActivityConfig.FORUM_ID)));
                            } else if (methodCall.method.equals("getAppVersion")) {
                                result.success(TbConfig.getVersion());
                            } else if (methodCall.method.equals("goToSearch")) {
                                goToSearch((String) methodCall.argument("search"), (String) methodCall.argument(SquareSearchActivityConfig.SEARCH_VALUE));
                            } else if (methodCall.method.equals("goToSendThread")) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new j(1)));
                                TiebaStatic.log(new StatisticItem(CommonStatisticKey.UBS_TEST_PUBLISH_BUTTON_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()));
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
                                d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
                                result.success(Boolean.valueOf(i.g("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)));
                            } else if (methodCall.method.equals("goToSignIn")) {
                                goToSignIn();
                            } else if (methodCall.method.equals("negativeFeedBack")) {
                                this.mNegativeFeedBackResult = result;
                                int round = methodCall.argument("offsetXAndroid") != null ? Math.round(Float.parseFloat(String.valueOf(methodCall.argument("offsetXAndroid")))) : 0;
                                int round2 = methodCall.argument("offsetYAndroid") != null ? Math.round(Float.parseFloat(String.valueOf(methodCall.argument("offsetYAndroid")))) : 0;
                                int round3 = methodCall.argument("width") != null ? Math.round(Float.parseFloat(String.valueOf(methodCall.argument("width")))) : 0;
                                if (methodCall.argument("item") != null) {
                                    JSONObject optJSONObject = new JSONObject((HashMap) methodCall.argument("item")).optJSONObject("item");
                                    a2 a2Var = new a2();
                                    a2Var.P2(optJSONObject);
                                    negativeFeedBack(round, round2, round3, a2Var.g());
                                }
                            } else if (methodCall.method.equals("experimentTypeForBarEntry")) {
                                if (c.d().b("11_8_forum_guide_b") != null) {
                                    result.success(2);
                                } else if (c.d().b("11_8_forum_guide_a") != null) {
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
                            } else if (methodCall.method.equals("isVideoCardMute")) {
                                result.success(Boolean.valueOf(TbSingleton.getInstance().isVideoCardMute()));
                            } else if (methodCall.method.equals("setVideoCardMute")) {
                                boolean booleanValue = ((Boolean) methodCall.arguments).booleanValue();
                                TbSingleton.getInstance().setVideoCardMute(booleanValue);
                                m0.e(new WeakReference(TbadkCoreApplication.getInst()), !booleanValue);
                                result.success("");
                            } else if (methodCall.method.equals("isVideoCardMute")) {
                                result.success(Boolean.valueOf(TbSingleton.getInstance().isVideoCardMute()));
                            } else if (methodCall.method.equals("videoPositionCacheManagerUpdate")) {
                                n.d().f((String) methodCall.argument("url"), ((Integer) methodCall.argument("duration")).intValue());
                                result.success(Boolean.TRUE);
                            } else if (methodCall.method.equals("videoPositionCacheManagerRemove")) {
                                n.d().e((String) methodCall.arguments);
                                result.success(Boolean.TRUE);
                            } else if (methodCall.method.equals("videoPositionCacheManagerGetCachePosition")) {
                                result.success(Integer.valueOf(n.d().c((String) methodCall.arguments)));
                            } else if (methodCall.method.equals("requestDistance")) {
                                double doubleValue = ((Double) methodCall.argument(SuggestAddrField.KEY_LAT)).doubleValue();
                                double doubleValue2 = ((Double) methodCall.argument(SuggestAddrField.KEY_LNG)).doubleValue();
                                boolean z2 = UtilHelper.isDecimal(String.valueOf(doubleValue)) && UtilHelper.isDecimal(String.valueOf(doubleValue2));
                                boolean isSystemLocationProviderEnabled = UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst());
                                double d2 = 0.0d;
                                if (z2 && isSystemLocationProviderEnabled) {
                                    AppPosInfo c2 = d.b.i0.r2.a0.a.e().c();
                                    String str = c2.latitude;
                                    String str2 = c2.longitude;
                                    if ((UtilHelper.isDecimal(str) && UtilHelper.isDecimal(str2)) ? false : false) {
                                        d2 = d.b.b.e.p.l.a(d.b.b.e.m.b.b(str, 0.0d), d.b.b.e.m.b.b(str2, 0.0d), doubleValue, doubleValue2);
                                    }
                                }
                                result.success(Double.valueOf(d2));
                            } else {
                                result.notImplemented();
                            }
                        }
                    }
                }
            }
        }
    }

    public final void openBBASMApp(MethodCall methodCall, MethodChannel.Result result) {
        Object obj = methodCall.arguments;
        if (obj instanceof String) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity instanceof TbPageContextSupport) {
                UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{(String) methodCall.arguments});
            }
        } else if (obj instanceof HashMap) {
            HashMap hashMap = (HashMap) obj;
            if (!d.b.i0.s.a.b((String) hashMap.get("id"), (String) hashMap.get("link"), "1191000600000000", Integer.valueOf(((Boolean) hashMap.get("is_game")).booleanValue() ? 1 : 0))) {
                if (k.isEmpty((String) hashMap.get("h5_url"))) {
                    return;
                }
                Activity currentActivity2 = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity2 instanceof TbPageContextSupport) {
                    UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity2).getPageContext(), new String[]{(String) hashMap.get("h5_url")});
                }
            }
        }
        result.success(Boolean.TRUE);
    }

    public final void postSignProcess(MethodCall methodCall, MethodChannel.Result result) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof TbPageContextSupport) {
            d.b.h0.s.d.f.c().a(((TbPageContextSupport) currentActivity).getPageContext(), (ViewGroup) currentActivity.getWindow().getDecorView());
        }
    }

    public final void preferenceGetStringValue(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("key");
        String str2 = (String) methodCall.argument("nameSpace");
        if (k.isEmpty(str)) {
            result.error("key is empty", "", "");
        } else {
            result.success(d.b.h0.r.d0.b.i().o(str, ""));
        }
    }

    public final void preferenceGetValues(MethodCall methodCall, MethodChannel.Result result) {
        ArrayList arrayList = (ArrayList) methodCall.argument("keys");
        String str = (String) methodCall.argument("nameSpace");
        HashMap hashMap = new HashMap();
        for (int i = 0; i < arrayList.size(); i++) {
            if (d.b.h0.r.d0.b.i().r(SharePrefNameTransform.getAndroidNameFromIos((String) arrayList.get(i)))) {
                hashMap.put(arrayList.get(i), Boolean.valueOf(d.b.h0.r.d0.b.i().g(SharePrefNameTransform.getAndroidNameFromIos((String) arrayList.get(i)), false)));
            }
        }
        result.success(hashMap);
    }

    public final void preferenceSetStringValue(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("nameSpace");
        String str2 = (String) methodCall.argument("key");
        String str3 = (String) methodCall.argument("value");
        if (!k.isEmpty(str2) && !k.isEmpty(str3)) {
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences(str, 0).edit();
            edit.putString(str2, str3);
            edit.commit();
            return;
        }
        result.error("input is empty", "", "");
    }

    public final void preferenceSetValues(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("nameSpace");
        HashMap hashMap = (HashMap) methodCall.argument("keyValueMap");
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry.getValue() instanceof Boolean) {
                    d.b.h0.r.d0.b.i().s(SharePrefNameTransform.getAndroidNameFromIos((String) entry.getKey()), ((Boolean) entry.getValue()).booleanValue());
                }
            }
        }
        result.success(Boolean.TRUE);
    }

    public byte[] readFileFromAsset(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        byte[] bArr = new byte[1024];
        InputStream inputStream2 = null;
        try {
            inputStream = BdBaseApplication.getInst().getAssets().open(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        try {
                            int read = inputStream.read(bArr);
                            if (read != -1) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                byteArrayOutputStream.flush();
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                d.b.b.e.m.a.c(inputStream);
                                d.b.b.e.m.a.d(byteArrayOutputStream);
                                return byteArray;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            d.b.b.e.m.a.c(inputStream);
                            d.b.b.e.m.a.d(byteArrayOutputStream);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream2 = inputStream;
                        d.b.b.e.m.a.c(inputStream2);
                        d.b.b.e.m.a.d(byteArrayOutputStream);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                inputStream2 = inputStream;
                d.b.b.e.m.a.c(inputStream2);
                d.b.b.e.m.a.d(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            inputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            d.b.b.e.m.a.c(inputStream2);
            d.b.b.e.m.a.d(byteArrayOutputStream);
            throw th;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:11:0x0028 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0041 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v0, types: [int] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v6 */
    public byte[] readFileFromRaw(Resources resources, int i) {
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = new byte[1024];
        InputStream inputStream = null;
        try {
            try {
                resources = resources.openRawResource(i);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            resources = 0;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
            d.b.b.e.m.a.c(inputStream);
            d.b.b.e.m.a.d(outputStream);
            throw th;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                try {
                    int read = resources.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        d.b.b.e.m.a.c(resources);
                        d.b.b.e.m.a.d(byteArrayOutputStream);
                        return byteArray;
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    d.b.b.e.m.a.c(resources);
                    d.b.b.e.m.a.d(byteArrayOutputStream);
                    return null;
                }
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            i = 0;
            inputStream = resources;
            outputStream = i;
            d.b.b.e.m.a.c(inputStream);
            d.b.b.e.m.a.d(outputStream);
            throw th;
        }
    }

    public final void redirectTo(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("url");
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (TextUtils.isEmpty(str) || !(currentActivity instanceof TbPageContextSupport)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{str});
    }

    public void sendMesage(int i, AgreeData agreeData) {
        if (agreeData == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
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
        BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
        if (baijiahaoData != null) {
            httpMessage.addParam("ori_ugc_tid", baijiahaoData.oriUgcTid);
            httpMessage.addParam("ori_ugc_nid", agreeData.baijiahaoData.oriUgcNid);
            httpMessage.addParam("ori_ugc_vid", agreeData.baijiahaoData.oriUgcVid);
            httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, agreeData.baijiahaoData.oriUgcType);
        }
        if (!StringUtil.isEmpty(agreeData.objSource)) {
            httpMessage.addParam("obj_source", agreeData.objSource);
        }
        httpMessage.setExtra(Integer.valueOf(i));
        httpMessage.addHeader("needSig", "1");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final void setOfficalForumLetterReminderOpen(MethodCall methodCall, MethodChannel.Result result) {
        final String str = (String) methodCall.argument(TbTitleActivityConfig.FORUM_ID);
        final boolean booleanValue = ((Boolean) methodCall.argument("open")).booleanValue();
        new BdAsyncTask<Void, Void, Void>(this) { // from class: com.example.utility_plugin.UtilityPlugin.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                d.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(str), booleanValue);
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public final void statLogEvent(MethodCall methodCall, MethodChannel.Result result) {
        HashMap hashMap = (HashMap) methodCall.argument("params");
        StatisticItem statisticItem = new StatisticItem((String) methodCall.argument("key"));
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry.getValue() instanceof String) {
                    statisticItem.param((String) entry.getKey(), (String) entry.getValue());
                } else if (entry.getValue() instanceof Integer) {
                    statisticItem.param((String) entry.getKey(), ((Integer) entry.getValue()).intValue());
                } else if (entry.getValue() instanceof Long) {
                    statisticItem.param((String) entry.getKey(), ((Long) entry.getValue()).longValue());
                } else if (entry.getValue() instanceof Double) {
                    statisticItem.param((String) entry.getKey(), ((Double) entry.getValue()).doubleValue());
                }
            }
        }
        TiebaStatic.log(statisticItem);
    }
}
