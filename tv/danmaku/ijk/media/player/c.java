package tv.danmaku.ijk.media.player;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class c {
    private static Map<String, Integer> d;
    public MediaCodecInfo a;
    public int b = 0;
    public String c;

    private static synchronized Map<String, Integer> a() {
        Map<String, Integer> map;
        synchronized (c.class) {
            if (d != null) {
                map = d;
            } else {
                d = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                d.put("OMX.Nvidia.h264.decode", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_BAD_INTERLEAVING));
                d.put("OMX.Nvidia.h264.decode.secure", 300);
                d.put("OMX.Intel.hw_vd.h264", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_NOT_SEEKABLE));
                d.put("OMX.Intel.VideoDecoder.AVC", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_BAD_INTERLEAVING));
                d.put("OMX.qcom.video.decoder.avc", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_BAD_INTERLEAVING));
                d.put("OMX.ittiam.video.decoder.avc", 0);
                d.put("OMX.SEC.avc.dec", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_BAD_INTERLEAVING));
                d.put("OMX.SEC.AVC.Decoder", 799);
                d.put("OMX.SEC.avcdec", 798);
                d.put("OMX.SEC.avc.sw.dec", 200);
                d.put("OMX.Exynos.avc.dec", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_BAD_INTERLEAVING));
                d.put("OMX.Exynos.AVC.Decoder", 799);
                d.put("OMX.k3.video.decoder.avc", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_BAD_INTERLEAVING));
                d.put("OMX.IMG.MSVDX.Decoder.AVC", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_BAD_INTERLEAVING));
                d.put("OMX.TI.DUCATI1.VIDEO.DECODER", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_BAD_INTERLEAVING));
                d.put("OMX.rk.video_decoder.avc", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_BAD_INTERLEAVING));
                d.put("OMX.amlogic.avc.decoder.awesome", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_BAD_INTERLEAVING));
                d.put("OMX.MARVELL.VIDEO.HW.CODA7542DECODER", Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_BAD_INTERLEAVING));
                d.put("OMX.MARVELL.VIDEO.H264DECODER", 200);
                d.remove("OMX.Action.Video.Decoder");
                d.remove("OMX.allwinner.video.decoder.avc");
                d.remove("OMX.BRCM.vc4.decoder.avc");
                d.remove("OMX.brcm.video.h264.hw.decoder");
                d.remove("OMX.brcm.video.h264.decoder");
                d.remove("OMX.cosmo.video.decoder.avc");
                d.remove("OMX.duos.h264.decoder");
                d.remove("OMX.hantro.81x0.video.decoder");
                d.remove("OMX.hantro.G1.video.decoder");
                d.remove("OMX.hisi.video.decoder");
                d.remove("OMX.LG.decoder.video.avc");
                d.remove("OMX.MS.AVC.Decoder");
                d.remove("OMX.RENESAS.VIDEO.DECODER.H264");
                d.remove("OMX.RTK.video.decoder");
                d.remove("OMX.sprd.h264.decoder");
                d.remove("OMX.ST.VFM.H264Dec");
                d.remove("OMX.vpu.video_decoder.avc");
                d.remove("OMX.WMT.decoder.avc");
                d.remove("OMX.bluestacks.hw.decoder");
                d.put("OMX.google.h264.decoder", 200);
                d.put("OMX.google.h264.lc.decoder", 200);
                d.put("OMX.k3.ffmpeg.decoder", 200);
                d.put("OMX.ffmpeg.video.decoder", 200);
                d.put("OMX.sprd.soft.h264.decoder", 200);
                map = d;
            }
        }
        return map;
    }

    @TargetApi(16)
    public static c a(MediaCodecInfo mediaCodecInfo, String str) {
        int i = 200;
        if (mediaCodecInfo == null || Build.VERSION.SDK_INT < 16) {
            return null;
        }
        String name = mediaCodecInfo.getName();
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        String lowerCase = name.toLowerCase(Locale.US);
        if (!lowerCase.startsWith("omx.")) {
            i = 100;
        } else if (!lowerCase.startsWith("omx.pv") && !lowerCase.startsWith("omx.google.") && !lowerCase.startsWith("omx.ffmpeg.") && !lowerCase.startsWith("omx.k3.ffmpeg.") && !lowerCase.startsWith("omx.avcodec.")) {
            if (lowerCase.startsWith("omx.ittiam.")) {
                i = 0;
            } else if (lowerCase.startsWith("omx.mtk.")) {
                i = Build.VERSION.SDK_INT < 18 ? 0 : CyberPlayerManager.MEDIA_INFO_BAD_INTERLEAVING;
            } else {
                Integer num = a().get(lowerCase);
                if (num != null) {
                    i = num.intValue();
                } else {
                    try {
                        i = mediaCodecInfo.getCapabilitiesForType(str) != null ? CyberPlayerManager.MEDIA_INFO_VIDEO_TRACK_LAGGING : 600;
                    } catch (Throwable th) {
                        i = 600;
                    }
                }
            }
        }
        c cVar = new c();
        cVar.a = mediaCodecInfo;
        cVar.b = i;
        cVar.c = str;
        return cVar;
    }
}
