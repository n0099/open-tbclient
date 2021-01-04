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
import androidx.annotation.Nullable;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public class ac implements aj<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> {
    private final ContentResolver mContentResolver;
    private final Executor mExecutor;

    public ac(Executor executor, ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> kVar, ak akVar) {
        final am eAe = akVar.eAe();
        final String id = akVar.getId();
        final ImageRequest eAd = akVar.eAd();
        final aq<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>> aqVar = new aq<com.facebook.common.references.a<com.facebook.imagepipeline.f.c>>(kVar, eAe, "VideoThumbnailProducer", id) { // from class: com.facebook.imagepipeline.producers.ac.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.e
            /* renamed from: j */
            public void onSuccess(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
                super.onSuccess(aVar);
                eAe.M(id, "VideoThumbnailProducer", aVar != null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.e
            public void onFailure(Exception exc) {
                super.onFailure(exc);
                eAe.M(id, "VideoThumbnailProducer", false);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.e
            /* renamed from: eyU */
            public com.facebook.common.references.a<com.facebook.imagepipeline.f.c> getResult() throws Exception {
                Bitmap m;
                if (ac.this.l(eAd) == null || (m = ac.this.m(eAd)) == null) {
                    return null;
                }
                return com.facebook.common.references.a.f(new com.facebook.imagepipeline.f.d(m, com.facebook.imagepipeline.a.g.ewB(), com.facebook.imagepipeline.f.g.pCU, 0));
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq
            /* renamed from: k */
            public Map<String, String> bz(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
                return ImmutableMap.of("createdThumbnail", String.valueOf(aVar != null));
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.e
            /* renamed from: l */
            public void ba(com.facebook.common.references.a<com.facebook.imagepipeline.f.c> aVar) {
                com.facebook.common.references.a.c(aVar);
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ac.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void eAk() {
                aqVar.cancel();
            }
        });
        this.mExecutor.execute(aqVar);
    }

    private static int k(ImageRequest imageRequest) {
        return (imageRequest.getPreferredWidth() > 96 || imageRequest.getPreferredHeight() > 96) ? 1 : 3;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String l(ImageRequest imageRequest) {
        String[] strArr;
        String str;
        Uri eAT = imageRequest.eAT();
        if (com.facebook.common.util.d.O(eAT)) {
            return imageRequest.aeg().getPath();
        }
        if (com.facebook.common.util.d.P(eAT)) {
            if (Build.VERSION.SDK_INT < 19 || !"com.android.providers.media.documents".equals(eAT.getAuthority())) {
                strArr = null;
                str = null;
            } else {
                String documentId = DocumentsContract.getDocumentId(eAT);
                eAT = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                str = "_id=?";
                strArr = new String[]{documentId.split(":")[1]};
            }
            Cursor query = this.mContentResolver.query(eAT, new String[]{"_data"}, str, strArr, null);
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
    private Bitmap G(String str, int i, int i2) {
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
    public Bitmap m(ImageRequest imageRequest) {
        int i;
        int i2;
        com.facebook.imagepipeline.common.d eAV = imageRequest.eAV();
        if (eAV != null) {
            int i3 = eAV.width;
            i = eAV.height;
            i2 = i3;
        } else {
            i = 0;
            i2 = 0;
        }
        if (i2 > 0 && i > 0) {
            return G(l(imageRequest), i2, i);
        }
        return ThumbnailUtils.createVideoThumbnail(l(imageRequest), k(imageRequest));
    }
}
