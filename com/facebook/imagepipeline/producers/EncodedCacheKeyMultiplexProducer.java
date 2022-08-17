package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes4.dex */
public class EncodedCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, ImageRequest.RequestLevel>, EncodedImage> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CacheKeyFactory mCacheKeyFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EncodedCacheKeyMultiplexProducer(CacheKeyFactory cacheKeyFactory, boolean z, Producer producer) {
        super(producer, "EncodedCacheKeyMultiplexProducer", ProducerContext.ExtraKeys.MULTIPLEX_ENCODED_COUNT, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cacheKeyFactory, Boolean.valueOf(z), producer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Producer) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCacheKeyFactory = cacheKeyFactory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public EncodedImage cloneOrNull(EncodedImage encodedImage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, encodedImage)) == null) ? EncodedImage.cloneOrNull(encodedImage) : (EncodedImage) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public Pair<CacheKey, ImageRequest.RequestLevel> getKey(ProducerContext producerContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, producerContext)) == null) ? Pair.create(this.mCacheKeyFactory.getEncodedCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext()), producerContext.getLowestPermittedRequestLevel()) : (Pair) invokeL.objValue;
    }
}
