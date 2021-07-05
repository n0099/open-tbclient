package com.bytedance.sdk.openadsdk.preload.falconx.statistic;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.a.a.c;
import java.util.List;
@Keep
/* loaded from: classes6.dex */
public class StatisticData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ERROR_CODE_IO_ERROR = "101";
    public static final String ERROR_CODE_NOT_FOUND = "100";
    public transient /* synthetic */ FieldHolder $fh;
    @c(a = "common")
    public Common mCommon;
    @c(a = "offline")
    public List<InterceptorModel> offline;

    public StatisticData() {
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
