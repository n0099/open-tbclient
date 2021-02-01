package com.yy.mediaframework.filters;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.encoder.AbstractTextureMoiveEncoder;
import com.yy.mediaframework.encoder.HardEncodeListner;
import com.yy.mediaframework.encoder.TextureMoiveEncoderSync;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.model.YYMediaSampleAlloc;
import com.yy.mediaframework.stat.VideoDataStat;
import com.yy.mediaframework.stat.YMFLiveExceptionStat;
import com.yy.mediaframework.stat.YMFLiveExceptionType;
import com.yy.mediaframework.stat.YMFLiveStatisticManager;
import com.yy.mediaframework.stat.YMFLiveUsrBehaviorStat;
import com.yy.mediaframework.utils.StringUtils;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes4.dex */
public class H264HardwareEncoderFilter extends AbstractEncoderFilter implements HardEncodeListner {
    private static final int kMaxRetryCnt = 5;
    private AbstractTextureMoiveEncoder mEncoder;
    private byte[] mFilteData;
    private int mSpsSize = 0;
    private int mPpsSize = 0;
    private boolean mFirstFrameEncode = false;
    private AtomicInteger mState = new AtomicInteger(0);
    private AtomicLong mCurrentEID = new AtomicLong(-1);
    private boolean mHasBFrame = false;
    private long mIDRFrameDts = 0;
    private boolean mFirstPFrameDtsCompensate = false;
    private boolean mPtsLog = true;
    public YYMediaSample mSpsSample = new YYMediaSample();
    public YYMediaSample mPpsSample = new YYMediaSample();

