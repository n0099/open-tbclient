package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class j implements f {
    private static j lRi = null;

    protected j() {
    }

    public static synchronized j dnX() {
        j jVar;
        synchronized (j.class) {
            if (lRi == null) {
                lRi = new j();
            }
            jVar = lRi;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(L(imageRequest.dso()).toString(), imageRequest.dsq(), imageRequest.dsr(), imageRequest.dss(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b dsx = imageRequest.dsx();
        if (dsx != null) {
            bVar = dsx.dru();
            str = dsx.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(L(imageRequest.dso()).toString(), imageRequest.dsq(), imageRequest.dsr(), imageRequest.dss(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.dso(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(L(uri).toString());
    }

    protected Uri L(Uri uri) {
        return uri;
    }
}
