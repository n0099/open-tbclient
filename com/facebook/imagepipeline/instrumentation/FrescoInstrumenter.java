package com.facebook.imagepipeline.instrumentation;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public final class FrescoInstrumenter {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    public static volatile Instrumenter sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public interface Instrumenter {
        @Nullable
        Runnable decorateRunnable(Runnable runnable, String str);

        boolean isTracing();

        void markFailure(Object obj, Throwable th);

        @Nullable
        Object onBeforeSubmitWork(String str);

        @Nullable
        Object onBeginWork(Object obj, @Nullable String str);

        @Nullable
        void onEndWork(Object obj);
    }

    public FrescoInstrumenter() {
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

    @Nullable
    public static Runnable decorateRunnable(@Nullable Runnable runnable, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, runnable, str)) == null) {
            Instrumenter instrumenter = sInstance;
            return (instrumenter == null || runnable == null || str == null) ? runnable : instrumenter.decorateRunnable(runnable, str);
        }
        return (Runnable) invokeLL.objValue;
    }

    public static boolean isTracing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Instrumenter instrumenter = sInstance;
            if (instrumenter == null) {
                return false;
            }
            return instrumenter.isTracing();
        }
        return invokeV.booleanValue;
    }

    public static void markFailure(@Nullable Object obj, Throwable th) {
        Instrumenter instrumenter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, obj, th) == null) || (instrumenter = sInstance) == null || obj == null) {
            return;
        }
        instrumenter.markFailure(obj, th);
    }

    @Nullable
    public static Object onBeforeSubmitWork(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            Instrumenter instrumenter = sInstance;
            if (instrumenter == null || str == null) {
                return null;
            }
            return instrumenter.onBeforeSubmitWork(str);
        }
        return invokeL.objValue;
    }

    @Nullable
    public static Object onBeginWork(@Nullable Object obj, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, obj, str)) == null) {
            Instrumenter instrumenter = sInstance;
            if (instrumenter == null || obj == null) {
                return null;
            }
            return instrumenter.onBeginWork(obj, str);
        }
        return invokeLL.objValue;
    }

    public static void onEndWork(@Nullable Object obj) {
        Instrumenter instrumenter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, obj) == null) || (instrumenter = sInstance) == null || obj == null) {
            return;
        }
        instrumenter.onEndWork(obj);
    }

    public static void provide(@Nullable Instrumenter instrumenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, instrumenter) == null) {
            sInstance = instrumenter;
        }
    }
}
