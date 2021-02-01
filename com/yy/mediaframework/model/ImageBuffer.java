package com.yy.mediaframework.model;

import android.graphics.ImageFormat;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class ImageBuffer {
    public int mWidth = 0;
    public int mHeight = 0;
    public ByteBuffer mDataBuffer = null;
    public int mImageFormat = 17;

    public int imageSize() {
        return ((this.mWidth * this.mHeight) * ImageFormat.getBitsPerPixel(this.mImageFormat)) / 8;
    }

    public void clear() {
        if (this.mDataBuffer != null) {
            this.mDataBuffer.clear();
        }
    }
}
