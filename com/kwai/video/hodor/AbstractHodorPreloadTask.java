package com.kwai.video.hodor;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.hodor.anotations.AccessedByNative;
/* loaded from: classes7.dex */
public abstract class AbstractHodorPreloadTask extends AbstractHodorTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @AccessedByNative
    public int mOnlyPreloadUnderSpeedKbps;

    public AbstractHodorPreloadTask() {
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
        this.mOnlyPreloadUnderSpeedKbps = -1;
    }

    public void setOnlyPreloadUnderSpeedKbps(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.mOnlyPreloadUnderSpeedKbps = i2;
        }
    }
}
