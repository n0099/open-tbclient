package com.repackage;

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
/* loaded from: classes5.dex */
public class b79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d79 a;
    public MediaCodec b;
    public MediaCodec.BufferInfo c;
    public int d;
    public boolean e;
    public long f;

    public b79(d79 d79Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d79Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = 0L;
        this.c = new MediaCodec.BufferInfo();
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", RecordConstants.AUDIO_ENCODE_SAMPLE_RATE, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger("bitrate", RecordConstants.AUDIO_ENCODE_BIT_RATE);
        createAudioFormat.setInteger("max-input-size", 163840);
        try {
            this.b = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.b.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.b.start();
        this.d = -1;
        this.e = false;
        this.a = d79Var;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void b(ByteBuffer byteBuffer, int i, int i2, long j) throws Exception {
        int dequeueInputBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            ByteBuffer[] inputBuffers = this.b.getInputBuffers();
            while (true) {
                dequeueInputBuffer = this.b.dequeueInputBuffer(10000L);
                if (dequeueInputBuffer >= 0) {
                    break;
                } else if (dequeueInputBuffer == -1) {
                    p79.b("wait for MediaCodec encoder");
                }
            }
            ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
            byteBuffer2.clear();
            if (byteBuffer != null) {
                byteBuffer2.put(byteBuffer);
            }
            this.b.queueInputBuffer(dequeueInputBuffer, i, i2, j, i2 <= 0 ? 4 : 0);
        }
    }

    public void c() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
            return;
        }
        while (true) {
            ByteBuffer[] outputBuffers = this.b.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = this.b.dequeueOutputBuffer(this.c, 10000L);
                if (dequeueOutputBuffer == -1) {
                    return;
                }
                if (dequeueOutputBuffer == -3) {
                    break;
                } else if (dequeueOutputBuffer == -2) {
                    if (this.e) {
                        throw new RuntimeException("format changed twice");
                    }
                    MediaFormat outputFormat = this.b.getOutputFormat();
                    p79.c(AudioEncoderCore.TAG, "encoder output format changed: " + outputFormat);
                    this.d = this.a.a(outputFormat);
                    if (!this.a.c()) {
                        synchronized (this.a) {
                            while (!this.a.e()) {
                                try {
                                    this.a.wait(100L);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    this.e = true;
                } else if (dequeueOutputBuffer < 0) {
                    p79.l(AudioEncoderCore.TAG, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                    MediaCodec.BufferInfo bufferInfo = this.c;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.c;
                    if (bufferInfo2.size != 0) {
                        if (!this.e) {
                            throw new RuntimeException("muxer hasn't started");
                        }
                        long j = this.f;
                        if (j != 0 && j > bufferInfo2.presentationTimeUs) {
                            bufferInfo2.presentationTimeUs = j + 20000;
                        }
                        byteBuffer.position(this.c.offset);
                        MediaCodec.BufferInfo bufferInfo3 = this.c;
                        byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                        this.a.b(this.d, byteBuffer, this.c);
                        this.f = this.c.presentationTimeUs;
                    }
                    this.b.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.c.flags & 4) != 0) {
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
                if (this.b != null) {
                    this.b.stop();
                    this.b.release();
                    this.b = null;
                }
                if (this.a != null) {
                    this.a.d();
                    this.a = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
