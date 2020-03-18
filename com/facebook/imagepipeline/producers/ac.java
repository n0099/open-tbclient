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
import android.support.annotation.Nullable;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.Executor;
/* loaded from: classes12.dex */
public class ac implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> {
    private final ContentResolver mContentResolver;
    private final Executor mExecutor;

    public ac(Executor executor, ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> kVar, ak akVar) {
        final am drW = akVar.drW();
        final String id = akVar.getId();
        final ImageRequest drV = akVar.drV();
        final aq<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>> aqVar = new aq<com.facebook.common.references.a<com.facebook.imagepipeline.g.c>>(kVar, drW, "VideoThumbnailProducer", id) { // from class: com.facebook.imagepipeline.producers.ac.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: m */
            public void onSuccess(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
                super.onSuccess(aVar);
                drW.D(id, "VideoThumbnailProducer", aVar != null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onFailure(Exception exc) {
                super.onFailure(exc);
                drW.D(id, "VideoThumbnailProducer", false);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: dqG */
            public com.facebook.common.references.a<com.facebook.imagepipeline.g.c> getResult() throws Exception {
                Bitmap n;
                if (ac.this.m(drV) == null || (n = ac.this.n(drV)) == null) {
                    return null;
                }
                return com.facebook.common.references.a.b(new com.facebook.imagepipeline.g.d(n, com.facebook.imagepipeline.b.g.doo(), com.facebook.imagepipeline.g.g.lVN, 0));
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq
            /* renamed from: n */
            public Map<String, String> bt(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
                return ImmutableMap.of("createdThumbnail", String.valueOf(aVar != null));
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: o */
            public void aR(com.facebook.common.references.a<com.facebook.imagepipeline.g.c> aVar) {
                com.facebook.common.references.a.c(aVar);
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ac.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void don() {
                aqVar.cancel();
            }
        });
        this.mExecutor.execute(aqVar);
    }

    private static int l(ImageRequest imageRequest) {
        return (imageRequest.getPreferredWidth() > 96 || imageRequest.getPreferredHeight() > 96) ? 1 : 3;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String m(ImageRequest imageRequest) {
        String[] strArr;
        String str;
        Uri dsO = imageRequest.dsO();
        if (com.facebook.common.util.d.isLocalFileUri(dsO)) {
            return imageRequest.dsW().getPath();
        }
        if (com.facebook.common.util.d.isLocalContentUri(dsO)) {
            if (Build.VERSION.SDK_INT < 19 || !"com.android.providers.media.documents".equals(dsO.getAuthority())) {
                strArr = null;
                str = null;
            } else {
                String documentId = DocumentsContract.getDocumentId(dsO);
                dsO = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                str = "_id=?";
                strArr = new String[]{documentId.split(":")[1]};
            }
            Cursor query = this.mContentResolver.query(dsO, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            if (query != null) {
                query.close();
                return null;
            }
            return null;
        }
        return null;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0006 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: java.lang.RuntimeException */
    /* JADX WARN: Multi-variable type inference failed */
    private Bitmap D(String str, int i, int i2) {
        Bitmap bitmap;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                bitmap = mediaMetadataRetriever.getFrameAtTime(-1L);
            } catch (RuntimeException e) {
                e.printStackTrace();
                try {
                    mediaMetadataRetriever.release();
                    bitmap = null;
                    mediaMetadataRetriever = mediaMetadataRetriever;
                } catch (RuntimeException e2) {
                    e2.printStackTrace();
                    bitmap = null;
                    mediaMetadataRetriever = mediaMetadataRetriever;
                }
            }
            if (bitmap == null) {
                return null;
            }
            return ThumbnailUtils.extractThumbnail(bitmap, i, i2);
        } finally {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException e3) {
                e3.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap n(ImageRequest imageRequest) {
        int i;
        int i2 = 0;
        com.facebook.imagepipeline.common.d dsQ = imageRequest.dsQ();
        if (dsQ != null) {
            i = dsQ.width;
            i2 = dsQ.height;
        } else {
            i = 0;
        }
        if (i > 0 && i2 > 0) {
            return D(m(imageRequest), i, i2);
        }
        return ThumbnailUtils.createVideoThumbnail(m(imageRequest), l(imageRequest));
    }
}
