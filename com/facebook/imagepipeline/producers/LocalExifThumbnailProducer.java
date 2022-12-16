package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.imageutils.JfifUtil;
import com.facebook.soloader.DoNotOptimize;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class LocalExifThumbnailProducer implements ThumbnailProducer<EncodedImage> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COMMON_EXIF_THUMBNAIL_MAX_DIMENSION = 512;
    @VisibleForTesting
    public static final String CREATED_THUMBNAIL = "createdThumbnail";
    public static final String PRODUCER_NAME = "LocalExifThumbnailProducer";
    public transient /* synthetic */ FieldHolder $fh;
    public final ContentResolver mContentResolver;
    public final Executor mExecutor;
    public final PooledByteBufferFactory mPooledByteBufferFactory;

    @DoNotOptimize
    /* loaded from: classes7.dex */
    public class Api24Utils {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LocalExifThumbnailProducer this$0;

        public Api24Utils(LocalExifThumbnailProducer localExifThumbnailProducer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {localExifThumbnailProducer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = localExifThumbnailProducer;
        }

        public ExifInterface getExifInterface(FileDescriptor fileDescriptor) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fileDescriptor)) == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    return new ExifInterface(fileDescriptor);
                }
                return null;
            }
            return (ExifInterface) invokeL.objValue;
        }
    }

    public LocalExifThumbnailProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executor, pooledByteBufferFactory, contentResolver};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mExecutor = executor;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mContentResolver = contentResolver;
    }

    private int getRotationAngle(ExifInterface exifInterface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, exifInterface)) == null) {
            return JfifUtil.getAutoRotateAngleFromOrientation(Integer.parseInt(exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION)));
        }
        return invokeL.intValue;
    }

    @Override // com.facebook.imagepipeline.producers.ThumbnailProducer
    public boolean canProvideImageForSize(ResizeOptions resizeOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, resizeOptions)) == null) {
            return ThumbnailSizeChecker.isImageBigEnough(512, 512, resizeOptions);
        }
        return invokeL.booleanValue;
    }

    @VisibleForTesting
    public boolean canReadAsFile(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str == null) {
                return false;
            }
            File file = new File(str);
            if (!file.exists() || !file.canRead()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EncodedImage buildEncodedImage(PooledByteBuffer pooledByteBuffer, ExifInterface exifInterface) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, pooledByteBuffer, exifInterface)) == null) {
            Pair<Integer, Integer> decodeDimensions = BitmapUtil.decodeDimensions(new PooledByteBufferInputStream(pooledByteBuffer));
            int rotationAngle = getRotationAngle(exifInterface);
            int i2 = -1;
            if (decodeDimensions != null) {
                i = ((Integer) decodeDimensions.first).intValue();
            } else {
                i = -1;
            }
            if (decodeDimensions != null) {
                i2 = ((Integer) decodeDimensions.second).intValue();
            }
            CloseableReference of = CloseableReference.of(pooledByteBuffer);
            try {
                EncodedImage encodedImage = new EncodedImage(of);
                CloseableReference.closeSafely(of);
                encodedImage.setImageFormat(DefaultImageFormats.JPEG);
                encodedImage.setRotationAngle(rotationAngle);
                encodedImage.setWidth(i);
                encodedImage.setHeight(i2);
                return encodedImage;
            } catch (Throwable th) {
                CloseableReference.closeSafely(of);
                throw th;
            }
        }
        return (EncodedImage) invokeLL.objValue;
    }

    @VisibleForTesting
    @Nullable
    public ExifInterface getExifInterface(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uri)) == null) {
            String realPathFromUri = UriUtil.getRealPathFromUri(this.mContentResolver, uri);
            try {
            } catch (IOException unused) {
            } catch (StackOverflowError unused2) {
                FLog.e(LocalExifThumbnailProducer.class, "StackOverflowError in ExifInterface constructor");
            }
            if (canReadAsFile(realPathFromUri)) {
                return new ExifInterface(realPathFromUri);
            }
            AssetFileDescriptor assetFileDescriptor = UriUtil.getAssetFileDescriptor(this.mContentResolver, uri);
            if (assetFileDescriptor != null && Build.VERSION.SDK_INT >= 24) {
                ExifInterface exifInterface = new Api24Utils().getExifInterface(assetFileDescriptor.getFileDescriptor());
                assetFileDescriptor.close();
                return exifInterface;
            }
            return null;
        }
        return (ExifInterface) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, consumer, producerContext) == null) {
            ProducerListener2 producerListener = producerContext.getProducerListener();
            ImageRequest imageRequest = producerContext.getImageRequest();
            producerContext.putOriginExtra("local", "exif");
            StatefulProducerRunnable<EncodedImage> statefulProducerRunnable = new StatefulProducerRunnable<EncodedImage>(this, consumer, producerListener, producerContext, PRODUCER_NAME, imageRequest) { // from class: com.facebook.imagepipeline.producers.LocalExifThumbnailProducer.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LocalExifThumbnailProducer this$0;
                public final /* synthetic */ ImageRequest val$imageRequest;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(consumer, producerListener, producerContext, r14);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, consumer, producerListener, producerContext, r14, imageRequest};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Consumer) objArr2[0], (ProducerListener2) objArr2[1], (ProducerContext) objArr2[2], (String) objArr2[3]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$imageRequest = imageRequest;
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
                @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
                public Map<String, String> getExtraMapOnSuccess(EncodedImage encodedImage) {
                    InterceptResult invokeL;
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, encodedImage)) == null) {
                        if (encodedImage != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        return ImmutableMap.of("createdThumbnail", Boolean.toString(z));
                    }
                    return (Map) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.executors.StatefulRunnable
                @Nullable
                public EncodedImage getResult() throws Exception {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        ExifInterface exifInterface = this.this$0.getExifInterface(this.val$imageRequest.getSourceUri());
                        if (exifInterface != null && exifInterface.hasThumbnail()) {
                            return this.this$0.buildEncodedImage(this.this$0.mPooledByteBufferFactory.newByteBuffer(exifInterface.getThumbnail()), exifInterface);
                        }
                        return null;
                    }
                    return (EncodedImage) invokeV.objValue;
                }
            };
            producerContext.addCallbacks(new BaseProducerContextCallbacks(this, statefulProducerRunnable) { // from class: com.facebook.imagepipeline.producers.LocalExifThumbnailProducer.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LocalExifThumbnailProducer this$0;
                public final /* synthetic */ StatefulProducerRunnable val$cancellableProducerRunnable;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, statefulProducerRunnable};
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
