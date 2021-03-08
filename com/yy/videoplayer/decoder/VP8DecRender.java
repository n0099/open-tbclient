package com.yy.videoplayer.decoder;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.view.Surface;
import com.yy.videoplayer.Constant;
import com.yy.videoplayer.decoder.VideoConstant;
import com.yy.videoplayer.utils.YMFLog;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class VP8DecRender extends HardDecRender {
    public static final String crashTsFirst = "VP8DecRenderCrashTsFirst";
    public static final String crashTsSecond = "VP8DecRenderCrashTsSecond";
    static final String mCodecType = "video/x-vnd.on2.vp8";
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
                MediaCodecInfo selectCodec = VP8DecRender.selectCodec(VP8DecRender.mCodecType);
                if (selectCodec != null) {
                    VP8DecRender.mCodecName = selectCodec.getName();
                    YMFLog.info(null, "[Decoder ]", "VP8DecRender mediaCodecInfo.getName() mCodecName:" + VP8DecRender.mCodecName);
                }
            } catch (Exception e) {
                YMFLog.error((Object) null, Constant.MEDIACODE_STAT, "DecoderInfo Load exception:" + e.getMessage());
            }
        }
    }

    public static void getDecodeInfoAsync() {
        new Thread(new DecodeInfoThread()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MediaCodecInfo selectCodec(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        YMFLog.info(null, Constant.MEDIACODE_STAT, "SelectCodec:" + codecInfoAt.getName());
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public VP8DecRender(Surface surface, int i, int i2) {
        this.mSurface = surface;
        this.mWidth = i;
        this.mHeight = i2;
        YMFLog.info(null, Constant.MEDIACODE_STAT, "VP8DecRender init");
        InitFields();
        reset(this.mSurface, this.mWidth, this.mHeight);
    }

    public VP8DecRender(Surface surface, PlayNotify playNotify) {
        this.mSurface = surface;
        InitFields();
        reset(this.mSurface, this.mWidth, this.mHeight);
    }

    public static boolean upDateCodecIgnoreCodecWhiteList() {
        mCodecName = findCodecName(mCodecType, supportedHevcHwCodecPrefixes, unSupportedHevcHwCodecPrefixes, true);
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
        return reset(surface, mCodecName, mCodecType, i, i2);
    }

    @Override // com.yy.videoplayer.decoder.HardDecRender
    public long PushFrame(Surface surface, byte[] bArr, VideoConstant.ExtraData extraData, long j, boolean z) {
        return PushFrame(surface, mCodecName, mCodecType, bArr, extraData, j, z);
    }
}
