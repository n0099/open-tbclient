package com.repackage;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class z99 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaMuxer a;
    public MediaCodec b;
    public MediaCodec.BufferInfo c;
    public boolean d;
    public long e;
    public long f;
    public int g;
    public int h;
    public volatile boolean i;

    public z99() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
    }

    public static MediaCodecInfo b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i = 0; i < codecCount; i++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
                if (codecInfoAt.isEncoder()) {
                    for (String str2 : codecInfoAt.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            return codecInfoAt;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (MediaCodecInfo) invokeL.objValue;
    }

    public final int a(MediaCodec mediaCodec) {
        InterceptResult invokeL;
        int addTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mediaCodec)) == null) {
            synchronized (this) {
                MediaFormat outputFormat = mediaCodec.getOutputFormat();
                if (k99.g(outputFormat) == 1) {
                    outputFormat.setString("qlc", "123adb");
                    outputFormat.setString("adc", "123adb");
                    addTrack = this.a.addTrack(outputFormat);
                    this.g = addTrack;
                } else {
                    addTrack = this.a.addTrack(outputFormat);
                    this.h = addTrack;
                }
                if (this.g != -1) {
                    this.a.start();
                    this.i = true;
                    notifyAll();
                    Log.i("HWRecorder", "MediaMuxer has added all track, notifyAll");
                }
            }
            return addTrack;
        }
        return invokeL.intValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                h();
            } catch (Exception e) {
                Log.e("HWRecorder", "stop exception occur: " + e.getLocalizedMessage());
            }
            if (this.d) {
                Log.i("HWRecorder", "Recorder released");
            }
            this.d = false;
        }
    }

    public void d(int i, int i2, int i3, int i4, int i5, int i6, String str) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str}) == null) {
            if (b("video/avc") == null || b("audio/mp4a-latm") == null) {
                throw new Exception("cannot find suitable codec");
            }
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
            createVideoFormat.setInteger("bitrate", i4);
            createVideoFormat.setInteger("frame-rate", 30);
            createVideoFormat.setInteger("i-frame-interval", 5);
            createVideoFormat.setInteger("color-format", i3);
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
            this.b = createEncoderByType;
            createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.b.start();
            File file = new File(str);
            if (file.exists() && !file.delete()) {
                Log.w("HWRecorder", "delete file failed");
            }
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            this.a = new MediaMuxer(str, 0);
            this.i = false;
            this.g = -1;
            this.h = -1;
            this.e = -1L;
            this.f = -1L;
            this.c = new MediaCodec.BufferInfo();
            new MediaCodec.BufferInfo();
            this.d = true;
            Log.i("HWRecorder", "Recorder initialized");
        }
    }

    public final void e(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048579, this, mediaCodec, bufferInfo) != null) {
            return;
        }
        int i = mediaCodec == this.b ? this.g : this.h;
        while (true) {
            ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
                if (dequeueOutputBuffer == -3) {
                    break;
                } else if (dequeueOutputBuffer == -2) {
                    i = a(mediaCodec);
                } else if (dequeueOutputBuffer == -1) {
                    return;
                } else {
                    if (dequeueOutputBuffer < 0) {
                        Log.w("HWRecorder", "drainEncoder unexpected result: " + dequeueOutputBuffer);
                    } else if ((bufferInfo.flags & 2) == 0) {
                        if (bufferInfo.size != 0) {
                            ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                            if (byteBuffer == null) {
                                throw new RuntimeException("drainEncoder get outputBuffer " + dequeueOutputBuffer + " was null");
                            }
                            synchronized (this) {
                                if (!this.i) {
                                    wait();
                                }
                            }
                            byteBuffer.position(bufferInfo.offset);
                            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            this.a.writeSampleData(i, byteBuffer, bufferInfo);
                        }
                        mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    public final void f(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo, byte[] bArr, long j) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{mediaCodec, bufferInfo, bArr, Long.valueOf(j)}) == null) {
            if (!this.d) {
                Log.e("HWRecorder", "Recorder must be initialized!");
                return;
            }
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L);
            ByteBuffer byteBuffer = mediaCodec.getInputBuffers()[dequeueInputBuffer];
            if (dequeueInputBuffer >= 0) {
                byteBuffer.clear();
                byteBuffer.put(bArr);
                mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j, 0);
            }
            e(mediaCodec, bufferInfo);
        }
    }

    public void g(byte[] bArr) throws Exception {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bArr) == null) {
            int i = (this.e > (-1L) ? 1 : (this.e == (-1L) ? 0 : -1));
            long nanoTime = System.nanoTime();
            if (i == 0) {
                this.e = nanoTime;
                j = 0;
            } else {
                j = (nanoTime - this.e) / 1000;
            }
            long j2 = this.f;
            if (j <= j2) {
                j += (j2 - j) + 1000;
            }
            long j3 = j;
            this.f = j3;
            f(this.b, this.c, bArr, j3);
        }
    }

    public final void h() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MediaCodec mediaCodec = this.b;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.b.release();
                this.b = null;
            }
            MediaMuxer mediaMuxer = this.a;
            if (mediaMuxer != null) {
                mediaMuxer.stop();
                this.a.release();
                this.a = null;
            }
        }
    }
}
