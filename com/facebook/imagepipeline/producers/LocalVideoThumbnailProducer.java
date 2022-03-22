package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.ImageClipActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class LocalVideoThumbnailProducer implements Producer<CloseableReference<CloseableImage>> {
    public static /* synthetic */ Interceptable $ic = null;
    @VisibleForTesting
    public static final String CREATED_THUMBNAIL = "createdThumbnail";
    public static final String PRODUCER_NAME = "VideoThumbnailProducer";
    public transient /* synthetic */ FieldHolder $fh;
    public final ContentResolver mContentResolver;
    public final Executor mExecutor;

    public LocalVideoThumbnailProducer(Executor executor, ContentResolver contentResolver) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executor, contentResolver};
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
        this.mContentResolver = contentResolver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap baiduAppCreateVideoThumbnail(ImageRequest imageRequest) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, imageRequest)) == null) {
            ResizeOptions resizeOptions = imageRequest.getResizeOptions();
            int i2 = 0;
            if (resizeOptions != null) {
                i2 = resizeOptions.width;
                i = resizeOptions.height;
            } else {
                i = 0;
            }
            if (i2 > 0 && i > 0) {
                return createExtractVideoThumbnail(getLocalFilePath(imageRequest), i2, i);
            }
            return ThumbnailUtils.createVideoThumbnail(getLocalFilePath(imageRequest), calculateKind(imageRequest));
        }
        return (Bitmap) invokeL.objValue;
    }

    public static int calculateKind(ImageRequest imageRequest) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, imageRequest)) == null) ? (imageRequest.getPreferredWidth() > 96 || imageRequest.getPreferredHeight() > 96) ? 1 : 3 : invokeL.intValue;
    }

    private Bitmap createExtractVideoThumbnail(String str, int i, int i2) {
        InterceptResult invokeLII;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, this, str, i, i2)) == null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    bitmap = mediaMetadataRetriever.getFrameAtTime(-1L);
                    try {
                        mediaMetadataRetriever.release();
                    } catch (RuntimeException e2) {
                        e2.printStackTrace();
                    }
                } catch (RuntimeException e3) {
                    e3.printStackTrace();
                    try {
                        mediaMetadataRetriever.release();
                    } catch (RuntimeException e4) {
                        e4.printStackTrace();
                    }
                    bitmap = null;
                }
                if (bitmap == null) {
                    return null;
                }
                return ThumbnailUtils.extractThumbnail(bitmap, i, i2);
            } catch (Throwable th) {
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e5) {
                    e5.printStackTrace();
                }
                throw th;
            }
        }
        return (Bitmap) invokeLII.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String getLocalFilePath(ImageRequest imageRequest) {
        InterceptResult invokeL;
        Uri uri;
        String str;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, imageRequest)) == null) {
            Uri sourceUri = imageRequest.getSourceUri();
            if (UriUtil.isLocalFileUri(sourceUri)) {
                return imageRequest.getSourceFile().getPath();
            }
            if (UriUtil.isLocalContentUri(sourceUri)) {
                if (Build.VERSION.SDK_INT < 19 || !ImageClipActivity.k.equals(sourceUri.getAuthority())) {
                    uri = sourceUri;
                    str = null;
                    strArr = null;
                } else {
                    String documentId = DocumentsContract.getDocumentId(sourceUri);
                    str = "_id=?";
                    uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    strArr = new String[]{documentId.split(":")[1]};
                }
                Cursor query = this.mContentResolver.query(uri, new String[]{"_data"}, str, strArr, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            return query.getString(query.getColumnIndexOrThrow("_data"));
                        }
                    } finally {
                        if (query != null) {
                            query.close();
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, consumer, producerContext) == null) {
            ProducerListener listener = producerContext.getListener();
            String id = producerContext.getId();
            StatefulProducerRunnable<CloseableReference<CloseableImage>> statefulProducerRunnable = new StatefulProducerRunnable<CloseableReference<CloseableImage>>(this, consumer, listener, PRODUCER_NAME, id, listener, id, producerContext.getImageRequest()) { // from class: com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LocalVideoThumbnailProducer this$0;
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
                        Object[] objArr = {this, consumer, listener, r14, id, listener, id, r18};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((Consumer) objArr2[0], (ProducerListener) objArr2[1], (String) objArr2[2], (String) objArr2[3]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$listener = listener;
                    this.val$requestId = id;
                    this.val$imageRequest = r18;
                }

                @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                public void onFailure(Exception exc) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048582, this, exc) == null) {
                        super.onFailure(exc);
                        this.val$listener.onUltimateProducerReached(this.val$requestId, LocalVideoThumbnailProducer.PRODUCER_NAME, false);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                public void disposeResult(CloseableReference<CloseableImage> closeableReference) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, closeableReference) == null) {
                        CloseableReference.closeSafely(closeableReference);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
                public Map<String, String> getExtraMapOnSuccess(CloseableReference<CloseableImage> closeableReference) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, closeableReference)) == null) {
                        return ImmutableMap.of("createdThumbnail", String.valueOf(closeableReference != null));
                    }
                    return (Map) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.executors.StatefulRunnable
                @Nullable
                public CloseableReference<CloseableImage> getResult() throws Exception {
                    InterceptResult invokeV;
                    Bitmap baiduAppCreateVideoThumbnail;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        if (this.this$0.getLocalFilePath(this.val$imageRequest) == null || (baiduAppCreateVideoThumbnail = this.this$0.baiduAppCreateVideoThumbnail(this.val$imageRequest)) == null) {
                            return null;
                        }
                        return CloseableReference.of(new CloseableStaticBitmap(baiduAppCreateVideoThumbnail, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0));
                    }
                    return (CloseableReference) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                public void onSuccess(CloseableReference<CloseableImage> closeableReference) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048583, this, closeableReference) == null) {
                        super.onSuccess((AnonymousClass1) closeableReference);
                        this.val$listener.onUltimateProducerReached(this.val$requestId, LocalVideoThumbnailProducer.PRODUCER_NAME, closeableReference != null);
                    }
                }
            };
            producerContext.addCallbacks(new BaseProducerContextCallbacks(this, statefulProducerRunnable) { // from class: com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LocalVideoThumbnailProducer this$0;
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
