package com.yy.videoplayer.render;

import android.graphics.ImageFormat;
import com.yy.videoplayer.utils.YMFLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes4.dex */
public class YMFImageBuffer {
    private static int mDirectoryBufferOffset;
    public int mBufSize;
    public boolean mChangeRenderMode;
    public boolean mClipWindow;
    public int mCropBottom;
    public int mCropLeft;
    public int mCropRight;
    public int mCropTop;
    public ByteBuffer mData;
    public long mDts;
    public int mFormat;
    public boolean mHardware;
    public int mHeight;
    public boolean mIgnore;
    public boolean mNotifyRenderInfo;
    public long mPts;
    public int mSsrc;
    public long mStreamId;
    public boolean mStreamStart;
    public int mWidth;
    public boolean mDirectHardRender = false;
    public boolean mNeedRendered = true;
    public long mLastNotifyRenderInfoPts = 0;
    public long mDeltaPts = 0;
    public boolean mMultiIgnoreState = false;
    public ReentrantReadWriteLock mSyncLock = new ReentrantReadWriteLock();

    public void tryLockData() {
        this.mSyncLock.writeLock().lock();
    }

    public void tryUnlockData() {
        while (this.mSyncLock.getWriteHoldCount() != 0) {
            try {
                this.mSyncLock.writeLock().unlock();
            } catch (IllegalMonitorStateException e) {
                YMFLog.warn(this, "[Decoder ]", "tryUnlockData more than once, exception:" + e.toString());
                return;
            }
        }
    }

