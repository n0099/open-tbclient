package com.yy.mediaframework.filters;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.mobstat.Config;
import com.yy.mediaframework.ExternalInterface;
import com.yy.mediaframework.IEncoderListener;
import com.yy.mediaframework.ILiveSession;
import com.yy.mediaframework.YMFStreamSyncSourceManager;
import com.yy.mediaframework.YYVideoCodec;
import com.yy.mediaframework.YYVideoSDK;
import com.yy.mediaframework.api.YMFEncoderStatisticInfo;
import com.yy.mediaframework.api.YMFVideoEncodeFrame;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.encoder.H264SurfaceEncoder;
import com.yy.mediaframework.filters.AbstractEncoderFilter;
import com.yy.mediaframework.filters.AbstractVideoLiveQualityFilter;
import com.yy.mediaframework.inteligence.common.ResolutionModifyConfig;
import com.yy.mediaframework.model.ExternalYYMediaSample;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.stat.IEncodeParamListener;
import com.yy.mediaframework.stat.UploadStatManager;
import com.yy.mediaframework.stat.YMFLiveStatisticManager;
import com.yy.mediaframework.stat.YMFLiveUsrBehaviorStat;
import com.yy.mediaframework.utils.CommonUtil;
import com.yy.mediaframework.utils.TimeUtil;
import com.yy.mediaframework.utils.YMFLog;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes6.dex */
public class VideoEncoderGroupFilter extends AbstractYYMediaFilter implements IEncoderListener, AbstractEncoderFilter.IEncodeStateCallBack, AbstractEncoderFilter.IEncodedDataOutCallBack, AbstractVideoLiveQualityFilter.IWeakerNetworkCallback, IEncodeParamListener {
    private static final int DEFAULT_START_ENCODER_TRY_COUNT = 3;
    private static final String TAG = "VideoEncoderGroupFilter";
    private VideoLiveFilterContext mFilterContext;
    private ExternalInterface.IExternalCameraData mIExternalCameraData;
    private ExternalInterface.IExternalDecode mIExternalDecode;
    YMFLowStreamEncoderFilter mMultiStreamEncoderFilter;
    private ILiveSession mVideoLiveSession;
    private IEncodeFilter mEncoderFilter = null;
    private AtomicBoolean mInited = new AtomicBoolean(false);
    private AtomicBoolean mEnable = new AtomicBoolean(false);
    private AbstractVideoLiveQualityFilter mVideoQualityFilter = null;
    private TransmitUploadFilter mUploaderFilter = null;
    protected List<ResolutionModifyConfig> mResolutionModifyConfigs = null;
    protected int mResolutionModifyInterval = 0;
    private IEncoderListener mEncoderListener = null;
    private boolean skipCurrentCameraFrameMode = true;
    private boolean mIsExternalEncode = false;
    private AtomicBoolean mQoeFilterUsed = new AtomicBoolean(false);
    private Handler mWeakNetworkHandler = null;
    private HandlerThread mWeakNetworkHandlerThread = null;
    private AtomicBoolean mWeakNetworkFlag = new AtomicBoolean(false);
    private int mLastSuggestCodeRate = 0;
    private int mLastEncoderInitBitrate = 0;
    private int mLastEncoderInitFrameRate = 0;
    private boolean mSoftEncoderSteadyEncodedMode = false;
    private int dstFps = 0;
    private long dstFrameDuration = 0;
    private long mLastFramTime = 0;
    private AtomicBoolean skipFlag = new AtomicBoolean(false);
    private boolean mFirstGetIn = true;
    private ReentrantLock mNewEncoderDealLock = new ReentrantLock(true);
    private IEncodeFilter mNewEncoderFilter = null;
    private AtomicBoolean mChangeEncoderFlag = new AtomicBoolean(false);
    private AtomicBoolean mDiscardAsyncMessageFlag = new AtomicBoolean(false);

    public VideoEncoderGroupFilter(VideoLiveFilterContext videoLiveFilterContext, ILiveSession iLiveSession) {
        this.mMultiStreamEncoderFilter = null;
        this.mFilterContext = videoLiveFilterContext;
        this.mVideoLiveSession = iLiveSession;
        this.mFilterContext.getEncodeParamTipsMgr().setParamListener(this);
        this.mMultiStreamEncoderFilter = new YMFLowStreamEncoderFilter(this.mFilterContext, this.mVideoLiveSession);
    }

    public void setEncoderListener(IEncoderListener iEncoderListener) {
        this.mEncoderListener = iEncoderListener;
        if (this.mMultiStreamEncoderFilter != null) {
            this.mMultiStreamEncoderFilter.setEncoderListener(iEncoderListener);
        }
    }

