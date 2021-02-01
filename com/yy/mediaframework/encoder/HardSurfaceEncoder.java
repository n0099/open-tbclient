package com.yy.mediaframework.encoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Surface;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import com.kwai.video.player.KsMediaMeta;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.YYVideoCodec;
import com.yy.mediaframework.base.VideoEncoderConfig;
import com.yy.mediaframework.base.VideoEncoderType;
import com.yy.mediaframework.model.YMFImageBuffer;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.stat.UploadStatManager;
import com.yy.mediaframework.stat.VideoDataStat;
import com.yy.mediaframework.stat.VideoDataStatUtil;
import com.yy.mediaframework.stat.YMFLiveStatisticManager;
import com.yy.mediaframework.utils.MediaCodecUtil;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
@TargetApi(18)
/* loaded from: classes4.dex */
public abstract class HardSurfaceEncoder {
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 2000;
    private static String TAG = "HardSurfaceEncoder";
    private static String mCodecName = null;
    int mBps;
    MediaCodec.BufferInfo mBufferInfo;
    private int mColorFormat;
    MediaCodec mEncoder;
    int mFps;
    int mHeight;
    private Surface mInputSurface;
    int mLevel;
    HardEncodeListner mListener;
    String mMime;
    int mProfile;
    int mWidth;
    private MediaFormat mMediaformat = null;
    private LinkedList<Long> mCachedPtsList = new LinkedList<>();
    boolean mInitialized = false;
    private AtomicLong mEncodeId = new AtomicLong(-1);
    private long mEncodedDeltaPts = 0;
    private boolean mFirstEncodedFrame = true;
    private String mStrFormat = "";
    private boolean mLowDelay = false;
    private boolean mHasEncodeData = false;
    private byte[] mYuvData = null;
    private boolean mEofFlag = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HardSurfaceEncoder(String str, String str2, long j) {
        this.mMime = "";
        TAG = str;
        this.mMime = str2;
        this.mEncodeId.set(j);
    }

    public static boolean IsAvailable() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public Surface getInputSurface() {
        return this.mInputSurface;
    }

    private void setProfileLevel(MediaFormat mediaFormat, VideoEncoderConfig videoEncoderConfig) {
        int i = 0;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = this.mEncoder.getCodecInfo().getCapabilitiesForType(this.mMime).profileLevels;
        this.mLevel = 0;
        this.mProfile = 0;
        if (this.mMime.equals("video/hevc")) {
            int length = codecProfileLevelArr.length;
            while (i < length) {
                MediaCodecInfo.CodecProfileLevel codecProfileLevel = codecProfileLevelArr[i];
                if (this.mProfile == codecProfileLevel.profile && this.mLevel <= codecProfileLevel.level) {
                    this.mProfile = codecProfileLevel.profile;
                    this.mLevel = codecProfileLevel.level;
                }
                i++;
            }
        } else if (!videoEncoderConfig.mLowDelay && videoEncoderConfig.mEncodeType == VideoEncoderType.HARD_ENCODER_H264) {
            int length2 = codecProfileLevelArr.length;
            while (i < length2) {
                MediaCodecInfo.CodecProfileLevel codecProfileLevel2 = codecProfileLevelArr[i];
                if (codecProfileLevel2.profile <= 64) {
                    if (this.mProfile < codecProfileLevel2.profile) {
                        this.mProfile = codecProfileLevel2.profile;
                        this.mLevel = codecProfileLevel2.level;
                    } else if (this.mProfile == codecProfileLevel2.profile && this.mLevel < codecProfileLevel2.level) {
                        this.mProfile = codecProfileLevel2.profile;
                        this.mLevel = codecProfileLevel2.level;
                    }
                }
                i++;
            }
            if (this.mProfile > 0) {
                this.mLevel = this.mLevel <= 8192 ? this.mLevel : 8192;
                if (Build.VERSION.SDK_INT >= 21) {
                    mediaFormat.setInteger(ConstantData.VideoLocationType.PERSON_PROFILE, this.mProfile);
                }
                mediaFormat.setInteger("level", this.mLevel);
            }
        }
    }

