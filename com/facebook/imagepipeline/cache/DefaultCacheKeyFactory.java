package com.facebook.imagepipeline.cache;

import android.net.Uri;
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
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class DefaultCacheKeyFactory implements CacheKeyFactory {
    public static /* synthetic */ Interceptable $ic;
    public static DefaultCacheKeyFactory sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-101396351, "Lcom/facebook/imagepipeline/cache/DefaultCacheKeyFactory;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-101396351, "Lcom/facebook/imagepipeline/cache/DefaultCacheKeyFactory;");
        }
    }

    public DefaultCacheKeyFactory() {
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

    public static synchronized DefaultCacheKeyFactory getInstance() {
        InterceptResult invokeV;
        DefaultCacheKeyFactory defaultCacheKeyFactory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (DefaultCacheKeyFactory.class) {
                if (sInstance == null) {
                    sInstance = new DefaultCacheKeyFactory();
                }
                defaultCacheKeyFactory = sInstance;
            }
            return defaultCacheKeyFactory;
        }
        return (DefaultCacheKeyFactory) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getBitmapCacheKey(ImageRequest imageRequest, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, imageRequest, obj)) == null) ? new BitmapMemoryCacheKey(getCacheKeySourceUri(imageRequest.getSourceUri()).toString(), imageRequest.getResizeOptions(), imageRequest.getRotationOptions(), imageRequest.getImageDecodeOptions(), null, null, obj) : (CacheKey) invokeLL.objValue;
    }

    public Uri getCacheKeySourceUri(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri)) == null) ? uri : (Uri) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getEncodedCacheKey(ImageRequest imageRequest, @Nullable Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, imageRequest, obj)) == null) ? getEncodedCacheKey(imageRequest, imageRequest.getSourceUri(), obj) : (CacheKey) invokeLL.objValue;
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getPostprocessedBitmapCacheKey(ImageRequest imageRequest, Object obj) {
        InterceptResult invokeLL;
        CacheKey cacheKey;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, imageRequest, obj)) == null) {
            Postprocessor postprocessor = imageRequest.getPostprocessor();
            if (postprocessor != null) {
                CacheKey postprocessorCacheKey = postprocessor.getPostprocessorCacheKey();
                str = postprocessor.getClass().getName();
                cacheKey = postprocessorCacheKey;
            } else {
                cacheKey = null;
                str = null;
            }
            return new BitmapMemoryCacheKey(getCacheKeySourceUri(imageRequest.getSourceUri()).toString(), imageRequest.getResizeOptions(), imageRequest.getRotationOptions(), imageRequest.getImageDecodeOptions(), cacheKey, str, obj);
        }
        return (CacheKey) invokeLL.objValue;
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getEncodedCacheKey(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, imageRequest, uri, obj)) == null) ? new SimpleCacheKey(getCacheKeySourceUri(uri).toString()) : (CacheKey) invokeLLL.objValue;
    }
}
