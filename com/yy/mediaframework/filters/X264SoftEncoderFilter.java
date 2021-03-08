package com.yy.mediaframework.filters;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.encoder.X264SoftEncoder;
import com.yy.mediaframework.gpuimage.adapter.GlTextureBlender;
import com.yy.mediaframework.gpuimage.adapter.GlTextureImageReader;
import com.yy.mediaframework.model.ByteVector;
import com.yy.mediaframework.model.ImageBufferPool;
import com.yy.mediaframework.model.JVideoEncodedData;
import com.yy.mediaframework.model.YMFImageBuffer;
import com.yy.mediaframework.model.YUVImageBuffer;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.stat.UploadStatManager;
import com.yy.mediaframework.stat.VideoDataStat;
import com.yy.mediaframework.stat.YMFLiveExceptionStat;
import com.yy.mediaframework.stat.YMFLiveExceptionType;
import com.yy.mediaframework.stat.YMFLiveStatisticManager;
import com.yy.mediaframework.stat.YMFLiveUsrBehaviorStat;
import com.yy.mediaframework.utils.ImageUtil;
import com.yy.mediaframework.utils.YMFLog;
import com.yy.mediaframework.utils.YMFSkipFrameTool;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
@SuppressLint({"NewApi"})
/* loaded from: classes6.dex */
public class X264SoftEncoderFilter extends AbstractEncoderFilter implements Runnable {
    private static final int MSG_CHECK_IDLE = 3;
    private static final int MSG_FRAME_AVAILABLE = 1;
    private static final int MSG_QUIT = 2;
    private static String mEncoderNameCurrent;
    private volatile EncoderHandler mHandler;
    private boolean mReady;
    private YMFSkipFrameTool mSkipFrameTool;
    private AtomicInteger mBitRateReqInKbps = new AtomicInteger(0);
    private String mConfigStr = "preset=yyveryfast:bframes=2:b-pyramid=none:threads=2:sliced-threads=0:rc-lookahead=0:sync-lookahead=1:mbtree=0:force-cfr=0:me=dia:chroma_me=0:psy=0:b-adapt=0:";
    private String mLowDelayConfigStr = "preset=yyveryfast:scenecut=0:bframes=0:b-adapt=0:b-pyramid=none:threads=2:sliced-threads=0:ref=2:subme=3:me=dia:analyse=i4x4,i8x8,p8x8,b8x8:direct=spatial:weightp=0:weightb=0:8x8dct=1:cabac=1:deblock=0,0:psy=0:trellis=0:aq-mode=0:rc-lookahead=0:sync-lookahead=0:mbtree=0:force-cfr=1:";
    private String mLowSteadyBitrateConfigStr = "preset=yy:scenecut=0:bframes=0:b-adapt=0:b-pyramid=none:threads=2:sliced-threads=0:ref=2:subme=6:me=hex:analyse=i4x4,i8x8,p8x8,p4x4,b8x8:direct=spatial:weightp=1:weightb=1:8x8dct=1:cabac=1:deblock=0,0:psy=0:trellis=0:aq-mode=0:rc-lookahead=0:sync-lookahead=0:mbtree=0:force-cfr=0:strict-vfr=1:strict-vfr-tol=0.02:strict-vfr-imar=1";
    private String mHeightSteadyBitrateConfigStr = "preset=yyveryfast:scenecut=0:bframes=0:b-adapt=0:b-pyramid=none:threads=2:sliced-threads=0:ref=1:subme=2:me=dia:analyse=i4x4,i8x8,p8x8,b8x8:direct=spatial:weightp=1:weightb=0:8x8dct=1:cabac=1:deblock=0,0:psy=0:trellis=0:aq-mode=0:rc-lookahead=0:sync-lookahead=0:mbtree=0:force-cfr=0:strict-vfr=1:strict-vfr-tol=0.02:strict-vfr-imar=1";
    private String mGopParamStr = "";
    private boolean mFirstFrameEncode = false;
    private ImageBufferPool mYUVImagePool = null;
    private X264SoftEncoder mEncoder = null;
    private int mEncodeWidth = 0;
    private int mEncodeHeight = 0;
    private long mPreviousFramePts = 0;
    private Object mReadyFence = new Object();
    private boolean mRunning = false;
    private GlTextureImageReader mGlImageReader = null;
    private GlTextureBlender mGLBlender = null;
    private long encodeTime = 0;
    private long readPixelTime = 0;
    private AtomicInteger mSyncFrameCnt = new AtomicInteger(0);
    private int mCameraFacing = -1;
    private String mSvcConfigStr = "temporalnum=2:spatialid=1:annexg=1:";
    public YYMediaSample mSpsSample = new YYMediaSample();
    public YYMediaSample mPpsSample = new YYMediaSample();
    private boolean mUseColorChart = false;
    public YYMediaSample mSpecialEncodeConfigSample = new YYMediaSample();
    private boolean mUseSpecialEncodeConfig = false;
    private boolean mFirstInputFrame = false;
    private long mLastInputFramePts = 0;
    private int mLowStreamInputFrames = 0;
    private int mLowStreamSkipFrames = 0;
    private HashMap<Long, Long> mCachedPtsList = new HashMap<>();
    private AtomicBoolean mBSwitchHardEncoder = new AtomicBoolean(false);
    private int mLowStreamScaleWidth = 0;
    private int mLowStreamScaleHight = 0;
    private int mHighStreamWidth = 0;
    private int mHighStreamHight = 0;
    private int mLowStreamClipX = 0;
    private int mLowStreamClipY = 0;
    private ByteVector mBytesVector = null;
    private long mBeginEncode = 0;

    static {
        JVideoEncodedData.nativeClassInit();
        mEncoderNameCurrent = "X264Soft";
    }

