package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.webkit.sdk.VideoCloudSetting;
import com.heytap.mcssdk.mode.Message;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ax;
import com.xiaomi.push.bm;
import com.xiaomi.push.dj;
import com.xiaomi.push.dk;
import com.xiaomi.push.ei;
import com.xiaomi.push.ej;
import com.xiaomi.push.ek;
import com.xiaomi.push.ev;
import com.xiaomi.push.hf;
import com.xiaomi.push.hj;
import com.xiaomi.push.hk;
import com.xiaomi.push.hp;
import com.xiaomi.push.hs;
import com.xiaomi.push.ht;
import com.xiaomi.push.hz;
import com.xiaomi.push.ie;
import com.xiaomi.push.ij;
import com.xiaomi.push.il;
import com.xiaomi.push.in;
import com.xiaomi.push.service.aq;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes7.dex */
public abstract class MiPushClient {
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNREGISTER = "unregister";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final String PREF_EXTRA = "mipush_extra";
    public static Context sContext;
    public static long sCurMsgId = System.currentTimeMillis();

    /* loaded from: classes7.dex */
    public static class CodeResult {
        public long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        public void setResultCode(long j) {
            this.resultCode = j;
        }
    }

    /* loaded from: classes7.dex */
    public interface ICallbackResult<R> {
        void onResult(R r);
    }

    @Deprecated
    /* loaded from: classes7.dex */
    public static abstract class MiPushClientCallback {
        public String category;

        public String getCategory() {
            return this.category;
        }

        public void onCommandResult(String str, long j, String str2, List<String> list) {
        }

        public void onInitializeResult(long j, String str, String str2) {
        }

        public void onReceiveMessage(MiPushMessage miPushMessage) {
        }

        public void onReceiveMessage(String str, String str2, String str3, boolean z) {
        }

        public void onSubscribeResult(long j, String str, String str2) {
        }

        public void onUnsubscribeResult(long j, String str, String str2) {
        }

        public void setCategory(String str) {
            this.category = str;
        }
    }

    /* loaded from: classes7.dex */
    public static class TokenResult {
        public String token = null;
        public long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        public String getToken() {
            return this.token;
        }

        public void setResultCode(long j) {
            this.resultCode = j;
        }

        public void setToken(String str) {
            this.token = str;
        }
    }

    /* loaded from: classes7.dex */
    public interface UPSRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    /* loaded from: classes7.dex */
    public interface UPSTurnCallBack extends ICallbackResult<CodeResult> {
    }

    /* loaded from: classes7.dex */
    public interface UPSUnRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    public static boolean acceptTimeSet(Context context, String str, String str2) {
        String acceptTime = getAcceptTime(context);
        return TextUtils.equals(acceptTime, str + "," + str2);
    }