    public YMFImageBuffer(int i, int i2, int i3, boolean z) {
        this.mStreamStart = false;
        this.mNotifyRenderInfo = true;
        this.mIgnore = false;
        if (i <= 0 || i2 <= 0) {
            YMFLog.error(this, "[Util    ]", "invalid width or height. width:%d, height:%d", Integer.valueOf(i), Integer.valueOf(i2));
            return;
        }
        this.mWidth = i;
        this.mHeight = i2;
        this.mFormat = i3;
        this.mCropLeft = 0;
        this.mCropRight = i - 1;
        this.mCropTop = 0;
        this.mCropBottom = i2 - 1;
        this.mClipWindow = false;
        this.mStreamStart = true;
        this.mNotifyRenderInfo = true;
        this.mIgnore = false;
        this.mChangeRenderMode = false;
        this.mSsrc = 0;
        if (i3 == 1 || i3 == 2 || i3 == 0 || i3 == 3) {
            this.mBufSize = ((this.mWidth * this.mHeight) * ImageFormat.getBitsPerPixel(17)) / 8;
        } else if (i3 == 36) {
            this.mBufSize = ((this.mWidth * this.mHeight) * getBitsPerRgbPixel(i3)) / 8;
        } else {
            YMFLog.error(this, "[Util    ]", "unsupported format:" + i3);
        }
        if (z && this.mBufSize > 0) {
            this.mData = ByteBuffer.allocateDirect(this.mBufSize + offset());
            this.mData.order(ByteOrder.nativeOrder());
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

    public YMFImageBuffer assign(ByteBuffer byteBuffer, int i, int i2, int i3, long j, long j2, boolean z, long j3, int i4, int i5, int i6, int i7, boolean z2, int i8) {
        if (!byteBuffer.isDirect()) {
            YMFLog.error(this, "[Util    ]", "wrap error, only support directory ByteBuffer.");
            return null;
        }
        if (i3 == 36) {
            this.mBufSize = ((i * i2) * getBitsPerRgbPixel(i3)) / 8;
        } else {
            this.mBufSize = ((i * i2) * ImageFormat.getBitsPerPixel(17)) / 8;
        }
        this.mWidth = i;
        this.mHeight = i2;
        this.mCropRight = i5;
        this.mCropBottom = i6;
        this.mCropLeft = i4;
        this.mCropTop = i7;
        this.mFormat = i3;
        this.mData = byteBuffer;
        this.mPts = j;
        this.mDts = j2;
        this.mHardware = z;
        this.mStreamId = j3;
        this.mClipWindow = z2;
        this.mSsrc = i8;
        return this;
    }

    public YMFImageBuffer assign(YMFImageBuffer yMFImageBuffer) {
        this.mPts = yMFImageBuffer.mPts;
        this.mDts = yMFImageBuffer.mDts;
        this.mData = yMFImageBuffer.mData;
        this.mWidth = yMFImageBuffer.mWidth;
        this.mHeight = yMFImageBuffer.mHeight;
        this.mFormat = yMFImageBuffer.mFormat;
        this.mBufSize = yMFImageBuffer.mBufSize;
        this.mHardware = yMFImageBuffer.mHardware;
        this.mStreamId = yMFImageBuffer.mStreamId;
        this.mCropRight = yMFImageBuffer.mCropRight;
        this.mCropBottom = yMFImageBuffer.mCropBottom;
        this.mCropLeft = yMFImageBuffer.mCropLeft;
        this.mCropTop = yMFImageBuffer.mCropTop;
        this.mClipWindow = yMFImageBuffer.mClipWindow;
        this.mNeedRendered = yMFImageBuffer.mNeedRendered;
        this.mStreamStart = yMFImageBuffer.mStreamStart;
        this.mSsrc = yMFImageBuffer.mSsrc;
        this.mNotifyRenderInfo = yMFImageBuffer.mNotifyRenderInfo;
        this.mIgnore = yMFImageBuffer.mIgnore;
        this.mChangeRenderMode = yMFImageBuffer.mChangeRenderMode;
        this.mDeltaPts = yMFImageBuffer.mDeltaPts;
        if (this.mMultiIgnoreState) {
            this.mIgnore = true;
        } else {
            this.mMultiIgnoreState = yMFImageBuffer.mMultiIgnoreState;
        }
        return this;
    }

    public YMFImageBuffer assignWithoutBuffer(YMFImageBuffer yMFImageBuffer) {
        this.mPts = yMFImageBuffer.mPts;
        this.mDeltaPts = yMFImageBuffer.mDeltaPts;
        this.mDts = yMFImageBuffer.mDts;
        this.mWidth = yMFImageBuffer.mWidth;
        this.mHeight = yMFImageBuffer.mHeight;
        this.mFormat = yMFImageBuffer.mFormat;
        this.mBufSize = yMFImageBuffer.mBufSize;
        this.mHardware = yMFImageBuffer.mHardware;
        this.mStreamId = yMFImageBuffer.mStreamId;
        this.mCropRight = yMFImageBuffer.mCropRight;
        this.mCropBottom = yMFImageBuffer.mCropBottom;
        this.mCropLeft = yMFImageBuffer.mCropLeft;
        this.mCropTop = yMFImageBuffer.mCropTop;
        this.mClipWindow = yMFImageBuffer.mClipWindow;
        this.mNeedRendered = yMFImageBuffer.mNeedRendered;
        this.mStreamStart = yMFImageBuffer.mStreamStart;
        this.mSsrc = yMFImageBuffer.mSsrc;
        this.mNotifyRenderInfo = yMFImageBuffer.mNotifyRenderInfo;
        this.mIgnore = yMFImageBuffer.mIgnore;
        this.mChangeRenderMode = yMFImageBuffer.mChangeRenderMode;
        if (this.mMultiIgnoreState) {
            this.mIgnore = true;
        } else {
            this.mMultiIgnoreState = yMFImageBuffer.mMultiIgnoreState;
        }
        return this;
    }

    public boolean deepCopy(YMFImageBuffer yMFImageBuffer) {
        if (this.mWidth != yMFImageBuffer.mWidth || this.mHeight != yMFImageBuffer.mHeight || this.mBufSize != yMFImageBuffer.mBufSize) {
            YMFLog.error(this, "[Util    ]", "copy with different buffer size.");
            return false;
        } else if (this.mFormat != yMFImageBuffer.mFormat) {
            YMFLog.error(this, "[Util    ]", "copy with different image format");
            return false;
        } else {
            this.mPts = yMFImageBuffer.mPts;
            this.mDts = yMFImageBuffer.mDts;
            this.mFormat = yMFImageBuffer.mFormat;
            System.arraycopy(yMFImageBuffer.mData.array(), yMFImageBuffer.mData.arrayOffset(), this.mData.array(), this.mData.arrayOffset(), this.mBufSize);
            return true;
        }
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
            YMFLog.info(null, " YMFImageBuffer ", " mDirectoryBufferOffset " + mDirectoryBufferOffset);
        }
    }
}
