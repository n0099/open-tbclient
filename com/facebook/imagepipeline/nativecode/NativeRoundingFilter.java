package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
@DoNotStrip
/* loaded from: classes7.dex */
public class NativeRoundingFilter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @DoNotStrip
    public static native void nativeAddRoundedCornersFilter(Bitmap bitmap, int i, int i2, int i3, int i4);

    @DoNotStrip
    public static native void nativeToCircleFastFilter(Bitmap bitmap, boolean z);

    @DoNotStrip
    public static native void nativeToCircleFilter(Bitmap bitmap, boolean z);

    @DoNotStrip
    public static native void nativeToCircleWithBorderFilter(Bitmap bitmap, int i, int i2, boolean z);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(518656494, "Lcom/facebook/imagepipeline/nativecode/NativeRoundingFilter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(518656494, "Lcom/facebook/imagepipeline/nativecode/NativeRoundingFilter;");
                return;
            }
        }
        NativeFiltersLoader.load();
    }

    public NativeRoundingFilter() {
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

    public static void addRoundedCorners(Bitmap bitmap, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            nativeAddRoundedCornersFilter(bitmap, i, i2, i3, i4);
        }
    }

    public static void toCircle(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, bitmap) == null) {
            toCircle(bitmap, false);
        }
    }

    public static void toCircleFast(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, bitmap) == null) {
            toCircleFast(bitmap, false);
        }
    }

    @DoNotStrip
    public static void toCircle(Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, null, bitmap, z) == null) {
            Preconditions.checkNotNull(bitmap);
            nativeToCircleFilter(bitmap, z);
        }
    }

    @DoNotStrip
    public static void toCircleFast(Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65546, null, bitmap, z) == null) {
            Preconditions.checkNotNull(bitmap);
            nativeToCircleFastFilter(bitmap, z);
        }
    }

    public static void toCircleWithBorder(Bitmap bitmap, int i, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            Preconditions.checkNotNull(bitmap);
            nativeToCircleWithBorderFilter(bitmap, i, i2, z);
        }
    }
}
