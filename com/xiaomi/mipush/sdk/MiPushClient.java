package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.account.utils.SocialEncodeUtils;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.webkit.sdk.WebChromeClient;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.az;
import com.xiaomi.push.bo;
import com.xiaomi.push.dc;
import com.xiaomi.push.dm;
import com.xiaomi.push.dn;
import com.xiaomi.push.ek;
import com.xiaomi.push.el;
import com.xiaomi.push.em;
import com.xiaomi.push.ex;
import com.xiaomi.push.hh;
import com.xiaomi.push.hl;
import com.xiaomi.push.hm;
import com.xiaomi.push.hr;
import com.xiaomi.push.hu;
import com.xiaomi.push.hv;
import com.xiaomi.push.ib;
import com.xiaomi.push.ig;
import com.xiaomi.push.ih;
import com.xiaomi.push.il;
import com.xiaomi.push.in;
import com.xiaomi.push.ip;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
/* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public static class CodeResult {
        public long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        public void setResultCode(long j) {
            this.resultCode = j;
        }
    }

    /* loaded from: classes10.dex */
    public interface ICallbackResult<R> {
        void onResult(R r);
    }

    @Deprecated
    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public interface UPSRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    /* loaded from: classes10.dex */
    public interface UPSTurnCallBack extends ICallbackResult<CodeResult> {
    }

    /* loaded from: classes10.dex */
    public interface UPSUnRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    public static boolean acceptTimeSet(Context context, String str, String str2) {
        String acceptTime = getAcceptTime(context);
        return TextUtils.equals(acceptTime, str + "," + str2);
    }

    public static long accountSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong(SocialEncodeUtils.TAG_ACCOUNT + str, -1L);
    }

    public static synchronized void addAcceptTime(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(Constants.EXTRA_KEY_ACCEPT_TIME, str + "," + str2);
            com.xiaomi.push.q.a(edit);
        }
    }

    public static synchronized void addAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong(SocialEncodeUtils.TAG_ACCOUNT + str, System.currentTimeMillis()).commit();
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
        com.xiaomi.push.q.a(edit);
    }

    public static void addRegRequestTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        com.xiaomi.push.q.a(edit);
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
        com.xiaomi.push.aj.a(context).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.4
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

    public static void clearExtrasForInitialize(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        Iterator<String> it = getAllAlias(context).iterator();
        while (it.hasNext()) {
            edit.remove("alias_" + it.next());
        }
        Iterator<String> it2 = getAllUserAccount(context).iterator();
        while (it2.hasNext()) {
            edit.remove(SocialEncodeUtils.TAG_ACCOUNT + it2.next());
        }
        Iterator<String> it3 = getAllTopic(context).iterator();
        while (it3.hasNext()) {
            edit.remove("topic_" + it3.next());
        }
        edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
        edit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        ao.a(context).f();
    }

    public static void clearNotification(Context context) {
        ao.a(context).a(-1);
    }

    public static void clearNotification(Context context, int i) {
        ao.a(context).a(i);
    }

    public static void clearNotification(Context context, String str, String str2) {
        ao.a(context).a(str, str2);
    }

    public static void disablePush(Context context) {
        ao.a(context).a(true);
    }

    public static void enablePush(Context context) {
        ao.a(context).a(false);
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
            if (str.startsWith(SocialEncodeUtils.TAG_ACCOUNT)) {
                arrayList.add(str.substring(8));
            }
        }
        return arrayList;
    }

    public static String getAppRegion(Context context) {
        if (b.m230a(context).m239c()) {
            return b.m230a(context).f();
        }
        return null;
    }

    public static boolean getDefaultSwitch() {
        return com.xiaomi.push.j.m720b();
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
        if (b.m230a(context).m239c()) {
            return b.m230a(context).m238c();
        }
        return null;
    }

    public static void initEventPerfLogic(final Context context) {
        em.a(new em.a() { // from class: com.xiaomi.mipush.sdk.MiPushClient.5
            @Override // com.xiaomi.push.em.a
            public void uploader(Context context2, hl hlVar) {
                MiTinyDataClient.upload(context2, hlVar);
            }
        });
        Config a = em.a(context);
        com.xiaomi.clientreport.manager.a.a(context).a(BuildConfig.VERSION_NAME);
        ClientReportClient.init(context, a, new ek(context), new el(context));
        a.a(context);
        t.a(context, a);
        ba.a(context).a(new ba.a(100, "perf event job update") { // from class: com.xiaomi.mipush.sdk.MiPushClient.6
            @Override // com.xiaomi.push.service.ba.a
            public void onCallback() {
                em.m459a(context);
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
            com.xiaomi.channel.commonutils.logger.b.e("sdk_version = 5_0_5-C");
            az.a(context).a();
            dc.a(context);
            if (miPushClientCallback != null) {
                PushMessageHandler.a(miPushClientCallback);
            }
            if (iCallbackResult != null) {
                PushMessageHandler.a(iCallbackResult);
            }
            if (com.xiaomi.push.s.m731a(sContext)) {
                v.a(sContext);
            }
            boolean z = b.m230a(sContext).a() != Constants.a();
            if (!z && !shouldSendRegRequest(sContext)) {
                ao.a(sContext).m220a();
                com.xiaomi.channel.commonutils.logger.b.m186a("Could not send  register message within 5s repeatly .");
                return;
            }
            if (z || !b.m230a(sContext).a(str, str2) || b.m230a(sContext).m242f()) {
                String a = bo.a(6);
                b.m230a(sContext).m232a();
                b.m230a(sContext).a(Constants.a());
                b.m230a(sContext).a(str, str2, a);
                MiTinyDataClient.a.a().b(MiTinyDataClient.PENDING_REASON_APPID);
                clearExtras(sContext);
                clearNotification(context);
                ih ihVar = new ih();
                ihVar.a(bd.b());
                ihVar.b(str);
                ihVar.e(str2);
                ihVar.d(sContext.getPackageName());
                ihVar.f(a);
                ihVar.c(com.xiaomi.push.g.m521a(sContext, sContext.getPackageName()));
                ihVar.b(com.xiaomi.push.g.a(sContext, sContext.getPackageName()));
                ihVar.h(BuildConfig.VERSION_NAME);
                ihVar.a(50005);
                ihVar.a(hv.Init);
                if (!TextUtils.isEmpty(str3)) {
                    ihVar.g(str3);
                }
                if (!com.xiaomi.push.j.m722d()) {
                    String d = com.xiaomi.push.i.d(sContext);
                    if (!TextUtils.isEmpty(d)) {
                        ihVar.i(bo.a(d) + "," + com.xiaomi.push.i.f(sContext));
                    }
                }
                int a2 = com.xiaomi.push.i.a();
                if (a2 >= 0) {
                    ihVar.c(a2);
                }
                ao.a(sContext).a(ihVar, z);
                sContext.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
            } else {
                if (1 == PushMessageHelper.getPushMode(sContext)) {
                    checkNotNull(miPushClientCallback, WebChromeClient.KEY_ARG_CALLBACK);
                    miPushClientCallback.onInitializeResult(0L, null, b.m230a(sContext).m238c());
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(b.m230a(sContext).m238c());
                    PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(ex.COMMAND_REGISTER.f336a, arrayList, 0L, null, null, null));
                }
                ao.a(sContext).m220a();
                if (b.m230a(sContext).m234a()) {
                    ig igVar = new ig();
                    igVar.b(b.m230a(sContext).m231a());
                    igVar.c(hr.ClientInfoUpdate.f508a);
                    igVar.a(bd.a());
                    HashMap hashMap = new HashMap();
                    igVar.f650a = hashMap;
                    hashMap.put("app_version", com.xiaomi.push.g.m521a(sContext, sContext.getPackageName()));
                    igVar.f650a.put(Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.push.g.a(sContext, sContext.getPackageName())));
                    igVar.f650a.put("push_sdk_vn", BuildConfig.VERSION_NAME);
                    igVar.f650a.put("push_sdk_vc", Integer.toString(50005));
                    String e = b.m230a(sContext).e();
                    if (!TextUtils.isEmpty(e)) {
                        igVar.f650a.put("deviceid", e);
                    }
                    ao.a(sContext).a((ao) igVar, hh.Notification, false, (hu) null);
                    ao.a(sContext).m221a(sContext);
                }
                if (!com.xiaomi.push.k.m726a(sContext, "update_devId", false)) {
                    updateImeiOrOaid();
                    com.xiaomi.push.k.a(sContext, "update_devId", true);
                }
                if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                    ig igVar2 = new ig();
                    igVar2.b(b.m230a(sContext).m231a());
                    igVar2.c(hr.PullOfflineMessage.f508a);
                    igVar2.a(bd.a());
                    igVar2.a(false);
                    ao.a(sContext).a((ao) igVar2, hh.Notification, false, (hu) null, false);
                    addPullNotificationTime(sContext);
                }
            }
            addRegRequestTime(sContext);
            scheduleOcVersionCheckJob();
            scheduleDataCollectionJobs(sContext);
            initEventPerfLogic(sContext);
            av.a(sContext);
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
        if ("syncing".equals(af.a(sContext).a(au.DISABLE_PUSH))) {
            disablePush(sContext);
        }
        if ("syncing".equals(af.a(sContext).a(au.ENABLE_PUSH))) {
            enablePush(sContext);
        }
        if ("syncing".equals(af.a(sContext).a(au.UPLOAD_HUAWEI_TOKEN))) {
            ao.a(sContext).a((String) null, au.UPLOAD_HUAWEI_TOKEN, e.ASSEMBLE_PUSH_HUAWEI, "init");
        }
        if ("syncing".equals(af.a(sContext).a(au.UPLOAD_FCM_TOKEN))) {
            syncAssembleFCMPushToken(sContext);
        }
        if ("syncing".equals(af.a(sContext).a(au.UPLOAD_COS_TOKEN))) {
            ao.a(sContext).a((String) null, au.UPLOAD_COS_TOKEN, e.ASSEMBLE_PUSH_COS, "init");
        }
        if ("syncing".equals(af.a(sContext).a(au.UPLOAD_FTOS_TOKEN))) {
            ao.a(context).a((String) null, au.UPLOAD_FTOS_TOKEN, e.ASSEMBLE_PUSH_FTOS, "init");
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    public static void reInitialize(Context context, hv hvVar) {
        com.xiaomi.channel.commonutils.logger.b.e("re-register reason: " + hvVar);
        String a = bo.a(6);
        String m231a = b.m230a(context).m231a();
        String b = b.m230a(context).b();
        b.m230a(context).m232a();
        clearExtrasForInitialize(context);
        clearNotification(context);
        b.m230a(context).a(Constants.a());
        b.m230a(context).a(m231a, b, a);
        ih ihVar = new ih();
        ihVar.a(bd.b());
        ihVar.b(m231a);
        ihVar.e(b);
        ihVar.f(a);
        ihVar.d(context.getPackageName());
        ihVar.c(com.xiaomi.push.g.m521a(context, context.getPackageName()));
        ihVar.b(com.xiaomi.push.g.a(context, context.getPackageName()));
        ihVar.h(BuildConfig.VERSION_NAME);
        ihVar.a(50005);
        ihVar.a(hvVar);
        int a2 = com.xiaomi.push.i.a();
        if (a2 >= 0) {
            ihVar.c(a2);
        }
        ao.a(context).a(ihVar, false);
    }

    @Deprecated
    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    public static void registerNetworkReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
            intentFilter.addCategory("android.intent.category.DEFAULT");
            com.xiaomi.push.l.a(context.getApplicationContext(), new NetworkStatusReceiver(null), intentFilter);
            com.xiaomi.push.l.a(context, NetworkStatusReceiver.class);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m186a("dynamic register network status receiver failed:" + th);
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
        checkNotNull(str, com.heytap.mcssdk.constant.b.u);
        checkNotNull(str2, "appToken");
        Context applicationContext = context.getApplicationContext();
        sContext = applicationContext;
        if (applicationContext == null) {
            sContext = context;
        }
        Context context2 = sContext;
        com.xiaomi.push.s.a(context2);
        if (!NetworkStatusReceiver.a()) {
            registerNetworkReceiver(sContext);
        }
        f.a(sContext).a(pushConfiguration);
        com.xiaomi.push.aj.a(context2).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.1
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
            com.xiaomi.push.q.a(edit);
        }
    }

    public static synchronized void removeAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove(SocialEncodeUtils.TAG_ACCOUNT + str).commit();
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

    public static void removeWindow(Context context) {
        ao.a(context).m229e();
    }

    public static void reportAppRunInBackground(Context context, boolean z) {
        if (b.m230a(context).m237b()) {
            hr hrVar = z ? hr.APP_SLEEP : hr.APP_WAKEUP;
            ig igVar = new ig();
            igVar.b(b.m230a(context).m231a());
            igVar.c(hrVar.f508a);
            igVar.d(context.getPackageName());
            igVar.a(bd.a());
            igVar.a(false);
            ao.a(context).a((ao) igVar, hh.Notification, false, (hu) null, false);
        }
    }

    public static void reportIgnoreRegMessageClicked(Context context, String str, hu huVar, String str2, String str3) {
        ig igVar = new ig();
        if (TextUtils.isEmpty(str3)) {
            com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
            return;
        }
        igVar.b(str3);
        igVar.c("bar:click");
        igVar.a(str);
        igVar.a(false);
        ao.a(context).a(igVar, hh.Notification, false, true, huVar, true, str2, str3);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        hu huVar = new hu();
        huVar.a(miPushMessage.getMessageId());
        huVar.b(miPushMessage.getTopic());
        huVar.d(miPushMessage.getDescription());
        huVar.c(miPushMessage.getTitle());
        huVar.c(miPushMessage.getNotifyId());
        huVar.a(miPushMessage.getNotifyType());
        huVar.b(miPushMessage.getPassThrough());
        huVar.a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), huVar, null);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    public static void reportMessageClicked(Context context, String str, hu huVar, String str2) {
        ig igVar = new ig();
        if (TextUtils.isEmpty(str2)) {
            if (!b.m230a(context).m237b()) {
                com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
                return;
            }
            str2 = b.m230a(context).m231a();
        }
        igVar.b(str2);
        igVar.c("bar:click");
        igVar.a(str);
        igVar.a(false);
        ao.a(context).a((ao) igVar, hh.Notification, false, huVar);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    public static void scheduleDataCollectionJobs(Context context) {
        if (ba.a(sContext).a(hm.DataCollectionSwitch.a(), getDefaultSwitch())) {
            dm.a().a(new r(context));
            com.xiaomi.push.aj.a(sContext).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.2
                @Override // java.lang.Runnable
                public void run() {
                    dn.a(MiPushClient.sContext);
                }
            }, 10);
        }
    }

    public static void scheduleOcVersionCheckJob() {
        com.xiaomi.push.aj.a(sContext).a(new ae(sContext), ba.a(sContext).a(hm.OcVersionCheckFrequency.a(), 86400), 5);
    }

    public static void setAcceptTime(Context context, int i, int i2, int i3, int i4, String str) {
        if (i < 0 || i >= 24 || i3 < 0 || i3 >= 24 || i2 < 0 || i2 >= 60 || i4 < 0 || i4 >= 60) {
            throw new IllegalArgumentException("the input parameter is not valid.");
        }
        long rawOffset = ((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60;
        long j = ((((i * 60) + i2) + rawOffset) + 1440) % 1440;
        long j2 = ((((i3 * 60) + i4) + rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j / 60), Long.valueOf(j % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i), Integer.valueOf(i2)));
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i3), Integer.valueOf(i4)));
        if (!acceptTimeSet(context, (String) arrayList.get(0), (String) arrayList.get(1))) {
            setCommand(context, ex.COMMAND_SET_ACCEPT_TIME.f336a, arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.a(context, str, ex.COMMAND_SET_ACCEPT_TIME.f336a, 0L, null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ex.COMMAND_SET_ACCEPT_TIME.f336a, arrayList2, 0L, null, null, null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, ex.COMMAND_SET_ALIAS.f336a, str, str2);
    }

    public static void setCommand(Context context, String str, String str2, String str3) {
        StringBuilder sb;
        String str4;
        ex exVar;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (ex.COMMAND_SET_ALIAS.f336a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) < 86400000) {
            if (1 != PushMessageHelper.getPushMode(context)) {
                exVar = ex.COMMAND_SET_ALIAS;
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(exVar.f336a, arrayList, 0L, null, str3, null));
                return;
            }
            PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
            return;
        }
        if (ex.COMMAND_UNSET_ALIAS.f336a.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
            sb = new StringBuilder();
            str4 = "Don't cancel alias for ";
        } else if (ex.COMMAND_SET_ACCOUNT.f336a.equalsIgnoreCase(str) && Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) < 3600000) {
            if (1 != PushMessageHelper.getPushMode(context)) {
                exVar = ex.COMMAND_SET_ACCOUNT;
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(exVar.f336a, arrayList, 0L, null, str3, null));
                return;
            }
            PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
            return;
        } else if (!ex.COMMAND_UNSET_ACCOUNT.f336a.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
            setCommand(context, str, arrayList, str3);
            return;
        } else {
            sb = new StringBuilder();
            str4 = "Don't cancel account for ";
        }
        sb.append(str4);
        sb.append(bo.a(arrayList.toString(), 3));
        sb.append(" is unseted");
        com.xiaomi.channel.commonutils.logger.b.m186a(sb.toString());
    }

    public static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (TextUtils.isEmpty(b.m230a(context).m231a())) {
            return;
        }
        ib ibVar = new ib();
        String a = bd.a();
        ibVar.a(a);
        ibVar.b(b.m230a(context).m231a());
        ibVar.c(str);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            ibVar.m621a(it.next());
        }
        ibVar.e(str2);
        ibVar.d(context.getPackageName());
        com.xiaomi.channel.commonutils.logger.b.e("cmd:" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + a);
        ao.a(context).a((ao) ibVar, hh.Command, (hu) null);
    }

    public static void setLocalNotificationType(Context context, int i) {
        ao.a(context).b(i & (-1));
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, ex.COMMAND_SET_ACCOUNT.f336a, str, str2);
    }

    public static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1L)) > 300000;
    }

    public static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) > 5000;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return ao.a(context).m223a();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (TextUtils.isEmpty(b.m230a(context).m231a()) || TextUtils.isEmpty(str)) {
            return;
        }
        if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) <= 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0L, null, str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ex.COMMAND_SUBSCRIBE_TOPIC.f336a, arrayList, 0L, null, null, null));
            return;
        }
        il ilVar = new il();
        String a = bd.a();
        ilVar.a(a);
        ilVar.b(b.m230a(context).m231a());
        ilVar.c(str);
        ilVar.d(context.getPackageName());
        ilVar.e(str2);
        com.xiaomi.channel.commonutils.logger.b.e("cmd:" + ex.COMMAND_SUBSCRIBE_TOPIC + StringUtil.ARRAY_ELEMENT_SEPARATOR + a);
        ao.a(context).a((ao) ilVar, hh.Subscription, (hu) null);
    }

    @Deprecated
    public static void syncAssembleCOSPushToken(Context context) {
    }

    public static void syncAssembleFCMPushToken(Context context) {
        ao.a(context).a((String) null, au.UPLOAD_FCM_TOKEN, e.ASSEMBLE_PUSH_FCM, "");
    }

    @Deprecated
    public static void syncAssembleFTOSPushToken(Context context) {
    }

    @Deprecated
    public static void syncAssemblePushToken(Context context) {
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
        ba.a(context).a();
        if (b.m230a(context).m237b()) {
            in inVar = new in();
            inVar.a(bd.a());
            inVar.b(b.m230a(context).m231a());
            inVar.c(b.m230a(context).m238c());
            inVar.e(b.m230a(context).b());
            inVar.d(context.getPackageName());
            ao.a(context).a(inVar);
            PushMessageHandler.a();
            PushMessageHandler.b();
            b.m230a(context).m236b();
            clearLocalNotificationType(context);
            clearNotification(context);
            clearExtras(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, ex.COMMAND_UNSET_ALIAS.f336a, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, ex.COMMAND_UNSET_ACCOUNT.f336a, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (b.m230a(context).m237b()) {
            if (topicSubscribedTime(context, str) < 0) {
                com.xiaomi.channel.commonutils.logger.b.m186a("Don't cancel subscribe for " + str + " is unsubscribed");
                return;
            }
            ip ipVar = new ip();
            String a = bd.a();
            ipVar.a(a);
            ipVar.b(b.m230a(context).m231a());
            ipVar.c(str);
            ipVar.d(context.getPackageName());
            ipVar.e(str2);
            com.xiaomi.channel.commonutils.logger.b.e("cmd:" + ex.COMMAND_UNSUBSCRIBE_TOPIC + StringUtil.ARRAY_ELEMENT_SEPARATOR + a);
            ao.a(context).a((ao) ipVar, hh.UnSubscription, (hu) null);
        }
    }

    public static void updateImeiOrOaid() {
        new Thread(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.3
            @Override // java.lang.Runnable
            public void run() {
                String c;
                if (com.xiaomi.push.j.m722d()) {
                    return;
                }
                if (com.xiaomi.push.i.c(MiPushClient.sContext) != null || az.a(MiPushClient.sContext).mo272a()) {
                    ig igVar = new ig();
                    igVar.b(b.m230a(MiPushClient.sContext).m231a());
                    igVar.c(hr.ClientInfoUpdate.f508a);
                    igVar.a(bd.a());
                    igVar.a(new HashMap());
                    String str = "";
                    if (!TextUtils.isEmpty(com.xiaomi.push.i.c(MiPushClient.sContext))) {
                        str = "" + bo.a(c);
                    }
                    String e = com.xiaomi.push.i.e(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(e)) {
                        str = str + "," + e;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        igVar.m646a().put(Constants.EXTRA_KEY_IMEI_MD5, str);
                    }
                    az.a(MiPushClient.sContext).a(igVar.m646a());
                    int a = com.xiaomi.push.i.a();
                    if (a >= 0) {
                        igVar.m646a().put("space_id", Integer.toString(a));
                    }
                    ao.a(MiPushClient.sContext).a((ao) igVar, hh.Notification, false, (hu) null);
                }
            }
        }).start();
    }
}
