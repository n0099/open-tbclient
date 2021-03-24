package org.webrtc;

import android.os.Handler;
import android.os.HandlerThread;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;
import org.webrtc.EglBase;
import org.webrtc.VideoFrame;
/* loaded from: classes7.dex */
public class VideoFileRenderer implements VideoSink {
    public static final String TAG = "VideoFileRenderer";
    public EglBase eglBase;
    public final HandlerThread fileThread;
    public final Handler fileThreadHandler;
    public int frameCount;
    public final int outputFileHeight;
    public final String outputFileName;
    public final int outputFileWidth;
    public final ByteBuffer outputFrameBuffer;
    public final int outputFrameSize;
    public final HandlerThread renderThread;
    public final Handler renderThreadHandler;
    public final FileOutputStream videoOutFile;
    public YuvConverter yuvConverter;

    public VideoFileRenderer(String str, int i, int i2, final EglBase.Context context) throws IOException {
        if (i % 2 == 1 || i2 % 2 == 1) {
            throw new IllegalArgumentException("Does not support uneven width or height");
        }
        this.outputFileName = str;
        this.outputFileWidth = i;
        this.outputFileHeight = i2;
        int i3 = ((i * i2) * 3) / 2;
        this.outputFrameSize = i3;
        this.outputFrameBuffer = ByteBuffer.allocateDirect(i3);
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        this.videoOutFile = fileOutputStream;
        fileOutputStream.write(("YUV4MPEG2 C420 W" + i + " H" + i2 + " Ip F30:1 A1:1\n").getBytes(Charset.forName("US-ASCII")));
        HandlerThread handlerThread = new HandlerThread("VideoFileRendererRenderThread");
        this.renderThread = handlerThread;
        handlerThread.start();
        this.renderThreadHandler = new Handler(this.renderThread.getLooper());
        HandlerThread handlerThread2 = new HandlerThread("VideoFileRendererFileThread");
        this.fileThread = handlerThread2;
        handlerThread2.start();
        this.fileThreadHandler = new Handler(this.fileThread.getLooper());
        ThreadUtils.invokeAtFrontUninterruptibly(this.renderThreadHandler, new Runnable() { // from class: org.webrtc.VideoFileRenderer.1
            @Override // java.lang.Runnable
            public void run() {
                VideoFileRenderer.this.eglBase = EglBase_CC.create(context, EglBase.CONFIG_PIXEL_BUFFER);
                VideoFileRenderer.this.eglBase.createDummyPbufferSurface();
                VideoFileRenderer.this.eglBase.makeCurrent();
                VideoFileRenderer.this.yuvConverter = new YuvConverter();
            }
        });
    }

    public static /* synthetic */ void lambda$release$2(VideoFileRenderer videoFileRenderer, CountDownLatch countDownLatch) {
        videoFileRenderer.yuvConverter.release();
        videoFileRenderer.eglBase.release();
        videoFileRenderer.renderThread.quit();
        countDownLatch.countDown();
    }

    public static /* synthetic */ void lambda$release$3(VideoFileRenderer videoFileRenderer) {
        try {
            videoFileRenderer.videoOutFile.close();
            Logging.d(TAG, "Video written to disk as " + videoFileRenderer.outputFileName + ". The number of frames is " + videoFileRenderer.frameCount + " and the dimensions of the frames are " + videoFileRenderer.outputFileWidth + "x" + videoFileRenderer.outputFileHeight + ".");
            videoFileRenderer.fileThread.quit();
        } catch (IOException e2) {
            throw new RuntimeException("Error closing output file", e2);
        }
    }

    public static /* synthetic */ void lambda$renderFrameOnRenderThread$1(VideoFileRenderer videoFileRenderer, VideoFrame.I420Buffer i420Buffer, VideoFrame videoFrame) {
        YuvHelper.I420Rotate(i420Buffer.getDataY(), i420Buffer.getStrideY(), i420Buffer.getDataU(), i420Buffer.getStrideU(), i420Buffer.getDataV(), i420Buffer.getStrideV(), videoFileRenderer.outputFrameBuffer, i420Buffer.getWidth(), i420Buffer.getHeight(), videoFrame.getRotation());
        i420Buffer.release();
        try {
            videoFileRenderer.videoOutFile.write("FRAME\n".getBytes(Charset.forName("US-ASCII")));
            videoFileRenderer.videoOutFile.write(videoFileRenderer.outputFrameBuffer.array(), videoFileRenderer.outputFrameBuffer.arrayOffset(), videoFileRenderer.outputFrameSize);
            videoFileRenderer.frameCount++;
        } catch (IOException e2) {
            throw new RuntimeException("Error writing video to disk", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderFrameOnRenderThread(final VideoFrame videoFrame) {
        VideoFrame.Buffer buffer = videoFrame.getBuffer();
        int i = videoFrame.getRotation() % 180 == 0 ? this.outputFileWidth : this.outputFileHeight;
        int i2 = videoFrame.getRotation() % 180 == 0 ? this.outputFileHeight : this.outputFileWidth;
        float width = buffer.getWidth() / buffer.getHeight();
        float f2 = i / i2;
        int width2 = buffer.getWidth();
        int height = buffer.getHeight();
        if (f2 > width) {
            height = (int) (height * (width / f2));
        } else {
            width2 = (int) (width2 * (f2 / width));
        }
        VideoFrame.Buffer cropAndScale = buffer.cropAndScale((buffer.getWidth() - width2) / 2, (buffer.getHeight() - height) / 2, width2, height, i, i2);
        videoFrame.release();
        final VideoFrame.I420Buffer i420 = cropAndScale.toI420();
        cropAndScale.release();
        this.fileThreadHandler.post(new Runnable() { // from class: org.webrtc._$$Lambda$VideoFileRenderer$zRQe0q8wC2jUCR9Cw2PQybfFSuQ
            @Override // java.lang.Runnable
            public final void run() {
                VideoFileRenderer.lambda$renderFrameOnRenderThread$1(VideoFileRenderer.this, i420, videoFrame);
            }
        });
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(final VideoFrame videoFrame) {
        videoFrame.retain();
        this.renderThreadHandler.post(new Runnable() { // from class: org.webrtc._$$Lambda$VideoFileRenderer$bKgq7kthmTRkJZ0wD92QUSGMogk
            @Override // java.lang.Runnable
            public final void run() {
                VideoFileRenderer.this.renderFrameOnRenderThread(videoFrame);
            }
        });
    }

    public void release() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.renderThreadHandler.post(new Runnable() { // from class: org.webrtc._$$Lambda$VideoFileRenderer$O3_FJr8jIW3Oq5g0_9C_SlJYw9E
            @Override // java.lang.Runnable
            public final void run() {
                VideoFileRenderer.lambda$release$2(VideoFileRenderer.this, countDownLatch);
            }
        });
        ThreadUtils.awaitUninterruptibly(countDownLatch);
        this.fileThreadHandler.post(new Runnable() { // from class: org.webrtc._$$Lambda$VideoFileRenderer$_Z_EOR6W5DmTV8ot_2YxFLur_yE
            @Override // java.lang.Runnable
            public final void run() {
                VideoFileRenderer.lambda$release$3(VideoFileRenderer.this);
            }
        });
        try {
            this.fileThread.join();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            Logging.e(TAG, "Interrupted while waiting for the write to disk to complete.", e2);
        }
    }
}
