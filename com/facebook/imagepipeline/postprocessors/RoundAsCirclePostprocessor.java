package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.nativecode.NativeRoundingFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class RoundAsCirclePostprocessor extends BasePostprocessor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean ENABLE_ANTI_ALIASING = true;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public CacheKey mCacheKey;
    public final boolean mEnableAntiAliasing;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundAsCirclePostprocessor() {
        this(true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
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
                if (this.mEnableAntiAliasing) {
                    this.mCacheKey = new SimpleCacheKey("RoundAsCirclePostprocessor#AntiAliased");
                } else {
                    this.mCacheKey = new SimpleCacheKey("RoundAsCirclePostprocessor");
                }
            }
            return this.mCacheKey;
        }
        return (CacheKey) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
            NativeRoundingFilter.toCircle(bitmap, this.mEnableAntiAliasing);
        }
    }

    public RoundAsCirclePostprocessor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mEnableAntiAliasing = z;
    }
}
