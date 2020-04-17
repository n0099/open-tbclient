package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class j implements f {
    private static j maN = null;

    protected j() {
    }

    public static synchronized j dqw() {
        j jVar;
        synchronized (j.class) {
            if (maN == null) {
                maN = new j();
            }
            jVar = maN;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(P(imageRequest.duL()).toString(), imageRequest.duN(), imageRequest.duO(), imageRequest.duP(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b duT = imageRequest.duT();
        if (duT != null) {
            bVar = duT.dtS();
            str = duT.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(P(imageRequest.duL()).toString(), imageRequest.duN(), imageRequest.duO(), imageRequest.duP(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.duL(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(P(uri).toString());
    }

    protected Uri P(Uri uri) {
        return uri;
    }
}
