package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.ImagePipelineConfigProxy;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.EncodedImageOrigin;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class NetworkFetchProducer implements Producer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INTERMEDIATE_RESULT_PRODUCER_EVENT = "intermediate_result";
    public static final String PRODUCER_NAME = "NetworkFetchProducer";
    public static final int READ_SIZE = 16384;
    public static final long TIME_BETWEEN_PARTIAL_RESULTS_MS = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public final ByteArrayPool mByteArrayPool;
    public NetworkFetcher mNetworkFetcher;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    public NetworkFetchProducer(PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, NetworkFetcher networkFetcher) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pooledByteBufferFactory, byteArrayPool, networkFetcher};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mByteArrayPool = byteArrayPool;
        this.mNetworkFetcher = networkFetcher;
    }

    public static float calculateProgress(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i, i2)) == null) {
            if (i2 > 0) {
                return i / i2;
            }
            return 1.0f - ((float) Math.exp((-i) / 50000.0d));
        }
        return invokeII.floatValue;
    }

    @Nullable
    private Map getExtraMap(FetchState fetchState, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, fetchState, i)) == null) {
            if (!fetchState.getListener().requiresExtraMap(fetchState.getContext(), PRODUCER_NAME)) {
                return null;
            }
            return this.mNetworkFetcher.getExtraMap(fetchState, i);
        }
        return (Map) invokeLI.objValue;
    }

    public static void notifyConsumer(PooledByteBufferOutputStream pooledByteBufferOutputStream, int i, @Nullable BytesRange bytesRange, Consumer consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{pooledByteBufferOutputStream, Integer.valueOf(i), bytesRange, consumer, producerContext}) == null) {
            CloseableReference of = CloseableReference.of(pooledByteBufferOutputStream.toByteBuffer());
            EncodedImage encodedImage = null;
            try {
                EncodedImage encodedImage2 = new EncodedImage(of);
                try {
                    encodedImage2.setBytesRange(bytesRange);
                    encodedImage2.parseMetaData();
                    producerContext.setEncodedImageOrigin(EncodedImageOrigin.NETWORK);
                    consumer.onNewResult(encodedImage2, i);
                    EncodedImage.closeSafely(encodedImage2);
                    CloseableReference.closeSafely(of);
                } catch (Throwable th) {
                    th = th;
                    encodedImage = encodedImage2;
                    EncodedImage.closeSafely(encodedImage);
                    CloseableReference.closeSafely(of);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCancellation(FetchState fetchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, fetchState) == null) {
            fetchState.getListener().onProducerFinishWithCancellation(fetchState.getContext(), PRODUCER_NAME, null);
            fetchState.getConsumer().onCancellation();
        }
    }

    private boolean shouldPropagateIntermediateResults(FetchState fetchState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, fetchState)) == null) {
            if (!fetchState.getContext().isIntermediateResultExpected()) {
                return false;
            }
            return this.mNetworkFetcher.shouldPropagate(fetchState);
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFailure(FetchState fetchState, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, fetchState, th) == null) {
            fetchState.getListener().onProducerFinishWithFailure(fetchState.getContext(), PRODUCER_NAME, th, null);
            fetchState.getListener().onUltimateProducerReached(fetchState.getContext(), PRODUCER_NAME, false);
            fetchState.getContext().putOriginExtra("network");
            fetchState.getConsumer().onFailure(th);
        }
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, consumer, producerContext) == null) {
            producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
            if (ImagePipelineConfigProxy.getImagePipelineConfig() != null) {
                this.mNetworkFetcher = ImagePipelineConfigProxy.getImagePipelineConfig().getNetworkFetcher();
            }
            NetworkFetcher networkFetcher = this.mNetworkFetcher;
            if (networkFetcher == null) {
                return;
            }
            FetchState createFetchState = networkFetcher.createFetchState(consumer, producerContext);
            this.mNetworkFetcher.fetch(createFetchState, new NetworkFetcher.Callback(this, createFetchState) { // from class: com.facebook.imagepipeline.producers.NetworkFetchProducer.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ NetworkFetchProducer this$0;
                public final /* synthetic */ FetchState val$fetchState;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, createFetchState};
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
                    this.val$fetchState = createFetchState;
                }

                @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
                public void onCancellation() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    this.this$0.onCancellation(this.val$fetchState);
                }

                @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
                public void onFailure(Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.this$0.onFailure(this.val$fetchState, th);
                    }
                }

                @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
                public void onResponse(InputStream inputStream, int i) throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_SEND_USER_MSG, this, inputStream, i) == null) {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.beginSection("NetworkFetcher->onResponse");
                        }
                        this.this$0.onResponse(this.val$fetchState, inputStream, i);
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                    }
                }
            });
        }
    }

    public long getSystemUptime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return SystemClock.uptimeMillis();
        }
        return invokeV.longValue;
    }

    public void handleFinalResult(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pooledByteBufferOutputStream, fetchState) == null) {
            Map extraMap = getExtraMap(fetchState, pooledByteBufferOutputStream.size());
            ProducerListener2 listener = fetchState.getListener();
            listener.onProducerFinishWithSuccess(fetchState.getContext(), PRODUCER_NAME, extraMap);
            listener.onUltimateProducerReached(fetchState.getContext(), PRODUCER_NAME, true);
            fetchState.getContext().putOriginExtra("network");
            notifyConsumer(pooledByteBufferOutputStream, fetchState.getOnNewResultStatusFlags() | 1, fetchState.getResponseBytesRange(), fetchState.getConsumer(), fetchState.getContext());
        }
    }

    public void maybeHandleIntermediateResult(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pooledByteBufferOutputStream, fetchState) == null) {
            long systemUptime = getSystemUptime();
            if (shouldPropagateIntermediateResults(fetchState) && systemUptime - fetchState.getLastIntermediateResultTimeMs() >= 100) {
                fetchState.setLastIntermediateResultTimeMs(systemUptime);
                fetchState.getListener().onProducerEvent(fetchState.getContext(), PRODUCER_NAME, INTERMEDIATE_RESULT_PRODUCER_EVENT);
                notifyConsumer(pooledByteBufferOutputStream, fetchState.getOnNewResultStatusFlags(), fetchState.getResponseBytesRange(), fetchState.getConsumer(), fetchState.getContext());
            }
        }
    }

    public void onResponse(FetchState fetchState, InputStream inputStream, int i) throws IOException {
        PooledByteBufferOutputStream newOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, fetchState, inputStream, i) == null) {
            if (i > 0) {
                newOutputStream = this.mPooledByteBufferFactory.newOutputStream(i);
            } else {
                newOutputStream = this.mPooledByteBufferFactory.newOutputStream();
            }
            byte[] bArr = (byte[]) this.mByteArrayPool.get(16384);
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read >= 0) {
                        if (read > 0) {
                            newOutputStream.write(bArr, 0, read);
                            maybeHandleIntermediateResult(newOutputStream, fetchState);
                            fetchState.getConsumer().onProgressUpdate(calculateProgress(newOutputStream.size(), i));
                        }
                    } else {
                        this.mNetworkFetcher.onFetchCompletion(fetchState, newOutputStream.size());
                        handleFinalResult(newOutputStream, fetchState);
                        return;
                    }
                } finally {
                    this.mByteArrayPool.release(bArr);
                    newOutputStream.close();
                }
            }
        }
    }
}
