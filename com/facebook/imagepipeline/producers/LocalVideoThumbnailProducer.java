package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
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
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class LocalVideoThumbnailProducer implements Producer {
    public static /* synthetic */ Interceptable $ic = null;
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

    @Nullable
    public static Bitmap createThumbnailFromContentProvider(ContentResolver contentResolver, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, contentResolver, uri)) == null) {
            if (Build.VERSION.SDK_INT >= 10) {
                try {
                    ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(openFileDescriptor.getFileDescriptor());
                    return mediaMetadataRetriever.getFrameAtTime(-1L);
                } catch (FileNotFoundException unused) {
                }
            }
            return null;
        }
        return (Bitmap) invokeLL.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, consumer, producerContext) == null) {
            ProducerListener2 producerListener = producerContext.getProducerListener();
            ImageRequest imageRequest = producerContext.getImageRequest();
            producerContext.putOriginExtra(ImagesContract.LOCAL, "video");
            StatefulProducerRunnable statefulProducerRunnable = new StatefulProducerRunnable(this, consumer, producerListener, producerContext, PRODUCER_NAME, producerListener, producerContext, imageRequest) { // from class: com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LocalVideoThumbnailProducer this$0;
                public final /* synthetic */ ImageRequest val$imageRequest;
                public final /* synthetic */ ProducerListener2 val$listener;
                public final /* synthetic */ ProducerContext val$producerContext;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(consumer, producerListener, producerContext, r15);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r3;
                        Object[] objArr = {this, consumer, producerListener, producerContext, r15, producerListener, producerContext, imageRequest};
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
                    this.val$listener = producerListener;
                    this.val$producerContext = producerContext;
                    this.val$imageRequest = imageRequest;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                public void disposeResult(CloseableReference closeableReference) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, closeableReference) == null) {
                        CloseableReference.closeSafely(closeableReference);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
                public Map getExtraMapOnSuccess(CloseableReference closeableReference) {
                    InterceptResult invokeL;
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, closeableReference)) == null) {
                        if (closeableReference != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        return ImmutableMap.of("createdThumbnail", String.valueOf(z));
                    }
                    return (Map) invokeL.objValue;
                }

                @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                public void onFailure(Exception exc) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048582, this, exc) == null) {
                        super.onFailure(exc);
                        this.val$listener.onUltimateProducerReached(this.val$producerContext, LocalVideoThumbnailProducer.PRODUCER_NAME, false);
                        this.val$producerContext.putOriginExtra(ImagesContract.LOCAL);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                public void onSuccess(CloseableReference closeableReference) {
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048583, this, closeableReference) == null) {
                        super.onSuccess((Object) closeableReference);
                        ProducerListener2 producerListener2 = this.val$listener;
                        ProducerContext producerContext2 = this.val$producerContext;
                        if (closeableReference != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        producerListener2.onUltimateProducerReached(producerContext2, LocalVideoThumbnailProducer.PRODUCER_NAME, z);
                        this.val$producerContext.putOriginExtra(ImagesContract.LOCAL);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.common.executors.StatefulRunnable
                @Nullable
                public CloseableReference getResult() throws Exception {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        try {
                            this.this$0.getLocalFilePath(this.val$imageRequest);
                        } catch (IllegalArgumentException unused) {
                        }
                        Bitmap baiduAppCreateVideoThumbnail = this.this$0.baiduAppCreateVideoThumbnail(this.val$imageRequest);
                        if (baiduAppCreateVideoThumbnail == null) {
                            return null;
                        }
                        CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(baiduAppCreateVideoThumbnail, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0);
                        this.val$producerContext.setExtra("image_format", "thumbnail");
                        closeableStaticBitmap.setImageExtras(this.val$producerContext.getExtras());
                        return CloseableReference.of(closeableStaticBitmap);
                    }
                    return (CloseableReference) invokeV.objValue;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, imageRequest)) == null) {
            if (imageRequest.getPreferredWidth() <= 96 && imageRequest.getPreferredHeight() <= 96) {
                return 3;
            }
            return 1;
        }
        return invokeL.intValue;
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
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                } catch (RuntimeException e2) {
                    e2.printStackTrace();
                    try {
                        mediaMetadataRetriever.release();
                    } catch (RuntimeException e3) {
                        e3.printStackTrace();
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
                } catch (RuntimeException e4) {
                    e4.printStackTrace();
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, imageRequest)) == null) {
            Uri sourceUri = imageRequest.getSourceUri();
            if (UriUtil.isLocalFileUri(sourceUri)) {
                return imageRequest.getSourceFile().getPath();
            }
            if (UriUtil.isLocalContentUri(sourceUri)) {
                if (Build.VERSION.SDK_INT >= 19 && ImageClipActivity.k.equals(sourceUri.getAuthority())) {
                    String documentId = DocumentsContract.getDocumentId(sourceUri);
                    str = "_id=?";
                    uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    strArr = new String[]{documentId.split(":")[1]};
                } else {
                    uri = sourceUri;
                    str = null;
                    strArr = null;
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
}
