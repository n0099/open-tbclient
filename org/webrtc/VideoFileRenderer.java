package org.webrtc;

import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;
import org.webrtc.EglBase;
import org.webrtc.VideoFrame;
/* loaded from: classes2.dex */
public class VideoFileRenderer implements VideoSink {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "VideoFileRenderer";
    public transient /* synthetic */ FieldHolder $fh;
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

    public VideoFileRenderer(String str, int i2, int i3, EglBase.Context context) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (i2 % 2 == 1 || i3 % 2 == 1) {
            throw new IllegalArgumentException("Does not support uneven width or height");
        }
        this.outputFileName = str;
        this.outputFileWidth = i2;
        this.outputFileHeight = i3;
        int i6 = ((i2 * i3) * 3) / 2;
        this.outputFrameSize = i6;
        this.outputFrameBuffer = ByteBuffer.allocateDirect(i6);
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        this.videoOutFile = fileOutputStream;
        fileOutputStream.write(("YUV4MPEG2 C420 W" + i2 + " H" + i3 + " Ip F30:1 A1:1\n").getBytes(Charset.forName("US-ASCII")));
        HandlerThread handlerThread = new HandlerThread("VideoFileRendererRenderThread");
        this.renderThread = handlerThread;
        handlerThread.start();
        this.renderThreadHandler = new Handler(this.renderThread.getLooper());
        HandlerThread handlerThread2 = new HandlerThread("VideoFileRendererFileThread");
        this.fileThread = handlerThread2;
        handlerThread2.start();
        this.fileThreadHandler = new Handler(this.fileThread.getLooper());
        ThreadUtils.invokeAtFrontUninterruptibly(this.renderThreadHandler, new Runnable(this, context) { // from class: org.webrtc.VideoFileRenderer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VideoFileRenderer this$0;
            public final /* synthetic */ EglBase.Context val$sharedContext;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, context};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i7 = newInitContext2.flag;
                    if ((i7 & 1) != 0) {
                        int i8 = i7 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$sharedContext = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.eglBase = EglBase_CC.create(this.val$sharedContext, EglBase.CONFIG_PIXEL_BUFFER);
                    this.this$0.eglBase.createDummyPbufferSurface();
                    this.this$0.eglBase.makeCurrent();
                    this.this$0.yuvConverter = new YuvConverter();
                }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, videoFrame) == null) {
            VideoFrame.Buffer buffer = videoFrame.getBuffer();
            int i2 = videoFrame.getRotation() % 180 == 0 ? this.outputFileWidth : this.outputFileHeight;
            int i3 = videoFrame.getRotation() % 180 == 0 ? this.outputFileHeight : this.outputFileWidth;
            float width = buffer.getWidth() / buffer.getHeight();
            float f2 = i2 / i3;
            int width2 = buffer.getWidth();
            int height = buffer.getHeight();
            if (f2 > width) {
                height = (int) (height * (width / f2));
            } else {
                width2 = (int) (width2 * (f2 / width));
            }
            VideoFrame.Buffer cropAndScale = buffer.cropAndScale((buffer.getWidth() - width2) / 2, (buffer.getHeight() - height) / 2, width2, height, i2, i3);
            videoFrame.release();
            final VideoFrame.I420Buffer i420 = cropAndScale.toI420();
            cropAndScale.release();
            this.fileThreadHandler.post(new Runnable() { // from class: org.webrtc._$$Lambda$VideoFileRenderer$zRQe0q8wC2jUCR9Cw2PQybfFSuQ
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        VideoFileRenderer.lambda$renderFrameOnRenderThread$1(VideoFileRenderer.this, i420, videoFrame);
                    }
                }
            });
        }
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(final VideoFrame videoFrame) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, videoFrame) == null) {
            videoFrame.retain();
            this.renderThreadHandler.post(new Runnable() { // from class: org.webrtc._$$Lambda$VideoFileRenderer$bKgq7kthmTRkJZ0wD92QUSGMogk
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        VideoFileRenderer.this.renderFrameOnRenderThread(videoFrame);
                    }
                }
            });
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.renderThreadHandler.post(new Runnable() { // from class: org.webrtc._$$Lambda$VideoFileRenderer$O3_FJr8jIW3Oq5g0_9C_SlJYw9E
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        VideoFileRenderer.lambda$release$2(VideoFileRenderer.this, countDownLatch);
                    }
                }
            });
            ThreadUtils.awaitUninterruptibly(countDownLatch);
            this.fileThreadHandler.post(new Runnable() { // from class: org.webrtc._$$Lambda$VideoFileRenderer$_Z_EOR6W5DmTV8ot_2YxFLur_yE
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        VideoFileRenderer.lambda$release$3(VideoFileRenderer.this);
                    }
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
}
