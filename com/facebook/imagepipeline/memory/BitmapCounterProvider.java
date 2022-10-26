package com.facebook.imagepipeline.memory;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BitmapCounterProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long KB = 1024;
    public static final int MAX_BITMAP_TOTAL_SIZE;
    public static final long MB = 1048576;
    public static volatile BitmapCounter sBitmapCounter;
    public static int sMaxBitmapCount;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1790458570, "Lcom/facebook/imagepipeline/memory/BitmapCounterProvider;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1790458570, "Lcom/facebook/imagepipeline/memory/BitmapCounterProvider;");
                return;
            }
        }
        MAX_BITMAP_TOTAL_SIZE = getMaxSizeHardCap();
        sMaxBitmapCount = 384;
    }

    public BitmapCounterProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static BitmapCounter get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sBitmapCounter == null) {
                synchronized (BitmapCounterProvider.class) {
                    if (sBitmapCounter == null) {
                        sBitmapCounter = new BitmapCounter(sMaxBitmapCount, MAX_BITMAP_TOTAL_SIZE);
                    }
                }
            }
            return sBitmapCounter;
        }
        return (BitmapCounter) invokeV.objValue;
    }

    public static int getMaxSizeHardCap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
            if (min > 16777216) {
                return (min / 4) * 3;
            }
            return min / 2;
        }
        return invokeV.intValue;
    }

    public static void initialize(BitmapCounterConfig bitmapCounterConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bitmapCounterConfig) == null) {
            if (sBitmapCounter == null) {
                sMaxBitmapCount = bitmapCounterConfig.getMaxBitmapCount();
                return;
            }
            throw new IllegalStateException("BitmapCounter has already been created! `BitmapCounterProvider.initialize(...)` should only be called before `BitmapCounterProvider.get()` or not at all!");
        }
    }
}
