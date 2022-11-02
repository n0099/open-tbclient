package com.facebook.imagepipeline.producers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes7.dex */
public class BranchOnSeparateImagesProducer implements Producer<EncodedImage> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Producer<EncodedImage> mInputProducer1;
    public final Producer<EncodedImage> mInputProducer2;

    /* renamed from: com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class OnFirstImageConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ProducerContext mProducerContext;
        public final /* synthetic */ BranchOnSeparateImagesProducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnFirstImageConsumer(BranchOnSeparateImagesProducer branchOnSeparateImagesProducer, Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {branchOnSeparateImagesProducer, consumer, producerContext};
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
            this.this$0 = branchOnSeparateImagesProducer;
            this.mProducerContext = producerContext;
        }

        public /* synthetic */ OnFirstImageConsumer(BranchOnSeparateImagesProducer branchOnSeparateImagesProducer, Consumer consumer, ProducerContext producerContext, AnonymousClass1 anonymousClass1) {
            this(branchOnSeparateImagesProducer, consumer, producerContext);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.this$0.mInputProducer2.produceResults(getConsumer(), this.mProducerContext);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, encodedImage, i) == null) {
                ImageRequest imageRequest = this.mProducerContext.getImageRequest();
                boolean isLast = BaseConsumer.isLast(i);
                boolean isImageBigEnough = ThumbnailSizeChecker.isImageBigEnough(encodedImage, imageRequest.getResizeOptions());
                if (encodedImage != null && (isImageBigEnough || imageRequest.getLocalThumbnailPreviewsEnabled())) {
                    if (isLast && isImageBigEnough) {
                        getConsumer().onNewResult(encodedImage, i);
                    } else {
                        getConsumer().onNewResult(encodedImage, BaseConsumer.turnOffStatusFlag(i, 1));
                    }
                }
                if (isLast && !isImageBigEnough) {
                    EncodedImage.closeSafely(encodedImage);
                    this.this$0.mInputProducer2.produceResults(getConsumer(), this.mProducerContext);
                }
            }
        }
    }

    public BranchOnSeparateImagesProducer(Producer<EncodedImage> producer, Producer<EncodedImage> producer2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {producer, producer2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mInputProducer1 = producer;
        this.mInputProducer2 = producer2;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, consumer, producerContext) == null) {
            this.mInputProducer1.produceResults(new OnFirstImageConsumer(this, consumer, producerContext, null), producerContext);
        }
    }
}
