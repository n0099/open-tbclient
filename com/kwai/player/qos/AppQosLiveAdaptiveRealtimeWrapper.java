package com.kwai.player.qos;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.player.IMediaPlayer;
/* loaded from: classes7.dex */
public class AppQosLiveAdaptiveRealtimeWrapper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_LIVE_ADAPTIVE_QOS_TICK_DURATION_SEC = 2;
    public static final int DEFAULT_MONITOR_INTERVAL = 1000;
    public transient /* synthetic */ FieldHolder $fh;
    public final AppLiveReatimeInfoProvider mAppLiveReatimeInfoProvider;
    public AppQosLiveAdaptiveRealtime mAppQosLiveAdaptiveRealtime;
    public final boolean mEnable;
    public boolean mEnableAdditinalQosFlag;
    public Object mLiveAdaptiveQosObject;
    public long mLiveAdaptiveQosTickDuration;
    public IMediaPlayer.OnLiveAdaptiveQosStatListener mOnLiveAdaptiveQosStatListener;
    public long mStartTsMs;

    public AppQosLiveAdaptiveRealtimeWrapper(AppLiveReatimeInfoProvider appLiveReatimeInfoProvider, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {appLiveReatimeInfoProvider, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLiveAdaptiveQosObject = new Object();
        this.mLiveAdaptiveQosTickDuration = 2000L;
        this.mAppLiveReatimeInfoProvider = appLiveReatimeInfoProvider;
        this.mEnable = z;
    }

    private synchronized void startLiveAdaptiveQosStatTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            synchronized (this) {
                if (this.mAppQosLiveAdaptiveRealtime != null) {
                    return;
                }
                AppQosLiveAdaptiveRealtime appQosLiveAdaptiveRealtime = new AppQosLiveAdaptiveRealtime(1000L, this.mLiveAdaptiveQosTickDuration, this.mAppLiveReatimeInfoProvider, this.mLiveAdaptiveQosObject);
                this.mAppQosLiveAdaptiveRealtime = appQosLiveAdaptiveRealtime;
                appQosLiveAdaptiveRealtime.setPlayStartTime(this.mStartTsMs);
                this.mAppQosLiveAdaptiveRealtime.setEnableLiveAdaptiveAdditionalQosStat(this.mEnableAdditinalQosFlag);
                this.mAppQosLiveAdaptiveRealtime.startReport(this.mOnLiveAdaptiveQosStatListener);
            }
        }
    }

    private synchronized void stopLiveAdaptiveQosStatTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            synchronized (this) {
                if (this.mAppQosLiveAdaptiveRealtime == null) {
                    return;
                }
                this.mAppQosLiveAdaptiveRealtime.stopReport();
                this.mAppQosLiveAdaptiveRealtime = null;
            }
        }
    }

    public void setEnableLiveAdaptiveAdditionalQosStat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.mEnableAdditinalQosFlag = z;
        }
    }

    public void setOnPeriodicalLiveAdaptiveQosStatListener(IMediaPlayer.OnLiveAdaptiveQosStatListener onLiveAdaptiveQosStatListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onLiveAdaptiveQosStatListener) == null) {
            this.mOnLiveAdaptiveQosStatListener = onLiveAdaptiveQosStatListener;
        }
    }

    public void setTickDurationMs(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) || j <= 0) {
            return;
        }
        this.mLiveAdaptiveQosTickDuration = j;
    }

    public void start() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.mEnable) {
            this.mStartTsMs = System.currentTimeMillis();
            startLiveAdaptiveQosStatTimer();
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.mEnable) {
            stopLiveAdaptiveQosStatTimer();
        }
    }
}
