package com.kwai.player.vr;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class FpsStatistic {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FPS_CALCULATE_TIME_MS = 1000;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int mFps;
    public volatile int mFpsCounter;
    public volatile boolean mFpsStar;
    public volatile long mFpsStartTimeMs;

    public FpsStatistic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFpsCounter = 0;
        this.mFps = -1;
    }

    private void resetFpsTimeAndCounter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.mFpsStartTimeMs = 0L;
            this.mFpsCounter = 0;
        }
    }

    public int getFps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mFps : invokeV.intValue;
    }

    public void onFrame() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.mFpsStar) {
                if (this.mFpsStartTimeMs <= 0) {
                    this.mFpsStartTimeMs = System.currentTimeMillis();
                }
                int currentTimeMillis = (int) (System.currentTimeMillis() - this.mFpsStartTimeMs);
                if (this.mFpsStartTimeMs <= 0 || currentTimeMillis <= 0) {
                    return;
                }
                this.mFpsCounter++;
                if (currentTimeMillis <= 1000) {
                    return;
                }
                this.mFps = this.mFpsCounter;
            }
            resetFpsTimeAndCounter();
        }
    }

    public void resetFps() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mFps = -1;
            resetFpsTimeAndCounter();
        }
    }

    public void startFps() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mFpsStar = true;
        }
    }

    public void stopFps() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mFpsStar = false;
            resetFpsTimeAndCounter();
        }
    }
}
