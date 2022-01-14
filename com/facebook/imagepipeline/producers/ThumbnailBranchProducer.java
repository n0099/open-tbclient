package com.facebook.imagepipeline.producers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
/* loaded from: classes3.dex */
public class ThumbnailBranchProducer implements Producer<EncodedImage> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ThumbnailProducer<EncodedImage>[] mThumbnailProducers;

    /* loaded from: classes3.dex */
    public class ThumbnailConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ProducerContext mProducerContext;
        public final int mProducerIndex;
        public final ResizeOptions mResizeOptions;
        public final /* synthetic */ ThumbnailBranchProducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ThumbnailConsumer(ThumbnailBranchProducer thumbnailBranchProducer, Consumer<EncodedImage> consumer, ProducerContext producerContext, int i2) {
            super(consumer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {thumbnailBranchProducer, consumer, producerContext, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((Consumer) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = thumbnailBranchProducer;
            this.mProducerContext = producerContext;
            this.mProducerIndex = i2;
            this.mResizeOptions = producerContext.getImageRequest().getResizeOptions();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, th) == null) || this.this$0.produceResultsFromThumbnailProducer(this.mProducerIndex + 1, getConsumer(), this.mProducerContext)) {
                return;
            }
            getConsumer().onFailure(th);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, encodedImage, i2) == null) {
                if (encodedImage != null && (BaseConsumer.isNotLast(i2) || ThumbnailSizeChecker.isImageBigEnough(encodedImage, this.mResizeOptions))) {
                    getConsumer().onNewResult(encodedImage, i2);
                } else if (BaseConsumer.isLast(i2)) {
                    EncodedImage.closeSafely(encodedImage);
                    if (this.this$0.produceResultsFromThumbnailProducer(this.mProducerIndex + 1, getConsumer(), this.mProducerContext)) {
                        return;
                    }
                    getConsumer().onNewResult(null, 1);
                }
            }
        }
    }

    public ThumbnailBranchProducer(ThumbnailProducer<EncodedImage>... thumbnailProducerArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {thumbnailProducerArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ThumbnailProducer<EncodedImage>[] thumbnailProducerArr2 = (ThumbnailProducer[]) Preconditions.checkNotNull(thumbnailProducerArr);
        this.mThumbnailProducers = thumbnailProducerArr2;
        Preconditions.checkElementIndex(0, thumbnailProducerArr2.length);
    }

    private int findFirstProducerForSize(int i2, ResizeOptions resizeOptions) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeIL = interceptable.invokeIL(65538, this, i2, resizeOptions)) != null) {
            return invokeIL.intValue;
        }
        while (true) {
            ThumbnailProducer<EncodedImage>[] thumbnailProducerArr = this.mThumbnailProducers;
            if (i2 >= thumbnailProducerArr.length) {
                return -1;
            }
            if (thumbnailProducerArr[i2].canProvideImageForSize(resizeOptions)) {
                return i2;
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean produceResultsFromThumbnailProducer(int i2, Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65539, this, i2, consumer, producerContext)) == null) {
            int findFirstProducerForSize = findFirstProducerForSize(i2, producerContext.getImageRequest().getResizeOptions());
            if (findFirstProducerForSize == -1) {
                return false;
            }
            this.mThumbnailProducers[findFirstProducerForSize].produceResults(new ThumbnailConsumer(this, consumer, producerContext, findFirstProducerForSize), producerContext);
            return true;
        }
        return invokeILL.booleanValue;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, consumer, producerContext) == null) {
            if (producerContext.getImageRequest().getResizeOptions() == null) {
                consumer.onNewResult(null, 1);
            } else if (produceResultsFromThumbnailProducer(0, consumer, producerContext)) {
            } else {
                consumer.onNewResult(null, 1);
            }
        }
    }
}
