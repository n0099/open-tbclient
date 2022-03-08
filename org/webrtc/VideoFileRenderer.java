package org.webrtc;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.c.i0;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;
import org.webrtc.EglBase;
import org.webrtc.VideoFileRenderer;
import org.webrtc.VideoFrame;
/* loaded from: classes9.dex */
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
        if (i2 % 2 != 1 && i3 % 2 != 1) {
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
                        this.this$0.eglBase = i0.c(this.val$sharedContext, EglBase.CONFIG_PIXEL_BUFFER);
                        this.this$0.eglBase.createDummyPbufferSurface();
                        this.this$0.eglBase.makeCurrent();
                        this.this$0.yuvConverter = new YuvConverter();
                    }
                }
            });
            return;
        }
        throw new IllegalArgumentException("Does not support uneven width or height");
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: renderFrameOnRenderThread */
    public void a(final VideoFrame videoFrame) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, videoFrame) == null) {
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
            this.fileThreadHandler.post(new Runnable() { // from class: h.c.d0
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        VideoFileRenderer.this.d(i420, videoFrame);
                    }
                }
            });
        }
    }

    public /* synthetic */ void b(CountDownLatch countDownLatch) {
        this.yuvConverter.release();
        this.eglBase.release();
        this.renderThread.quit();
        countDownLatch.countDown();
    }

    public /* synthetic */ void c() {
        try {
            this.videoOutFile.close();
            Logging.d(TAG, "Video written to disk as " + this.outputFileName + ". The number of frames is " + this.frameCount + " and the dimensions of the frames are " + this.outputFileWidth + "x" + this.outputFileHeight + ".");
            this.fileThread.quit();
        } catch (IOException e2) {
            throw new RuntimeException("Error closing output file", e2);
        }
    }

    public /* synthetic */ void d(VideoFrame.I420Buffer i420Buffer, VideoFrame videoFrame) {
        YuvHelper.I420Rotate(i420Buffer.getDataY(), i420Buffer.getStrideY(), i420Buffer.getDataU(), i420Buffer.getStrideU(), i420Buffer.getDataV(), i420Buffer.getStrideV(), this.outputFrameBuffer, i420Buffer.getWidth(), i420Buffer.getHeight(), videoFrame.getRotation());
        i420Buffer.release();
        try {
            this.videoOutFile.write("FRAME\n".getBytes(Charset.forName("US-ASCII")));
            this.videoOutFile.write(this.outputFrameBuffer.array(), this.outputFrameBuffer.arrayOffset(), this.outputFrameSize);
            this.frameCount++;
        } catch (IOException e2) {
            throw new RuntimeException("Error writing video to disk", e2);
        }
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(final VideoFrame videoFrame) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, videoFrame) == null) {
            videoFrame.retain();
            this.renderThreadHandler.post(new Runnable() { // from class: h.c.c0
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        VideoFileRenderer.this.a(videoFrame);
                    }
                }
            });
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.renderThreadHandler.post(new Runnable() { // from class: h.c.b0
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        VideoFileRenderer.this.b(countDownLatch);
                    }
                }
            });
            ThreadUtils.awaitUninterruptibly(countDownLatch);
            this.fileThreadHandler.post(new Runnable() { // from class: h.c.a0
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        VideoFileRenderer.this.c();
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
