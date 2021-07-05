package com.facebook.imagepipeline.animated.factory;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.image.CloseableImage;
/* loaded from: classes6.dex */
public class AnimatedFactoryProvider {
    public static /* synthetic */ Interceptable $ic;
    public static AnimatedFactory sImpl;
    public static boolean sImplLoaded;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1555928845, "Lcom/facebook/imagepipeline/animated/factory/AnimatedFactoryProvider;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1555928845, "Lcom/facebook/imagepipeline/animated/factory/AnimatedFactoryProvider;");
        }
    }

    public AnimatedFactoryProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static AnimatedFactory getAnimatedFactory(PlatformBitmapFactory platformBitmapFactory, ExecutorSupplier executorSupplier, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{platformBitmapFactory, executorSupplier, countingMemoryCache, Boolean.valueOf(z)})) == null) {
            if (!sImplLoaded) {
                try {
                    sImpl = (AnimatedFactory) Class.forName("com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl").getConstructor(PlatformBitmapFactory.class, ExecutorSupplier.class, CountingMemoryCache.class, Boolean.TYPE).newInstance(platformBitmapFactory, executorSupplier, countingMemoryCache, Boolean.valueOf(z));
                } catch (Throwable unused) {
                }
                if (sImpl != null) {
                    sImplLoaded = true;
                }
            }
            return sImpl;
        }
        return (AnimatedFactory) invokeCommon.objValue;
    }
}
