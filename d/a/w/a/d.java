package d.a.w.a;

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
    public static MediaCodecInfo[] f64127d;

    /* renamed from: a  reason: collision with root package name */
    public MediaCodecInfo f64129a;

    /* renamed from: b  reason: collision with root package name */
    public int f64130b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, Integer> f64126c = new TreeMap(String.CASE_INSENSITIVE_ORDER);

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, MediaCodecInfo> f64128e = new HashMap();

    static {
        f64126c.put("OMX.Nvidia.h264.decode", 800);
        f64126c.put("OMX.Nvidia.h264.decode.secure", 300);
        f64126c.put("OMX.Intel.hw_vd.h264", 801);
        f64126c.put("OMX.Intel.VideoDecoder.AVC", 800);
        f64126c.put("OMX.qcom.video.decoder.avc", 800);
        f64126c.put("OMX.ittiam.video.decoder.avc", 0);
        f64126c.put("OMX.SEC.avc.dec", 800);
        f64126c.put("OMX.SEC.AVC.Decoder", 799);
        f64126c.put("OMX.SEC.avcdec", 798);
        f64126c.put("OMX.SEC.avc.sw.dec", 200);
        f64126c.put("OMX.Exynos.avc.dec", 800);
        f64126c.put("OMX.Exynos.AVC.Decoder", 799);
        f64126c.put("OMX.k3.video.decoder.avc", 800);
        f64126c.put("OMX.IMG.MSVDX.Decoder.AVC", 800);
        f64126c.put("OMX.TI.DUCATI1.VIDEO.DECODER", 800);
        f64126c.put("OMX.rk.video_decoder.avc", 800);
        f64126c.put("OMX.amlogic.avc.decoder.awesome", 800);
        f64126c.put("OMX.MARVELL.VIDEO.HW.CODA7542DECODER", 800);
        f64126c.put("OMX.MARVELL.VIDEO.H264DECODER", 200);
        f64126c.remove("OMX.Action.Video.Decoder");
        f64126c.remove("OMX.allwinner.video.decoder.avc");
        f64126c.remove("OMX.BRCM.vc4.decoder.avc");
        f64126c.remove("OMX.brcm.video.h264.hw.decoder");
        f64126c.remove("OMX.brcm.video.h264.decoder");
        f64126c.remove("OMX.cosmo.video.decoder.avc");
        f64126c.remove("OMX.duos.h264.decoder");
        f64126c.remove("OMX.hantro.81x0.video.decoder");
        f64126c.remove("OMX.hantro.G1.video.decoder");
        f64126c.remove("OMX.hisi.video.decoder");
        f64126c.remove("OMX.LG.decoder.video.avc");
        f64126c.remove("OMX.MS.AVC.Decoder");
        f64126c.remove("OMX.RENESAS.VIDEO.DECODER.H264");
        f64126c.remove("OMX.RTK.video.decoder");
        f64126c.remove("OMX.sprd.h264.decoder");
        f64126c.remove("OMX.ST.VFM.H264Dec");
        f64126c.remove("OMX.vpu.video_decoder.avc");
        f64126c.remove("OMX.WMT.decoder.avc");
        f64126c.remove("OMX.bluestacks.hw.decoder");
        f64126c.put("OMX.google.h264.decoder", 200);
        f64126c.put("OMX.google.h264.lc.decoder", 200);
        f64126c.put("OMX.k3.ffmpeg.decoder", 200);
        f64126c.put("OMX.ffmpeg.video.decoder", 200);
        f64126c.put("OMX.sprd.soft.h264.decoder", 200);
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
        int i2 = 600;
        if (!lowerCase.startsWith("omx.")) {
            i2 = 100;
        } else if (lowerCase.startsWith("omx.pv") || ((lowerCase.startsWith("omx.google.") && !lowerCase.equals("omx.google.hevc.decoder")) || lowerCase.startsWith("omx.ffmpeg.") || lowerCase.startsWith("omx.k3.ffmpeg.") || lowerCase.startsWith("omx.avcodec."))) {
            i2 = 200;
        } else {
            if (!lowerCase.startsWith("omx.ittiam.")) {
                if (!lowerCase.startsWith("omx.mtk.")) {
                    Integer num = f64126c.get(lowerCase);
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
        d dVar = new d();
        dVar.f64129a = mediaCodecInfo;
        dVar.f64130b = i2;
        return dVar;
    }

    public static synchronized String b(String str) {
        String c2;
        synchronized (d.class) {
            c2 = c(str, -1, -1, 0.0d);
        }
        return c2;
    }

    public static String c(String str, int i2, int i3, double d2) {
        d();
        MediaCodecInfo e2 = e(str);
        if (e2 != null) {
            boolean z = true;
            if (Build.VERSION.SDK_INT >= 21 && i2 > 0 && i3 > 0) {
                int i4 = (d2 > 0.0d ? 1 : (d2 == 0.0d ? 0 : -1));
                MediaCodecInfo.VideoCapabilities videoCapabilities = e2.getCapabilitiesForType(str).getVideoCapabilities();
                z = i4 > 0 ? videoCapabilities.areSizeAndRateSupported(i2, i3, d2) : videoCapabilities.isSizeSupported(i2, i3);
            }
            if (z) {
                CyberLog.d("CyberMediaCodecInfo", "mineType:" + str + " decoder:" + e2.getName());
                return e2.getName();
            }
            CyberLog.d("CyberMediaCodecInfo", "decoder not support [" + e2.getName() + "," + i2 + "," + i3 + "," + d2 + "]");
            return null;
        }
        return null;
    }

    public static synchronized void d() {
        synchronized (d.class) {
            if (f64127d != null) {
                return;
            }
            if (Build.VERSION.SDK_INT < 16) {
                return;
            }
            if (Build.VERSION.SDK_INT < 21) {
                ArrayList arrayList = new ArrayList();
                int codecCount = MediaCodecList.getCodecCount();
                for (int i2 = 0; i2 < codecCount; i2++) {
                    arrayList.add(MediaCodecList.getCodecInfoAt(i2));
                }
                f64127d = (MediaCodecInfo[]) arrayList.toArray(new MediaCodecInfo[arrayList.size()]);
            } else {
                f64127d = new MediaCodecList(0).getCodecInfos();
            }
            if (CyberCfgManager.getInstance().getCfgBoolValue("enable_mc_google_hevc_decoder", true)) {
                f64126c.put("OMX.google.hevc.decoder", 601);
                CyberLog.i("CyberMediaCodecInfo", "enable_mc_google_hevc_decoder add");
            } else {
                f64126c.put("OMX.google.hevc.decoder", 200);
            }
            e("video/avc");
            e("video/hevc");
        }
    }

    public static MediaCodecInfo e(String str) {
        String[] supportedTypes;
        d a2;
        MediaCodecInfo mediaCodecInfo = f64128e.get(str);
        if (mediaCodecInfo != null) {
            return mediaCodecInfo;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            MediaCodecInfo[] mediaCodecInfoArr = f64127d;
            if (i2 >= mediaCodecInfoArr.length) {
                break;
            }
            MediaCodecInfo mediaCodecInfo2 = mediaCodecInfoArr[i2];
            if (!mediaCodecInfo2.isEncoder() && (supportedTypes = mediaCodecInfo2.getSupportedTypes()) != null) {
                for (String str2 : supportedTypes) {
                    if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(str) && (a2 = a(mediaCodecInfo2, str)) != null) {
                        arrayList.add(a2);
                    }
                }
            }
            i2++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        d dVar = (d) arrayList.get(0);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d dVar2 = (d) it.next();
            if (dVar2.f64130b > dVar.f64130b) {
                dVar = dVar2;
            }
        }
        if (dVar.f64130b < 600) {
            return null;
        }
        f64128e.put(str, dVar.f64129a);
        return dVar.f64129a;
    }
}
