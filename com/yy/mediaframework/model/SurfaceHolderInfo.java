package com.yy.mediaframework.model;

import android.view.SurfaceHolder;
/* loaded from: classes6.dex */
public class SurfaceHolderInfo extends AbstractSurfaceInfo {
    public SurfaceHolder mSurfaceHolder;

    public SurfaceHolderInfo(SurfaceHolder surfaceHolder, int i, int i2) {
        super(i, i2);
        this.mSurfaceHolder = null;
        this.mSurfaceHolder = surfaceHolder;
    }
}
