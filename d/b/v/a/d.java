package d.b.v.a;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static MediaCodecInfo[] f65509d;

    /* renamed from: a  reason: collision with root package name */
    public MediaCodecInfo f65511a;

    /* renamed from: b  reason: collision with root package name */
    public int f65512b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, Integer> f65508c = new TreeMap(String.CASE_INSENSITIVE_ORDER);

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, MediaCodecInfo> f65510e = new HashMap();

    static {
        f65508c.put("OMX.Nvidia.h264.decode", 800);
        f65508c.put("OMX.Nvidia.h264.decode.secure", 300);
        f65508c.put("OMX.Intel.hw_vd.h264", 801);
        f65508c.put("OMX.Intel.VideoDecoder.AVC", 800);
        f65508c.put("OMX.qcom.video.decoder.avc", 800);
        f65508c.put("OMX.ittiam.video.decoder.avc", 0);
        f65508c.put("OMX.SEC.avc.dec", 800);
        f65508c.put("OMX.SEC.AVC.Decoder", 799);
        f65508c.put("OMX.SEC.avcdec", 798);
        f65508c.put("OMX.SEC.avc.sw.dec", 200);
        f65508c.put("OMX.Exynos.avc.dec", 800);
        f65508c.put("OMX.Exynos.AVC.Decoder", 799);
        f65508c.put("OMX.k3.video.decoder.avc", 800);
        f65508c.put("OMX.IMG.MSVDX.Decoder.AVC", 800);
        f65508c.put("OMX.TI.DUCATI1.VIDEO.DECODER", 800);
        f65508c.put("OMX.rk.video_decoder.avc", 800);
        f65508c.put("OMX.amlogic.avc.decoder.awesome", 800);
        f65508c.put("OMX.MARVELL.VIDEO.HW.CODA7542DECODER", 800);
        f65508c.put("OMX.MARVELL.VIDEO.H264DECODER", 200);
        f65508c.remove("OMX.Action.Video.Decoder");
        f65508c.remove("OMX.allwinner.video.decoder.avc");
        f65508c.remove("OMX.BRCM.vc4.decoder.avc");
        f65508c.remove("OMX.brcm.video.h264.hw.decoder");
        f65508c.remove("OMX.brcm.video.h264.decoder");
        f65508c.remove("OMX.cosmo.video.decoder.avc");
        f65508c.remove("OMX.duos.h264.decoder");
        f65508c.remove("OMX.hantro.81x0.video.decoder");
        f65508c.remove("OMX.hantro.G1.video.decoder");
        f65508c.remove("OMX.hisi.video.decoder");
        f65508c.remove("OMX.LG.decoder.video.avc");
        f65508c.remove("OMX.MS.AVC.Decoder");
        f65508c.remove("OMX.RENESAS.VIDEO.DECODER.H264");
        f65508c.remove("OMX.RTK.video.decoder");
        f65508c.remove("OMX.sprd.h264.decoder");
        f65508c.remove("OMX.ST.VFM.H264Dec");
        f65508c.remove("OMX.vpu.video_decoder.avc");
        f65508c.remove("OMX.WMT.decoder.avc");
        f65508c.remove("OMX.bluestacks.hw.decoder");
        f65508c.put("OMX.google.h264.decoder", 200);
        f65508c.put("OMX.google.h264.lc.decoder", 200);
        f65508c.put("OMX.k3.ffmpeg.decoder", 200);
        f65508c.put("OMX.ffmpeg.video.decoder", 200);
        f65508c.put("OMX.sprd.soft.h264.decoder", 200);
    }

    @TargetApi(16)
    public static d a(MediaCodecInfo mediaCodecInfo, String str) {
        if (mediaCodecInfo == null || Build.VERSION.SDK_INT < 16) {
            return null;
        }
        String name = mediaCodecInfo.getName();
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        String lowerCase = name.toLowerCase(Locale.US);
        int i = 600;
        if (!lowerCase.startsWith("omx.")) {
            i = 100;
        } else if (lowerCase.startsWith("omx.pv") || ((lowerCase.startsWith("omx.google.") && !lowerCase.equals("omx.google.hevc.decoder")) || lowerCase.startsWith("omx.ffmpeg.") || lowerCase.startsWith("omx.k3.ffmpeg.") || lowerCase.startsWith("omx.avcodec."))) {
            i = 200;
        } else {
            if (!lowerCase.startsWith("omx.ittiam.")) {
                if (!lowerCase.startsWith("omx.mtk.")) {
                    Integer num = f65508c.get(lowerCase);
                    if (num != null) {
                        i = num.intValue();
                    } else {
                        try {
                            if (mediaCodecInfo.getCapabilitiesForType(str) != null) {
                                i = 700;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                } else if (Build.VERSION.SDK_INT >= 18) {
                    i = 800;
                }
            }
            i = 0;
        }
        d dVar = new d();
        dVar.f65511a = mediaCodecInfo;
        dVar.f65512b = i;
        return dVar;
    }

    public static synchronized String b(String str) {
        String c2;
        synchronized (d.class) {
            c2 = c(str, -1, -1, 0.0d);
        }
        return c2;
    }

    public static String c(String str, int i, int i2, double d2) {
        d();
        MediaCodecInfo e2 = e(str);
        if (e2 != null) {
            boolean z = true;
            if (Build.VERSION.SDK_INT >= 21 && i > 0 && i2 > 0) {
                int i3 = (d2 > 0.0d ? 1 : (d2 == 0.0d ? 0 : -1));
                MediaCodecInfo.VideoCapabilities videoCapabilities = e2.getCapabilitiesForType(str).getVideoCapabilities();
                z = i3 > 0 ? videoCapabilities.areSizeAndRateSupported(i, i2, d2) : videoCapabilities.isSizeSupported(i, i2);
            }
            if (z) {
                CyberLog.d("CyberMediaCodecInfo", "mineType:" + str + " decoder:" + e2.getName());
                return e2.getName();
            }
            CyberLog.d("CyberMediaCodecInfo", "decoder not support [" + e2.getName() + "," + i + "," + i2 + "," + d2 + "]");
            return null;
        }
        return null;
    }

    public static synchronized void d() {
        synchronized (d.class) {
            if (f65509d != null) {
                return;
            }
            if (Build.VERSION.SDK_INT < 16) {
                return;
            }
            if (Build.VERSION.SDK_INT < 21) {
                ArrayList arrayList = new ArrayList();
                int codecCount = MediaCodecList.getCodecCount();
                for (int i = 0; i < codecCount; i++) {
                    arrayList.add(MediaCodecList.getCodecInfoAt(i));
                }
                f65509d = (MediaCodecInfo[]) arrayList.toArray(new MediaCodecInfo[arrayList.size()]);
            } else {
                f65509d = new MediaCodecList(0).getCodecInfos();
            }
            if (CyberCfgManager.getInstance().getCfgBoolValue("enable_mc_google_hevc_decoder", true)) {
                f65508c.put("OMX.google.hevc.decoder", 601);
                CyberLog.i("CyberMediaCodecInfo", "enable_mc_google_hevc_decoder add");
            } else {
                f65508c.put("OMX.google.hevc.decoder", 200);
            }
            e("video/avc");
            e("video/hevc");
        }
    }

    public static MediaCodecInfo e(String str) {
        String[] supportedTypes;
        d a2;
        MediaCodecInfo mediaCodecInfo = f65510e.get(str);
        if (mediaCodecInfo != null) {
            return mediaCodecInfo;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            MediaCodecInfo[] mediaCodecInfoArr = f65509d;
            if (i >= mediaCodecInfoArr.length) {
                break;
            }
            MediaCodecInfo mediaCodecInfo2 = mediaCodecInfoArr[i];
            if (!mediaCodecInfo2.isEncoder() && (supportedTypes = mediaCodecInfo2.getSupportedTypes()) != null) {
                for (String str2 : supportedTypes) {
                    if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(str) && (a2 = a(mediaCodecInfo2, str)) != null) {
                        arrayList.add(a2);
                    }
                }
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        d dVar = (d) arrayList.get(0);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d dVar2 = (d) it.next();
            if (dVar2.f65512b > dVar.f65512b) {
                dVar = dVar2;
            }
        }
        if (dVar.f65512b < 600) {
            return null;
        }
        f65510e.put(str, dVar.f65511a);
        return dVar.f65511a;
    }
}
