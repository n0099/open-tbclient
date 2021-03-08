package com.yy.videoplayer.decoder;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.view.Surface;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.utils.YMFLog;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class H265DecRender extends HardDecRender {
    public static final String crashTsFirst = "H265DecRenderCrashTsFirst";
    public static final String crashTsSecond = "H265DecRenderCrashTsSecond";
    static final String mCodecType = "video/hevc";
    static String mCodecName = "";
    private static final String[] supportedHevcHwCodecPrefixes = {"OMX.qcom.video.", "OMX.MTK."};
    private static final String[] unSupportedHevcHwCodecPrefixes = new String[0];

    static {
        getDecodeInfoAsync();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class DecodeInfoThread implements Runnable {
        DecodeInfoThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MediaCodecInfo selectCodec = H265DecRender.selectCodec("video/hevc");
                if (selectCodec != null) {
                    H265DecRender.mCodecName = selectCodec.getName();
                    YMFLog.info(null, "[Decoder ]", "H265DecRender mediaCodecInfo.getName() mCodecName:" + H265DecRender.mCodecName);
                }
            } catch (Exception e) {
                YMFLog.error((Object) null, "[Decoder ]", "H265DecRender DecoderInfo Load exception: " + e.getMessage());
            }
        }
    }

    public static void getDecodeInfoAsync() {
        new Thread(new DecodeInfoThread(), "YY_yylivesdk_H265DecRenderDecodeInfo_Thread").start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MediaCodecInfo selectCodec(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        YMFLog.info(null, "[Decoder ]", "SelectCodec:" + codecInfoAt.getName());
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public H265DecRender(Surface surface, int i, int i2) {
        this.mSurface = surface;
        this.mWidth = i;
        this.mHeight = i2;
        YMFLog.info(this, "[Decoder ]", "H265DecRender init");
        InitFields();
        reset(this.mSurface, this.mWidth, this.mHeight);
    }

    public H265DecRender(Surface surface, int i, int i2, long j, long j2) {
        this.mSurface = surface;
        this.mWidth = i;
        this.mHeight = i2;
        YMFLog.info(this, "[Decoder ]", "H265DecRender init");
        setGroupId(j);
        setStreamId(j2);
        InitFields();
        reset(this.mSurface, this.mWidth, this.mHeight);
    }

    public H265DecRender(Surface surface, PlayNotify playNotify) {
        this.mSurface = surface;
        InitFields();
        reset(this.mSurface, this.mWidth, this.mHeight);
    }

    public static boolean upDateCodecIgnoreCodecWhiteList() {
        mCodecName = findCodecName("video/hevc", supportedHevcHwCodecPrefixes, unSupportedHevcHwCodecPrefixes, true);
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
        return reset(surface, mCodecName, "video/hevc", i, i2);
    }

    @Override // com.yy.videoplayer.decoder.HardDecRender
    public long PushFrame(Surface surface, byte[] bArr, VideoConstant.ExtraData extraData, long j, boolean z) {
        return PushFrame(surface, mCodecName, "video/hevc", bArr, extraData, j, z);
    }
}
