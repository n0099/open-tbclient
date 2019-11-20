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
    private final com.facebook.common.memory.g kfD;
    private final ContentResolver mContentResolver;
    private final Executor mExecutor;

    public x(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.kfD = gVar;
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.au
    public boolean a(com.facebook.imagepipeline.common.c cVar) {
        return av.a(512, 512, cVar);
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<com.facebook.imagepipeline.f.d> jVar, aj ajVar) {
        al cIG = ajVar.cIG();
        String id = ajVar.getId();
        final ImageRequest cIF = ajVar.cIF();
        final ao<com.facebook.imagepipeline.f.d> aoVar = new ao<com.facebook.imagepipeline.f.d>(jVar, cIG, "LocalExifThumbnailProducer", id) { // from class: com.facebook.imagepipeline.producers.x.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.e
            /* renamed from: cJc */
            public com.facebook.imagepipeline.f.d getResult() throws Exception {
                ExifInterface O = x.this.O(cIF.cJs());
                if (O == null || !O.hasThumbnail()) {
                    return null;
                }
                return x.this.a(x.this.kfD.L(O.getThumbnail()), O);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            /* renamed from: h */
            public void aw(com.facebook.imagepipeline.f.d dVar) {
                com.facebook.imagepipeline.f.d.e(dVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao
            /* renamed from: i */
            public Map<String, String> aV(com.facebook.imagepipeline.f.d dVar) {
                return ImmutableMap.of("createdThumbnail", Boolean.toString(dVar != null));
            }
        };
        ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.x.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
            public void cIM() {
                aoVar.cancel();
            }
        });
        this.mExecutor.execute(aoVar);
    }

    ExifInterface O(Uri uri) throws IOException {
        String b = com.facebook.common.util.d.b(this.mContentResolver, uri);
        if (GL(b)) {
            return new ExifInterface(b);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.f.d a(PooledByteBuffer pooledByteBuffer, ExifInterface exifInterface) {
        Pair<Integer, Integer> u = com.facebook.d.a.u(new com.facebook.common.memory.h(pooledByteBuffer));
        int a = a(exifInterface);
        int intValue = u != null ? ((Integer) u.first).intValue() : -1;
        int intValue2 = u != null ? ((Integer) u.second).intValue() : -1;
        com.facebook.common.references.a c = com.facebook.common.references.a.c(pooledByteBuffer);
        try {
            com.facebook.imagepipeline.f.d dVar = new com.facebook.imagepipeline.f.d(c);
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
            dVar.c(com.facebook.c.b.kfj);
            dVar.Ct(a);
            dVar.setWidth(intValue);
            dVar.setHeight(intValue2);
            return dVar;
        } catch (Throwable th) {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
            throw th;
        }
    }

    private int a(ExifInterface exifInterface) {
        return com.facebook.d.b.CT(Integer.parseInt(exifInterface.getAttribute("Orientation")));
    }

    boolean GL(String str) throws IOException {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.canRead();
    }
}
