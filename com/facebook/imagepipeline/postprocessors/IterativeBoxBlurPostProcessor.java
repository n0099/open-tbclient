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
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class IterativeBoxBlurPostProcessor extends BasePostprocessor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_ITERATIONS = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mBlurRadius;
    public CacheKey mCacheKey;
    public final int mIterations;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IterativeBoxBlurPostProcessor(int i2) {
        this(3, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
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
                this.mCacheKey = new SimpleCacheKey(String.format(null, "i%dr%d", Integer.valueOf(this.mIterations), Integer.valueOf(this.mBlurRadius)));
            }
            return this.mCacheKey;
        }
        return (CacheKey) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public void process(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
            NativeBlurFilter.iterativeBoxBlur(bitmap, this.mIterations, this.mBlurRadius);
        }
    }

    public IterativeBoxBlurPostProcessor(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkArgument(i3 > 0);
        this.mIterations = i2;
        this.mBlurRadius = i3;
    }
}
