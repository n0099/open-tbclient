package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class j implements f {
    private static j iqo = null;

    protected j() {
    }

    public static synchronized j bXo() {
        j jVar;
        synchronized (j.class) {
            if (iqo == null) {
                iqo = new j();
            }
            jVar = iqo;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(v(imageRequest.cbc()).toString(), imageRequest.cbf(), imageRequest.cbg(), imageRequest.cbh(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b cbm = imageRequest.cbm();
        if (cbm != null) {
            bVar = cbm.cbu();
            str = cbm.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(v(imageRequest.cbc()).toString(), imageRequest.cbf(), imageRequest.cbg(), imageRequest.cbh(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.cbc(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(v(uri).toString());
    }

    protected Uri v(Uri uri) {
        return uri;
    }
}
