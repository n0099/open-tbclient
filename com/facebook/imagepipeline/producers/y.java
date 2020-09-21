package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Pair;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes25.dex */
public class y implements aw<com.facebook.imagepipeline.g.e> {
    private final ContentResolver mContentResolver;
    private final Executor mExecutor;
    private final com.facebook.common.memory.g nDr;

    public y(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.nDr = gVar;
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.aw
    public boolean a(com.facebook.imagepipeline.common.d dVar) {
        return ax.a(512, 512, dVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        am dZw = akVar.dZw();
        String id = akVar.getId();
        final ImageRequest dZv = akVar.dZv();
        final aq<com.facebook.imagepipeline.g.e> aqVar = new aq<com.facebook.imagepipeline.g.e>(kVar, dZw, "LocalExifThumbnailProducer", id) { // from class: com.facebook.imagepipeline.producers.y.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: dZU */
            public com.facebook.imagepipeline.g.e getResult() throws Exception {
                ExifInterface aa = y.this.aa(dZv.ean());
                if (aa == null || !aa.hasThumbnail()) {
                    return null;
                }
                return y.this.a(y.this.nDr.al(aa.getThumbnail()), aa);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: h */
            public void aR(com.facebook.imagepipeline.g.e eVar) {
                com.facebook.imagepipeline.g.e.e(eVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq
            /* renamed from: i */
            public Map<String, String> bt(com.facebook.imagepipeline.g.e eVar) {
                return ImmutableMap.of("createdThumbnail", Boolean.toString(eVar != null));
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.y.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void dVN() {
                aqVar.cancel();
            }
        });
        this.mExecutor.execute(aqVar);
    }

    @Nullable
    ExifInterface aa(Uri uri) {
        String a = com.facebook.common.util.d.a(this.mContentResolver, uri);
        try {
            if (Vl(a)) {
                return new ExifInterface(a);
            }
        } catch (IOException e) {
        } catch (StackOverflowError e2) {
            com.facebook.common.c.a.h(y.class, "StackOverflowError in ExifInterface constructor");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.g.e a(PooledByteBuffer pooledByteBuffer, ExifInterface exifInterface) {
        Pair<Integer, Integer> w = com.facebook.d.a.w(new com.facebook.common.memory.h(pooledByteBuffer));
        int a = a(exifInterface);
        int intValue = w != null ? ((Integer) w.first).intValue() : -1;
        int intValue2 = w != null ? ((Integer) w.second).intValue() : -1;
        com.facebook.common.references.a e = com.facebook.common.references.a.e(pooledByteBuffer);
        try {
            com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(e);
            com.facebook.common.references.a.c(e);
            eVar.c(com.facebook.c.b.nCm);
            eVar.Ms(a);
            eVar.setWidth(intValue);
            eVar.setHeight(intValue2);
            return eVar;
        } catch (Throwable th) {
            com.facebook.common.references.a.c(e);
            throw th;
        }
    }

    private int a(ExifInterface exifInterface) {
        return com.facebook.d.b.MZ(Integer.parseInt(exifInterface.getAttribute(android.support.media.ExifInterface.TAG_ORIENTATION)));
    }

    boolean Vl(String str) throws IOException {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.canRead();
    }
}
