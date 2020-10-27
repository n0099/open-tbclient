package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class j implements f {
    private static j oKT = null;

    protected j() {
    }

    public static synchronized j ejI() {
        j jVar;
        synchronized (j.class) {
            if (oKT == null) {
                oKT = new j();
            }
            jVar = oKT;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(T(imageRequest.enX()).toString(), imageRequest.enZ(), imageRequest.eoa(), imageRequest.eob(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b eog = imageRequest.eog();
        if (eog != null) {
            bVar = eog.ene();
            str = eog.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(T(imageRequest.enX()).toString(), imageRequest.enZ(), imageRequest.eoa(), imageRequest.eob(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.enX(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(T(uri).toString());
    }

    protected Uri T(Uri uri) {
        return uri;
    }
}