    private boolean setColorFormat(MediaFormat mediaFormat, Constant.EncoderInputMode encoderInputMode) {
        if (encoderInputMode == Constant.EncoderInputMode.BUFFER) {
            int colorFormat = MediaCodecUtil.instance().getColorFormat(this.mMime);
            if (colorFormat < 0) {
                YMFLog.error(this, "[Encoder ]", "hardware encoder do not support YUV420P and YUV420SP as input !");
                return false;
            }
            mediaFormat.setInteger("color-format", colorFormat);
            this.mColorFormat = colorFormat;
        } else {
            mediaFormat.setInteger("color-format", 2130708361);
            this.mColorFormat = 2130708361;
        }
        return true;
    }

    private void setEncodeParamFromServer(MediaFormat mediaFormat, VideoEncoderConfig videoEncoderConfig) {
        YMFLog.info(this, "[Encoder ]", "MediaCodec params:" + videoEncoderConfig.mEncodeParameter);
        try {
            if (videoEncoderConfig.mEncodeParameter != null) {
                String[] split = videoEncoderConfig.mEncodeParameter.split(":");
                for (int i = 0; i < split.length; i++) {
                    YMFLog.info(this, "[Encoder ]", "MediaCodec parse token:" + split[i]);
                    String[] split2 = split[i].split("=");
                    if (split2.length == 2) {
                        YMFLog.info(TAG, "[Encoder ]", "MediaCodec param item, name:" + split2[0] + ", value:" + split2[1]);
                        setEncoderParams(mediaFormat, split2[0], split2[1]);
                    } else {
                        YMFLog.info(TAG, "[Encoder ]", "MediaCodec invalid param item:" + Arrays.toString(split2));
                    }
                }
            }
        } catch (Exception e) {
            YMFLog.info(TAG, "[Encoder ]", "MediaCodec parse exception:" + e);
            UploadStatManager.getInstance().reportException("0", "4", e.toString());
        }
    }

