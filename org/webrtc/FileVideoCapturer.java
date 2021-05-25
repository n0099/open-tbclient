package org.webrtc;

import android.content.Context;
import android.os.SystemClock;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class FileVideoCapturer implements VideoCapturer {
    public static final String TAG = "FileVideoCapturer";
    public CapturerObserver capturerObserver;
    public final VideoReader videoReader;
    public final Timer timer = new Timer();
    public final TimerTask tickTask = new TimerTask() { // from class: org.webrtc.FileVideoCapturer.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            FileVideoCapturer.this.tick();
        }
    };

    /* loaded from: classes7.dex */
    public interface VideoReader {
        void close();

        VideoFrame getNextFrame();
    }

    /* loaded from: classes7.dex */
    public static class VideoReaderY4M implements VideoReader {
        public static final int FRAME_DELIMETER_LENGTH = 6;
        public static final String TAG = "VideoReaderY4M";
        public static final String Y4M_FRAME_DELIMETER = "FRAME";
        public final int frameHeight;
        public final int frameWidth;
        public final RandomAccessFile mediaFile;
        public final FileChannel mediaFileChannel;
        public final long videoStart;

        public VideoReaderY4M(String str) throws IOException {
            String[] split;
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, r.f7672a);
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
                    int i2 = 0;
                    int i3 = 0;
                    for (String str3 : sb.toString().split("[ ]")) {
                        char charAt = str3.charAt(0);
                        if (charAt == 'C') {
                            str2 = str3.substring(1);
                        } else if (charAt == 'H') {
                            i3 = Integer.parseInt(str3.substring(1));
                        } else if (charAt == 'W') {
                            i2 = Integer.parseInt(str3.substring(1));
                        }
                    }
                    Logging.d(TAG, "Color space: " + str2);
                    if (!str2.equals("420") && !str2.equals("420mpeg2")) {
                        throw new IllegalArgumentException("Does not support any other color space than I420 or I420mpeg2");
                    }
                    if (i2 % 2 == 1 || i3 % 2 == 1) {
                        throw new IllegalArgumentException("Does not support odd width or height");
                    }
                    this.frameWidth = i2;
                    this.frameHeight = i3;
                    Logging.d(TAG, "frame dim: (" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + SmallTailInfo.EMOTION_SUFFIX);
                    return;
                } else {
                    sb.append((char) read);
                }
            }
        }

        @Override // org.webrtc.FileVideoCapturer.VideoReader
        public void close() {
            try {
                this.mediaFile.close();
            } catch (IOException e2) {
                Logging.e(TAG, "Problem closing file", e2);
            }
        }

        @Override // org.webrtc.FileVideoCapturer.VideoReader
        public VideoFrame getNextFrame() {
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
    }

    public FileVideoCapturer(String str) throws IOException {
        try {
            this.videoReader = new VideoReaderY4M(str);
        } catch (IOException e2) {
            Logging.d(TAG, "Could not open video file: " + str);
            throw e2;
        }
    }

    @Override // org.webrtc.VideoCapturer
    public void changeCaptureFormat(int i2, int i3, int i4) {
    }

    @Override // org.webrtc.VideoCapturer
    public void dispose() {
        this.videoReader.close();
    }

    @Override // org.webrtc.VideoCapturer
    public void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {
        this.capturerObserver = capturerObserver;
    }

    @Override // org.webrtc.VideoCapturer
    public boolean isScreencast() {
        return false;
    }

    @Override // org.webrtc.VideoCapturer
    public void startCapture(int i2, int i3, int i4) {
        this.timer.schedule(this.tickTask, 0L, 1000 / i4);
    }

    @Override // org.webrtc.VideoCapturer
    public void stopCapture() throws InterruptedException {
        this.timer.cancel();
    }

    public void tick() {
        VideoFrame nextFrame = this.videoReader.getNextFrame();
        this.capturerObserver.onFrameCaptured(nextFrame);
        nextFrame.release();
    }
}
