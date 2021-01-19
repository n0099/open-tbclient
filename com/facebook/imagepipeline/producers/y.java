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
/* loaded from: classes3.dex */
public class y implements aw<com.facebook.imagepipeline.f.e> {
    private final ContentResolver mContentResolver;
    private final Executor mExecutor;
    private final com.facebook.common.memory.g pwC;

    public y(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.pwC = gVar;
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.aw
    public boolean a(com.facebook.imagepipeline.common.d dVar) {
        return ax.a(512, 512, dVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        am ewQ = akVar.ewQ();
        String id = akVar.getId();
        final ImageRequest ewP = akVar.ewP();
        final aq<com.facebook.imagepipeline.f.e> aqVar = new aq<com.facebook.imagepipeline.f.e>(kVar, ewQ, "LocalExifThumbnailProducer", id) { // from class: com.facebook.imagepipeline.producers.y.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: exo */
            public com.facebook.imagepipeline.f.e getResult() throws Exception {
                ExifInterface ad = y.this.ad(ewP.exF());
                if (ad == null || !ad.hasThumbnail()) {
                    return null;
                }
                return y.this.a(y.this.pwC.al(ad.getThumbnail()), ad);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: h */
            public void ba(com.facebook.imagepipeline.f.e eVar) {
                com.facebook.imagepipeline.f.e.e(eVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq
            /* renamed from: i */
            public Map<String, String> bA(com.facebook.imagepipeline.f.e eVar) {
                return ImmutableMap.of("createdThumbnail", Boolean.toString(eVar != null));
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.y.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void ewW() {
                aqVar.cancel();
            }
        });
        this.mExecutor.execute(aqVar);
    }

    @Nullable
    ExifInterface ad(Uri uri) {
        String a2 = com.facebook.common.util.d.a(this.mContentResolver, uri);
        try {
            if (Yx(a2)) {
                return new ExifInterface(a2);
            }
        } catch (IOException e) {
        } catch (StackOverflowError e2) {
            com.facebook.common.c.a.i(y.class, "StackOverflowError in ExifInterface constructor");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.f.e a(PooledByteBuffer pooledByteBuffer, ExifInterface exifInterface) {
        Pair<Integer, Integer> B = com.facebook.d.a.B(new com.facebook.common.memory.h(pooledByteBuffer));
        int a2 = a(exifInterface);
        int intValue = B != null ? ((Integer) B.first).intValue() : -1;
        int intValue2 = B != null ? ((Integer) B.second).intValue() : -1;
        com.facebook.common.references.a f = com.facebook.common.references.a.f(pooledByteBuffer);
        try {
            com.facebook.imagepipeline.f.e eVar = new com.facebook.imagepipeline.f.e(f);
            com.facebook.common.references.a.c(f);
            eVar.c(com.facebook.c.b.pvG);
            eVar.Pq(a2);
            eVar.setWidth(intValue);
            eVar.setHeight(intValue2);
            return eVar;
        } catch (Throwable th) {
            com.facebook.common.references.a.c(f);
            throw th;
        }
    }

    private int a(ExifInterface exifInterface) {
        return com.facebook.d.b.PV(Integer.parseInt(exifInterface.getAttribute("Orientation")));
    }

    boolean Yx(String str) throws IOException {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.canRead();
    }
}
