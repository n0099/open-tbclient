package com.example.utility_plugin;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.messageCenter.f;
import com.baidu.tieba.aiapps.a;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.tieba.im.settingcache.d;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
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
                result.success(b.aFB().getString(str, ""));
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
            OfficialSettingItemData dF = d.bXZ().dF(TbadkApplication.getCurrentAccount(), (String) methodCall.arguments);
            if (dF != null) {
                result.success(Boolean.valueOf(dF.isAcceptNotify()));
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
                        d.bXZ().y(TbadkApplication.getCurrentAccount(), String.valueOf(str7), booleanValue);
                    }
                    return null;
                }
            }.execute(new Void[0]);
            MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
        } else if (!methodCall.method.equals("resetFansNumCount")) {
            if (methodCall.method.equals("postSignProcess")) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity instanceof TbPageContextSupport) {
                    f.aLE().a(((TbPageContextSupport) currentActivity).getPageContext(), (ViewGroup) currentActivity.getWindow().getDecorView());
                }
            } else if (methodCall.method.equals("redirectTo")) {
                String str8 = (String) methodCall.argument("url");
                Activity currentActivity2 = TbadkCoreApplication.getInst().getCurrentActivity();
                if (!TextUtils.isEmpty(str8) && (currentActivity2 instanceof TbPageContextSupport)) {
                    ba.aGE().b(((TbPageContextSupport) currentActivity2).getPageContext(), new String[]{str8});
                }
            } else if (methodCall.method.equals("postNotification")) {
                mNativeListeners.postNotification(methodCall.arguments);
            } else if (methodCall.method.equals("statLogEvent")) {
                HashMap hashMap = (HashMap) methodCall.argument("params");
                an anVar = new an((String) methodCall.argument("key"));
                if (hashMap != null && !hashMap.isEmpty()) {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        anVar.cy((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                TiebaStatic.log(anVar);
            } else if (!methodCall.method.equals("showTopToast")) {
                if (methodCall.method.equals("preferenceGetValues")) {
                    ArrayList arrayList = (ArrayList) methodCall.argument("keys");
                    String str9 = (String) methodCall.argument("nameSpace");
                    HashMap hashMap2 = new HashMap();
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (b.aFB().isContains(SharePrefNameTransform.getAndroidNameFromIos((String) arrayList.get(i)))) {
                            hashMap2.put(arrayList.get(i), Boolean.valueOf(b.aFB().getBoolean(SharePrefNameTransform.getAndroidNameFromIos((String) arrayList.get(i)), false)));
                        }
                    }
                    result.success(hashMap2);
                } else if (methodCall.method.equals("preferenceSetValues")) {
                    String str10 = (String) methodCall.argument("nameSpace");
                    HashMap hashMap3 = (HashMap) methodCall.argument("keyValueMap");
                    if (hashMap3 != null && !hashMap3.isEmpty()) {
                        for (Map.Entry entry2 : hashMap3.entrySet()) {
                            if (entry2.getValue() instanceof Boolean) {
                                b.aFB().putBoolean(SharePrefNameTransform.getAndroidNameFromIos((String) entry2.getKey()), ((Boolean) entry2.getValue()).booleanValue());
                            }
                        }
                    }
                    result.success(true);
                } else if (methodCall.method.equals("accessWalletService")) {
                    String str11 = (String) methodCall.arguments;
                    if (!StringUtils.isNull(str11)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_OPEN_WALLET_ICASH, str11));
                    }
                } else if (methodCall.method.equals("openSwanApp")) {
                    HashMap hashMap4 = (HashMap) methodCall.arguments;
                    if (!a.b((String) hashMap4.get("id"), (String) hashMap4.get("link"), "1191000600000000", Integer.valueOf(((Boolean) hashMap4.get("is_game")).booleanValue() ? 1 : 0))) {
                        if (!aq.isEmpty((String) hashMap4.get("h5_url"))) {
                            Activity currentActivity3 = TbadkCoreApplication.getInst().getCurrentActivity();
                            if (currentActivity3 instanceof TbPageContextSupport) {
                                ba.aGE().b(((TbPageContextSupport) currentActivity3).getPageContext(), new String[]{(String) hashMap4.get("h5_url")});
                            }
                        } else {
                            return;
                        }
                    }
                    result.success(true);
                } else if (methodCall.method.equals("readNewMessage")) {
                    HashMap hashMap5 = new HashMap();
                    hashMap5.put("bookmarkNum", Integer.valueOf(com.baidu.tieba.p.a.cDN().cDK() ? 1 : 0));
                    hashMap5.put("fansNum", Integer.valueOf(com.baidu.tieba.p.a.cDN().cDJ() ? 1 : 0));
                    result.success(hashMap5);
                } else if (methodCall.method.equals("clearNewMessage")) {
                    String str12 = (String) methodCall.arguments;
                    if (!StringUtils.isNull(str12)) {
                        if ("bookmarkNum".equals(str12)) {
                            com.baidu.tieba.p.a.cDN().g(3, false, true);
                        } else if ("fansNum".equals(str12)) {
                            com.baidu.tieba.p.a.cDN().g(2, false, true);
                        } else if ("giftNum".equals(str12)) {
                            com.baidu.tieba.p.a.cDN().g(1, false, true);
                        }
                    }
                } else if (methodCall.method.equals("readVipCenterNewMessage")) {
                    result.success(Boolean.valueOf(com.baidu.tieba.p.a.cDN().cDL()));
                } else if (methodCall.method.equals("showLoginAwardCell")) {
                    result.success(Boolean.valueOf(TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch()));
                } else if (methodCall.method.equals("showRedDotForMyTab")) {
                    result.success(Boolean.valueOf(com.baidu.tieba.p.a.cDN().cDM()));
                } else if (methodCall.method.equals("getThemeMode")) {
                    result.success(am.aGt());
                } else {
                    result.notImplemented();
                }
            }
        }
    }
}
