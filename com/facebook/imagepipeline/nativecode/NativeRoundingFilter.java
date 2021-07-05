package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes6.dex */
public class NativeRoundingFilter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @DoNotStrip
    public static native void nativeToCircleFilter(Bitmap bitmap, boolean z);

    @DoNotStrip
    public static native void nativeToCircleWithBorderFilter(Bitmap bitmap, int i2, int i3, boolean z);

    public static void toCircle(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, bitmap) == null) {
            toCircle(bitmap, false);
        }
    }

    public static void toCircleWithBorder(Bitmap bitmap, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{bitmap, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            Preconditions.checkNotNull(bitmap);
            nativeToCircleWithBorderFilter(bitmap, i2, i3, z);
        }
    }

    public static void toCircle(Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, null, bitmap, z) == null) {
            Preconditions.checkNotNull(bitmap);
            nativeToCircleFilter(bitmap, z);
        }
    }
}
