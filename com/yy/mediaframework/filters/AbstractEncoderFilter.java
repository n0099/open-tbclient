package com.yy.mediaframework.filters;

import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.mobstat.Config;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.IEncoderListener;
import com.yy.mediaframework.YMFStreamSyncSourceManager;
import com.yy.mediaframework.api.YMFEncoderStatisticInfo;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.stat.VideoDataStat;
import com.yy.mediaframework.stat.YMFLiveExceptionStat;
import com.yy.mediaframework.stat.YMFLiveExceptionType;
import com.yy.mediaframework.utils.YMFLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class AbstractEncoderFilter extends IEncodeFilter {
    private int capFrameRate;
    protected IEncodedDataOutCallBack encodedCallBack;
    protected IEncodeStateCallBack mEncodeStateCallBack;
    protected Constant.EncoderInputMode mInputMode;
    private long mlastCountTime = System.currentTimeMillis();
    private int mInputByteSize = 0;
    private int mOutputByteSize = 0;
    private int mFrameCnt = 0;
    private int mBitRate = 0;
    private int mFrameRate = 0;
    protected int mStreamId = 0;
    private long lastCapCountTime = 0;
    private long encodeTime = 0;
    private IEncoderListener mEncoderListener = null;
    VideoEncoderConfig mEncoderConfig = null;
    protected int mRetryCnt = 0;
    protected VideoLiveFilterContext mFilterContext = null;
    private boolean mbFirstFrame = true;
    public boolean mbEncodingState = false;
    private boolean mHasBFrame = false;
    private boolean mEncoderSwitchEnable = true;
    public String mEncodeParam = null;
    public long currentPrintTime = 0;
    public long lastPrintTime = 0;
    public long mEncodeFrameCount = 0;
    private int statisticCnt = 0;
    private List<Integer> mFrameRateLister = new ArrayList();
    private List<Integer> mBitrateRateLister = new ArrayList();
    private YMFEncoderStatisticInfo mVideoPublishInfo = new YMFEncoderStatisticInfo(0);
    protected AtomicBoolean mFirstEncoderDataOut = new AtomicBoolean(false);

    /* loaded from: classes6.dex */
    public interface IEncodeStateCallBack {
        void onEncodeError(String str);
    }

    /* loaded from: classes6.dex */
    public interface IEncodedDataOutCallBack {
        void onFirstEncodedDataOut();

        void onNoEncodedDataOut();
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public void setEncoderListener(IEncoderListener iEncoderListener) {
        this.mEncoderListener = iEncoderListener;
    }

    public void setStreamId(int i) {
        this.mVideoPublishInfo = new YMFEncoderStatisticInfo(i);
        this.mStreamId = i;
    }

    public IEncoderListener getEncoderListener() {
        return this.mEncoderListener;
    }

    public void handleEncodedFrameStats(long j, int i, int i2) {
        if (this.mbFirstFrame && this.mEncoderListener != null) {
            YMFLog.info(this, "[Encoder ]", "handleEncodedFrameStats onEncodeFirstFrame:" + i2);
            this.mEncoderListener.onEncodeFirstFrame();
        }
        if (!this.mbEncodingState) {
            YMFLiveExceptionStat.getInstance().notifyException(YMFLiveExceptionType.AnchorStatus_BACK_TO_NORMAL);
            this.mbEncodingState = true;
        }
        this.mbFirstFrame = false;
        if (i2 != 5 && i2 != 6) {
            if (i2 == 2 && !this.mHasBFrame) {
                YMFLog.info(this, "[Encoder ]", "handleEncodedFrameStats B frame enable");
                this.mHasBFrame = true;
                if (this.mEncoderListener != null) {
                    this.mEncoderListener.onEncodeEncParam(this.mEncodeParam + ":haveBFrame:true");
                }
            }
            this.mFrameCnt++;
            this.mOutputByteSize = (int) (this.mOutputByteSize + j);
            this.mInputByteSize += i;
            if (this.mlastCountTime == 0) {
                this.mlastCountTime = System.currentTimeMillis();
            }
            float currentTimeMillis = ((float) (System.currentTimeMillis() - this.mlastCountTime)) / 1000.0f;
            if (currentTimeMillis >= 1.0f) {
                this.mBitRate = (int) ((this.mOutputByteSize * 8) / currentTimeMillis);
                this.mFrameRate = (int) (this.mFrameCnt / currentTimeMillis);
                VideoDataStat.getInstance().setEncodeFrameRate(this.mFrameRate);
                if (this.mEncoderListener != null) {
                    this.mVideoPublishInfo.mBitRate = this.mBitRate;
                    this.mVideoPublishInfo.mFrameRate = this.mFrameRate;
                    this.mVideoPublishInfo.mStreamId = this.mStreamId;
                    this.mVideoPublishInfo.mWidth = this.mEncoderConfig.getEncodeWidth();
                    this.mVideoPublishInfo.mHeight = this.mEncoderConfig.getEncodeHeight();
                    this.mVideoPublishInfo.mEncoderType = this.mEncoderConfig.mEncodeType;
                    this.mEncoderListener.onEncodeStat(this.mVideoPublishInfo);
                }
                this.mFrameRateLister.add(Integer.valueOf(this.mFrameRate));
                this.mBitrateRateLister.add(Integer.valueOf(this.mBitRate));
                this.mlastCountTime = System.currentTimeMillis();
                this.mOutputByteSize = 0;
                this.mInputByteSize = 0;
                this.mFrameCnt = 0;
                int i3 = this.statisticCnt;
                this.statisticCnt = i3 + 1;
                if (i3 >= 3) {
                    int i4 = 0;
                    int i5 = 0;
                    for (int i6 = 0; i6 < this.mFrameRateLister.size(); i6++) {
                        i5 += this.mBitrateRateLister.get(i6).intValue();
                        i4 += this.mFrameRateLister.get(i6).intValue();
                    }
                    int size = i5 / this.mFrameRateLister.size();
                    int size2 = i4 / this.mFrameRateLister.size();
                    VideoDataStat.getInstance().setEncodeFrameRate(size2);
                    YMFLog.info(this, "[Encoder ]", "encoded bitRate:" + size + ", mFrameCnt:" + size2);
                    this.statisticCnt = 0;
                    this.mBitrateRateLister.clear();
                    this.mFrameRateLister.clear();
                }
            }
            this.mRetryCnt = 0;
        }
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public void reSetEncodingState() {
        this.mbEncodingState = false;
    }

    public void handleEncodeResolution(int i, int i2) {
        if (this.mEncoderListener != null) {
            YMFLog.info(this, "[Encoder ]", this.mVideoPublishInfo.mStreamId + " handleEncodeResolution:" + i + Config.EVENT_HEAT_X + i2);
            this.mEncoderListener.onEncodeResolution(this.mVideoPublishInfo.mStreamId, i, i2);
        }
    }

    public void handleCaptureFrameStats() {
        if (System.currentTimeMillis() - this.lastCapCountTime >= IMConnection.RETRY_DELAY_TIMES) {
            this.capFrameRate /= 3;
            YMFLog.info(this, "[Encoder ]", "encoded capture mFrameCnt:" + this.capFrameRate);
            this.lastCapCountTime = System.currentTimeMillis();
            this.capFrameRate = 0;
        }
        this.capFrameRate++;
    }

    public void setEncodeCfg(VideoEncoderConfig videoEncoderConfig) {
        YMFLog.info(this, "[Encoder ]", "setEncodeCfg:" + videoEncoderConfig.toString());
        if (this.mEncoderConfig == null) {
            this.mEncoderConfig = new VideoEncoderConfig(videoEncoderConfig);
        } else {
            this.mEncoderConfig.assign(videoEncoderConfig);
        }
    }

    public void notifyEncoderParam(String str) {
        if (this.mEncoderListener != null) {
            this.mEncoderListener.onEncodeEncParam(str);
        }
    }

    public void handleEncoderSwitch() {
        if (this.mEncoderListener != null && this.mEncoderSwitchEnable) {
            YMFLog.info(this, "[Encoder ]", "encoder switch in AbstractEncoderFilter");
            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.AbstractEncoderFilter.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractEncoderFilter.this.mEncoderListener.onEncoderSwitch();
                    AbstractEncoderFilter.this.mEncoderSwitchEnable = false;
                }
            });
        }
    }

    public boolean checkEncodeUpdate(int i, int i2, boolean z, int i3, int i4, String str, Constant.EncoderInputMode encoderInputMode) {
        boolean z2;
        boolean z3 = false;
        if (this.mEncoderConfig.getEncodeHeight() == i2 && this.mEncoderConfig.getEncodeWidth() == i) {
            z2 = false;
        } else {
            YMFLog.info(this, "[Encoder ]", "checkEncodeUpdate:" + this.mEncoderConfig.getEncodeWidth() + Config.EVENT_HEAT_X + this.mEncoderConfig.getEncodeHeight() + " -> " + i + Config.EVENT_HEAT_X + i2);
            this.mEncoderConfig.setEncodeSize(i, i2);
            z2 = true;
        }
        if (this.mEncoderConfig.mLowDelay != z) {
            YMFLog.info(this, "[Encoder ]", "checkEncodeUpdate lowDelay:" + this.mEncoderConfig.mLowDelay + " -> " + z);
            this.mEncoderConfig.mLowDelay = z;
            YMFStreamSyncSourceManager.getInstance().changeEncoderConfig();
            z2 = true;
        }
        if (this.mEncoderConfig.mBitRate != i4) {
            YMFLog.info(this, "[Encoder ]", "checkEncodeUpdate biteRate:" + this.mEncoderConfig.mBitRate + " -> " + i4);
            adjustBitRate((i4 + 999) / 1000);
            this.mEncoderConfig.mBitRate = i4;
        } else {
            z3 = z2;
        }
        if ((!this.mEncoderConfig.mLowDelay || this.mEncoderConfig.mEncodeType != VideoEncoderType.SOFT_ENCODER_X264) && this.mEncoderConfig != null && this.mEncoderConfig.mEncodeParameter != null && !this.mEncoderConfig.mEncodeParameter.equals(str)) {
            YMFLog.info(this, "[Encoder ]", "checkEncodeUpdate param:" + this.mEncoderConfig.mEncodeParameter + " -> " + str);
            this.mEncoderConfig.mEncodeParameter = str;
            z3 = true;
        }
        if (this.mInputMode != encoderInputMode) {
            YMFLog.info(this, "[Encoder ]", "Encoder input mode change:" + this.mInputMode + " -> " + encoderInputMode + ", restart encoder.");
            this.mInputMode = encoderInputMode;
            return true;
        }
        return z3;
    }

    public boolean checkEncoderSwitch() {
        if (this.mFilterContext.mVideoEncoderConfig.mEncodeType.equals(getEncoderFilterType())) {
            return false;
        }
        YMFLog.info(this, "[Encoder ]", "encoder switch, new encoder:%s", this.mFilterContext.mVideoEncoderConfig.mEncodeType);
        return true;
    }

    public void setEncodedCallback(IEncodedDataOutCallBack iEncodedDataOutCallBack) {
        this.encodedCallBack = iEncodedDataOutCallBack;
        YMFLog.info(this, "[Encoder ]", "setEncodedCallback");
    }

    public void setEncodeStateCallback(IEncodeStateCallBack iEncodeStateCallBack) {
        this.mEncodeStateCallBack = iEncodeStateCallBack;
        YMFLog.info(this, "[Encoder ]", "setEncodeStateCallback");
    }
}
