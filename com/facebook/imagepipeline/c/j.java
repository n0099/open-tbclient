package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class j implements f {
    private static j oUm = null;

    protected j() {
    }

    public static synchronized j eny() {
        j jVar;
        synchronized (j.class) {
            if (oUm == null) {
                oUm = new j();
            }
            jVar = oUm;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(T(imageRequest.erN()).toString(), imageRequest.erP(), imageRequest.erQ(), imageRequest.erR(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b erV = imageRequest.erV();
        if (erV != null) {
            bVar = erV.eqU();
            str = erV.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(T(imageRequest.erN()).toString(), imageRequest.erP(), imageRequest.erQ(), imageRequest.erR(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.erN(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(T(uri).toString());
    }

    protected Uri T(Uri uri) {
        return uri;
    }
}