    public H264HardwareEncoderFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mEncoder = null;
        this.mFilterContext = videoLiveFilterContext;
        this.mInputMode = this.mFilterContext.getEncoderInputMode();
        this.mEncoder = new TextureMoiveEncoderSync(this.mFilterContext, this.mFilterContext.getGlManager(), this);
        YMFLog.info(this, "[Encoder ]", "H264HardwareEncoderFilter construct");
    }

    public static boolean isAvaible() {
        return Build.VERSION.SDK_INT >= 18;
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public VideoEncoderType getEncoderFilterType() {
        return VideoEncoderType.HARD_ENCODER_H264;
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public boolean startEncode() {
        synchronized (this) {
            this.encodedCallBack = null;
        }
        this.mFirstEncoderDataOut.set(false);
        return startEncode_private(this.mFilterContext.getVideoEncoderConfig().getEncodeWidth(), this.mFilterContext.getVideoEncoderConfig().getEncodeHeight());
    }

    private boolean startEncode_private(int i, int i2) {
        YMFLog.info(this, "[Encoder ]", "encode width:%d, height:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (Constant.EncoderState.isStart(this.mState.get())) {
            YMFLog.info(this, "[Encoder ]", "startEncode already, so return");
            return true;
        }
        YMFLog.info(this, "[Encoder ]", "H264HardwareEncoderFilter startEncode begin");
        setEncodeCfg(this.mFilterContext.getVideoEncoderConfig());
        this.mEncoderConfig.setEncodeSize(this.mFilterContext.getVideoEncoderConfig().getEncodeWidth(), this.mFilterContext.getVideoEncoderConfig().getEncodeHeight());
        this.mEncoder.setEncoderInputMode(this.mInputMode);
        long startEncode = this.mEncoder.startEncode(this.mEncoderConfig);
        if (startEncode > 0) {
            this.mCurrentEID.set(startEncode);
            this.mState.set(1);
            VideoDataStat.getInstance().setVideoEncodingState(true);
            YMFLog.info(this, "[Encoder ]", "H264HardwareEncoderFilter startEncode succeed end");
            this.mEncodeParam = "config:" + this.mEncoderConfig.toString() + ", real:" + this.mEncoder.getMediaFormat();
            this.mFilterContext.getEncodeParamTipsMgr().setEncoderParam(this.mEncodeParam);
            return true;
        }
        this.mbEncodingState = false;
        YMFLiveExceptionStat.getInstance().notifyException(YMFLiveExceptionType.AnchorStatus_ENCODE_ERROR);
        YMFLog.info(this, "[Encoder ]", "H264HardwareEncoderFilter startEncode fail end");
        return false;
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public void stopEncode() {
        YMFLog.info(this, "[Encoder ]", "H264 stopEncode begin");
        if (Constant.EncoderState.isStoped(this.mState.getAndSet(3))) {
            YMFLog.info(this, "[Encoder ]", "H264 stopEncode: no initialized state, so return");
            return;
        }
        this.mFilterContext.getEncodeParamTipsMgr().setNoEncoder();
        this.mState.set(3);
        VideoDataStat.getInstance().setVideoEncodingState(false);
        this.mEncoder.releaseEncoder();
        if (getClass().getSimpleName().equals("H264HardwareEncoderFilter")) {
            YMFLiveUsrBehaviorStat.getInstance().notifyVideoEncoderState(VideoEncoderType.HARD_ENCODER_H264, false);
        } else if (getClass().getSimpleName().equals("H265HardwareEncoderFilter")) {
            YMFLiveUsrBehaviorStat.getInstance().notifyVideoEncoderState(VideoEncoderType.HARD_ENCODER_H265, false);
        }
        YMFLog.info(this, "[Encoder ]", "H264 stopEncode done");
        synchronized (this) {
            if (this.encodedCallBack != null) {
                this.encodedCallBack = null;
            }
        }
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public void requestSyncFrame() {
        if (this.mEncoder != null) {
            this.mEncoder.requestSyncFrame();
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        int i = this.mState.get();
        if (Constant.EncoderState.blockStream(i)) {
            YMFLog.error(this, "[Encoder ]", "encoder is not started or stoped!!");
            return false;
        } else if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_NORMAL && checkEncoderSwitch()) {
            handleEncoderSwitch();
            return true;
        } else {
            if (checkEncodeUpdate(yYMediaSample.mEncodeWidth, yYMediaSample.mEncodeHeight, this.mFilterContext.getVideoEncoderConfig().mLowDelay, this.mFilterContext.getVideoEncoderConfig().mFrameRate, this.mFilterContext.getVideoEncoderConfig().mBitRate, this.mFilterContext.getVideoEncoderConfig().mEncodeParameter, yYMediaSample.mEncoderInputMode)) {
                YMFLog.info(this, "[Encoder ]", "image size changed, so restart the hardware encoder!!");
                stopEncode();
                startEncode_private(yYMediaSample.mEncodeWidth, yYMediaSample.mEncodeHeight);
                YMFLog.info(this, "[Encoder ]", "image size changed, restart hardeware encoder success!!");
            }
            if (i == 4) {
                YMFLog.error(this, "[Encoder ]", "encoder is now in error state");
                return false;
            }
            yYMediaSample.addRef();
            long currentTimeMillis = System.currentTimeMillis();
            if (yYMediaSample.mEncoderInputMode == Constant.EncoderInputMode.SURFACE) {
                this.mEncoder.encodeFrame(yYMediaSample, this.mFilterContext.getWatermarkTextureID(), this.mFilterContext.getDynamicTextureID(), yYMediaSample.mSlaveTextureId, this.mSlaveVertexBuffer);
            } else {
                this.mEncoder.encodeFrame(yYMediaSample);
            }
            YMFLiveStatisticManager.getInstance().calcPureEncodeLatency(currentTimeMillis);
            yYMediaSample.decRef();
            return false;
        }
    }

    @Override // com.yy.mediaframework.encoder.HardEncodeListner
    public void onEncodedHeaderAvailable(ByteBuffer byteBuffer, int i, int i2, String str) {
        YMFLog.info(this, "[Encoder ]", "OnEncodedHeaderAvailable get in");
    }

    @Override // com.yy.mediaframework.encoder.HardEncodeListner
    @TargetApi(16)
    public void onEncodedHeaderAvailableSample(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, long j, long j2, MediaFormat mediaFormat) {
        int i;
        YMFLog.info(this, "[Encoder ]", "onEncodeHeadAvailable get in");
        if (byteBuffer == null || bufferInfo == null) {
            YMFLog.error(this, "[Encoder ]", "H264SurfaceEndoerFilter onEncodeHeadAvailable error, buffer or bufferInfo is null");
        } else if ((bufferInfo.flags & 2) != 0) {
            if (this.mSpsSize <= 0 || this.mPpsSize <= 0) {
                YMFLog.error(this, "[Encoder ]", "OnEncodedHeaderAvailableSample error, should set setMediaFormatChanged first!");
                return;
            }
            byteBuffer.position(bufferInfo.offset);
            if (byteBuffer.remaining() < this.mSpsSize + this.mPpsSize) {
                YMFLog.error(this, "[Encoder ]", "setVideoCodecConfigBuffer error, buffer length error!");
                return;
            }
            if (!this.mFirstEncoderDataOut.get()) {
                onFirstEncodedDataOut();
            }
            int i2 = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN ? 1 : 16777216;
            int i3 = byteBuffer.getInt();
            int i4 = this.mSpsSize;
            if (i3 == i2) {
                i4 -= 4;
            } else {
                byteBuffer.position(byteBuffer.position() - 4);
            }
            byte[] bArr = new byte[i4];
            byteBuffer.get(bArr);
            YYMediaSample alloc = YYMediaSampleAlloc.instance().alloc();
            alloc.mDataByteBuffer = ByteBuffer.wrap(bArr);
            alloc.mDataByteBuffer.order(ByteOrder.nativeOrder());
            alloc.mBufferSize = i4;
            alloc.mBufferOffset = 0;
            alloc.mEncoderType = VideoEncoderType.HARD_ENCODER_H264;
            alloc.mFrameType = 5;
            alloc.mYYPtsMillions = 0L;
            alloc.mDtsMillions = 0L;
            this.mSpsSample.assigne(alloc);
            deliverToDownStream(alloc);
            alloc.decRef();
            YMFLog.info(this, "[Encoder ]", "OnEncodedHeaderAvailableSample sps:" + StringUtils.bytesToHexString(bArr) + " sps size:" + this.mSpsSize);
            int i5 = this.mPpsSize;
            if (byteBuffer.getInt() == i2) {
                i = i5 - 4;
            } else {
                byteBuffer.position(byteBuffer.position() - 4);
                int i6 = 0;
                while (true) {
                    i6++;
                    if (i6 > 5) {
                        i6 = 0;
                        break;
                    } else if ((byteBuffer.get() & 31) == 8) {
                        break;
                    }
                }
                byteBuffer.position(byteBuffer.position() - i6);
                i = i5 - i6;
            }
            byte[] bArr2 = new byte[i];
            byteBuffer.get(bArr2);
            YYMediaSample alloc2 = YYMediaSampleAlloc.instance().alloc();
            alloc2.mDataByteBuffer = ByteBuffer.wrap(bArr2);
            alloc2.mDataByteBuffer.order(ByteOrder.nativeOrder());
            alloc2.mBufferSize = i;
            alloc2.mEncoderType = VideoEncoderType.HARD_ENCODER_H264;
            alloc2.mFrameType = 6;
            alloc2.mYYPtsMillions = 0L;
            alloc2.mDtsMillions = 0L;
            this.mPpsSample.assigne(alloc2);
            deliverToDownStream(alloc2);
            alloc2.decRef();
            this.mIDRFrameDts = j;
            this.mFirstPFrameDtsCompensate = false;
            YMFLog.info(this, "[Encoder ]", "OnEncodedHeaderAvailableSample pps:" + StringUtils.bytesToHexString(bArr2) + " pps size:" + this.mPpsSize);
            if (byteBuffer.remaining() > 0) {
                YMFLog.info(this, "[Encoder ]", "H264SurfaceEndoerFilter OnEncodeDataAvailableSample");
                YYMediaSample alloc3 = YYMediaSampleAlloc.instance().alloc();
                alloc3.mDtsMillions = j;
                alloc3.mYYPtsMillions = j2;
                alloc3.mMediaFormat = mediaFormat;
                alloc3.mFrameFlag = bufferInfo.flags;
                alloc3.mWidth = mediaFormat.getInteger("width");
                alloc3.mHeight = mediaFormat.getInteger("height");
                alloc3.mDataByteBuffer = byteBuffer;
                alloc3.mBufferOffset = byteBuffer.position();
                alloc3.mBufferSize = byteBuffer.remaining();
                alloc3.mEncoderType = VideoEncoderType.HARD_ENCODER_H264;
                if ((bufferInfo.flags & 1) != 0) {
                    alloc3.mFrameType = 4;
                } else {
                    alloc3.mDataByteBuffer.position(alloc3.mBufferOffset);
                    int i7 = alloc3.mDataByteBuffer.getInt(4);
                    alloc3.mDataByteBuffer.position(alloc3.mBufferOffset);
                    alloc3.mFrameType = fetchFrameType(i7);
                }
                if (!this.mFirstFrameEncode) {
                    YMFLiveUsrBehaviorStat.getInstance().notifyFirstFrameEncode(alloc3.mYYPtsMillions);
                    this.mFirstFrameEncode = true;
                }
                deliverToDownStream(alloc3);
                handleEncodedFrameStats(alloc3.mBufferSize, getInputFrameByteSize(), alloc3.mFrameType);
                alloc3.decRef();
                return;
            }
            this.mEncoder.recoverCachedPtsList(j);
        }
    }

    @TargetApi(16)
    private void filteSpsPpsFormIDRFrame(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, YYMediaSample yYMediaSample) {
        if (this.mFilteData == null || this.mFilteData.length > byteBuffer.limit()) {
            this.mFilteData = new byte[byteBuffer.limit() <= 40 ? byteBuffer.limit() : 40];
        }
        byteBuffer.position(bufferInfo.offset);
        byteBuffer.get(this.mFilteData, 0, this.mFilteData.length);
        int i = 2;
        while (true) {
            if (i >= this.mFilteData.length - 5) {
                i = 0;
                break;
            } else if (this.mFilteData[i] == 0 && this.mFilteData[i + 1] == 0 && this.mFilteData[i + 2] == 0 && this.mFilteData[i + 3] == 1 && (this.mFilteData[i + 4] & 31) == 5) {
                break;
            } else {
                i++;
            }
        }
        yYMediaSample.mBufferOffset = bufferInfo.offset + i;
        yYMediaSample.mBufferSize = bufferInfo.size - i;
    }

    @Override // com.yy.mediaframework.encoder.HardEncodeListner
    @TargetApi(16)
    public void onEncodedDataAvailableSample(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, long j, long j2, MediaFormat mediaFormat) {
        YMFLog.debug(this, "[Encoder ]", "OnEncodeDataAvailableSample get in");
        YYMediaSample alloc = YYMediaSampleAlloc.instance().alloc();
        alloc.mYYPtsMillions = j2;
        alloc.mMediaFormat = mediaFormat;
        alloc.mFrameFlag = bufferInfo.flags;
        alloc.mWidth = mediaFormat.getInteger("width");
        alloc.mHeight = mediaFormat.getInteger("height");
        alloc.mDataByteBuffer = byteBuffer;
        alloc.mBufferOffset = bufferInfo.offset;
        alloc.mBufferSize = bufferInfo.size;
        alloc.mEncoderType = VideoEncoderType.HARD_ENCODER_H264;
        if (!this.mFirstFrameEncode) {
            YMFLiveUsrBehaviorStat.getInstance().notifyFirstFrameEncode(alloc.mYYPtsMillions);
            this.mFirstFrameEncode = true;
        }
        if ((bufferInfo.flags & 1) != 0) {
            alloc.mFrameType = 4;
            if ((byteBuffer.get(4) & 31) != 5) {
                filteSpsPpsFormIDRFrame(byteBuffer, bufferInfo, alloc);
            }
            byteBuffer.rewind();
        } else {
            alloc.mDataByteBuffer.position(alloc.mBufferOffset);
            byte b2 = alloc.mDataByteBuffer.get(4);
            alloc.mDataByteBuffer.position(alloc.mBufferOffset);
            alloc.mFrameType = fetchFrameType(b2);
        }
        if (alloc.mFrameType == 2 && !this.mHasBFrame) {
            YMFLog.info(this, "[Encoder ]", "onEncodedDataAvailableSample hasBframe:" + this.mHasBFrame);
            this.mHasBFrame = true;
        }
        if (j2 != j && !this.mFirstPFrameDtsCompensate) {
            alloc.mDtsMillions = this.mIDRFrameDts + ((j - this.mIDRFrameDts) / 2);
            this.mEncoder.recoverCachedPtsList(j);
            this.mFirstPFrameDtsCompensate = true;
            YMFLog.info(this, "[Encoder ]", "firstPframe H264 dts:" + alloc.mDtsMillions);
        } else {
            alloc.mDtsMillions = j;
        }
        if (alloc.mFrameType == 4 && this.mSpsSample != null && this.mPpsSample != null) {
            deliverToDownStream(this.mSpsSample);
            deliverToDownStream(this.mPpsSample);
        }
        if (this.mPtsLog && alloc.mDtsMillions > alloc.mYYPtsMillions) {
            YMFLog.error(this, "[Encoder ]", "onEncodedDataAvailableSample  H264 pts:" + alloc.mYYPtsMillions + " dts:" + alloc.mDtsMillions + " gap:" + (alloc.mYYPtsMillions - alloc.mDtsMillions) + " frameType:" + alloc.mFrameType);
            this.mPtsLog = false;
        }
        deliverToDownStream(alloc);
        handleEncodedFrameStats(alloc.mBufferSize, getInputFrameByteSize(), alloc.mFrameType);
        alloc.decRef();
    }

    private int fetchFrameType(int i) {
        switch (i & 31) {
            case 1:
                return i == 1 ? 2 : 1;
            case 2:
            case 3:
            case 4:
                return 1;
            case 5:
                return 4;
            case 6:
            case 7:
            case 8:
            default:
                return 4;
            case 9:
                return 255;
        }
    }

    @Override // com.yy.mediaframework.encoder.HardEncodeListner
    public void onEncodedDataAvailable(ByteBuffer byteBuffer, int i, int i2, long j, long j2) {
    }

    @Override // com.yy.mediaframework.encoder.HardEncodeListner
    @TargetApi(16)
    public void onEncoderFomratChanged(MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            YMFLog.error(this, "[Encoder ]", "setMediaFormatChanged error, format null!");
            return;
        }
        YMFLog.info(this, "[Encoder ]", "setMediaFormatChanged spsSize:" + this.mSpsSize + ", ppsSize:" + this.mPpsSize);
        handleEncodeResolution(mediaFormat.getInteger("width"), mediaFormat.getInteger("height"));
        ByteBuffer byteBuffer = mediaFormat.getByteBuffer("csd-0");
        ByteBuffer byteBuffer2 = mediaFormat.getByteBuffer("csd-1");
        if (byteBuffer == null || byteBuffer2 == null) {
            YMFLog.error(this, "[Encoder ]", "setMediaFormatChanged error, csd-0:" + byteBuffer + ", csd-1:" + byteBuffer2);
            return;
        }
        this.mSpsSize = byteBuffer.limit() - byteBuffer.position();
        this.mPpsSize = byteBuffer2.limit() - byteBuffer2.position();
    }

    public int getInputFrameByteSize() {
        return this.mEncoderConfig.getEncodeHeight() * this.mEncoderConfig.getEncodeWidth() * 4;
    }

    @Override // com.yy.mediaframework.encoder.HardEncodeListner
    public void onPreviewTextureAvailable(SurfaceTexture surfaceTexture) {
    }

    public void _OnError(long j, String str, String str2) {
        YMFLog.error(this, "[Encoder ]", "_onError get in");
        onEncodeError(str);
        this.mState.set(4);
    }

    @Override // com.yy.mediaframework.encoder.HardEncodeListner
    public void onError(final long j, final String str, final String str2) {
        StringBuilder append = new StringBuilder().append("hardware encoder error:").append(str2 == null ? "null" : str2).append(", retryCnt:");
        int i = this.mRetryCnt;
        this.mRetryCnt = i + 1;
        YMFLog.error(this, "[Encoder ]", append.append(i).toString());
        if (!"2".equals(str) && (j == -1 || j != this.mCurrentEID.get())) {
            YMFLog.info(this, "[Encoder ]", "encoder error, but it is out of date!!");
            return;
        }
        this.mbEncodingState = false;
        YMFLiveExceptionStat.getInstance().notifyException(YMFLiveExceptionType.AnchorStatus_ENCODE_ERROR);
        if (this.mFilterContext.getGlManager().checkSameThread()) {
            _OnError(j, str, str2);
        } else {
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.H264HardwareEncoderFilter.1
                @Override // java.lang.Runnable
                public void run() {
                    H264HardwareEncoderFilter.this._OnError(j, str, str2);
                }
            });
        }
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public void adjustBitRate(final int i) {
        YMFLog.info(this, "[Encoder ]", "adjust bitrate:" + i);
        if (this.mFilterContext.getGlManager().checkSameThread()) {
            if (Constant.EncoderState.isStart(this.mState.get())) {
                this.mEncoder.adjustBitRate(i);
                return;
            }
            return;
        }
        this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.H264HardwareEncoderFilter.2
            @Override // java.lang.Runnable
            public void run() {
                if (Constant.EncoderState.isStart(H264HardwareEncoderFilter.this.mState.get())) {
                    H264HardwareEncoderFilter.this.mEncoder.adjustBitRate(i);
                }
            }
        });
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public boolean stopEncoderAsync() {
        YMFLog.info(this, "[Encoder ]", "H264 stopEncoderAsyenc begin");
        if (Constant.EncoderState.isStoped(this.mState.getAndSet(3))) {
            YMFLog.info(this, "[Encoder ]", "H264 stopEncoderAsyenc: no initialized state, so return");
            return false;
        }
        this.mState.set(3);
        VideoDataStat.getInstance().setVideoEncodingState(false);
        this.mEncoder.releaseEncoderAsync();
        YMFLog.info(this, "[Encoder ]", "H264 stopEncoderAsyenc done");
        return true;
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public void createGlElementEnvOnly() {
        if (this.mEncoder != null) {
            this.mEncoder.createGlElementEnv();
        }
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public void destoryGlElementEnvOnly() {
        if (this.mEncoder != null) {
            this.mEncoder.destoryGlElementEnvOnly();
        }
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public boolean startEncoderOnly(VideoEncoderConfig videoEncoderConfig) {
        YMFLog.info(this, "[Encoder ]", "startEncoderOnly, config:" + videoEncoderConfig.toString());
        if (Constant.EncoderState.isStart(this.mState.get())) {
            YMFLog.info(this, "[Encoder ]", "startEncoderOnly already, so return");
            return true;
        }
        setEncodeCfg(videoEncoderConfig);
        this.mEncoder.setEncoderInputMode(this.mInputMode);
        YMFLog.info(this, "[Encoder ]", "H264HardwareEncoderFilter startEncoderOnly begin mInputMode:" + this.mInputMode);
        long startEncoerAsync = this.mEncoder.startEncoerAsync(this.mEncoderConfig);
        if (startEncoerAsync > 0) {
            this.mCurrentEID.set(startEncoerAsync);
            this.mState.set(1);
            VideoDataStat.getInstance().setVideoEncodingState(true);
            YMFLog.info(this, "[Encoder ]", "H264HardwareEncoderFilter startEncoderOnly succeed end");
            this.mEncodeParam = "config:" + this.mEncoderConfig.toString() + ", real:" + this.mEncoder.getMediaFormat();
            this.mFilterContext.getEncodeParamTipsMgr().setEncoderParam(this.mEncodeParam);
            return true;
        }
        YMFLog.info(this, "[Encoder ]", "H264HardwareEncoderFilter startEncoderOnly fail end");
        return false;
    }

    @Override // com.yy.mediaframework.encoder.HardEncodeListner
    public void onNoEncodedDataOut() {
        synchronized (this) {
            if (this.encodedCallBack != null && !this.mFirstEncoderDataOut.get()) {
                this.encodedCallBack.onNoEncodedDataOut();
                YMFLog.info(this, "[Encoder ]", "encodedCallBack onNoEncodedDataOut!");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFirstEncodedDataOut() {
        synchronized (this) {
            if (this.encodedCallBack != null && !this.mFirstEncoderDataOut.get()) {
                this.encodedCallBack.onFirstEncodedDataOut();
                this.mFirstEncoderDataOut.set(true);
                YMFLog.info(this, "[Encoder ]", "onNoEncodedDataOut onFirstEncodedDataOut!");
            }
        }
    }

    protected void onEncodeError(String str) {
        if (this.mEncodeStateCallBack != null) {
            this.mEncodeStateCallBack.onEncodeError(str);
            YMFLog.info(this, "[Encoder ]", "onEncodeError exceptionId:" + str);
        }
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public boolean getCacheEncodedData() {
        if (this.mEncoder != null) {
            return ((TextureMoiveEncoderSync) this.mEncoder).getCacheEncodedData();
        }
        YMFLog.error(this, "[Encoder ]", " getCacheEncodedData mEncoder == null");
        return false;
    }
}
