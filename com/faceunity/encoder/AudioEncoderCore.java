package com.faceunity.encoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.record.EncoderParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class AudioEncoderCore {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MIME_TYPE = "audio/mp4a-latm";
    public static final String TAG = "AudioEncoder";
    public static final boolean VERBOSE = false;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaCodec.BufferInfo mBufferInfo;
    public MediaCodec mEncoder;
    public MediaMuxerWrapper mMuxer;
    public boolean mMuxerStarted;
    public int mTrackIndex;

    public AudioEncoderCore(MediaMuxerWrapper mediaMuxerWrapper) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaMuxerWrapper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 48000, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger("bitrate", EncoderParams.AUDIO_BIT_RATE);
        try {
            this.mEncoder = MediaCodec.createEncoderByType("audio/mp4a-latm");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.mEncoder.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        this.mEncoder.start();
        this.mTrackIndex = -1;
        this.mMuxerStarted = false;
        this.mMuxer = mediaMuxerWrapper;
    }

    public void drainEncoder() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        ByteBuffer[] outputBuffers = this.mEncoder.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.mEncoder.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -1) {
                return;
            }
            if (dequeueOutputBuffer == -3) {
                outputBuffers = this.mEncoder.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (!this.mMuxerStarted) {
                    MediaFormat outputFormat = this.mEncoder.getOutputFormat();
                    Log.d(TAG, "encoder output format changed: " + outputFormat);
                    this.mTrackIndex = this.mMuxer.addTrack(outputFormat);
                    if (!this.mMuxer.start()) {
                        synchronized (this.mMuxer) {
                            while (!this.mMuxer.isStarted()) {
                                try {
                                    this.mMuxer.wait(100L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    this.mMuxerStarted = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer < 0) {
                Log.w(TAG, "unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer != null) {
                    MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    MediaCodec.BufferInfo bufferInfo2 = this.mBufferInfo;
                    if (bufferInfo2.size != 0) {
                        if (this.mMuxerStarted) {
                            byteBuffer.position(bufferInfo2.offset);
                            MediaCodec.BufferInfo bufferInfo3 = this.mBufferInfo;
                            byteBuffer.limit(bufferInfo3.offset + bufferInfo3.size);
                            this.mMuxer.writeSampleData(this.mTrackIndex, byteBuffer, this.mBufferInfo);
                        } else {
                            throw new RuntimeException("muxer hasn't started");
                        }
                    }
                    this.mEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.mBufferInfo.flags & 4) != 0) {
                        return;
                    }
                } else {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
            }
        }
    }

    public void encode(ByteBuffer byteBuffer, int i, long j) throws Exception {
        int dequeueInputBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            ByteBuffer[] inputBuffers = this.mEncoder.getInputBuffers();
            do {
                dequeueInputBuffer = this.mEncoder.dequeueInputBuffer(10000L);
            } while (dequeueInputBuffer < 0);
            ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
            byteBuffer2.clear();
            if (byteBuffer != null) {
                byteBuffer2.put(byteBuffer);
            }
            if (i <= 0) {
                this.mEncoder.queueInputBuffer(dequeueInputBuffer, 0, 0, j, 4);
            } else {
                this.mEncoder.queueInputBuffer(dequeueInputBuffer, 0, i, j, 0);
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                if (this.mEncoder != null) {
                    this.mEncoder.stop();
                    this.mEncoder.release();
                    this.mEncoder = null;
                }
                if (this.mMuxer != null) {
                    this.mMuxer.stop();
                    this.mMuxer = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