    public void init() {
        if (!this.mInited.get()) {
            if (this.mWeakNetworkHandler == null) {
                this.mWeakNetworkHandlerThread = new HandlerThread("YY_yyvideolib_VideoGroupThread");
                this.mWeakNetworkHandlerThread.start();
                this.mWeakNetworkHandler = new Handler(this.mWeakNetworkHandlerThread.getLooper());
                YMFLog.info(this, "[Encoder ]", "mWeakNetworkHandler start!.");
            }
            this.mInited.set(true);
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        if (this.mInited.get()) {
            this.mInited.set(false);
            stopEncode();
            tryLockNewEncoderDealLock();
            if (Build.VERSION.SDK_INT >= 18) {
                if (this.mWeakNetworkHandler != null) {
                    this.mWeakNetworkHandler.removeCallbacksAndMessages(null);
                    this.mWeakNetworkHandlerThread.quitSafely();
                    this.mWeakNetworkHandlerThread = null;
                }
            } else if (this.mWeakNetworkHandler != null) {
                this.mWeakNetworkHandler.removeCallbacksAndMessages(null);
                this.mWeakNetworkHandlerThread.quit();
                this.mWeakNetworkHandlerThread = null;
            }
            tryUnlockNewEncoderDealLock();
        }
    }

    private IEncodeFilter createEncoder(VideoEncoderConfig videoEncoderConfig) {
        VideoEncoderType videoEncoderType;
        IEncodeFilter iEncodeFilter = null;
        if (videoEncoderConfig.mEncodeType == VideoEncoderType.HARD_ENCODER_H264) {
            if (H264SurfaceEncoder.IsAvailable()) {
                iEncodeFilter = new H264HardwareEncoderFilter(this.mFilterContext);
                videoEncoderType = VideoEncoderType.HARD_ENCODER_H264;
            } else {
                YMFLog.info(this, "[Encoder ]", "SDK_INT < 18，changed to soft encode");
                UploadStatManager.getInstance().reportException("0", "5", "changed to soft encode");
                iEncodeFilter = new X264SoftEncoderFilter(this.mFilterContext);
                videoEncoderType = VideoEncoderType.SOFT_ENCODER_X264;
                this.mFilterContext.getVideoEncoderConfig().mEncodeType = videoEncoderType;
            }
        } else if (videoEncoderConfig.mEncodeType == VideoEncoderType.SOFT_ENCODER_X264) {
            iEncodeFilter = new X264SoftEncoderFilter(this.mFilterContext);
            videoEncoderType = VideoEncoderType.SOFT_ENCODER_X264;
        } else if (videoEncoderConfig.mEncodeType == VideoEncoderType.HARD_ENCODER_H265) {
            iEncodeFilter = new H265HardwareEncoderFilter(this.mFilterContext);
            videoEncoderType = VideoEncoderType.HARD_ENCODER_H265;
        } else {
            YMFLog.error(this, "[Encoder ]", "codec type is not support, codeId:" + videoEncoderConfig.mEncodeType);
            videoEncoderType = VideoEncoderType.ERROR;
        }
        YMFLiveUsrBehaviorStat.getInstance().notifyVideoEncoderState(videoEncoderType, true);
        YMFLiveStatisticManager.getInstance().setVideoEncodeTypeId(0, CommonUtil.wrapperHiidoEncodeId(videoEncoderType));
        YMFLiveStatisticManager.getInstance().setVideoEncodeWidth(0, videoEncoderConfig.mEncodeWidth);
        YMFLiveStatisticManager.getInstance().setVideoEncodeHeight(0, videoEncoderConfig.mEncodeHeight);
        YMFLiveStatisticManager.getInstance().setVideoDesiredEncodeBitrate(0, videoEncoderConfig.mBitRate);
        YMFLiveStatisticManager.getInstance().setVideoEncodeDesiredFps(0, videoEncoderConfig.mFrameRate);
        return iEncodeFilter;
    }

    public boolean isEnable() {
        return this.mEnable.get();
    }

    public void reSetEncodingState() {
        if (this.mEncoderFilter != null) {
            this.mEncoderFilter.reSetEncodingState();
        }
    }

    public boolean startEncode(VideoEncoderConfig videoEncoderConfig) {
        boolean z;
        X264SoftEncoderFilter x264SoftEncoderFilter = null;
        if (this.mMultiStreamEncoderFilter != null) {
            this.mMultiStreamEncoderFilter.startEncode();
        }
        if (!this.mFilterContext.isHardwareEncode() && videoEncoderConfig.mEncodeType != VideoEncoderType.SOFT_ENCODER_X264) {
            videoEncoderConfig.mEncodeType = VideoEncoderType.SOFT_ENCODER_X264;
            this.mFilterContext.mVideoEncoderConfig.setEncodeType(VideoEncoderType.SOFT_ENCODER_X264);
        }
        if (videoEncoderConfig.mEncodeType == VideoEncoderType.SOFT_ENCODER_X264) {
            this.mSoftEncoderSteadyEncodedMode = false;
        } else {
            this.mSoftEncoderSteadyEncodedMode = true;
        }
        IEncodeFilter createEncoder = createEncoder(videoEncoderConfig);
        if (createEncoder == null) {
            YMFLog.error(this, "[Encoder ]", "no encoder match the encoderConfig:" + videoEncoderConfig.toString());
            return false;
        }
        ((AbstractEncoderFilter) createEncoder).setEncodeStateCallback(this);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 3) {
                z = false;
                break;
            } else if (createEncoder.startEncode()) {
                YMFLog.info(this, "[Encoder ]", "startEncode success");
                YMFLiveUsrBehaviorStat.getInstance().notifyVideoEncodingState(true);
                z = true;
                break;
            } else {
                YMFLog.info(this, "[Encoder ]", "startEncode failed");
                createEncoder.stopEncode();
                createEncoder.deInit();
                i = i2;
            }
        }
        if (z) {
            x264SoftEncoderFilter = createEncoder;
        } else {
            UploadStatManager.getInstance().reportException("0", "5", "changed to soft encode");
            if (createEncoder.getEncoderFilterType() == VideoEncoderType.HARD_ENCODER_H264) {
                this.mFilterContext.mVideoEncoderConfig.setEncodeType(VideoEncoderType.SOFT_ENCODER_X264);
                createEncoder = new X264SoftEncoderFilter(this.mFilterContext);
                this.mFilterContext.getVideoEncoderConfig().mEncodeParameter = "";
                if (createEncoder.startEncode()) {
                    YMFLog.info(this, "[Encoder ]", "hardware h264 encoder switch to software 264 encoder succeed!!");
                } else {
                    YMFLog.info(this, "[Encoder ]", "hardware h264 encoder switch to software 264 encoder fail!!");
                    createEncoder = null;
                }
            }
            if (createEncoder.getEncoderFilterType() == VideoEncoderType.HARD_ENCODER_H265) {
                this.mFilterContext.mVideoEncoderConfig.setEncodeType(VideoEncoderType.HARD_ENCODER_H264);
                H264HardwareEncoderFilter h264HardwareEncoderFilter = new H264HardwareEncoderFilter(this.mFilterContext);
                if (h264HardwareEncoderFilter.startEncode()) {
                    YMFLog.info(this, "[Encoder ]", "hardware h265 encoder switch to hard 264 encoder succeed!!");
                    x264SoftEncoderFilter = h264HardwareEncoderFilter;
                } else {
                    YMFLog.info(this, "[Encoder ]", "hardware h265 encoder switch to hard 264 encoder fail!!");
                    this.mFilterContext.mVideoEncoderConfig.setEncodeType(VideoEncoderType.SOFT_ENCODER_X264);
                    X264SoftEncoderFilter x264SoftEncoderFilter2 = new X264SoftEncoderFilter(this.mFilterContext);
                    if (x264SoftEncoderFilter2.startEncode()) {
                        YMFLog.info(this, "[Encoder ]", "hardware h264 encoder switch to software 264 encoder succeed!!");
                        x264SoftEncoderFilter = x264SoftEncoderFilter2;
                    } else {
                        YMFLog.info(this, "[Encoder ]", "hardware h264 encoder switch to software 264 encoder fail!!");
                    }
                }
            }
        }
        if (x264SoftEncoderFilter != null) {
            this.mEncoderFilter = x264SoftEncoderFilter;
            addDownStream(this.mEncoderFilter);
            this.mEncoderFilter.setEncoderListener(this);
            ((AbstractEncoderFilter) this.mEncoderFilter).setEncodeStateCallback(this);
            YMFLog.info(this, "[Encoder ]", "current mode: " + this.mFilterContext.getLiveMode());
            if (this.mResolutionModifyConfigs != null && this.mResolutionModifyConfigs.size() != 0) {
                enableWeakNetworkAdjust(this.mEncoderFilter, true);
            } else {
                enableWeakNetworkAdjust(this.mEncoderFilter, false);
            }
            this.mUploaderFilter = new TransmitUploadFilter(this.mFilterContext, this.mEncoderListener);
            this.mEncoderFilter.addDownStream(this.mUploaderFilter);
            this.mEnable.set(true);
            YMFLog.info(this, "[Encoder ]", "startEncode encoderConfig:" + videoEncoderConfig.toString());
            return true;
        }
        return false;
    }

    private void enableWeakNetworkAdjust(IEncodeFilter iEncodeFilter, boolean z) {
        if (z && iEncodeFilter != null && !this.mWeakNetworkFlag.get()) {
            YMFLog.info(this, "[Encoder ]", "Enable weak network adjustment.");
            VideoEncoderType encoderFilterType = iEncodeFilter.getEncoderFilterType();
            if (this.mVideoQualityFilter != null) {
                YMFLog.info(this, "[Encoder ]", "Enable weak network adjustment remove old mVideoQualityFilter.");
                removeDownStream(this.mVideoQualityFilter);
                this.mVideoQualityFilter = null;
            }
            if (encoderFilterType == VideoEncoderType.HARD_ENCODER_H264 || encoderFilterType == VideoEncoderType.HARD_ENCODER_H265) {
                this.mVideoQualityFilter = new HardEncodeVideoLiveQualityFilter(this.mFilterContext, this.mVideoLiveSession);
            } else {
                this.mVideoQualityFilter = new SoftEncodeVideoLiveQualityFilter(this.mFilterContext, this.mVideoLiveSession);
            }
            this.mVideoQualityFilter.setResolutionModifyConfigs(this.mResolutionModifyConfigs, this.mResolutionModifyInterval);
            this.mVideoQualityFilter.setWeakNetworkCallback(this);
            this.mVideoQualityFilter.installAdaptor();
            addDownStream(this.mVideoQualityFilter);
            this.skipCurrentCameraFrameMode = false;
            this.mWeakNetworkFlag.set(true);
            YMFLog.info(this, "[Encoder ]", "enableWeakNetworkAdjust:" + z + " skipCurrentCameraFrameMode:" + this.skipCurrentCameraFrameMode);
        } else if (this.mWeakNetworkFlag.get() && !z) {
            this.skipCurrentCameraFrameMode = true;
            if (this.mVideoQualityFilter != null) {
                YMFLog.info(this, "[Encoder ]", " Disable weak network adjustment.");
                removeDownStream(this.mVideoQualityFilter);
                this.mVideoQualityFilter = null;
            }
            YMFLog.info(this, "[Encoder ]", " enableWeakNetworkAdjust:" + z + " skipCurrentCameraFrameMode:" + this.skipCurrentCameraFrameMode + " mResolutionModifyConfigs == null" + (this.mResolutionModifyConfigs == null ? " true" : Integer.valueOf(this.mResolutionModifyConfigs.size())));
            this.mWeakNetworkFlag.set(false);
        }
    }

    public void stopEncode() {
        YMFLog.info(this, "[Encoder ]", "stopEncode");
        YMFLiveUsrBehaviorStat.getInstance().notifyVideoEncodingState(false);
        long currentTimeMillis = System.currentTimeMillis();
        this.mEnable.set(false);
        this.mFilterContext.mChangeEncoderFlag.set(false);
        tryLockNewEncoderDealLock();
        if (this.mMultiStreamEncoderFilter != null) {
            this.mMultiStreamEncoderFilter.stopEncoder();
        }
        if (this.mNewEncoderFilter != null) {
            if (!this.mChangeEncoderFlag.get()) {
                this.mDiscardAsyncMessageFlag.set(true);
                YMFLog.info(this, "[Encoder ]", "stopEncode mDiscardAsyncMessageFlag true");
            }
            this.mNewEncoderFilter.stopEncoderAsync();
        }
        this.mChangeEncoderFlag.set(false);
        tryUnlockNewEncoderDealLock();
        if (this.mNewEncoderFilter != null) {
            this.mNewEncoderFilter.destoryGlElementEnvOnly();
        }
        if (this.mEncoderFilter != null) {
            this.mEncoderFilter.setEncoderListener(null);
            this.mEncoderFilter.stopEncode();
            this.mEncoderFilter.removeAllDownStream();
            removeDownStream(this.mEncoderFilter);
            this.mEncoderFilter = null;
        }
        if (this.mVideoQualityFilter != null) {
            this.mVideoQualityFilter.deInit();
            removeDownStream(this.mVideoQualityFilter);
            this.mVideoQualityFilter = null;
        }
        if (this.mUploaderFilter != null) {
            this.mUploaderFilter = null;
        }
        this.mWeakNetworkFlag.set(false);
        this.skipCurrentCameraFrameMode = true;
        YYVideoCodec.resetCurrentEncodeName();
        YMFLog.info(this, "[Encoder ]", "stopEncoder cost time:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void requestSyncFrame() {
        if (this.mEncoderFilter != null) {
            this.mEncoderFilter.requestSyncFrame();
        }
        if (this.mMultiStreamEncoderFilter != null) {
            this.mMultiStreamEncoderFilter.requestSyncFrame();
        }
    }

    public void setIsExternalEncode(boolean z) {
        this.mIsExternalEncode = z;
    }

    public void setExternalCameraDataCallback(ExternalInterface.IExternalCameraData iExternalCameraData) {
        this.mIExternalCameraData = iExternalCameraData;
    }

    public void setExternalDecodeCallback(ExternalInterface.IExternalDecode iExternalDecode) {
        this.mIExternalDecode = iExternalDecode;
    }

    public void onExternalVideoEnd() {
        YMFLog.info(this, "[Encoder ]", "onExternalVideoEnd");
        this.mIExternalCameraData = null;
        this.mIsExternalEncode = false;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        if (this.mMultiStreamEncoderFilter != null) {
            this.mMultiStreamEncoderFilter.processMediaSample(yYMediaSample, obj);
        }
        if (this.mIExternalCameraData != null && this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_EXTERNAL && !this.mIsExternalEncode) {
            Object eGLContext = this.mFilterContext.getGlManager().getEglCore().getEGLContext();
            ExternalYYMediaSample externalYYMediaSample = new ExternalYYMediaSample(yYMediaSample);
            externalYYMediaSample.mPts = yYMediaSample.mYYPtsMillions;
            externalYYMediaSample.mEGLContext = eGLContext;
            externalYYMediaSample.mMasterTextureId = yYMediaSample.mMasterTextureId;
            this.mIExternalCameraData.onCameraDataProcessCallback(externalYYMediaSample);
        } else if (this.mIExternalDecode != null && this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_EXTERNAL && !this.mIsExternalEncode) {
            Object eGLContext2 = this.mFilterContext.getGlManager().getEglCore().getEGLContext();
            ExternalYYMediaSample externalYYMediaSample2 = new ExternalYYMediaSample(yYMediaSample);
            externalYYMediaSample2.mPts = yYMediaSample.mYYPtsMillions;
            externalYYMediaSample2.mEGLContext = eGLContext2;
            externalYYMediaSample2.mMasterTextureId = yYMediaSample.mMasterTextureId;
            this.mIExternalDecode.onExternalDecodeCallback(externalYYMediaSample2);
        } else {
            this.mIsExternalEncode = false;
            if (this.mFilterContext.getScreenLiveMode().get() || this.mFilterContext.getScreenLiveTextureId() != -1) {
                yYMediaSample.mMasterTextureId = this.mFilterContext.getScreenLiveTextureId();
            }
            if (this.mInited.get() && this.mEnable.get()) {
                if (this.mResolutionModifyConfigs != null && this.mResolutionModifyConfigs.size() != 0) {
                    enableWeakNetworkAdjust(this.mEncoderFilter, true);
                } else {
                    enableWeakNetworkAdjust(this.mEncoderFilter, false);
                }
                if (!this.skipCurrentCameraFrameMode || !skipCurrentFrame(yYMediaSample).booleanValue()) {
                    if (this.mChangeEncoderFlag.get()) {
                        smoothingChangeEncoder(yYMediaSample);
                    } else {
                        synchronized (this) {
                            deliverToDownStream(yYMediaSample);
                        }
                    }
                }
            }
        }
        return false;
    }

    private Boolean skipCurrentFrame(YYMediaSample yYMediaSample) {
        if (this.mFilterContext.getVideoEncoderConfig() == null) {
            return false;
        }
        this.skipFlag.set(false);
        if (this.dstFps == 0 || this.dstFps != this.mFilterContext.getVideoEncoderConfig().getFrameRate()) {
            this.dstFps = this.mFilterContext.getVideoEncoderConfig().getFrameRate();
            this.dstFrameDuration = 1000 / this.dstFps;
        }
        if (TimeUtil.getTickCountLong() - this.mLastFramTime > 2 * this.dstFrameDuration) {
            this.mLastFramTime = 0L;
        }
        if (this.mLastFramTime == 0) {
            this.skipFlag.set(false);
            this.mFirstGetIn = true;
            if (yYMediaSample.mUsedExternPts) {
                this.mLastFramTime = yYMediaSample.mYYPtsMillions;
            } else {
                this.mLastFramTime = TimeUtil.getTickCountLong();
            }
        } else if (this.mFirstGetIn && TimeUtil.getTickCountLong() - this.mLastFramTime < this.dstFrameDuration) {
            this.skipFlag.set(false);
            this.mFirstGetIn = false;
        } else if (!this.mFirstGetIn && TimeUtil.getTickCountLong() - this.mLastFramTime < this.dstFrameDuration) {
            this.skipFlag.set(true);
            this.mFirstGetIn = false;
        } else {
            this.skipFlag.set(false);
            this.mFirstGetIn = false;
            this.mLastFramTime += this.dstFrameDuration;
        }
        return Boolean.valueOf(this.skipFlag.get());
    }

    public void setNetworkBitrateSuggest(int i) {
        int i2;
        YMFLog.info(this, "[Encoder ]", "setNetworkBitrateSuggest, mVideoQualityFilter is null:" + (this.mVideoQualityFilter == null) + ", has adapter:" + (this.mVideoQualityFilter == null ? "no" : Boolean.valueOf(this.mVideoQualityFilter.hasAdapator())) + ", bitrate:" + i);
        this.mLastSuggestCodeRate = i;
        if (this.mVideoQualityFilter != null && this.mVideoQualityFilter.hasAdapator()) {
            if ((this.mVideoQualityFilter instanceof SoftEncodeVideoLiveQualityFilter) && !this.mSoftEncoderSteadyEncodedMode && this.mLastSuggestCodeRate != this.mFilterContext.mVideoEncoderConfig.mBitRate && this.mFilterContext.mUsedAbroadNetWorkStrategy) {
                this.mSoftEncoderSteadyEncodedMode = true;
                VideoEncoderConfig videoEncoderConfig = new VideoEncoderConfig();
                videoEncoderConfig.assign(this.mFilterContext.mVideoEncoderConfig);
                ((SoftEncodeVideoLiveQualityFilter) this.mVideoQualityFilter).forceRebootEncoder(videoEncoderConfig);
                return;
            }
            this.mVideoQualityFilter.setNetworkBitrateSuggest(i);
            return;
        }
        if (YYVideoSDK.getInstance().isMultiVideoLianmaiMode()) {
            i2 = (this.mFilterContext.getVideoEncoderConfig().mBitRate + 999) / 1000;
        } else {
            i2 = (i + 999) / 1000;
        }
        adjustBitRate(i2);
    }

    public void adjustBitRate(int i) {
        if (this.mEncoderFilter != null) {
            this.mEncoderFilter.adjustBitRate(i);
        }
    }

    public void setResolutionModifyConfigs(List<ResolutionModifyConfig> list, int i) {
        this.mResolutionModifyConfigs = list;
        this.mResolutionModifyInterval = i;
        if (this.mVideoQualityFilter != null) {
            this.mVideoQualityFilter.setResolutionModifyConfigs(list, i);
        }
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onEncodeStat(YMFEncoderStatisticInfo yMFEncoderStatisticInfo) {
        if (this.mEncoderListener != null) {
            this.mEncoderListener.onEncodeStat(yMFEncoderStatisticInfo);
        }
        if (this.mVideoQualityFilter != null && (this.mVideoQualityFilter instanceof HardEncodeVideoLiveQualityFilter) && this.mFilterContext.mUsedAbroadNetWorkStrategy && !this.mFilterContext.mChangeEncoderFlag.get()) {
            this.mVideoQualityFilter.estimateRebootEncoder(yMFEncoderStatisticInfo.mBitRate, yMFEncoderStatisticInfo.mFrameRate);
        }
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onEncodeResolution(int i, int i2, int i3) {
        if (this.mEncoderListener != null) {
            this.mEncoderListener.onEncodeResolution(i, i2, i3);
        }
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onEncodeFirstFrame() {
        if (this.mEncoderListener != null) {
            this.mEncoderListener.onEncodeFirstFrame();
        }
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onEncodeFrameData(YMFVideoEncodeFrame yMFVideoEncodeFrame) {
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onEncodeEncParam(String str) {
        if (this.mEncoderListener != null) {
            this.mEncoderListener.onEncodeEncParam(str);
        }
    }

    @Override // com.yy.mediaframework.stat.IEncodeParamListener
    public void encodeParamChanged(String str) {
        onEncodeEncParam(str);
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onHardEncoderError() {
        if (this.mEncoderListener != null) {
            this.mEncoderListener.onHardEncoderError();
        }
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onEncoderSwitch() {
        YMFLog.info(this, "[Encoder ]", "encoder switch in VideoEncoderGroupFilter");
        stopEncode();
        startEncode(this.mFilterContext.mVideoEncoderConfig);
        YMFStreamSyncSourceManager.getInstance().changeEncoderConfig();
    }

    @Override // com.yy.mediaframework.filters.AbstractVideoLiveQualityFilter.IWeakerNetworkCallback
    public void notifyInitEncoderParams(int i, int i2) {
        this.mLastEncoderInitBitrate = i2;
        this.mLastEncoderInitFrameRate = i;
    }

    @Override // com.yy.mediaframework.filters.AbstractVideoLiveQualityFilter.IWeakerNetworkCallback
    public void onReCreateEncoder(final VideoEncoderConfig videoEncoderConfig) {
        if (this.mWeakNetworkHandler != null && videoEncoderConfig != null && this.mEncoderFilter != null) {
            final long hashCode = this.mEncoderFilter.hashCode();
            this.mWeakNetworkHandler.post(new Runnable() { // from class: com.yy.mediaframework.filters.VideoEncoderGroupFilter.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoEncoderGroupFilter.this.reCreateEncoderAsync(videoEncoderConfig, hashCode);
                }
            });
            YMFLog.info(this, "[Encoder ]", "onReCreateEncoder config:" + videoEncoderConfig.toString());
            return;
        }
        YMFLog.error(this, "[Encoder ]", "onReCreateEncoder no handler:" + videoEncoderConfig.toString());
    }

    private void tryLockNewEncoderDealLock() {
        if (this.mNewEncoderDealLock.getHoldCount() == 0) {
            this.mNewEncoderDealLock.lock();
        }
    }

    private void tryUnlockNewEncoderDealLock() {
        while (this.mNewEncoderDealLock.getHoldCount() != 0) {
            try {
                this.mNewEncoderDealLock.unlock();
            } catch (IllegalMonitorStateException e) {
                YMFLog.warn(this, "[Encoder ]", "HardDecodeWayGpu tryUnlockSurfaceDestroyLock more than once");
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reCreateEncoderAsync(VideoEncoderConfig videoEncoderConfig, long j) {
        if (this.mEncoderFilter == null || videoEncoderConfig == null || !this.mInited.get()) {
            YMFLog.error(this, "[Encoder ]", "reCreateEncoderAsync no EncoderFilter:" + videoEncoderConfig.toString());
            return;
        }
        tryLockNewEncoderDealLock();
        if (!this.mEnable.get()) {
            YMFLog.error(this, "[Encoder ]", "creCreateEncoderAsync no mEnable false!");
            tryUnlockNewEncoderDealLock();
        } else if (this.mEncoderFilter == null || j != this.mEncoderFilter.hashCode()) {
            YMFLog.error(this, "[Encoder ]", "creCreateEncoderAsync encoder released :" + j);
            tryUnlockNewEncoderDealLock();
        } else {
            if (this.mNewEncoderFilter != null) {
                this.mNewEncoderFilter.stopEncoderAsync();
            }
            this.mFilterContext.mChangeEncoderFlag.set(true);
            videoEncoderConfig.mLowDelay = ((AbstractEncoderFilter) this.mEncoderFilter).mEncoderConfig.mLowDelay;
            if (!this.mFilterContext.isHardwareEncode() && videoEncoderConfig.mEncodeType != VideoEncoderType.SOFT_ENCODER_X264) {
                videoEncoderConfig.mEncodeType = VideoEncoderType.SOFT_ENCODER_X264;
                videoEncoderConfig.mEncodeParameter = null;
            }
            IEncodeFilter createEncoder = createEncoder(videoEncoderConfig);
            if (createEncoder == null) {
                YMFLog.error(this, "[Encoder ]", "reCreateEncoderAsync no encoder match the encoderConfig:" + videoEncoderConfig.toString());
                tryUnlockNewEncoderDealLock();
                return;
            }
            boolean z = false;
            if (createEncoder.startEncoderOnly(videoEncoderConfig)) {
                YMFLog.info(this, "[Encoder ]", "startEncoderOnly success");
                z = true;
            } else {
                YMFLog.info(this, "[Encoder ]", "startEncoderOnly failed");
                createEncoder.stopEncoderAsync();
                createEncoder.deInit();
            }
            if (!z) {
                UploadStatManager.getInstance().reportException("0", "5", "changed to soft encode");
                if (createEncoder.getEncoderFilterType() == VideoEncoderType.HARD_ENCODER_H264) {
                    this.mFilterContext.mVideoEncoderConfig.setEncodeType(VideoEncoderType.SOFT_ENCODER_X264);
                    createEncoder = new X264SoftEncoderFilter(this.mFilterContext);
                    if (createEncoder.startEncoderOnly(videoEncoderConfig)) {
                        YMFLog.info(this, "[Encoder ]", "hardware h264 encoder switch to software 264 encoder succeed!!");
                    } else {
                        YMFLog.info(this, "[Encoder ]", "hardware h264 encoder switch to software 264 encoder fail!!");
                        createEncoder = null;
                    }
                } else if (createEncoder.getEncoderFilterType() == VideoEncoderType.HARD_ENCODER_H265) {
                    this.mFilterContext.mVideoEncoderConfig.setEncodeType(VideoEncoderType.HARD_ENCODER_H264);
                    createEncoder = new H264HardwareEncoderFilter(this.mFilterContext);
                    if (createEncoder.startEncoderOnly(videoEncoderConfig)) {
                        YMFLog.info(this, "[Encoder ]", "hardware h265 encoder switch to hardware 264 encoder succeed!!");
                    } else {
                        YMFLog.info(this, "[Encoder ]", "hardware h265 encoder switch to hardware 264 encoder fail!!");
                        this.mFilterContext.mVideoEncoderConfig.setEncodeType(VideoEncoderType.SOFT_ENCODER_X264);
                        createEncoder = new X264SoftEncoderFilter(this.mFilterContext);
                        if (createEncoder.startEncoderOnly(videoEncoderConfig)) {
                            YMFLog.info(this, "[Encoder ]", "hardware h264 encoder switch to software 264 encoder succeed!!");
                        } else {
                            YMFLog.info(this, "[Encoder ]", "hardware h264 encoder switch to software 264 encoder fail!!");
                            createEncoder = null;
                        }
                    }
                } else {
                    createEncoder = null;
                }
            }
            if (createEncoder != null) {
                this.mNewEncoderFilter = createEncoder;
                ((AbstractEncoderFilter) this.mNewEncoderFilter).setEncodedCallback(this);
                ((AbstractEncoderFilter) this.mNewEncoderFilter).setEncodeStateCallback(this);
                tryUnlockNewEncoderDealLock();
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                this.mFilterContext.getGLManager().getHandler().post(new Runnable() { // from class: com.yy.mediaframework.filters.VideoEncoderGroupFilter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoEncoderGroupFilter.this.mDiscardAsyncMessageFlag.get()) {
                            VideoEncoderGroupFilter.this.mNewEncoderFilter.createGlElementEnvOnly();
                        } else {
                            YMFLog.info(this, "[Encoder ]", "createGlElementEnvOnly mDiscardAsyncMessageFlag true");
                        }
                        countDownLatch.countDown();
                    }
                });
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    YMFLog.error(this, "[Encoder ]", "updateEncoderConfig  .barrier.await exception:" + e.toString());
                }
                updateEncoderConfig();
            }
        }
    }

    private void updateEncoderConfig() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.mFilterContext.getGLManager().getHandler().post(new Runnable() { // from class: com.yy.mediaframework.filters.VideoEncoderGroupFilter.3
            @Override // java.lang.Runnable
            public void run() {
                if (VideoEncoderGroupFilter.this.mEnable.get() && !VideoEncoderGroupFilter.this.mDiscardAsyncMessageFlag.get()) {
                    VideoEncoderGroupFilter.this.mFilterContext.getVideoEncoderConfig().assign(((AbstractEncoderFilter) VideoEncoderGroupFilter.this.mNewEncoderFilter).mEncoderConfig);
                    YMFLog.info(this, "[Encoder ]", "update EncoderConfig:" + VideoEncoderGroupFilter.this.mFilterContext.getVideoEncoderConfig().toString());
                    if (VideoEncoderGroupFilter.this.mEncoderListener != null) {
                        YMFLog.info(this, "[Encoder ]", "handleEncodeResolution:" + VideoEncoderGroupFilter.this.mFilterContext.getVideoEncoderConfig().mEncodeWidth + Config.EVENT_HEAT_X + VideoEncoderGroupFilter.this.mFilterContext.getVideoEncoderConfig().mEncodeHeight);
                        VideoEncoderGroupFilter.this.mEncoderListener.onEncodeResolution(0, VideoEncoderGroupFilter.this.mFilterContext.getVideoEncoderConfig().mEncodeWidth, VideoEncoderGroupFilter.this.mFilterContext.getVideoEncoderConfig().mEncodeHeight);
                    }
                    VideoEncoderGroupFilter.this.skipCurrentCameraFrameMode = true;
                    VideoEncoderGroupFilter.this.mChangeEncoderFlag.set(true);
                } else {
                    YMFLog.info(this, "[Encoder ]", "updateEncoderConfig mEnable:" + VideoEncoderGroupFilter.this.mEnable.get() + "Discard:" + VideoEncoderGroupFilter.this.mDiscardAsyncMessageFlag.get());
                    VideoEncoderGroupFilter.this.mDiscardAsyncMessageFlag.set(false);
                }
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            YMFLog.error(this, "[Encoder ]", "updateEncoderConfig  .barrier.await exception:" + e.toString());
        }
    }

    @Override // com.yy.mediaframework.IEncoderListener
    public void onWaterMarkSizeChange(int i, int i2) {
    }

    private void checkWaterMarkSize() {
        if (this.mFilterContext.getWaterMarkTexture() != null) {
            if (this.mFilterContext.getVideoEncoderConfig().mEncodeHeight != this.mFilterContext.getWaterMarkTexture().mWatermarkHeight || this.mFilterContext.getVideoEncoderConfig().mEncodeWidth != this.mFilterContext.getWaterMarkTexture().mWatermarkWidth) {
                this.mEncoderListener.onWaterMarkSizeChange(this.mFilterContext.getVideoEncoderConfig().mEncodeWidth, this.mFilterContext.getVideoEncoderConfig().mEncodeHeight);
            }
        }
    }

    private void smoothingChangeEncoder(YYMediaSample yYMediaSample) {
        if (this.mChangeEncoderFlag.get() && this.mNewEncoderFilter != null) {
            checkWaterMarkSize();
            this.mNewEncoderFilter.processMediaSample(yYMediaSample, this);
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractEncoderFilter.IEncodedDataOutCallBack
    public void onNoEncodedDataOut() {
        if (this.mEncoderFilter != null && this.mInited.get()) {
            this.mEncoderFilter.getCacheEncodedData();
        } else {
            YMFLog.error(this, "[Encoder ]", "onNoEncodedDataOut mEncoder:" + this.mEncoderFilter + " mInited:" + this.mInited.get());
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractEncoderFilter.IEncodeStateCallBack
    public void onEncodeError(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c = 0;
                    break;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                if (this.mEncoderListener != null) {
                    YMFLog.info(this, "[Encoder ]", "encoder switch in onEncodeError");
                    this.mFilterContext.setHardwareEncode(false);
                    this.mFilterContext.mVideoEncoderConfig.mEncodeType = VideoEncoderType.SOFT_ENCODER_X264;
                    return;
                }
                return;
            case 2:
                if (this.mEncoderListener != null) {
                    YMFLog.info(this, "[Encoder ]", "encoder switch in onEncodeError");
                    this.mFilterContext.setHardwareEncode(false);
                    this.mEncoderListener.onHardEncoderError();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractEncoderFilter.IEncodedDataOutCallBack
    public void onFirstEncodedDataOut() {
        if (!this.mInited.get()) {
            YMFLog.info(this, "[Encoder ]", "onFirstEncodedDataOut mInited:" + this.mInited.get());
            return;
        }
        tryLockNewEncoderDealLock();
        if (!this.mEnable.get()) {
            YMFLog.error(this, "[Encoder ]", "reCreateEncoderAsync no mEnable false!");
            tryUnlockNewEncoderDealLock();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        while (this.mEncoderFilter.getCacheEncodedData()) {
            YMFLog.info(this, "[Encoder ]", "onFirstEncodedDataOut get cache data");
        }
        final IEncodeFilter iEncodeFilter = this.mEncoderFilter;
        synchronized (this) {
            YMFLog.info(this, "[Encoder ]", "onFirstEncodedDataOut begin real change");
            this.mEnable.set(false);
            if (this.mEncoderFilter != null) {
                this.mEncoderFilter.setEncoderListener(null);
                this.mEncoderFilter.removeAllDownStream();
                removeDownStream(this.mEncoderFilter);
            }
            float f = ((AbstractEncoderFilter) this.mNewEncoderFilter).mEncoderConfig.mFrameRate;
            if (this.mVideoQualityFilter != null) {
                f = this.mVideoQualityFilter.getLastFrameRate();
                this.mVideoQualityFilter.deInit();
                removeDownStream(this.mVideoQualityFilter);
                this.mVideoQualityFilter = null;
            }
            float f2 = f;
            if (this.mUploaderFilter != null) {
                this.mUploaderFilter = null;
            }
            this.mEncoderFilter = this.mNewEncoderFilter;
            addDownStream(this.mEncoderFilter);
            this.mEncoderFilter.setEncoderListener(this);
            ((AbstractEncoderFilter) this.mEncoderFilter).setEncodedCallback(null);
            this.mWeakNetworkFlag.set(false);
            YMFLog.info(this, "[Encoder ]", "current mode:" + this.mFilterContext.getLiveMode());
            if (this.mResolutionModifyConfigs != null && this.mResolutionModifyConfigs.size() != 0) {
                enableWeakNetworkAdjust(this.mEncoderFilter, true);
            } else {
                enableWeakNetworkAdjust(this.mEncoderFilter, false);
            }
            if (this.mVideoQualityFilter != null) {
                if (f2 != 0.0f) {
                    this.mVideoQualityFilter.setLastFrameRate(f2);
                }
                if (this.mLastSuggestCodeRate != 0) {
                    this.mVideoQualityFilter.setLastNetWorkBitrate(this.mLastSuggestCodeRate);
                }
                if (this.mLastEncoderInitFrameRate != 0 || this.mLastEncoderInitBitrate != 0) {
                    this.mVideoQualityFilter.mLastEncoderInitBitrate = this.mLastEncoderInitBitrate;
                    this.mVideoQualityFilter.mLastEncoderInitFrameRate = this.mLastEncoderInitFrameRate;
                }
            }
            if (this.mLastSuggestCodeRate != 0) {
                adjustBitRate((this.mLastSuggestCodeRate + 999) / 1000);
            }
            this.mUploaderFilter = new TransmitUploadFilter(this.mFilterContext, this.mEncoderListener);
            this.mEncoderFilter.addDownStream(this.mUploaderFilter);
            this.mEnable.set(true);
            this.mNewEncoderFilter = null;
            YMFLog.info(this, "[Encoder ]", "schangeExistEncoder encoderConfig:" + ((AbstractEncoderFilter) this.mEncoderFilter).mEncoderConfig.toString());
        }
        tryUnlockNewEncoderDealLock();
        this.mWeakNetworkHandler.post(new Runnable() { // from class: com.yy.mediaframework.filters.VideoEncoderGroupFilter.4
            @Override // java.lang.Runnable
            public void run() {
                iEncodeFilter.stopEncoderAsync();
                iEncodeFilter.destoryGlElementEnvOnly();
            }
        });
        this.mChangeEncoderFlag.set(false);
        this.mFilterContext.mChangeEncoderFlag.set(false);
        YMFLog.info(this, "[Encoder ]", "onFirstEncodedDataOut cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }
}
