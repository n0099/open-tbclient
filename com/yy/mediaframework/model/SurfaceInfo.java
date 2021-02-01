package com.yy.mediaframework.model;

import android.view.Surface;
/* loaded from: classes4.dex */
public class SurfaceInfo extends AbstractSurfaceInfo {
    public Surface mSurface;

    public SurfaceInfo(Surface surface, int i, int i2) {
        super(i, i2);
        this.mSurface = null;
        this.mSurface = surface;
    }
}
