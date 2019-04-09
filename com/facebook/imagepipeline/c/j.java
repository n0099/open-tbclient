package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class j implements f {
    private static j jFB = null;

    protected j() {
    }

    public static synchronized j cwv() {
        j jVar;
        synchronized (j.class) {
            if (jFB == null) {
                jFB = new j();
            }
            jVar = jFB;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(D(imageRequest.cAn()).toString(), imageRequest.cAq(), imageRequest.cAr(), imageRequest.cAs(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b cAx = imageRequest.cAx();
        if (cAx != null) {
            bVar = cAx.cAF();
            str = cAx.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(D(imageRequest.cAn()).toString(), imageRequest.cAq(), imageRequest.cAr(), imageRequest.cAs(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.cAn(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(D(uri).toString());
    }

    protected Uri D(Uri uri) {
        return uri;
    }
}
