package com.facebook.imagepipeline.producers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Closeables;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public abstract class LocalFetchProducer implements Producer<EncodedImage> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Executor mExecutor;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    public LocalFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executor, pooledByteBufferFactory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mExecutor = executor;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
    }

    public EncodedImage getByteBufferBackedEncodedImage(InputStream inputStream, int i2) throws IOException {
        InterceptResult invokeLI;
        CloseableReference of;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, inputStream, i2)) == null) {
            CloseableReference closeableReference = null;
            try {
                if (i2 <= 0) {
                    of = CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(inputStream));
                } else {
                    of = CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(inputStream, i2));
                }
                closeableReference = of;
                return new EncodedImage(closeableReference);
            } finally {
                Closeables.closeQuietly(inputStream);
                CloseableReference.closeSafely(closeableReference);
            }
        }
        return (EncodedImage) invokeLI.objValue;
    }

    public abstract EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException;

    public EncodedImage getEncodedImage(InputStream inputStream, int i2) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, inputStream, i2)) == null) ? getByteBufferBackedEncodedImage(inputStream, i2) : (EncodedImage) invokeLI.objValue;
    }

    public abstract String getProducerName();

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, consumer, producerContext) == null) {
            ProducerListener listener = producerContext.getListener();
            String id = producerContext.getId();
            StatefulProducerRunnable<EncodedImage> statefulProducerRunnable = new StatefulProducerRunnable<EncodedImage>(this, consumer, listener, getProducerName(), id, producerContext.getImageRequest(), listener, id) { // from class: com.facebook.imagepipeline.producers.LocalFetchProducer.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LocalFetchProducer this$0;
                public final /* synthetic */ ImageRequest val$imageRequest;
                public final /* synthetic */ ProducerListener val$listener;
                public final /* synthetic */ String val$requestId;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(consumer, listener, r14, id);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r3;
                        Object[] objArr = {this, consumer, listener, r14, id, r16, listener, id};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Consumer) objArr2[0], (ProducerListener) objArr2[1], (String) objArr2[2], (String) objArr2[3]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$imageRequest = r16;
                    this.val$listener = listener;
                    this.val$requestId = id;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                public void disposeResult(EncodedImage encodedImage) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, encodedImage) == null) {
                        EncodedImage.closeSafely(encodedImage);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.executors.StatefulRunnable
                @Nullable
                public EncodedImage getResult() throws Exception {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        EncodedImage encodedImage = this.this$0.getEncodedImage(this.val$imageRequest);
                        if (encodedImage == null) {
                            this.val$listener.onUltimateProducerReached(this.val$requestId, this.this$0.getProducerName(), false);
                            return null;
                        }
                        encodedImage.parseMetaData();
                        this.val$listener.onUltimateProducerReached(this.val$requestId, this.this$0.getProducerName(), true);
                        return encodedImage;
                    }
                    return (EncodedImage) invokeV.objValue;
                }
            };
            producerContext.addCallbacks(new BaseProducerContextCallbacks(this, statefulProducerRunnable) { // from class: com.facebook.imagepipeline.producers.LocalFetchProducer.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LocalFetchProducer this$0;
                public final /* synthetic */ StatefulProducerRunnable val$cancellableProducerRunnable;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, statefulProducerRunnable};
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
                    this.val$cancellableProducerRunnable = statefulProducerRunnable;
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$cancellableProducerRunnable.cancel();
                    }
                }
            });
            this.mExecutor.execute(statefulProducerRunnable);
        }
    }
}
