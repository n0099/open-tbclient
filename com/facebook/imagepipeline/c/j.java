package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class j implements f {
    private static j ilV = null;

    protected j() {
    }

    public static synchronized j bVQ() {
        j jVar;
        synchronized (j.class) {
            if (ilV == null) {
                ilV = new j();
            }
            jVar = ilV;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(v(imageRequest.bZE()).toString(), imageRequest.bZH(), imageRequest.bZI(), imageRequest.bZJ(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b bZO = imageRequest.bZO();
        if (bZO != null) {
            bVar = bZO.bZW();
            str = bZO.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(v(imageRequest.bZE()).toString(), imageRequest.bZH(), imageRequest.bZI(), imageRequest.bZJ(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.bZE(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(v(uri).toString());
    }

    protected Uri v(Uri uri) {
        return uri;
    }
}
