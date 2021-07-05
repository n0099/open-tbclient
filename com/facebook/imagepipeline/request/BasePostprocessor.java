package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public abstract class BasePostprocessor implements Postprocessor {
    public static /* synthetic */ Interceptable $ic;
    public static final Bitmap.Config FALLBACK_BITMAP_CONFIGURATION;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2033488133, "Lcom/facebook/imagepipeline/request/BasePostprocessor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2033488133, "Lcom/facebook/imagepipeline/request/BasePostprocessor;");
                return;
            }
        }
        FALLBACK_BITMAP_CONFIGURATION = Bitmap.Config.ARGB_8888;
    }

    public BasePostprocessor() {
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

    public static void internalCopyBitmap(Bitmap bitmap, Bitmap bitmap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, bitmap, bitmap2) == null) {
            if (bitmap.getConfig() == bitmap2.getConfig()) {
                Bitmaps.copyBitmap(bitmap, bitmap2);
            } else {
                new Canvas(bitmap).drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Unknown postprocessor" : (String) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    @Nullable
    public CacheKey getPostprocessorCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (CacheKey) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bitmap, platformBitmapFactory)) == null) {
            Bitmap.Config config = bitmap.getConfig();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (config == null) {
                config = FALLBACK_BITMAP_CONFIGURATION;
            }
            CloseableReference<Bitmap> createBitmapInternal = platformBitmapFactory.createBitmapInternal(width, height, config);
            try {
                process(createBitmapInternal.get(), bitmap);
                return CloseableReference.cloneOrNull(createBitmapInternal);
            } finally {
                CloseableReference.closeSafely(createBitmapInternal);
            }
        }
        return (CloseableReference) invokeLL.objValue;
    }

    public void process(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bitmap) == null) {
        }
    }

    public void process(Bitmap bitmap, Bitmap bitmap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bitmap, bitmap2) == null) {
            internalCopyBitmap(bitmap, bitmap2);
            process(bitmap);
        }
    }
}
