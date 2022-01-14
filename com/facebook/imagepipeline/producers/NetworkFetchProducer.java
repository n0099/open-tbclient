package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class NetworkFetchProducer implements Producer<EncodedImage> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INTERMEDIATE_RESULT_PRODUCER_EVENT = "intermediate_result";
    public static final String PRODUCER_NAME = "NetworkFetchProducer";
    public static final int READ_SIZE = 16384;
    @VisibleForTesting
    public static final long TIME_BETWEEN_PARTIAL_RESULTS_MS = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public final ByteArrayPool mByteArrayPool;
    public final NetworkFetcher mNetworkFetcher;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    public NetworkFetchProducer(PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, NetworkFetcher networkFetcher) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pooledByteBufferFactory, byteArrayPool, networkFetcher};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mByteArrayPool = byteArrayPool;
        this.mNetworkFetcher = networkFetcher;
    }

    public static float calculateProgress(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) ? i3 > 0 ? i2 / i3 : 1.0f - ((float) Math.exp((-i2) / 50000.0d)) : invokeII.floatValue;
    }

    @Nullable
    private Map<String, String> getExtraMap(FetchState fetchState, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, fetchState, i2)) == null) {
            if (fetchState.getListener().requiresExtraMap(fetchState.getId())) {
                return this.mNetworkFetcher.getExtraMap(fetchState, i2);
            }
            return null;
        }
        return (Map) invokeLI.objValue;
    }

    public static void notifyConsumer(PooledByteBufferOutputStream pooledByteBufferOutputStream, int i2, @Nullable BytesRange bytesRange, Consumer<EncodedImage> consumer) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLILL(65541, null, pooledByteBufferOutputStream, i2, bytesRange, consumer) != null) {
            return;
        }
        CloseableReference of = CloseableReference.of(pooledByteBufferOutputStream.toByteBuffer());
        EncodedImage encodedImage = null;
        try {
            EncodedImage encodedImage2 = new EncodedImage(of);
            try {
                encodedImage2.setBytesRange(bytesRange);
                encodedImage2.parseMetaData();
                consumer.onNewResult(encodedImage2, i2);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void onCancellation(FetchState fetchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, fetchState) == null) {
            fetchState.getListener().onProducerFinishWithCancellation(fetchState.getId(), PRODUCER_NAME, null);
            fetchState.getConsumer().onCancellation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFailure(FetchState fetchState, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, fetchState, th) == null) {
            fetchState.getListener().onProducerFinishWithFailure(fetchState.getId(), PRODUCER_NAME, th, null);
            fetchState.getListener().onUltimateProducerReached(fetchState.getId(), PRODUCER_NAME, false);
            fetchState.getConsumer().onFailure(th);
        }
    }

    private boolean shouldPropagateIntermediateResults(FetchState fetchState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, fetchState)) == null) {
            if (fetchState.getContext().isIntermediateResultExpected()) {
                return this.mNetworkFetcher.shouldPropagate(fetchState);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void handleFinalResult(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, pooledByteBufferOutputStream, fetchState) == null) {
            Map<String, String> extraMap = getExtraMap(fetchState, pooledByteBufferOutputStream.size());
            ProducerListener listener = fetchState.getListener();
            listener.onProducerFinishWithSuccess(fetchState.getId(), PRODUCER_NAME, extraMap);
            listener.onUltimateProducerReached(fetchState.getId(), PRODUCER_NAME, true);
            notifyConsumer(pooledByteBufferOutputStream, fetchState.getOnNewResultStatusFlags() | 1, fetchState.getResponseBytesRange(), fetchState.getConsumer());
        }
    }

    public void maybeHandleIntermediateResult(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pooledByteBufferOutputStream, fetchState) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (!shouldPropagateIntermediateResults(fetchState) || uptimeMillis - fetchState.getLastIntermediateResultTimeMs() < 100) {
                return;
            }
            fetchState.setLastIntermediateResultTimeMs(uptimeMillis);
            fetchState.getListener().onProducerEvent(fetchState.getId(), PRODUCER_NAME, INTERMEDIATE_RESULT_PRODUCER_EVENT);
            notifyConsumer(pooledByteBufferOutputStream, fetchState.getOnNewResultStatusFlags(), fetchState.getResponseBytesRange(), fetchState.getConsumer());
        }
    }

    public void onResponse(FetchState fetchState, InputStream inputStream, int i2) throws IOException {
        PooledByteBufferOutputStream newOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, fetchState, inputStream, i2) != null) {
            return;
        }
        if (i2 > 0) {
            newOutputStream = this.mPooledByteBufferFactory.newOutputStream(i2);
        } else {
            newOutputStream = this.mPooledByteBufferFactory.newOutputStream();
        }
        byte[] bArr = this.mByteArrayPool.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    this.mNetworkFetcher.onFetchCompletion(fetchState, newOutputStream.size());
                    handleFinalResult(newOutputStream, fetchState);
                    return;
                } else if (read > 0) {
                    newOutputStream.write(bArr, 0, read);
                    maybeHandleIntermediateResult(newOutputStream, fetchState);
                    fetchState.getConsumer().onProgressUpdate(calculateProgress(newOutputStream.size(), i2));
                }
            } finally {
                this.mByteArrayPool.release(bArr);
                newOutputStream.close();
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, consumer, producerContext) == null) {
            producerContext.getListener().onProducerStart(producerContext.getId(), PRODUCER_NAME);
            FetchState createFetchState = this.mNetworkFetcher.createFetchState(consumer, producerContext);
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.onCancellation(this.val$fetchState);
                    }
                }

                @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
                public void onFailure(Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.this$0.onFailure(this.val$fetchState, th);
                    }
                }

                @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
                public void onResponse(InputStream inputStream, int i2) throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_SEND_USER_MSG, this, inputStream, i2) == null) {
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.beginSection("NetworkFetcher->onResponse");
                        }
                        this.this$0.onResponse(this.val$fetchState, inputStream, i2);
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                    }
                }
            });
        }
    }
}
