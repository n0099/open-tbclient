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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.s;
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
import com.yy.hiidostatis.inner.FlushManager;
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
/* loaded from: classes4.dex */
public class HiidoSDKNew implements HiidoApi {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_METRICS_NAME = "DEFAULT_METRICS";
    public static final int INTERVAL_HEART_BEAT = 900000;
    public static final String SDK_METRICS_NAME = "SDK_METRICS";
    public static final int SDK_METRICS_TIMER_INTERVAL = 900;
    public static final int STATE_INVALID = -1;
    public static final int STATE_QUITED = 2;
    public static final int STATE_STARTED = 1;
    public static volatile boolean isResumeCall;
    public static ConfigAPI mConfigApi;
    public static volatile boolean mIsInit;
    public static OnLineConfigController mOnLineConfigController;
    public static OnStatisListener nullListener;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean appRunIsCalled;
    public volatile MessageConfig config;
    public boolean isAppRunning;
    public boolean isFrontground;
    public ActivityLifecycleController mActivityLifecycleController;
    public BasicBehaviorController mBasicBehaviorController;
    public volatile Context mContext;
    public CrashController mCrashController;
    public DeviceController mDeviceController;
    public Map<String, String> mDoShortProp;
    public final Handler mHandler;
    public final Counter mHeartbeatInvoker;
    public final Counter mHeartbeatInvokerShort;
    public volatile Counter.Callback mHeartbeatReportExecutor;
    public volatile Counter.Callback mHeartbeatReportExecutorShort;
    public InstallController mInstallController;
    public volatile OnStatisListener mOnStatisListener;
    public volatile QuitTimer mQuittimer;
    public SdkAnalyzeController mSdkAnalyzeController;
    public SdkVerController mSdkVerController;
    public int mState;
    public StatisAPINew mStatisAPI;
    public volatile StatisOption mStatisOption;
    public MetricsHandler metricsHandler;
    public PageStateController pageStateController;
    public SensorController sensorController;
    public SessionReportWrapper sessionReport;
    public volatile boolean userAgreed;

    /* loaded from: classes4.dex */
    public interface HdidReceiver {
        void onHdidReceived(String str);
    }

    /* loaded from: classes4.dex */
    public class QuitTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Runnable mQuitTimer;
        public final /* synthetic */ HiidoSDKNew this$0;

