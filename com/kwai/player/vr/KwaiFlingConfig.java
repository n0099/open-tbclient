package com.kwai.player.vr;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class KwaiFlingConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long mDuring;
    public TimeInterpolator mInterpolator;
    public float mSensitivity;

    public KwaiFlingConfig() {
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
        this.mInterpolator = new DecelerateInterpolator();
        this.mDuring = 400L;
        this.mSensitivity = 1.0f;
    }

    public long getDuring() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDuring : invokeV.longValue;
    }

    public TimeInterpolator getInterpolator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mInterpolator : (TimeInterpolator) invokeV.objValue;
    }

    public float getSensitivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSensitivity : invokeV.floatValue;
    }

    public KwaiFlingConfig setDuring(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            this.mDuring = j;
            return this;
        }
        return (KwaiFlingConfig) invokeJ.objValue;
    }

    public KwaiFlingConfig setInterpolator(TimeInterpolator timeInterpolator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, timeInterpolator)) == null) {
            this.mInterpolator = timeInterpolator;
            return this;
        }
        return (KwaiFlingConfig) invokeL.objValue;
    }

    public KwaiFlingConfig setSensitivity(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
            this.mSensitivity = f2;
            return this;
        }
        return (KwaiFlingConfig) invokeF.objValue;
    }
}
