package com.yy.hiidostatis.api;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.widget.Toast;
import com.heytap.mcssdk.constant.a;
import com.kuaishou.weapon.p0.h;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.defs.ConfigAPI;
import com.yy.hiidostatis.defs.StatisAPI;
import com.yy.hiidostatis.defs.controller.ActivityLifecycleController;
import com.yy.hiidostatis.defs.controller.BasicBehaviorController;
import com.yy.hiidostatis.defs.controller.BindTestPhoneController;
import com.yy.hiidostatis.defs.controller.CrashController;
import com.yy.hiidostatis.defs.controller.DeviceController;
import com.yy.hiidostatis.defs.controller.InstallController;
import com.yy.hiidostatis.defs.controller.OaidController;
import com.yy.hiidostatis.defs.controller.OnLineConfigController;
import com.yy.hiidostatis.defs.controller.PageStateController;
import com.yy.hiidostatis.defs.controller.SdkAnalyzeController;
import com.yy.hiidostatis.defs.controller.SdkVerController;
import com.yy.hiidostatis.defs.controller.SensorController;
import com.yy.hiidostatis.defs.handler.MetricsHandler;
import com.yy.hiidostatis.defs.listener.ActListener;
import com.yy.hiidostatis.defs.listener.HiidoSdkAdditionDelegate;
import com.yy.hiidostatis.defs.monitor.ScreenMonitor;
import com.yy.hiidostatis.defs.monitor.TrafficMonitor;
import com.yy.hiidostatis.defs.obj.Property;
import com.yy.hiidostatis.defs.obj.ShareType;
import com.yy.hiidostatis.inner.AppInfo;
import com.yy.hiidostatis.inner.GeneralProxy;
import com.yy.hiidostatis.inner.implementation.CommonFiller;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.Counter;
import com.yy.hiidostatis.inner.util.DefaultPreference;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.inner.util.hdid.DeviceProxy;
import com.yy.hiidostatis.inner.util.log.ActLog;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.message.module.sessionreport.CalAction;
import com.yy.hiidostatis.message.module.sessionreport.EventValue;
import com.yy.hiidostatis.pref.HdStatisConfig;
import com.yy.hiidostatis.testui.FloatingService;
import com.yy.hiidostatis.track.DataTrack;
import com.yy.hiidostatis.track.HStaticApi;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class HiidoSDKOld implements HiidoApi {
    public static final String DEFAULT_METRICS_NAME = "DEFAULT_METRICS";
    public static final int INTERVAL_HEART_BEAT = 900000;
    public static final String SDK_METRICS_NAME = "SDK_METRICS";
    public static final int SDK_METRICS_TIMER_INTERVAL = 900;
    public static final int STATE_INVALID = -1;
    public static final int STATE_QUITED = 2;
    public static final int STATE_STARTED = 1;
    public static BasicBehaviorController mBasicBehaviorController;
    public static ConfigAPI mConfigApi;
    public static DeviceController mDeviceController;
    public static InstallController mInstallController;
    public static OnLineConfigController mOnLineConfigController;
    public static SdkAnalyzeController mSdkAnalyzeController;
    public static SdkVerController mSdkVerController;
    public boolean isAppRunning;
    public volatile Context mContext;
    public CrashController mCrashController;
    public volatile Counter.Callback mHeartbeatReportExecutor;
    public volatile Counter.Callback mHeartbeatReportExecutorShort;
    public MetricsHandler metricsHandler;
    public PageStateController pageStateController;
    public SensorController sensorController;
    public static OnStatisListener nullListener = new OnStatisListener() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.1
        @Override // com.yy.hiidostatis.defs.interf.IOnStatisListener
        public long getCurrentUid() {
            return 0L;
        }
    };
    public static volatile boolean isResumeCall = false;
    public static StatisAPI mStatisAPI = new StatisAPI();
    public static volatile boolean mIsInit = false;
    public int mState = -1;
    public boolean appRunIsCalled = false;
    public volatile StatisOption mStatisOption = new StatisOption();
    public final Handler mHandler = new Handler(Looper.getMainLooper());
    public final Counter mHeartbeatInvoker = new Counter(this.mHandler, 0, a.h, true);
    public final Counter mHeartbeatInvokerShort = new Counter(this.mHandler, 0, 60000, true);
    public volatile OnStatisListener mOnStatisListener = nullListener;
    public volatile QuitTimer mQuittimer = new QuitTimer();
    public Map<String, String> mDoShortProp = new HashMap();
    public volatile boolean userAgreed = true;
    public ActivityLifecycleController mActivityLifecycleController = new ActivityLifecycleController();
    public boolean isFrontground = false;

    /* loaded from: classes9.dex */
    public interface HdidReceiver {
        void onHdidReceived(String str);
    }

    /* renamed from: com.yy.hiidostatis.api.HiidoSDKOld$41  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass41 implements Runnable {
        public AnonymousClass41() {
        }

        @Override // java.lang.Runnable
        public void run() {
            L.debug(this, "isOpenCrashMonitor is %b", Boolean.valueOf(HiidoSDK.instance().getOptions().isOpenCrashMonitor));
            if (HiidoSDK.instance().getOptions().isOpenCrashMonitor) {
                if (HiidoSDKOld.this.mCrashController != null) {
                    L.warn(this, "crash monitor has been started.", new Object[0]);
                    return;
                }
                HiidoSDKOld hiidoSDKOld = HiidoSDKOld.this;
                hiidoSDKOld.mCrashController = new CrashController(hiidoSDKOld.getContext(), HiidoSDKOld.mStatisAPI, HiidoSDKOld.this.mOnStatisListener, new CrashController.OnCrashListener() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.41.1
                    @Override // com.yy.hiidostatis.defs.controller.CrashController.OnCrashListener
                    public void handler(JSONObject jSONObject) {
                        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.41.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HiidoSDKOld.this.quitApp(false);
                            }
                        });
                    }
                });
                HiidoSDKOld.this.mCrashController.startCrashMonitor();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class QuitTimer {
        public final Runnable mQuitTimer;

        public QuitTimer() {
            this.mQuitTimer = new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.QuitTimer.1
                @Override // java.lang.Runnable
                public void run() {
                    HiidoSDKOld.this.quitApp(true);
                }
            };
        }

        public void clearQuitTimer() {
            HiidoSDKOld.this.mHandler.removeCallbacks(this.mQuitTimer);
        }

        public void startQuitTimer() {
            HiidoSDKOld.this.mHandler.postDelayed(this.mQuitTimer, HiidoSDK.instance().getOptions().backgroundDurationMillisAsQuit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void appInitRun() {
        if (this.isFrontground && (this.mState == 2 || this.mState == -1)) {
            reportOnAppStartLaunch(this.mContext, this.mOnStatisListener);
            BasicBehaviorController.AppActionReporter appActionReporter = getAppActionReporter();
            this.metricsHandler.onForeground();
            if (appActionReporter != null) {
                appActionReporter.onAppStarted();
            }
            this.mState = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSDKInit() {
        if (!mIsInit) {
            L.warn(this, "The SDK is NOT init", new Object[0]);
        }
        return mIsInit;
    }

    private BasicBehaviorController.AppActionReporter getAppActionReporter() {
        BasicBehaviorController behaviorCollector = getBehaviorCollector(getCtx(this.mContext));
        if (behaviorCollector == null) {
            return null;
        }
        return behaviorCollector.getAppActionCollector();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BasicBehaviorController.PageActionReporter getPageActionReporter() {
        BasicBehaviorController behaviorCollector = getBehaviorCollector(getCtx(this.mContext));
        if (behaviorCollector == null) {
            return null;
        }
        return behaviorCollector.getPageActionCollector();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean imeiPrepared() {
        if (HiidoSDK.instance().getOptions().isUseOaid() && Build.VERSION.SDK_INT <= 28 && !this.appRunIsCalled && !ArdUtil.checkPermissions(this.mContext, h.c)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void oaidInitFinish() {
        if (imeiPrepared()) {
            ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.11
                @Override // java.lang.Runnable
                public void run() {
                    HiidoSDKOld.this.appInitRun();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oaidPrepared() {
        if (HiidoSDK.instance().getOptions().isUseOaid() && !OaidController.ignore(this.mContext) && !OaidController.INSTANCE.isLoaded()) {
            return false;
        }
        return true;
    }

    private BasicBehaviorController.AppActionReporter peekAppaActionReporter() {
        BasicBehaviorController.AppActionReporter appActionCollector;
        BasicBehaviorController basicBehaviorController = mBasicBehaviorController;
        if (basicBehaviorController != null) {
            return basicBehaviorController.getAppActionCollector();
        }
        synchronized (this) {
            BasicBehaviorController basicBehaviorController2 = mBasicBehaviorController;
            if (basicBehaviorController2 == null) {
                appActionCollector = null;
            } else {
                appActionCollector = basicBehaviorController2.getAppActionCollector();
            }
        }
        return appActionCollector;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCrashMonitor() {
        ThreadPool.getPool().executeQueue(new AnonymousClass41());
    }

    private void startHeartbeatReport() {
        if (this.mHeartbeatReportExecutor != null) {
            L.warn(this, "heart beat as for mbsdkdo has been started.", new Object[0]);
            return;
        }
        Counter.Callback callback = new Counter.Callback() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.37
            @Override // com.yy.hiidostatis.inner.util.Counter.Callback
            public void onCount(int i) {
                long currentUid = HiidoSDKOld.this.mOnStatisListener.getCurrentUid();
                HiidoSDKOld hiidoSDKOld = HiidoSDKOld.this;
                hiidoSDKOld.reportDo(hiidoSDKOld.mContext, currentUid);
            }
        };
        this.mHeartbeatReportExecutor = callback;
        this.mHeartbeatInvoker.setCallback(callback);
        Counter counter = this.mHeartbeatInvoker;
        counter.start(counter.getInterval());
        L.debug(this, "start heart beat invoker for mbsdkdo.", new Object[0]);
    }

    private void startHeartbeatReportShort() {
        if (this.mHeartbeatReportExecutorShort != null) {
            L.warn(this, "heart beat as for mbsdkdo short has been started.", new Object[0]);
            return;
        }
        Counter.Callback callback = new Counter.Callback() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.38
            @Override // com.yy.hiidostatis.inner.util.Counter.Callback
            public void onCount(int i) {
                long currentUid = HiidoSDKOld.this.mOnStatisListener.getCurrentUid();
                HiidoSDKOld hiidoSDKOld = HiidoSDKOld.this;
                hiidoSDKOld.reportDoShort(hiidoSDKOld.mContext, currentUid);
                HiidoSDKOld hiidoSDKOld2 = HiidoSDKOld.this;
                hiidoSDKOld2.flushCache(hiidoSDKOld2.mContext);
                DataTrack.instance.triggerTrack(false);
            }
        };
        this.mHeartbeatReportExecutorShort = callback;
        this.mHeartbeatInvokerShort.setCallback(callback);
        Counter counter = this.mHeartbeatInvokerShort;
        counter.start(counter.getInterval());
        L.debug(this, "start heart beat invoker for mbsdkdo short.", new Object[0]);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public synchronized void appRun() {
        this.appRunIsCalled = true;
        if (oaidPrepared()) {
            ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.10
                @Override // java.lang.Runnable
                public void run() {
                    HiidoSDKOld.this.appInitRun();
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public StatisAPI createNewStatisApi() {
        StatisAPI statisAPI = new StatisAPI();
        statisAPI.setAbroad(HiidoSDK.instance().getOptions().isAbroad);
        statisAPI.setTestServer(HiidoSDK.instance().getOptions().testServer);
        statisAPI.setBusinessType(HiidoSDK.instance().getOptions().businessType);
        return statisAPI;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getAppId() {
        return this.mStatisOption.getAppId();
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getAppKey() {
        return this.mStatisOption.getAppkey();
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getFrom() {
        return this.mStatisOption.getFrom();
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public OnStatisListener getOnStatisListener() {
        return this.mOnStatisListener;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public StatisOption getStatisOption() {
        return this.mStatisOption;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flushCache(Context context) {
        if (new Random().nextInt(2) % 2 == 0) {
            if (context != null) {
                GeneralProxy.flushCache(context);
            }
            CrashController crashController = this.mCrashController;
            if (crashController != null) {
                crashController.flushCache();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getCtx(Context context) {
        if (context == null) {
            return this.mContext;
        }
        return context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPageId(Activity activity) {
        if (activity != null) {
            return activity.getClass().getName();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportUrlScheme(final Uri uri) {
        if (uri == null) {
            return;
        }
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.7
            @Override // java.lang.Runnable
            public void run() {
                if (!HiidoSDKOld.this.checkSDKInit()) {
                    return;
                }
                try {
                    String scheme = uri.getScheme();
                    String host = uri.getHost();
                    int port = uri.getPort();
                    String path = uri.getPath();
                    String query = uri.getQuery();
                    L.debug(this, "URL SCHEME:%s://%s:%d/%s?%s", scheme, host, Integer.valueOf(port), path, query);
                    HiidoSDKOld.mStatisAPI.reportUrlScheme(scheme, host, port, path, query);
                } catch (Throwable th) {
                    L.debug(this, th.getMessage(), new Object[0]);
                }
            }
        });
    }

    private void resetHeartbeatReportShort(long j) {
        try {
            if (this.mHeartbeatInvokerShort != null && this.mHeartbeatInvokerShort.running()) {
                this.mHeartbeatInvokerShort.stop();
                this.mHeartbeatInvokerShort.start(j);
            }
        } catch (Throwable th) {
            L.debug(this, "resetHeartbeatReportShort exception = %s", th);
        }
    }

    private void sendInstallationReportIfNotYet(Context context) {
        Context ctx = getCtx(context);
        if (ctx != null && mInstallController != null) {
            if (!checkSDKInit()) {
                return;
            }
            mInstallController.sendInstallationReportIfNotYet(ctx);
            return;
        }
        L.error(this, "Input context is null,sdk is not init?", new Object[0]);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void addActAdditionListener(final ActListener actListener) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.42
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.mStatisAPI.addActAdditionListener(actListener);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    @Deprecated
    public void closeSession(String str) {
        L.debug(this, "session report need version after V4.0.0 ", new Object[0]);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getDeviceId(Context context) {
        return CommonFiller.getIMEI(context);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    @Deprecated
    public String getHdid(Context context) {
        return DeviceProxy.getHdid(context);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getMac(Context context) {
        return CommonFiller.getMacAddr(context);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onScreenMonitor(MotionEvent motionEvent) {
        ScreenMonitor.instance.onTouchEvent(motionEvent);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onScreenPause(final String str) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HiidoSDKOld.this.getPageActionReporter().onLeavingUI(str, null);
                } catch (Throwable th) {
                    L.debug(this, "onScreenPause exception =%s", th);
                }
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onScreenResume(final String str) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.12
            @Override // java.lang.Runnable
            public void run() {
                if (!HiidoSDKOld.this.checkSDKInit()) {
                    return;
                }
                try {
                    BasicBehaviorController.PageActionReporter pageActionReporter = HiidoSDKOld.this.getPageActionReporter();
                    long j = 0;
                    if (HiidoSDKOld.this.mOnStatisListener != null) {
                        j = HiidoSDKOld.this.mOnStatisListener.getCurrentUid();
                    }
                    if (pageActionReporter != null) {
                        pageActionReporter.onResumeUI(j, str);
                    }
                    ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                DefaultPreference.getPreference().setPrefString(HiidoSDKOld.this.mContext, HdStatisConfig.PREF_CPAGE, str);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                } catch (Throwable th) {
                    L.debug(this, "onScreenResume exception =%s", th);
                }
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean registerActivityLifecycleMonitor(Context context) {
        this.mActivityLifecycleController.registerActivityLifecycleCallbacks(context, new ActivityLifecycleController.ActivityLifecycleCallback() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.6
            @Override // com.yy.hiidostatis.defs.controller.ActivityLifecycleController.ActivityLifecycleCallback
            public void onActivityPaused(Activity activity) {
                HiidoSDKOld hiidoSDKOld = HiidoSDKOld.this;
                hiidoSDKOld.onPauseInner(hiidoSDKOld.getPageId(activity), HiidoSDK.PageActionReportOption.REPORT_ON_FUTURE_RESUME);
            }

            @Override // com.yy.hiidostatis.defs.controller.ActivityLifecycleController.ActivityLifecycleCallback
            public void onActivityResumed(Activity activity) {
                long j;
                OnStatisListener onStatisListener = HiidoSDKOld.this.getOnStatisListener();
                if (onStatisListener != null) {
                    j = onStatisListener.getCurrentUid();
                } else {
                    j = 0;
                }
                HiidoSDKOld hiidoSDKOld = HiidoSDKOld.this;
                hiidoSDKOld.onResumeInner(j, hiidoSDKOld.getPageId(activity));
            }
        });
        L.debug(this, "registerActivityLifecycleMonitor = %b", Boolean.valueOf(this.mActivityLifecycleController.isRegister()));
        return this.mActivityLifecycleController.isRegister();
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void removeActAdditionListerner(final ActListener actListener) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.44
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.mStatisAPI.removeActAdditionListener(actListener);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportAppsflyer(final String str) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.16
            @Override // java.lang.Runnable
            public void run() {
                long currentUid;
                HiidoSDKOld.mStatisAPI.reportAppsflyer(str);
                if (HiidoSDKOld.this.mState == 1) {
                    HiidoSDKOld hiidoSDKOld = HiidoSDKOld.this;
                    Context context = hiidoSDKOld.mContext;
                    if (HiidoSDKOld.this.mOnStatisListener == null) {
                        currentUid = 0;
                    } else {
                        currentUid = HiidoSDKOld.this.mOnStatisListener.getCurrentUid();
                    }
                    hiidoSDKOld.reportDo(context, currentUid);
                }
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportLogin(final long j) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.15
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.mStatisAPI.reportLogin(j);
                if (HiidoSDKOld.this.mState == 1) {
                    HiidoSDKOld.mStatisAPI.reportDo(j);
                }
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportPushToken(final String str) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.48
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.mStatisAPI.reportPushToken(HiidoSDKOld.this.mOnStatisListener.getCurrentUid(), str);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void setAdditionParamsDelegate(final HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.43
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.mStatisAPI.setAdditionParamsDelegate(hiidoSdkAdditionDelegate);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public synchronized void setBdCuid(String str) {
        HiidoSDK.instance().getOptions().setBdCuid(str);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void setCurPageParam(String str) {
        if (getPageActionReporter() != null) {
            getPageActionReporter().setCurPageParam(str);
        }
    }

    public HiidoApi setLogWriter(StatisLogWriter statisLogWriter) {
        L.setLogSetting(statisLogWriter);
        return this;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void setOnLineConfigListener(final OnLineConfigListener onLineConfigListener) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.40
            @Override // java.lang.Runnable
            public void run() {
                if (!HiidoSDKOld.this.checkSDKInit()) {
                    return;
                }
                HiidoSDKOld.mOnLineConfigController.setOnLineConfigListener(onLineConfigListener);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void updateOnlineConfigs(final Context context) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.39
            @Override // java.lang.Runnable
            public void run() {
                Context context2 = context;
                if (context2 == null) {
                    context2 = HiidoSDKOld.this.mContext;
                }
                if (context2 != null && HiidoSDKOld.mOnLineConfigController != null) {
                    HiidoSDKOld.mOnLineConfigController.updateOnlineConfigs(context2, HiidoSDKOld.this.getAppKey());
                } else {
                    L.warn(this, "updateOnlineConfigs error,Input context is null", new Object[0]);
                }
            }
        });
    }

    private void initMetricsHandler(String str, String str2) {
        MetricsHandler metricsHandler = new MetricsHandler(this.mContext, str, str2, HiidoSDK.instance().getOptions().getDefaultMetricsExpire());
        this.metricsHandler = metricsHandler;
        metricsHandler.addMetricsWorker("SDK_METRICS", 900L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPauseInner(final String str, final HiidoSDK.PageActionReportOption pageActionReportOption) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.9
            @Override // java.lang.Runnable
            public void run() {
                if (!HiidoSDKOld.this.checkSDKInit()) {
                    return;
                }
                if (HiidoSDK.instance().getOptions().getIgnoreActivity() != null && HiidoSDK.instance().getOptions().getIgnoreActivity().contains(str)) {
                    return;
                }
                try {
                    if (HiidoSDKOld.isResumeCall) {
                        if (pageActionReportOption == HiidoSDK.PageActionReportOption.DO_NOT_REPORT_ON_FUTURE_RESUME) {
                            L.info(this, " DO_NOT_REPORT_ON_FUTURE_RESUME,Clear current page element on page %s", str);
                            HiidoSDKOld.this.getPageActionReporter().clearCurPageElement();
                        } else {
                            HiidoSDKOld.this.getPageActionReporter().onLeavingUI(str, null);
                        }
                        L.verbose(this, "startQuitTimer in onPause", new Object[0]);
                        HiidoSDKOld.this.mQuittimer.startQuitTimer();
                        boolean unused = HiidoSDKOld.isResumeCall = false;
                        HiidoSDKOld.this.getBehaviorCollector(HiidoSDKOld.this.getCtx(HiidoSDKOld.this.mContext)).saveLastOnPauseTime(Util.wallTimeMillis());
                        return;
                    }
                    L.error(this, "call onPause() must call onResume() first", new Object[0]);
                } catch (Throwable th) {
                    L.debug(this, "onPause exception =%s", th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResumeInner(final long j, final String str) {
        this.isFrontground = true;
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.8
            @Override // java.lang.Runnable
            public void run() {
                long j2;
                if (!HiidoSDKOld.this.checkSDKInit()) {
                    return;
                }
                if (HiidoSDK.instance().getOptions().getIgnoreActivity() != null && HiidoSDK.instance().getOptions().getIgnoreActivity().contains(str)) {
                    return;
                }
                try {
                    L.verbose(this, "clearQuitTimer in onResume", new Object[0]);
                    HiidoSDKOld.this.mQuittimer.clearQuitTimer();
                    boolean unused = HiidoSDKOld.isResumeCall = true;
                    if (!HiidoSDKOld.this.imeiPrepared() || !HiidoSDKOld.this.oaidPrepared()) {
                        if (HiidoSDKOld.this.mState == 2 || HiidoSDKOld.this.mState == -1) {
                            HiidoSDKOld hiidoSDKOld = HiidoSDKOld.this;
                            Context context = HiidoSDKOld.this.mContext;
                            if (HiidoSDKOld.this.getOnStatisListener() != null) {
                                j2 = HiidoSDKOld.this.getOnStatisListener().getCurrentUid();
                            } else {
                                j2 = 0;
                            }
                            hiidoSDKOld.reportDo(context, j2);
                        }
                    } else {
                        HiidoSDKOld.this.appInitRun();
                    }
                    BasicBehaviorController.PageActionReporter pageActionReporter = HiidoSDKOld.this.getPageActionReporter();
                    if (pageActionReporter != null) {
                        pageActionReporter.onResumeUI(j, str);
                    }
                    DefaultPreference.getPreference().setPrefString(HiidoSDKOld.this.mContext, HdStatisConfig.PREF_CPAGE, str);
                } catch (Throwable th) {
                    L.debug(this, "onResume exception =%s", th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDo(Context context, long j) {
        try {
            mStatisAPI.reportDo(j);
            L.debug(this, "report heart beat for %d", Long.valueOf(j));
        } catch (Throwable th) {
            L.debug(this, "report heart beat for %d.exception=%s", Long.valueOf(j), th);
        }
    }

    private void reportRun(Context context, long j) {
        try {
            if (this.mState != -1 && this.mState != 2) {
                L.warn(this, "reportRun has been called, one launch only one call!", new Object[0]);
            }
            mStatisAPI.reportRun(j);
            L.debug(this, "reportRun call", new Object[0]);
        } catch (Throwable th) {
            L.debug(this, "reportRun exception=%s", th);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public MetricsWorker addMetricsWorker(String str, long j) {
        if (!checkSDKInit()) {
            return null;
        }
        return this.metricsHandler.addMetricsWorker(str, j);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    @Deprecated
    public boolean flushSession(String str, String str2) {
        L.debug(this, "session report need version after V4.0.0 ", new Object[0]);
        return false;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    @Deprecated
    public boolean flushSessionAll(String str, Set<String> set) {
        L.debug(this, "session report need version after V4.0.0 ", new Object[0]);
        return false;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void getHdid(final Context context, final HiidoSDK.HdidReceiver hdidReceiver) {
        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.45
            @Override // java.lang.Runnable
            public void run() {
                String hdid = DeviceProxy.getHdid(context);
                HiidoSDK.HdidReceiver hdidReceiver2 = hdidReceiver;
                if (hdidReceiver2 != null) {
                    hdidReceiver2.onHdidReceived(hdid);
                }
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getOnlineConfigParams(Context context, String str) {
        if (context == null) {
            context = this.mContext;
        }
        if (context == null) {
            L.warn(this, "getOnlineConfigParams error,Input context is null", new Object[0]);
            return null;
        } else if (!mIsInit) {
            L.warn(this, "getOnlineConfigParams error,not init sdk?", new Object[0]);
            return null;
        } else {
            return mOnLineConfigController.getOnlineConfigParams(context, str);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onPause(Activity activity, HiidoSDK.PageActionReportOption pageActionReportOption) {
        if (this.mActivityLifecycleController.isRegister()) {
            return;
        }
        onPause(getPageId(activity), pageActionReportOption);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onResume(long j, Activity activity) {
        if (this.mActivityLifecycleController.isRegister()) {
            return;
        }
        onResume(j, getPageId(activity));
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCrash(final long j, final String str) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.27
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.mStatisAPI.reportCrash(j, str);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContent(final String str, final StatisContent statisContent) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.22
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.mStatisAPI.reportStatisticContent(str, statisContent, true, true);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContentTemporary(final String str, final StatisContent statisContent) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.21
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.mStatisAPI.reportStatisticContentTemporary(str, statisContent, true, true);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportTimesEvent(final long j, final String str) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.29
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.this.reportTimesEvent(j, str, null);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCountEvent(final long j, final String str, final double d) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.32
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.this.reportCountEvent(j, str, d, null);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCustomContent(final long j, final String str, final String str2) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.26
            @Override // java.lang.Runnable
            public void run() {
                if (HiidoSDKOld.this.mContext == null) {
                    L.error(this, "Input context is null,sdk is not init?", new Object[0]);
                } else {
                    HiidoSDKOld.mStatisAPI.reportCustomContent(j, str, str2);
                }
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean reportFeedBack(final String str, final String str2, final String str3) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.46
            @Override // java.lang.Runnable
            public void run() {
                String str4;
                try {
                    str4 = Coder.encryptMD5(UUID.randomUUID().toString());
                } catch (Throwable th) {
                    L.debug(this, th.getMessage(), new Object[0]);
                    str4 = null;
                }
                HiidoSDKOld.mStatisAPI.reportFeedback(HiidoSDKOld.this.mOnStatisListener.getCurrentUid(), str4, str, str2, str3, null);
            }
        });
        return true;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportLocation(final double d, final double d2, final double d3) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.47
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.mStatisAPI.reportLocation(HiidoSDKOld.this.mOnStatisListener.getCurrentUid(), d, d2, d3, null);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContent(final String str, final StatisContent statisContent, final boolean z) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.23
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.mStatisAPI.reportStatisticContent(str, statisContent, true, true, z);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContentWithNoComm(final Context context, final String str, final StatisContent statisContent) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.24
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.mStatisAPI.reportStatisticContentWithNoComm(HiidoSDKOld.this.getCtx(context), str, statisContent);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportTimesEvent(final long j, final String str, final String str2) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.30
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.this.reportTimesEvent(j, str, str2, null);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    @Deprecated
    public void beginSession(String str, String str2, long j, Map<String, Long> map) {
        L.debug(this, "session report need version after V4.0.0 ", new Object[0]);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCount(int i, String str, String str2, long j) {
        if (!checkSDKInit()) {
            return;
        }
        if (!this.metricsHandler.containMetric("DEFAULT_METRICS")) {
            this.metricsHandler.addMetricsWorker("DEFAULT_METRICS", HiidoSDK.instance().getOptions().defaultMetricsInterval);
        }
        this.metricsHandler.reportCount("DEFAULT_METRICS", i, str, str2, j);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCountEvent(final long j, final String str, final double d, final String str2) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.33
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.this.reportCountEvent(j, str, d, str2, null);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportErrorEvent(final long j, final String str, final String str2, final String str3) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.20
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.mStatisAPI.reportError(j, str, str2, str3);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportReg(final String str, final String str2, final String str3, final Map<String, String> map) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.19
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.mStatisAPI.reportReg(str, str2, str3, map);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContentWithNoComm(final Context context, final String str, final StatisContent statisContent, final boolean z) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.25
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.mStatisAPI.reportStatisticContentWithNoComm(HiidoSDKOld.this.getCtx(context), str, statisContent, z);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportTimesEvent(final long j, final String str, final String str2, Property property) {
        Property copy;
        if (property == null) {
            copy = null;
        } else {
            copy = property.copy();
        }
        final Property property2 = copy;
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.31
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.mStatisAPI.reportTimesEvent(j, str, str2, property2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BasicBehaviorController getBehaviorCollector(Context context) {
        BasicBehaviorController basicBehaviorController;
        Context ctx = getCtx(context);
        if (ctx == null) {
            L.debug(this, "Input context is null when getBehaviorCollector", new Object[0]);
            return null;
        }
        BasicBehaviorController basicBehaviorController2 = mBasicBehaviorController;
        if (basicBehaviorController2 != null) {
            return basicBehaviorController2;
        }
        synchronized (this) {
            basicBehaviorController = mBasicBehaviorController;
            if (basicBehaviorController == null) {
                L.brief("mOnStatisListener is %s", this.mOnStatisListener);
                BasicBehaviorController basicBehaviorController3 = new BasicBehaviorController(ctx, this.mHandler, this.mOnStatisListener, mStatisAPI, HiidoSDK.instance().getOptions().backgroundDurationMillisAsQuit, HiidoSDK.instance().getOptions().behaviorSendThreshold, 10);
                mBasicBehaviorController = basicBehaviorController3;
                basicBehaviorController = basicBehaviorController3;
            }
        }
        return basicBehaviorController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void quitApp(boolean z) {
        long currentUid;
        try {
            if (this.mState == 1) {
                BasicBehaviorController.PageActionReporter pageActionReporter = getPageActionReporter();
                if (pageActionReporter != null) {
                    if (!z) {
                        pageActionReporter.onLeavingUI(null, null);
                        isResumeCall = false;
                    }
                    if (this.mOnStatisListener == null) {
                        currentUid = 0;
                    } else {
                        currentUid = this.mOnStatisListener.getCurrentUid();
                    }
                    pageActionReporter.onFinishGotoUI(currentUid, null, true);
                }
                this.metricsHandler.onExit();
                onQuitApp(z);
                this.mState = 2;
                L.info(this, "app quit. it is one appa finish. isNormal quit is [%b]。", Boolean.valueOf(z));
            }
        } catch (Throwable th) {
            L.debug(this, "quitApp exception =%s", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData(Context context, StatisOption statisOption, OnStatisListener onStatisListener) {
        mStatisAPI.setTestServer(HiidoSDK.instance().getOptions().testServer);
        mStatisAPI.setAbroad(HiidoSDK.instance().getOptions().isAbroad);
        mStatisAPI.setBusinessType(HiidoSDK.instance().getOptions().businessType);
        mStatisAPI.init(this.mContext, this.mStatisOption);
        mConfigApi = new ConfigAPI(this.mContext, this.mStatisOption.getAppkey());
        if (HiidoSDK.instance().getOptions().isAbroad) {
            HStaticApi.instante.init(this.mContext, this.mStatisOption, HiidoSDK.instance().getOptions().testServer);
        }
        DataTrack.instance.init(this.mContext, this.mStatisOption, new DataTrack.IDataTrackListener() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.4
            @Override // com.yy.hiidostatis.track.DataTrack.IDataTrackListener
            public JSONObject getConfig(String str, long j, String str2) {
                return HiidoSDKOld.mConfigApi.getDeviceConfig(HiidoSDKOld.this.mContext, str, str2, j, true);
            }
        });
        mSdkAnalyzeController = new SdkAnalyzeController(mStatisAPI, mConfigApi);
        mSdkVerController = new SdkVerController(mConfigApi);
        mInstallController = new InstallController(mStatisAPI);
        mDeviceController = new DeviceController(mStatisAPI, context);
        mOnLineConfigController = new OnLineConfigController(mConfigApi);
    }

    private void onQuitApp(boolean z) {
        if (this.mContext == null) {
            L.error(this, "No context, cannot do quit things properly, data lost.", new Object[0]);
            return;
        }
        Counter counter = this.mHeartbeatInvoker;
        Counter counter2 = this.mHeartbeatInvokerShort;
        if (counter != null) {
            counter.stop();
        }
        if (counter2 != null) {
            counter2.stop();
        }
        this.mHeartbeatReportExecutor = null;
        this.mHeartbeatReportExecutorShort = null;
        TrafficMonitor.instance.end();
        BasicBehaviorController.AppActionReporter peekAppaActionReporter = peekAppaActionReporter();
        if (peekAppaActionReporter != null) {
            peekAppaActionReporter.onExitApp(false, z);
        } else {
            L.debug(this, "No behavior reporter to report app action, sdk not initialized.", new Object[0]);
        }
        mStatisAPI.exit();
        GeneralProxy.exit(getContext(), z);
        if (z) {
            if (getContext() != null) {
                GeneralProxy.startTimer(getContext(), 1800000L);
            }
            ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.14
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    DataTrack.instance.triggerTrack(true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDoShort(Context context, long j) {
        try {
            if (this.mDoShortProp.size() == 0) {
                L.brief("report heart beat short for %d do nothing , mDoShortProp size  = 0", Long.valueOf(j));
                return;
            }
            mStatisAPI.reportDoShort(j, this.mDoShortProp);
            L.debug(this, "report heart beat short for %d", Long.valueOf(j));
        } catch (Throwable th) {
            L.debug(this, "report heart beat short for %d.exception=%s", Long.valueOf(j), th);
        }
    }

    private void reportOnAppStartLaunch(Context context, OnStatisListener onStatisListener) {
        try {
            TrafficMonitor.instance.init(this.mContext);
            TrafficMonitor.instance.start();
            ScreenMonitor.instance.reset();
            mSdkVerController.startSdkVerCheck(context);
            mStatisAPI.generateSession();
            getAppActionReporter().onStartApp();
            sendInstallationReportIfNotYet(context);
            reportDo(context, onStatisListener.getCurrentUid());
            reportRun(context, onStatisListener.getCurrentUid());
            mDeviceController.reportDeviceOnLaunch(context, onStatisListener.getCurrentUid());
            this.sensorController.reset(context);
            mSdkAnalyzeController.reportSdkAnalyze(context, onStatisListener.getCurrentUid());
            startHeartbeatReport();
            if (HiidoSDK.instance().getOptions().isOpenDoShort) {
                reportDoShort(context, onStatisListener.getCurrentUid());
                startHeartbeatReportShort();
            }
            GeneralProxy.start(context);
            GeneralProxy.stopTimer(context);
            DataTrack.instance.triggerTrack(true);
            ActLog.uploadLog(this.mContext, new ActLog.ILogConfigListener() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.5
                @Override // com.yy.hiidostatis.inner.util.log.ActLog.ILogConfigListener
                public JSONObject getLogConfig() {
                    return HiidoSDKOld.mConfigApi.getAppListConfig(HiidoSDKOld.this.mContext, true);
                }
            });
        } catch (Throwable th) {
            L.debug(this, "reportOnAppStartLaunch exception =%s", th);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void setHeartbeatField(String str, String str2) {
        String str3 = this.mDoShortProp.get("sid");
        String str4 = this.mDoShortProp.get("subsid");
        String str5 = this.mDoShortProp.get("auid");
        if (str2 == null) {
            this.mDoShortProp.remove(str);
        } else {
            this.mDoShortProp.put(str, str2);
        }
        boolean z = false;
        boolean z2 = true;
        if ("sid".equals(str) && ((str2 != null && !str2.equals(str3)) || (str3 != null && !str3.equals(str2)))) {
            z = true;
        }
        if ("subsid".equals(str) && ((str2 != null && !str2.equals(str4)) || (str4 != null && !str4.equals(str2)))) {
            z = true;
        }
        if (!"auid".equals(str) || ((str2 == null || str2.equals(str5)) && (str5 == null || str5.equals(str2)))) {
            z2 = z;
        }
        if (z2) {
            resetHeartbeatReportShort(1000L);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void appStartLaunchWithAppKey(final Context context, final StatisOption statisOption, final OnStatisListener onStatisListener) {
        Context applicationContext;
        Context context2;
        if (mIsInit) {
            L.warn(this, "sdk only be init once", new Object[0]);
            return;
        }
        AppInfo.INSTANCE.init(context);
        L.initLogConfig(context);
        this.sensorController = new SensorController(context, HiidoSDK.instance().getOptions().gyroscopeThreshold, HiidoSDK.instance().getOptions().accelerometerThreshold, HiidoSDK.instance().getOptions().lightThreshold, HiidoSDK.instance().getOptions().isOpenSensorMonitor());
        FloatingService.INSTANCT.setFilterAppkey(statisOption.getAppkey());
        if (context instanceof Application) {
            applicationContext = context;
        } else {
            applicationContext = context.getApplicationContext();
        }
        Application application = (Application) applicationContext;
        if (context == null) {
            context2 = this.mContext;
        } else {
            context2 = application;
        }
        this.mContext = context2;
        this.pageStateController = new PageStateController(mStatisAPI, context, onStatisListener);
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (FloatingService.INSTANCT.isDebug() && !FloatingService.INSTANCT.isInit()) {
                    FloatingService.INSTANCT.showFloatingWindow(activity);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                final String name = activity.getClass().getName();
                final Context applicationContext2 = activity.getApplicationContext();
                ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (HiidoSDKOld.this.pageStateController.onStop(name)) {
                            HiidoSDKOld.this.metricsHandler.onBackground();
                            HiidoSDKOld.this.sensorController.onStop(applicationContext2);
                        }
                    }
                });
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                final String name = activity.getClass().getName();
                ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HiidoSDKOld.this.pageStateController.onStart(name);
                        HiidoSDKOld.this.sensorController.onStart(context);
                    }
                });
                if (activity.getIntent() != null) {
                    try {
                        HiidoSDKOld.this.reportUrlScheme(activity.getIntent().getData());
                    } catch (Throwable th) {
                        L.debug(this, th.getMessage(), new Object[0]);
                    }
                    try {
                        Uri data = activity.getIntent().getData();
                        if (data != null && data.getScheme().toLowerCase().startsWith("hiidodct.")) {
                            BindTestPhoneController.bind(data.toString(), activity.getApplicationContext());
                            Toast.makeText(activity.getApplicationContext(), "可以测试了", 1).show();
                        }
                    } catch (Throwable th2) {
                        L.debug(this, th2.getMessage(), new Object[0]);
                    }
                }
            }
        });
        if (onStatisListener == null) {
            L.brief("the Input listener is null ,so get the default listener instead", new Object[0]);
            this.mOnStatisListener = nullListener;
        } else {
            this.mOnStatisListener = onStatisListener;
        }
        if (statisOption == null) {
            L.brief("the Input sOption is null ,so get the default sOption instead", new Object[0]);
        } else {
            this.mStatisOption = statisOption;
        }
        if (Util.empty(this.mStatisOption.getAppkey())) {
            this.mStatisOption.setAppkey(ArdUtil.getMetaDataParam(this.mContext, HdStatisConfig.META_DATA_KEY_APP_KEY));
        }
        if (Util.empty(this.mStatisOption.getFrom())) {
            this.mStatisOption.setFrom(ArdUtil.getMetaDataParam(this.mContext, HdStatisConfig.META_DATA_KEY_CHANNEL));
        }
        if (Util.empty(this.mStatisOption.getVer())) {
            this.mStatisOption.setVer(ArdUtil.getVersionName(this.mContext));
        }
        HdStatisConfig.getConfig(this.mStatisOption.getAppkey());
        initMetricsHandler(getStatisOption().getAppkey(), getStatisOption().getVer());
        mIsInit = true;
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.3
            @Override // java.lang.Runnable
            public void run() {
                if (HiidoSDK.instance().getOptions().isUseOaid()) {
                    OaidController.loadLib(context.getApplicationContext());
                    OaidController.INSTANCE.initOaidAsyn(context, new OaidController.OaidInitListener() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.3.1
                        @Override // com.yy.hiidostatis.defs.controller.OaidController.OaidInitListener
                        public void initFinish(boolean z, String str, String str2) {
                            HiidoSDKOld.this.oaidInitFinish();
                        }
                    });
                }
                HiidoSDKOld.this.initData(context, statisOption, onStatisListener);
                HiidoSDKOld.this.startCrashMonitor();
                L.infoOn(this, "init hiido isLogOn " + HiidoSDK.instance().getOptions().isLogOn, new Object[0]);
                L.debug(this, "testServer = %s", HiidoSDK.instance().getOptions().testServer);
                L.debug(this, "isAbroad = %b", Boolean.valueOf(HiidoSDK.instance().getOptions().isAbroad));
                L.debug(this, "isLogOn = %b", Boolean.valueOf(HiidoSDK.instance().getOptions().isLogOn));
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onPause(String str, HiidoSDK.PageActionReportOption pageActionReportOption) {
        if (this.mActivityLifecycleController.isRegister()) {
            return;
        }
        onPauseInner(str, pageActionReportOption);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onResume(long j, String str) {
        if (this.mActivityLifecycleController.isRegister()) {
            return;
        }
        onResumeInner(j, str);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCrash(final long j, final Throwable th) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.28
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.mStatisAPI.reportCrash(j, th);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    @Deprecated
    public boolean pushToSession(String str, String str2, CalAction calAction, String str3, Number number, Map<String, String> map, Map<String, String> map2) {
        L.debug(this, "session report need version after V4.0.0 ", new Object[0]);
        return false;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportShare(final String str, final int i, final String str2, final ShareType shareType, final String str3, final String str4, final String str5) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.17
            @Override // java.lang.Runnable
            public void run() {
                if (HiidoSDKOld.this.checkSDKInit()) {
                    HiidoSDKOld.mStatisAPI.reportShare(str, i, str2, shareType, str3, str4, str5);
                }
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    @Deprecated
    public boolean pushToSession(String str, String str2, List<EventValue> list, Map<String, String> map, Map<String, String> map2) {
        L.debug(this, "session report need version after V4.0.0 ", new Object[0]);
        return false;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCount(int i, String str, String str2, long j, int i2) {
        if (!checkSDKInit()) {
            return;
        }
        if (!this.metricsHandler.containMetric("DEFAULT_METRICS")) {
            this.metricsHandler.addMetricsWorker("DEFAULT_METRICS", HiidoSDK.instance().getOptions().defaultMetricsInterval);
        }
        this.metricsHandler.reportCount("DEFAULT_METRICS", i, str, str2, j, i2);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCountEvent(final long j, final String str, final double d, final String str2, Property property) {
        Property copy;
        if (property == null) {
            copy = null;
        } else {
            copy = property.copy();
        }
        final Property property2 = copy;
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.34
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKOld.mStatisAPI.reportCountEvent(j, str, d, str2, property2);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportReturnCode(int i, String str, long j, String str2, Map<String, String> map) {
        if (!checkSDKInit()) {
            return;
        }
        if (!this.metricsHandler.containMetric("DEFAULT_METRICS")) {
            this.metricsHandler.addMetricsWorker("DEFAULT_METRICS", HiidoSDK.instance().getOptions().defaultMetricsInterval);
        }
        this.metricsHandler.reportReturnCode("DEFAULT_METRICS", i, str, j, str2, map);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportSrcData(int i, String str, String str2, long j, Map<String, String> map) {
        if (!checkSDKInit()) {
            return;
        }
        if (!this.metricsHandler.containMetric("DEFAULT_METRICS")) {
            this.metricsHandler.addMetricsWorker("DEFAULT_METRICS", HiidoSDK.instance().getOptions().defaultMetricsInterval);
        }
        this.metricsHandler.reportSrcData("DEFAULT_METRICS", i, str, str2, j, map);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportSuccess(final long j, final String str, final String str2, final long j2, final String str3) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.35
            @Override // java.lang.Runnable
            public void run() {
                if (HiidoSDKOld.this.mContext == null) {
                    L.error(this, "Input context is null,sdk is not init?", new Object[0]);
                } else {
                    HiidoSDKOld.mStatisAPI.reportSuccess(j, str, str2, j2, str3);
                }
            }
        });
    }

    public void reportCount(String str, int i, String str2, String str3, long j) {
        if (!checkSDKInit()) {
            return;
        }
        this.metricsHandler.reportCount(str, i, str2, str3, j);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCount(String str, int i, String str2, String str3, long j, int i2) {
        if (!checkSDKInit()) {
            return;
        }
        this.metricsHandler.reportCount(str, i, str2, str3, j, i2);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportFailure(final long j, final String str, final String str2, final String str3, final String str4, final String str5) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.36
            @Override // java.lang.Runnable
            public void run() {
                if (HiidoSDKOld.this.mContext == null) {
                    L.error(this, "Input context is null,sdk is not init?", new Object[0]);
                } else {
                    HiidoSDKOld.mStatisAPI.reportFailure(j, str, str2, str3, str4, str5);
                }
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportReturnCode(String str, int i, String str2, long j, String str3, Map<String, String> map) {
        if (!checkSDKInit()) {
            return;
        }
        this.metricsHandler.reportReturnCode(str, i, str2, j, str3, map);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportSrcData(String str, int i, String str2, String str3, long j, Map<String, String> map) {
        if (!checkSDKInit()) {
            return;
        }
        this.metricsHandler.reportSrcData(str, i, str2, str3, j, map);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportIM(final String str, final String str2, final String str3, final Date date, final Date date2, final String str4, final int i, final String str5) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKOld.18
            @Override // java.lang.Runnable
            public void run() {
                if (HiidoSDKOld.this.checkSDKInit()) {
                    HiidoSDKOld.mStatisAPI.reportIM(str, str2, str3, date, date2, str4, i, str5);
                }
            }
        });
    }
}
