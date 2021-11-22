package com.facebook.imagepipeline.producers;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import d.d;
import d.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
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

        private void copy(InputStream inputStream, OutputStream outputStream, int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(65538, this, inputStream, outputStream, i2) == null) {
                byte[] bArr = this.mByteArrayPool.get(16384);
                int i3 = i2;
                while (i3 > 0) {
                    try {
                        int read = inputStream.read(bArr, 0, Math.min(16384, i3));
                        if (read < 0) {
                            break;
                        } else if (read > 0) {
                            outputStream.write(bArr, 0, read);
                            i3 -= read;
                        }
                    } finally {
                        this.mByteArrayPool.release(bArr);
                    }
                }
                if (i3 > 0) {
                    throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i2), Integer.valueOf(i3)));
                }
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
            if (interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, pooledByteBufferOutputStream) != null) {
                return;
            }
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PartialDiskCacheConsumer(Consumer<EncodedImage> consumer, BufferedDiskCache bufferedDiskCache, CacheKey cacheKey, PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, @Nullable EncodedImage encodedImage) {
            super(consumer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {consumer, bufferedDiskCache, cacheKey, pooledByteBufferFactory, byteArrayPool, encodedImage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, encodedImage, i2) == null) || BaseConsumer.isNotLast(i2)) {
                return;
            }
            if (this.mPartialEncodedImageFromCache != null && encodedImage.getBytesRange() != null) {
                try {
                    try {
                        sendFinalResultToConsumer(merge(this.mPartialEncodedImageFromCache, encodedImage));
                    } catch (IOException e2) {
                        FLog.e(PartialDiskCacheProducer.PRODUCER_NAME, "Error while merging image data", e2);
                        getConsumer().onFailure(e2);
                    }
                    this.mDefaultBufferedDiskCache.remove(this.mPartialImageCacheKey);
                } finally {
                    encodedImage.close();
                    this.mPartialEncodedImageFromCache.close();
                }
            } else if (BaseConsumer.statusHasFlag(i2, 8) && BaseConsumer.isLast(i2) && encodedImage.getImageFormat() != ImageFormat.UNKNOWN) {
                this.mDefaultBufferedDiskCache.put(this.mPartialImageCacheKey, encodedImage);
                getConsumer().onNewResult(encodedImage, i2);
            } else {
                getConsumer().onNewResult(encodedImage, i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, imageRequest)) == null) ? imageRequest.getSourceUri().buildUpon().appendQueryParameter("fresco_partial", "true").build() : (Uri) invokeL.objValue;
    }

    @VisibleForTesting
    @Nullable
    public static Map<String, String> getExtraMap(ProducerListener producerListener, String str, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{producerListener, str, Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            if (producerListener.requiresExtraMap(str)) {
                if (z) {
                    return ImmutableMap.of("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i2));
                }
                return ImmutableMap.of("cached_value_found", String.valueOf(z));
            }
            return null;
        }
        return (Map) invokeCommon.objValue;
    }

    public static boolean isTaskCancelled(e<?> eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, eVar)) == null) ? eVar.n() || (eVar.p() && (eVar.k() instanceof CancellationException)) : invokeL.booleanValue;
    }

    private d<EncodedImage, Void> onFinishDiskReads(Consumer<EncodedImage> consumer, ProducerContext producerContext, CacheKey cacheKey) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, consumer, producerContext, cacheKey)) == null) ? new d<EncodedImage, Void>(this, producerContext.getListener(), producerContext.getId(), consumer, producerContext, cacheKey) { // from class: com.facebook.imagepipeline.producers.PartialDiskCacheProducer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PartialDiskCacheProducer this$0;
            public final /* synthetic */ Consumer val$consumer;
            public final /* synthetic */ ProducerListener val$listener;
            public final /* synthetic */ CacheKey val$partialImageCacheKey;
            public final /* synthetic */ ProducerContext val$producerContext;
            public final /* synthetic */ String val$requestId;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, r7, r8, consumer, producerContext, cacheKey};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$listener = r7;
                this.val$requestId = r8;
                this.val$consumer = consumer;
                this.val$producerContext = producerContext;
                this.val$partialImageCacheKey = cacheKey;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.d
            public Void then(e<EncodedImage> eVar) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar)) == null) {
                    if (PartialDiskCacheProducer.isTaskCancelled(eVar)) {
                        this.val$listener.onProducerFinishWithCancellation(this.val$requestId, PartialDiskCacheProducer.PRODUCER_NAME, null);
                        this.val$consumer.onCancellation();
                    } else if (eVar.p()) {
                        this.val$listener.onProducerFinishWithFailure(this.val$requestId, PartialDiskCacheProducer.PRODUCER_NAME, eVar.k(), null);
                        this.this$0.startInputProducer(this.val$consumer, this.val$producerContext, this.val$partialImageCacheKey, null);
                    } else {
                        EncodedImage l = eVar.l();
                        if (l != null) {
                            ProducerListener producerListener = this.val$listener;
                            String str = this.val$requestId;
                            producerListener.onProducerFinishWithSuccess(str, PartialDiskCacheProducer.PRODUCER_NAME, PartialDiskCacheProducer.getExtraMap(producerListener, str, true, l.getSize()));
                            BytesRange max = BytesRange.toMax(l.getSize() - 1);
                            l.setBytesRange(max);
                            int size = l.getSize();
                            ImageRequest imageRequest = this.val$producerContext.getImageRequest();
                            if (max.contains(imageRequest.getBytesRange())) {
                                this.val$listener.onUltimateProducerReached(this.val$requestId, PartialDiskCacheProducer.PRODUCER_NAME, true);
                                this.val$consumer.onNewResult(l, 9);
                            } else {
                                this.val$consumer.onNewResult(l, 8);
                                this.this$0.startInputProducer(this.val$consumer, new SettableProducerContext(ImageRequestBuilder.fromRequest(imageRequest).setBytesRange(BytesRange.from(size - 1)).build(), this.val$producerContext), this.val$partialImageCacheKey, l);
                            }
                        } else {
                            ProducerListener producerListener2 = this.val$listener;
                            String str2 = this.val$requestId;
                            producerListener2.onProducerFinishWithSuccess(str2, PartialDiskCacheProducer.PRODUCER_NAME, PartialDiskCacheProducer.getExtraMap(producerListener2, str2, false, 0));
                            this.this$0.startInputProducer(this.val$consumer, this.val$producerContext, this.val$partialImageCacheKey, l);
                        }
                    }
                    return null;
                }
                return (Void) invokeL.objValue;
            }
        } : (d) invokeLLL.objValue;
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
            producerContext.getListener().onProducerStart(producerContext.getId(), PRODUCER_NAME);
            CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, createUriForPartialCacheKey(imageRequest), producerContext.getCallerContext());
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            this.mDefaultBufferedDiskCache.get(encodedCacheKey, atomicBoolean).e(onFinishDiskReads(consumer, producerContext, encodedCacheKey));
            subscribeTaskForRequestCancellation(atomicBoolean, producerContext);
        }
    }
}
