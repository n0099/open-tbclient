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
import com.heytap.mcssdk.mode.Message;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.bf;
import com.xiaomi.push.dq;
import com.xiaomi.push.dr;
import com.xiaomi.push.ey;
import com.xiaomi.push.ez;
import com.xiaomi.push.fa;
import com.xiaomi.push.fg;
import com.xiaomi.push.hm;
import com.xiaomi.push.hq;
import com.xiaomi.push.hr;
import com.xiaomi.push.hw;
import com.xiaomi.push.hz;
import com.xiaomi.push.ia;
import com.xiaomi.push.ig;
import com.xiaomi.push.il;
import com.xiaomi.push.im;
import com.xiaomi.push.iq;
import com.xiaomi.push.is;
import com.xiaomi.push.iu;
import com.xiaomi.push.service.ak;
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

    /* loaded from: classes6.dex */
    public static class CodeResult {
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        protected void setResultCode(long j) {
            this.resultCode = j;
        }
    }

    /* loaded from: classes6.dex */
    public interface ICallbackResult<R> {
        void onResult(R r);
    }

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

    /* loaded from: classes6.dex */
    public static class TokenResult {
        private String token = null;
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        public String getToken() {
            return this.token;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void setResultCode(long j) {
            this.resultCode = j;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void setToken(String str) {
            this.token = str;
        }
    }

    /* loaded from: classes6.dex */
    public interface UPSRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    /* loaded from: classes6.dex */
    public interface UPSTurnCallBack extends ICallbackResult<CodeResult> {
    }

    /* loaded from: classes6.dex */
    public interface UPSUnRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    private static boolean acceptTimeSet(Context context, String str, String str2) {
        return TextUtils.equals(getAcceptTime(context), str + "," + str2);
    }

    public static long accountSetTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("account_" + str, -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void addAcceptTime(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(Constants.EXTRA_KEY_ACCEPT_TIME, str + "," + str2);
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

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00af, code lost:
        if (com.xiaomi.push.au.a(r5).a() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c6, code lost:
        if (android.text.TextUtils.isEmpty(r3) != false) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean checkPermission(Context context) {
        boolean z = true;
        if (context != null) {
            if (!com.xiaomi.push.l.m519a() && !"com.xiaomi.xmsf".equals(context.getPackageName()) && TextUtils.isEmpty(com.xiaomi.push.i.b(context))) {
                if (context.getApplicationInfo().targetSdkVersion < 23 || Build.VERSION.SDK_INT < 23) {
                    String f = com.xiaomi.push.i.f(context);
                    String m407a = com.xiaomi.push.i.m407a();
                    if (TextUtils.isEmpty(f)) {
                    }
                } else if (!com.xiaomi.push.m.a(context, "android.permission.READ_PHONE_STATE")) {
                    if (!com.xiaomi.push.m.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    }
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
        aq.a(context).m112e();
    }

    public static void clearNotification(Context context) {
        aq.a(context).a(-1);
    }

    public static void clearNotification(Context context, int i) {
        aq.a(context).a(i);
    }

    public static void clearNotification(Context context, String str, String str2) {
        aq.a(context).a(str, str2);
    }

    public static void disablePush(Context context) {
        aq.a(context).a(true);
    }

    public static void enablePush(Context context) {
        aq.a(context).a(false);
    }

    private static void forceHandleCrash() {
        boolean a2 = com.xiaomi.push.service.ak.a(sContext).a(hr.ForceHandleCrashSwitch.a(), false);
        if (isCrashHandlerSuggested || !a2) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new v(sContext));
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
        if (b.m113a(context).m122c()) {
            return b.m113a(context).f();
        }
        return null;
    }

    private static boolean getDefaultSwitch() {
        return com.xiaomi.push.l.m520b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenFCMPush(Context context) {
        checkNotNull(context, "context");
        return e.a(context).b(d.ASSEMBLE_PUSH_FCM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenHmsPush(Context context) {
        checkNotNull(context, "context");
        return e.a(context).b(d.ASSEMBLE_PUSH_HUAWEI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenOPPOPush(Context context) {
        checkNotNull(context, "context");
        return e.a(context).b(d.ASSEMBLE_PUSH_COS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getOpenVIVOPush(Context context) {
        return e.a(context).b(d.ASSEMBLE_PUSH_FTOS);
    }

    public static String getRegId(Context context) {
        if (b.m113a(context).m122c()) {
            return b.m113a(context).m121c();
        }
        return null;
    }

    private static void initEventPerfLogic(final Context context) {
        fa.a(new fa.a() { // from class: com.xiaomi.mipush.sdk.MiPushClient.5
            @Override // com.xiaomi.push.fa.a
            public void uploader(Context context2, hq hqVar) {
                MiTinyDataClient.upload(context2, hqVar);
            }
        });
        Config a2 = fa.a(context);
        com.xiaomi.clientreport.manager.a.a(context).a("3_7_5");
        ClientReportClient.init(context, a2, new ey(context), new ez(context));
        a.a(context);
        r.a(context, a2);
        com.xiaomi.push.service.ak.a(context).a(new ak.a(100, "perf event job update") { // from class: com.xiaomi.mipush.sdk.MiPushClient.6
            @Override // com.xiaomi.push.service.ak.a
            protected void onCallback() {
                fa.m291a(context);
            }
        });
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        initialize(context, str, str2, miPushClientCallback, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback, String str3, ICallbackResult iCallbackResult) {
        try {
            com.xiaomi.channel.commonutils.logger.b.m73a("sdk_version = 3_7_5");
            if (miPushClientCallback != null) {
                PushMessageHandler.a(miPushClientCallback);
            }
            if (iCallbackResult != null) {
                PushMessageHandler.a(iCallbackResult);
            }
            if (com.xiaomi.push.t.m606a(sContext)) {
                x.a(sContext);
            }
            if (b.m113a(sContext).a(str, str2) || checkPermission(sContext)) {
                boolean z = b.m113a(sContext).a() != Constants.a();
                if (!z && !shouldSendRegRequest(sContext)) {
                    aq.a(sContext).m104a();
                    com.xiaomi.channel.commonutils.logger.b.m73a("Could not send  register message within 5s repeatly .");
                    return;
                }
                if (z || !b.m113a(sContext).a(str, str2) || b.m113a(sContext).m124e()) {
                    String a2 = bf.a(6);
                    b.m113a(sContext).m115a();
                    b.m113a(sContext).a(Constants.a());
                    b.m113a(sContext).a(str, str2, a2);
                    MiTinyDataClient.a.a().b(MiTinyDataClient.PENDING_REASON_APPID);
                    clearExtras(sContext);
                    im imVar = new im();
                    imVar.a(com.xiaomi.push.service.an.a());
                    imVar.b(str);
                    imVar.e(str2);
                    imVar.d(sContext.getPackageName());
                    imVar.f(a2);
                    imVar.c(com.xiaomi.push.g.m326a(sContext, sContext.getPackageName()));
                    imVar.b(com.xiaomi.push.g.a(sContext, sContext.getPackageName()));
                    imVar.h("3_7_5");
                    imVar.a(30705);
                    imVar.i(com.xiaomi.push.i.e(sContext));
                    imVar.a(ia.Init);
                    if (!TextUtils.isEmpty(str3)) {
                        imVar.g(str3);
                    }
                    if (!com.xiaomi.push.l.d()) {
                        String g = com.xiaomi.push.i.g(sContext);
                        if (!TextUtils.isEmpty(g)) {
                            imVar.k(bf.a(g) + "," + com.xiaomi.push.i.j(sContext));
                        }
                    }
                    imVar.j(com.xiaomi.push.i.m407a());
                    int a3 = com.xiaomi.push.i.a();
                    if (a3 >= 0) {
                        imVar.c(a3);
                    }
                    aq.a(sContext).a(imVar, z);
                    sContext.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
                } else {
                    if (1 == PushMessageHelper.getPushMode(sContext)) {
                        checkNotNull(miPushClientCallback, BuyTBeanActivityConfig.CALLBACK);
                        miPushClientCallback.onInitializeResult(0L, null, b.m113a(sContext).m121c());
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(b.m113a(sContext).m121c());
                        PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(fg.COMMAND_REGISTER.f398a, arrayList, 0L, null, null));
                    }
                    aq.a(sContext).m104a();
                    if (b.m113a(sContext).m117a()) {
                        il ilVar = new il();
                        ilVar.b(b.m113a(sContext).m114a());
                        ilVar.c("client_info_update");
                        ilVar.a(com.xiaomi.push.service.an.a());
                        ilVar.f696a = new HashMap();
                        ilVar.f696a.put("app_version", com.xiaomi.push.g.m326a(sContext, sContext.getPackageName()));
                        ilVar.f696a.put(Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.g.a(sContext, sContext.getPackageName())));
                        ilVar.f696a.put("push_sdk_vn", "3_7_5");
                        ilVar.f696a.put("push_sdk_vc", Integer.toString(30705));
                        String e = b.m113a(sContext).e();
                        if (!TextUtils.isEmpty(e)) {
                            ilVar.f696a.put("deviceid", e);
                        }
                        aq.a(sContext).a((aq) ilVar, hm.Notification, false, (hz) null);
                    }
                    if (!com.xiaomi.push.n.m521a(sContext, "update_devId", false)) {
                        updateImeiOrOaid();
                        com.xiaomi.push.n.a(sContext, "update_devId", true);
                    }
                    String d = com.xiaomi.push.i.d(sContext);
                    if (!TextUtils.isEmpty(d)) {
                        ig igVar = new ig();
                        igVar.a(com.xiaomi.push.service.an.a());
                        igVar.b(str);
                        igVar.c(fg.COMMAND_CHK_VDEVID.f398a);
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(com.xiaomi.push.i.c(sContext));
                        arrayList2.add(d);
                        arrayList2.add(Build.MODEL != null ? Build.MODEL : "");
                        arrayList2.add(Build.BOARD != null ? Build.BOARD : "");
                        igVar.a(arrayList2);
                        aq.a(sContext).a((aq) igVar, hm.Command, false, (hz) null);
                    }
                    if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                        il ilVar2 = new il();
                        ilVar2.b(b.m113a(sContext).m114a());
                        ilVar2.c(hw.PullOfflineMessage.f555a);
                        ilVar2.a(com.xiaomi.push.service.an.a());
                        ilVar2.a(false);
                        aq.a(sContext).a((aq) ilVar2, hm.Notification, false, (hz) null, false);
                        addPullNotificationTime(sContext);
                    }
                }
                addRegRequestTime(sContext);
                scheduleOcVersionCheckJob();
                scheduleDataCollectionJobs(sContext);
                initEventPerfLogic(sContext);
                aw.a(sContext);
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
        if ("syncing".equals(ag.a(sContext).a(av.DISABLE_PUSH))) {
            disablePush(sContext);
        }
        if ("syncing".equals(ag.a(sContext).a(av.ENABLE_PUSH))) {
            enablePush(sContext);
        }
        if ("syncing".equals(ag.a(sContext).a(av.UPLOAD_HUAWEI_TOKEN))) {
            syncAssemblePushToken(sContext);
        }
        if ("syncing".equals(ag.a(sContext).a(av.UPLOAD_FCM_TOKEN))) {
            syncAssembleFCMPushToken(sContext);
        }
        if ("syncing".equals(ag.a(sContext).a(av.UPLOAD_COS_TOKEN))) {
            syncAssembleCOSPushToken(context);
        }
        if ("syncing".equals(ag.a(sContext).a(av.UPLOAD_FTOS_TOKEN))) {
            syncAssembleFTOSPushToken(context);
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reInitialize(Context context, ia iaVar) {
        if (b.m113a(context).m122c()) {
            String a2 = bf.a(6);
            String m114a = b.m113a(context).m114a();
            String b2 = b.m113a(context).b();
            b.m113a(context).m115a();
            b.m113a(context).a(Constants.a());
            b.m113a(context).a(m114a, b2, a2);
            im imVar = new im();
            imVar.a(com.xiaomi.push.service.an.a());
            imVar.b(m114a);
            imVar.e(b2);
            imVar.f(a2);
            imVar.d(context.getPackageName());
            imVar.c(com.xiaomi.push.g.m326a(context, context.getPackageName()));
            imVar.a(iaVar);
            aq.a(context).a(imVar, false);
        }
    }

    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(new v(sContext, uncaughtExceptionHandler));
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
        registerPush(context, str, str2, pushConfiguration, null, null);
    }

    private static void registerPush(Context context, final String str, final String str2, PushConfiguration pushConfiguration, final String str3, final ICallbackResult iCallbackResult) {
        checkNotNull(context, "context");
        checkNotNull(str, Message.APP_ID);
        checkNotNull(str2, "appToken");
        sContext = context.getApplicationContext();
        if (sContext == null) {
            sContext = context;
        }
        Context context2 = sContext;
        com.xiaomi.push.t.m604a(context2);
        if (!NetworkStatusReceiver.a()) {
            registerNetworkReceiver(sContext);
        }
        e.a(sContext).a(pushConfiguration);
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
        if (b.m113a(context).m120b()) {
            hw hwVar = z ? hw.APP_SLEEP : hw.APP_WAKEUP;
            il ilVar = new il();
            ilVar.b(b.m113a(context).m114a());
            ilVar.c(hwVar.f555a);
            ilVar.d(context.getPackageName());
            ilVar.a(com.xiaomi.push.service.an.a());
            ilVar.a(false);
            aq.a(context).a((aq) ilVar, hm.Notification, false, (hz) null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportIgnoreRegMessageClicked(Context context, String str, hz hzVar, String str2, String str3) {
        il ilVar = new il();
        if (TextUtils.isEmpty(str3)) {
            com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
            return;
        }
        ilVar.b(str3);
        ilVar.c("bar:click");
        ilVar.a(str);
        ilVar.a(false);
        aq.a(context).a(ilVar, hm.Notification, false, true, hzVar, true, str2, str3);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        hz hzVar = new hz();
        hzVar.a(miPushMessage.getMessageId());
        hzVar.b(miPushMessage.getTopic());
        hzVar.d(miPushMessage.getDescription());
        hzVar.c(miPushMessage.getTitle());
        hzVar.c(miPushMessage.getNotifyId());
        hzVar.a(miPushMessage.getNotifyType());
        hzVar.b(miPushMessage.getPassThrough());
        hzVar.a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), hzVar, null);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportMessageClicked(Context context, String str, hz hzVar, String str2) {
        il ilVar = new il();
        if (!TextUtils.isEmpty(str2)) {
            ilVar.b(str2);
        } else if (!b.m113a(context).m120b()) {
            com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
            return;
        } else {
            ilVar.b(b.m113a(context).m114a());
        }
        ilVar.c("bar:click");
        ilVar.a(str);
        ilVar.a(false);
        aq.a(context).a((aq) ilVar, hm.Notification, false, hzVar);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    private static void scheduleDataCollectionJobs(Context context) {
        if (com.xiaomi.push.service.ak.a(sContext).a(hr.DataCollectionSwitch.a(), getDefaultSwitch())) {
            dq.a().a(new q(context));
            com.xiaomi.push.ai.a(sContext).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.2
                @Override // java.lang.Runnable
                public void run() {
                    dr.a(MiPushClient.sContext);
                }
            }, 10);
        }
    }

    private static void scheduleOcVersionCheckJob() {
        com.xiaomi.push.ai.a(sContext).a(new af(sContext), com.xiaomi.push.service.ak.a(sContext).a(hr.OcVersionCheckFrequency.a(), 86400), 5);
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
            setCommand(context, fg.COMMAND_SET_ACCEPT_TIME.f398a, arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.a(context, str, fg.COMMAND_SET_ACCEPT_TIME.f398a, 0L, null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(fg.COMMAND_SET_ACCEPT_TIME.f398a, arrayList2, 0L, null, null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, fg.COMMAND_SET_ALIAS.f398a, str, str2);
    }

    protected static void setCommand(Context context, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (fg.COMMAND_SET_ALIAS.f398a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) < 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(fg.COMMAND_SET_ALIAS.f398a, arrayList, 0L, null, str3));
            }
        } else if (fg.COMMAND_UNSET_ALIAS.f398a.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
            com.xiaomi.channel.commonutils.logger.b.m73a("Don't cancel alias for " + bf.a(arrayList.toString(), 3) + " is unseted");
        } else if (fg.COMMAND_SET_ACCOUNT.f398a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) < BdKVCache.MILLS_1Hour) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(fg.COMMAND_SET_ACCOUNT.f398a, arrayList, 0L, null, str3));
            }
        } else if (!fg.COMMAND_UNSET_ACCOUNT.f398a.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
            setCommand(context, str, arrayList, str3);
        } else {
            com.xiaomi.channel.commonutils.logger.b.m73a("Don't cancel account for " + bf.a(arrayList.toString(), 3) + " is unseted");
        }
    }

    protected static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (TextUtils.isEmpty(b.m113a(context).m114a())) {
            return;
        }
        ig igVar = new ig();
        igVar.a(com.xiaomi.push.service.an.a());
        igVar.b(b.m113a(context).m114a());
        igVar.c(str);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            igVar.m429a(it.next());
        }
        igVar.e(str2);
        igVar.d(context.getPackageName());
        aq.a(context).a((aq) igVar, hm.Command, (hz) null);
    }

    public static void setLocalNotificationType(Context context, int i) {
        aq.a(context).b(i & (-1));
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, fg.COMMAND_SET_ACCOUNT.f398a, str, str2);
    }

    private static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1L)) > 300000;
    }

    private static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) > 5000;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return aq.a(context).m106a();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (TextUtils.isEmpty(b.m113a(context).m114a()) || TextUtils.isEmpty(str)) {
            return;
        }
        if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) <= 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0L, null, str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(fg.COMMAND_SUBSCRIBE_TOPIC.f398a, arrayList, 0L, null, null));
            return;
        }
        iq iqVar = new iq();
        iqVar.a(com.xiaomi.push.service.an.a());
        iqVar.b(b.m113a(context).m114a());
        iqVar.c(str);
        iqVar.d(context.getPackageName());
        iqVar.e(str2);
        aq.a(context).a((aq) iqVar, hm.Subscription, (hz) null);
    }

    public static void syncAssembleCOSPushToken(Context context) {
        aq.a(context).a((String) null, av.UPLOAD_COS_TOKEN, d.ASSEMBLE_PUSH_COS);
    }

    public static void syncAssembleFCMPushToken(Context context) {
        aq.a(context).a((String) null, av.UPLOAD_FCM_TOKEN, d.ASSEMBLE_PUSH_FCM);
    }

    public static void syncAssembleFTOSPushToken(Context context) {
        aq.a(context).a((String) null, av.UPLOAD_FTOS_TOKEN, d.ASSEMBLE_PUSH_FTOS);
    }

    public static void syncAssemblePushToken(Context context) {
        aq.a(context).a((String) null, av.UPLOAD_HUAWEI_TOKEN, d.ASSEMBLE_PUSH_HUAWEI);
    }

    public static long topicSubscribedTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("topic_" + str, -1L);
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
        h.c(context);
        com.xiaomi.push.service.ak.a(context).a();
        if (b.m113a(context).m120b()) {
            is isVar = new is();
            isVar.a(com.xiaomi.push.service.an.a());
            isVar.b(b.m113a(context).m114a());
            isVar.c(b.m113a(context).m121c());
            isVar.e(b.m113a(context).b());
            isVar.d(context.getPackageName());
            aq.a(context).a(isVar);
            PushMessageHandler.a();
            PushMessageHandler.b();
            b.m113a(context).m119b();
            clearLocalNotificationType(context);
            clearNotification(context);
            clearExtras(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, fg.COMMAND_UNSET_ALIAS.f398a, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, fg.COMMAND_UNSET_ACCOUNT.f398a, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (b.m113a(context).m120b()) {
            if (topicSubscribedTime(context, str) < 0) {
                com.xiaomi.channel.commonutils.logger.b.m73a("Don't cancel subscribe for " + str + " is unsubscribed");
                return;
            }
            iu iuVar = new iu();
            iuVar.a(com.xiaomi.push.service.an.a());
            iuVar.b(b.m113a(context).m114a());
            iuVar.c(str);
            iuVar.d(context.getPackageName());
            iuVar.e(str2);
            aq.a(context).a((aq) iuVar, hm.UnSubscription, (hz) null);
        }
    }

    private static void updateImeiOrOaid() {
        new Thread(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.3
            @Override // java.lang.Runnable
            public void run() {
                String f;
                if (com.xiaomi.push.l.d()) {
                    return;
                }
                if (com.xiaomi.push.i.f(MiPushClient.sContext) != null || com.xiaomi.push.au.a(MiPushClient.sContext).a()) {
                    il ilVar = new il();
                    ilVar.b(b.m113a(MiPushClient.sContext).m114a());
                    ilVar.c("client_info_update");
                    ilVar.a(com.xiaomi.push.service.an.a());
                    ilVar.a(new HashMap());
                    String str = TextUtils.isEmpty(com.xiaomi.push.i.f(MiPushClient.sContext)) ? "" : "" + bf.a(f);
                    String h = com.xiaomi.push.i.h(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(h)) {
                        str = str + "," + h;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        ilVar.m452a().put(Constants.EXTRA_KEY_IMEI_MD5, str);
                    }
                    com.xiaomi.push.au.a(MiPushClient.sContext).a(ilVar.m452a());
                    int a2 = com.xiaomi.push.i.a();
                    if (a2 >= 0) {
                        ilVar.m452a().put("space_id", Integer.toString(a2));
                    }
                    aq.a(MiPushClient.sContext).a((aq) ilVar, hm.Notification, false, (hz) null);
                }
            }
        }).start();
    }
}
