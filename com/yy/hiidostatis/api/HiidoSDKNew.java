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
import com.yy.hiidostatis.defs.StatisAPINew;
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
import com.yy.hiidostatis.message.AppInfo;
import com.yy.hiidostatis.message.SessionReportWrapper;
import com.yy.hiidostatis.message.log.TraceLog;
import com.yy.hiidostatis.message.module.sessionreport.CalAction;
import com.yy.hiidostatis.message.module.sessionreport.EventValue;
import com.yy.hiidostatis.message.utils.KVIO;
import com.yy.hiidostatis.pref.HdStatisConfig;
import com.yy.hiidostatis.provider.DefaultProviderLoader;
import com.yy.hiidostatis.provider.GlobalProvider;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.MessageConfigFactory;
import com.yy.hiidostatis.testui.FloatingService;
import com.yy.hiidostatis.track.DataTrack;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class HiidoSDKNew implements HiidoApi {
    public static final String DEFAULT_METRICS_NAME = "DEFAULT_METRICS";
    public static final int INTERVAL_HEART_BEAT = 900000;
    public static final String SDK_METRICS_NAME = "SDK_METRICS";
    public static final int SDK_METRICS_TIMER_INTERVAL = 900;
    public static final int STATE_INVALID = -1;
    public static final int STATE_QUITED = 2;
    public static final int STATE_STARTED = 1;
    public static ConfigAPI mConfigApi;
    public static OnLineConfigController mOnLineConfigController;
    public boolean isAppRunning;
    public boolean isFrontground;
    public BasicBehaviorController mBasicBehaviorController;
    public volatile Context mContext;
    public CrashController mCrashController;
    public DeviceController mDeviceController;
    public volatile Counter.Callback mHeartbeatReportExecutor;
    public volatile Counter.Callback mHeartbeatReportExecutorShort;
    public InstallController mInstallController;
    public SdkAnalyzeController mSdkAnalyzeController;
    public SdkVerController mSdkVerController;
    public MetricsHandler metricsHandler;
    public PageStateController pageStateController;
    public SensorController sensorController;
    public SessionReportWrapper sessionReport;
    public static OnStatisListener nullListener = new OnStatisListener() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.1
        @Override // com.yy.hiidostatis.defs.interf.IOnStatisListener
        public long getCurrentUid() {
            return 0L;
        }
    };
    public static volatile boolean isResumeCall = false;
    public static volatile boolean mIsInit = false;
    public int mState = -1;
    public boolean appRunIsCalled = false;
    public volatile StatisOption mStatisOption = new StatisOption();
    public final Handler mHandler = new Handler(Looper.getMainLooper());
    public final Counter mHeartbeatInvoker = new Counter(this.mHandler, 0, a.h, true);
    public final Counter mHeartbeatInvokerShort = new Counter(this.mHandler, 0, 60000, true);
    public volatile OnStatisListener mOnStatisListener = nullListener;
    public volatile QuitTimer mQuittimer = new QuitTimer();
    public StatisAPINew mStatisAPI = null;
    public volatile MessageConfig config = null;
    public Map<String, String> mDoShortProp = new HashMap();
    public volatile boolean userAgreed = true;
    public ActivityLifecycleController mActivityLifecycleController = new ActivityLifecycleController();

    /* loaded from: classes8.dex */
    public interface HdidReceiver {
        void onHdidReceived(String str);
    }

    /* loaded from: classes8.dex */
    public class QuitTimer {
        public final Runnable mQuitTimer;

        public QuitTimer() {
            this.mQuitTimer = new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.QuitTimer.1
                @Override // java.lang.Runnable
                public void run() {
                    HiidoSDKNew.this.quitApp(true);
                }
            };
        }

        public void clearQuitTimer() {
            HiidoSDKNew.this.mHandler.removeCallbacks(this.mQuitTimer);
        }

        public void startQuitTimer() {
            HiidoSDKNew.this.mHandler.postDelayed(this.mQuitTimer, HiidoSDK.instance().getOptions().backgroundDurationMillisAsQuit);
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
        if (HiidoSDK.instance().getOptions().isWaitGrant() && Build.VERSION.SDK_INT <= 28 && !this.appRunIsCalled && !ArdUtil.checkPermissions(this.mContext, h.c)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void oaidInitFinish() {
        if (imeiPrepared()) {
            ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.11
                @Override // java.lang.Runnable
                public void run() {
                    HiidoSDKNew.this.appInitRun();
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
        BasicBehaviorController basicBehaviorController = this.mBasicBehaviorController;
        if (basicBehaviorController != null) {
            return basicBehaviorController.getAppActionCollector();
        }
        synchronized (this) {
            BasicBehaviorController basicBehaviorController2 = this.mBasicBehaviorController;
            if (basicBehaviorController2 == null) {
                appActionCollector = null;
            } else {
                appActionCollector = basicBehaviorController2.getAppActionCollector();
            }
        }
        return appActionCollector;
    }

    private void startCrashMonitor() {
        if (this.config.isOpenCrashMonitor()) {
            if (this.mCrashController != null) {
                L.warn(this, "crash monitor has been started.", new Object[0]);
                return;
            }
            CrashController crashController = new CrashController(getContext(), this.mStatisAPI, this.mOnStatisListener, new CrashController.OnCrashListener() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.19
                @Override // com.yy.hiidostatis.defs.controller.CrashController.OnCrashListener
                public void handler(JSONObject jSONObject) {
                    ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.19.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HiidoSDKNew.this.quitApp(false);
                        }
                    });
                }
            });
            this.mCrashController = crashController;
            crashController.startCrashMonitor();
        }
    }

    private void startHeartbeatReport() {
        if (this.mHeartbeatReportExecutor != null) {
            L.warn(this, "heart beat as for mbsdkdo has been started.", new Object[0]);
            return;
        }
        Counter.Callback callback = new Counter.Callback() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.15
            @Override // com.yy.hiidostatis.inner.util.Counter.Callback
            public void onCount(int i) {
                long currentUid = HiidoSDKNew.this.mOnStatisListener.getCurrentUid();
                HiidoSDKNew hiidoSDKNew = HiidoSDKNew.this;
                hiidoSDKNew.reportDo(hiidoSDKNew.mContext, currentUid);
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
        Counter.Callback callback = new Counter.Callback() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.16
            @Override // com.yy.hiidostatis.inner.util.Counter.Callback
            public void onCount(int i) {
                long currentUid = HiidoSDKNew.this.mOnStatisListener.getCurrentUid();
                HiidoSDKNew hiidoSDKNew = HiidoSDKNew.this;
                hiidoSDKNew.reportDoShort(hiidoSDKNew.mContext, currentUid);
                HiidoSDKNew hiidoSDKNew2 = HiidoSDKNew.this;
                hiidoSDKNew2.flushCache(hiidoSDKNew2.mContext);
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
            ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.10
                @Override // java.lang.Runnable
                public void run() {
                    HiidoSDKNew.this.appInitRun();
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
        return this.config.getAppId();
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getAppKey() {
        return this.config.getAppkey();
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public Context getContext() {
        return this.config.getApplicationContext();
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getFrom() {
        return this.config.getFrom();
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
        if (ctx != null && this.mInstallController != null) {
            if (!checkSDKInit()) {
                return;
            }
            this.mInstallController.sendInstallationReportIfNotYet(ctx);
            return;
        }
        L.error(this, "Input context is null,sdk is not init?", new Object[0]);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void addActAdditionListener(ActListener actListener) {
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.addActAdditionListener(actListener);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void closeSession(String str) {
        this.sessionReport.closeSession(str);
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
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HiidoSDKNew.this.getPageActionReporter().onLeavingUI(str, null);
                } catch (Throwable th) {
                    L.debug(this, "onScreenPause exception =%s", th);
                }
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onScreenResume(final String str) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.12
            @Override // java.lang.Runnable
            public void run() {
                if (!HiidoSDKNew.this.checkSDKInit()) {
                    return;
                }
                try {
                    BasicBehaviorController.PageActionReporter pageActionReporter = HiidoSDKNew.this.getPageActionReporter();
                    long j = 0;
                    if (HiidoSDKNew.this.mOnStatisListener != null) {
                        j = HiidoSDKNew.this.mOnStatisListener.getCurrentUid();
                    }
                    if (pageActionReporter != null) {
                        pageActionReporter.onResumeUI(j, str);
                    }
                    ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                DefaultPreference.getPreference().setPrefString(HiidoSDKNew.this.mContext, HdStatisConfig.PREF_CPAGE, str);
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
        this.mActivityLifecycleController.registerActivityLifecycleCallbacks(context, new ActivityLifecycleController.ActivityLifecycleCallback() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.7
            @Override // com.yy.hiidostatis.defs.controller.ActivityLifecycleController.ActivityLifecycleCallback
            public void onActivityPaused(Activity activity) {
                HiidoSDKNew hiidoSDKNew = HiidoSDKNew.this;
                hiidoSDKNew.onPauseInner(hiidoSDKNew.getPageId(activity), HiidoSDK.PageActionReportOption.REPORT_ON_FUTURE_RESUME);
            }

            @Override // com.yy.hiidostatis.defs.controller.ActivityLifecycleController.ActivityLifecycleCallback
            public void onActivityResumed(Activity activity) {
                long j;
                OnStatisListener onStatisListener = HiidoSDKNew.this.getOnStatisListener();
                if (onStatisListener != null) {
                    j = onStatisListener.getCurrentUid();
                } else {
                    j = 0;
                }
                HiidoSDKNew hiidoSDKNew = HiidoSDKNew.this;
                hiidoSDKNew.onResumeInner(j, hiidoSDKNew.getPageId(activity));
            }
        });
        L.debug(this, "registerActivityLifecycleMonitor = %b", Boolean.valueOf(this.mActivityLifecycleController.isRegister()));
        return this.mActivityLifecycleController.isRegister();
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void removeActAdditionListerner(ActListener actListener) {
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.removeActAdditionListener(actListener);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportAppsflyer(String str) {
        long currentUid;
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.reportAppsflyer(str);
        if (this.mState == 1) {
            Context context = this.mContext;
            if (this.mOnStatisListener == null) {
                currentUid = 0;
            } else {
                currentUid = this.mOnStatisListener.getCurrentUid();
            }
            reportDo(context, currentUid);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportLogin(long j) {
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.reportLogin(j);
        if (this.mState == 1) {
            this.mStatisAPI.reportDo(j);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportPushToken(String str) {
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.reportPushToken(this.mOnStatisListener.getCurrentUid(), str);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void setAdditionParamsDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate) {
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.setAdditionParamsDelegate(hiidoSdkAdditionDelegate);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public synchronized void setBdCuid(String str) {
        this.config.setBdCuid(str);
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
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.18
            @Override // java.lang.Runnable
            public void run() {
                if (!HiidoSDKNew.this.checkSDKInit()) {
                    return;
                }
                HiidoSDKNew.mOnLineConfigController.setOnLineConfigListener(onLineConfigListener);
            }
        });
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void updateOnlineConfigs(final Context context) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.17
            @Override // java.lang.Runnable
            public void run() {
                Context context2 = context;
                if (context2 == null) {
                    context2 = HiidoSDKNew.this.mContext;
                }
                if (context2 != null && HiidoSDKNew.mOnLineConfigController != null) {
                    HiidoSDKNew.mOnLineConfigController.updateOnlineConfigs(context2, HiidoSDKNew.this.getAppKey());
                } else {
                    L.warn(this, "updateOnlineConfigs error,Input context is null", new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPauseInner(final String str, final HiidoSDK.PageActionReportOption pageActionReportOption) {
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.9
            @Override // java.lang.Runnable
            public void run() {
                if (!HiidoSDKNew.this.checkSDKInit()) {
                    return;
                }
                if (HiidoSDK.instance().getOptions().getIgnoreActivity() != null && HiidoSDK.instance().getOptions().getIgnoreActivity().contains(str)) {
                    return;
                }
                try {
                    if (HiidoSDKNew.isResumeCall) {
                        if (pageActionReportOption == HiidoSDK.PageActionReportOption.DO_NOT_REPORT_ON_FUTURE_RESUME) {
                            L.debug(this, " DO_NOT_REPORT_ON_FUTURE_RESUME,Clear current page element on page %s", str);
                            HiidoSDKNew.this.getPageActionReporter().clearCurPageElement();
                        } else {
                            HiidoSDKNew.this.getPageActionReporter().onLeavingUI(str, null);
                        }
                        L.verbose(this, "startQuitTimer in onPause", new Object[0]);
                        HiidoSDKNew.this.mQuittimer.startQuitTimer();
                        boolean unused = HiidoSDKNew.isResumeCall = false;
                        HiidoSDKNew.this.getBehaviorCollector(HiidoSDKNew.this.getCtx(HiidoSDKNew.this.mContext)).saveLastOnPauseTime(Util.wallTimeMillis());
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
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.8
            @Override // java.lang.Runnable
            public void run() {
                long j2;
                if (!HiidoSDKNew.this.checkSDKInit()) {
                    return;
                }
                if (HiidoSDK.instance().getOptions().getIgnoreActivity() != null && HiidoSDK.instance().getOptions().getIgnoreActivity().contains(str)) {
                    return;
                }
                try {
                    L.verbose(this, "clearQuitTimer in onResume", new Object[0]);
                    HiidoSDKNew.this.mQuittimer.clearQuitTimer();
                    boolean unused = HiidoSDKNew.isResumeCall = true;
                    if (!HiidoSDKNew.this.imeiPrepared() || !HiidoSDKNew.this.oaidPrepared()) {
                        if (HiidoSDKNew.this.mState == 2 || HiidoSDKNew.this.mState == -1) {
                            HiidoSDKNew hiidoSDKNew = HiidoSDKNew.this;
                            Context context = HiidoSDKNew.this.mContext;
                            if (HiidoSDKNew.this.getOnStatisListener() != null) {
                                j2 = HiidoSDKNew.this.getOnStatisListener().getCurrentUid();
                            } else {
                                j2 = 0;
                            }
                            hiidoSDKNew.reportDo(context, j2);
                        }
                    } else {
                        HiidoSDKNew.this.appInitRun();
                    }
                    BasicBehaviorController.PageActionReporter pageActionReporter = HiidoSDKNew.this.getPageActionReporter();
                    if (pageActionReporter != null) {
                        pageActionReporter.onResumeUI(j, str);
                    }
                    DefaultPreference.getPreference().setPrefString(HiidoSDKNew.this.mContext, HdStatisConfig.PREF_CPAGE, str);
                } catch (Throwable th) {
                    L.debug(this, "onResume exception =%s", th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDo(Context context, long j) {
        try {
            this.mStatisAPI.reportDo(j);
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
            this.mStatisAPI.reportRun(j);
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
    public boolean flushSession(String str, String str2) {
        return this.sessionReport.flushSession(str, str2);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean flushSessionAll(String str, Set<String> set) {
        return this.sessionReport.flushSessionAll(str, set);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void getHdid(final Context context, final HiidoSDK.HdidReceiver hdidReceiver) {
        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.20
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
            L.debug(this, "getOnlineConfigParams error,Input context is null", new Object[0]);
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
    public void reportCrash(long j, String str) {
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.reportCrash(j, str);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContent(String str, StatisContent statisContent) {
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.reportStatisticContent(str, statisContent, true, true);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContentTemporary(String str, StatisContent statisContent) {
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.reportStatisticContentTemporary(str, statisContent, true, true);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportTimesEvent(long j, String str) {
        if (!checkSDKInit()) {
            return;
        }
        reportTimesEvent(j, str, null);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void appStartLaunchWithAppKey(Context context, StatisOption statisOption, OnStatisListener onStatisListener) {
        if (mIsInit) {
            L.warn(this, "sdk only be init once", new Object[0]);
            return;
        }
        this.config = initMessageConfig(context, statisOption, onStatisListener);
        if (this.config == null) {
            return;
        }
        appStartLaunchWithAppKey(this.config, onStatisListener);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCountEvent(long j, String str, double d) {
        if (!checkSDKInit()) {
            return;
        }
        reportCountEvent(j, str, d, null);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCustomContent(long j, String str, String str2) {
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.reportCustomContent(j, str, str2);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean reportFeedBack(String str, String str2, String str3) {
        String str4;
        try {
            str4 = Coder.encryptMD5(UUID.randomUUID().toString());
        } catch (Throwable th) {
            L.debug(this, th.getMessage(), new Object[0]);
            str4 = null;
        }
        String str5 = str4;
        if (!checkSDKInit()) {
            return false;
        }
        this.mStatisAPI.reportFeedback(this.mOnStatisListener.getCurrentUid(), str5, str, str2, str3, null);
        return true;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportLocation(double d, double d2, double d3) {
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.reportLocation(this.mOnStatisListener.getCurrentUid(), d, d2, d3, null);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContent(String str, StatisContent statisContent, boolean z) {
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.reportStatisticContent(str, statisContent, true, true, z);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent) {
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.reportStatisticContentWithNoComm(getCtx(context), str, statisContent);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportTimesEvent(long j, String str, String str2) {
        if (!checkSDKInit()) {
            return;
        }
        reportTimesEvent(j, str, str2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void appInitRun() {
        if (this.isFrontground && (this.mState == 2 || this.mState == -1)) {
            reportOnAppStartLaunch(this.mContext, this.mOnStatisListener);
            BasicBehaviorController.AppActionReporter appActionReporter = getAppActionReporter();
            this.metricsHandler.onForeground();
            if (this.mStatisAPI.metricsHandler != null) {
                this.mStatisAPI.metricsHandler.onForeground();
            }
            if (appActionReporter != null) {
                appActionReporter.onAppStarted();
            }
            this.mState = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asynInit() {
        try {
            try {
                ((AppInfo) GlobalProvider.instance.get(AppInfo.class, this.config)).updateAppInfo(this.config);
                this.sensorController = new SensorController(this.mContext, this.config.getGyroscopeThreshold(), this.config.getAccelerometerThreshold(), this.config.getLightThreshold(), this.config.isOpenSensorMonitor());
                FloatingService.INSTANCT.setFilterAppkey(this.config.getAppkey());
                this.pageStateController = new PageStateController(this.mStatisAPI, this.mContext, this.mOnStatisListener);
                com.yy.hiidostatis.inner.AppInfo.INSTANCE.init(this.mContext);
                L.initLogConfig(this.mContext);
                if (Util.empty(this.config.getFrom())) {
                    this.config.setFrom(ArdUtil.getMetaDataParam(this.mContext, HdStatisConfig.META_DATA_KEY_CHANNEL));
                }
                if (HiidoSDK.instance().getOptions().isUseOaid()) {
                    OaidController.loadLib(this.config.getApplicationContext());
                    OaidController.INSTANCE.initOaidAsyn(this.config.getApplicationContext(), new OaidController.OaidInitListener() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.4
                        @Override // com.yy.hiidostatis.defs.controller.OaidController.OaidInitListener
                        public void initFinish(boolean z, String str, String str2) {
                            HiidoSDKNew.this.oaidInitFinish();
                        }
                    });
                }
                if (Util.empty(this.config.getVer())) {
                    this.config.setVer(ArdUtil.getVersionName(this.mContext));
                    this.metricsHandler.setVer(this.config.getVer());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mStatisAPI.onInitSuccess();
            DataTrack.instance.init(this.mContext, this.mStatisOption, new DataTrack.IDataTrackListener() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.5
                @Override // com.yy.hiidostatis.track.DataTrack.IDataTrackListener
                public JSONObject getConfig(String str, long j, String str2) {
                    return HiidoSDKNew.mConfigApi.getDeviceConfig(HiidoSDKNew.this.mContext, str, str2, j, true);
                }
            });
            this.mDeviceController = new DeviceController(this.mStatisAPI, this.mContext);
            SensorController.initRecord(this.mContext);
            L.infoOn(this, "init hiido isLogOn " + HiidoSDK.instance().getOptions().isLogOn, new Object[0]);
            L.debug(this, "testServer = %s", HiidoSDK.instance().getOptions().testServer);
            L.debug(this, "isAbroad = %b", Boolean.valueOf(HiidoSDK.instance().getOptions().isAbroad));
            L.debug(this, "isLogOn = %b", Boolean.valueOf(HiidoSDK.instance().getOptions().isLogOn));
        } catch (Throwable th) {
            this.mStatisAPI.onInitSuccess();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BasicBehaviorController getBehaviorCollector(Context context) {
        BasicBehaviorController basicBehaviorController;
        Context ctx = getCtx(context);
        if (ctx == null) {
            L.debug(this, "Input context is null when getBehaviorCollector", new Object[0]);
            return null;
        }
        BasicBehaviorController basicBehaviorController2 = this.mBasicBehaviorController;
        if (basicBehaviorController2 != null) {
            return basicBehaviorController2;
        }
        synchronized (this) {
            basicBehaviorController = this.mBasicBehaviorController;
            if (basicBehaviorController == null) {
                L.brief("mOnStatisListener is %s", this.mOnStatisListener);
                BasicBehaviorController basicBehaviorController3 = new BasicBehaviorController(ctx, this.mHandler, this.mOnStatisListener, this.mStatisAPI, HiidoSDK.instance().getOptions().backgroundDurationMillisAsQuit, HiidoSDK.instance().getOptions().behaviorSendThreshold, 10);
                this.mBasicBehaviorController = basicBehaviorController3;
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
                if (this.mStatisAPI.metricsHandler != null) {
                    this.mStatisAPI.metricsHandler.onExit();
                }
                onQuitApp(z);
                this.mState = 2;
                L.info(this, "app quit. it is one appa finish. isNormal quit is [%b]。", Boolean.valueOf(z));
            }
        } catch (Throwable th) {
            L.debug(this, "quitApp exception =%s", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportUrlScheme(Uri uri) {
        if (uri == null || !checkSDKInit()) {
            return;
        }
        try {
            String scheme = uri.getScheme();
            String host = uri.getHost();
            int port = uri.getPort();
            String path = uri.getPath();
            String query = uri.getQuery();
            L.debug(this, "URL SCHEME:%s://%s:%d/%s?%s", scheme, host, Integer.valueOf(port), path, query);
            this.mStatisAPI.reportUrlScheme(scheme, host, port, path, query);
        } catch (Throwable th) {
            L.debug(this, th.getMessage(), new Object[0]);
        }
    }

    private MessageConfig initMessageConfig(Context context, StatisOption statisOption, OnStatisListener onStatisListener) {
        String appkey = statisOption.getAppkey();
        if (Util.empty(appkey)) {
            ArdUtil.getMetaDataParam(context, HdStatisConfig.META_DATA_KEY_APP_KEY);
        }
        if (Util.empty(appkey)) {
            return null;
        }
        MessageConfig generateMainConfig = MessageConfigFactory.generateMainConfig(context, appkey);
        generateMainConfig.setVer(statisOption.getVer());
        generateMainConfig.setAppId(statisOption.getAppId());
        generateMainConfig.setVer(statisOption.getVer());
        generateMainConfig.setFrom(statisOption.getFrom());
        generateMainConfig.setInterval(HiidoSDK.instance().getOptions().getInterval());
        generateMainConfig.setDefaultMetricsExpire(HiidoSDK.instance().getOptions().getDefaultMetricsExpire());
        generateMainConfig.setLogOn(HiidoSDK.instance().getOptions().isLogOn);
        generateMainConfig.setGaidEnable(HiidoSDK.instance().getOptions().isGaidEnable());
        generateMainConfig.setDefaultMetricsExpire(HiidoSDK.instance().getOptions().getDefaultMetricsExpire());
        generateMainConfig.setUidProvider(onStatisListener);
        generateMainConfig.setBdCuid(HiidoSDK.instance().getOptions().getBdCuid());
        return generateMainConfig;
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
        this.mStatisAPI.exit();
        GeneralProxy.exit(getContext(), z);
        if (z) {
            if (getContext() != null) {
                GeneralProxy.startTimer(getContext(), 1800000L);
            }
            ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.14
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
            } else {
                L.debug(this, "report heart beat short for %d", Long.valueOf(j));
            }
        } catch (Throwable th) {
            L.debug(this, "report heart beat short for %d.exception=%s", Long.valueOf(j), th);
        }
    }

    private void reportOnAppStartLaunch(Context context, OnStatisListener onStatisListener) {
        try {
            TrafficMonitor.instance.init(this.mContext);
            TrafficMonitor.instance.start();
            ScreenMonitor.instance.reset();
            this.mSdkVerController.startSdkVerCheck(context);
            this.mStatisAPI.generateSession();
            getAppActionReporter().onStartApp();
            sendInstallationReportIfNotYet(context);
            reportDo(context, onStatisListener.getCurrentUid());
            reportRun(context, onStatisListener.getCurrentUid());
            this.mDeviceController.reportDeviceOnLaunch(context, onStatisListener.getCurrentUid());
            this.sensorController.reset(context);
            this.mSdkAnalyzeController.reportSdkAnalyze(context, onStatisListener.getCurrentUid());
            startHeartbeatReport();
            if (HiidoSDK.instance().getOptions().isOpenDoShort) {
                reportDoShort(context, onStatisListener.getCurrentUid());
                startHeartbeatReportShort();
            }
            GeneralProxy.start(context);
            GeneralProxy.stopTimer(context);
            DataTrack.instance.triggerTrack(true);
            ActLog.uploadLog(this.mContext, new ActLog.ILogConfigListener() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.6
                @Override // com.yy.hiidostatis.inner.util.log.ActLog.ILogConfigListener
                public JSONObject getLogConfig() {
                    return HiidoSDKNew.mConfigApi.getAppListConfig(HiidoSDKNew.this.mContext, true);
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

    public void appStartLaunchWithAppKey(MessageConfig messageConfig, OnStatisListener onStatisListener) {
        Application application = (Application) messageConfig.getApplicationContext().getApplicationContext();
        this.mContext = application;
        KVIO.initialize(application);
        DefaultProviderLoader.init();
        TraceLog.initLog(messageConfig.getApplicationContext());
        this.config = messageConfig;
        if (onStatisListener == null) {
            L.brief("the Input listener is null ,so get the default listener instead", new Object[0]);
            this.mOnStatisListener = nullListener;
        } else {
            this.mOnStatisListener = onStatisListener;
        }
        this.mStatisAPI = new StatisAPINew(messageConfig);
        this.sessionReport = (SessionReportWrapper) GlobalProvider.instance.get(SessionReportWrapper.class, messageConfig);
        startCrashMonitor();
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.2
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
                final Context applicationContext = activity.getApplicationContext();
                ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (HiidoSDKNew.this.pageStateController.onStop(name)) {
                            HiidoSDKNew.this.metricsHandler.onBackground();
                            if (HiidoSDKNew.this.mStatisAPI.metricsHandler != null) {
                                HiidoSDKNew.this.mStatisAPI.metricsHandler.onBackground();
                            }
                            HiidoSDKNew.this.sensorController.onStop(applicationContext);
                        }
                    }
                });
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                final String name = activity.getClass().getName();
                ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HiidoSDKNew.this.pageStateController.onStart(name);
                    }
                });
                if (activity.getIntent() != null) {
                    try {
                        HiidoSDKNew.this.reportUrlScheme(activity.getIntent().getData());
                    } catch (Throwable th) {
                        L.debug(this, th.getMessage(), new Object[0]);
                    }
                    try {
                        Uri data = activity.getIntent().getData();
                        if (data != null && data.getScheme().toLowerCase().startsWith("hiidodct.")) {
                            HiidoSDK.isDebugMode = true;
                            BindTestPhoneController.bind(data.toString(), activity.getApplicationContext());
                            Toast.makeText(activity.getApplicationContext(), "可以测试了", 1).show();
                        }
                    } catch (Throwable th2) {
                        L.debug(this, th2.getMessage(), new Object[0]);
                    }
                }
            }
        });
        ConfigAPI configAPI = new ConfigAPI(this.mContext, this.config.getAppkey());
        mConfigApi = configAPI;
        this.mSdkAnalyzeController = new SdkAnalyzeController(this.mStatisAPI, configAPI);
        this.mSdkVerController = new SdkVerController(mConfigApi);
        this.mInstallController = new InstallController(this.mStatisAPI);
        mOnLineConfigController = new OnLineConfigController(mConfigApi);
        this.metricsHandler = new MetricsHandler(this.mContext, messageConfig.getAppkey(), messageConfig.getVer(), HiidoSDK.instance().getOptions().getDefaultMetricsExpire());
        ThreadPool.getPool().executeQueue(new Runnable() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.3
            @Override // java.lang.Runnable
            public void run() {
                HiidoSDKNew.this.asynInit();
            }
        });
        mIsInit = true;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void beginSession(String str, String str2, long j, Map<String, Long> map) {
        this.sessionReport.beginSession(str, str2, j, map);
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
    public void reportCountEvent(long j, String str, double d, String str2) {
        reportCountEvent(j, str, d, str2, null);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportErrorEvent(long j, String str, String str2, String str3) {
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.reportError(j, str, str2, str3);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportReg(String str, String str2, String str3, Map<String, String> map) {
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.reportReg(str, str2, str3, map);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent, boolean z) {
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.reportStatisticContentWithNoComm(getCtx(context), str, statisContent, z);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportTimesEvent(long j, String str, String str2, Property property) {
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.reportTimesEvent(j, str, str2, property);
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
    public void reportCrash(long j, Throwable th) {
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.reportCrash(j, th);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean pushToSession(String str, String str2, CalAction calAction, String str3, Number number, Map<String, String> map, Map<String, String> map2) {
        return this.sessionReport.pushToSession(str, str2, calAction, str3, number, map, map2);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportShare(String str, int i, String str2, ShareType shareType, String str3, String str4, String str5) {
        if (checkSDKInit()) {
            this.mStatisAPI.reportShare(str, i, str2, shareType, str3, str4, str5);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean pushToSession(String str, String str2, List<EventValue> list, Map<String, String> map, Map<String, String> map2) {
        return this.sessionReport.pushToSession(str, str2, list, map, map2);
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
    public void reportCountEvent(long j, String str, double d, String str2, Property property) {
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.reportCountEvent(j, str, d, str2, property);
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
    public void reportSuccess(long j, String str, String str2, long j2, String str3) {
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.reportSuccess(j, str, str2, j2, str3);
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
    public void reportFailure(long j, String str, String str2, String str3, String str4, String str5) {
        if (!checkSDKInit()) {
            return;
        }
        this.mStatisAPI.reportFailure(j, str, str2, str3, str4, str5);
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
    public void reportIM(String str, String str2, String str3, Date date, Date date2, String str4, int i, String str5) {
        if (checkSDKInit()) {
            this.mStatisAPI.reportIM(str, str2, str3, date, date2, str4, i, str5);
        }
    }
}
