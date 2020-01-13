package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class j implements f {
    private static j lQw = null;

    protected j() {
    }

    public static synchronized j dmI() {
        j jVar;
        synchronized (j.class) {
            if (lQw == null) {
                lQw = new j();
            }
            jVar = lQw;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(K(imageRequest.dra()).toString(), imageRequest.drc(), imageRequest.drd(), imageRequest.dre(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b drj = imageRequest.drj();
        if (drj != null) {
            bVar = drj.dqg();
            str = drj.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(K(imageRequest.dra()).toString(), imageRequest.drc(), imageRequest.drd(), imageRequest.dre(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.dra(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(K(uri).toString());
    }

    protected Uri K(Uri uri) {
        return uri;
    }
}
