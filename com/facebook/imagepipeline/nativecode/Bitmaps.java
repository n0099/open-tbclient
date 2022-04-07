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
/* loaded from: classes4.dex */
public class Bitmaps {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1606649441, "Lcom/facebook/imagepipeline/nativecode/Bitmaps;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1606649441, "Lcom/facebook/imagepipeline/nativecode/Bitmaps;");
                return;
            }
        }
        ImagePipelineNativeLoader.load();
    }

    public Bitmaps() {
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

    public static void copyBitmap(Bitmap bitmap, Bitmap bitmap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, bitmap, bitmap2) == null) {
            Preconditions.checkArgument(bitmap2.getConfig() == bitmap.getConfig());
            Preconditions.checkArgument(bitmap.isMutable());
            Preconditions.checkArgument(bitmap.getWidth() == bitmap2.getWidth());
            Preconditions.checkArgument(bitmap.getHeight() == bitmap2.getHeight());
            nativeCopyBitmap(bitmap, bitmap.getRowBytes(), bitmap2, bitmap2.getRowBytes(), bitmap.getHeight());
        }
    }

    @DoNotStrip
    public static native void nativeCopyBitmap(Bitmap bitmap, int i, Bitmap bitmap2, int i2, int i3);
}
