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
/* loaded from: classes5.dex */
public class NativeBlurFilter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1798096581, "Lcom/facebook/imagepipeline/nativecode/NativeBlurFilter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1798096581, "Lcom/facebook/imagepipeline/nativecode/NativeBlurFilter;");
                return;
            }
        }
        NativeFiltersLoader.load();
    }

    public NativeBlurFilter() {
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

    public static void iterativeBoxBlur(Bitmap bitmap, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, bitmap, i2, i3) == null) {
            Preconditions.checkNotNull(bitmap);
            Preconditions.checkArgument(i2 > 0);
            Preconditions.checkArgument(i3 > 0);
            nativeIterativeBoxBlur(bitmap, i2, i3);
        }
    }

    @DoNotStrip
    public static native void nativeIterativeBoxBlur(Bitmap bitmap, int i2, int i3);
}
