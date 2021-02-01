package com.yy.mediaframework.model;

import android.graphics.ImageFormat;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class YMFImageBuffer {
    private static int mDirectoryBufferOffset;
    public int mBufSize;
    public ByteBuffer mData;
    public int mFormat;
    public int mHeight;
    public int mWidth;

    public YMFImageBuffer(int i, int i2, int i3, boolean z) {
        if (i <= 0 || i2 <= 0) {
            YMFLog.error(this, "[Util    ]", "invalid width or height.");
            return;
        }
        this.mWidth = i;
        this.mHeight = i2;
        this.mFormat = i3;
        if (i3 == 1 || i3 == 2 || i3 == 0 || i3 == 3) {
            this.mBufSize = ((this.mWidth * this.mHeight) * ImageFormat.getBitsPerPixel(17)) / 8;
        } else if (i3 == 36) {
            this.mBufSize = ((this.mWidth * this.mHeight) * getBitsPerRgbPixel(i3)) / 8;
        } else {
            YMFLog.error(this, "[Util    ]", " unsupported format:" + i3);
        }
        if (z && this.mBufSize > 0) {
            this.mData = ByteBuffer.allocateDirect(this.mBufSize + offset());
        }
    }

    private int getBitsPerRgbPixel(int i) {
        switch (i) {
            case 20:
                return 24;
            case 36:
                return 32;
            case 52:
                return 16;
            default:
                return -1;
        }
    }

    public static int offset() {
        return mDirectoryBufferOffset;
    }

    public YMFImageBuffer wrap(byte[] bArr, int i, int i2, int i3) {
        if (this.mWidth != i || this.mHeight != i2 || this.mFormat != i3) {
            if (i3 == 36) {
                this.mBufSize = ((i * i2) * getBitsPerRgbPixel(i3)) / 8;
            } else {
                this.mBufSize = ((i * i2) * ImageFormat.getBitsPerPixel(17)) / 8;
            }
            this.mWidth = i;
            this.mHeight = i2;
            this.mFormat = i3;
        }
        if (this.mBufSize >= bArr.length) {
            this.mData = ByteBuffer.wrap(bArr);
        }
        return this;
    }

    public boolean deepCopy(YMFImageBuffer yMFImageBuffer) {
        if (this.mWidth != yMFImageBuffer.mWidth || this.mHeight != yMFImageBuffer.mHeight || this.mBufSize != yMFImageBuffer.mBufSize) {
            YMFLog.error(this, "[Util    ]", "copy with different buffer size.");
            return false;
        }
        this.mWidth = yMFImageBuffer.mWidth;
        this.mHeight = yMFImageBuffer.mHeight;
        this.mFormat = yMFImageBuffer.mFormat;
        System.arraycopy(yMFImageBuffer.mData.array(), yMFImageBuffer.mData.arrayOffset(), this.mData.array(), this.mData.arrayOffset(), this.mBufSize);
        return true;
    }

    public int getYoffset() {
        return 0;
    }

    public int getUoffset() {
        return this.mWidth * this.mHeight;
    }

    public int getVoffset() {
        return ((this.mWidth * this.mHeight) * 5) / 4;
    }

    static {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(4);
        if (allocateDirect.hasArray()) {
            mDirectoryBufferOffset = allocateDirect.arrayOffset();
            YMFLog.warn("", "[Util    ]", "mDirectoryBufferOffset:" + mDirectoryBufferOffset);
        }
    }
}
