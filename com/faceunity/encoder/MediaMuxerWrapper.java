package com.faceunity.encoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class MediaMuxerWrapper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MediaMuxerWrapper";
    public static final boolean VERBOSE = true;
    public transient /* synthetic */ FieldHolder $fh;
    public int mEncoderCount;
    public boolean mIsStarted;
    public final MediaMuxer mMediaMuxer;
    public int mStatredCount;

    public MediaMuxerWrapper(String str) throws IOException {
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
        this.mEncoderCount = 2;
        this.mStatredCount = 0;
        this.mIsStarted = false;
        this.mMediaMuxer = new MediaMuxer(str, 0);
    }

    public synchronized int addTrack(MediaFormat mediaFormat) {
        InterceptResult invokeL;
        int addTrack;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mediaFormat)) == null) {
            synchronized (this) {
                if (!this.mIsStarted) {
                    addTrack = this.mMediaMuxer.addTrack(mediaFormat);
                    String str = "addTrack:trackNum=" + this.mEncoderCount + ",trackIx=" + addTrack + ",format=" + mediaFormat;
                } else {
                    throw new IllegalStateException("muxer already started");
                }
            }
            return addTrack;
        }
        return invokeL.intValue;
    }

    public synchronized boolean isStarted() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                z = this.mIsStarted;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean start() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                int i2 = this.mStatredCount + 1;
                this.mStatredCount = i2;
                if (this.mEncoderCount > 0 && i2 == this.mEncoderCount) {
                    this.mMediaMuxer.start();
                    this.mIsStarted = true;
                    notifyAll();
                }
                z = this.mIsStarted;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                String str = "stop:mStatredCount=" + this.mStatredCount;
                int i2 = this.mStatredCount - 1;
                this.mStatredCount = i2;
                if (this.mEncoderCount > 0 && i2 <= 0) {
                    this.mMediaMuxer.stop();
                    this.mMediaMuxer.release();
                    this.mIsStarted = false;
                }
            }
        }
    }

    public synchronized void writeSampleData(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i2, byteBuffer, bufferInfo) == null) {
            synchronized (this) {
                if (this.mStatredCount > 0) {
                    this.mMediaMuxer.writeSampleData(i2, byteBuffer, bufferInfo);
                }
            }
        }
    }
}
