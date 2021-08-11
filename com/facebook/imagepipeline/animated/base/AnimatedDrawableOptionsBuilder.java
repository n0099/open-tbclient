package com.facebook.imagepipeline.animated.base;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class AnimatedDrawableOptionsBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAllowPrefetching;
    public boolean mEnableDebugging;
    public boolean mForceKeepAllFramesInMemory;
    public int mMaximumBytes;

    public AnimatedDrawableOptionsBuilder() {
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
        this.mAllowPrefetching = true;
        this.mMaximumBytes = -1;
    }

    public AnimatedDrawableOptions build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new AnimatedDrawableOptions(this) : (AnimatedDrawableOptions) invokeV.objValue;
    }

    public boolean getAllowPrefetching() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAllowPrefetching : invokeV.booleanValue;
    }

    public boolean getEnableDebugging() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mEnableDebugging : invokeV.booleanValue;
    }

    public boolean getForceKeepAllFramesInMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mForceKeepAllFramesInMemory : invokeV.booleanValue;
    }

    public int getMaximumBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mMaximumBytes : invokeV.intValue;
    }

    public AnimatedDrawableOptionsBuilder setAllowPrefetching(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.mAllowPrefetching = z;
            return this;
        }
        return (AnimatedDrawableOptionsBuilder) invokeZ.objValue;
    }

    public AnimatedDrawableOptionsBuilder setEnableDebugging(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.mEnableDebugging = z;
            return this;
        }
        return (AnimatedDrawableOptionsBuilder) invokeZ.objValue;
    }

    public AnimatedDrawableOptionsBuilder setForceKeepAllFramesInMemory(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
            this.mForceKeepAllFramesInMemory = z;
            return this;
        }
        return (AnimatedDrawableOptionsBuilder) invokeZ.objValue;
    }

    public AnimatedDrawableOptionsBuilder setMaximumBytes(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            this.mMaximumBytes = i2;
            return this;
        }
        return (AnimatedDrawableOptionsBuilder) invokeI.objValue;
    }
}
