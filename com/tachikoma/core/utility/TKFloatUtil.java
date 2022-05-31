package com.tachikoma.core.utility;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class TKFloatUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float EPSILON = 1.0E-5f;
    public transient /* synthetic */ FieldHolder $fh;

    public TKFloatUtil() {
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

    public static boolean floatsEqual(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) ? (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) && Float.isNaN(f2) : Math.abs(f2 - f) < 1.0E-5f : invokeCommon.booleanValue;
    }
}
