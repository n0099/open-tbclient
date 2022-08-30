package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.filter.InPlaceRoundFilter;
import com.facebook.imagepipeline.filter.XferRoundFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class RoundPostprocessor extends BasePostprocessor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean ENABLE_ANTI_ALIASING = true;
    public static final boolean canUseXferRoundFilter;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public CacheKey mCacheKey;
    public final boolean mEnableAntiAliasing;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1460834838, "Lcom/facebook/imagepipeline/postprocessors/RoundPostprocessor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1460834838, "Lcom/facebook/imagepipeline/postprocessors/RoundPostprocessor;");
                return;
            }
        }
        canUseXferRoundFilter = XferRoundFilter.canUseXferRoundFilter();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundPostprocessor() {
        this(true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    @Nullable
    public CacheKey getPostprocessorCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mCacheKey == null) {
                if (canUseXferRoundFilter) {
                    this.mCacheKey = new SimpleCacheKey("XferRoundFilter");
                } else {
                    this.mCacheKey = new SimpleCacheKey("InPlaceRoundFilter");
                }
            }
            return this.mCacheKey;
        }
        return (CacheKey) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap, Bitmap bitmap2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bitmap, bitmap2) == null) {
            Preconditions.checkNotNull(bitmap);
            Preconditions.checkNotNull(bitmap2);
            if (canUseXferRoundFilter) {
                XferRoundFilter.xferRoundBitmap(bitmap, bitmap2, this.mEnableAntiAliasing);
            } else {
                super.process(bitmap, bitmap2);
            }
        }
    }

    public RoundPostprocessor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mEnableAntiAliasing = z;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
            InPlaceRoundFilter.roundBitmapInPlace(bitmap);
        }
    }
}
