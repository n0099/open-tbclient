package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class j implements f {
    private static j lMK = null;

    protected j() {
    }

    public static synchronized j dlD() {
        j jVar;
        synchronized (j.class) {
            if (lMK == null) {
                lMK = new j();
            }
            jVar = lMK;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(K(imageRequest.dpN()).toString(), imageRequest.dpP(), imageRequest.dpQ(), imageRequest.dpR(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.a dpW = imageRequest.dpW();
        if (dpW != null) {
            bVar = dpW.dqa();
            str = dpW.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(K(imageRequest.dpN()).toString(), imageRequest.dpP(), imageRequest.dpQ(), imageRequest.dpR(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.dpN(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(K(uri).toString());
    }

    protected Uri K(Uri uri) {
        return uri;
    }
}
