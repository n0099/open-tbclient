package com.facebook.imagepipeline.c;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class j implements f {
    private static j nTB = null;

    protected j() {
    }

    public static synchronized j dZK() {
        j jVar;
        synchronized (j.class) {
            if (nTB == null) {
                nTB = new j();
            }
            jVar = nTB;
        }
        return jVar;
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Object obj) {
        return new c(T(imageRequest.edY()).toString(), imageRequest.eea(), imageRequest.eeb(), imageRequest.eec(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Object obj) {
        com.facebook.cache.common.b bVar;
        String str = null;
        com.facebook.imagepipeline.request.b eeg = imageRequest.eeg();
        if (eeg != null) {
            bVar = eeg.edf();
            str = eeg.getClass().getName();
        } else {
            bVar = null;
        }
        return new c(T(imageRequest.edY()).toString(), imageRequest.eea(), imageRequest.eeb(), imageRequest.eec(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        return a(imageRequest, imageRequest.edY(), obj);
    }

    @Override // com.facebook.imagepipeline.c.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new com.facebook.cache.common.g(T(uri).toString());
    }

    protected Uri T(Uri uri) {
        return uri;
    }
}
