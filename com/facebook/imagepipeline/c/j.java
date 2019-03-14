package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class j implements f {
    private static j jGg = null;

    protected j() {
    }

    public static synchronized j cwC() {
        j jVar;
        synchronized (j.class) {
            if (jGg == null) {
                jGg = new j();
            }
            jVar = jGg;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(D(imageRequest.cAu()).toString(), imageRequest.cAx(), imageRequest.cAy(), imageRequest.cAz(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b cAE = imageRequest.cAE();
        if (cAE != null) {
            bVar = cAE.cAM();
            str = cAE.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(D(imageRequest.cAu()).toString(), imageRequest.cAx(), imageRequest.cAy(), imageRequest.cAz(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.cAu(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(D(uri).toString());
    }

    protected Uri D(Uri uri) {
        return uri;
    }
}
