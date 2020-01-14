package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.coloros.mcssdk.mode.Message;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.Cif;
import com.xiaomi.push.dl;
import com.xiaomi.push.es;
import com.xiaomi.push.et;
import com.xiaomi.push.eu;
import com.xiaomi.push.fa;
import com.xiaomi.push.hg;
import com.xiaomi.push.hl;
import com.xiaomi.push.hq;
import com.xiaomi.push.ht;
import com.xiaomi.push.hu;
import com.xiaomi.push.ia;
import com.xiaomi.push.ig;
import com.xiaomi.push.ik;
import com.xiaomi.push.im;
import com.xiaomi.push.io;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes6.dex */
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
    private static Context sContext;
    private static boolean isCrashHandlerSuggested = false;
    private static long sCurMsgId = System.currentTimeMillis();

    @Deprecated
    /* loaded from: classes6.dex */
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
            com.xiaomi.push.r.a(edit);
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
        com.xiaomi.push.r.a(edit);
    }

    private static void addRegRequestTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        com.xiaomi.push.r.a(edit);
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
        com.xiaomi.push.ai.a(context).a(new ah(strArr, context));
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

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a5, code lost:
        if (com.xiaomi.push.m.a(r5, "android.permission.WRITE_EXTERNAL_STORAGE") == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bc, code lost:
        if (android.text.TextUtils.isEmpty(r3) != false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean checkPermission(Context context) {
        boolean z = true;
        if (context != null) {
            if (!com.xiaomi.push.l.m478a() && !"com.xiaomi.xmsf".equals(context.getPackageName()) && TextUtils.isEmpty(com.xiaomi.push.i.b(context))) {
                if (context.getApplicationInfo().targetSdkVersion < 23 || Build.VERSION.SDK_INT < 23) {
                    String f = com.xiaomi.push.i.f(context);
                    String m384a = com.xiaomi.push.i.m384a();
                    if (TextUtils.isEmpty(f)) {
                    }
                } else if (!com.xiaomi.push.m.a(context, "android.permission.READ_PHONE_STATE")) {
                }
            }
            if (!z) {
                com.xiaomi.channel.commonutils.logger.b.d("Because of lack of necessary information, mi push can't be initialized");
                ArrayList arrayList = new ArrayList();
                if (!com.xiaomi.push.m.a(context, "android.permission.READ_PHONE_STATE")) {
                    arrayList.add("android.permission.READ_PHONE_STATE");
                }
                if (!com.xiaomi.push.m.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
                if (!arrayList.isEmpty()) {
                    String[] strArr = new String[arrayList.size()];
                    arrayList.toArray(strArr);
                    Intent intent = new Intent();
                    intent.setAction("com.xiaomi.mipush.ERROR");
                    intent.setPackage(context.getPackageName());
                    intent.putExtra(PushMessageHelper.MESSAGE_TYPE, 5);
                    intent.putExtra(PushMessageHelper.ERROR_TYPE, PushMessageHelper.ERROR_TYPE_NEED_PERMISSION);
                    intent.putExtra("error_message", strArr);
                    context.sendBroadcast(intent);
                }
            }
            return z;
        }
        z = false;
        if (!z) {
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void clearExtras(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        ay.a(context).m77e();
    }

    public static void clearNotification(Context context) {
        ay.a(context).a(-1);
    }

    public static void clearNotification(Context context, int i) {
        ay.a(context).a(i);
    }

    public static void clearNotification(Context context, String str, String str2) {
        ay.a(context).a(str, str2);
    }

    public static void disablePush(Context context) {
        ay.a(context).a(true);
    }

    public static void enablePush(Context context) {
        ay.a(context).a(false);
    }

    private static void forceHandleCrash() {
        boolean a = com.xiaomi.push.service.ag.a(sContext).a(hl.ForceHandleCrashSwitch.a(), false);
        if (isCrashHandlerSuggested || !a) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new x(sContext));
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
        if (d.m80a(context).m89c()) {
            return d.m80a(context).f();
        }
        return null;
    }

    private static boolean getDefaultSwitch() {
        return com.xiaomi.push.l.m479b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenFCMPush(Context context) {
        checkNotNull(context, "context");
        return g.a(context).b(f.ASSEMBLE_PUSH_FCM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenHmsPush(Context context) {
        checkNotNull(context, "context");
        return g.a(context).b(f.ASSEMBLE_PUSH_HUAWEI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenOPPOPush(Context context) {
        checkNotNull(context, "context");
        return g.a(context).b(f.ASSEMBLE_PUSH_COS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenVIVOPush(Context context) {
        return g.a(context).b(f.ASSEMBLE_PUSH_FTOS);
    }

    public static String getRegId(Context context) {
        if (d.m80a(context).m89c()) {
            return d.m80a(context).m88c();
        }
        return null;
    }

    private static void initEventPerfLogic(Context context) {
        eu.a(new ai());
        Config a = eu.a(context);
        ClientReportClient.init(context, a, new es(context), new et(context));
        a.a(context);
        t.a(context, a);
        com.xiaomi.push.service.ag.a(context).a(new aj(100, "perf event job update", context));
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        try {
            com.xiaomi.channel.commonutils.logger.b.m42a("sdk_version = 3_6_19");
            if (miPushClientCallback != null) {
                PushMessageHandler.a(miPushClientCallback);
            }
            if (com.xiaomi.push.t.m560a(sContext)) {
                z.a(sContext);
            }
            if (d.m80a(sContext).a(str, str2) || checkPermission(sContext)) {
                boolean z = d.m80a(sContext).a() != Constants.a();
                if (!z && !shouldSendRegRequest(sContext)) {
                    ay.a(sContext).m69a();
                    com.xiaomi.channel.commonutils.logger.b.m42a("Could not send  register message within 5s repeatly .");
                    return;
                }
                if (z || !d.m80a(sContext).a(str, str2) || d.m80a(sContext).m91e()) {
                    String a = com.xiaomi.push.ay.a(6);
                    d.m80a(sContext).m82a();
                    d.m80a(sContext).a(Constants.a());
                    d.m80a(sContext).a(str, str2, a);
                    MiTinyDataClient.a.a().b(MiTinyDataClient.PENDING_REASON_APPID);
                    clearExtras(sContext);
                    ig igVar = new ig();
                    igVar.a(com.xiaomi.push.service.aj.a());
                    igVar.b(str);
                    igVar.e(str2);
                    igVar.d(sContext.getPackageName());
                    igVar.f(a);
                    igVar.c(com.xiaomi.push.g.m291a(sContext, sContext.getPackageName()));
                    igVar.b(com.xiaomi.push.g.a(sContext, sContext.getPackageName()));
                    igVar.g("3_6_19");
                    igVar.a(30619);
                    igVar.h(com.xiaomi.push.i.e(sContext));
                    igVar.a(hu.Init);
                    if (!com.xiaomi.push.l.d()) {
                        String g = com.xiaomi.push.i.g(sContext);
                        String i = com.xiaomi.push.i.i(sContext);
                        if (!TextUtils.isEmpty(g)) {
                            if (com.xiaomi.push.l.m479b()) {
                                if (!TextUtils.isEmpty(i)) {
                                    g = g + Constants.ACCEPT_TIME_SEPARATOR_SP + i;
                                }
                                igVar.i(g);
                            }
                            igVar.k(com.xiaomi.push.ay.a(g) + Constants.ACCEPT_TIME_SEPARATOR_SP + com.xiaomi.push.i.j(sContext));
                        }
                    }
                    igVar.j(com.xiaomi.push.i.m384a());
                    int a2 = com.xiaomi.push.i.a();
                    if (a2 >= 0) {
                        igVar.c(a2);
                    }
                    ay.a(sContext).a(igVar, z);
                    b.a(sContext);
                    sContext.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
                } else {
                    if (1 == PushMessageHelper.getPushMode(sContext)) {
                        checkNotNull(miPushClientCallback, BuyTBeanActivityConfig.CALLBACK);
                        miPushClientCallback.onInitializeResult(0L, null, d.m80a(sContext).m88c());
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(d.m80a(sContext).m88c());
                        PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(fa.COMMAND_REGISTER.f336a, arrayList, 0L, null, null));
                    }
                    ay.a(sContext).m69a();
                    if (d.m80a(sContext).m84a()) {
                        Cif cif = new Cif();
                        cif.b(d.m80a(sContext).m81a());
                        cif.c("client_info_update");
                        cif.a(com.xiaomi.push.service.aj.a());
                        cif.f633a = new HashMap();
                        cif.f633a.put("app_version", com.xiaomi.push.g.m291a(sContext, sContext.getPackageName()));
                        cif.f633a.put(Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.g.a(sContext, sContext.getPackageName())));
                        cif.f633a.put("push_sdk_vn", "3_6_19");
                        cif.f633a.put("push_sdk_vc", Integer.toString(30619));
                        String e = d.m80a(sContext).e();
                        if (!TextUtils.isEmpty(e)) {
                            cif.f633a.put("deviceid", e);
                        }
                        ay.a(sContext).a((ay) cif, hg.Notification, false, (ht) null);
                        b.a(sContext);
                    }
                    if (!com.xiaomi.push.n.m480a(sContext, "update_devId", false)) {
                        updateIMEI();
                        com.xiaomi.push.n.a(sContext, "update_devId", true);
                    }
                    String d = com.xiaomi.push.i.d(sContext);
                    if (!TextUtils.isEmpty(d)) {
                        ia iaVar = new ia();
                        iaVar.a(com.xiaomi.push.service.aj.a());
                        iaVar.b(str);
                        iaVar.c(fa.COMMAND_CHK_VDEVID.f336a);
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(com.xiaomi.push.i.c(sContext));
                        arrayList2.add(d);
                        arrayList2.add(Build.MODEL != null ? Build.MODEL : "");
                        arrayList2.add(Build.BOARD != null ? Build.BOARD : "");
                        iaVar.a(arrayList2);
                        ay.a(sContext).a((ay) iaVar, hg.Command, false, (ht) null);
                    }
                    if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                        Cif cif2 = new Cif();
                        cif2.b(d.m80a(sContext).m81a());
                        cif2.c(hq.PullOfflineMessage.f493a);
                        cif2.a(com.xiaomi.push.service.aj.a());
                        cif2.a(false);
                        ay.a(sContext).a((ay) cif2, hg.Notification, false, (ht) null, false);
                        addPullNotificationTime(sContext);
                    }
                }
                addRegRequestTime(sContext);
                scheduleOcVersionCheckJob();
                scheduleDataCollectionJobs(sContext);
                initEventPerfLogic(sContext);
                be.a(sContext);
                forceHandleCrash();
                if (!sContext.getPackageName().equals("com.xiaomi.xmsf")) {
                    if (Logger.getUserLogger() != null) {
                        Logger.setLogger(sContext, Logger.getUserLogger());
                    }
                    com.xiaomi.channel.commonutils.logger.b.a(2);
                }
                operateSyncAction(context);
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    private static void operateSyncAction(Context context) {
        if ("syncing".equals(ao.a(sContext).a(bd.DISABLE_PUSH))) {
            disablePush(sContext);
        }
        if ("syncing".equals(ao.a(sContext).a(bd.ENABLE_PUSH))) {
            enablePush(sContext);
        }
        if ("syncing".equals(ao.a(sContext).a(bd.UPLOAD_HUAWEI_TOKEN))) {
            syncAssemblePushToken(sContext);
        }
        if ("syncing".equals(ao.a(sContext).a(bd.UPLOAD_FCM_TOKEN))) {
            syncAssembleFCMPushToken(sContext);
        }
        if ("syncing".equals(ao.a(sContext).a(bd.UPLOAD_COS_TOKEN))) {
            syncAssembleCOSPushToken(context);
        }
        if ("syncing".equals(ao.a(sContext).a(bd.UPLOAD_FTOS_TOKEN))) {
            syncAssembleFTOSPushToken(context);
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reInitialize(Context context, hu huVar) {
        if (d.m80a(context).m89c()) {
            String a = com.xiaomi.push.ay.a(6);
            String m81a = d.m80a(context).m81a();
            String b = d.m80a(context).b();
            d.m80a(context).m82a();
            d.m80a(context).a(Constants.a());
            d.m80a(context).a(m81a, b, a);
            ig igVar = new ig();
            igVar.a(com.xiaomi.push.service.aj.a());
            igVar.b(m81a);
            igVar.e(b);
            igVar.f(a);
            igVar.d(context.getPackageName());
            igVar.c(com.xiaomi.push.g.m291a(context, context.getPackageName()));
            igVar.a(huVar);
            ay.a(context).a(igVar, false);
        }
    }

    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(new x(sContext, uncaughtExceptionHandler));
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
        checkNotNull(context, "context");
        checkNotNull(str, Message.APP_ID);
        checkNotNull(str2, "appToken");
        sContext = context.getApplicationContext();
        if (sContext == null) {
            sContext = context;
        }
        Context context2 = sContext;
        com.xiaomi.push.t.m558a(context2);
        if (!NetworkStatusReceiver.a()) {
            registerNetworkReceiver(sContext);
        }
        g.a(sContext).a(pushConfiguration);
        b.a();
        com.xiaomi.push.ai.a(context2).a(new ae(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void removeAcceptTime(Context context) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
            com.xiaomi.push.r.a(edit);
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
        if (d.m80a(context).m87b()) {
            hq hqVar = z ? hq.APP_SLEEP : hq.APP_WAKEUP;
            Cif cif = new Cif();
            cif.b(d.m80a(context).m81a());
            cif.c(hqVar.f493a);
            cif.d(context.getPackageName());
            cif.a(com.xiaomi.push.service.aj.a());
            cif.a(false);
            ay.a(context).a((ay) cif, hg.Notification, false, (ht) null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportIgnoreRegMessageClicked(Context context, String str, ht htVar, String str2, String str3) {
        Cif cif = new Cif();
        if (TextUtils.isEmpty(str3)) {
            com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
            return;
        }
        cif.b(str3);
        cif.c("bar:click");
        cif.a(str);
        cif.a(false);
        ay.a(context).a(cif, hg.Notification, false, true, htVar, true, str2, str3);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        ht htVar = new ht();
        htVar.a(miPushMessage.getMessageId());
        htVar.b(miPushMessage.getTopic());
        htVar.d(miPushMessage.getDescription());
        htVar.c(miPushMessage.getTitle());
        htVar.c(miPushMessage.getNotifyId());
        htVar.a(miPushMessage.getNotifyType());
        htVar.b(miPushMessage.getPassThrough());
        htVar.a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), htVar, null);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportMessageClicked(Context context, String str, ht htVar, String str2) {
        Cif cif = new Cif();
        if (!TextUtils.isEmpty(str2)) {
            cif.b(str2);
        } else if (!d.m80a(context).m87b()) {
            com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
            return;
        } else {
            cif.b(d.m80a(context).m81a());
        }
        cif.c("bar:click");
        cif.a(str);
        cif.a(false);
        ay.a(context).a((ay) cif, hg.Notification, false, htVar);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    private static void scheduleDataCollectionJobs(Context context) {
        if (com.xiaomi.push.service.ag.a(sContext).a(hl.DataCollectionSwitch.a(), getDefaultSwitch())) {
            dl.a().a(new s(context));
            com.xiaomi.push.ai.a(sContext).a(new af(), 10);
        }
    }

    private static void scheduleOcVersionCheckJob() {
        com.xiaomi.push.ai.a(sContext).a(new an(sContext), com.xiaomi.push.service.ag.a(sContext).a(hl.OcVersionCheckFrequency.a(), 86400), 5);
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
            setCommand(context, fa.COMMAND_SET_ACCEPT_TIME.f336a, arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.a(context, str, fa.COMMAND_SET_ACCEPT_TIME.f336a, 0L, null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(fa.COMMAND_SET_ACCEPT_TIME.f336a, arrayList2, 0L, null, null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, fa.COMMAND_SET_ALIAS.f336a, str, str2);
    }

    protected static void setCommand(Context context, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (fa.COMMAND_SET_ALIAS.f336a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) < BdKVCache.MILLS_1Hour) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(fa.COMMAND_SET_ALIAS.f336a, arrayList, 0L, null, str3));
            }
        } else if (fa.COMMAND_UNSET_ALIAS.f336a.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
            com.xiaomi.channel.commonutils.logger.b.m42a("Don't cancel alias for " + com.xiaomi.push.ay.a(arrayList.toString(), 3) + " is unseted");
        } else if (fa.COMMAND_SET_ACCOUNT.f336a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) < BdKVCache.MILLS_1Hour) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(fa.COMMAND_SET_ACCOUNT.f336a, arrayList, 0L, null, str3));
            }
        } else if (!fa.COMMAND_UNSET_ACCOUNT.f336a.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
            setCommand(context, str, arrayList, str3);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m42a("Don't cancel account for " + com.xiaomi.push.ay.a(arrayList.toString(), 3) + " is unseted");
        }
    }

    protected static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (TextUtils.isEmpty(d.m80a(context).m81a())) {
            return;
        }
        ia iaVar = new ia();
        iaVar.a(com.xiaomi.push.service.aj.a());
        iaVar.b(d.m80a(context).m81a());
        iaVar.c(str);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            iaVar.m388a(it.next());
        }
        iaVar.e(str2);
        iaVar.d(context.getPackageName());
        ay.a(context).a((ay) iaVar, hg.Command, (ht) null);
    }

    public static void setLocalNotificationType(Context context, int i) {
        ay.a(context).b(i & (-1));
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, fa.COMMAND_SET_ACCOUNT.f336a, str, str2);
    }

    private static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1L)) > 300000;
    }

    private static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) > 5000;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return ay.a(context).m71a();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (TextUtils.isEmpty(d.m80a(context).m81a()) || TextUtils.isEmpty(str)) {
            return;
        }
        if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) <= 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0L, null, str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(fa.COMMAND_SUBSCRIBE_TOPIC.f336a, arrayList, 0L, null, null));
            return;
        }
        ik ikVar = new ik();
        ikVar.a(com.xiaomi.push.service.aj.a());
        ikVar.b(d.m80a(context).m81a());
        ikVar.c(str);
        ikVar.d(context.getPackageName());
        ikVar.e(str2);
        ay.a(context).a((ay) ikVar, hg.Subscription, (ht) null);
    }

    public static void syncAssembleCOSPushToken(Context context) {
        ay.a(context).a((String) null, bd.UPLOAD_COS_TOKEN, f.ASSEMBLE_PUSH_COS);
    }

    public static void syncAssembleFCMPushToken(Context context) {
        ay.a(context).a((String) null, bd.UPLOAD_FCM_TOKEN, f.ASSEMBLE_PUSH_FCM);
    }

    public static void syncAssembleFTOSPushToken(Context context) {
        ay.a(context).a((String) null, bd.UPLOAD_FTOS_TOKEN, f.ASSEMBLE_PUSH_FTOS);
    }

    public static void syncAssemblePushToken(Context context) {
        ay.a(context).a((String) null, bd.UPLOAD_HUAWEI_TOKEN, f.ASSEMBLE_PUSH_HUAWEI);
    }

    public static long topicSubscribedTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("topic_" + str, -1L);
    }

    public static void unregisterPush(Context context) {
        j.c(context);
        com.xiaomi.push.service.ag.a(context).a();
        if (d.m80a(context).m87b()) {
            im imVar = new im();
            imVar.a(com.xiaomi.push.service.aj.a());
            imVar.b(d.m80a(context).m81a());
            imVar.c(d.m80a(context).m88c());
            imVar.e(d.m80a(context).b());
            imVar.d(context.getPackageName());
            ay.a(context).a(imVar);
            PushMessageHandler.a();
            d.m80a(context).m86b();
            clearLocalNotificationType(context);
            clearNotification(context);
            clearExtras(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, fa.COMMAND_UNSET_ALIAS.f336a, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, fa.COMMAND_UNSET_ACCOUNT.f336a, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (d.m80a(context).m87b()) {
            if (topicSubscribedTime(context, str) < 0) {
                com.xiaomi.channel.commonutils.logger.b.m42a("Don't cancel subscribe for " + str + " is unsubscribed");
                return;
            }
            io ioVar = new io();
            ioVar.a(com.xiaomi.push.service.aj.a());
            ioVar.b(d.m80a(context).m81a());
            ioVar.c(str);
            ioVar.d(context.getPackageName());
            ioVar.e(str2);
            ay.a(context).a((ay) ioVar, hg.UnSubscription, (ht) null);
        }
    }

    private static void updateIMEI() {
        new Thread(new ag()).start();
    }
}
