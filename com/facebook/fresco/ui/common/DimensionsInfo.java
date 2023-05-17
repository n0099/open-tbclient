package com.facebook.fresco.ui.common;
/* loaded from: classes8.dex */
public class DimensionsInfo {
    public final int mDecodedImageHeight;
    public final int mDecodedImageWidth;
    public final int mEncodedImageHeight;
    public final int mEncodedImageWidth;
    public final String mScaleType;
    public final int mViewportHeight;
    public final int mViewportWidth;

    public DimensionsInfo(int i, int i2, int i3, int i4, int i5, int i6, String str) {
        this.mViewportWidth = i;
        this.mViewportHeight = i2;
        this.mEncodedImageWidth = i3;
        this.mEncodedImageHeight = i4;
        this.mDecodedImageWidth = i5;
        this.mDecodedImageHeight = i6;
        this.mScaleType = str;
    }

    public int getDecodedImageHeight() {
        return this.mDecodedImageHeight;
    }

    public int getDecodedImageWidth() {
        return this.mDecodedImageWidth;
    }

    public int getEncodedImageHeight() {
        return this.mEncodedImageHeight;
    }

    public int getEncodedImageWidth() {
        return this.mEncodedImageWidth;
    }

    public String getScaleType() {
        return this.mScaleType;
    }

    public int getViewportHeight() {
        return this.mViewportHeight;
    }

    public int getViewportWidth() {
        return this.mViewportWidth;
    }

    public String toString() {
        return "DimensionsInfo{mViewportWidth=" + this.mViewportWidth + ", mViewportHeight=" + this.mViewportHeight + ", mEncodedImageWidth=" + this.mEncodedImageWidth + ", mEncodedImageHeight=" + this.mEncodedImageHeight + ", mDecodedImageWidth=" + this.mDecodedImageWidth + ", mDecodedImageHeight=" + this.mDecodedImageHeight + ", mScaleType='" + this.mScaleType + "'}";
    }
}
