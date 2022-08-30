package com.facebook.imagepipeline.animated.base;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes7.dex */
public class AnimatedDrawableOptions {
    public static /* synthetic */ Interceptable $ic;
    public static AnimatedDrawableOptions DEFAULTS;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean allowPrefetching;
    public final boolean enableDebugging;
    public final boolean forceKeepAllFramesInMemory;
    public final int maximumBytes;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-401414095, "Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableOptions;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-401414095, "Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableOptions;");
                return;
            }
        }
        DEFAULTS = newBuilder().build();
    }

    public AnimatedDrawableOptions(AnimatedDrawableOptionsBuilder animatedDrawableOptionsBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animatedDrawableOptionsBuilder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.forceKeepAllFramesInMemory = animatedDrawableOptionsBuilder.getForceKeepAllFramesInMemory();
        this.allowPrefetching = animatedDrawableOptionsBuilder.getAllowPrefetching();
        this.maximumBytes = animatedDrawableOptionsBuilder.getMaximumBytes();
        this.enableDebugging = animatedDrawableOptionsBuilder.getEnableDebugging();
    }

    public static AnimatedDrawableOptionsBuilder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new AnimatedDrawableOptionsBuilder() : (AnimatedDrawableOptionsBuilder) invokeV.objValue;
    }
}
