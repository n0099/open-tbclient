package com.facebook.imagepipeline.cache;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.common.util.HashCodeUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes11.dex */
public class BitmapMemoryCacheKey implements CacheKey {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long mCacheTime;
    public final Object mCallerContext;
    public final int mHash;
    public final ImageDecodeOptions mImageDecodeOptions;
    @Nullable
    public final CacheKey mPostprocessorCacheKey;
    @Nullable
    public final String mPostprocessorName;
    @Nullable
    public final ResizeOptions mResizeOptions;
    public final RotationOptions mRotationOptions;
    public final String mSourceString;

    public BitmapMemoryCacheKey(String str, @Nullable ResizeOptions resizeOptions, RotationOptions rotationOptions, ImageDecodeOptions imageDecodeOptions, @Nullable CacheKey cacheKey, @Nullable String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, resizeOptions, rotationOptions, imageDecodeOptions, cacheKey, str2, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSourceString = (String) Preconditions.checkNotNull(str);
        this.mResizeOptions = resizeOptions;
        this.mRotationOptions = rotationOptions;
        this.mImageDecodeOptions = imageDecodeOptions;
        this.mPostprocessorCacheKey = cacheKey;
        this.mPostprocessorName = str2;
        this.mHash = HashCodeUtil.hashCode(Integer.valueOf(str.hashCode()), Integer.valueOf(resizeOptions != null ? resizeOptions.hashCode() : 0), Integer.valueOf(rotationOptions.hashCode()), this.mImageDecodeOptions, this.mPostprocessorCacheKey, str2);
        this.mCallerContext = obj;
        this.mCacheTime = RealtimeSinceBootClock.get().now();
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean containsUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uri)) == null) ? getUriString().contains(uri.toString()) : invokeL.booleanValue;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj instanceof BitmapMemoryCacheKey) {
                BitmapMemoryCacheKey bitmapMemoryCacheKey = (BitmapMemoryCacheKey) obj;
                return this.mHash == bitmapMemoryCacheKey.mHash && this.mSourceString.equals(bitmapMemoryCacheKey.mSourceString) && Objects.equal(this.mResizeOptions, bitmapMemoryCacheKey.mResizeOptions) && Objects.equal(this.mRotationOptions, bitmapMemoryCacheKey.mRotationOptions) && Objects.equal(this.mImageDecodeOptions, bitmapMemoryCacheKey.mImageDecodeOptions) && Objects.equal(this.mPostprocessorCacheKey, bitmapMemoryCacheKey.mPostprocessorCacheKey) && Objects.equal(this.mPostprocessorName, bitmapMemoryCacheKey.mPostprocessorName);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Object getCallerContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCallerContext : invokeV.objValue;
    }

    public long getInBitmapCacheSince() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCacheTime : invokeV.longValue;
    }

    @Nullable
    public String getPostprocessorName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPostprocessorName : (String) invokeV.objValue;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String getUriString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mSourceString : (String) invokeV.objValue;
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mHash : invokeV.intValue;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean isResourceIdForDebugging() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.mSourceString, this.mResizeOptions, this.mRotationOptions, this.mImageDecodeOptions, this.mPostprocessorCacheKey, this.mPostprocessorName, Integer.valueOf(this.mHash)) : (String) invokeV.objValue;
    }
}
