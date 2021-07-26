package d.a.w0.p.f;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
import com.faceunity.encoder.AudioEncoderCore;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f68872a;

    /* renamed from: b  reason: collision with root package name */
    public MediaCodec f68873b;

    /* renamed from: c  reason: collision with root package name */
    public MediaCodec.BufferInfo f68874c;

    /* renamed from: d  reason: collision with root package name */
    public int f68875d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f68876e;

    /* renamed from: f  reason: collision with root package name */
    public long f68877f;

    public b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68877f = 0L;
        this.f68874c = new MediaCodec.BufferInfo();
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", RecordConstants.AUDIO_ENCODE_SAMPLE_RATE, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger("bitrate", RecordConstants.AUDIO_ENCODE_BIT_RATE);
        createAudioFormat.setInteger("max-input-size", 163840);
        try {
            this.f68873b = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f68873b.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f68873b.start();
        this.f68875d = -1;
        this.f68876e = false;
        this.f68872a = dVar;
    }

    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
            }
        }
    }

    public void b(ByteBuffer byteBuffer, int i2, int i3, long j) throws Exception {
        int dequeueInputBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
            ByteBuffer[] inputBuffers = this.f68873b.getInputBuffers();
            while (true) {
                dequeueInputBuffer = this.f68873b.dequeueInputBuffer(10000L);
                if (dequeueInputBuffer >= 0) {
                    break;
                } else if (dequeueInputBuffer == -1) {
                    d.a.w0.t.c.b("wait for MediaCodec encoder");
                }
            }
            ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
            byteBuffer2.clear();
            if (byteBuffer != null) {
                byteBuffer2.put(byteBuffer);
            }
            this.f68873b.queueInputBuffer(dequeueInputBuffer, i2, i3, j, i3 <= 0 ? 4 : 0);
        }
    }

    public void c() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
            return;
        }
        while (true) {
            ByteBuffer[] outputBuffers = this.f68873b.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = this.f68873b.dequeueOutputBuffer(this.f68874c, 10000L);
                if (dequeueOutputBuffer == -1) {
                    return;
                }
                if (dequeueOutputBuffer == -3) {
                    break;
                } else if (dequeueOutputBuffer == -2) {
                    if (this.f68876e) {
                        throw new RuntimeException("format changed twice");
                    }
                    MediaFormat outputFormat = this.f68873b.getOutputFormat();
                    d.a.w0.t.c.c(AudioEncoderCore.TAG, "encoder output format changed: " + outputFormat);
                    this.f68875d = this.f68872a.a(outputFormat);
                    if (!this.f68872a.c()) {
                        synchronized (this.f68872a) {
                            while (!this.f68872a.e()) {
                                try {
                                    this.f68872a.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    this.f68876e = true;
                } else if (dequeueOutputBuffer < 0) {
                    d.a.w0.t.c.l(AudioEncoderCore.TAG, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                    MediaCodec.BufferInfo bufferInfo = this.f68874c;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.f68874c;
                    if (bufferInfo2.size != 0) {
                        if (!this.f68876e) {
                            throw new RuntimeException("muxer hasn't started");
                        }
                        long j = this.f68877f;
                        if (j != 0 && j > bufferInfo2.presentationTimeUs) {
                            bufferInfo2.presentationTimeUs = j + 20000;
                        }
                        byteBuffer.position(this.f68874c.offset);
                        MediaCodec.BufferInfo bufferInfo3 = this.f68874c;
                        byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                        this.f68872a.b(this.f68875d, byteBuffer, this.f68874c);
                        this.f68877f = this.f68874c.presentationTimeUs;
                    }
                    this.f68873b.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.f68874c.flags & 4) != 0) {
                        return;
                    }
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                if (this.f68873b != null) {
                    this.f68873b.stop();
                    this.f68873b.release();
                    this.f68873b = null;
                }
                if (this.f68872a != null) {
                    this.f68872a.d();
                    this.f68872a = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
