package com.qq.e.comm.constants;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AdPatternType {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NATIVE_1IMAGE_2TEXT = 4;
    public static final int NATIVE_2IMAGE_2TEXT = 1;
    public static final int NATIVE_3IMAGE = 3;
    public static final int NATIVE_VIDEO = 2;
    public transient /* synthetic */ FieldHolder $fh;

    public AdPatternType() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