        public QuitTimer(HiidoSDKNew hiidoSDKNew) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hiidoSDKNew};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = hiidoSDKNew;
            this.mQuitTimer = new Runnable(this) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.QuitTimer.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ QuitTimer this$1;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$1 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$1.this$0.quitApp(true);
                    }
                }
            };
        }

        public void clearQuitTimer() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.mHandler.removeCallbacks(this.mQuitTimer);
            }
        }

        public void startQuitTimer() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.this$0.mHandler.postDelayed(this.mQuitTimer, HiidoSDK.instance().getOptions().backgroundDurationMillisAsQuit);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-578845046, "Lcom/yy/hiidostatis/api/HiidoSDKNew;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-578845046, "Lcom/yy/hiidostatis/api/HiidoSDKNew;");
                return;
            }
        }
        nullListener = new OnStatisListener() { // from class: com.yy.hiidostatis.api.HiidoSDKNew.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.yy.hiidostatis.defs.interf.IOnStatisListener
            public long getCurrentUid() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return 0L;
                }
                return invokeV.longValue;
            }
        };
        isResumeCall = false;
        mIsInit = false;
    }

    public HiidoSDKNew() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mState = -1;
        this.appRunIsCalled = false;
        this.mStatisOption = new StatisOption();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mHeartbeatInvoker = new Counter(this.mHandler, 0, 900000L, true);
        this.mHeartbeatInvokerShort = new Counter(this.mHandler, 0, 60000L, true);
        this.mOnStatisListener = nullListener;
        this.mQuittimer = new QuitTimer();
        this.mStatisAPI = null;
        this.config = null;
        this.mDoShortProp = new HashMap();
        this.userAgreed = true;
        this.mActivityLifecycleController = new ActivityLifecycleController();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void appInitRun() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            synchronized (this) {
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asynInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
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
                        OaidController.INSTANCE.initOaidAsyn(this.config.getApplicationContext(), new OaidController.OaidInitListener(this) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ HiidoSDKNew this$0;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            @Override // com.yy.hiidostatis.defs.controller.OaidController.OaidInitListener
                            public void initFinish(boolean z, String str, String str2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
                                    this.this$0.oaidInitFinish();
                                }
                            }
                        });
                    }
                    if (Util.empty(this.config.getVer())) {
                        this.config.setVer(ArdUtil.getVersionName(this.mContext));
                        this.metricsHandler.setVer(this.config.getVer());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.mStatisAPI.onInitSuccess();
                DataTrack.instance.init(this.mContext, this.mStatisOption, new DataTrack.IDataTrackListener(this) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ HiidoSDKNew this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.yy.hiidostatis.track.DataTrack.IDataTrackListener
                    public JSONObject getConfig(String str, long j2, String str2) {
                        InterceptResult invokeCommon;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{str, Long.valueOf(j2), str2})) == null) ? HiidoSDKNew.mConfigApi.getDeviceConfig(this.this$0.mContext, str, str2, j2, true) : (JSONObject) invokeCommon.objValue;
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSDKInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, this)) == null) {
            if (!mIsInit) {
                L.warn(this, "The SDK is NOT init", new Object[0]);
            }
            return mIsInit;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flushCache(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65571, this, context) == null) && new Random().nextInt(2) % 2 == 0) {
            if (context != null) {
                GeneralProxy.flushCache(context);
            }
            CrashController crashController = this.mCrashController;
            if (crashController != null) {
                crashController.flushCache();
            }
        }
    }

    private BasicBehaviorController.AppActionReporter getAppActionReporter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, this)) == null) {
            BasicBehaviorController behaviorCollector = getBehaviorCollector(getCtx(this.mContext));
            if (behaviorCollector == null) {
                return null;
            }
            return behaviorCollector.getAppActionCollector();
        }
        return (BasicBehaviorController.AppActionReporter) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BasicBehaviorController getBehaviorCollector(Context context) {
        InterceptResult invokeL;
        BasicBehaviorController basicBehaviorController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, this, context)) == null) {
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
        return (BasicBehaviorController) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getCtx(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65574, this, context)) == null) ? context == null ? this.mContext : context : (Context) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BasicBehaviorController.PageActionReporter getPageActionReporter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, this)) == null) {
            BasicBehaviorController behaviorCollector = getBehaviorCollector(getCtx(this.mContext));
            if (behaviorCollector == null) {
                return null;
            }
            return behaviorCollector.getPageActionCollector();
        }
        return (BasicBehaviorController.PageActionReporter) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPageId(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65576, this, activity)) == null) ? activity != null ? activity.getClass().getName() : "" : (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean imeiPrepared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65577, this)) == null) ? !HiidoSDK.instance().getOptions().isWaitGrant() || Build.VERSION.SDK_INT > 28 || this.appRunIsCalled || ArdUtil.checkPermissions(this.mContext, s.f55454c) : invokeV.booleanValue;
    }

    private MessageConfig initMessageConfig(Context context, StatisOption statisOption, OnStatisListener onStatisListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65578, this, context, statisOption, onStatisListener)) == null) {
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
        return (MessageConfig) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void oaidInitFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            synchronized (this) {
                if (imeiPrepared()) {
                    ThreadPool.getPool().executeQueue(new Runnable(this) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.11
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ HiidoSDKNew this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.appInitRun();
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean oaidPrepared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65580, this)) == null) ? !HiidoSDK.instance().getOptions().isUseOaid() || OaidController.ignore(this.mContext) || OaidController.INSTANCE.isLoaded() : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPauseInner(String str, HiidoSDK.PageActionReportOption pageActionReportOption) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65581, this, str, pageActionReportOption) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str, pageActionReportOption) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HiidoSDKNew this$0;
                public final /* synthetic */ String val$pageId;
                public final /* synthetic */ HiidoSDK.PageActionReportOption val$reportOption;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, pageActionReportOption};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$pageId = str;
                    this.val$reportOption = pageActionReportOption;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.checkSDKInit()) {
                        if (HiidoSDK.instance().getOptions().getIgnoreActivity() == null || !HiidoSDK.instance().getOptions().getIgnoreActivity().contains(this.val$pageId)) {
                            try {
                                if (HiidoSDKNew.isResumeCall) {
                                    if (this.val$reportOption == HiidoSDK.PageActionReportOption.DO_NOT_REPORT_ON_FUTURE_RESUME) {
                                        L.debug(this, " DO_NOT_REPORT_ON_FUTURE_RESUME,Clear current page element on page %s", this.val$pageId);
                                        this.this$0.getPageActionReporter().clearCurPageElement();
                                    } else {
                                        this.this$0.getPageActionReporter().onLeavingUI(this.val$pageId, null);
                                    }
                                    L.verbose(this, "startQuitTimer in onPause", new Object[0]);
                                    this.this$0.mQuittimer.startQuitTimer();
                                    boolean unused = HiidoSDKNew.isResumeCall = false;
                                    this.this$0.getBehaviorCollector(this.this$0.getCtx(this.this$0.mContext)).saveLastOnPauseTime(Util.wallTimeMillis());
                                    return;
                                }
                                L.error(this, "call onPause() must call onResume() first", new Object[0]);
                            } catch (Throwable th) {
                                L.debug(this, "onPause exception =%s", th);
                            }
                        }
                    }
                }
            });
        }
    }

    private void onQuitApp(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65582, this, z) == null) {
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
                    GeneralProxy.startTimer(getContext(), Long.valueOf((long) FlushManager.ReportTimer.DEFAULT_INTERVAL));
                }
                ThreadPool.getPool().execute(new Runnable(this) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ HiidoSDKNew this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                Thread.sleep(1000L);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                            DataTrack.instance.triggerTrack(true);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResumeInner(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65583, this, j2, str) == null) {
            this.isFrontground = true;
            ThreadPool.getPool().executeQueue(new Runnable(this, str, j2) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HiidoSDKNew this$0;
                public final /* synthetic */ String val$pageId;
                public final /* synthetic */ long val$uid;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$pageId = str;
                    this.val$uid = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.checkSDKInit()) {
                        if (HiidoSDK.instance().getOptions().getIgnoreActivity() == null || !HiidoSDK.instance().getOptions().getIgnoreActivity().contains(this.val$pageId)) {
                            try {
                                L.verbose(this, "clearQuitTimer in onResume", new Object[0]);
                                this.this$0.mQuittimer.clearQuitTimer();
                                boolean unused = HiidoSDKNew.isResumeCall = true;
                                if (!this.this$0.imeiPrepared() || !this.this$0.oaidPrepared()) {
                                    if (this.this$0.mState == 2 || this.this$0.mState == -1) {
                                        this.this$0.reportDo(this.this$0.mContext, this.this$0.getOnStatisListener() != null ? this.this$0.getOnStatisListener().getCurrentUid() : 0L);
                                    }
                                } else {
                                    this.this$0.appInitRun();
                                }
                                BasicBehaviorController.PageActionReporter pageActionReporter = this.this$0.getPageActionReporter();
                                if (pageActionReporter != null) {
                                    pageActionReporter.onResumeUI(this.val$uid, this.val$pageId);
                                }
                                DefaultPreference.getPreference().setPrefString(this.this$0.mContext, HdStatisConfig.PREF_CPAGE, this.val$pageId);
                            } catch (Throwable th) {
                                L.debug(this, "onResume exception =%s", th);
                            }
                        }
                    }
                }
            });
        }
    }

    private BasicBehaviorController.AppActionReporter peekAppaActionReporter() {
        InterceptResult invokeV;
        BasicBehaviorController.AppActionReporter appActionCollector;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, this)) == null) {
            BasicBehaviorController basicBehaviorController = this.mBasicBehaviorController;
            if (basicBehaviorController != null) {
                return basicBehaviorController.getAppActionCollector();
            }
            synchronized (this) {
                BasicBehaviorController basicBehaviorController2 = this.mBasicBehaviorController;
                appActionCollector = basicBehaviorController2 == null ? null : basicBehaviorController2.getAppActionCollector();
            }
            return appActionCollector;
        }
        return (BasicBehaviorController.AppActionReporter) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void quitApp(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65585, this, z) == null) {
            try {
                if (this.mState == 1) {
                    BasicBehaviorController.PageActionReporter pageActionReporter = getPageActionReporter();
                    if (pageActionReporter != null) {
                        if (!z) {
                            pageActionReporter.onLeavingUI(null, null);
                            isResumeCall = false;
                        }
                        pageActionReporter.onFinishGotoUI(this.mOnStatisListener == null ? 0L : this.mOnStatisListener.getCurrentUid(), null, true);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDo(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65586, this, context, j2) == null) {
            try {
                this.mStatisAPI.reportDo(j2);
                L.debug(this, "report heart beat for %d", Long.valueOf(j2));
            } catch (Throwable th) {
                L.debug(this, "report heart beat for %d.exception=%s", Long.valueOf(j2), th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDoShort(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65587, this, context, j2) == null) {
            try {
                if (this.mDoShortProp.size() == 0) {
                    L.brief("report heart beat short for %d do nothing , mDoShortProp size  = 0", Long.valueOf(j2));
                } else {
                    L.debug(this, "report heart beat short for %d", Long.valueOf(j2));
                }
            } catch (Throwable th) {
                L.debug(this, "report heart beat short for %d.exception=%s", Long.valueOf(j2), th);
            }
        }
    }

    private void reportOnAppStartLaunch(Context context, OnStatisListener onStatisListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65588, this, context, onStatisListener) == null) {
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
                ActLog.uploadLog(this.mContext, new ActLog.ILogConfigListener(this) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ HiidoSDKNew this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.yy.hiidostatis.inner.util.log.ActLog.ILogConfigListener
                    public JSONObject getLogConfig() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? HiidoSDKNew.mConfigApi.getAppListConfig(this.this$0.mContext, true) : (JSONObject) invokeV.objValue;
                    }
                });
            } catch (Throwable th) {
                L.debug(this, "reportOnAppStartLaunch exception =%s", th);
            }
        }
    }

    private void reportRun(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65589, this, context, j2) == null) {
            try {
                if (this.mState != -1 && this.mState != 2) {
                    L.warn(this, "reportRun has been called, one launch only one call!", new Object[0]);
                }
                this.mStatisAPI.reportRun(j2);
                L.debug(this, "reportRun call", new Object[0]);
            } catch (Throwable th) {
                L.debug(this, "reportRun exception=%s", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportUrlScheme(Uri uri) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65590, this, uri) == null) && uri != null && checkSDKInit()) {
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
    }

    private void resetHeartbeatReportShort(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65591, this, j2) == null) {
            try {
                if (this.mHeartbeatInvokerShort == null || !this.mHeartbeatInvokerShort.running()) {
                    return;
                }
                this.mHeartbeatInvokerShort.stop();
                this.mHeartbeatInvokerShort.start(j2);
            } catch (Throwable th) {
                L.debug(this, "resetHeartbeatReportShort exception = %s", th);
            }
        }
    }

    private void sendInstallationReportIfNotYet(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65592, this, context) == null) {
            Context ctx = getCtx(context);
            if (ctx != null && this.mInstallController != null) {
                if (checkSDKInit()) {
                    this.mInstallController.sendInstallationReportIfNotYet(ctx);
                    return;
                }
                return;
            }
            L.error(this, "Input context is null,sdk is not init?", new Object[0]);
        }
    }

    private void startCrashMonitor() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65593, this) == null) && this.config.isOpenCrashMonitor()) {
            if (this.mCrashController != null) {
                L.warn(this, "crash monitor has been started.", new Object[0]);
                return;
            }
            CrashController crashController = new CrashController(getContext(), this.mStatisAPI, this.mOnStatisListener, new CrashController.OnCrashListener(this) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HiidoSDKNew this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.yy.hiidostatis.defs.controller.CrashController.OnCrashListener
                public void handler(JSONObject jSONObject) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, jSONObject) == null) {
                        ThreadPool.getPool().execute(new Runnable(this) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.19.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass19 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.this$1.this$0.quitApp(false);
                                }
                            }
                        });
                    }
                }
            });
            this.mCrashController = crashController;
            crashController.startCrashMonitor();
        }
    }

    private void startHeartbeatReport() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65594, this) == null) {
            if (this.mHeartbeatReportExecutor != null) {
                L.warn(this, "heart beat as for mbsdkdo has been started.", new Object[0]);
                return;
            }
            Counter.Callback callback = new Counter.Callback(this) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HiidoSDKNew this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.yy.hiidostatis.inner.util.Counter.Callback
                public void onCount(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        long currentUid = this.this$0.mOnStatisListener.getCurrentUid();
                        HiidoSDKNew hiidoSDKNew = this.this$0;
                        hiidoSDKNew.reportDo(hiidoSDKNew.mContext, currentUid);
                    }
                }
            };
            this.mHeartbeatReportExecutor = callback;
            this.mHeartbeatInvoker.setCallback(callback);
            Counter counter = this.mHeartbeatInvoker;
            counter.start(counter.getInterval());
            L.debug(this, "start heart beat invoker for mbsdkdo.", new Object[0]);
        }
    }

    private void startHeartbeatReportShort() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65595, this) == null) {
            if (this.mHeartbeatReportExecutorShort != null) {
                L.warn(this, "heart beat as for mbsdkdo short has been started.", new Object[0]);
                return;
            }
            Counter.Callback callback = new Counter.Callback(this) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HiidoSDKNew this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.yy.hiidostatis.inner.util.Counter.Callback
                public void onCount(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        long currentUid = this.this$0.mOnStatisListener.getCurrentUid();
                        HiidoSDKNew hiidoSDKNew = this.this$0;
                        hiidoSDKNew.reportDoShort(hiidoSDKNew.mContext, currentUid);
                        HiidoSDKNew hiidoSDKNew2 = this.this$0;
                        hiidoSDKNew2.flushCache(hiidoSDKNew2.mContext);
                        DataTrack.instance.triggerTrack(false);
                    }
                }
            };
            this.mHeartbeatReportExecutorShort = callback;
            this.mHeartbeatInvokerShort.setCallback(callback);
            Counter counter = this.mHeartbeatInvokerShort;
            counter.start(counter.getInterval());
            L.debug(this, "start heart beat invoker for mbsdkdo short.", new Object[0]);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void addActAdditionListener(ActListener actListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, actListener) == null) && checkSDKInit()) {
            this.mStatisAPI.addActAdditionListener(actListener);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public MetricsWorker addMetricsWorker(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j2)) == null) {
            if (checkSDKInit()) {
                return this.metricsHandler.addMetricsWorker(str, j2);
            }
            return null;
        }
        return (MetricsWorker) invokeLJ.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public synchronized void appRun() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.appRunIsCalled = true;
                if (oaidPrepared()) {
                    ThreadPool.getPool().executeQueue(new Runnable(this) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.10
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ HiidoSDKNew this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.appInitRun();
                            }
                        }
                    });
                }
            }
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void appStartLaunchWithAppKey(Context context, StatisOption statisOption, OnStatisListener onStatisListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, statisOption, onStatisListener) == null) {
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
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void beginSession(String str, String str2, long j2, Map<String, Long> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Long.valueOf(j2), map}) == null) {
            this.sessionReport.beginSession(str, str2, j2, map);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void closeSession(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.sessionReport.closeSession(str);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public StatisAPI createNewStatisApi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StatisAPI statisAPI = new StatisAPI();
            statisAPI.setAbroad(HiidoSDK.instance().getOptions().isAbroad);
            statisAPI.setTestServer(HiidoSDK.instance().getOptions().testServer);
            statisAPI.setBusinessType(HiidoSDK.instance().getOptions().businessType);
            return statisAPI;
        }
        return (StatisAPI) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean flushSession(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) ? this.sessionReport.flushSession(str, str2) : invokeLL.booleanValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean flushSessionAll(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, set)) == null) ? this.sessionReport.flushSessionAll(str, set) : invokeLL.booleanValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.config.getAppId() : (String) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getAppKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.config.getAppkey() : (String) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.config.getApplicationContext() : (Context) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getDeviceId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) ? CommonFiller.getIMEI(context) : (String) invokeL.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.config.getFrom() : (String) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    @Deprecated
    public String getHdid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, context)) == null) ? DeviceProxy.getHdid(context) : (String) invokeL.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getMac(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, context)) == null) ? CommonFiller.getMacAddr(context) : (String) invokeL.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public OnStatisListener getOnStatisListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mOnStatisListener : (OnStatisListener) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public String getOnlineConfigParams(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, context, str)) == null) {
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
        return (String) invokeLL.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public StatisOption getStatisOption() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mStatisOption : (StatisOption) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onPause(String str, HiidoSDK.PageActionReportOption pageActionReportOption) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, str, pageActionReportOption) == null) || this.mActivityLifecycleController.isRegister()) {
            return;
        }
        onPauseInner(str, pageActionReportOption);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onResume(long j2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048600, this, j2, str) == null) || this.mActivityLifecycleController.isRegister()) {
            return;
        }
        onResumeInner(j2, str);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onScreenMonitor(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, motionEvent) == null) {
            ScreenMonitor.instance.onTouchEvent(motionEvent);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onScreenPause(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HiidoSDKNew this$0;
                public final /* synthetic */ String val$screen;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$screen = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.this$0.getPageActionReporter().onLeavingUI(this.val$screen, null);
                        } catch (Throwable th) {
                            L.debug(this, "onScreenPause exception =%s", th);
                        }
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onScreenResume(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, str) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HiidoSDKNew this$0;
                public final /* synthetic */ String val$screen;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$screen = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.checkSDKInit()) {
                        try {
                            BasicBehaviorController.PageActionReporter pageActionReporter = this.this$0.getPageActionReporter();
                            long currentUid = this.this$0.mOnStatisListener != null ? this.this$0.mOnStatisListener.getCurrentUid() : 0L;
                            if (pageActionReporter != null) {
                                pageActionReporter.onResumeUI(currentUid, this.val$screen);
                            }
                            ThreadPool.getPool().executeQueue(new Runnable(this) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.12.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass12 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        try {
                                            DefaultPreference.getPreference().setPrefString(this.this$1.this$0.mContext, HdStatisConfig.PREF_CPAGE, this.this$1.val$screen);
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            L.debug(this, "onScreenResume exception =%s", th);
                        }
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean pushToSession(String str, String str2, List<EventValue> list, Map<String, String> map, Map<String, String> map2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048605, this, str, str2, list, map, map2)) == null) ? this.sessionReport.pushToSession(str, str2, list, map, map2) : invokeLLLLL.booleanValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean registerActivityLifecycleMonitor(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, context)) == null) {
            this.mActivityLifecycleController.registerActivityLifecycleCallbacks(context, new ActivityLifecycleController.ActivityLifecycleCallback(this) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HiidoSDKNew this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.yy.hiidostatis.defs.controller.ActivityLifecycleController.ActivityLifecycleCallback
                public void onActivityPaused(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, activity) == null) {
                        HiidoSDKNew hiidoSDKNew = this.this$0;
                        hiidoSDKNew.onPauseInner(hiidoSDKNew.getPageId(activity), HiidoSDK.PageActionReportOption.REPORT_ON_FUTURE_RESUME);
                    }
                }

                @Override // com.yy.hiidostatis.defs.controller.ActivityLifecycleController.ActivityLifecycleCallback
                public void onActivityResumed(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                        OnStatisListener onStatisListener = this.this$0.getOnStatisListener();
                        long currentUid = onStatisListener != null ? onStatisListener.getCurrentUid() : 0L;
                        HiidoSDKNew hiidoSDKNew = this.this$0;
                        hiidoSDKNew.onResumeInner(currentUid, hiidoSDKNew.getPageId(activity));
                    }
                }
            });
            L.debug(this, "registerActivityLifecycleMonitor = %b", Boolean.valueOf(this.mActivityLifecycleController.isRegister()));
            return this.mActivityLifecycleController.isRegister();
        }
        return invokeL.booleanValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void removeActAdditionListerner(ActListener actListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, actListener) == null) && checkSDKInit()) {
            this.mStatisAPI.removeActAdditionListener(actListener);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportAppsflyer(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && checkSDKInit()) {
            this.mStatisAPI.reportAppsflyer(str);
            if (this.mState == 1) {
                reportDo(this.mContext, this.mOnStatisListener == null ? 0L : this.mOnStatisListener.getCurrentUid());
            }
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCount(int i2, String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), str, str2, Long.valueOf(j2)}) == null) && checkSDKInit()) {
            if (!this.metricsHandler.containMetric("DEFAULT_METRICS")) {
                this.metricsHandler.addMetricsWorker("DEFAULT_METRICS", HiidoSDK.instance().getOptions().defaultMetricsInterval);
            }
            this.metricsHandler.reportCount("DEFAULT_METRICS", i2, str, str2, j2);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCountEvent(long j2, String str, double d2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Long.valueOf(j2), str, Double.valueOf(d2)}) == null) && checkSDKInit()) {
            reportCountEvent(j2, str, d2, null);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCrash(long j2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(1048616, this, j2, str) == null) && checkSDKInit()) {
            this.mStatisAPI.reportCrash(j2, str);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCustomContent(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Long.valueOf(j2), str, str2}) == null) && checkSDKInit()) {
            this.mStatisAPI.reportCustomContent(j2, str, str2);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportErrorEvent(long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Long.valueOf(j2), str, str2, str3}) == null) && checkSDKInit()) {
            this.mStatisAPI.reportError(j2, str, str2, str3);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportFailure(long j2, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Long.valueOf(j2), str, str2, str3, str4, str5}) == null) && checkSDKInit()) {
            this.mStatisAPI.reportFailure(j2, str, str2, str3, str4, str5);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean reportFeedBack(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048621, this, str, str2, str3)) == null) {
            try {
                str4 = Coder.encryptMD5(UUID.randomUUID().toString());
            } catch (Throwable th) {
                L.debug(this, th.getMessage(), new Object[0]);
                str4 = null;
            }
            String str5 = str4;
            if (checkSDKInit()) {
                this.mStatisAPI.reportFeedback(this.mOnStatisListener.getCurrentUid(), str5, str, str2, str3, null);
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportIM(String str, String str2, String str3, Date date, Date date2, String str4, int i2, String str5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{str, str2, str3, date, date2, str4, Integer.valueOf(i2), str5}) == null) && checkSDKInit()) {
            this.mStatisAPI.reportIM(str, str2, str3, date, date2, str4, i2, str5);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportLocation(double d2, double d3, double d4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)}) == null) && checkSDKInit()) {
            this.mStatisAPI.reportLocation(this.mOnStatisListener.getCurrentUid(), d2, d3, d4, null);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportLogin(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048624, this, j2) == null) && checkSDKInit()) {
            this.mStatisAPI.reportLogin(j2);
            if (this.mState == 1) {
                this.mStatisAPI.reportDo(j2);
            }
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportPushToken(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, str) == null) && checkSDKInit()) {
            this.mStatisAPI.reportPushToken(this.mOnStatisListener.getCurrentUid(), str);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportReg(String str, String str2, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048626, this, str, str2, str3, map) == null) && checkSDKInit()) {
            this.mStatisAPI.reportReg(str, str2, str3, map);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportReturnCode(int i2, String str, long j2, String str2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2), str2, map}) == null) && checkSDKInit()) {
            if (!this.metricsHandler.containMetric("DEFAULT_METRICS")) {
                this.metricsHandler.addMetricsWorker("DEFAULT_METRICS", HiidoSDK.instance().getOptions().defaultMetricsInterval);
            }
            this.metricsHandler.reportReturnCode("DEFAULT_METRICS", i2, str, j2, str2, map);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportShare(String str, int i2, String str2, ShareType shareType, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{str, Integer.valueOf(i2), str2, shareType, str3, str4, str5}) == null) && checkSDKInit()) {
            this.mStatisAPI.reportShare(str, i2, str2, shareType, str3, str4, str5);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportSrcData(int i2, String str, String str2, long j2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048630, this, new Object[]{Integer.valueOf(i2), str, str2, Long.valueOf(j2), map}) == null) && checkSDKInit()) {
            if (!this.metricsHandler.containMetric("DEFAULT_METRICS")) {
                this.metricsHandler.addMetricsWorker("DEFAULT_METRICS", HiidoSDK.instance().getOptions().defaultMetricsInterval);
            }
            this.metricsHandler.reportSrcData("DEFAULT_METRICS", i2, str, str2, j2, map);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContent(String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048632, this, str, statisContent) == null) && checkSDKInit()) {
            this.mStatisAPI.reportStatisticContent(str, statisContent, true, true);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContentTemporary(String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048634, this, str, statisContent) == null) && checkSDKInit()) {
            this.mStatisAPI.reportStatisticContentTemporary(str, statisContent, true, true);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048635, this, context, str, statisContent) == null) && checkSDKInit()) {
            this.mStatisAPI.reportStatisticContentWithNoComm(getCtx(context), str, statisContent);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportSuccess(long j2, String str, String str2, long j3, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048637, this, new Object[]{Long.valueOf(j2), str, str2, Long.valueOf(j3), str3}) == null) && checkSDKInit()) {
            this.mStatisAPI.reportSuccess(j2, str, str2, j3, str3);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportTimesEvent(long j2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(1048638, this, j2, str) == null) && checkSDKInit()) {
            reportTimesEvent(j2, str, null);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void setAdditionParamsDelegate(HiidoSdkAdditionDelegate hiidoSdkAdditionDelegate) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048641, this, hiidoSdkAdditionDelegate) == null) && checkSDKInit()) {
            this.mStatisAPI.setAdditionParamsDelegate(hiidoSdkAdditionDelegate);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public synchronized void setBdCuid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, str) == null) {
            synchronized (this) {
                this.config.setBdCuid(str);
            }
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void setCurPageParam(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048643, this, str) == null) || getPageActionReporter() == null) {
            return;
        }
        getPageActionReporter().setCurPageParam(str);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void setHeartbeatField(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048644, this, str, str2) == null) {
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
    }

    public HiidoApi setLogWriter(StatisLogWriter statisLogWriter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, statisLogWriter)) == null) {
            L.setLogSetting(statisLogWriter);
            return this;
        }
        return (HiidoApi) invokeL.objValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void setOnLineConfigListener(OnLineConfigListener onLineConfigListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, onLineConfigListener) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, onLineConfigListener) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HiidoSDKNew this$0;
                public final /* synthetic */ OnLineConfigListener val$onLineConfigListener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, onLineConfigListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$onLineConfigListener = onLineConfigListener;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.checkSDKInit()) {
                        HiidoSDKNew.mOnLineConfigController.setOnLineConfigListener(this.val$onLineConfigListener);
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void updateOnlineConfigs(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, context) == null) {
            ThreadPool.getPool().executeQueue(new Runnable(this, context) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HiidoSDKNew this$0;
                public final /* synthetic */ Context val$context;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$context = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        Context context2 = this.val$context;
                        if (context2 == null) {
                            context2 = this.this$0.mContext;
                        }
                        if (context2 != null && HiidoSDKNew.mOnLineConfigController != null) {
                            HiidoSDKNew.mOnLineConfigController.updateOnlineConfigs(context2, this.this$0.getAppKey());
                        } else {
                            L.warn(this, "updateOnlineConfigs error,Input context is null", new Object[0]);
                        }
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void getHdid(Context context, HiidoSDK.HdidReceiver hdidReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, context, hdidReceiver) == null) {
            ThreadPool.getPool().execute(new Runnable(this, context, hdidReceiver) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.20
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HiidoSDKNew this$0;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ HiidoSDK.HdidReceiver val$receiver;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, hdidReceiver};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$context = context;
                    this.val$receiver = hdidReceiver;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String hdid = DeviceProxy.getHdid(this.val$context);
                        HiidoSDK.HdidReceiver hdidReceiver2 = this.val$receiver;
                        if (hdidReceiver2 != null) {
                            hdidReceiver2.onHdidReceived(hdid);
                        }
                    }
                }
            });
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public boolean pushToSession(String str, String str2, CalAction calAction, String str3, Number number, Map<String, String> map, Map<String, String> map2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{str, str2, calAction, str3, number, map, map2})) == null) ? this.sessionReport.pushToSession(str, str2, calAction, str3, number, map, map2) : invokeCommon.booleanValue;
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onPause(Activity activity, HiidoSDK.PageActionReportOption pageActionReportOption) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, activity, pageActionReportOption) == null) || this.mActivityLifecycleController.isRegister()) {
            return;
        }
        onPause(getPageId(activity), pageActionReportOption);
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void onResume(long j2, Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048599, this, j2, activity) == null) || this.mActivityLifecycleController.isRegister()) {
            return;
        }
        onResume(j2, getPageId(activity));
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCountEvent(long j2, String str, double d2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Long.valueOf(j2), str, Double.valueOf(d2), str2}) == null) {
            reportCountEvent(j2, str, d2, str2, null);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCrash(long j2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(1048617, this, j2, th) == null) && checkSDKInit()) {
            this.mStatisAPI.reportCrash(j2, th);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContent(String str, StatisContent statisContent, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048633, this, str, statisContent, z) == null) && checkSDKInit()) {
            this.mStatisAPI.reportStatisticContent(str, statisContent, true, true, z);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportStatisticContentWithNoComm(Context context, String str, StatisContent statisContent, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{context, str, statisContent, Boolean.valueOf(z)}) == null) && checkSDKInit()) {
            this.mStatisAPI.reportStatisticContentWithNoComm(getCtx(context), str, statisContent, z);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportTimesEvent(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{Long.valueOf(j2), str, str2}) == null) && checkSDKInit()) {
            reportTimesEvent(j2, str, str2, null);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCountEvent(long j2, String str, double d2, String str2, Property property) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Long.valueOf(j2), str, Double.valueOf(d2), str2, property}) == null) && checkSDKInit()) {
            this.mStatisAPI.reportCountEvent(j2, str, d2, str2, property);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCount(int i2, String str, String str2, long j2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), str, str2, Long.valueOf(j2), Integer.valueOf(i3)}) == null) && checkSDKInit()) {
            if (!this.metricsHandler.containMetric("DEFAULT_METRICS")) {
                this.metricsHandler.addMetricsWorker("DEFAULT_METRICS", HiidoSDK.instance().getOptions().defaultMetricsInterval);
            }
            this.metricsHandler.reportCount("DEFAULT_METRICS", i2, str, str2, j2, i3);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportReturnCode(String str, int i2, String str2, long j2, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{str, Integer.valueOf(i2), str2, Long.valueOf(j2), str3, map}) == null) && checkSDKInit()) {
            this.metricsHandler.reportReturnCode(str, i2, str2, j2, str3, map);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportSrcData(String str, int i2, String str2, String str3, long j2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{str, Integer.valueOf(i2), str2, str3, Long.valueOf(j2), map}) == null) && checkSDKInit()) {
            this.metricsHandler.reportSrcData(str, i2, str2, str3, j2, map);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportTimesEvent(long j2, String str, String str2, Property property) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048640, this, new Object[]{Long.valueOf(j2), str, str2, property}) == null) && checkSDKInit()) {
            this.mStatisAPI.reportTimesEvent(j2, str, str2, property);
        }
    }

    public void appStartLaunchWithAppKey(MessageConfig messageConfig, OnStatisListener onStatisListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, messageConfig, onStatisListener) == null) {
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
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks(this) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HiidoSDKNew this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, activity, bundle) == null) {
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048579, this, activity) == null) && FloatingService.INSTANCT.isDebug() && !FloatingService.INSTANCT.isInit()) {
                        FloatingService.INSTANCT.showFloatingWindow(activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048580, this, activity, bundle) == null) {
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048581, this, activity) == null) {
                        ThreadPool.getPool().executeQueue(new Runnable(this, activity.getClass().getName()) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;
                            public final /* synthetic */ String val$cn;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r7};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$cn = r7;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.this$1.this$0.pageStateController.onStart(this.val$cn);
                                }
                            }
                        });
                        if (activity.getIntent() != null) {
                            try {
                                this.this$0.reportUrlScheme(activity.getIntent().getData());
                            } catch (Throwable th) {
                                L.debug(this, th.getMessage(), new Object[0]);
                            }
                            try {
                                Uri data = activity.getIntent().getData();
                                if (data == null || !data.getScheme().toLowerCase().startsWith("hiidodct.")) {
                                    return;
                                }
                                HiidoSDK.isDebugMode = true;
                                BindTestPhoneController.bind(data.toString(), activity.getApplicationContext());
                                Toast.makeText(activity.getApplicationContext(), "可以测试了", 1).show();
                            } catch (Throwable th2) {
                                L.debug(this, th2.getMessage(), new Object[0]);
                            }
                        }
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048582, this, activity) == null) {
                        ThreadPool.getPool().executeQueue(new Runnable(this, activity.getClass().getName(), activity.getApplicationContext()) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.2.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;
                            public final /* synthetic */ Context val$app;
                            public final /* synthetic */ String val$cn;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r7, r8};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$cn = r7;
                                this.val$app = r8;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && this.this$1.this$0.pageStateController.onStop(this.val$cn)) {
                                    this.this$1.this$0.metricsHandler.onBackground();
                                    if (this.this$1.this$0.mStatisAPI.metricsHandler != null) {
                                        this.this$1.this$0.mStatisAPI.metricsHandler.onBackground();
                                    }
                                    this.this$1.this$0.sensorController.onStop(this.val$app);
                                }
                            }
                        });
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
            ThreadPool.getPool().executeQueue(new Runnable(this) { // from class: com.yy.hiidostatis.api.HiidoSDKNew.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HiidoSDKNew this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.asynInit();
                    }
                }
            });
            mIsInit = true;
        }
    }

    public void reportCount(String str, int i2, String str2, String str3, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{str, Integer.valueOf(i2), str2, str3, Long.valueOf(j2)}) == null) && checkSDKInit()) {
            this.metricsHandler.reportCount(str, i2, str2, str3, j2);
        }
    }

    @Override // com.yy.hiidostatis.api.HiidoApi
    public void reportCount(String str, int i2, String str2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{str, Integer.valueOf(i2), str2, str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) && checkSDKInit()) {
            this.metricsHandler.reportCount(str, i2, str2, str3, j2, i3);
        }
    }
}
