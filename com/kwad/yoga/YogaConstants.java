package com.kwad.yoga;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class YogaConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float UNDEFINED = Float.NaN;
    public transient /* synthetic */ FieldHolder $fh;

    public YogaConstants() {
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

    public static float getUndefined() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return Float.NaN;
        }
        return invokeV.floatValue;
    }

    public static boolean isUndefined(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65538, null, f2)) == null) ? Float.compare(f2, Float.NaN) == 0 : invokeF.booleanValue;
    }

    public static boolean isUndefined(YogaValue yogaValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, yogaValue)) == null) ? yogaValue.unit == YogaUnit.UNDEFINED : invokeL.booleanValue;
    }
}
