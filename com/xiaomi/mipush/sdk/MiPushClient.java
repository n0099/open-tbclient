package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.coloros.mcssdk.mode.Message;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes3.dex */
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
    private static bh mSyncMIIDHelper;
    private static Context sContext;
    private static boolean isCrashHandlerSuggested = false;
    private static long sCurMsgId = System.currentTimeMillis();

    @Deprecated
    /* loaded from: classes3.dex */
    public static abstract class MiPushClientCallback {
        private String category;

        /* JADX INFO: Access modifiers changed from: protected */
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

        protected void setCategory(String str) {
            this.category = str;
        }
    }

    private static boolean acceptTimeSet(Context context, String str, String str2) {
        return TextUtils.equals(getAcceptTime(context), str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
    }

    public static long accountSetTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("account_" + str, -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void addAcceptTime(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(Constants.EXTRA_KEY_ACCEPT_TIME, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
            com.xiaomi.channel.commonutils.android.l.a(edit);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void addAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("account_" + str, System.currentTimeMillis()).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void addAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("alias_" + str, System.currentTimeMillis()).commit();
        }
    }

    private static void addPullNotificationTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_pull_notification", System.currentTimeMillis());
        com.xiaomi.channel.commonutils.android.l.a(edit);
    }

    private static void addRegRequestTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        com.xiaomi.channel.commonutils.android.l.a(edit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void addTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("topic_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static long aliasSetTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("alias_" + str, -1L);
    }

    public static void awakeApps(Context context, String[] strArr) {
        com.xiaomi.channel.commonutils.misc.h.a(context).a(new aj(strArr, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
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
                    } catch (Throwable th) {
                        return;
                    }
                }
            }
        }
    }

    private static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("param " + str + " is not nullable");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkPermission(Context context) {
        if (context != null) {
            if (com.xiaomi.channel.commonutils.android.f.a() || "com.xiaomi.xmsf".equals(context.getPackageName())) {
                return true;
            }
            if (context.getApplicationInfo().targetSdkVersion < 23 || Build.VERSION.SDK_INT < 23) {
                return (TextUtils.isEmpty(com.xiaomi.channel.commonutils.android.d.e(context)) && TextUtils.isEmpty(com.xiaomi.channel.commonutils.android.d.a())) ? false : true;
            }
            return com.xiaomi.channel.commonutils.android.g.a(context, "android.permission.READ_PHONE_STATE") || com.xiaomi.channel.commonutils.android.g.a(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void clearExtras(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        az.a(context).f();
    }

    public static void clearNotification(Context context) {
        az.a(context).a(-1);
    }

    public static void clearNotification(Context context, int i) {
        az.a(context).a(i);
    }

    public static void clearNotification(Context context, String str, String str2) {
        az.a(context).a(str, str2);
    }

    public static void disablePush(Context context) {
        az.a(context).a(true);
    }

    private static void enableGeo(Context context, boolean z) {
        if (Math.abs(System.currentTimeMillis() - getGeoEnableTime(context, String.valueOf(z))) > 60000) {
            com.xiaomi.push.service.j.a(context, z);
            w.a(context, z);
            setGeoEnableTime(context, String.valueOf(z));
        }
    }

    public static void enablePush(Context context) {
        az.a(context).a(false);
    }

    private static void forceHandleCrash() {
        boolean a = com.xiaomi.push.service.an.a(sContext).a(com.xiaomi.xmpush.thrift.g.ForceHandleCrashSwitch.a(), false);
        if (isCrashHandlerSuggested || !a) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new z(sContext));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getAcceptTime(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString(Constants.EXTRA_KEY_ACCEPT_TIME, "00:00-23:59");
    }

    public static List<String> getAllAlias(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring("alias_".length()));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring("topic_".length()));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring("account_".length()));
            }
        }
        return arrayList;
    }

    public static String getAppRegion(Context context) {
        if (d.a(context).j()) {
            return d.a(context).h();
        }
        return null;
    }

    private static boolean getDefaultSwitch() {
        return com.xiaomi.channel.commonutils.android.f.b();
    }

    private static long getGeoEnableTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("geo_" + str, -1L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenFCMPush() {
        return g.a(sContext).d(f.ASSEMBLE_PUSH_FCM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenHmsPush() {
        return g.a(sContext).d(f.ASSEMBLE_PUSH_HUAWEI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenOPPOPush() {
        return g.a(sContext).d(f.ASSEMBLE_PUSH_COS);
    }

    public static String getRegId(Context context) {
        if (d.a(context).j()) {
            return d.a(context).e();
        }
        return null;
    }

    private static void initEventPerfLogic(Context context) {
        com.xiaomi.push.service.clientReport.c.a(new ak());
        Config c = com.xiaomi.push.service.clientReport.c.c(context);
        ClientReportClient.init(context, c, new com.xiaomi.push.service.clientReport.a(context), new com.xiaomi.push.service.clientReport.b(context));
        a.a(context);
        r.a(context, c);
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        checkNotNull(context, "context");
        checkNotNull(str, Message.APP_ID);
        checkNotNull(str2, "appToken");
        try {
            sContext = context.getApplicationContext();
            if (sContext == null) {
                sContext = context;
            }
            if (miPushClientCallback != null) {
                PushMessageHandler.a(miPushClientCallback);
            }
            if (com.xiaomi.channel.commonutils.android.n.b(context)) {
                ab.a(context);
            }
            boolean z = d.a(sContext).m() != Constants.a();
            if (!z && !shouldSendRegRequest(sContext)) {
                az.a(context).a();
                com.xiaomi.channel.commonutils.logger.b.a("Could not send  register message within 5s repeatly .");
                return;
            }
            if (z || !d.a(sContext).a(str, str2) || d.a(sContext).n()) {
                String a = com.xiaomi.channel.commonutils.string.d.a(6);
                d.a(sContext).i();
                d.a(sContext).a(Constants.a());
                d.a(sContext).a(str, str2, a);
                MiTinyDataClient.a.a().b(MiTinyDataClient.PENDING_REASON_APPID);
                clearExtras(sContext);
                com.xiaomi.xmpush.thrift.aj ajVar = new com.xiaomi.xmpush.thrift.aj();
                ajVar.a(com.xiaomi.push.service.aq.a());
                ajVar.b(str);
                ajVar.e(str2);
                ajVar.d(context.getPackageName());
                ajVar.f(a);
                ajVar.c(com.xiaomi.channel.commonutils.android.a.a(context, context.getPackageName()));
                ajVar.b(com.xiaomi.channel.commonutils.android.a.b(context, context.getPackageName()));
                ajVar.g("3_6_9");
                ajVar.a(30609);
                ajVar.h(com.xiaomi.channel.commonutils.android.d.d(sContext));
                ajVar.a(com.xiaomi.xmpush.thrift.w.Init);
                if (!com.xiaomi.channel.commonutils.android.f.g()) {
                    String f = com.xiaomi.channel.commonutils.android.d.f(sContext);
                    String h = com.xiaomi.channel.commonutils.android.d.h(sContext);
                    if (!TextUtils.isEmpty(f)) {
                        if (com.xiaomi.channel.commonutils.android.f.b()) {
                            if (!TextUtils.isEmpty(h)) {
                                f = f + Constants.ACCEPT_TIME_SEPARATOR_SP + h;
                            }
                            ajVar.i(f);
                        }
                        ajVar.k(com.xiaomi.channel.commonutils.string.d.a(f) + Constants.ACCEPT_TIME_SEPARATOR_SP + com.xiaomi.channel.commonutils.android.d.i(sContext));
                    }
                }
                ajVar.j(com.xiaomi.channel.commonutils.android.d.a());
                int b = com.xiaomi.channel.commonutils.android.d.b();
                if (b >= 0) {
                    ajVar.c(b);
                }
                az.a(sContext).a(ajVar, z);
                b.a(context);
                context.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
            } else {
                if (1 == PushMessageHelper.getPushMode(context)) {
                    checkNotNull(miPushClientCallback, "callback");
                    miPushClientCallback.onInitializeResult(0L, null, d.a(context).e());
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(d.a(context).e());
                    PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(com.xiaomi.push.service.xmpush.a.COMMAND_REGISTER.k, arrayList, 0L, null, null));
                }
                az.a(context).a();
                if (d.a(sContext).a()) {
                    com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai();
                    aiVar.b(d.a(context).c());
                    aiVar.c("client_info_update");
                    aiVar.a(com.xiaomi.push.service.aq.a());
                    aiVar.h = new HashMap();
                    aiVar.h.put(Constants.EXTRA_KEY_APP_VERSION, com.xiaomi.channel.commonutils.android.a.a(sContext, sContext.getPackageName()));
                    aiVar.h.put(Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.channel.commonutils.android.a.b(sContext, sContext.getPackageName())));
                    aiVar.h.put("push_sdk_vn", "3_6_9");
                    aiVar.h.put("push_sdk_vc", Integer.toString(30609));
                    String g = d.a(sContext).g();
                    if (!TextUtils.isEmpty(g)) {
                        aiVar.h.put("deviceid", g);
                    }
                    az.a(context).a((az) aiVar, com.xiaomi.xmpush.thrift.a.Notification, false, (com.xiaomi.xmpush.thrift.u) null);
                    b.a(context);
                }
                if (!com.xiaomi.channel.commonutils.android.h.a(sContext, "update_devId", false)) {
                    updateIMEI();
                    com.xiaomi.channel.commonutils.android.h.b(sContext, "update_devId", true);
                }
                String c = com.xiaomi.channel.commonutils.android.d.c(context);
                if (!TextUtils.isEmpty(c)) {
                    com.xiaomi.xmpush.thrift.ad adVar = new com.xiaomi.xmpush.thrift.ad();
                    adVar.a(com.xiaomi.push.service.aq.a());
                    adVar.b(str);
                    adVar.c(com.xiaomi.push.service.xmpush.a.COMMAND_CHK_VDEVID.k);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(com.xiaomi.channel.commonutils.android.d.b(context));
                    arrayList2.add(c);
                    arrayList2.add(Build.MODEL != null ? Build.MODEL : "");
                    arrayList2.add(Build.BOARD != null ? Build.BOARD : "");
                    adVar.a(arrayList2);
                    az.a(context).a((az) adVar, com.xiaomi.xmpush.thrift.a.Command, false, (com.xiaomi.xmpush.thrift.u) null);
                }
                if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                    com.xiaomi.xmpush.thrift.ai aiVar2 = new com.xiaomi.xmpush.thrift.ai();
                    aiVar2.b(d.a(sContext).c());
                    aiVar2.c(com.xiaomi.xmpush.thrift.r.PullOfflineMessage.aa);
                    aiVar2.a(com.xiaomi.push.service.aq.a());
                    aiVar2.a(false);
                    az.a(sContext).a((az) aiVar2, com.xiaomi.xmpush.thrift.a.Notification, false, (com.xiaomi.xmpush.thrift.u) null, false);
                    addPullNotificationTime(sContext);
                }
            }
            addRegRequestTime(sContext);
            scheduleOcVersionCheckJob();
            scheduleGeoFenceLocUploadJobs();
            scheduleDataCollectionJobs(context);
            initEventPerfLogic(context);
            bf.a(sContext);
            forceHandleCrash();
            if (!sContext.getPackageName().equals("com.xiaomi.xmsf")) {
                Logger.setLogger(sContext, Logger.getUserLogger());
                com.xiaomi.channel.commonutils.logger.b.a(2);
            }
            try {
                if (mSyncMIIDHelper == null) {
                    mSyncMIIDHelper = new bh(sContext);
                }
                mSyncMIIDHelper.a(sContext);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            }
            if ("syncing".equals(ap.a(sContext).a(be.DISABLE_PUSH))) {
                disablePush(sContext);
            }
            if ("syncing".equals(ap.a(sContext).a(be.ENABLE_PUSH))) {
                enablePush(sContext);
            }
            if ("syncing".equals(ap.a(sContext).a(be.UPLOAD_HUAWEI_TOKEN))) {
                syncAssemblePushToken(sContext);
            }
            if ("syncing".equals(ap.a(sContext).a(be.UPLOAD_FCM_TOKEN))) {
                syncAssembleFCMPushToken(sContext);
            }
            if ("syncing".equals(ap.a(context).a(be.UPLOAD_COS_TOKEN))) {
                syncAssembleCOSPushToken(context);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reInitialize(Context context, com.xiaomi.xmpush.thrift.w wVar) {
        if (d.a(context).j()) {
            String a = com.xiaomi.channel.commonutils.string.d.a(6);
            String c = d.a(context).c();
            String d = d.a(context).d();
            d.a(context).i();
            d.a(context).a(Constants.a());
            d.a(context).a(c, d, a);
            com.xiaomi.xmpush.thrift.aj ajVar = new com.xiaomi.xmpush.thrift.aj();
            ajVar.a(com.xiaomi.push.service.aq.a());
            ajVar.b(c);
            ajVar.e(d);
            ajVar.f(a);
            ajVar.d(context.getPackageName());
            ajVar.c(com.xiaomi.channel.commonutils.android.a.a(context, context.getPackageName()));
            ajVar.a(wVar);
            az.a(context).a(ajVar, false);
        }
    }

    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(new z(sContext, uncaughtExceptionHandler));
        isCrashHandlerSuggested = true;
    }

    private static void registerNetworkReceiver(Context context) {
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
        if (!NetworkStatusReceiver.a()) {
            registerNetworkReceiver(context);
        }
        g.a(context).a(pushConfiguration);
        enableGeo(context, pushConfiguration.getGeoEnable());
        b.a();
        com.xiaomi.channel.commonutils.misc.h.a(context).a(new ag(context, str, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAcceptTime(Context context) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
            com.xiaomi.channel.commonutils.android.l.a(edit);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("account_" + str).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("alias_" + str).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAllAccounts(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllUserAccount(context)) {
                removeAccount(context, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAllAliases(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllAlias(context)) {
                removeAlias(context, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAllTopics(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllTopic(context)) {
                removeTopic(context, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("topic_" + str).commit();
        }
    }

    public static void reportAppRunInBackground(Context context, boolean z) {
        if (d.a(context).b()) {
            com.xiaomi.xmpush.thrift.r rVar = z ? com.xiaomi.xmpush.thrift.r.APP_SLEEP : com.xiaomi.xmpush.thrift.r.APP_WAKEUP;
            com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai();
            aiVar.b(d.a(context).c());
            aiVar.c(rVar.aa);
            aiVar.d(context.getPackageName());
            aiVar.a(com.xiaomi.push.service.aq.a());
            aiVar.a(false);
            az.a(context).a((az) aiVar, com.xiaomi.xmpush.thrift.a.Notification, false, (com.xiaomi.xmpush.thrift.u) null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportIgnoreRegMessageClicked(Context context, String str, com.xiaomi.xmpush.thrift.u uVar, String str2, String str3) {
        com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai();
        if (TextUtils.isEmpty(str3)) {
            com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
            return;
        }
        aiVar.b(str3);
        aiVar.c("bar:click");
        aiVar.a(str);
        aiVar.a(false);
        az.a(context).a(aiVar, com.xiaomi.xmpush.thrift.a.Notification, false, true, uVar, true, str2, str3);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        com.xiaomi.xmpush.thrift.u uVar = new com.xiaomi.xmpush.thrift.u();
        uVar.a(miPushMessage.getMessageId());
        uVar.b(miPushMessage.getTopic());
        uVar.d(miPushMessage.getDescription());
        uVar.c(miPushMessage.getTitle());
        uVar.c(miPushMessage.getNotifyId());
        uVar.a(miPushMessage.getNotifyType());
        uVar.b(miPushMessage.getPassThrough());
        uVar.a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), uVar, null);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportMessageClicked(Context context, String str, com.xiaomi.xmpush.thrift.u uVar, String str2) {
        com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai();
        if (!TextUtils.isEmpty(str2)) {
            aiVar.b(str2);
        } else if (!d.a(context).b()) {
            com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
            return;
        } else {
            aiVar.b(d.a(context).c());
        }
        aiVar.c("bar:click");
        aiVar.a(str);
        aiVar.a(false);
        az.a(context).a((az) aiVar, com.xiaomi.xmpush.thrift.a.Notification, false, uVar);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    private static void scheduleDataCollectionJobs(Context context) {
        if (com.xiaomi.push.service.an.a(sContext).a(com.xiaomi.xmpush.thrift.g.DataCollectionSwitch.a(), getDefaultSwitch())) {
            com.xiaomi.push.mpcd.c.a().a(new q(context));
            com.xiaomi.channel.commonutils.misc.h.a(sContext).a(new ah(), 10);
        }
    }

    private static void scheduleGeoFenceLocUploadJobs() {
        if (com.xiaomi.push.service.j.e(sContext) && !TextUtils.equals("com.xiaomi.xmsf", sContext.getPackageName()) && com.xiaomi.push.service.an.a(sContext).a(com.xiaomi.xmpush.thrift.g.UploadGeoAppLocSwitch.a(), true) && !com.xiaomi.channel.commonutils.android.n.d()) {
            u.a(sContext, true);
            int max = Math.max(60, com.xiaomi.push.service.an.a(sContext).a(com.xiaomi.xmpush.thrift.g.UploadWIFIGeoLocFrequency.a(), 900));
            com.xiaomi.channel.commonutils.misc.h.a(sContext).a(new u(sContext, max), max, max);
        }
    }

    private static void scheduleOcVersionCheckJob() {
        com.xiaomi.channel.commonutils.misc.h.a(sContext).a(new ao(sContext), com.xiaomi.push.service.an.a(sContext).a(com.xiaomi.xmpush.thrift.g.OcVersionCheckFrequency.a(), 86400), 5);
    }

    public static void setAcceptTime(Context context, int i, int i2, int i3, int i4, String str) {
        if (i < 0 || i >= 24 || i3 < 0 || i3 >= 24 || i2 < 0 || i2 >= 60 || i4 < 0 || i4 >= 60) {
            throw new IllegalArgumentException("the input parameter is not valid.");
        }
        long rawOffset = ((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60;
        long j = ((((i * 60) + i2) + rawOffset) + 1440) % 1440;
        long j2 = ((rawOffset + ((i3 * 60) + i4)) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j / 60), Long.valueOf(j % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i), Integer.valueOf(i2)));
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i3), Integer.valueOf(i4)));
        if (!acceptTimeSet(context, (String) arrayList.get(0), (String) arrayList.get(1))) {
            setCommand(context, com.xiaomi.push.service.xmpush.a.COMMAND_SET_ACCEPT_TIME.k, arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.a(context, str, com.xiaomi.push.service.xmpush.a.COMMAND_SET_ACCEPT_TIME.k, 0L, null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(com.xiaomi.push.service.xmpush.a.COMMAND_SET_ACCEPT_TIME.k, arrayList2, 0L, null, null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, com.xiaomi.push.service.xmpush.a.COMMAND_SET_ALIAS.k, str, str2);
    }

    protected static void setCommand(Context context, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (com.xiaomi.push.service.xmpush.a.COMMAND_SET_ALIAS.k.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) < 3600000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(com.xiaomi.push.service.xmpush.a.COMMAND_SET_ALIAS.k, arrayList, 0L, null, str3));
            }
        } else if (com.xiaomi.push.service.xmpush.a.COMMAND_UNSET_ALIAS.k.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
            com.xiaomi.channel.commonutils.logger.b.a("Don't cancel alias for " + com.xiaomi.channel.commonutils.string.d.a(arrayList.toString(), 3) + " is unseted");
        } else if (com.xiaomi.push.service.xmpush.a.COMMAND_SET_ACCOUNT.k.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) < 3600000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(com.xiaomi.push.service.xmpush.a.COMMAND_SET_ACCOUNT.k, arrayList, 0L, null, str3));
            }
        } else if (!com.xiaomi.push.service.xmpush.a.COMMAND_UNSET_ACCOUNT.k.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
            setCommand(context, str, arrayList, str3);
        } else {
            com.xiaomi.channel.commonutils.logger.b.a("Don't cancel account for " + com.xiaomi.channel.commonutils.string.d.a(arrayList.toString(), 3) + " is unseted");
        }
    }

    protected static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (TextUtils.isEmpty(d.a(context).c())) {
            return;
        }
        com.xiaomi.xmpush.thrift.ad adVar = new com.xiaomi.xmpush.thrift.ad();
        adVar.a(com.xiaomi.push.service.aq.a());
        adVar.b(d.a(context).c());
        adVar.c(str);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            adVar.d(it.next());
        }
        adVar.f(str2);
        adVar.e(context.getPackageName());
        az.a(context).a((az) adVar, com.xiaomi.xmpush.thrift.a.Command, (com.xiaomi.xmpush.thrift.u) null);
    }

    static synchronized void setGeoEnableTime(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("geo_" + str, System.currentTimeMillis());
            com.xiaomi.channel.commonutils.android.l.a(edit);
        }
    }

    public static void setLocalNotificationType(Context context, int i) {
        az.a(context).b(i & (-1));
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, com.xiaomi.push.service.xmpush.a.COMMAND_SET_ACCOUNT.k, str, str2);
    }

    private static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1L)) > ReportUserInfoModel.TIME_INTERVAL;
    }

    private static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) > 5000;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return az.a(context).c();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (TextUtils.isEmpty(d.a(context).c()) || TextUtils.isEmpty(str)) {
            return;
        }
        if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) <= 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0L, null, str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(com.xiaomi.push.service.xmpush.a.COMMAND_SUBSCRIBE_TOPIC.k, arrayList, 0L, null, null));
            return;
        }
        com.xiaomi.xmpush.thrift.an anVar = new com.xiaomi.xmpush.thrift.an();
        anVar.a(com.xiaomi.push.service.aq.a());
        anVar.b(d.a(context).c());
        anVar.c(str);
        anVar.d(context.getPackageName());
        anVar.e(str2);
        az.a(context).a((az) anVar, com.xiaomi.xmpush.thrift.a.Subscription, (com.xiaomi.xmpush.thrift.u) null);
    }

    public static void syncAssembleCOSPushToken(Context context) {
        az.a(context).a((String) null, be.UPLOAD_COS_TOKEN, f.ASSEMBLE_PUSH_COS);
    }

    public static void syncAssembleFCMPushToken(Context context) {
        az.a(context).a((String) null, be.UPLOAD_FCM_TOKEN, f.ASSEMBLE_PUSH_FCM);
    }

    public static void syncAssemblePushToken(Context context) {
        az.a(context).a((String) null, be.UPLOAD_HUAWEI_TOKEN, f.ASSEMBLE_PUSH_HUAWEI);
    }

    public static long topicSubscribedTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("topic_" + str, -1L);
    }

    public static void unregisterPush(Context context) {
        i.d(context);
        if (d.a(context).b()) {
            com.xiaomi.xmpush.thrift.ap apVar = new com.xiaomi.xmpush.thrift.ap();
            apVar.a(com.xiaomi.push.service.aq.a());
            apVar.b(d.a(context).c());
            apVar.c(d.a(context).e());
            apVar.e(d.a(context).d());
            apVar.d(context.getPackageName());
            az.a(context).a(apVar);
            PushMessageHandler.a();
            d.a(context).k();
            clearLocalNotificationType(context);
            clearNotification(context);
            if (mSyncMIIDHelper != null) {
                com.xiaomi.push.service.o.a(context).b(mSyncMIIDHelper);
            }
            clearExtras(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, com.xiaomi.push.service.xmpush.a.COMMAND_UNSET_ALIAS.k, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, com.xiaomi.push.service.xmpush.a.COMMAND_UNSET_ACCOUNT.k, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (d.a(context).b()) {
            if (topicSubscribedTime(context, str) < 0) {
                com.xiaomi.channel.commonutils.logger.b.a("Don't cancel subscribe for " + str + " is unsubscribed");
                return;
            }
            com.xiaomi.xmpush.thrift.ar arVar = new com.xiaomi.xmpush.thrift.ar();
            arVar.a(com.xiaomi.push.service.aq.a());
            arVar.b(d.a(context).c());
            arVar.c(str);
            arVar.d(context.getPackageName());
            arVar.e(str2);
            az.a(context).a((az) arVar, com.xiaomi.xmpush.thrift.a.UnSubscription, (com.xiaomi.xmpush.thrift.u) null);
        }
    }

    private static void updateIMEI() {
        new Thread(new ai()).start();
    }
}