    public X264SoftEncoderFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mFilterContext = videoLiveFilterContext;
        YMFLog.info(this, "[Encoder ]", "X264SoftEncoderFilter construct!!");
    }

    private String genGopParamStr(int i) {
        return "keyint=" + i + ":min-keyint=" + i + ":";
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public VideoEncoderType getEncoderFilterType() {
        return VideoEncoderType.SOFT_ENCODER_X264;
    }

    public boolean startEncode(VideoEncoderConfig videoEncoderConfig) {
        synchronized (this.mReadyFence) {
            if (this.mRunning) {
                YMFLog.warn(this, "[Encoder ]", "X264 Encoder thread already running");
            } else {
                this.mEncodeWidth = videoEncoderConfig.getEncodeWidth();
                this.mEncodeHeight = videoEncoderConfig.getEncodeHeight();
                setEncodeCfg(videoEncoderConfig);
                this.mGopParamStr = genGopParamStr(videoEncoderConfig.getFrameRate());
                this.mSyncFrameCnt.set(0);
                this.mRunning = true;
                this.mGlImageReader = new GlTextureImageReader(this.mFilterContext.getAndroidContext(), this.mEncodeWidth, this.mEncodeHeight);
                this.mGLBlender = new GlTextureBlender(this.mFilterContext, this.mEncodeWidth, this.mEncodeHeight);
                this.mYUVImagePool = new ImageBufferPool(this.mEncodeWidth, this.mEncodeHeight, 6, 35, YUVImageBuffer.class, 0);
                YMFLog.info(this, "[Encoder ]", "startEncode width:" + this.mEncodeWidth + " height:" + this.mEncodeHeight + " bitRate:" + this.mEncoderConfig.mBitRate + " mFrameCnt:" + this.mEncoderConfig.mFrameRate);
                this.mBitRateReqInKbps.set(this.mEncoderConfig.mBitRate / 1000);
                synchronized (this.mReadyFence) {
                    if (this.mEncoderConfig.mEncodeParameter == null || this.mEncoderConfig.mEncodeParameter.isEmpty()) {
                        this.mEncoderConfig.mEncodeParameter = this.mConfigStr;
                    }
                    if (this.mEncoderConfig.mEncodeParameter.contains("bframes=2") && this.mEncoderConfig.mLowDelay) {
                        if (this.mEncoderConfig.mEncodeParameter.contains("annexg")) {
                            this.mEncoderConfig.mEncodeParameter = this.mLowDelayConfigStr + this.mSvcConfigStr + this.mGopParamStr;
                        } else {
                            this.mEncoderConfig.mEncodeParameter = this.mLowDelayConfigStr + this.mGopParamStr;
                        }
                        YMFLog.info(this, "[Encoder ]", "X264 startEncode lowDelay:" + this.mEncoderConfig.mEncodeParameter);
                    }
                    this.mEncodeParam = this.mEncoderConfig.toString();
                }
                this.mEncoder = X264SoftEncoder.createEncoder();
                this.mEncoder.setSteadyBitrateControl(false);
                this.mEncoder.initEncoder(this.mEncoderConfig);
                this.mFirstInputFrame = false;
                this.mCachedPtsList.clear();
                new Thread(this, "YMF_X264_Thread").start();
                while (!this.mReady) {
                    try {
                        YMFLog.info(this, "[Encoder ]", "ready fence waitting");
                        this.mReadyFence.wait();
                        YMFLog.info(this, "[Encoder ]", "got ready fence ");
                    } catch (InterruptedException e) {
                    }
                }
                this.mFilterContext.getEncodeParamTipsMgr().setEncoderParam(this.mFilterContext.getLowStreamEncoderConfigs().toString() + ", localConfig:" + this.mEncodeParam);
                this.mFirstEncoderDataOut.set(false);
                this.mUseSpecialEncodeConfig = true;
                this.mSkipFrameTool = new YMFSkipFrameTool(videoEncoderConfig.mFrameRate);
                VideoDataStat.getInstance().setVideoEncodingState(true);
                YMFLog.info(this, "[Encoder ]", "X264SoftEncoderFilter startEncode done");
            }
        }
        return true;
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public boolean startEncode() {
        synchronized (this.mReadyFence) {
            if (this.mRunning) {
                YMFLog.warn(this, "[Encoder ]", "X264 Encoder thread already running");
            } else {
                setEncodeCfg(this.mFilterContext.getVideoEncoderConfig());
                this.mGopParamStr = genGopParamStr(this.mFilterContext.getVideoEncoderConfig().getFrameRate());
                this.mSyncFrameCnt.set(0);
                this.mRunning = true;
                this.mGlImageReader = new GlTextureImageReader(this.mFilterContext.getAndroidContext(), this.mFilterContext.getVideoEncoderConfig().getEncodeWidth(), this.mFilterContext.getVideoEncoderConfig().getEncodeHeight());
                this.mGLBlender = new GlTextureBlender(this.mFilterContext);
                this.mYUVImagePool = new ImageBufferPool(this.mEncoderConfig.getEncodeWidth(), this.mEncoderConfig.getEncodeHeight(), 6, 35, YUVImageBuffer.class, 0);
                YMFLog.info(this, "[Encoder ]", "startEncode width:" + this.mEncoderConfig.getEncodeWidth() + " height:" + this.mEncoderConfig.getEncodeHeight() + " bitRate:" + this.mEncoderConfig.mBitRate + " mFrameCnt:" + this.mEncoderConfig.mFrameRate);
                this.mBitRateReqInKbps.set(this.mEncoderConfig.mBitRate / 1000);
                synchronized (this.mReadyFence) {
                    if (this.mEncoderConfig.mEncodeParameter == null || this.mEncoderConfig.mEncodeParameter.isEmpty()) {
                        this.mEncoderConfig.mEncodeParameter = this.mConfigStr;
                        this.mFilterContext.getVideoEncoderConfig().mEncodeParameter = this.mEncoderConfig.mEncodeParameter;
                    }
                    if (this.mEncoderConfig.mEncodeParameter.contains("bframes=2") && this.mEncoderConfig.mLowDelay) {
                        if (this.mEncoderConfig.mEncodeParameter.contains("annexg")) {
                            this.mEncoderConfig.mEncodeParameter = this.mLowDelayConfigStr + this.mSvcConfigStr + this.mGopParamStr;
                        } else {
                            this.mEncoderConfig.mEncodeParameter = this.mLowDelayConfigStr + this.mGopParamStr;
                        }
                        YMFLog.info(this, "[Encoder ]", "X264 startEncode lowDelay:" + this.mEncoderConfig.mEncodeParameter);
                    }
                    this.mEncodeParam = this.mEncoderConfig.toString();
                }
                this.mEncoder = X264SoftEncoder.createEncoder();
                this.mEncoder.setSteadyBitrateControl(false);
                this.mEncoder.initEncoder(this.mEncoderConfig);
                this.mFirstInputFrame = false;
                this.mCachedPtsList.clear();
                new Thread(this, "YY_yyvideolib_TextureMovieEncoder_Thread").start();
                while (!this.mReady) {
                    try {
                        YMFLog.info(this, "[Encoder ]", "ready fence waitting");
                        this.mReadyFence.wait();
                        YMFLog.info(this, "[Encoder ]", "got ready fence ");
                    } catch (InterruptedException e) {
                    }
                }
                this.mFilterContext.getEncodeParamTipsMgr().setEncoderParam(this.mFilterContext.getVideoEncoderConfig().toString() + ", localConfig:" + this.mEncodeParam);
                this.mFirstEncoderDataOut.set(false);
                VideoDataStat.getInstance().setVideoEncodingState(true);
                YMFLog.info(this, "[Encoder ]", "X264SoftEncoderFilter startEncode done");
            }
        }
        return true;
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public void stopEncode() {
        synchronized (this.mReadyFence) {
            YMFLog.info(this, "[Encoder ]", "X264 stopEncode begin");
            VideoDataStat.getInstance().setVideoEncodingState(false);
            this.mCameraFacing = -1;
            if (this.mGlImageReader != null) {
                this.mGlImageReader.destroy();
                this.mGlImageReader = null;
            }
            if (this.mGLBlender != null) {
                this.mGLBlender.destroy();
                this.mGLBlender = null;
            }
            if (this.mEncoder != null) {
                X264SoftEncoder.destroyEncoder(this.mEncoder);
                this.mEncoder = null;
            }
            YMFLog.info(this, "[Encoder ]", "X264 stopEncode done");
        }
        this.mFilterContext.getEncodeParamTipsMgr().setNoEncoder();
        YMFLiveUsrBehaviorStat.getInstance().notifyVideoEncoderState(VideoEncoderType.SOFT_ENCODER_X264, false);
        this.mSyncFrameCnt.set(0);
        if (this.mHandler != null) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
        }
    }

    private boolean skipFrame(long j) {
        if (this.mSkipFrameTool == null || this.mEncoderConfig == null) {
            return false;
        }
        if (this.mSkipFrameTool.getTargetFrameRate() != this.mEncoderConfig.mFrameRate) {
            this.mSkipFrameTool.updateTargetFrameRate(this.mEncoderConfig.mFrameRate);
        }
        return this.mSkipFrameTool.skipCurrentFrame(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFrameAvailable(YUVImageBuffer yUVImageBuffer) {
        JVideoEncodedData[] encode;
        synchronized (this.mReadyFence) {
            if (this.mEncoder == null) {
                YMFLog.error(this, "[Encoder ]", "handleFrameAvailable encoder is null!");
                return;
            }
            if (this.mEncodeWidth != yUVImageBuffer.mWidth || this.mEncodeHeight != yUVImageBuffer.mHeight) {
                handleEncodeResolution(yUVImageBuffer.mWidth, yUVImageBuffer.mHeight);
                this.mEncodeWidth = yUVImageBuffer.mWidth;
                this.mEncodeHeight = yUVImageBuffer.mHeight;
            }
            if (this.mBSwitchHardEncoder.get()) {
                YMFLog.warn(this, "[Encoder ]", "Switch to HardEncoder!");
            } else if (this.mFilterContext.getLiveMode() == LiveSessionType.LIVE_MODE_NORMAL && !this.mFilterContext.getColorChartLiveEnable() && !this.mUseSpecialEncodeConfig && checkEncoderSwitch()) {
                this.mBSwitchHardEncoder.set(true);
                handleEncoderSwitch();
            } else {
                if (checkEncodeUpdate(yUVImageBuffer.mWidth, yUVImageBuffer.mHeight, yUVImageBuffer.mLowDelay, yUVImageBuffer.mFrameRate, yUVImageBuffer.mBitRate, yUVImageBuffer.mEncodeParameter, this.mInputMode)) {
                    synchronized (this.mReadyFence) {
                        if (this.mEncoderConfig.mEncodeParameter == null || this.mEncoderConfig.mEncodeParameter.isEmpty()) {
                            this.mEncoderConfig.mEncodeParameter = this.mConfigStr;
                            this.mFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.X264SoftEncoderFilter.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    X264SoftEncoderFilter.this.mFilterContext.getVideoEncoderConfig().mEncodeParameter = X264SoftEncoderFilter.this.mEncoderConfig.mEncodeParameter;
                                }
                            });
                        }
                        if (this.mEncoderConfig.mLowDelay) {
                            if (this.mEncoderConfig.mEncodeParameter.contains("annexg")) {
                                this.mEncoderConfig.mEncodeParameter = this.mLowDelayConfigStr + this.mSvcConfigStr + this.mGopParamStr;
                            } else {
                                this.mEncoderConfig.mEncodeParameter = this.mLowDelayConfigStr + this.mGopParamStr;
                            }
                            YMFLog.info(this, "[Encoder ]", "X264 handleFrame lowDelay, config:" + this.mEncoderConfig.mEncodeParameter);
                        }
                        YMFLog.info(this, "[Encoder ]", "config changed, restart the encoder!! config:" + this.mEncoderConfig.toString());
                        this.mBitRateReqInKbps.set(this.mEncoderConfig.mBitRate / 1000);
                        X264SoftEncoder.destroyEncoder(this.mEncoder);
                        this.mEncoder = X264SoftEncoder.createEncoder();
                        this.mEncoder.setSteadyBitrateControl(false);
                        this.mEncoder.initEncoder(this.mEncoderConfig);
                        this.mFirstInputFrame = false;
                        this.mCachedPtsList.clear();
                        this.mEncodeParam = this.mEncoderConfig.toString();
                    }
                    this.mFilterContext.getEncodeParamTipsMgr().setEncoderParam(this.mFilterContext.getVideoEncoderConfig().toString() + ", localConfig:" + this.mEncodeParam);
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (!this.mFilterContext.isUseYuvCapture()) {
                    if (!this.mFirstInputFrame) {
                        this.mCachedPtsList.put(Long.valueOf(yUVImageBuffer.mPts), Long.valueOf(1000 / this.mEncoderConfig.mFrameRate));
                        this.mLastInputFramePts = yUVImageBuffer.mPts;
                        this.mFirstInputFrame = true;
                    } else {
                        this.mCachedPtsList.put(Long.valueOf(yUVImageBuffer.mPts), Long.valueOf(yUVImageBuffer.mPts - this.mLastInputFramePts));
                        this.mLastInputFramePts = yUVImageBuffer.mPts;
                    }
                }
                if (this.mSyncFrameCnt.get() > 0) {
                    JVideoEncodedData[] encode2 = this.mEncoder.encode(yUVImageBuffer.mDataBuffer, yUVImageBuffer.mPts, 4);
                    this.mSyncFrameCnt.decrementAndGet();
                    encode = encode2;
                } else {
                    encode = this.mEncoder.encode(yUVImageBuffer.mDataBuffer, yUVImageBuffer.mPts, 255);
                }
                if (!this.mFirstFrameEncode) {
                    YMFLiveUsrBehaviorStat.getInstance().notifyFirstFrameEncode(yUVImageBuffer.mPts);
                    this.mFirstFrameEncode = true;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                YMFLiveStatisticManager.getInstance().calcPureEncodeLatency(this.mBeginEncode);
                if (System.currentTimeMillis() - this.encodeTime >= IMConnection.RETRY_DELAY_TIMES) {
                    YMFLog.info(this, "[Encoder ]", "processMediaSample encode time:" + (currentTimeMillis2 - currentTimeMillis));
                    this.encodeTime = System.currentTimeMillis();
                }
                if (encode == null) {
                    if (this.encodedCallBack != null && !this.mFirstEncoderDataOut.get()) {
                        this.encodedCallBack.onNoEncodedDataOut();
                        YMFLog.info(this, "[Encoder ]", "encodedCallBack onNoEncodedDataOut!");
                    } else {
                        YMFLog.error(this, "[Encoder ]", "outputVideoArray null!");
                    }
                    this.mYUVImagePool.freeBuffer(yUVImageBuffer);
                    return;
                }
                if (!this.mFirstEncoderDataOut.get()) {
                    this.mFirstEncoderDataOut.set(true);
                    if (this.encodedCallBack != null) {
                        this.encodedCallBack.onFirstEncodedDataOut();
                        YMFLog.info(this, "[Encoder ]", "encodedCallBack onFirstEncodedDataOut!");
                    }
                }
                YMFLiveStatisticManager.getInstance().endEncode(yUVImageBuffer.mStreamId, yUVImageBuffer.mPts);
                for (int i = 0; i < encode.length; i++) {
                    encode[i].mEncodeType = VideoEncoderType.SOFT_ENCODER_X264;
                    YYMediaSample yYMediaSample = encode[i].toYYMediaSample();
                    if (yYMediaSample.mFrameType == 5) {
                        this.mSpsSample.assigne(yYMediaSample);
                    } else if (yYMediaSample.mFrameType == 6) {
                        this.mPpsSample.assigne(yYMediaSample);
                    } else if (this.mGlImageReader.mGlPboSupported && !this.mFilterContext.isUseYuvCapture()) {
                        yYMediaSample.isUsePbo = true;
                        if (this.mCachedPtsList.get(Long.valueOf(yYMediaSample.mYYPtsMillions)) != null) {
                            yYMediaSample.mFrameDeltaDts = this.mCachedPtsList.get(Long.valueOf(yYMediaSample.mYYPtsMillions)).longValue();
                        } else {
                            YMFLog.error((Object) null, "[Encoder ]", "mCachedPtsList error get null");
                        }
                    }
                    yYMediaSample.mStreamId = yUVImageBuffer.mStreamId;
                    yYMediaSample.mWidth = yUVImageBuffer.mWidth;
                    yYMediaSample.mHeight = yUVImageBuffer.mHeight;
                    if (yYMediaSample.mFrameType == 0) {
                        yYMediaSample.mFrameType = 4;
                    }
                    deliverToDownStream(yYMediaSample);
                    handleEncodedFrameStats(encode[i].mDataLen, yUVImageBuffer.mDataBuffer.array().length, yYMediaSample.mFrameType);
                    yYMediaSample.decRef();
                }
                for (JVideoEncodedData jVideoEncodedData : encode) {
                    jVideoEncodedData.releaseVideoByteBuffer();
                }
                this.mYUVImagePool.freeBuffer(yUVImageBuffer);
            }
        }
    }

    public void stopRecording() {
        this.mSyncFrameCnt.set(0);
    }

    public boolean processMediaSampleEx(YYMediaSample yYMediaSample, Object obj) {
        synchronized (this.mReadyFence) {
            YUVImageBuffer yUVImageBuffer = (YUVImageBuffer) this.mYUVImagePool.newBuffer(yYMediaSample.mEncodeWidth, yYMediaSample.mEncodeHeight);
            if (yUVImageBuffer == null) {
                YMFLog.warn(this, "[Encoder ]", "ByteBufferPool is empty!");
            } else {
                YMFLiveStatisticManager.getInstance().beginEncode(yYMediaSample.mStreamId, yYMediaSample.mYYPtsMillions);
                System.arraycopy(yYMediaSample.mI420.mData.array(), yYMediaSample.mI420.mData.arrayOffset(), yUVImageBuffer.mDataBuffer.array(), 0, yUVImageBuffer.mDataBuffer.array().length);
                yUVImageBuffer.mPts = yYMediaSample.mYYPtsMillions;
                yUVImageBuffer.mFrameRate = this.mFilterContext.getVideoEncoderConfig().mFrameRate;
                yUVImageBuffer.mBitRate = this.mFilterContext.getVideoEncoderConfig().mBitRate;
                yUVImageBuffer.mLowDelay = this.mFilterContext.getVideoEncoderConfig().mLowDelay;
                yUVImageBuffer.mEncodeParameter = this.mFilterContext.getVideoEncoderConfig().mEncodeParameter;
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1, yUVImageBuffer));
                handleCaptureFrameStats();
            }
        }
        return false;
    }

    public boolean processMediaSampleEx3(YYMediaSample yYMediaSample, Object obj) {
        boolean z;
        if ((yYMediaSample.mImageFormat == 2 || yYMediaSample.mImageFormat == 1) && (yYMediaSample.mI420 == null || yYMediaSample.mI420.mData == null)) {
            return false;
        }
        this.mSpecialEncodeConfigSample.assigne(yYMediaSample);
        this.mSpecialEncodeConfigSample.mEncodeWidth = this.mEncodeWidth;
        this.mSpecialEncodeConfigSample.mEncodeHeight = this.mEncodeHeight;
        this.mSpecialEncodeConfigSample.mStreamId = this.mStreamId;
        this.mSpecialEncodeConfigSample.mNV12 = yYMediaSample.mNV12;
        this.mSpecialEncodeConfigSample.mI420 = yYMediaSample.mI420;
        YYMediaSample yYMediaSample2 = this.mSpecialEncodeConfigSample;
        UploadStatManager.getInstance().beginEncode((int) yYMediaSample2.mYYPtsMillions);
        synchronized (this.mReadyFence) {
            YUVImageBuffer yUVImageBuffer = (YUVImageBuffer) this.mYUVImagePool.newBuffer(yYMediaSample2.mEncodeWidth, yYMediaSample2.mEncodeHeight);
            if (yUVImageBuffer == null) {
                YMFLog.warn(this, "[Encoder ]", "ByteBufferPool is empty!");
                z = false;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                convertHighStreamToLowStream(yYMediaSample2, yUVImageBuffer);
                long currentTimeMillis2 = System.currentTimeMillis();
                yUVImageBuffer.mWidth = yYMediaSample2.mEncodeWidth;
                yUVImageBuffer.mHeight = yYMediaSample2.mEncodeHeight;
                yUVImageBuffer.mStreamId = yYMediaSample2.mStreamId;
                yUVImageBuffer.mPts = yYMediaSample2.mYYPtsMillions;
                yUVImageBuffer.mFrameRate = this.mEncoderConfig.getFrameRate();
                yUVImageBuffer.mBitRate = this.mEncoderConfig.getBitRate();
                yUVImageBuffer.mLowDelay = this.mEncoderConfig.mLowDelay;
                yUVImageBuffer.mEncodeParameter = this.mEncoderConfig.mEncodeParameter;
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1, yUVImageBuffer));
                if (System.currentTimeMillis() - this.readPixelTime >= IMConnection.RETRY_DELAY_TIMES) {
                    YMFLog.info(this, "[Encoder ]", "processMediaSampleEx3 I420Sacle time:" + (currentTimeMillis2 - currentTimeMillis));
                    this.readPixelTime = System.currentTimeMillis();
                }
                handleCaptureFrameStats();
                z = true;
            }
        }
        return z;
    }

    private void convertHighStreamToLowStream(YYMediaSample yYMediaSample, YUVImageBuffer yUVImageBuffer) {
        YMFImageBuffer yMFImageBuffer = yYMediaSample.mI420;
        if (this.mHighStreamWidth != yMFImageBuffer.mWidth || this.mHighStreamHight != yMFImageBuffer.mHeight) {
            double d = (1.0d * yYMediaSample.mEncodeWidth) / yMFImageBuffer.mWidth;
            double d2 = (1.0d * yYMediaSample.mEncodeHeight) / yMFImageBuffer.mHeight;
            if (d >= d2) {
                this.mLowStreamScaleHight = ((int) ((d * yYMediaSample.mHeight) + 0.5d)) & (-2);
                this.mLowStreamScaleWidth = yYMediaSample.mEncodeWidth;
            } else {
                this.mLowStreamScaleWidth = ((int) ((yYMediaSample.mWidth * d2) + 0.5d)) & (-2);
                this.mLowStreamScaleHight = yYMediaSample.mEncodeHeight;
            }
            this.mHighStreamWidth = yMFImageBuffer.mWidth;
            this.mHighStreamHight = yMFImageBuffer.mHeight;
            this.mLowStreamClipX = ((this.mLowStreamScaleWidth - yYMediaSample.mEncodeWidth) / 2) & (-2);
            this.mLowStreamClipY = ((this.mLowStreamScaleHight - yYMediaSample.mEncodeHeight) / 2) & (-2);
            YMFLog.info(this, TAG, " buffer mode clip" + this.mHighStreamWidth + Config.EVENT_HEAT_X + this.mHighStreamHight + PerfFrameTrackUIUtil.SEPERATOR_ARROR + this.mLowStreamScaleWidth + Config.EVENT_HEAT_X + this.mLowStreamScaleHight + " ; <" + this.mLowStreamClipX + "," + this.mLowStreamClipY + "," + yYMediaSample.mEncodeWidth + "," + yYMediaSample.mEncodeHeight + ">");
        }
        if (this.mBytesVector == null) {
            this.mBytesVector = new ByteVector(((this.mHighStreamWidth * this.mHighStreamHight) * 3) / 2);
        }
        this.mBytesVector.reserve(((this.mHighStreamWidth * this.mHighStreamHight) * 3) / 2);
        ImageUtil.I420Scale(yYMediaSample.mI420.mData.array(), yYMediaSample.mI420.mData.arrayOffset(), yYMediaSample.mI420.mWidth, yYMediaSample.mI420.mHeight, this.mBytesVector.getBytes(), this.mLowStreamScaleWidth, this.mLowStreamScaleHight, 0, false);
        ImageUtil.ConvertToI420Ex(this.mBytesVector.getBytes(), yYMediaSample.mI420.mData.arrayOffset(), ((this.mLowStreamScaleWidth * this.mLowStreamScaleHight) * 3) / 2, yUVImageBuffer.mDataBuffer.array(), 0, this.mLowStreamClipX, this.mLowStreamClipY, this.mLowStreamScaleWidth, this.mLowStreamScaleHight, yYMediaSample.mEncodeWidth, yYMediaSample.mEncodeHeight, 0, 2);
        this.mBytesVector.clear();
    }

    public boolean processMediaSampleEx2(YYMediaSample yYMediaSample, Object obj) {
        boolean z;
        this.mLowStreamInputFrames++;
        if (skipFrame(yYMediaSample.mYYPtsMillions)) {
            this.mLowStreamSkipFrames++;
            if (this.mLowStreamInputFrames > 40) {
                YMFLog.info(this, "[Encoder ]", yYMediaSample.mYYPtsMillions + " lowStream IN:" + this.mLowStreamInputFrames + ",skip:" + this.mLowStreamSkipFrames);
                this.mLowStreamSkipFrames = 0;
                this.mLowStreamInputFrames = 0;
            }
            return true;
        } else if (yYMediaSample.mImageFormat == 2 || yYMediaSample.mImageFormat == 1) {
            return processMediaSampleEx3(yYMediaSample, obj);
        } else {
            this.mSpecialEncodeConfigSample.assigne(yYMediaSample);
            this.mSpecialEncodeConfigSample.mEncodeWidth = this.mEncodeWidth;
            this.mSpecialEncodeConfigSample.mEncodeHeight = this.mEncodeHeight;
            this.mSpecialEncodeConfigSample.mStreamId = this.mStreamId;
            YYMediaSample yYMediaSample2 = this.mSpecialEncodeConfigSample;
            YMFLiveStatisticManager.getInstance().beginEncode(this.mSpecialEncodeConfigSample.mStreamId, yYMediaSample2.mYYPtsMillions);
            long currentTimeMillis = System.currentTimeMillis();
            int i = yYMediaSample2.mMasterTextureId;
            if (this.mGLBlender != null) {
                i = this.mGLBlender.blend(yYMediaSample2, this.mFilterContext.getWatermarkTextureID(), this.mFilterContext.getDynamicTextureID(), this.mFilterContext.getPictureInPictureFlag() && this.mFilterContext.getSwithPictureFlag());
                yYMediaSample2.mBlenderTextureId = i;
            }
            if (this.mGlImageReader == null) {
                this.mGlImageReader = new GlTextureImageReader(this.mFilterContext.getAndroidContext(), this.mEncoderConfig.getEncodeWidth(), this.mEncoderConfig.getEncodeHeight());
                YMFLog.info(this, "[Encoder ]", "new GlTextureImageReader OK!");
            }
            byte[] read = this.mGlImageReader.read(i, yYMediaSample2.mEncodeWidth, yYMediaSample2.mEncodeHeight);
            if (read == null) {
                return false;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            synchronized (this.mReadyFence) {
                YUVImageBuffer yUVImageBuffer = (YUVImageBuffer) this.mYUVImagePool.newBuffer(yYMediaSample2.mEncodeWidth, yYMediaSample2.mEncodeHeight);
                if (yUVImageBuffer == null) {
                    YMFLog.warn(this, "[Encoder ]", "ByteBufferPool is empty!");
                    z = false;
                } else {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    ImageUtil.RBGAtoYUV(read, yYMediaSample2.mEncodeWidth, yYMediaSample2.mEncodeHeight, yUVImageBuffer.mDataBuffer.array());
                    long currentTimeMillis4 = System.currentTimeMillis();
                    yUVImageBuffer.mWidth = yYMediaSample2.mEncodeWidth;
                    yUVImageBuffer.mHeight = yYMediaSample2.mEncodeHeight;
                    yUVImageBuffer.mStreamId = yYMediaSample2.mStreamId;
                    yUVImageBuffer.mPts = yYMediaSample2.mYYPtsMillions;
                    yUVImageBuffer.mFrameRate = this.mEncoderConfig.getFrameRate();
                    yUVImageBuffer.mBitRate = this.mEncoderConfig.getBitRate();
                    yUVImageBuffer.mLowDelay = this.mEncoderConfig.mLowDelay;
                    yUVImageBuffer.mEncodeParameter = this.mEncoderConfig.mEncodeParameter;
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(1, yUVImageBuffer));
                    if (System.currentTimeMillis() - this.readPixelTime >= IMConnection.RETRY_DELAY_TIMES) {
                        YMFLog.info(this, "[Encoder ]", "processMediaSampleEx2 read pixel time:" + (currentTimeMillis2 - currentTimeMillis) + " rgb2yuv time:" + (currentTimeMillis4 - currentTimeMillis3));
                        this.readPixelTime = System.currentTimeMillis();
                    }
                    handleCaptureFrameStats();
                    z = true;
                }
            }
            return z;
        }
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter, com.yy.mediaframework.IMediaFilter
    public boolean processMediaSample(YYMediaSample yYMediaSample, Object obj) {
        boolean z;
        synchronized (this.mReadyFence) {
            if (!this.mReady) {
                return false;
            }
            if (this.mUseSpecialEncodeConfig) {
                return processMediaSampleEx2(yYMediaSample, obj);
            }
            if (yYMediaSample.mImageFormat == 2) {
                return processMediaSampleEx(yYMediaSample, obj);
            }
            YMFLiveStatisticManager.getInstance().beginEncode(yYMediaSample.mStreamId, yYMediaSample.mYYPtsMillions);
            long currentTimeMillis = System.currentTimeMillis();
            this.mBeginEncode = currentTimeMillis;
            this.mFilterContext.getVideoEncoderConfig();
            int i = yYMediaSample.mMasterTextureId;
            if (this.mGLBlender != null) {
                i = this.mGLBlender.blend(yYMediaSample, this.mFilterContext.getWatermarkTextureID(), this.mFilterContext.getDynamicTextureID(), this.mFilterContext.getPictureInPictureFlag() && this.mFilterContext.getSwithPictureFlag());
                yYMediaSample.mBlenderTextureId = i;
            }
            if (this.mGlImageReader == null) {
                this.mGlImageReader = new GlTextureImageReader(this.mFilterContext.getAndroidContext(), this.mFilterContext.getVideoEncoderConfig().getEncodeWidth(), this.mFilterContext.getVideoEncoderConfig().getEncodeHeight());
                YMFLog.info(this, "[Encoder ]", "new GlTextureImageReader OK!");
            }
            byte[] read = this.mGlImageReader.read(i, yYMediaSample.mEncodeWidth, yYMediaSample.mEncodeHeight);
            if (read == null) {
                return false;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            synchronized (this.mReadyFence) {
                YUVImageBuffer yUVImageBuffer = (YUVImageBuffer) this.mYUVImagePool.newBuffer(yYMediaSample.mEncodeWidth, yYMediaSample.mEncodeHeight);
                if (yUVImageBuffer == null) {
                    YMFLog.warn(this, "[Encoder ]", "ByteBufferPool is empty!");
                    z = false;
                } else {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    ImageUtil.RBGAtoYUV(read, yYMediaSample.mEncodeWidth, yYMediaSample.mEncodeHeight, yUVImageBuffer.mDataBuffer.array());
                    long currentTimeMillis4 = System.currentTimeMillis();
                    yUVImageBuffer.mPts = yYMediaSample.mYYPtsMillions;
                    yUVImageBuffer.mFrameRate = this.mFilterContext.getVideoEncoderConfig().mFrameRate;
                    yUVImageBuffer.mBitRate = this.mFilterContext.getVideoEncoderConfig().mBitRate;
                    yUVImageBuffer.mLowDelay = this.mFilterContext.getVideoEncoderConfig().mLowDelay;
                    yUVImageBuffer.mEncodeParameter = this.mFilterContext.getVideoEncoderConfig().mEncodeParameter;
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(1, yUVImageBuffer));
                    if (System.currentTimeMillis() - this.readPixelTime >= IMConnection.RETRY_DELAY_TIMES) {
                        YMFLog.info(this, "[Encoder ]", "processMediaSample read pixel buffer time:" + (currentTimeMillis2 - currentTimeMillis));
                        YMFLog.info(this, "[Encoder ]", "processMediaSample trans rgb2yuv time:" + (currentTimeMillis4 - currentTimeMillis3));
                        this.readPixelTime = System.currentTimeMillis();
                    }
                    handleCaptureFrameStats();
                    z = true;
                }
            }
            return z;
        }
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public void requestSyncFrame() {
        YMFLog.info(this, "[Encoder ]", "requestSyncFrame");
        this.mSyncFrameCnt.addAndGet(1);
    }

    public boolean isRecording() {
        boolean z;
        synchronized (this.mReadyFence) {
            z = this.mRunning;
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [805=4] */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    @Override // java.lang.Runnable
    public void run() {
        YMFLog.info(this, "[Encoder ]", "run before prepare");
        Looper.prepare();
        try {
            synchronized (this.mReadyFence) {
                this.mHandler = new EncoderHandler(this);
                this.mReady = true;
                this.mReadyFence.notify();
                YMFLog.info(this, "[Encoder ]", "run notify ready");
            }
            Looper.loop();
            YMFLog.info(this, "[Encoder ]", "x264 encoder thread exiting");
            synchronized (this.mReadyFence) {
                this.mRunning = false;
                this.mReady = false;
                this.mHandler = null;
            }
        } catch (Throwable th) {
            try {
                YMFLog.error(this, "[Encoder ]", "x264 encoder thread run exception:" + th.getMessage());
                YMFLiveExceptionStat.getInstance().notifyException(YMFLiveExceptionType.AnchorStatus_ENCODE_ERROR);
                this.mbEncodingState = false;
                YMFLog.info(this, "[Encoder ]", "x264 encoder thread exiting");
                synchronized (this.mReadyFence) {
                    this.mRunning = false;
                    this.mReady = false;
                    this.mHandler = null;
                }
            } catch (Throwable th2) {
                YMFLog.info(this, "[Encoder ]", "x264 encoder thread exiting");
                synchronized (this.mReadyFence) {
                    this.mRunning = false;
                    this.mReady = false;
                    this.mHandler = null;
                    throw th2;
                }
            }
        }
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public void adjustBitRate(int i) {
        if (this.mBitRateReqInKbps.get() == i) {
            YMFLog.info(this, "[Encoder ]", "original bitrate is" + i + " already");
            return;
        }
        YMFLog.info(this, "[Encoder ]", "adjustBitRate, target bitRate:" + i);
        this.mBitRateReqInKbps.set(i);
        synchronized (this.mReadyFence) {
            if (this.mEncoder != null) {
                this.mEncoder.adjustBitRate(this.mBitRateReqInKbps.get());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class EncoderHandler extends Handler {
        private WeakReference<X264SoftEncoderFilter> mWeakEncoder;

        public EncoderHandler(X264SoftEncoderFilter x264SoftEncoderFilter) {
            this.mWeakEncoder = new WeakReference<>(x264SoftEncoderFilter);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            X264SoftEncoderFilter x264SoftEncoderFilter = this.mWeakEncoder.get();
            if (x264SoftEncoderFilter != null) {
                switch (i) {
                    case 1:
                        x264SoftEncoderFilter.handleFrameAvailable((YUVImageBuffer) message.obj);
                        return;
                    case 2:
                        if (Looper.myLooper() != null) {
                            Looper.myLooper().quit();
                            return;
                        }
                        return;
                    case 3:
                        ((CountDownLatch) message.obj).countDown();
                        YMFLog.info(this, "[Encoder ]", "mHandler MSG_CHECK_IDLE !");
                        return;
                    default:
                        throw new RuntimeException("Unhandled msg what=" + i);
                }
            }
            YMFLog.warn(this, "[Encoder ]", "handleMessage: encoder is null");
        }
    }

    public static String getEncoderName() {
        return mEncoderNameCurrent;
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public boolean getCacheEncodedData() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            YMFLog.error(this, "[Encoder ]", "getCacheEncodedData exception:" + e.toString());
        }
        if (this.mEncoder != null) {
            JVideoEncodedData[] cacheEncodedData = this.mEncoder.getCacheEncodedData();
            if (cacheEncodedData == null) {
                YMFLog.warn(this, "[Encoder ]", "getCacheEncodedData no cache Encoded Data!");
                return false;
            }
            for (int i = 0; i < cacheEncodedData.length; i++) {
                cacheEncodedData[i].mEncodeType = VideoEncoderType.SOFT_ENCODER_X264;
                YYMediaSample yYMediaSample = cacheEncodedData[i].toYYMediaSample();
                YMFLog.info(this, "[Encoder ]", "getCacheEncodedData pts:" + yYMediaSample.mYYPtsMillions + " dts:" + yYMediaSample.mDtsMillions + " gap:" + (yYMediaSample.mYYPtsMillions - yYMediaSample.mDtsMillions) + " frameType:" + yYMediaSample.mFrameType);
                if (yYMediaSample.mFrameType == 5) {
                    this.mSpsSample.assigne(yYMediaSample);
                } else if (yYMediaSample.mFrameType == 6) {
                    this.mPpsSample.assigne(yYMediaSample);
                } else if (this.mGlImageReader.mGlPboSupported && !this.mFilterContext.isUseYuvCapture()) {
                    yYMediaSample.isUsePbo = true;
                    if (this.mCachedPtsList.get(Long.valueOf(yYMediaSample.mYYPtsMillions)) != null) {
                        yYMediaSample.mFrameDeltaDts = this.mCachedPtsList.get(Long.valueOf(yYMediaSample.mYYPtsMillions)).longValue();
                    } else {
                        YMFLog.error((Object) null, "[Encoder ]", "mCachedPtsList error get null");
                    }
                }
                deliverToDownStream(yYMediaSample);
                handleEncodedFrameStats(cacheEncodedData[i].mDataLen, 0, yYMediaSample.mFrameType);
                yYMediaSample.decRef();
            }
            for (JVideoEncodedData jVideoEncodedData : cacheEncodedData) {
                jVideoEncodedData.releaseVideoByteBuffer();
            }
            return true;
        }
        return false;
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public void destoryGlElementEnvOnly() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (!this.mFilterContext.getGLManager().checkSameThread()) {
            this.mFilterContext.getGLManager().getHandler().post(new Runnable() { // from class: com.yy.mediaframework.filters.X264SoftEncoderFilter.2
                @Override // java.lang.Runnable
                public void run() {
                    X264SoftEncoderFilter.this.destroyGlElementEnv();
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
                return;
            } catch (InterruptedException e) {
                YMFLog.error(this, "[Encoder ]", "stopEncoderAsyenc  .barrier.await exception:" + e.toString());
                return;
            }
        }
        destroyGlElementEnv();
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public void createGlElementEnvOnly() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mGlImageReader = new GlTextureImageReader(this.mFilterContext.getAndroidContext(), this.mFilterContext.getVideoEncoderConfig().getEncodeWidth(), this.mFilterContext.getVideoEncoderConfig().getEncodeHeight());
        this.mGLBlender = new GlTextureBlender(this.mFilterContext);
        YMFLog.info(this, "[Encoder ]", "createGlElementEnv success, cost time :" + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyGlElementEnv() {
        if (this.mGlImageReader != null) {
            this.mGlImageReader.destroy();
            this.mGlImageReader = null;
        }
        if (this.mGLBlender != null) {
            this.mGLBlender.destroy();
            this.mGLBlender = null;
        }
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public boolean stopEncoderAsync() {
        synchronized (this.mReadyFence) {
            if (this.mEncoder == null) {
                YMFLog.info(this, "[Encoder ]", "X264 stopEncoderAsyenc has realeased");
            } else {
                YMFLog.info(this, "[Encoder ]", "X264 stopEncoderAsyenc begin");
                this.mCameraFacing = -1;
                if (this.mEncoder != null) {
                    X264SoftEncoder.destroyEncoder(this.mEncoder);
                    this.mEncoder = null;
                }
                YMFLog.info(this, "[Encoder ]", "X264 stopEncoderAsyenc done");
                this.mFilterContext.getEncodeParamTipsMgr().setNoEncoder();
                this.mSyncFrameCnt.set(0);
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                }
            }
        }
        return true;
    }

    @Override // com.yy.mediaframework.filters.IEncodeFilter
    public boolean startEncoderOnly(VideoEncoderConfig videoEncoderConfig) {
        synchronized (this.mReadyFence) {
            if (this.mRunning) {
                YMFLog.warn(this, "[Encoder ]", "X264 Encoder thread already running");
            } else {
                setEncodeCfg(videoEncoderConfig);
                this.mGopParamStr = genGopParamStr(videoEncoderConfig.getFrameRate());
                this.mSyncFrameCnt.set(0);
                this.mRunning = true;
                this.mYUVImagePool = new ImageBufferPool(this.mEncoderConfig.getEncodeWidth(), this.mEncoderConfig.getEncodeHeight(), 6, 35, YUVImageBuffer.class, 0);
                YMFLog.info(this, "[Encoder ]", "X264SoftEncoderFilter startEncoderOnly width:" + this.mEncoderConfig.getEncodeWidth() + " height:" + this.mEncoderConfig.getEncodeHeight() + " bitRate:" + this.mEncoderConfig.mBitRate + " mFrameCnt " + this.mEncoderConfig.mFrameRate);
                this.mBitRateReqInKbps.set(this.mEncoderConfig.mBitRate / 1000);
                String str = this.mLowSteadyBitrateConfigStr;
                if (videoEncoderConfig.mEncodeHeight * videoEncoderConfig.mEncodeWidth >= 235520) {
                    str = this.mHeightSteadyBitrateConfigStr;
                }
                synchronized (this.mReadyFence) {
                    if (this.mEncoderConfig.mEncodeParameter == null || this.mEncoderConfig.mEncodeParameter.isEmpty()) {
                        this.mEncoderConfig.mEncodeParameter = str;
                    }
                    if (this.mEncoderConfig.mEncodeParameter.contains("bframes=2") && this.mEncoderConfig.mLowDelay) {
                        if (this.mEncoderConfig.mEncodeParameter.contains("annexg")) {
                            this.mEncoderConfig.mEncodeParameter = str + this.mSvcConfigStr + this.mGopParamStr;
                        } else {
                            this.mEncoderConfig.mEncodeParameter = str + this.mGopParamStr;
                        }
                        YMFLog.info(this, "[Encoder ]", "X264 startEncoderOnly lowDelay:" + this.mEncoderConfig.mEncodeParameter);
                    }
                    this.mEncodeParam = this.mEncoderConfig.toString();
                }
                this.mEncoder = X264SoftEncoder.createEncoder();
                this.mEncoder.setSteadyBitrateControl(true);
                this.mEncoder.initEncoder(this.mEncoderConfig);
                this.mFirstInputFrame = false;
                this.mCachedPtsList.clear();
                new Thread(this, "YY_yyvideolib_TextureMovieEncoder_Thread").start();
                while (!this.mReady) {
                    try {
                        YMFLog.info(this, "[Encoder ]", "ready fence waitting");
                        this.mReadyFence.wait();
                        YMFLog.info(this, "[Encoder ]", "got ready fence ");
                    } catch (InterruptedException e) {
                    }
                }
                this.mFilterContext.getEncodeParamTipsMgr().setEncoderParam(this.mFilterContext.getVideoEncoderConfig().toString() + ", localConfig:" + this.mEncodeParam);
                this.mFirstEncoderDataOut.set(false);
                YMFLog.info(this, "[Encoder ]", "X264SoftEncoderFilter startEncoderOnly done!");
            }
        }
        return true;
    }
}
