package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class j implements f {
    private static j muI = null;

    protected j() {
    }

    public static synchronized j dxM() {
        j jVar;
        synchronized (j.class) {
            if (muI == null) {
                muI = new j();
            }
            jVar = muI;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(R(imageRequest.dCa()).toString(), imageRequest.dCc(), imageRequest.dCd(), imageRequest.dCe(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b dCi = imageRequest.dCi();
        if (dCi != null) {
            bVar = dCi.dBh();
            str = dCi.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(R(imageRequest.dCa()).toString(), imageRequest.dCc(), imageRequest.dCd(), imageRequest.dCe(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.dCa(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(R(uri).toString());
    }

    protected Uri R(Uri uri) {
        return uri;
    }
}
