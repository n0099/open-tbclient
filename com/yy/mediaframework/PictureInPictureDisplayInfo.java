package com.yy.mediaframework;

import java.util.Locale;
/* loaded from: classes6.dex */
public class PictureInPictureDisplayInfo {
    public float bottomOffset = 0.15f;
    public float scaleRatio = 0.83f;

    public PictureInPictureDisplayInfo() {
    }

    public PictureInPictureDisplayInfo(float f, float f2) {
        update(f, f2);
    }

    public void update(float f, float f2) {
        this.bottomOffset = f;
        this.scaleRatio = f2;
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public boolean equals(PictureInPictureDisplayInfo pictureInPictureDisplayInfo) {
        return this.bottomOffset == pictureInPictureDisplayInfo.bottomOffset && this.scaleRatio == pictureInPictureDisplayInfo.scaleRatio;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "PictureInPictureDisplayInfo::bottomOffset = %f,scaleRatio = %f", Float.valueOf(this.bottomOffset), Float.valueOf(this.scaleRatio));
    }
}
