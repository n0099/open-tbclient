package com.kwai.video.player;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.room.RoomMasterTable;
import com.tencent.connect.common.Constants;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class KsMediaCodecInfo {
    public static final int RANK_ACCEPTABLE = 700;
    public static final int RANK_LAST_CHANCE = 600;
    public static int RANK_MAX = 1000;
    public static final int RANK_NON_STANDARD = 100;
    public static final int RANK_NO_SENSE = 0;
    public static final int RANK_SECURE = 300;
    public static final int RANK_SOFTWARE = 200;
    public static final int RANK_TESTED = 800;
    public static final String TAG = "KsMediaCodecInfo";
    public static Map<String, Integer> sKnownCodecList;
    public MediaCodecInfo mCodecInfo;
    public String mMimeType;
    public int mRank = 0;

    public static synchronized Map<String, Integer> getKnownCodecList() {
        synchronized (KsMediaCodecInfo.class) {
            if (sKnownCodecList != null) {
                return sKnownCodecList;
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            sKnownCodecList = treeMap;
            treeMap.put("OMX.Nvidia.h264.decode", 800);
            sKnownCodecList.put("OMX.Nvidia.h264.decode.secure", 300);
            sKnownCodecList.put("OMX.Intel.hw_vd.h264", 801);
            sKnownCodecList.put("OMX.Intel.VideoDecoder.AVC", 800);
            sKnownCodecList.put("OMX.qcom.video.decoder.avc", 800);
            sKnownCodecList.put("OMX.ittiam.video.decoder.avc", 0);
            sKnownCodecList.put("OMX.SEC.avc.dec", 800);
            sKnownCodecList.put("OMX.SEC.AVC.Decoder", 799);
            sKnownCodecList.put("OMX.SEC.avcdec", 798);
            sKnownCodecList.put("OMX.SEC.avc.sw.dec", 200);
            sKnownCodecList.put("OMX.Exynos.avc.dec", 800);
            sKnownCodecList.put("OMX.Exynos.AVC.Decoder", 799);
            sKnownCodecList.put("OMX.k3.video.decoder.avc", 800);
            sKnownCodecList.put("OMX.IMG.MSVDX.Decoder.AVC", 800);
            sKnownCodecList.put("OMX.TI.DUCATI1.VIDEO.DECODER", 800);
            sKnownCodecList.put("OMX.rk.video_decoder.avc", 800);
            sKnownCodecList.put("OMX.amlogic.avc.decoder.awesome", 800);
            sKnownCodecList.put("OMX.MARVELL.VIDEO.HW.CODA7542DECODER", 800);
            sKnownCodecList.put("OMX.MARVELL.VIDEO.H264DECODER", 200);
            sKnownCodecList.remove("OMX.Action.Video.Decoder");
            sKnownCodecList.remove("OMX.allwinner.video.decoder.avc");
            sKnownCodecList.remove("OMX.BRCM.vc4.decoder.avc");
            sKnownCodecList.remove("OMX.brcm.video.h264.hw.decoder");
            sKnownCodecList.remove("OMX.brcm.video.h264.decoder");
            sKnownCodecList.remove("OMX.cosmo.video.decoder.avc");
            sKnownCodecList.remove("OMX.duos.h264.decoder");
            sKnownCodecList.remove("OMX.hantro.81x0.video.decoder");
            sKnownCodecList.remove("OMX.hantro.G1.video.decoder");
            sKnownCodecList.remove("OMX.hisi.video.decoder");
            sKnownCodecList.remove("OMX.LG.decoder.video.avc");
            sKnownCodecList.remove("OMX.MS.AVC.Decoder");
            sKnownCodecList.remove("OMX.RENESAS.VIDEO.DECODER.H264");
            sKnownCodecList.remove("OMX.RTK.video.decoder");
            sKnownCodecList.remove("OMX.sprd.h264.decoder");
            sKnownCodecList.remove("OMX.ST.VFM.H264Dec");
            sKnownCodecList.remove("OMX.vpu.video_decoder.avc");
            sKnownCodecList.remove("OMX.WMT.decoder.avc");
            sKnownCodecList.remove("OMX.bluestacks.hw.decoder");
            sKnownCodecList.put("OMX.google.h264.decoder", 200);
            sKnownCodecList.put("OMX.google.h264.lc.decoder", 200);
            sKnownCodecList.put("OMX.k3.ffmpeg.decoder", 200);
            sKnownCodecList.put("OMX.ffmpeg.video.decoder", 200);
            sKnownCodecList.put("OMX.sprd.soft.h264.decoder", 200);
            return sKnownCodecList;
        }
    }

    public static String getLevelName(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                switch (i2) {
                    case 4:
                        return "11";
                    case 8:
                        return "12";
                    case 16:
                        return "13";
                    case 32:
                        return "2";
                    case 64:
                        return Constants.VIA_REPORT_TYPE_QQFAVORITES;
                    case 128:
                        return Constants.VIA_REPORT_TYPE_DATALINE;
                    case 256:
                        return "3";
                    case 512:
                        return EventType.GiftEventID.SEND_GIFT_TO_USER_FAIL;
                    case 1024:
                        return EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_SUCCESS;
                    case 2048:
                        return "4";
                    case 4096:
                        return "41";
                    case 8192:
                        return RoomMasterTable.DEFAULT_ID;
                    case 16384:
                        return "5";
                    case 32768:
                        return "51";
                    case 65536:
                        return "52";
                    default:
                        return "0";
                }
            }
            return "1b";
        }
        return "1";
    }

    public static String getProfileLevelName(int i2, int i3) {
        return String.format(Locale.US, " %s Profile Level %s (%d,%d)", getProfileName(i2), getLevelName(i3), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static String getProfileName(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? i2 != 16 ? i2 != 32 ? i2 != 64 ? "Unknown" : "High444" : "High422" : "High10" : "High" : "Extends" : "Main" : "Baseline";
    }

    @TargetApi(16)
    public static KsMediaCodecInfo setupCandidate(MediaCodecInfo mediaCodecInfo, String str) {
        if (mediaCodecInfo == null || Build.VERSION.SDK_INT < 16) {
            return null;
        }
        String name = mediaCodecInfo.getName();
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        String lowerCase = name.toLowerCase(Locale.US);
        int i2 = 600;
        if (!lowerCase.startsWith("omx.")) {
            i2 = 100;
        } else if (lowerCase.startsWith("omx.pv") || lowerCase.startsWith("omx.google.") || lowerCase.startsWith("omx.ffmpeg.") || lowerCase.startsWith("omx.k3.ffmpeg.") || lowerCase.startsWith("omx.avcodec.")) {
            i2 = 200;
        } else {
            if (!lowerCase.startsWith("omx.ittiam.")) {
                if (!lowerCase.startsWith("omx.mtk.")) {
                    Integer num = getKnownCodecList().get(lowerCase);
                    if (num != null) {
                        i2 = num.intValue();
                    } else {
                        try {
                            if (mediaCodecInfo.getCapabilitiesForType(str) != null) {
                                i2 = 700;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                } else if (Build.VERSION.SDK_INT >= 18) {
                    i2 = 800;
                }
            }
            i2 = 0;
        }
        KsMediaCodecInfo ksMediaCodecInfo = new KsMediaCodecInfo();
        ksMediaCodecInfo.mCodecInfo = mediaCodecInfo;
        ksMediaCodecInfo.mRank = i2;
        ksMediaCodecInfo.mMimeType = str;
        return ksMediaCodecInfo;
    }

    @TargetApi(16)
    public void dumpProfileLevels(String str) {
        int i2;
        int i3;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        try {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = this.mCodecInfo.getCapabilitiesForType(str);
            if (capabilitiesForType == null || capabilitiesForType.profileLevels == null) {
                i2 = 0;
                i3 = 0;
            } else {
                i2 = 0;
                i3 = 0;
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : capabilitiesForType.profileLevels) {
                    if (codecProfileLevel != null) {
                        i2 = Math.max(i2, codecProfileLevel.profile);
                        i3 = Math.max(i3, codecProfileLevel.level);
                    }
                }
            }
            Log.i(TAG, String.format(Locale.US, "%s", getProfileLevelName(i2, i3)));
        } catch (Throwable unused) {
            Log.i(TAG, "profile-level: exception");
        }
    }
}
