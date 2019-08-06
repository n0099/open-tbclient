package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class j implements f {
    private static j kgE = null;

    protected j() {
    }

    public static synchronized j cHQ() {
        j jVar;
        synchronized (j.class) {
            if (kgE == null) {
                kgE = new j();
            }
            jVar = kgE;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(J(imageRequest.cLJ()).toString(), imageRequest.cLM(), imageRequest.cLN(), imageRequest.cLO(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b cLT = imageRequest.cLT();
        if (cLT != null) {
            bVar = cLT.cMb();
            str = cLT.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(J(imageRequest.cLJ()).toString(), imageRequest.cLM(), imageRequest.cLN(), imageRequest.cLO(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.cLJ(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(J(uri).toString());
    }

    protected Uri J(Uri uri) {
        return uri;
    }
}
