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
/* loaded from: classes15.dex */
public class y implements aw<com.facebook.imagepipeline.f.e> {
    private final ContentResolver mContentResolver;
    private final Executor mExecutor;
    private final com.facebook.common.memory.g pjQ;

    public y(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.pjQ = gVar;
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.aw
    public boolean a(com.facebook.imagepipeline.common.d dVar) {
        return ax.a(512, 512, dVar);
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<com.facebook.imagepipeline.f.e> kVar, ak akVar) {
        am ewx = akVar.ewx();
        String id = akVar.getId();
        final ImageRequest eww = akVar.eww();
        final aq<com.facebook.imagepipeline.f.e> aqVar = new aq<com.facebook.imagepipeline.f.e>(kVar, ewx, "LocalExifThumbnailProducer", id) { // from class: com.facebook.imagepipeline.producers.y.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.common.b.h
            /* renamed from: ewV */
            public com.facebook.imagepipeline.f.e getResult() throws Exception {
                ExifInterface ac = y.this.ac(eww.exm());
                if (ac == null || !ac.hasThumbnail()) {
                    return null;
                }
                return y.this.a(y.this.pjQ.an(ac.getThumbnail()), ac);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            /* renamed from: h */
            public void aZ(com.facebook.imagepipeline.f.e eVar) {
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
            public void ewD() {
                aqVar.cancel();
            }
        });
        this.mExecutor.execute(aqVar);
    }

    @Nullable
    ExifInterface ac(Uri uri) {
        String a2 = com.facebook.common.util.d.a(this.mContentResolver, uri);
        try {
            if (Zu(a2)) {
                return new ExifInterface(a2);
            }
        } catch (IOException e) {
        } catch (StackOverflowError e2) {
            com.facebook.common.c.a.h(y.class, "StackOverflowError in ExifInterface constructor");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.imagepipeline.f.e a(PooledByteBuffer pooledByteBuffer, ExifInterface exifInterface) {
        Pair<Integer, Integer> y = com.facebook.d.a.y(new com.facebook.common.memory.h(pooledByteBuffer));
        int a2 = a(exifInterface);
        int intValue = y != null ? ((Integer) y.first).intValue() : -1;
        int intValue2 = y != null ? ((Integer) y.second).intValue() : -1;
        com.facebook.common.references.a e = com.facebook.common.references.a.e(pooledByteBuffer);
        try {
            com.facebook.imagepipeline.f.e eVar = new com.facebook.imagepipeline.f.e(e);
            com.facebook.common.references.a.c(e);
            eVar.c(com.facebook.c.b.piU);
            eVar.QJ(a2);
            eVar.setWidth(intValue);
            eVar.setHeight(intValue2);
            return eVar;
        } catch (Throwable th) {
            com.facebook.common.references.a.c(e);
            throw th;
        }
    }

    private int a(ExifInterface exifInterface) {
        return com.facebook.d.b.Rp(Integer.parseInt(exifInterface.getAttribute(android.support.media.ExifInterface.TAG_ORIENTATION)));
    }

    boolean Zu(String str) throws IOException {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.canRead();
    }
}