    public static long accountSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("account_" + str, -1L);
    }

    public static synchronized void addAcceptTime(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(Constants.EXTRA_KEY_ACCEPT_TIME, str + "," + str2);
            com.xiaomi.push.r.a(edit);
        }
    }

    public static synchronized void addAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("account_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static synchronized void addAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("alias_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static void addPullNotificationTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_pull_notification", System.currentTimeMillis());
        com.xiaomi.push.r.a(edit);
    }

    public static void addRegRequestTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        com.xiaomi.push.r.a(edit);
    }

    public static synchronized void addTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("topic_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static long aliasSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("alias_" + str, -1L);
    }

    public static void awakeApps(final Context context, final String[] strArr) {
        com.xiaomi.push.ai.a(context).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.4
            @Override // java.lang.Runnable
            public void run() {
                String[] strArr2;
                PackageInfo packageInfo;
                try {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str) && (packageInfo = context.getPackageManager().getPackageInfo(str, 4)) != null) {
                            MiPushClient.awakePushServiceByPackageInfo(context, packageInfo);
                        }
                    }
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.a(th);
                }
            }
        });
    }

    public static void awakePushServiceByPackageInfo(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    try {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                        intent.putExtra("waker_pkgname", context.getPackageName());
                        PushMessageHandler.a(context, intent);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
        }
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new IllegalArgumentException("param " + str + " is not nullable");
    }

    public static void clearExtras(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        an.a(context).m98e();
    }

    public static void clearNotification(Context context) {
        an.a(context).a(-1);
    }

    public static void clearNotification(Context context, int i2) {
        an.a(context).a(i2);
    }

    public static void clearNotification(Context context, String str, String str2) {
        an.a(context).a(str, str2);
    }

    public static void disablePush(Context context) {
        an.a(context).a(true);
    }

    public static void enablePush(Context context) {
        an.a(context).a(false);
    }

    public static String getAcceptTime(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString(Constants.EXTRA_KEY_ACCEPT_TIME, "00:00-23:59");
    }

    public static List<String> getAllAlias(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring(8));
            }
        }
        return arrayList;
    }

    public static String getAppRegion(Context context) {
        if (b.m99a(context).m108c()) {
            return b.m99a(context).f();
        }
        return null;
    }

    public static boolean getDefaultSwitch() {
        return com.xiaomi.push.l.m526b();
    }

    public static boolean getOpenFCMPush(Context context) {
        checkNotNull(context, "context");
        return f.a(context).b(e.ASSEMBLE_PUSH_FCM);
    }

    public static boolean getOpenHmsPush(Context context) {
        checkNotNull(context, "context");
        return f.a(context).b(e.ASSEMBLE_PUSH_HUAWEI);
    }

    public static boolean getOpenOPPOPush(Context context) {
        checkNotNull(context, "context");
        return f.a(context).b(e.ASSEMBLE_PUSH_COS);
    }

    public static boolean getOpenVIVOPush(Context context) {
        return f.a(context).b(e.ASSEMBLE_PUSH_FTOS);
    }

    public static String getRegId(Context context) {
        if (b.m99a(context).m108c()) {
            return b.m99a(context).m107c();
        }
        return null;
    }

    public static void initEventPerfLogic(final Context context) {
        ek.a(new ek.a() { // from class: com.xiaomi.mipush.sdk.MiPushClient.5
            @Override // com.xiaomi.push.ek.a
            public void uploader(Context context2, hj hjVar) {
                MiTinyDataClient.upload(context2, hjVar);
            }
        });
        Config a2 = ek.a(context);
        com.xiaomi.clientreport.manager.a.a(context).a("3_8_5");
        ClientReportClient.init(context, a2, new ei(context), new ej(context));
        a.a(context);
        s.a(context, a2);
        com.xiaomi.push.service.aq.a(context).a(new aq.a(100, "perf event job update") { // from class: com.xiaomi.mipush.sdk.MiPushClient.6
            @Override // com.xiaomi.push.service.aq.a
            public void onCallback() {
                ek.m275a(context);
            }
        });
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        initialize(context, str, str2, miPushClientCallback, null, null);
    }

    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback, String str3, ICallbackResult iCallbackResult) {
        try {
            com.xiaomi.channel.commonutils.logger.b.a(context.getApplicationContext());
            com.xiaomi.channel.commonutils.logger.b.e("sdk_version = 3_8_5");
            if (miPushClientCallback != null) {
                PushMessageHandler.a(miPushClientCallback);
            }
            if (iCallbackResult != null) {
                PushMessageHandler.a(iCallbackResult);
            }
            if (com.xiaomi.push.t.m628a(sContext)) {
                u.a(sContext);
            }
            boolean z = b.m99a(sContext).a() != Constants.a();
            if (!z && !shouldSendRegRequest(sContext)) {
                an.a(sContext).m90a();
                com.xiaomi.channel.commonutils.logger.b.m58a("Could not send  register message within 5s repeatly .");
                return;
            }
            if (z || !b.m99a(sContext).a(str, str2) || b.m99a(sContext).m111f()) {
                String a2 = bm.a(6);
                b.m99a(sContext).m101a();
                b.m99a(sContext).a(Constants.a());
                b.m99a(sContext).a(str, str2, a2);
                MiTinyDataClient.a.a().b(MiTinyDataClient.PENDING_REASON_APPID);
                clearExtras(sContext);
                clearNotification(context);
                Cif cif = new Cif();
                cif.a(com.xiaomi.push.service.at.a());
                cif.b(str);
                cif.e(str2);
                cif.d(sContext.getPackageName());
                cif.f(a2);
                cif.c(com.xiaomi.push.g.m326a(sContext, sContext.getPackageName()));
                cif.b(com.xiaomi.push.g.a(sContext, sContext.getPackageName()));
                cif.h("3_8_5");
                cif.a(30805);
                cif.a(ht.Init);
                if (!TextUtils.isEmpty(str3)) {
                    cif.g(str3);
                }
                if (!com.xiaomi.push.l.d()) {
                    String g2 = com.xiaomi.push.i.g(sContext);
                    if (!TextUtils.isEmpty(g2)) {
                        cif.i(bm.a(g2) + "," + com.xiaomi.push.i.j(sContext));
                    }
                }
                int a3 = com.xiaomi.push.i.a();
                if (a3 >= 0) {
                    cif.c(a3);
                }
                an.a(sContext).a(cif, z);
                sContext.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
            } else {
                if (1 == PushMessageHelper.getPushMode(sContext)) {
                    checkNotNull(miPushClientCallback, "callback");
                    miPushClientCallback.onInitializeResult(0L, null, b.m99a(sContext).m107c());
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(b.m99a(sContext).m107c());
                    PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(ev.COMMAND_REGISTER.f337a, arrayList, 0L, null, null));
                }
                an.a(sContext).m90a();
                if (b.m99a(sContext).m103a()) {
                    ie ieVar = new ie();
                    ieVar.b(b.m99a(sContext).m100a());
                    ieVar.c(hp.ClientInfoUpdate.f506a);
                    ieVar.a(com.xiaomi.push.service.at.a());
                    HashMap hashMap = new HashMap();
                    ieVar.f647a = hashMap;
                    hashMap.put("app_version", com.xiaomi.push.g.m326a(sContext, sContext.getPackageName()));
                    ieVar.f647a.put(Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.g.a(sContext, sContext.getPackageName())));
                    ieVar.f647a.put("push_sdk_vn", "3_8_5");
                    ieVar.f647a.put("push_sdk_vc", Integer.toString(30805));
                    com.xiaomi.push.i.a(sContext, ieVar.f647a);
                    String e2 = b.m99a(sContext).e();
                    if (!TextUtils.isEmpty(e2)) {
                        ieVar.f647a.put(DeviceUtils.KEY_OLD_NAME_STRING, e2);
                    }
                    an.a(sContext).a((an) ieVar, hf.Notification, false, (hs) null);
                }
                if (!com.xiaomi.push.n.m527a(sContext, "update_devId", false)) {
                    updateImeiOrOaid();
                    com.xiaomi.push.n.a(sContext, "update_devId", true);
                }
                String c2 = com.xiaomi.push.i.c(sContext);
                if (!TextUtils.isEmpty(c2)) {
                    hz hzVar = new hz();
                    hzVar.a(com.xiaomi.push.service.at.a());
                    hzVar.b(str);
                    hzVar.c(ev.COMMAND_CHK_VDEVID.f337a);
                    ArrayList arrayList2 = new ArrayList();
                    String b2 = com.xiaomi.push.i.b(sContext);
                    if (!TextUtils.isEmpty(b2)) {
                        arrayList2.add(b2);
                    }
                    if (c2 == null) {
                        c2 = "";
                    }
                    arrayList2.add(c2);
                    arrayList2.add(Build.MODEL != null ? Build.MODEL : "");
                    arrayList2.add(Build.BOARD != null ? Build.BOARD : "");
                    hzVar.a(arrayList2);
                    an.a(sContext).a((an) hzVar, hf.Command, false, (hs) null);
                }
                if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                    ie ieVar2 = new ie();
                    ieVar2.b(b.m99a(sContext).m100a());
                    ieVar2.c(hp.PullOfflineMessage.f506a);
                    ieVar2.a(com.xiaomi.push.service.at.a());
                    ieVar2.a(false);
                    an.a(sContext).a((an) ieVar2, hf.Notification, false, (hs) null, false);
                    addPullNotificationTime(sContext);
                }
            }
            addRegRequestTime(sContext);
            scheduleOcVersionCheckJob();
            scheduleDataCollectionJobs(sContext);
            initEventPerfLogic(sContext);
            au.a(sContext);
            if (!sContext.getPackageName().equals("com.xiaomi.xmsf")) {
                if (Logger.getUserLogger() != null) {
                    Logger.setLogger(sContext, Logger.getUserLogger());
                }
                com.xiaomi.channel.commonutils.logger.b.a(2);
            }
            operateSyncAction(context);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    public static void operateSyncAction(Context context) {
        if ("syncing".equals(ae.a(sContext).a(at.DISABLE_PUSH))) {
            disablePush(sContext);
        }
        if ("syncing".equals(ae.a(sContext).a(at.ENABLE_PUSH))) {
            enablePush(sContext);
        }
        if ("syncing".equals(ae.a(sContext).a(at.UPLOAD_HUAWEI_TOKEN))) {
            syncAssemblePushToken(sContext);
        }
        if ("syncing".equals(ae.a(sContext).a(at.UPLOAD_FCM_TOKEN))) {
            syncAssembleFCMPushToken(sContext);
        }
        if ("syncing".equals(ae.a(sContext).a(at.UPLOAD_COS_TOKEN))) {
            syncAssembleCOSPushToken(context);
        }
        if ("syncing".equals(ae.a(sContext).a(at.UPLOAD_FTOS_TOKEN))) {
            syncAssembleFTOSPushToken(context);
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    public static void reInitialize(Context context, ht htVar) {
        com.xiaomi.channel.commonutils.logger.b.e("re-register reason: " + htVar);
        String a2 = bm.a(6);
        String m100a = b.m99a(context).m100a();
        String b2 = b.m99a(context).b();
        b.m99a(context).m101a();
        clearNotification(context);
        b.m99a(context).a(Constants.a());
        b.m99a(context).a(m100a, b2, a2);
        Cif cif = new Cif();
        cif.a(com.xiaomi.push.service.at.a());
        cif.b(m100a);
        cif.e(b2);
        cif.f(a2);
        cif.d(context.getPackageName());
        cif.c(com.xiaomi.push.g.m326a(context, context.getPackageName()));
        cif.b(com.xiaomi.push.g.a(context, context.getPackageName()));
        cif.h("3_8_5");
        cif.a(30805);
        cif.a(htVar);
        int a3 = com.xiaomi.push.i.a();
        if (a3 >= 0) {
            cif.c(a3);
        }
        an.a(context).a(cif, false);
    }

    @Deprecated
    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    public static void registerNetworkReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            context.getApplicationContext().registerReceiver(new NetworkStatusReceiver(null), intentFilter);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    public static void registerPush(Context context, String str, String str2) {
        registerPush(context, str, str2, new PushConfiguration());
    }

    public static void registerPush(Context context, String str, String str2, PushConfiguration pushConfiguration) {
        registerPush(context, str, str2, pushConfiguration, null, null);
    }

    public static void registerPush(Context context, final String str, final String str2, PushConfiguration pushConfiguration, final String str3, final ICallbackResult iCallbackResult) {
        checkNotNull(context, "context");
        checkNotNull(str, Message.APP_ID);
        checkNotNull(str2, "appToken");
        Context applicationContext = context.getApplicationContext();
        sContext = applicationContext;
        if (applicationContext == null) {
            sContext = context;
        }
        Context context2 = sContext;
        com.xiaomi.push.t.m626a(context2);
        if (!NetworkStatusReceiver.a()) {
            registerNetworkReceiver(sContext);
        }
        f.a(sContext).a(pushConfiguration);
        com.xiaomi.push.ai.a(context2).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.1
            @Override // java.lang.Runnable
            public void run() {
                MiPushClient.initialize(MiPushClient.sContext, str, str2, null, str3, iCallbackResult);
            }
        });
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        registerPush(context, str, str2, new PushConfiguration(), str3, null);
    }

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        registerPush(context, str, str2, new PushConfiguration(), null, uPSRegisterCallBack);
    }

    public static synchronized void removeAcceptTime(Context context) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
            com.xiaomi.push.r.a(edit);
        }
    }

    public static synchronized void removeAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("account_" + str).commit();
        }
    }

    public static synchronized void removeAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("alias_" + str).commit();
        }
    }

    public static synchronized void removeAllAccounts(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllUserAccount(context)) {
                removeAccount(context, str);
            }
        }
    }

    public static synchronized void removeAllAliases(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllAlias(context)) {
                removeAlias(context, str);
            }
        }
    }

    public static synchronized void removeAllTopics(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllTopic(context)) {
                removeTopic(context, str);
            }
        }
    }

    public static synchronized void removeTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("topic_" + str).commit();
        }
    }

    public static void reportAppRunInBackground(Context context, boolean z) {
        if (b.m99a(context).m106b()) {
            hp hpVar = z ? hp.APP_SLEEP : hp.APP_WAKEUP;
            ie ieVar = new ie();
            ieVar.b(b.m99a(context).m100a());
            ieVar.c(hpVar.f506a);
            ieVar.d(context.getPackageName());
            ieVar.a(com.xiaomi.push.service.at.a());
            ieVar.a(false);
            an.a(context).a((an) ieVar, hf.Notification, false, (hs) null, false);
        }
    }

    public static void reportIgnoreRegMessageClicked(Context context, String str, hs hsVar, String str2, String str3) {
        ie ieVar = new ie();
        if (TextUtils.isEmpty(str3)) {
            com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
            return;
        }
        ieVar.b(str3);
        ieVar.c("bar:click");
        ieVar.a(str);
        ieVar.a(false);
        an.a(context).a(ieVar, hf.Notification, false, true, hsVar, true, str2, str3);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        hs hsVar = new hs();
        hsVar.a(miPushMessage.getMessageId());
        hsVar.b(miPushMessage.getTopic());
        hsVar.d(miPushMessage.getDescription());
        hsVar.c(miPushMessage.getTitle());
        hsVar.c(miPushMessage.getNotifyId());
        hsVar.a(miPushMessage.getNotifyType());
        hsVar.b(miPushMessage.getPassThrough());
        hsVar.a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), hsVar, null);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    public static void reportMessageClicked(Context context, String str, hs hsVar, String str2) {
        ie ieVar = new ie();
        if (TextUtils.isEmpty(str2)) {
            if (!b.m99a(context).m106b()) {
                com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
                return;
            }
            str2 = b.m99a(context).m100a();
        }
        ieVar.b(str2);
        ieVar.c("bar:click");
        ieVar.a(str);
        ieVar.a(false);
        an.a(context).a((an) ieVar, hf.Notification, false, hsVar);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    public static void scheduleDataCollectionJobs(Context context) {
        if (com.xiaomi.push.service.aq.a(sContext).a(hk.DataCollectionSwitch.a(), getDefaultSwitch())) {
            dj.a().a(new r(context));
            com.xiaomi.push.ai.a(sContext).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.2
                @Override // java.lang.Runnable
                public void run() {
                    dk.a(MiPushClient.sContext);
                }
            }, 10);
        }
    }

    public static void scheduleOcVersionCheckJob() {
        com.xiaomi.push.ai.a(sContext).a(new ad(sContext), com.xiaomi.push.service.aq.a(sContext).a(hk.OcVersionCheckFrequency.a(), 86400), 5);
    }

    public static void setAcceptTime(Context context, int i2, int i3, int i4, int i5, String str) {
        if (i2 < 0 || i2 >= 24 || i4 < 0 || i4 >= 24 || i3 < 0 || i3 >= 60 || i5 < 0 || i5 >= 60) {
            throw new IllegalArgumentException("the input parameter is not valid.");
        }
        long rawOffset = ((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60;
        long j = ((((i2 * 60) + i3) + rawOffset) + 1440) % 1440;
        long j2 = ((((i4 * 60) + i5) + rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j / 60), Long.valueOf(j % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i2), Integer.valueOf(i3)));
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i4), Integer.valueOf(i5)));
        if (!acceptTimeSet(context, (String) arrayList.get(0), (String) arrayList.get(1))) {
            setCommand(context, ev.COMMAND_SET_ACCEPT_TIME.f337a, arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.a(context, str, ev.COMMAND_SET_ACCEPT_TIME.f337a, 0L, null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ev.COMMAND_SET_ACCEPT_TIME.f337a, arrayList2, 0L, null, null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, ev.COMMAND_SET_ALIAS.f337a, str, str2);
    }

    public static void setCommand(Context context, String str, String str2, String str3) {
        StringBuilder sb;
        String str4;
        ev evVar;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (ev.COMMAND_SET_ALIAS.f337a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) < 86400000) {
            if (1 != PushMessageHelper.getPushMode(context)) {
                evVar = ev.COMMAND_SET_ALIAS;
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(evVar.f337a, arrayList, 0L, null, str3));
                return;
            }
            PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
            return;
        }
        if (ev.COMMAND_UNSET_ALIAS.f337a.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
            sb = new StringBuilder();
            str4 = "Don't cancel alias for ";
        } else if (ev.COMMAND_SET_ACCOUNT.f337a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) < VideoCloudSetting.HOUR_MILLISECOND) {
            if (1 != PushMessageHelper.getPushMode(context)) {
                evVar = ev.COMMAND_SET_ACCOUNT;
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(evVar.f337a, arrayList, 0L, null, str3));
                return;
            }
            PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
            return;
        } else if (!ev.COMMAND_UNSET_ACCOUNT.f337a.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
            setCommand(context, str, arrayList, str3);
            return;
        } else {
            sb = new StringBuilder();
            str4 = "Don't cancel account for ";
        }
        sb.append(str4);
        sb.append(bm.a(arrayList.toString(), 3));
        sb.append(" is unseted");
        com.xiaomi.channel.commonutils.logger.b.m58a(sb.toString());
    }

    public static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (TextUtils.isEmpty(b.m99a(context).m100a())) {
            return;
        }
        hz hzVar = new hz();
        String a2 = com.xiaomi.push.service.at.a();
        hzVar.a(a2);
        hzVar.b(b.m99a(context).m100a());
        hzVar.c(str);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            hzVar.m420a(it.next());
        }
        hzVar.e(str2);
        hzVar.d(context.getPackageName());
        com.xiaomi.channel.commonutils.logger.b.e("cmd:" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + a2);
        an.a(context).a((an) hzVar, hf.Command, (hs) null);
    }

    public static void setLocalNotificationType(Context context, int i2) {
        an.a(context).b(i2 & (-1));
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, ev.COMMAND_SET_ACCOUNT.f337a, str, str2);
    }

    public static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1L)) > 300000;
    }

    public static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) > 5000;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return an.a(context).m92a();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (TextUtils.isEmpty(b.m99a(context).m100a()) || TextUtils.isEmpty(str)) {
            return;
        }
        if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) <= 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0L, null, str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ev.COMMAND_SUBSCRIBE_TOPIC.f337a, arrayList, 0L, null, null));
            return;
        }
        ij ijVar = new ij();
        String a2 = com.xiaomi.push.service.at.a();
        ijVar.a(a2);
        ijVar.b(b.m99a(context).m100a());
        ijVar.c(str);
        ijVar.d(context.getPackageName());
        ijVar.e(str2);
        com.xiaomi.channel.commonutils.logger.b.e("cmd:" + ev.COMMAND_SUBSCRIBE_TOPIC + StringUtil.ARRAY_ELEMENT_SEPARATOR + a2);
        an.a(context).a((an) ijVar, hf.Subscription, (hs) null);
    }

    public static void syncAssembleCOSPushToken(Context context) {
        an.a(context).a((String) null, at.UPLOAD_COS_TOKEN, e.ASSEMBLE_PUSH_COS);
    }

    public static void syncAssembleFCMPushToken(Context context) {
        an.a(context).a((String) null, at.UPLOAD_FCM_TOKEN, e.ASSEMBLE_PUSH_FCM);
    }

    public static void syncAssembleFTOSPushToken(Context context) {
        an.a(context).a((String) null, at.UPLOAD_FTOS_TOKEN, e.ASSEMBLE_PUSH_FTOS);
    }

    public static void syncAssemblePushToken(Context context) {
        an.a(context).a((String) null, at.UPLOAD_HUAWEI_TOKEN, e.ASSEMBLE_PUSH_HUAWEI);
    }

    public static long topicSubscribedTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("topic_" + str, -1L);
    }

    public static void turnOffPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        disablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void turnOnPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        enablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void unRegisterToken(Context context, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        unregisterPush(context);
        if (uPSUnRegisterCallBack != null) {
            TokenResult tokenResult = new TokenResult();
            tokenResult.setToken(null);
            tokenResult.getToken();
            tokenResult.setResultCode(0L);
            tokenResult.getResultCode();
            uPSUnRegisterCallBack.onResult(tokenResult);
        }
    }

    public static void unregisterPush(Context context) {
        i.c(context);
        com.xiaomi.push.service.aq.a(context).a();
        if (b.m99a(context).m106b()) {
            il ilVar = new il();
            ilVar.a(com.xiaomi.push.service.at.a());
            ilVar.b(b.m99a(context).m100a());
            ilVar.c(b.m99a(context).m107c());
            ilVar.e(b.m99a(context).b());
            ilVar.d(context.getPackageName());
            an.a(context).a(ilVar);
            PushMessageHandler.a();
            PushMessageHandler.b();
            b.m99a(context).m105b();
            clearLocalNotificationType(context);
            clearNotification(context);
            clearExtras(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, ev.COMMAND_UNSET_ALIAS.f337a, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, ev.COMMAND_UNSET_ACCOUNT.f337a, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (b.m99a(context).m106b()) {
            if (topicSubscribedTime(context, str) < 0) {
                com.xiaomi.channel.commonutils.logger.b.m58a("Don't cancel subscribe for " + str + " is unsubscribed");
                return;
            }
            in inVar = new in();
            String a2 = com.xiaomi.push.service.at.a();
            inVar.a(a2);
            inVar.b(b.m99a(context).m100a());
            inVar.c(str);
            inVar.d(context.getPackageName());
            inVar.e(str2);
            com.xiaomi.channel.commonutils.logger.b.e("cmd:" + ev.COMMAND_UNSUBSCRIBE_TOPIC + StringUtil.ARRAY_ELEMENT_SEPARATOR + a2);
            an.a(context).a((an) inVar, hf.UnSubscription, (hs) null);
        }
    }

    public static void updateImeiOrOaid() {
        new Thread(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.3
            @Override // java.lang.Runnable
            public void run() {
                String f2;
                if (com.xiaomi.push.l.d()) {
                    return;
                }
                if (com.xiaomi.push.i.f(MiPushClient.sContext) != null || ax.a(MiPushClient.sContext).a()) {
                    ie ieVar = new ie();
                    ieVar.b(b.m99a(MiPushClient.sContext).m100a());
                    ieVar.c(hp.ClientInfoUpdate.f506a);
                    ieVar.a(com.xiaomi.push.service.at.a());
                    ieVar.a(new HashMap());
                    String str = "";
                    if (!TextUtils.isEmpty(com.xiaomi.push.i.f(MiPushClient.sContext))) {
                        str = "" + bm.a(f2);
                    }
                    String h2 = com.xiaomi.push.i.h(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(h2)) {
                        str = str + "," + h2;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        ieVar.m454a().put(Constants.EXTRA_KEY_IMEI_MD5, str);
                    }
                    ax.a(MiPushClient.sContext).a(ieVar.m454a());
                    com.xiaomi.push.i.a(MiPushClient.sContext, ieVar.f647a);
                    int a2 = com.xiaomi.push.i.a();
                    if (a2 >= 0) {
                        ieVar.m454a().put("space_id", Integer.toString(a2));
                    }
                    an.a(MiPushClient.sContext).a((an) ieVar, hf.Notification, false, (hs) null);
                }
            }
        }).start();
    }
}
