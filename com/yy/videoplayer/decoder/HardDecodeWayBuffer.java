package com.yy.videoplayer.decoder;

import android.graphics.Bitmap;
import android.media.MediaFormat;
import android.view.Surface;
import android.view.View;
import com.yy.videoplayer.IVideoInfoCallback;
import com.yy.videoplayer.IYMFDecoderListener;
import com.yy.videoplayer.VideoRenderNotify;
import com.yy.videoplayer.YMFEventManager;
import com.yy.videoplayer.YMFStreamManager;
import com.yy.videoplayer.decoder.HardDecRender;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.decoder.VideoDecoderCenterExt;
import com.yy.videoplayer.render.YMFImageBuffer;
import com.yy.videoplayer.stat.YMFPlayerStatisticManager;
import com.yy.videoplayer.stat.YMFPlayerUsrBehaviorStat;
import com.yy.videoplayer.utils.ByteVector;
import com.yy.videoplayer.utils.ImageUtil;
import com.yy.videoplayer.utils.TimeUtil;
import com.yy.videoplayer.utils.YMFLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class HardDecodeWayBuffer implements HardDecRender.IDecoderDataOutCallBack, HardDecRender.OnDecoderYUVListener, HardDecodeWay, Runnable {
    private static final int COLOR_QCOM_FormatYUV420SemiPlanar32m = 2141391876;
    private static final int OMX_QCOM_COLOR_FormatYUV420PackedSemiPlanar64x32Tile2m8ka = 2141391875;
    private static final String TAG = "HardDecodeWayBuffer";
    private static final int VIDEO_DATA_LOG = 500;
    private IYMFDecoderListener mDecoderListener;
    private boolean mIsDecoderNeedReconfig = false;
    private AtomicBoolean mReady = new AtomicBoolean(false);
    private HardDecRender mOuterDecoder = null;
    private long mUserGroupId = 0;
    private long mStreamId = 0;
    private boolean mFirstFrameOut = false;
    private boolean mFirstFrameRenderSdk = false;
    private boolean mFirstFrameRenderLibMgr = false;
    private boolean mYUVDecodeMode = false;
    private boolean mOnlyDecode = false;
    private int mFrames = 0;
    private int renderType = 0;
    private long mVideoDataCnt = 0;
    private boolean mRecIFrame = false;
    private long mCurTime = 0;
    private long mLastTime = 0;
    private int mDecodeCnt = 0;
    public ByteVector mBytesVector = null;
    public ByteVector mTmpBytesVector = null;
    private YMFImageBuffer mImage = null;
    private boolean isFirstOnVideoConfig = false;
    private boolean mFirstDecodedFrame = false;
    private HashMap<Long, Long> mDecodeDiffMap = new HashMap<>();
    private ArrayList<VideoRenderNotify> mVideoRenderNotifys = new ArrayList<>();
    private boolean mIgnoreStatistic = false;
    private AtomicBoolean mVideoPlayRender = new AtomicBoolean(false);

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void Start() {
    }

    @Override // com.yy.videoplayer.decoder.VideoSurfaceListener
    public void OnSurfaceCreated() {
    }

    @Override // com.yy.videoplayer.decoder.VideoSurfaceListener
    public void OnSurfaceChanged(View view, Surface surface, int i, int i2, int i3, int i4, int i5, VideoConstant.OrientationType orientationType, VideoConstant.ScaleMode scaleMode) {
    }

    @Override // com.yy.videoplayer.decoder.VideoSurfaceListener
    public void OnSurfaceDestroyed(Surface surface) {
    }

    @Override // com.yy.videoplayer.decoder.VideoSurfaceListener
    public void OnSurfaceRedraw() {
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public boolean IsDecoderNeedReconfig() {
        return this.mIsDecoderNeedReconfig;
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void SetPlayNotify(PlayNotify playNotify) {
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void SetVideoIds(long j, long j2) {
        YMFLog.info(this, "[Decoder ]", "SetVideoIds userGroupId:" + j + ", streamId:" + j2);
        this.mUserGroupId = j;
        this.mStreamId = j2;
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void OnStreamEnd() {
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public Bitmap GetScreenShot() {
        return null;
    }

    public void setDecoderListener(IYMFDecoderListener iYMFDecoderListener) {
        this.mDecoderListener = iYMFDecoderListener;
    }

    private void notifyHardwareDecoderFrameRate() {
        this.mDecodeCnt++;
        this.mCurTime = TimeUtil.getTickCountLong();
        if (this.mLastTime == 0) {
            this.mLastTime = this.mCurTime;
        }
        if (this.mCurTime - this.mLastTime >= 1000) {
            StateMonitor.NotifyDecoderFrameRateOUT(this.mStreamId, this.mDecodeCnt);
            this.mLastTime = this.mCurTime;
            this.mDecodeCnt = 0;
        }
    }

    private void sendFrameToView(int i, int i2, ByteBuffer byteBuffer, VideoConstant.ExtraData extraData, long j, int i3, MediaFormat mediaFormat) {
        if (this.mYUVDecodeMode && this.mDecoderListener != null) {
            notifyHardwareDecoderFrameRate();
            int i4 = 2;
            switch (i3) {
                case 19:
                    break;
                case 21:
                case COLOR_QCOM_FormatYUV420SemiPlanar32m /* 2141391876 */:
                    i4 = 1;
                    break;
                default:
                    YMFLog.error(this, "[Decoder ]", "unsupported colorFormat:" + i3);
                    break;
            }
            if (this.mImage == null || this.mImage.mWidth != i || this.mImage.mHeight != i2) {
                if (this.mImage != null) {
                    this.mImage.mData = null;
                    this.mImage = null;
                }
                this.mImage = new YMFImageBuffer(i, i2, i4, false);
            }
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            boolean z = false;
            if (mediaFormat != null && mediaFormat.containsKey("crop-right")) {
                i5 = mediaFormat.getInteger("crop-right");
                i6 = mediaFormat.getInteger("crop-left");
                i7 = mediaFormat.getInteger("crop-top");
                i8 = mediaFormat.getInteger("crop-bottom");
            }
            if (extraData != null && extraData.layouts[0] >= 0 && extraData.layouts[1] >= 0 && extraData.layouts[2] > 0 && extraData.layouts[3] > 0) {
                i6 += extraData.layouts[0];
                i5 = (extraData.layouts[2] + i6) - 1;
                i7 += extraData.layouts[1];
                i8 = (extraData.layouts[3] + i7) - 1;
                z = true;
            }
            if (this.mImage.mClipWindow != z) {
                this.mImage.mChangeRenderMode = true;
            } else {
                this.mImage.mChangeRenderMode = false;
            }
            this.mImage.assign(byteBuffer, i, i2, i4, j, TimeUtil.getTickCountLong(), true, this.mStreamId, i6, i5, i8, i7, z, extraData != null ? extraData.ssrc : 0);
            this.mDecoderListener.onDecodedFrameAvailable(this.mStreamId, this.mImage);
        }
    }

    public void setVideoPlayRender(boolean z) {
        this.mVideoPlayRender.set(z);
    }

    @Override // com.yy.videoplayer.decoder.HardDecRender.OnDecoderYUVListener
    public void OnDecoderYUVListener(int i, int i2, ByteBuffer byteBuffer, int i3, VideoConstant.ExtraData extraData, long j, int i4, int i5, MediaFormat mediaFormat) {
        int i6;
        int i7;
        if (mediaFormat == null || !mediaFormat.containsKey("crop-right")) {
            i6 = 0;
            i7 = i;
        } else {
            mediaFormat.getInteger("crop-right");
            int integer = mediaFormat.getInteger("stride");
            mediaFormat.getInteger("crop-left");
            mediaFormat.getInteger("crop-top");
            mediaFormat.getInteger("crop-bottom");
            i6 = mediaFormat.getInteger("slice-height");
            i7 = integer;
        }
        long tickCountLong = TimeUtil.getTickCountLong();
        if (!this.mFirstDecodedFrame) {
            YYVideoLibMgr.instance().onFirstFrameDecodeNotify(this.mStreamId, j, tickCountLong);
            this.mFirstDecodedFrame = true;
        }
        YMFEventManager.instance().notifyDecoderEvent(this.mStreamId, j);
        if (this.mYUVDecodeMode) {
            if (i3 == ((i * i2) * 3) / 2) {
                sendFrameToView(i, i2, byteBuffer, extraData, j, i5, mediaFormat);
            } else {
                sendFrameToView(i7 != 0 ? i7 : i, i6 != 0 ? i6 : i2, byteBuffer, extraData, j, i5, mediaFormat);
            }
        }
        if (this.mOnlyDecode) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mBytesVector == null) {
                this.mBytesVector = new ByteVector(i3);
            }
            this.mBytesVector.reserve(i3);
            if (i5 == 21) {
                if (this.mTmpBytesVector == null) {
                    this.mTmpBytesVector = new ByteVector(i3);
                }
                this.mTmpBytesVector.reserve(i3);
                byteBuffer.rewind();
                byteBuffer.get(this.mTmpBytesVector.getBytes(), 0, i3);
                if (i7 != i || i6 != i2) {
                    ImageUtil.NV12ToYUV420WithStride(this.mTmpBytesVector.getBytes(), this.mBytesVector.getBytes(), i, i2, i7, i6);
                } else {
                    ImageUtil.NV12ToYUV420(this.mTmpBytesVector.getBytes(), this.mBytesVector.getBytes(), i, i2);
                }
            } else if (i7 != i || i6 != i2) {
                if (this.mTmpBytesVector == null) {
                    this.mTmpBytesVector = new ByteVector(i3);
                }
                this.mTmpBytesVector.reserve(i3);
                byteBuffer.rewind();
                byteBuffer.get(this.mTmpBytesVector.getBytes(), 0, i3);
                ImageUtil.YUV420ToYUV420WithStride(this.mTmpBytesVector.getBytes(), this.mBytesVector.getBytes(), i, i2, i7, i6);
            } else {
                byteBuffer.rewind();
                byteBuffer.get(this.mBytesVector.getBytes(), 0, i3);
            }
            System.currentTimeMillis();
            YYVideoLibMgr.instance().onDecodedFrameData(this.mStreamId, i, i2, this.mBytesVector.getBytes(), (int) (i * i2 * 1.5d), j);
            if (!this.mFirstFrameRenderLibMgr) {
                this.mFirstFrameRenderLibMgr = true;
                YMFPlayerUsrBehaviorStat.getInstance().notifyFirstFrameRendered(0);
            }
            YMFStreamManager.instance();
            if (!YMFStreamManager.checkIfStreamRenderedBySdk(this.mStreamId)) {
                onVideoRenderNotify(this.mUserGroupId, this.mStreamId, j, tickCountLong, tickCountLong, this.mIgnoreStatistic);
                if (this.mIgnoreStatistic) {
                    YMFLog.info(this, "[Decoder ]", "IgnoreStat mStreamId:" + this.mStreamId + " pts:" + j);
                    this.mIgnoreStatistic = false;
                }
                YMFPlayerStatisticManager.getInstance().setRenderFrameCount(this.mStreamId, 1);
                YMFPlayerStatisticManager.getInstance().setRenderTimeStamp(this.mStreamId, System.currentTimeMillis(), j);
                YMFPlayerStatisticManager.getInstance().setRenderLatency(this.mStreamId, (int) (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private String bin2hex(byte[] bArr) {
        String str = null;
        int length = bArr == null ? 0 : bArr.length;
        for (int i = 0; i < length; i++) {
            str = str != null ? str + String.format("%02x ", Byte.valueOf(bArr[i])) : String.format("%02x ", Byte.valueOf(bArr[i]));
        }
        return str;
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void onCreateRenderAhead(int i, int i2, String str) {
        YMFLog.info(this, VideoConstant.MEDIACODE_DECODER, "HardDecodeWayBuffer onCreateRenderAhead width:" + i + " ,height:" + i2 + " ,mime:" + str + " ,streamId:" + this.mStreamId);
        if (this.mOuterDecoder == null && i != 0 && i2 != 0) {
            if ("video/hevc".equals(str)) {
                this.mOuterDecoder = new H265DecRender(null, i, i2, this.mUserGroupId, this.mStreamId);
                StateMonitor.NotifyCreateRender(this.mStreamId, 1);
            } else if ("video/avc".equals(str)) {
                this.mOuterDecoder = new H264DecRender(null, i, i2, this.mUserGroupId, this.mStreamId);
                StateMonitor.NotifyCreateRender(this.mStreamId, 0);
            } else if ("video/x-vnd.on2.vp8".equals(str)) {
                this.mOuterDecoder = new VP8DecRender(null, i, i2);
            }
            this.mOuterDecoder.setStreamId(this.mStreamId);
            this.mOuterDecoder.setOnDecoderYUVListener(this);
        }
        this.isFirstOnVideoConfig = true;
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void OnVideoConfig(byte[] bArr, int i, int i2, String str) {
        YMFLog.info(this, "[Decoder ]", "OnVideoConfig width:" + i + " height:" + i2 + " mime:" + str + " streamId:" + this.mStreamId + " data:" + bin2hex(bArr) + " isFirstOnVideoConfig:" + this.isFirstOnVideoConfig);
        if (this.isFirstOnVideoConfig || this.mOuterDecoder == null) {
            if (this.mOuterDecoder == null) {
                if ("video/hevc".equals(str)) {
                    this.mOuterDecoder = new H265DecRender(null, i, i2, this.mUserGroupId, this.mStreamId);
                    this.renderType = 1;
                } else if ("video/avc".equals(str)) {
                    this.mOuterDecoder = new H264DecRender(null, i, i2, this.mUserGroupId, this.mStreamId);
                    this.renderType = 0;
                } else if ("video/x-vnd.on2.vp8".equals(str)) {
                    this.mOuterDecoder = new VP8DecRender(null, i, i2);
                    this.renderType = 5;
                }
                if (!this.mYUVDecodeMode) {
                    StateMonitor.NotifyCreateRender(this.mStreamId, this.renderType);
                }
                this.mOuterDecoder.setStreamId(this.mStreamId);
                this.mOuterDecoder.setOnDecoderYUVListener(this);
            } else if (i != this.mOuterDecoder.mWidth || i2 != this.mOuterDecoder.mHeight) {
                YMFLog.info(this, "[Decoder ]", "reset decoder because of width or height inequality!");
                this.mOuterDecoder.reset(null, i, i2);
                if (!this.mYUVDecodeMode) {
                    StateMonitor.NotifyCreateRender(this.mStreamId, this.renderType);
                }
                this.mOuterDecoder.setStreamId(this.mStreamId);
                this.mOuterDecoder.setOnDecoderYUVListener(this);
            }
        } else {
            this.mOuterDecoder.reset(null, i, i2);
        }
        System.currentTimeMillis();
        this.mOuterDecoder.PushFrame(null, bArr, null, 0L, true);
        this.mOuterDecoder.ConfigDone();
        if (this.mOuterDecoder.GetAndClearExceptionFlag()) {
            this.mIsDecoderNeedReconfig = true;
            this.mOuterDecoder.EndofStream();
        }
        this.mFirstFrameOut = false;
        this.isFirstOnVideoConfig = false;
        if (this.mYUVDecodeMode) {
            YMFStreamManager.instance().addStream(this.mStreamId, this);
        }
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public long OnVideoDataArrived(byte[] bArr, long j, VideoConstant.ExtraData extraData) {
        int i;
        long j2 = this.mVideoDataCnt;
        this.mVideoDataCnt = 1 + j2;
        if (j2 % 500 == 0 || ((!this.mFirstFrameOut || !this.mRecIFrame) && this.mFrames <= 50)) {
            YMFLog.info(this, "[Decoder ]", "OnVideoDataArrived streamId:" + this.mStreamId + ", pts:" + j);
        }
        if (this.mOuterDecoder != null) {
            if ((!this.mFirstFrameOut || !this.mRecIFrame) && this.mFrames <= 50) {
                if (this.mOuterDecoder instanceof VP8DecRender) {
                    i = 0;
                } else if (bArr == null) {
                    i = 255;
                } else if (bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 1) {
                    i = bArr[3] & 31;
                } else if (bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 1) {
                    i = bArr[4] & 31;
                } else {
                    i = -1;
                }
                if (i == 5) {
                    this.mRecIFrame = true;
                }
                YMFLog.info(this, "[Decoder ]", "handleOuterVideoData streamId:" + this.mStreamId + ", frames:" + this.mFrames + ", type:" + i + ", len:" + (bArr == null ? 0 : bArr.length) + ", pts:" + j);
            }
            this.mFrames++;
            this.mDecodeDiffMap.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
            long PushFrame = this.mOuterDecoder.PushFrame(null, bArr, extraData, j, false);
            if (PushFrame <= 0) {
                if (this.mOuterDecoder.GetAndClearExceptionFlag()) {
                    YMFLog.warn(this, "[Decoder ]", "handleOuterVideoData decoder exception! Need to recconfig!");
                    this.mIsDecoderNeedReconfig = true;
                    this.mOuterDecoder.EndofStream();
                    return PushFrame;
                }
            } else {
                if (this.mDecodeDiffMap.get(Long.valueOf(j)) != null) {
                    YMFPlayerStatisticManager.getInstance().setDecodeLatency(this.mStreamId, (int) (System.currentTimeMillis() - this.mDecodeDiffMap.get(Long.valueOf(j)).longValue()));
                }
                if (!this.mFirstFrameOut) {
                    StateMonitor.instance().NotifyDecodeDelayFrameCountInfo(this.mStreamId, this.mFrames);
                    YMFPlayerUsrBehaviorStat.getInstance().notifyFirstFrameDecode();
                    YMFLog.info(this, "[Decoder ]", "handleOuterVideoData first frame out, frames:" + this.mFrames);
                }
                this.mFirstFrameOut = true;
            }
            return PushFrame;
        }
        return 0L;
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void Quit() {
        if (this.mOuterDecoder != null) {
            if (!this.mYUVDecodeMode) {
                StateMonitor.NotifyReleaseRender(this.mStreamId);
            }
            this.mOuterDecoder.release();
            this.mOuterDecoder.EndofStream();
            this.mOuterDecoder = null;
        }
        if (this.mYUVDecodeMode) {
            YMFStreamManager.instance().removeStream(this.mStreamId);
        }
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void setVrStream(boolean z) {
    }

    public void setYUVDecodeMode(boolean z) {
        YMFLog.info(this, "[Decoder ]", "setYUVDecodeMode:" + this.mStreamId + "," + z);
        this.mYUVDecodeMode = z;
    }

    public void setOnlyDecoded(boolean z) {
        YMFLog.info(this, "[Decoder ]", "setOnlyDecoded streamId:" + this.mStreamId + "," + z);
        this.mIgnoreStatistic = z;
        this.mOnlyDecode = z;
        if (this.mIgnoreStatistic) {
            YMFPlayerStatisticManager.getInstance().reset(this.mStreamId);
        }
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public VideoDecoderCenterExt.HardDecoderStaffVersion getHardDecodeType() {
        return VideoDecoderCenterExt.HardDecoderStaffVersion.YUVBUFFER;
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public long getUserGroupId() {
        return 0L;
    }

    @Override // com.yy.videoplayer.decoder.HardDecodeWay
    public void setVideoInfoCallback(IVideoInfoCallback iVideoInfoCallback) {
    }

    @Override // com.yy.videoplayer.decoder.HardDecRender.IDecoderDataOutCallBack
    public void onFirstDecodedDataOut() {
    }

    @Override // java.lang.Runnable
    public void run() {
    }

    private void onVideoRenderNotify(long j, long j2, long j3, long j4, long j5, boolean z) {
        if (this.mVideoRenderNotifys != null) {
            this.mVideoRenderNotifys.add(new VideoRenderNotify(j, j2, j3, j4, j5, z));
            YYVideoLibMgr.instance().onVideoRenderNotify(this.mVideoRenderNotifys);
            this.mVideoRenderNotifys.clear();
        }
    }
}
