package io.flutter.view;

import android.graphics.SurfaceTexture;
/* loaded from: classes9.dex */
public interface TextureRegistry {

    /* loaded from: classes9.dex */
    public interface SurfaceTextureEntry {
        long id();

        void release();

        SurfaceTexture surfaceTexture();
    }

    SurfaceTextureEntry createSurfaceTexture();
}
