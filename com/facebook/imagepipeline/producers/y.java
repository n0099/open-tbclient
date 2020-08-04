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
/* loaded from: classes4.dex */
public class y implements aw<com.facebook.imagepipeline.g.e> {
    private final ContentResolver mContentResolver;
    private final Executor mExecutor;
    private final com.facebook.common.memory.g mZm;

    public y(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.mZm = gVar;
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.aw
    public boolean a(com.facebook.imagepipeline.common.d dVar) {
        return ax.a(512, 512, dVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        am dJq = akVar.dJq();
        String id = akVar.getId();
        final ImageRequest dJp = akVar.dJp();
        final aq<com.facebook.imagepipeline.g.e> aqVar = new aq<com.facebook.imagepipeline.g.e>(kVar, dJq, "LocalExifThumbnailProducer", id) { // from class: com.facebook.imagepipeline.producers.y.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: dJO */
            public com.facebook.imagepipeline.g.e getResult() throws Exception {
                ExifInterface Y = y.this.Y(dJp.dKh());
                if (Y == null || !Y.hasThumbnail()) {
                    return null;
                }
                return y.this.a(y.this.mZm.ak(Y.getThumbnail()), Y);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: h */
            public void aN(com.facebook.imagepipeline.g.e eVar) {
                com.facebook.imagepipeline.g.e.e(eVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq
            /* renamed from: i */
            public Map<String, String> bp(com.facebook.imagepipeline.g.e eVar) {
                return ImmutableMap.of("createdThumbnail", Boolean.toString(eVar != null));
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.y.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void dFH() {
                aqVar.cancel();
            }
        });
        this.mExecutor.execute(aqVar);
    }

    @Nullable
    ExifInterface Y(Uri uri) {
        String a = com.facebook.common.util.d.a(this.mContentResolver, uri);
        try {
            if (RF(a)) {
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
        Pair<Integer, Integer> v = com.facebook.d.a.v(new com.facebook.common.memory.h(pooledByteBuffer));
        int a = a(exifInterface);
        int intValue = v != null ? ((Integer) v.first).intValue() : -1;
        int intValue2 = v != null ? ((Integer) v.second).intValue() : -1;
        com.facebook.common.references.a e = com.facebook.common.references.a.e(pooledByteBuffer);
        try {
            com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(e);
            com.facebook.common.references.a.c(e);
            eVar.c(com.facebook.c.b.mYh);
            eVar.Jj(a);
            eVar.setWidth(intValue);
            eVar.setHeight(intValue2);
            return eVar;
        } catch (Throwable th) {
            com.facebook.common.references.a.c(e);
            throw th;
        }
    }

    private int a(ExifInterface exifInterface) {
        return com.facebook.d.b.JQ(Integer.parseInt(exifInterface.getAttribute(android.support.media.ExifInterface.TAG_ORIENTATION)));
    }

    boolean RF(String str) throws IOException {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.canRead();
    }
}
