package d.a.y0.p.d;

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
import com.kwai.video.player.KsMediaMeta;
import java.io.File;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MediaMuxer f71302a;

    /* renamed from: b  reason: collision with root package name */
    public MediaCodec f71303b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec.BufferInfo f71304c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f71305d;

    /* renamed from: e  reason: collision with root package name */
    public long f71306e;

    /* renamed from: f  reason: collision with root package name */
    public long f71307f;

    /* renamed from: g  reason: collision with root package name */
    public int f71308g;

    /* renamed from: h  reason: collision with root package name */
    public int f71309h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f71310i;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71305d = false;
    }

    public static MediaCodecInfo b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i2 = 0; i2 < codecCount; i2++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
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
                if (d.a.y0.l.d.f.g(outputFormat) == 1) {
                    outputFormat.setString("qlc", "123adb");
                    outputFormat.setString("adc", "123adb");
                    addTrack = this.f71302a.addTrack(outputFormat);
                    this.f71308g = addTrack;
                } else {
                    addTrack = this.f71302a.addTrack(outputFormat);
                    this.f71309h = addTrack;
                }
                if (this.f71308g != -1) {
                    this.f71302a.start();
                    this.f71310i = true;
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
            } catch (Exception e2) {
                Log.e("HWRecorder", "stop exception occur: " + e2.getLocalizedMessage());
            }
            if (this.f71305d) {
                Log.i("HWRecorder", "Recorder released");
            }
            this.f71305d = false;
        }
    }

    public void d(int i2, int i3, int i4, int i5, int i6, int i7, String str) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), str}) == null) {
            if (b("video/avc") == null || b("audio/mp4a-latm") == null) {
                throw new Exception("cannot find suitable codec");
            }
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i2, i3);
            createVideoFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, i5);
            createVideoFormat.setInteger("frame-rate", 30);
            createVideoFormat.setInteger("i-frame-interval", 5);
            createVideoFormat.setInteger("color-format", i4);
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
            this.f71303b = createEncoderByType;
            createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.f71303b.start();
            File file = new File(str);
            if (file.exists() && !file.delete()) {
                Log.w("HWRecorder", "delete file failed");
            }
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            this.f71302a = new MediaMuxer(str, 0);
            this.f71310i = false;
            this.f71308g = -1;
            this.f71309h = -1;
            this.f71306e = -1L;
            this.f71307f = -1L;
            this.f71304c = new MediaCodec.BufferInfo();
            new MediaCodec.BufferInfo();
            this.f71305d = true;
            Log.i("HWRecorder", "Recorder initialized");
        }
    }

    public final void e(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048579, this, mediaCodec, bufferInfo) != null) {
            return;
        }
        int i2 = mediaCodec == this.f71303b ? this.f71308g : this.f71309h;
        while (true) {
            ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
                if (dequeueOutputBuffer == -3) {
                    break;
                } else if (dequeueOutputBuffer == -2) {
                    i2 = a(mediaCodec);
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
                                if (!this.f71310i) {
                                    wait();
                                }
                            }
                            byteBuffer.position(bufferInfo.offset);
                            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            this.f71302a.writeSampleData(i2, byteBuffer, bufferInfo);
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
            if (!this.f71305d) {
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
            int i2 = (this.f71306e > (-1L) ? 1 : (this.f71306e == (-1L) ? 0 : -1));
            long nanoTime = System.nanoTime();
            if (i2 == 0) {
                this.f71306e = nanoTime;
                j = 0;
            } else {
                j = (nanoTime - this.f71306e) / 1000;
            }
            long j2 = this.f71307f;
            if (j <= j2) {
                j += (j2 - j) + 1000;
            }
            long j3 = j;
            this.f71307f = j3;
            f(this.f71303b, this.f71304c, bArr, j3);
        }
    }

    public final void h() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MediaCodec mediaCodec = this.f71303b;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.f71303b.release();
                this.f71303b = null;
            }
            MediaMuxer mediaMuxer = this.f71302a;
            if (mediaMuxer != null) {
                mediaMuxer.stop();
                this.f71302a.release();
                this.f71302a = null;
            }
        }
    }
}
