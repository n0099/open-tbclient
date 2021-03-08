package com.yy.videoplayer.decoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.SystemClock;
import android.view.Surface;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.yy.videoplayer.VideoPlayer;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.stat.YMFPlayerUsrBehaviorStat;
import com.yy.videoplayer.utils.YMFLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class HardDecRender {
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 4000;
    private static final String TAG = "HardDecRender";
    protected String mCrashTsFirst;
    protected String mCrashTsSecond;
    protected MediaFormat mFormat;
    protected MediaCodec.BufferInfo mInfo;
    protected ByteBuffer[] mInputBuffers;
    private OnDecoderYUVListener mOnDecoderYUVListener;
    protected ByteBuffer[] mOutputBuffers;
    protected AtomicBoolean mSecondTsWriten;
    protected Surface mSurface;
    protected MediaCodec mDecoder = null;
    protected boolean mNeedConfig = true;
    protected int mWidth = 720;
    protected int mHeight = 1280;
    protected int mStride = 720;
    protected boolean mInitialized = false;
    protected int mNoFrameCnt = 0;
    protected boolean mIsExceptionOccured = false;
    protected long mStreamId = 0;
    protected long mGroupId = 0;
    protected AtomicBoolean mMediaCodecStopState = new AtomicBoolean(false);
    protected byte[] mDumpSpsPps = null;
    protected byte[] mDumpIDRFrame = null;
    protected String mDumpFrameName = null;
    private long mLastInputPts = -1;
    private long mLastOutputPts = -1;
    private long mOutFrameNum = -1;
    protected int mInputIndex = 0;
    private long mNoFrameCount = 0;
    private int mColorFormat = 0;
    private HashMap<String, Object> mDecoderInfoMap = new HashMap<>();
    private HashMap<Long, VideoConstant.ExtraData> mLayoutInfoMap = new HashMap<>();
    final Object mForceFlushLock = new Object();
    private boolean mFirstDecodedDataOut = false;
    private IDecoderDataOutCallBack decoderDataOutCallBack = null;
    private boolean mEndOfStream = false;

    /* loaded from: classes6.dex */
    public interface IDecoderDataOutCallBack {
        void onFirstDecodedDataOut();
    }

    /* loaded from: classes6.dex */
    public static class MediaCodecErrorType {
        public static final int MEDIA_CODEC_DECODING_ERROR = 2;
        public static final int MEDIA_CODEC_INIT_ERROR = 1;
        public static final int MEDIA_CODEC_QUEUEINPUTBUFFER_ERROR = 4;
        public static final int MEDIA_CODEC_RESET_ERROR = 0;
        public static final int MEDIA_CODEC_STOP_BLOCK_ERROR = 3;
    }

    /* loaded from: classes6.dex */
    public interface OnDecoderYUVListener {
        void OnDecoderYUVListener(int i, int i2, ByteBuffer byteBuffer, int i3, VideoConstant.ExtraData extraData, long j, int i4, int i5, MediaFormat mediaFormat);
    }

    public abstract long PushFrame(Surface surface, byte[] bArr, VideoConstant.ExtraData extraData, long j, boolean z);

    public abstract int reset();

    public abstract int reset(Surface surface, int i, int i2);

    public boolean IsNeedConfig() {
        return this.mNeedConfig;
    }

    public void ConfigDone() {
        synchronized (this) {
            this.mNeedConfig = false;
        }
    }

    public AtomicBoolean getMediaCodecStopState() {
        return this.mMediaCodecStopState;
    }

    public void EndofStream() {
        this.mNoFrameCnt = 0;
    }

    public boolean GetAndClearExceptionFlag() {
        boolean z = this.mIsExceptionOccured;
        this.mIsExceptionOccured = false;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean IsAvailable(String str) {
        return Build.VERSION.SDK_INT >= 17 && str != null;
    }

    protected void dumpIDRFrame(String str, byte[] bArr, long j) {
        this.mDumpIDRFrame = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.mDumpIDRFrame, 0, bArr.length);
        this.mDumpFrameName = (str.equalsIgnoreCase("video/avc") ? "H264" : "H265") + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + j;
        YMFLog.error(this, "[Decoder ]", "IDRFrame direct decoded!");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b6, code lost:
        r12 = r19.mInfo.presentationTimeUs / 1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c1, code lost:
        r19.mNoFrameCnt = 0;
        r19.mLastOutputPts = r12;
        r19.mOutFrameNum++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d9, code lost:
        if (r19.mInputIndex != 1) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00db, code lost:
        dumpIDRFrame(r21, r22, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00e4, code lost:
        r9 = r19.mOutputBuffers[r17];
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f6, code lost:
        if (r19.mLayoutInfoMap.containsKey(java.lang.Long.valueOf(r12)) == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0104, code lost:
        if (r19.mLayoutInfoMap.get(java.lang.Long.valueOf(r12)) == null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0118, code lost:
        if (r19.mLayoutInfoMap.get(java.lang.Long.valueOf(r12)).layouts.length < 4) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x011a, code lost:
        r19.mLayoutInfoMap.remove(java.lang.Long.valueOf(r12));
        r11 = r19.mLayoutInfoMap.get(java.lang.Long.valueOf(r12));
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0134, code lost:
        r19.mOnDecoderYUVListener.OnDecoderYUVListener(r19.mWidth, r19.mHeight, r9, r19.mInfo.size, r11, r12, r19.mInfo.flags, r19.mColorFormat, r19.mFormat);
        r19.mDecoder.releaseOutputBuffer(r17, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01d2, code lost:
        r19.mNoFrameCnt++;
        r19.mIsExceptionOccured = true;
        com.yy.videoplayer.stat.YMFPlayerUsrBehaviorStat.getInstance().notifyPlayerException("pushFrame_codec_" + r20);
        com.yy.videoplayer.utils.YMFLog.error(r19, "[Decoder ]", "HardDecRender PushFrame exception " + com.yy.videoplayer.utils.YMFLog.stackTraceOf(r4));
        com.yy.videoplayer.decoder.YYVideoLibMgr.instance().onHardwareDecodeErrorNotify(r19.mGroupId, r19.mStreamId, 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x022e, code lost:
        r5 = r11;
        r12 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x03a6, code lost:
        r4 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x03a7, code lost:
        r11 = r5;
        r14 = r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0165 A[Catch: all -> 0x0023, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:6:0x0009, B:7:0x0010, B:10:0x0014, B:11:0x0021, B:16:0x0026, B:18:0x002c, B:19:0x0046, B:21:0x0052, B:22:0x0069, B:24:0x0076, B:26:0x0086, B:48:0x01b4, B:27:0x00a6, B:29:0x00b6, B:31:0x00c1, B:33:0x00db, B:34:0x00e4, B:36:0x00f8, B:38:0x0106, B:40:0x011a, B:41:0x0134, B:43:0x0165, B:44:0x01a1, B:52:0x01d2, B:56:0x0237, B:59:0x0255, B:61:0x0272, B:62:0x02a1, B:65:0x0333, B:67:0x0345, B:68:0x0375, B:69:0x0398, B:46:0x01a5), top: B:74:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long PushFrameWithoutSurface(String str, String str2, byte[] bArr, VideoConstant.ExtraData extraData, long j, boolean z) {
        int i;
        long j2;
        synchronized (this) {
            if (this.mNeedConfig && !z) {
                this.mIsExceptionOccured = true;
                return 0L;
            } else if (bArr == null) {
                YMFLog.error(this, "[Decoder ]", "HardDecRender  bf is null!!!");
                return 0L;
            } else {
                if (!this.mInitialized) {
                    reset(this.mSurface, str, str2, this.mWidth, this.mHeight);
                    this.mIsExceptionOccured = true;
                }
                long j3 = 0;
                VideoConstant.ExtraData extraData2 = null;
                this.mLastInputPts = j;
                if (z) {
                    this.mDumpSpsPps = new byte[bArr.length];
                    System.arraycopy(bArr, 0, this.mDumpSpsPps, 0, bArr.length);
                } else {
                    this.mLayoutInfoMap.put(Long.valueOf(j), extraData);
                }
                try {
                    i = this.mDecoder.dequeueInputBuffer(500000L);
                    if (i >= 0) {
                        ByteBuffer byteBuffer = this.mInputBuffers[i];
                        byteBuffer.clear();
                        byteBuffer.put(bArr);
                        if (z) {
                            YMFLog.info(this, "[Decoder ]", "HardDecRender PushFrame config video");
                            this.mDecoder.queueInputBuffer(i, 0, bArr.length, 1000 * j, 2);
                            this.mInputIndex = 0;
                        } else {
                            this.mDecoder.queueInputBuffer(i, 0, bArr.length, 1000 * j, 0);
                            this.mInputIndex++;
                        }
                    }
                    while (true) {
                        int dequeueOutputBuffer = this.mDecoder.dequeueOutputBuffer(this.mInfo, 0L);
                        if (dequeueOutputBuffer >= 0) {
                            break;
                        } else if (dequeueOutputBuffer == -3) {
                            this.mOutputBuffers = this.mDecoder.getOutputBuffers();
                            YMFLog.info(this, "[Decoder ]", "HardDecRender PushFrame INFO_OUTPUT_BUFFERS_CHANGED");
                        } else if (dequeueOutputBuffer == -2) {
                            this.mFormat = this.mDecoder.getOutputFormat();
                            int integer = this.mFormat.getInteger("color-format");
                            if (this.mColorFormat != integer) {
                                YMFLog.warn(this, "[Decoder ]", "FORMAT change " + this.mColorFormat + ">" + integer);
                                this.mColorFormat = integer;
                            }
                            this.mWidth = this.mFormat.getInteger("width");
                            this.mHeight = this.mFormat.getInteger("height");
                            this.mStride = this.mFormat.getInteger("stride");
                            VideoPlayer.getInstance().getPlayerInfo(this.mStreamId, VideoPlayer.VideoPlayerInfoEnum.RESOLUTION);
                            YMFLog.info(this, "[Decoder ]", "HardDecRender PushFrame INFO_OUTPUT_FORMAT_CHANGED format " + this.mDecoder.getOutputFormat() + " width " + this.mWidth + " height " + this.mHeight + " mStride " + this.mStride);
                        } else if (dequeueOutputBuffer == -1) {
                            this.mNoFrameCnt++;
                            if (this.mNoFrameCnt % 100 == 0) {
                                YMFLog.error(this, "[Decoder ]", "HardDecRender PushFrame noFrameCnt " + this.mNoFrameCnt);
                                YYVideoLibMgr.instance().onHardwareDecodeErrorNotify(this.mGroupId, this.mStreamId, 1);
                            }
                            YMFLog.info(this, "[Decoder ]", "HardDecRender PushFrame INFO_TRY_AGAIN_LATER, no frame count:" + this.mNoFrameCnt);
                            j2 = 0;
                        } else {
                            YMFLog.info(this, "[Decoder ]", "HardDecRender...");
                            j2 = 0;
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    int i2 = -1;
                }
                if (i < 0) {
                    YMFLog.warn(this, "[Decoder ]", "HardDecRender PushFrame will skip current frame pts:" + j + " size:" + bArr.length);
                    YYVideoLibMgr.instance().onHardwareDecodeErrorNotify(this.mGroupId, this.mStreamId, 2);
                }
                return j2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a8, code lost:
        if (r14.mFirstDecodedDataOut != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ac, code lost:
        if (r14.decoderDataOutCallBack == null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ae, code lost:
        r14.mFirstDecodedDataOut = true;
        r14.decoderDataOutCallBack.onFirstDecodedDataOut();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b6, code lost:
        r14.mDecoder.releaseOutputBuffer(r2, true);
        r4 = r14.mInfo.presentationTimeUs / 1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c4, code lost:
        r14.mNoFrameCnt = 0;
        r14.mLastOutputPts = r4;
        r14.mOutFrameNum++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d2, code lost:
        if (r14.mInputIndex != 1) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d4, code lost:
        dumpIDRFrame(r17, r18, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0130, code lost:
        r14.mNoFrameCnt++;
        r14.mIsExceptionOccured = true;
        com.yy.videoplayer.stat.YMFPlayerUsrBehaviorStat.getInstance().notifyPlayerException("pushFrame_codec_" + r16);
        com.yy.videoplayer.utils.YMFLog.error(r14, "[Decoder ]", "HardDecRender PushFrame exception:" + com.yy.videoplayer.utils.YMFLog.stackTraceOf(r2));
        com.yy.videoplayer.decoder.YYVideoLibMgr.instance().onHardwareDecodeErrorNotify(r14.mGroupId, r14.mStreamId, 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0180, code lost:
        r3 = r9;
        r10 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x025c, code lost:
        r2 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x025d, code lost:
        r9 = r3;
        r12 = r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00de A[Catch: all -> 0x0022, TRY_ENTER, TryCatch #1 {, blocks: (B:6:0x0015, B:9:0x001b, B:10:0x0020, B:16:0x0027, B:17:0x0032, B:19:0x0034, B:21:0x003a, B:22:0x004b, B:24:0x0054, B:25:0x0067, B:27:0x0072, B:29:0x0080, B:47:0x0118, B:30:0x009a, B:32:0x00a6, B:34:0x00aa, B:36:0x00ae, B:37:0x00b6, B:39:0x00c4, B:41:0x00d4, B:44:0x00de, B:45:0x0114, B:51:0x0130, B:55:0x0187, B:58:0x0195, B:61:0x01fd, B:63:0x0209, B:64:0x0231, B:65:0x0250), top: B:70:0x0015 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long PushFrame(Surface surface, String str, String str2, byte[] bArr, VideoConstant.ExtraData extraData, long j, boolean z) {
        int i;
        long j2;
        long j3;
        if (surface == null) {
            return PushFrameWithoutSurface(str, str2, bArr, extraData, j, z);
        }
        synchronized (this) {
            if (this.mNeedConfig && !z) {
                this.mIsExceptionOccured = true;
                return 0L;
            } else if (bArr == null) {
                YMFLog.error(this, "[Decoder ]", "HardDecRender  bf is null!!!");
                return 0L;
            } else {
                this.mSurface = surface;
                if (!this.mInitialized) {
                    reset(this.mSurface, str, str2, this.mWidth, this.mHeight);
                    this.mIsExceptionOccured = true;
                }
                long j4 = 0;
                this.mLastInputPts = j;
                if (z) {
                    this.mDumpSpsPps = new byte[bArr.length];
                    System.arraycopy(bArr, 0, this.mDumpSpsPps, 0, bArr.length);
                }
                try {
                    i = this.mDecoder.dequeueInputBuffer(200000L);
                    if (i >= 0) {
                        ByteBuffer byteBuffer = this.mInputBuffers[i];
                        byteBuffer.clear();
                        byteBuffer.put(bArr);
                        if (z) {
                            YMFLog.info(this, "[Decoder ]", "HardDecRender PushFrame config video");
                            this.mDecoder.queueInputBuffer(i, 0, bArr.length, 1000 * j, 2);
                            this.mInputIndex = 0;
                        } else {
                            this.mDecoder.queueInputBuffer(i, 0, bArr.length, 1000 * j, 0);
                            this.mInputIndex++;
                        }
                    }
                    while (true) {
                        int dequeueOutputBuffer = this.mDecoder.dequeueOutputBuffer(this.mInfo, 0L);
                        if (dequeueOutputBuffer >= 0) {
                            break;
                        } else if (dequeueOutputBuffer == -3) {
                            YMFLog.info(this, "[Decoder ]", "HardDecRender PushFrame INFO_OUTPUT_BUFFERS_CHANGED");
                        } else if (dequeueOutputBuffer == -2) {
                            this.mFormat = this.mDecoder.getOutputFormat();
                            this.mWidth = this.mFormat.getInteger("width");
                            this.mHeight = this.mFormat.getInteger("height");
                            VideoPlayer.getInstance().getPlayerInfo(this.mStreamId, VideoPlayer.VideoPlayerInfoEnum.RESOLUTION);
                            YMFLog.info(this, "[Decoder ]", "HardDecRender PushFrame INFO_OUTPUT_FORMAT_CHANGED format " + this.mDecoder.getOutputFormat() + " width " + this.mWidth + " height " + this.mHeight);
                        } else if (dequeueOutputBuffer == -1) {
                            this.mNoFrameCnt++;
                            if (this.mNoFrameCnt % 100 == 0) {
                                YMFLog.error(this, "[Decoder ]", "HardDecRender PushFrame noFrameCnt " + this.mNoFrameCnt);
                                YYVideoLibMgr.instance().onHardwareDecodeErrorNotify(this.mGroupId, this.mStreamId, 1);
                            }
                            YMFLog.info(this, "[Decoder ]", "HardDecRender PushFrame INFO_TRY_AGAIN_LATER, no frame count:" + this.mNoFrameCnt);
                            j3 = 0;
                        } else {
                            YMFLog.info(this, "[Decoder ]", "HardDecRender...");
                            j3 = 0;
                        }
                    }
                    j2 = j3;
                } catch (Exception e) {
                    e = e;
                    int i2 = -1;
                }
                if (i < 0) {
                    YMFLog.warn(this, "[Decoder ]", "HardDecRender PushFrame will skip current frame pts:" + j + " size:" + bArr.length);
                    YYVideoLibMgr.instance().onHardwareDecodeErrorNotify(this.mGroupId, this.mStreamId, 2);
                }
                return j2;
            }
        }
    }

    private int resetWithoutSurface(String str, String str2, int i, int i2) {
        int i3;
        synchronized (this) {
            try {
            } catch (Exception e) {
                YMFLog.error(this, "[Decoder ]", "HardDecRender reset codec:" + str + " exception:" + e.getMessage());
                YMFPlayerUsrBehaviorStat.getInstance().notifyPlayerException("reset_codec_" + str);
                YYVideoLibMgr.instance().onHardwareDecodeErrorNotify(this.mGroupId, this.mStreamId, 0);
            }
            if (!IsAvailable(str)) {
                YMFLog.error(this, "[Decoder ]", "HardDecRender reset codecType:" + str2 + " codecName:" + str + " hardware decoder is not available");
                i3 = -1;
            } else {
                release();
                YMFLog.info(this, "[Decoder ]", "HardDecRender reset");
                this.mWidth = i;
                this.mHeight = i2;
                VideoPlayer.getInstance().getPlayerInfo(this.mStreamId, VideoPlayer.VideoPlayerInfoEnum.RESOLUTION);
                this.mFormat = MediaFormat.createVideoFormat(str2, this.mWidth, this.mHeight);
                if (str != null && !str.isEmpty()) {
                    this.mDecoder = MediaCodec.createByCodecName(str);
                } else {
                    this.mDecoder = MediaCodec.createDecoderByType(str2);
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    MediaCodecInfo.CodecCapabilities capabilitiesForType = this.mDecoder.getCodecInfo().getCapabilitiesForType(str2);
                    this.mColorFormat = 0;
                    int i4 = 0;
                    int[] iArr = capabilitiesForType.colorFormats;
                    int length = iArr.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        int i6 = iArr[i5];
                        if (i6 == 19) {
                            this.mColorFormat = 19;
                            break;
                        }
                        if (i6 == 21) {
                            i4 = 21;
                        }
                        YMFLog.info(this, "[Decoder ]", "color-format:" + i6);
                        i5++;
                    }
                    if (this.mColorFormat == 0) {
                        this.mColorFormat = i4;
                    }
                    this.mFormat.setInteger("color-format", this.mColorFormat);
                    YMFLog.info(this, "[Decoder ]", "used color-format:" + this.mColorFormat);
                }
                this.mDecoder.configure(this.mFormat, (Surface) null, (MediaCrypto) null, 0);
                this.mDecoder.start();
                this.mInputBuffers = this.mDecoder.getInputBuffers();
                this.mOutputBuffers = this.mDecoder.getOutputBuffers();
                this.mInfo = new MediaCodec.BufferInfo();
                this.mInitialized = true;
                this.mNeedConfig = true;
                this.mFirstDecodedDataOut = false;
                this.mEndOfStream = false;
                this.mLayoutInfoMap.clear();
                YMFLog.info(this, "[Decoder ]", "HardDecRender reset create yuv codec:" + str + " start success.");
                if (!this.mInitialized) {
                    i3 = -1;
                } else {
                    i3 = 0;
                }
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int reset(Surface surface, String str, String str2, int i, int i2) {
        if (surface == null) {
            return resetWithoutSurface(str, str2, i, i2);
        }
        synchronized (this) {
            try {
            } catch (Exception e) {
                YMFLog.error(this, "[Decoder ]", "HardDecRender reset codec:" + str + " exception:" + e.getMessage());
                YMFPlayerUsrBehaviorStat.getInstance().notifyPlayerException("reset_codec_" + str);
                YYVideoLibMgr.instance().onHardwareDecodeErrorNotify(this.mGroupId, this.mStreamId, 0);
            }
            if (!IsAvailable(str)) {
                YMFLog.error(this, "[Decoder ]", "HardDecRender reset codecType:" + str2 + " codecName:" + str + " hardware decoder is not available");
                return -1;
            }
            release();
            YMFLog.info(this, "[Decoder ]", "HardDecRender reset");
            this.mWidth = i;
            this.mHeight = i2;
            VideoPlayer.getInstance().getPlayerInfo(this.mStreamId, VideoPlayer.VideoPlayerInfoEnum.RESOLUTION);
            this.mSurface = surface;
            this.mFormat = MediaFormat.createVideoFormat(str2, this.mWidth, this.mHeight);
            if (str != null && !str.isEmpty()) {
                this.mDecoder = MediaCodec.createByCodecName(str);
            } else {
                this.mDecoder = MediaCodec.createDecoderByType(str2);
            }
            this.mDecoder.configure(this.mFormat, this.mSurface, (MediaCrypto) null, 0);
            this.mDecoder.start();
            this.mInputBuffers = this.mDecoder.getInputBuffers();
            this.mInfo = new MediaCodec.BufferInfo();
            this.mInitialized = true;
            this.mNeedConfig = true;
            this.mFirstDecodedDataOut = false;
            this.mEndOfStream = false;
            YMFLog.info(this, "[Decoder ]", "HardDecRender reset create codec:" + str + " start success.");
            return !this.mInitialized ? -1 : 0;
        }
    }

    private void UnBlockingForceFlush() {
        Thread thread = new Thread(new Runnable() { // from class: com.yy.videoplayer.decoder.HardDecRender.1
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [481=5] */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
            /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HardDecRender.this.mDecoder.flush();
                    YMFLog.info(this, "[Decoder ]", "UnBlockingForceFlush flushed normally");
                    synchronized (HardDecRender.this.mForceFlushLock) {
                        HardDecRender.this.mForceFlushLock.notifyAll();
                    }
                } catch (Throwable th) {
                    try {
                        YMFLog.error(this, "[Decoder ]", "UnBlockingForceFlush flushed with errors, maybe blocked, exception:" + th.getMessage());
                        synchronized (HardDecRender.this.mForceFlushLock) {
                            HardDecRender.this.mForceFlushLock.notifyAll();
                        }
                    } catch (Throwable th2) {
                        synchronized (HardDecRender.this.mForceFlushLock) {
                            HardDecRender.this.mForceFlushLock.notifyAll();
                            throw th2;
                        }
                    }
                }
            }
        }, "YY_yylivesdk_HardDecRenderForceFlush_Thread");
        try {
            synchronized (this.mForceFlushLock) {
                thread.start();
                this.mForceFlushLock.wait(1000L);
                thread.interrupt();
            }
        } catch (Throwable th) {
            YMFLog.error(this, "[Decoder ]", "UnBlockingForceFlush thread start exception:" + th.getMessage());
        }
    }

    public void release() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread thread = new Thread(new Runnable() { // from class: com.yy.videoplayer.decoder.HardDecRender.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    YMFLog.info(this, "[Decoder ]", "begin stop mediacodec:" + HardDecRender.this.mDecoder + "LastOutputPts:" + HardDecRender.this.mLastInputPts + "/" + HardDecRender.this.mLastOutputPts + " num:" + HardDecRender.this.mInputIndex + "/" + HardDecRender.this.mOutFrameNum);
                    if (HardDecRender.this.mDecoder != null) {
                        HardDecRender.this.mInitialized = false;
                        HardDecRender.this.mDecoder.stop();
                        HardDecRender.this.mInputBuffers = null;
                    }
                    if (HardDecRender.this.mDecoder != null) {
                        try {
                            HardDecRender.this.mDecoder.release();
                            HardDecRender.this.mDecoder = null;
                        } catch (Exception e) {
                            YMFLog.error(this, "[Decoder ]", "HardDecRender decoder release exception:" + YMFLog.stackTraceOf(e));
                        }
                    }
                    countDownLatch.countDown();
                    YMFLog.info(this, "[Decoder ]", "release mediacodec done");
                }
            }
        }, "YMF_StopDecoderThread");
        thread.start();
        YMFLog.error(this, "[Decoder ]", "release mediacodec thread start!");
        if (!awaitUninterruptibly(thread, countDownLatch, 4000L)) {
            YYVideoLibMgr.instance().onHardwareDecodeErrorNotify(this.mGroupId, this.mStreamId, 3);
        } else {
            YMFLog.error(this, "[Decoder ]", "release mediacodec success!");
        }
    }

    public static boolean awaitUninterruptibly(Thread thread, CountDownLatch countDownLatch, long j) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public static String findCodecName(String str, String[] strArr, String[] strArr2, boolean z) {
        YMFLog.info(null, "[Decoder ]", "findCodecName mime:" + str + " supportedPrefixes:" + Arrays.toString(strArr) + " unSupportedPrefixes:" + Arrays.toString(strArr2) + " isIgnoreCodecWhiteList:" + z);
        if (Build.VERSION.SDK_INT < 16) {
            YMFLog.error((Object) null, "[Decoder ]", "findCodecName failed!! SDK version:" + Build.VERSION.SDK_INT);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (int codecCount = MediaCodecList.getCodecCount() - 1; codecCount >= 0; codecCount--) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(codecCount);
            if (!codecInfoAt.isEncoder() && isSupportMime(codecInfoAt, str) && !isDisabledCodec(codecInfoAt.getName())) {
                arrayList.add(codecInfoAt.getName());
            }
        }
        for (String str2 : arrayList) {
            int i = 0;
            while (i < strArr2.length && !str2.startsWith(strArr2[i])) {
                i++;
            }
            if (i >= strArr2.length) {
                for (String str3 : strArr) {
                    if (str2.startsWith(str3)) {
                        YMFLog.info(null, "[Decoder ]", "findCodecName codecName:" + str2);
                        return str2;
                    }
                }
                continue;
            }
        }
        if (z) {
            if (arrayList.size() == 0) {
                YMFLog.error((Object) null, "[Decoder ]", "findCodecName failed!! codecNames empty!");
                return null;
            }
            String str4 = (String) arrayList.get(arrayList.size() - 1);
            YMFLog.info(null, "[Decoder ]", "findCodecName codecName:" + str4);
            return str4;
        }
        return null;
    }

    private static boolean isDisabledCodec(String str) {
        return str.startsWith("OMX.google.") || str.startsWith("OMX.PV.") || str.startsWith("OMX.ittiam") || str.endsWith(".sw.dec") || !str.startsWith("OMX.");
    }

    private static boolean isSupportMime(MediaCodecInfo mediaCodecInfo, String str) {
        for (String str2 : mediaCodecInfo.getSupportedTypes()) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    public void setStreamId(long j) {
        this.mStreamId = j;
    }

    public void setGroupId(long j) {
        this.mGroupId = j;
    }

    public void setDecoderDataOutCallBack(IDecoderDataOutCallBack iDecoderDataOutCallBack) {
        this.decoderDataOutCallBack = iDecoderDataOutCallBack;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:
        r11.mDecoder.releaseOutputBuffer(r1, true);
        r0 = r11.mInfo.presentationTimeUs / 1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
        r11.mNoFrameCnt = 0;
        r11.mLastOutputPts = r0;
        r11.mOutFrameNum++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
        if (r11.mInfo.flags != 4) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006d, code lost:
        com.yy.videoplayer.utils.YMFLog.info(r11, "[Decoder ]", "getCacheFrame flags BUFFER_FLAG_END_OF_STREAM " + r11.mLastOutputPts);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0089, code lost:
        com.yy.videoplayer.utils.YMFLog.info(r11, "[Decoder ]", "getCacheFrame outPts " + r0 + " flag:" + r11.mInfo.flags);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c9, code lost:
        r11.mNoFrameCnt++;
        r11.mIsExceptionOccured = true;
        com.yy.videoplayer.utils.YMFLog.error(r11, "[Decoder ]", "getCacheFrame exception:" + com.yy.videoplayer.utils.YMFLog.stackTraceOf(r2));
        com.yy.videoplayer.decoder.YYVideoLibMgr.instance().onHardwareDecodeErrorNotify(r11.mGroupId, r11.mStreamId, 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01b7, code lost:
        r2 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01b8, code lost:
        r8 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getCacheFrame() {
        long j;
        long j2 = 0;
        synchronized (this) {
            if (this.mNeedConfig && !this.mInitialized) {
                this.mIsExceptionOccured = true;
                YMFLog.info(this, "[Decoder ]", "getCacheFrame mNeedConfig");
            } else {
                try {
                    int dequeueInputBuffer = this.mDecoder.dequeueInputBuffer(150000L);
                    if (dequeueInputBuffer >= 0 && !this.mEndOfStream) {
                        this.mDecoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                        YMFLog.info(this, "[Decoder ]", "getCacheFrame BUFFER_FLAG_END_OF_STREAM ");
                        this.mEndOfStream = true;
                    }
                    int i = 0;
                    while (true) {
                        int dequeueOutputBuffer = this.mDecoder.dequeueOutputBuffer(this.mInfo, 10000L);
                        if (dequeueOutputBuffer >= 0) {
                            break;
                        } else if (dequeueOutputBuffer == -3) {
                            YMFLog.info(this, "[Decoder ]", "getCacheFrame INFO_OUTPUT_BUFFERS_CHANGED");
                        } else if (dequeueOutputBuffer == -2) {
                            this.mFormat = this.mDecoder.getOutputFormat();
                            this.mWidth = this.mFormat.getInteger("width");
                            this.mHeight = this.mFormat.getInteger("height");
                            VideoPlayer.getInstance().getPlayerInfo(this.mStreamId, VideoPlayer.VideoPlayerInfoEnum.RESOLUTION);
                            YMFLog.info(this, "[Decoder ]", "getCacheFrame INFO_OUTPUT_FORMAT_CHANGED format:" + this.mDecoder.getOutputFormat() + " width:" + this.mWidth + " height:" + this.mHeight);
                        } else if (dequeueOutputBuffer == -1) {
                            i++;
                            if (i >= 3) {
                                YMFLog.error(this, "[Decoder ]", "getCacheFrame INFO_TRY_AGAIN_LATER 30ms");
                                j = 0;
                                break;
                            }
                        } else if (dequeueOutputBuffer == 4) {
                            YMFLog.info(this, "[Decoder ]", "getCacheFrame BUFFER_FLAG_END_OF_STREAM " + this.mLastOutputPts);
                            j = 0;
                        } else {
                            YMFLog.info(this, "[Decoder ]", "getCacheFrame outIndex:" + dequeueOutputBuffer);
                            j = 0;
                        }
                    }
                    j2 = j;
                } catch (Exception e) {
                    Exception e2 = e;
                }
            }
        }
        return j2;
    }

    public void setOnDecoderYUVListener(OnDecoderYUVListener onDecoderYUVListener) {
        this.mOnDecoderYUVListener = onDecoderYUVListener;
    }
}
