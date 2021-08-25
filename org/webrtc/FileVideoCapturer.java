package org.webrtc;

import android.content.Context;
import android.os.SystemClock;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class FileVideoCapturer implements VideoCapturer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FileVideoCapturer";
    public transient /* synthetic */ FieldHolder $fh;
    public CapturerObserver capturerObserver;
    public final TimerTask tickTask;
    public final Timer timer;
    public final VideoReader videoReader;

    /* loaded from: classes2.dex */
    public interface VideoReader {
        void close();

        VideoFrame getNextFrame();
    }

    /* loaded from: classes2.dex */
    public static class VideoReaderY4M implements VideoReader {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int FRAME_DELIMETER_LENGTH = 6;
        public static final String TAG = "VideoReaderY4M";
        public static final String Y4M_FRAME_DELIMETER = "FRAME";
        public transient /* synthetic */ FieldHolder $fh;
        public final int frameHeight;
        public final int frameWidth;
        public final RandomAccessFile mediaFile;
        public final FileChannel mediaFileChannel;
        public final long videoStart;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1917198717, "Lorg/webrtc/FileVideoCapturer$VideoReaderY4M;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1917198717, "Lorg/webrtc/FileVideoCapturer$VideoReaderY4M;");
            }
        }

        public VideoReaderY4M(String str) throws IOException {
            String[] split;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, r.f42169a);
            this.mediaFile = randomAccessFile;
            this.mediaFileChannel = randomAccessFile.getChannel();
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = this.mediaFile.read();
                if (read == -1) {
                    throw new RuntimeException("Found end of file before end of header for file: " + str);
                } else if (read == 10) {
                    this.videoStart = this.mediaFileChannel.position();
                    String str2 = "";
                    int i4 = 0;
                    int i5 = 0;
                    for (String str3 : sb.toString().split("[ ]")) {
                        char charAt = str3.charAt(0);
                        if (charAt == 'C') {
                            str2 = str3.substring(1);
                        } else if (charAt == 'H') {
                            i5 = Integer.parseInt(str3.substring(1));
                        } else if (charAt == 'W') {
                            i4 = Integer.parseInt(str3.substring(1));
                        }
                    }
                    Logging.d(TAG, "Color space: " + str2);
                    if (!str2.equals("420") && !str2.equals("420mpeg2")) {
                        throw new IllegalArgumentException("Does not support any other color space than I420 or I420mpeg2");
                    }
                    if (i4 % 2 == 1 || i5 % 2 == 1) {
                        throw new IllegalArgumentException("Does not support odd width or height");
                    }
                    this.frameWidth = i4;
                    this.frameHeight = i5;
                    Logging.d(TAG, "frame dim: (" + i4 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i5 + SmallTailInfo.EMOTION_SUFFIX);
                    return;
                } else {
                    sb.append((char) read);
                }
            }
        }

        @Override // org.webrtc.FileVideoCapturer.VideoReader
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.mediaFile.close();
                } catch (IOException e2) {
                    Logging.e(TAG, "Problem closing file", e2);
                }
            }
        }

        @Override // org.webrtc.FileVideoCapturer.VideoReader
        public VideoFrame getNextFrame() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime());
                JavaI420Buffer allocate = JavaI420Buffer.allocate(this.frameWidth, this.frameHeight);
                ByteBuffer dataY = allocate.getDataY();
                ByteBuffer dataU = allocate.getDataU();
                ByteBuffer dataV = allocate.getDataV();
                int i2 = (this.frameHeight + 1) / 2;
                allocate.getStrideY();
                allocate.getStrideU();
                allocate.getStrideV();
                try {
                    ByteBuffer allocate2 = ByteBuffer.allocate(FRAME_DELIMETER_LENGTH);
                    if (this.mediaFileChannel.read(allocate2) < FRAME_DELIMETER_LENGTH) {
                        this.mediaFileChannel.position(this.videoStart);
                        if (this.mediaFileChannel.read(allocate2) < FRAME_DELIMETER_LENGTH) {
                            throw new RuntimeException("Error looping video");
                        }
                    }
                    String str = new String(allocate2.array(), Charset.forName("US-ASCII"));
                    if (str.equals("FRAME\n")) {
                        this.mediaFileChannel.read(dataY);
                        this.mediaFileChannel.read(dataU);
                        this.mediaFileChannel.read(dataV);
                        return new VideoFrame(allocate, 0, nanos);
                    }
                    throw new RuntimeException("Frames should be delimited by FRAME plus newline, found delimter was: '" + str + "'");
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
            return (VideoFrame) invokeV.objValue;
        }
    }

    public FileVideoCapturer(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.timer = new Timer();
        this.tickTask = new TimerTask(this) { // from class: org.webrtc.FileVideoCapturer.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FileVideoCapturer this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.tick();
                }
            }
        };
        try {
            this.videoReader = new VideoReaderY4M(str);
        } catch (IOException e2) {
            Logging.d(TAG, "Could not open video file: " + str);
            throw e2;
        }
    }

    @Override // org.webrtc.VideoCapturer
    public void changeCaptureFormat(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
        }
    }

    @Override // org.webrtc.VideoCapturer
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.videoReader.close();
        }
    }

    @Override // org.webrtc.VideoCapturer
    public void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, surfaceTextureHelper, context, capturerObserver) == null) {
            this.capturerObserver = capturerObserver;
        }
    }

    @Override // org.webrtc.VideoCapturer
    public boolean isScreencast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // org.webrtc.VideoCapturer
    public void startCapture(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048580, this, i2, i3, i4) == null) {
            this.timer.schedule(this.tickTask, 0L, 1000 / i4);
        }
    }

    @Override // org.webrtc.VideoCapturer
    public void stopCapture() throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.timer.cancel();
        }
    }

    public void tick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            VideoFrame nextFrame = this.videoReader.getNextFrame();
            this.capturerObserver.onFrameCaptured(nextFrame);
            nextFrame.release();
        }
    }
}
