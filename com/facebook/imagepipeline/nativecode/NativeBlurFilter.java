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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void iterativeBoxBlur(Bitmap bitmap, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, bitmap, i, i2) == null) {
            Preconditions.checkNotNull(bitmap);
            Preconditions.checkArgument(i > 0);
            Preconditions.checkArgument(i2 > 0);
            nativeIterativeBoxBlur(bitmap, i, i2);
        }
    }

    @DoNotStrip
    public static native void nativeIterativeBoxBlur(Bitmap bitmap, int i, int i2);
}
