package com.yy.mediaframework.model;

import com.yy.mediaframework.model.ImageBuffer;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class ImageBufferPool<T extends ImageBuffer> {
    AtomicInteger mBufferCnt = new AtomicInteger(0);
    private int mCapacity;
    private ConcurrentLinkedQueue<T> mFreeArray;
    private int mHeight;
    private int mImageByteSize;
    Class<T> mImageClazz;
    private int mImageFormat;
    private int mWidth;

    public ImageBufferPool(int i, int i2, int i3, int i4, Class<T> cls, int i5) {
        this.mImageClazz = null;
        this.mFreeArray = null;
        this.mCapacity = 0;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mImageFormat = 0;
        this.mImageClazz = cls;
        this.mCapacity = i3;
        this.mFreeArray = new ConcurrentLinkedQueue<>();
        this.mWidth = i;
        this.mHeight = i2;
        this.mImageByteSize = i5;
        this.mImageFormat = i4;
        for (int i6 = 0; i6 < i3; i6++) {
            this.mFreeArray.offer(newImageBuffer(i, i2));
        }
        this.mBufferCnt.set(i3);
    }

    private T newImageBuffer(int i, int i2) {
        try {
            T newInstance = this.mImageClazz.newInstance();
            newInstance.mWidth = i;
            newInstance.mHeight = i2;
            newInstance.mImageFormat = this.mImageFormat;
            int i3 = this.mImageByteSize;
            if (i3 == 0) {
                i3 = newInstance.imageSize();
            }
            YMFLog.info(this, "[Util    ]", "newImageBuffer imageSize:" + i3 + " mImageByteSize:" + this.mImageByteSize);
            newInstance.mDataBuffer = ByteBuffer.allocate(i3);
            newInstance.mDataBuffer.order(ByteOrder.nativeOrder());
            return newInstance;
        } catch (IllegalAccessException e) {
            YMFLog.info(this, "[Util    ]", "newImageBuffer exception:" + e.getMessage());
            return null;
        } catch (InstantiationException e2) {
            YMFLog.info(this, "[Util    ]", "newImageBuffer exception:" + e2.getMessage());
            return null;
        }
    }

    public T newBuffer(int i, int i2) {
        if (this.mWidth != i || this.mHeight != i2) {
            this.mWidth = i;
            this.mHeight = i2;
        }
        T poll = this.mFreeArray.poll();
        while (poll != null) {
            this.mBufferCnt.decrementAndGet();
            if (poll.mWidth == i && poll.mHeight == i2) {
                break;
            }
            poll = this.mFreeArray.poll();
        }
        if (poll == null) {
            return newImageBuffer(this.mWidth, this.mHeight);
        }
        return poll;
    }

    public void freeBuffer(T t) {
        if (t.mHeight == this.mHeight && t.mWidth == this.mWidth && t != null) {
            t.clear();
            if (this.mBufferCnt.get() < this.mCapacity) {
                this.mFreeArray.offer(t);
            }
        }
    }
}
