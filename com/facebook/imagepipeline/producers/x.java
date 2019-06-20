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
/* loaded from: classes2.dex */
public class x implements au<com.facebook.imagepipeline.f.d> {
    private final com.facebook.common.memory.g jXB;
    private final ContentResolver mContentResolver;
    private final Executor mExecutor;

    public x(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.jXB = gVar;
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.au
    public boolean a(com.facebook.imagepipeline.common.c cVar) {
        return av.a(512, 512, cVar);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        al cHy = ajVar.cHy();
        String id = ajVar.getId();
        final ImageRequest cHx = ajVar.cHx();
        final ao<com.facebook.imagepipeline.f.d> aoVar = new ao<com.facebook.imagepipeline.f.d>(jVar, cHy, "LocalExifThumbnailProducer", id) { // from class: com.facebook.imagepipeline.producers.x.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.e
            /* renamed from: cHU */
            public com.facebook.imagepipeline.f.d getResult() throws Exception {
                ExifInterface R = x.this.R(cHx.cIk());
                if (R == null || !R.hasThumbnail()) {
                    return null;
                }
                return x.this.a(x.this.jXB.W(R.getThumbnail()), R);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            /* renamed from: h */
            public void aB(com.facebook.imagepipeline.f.d dVar) {
                com.facebook.imagepipeline.f.d.e(dVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao
            /* renamed from: i */
            public Map<String, String> ba(com.facebook.imagepipeline.f.d dVar) {
                return ImmutableMap.of("createdThumbnail", Boolean.toString(dVar != null));
            }
        };
        ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.x.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
            public void cHE() {
                aoVar.cancel();
            }
        });
        this.mExecutor.execute(aoVar);
    }

    ExifInterface R(Uri uri) throws IOException {
        String a = com.facebook.common.util.d.a(this.mContentResolver, uri);
        if (GZ(a)) {
            return new ExifInterface(a);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.f.d a(PooledByteBuffer pooledByteBuffer, ExifInterface exifInterface) {
        Pair<Integer, Integer> x = com.facebook.d.a.x(new com.facebook.common.memory.h(pooledByteBuffer));
        int a = a(exifInterface);
        int intValue = x != null ? ((Integer) x.first).intValue() : -1;
        int intValue2 = x != null ? ((Integer) x.second).intValue() : -1;
        com.facebook.common.references.a d = com.facebook.common.references.a.d(pooledByteBuffer);
        try {
            com.facebook.imagepipeline.f.d dVar = new com.facebook.imagepipeline.f.d(d);
            com.facebook.common.references.a.c(d);
            dVar.c(com.facebook.c.b.jXh);
            dVar.Dl(a);
            dVar.setWidth(intValue);
            dVar.setHeight(intValue2);
            return dVar;
        } catch (Throwable th) {
            com.facebook.common.references.a.c(d);
            throw th;
        }
    }

    private int a(ExifInterface exifInterface) {
        return com.facebook.d.b.DL(Integer.parseInt(exifInterface.getAttribute("Orientation")));
    }

    boolean GZ(String str) throws IOException {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.canRead();
    }
}
