package com.kwai.player.qos;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.player.IMediaPlayer;
/* loaded from: classes7.dex */
public class AppQosLiveRealtimeWrapper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_MONITOR_INTERVAL = 1000;
    public static final int DEFAULT_QOS_TICK_DURATION_SEC = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public AppQosLiveRealtime mAppQosLiveRealtime;
    public final boolean mEnable;
    public IMediaPlayer.OnQosStatListener mOnQosStatListener;
    public final AppLiveReatimeInfoProvider mProvider;
    public long mTickDurMs;

    public AppQosLiveRealtimeWrapper(AppLiveReatimeInfoProvider appLiveReatimeInfoProvider, boolean z) {
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
        this.mTickDurMs = 10000L;
        this.mProvider = appLiveReatimeInfoProvider;
        this.mEnable = z;
    }

    private synchronized void startQosStatTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            synchronized (this) {
                if (this.mAppQosLiveRealtime != null) {
                    return;
                }
                AppQosLiveRealtime appQosLiveRealtime = new AppQosLiveRealtime(1000L, this.mTickDurMs, this.mProvider, new Object());
                this.mAppQosLiveRealtime = appQosLiveRealtime;
                appQosLiveRealtime.startReport(this.mOnQosStatListener);
            }
        }
    }

    private synchronized void stopQosStatTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            synchronized (this) {
                if (this.mAppQosLiveRealtime == null) {
                    return;
                }
                this.mAppQosLiveRealtime.stopReport();
                this.mAppQosLiveRealtime = null;
            }
        }
    }

    public void setOnQosStatListener(IMediaPlayer.OnQosStatListener onQosStatListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onQosStatListener) == null) {
            this.mOnQosStatListener = onQosStatListener;
        }
    }

    public void setTickDurationMs(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || j <= 0) {
            return;
        }
        this.mTickDurMs = j;
    }

    public void start(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.mEnable) {
            startQosStatTimer();
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.mEnable) {
            stopQosStatTimer();
        }
    }
}
