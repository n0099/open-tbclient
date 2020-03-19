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
/* loaded from: classes12.dex */
public class y implements aw<com.facebook.imagepipeline.g.e> {
    private final com.facebook.common.memory.g lSj;
    private final ContentResolver mContentResolver;
    private final Executor mExecutor;

    public y(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.lSj = gVar;
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.aw
    public boolean a(com.facebook.imagepipeline.common.d dVar) {
        return ax.a(512, 512, dVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<com.facebook.imagepipeline.g.e> kVar, ak akVar) {
        am drW = akVar.drW();
        String id = akVar.getId();
        final ImageRequest drV = akVar.drV();
        final aq<com.facebook.imagepipeline.g.e> aqVar = new aq<com.facebook.imagepipeline.g.e>(kVar, drW, "LocalExifThumbnailProducer", id) { // from class: com.facebook.imagepipeline.producers.y.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: dsu */
            public com.facebook.imagepipeline.g.e getResult() throws Exception {
                ExifInterface V = y.this.V(drV.dsO());
                if (V == null || !V.hasThumbnail()) {
                    return null;
                }
                return y.this.a(y.this.lSj.ak(V.getThumbnail()), V);
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
            public void don() {
                aqVar.cancel();
            }
        });
        this.mExecutor.execute(aqVar);
    }

    @Nullable
    ExifInterface V(Uri uri) {
        String a = com.facebook.common.util.d.a(this.mContentResolver, uri);
        try {
            if (Ph(a)) {
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
        Pair<Integer, Integer> y = com.facebook.d.a.y(new com.facebook.common.memory.h(pooledByteBuffer));
        int a = a(exifInterface);
        int intValue = y != null ? ((Integer) y.first).intValue() : -1;
        int intValue2 = y != null ? ((Integer) y.second).intValue() : -1;
        com.facebook.common.references.a b = com.facebook.common.references.a.b(pooledByteBuffer);
        try {
            com.facebook.imagepipeline.g.e eVar = new com.facebook.imagepipeline.g.e(b);
            com.facebook.common.references.a.c(b);
            eVar.c(com.facebook.c.b.lRh);
            eVar.Ir(a);
            eVar.setWidth(intValue);
            eVar.setHeight(intValue2);
            return eVar;
        } catch (Throwable th) {
            com.facebook.common.references.a.c(b);
            throw th;
        }
    }

    private int a(ExifInterface exifInterface) {
        return com.facebook.d.b.IX(Integer.parseInt(exifInterface.getAttribute(android.support.media.ExifInterface.TAG_ORIENTATION)));
    }

    boolean Ph(String str) throws IOException {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.canRead();
    }
}
