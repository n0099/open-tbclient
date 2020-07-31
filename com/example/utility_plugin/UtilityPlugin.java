package com.example.utility_plugin;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.sofire.ac.FH;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.e.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.messageCenter.f;
import com.baidu.tbadk.mutiprocess.agree.AgreeEvent;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.tieba.im.settingcache.d;
import com.baidu.tieba.p.a;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class UtilityPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private static NativeListeners mNativeListeners;

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
                        hashMap.put("bookmarkNum", Integer.valueOf(a.ddy().ddv() ? 1 : 0));
                        hashMap.put("fansNum", Integer.valueOf(a.ddy().ddu() ? 1 : 0));
                        result.success(hashMap);
                    } else if (methodCall.method.equals("clearNewMessage")) {
                        clearNewMessage(methodCall, result);
                    } else if (methodCall.method.equals("readVipCenterNewMessage")) {
                        result.success(Boolean.valueOf(a.ddy().ddw()));
                    } else if (methodCall.method.equals("showLoginAwardCell")) {
                        result.success(Boolean.valueOf(TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch()));
                    } else if (methodCall.method.equals("showRedDotForMyTab")) {
                        result.success(Boolean.valueOf(a.ddy().ddx()));
                    } else if (methodCall.method.equals("getThemeMode")) {
                        result.success(ao.baL());
                    } else if (methodCall.method.equals("getMyPrivateStat")) {
                        result.success(Integer.valueOf(e.kF(((Integer) methodCall.argument("type")).intValue())));
                    } else if (methodCall.method.equals("setMyPrivateStat")) {
                        e.aF(((Integer) methodCall.argument("type")).intValue(), ((Integer) methodCall.argument("stat")).intValue());
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
                            doAgreeAndDisagree(true, new JSONObject((HashMap) methodCall.argument("item")));
                        }
                    } else if (methodCall.method.equals("disagreeThread")) {
                        if (methodCall.argument("item") != null && (methodCall.argument("item") instanceof HashMap)) {
                            doAgreeAndDisagree(false, new JSONObject((HashMap) methodCall.argument("item")));
                        }
                    } else if (methodCall.method.equals("shareFrs")) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921463, (String) methodCall.argument(TbTitleActivityConfig.FORUM_ID)));
                    } else if (methodCall.method.equals("getAppVersion")) {
                        result.success(TbConfig.getVersion());
                    } else {
                        result.notImplemented();
                    }
                }
            }
        } else {
            result.success(Boolean.valueOf(!TbadkCoreApplication.isLogin()));
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
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharePrefNameTransform.getAndroidNameFromIos((String) entry.getKey()), ((Boolean) entry.getValue()).booleanValue());
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
            if (com.baidu.tbadk.core.sharedPref.b.aZP().isContains(SharePrefNameTransform.getAndroidNameFromIos((String) arrayList.get(i)))) {
                hashMap.put(arrayList.get(i), Boolean.valueOf(com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharePrefNameTransform.getAndroidNameFromIos((String) arrayList.get(i)), false)));
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
        ap apVar = new ap((String) methodCall.argument("key"));
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                apVar.dn((String) entry.getKey(), (String) entry.getValue());
            }
        }
        TiebaStatic.log(apVar);
    }

    private void redirectTo(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("url");
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (!TextUtils.isEmpty(str) && (currentActivity instanceof TbPageContextSupport)) {
            bd.baV().b(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{str});
        }
    }

    private void postSignProcess(MethodCall methodCall, MethodChannel.Result result) {
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof TbPageContextSupport) {
            f.bgj().a(((TbPageContextSupport) currentActivity).getPageContext(), (ViewGroup) currentActivity.getWindow().getDecorView());
        }
    }

    private void setOfficalForumLetterReminderOpen(MethodCall methodCall, MethodChannel.Result result) {
        final String str = (String) methodCall.argument(TbTitleActivityConfig.FORUM_ID);
        final boolean booleanValue = ((Boolean) methodCall.argument("open")).booleanValue();
        new BdAsyncTask<Void, Void, Void>() { // from class: com.example.utility_plugin.UtilityPlugin.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    d.cxs().A(TbadkApplication.getCurrentAccount(), String.valueOf(str), booleanValue);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void getIsOfficalForumLetterReminderOpen(MethodCall methodCall, MethodChannel.Result result) {
        OfficialSettingItemData eB = d.cxs().eB(TbadkApplication.getCurrentAccount(), (String) methodCall.arguments);
        if (eB != null) {
            result.success(Boolean.valueOf(eB.isAcceptNotify()));
        } else {
            result.success(true);
        }
    }

    private void delAllMsgInForumUser(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument(TbTitleActivityConfig.FORUM_ID);
        if (as.isEmpty(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(str), 4, null, 1)));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEL_OFFICIAL_DB, String.valueOf(str)));
        }
    }

    private void preferenceSetStringValue(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("nameSpace");
        String str2 = (String) methodCall.argument("key");
        String str3 = (String) methodCall.argument("value");
        if (as.isEmpty(str2) || as.isEmpty(str3)) {
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
        if (as.isEmpty(str)) {
            result.error("key is empty", "", "");
        } else {
            result.success(com.baidu.tbadk.core.sharedPref.b.aZP().getString(str, ""));
        }
    }

    private int getResIdBySkin(String str, int i) {
        int d;
        int c;
        if (as.isEmpty(str)) {
            return 0;
        }
        if (ComboPraiseProvider.DIR_PREFIX_NIGHT.equals(str) && (c = ao.c(TbadkCoreApplication.getInst().getResources(), i)) > 0) {
            i = c;
        }
        return (!"dark".equals(str) || (d = ao.d(TbadkCoreApplication.getInst().getResources(), i)) <= 0) ? i : d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [410=4] */
    public byte[] readFileFromRaw(Resources resources, int i) {
        OutputStream outputStream;
        InputStream inputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = null;
        byte[] bArr2 = new byte[1024];
        try {
            try {
                inputStream = resources.openRawResource(i);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
            inputStream = null;
        } catch (Throwable th3) {
            outputStream = null;
            inputStream = null;
            th = th3;
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
        } catch (Throwable th4) {
            outputStream = null;
            th = th4;
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
                bd.baV().b(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{(String) methodCall.arguments});
            }
        } else if (methodCall.arguments instanceof HashMap) {
            HashMap hashMap = (HashMap) methodCall.arguments;
            if (!com.baidu.tieba.aiapps.a.b((String) hashMap.get("id"), (String) hashMap.get("link"), "1191000600000000", Integer.valueOf(((Boolean) hashMap.get("is_game")).booleanValue() ? 1 : 0))) {
                if (!as.isEmpty((String) hashMap.get("h5_url"))) {
                    Activity currentActivity2 = TbadkCoreApplication.getInst().getCurrentActivity();
                    if (currentActivity2 instanceof TbPageContextSupport) {
                        bd.baV().b(((TbPageContextSupport) currentActivity2).getPageContext(), new String[]{(String) hashMap.get("h5_url")});
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
                a.ddy().g(3, false, true);
            } else if ("fansNum".equals(str)) {
                a.ddy().g(2, false, true);
            } else if ("giftNum".equals(str)) {
                a.ddy().g(1, false, true);
            }
        }
    }

    private void getLottieBytes(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("name");
        Resources resources = g.jE().getResources();
        int resIdBySkin = getResIdBySkin((String) methodCall.argument("themeStr"), resources.getIdentifier(ResNameTransform.getAndroidNameFromIos(str), "raw", BdBaseApplication.getInst().getPackageName()));
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

    private void doAgreeAndDisagree(boolean z, JSONObject jSONObject) {
        int i;
        int i2 = 0;
        bv bvVar = new bv();
        bvVar.parserJson(jSONObject);
        AgreeData aYc = bvVar.aYc();
        if (z) {
            TbPageContext tbPageContext = null;
            if (TbadkApplication.getInst().getCurrentActivity() != null) {
                tbPageContext = ((TbPageContextSupport) TbadkApplication.getInst().getCurrentActivity()).getPageContext();
            }
            if (aYc.hasAgree) {
                if (aYc.agreeType == 2) {
                    aYc.agreeType = 2;
                    aYc.hasAgree = false;
                    aYc.agreeNum--;
                    i = 1;
                } else {
                    aYc.agreeType = 2;
                    aYc.hasAgree = true;
                    aYc.agreeNum++;
                    com.baidu.tieba.o.a.dbG().G(tbPageContext);
                    i = 0;
                }
            } else {
                aYc.agreeType = 2;
                aYc.hasAgree = true;
                aYc.agreeNum++;
                com.baidu.tieba.o.a.dbG().G(tbPageContext);
                i = 0;
            }
            sendMesage(i, aYc);
        } else {
            if (aYc.hasAgree) {
                if (aYc.agreeType == 5) {
                    aYc.agreeType = 5;
                    aYc.hasAgree = false;
                    NoNetworkView.updateUI();
                    i2 = 1;
                } else {
                    aYc.agreeType = 5;
                    aYc.hasAgree = true;
                    aYc.agreeNum--;
                }
            } else {
                aYc.agreeType = 5;
                aYc.hasAgree = true;
            }
            sendMesage(i2, aYc);
        }
        com.baidu.tieba.tbadkCore.data.e eVar = new com.baidu.tieba.tbadkCore.data.e();
        eVar.agreeData = aYc;
        if (bvVar != null && bvVar.getBaijiahaoData() != null) {
            aYc.nid = bvVar.getBaijiahaoData().oriUgcNid;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
        dispatchMutiProcessAgree(aYc, AgreeEvent.IS_THREAD);
    }

    private void dispatchMutiProcessAgree(AgreeData agreeData, String str) {
        AgreeEvent agreeEvent = new AgreeEvent();
        agreeEvent.agreeData = agreeData;
        agreeEvent.agreeExtra = str;
        com.baidu.tbadk.mutiprocess.g.publishEvent(agreeEvent);
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
            httpMessage.setExtra(Integer.valueOf(i));
            httpMessage.addHeader("needSig", "1");
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
