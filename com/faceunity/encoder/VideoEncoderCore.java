package com.faceunity.encoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b99;
import com.baidu.tieba.f99;
import com.baidu.tieba.v89;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class VideoEncoderCore {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MIME_TYPE = "video/avc";
    public static final String TAG = "VideoEncoder";
    public static final boolean VERBOSE = false;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaCodec.BufferInfo mBufferInfo;
    public MediaCodec mEncoder;
    public Surface mInputSurface;
    public long mLastFrameSyncTime;
    public MediaMuxerWrapper mMuxer;
    public boolean mMuxerStarted;
    public b99 mPostMonitorManager;
    public boolean mRequestStop;
    public int mTrackIndex;
    public Bundle params;

    public VideoEncoderCore(int i, int i2, int i3, MediaMuxerWrapper mediaMuxerWrapper) throws IOException {
        f99 f99Var;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), mediaMuxerWrapper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.params = new Bundle();
        this.mLastFrameSyncTime = 0L;
        this.mRequestStop = false;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, f99.class);
        if (runTask != null) {
            f99Var = (f99) runTask.getData();
        } else {
            f99Var = null;
        }
        if (f99Var != null) {
            this.mPostMonitorManager = f99Var.get();
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", i3);
        createVideoFormat.setInteger("frame-rate", 20);
        createVideoFormat.setInteger("i-frame-interval", 1);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.mEncoder = createEncoderByType;
        createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.mInputSurface = this.mEncoder.createInputSurface();
        this.mEncoder.start();
        if (Build.VERSION.SDK_INT >= 19) {
            this.params.putInt("request-sync", 0);
            this.mEncoder.setParameters(this.params);
        }
        this.mTrackIndex = -1;
        this.mMuxerStarted = false;
        this.mMuxer = mediaMuxerWrapper;
    }

    public void drainEncoder(boolean z) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                this.mEncoder.signalEndOfInputStream();
            }
            ByteBuffer[] outputBuffers = this.mEncoder.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = this.mEncoder.dequeueOutputBuffer(this.mBufferInfo, 10000L);
                if (dequeueOutputBuffer == -1) {
                    if (!z) {
                        return;
                    }
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = this.mEncoder.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    if (!this.mMuxerStarted) {
                        MediaFormat outputFormat = this.mEncoder.getOutputFormat();
                        Log.d(TAG, "encoder output format changed: " + outputFormat);
                        this.mTrackIndex = this.mMuxer.addTrack(outputFormat);
                        if (!this.mMuxer.start()) {
                            synchronized (this.mMuxer) {
                                while (!this.mMuxer.isStarted() && !this.mRequestStop) {
                                    try {
                                        this.mMuxer.wait(100L);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        if (!this.mRequestStop) {
                            this.mMuxerStarted = true;
                        } else {
                            return;
                        }
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
                        if (Build.VERSION.SDK_INT >= 19 && System.currentTimeMillis() - this.mLastFrameSyncTime >= 500) {
                            this.mEncoder.setParameters(this.params);
                            this.mLastFrameSyncTime = System.currentTimeMillis();
                        }
                        if ((this.mBufferInfo.flags & 4) != 0) {
                            if (!z) {
                                Log.w(TAG, "reached end of stream unexpectedly");
                                return;
                            }
                            return;
                        }
                    } else {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                }
            }
        }
    }

    public Surface getInputSurface() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mInputSurface;
        }
        return (Surface) invokeV.objValue;
    }

    public synchronized void requestStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.mRequestStop = true;
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MediaCodec mediaCodec = this.mEncoder;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.mEncoder.release();
                this.mEncoder = null;
            }
            MediaMuxerWrapper mediaMuxerWrapper = this.mMuxer;
            if (mediaMuxerWrapper != null) {
                try {
                    mediaMuxerWrapper.stop();
                } catch (IllegalStateException e) {
                    b99 b99Var = this.mPostMonitorManager;
                    if (b99Var != null) {
                        b99Var.b(17, v89.a(e));
                    }
                }
                this.mMuxer = null;
            }
        }
    }
}
