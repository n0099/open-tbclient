package com.yy.videoplayer.decoder;

import android.view.Surface;
import com.yy.videoplayer.decoder.OMXDecoderRank;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.utils.YMFLog;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class H264DecRender extends HardDecRender {
    public static final String crashTsFirst = "H264DecRenderCrashTsFirst";
    public static final String crashTsSecond = "H264DecRenderCrashTsSecond";
    static final String mCodecType = "video/avc";
    static String mCodecName = "";
    private static final String[] supportedH264HwCodecPrefixes = {"OMX.qcom.video.", "OMX.TI.", "OMX.SEC.", "OMX.Exynos.", "OMX.Nvidia.", "OMX.IMG.", "OMX.amlogic", "OMX.MTK.", "OMX.k3."};
    private static final String[] unSupportedH264HwCodecPrefixes = {"OMX.Nvidia.h264.decode.secure", "OMX.SEC.avcdec", "OMX.TI.DUCATI1.VIDEO.DECODER", "OMX.SEC.AVC.Decoder"};

    static {
        getDecodeInfoAsync();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class DecodeInfoThread implements Runnable {
        DecodeInfoThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                OMXDecoderRank.DecoderInfo bestDecoder = OMXDecoderRank.instance().getBestDecoder();
                if (bestDecoder != null) {
                    H264DecRender.mCodecName = bestDecoder.name();
                    YMFLog.info(null, "[Decoder ]", "H264DecRender, DecoderInfo mCodecName:" + H264DecRender.mCodecName);
                }
            } catch (Exception e) {
                YMFLog.error((Object) null, "[Decoder ]", "H264DecRende, DecoderInfo Load exception:" + e.getMessage());
            }
        }
    }

    public static void getDecodeInfoAsync() {
        new Thread(new DecodeInfoThread(), "YY_yylivesdk_H264DecRenderDecodeInfo_Thread").start();
    }

    public H264DecRender(Surface surface, int i, int i2) {
        this.mSurface = surface;
        this.mWidth = i;
        this.mHeight = i2;
        InitFields();
        reset(this.mSurface, this.mWidth, this.mHeight);
    }

    public H264DecRender(Surface surface, int i, int i2, long j, long j2) {
        this.mSurface = surface;
        this.mWidth = i;
        this.mHeight = i2;
        InitFields();
        setGroupId(j);
        setStreamId(j2);
        reset(this.mSurface, this.mWidth, this.mHeight);
    }

    public H264DecRender(Surface surface) {
        this.mSurface = surface;
        InitFields();
        reset(this.mSurface, this.mWidth, this.mHeight);
    }

    public static boolean upDateCodecIgnoreCodecWhiteList() {
        mCodecName = findCodecName("video/avc", supportedH264HwCodecPrefixes, unSupportedH264HwCodecPrefixes, true);
        return mCodecName != null;
    }

    public static boolean IsAvailable() {
        return IsAvailable(mCodecName);
    }

    public static String getCodecName() {
        return mCodecName;
    }

    void InitFields() {
        this.mSecondTsWriten = new AtomicBoolean(false);
        this.mCrashTsFirst = crashTsFirst;
        this.mCrashTsSecond = crashTsSecond;
        this.mNoFrameCnt = 0;
    }

    @Override // com.yy.videoplayer.decoder.HardDecRender
    public int reset() {
        return reset(this.mSurface, this.mWidth, this.mHeight);
    }

    @Override // com.yy.videoplayer.decoder.HardDecRender
    public int reset(Surface surface, int i, int i2) {
        return reset(surface, mCodecName, "video/avc", i, i2);
    }

    @Override // com.yy.videoplayer.decoder.HardDecRender
    public long PushFrame(Surface surface, byte[] bArr, VideoConstant.ExtraData extraData, long j, boolean z) {
        return PushFrame(surface, mCodecName, "video/avc", bArr, extraData, j, z);
    }
}
