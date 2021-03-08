package com.yy.mediaframework.encoder;

import com.yy.mediaframework.YYVideoCodec;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.model.JVideoEncodedData;
import com.yy.mediaframework.stat.VideoDataStat;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.ByteBuffer;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class X264SoftEncoder {
    private static HashSet<X264SoftEncoder> mEncoders = new HashSet<>();
    private long mNativeEncoderHandle = 0;
    private VideoStreamFormat mVideoFormat = new VideoStreamFormat();
    private String mSoftConfig = null;

    private native void nativeAdjuestBitRate(int i);

    private static native void nativeClassInit();

    private native void nativeCreateEncoder();

    private native void nativeDeinitEncoder();

    private native void nativeDestroyEncoder();

    private native JVideoEncodedData[] nativeGetCacheData();

    private native void nativeInitEncoder(VideoStreamFormat videoStreamFormat, byte[] bArr);

    private native JVideoEncodedData[] nativeProcess(byte[] bArr, int i, long j, int i2);

    static {
        nativeClassInit();
    }

    public static X264SoftEncoder createEncoder() {
        X264SoftEncoder x264SoftEncoder = new X264SoftEncoder();
        synchronized (mEncoders) {
            mEncoders.add(x264SoftEncoder);
        }
        return x264SoftEncoder;
    }

    public static void destroyEncoder(X264SoftEncoder x264SoftEncoder) {
        if (x264SoftEncoder != null) {
            x264SoftEncoder.destroy();
            synchronized (mEncoders) {
                mEncoders.remove(x264SoftEncoder);
            }
        }
    }

    public X264SoftEncoder() {
        this.mVideoFormat.iUsedBitContorlParams = 0L;
        nativeCreateEncoder();
    }

    public void setSteadyBitrateControl(boolean z) {
        this.mVideoFormat.iUsedBitContorlParams = z ? 1L : 0L;
        YMFLog.info(this, "[Encoder ]", "setSteadyBitrateControl " + this.mVideoFormat.iUsedBitContorlParams);
    }

    public void initEncoder(VideoEncoderConfig videoEncoderConfig) {
        this.mVideoFormat.iBitRate = videoEncoderConfig.mBitRate / 1000;
        this.mVideoFormat.iFrameRate = videoEncoderConfig.mFrameRate;
        this.mVideoFormat.iHeight = videoEncoderConfig.getEncodeHeight();
        this.mVideoFormat.iWidth = videoEncoderConfig.getEncodeWidth();
        this.mVideoFormat.iPicFormat = 3;
        this.mVideoFormat.iProfile = 0;
        this.mVideoFormat.iEncodePreset = 0L;
        nativeInitEncoder(this.mVideoFormat, videoEncoderConfig.mEncodeParameter.getBytes());
        this.mSoftConfig = videoEncoderConfig.mEncodeParameter;
        YYVideoCodec.setCurrentEncodeName("x264");
        VideoDataStat.getInstance().setDynamicEncodeFrameRate(videoEncoderConfig.mFrameRate);
        YMFLog.info(this, "[Encoder ]", "software encoder, configure:" + (videoEncoderConfig.mEncodeParameter == null ? "null" : videoEncoderConfig.toString()));
    }

    public JVideoEncodedData[] encode(ByteBuffer byteBuffer, long j, int i) {
        return nativeProcess(byteBuffer.array(), byteBuffer.remaining(), j, i);
    }

    public void adjustBitRate(int i) {
        if (this.mNativeEncoderHandle != 0) {
            nativeAdjuestBitRate(i);
            this.mVideoFormat.iBitRate = i;
        }
    }

    private void deInitEncoder() {
        if (this.mNativeEncoderHandle != 0) {
            nativeDeinitEncoder();
        }
    }

    public void setEnocderImageSize(int i, int i2) {
        this.mVideoFormat.iWidth = i;
        this.mVideoFormat.iHeight = i2;
    }

    public void restartEncoder() {
        deInitEncoder();
        nativeInitEncoder(this.mVideoFormat, this.mSoftConfig.getBytes());
    }

    public JVideoEncodedData[] getCacheEncodedData() {
        return nativeGetCacheData();
    }

    private void destroy() {
        nativeDeinitEncoder();
        nativeDestroyEncoder();
    }
}
