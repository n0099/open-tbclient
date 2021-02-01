package com.yy.mediaframework.filters;

import android.annotation.TargetApi;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.yy.mediaframework.model.ImageBuffer;
import com.yy.mediaframework.model.ImageBufferPool;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.model.YYMediaSampleAlloc;
import com.yy.mediaframework.utils.TimeUtil;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class ImageCaptureFilter extends AbstractYYMediaFilter {
    private int mCacheCnt;
    VideoLiveFilterContext mFilterContext;
    private ConcurrentLinkedQueue<ImageAvailbleRunnable> mImageRunnableQueue;
    AtomicBoolean mInited = new AtomicBoolean(false);
    private ImageBufferPool<ImageBuffer> mImageBufferPool = null;

    /* loaded from: classes4.dex */
    public static class ImageAvailbleRunnable implements Runnable {
        ImageCaptureFilter mHandler;
        ImageBuffer mImageBuffer;

        public ImageAvailbleRunnable(ImageBuffer imageBuffer, ImageCaptureFilter imageCaptureFilter) {
            this.mImageBuffer = null;
            this.mHandler = null;
            this.mImageBuffer = imageBuffer;
            this.mHandler = imageCaptureFilter;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mHandler.handleImageAvaible(this.mImageBuffer);
            if (this.mHandler.mImageBufferPool != null) {
                this.mHandler.mImageBufferPool.freeBuffer(this.mImageBuffer);
            }
            this.mImageBuffer = null;
            if (this.mHandler.mImageRunnableQueue != null) {
                this.mHandler.mImageRunnableQueue.add(this);
            }
        }
    }

    @TargetApi(21)
    public ImageCaptureFilter(VideoLiveFilterContext videoLiveFilterContext, int i) {
        this.mFilterContext = null;
        this.mCacheCnt = 0;
        this.mImageRunnableQueue = null;
        this.mFilterContext = videoLiveFilterContext;
        this.mCacheCnt = i;
        this.mImageRunnableQueue = new ConcurrentLinkedQueue<>();
        for (int i2 = 0; i2 < this.mCacheCnt; i2++) {
            this.mImageRunnableQueue.add(new ImageAvailbleRunnable(null, this));
        }
        YMFLog.info(this, "[SCapture]", "ImageCaptureFilter construct");
    }

    public void onImageAvailable(ByteBuffer byteBuffer, int i, int i2, int i3) {
        if (this.mImageBufferPool == null) {
            this.mImageBufferPool = new ImageBufferPool<>(i, i2, this.mCacheCnt, i3, ImageBuffer.class, byteBuffer.remaining());
        }
        ImageBuffer newBuffer = this.mImageBufferPool.newBuffer(i, i2);
        if (newBuffer != null) {
            int capacity = byteBuffer.remaining() > newBuffer.imageSize() ? newBuffer.mDataBuffer.capacity() : byteBuffer.remaining();
            int position = byteBuffer.position();
            byteBuffer.get(newBuffer.mDataBuffer.array(), 0, capacity);
            byteBuffer.position(position);
            newBuffer.mDataBuffer.position(0);
            if (this.mFilterContext.getGlManager().checkSameThread()) {
                handleImageAvaible(newBuffer);
                return;
            }
            ImageAvailbleRunnable poll = this.mImageRunnableQueue.poll();
            if (poll == null) {
                YMFLog.error(this, "[SCapture]", "onImageAvailable poll runnable return null, so discard capture.");
                this.mImageBufferPool.freeBuffer(newBuffer);
                return;
            }
            poll.mImageBuffer = newBuffer;
            this.mFilterContext.getGlManager().post(poll);
        }
    }

    protected void handleImageAvaible(ImageBuffer imageBuffer) {
        if (!this.mInited.get()) {
            YMFLog.error(this, "[SCapture]", "handleFrameAvailble, not same surfaceTexture or not initialized");
            return;
        }
        YYMediaSample alloc = YYMediaSampleAlloc.instance().alloc();
        alloc.mWidth = imageBuffer.mWidth;
        alloc.mHeight = imageBuffer.mHeight;
        long tickCountLong = TimeUtil.getTickCountLong();
        alloc.mAndoridPtsNanos = TimeUtils.NANOS_PER_MS * tickCountLong;
        alloc.mYYPtsMillions = tickCountLong;
        alloc.mResMode = this.mFilterContext.getCameraPreviewConfig().getResMode();
        alloc.mImageFormat = imageBuffer.mImageFormat;
        alloc.mDataByteBuffer = imageBuffer.mDataBuffer;
        alloc.mBufferOffset = imageBuffer.mDataBuffer.position();
        alloc.mBufferSize = imageBuffer.mDataBuffer.remaining();
        alloc.mCameraFacing = 0;
        alloc.mOrientation = this.mFilterContext.getCameraPreviewConfig().getOrientation();
        alloc.mEncodeWidth = this.mFilterContext.getVideoEncoderConfig().getEncodeWidth();
        alloc.mEncodeHeight = this.mFilterContext.getVideoEncoderConfig().getEncodeHeight();
        alloc.mEncoderType = this.mFilterContext.getVideoEncoderConfig().mEncodeType;
        deliverToDownStream(alloc);
        alloc.decRef();
    }

    @TargetApi(15)
    protected void doInit() {
        this.mInited.set(true);
    }

    public void init() {
        YMFLog.info(this, "[SCapture]", "ImageCaptureFilter init begin");
        if (this.mFilterContext.getGlManager().checkSameThread()) {
            doInit();
        } else {
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.ImageCaptureFilter.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageCaptureFilter.this.doInit();
                }
            });
        }
        YMFLog.info(this, "[SCapture]", "ImageCaptureFilter init done");
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        YMFLog.info(this, "[SCapture]", "ImageCaptureFilter deInit begin");
        if (this.mFilterContext.getGlManager().checkSameThread()) {
            doDeInit();
        } else {
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.ImageCaptureFilter.2
                @Override // java.lang.Runnable
                public void run() {
                    ImageCaptureFilter.this.doDeInit();
                }
            });
        }
        YMFLog.info(this, "[SCapture]", "ImageCaptureFilter deInit done");
    }

    @TargetApi(16)
    protected void doDeInit() {
        if (this.mInited.getAndSet(false) && this.mImageBufferPool != null) {
            this.mImageBufferPool = null;
        }
    }
}