    public boolean init(VideoEncoderConfig videoEncoderConfig, HardEncodeListner hardEncodeListner, Constant.EncoderInputMode encoderInputMode) {
        boolean z = false;
        synchronized (this) {
            if (!IsAvailable()) {
                YMFLog.error(this, "[Encoder ]", "hardware encoder is not available");
            } else {
                deInit();
                YMFLog.info(this, "[Encoder ]", "encoder init, configure:" + videoEncoderConfig.toString());
                this.mWidth = videoEncoderConfig.getEncodeWidth();
                this.mHeight = videoEncoderConfig.getEncodeHeight();
                UploadStatManager.getInstance().setDecoderResolution(VideoDataStatUtil.getDPI(this.mWidth, this.mHeight));
                VideoDataStat.getInstance().setDynamicEncodeFrameRate(videoEncoderConfig.mFrameRate);
                this.mFps = videoEncoderConfig.mFrameRate;
                this.mBps = videoEncoderConfig.mBitRate;
                this.mLowDelay = videoEncoderConfig.mLowDelay;
                this.mEncoder = MediaCodec.createEncoderByType(this.mMime);
                mCodecName = this.mEncoder.getName();
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.mMime, this.mWidth, this.mHeight);
                setProfileLevel(createVideoFormat, videoEncoderConfig);
                if (!setColorFormat(createVideoFormat, encoderInputMode)) {
                    deInit();
                } else {
                    createVideoFormat.setInteger(KsMediaMeta.KSM_KEY_BITRATE, this.mBps);
                    if (Build.VERSION.SDK_INT >= 21) {
                        createVideoFormat.setInteger("bitrate-mode", 2);
                    }
                    createVideoFormat.setInteger("frame-rate", this.mFps);
                    createVideoFormat.setInteger("i-frame-interval", 3);
                    setEncodeParamFromServer(createVideoFormat, videoEncoderConfig);
                    if (this.mLowDelay) {
                        createVideoFormat.setInteger("i-frame-interval", 1);
                    }
                    this.mStrFormat = createVideoFormat.toString();
                    YMFLog.info(this, "[Encoder ]", "MediaCodec format:" + this.mStrFormat);
                    this.mEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                    if (encoderInputMode == Constant.EncoderInputMode.SURFACE) {
                        this.mInputSurface = this.mEncoder.createInputSurface();
                    }
                    this.mBufferInfo = new MediaCodec.BufferInfo();
                    this.mEncoder.start();
                    this.mInitialized = true;
                    this.mFirstEncodedFrame = true;
                    this.mEncodedDeltaPts = 0L;
                    this.mListener = hardEncodeListner;
                    YMFLog.info(this, "[Encoder ]", "codec:" + mCodecName + " start success, level:" + this.mLevel + ", profile:" + this.mProfile + " inputMode:" + encoderInputMode + " colorFormat:" + MediaCodecUtil.colorFormatToName(this.mColorFormat));
                    YYVideoCodec.setCurrentEncodeName(mCodecName);
                    z = this.mInitialized;
                }
            }
        }
        return z;
    }

    public void deInit() {
        releaseEncoder();
    }

    public void recoverCachedPtsList(long j) {
        this.mCachedPtsList.addFirst(Long.valueOf(j));
    }

    private YMFImageBuffer selectImageBuffer(YYMediaSample yYMediaSample) {
        boolean isSemiPlanar = MediaCodecUtil.isSemiPlanar(this.mColorFormat);
        if (isSemiPlanar && yYMediaSample.mImageFormat != 1) {
            YMFLog.error(this, "[Encoder ]", "input image format:" + yYMediaSample.mImageFormat + " not match encoder color format:" + MediaCodecUtil.colorFormatToName(this.mColorFormat));
            return null;
        } else if (!isSemiPlanar && yYMediaSample.mImageFormat != 2) {
            YMFLog.error(this, "[Encoder ]", "input image format:" + yYMediaSample.mImageFormat + " not match encoder color format:" + MediaCodecUtil.colorFormatToName(this.mColorFormat));
            return null;
        } else {
            switch (yYMediaSample.mImageFormat) {
                case 1:
                    if (yYMediaSample.mNV12 == null || yYMediaSample.mNV12.mData == null) {
                        YMFLog.error(this, "[Encoder ]", "invalid NV12 image buffer for media codec.");
                        return null;
                    }
                    return yYMediaSample.mNV12;
                case 2:
                    if (yYMediaSample.mI420 == null || yYMediaSample.mI420.mData == null) {
                        YMFLog.error(this, "[Encoder ]", "invalid I420 image buffer for media codec.");
                        return null;
                    }
                    return yYMediaSample.mI420;
                default:
                    YMFLog.error(this, "[Encoder ]", "invalid YUV format for media codec:" + yYMediaSample.mImageFormat);
                    return null;
            }
        }
    }

    public void feedEncoder(YYMediaSample yYMediaSample) {
        int dequeueInputBuffer;
        if (!this.mInitialized) {
            YMFLog.info(this, "[Encoder ]", "feedEncoder but encoder not started, just return!");
            return;
        }
        YMFImageBuffer selectImageBuffer = selectImageBuffer(yYMediaSample);
        if (selectImageBuffer != null) {
            ByteBuffer[] inputBuffers = this.mEncoder.getInputBuffers();
            do {
                dequeueInputBuffer = this.mEncoder.dequeueInputBuffer(1000L);
            } while (dequeueInputBuffer < 0);
            ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
            byteBuffer.clear();
            if (byteBuffer.capacity() >= selectImageBuffer.mBufSize) {
                if (this.mYuvData == null || this.mYuvData.length != selectImageBuffer.mBufSize) {
                    this.mYuvData = new byte[selectImageBuffer.mBufSize];
                }
                selectImageBuffer.mData.rewind();
                selectImageBuffer.mData.get(this.mYuvData);
                byteBuffer.put(this.mYuvData);
                this.mEncoder.queueInputBuffer(dequeueInputBuffer, 0, selectImageBuffer.mBufSize, yYMediaSample.mYYPtsMillions * 1000, 0);
                return;
            }
            YMFLog.error(this, "[Encoder ]", "invalid data buffer size.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00af, code lost:
        if (r15.mHasEncodeData != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b1, code lost:
        r15.mListener.onNoEncodedDataOut();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drainEncoder(long j, boolean z) {
        int i;
        ByteBuffer[] byteBufferArr;
        try {
            if (!this.mInitialized) {
                YMFLog.info(this, "[Encoder ]", "drainEncoder but encoder not started, just return!");
            } else if (z) {
                this.mCachedPtsList.clear();
                this.mFirstEncodedFrame = true;
                if (this.mInputSurface != null) {
                    this.mEncoder.signalEndOfInputStream();
                    return;
                }
                int dequeueInputBuffer = this.mEncoder.dequeueInputBuffer(100L);
                if (dequeueInputBuffer >= 0) {
                    this.mEncoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                }
            } else {
                this.mCachedPtsList.add(Long.valueOf(j));
                this.mHasEncodeData = false;
                ByteBuffer[] outputBuffers = this.mEncoder.getOutputBuffers();
                int i2 = 0;
                while (true) {
                    int dequeueOutputBuffer = this.mEncoder.dequeueOutputBuffer(this.mBufferInfo, 100L);
                    if (dequeueOutputBuffer == -1) {
                        if (!z) {
                            if (!this.mLowDelay) {
                                break;
                            }
                            i = i2 + 1;
                            if (i2 > 400) {
                                break;
                            }
                            byteBufferArr = outputBuffers;
                        }
                        i = i2;
                        byteBufferArr = outputBuffers;
                    } else if (dequeueOutputBuffer == -3) {
                        byteBufferArr = this.mEncoder.getOutputBuffers();
                        i = i2;
                    } else {
                        if (dequeueOutputBuffer == -2) {
                            this.mMediaformat = this.mEncoder.getOutputFormat();
                            if (this.mListener != null) {
                                this.mListener.onEncoderFomratChanged(this.mMediaformat);
                                i = i2;
                                byteBufferArr = outputBuffers;
                            }
                        } else if (dequeueOutputBuffer >= 0) {
                            ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                            if (byteBuffer == null) {
                                throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                            }
                            byteBuffer.position(this.mBufferInfo.offset);
                            byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                            long j2 = this.mBufferInfo.presentationTimeUs / 1000;
                            YMFLiveStatisticManager.getInstance().endEncode(0, j2);
                            long j3 = 0;
                            if (this.mCachedPtsList.size() > 0) {
                                j3 = this.mCachedPtsList.pop().longValue();
                            }
                            if (j3 == 0) {
                                j3 = j2;
                            }
                            if ((this.mBufferInfo.flags & 2) != 0) {
                                if (this.mMediaformat == null) {
                                    this.mMediaformat = this.mEncoder.getOutputFormat();
                                }
                                this.mListener.onEncodedHeaderAvailableSample(byteBuffer, this.mBufferInfo, j3, j2, this.mMediaformat);
                                this.mBufferInfo.size = 0;
                            }
                            if (this.mBufferInfo.size != 0) {
                                if (this.mMediaformat == null) {
                                    this.mMediaformat = this.mEncoder.getOutputFormat();
                                }
                                if (this.mFirstEncodedFrame) {
                                    this.mFirstEncodedFrame = false;
                                    if (j2 != j3) {
                                        this.mEncodedDeltaPts = j3 - j2;
                                        YMFLog.info(this, "[Encoder ]", " mEncodedDeltaPts " + this.mEncodedDeltaPts);
                                    }
                                }
                                this.mListener.onEncodedDataAvailableSample(byteBuffer, this.mBufferInfo, j3, j2 + this.mEncodedDeltaPts, this.mMediaformat);
                                if (this.mLowDelay) {
                                    this.mHasEncodeData = true;
                                }
                            }
                            this.mEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                            if ((this.mBufferInfo.flags & 4) == 0) {
                                if (this.mLowDelay && this.mHasEncodeData) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            return;
                        }
                        i = i2;
                        byteBufferArr = outputBuffers;
                    }
                    i2 = i;
                    outputBuffers = byteBufferArr;
                }
            }
        } catch (Exception e) {
            deInit();
            UploadStatManager.getInstance().reportException("0", "1", e.toString());
            YMFLog.error(this, "[Encoder ]", "drainEncoder exception:" + e.toString());
            if (this.mListener != null) {
                this.mListener.onError(this.mEncodeId.get(), "1", e.toString());
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void setEncoderParams(MediaFormat mediaFormat, String str, String str2) {
        char c;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1228625131:
                if (str.equals("color-transfer")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1196879385:
                if (str.equals("color-standard")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1165461084:
                if (str.equals("priority")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -1086653437:
                if (str.equals("bitrate-mode")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -541084162:
                if (str.equals("complexity")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -309425751:
                if (str.equals(ConstantData.VideoLocationType.PERSON_PROFILE)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -271617982:
                if (str.equals("intra-refresh-period")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -108059053:
                if (str.equals("color-range")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 102865796:
                if (str.equals("level")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 376309611:
                if (str.equals("gop_duration")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1570203800:
                if (str.equals("repeat-previous-frame-after")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                YMFLog.info(this, "[Encoder ]", "MediaCodec set bitrate-mode:" + str2);
                if (Build.VERSION.SDK_INT >= 21) {
                    mediaFormat.setInteger("bitrate-mode", Integer.parseInt(str2));
                    return;
                }
                return;
            case 1:
                YMFLog.info(this, "[Encoder ]", "MediaCodec set color-range:" + str2);
                mediaFormat.setInteger("color-range", Integer.parseInt(str2));
                return;
            case 2:
                YMFLog.info(this, "[Encoder ]", "MediaCodec set color-standard:" + str2);
                mediaFormat.setInteger("color-standard", Integer.parseInt(str2));
                return;
            case 3:
                YMFLog.info(this, "[Encoder ]", "MediaCodec set color-transfer:" + str2);
                mediaFormat.setInteger("color-transfer", Integer.parseInt(str2));
                return;
            case 4:
                YMFLog.info(this, "[Encoder ]", "MediaCodec set complexity:" + str2);
                if (Build.VERSION.SDK_INT >= 21) {
                    mediaFormat.setInteger("complexity", Integer.parseInt(str2));
                    return;
                }
                return;
            case 5:
                YMFLog.info(this, "[Encoder ]", "MediaCodec set i-frame-interval:" + str2);
                mediaFormat.setInteger("i-frame-interval", Integer.parseInt(str2));
                return;
            case 6:
                YMFLog.info(this, "[Encoder ]", "MediaCodec set i-frame-interval:" + str2);
                mediaFormat.setInteger("intra-refresh-period", Integer.parseInt(str2));
                return;
            case 7:
                String lowerCase = str2.toLowerCase();
                switch (lowerCase.hashCode()) {
                    case -1820889799:
                        if (lowerCase.equals("extended")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1720785339:
                        if (lowerCase.equals("baseline")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1217395903:
                        if (lowerCase.equals("high10")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 3202466:
                        if (lowerCase.equals("high")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 3343801:
                        if (lowerCase.equals("main")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 915435666:
                        if (lowerCase.equals("high422")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 915435730:
                        if (lowerCase.equals("high444")) {
                            c2 = 6;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        YMFLog.info(this, "[Encoder ]", "MediaCodec set profile:Baseline");
                        if (Build.VERSION.SDK_INT >= 21) {
                            mediaFormat.setInteger(ConstantData.VideoLocationType.PERSON_PROFILE, 1);
                            return;
                        }
                        return;
                    case 1:
                        YMFLog.info(this, "[Encoder ]", "MediaCodec set profile:Main");
                        if (Build.VERSION.SDK_INT >= 21) {
                            mediaFormat.setInteger(ConstantData.VideoLocationType.PERSON_PROFILE, 2);
                            return;
                        }
                        return;
                    case 2:
                        YMFLog.info(this, "[Encoder ]", "MediaCodec set profile:Extended");
                        if (Build.VERSION.SDK_INT >= 21) {
                            mediaFormat.setInteger(ConstantData.VideoLocationType.PERSON_PROFILE, 4);
                            return;
                        }
                        return;
                    case 3:
                        YMFLog.info(this, "[Encoder ]", "MediaCodec set profile:High");
                        if (Build.VERSION.SDK_INT >= 21) {
                            mediaFormat.setInteger(ConstantData.VideoLocationType.PERSON_PROFILE, 8);
                            return;
                        }
                        return;
                    case 4:
                        YMFLog.info(this, "[Encoder ]", "MediaCodec set profile:High10");
                        if (Build.VERSION.SDK_INT >= 21) {
                            mediaFormat.setInteger(ConstantData.VideoLocationType.PERSON_PROFILE, 16);
                            return;
                        }
                        return;
                    case 5:
                        YMFLog.info(this, "[Encoder ]", "MediaCodec set profile:High422");
                        if (Build.VERSION.SDK_INT >= 21) {
                            mediaFormat.setInteger(ConstantData.VideoLocationType.PERSON_PROFILE, 32);
                            return;
                        }
                        return;
                    case 6:
                        YMFLog.info(this, "[Encoder ]", "MediaCodec set profile:High444");
                        if (Build.VERSION.SDK_INT >= 21) {
                            mediaFormat.setInteger(ConstantData.VideoLocationType.PERSON_PROFILE, 64);
                            return;
                        }
                        return;
                    default:
                        YMFLog.info(this, "[Encoder ]", "MediaCodec set profile:error keyword");
                        return;
                }
            case '\b':
                YMFLog.info(this, "[Encoder ]", "MediaCodec set level:" + str2);
                mediaFormat.setInteger("level", Integer.parseInt(str2));
                return;
            case '\t':
                YMFLog.info(this, "[Encoder ]", "MediaCodec set priority:" + str2);
                mediaFormat.setInteger("priority", Integer.parseInt(str2));
                return;
            case '\n':
                YMFLog.info(this, "[Encoder ]", "MediaCodec set repeat-previous-frame-after:" + str2);
                if (Build.VERSION.SDK_INT >= 19) {
                    mediaFormat.setInteger("repeat-previous-frame-after", Integer.parseInt(str2));
                    return;
                }
                return;
            default:
                YMFLog.info(this, "[Encoder ]", "unsupported params:" + str);
                return;
        }
    }

    public void adjustBitRate(int i) {
        if (this.mEncoder != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                int i2 = i * 1000;
                try {
                    Bundle bundle = new Bundle();
                    bundle.putInt("video-bitrate", i2);
                    this.mEncoder.setParameters(bundle);
                    YMFLog.info(this, "[Encoder ]", "succeed to adjustBitRate:" + i2);
                    return;
                } catch (Throwable th) {
                    YMFLog.error(this, "[Encoder ]", "adjustBitRate exception:" + th.toString());
                    return;
                }
            }
            YMFLog.error(this, "[Encoder ]", "adjustBitRate is only available on Android API 19+");
        }
    }

    public void requestSyncFrame() {
        if (this.mEncoder != null && this.mInitialized) {
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putInt("request-sync", 0);
                    this.mEncoder.setParameters(bundle);
                    YMFLog.info(this, "[Encoder ]", "requestSyncFrame");
                    return;
                } catch (Throwable th) {
                    YMFLog.error(this, "[Encoder ]", "requestSyncFrame exception:" + th.toString());
                    return;
                }
            }
            YMFLog.warn(this, "[Encoder ]", "requestSyncFrame is only available on Android API 19+");
        }
    }

    public String getFormat() {
        return this.mStrFormat;
    }

    public static String getCodecName() {
        return mCodecName;
    }

    public boolean getCacheEncodedData() {
        int dequeueInputBuffer;
        boolean z;
        ByteBuffer[] byteBufferArr;
        int i;
        boolean z2 = false;
        try {
            if (!this.mInitialized) {
                YMFLog.info(this, "[Encoder ]", "drainEncoder but encoder not started, just return!");
                return false;
            }
            int i2 = 3;
            if (!this.mEofFlag && this.mInputSurface != null) {
                this.mEncoder.signalEndOfInputStream();
                this.mEofFlag = true;
            } else if (!this.mEofFlag && this.mInputSurface == null && (dequeueInputBuffer = this.mEncoder.dequeueInputBuffer(100L)) >= 0) {
                this.mEncoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                this.mEofFlag = true;
            }
            this.mHasEncodeData = false;
            ByteBuffer[] outputBuffers = this.mEncoder.getOutputBuffers();
            while (true) {
                int dequeueOutputBuffer = this.mEncoder.dequeueOutputBuffer(this.mBufferInfo, 100L);
                if (dequeueOutputBuffer == -1) {
                    i = i2 - 1;
                    if (i2 != 0) {
                        YMFLog.warn(this, "[Encoder ]", "getCacheEncodedData INFO_TRY_AGAIN_LATER!");
                        byteBufferArr = outputBuffers;
                        z = z2;
                    } else {
                        return z2;
                    }
                } else if (dequeueOutputBuffer == -3) {
                    byteBufferArr = this.mEncoder.getOutputBuffers();
                    i = i2;
                    z = z2;
                } else if (dequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.mEncoder.getOutputFormat();
                    if (this.mListener != null) {
                        this.mListener.onEncoderFomratChanged(outputFormat);
                    }
                    byteBufferArr = outputBuffers;
                    i = i2;
                    z = z2;
                } else if (dequeueOutputBuffer == 4) {
                    YMFLog.error(this, "[Encoder ]", "input frame:BUFFER_FLAG_END_OF_STREAM" + this.mCachedPtsList.size());
                    return z2;
                } else if (dequeueOutputBuffer >= 0) {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                    }
                    byteBuffer.position(this.mBufferInfo.offset);
                    byteBuffer.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
                    YMFLiveStatisticManager.getInstance().endEncode(0, this.mBufferInfo.presentationTimeUs / 1000);
                    long j = this.mBufferInfo.presentationTimeUs / 1000;
                    long j2 = 0;
                    if (this.mCachedPtsList.size() > 0) {
                        j2 = this.mCachedPtsList.pop().longValue();
                    }
                    if (j2 == 0) {
                        j2 = j;
                    }
                    if ((this.mBufferInfo.flags & 2) != 0) {
                        this.mListener.onEncodedHeaderAvailableSample(byteBuffer, this.mBufferInfo, j2, j, this.mEncoder.getOutputFormat());
                        this.mBufferInfo.size = 0;
                    }
                    if (this.mBufferInfo.size != 0) {
                        YMFLog.info(this, "[Encoder ]", "getCacheEncodedData pts:" + j + PerfFrameTrackUIUtil.SEPERATOR_ARROR + this.mCachedPtsList.size());
                        this.mListener.onEncodedDataAvailableSample(byteBuffer, this.mBufferInfo, j2, j + this.mEncodedDeltaPts, this.mEncoder.getOutputFormat());
                        z = true;
                    } else {
                        z = z2;
                    }
                    try {
                        this.mEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((this.mBufferInfo.flags & 4) != 0) {
                            YMFLog.info(this, "[Encoder ]", "out: BUFFER_FLAG_END_OF_STREAM:" + this.mCachedPtsList.size());
                            return false;
                        } else if (this.mLowDelay && this.mHasEncodeData) {
                            return z;
                        } else {
                            byteBufferArr = outputBuffers;
                            i = i2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        z2 = z;
                        deInit();
                        UploadStatManager.getInstance().reportException("0", "1", th.toString());
                        YMFLog.error(this, "[Encoder ]", "getCacheEncodedData exception:" + th.toString());
                        if (this.mListener != null) {
                            this.mListener.onError(this.mEncodeId.get(), "1", th.toString());
                            return z2;
                        }
                        return z2;
                    }
                } else {
                    return z2;
                }
                outputBuffers = byteBufferArr;
                i2 = i;
                z2 = z;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean awaitUninterruptibly(CountDownLatch countDownLatch, long j) {
        boolean z = false;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z2 = false;
        long j2 = j;
        do {
            try {
                z = countDownLatch.await(j2, TimeUnit.MILLISECONDS);
                break;
            } catch (InterruptedException e) {
                z2 = true;
                j2 = j - (SystemClock.elapsedRealtime() - elapsedRealtime);
                if (j2 <= 0) {
                }
            }
        } while (j2 <= 0);
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return z;
    }

    private void releaseEncoder() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() { // from class: com.yy.mediaframework.encoder.HardSurfaceEncoder.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    YMFLog.info(this, "[Encoder ]", "releaseEncoder begin");
                    if (HardSurfaceEncoder.this.mEncoder != null) {
                        HardSurfaceEncoder.this.mInitialized = false;
                        HardSurfaceEncoder.this.mEncoder.stop();
                    }
                    if (HardSurfaceEncoder.this.mEncoder != null) {
                        HardSurfaceEncoder.this.mEncoder.release();
                    }
                    countDownLatch.countDown();
                    YMFLog.info(this, "[Encoder ]", "releaseEncoder done");
                    HardSurfaceEncoder.this.mEncoder = null;
                    HardSurfaceEncoder.this.mMediaformat = null;
                }
            }
        }).start();
        YMFLog.error(this, "[Encoder ]", "releaseEncoder thread start!");
        if (!awaitUninterruptibly(countDownLatch, 2000L)) {
            YMFLog.error(this, "[Encoder ]", "releaseEncoder Block in :2000ms");
            if (this.mListener != null) {
                this.mListener.onError(this.mEncodeId.get(), "6", "Blocked");
                return;
            }
            return;
        }
        YMFLog.error(this, "[Encoder ]", "releaseEncoder end!");
    }
}
