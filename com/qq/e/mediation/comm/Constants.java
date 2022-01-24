package com.qq.e.mediation.comm;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class Constants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int VAST_CALLBACK_ALL_ADS_COMPLETED = 8;
    public static final int VAST_CALLBACK_CLICK = 6;
    public static final int VAST_CALLBACK_COMPLETE = 7;
    public static final int VAST_CALLBACK_EXPOSED = 9;
    public static final int VAST_CALLBACK_FIRST_QUARTILE = 3;
    public static final int VAST_CALLBACK_LOADED = 1;
    public static final int VAST_CALLBACK_MIDPOINT = 4;
    public static final int VAST_CALLBACK_STARTED = 2;
    public static final int VAST_CALLBACK_THIRD_QUARTILE = 5;
    public transient /* synthetic */ FieldHolder $fh;

    public Constants() {
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
