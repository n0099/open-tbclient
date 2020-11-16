package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class j implements f {
    private static j oVP = null;

    protected j() {
    }

    public static synchronized j enw() {
        j jVar;
        synchronized (j.class) {
            if (oVP == null) {
                oVP = new j();
            }
            jVar = oVP;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(U(imageRequest.erL()).toString(), imageRequest.erN(), imageRequest.erO(), imageRequest.erP(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b erT = imageRequest.erT();
        if (erT != null) {
            bVar = erT.eqS();
            str = erT.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(U(imageRequest.erL()).toString(), imageRequest.erN(), imageRequest.erO(), imageRequest.erP(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.erL(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(U(uri).toString());
    }

    protected Uri U(Uri uri) {
        return uri;
    }
}
