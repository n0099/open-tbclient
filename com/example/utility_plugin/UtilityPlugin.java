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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.e;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.messageCenter.f;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.tieba.im.settingcache.d;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class UtilityPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private static NativeListeners mNativeListeners;

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "utility_plugin").setMethodCallHandler(new UtilityPlugin());
        mNativeListeners = new NativeListeners(new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "utility_plugin"));
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals("getPlatformVersion")) {
            result.success("Android " + Build.VERSION.RELEASE);
        } else if (methodCall.method.equals("getUserTBS")) {
            result.success(TbadkCoreApplication.getInst().getTbs());
        } else if (methodCall.method.equals("getUserUID")) {
            result.success(TbadkCoreApplication.getCurrentAccount());
        } else if (methodCall.method.equals("isVisitorMode")) {
            result.success(Boolean.valueOf(!TbadkCoreApplication.isLogin()));
        } else if (methodCall.method.equals("goToLogin")) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(TbadkCoreApplication.getInst().getContext(), true)));
        } else if (methodCall.method.equals("getUserSmallPhotoHost")) {
            result.success(TbConfig.getPhotoSmallAddress());
        } else if (methodCall.method.equals("getUserBigPhotoHost")) {
            result.success(TbConfig.getBigPhotoAdress());
        } else if (methodCall.method.equals("preferenceGetStringValue")) {
            String str = (String) methodCall.argument("key");
            String str2 = (String) methodCall.argument("nameSpace");
            if (aq.isEmpty(str)) {
                result.error("key is empty", "", "");
            } else {
                result.success(b.aNV().getString(str, ""));
            }
        } else if (methodCall.method.equals("preferenceSetStringValue")) {
            String str3 = (String) methodCall.argument("nameSpace");
            String str4 = (String) methodCall.argument("key");
            String str5 = (String) methodCall.argument("value");
            if (aq.isEmpty(str4) || aq.isEmpty(str5)) {
                result.error("input is empty", "", "");
                return;
            }
            SharedPreferences.Editor edit = BdBaseApplication.getInst().getApp().getSharedPreferences(str3, 0).edit();
            edit.putString(str4, str5);
            edit.commit();
        } else if (methodCall.method.equals("addNotificationObserver")) {
            if (methodCall.arguments instanceof String) {
                mNativeListeners.addNotificationObserver((String) methodCall.arguments);
            }
        } else if (methodCall.method.equals("removeNotificationObserver")) {
            if (methodCall.arguments instanceof String) {
                mNativeListeners.removeNotificationObserver((String) methodCall.arguments);
            }
        } else if (methodCall.method.equals("delAllMsgInForumUser")) {
            String str6 = (String) methodCall.argument(TbTitleActivityConfig.FORUM_ID);
            if (aq.isEmpty(str6)) {
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(str6), 4, null, 1)));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEL_OFFICIAL_DB, String.valueOf(str6)));
            }
        } else if (methodCall.method.equals("getIsOfficalForumLetterReminderOpen")) {
            OfficialSettingItemData dS = d.ciV().dS(TbadkApplication.getCurrentAccount(), (String) methodCall.arguments);
            if (dS != null) {
                result.success(Boolean.valueOf(dS.isAcceptNotify()));
            } else {
                result.success(true);
            }
        } else if (methodCall.method.equals("setOfficalForumLetterReminderOpen")) {
            final String str7 = (String) methodCall.argument(TbTitleActivityConfig.FORUM_ID);
            final boolean booleanValue = ((Boolean) methodCall.argument("open")).booleanValue();
            new BdAsyncTask<Void, Void, Void>() { // from class: com.example.utility_plugin.UtilityPlugin.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(Void... voidArr) {
                    if (!TextUtils.isEmpty(str7)) {
                        d.ciV().x(TbadkApplication.getCurrentAccount(), String.valueOf(str7), booleanValue);
                    }
                    return null;
                }
            }.execute(new Void[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        } else if (!methodCall.method.equals("resetFansNumCount")) {
            if (methodCall.method.equals("postSignProcess")) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity instanceof TbPageContextSupport) {
                    f.aUi().a(((TbPageContextSupport) currentActivity).getPageContext(), (ViewGroup) currentActivity.getWindow().getDecorView());
                }
            } else if (methodCall.method.equals("redirectTo")) {
                String str8 = (String) methodCall.argument("url");
                Activity currentActivity2 = TbadkCoreApplication.getInst().getCurrentActivity();
                if (!TextUtils.isEmpty(str8) && (currentActivity2 instanceof TbPageContextSupport)) {
                    ba.aOY().b(((TbPageContextSupport) currentActivity2).getPageContext(), new String[]{str8});
                }
            } else if (methodCall.method.equals("postNotification")) {
                mNativeListeners.postNotification(methodCall.arguments);
            } else if (methodCall.method.equals("statLogEvent")) {
                HashMap hashMap = (HashMap) methodCall.argument("params");
                an anVar = new an((String) methodCall.argument("key"));
                if (hashMap != null && !hashMap.isEmpty()) {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        anVar.cI((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                TiebaStatic.log(anVar);
            } else if (methodCall.method.equals("debugLog")) {
                String str9 = (String) methodCall.argument("key");
                HashMap hashMap2 = (HashMap) methodCall.argument("params");
                a aVar = new a("dbg");
                if (hashMap2 != null && !hashMap2.isEmpty()) {
                    for (Map.Entry entry2 : hashMap2.entrySet()) {
                        aVar.addValue(entry2.getKey(), entry2.getValue());
                    }
                }
                BdStatisticsManager.getInstance().debug(str9, aVar);
            } else if (!methodCall.method.equals("showTopToast")) {
                if (methodCall.method.equals("preferenceGetValues")) {
                    ArrayList arrayList = (ArrayList) methodCall.argument("keys");
                    String str10 = (String) methodCall.argument("nameSpace");
                    HashMap hashMap3 = new HashMap();
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (b.aNV().isContains(SharePrefNameTransform.getAndroidNameFromIos((String) arrayList.get(i)))) {
                            hashMap3.put(arrayList.get(i), Boolean.valueOf(b.aNV().getBoolean(SharePrefNameTransform.getAndroidNameFromIos((String) arrayList.get(i)), false)));
                        }
                    }
                    result.success(hashMap3);
                } else if (methodCall.method.equals("preferenceSetValues")) {
                    String str11 = (String) methodCall.argument("nameSpace");
                    HashMap hashMap4 = (HashMap) methodCall.argument("keyValueMap");
                    if (hashMap4 != null && !hashMap4.isEmpty()) {
                        for (Map.Entry entry3 : hashMap4.entrySet()) {
                            if (entry3.getValue() instanceof Boolean) {
                                b.aNV().putBoolean(SharePrefNameTransform.getAndroidNameFromIos((String) entry3.getKey()), ((Boolean) entry3.getValue()).booleanValue());
                            }
                        }
                    }
                    result.success(true);
                } else if (methodCall.method.equals("accessWalletService")) {
                    String str12 = (String) methodCall.arguments;
                    if (!StringUtils.isNull(str12)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_OPEN_WALLET_ICASH, str12));
                    }
                } else if (methodCall.method.equals("openBBASMApp")) {
                    HashMap hashMap5 = (HashMap) methodCall.arguments;
                    if (!com.baidu.tieba.aiapps.a.b((String) hashMap5.get("id"), (String) hashMap5.get("link"), "1191000600000000", Integer.valueOf(((Boolean) hashMap5.get("is_game")).booleanValue() ? 1 : 0))) {
                        if (!aq.isEmpty((String) hashMap5.get("h5_url"))) {
                            Activity currentActivity3 = TbadkCoreApplication.getInst().getCurrentActivity();
                            if (currentActivity3 instanceof TbPageContextSupport) {
                                ba.aOY().b(((TbPageContextSupport) currentActivity3).getPageContext(), new String[]{(String) hashMap5.get("h5_url")});
                            }
                        } else {
                            return;
                        }
                    }
                    result.success(true);
                } else if (methodCall.method.equals("readNewMessage")) {
                    HashMap hashMap6 = new HashMap();
                    hashMap6.put("bookmarkNum", Integer.valueOf(com.baidu.tieba.p.a.cOL().cOI() ? 1 : 0));
                    hashMap6.put("fansNum", Integer.valueOf(com.baidu.tieba.p.a.cOL().cOH() ? 1 : 0));
                    result.success(hashMap6);
                } else if (methodCall.method.equals("clearNewMessage")) {
                    String str13 = (String) methodCall.arguments;
                    if (!StringUtils.isNull(str13)) {
                        if ("bookmarkNum".equals(str13)) {
                            com.baidu.tieba.p.a.cOL().g(3, false, true);
                        } else if ("fansNum".equals(str13)) {
                            com.baidu.tieba.p.a.cOL().g(2, false, true);
                        } else if ("giftNum".equals(str13)) {
                            com.baidu.tieba.p.a.cOL().g(1, false, true);
                        }
                    }
                } else if (methodCall.method.equals("readVipCenterNewMessage")) {
                    result.success(Boolean.valueOf(com.baidu.tieba.p.a.cOL().cOJ()));
                } else if (methodCall.method.equals("showLoginAwardCell")) {
                    result.success(Boolean.valueOf(TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch()));
                } else if (methodCall.method.equals("showRedDotForMyTab")) {
                    result.success(Boolean.valueOf(com.baidu.tieba.p.a.cOL().cOK()));
                } else if (methodCall.method.equals("getThemeMode")) {
                    result.success(am.aON());
                } else if (methodCall.method.equals("getMyPrivateStat")) {
                    result.success(Integer.valueOf(e.jz(((Integer) methodCall.argument("type")).intValue())));
                } else if (methodCall.method.equals("setMyPrivateStat")) {
                    e.az(((Integer) methodCall.argument("type")).intValue(), ((Integer) methodCall.argument("stat")).intValue());
                    result.success((Object) null);
                } else if (methodCall.method.equals("hasOfficialChat")) {
                    result.success(Boolean.valueOf(TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT)));
                } else if (methodCall.method.equals("delLikeForum")) {
                    TbadkCoreApplication.getInst().delLikeForum((String) methodCall.arguments);
                } else if (methodCall.method.equals("goToMainTabRefresh")) {
                    com.baidu.tbadk.core.e.b.c(TbadkCoreApplication.getInst(), ((Integer) methodCall.arguments).intValue(), false);
                } else if ("getLottieBytes".equals(methodCall.method)) {
                    String str14 = (String) methodCall.argument("name");
                    Resources resources = g.jo().getResources();
                    int resIdBySkin = getResIdBySkin((String) methodCall.argument("themeStr"), resources.getIdentifier(ResNameTransform.getAndroidNameFromIos(str14), "raw", BdBaseApplication.getInst().getPackageName()));
                    if (resIdBySkin != 0) {
                        byte[] readFileFromRaw = readFileFromRaw(resources, resIdBySkin);
                        if (readFileFromRaw != null && readFileFromRaw.length > 0) {
                            result.success(readFileFromRaw);
                            return;
                        } else {
                            result.error("flutter lottie resource data is null :" + str14, "bytes:" + readFileFromRaw, "");
                            return;
                        }
                    }
                    result.error("flutter lottie resource in package not found :" + str14, "", "");
                } else {
                    result.notImplemented();
                }
            }
        }
    }

    private int getResIdBySkin(String str, int i) {
        int d;
        int c;
        if (aq.isEmpty(str)) {
            return 0;
        }
        if (ComboPraiseProvider.DIR_PREFIX_NIGHT.equals(str) && (c = am.c(TbadkCoreApplication.getInst().getResources(), i)) > 0) {
            i = c;
        }
        return (!"dark".equals(str) || (d = am.d(TbadkCoreApplication.getInst().getResources(), i)) <= 0) ? i : d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [369=4] */
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
}
