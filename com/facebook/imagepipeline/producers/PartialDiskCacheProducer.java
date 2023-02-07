package com.facebook.imagepipeline.producers;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.o0;
import com.baidu.tieba.p0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class PartialDiskCacheProducer implements Producer<EncodedImage> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "PartialDiskCacheProducer";
    public transient /* synthetic */ FieldHolder $fh;
    public final ByteArrayPool mByteArrayPool;
    public final CacheKeyFactory mCacheKeyFactory;
    public final BufferedDiskCache mDefaultBufferedDiskCache;
    public final Producer<EncodedImage> mInputProducer;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    /* loaded from: classes7.dex */
    public static class PartialDiskCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int READ_SIZE = 16384;
        public transient /* synthetic */ FieldHolder $fh;
        public final ByteArrayPool mByteArrayPool;
        public final BufferedDiskCache mDefaultBufferedDiskCache;
        @Nullable
        public final EncodedImage mPartialEncodedImageFromCache;
        public final CacheKey mPartialImageCacheKey;
        public final PooledByteBufferFactory mPooledByteBufferFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PartialDiskCacheConsumer(Consumer<EncodedImage> consumer, BufferedDiskCache bufferedDiskCache, CacheKey cacheKey, PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, @Nullable EncodedImage encodedImage) {
            super(consumer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {consumer, bufferedDiskCache, cacheKey, pooledByteBufferFactory, byteArrayPool, encodedImage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Consumer) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDefaultBufferedDiskCache = bufferedDiskCache;
            this.mPartialImageCacheKey = cacheKey;
            this.mPooledByteBufferFactory = pooledByteBufferFactory;
            this.mByteArrayPool = byteArrayPool;
            this.mPartialEncodedImageFromCache = encodedImage;
        }

        private void copy(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(65538, this, inputStream, outputStream, i) == null) {
                byte[] bArr = this.mByteArrayPool.get(16384);
                int i2 = i;
                while (i2 > 0) {
                    try {
                        int read = inputStream.read(bArr, 0, Math.min(16384, i2));
                        if (read < 0) {
                            break;
                        } else if (read > 0) {
                            outputStream.write(bArr, 0, read);
                            i2 -= read;
                        }
                    } finally {
                        this.mByteArrayPool.release(bArr);
                    }
                }
                if (i2 <= 0) {
                    return;
                }
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i), Integer.valueOf(i2)));
            }
        }

        private PooledByteBufferOutputStream merge(EncodedImage encodedImage, EncodedImage encodedImage2) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, encodedImage, encodedImage2)) == null) {
                PooledByteBufferOutputStream newOutputStream = this.mPooledByteBufferFactory.newOutputStream(encodedImage2.getSize() + encodedImage2.getBytesRange().from);
                copy(encodedImage.getInputStream(), newOutputStream, encodedImage2.getBytesRange().from);
                copy(encodedImage2.getInputStream(), newOutputStream, encodedImage2.getSize());
                return newOutputStream;
            }
            return (PooledByteBufferOutputStream) invokeLL.objValue;
        }

        private void sendFinalResultToConsumer(PooledByteBufferOutputStream pooledByteBufferOutputStream) {
            EncodedImage encodedImage;
            Throwable th;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, pooledByteBufferOutputStream) == null) {
                CloseableReference of = CloseableReference.of(pooledByteBufferOutputStream.toByteBuffer());
                try {
                    encodedImage = new EncodedImage(of);
                    try {
                        encodedImage.parseMetaData();
                        getConsumer().onNewResult(encodedImage, 1);
                        EncodedImage.closeSafely(encodedImage);
                        CloseableReference.closeSafely(of);
                    } catch (Throwable th2) {
                        th = th2;
                        EncodedImage.closeSafely(encodedImage);
                        CloseableReference.closeSafely(of);
                        throw th;
                    }
                } catch (Throwable th3) {
                    encodedImage = null;
                    th = th3;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, encodedImage, i) != null) || BaseConsumer.isNotLast(i)) {
                return;
            }
            if (this.mPartialEncodedImageFromCache != null && encodedImage.getBytesRange() != null) {
                try {
                    try {
                        sendFinalResultToConsumer(merge(this.mPartialEncodedImageFromCache, encodedImage));
                    } catch (IOException e) {
                        FLog.e(PartialDiskCacheProducer.PRODUCER_NAME, "Error while merging image data", e);
                        getConsumer().onFailure(e);
                    }
                    this.mDefaultBufferedDiskCache.remove(this.mPartialImageCacheKey);
                } finally {
                    encodedImage.close();
                    this.mPartialEncodedImageFromCache.close();
                }
            } else if (BaseConsumer.statusHasFlag(i, 8) && BaseConsumer.isLast(i) && encodedImage.getImageFormat() != ImageFormat.UNKNOWN) {
                this.mDefaultBufferedDiskCache.put(this.mPartialImageCacheKey, encodedImage);
                getConsumer().onNewResult(encodedImage, i);
            } else {
                getConsumer().onNewResult(encodedImage, i);
            }
        }
    }

    public PartialDiskCacheProducer(BufferedDiskCache bufferedDiskCache, CacheKeyFactory cacheKeyFactory, PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, Producer<EncodedImage> producer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bufferedDiskCache, cacheKeyFactory, pooledByteBufferFactory, byteArrayPool, producer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDefaultBufferedDiskCache = bufferedDiskCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mByteArrayPool = byteArrayPool;
        this.mInputProducer = producer;
    }

    public static Uri createUriForPartialCacheKey(ImageRequest imageRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, imageRequest)) == null) {
            return imageRequest.getSourceUri().buildUpon().appendQueryParameter("fresco_partial", "true").build();
        }
        return (Uri) invokeL.objValue;
    }

    public static boolean isTaskCancelled(p0<?> p0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, p0Var)) == null) {
            if (!p0Var.n() && (!p0Var.p() || !(p0Var.k() instanceof CancellationException))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @VisibleForTesting
    @Nullable
    public static Map<String, String> getExtraMap(ProducerListener2 producerListener2, ProducerContext producerContext, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{producerListener2, producerContext, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (!producerListener2.requiresExtraMap(producerContext, PRODUCER_NAME)) {
                return null;
            }
            if (z) {
                return ImmutableMap.of("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i));
            }
            return ImmutableMap.of("cached_value_found", String.valueOf(z));
        }
        return (Map) invokeCommon.objValue;
    }

    private o0<EncodedImage, Void> onFinishDiskReads(Consumer<EncodedImage> consumer, ProducerContext producerContext, CacheKey cacheKey) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, this, consumer, producerContext, cacheKey)) == null) {
            return new o0<EncodedImage, Void>(this, producerContext.getProducerListener(), producerContext, consumer, cacheKey) { // from class: com.facebook.imagepipeline.producers.PartialDiskCacheProducer.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PartialDiskCacheProducer this$0;
                public final /* synthetic */ Consumer val$consumer;
                public final /* synthetic */ ProducerListener2 val$listener;
                public final /* synthetic */ CacheKey val$partialImageCacheKey;
                public final /* synthetic */ ProducerContext val$producerContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, producerContext, consumer, cacheKey};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$listener = r7;
                    this.val$producerContext = producerContext;
                    this.val$consumer = consumer;
                    this.val$partialImageCacheKey = cacheKey;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.o0
                public Void then(p0<EncodedImage> p0Var) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p0Var)) == null) {
                        if (PartialDiskCacheProducer.isTaskCancelled(p0Var)) {
                            this.val$listener.onProducerFinishWithCancellation(this.val$producerContext, PartialDiskCacheProducer.PRODUCER_NAME, null);
                            this.val$consumer.onCancellation();
                        } else if (p0Var.p()) {
                            this.val$listener.onProducerFinishWithFailure(this.val$producerContext, PartialDiskCacheProducer.PRODUCER_NAME, p0Var.k(), null);
                            this.this$0.startInputProducer(this.val$consumer, this.val$producerContext, this.val$partialImageCacheKey, null);
                        } else {
                            EncodedImage l = p0Var.l();
                            if (l != null) {
                                ProducerListener2 producerListener2 = this.val$listener;
                                ProducerContext producerContext2 = this.val$producerContext;
                                producerListener2.onProducerFinishWithSuccess(producerContext2, PartialDiskCacheProducer.PRODUCER_NAME, PartialDiskCacheProducer.getExtraMap(producerListener2, producerContext2, true, l.getSize()));
                                BytesRange max = BytesRange.toMax(l.getSize() - 1);
                                l.setBytesRange(max);
                                int size = l.getSize();
                                ImageRequest imageRequest = this.val$producerContext.getImageRequest();
                                if (max.contains(imageRequest.getBytesRange())) {
                                    this.val$producerContext.putOriginExtra("disk", "partial");
                                    this.val$listener.onUltimateProducerReached(this.val$producerContext, PartialDiskCacheProducer.PRODUCER_NAME, true);
                                    this.val$consumer.onNewResult(l, 9);
                                } else {
                                    this.val$consumer.onNewResult(l, 8);
                                    this.this$0.startInputProducer(this.val$consumer, new SettableProducerContext(ImageRequestBuilder.fromRequest(imageRequest).setBytesRange(BytesRange.from(size - 1)).build(), this.val$producerContext), this.val$partialImageCacheKey, l);
                                }
                            } else {
                                ProducerListener2 producerListener22 = this.val$listener;
                                ProducerContext producerContext3 = this.val$producerContext;
                                producerListener22.onProducerFinishWithSuccess(producerContext3, PartialDiskCacheProducer.PRODUCER_NAME, PartialDiskCacheProducer.getExtraMap(producerListener22, producerContext3, false, 0));
                                this.this$0.startInputProducer(this.val$consumer, this.val$producerContext, this.val$partialImageCacheKey, l);
                            }
                        }
                        return null;
                    }
                    return (Void) invokeL.objValue;
                }
            };
        }
        return (o0) invokeLLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInputProducer(Consumer<EncodedImage> consumer, ProducerContext producerContext, CacheKey cacheKey, @Nullable EncodedImage encodedImage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, this, consumer, producerContext, cacheKey, encodedImage) == null) {
            this.mInputProducer.produceResults(new PartialDiskCacheConsumer(consumer, this.mDefaultBufferedDiskCache, cacheKey, this.mPooledByteBufferFactory, this.mByteArrayPool, encodedImage), producerContext);
        }
    }

    private void subscribeTaskForRequestCancellation(AtomicBoolean atomicBoolean, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, atomicBoolean, producerContext) == null) {
            producerContext.addCallbacks(new BaseProducerContextCallbacks(this, atomicBoolean) { // from class: com.facebook.imagepipeline.producers.PartialDiskCacheProducer.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PartialDiskCacheProducer this$0;
                public final /* synthetic */ AtomicBoolean val$isCancelled;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, atomicBoolean};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$isCancelled = atomicBoolean;
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$isCancelled.set(true);
                    }
                }
            });
        }
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, consumer, producerContext) == null) {
            ImageRequest imageRequest = producerContext.getImageRequest();
            if (!imageRequest.isDiskCacheEnabled()) {
                this.mInputProducer.produceResults(consumer, producerContext);
                return;
            }
            producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
            CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, createUriForPartialCacheKey(imageRequest), producerContext.getCallerContext());
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            this.mDefaultBufferedDiskCache.get(encodedCacheKey, atomicBoolean).e(onFinishDiskReads(consumer, producerContext, encodedCacheKey));
            subscribeTaskForRequestCancellation(atomicBoolean, producerContext);
        }
    }
}
