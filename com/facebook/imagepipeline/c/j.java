package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class j implements f {
    private static j ieL = null;

    protected j() {
    }

    public static synchronized j bTK() {
        j jVar;
        synchronized (j.class) {
            if (ieL == null) {
                ieL = new j();
            }
            jVar = ieL;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(u(imageRequest.bXy()).toString(), imageRequest.bXB(), imageRequest.bXC(), imageRequest.bXD(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b bXI = imageRequest.bXI();
        if (bXI != null) {
            bVar = bXI.bXQ();
            str = bXI.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(u(imageRequest.bXy()).toString(), imageRequest.bXB(), imageRequest.bXC(), imageRequest.bXD(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.bXy(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(u(uri).toString());
    }

    protected Uri u(Uri uri) {
        return uri;
    }
}
