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
import com.baidu.sapi2.activity.ImageClipActivity;
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
    @VisibleForTesting
    public static final String CREATED_THUMBNAIL = "createdThumbnail";
    public static final String PRODUCER_NAME = "VideoThumbnailProducer";
    public final ContentResolver mContentResolver;
    public final Executor mExecutor;

    public LocalVideoThumbnailProducer(Executor executor, ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.mContentResolver = contentResolver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap baiduAppCreateVideoThumbnail(ImageRequest imageRequest) {
        int i2;
        ResizeOptions resizeOptions = imageRequest.getResizeOptions();
        int i3 = 0;
        if (resizeOptions != null) {
            i3 = resizeOptions.width;
            i2 = resizeOptions.height;
        } else {
            i2 = 0;
        }
        if (i3 > 0 && i2 > 0) {
            return createExtractVideoThumbnail(getLocalFilePath(imageRequest), i3, i2);
        }
        return ThumbnailUtils.createVideoThumbnail(getLocalFilePath(imageRequest), calculateKind(imageRequest));
    }

    public static int calculateKind(ImageRequest imageRequest) {
        return (imageRequest.getPreferredWidth() > 96 || imageRequest.getPreferredHeight() > 96) ? 1 : 3;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0006 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.lang.RuntimeException */
    /* JADX WARN: Multi-variable type inference failed */
    private Bitmap createExtractVideoThumbnail(String str, int i2, int i3) {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                bitmap = mediaMetadataRetriever.getFrameAtTime(-1L);
                try {
                    mediaMetadataRetriever.release();
                    mediaMetadataRetriever = mediaMetadataRetriever;
                } catch (RuntimeException e2) {
                    e2.printStackTrace();
                    mediaMetadataRetriever = e2;
                }
            } catch (RuntimeException e3) {
                e3.printStackTrace();
                try {
                    mediaMetadataRetriever.release();
                } catch (RuntimeException e4) {
                    e4.printStackTrace();
                }
                bitmap = null;
                mediaMetadataRetriever = mediaMetadataRetriever;
            }
            if (bitmap == null) {
                return null;
            }
            return ThumbnailUtils.extractThumbnail(bitmap, i2, i3);
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String getLocalFilePath(ImageRequest imageRequest) {
        Uri uri;
        String str;
        String[] strArr;
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

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        final ProducerListener listener = producerContext.getListener();
        final String id = producerContext.getId();
        final ImageRequest imageRequest = producerContext.getImageRequest();
        final StatefulProducerRunnable<CloseableReference<CloseableImage>> statefulProducerRunnable = new StatefulProducerRunnable<CloseableReference<CloseableImage>>(consumer, listener, PRODUCER_NAME, id) { // from class: com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.1
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void onFailure(Exception exc) {
                super.onFailure(exc);
                listener.onUltimateProducerReached(id, LocalVideoThumbnailProducer.PRODUCER_NAME, false);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void disposeResult(CloseableReference<CloseableImage> closeableReference) {
                CloseableReference.closeSafely(closeableReference);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable
            public Map<String, String> getExtraMapOnSuccess(CloseableReference<CloseableImage> closeableReference) {
                return ImmutableMap.of("createdThumbnail", String.valueOf(closeableReference != null));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.executors.StatefulRunnable
            @Nullable
            public CloseableReference<CloseableImage> getResult() throws Exception {
                Bitmap baiduAppCreateVideoThumbnail;
                if (LocalVideoThumbnailProducer.this.getLocalFilePath(imageRequest) == null || (baiduAppCreateVideoThumbnail = LocalVideoThumbnailProducer.this.baiduAppCreateVideoThumbnail(imageRequest)) == null) {
                    return null;
                }
                return CloseableReference.of(new CloseableStaticBitmap(baiduAppCreateVideoThumbnail, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public void onSuccess(CloseableReference<CloseableImage> closeableReference) {
                super.onSuccess((AnonymousClass1) closeableReference);
                listener.onUltimateProducerReached(id, LocalVideoThumbnailProducer.PRODUCER_NAME, closeableReference != null);
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.2
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                statefulProducerRunnable.cancel();
            }
        });
        this.mExecutor.execute(statefulProducerRunnable);
    }
}
