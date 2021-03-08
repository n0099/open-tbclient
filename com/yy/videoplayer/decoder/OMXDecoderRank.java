package com.yy.videoplayer.decoder;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.baidu.down.manage.DownloadConstants;
import com.yy.videoplayer.utils.YMFLog;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public class OMXDecoderRank {
    public static final String CODEC_H264_MIME = "video/avc";
    private static final int RANK_NOT_STANDARD = 100;
    private static final int RANK_NO_SENSE = 0;
    private static final int RANK_SECURE = 300;
    private static final int RANK_SOFTWARE = 200;
    private static final int RANK_TESTED = 500;
    public static final int RANK_UNKNOWN = 400;
    private static final String TAG = "OMXDecoderRank";
    private static OMXDecoderRank mInstance;
    private DecoderInfo mBestDecoder;
    private boolean mBestDecoderInitialized = false;
    private Map<String, Integer> mKnownCodecList;

    /* loaded from: classes6.dex */
    public static class DecoderInfo {
        private String mName;
        private int mRank;

        public DecoderInfo(String str, int i) {
            this.mName = str;
            this.mRank = i;
        }

        public int rank() {
            return this.mRank;
        }

        public String name() {
            return this.mName;
        }
    }

    public static synchronized OMXDecoderRank instance() {
        OMXDecoderRank oMXDecoderRank;
        synchronized (OMXDecoderRank.class) {
            if (mInstance == null) {
                mInstance = new OMXDecoderRank();
            }
            oMXDecoderRank = mInstance;
        }
        return oMXDecoderRank;
    }

    private OMXDecoderRank() {
        init();
    }

    private void init() {
        this.mKnownCodecList = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        this.mKnownCodecList.put("OMX.qcom.video.decoder.avc", 500);
        this.mKnownCodecList.put("OMX.ittiam.video.decoder.avc", 0);
        this.mKnownCodecList.put("OMX.MTK.VIDEO.DECODER.AVC", 500);
        this.mKnownCodecList.put("OMX.IMG.MSVDX.Decoder.AVC", 500);
        this.mKnownCodecList.put("OMX.k3.video.decoder.avc", 500);
        this.mKnownCodecList.put("OMX.Nvidia.h264.decode", 500);
        this.mKnownCodecList.put("OMX.Nvidia.h264.decode.secure", 300);
        this.mKnownCodecList.put("OMX.Exynos.avc.dec", 500);
        this.mKnownCodecList.put("OMX.Exynos.AVC.Decoder", Integer.valueOf((int) DownloadConstants.STATUS_DEVICE_NOT_FOUND_ERROR));
        this.mKnownCodecList.put("OMX.MARVELL.VIDEO.HW.CODA7542DECODER", 500);
        this.mKnownCodecList.put("OMX.MARVELL.VIDEO.HW.HANTRODECODER", 500);
        this.mKnownCodecList.put("OMX.SEC.avc.dec", 500);
        this.mKnownCodecList.put("OMX.SEC.AVC.Decoder", Integer.valueOf((int) DownloadConstants.STATUS_DEVICE_NOT_FOUND_ERROR));
        this.mKnownCodecList.put("OMX.SEC.avcdec", 498);
        this.mKnownCodecList.put("OMX.SEC.avc.sw.dec", 200);
        this.mKnownCodecList.put("OMX.Intel.VideoDecoder.AVC", 500);
        this.mKnownCodecList.put("OMX.Intel.hw_vd.h264", 501);
        this.mKnownCodecList.put("OMX.rk.video_decoder.avc", 500);
        this.mKnownCodecList.put("OMX.TI.DUCATI1.VIDEO.DECODER", 500);
        this.mKnownCodecList.put("OMX.amlogic.avc.decoder.awesome", 500);
        this.mKnownCodecList.put("OMX.ffmpeg.h264.decoder", 200);
        this.mKnownCodecList.put("OMX.bluestacks.hw.decoder", 0);
        this.mKnownCodecList.remove("OMX.hantro.81x0.video.decoder");
        this.mKnownCodecList.remove("OMX.sprd.h264.decoder");
        this.mKnownCodecList.remove("OMX.BRCM.vc4.decoder.avc");
        this.mKnownCodecList.remove("OMX.allwinner.video.decoder.avc");
        this.mKnownCodecList.remove("OMX.brcm.video.h264.hw.decoder");
        this.mKnownCodecList.remove("OMX.ST.VFM.H264Dec");
        this.mKnownCodecList.remove("OMX.Action.Video.Decoder");
        this.mKnownCodecList.remove("OMX.MS.AVC.Decoder");
        this.mKnownCodecList.remove("OMX.hisi.video.decoder");
        this.mKnownCodecList.remove("OMX.Infotm.Video.Decoder");
        this.mKnownCodecList.remove("OMX.NU.Video.Decoder");
        this.mKnownCodecList.remove("OMX.brcm.video.h264.decoder");
        this.mKnownCodecList.remove("OMX.hisi.video.decoder.avc");
        this.mKnownCodecList.put("OMX.google.h264.decoder", 200);
        this.mKnownCodecList.put("OMX.google.h264.lc.decoder", 200);
        this.mKnownCodecList.put("OMX.k3.ffmpeg.decoder", 200);
        this.mKnownCodecList.put("OMX.ffmpeg.video.decoder", 200);
        this.mKnownCodecList.put("OMX.sprd.soft.h264.decoder", 200);
        YMFLog.info(this, "[Decoder ]", "OMXDecoderRank knownCodecList:" + Arrays.toString(this.mKnownCodecList.keySet().toArray()));
    }

    public DecoderInfo getRank(String str) {
        int i = 200;
        if (str == null || "".equals(str)) {
            return new DecoderInfo(str, 0);
        }
        String lowerCase = str.toLowerCase(Locale.US);
        if (!lowerCase.startsWith("omx.")) {
            i = 100;
        } else if (!lowerCase.startsWith("omx.pv") && !lowerCase.startsWith("omx.google.") && !lowerCase.startsWith("omx.ffmpeg.") && !lowerCase.startsWith("omx.k3.ffmpeg.") && !lowerCase.startsWith("omx.avcodec.")) {
            if (lowerCase.startsWith("omx.ittiam.")) {
                i = 0;
            } else {
                Integer num = this.mKnownCodecList.get(lowerCase);
                if (num != null) {
                    i = num.intValue();
                } else {
                    i = 400;
                }
            }
        }
        return new DecoderInfo(str, i);
    }

    @TargetApi(16)
    public DecoderInfo getBestDecoder() {
        if (this.mBestDecoderInitialized) {
            return this.mBestDecoder;
        }
        try {
            YMFLog.debug(this, "[Decoder ]", "OMXDecoderRank Codec supported count:" + MediaCodecList.getCodecCount());
            int i = 400;
            DecoderInfo decoderInfo = null;
            for (int codecCount = MediaCodecList.getCodecCount() - 1; codecCount >= 0; codecCount--) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(codecCount);
                if (!codecInfoAt.isEncoder() && isSupportMime(codecInfoAt, "video/avc")) {
                    DecoderInfo rank = instance().getRank(codecInfoAt.getName());
                    int rank2 = rank.rank();
                    YMFLog.debug(this, "[Decoder ]", "OMXDecoderRank codec:%s, rank:%d", codecInfoAt.getName(), Integer.valueOf(rank2));
                    if (rank2 >= 400 && rank2 >= i) {
                        YMFLog.info(this, "[Decoder ]", "OMXDecoderRank codec match:%s, rank:%d", codecInfoAt.getName(), Integer.valueOf(rank2));
                        i = rank2;
                        decoderInfo = rank;
                    }
                }
            }
            this.mBestDecoder = decoderInfo;
            this.mBestDecoderInitialized = true;
            return decoderInfo;
        } catch (Throwable th) {
            YMFLog.error(this, "[Decoder ]", "OMXDecoderRank getBestDecoder exception:" + th.getMessage());
            return null;
        }
    }

    @TargetApi(16)
    private boolean isSupportMime(MediaCodecInfo mediaCodecInfo, String str) {
        for (String str2 : mediaCodecInfo.getSupportedTypes()) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }
}
