package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
/* loaded from: classes6.dex */
public class BitmapPrepareProducer implements Producer<CloseableReference<CloseableImage>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PRODUCER_NAME = "BitmapPrepareProducer";
    public transient /* synthetic */ FieldHolder $fh;
    public final Producer<CloseableReference<CloseableImage>> mInputProducer;
    public final int mMaxBitmapSizeBytes;
    public final int mMinBitmapSizeBytes;
    public final boolean mPreparePrefetch;

    /* loaded from: classes6.dex */
    public static class BitmapPrepareConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mMaxBitmapSizeBytes;
        public final int mMinBitmapSizeBytes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BitmapPrepareConsumer(Consumer<CloseableReference<CloseableImage>> consumer, int i2, int i3) {
            super(consumer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {consumer, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    super((Consumer) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mMinBitmapSizeBytes = i2;
            this.mMaxBitmapSizeBytes = i3;
        }

        private void internalPrepareBitmap(CloseableReference<CloseableImage> closeableReference) {
            CloseableImage closeableImage;
            Bitmap underlyingBitmap;
            int rowBytes;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, closeableReference) == null) || closeableReference == null || !closeableReference.isValid() || (closeableImage = closeableReference.get()) == null || closeableImage.isClosed() || !(closeableImage instanceof CloseableStaticBitmap) || (underlyingBitmap = ((CloseableStaticBitmap) closeableImage).getUnderlyingBitmap()) == null || (rowBytes = underlyingBitmap.getRowBytes() * underlyingBitmap.getHeight()) < this.mMinBitmapSizeBytes || rowBytes > this.mMaxBitmapSizeBytes) {
                return;
            }
            underlyingBitmap.prepareToDraw();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, closeableReference, i2) == null) {
                internalPrepareBitmap(closeableReference);
                getConsumer().onNewResult(closeableReference, i2);
            }
        }
    }

    public BitmapPrepareProducer(Producer<CloseableReference<CloseableImage>> producer, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {producer, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Preconditions.checkArgument(i2 <= i3);
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mMinBitmapSizeBytes = i2;
        this.mMaxBitmapSizeBytes = i3;
        this.mPreparePrefetch = z;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, consumer, producerContext) == null) {
            if (producerContext.isPrefetch() && !this.mPreparePrefetch) {
                this.mInputProducer.produceResults(consumer, producerContext);
            } else {
                this.mInputProducer.produceResults(new BitmapPrepareConsumer(consumer, this.mMinBitmapSizeBytes, this.mMaxBitmapSizeBytes), producerContext);
            }
        }
    }
}
