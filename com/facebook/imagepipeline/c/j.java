package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class j implements f {
    private static j iph = null;

    protected j() {
    }

    public static synchronized j bWG() {
        j jVar;
        synchronized (j.class) {
            if (iph == null) {
                iph = new j();
            }
            jVar = iph;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(v(imageRequest.cau()).toString(), imageRequest.cax(), imageRequest.cay(), imageRequest.caz(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b caE = imageRequest.caE();
        if (caE != null) {
            bVar = caE.caM();
            str = caE.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(v(imageRequest.cau()).toString(), imageRequest.cax(), imageRequest.cay(), imageRequest.caz(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.cau(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(v(uri).toString());
    }

    protected Uri v(Uri uri) {
        return uri;
    }
}
