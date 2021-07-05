package com.kwai.video.hodor.debuginfo.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class HodorDebugInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String dirManagerMediaStatus;
    public String dirManagerResourceStatus;
    public String networkCurrentNetStatus;
    public boolean networkIsConnected;
    public boolean networkIsWifi;
    public String networkMonitorSpeedStatus;
    public String preloadV3Status;
    public boolean preloadV3ToPausePreload;
    public String queueStatus;
    public String threadWorkerStatus;

    public HodorDebugInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
