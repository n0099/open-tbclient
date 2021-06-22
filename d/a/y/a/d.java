package d.a.y.a;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static MediaCodecInfo[] f68689d;

    /* renamed from: a  reason: collision with root package name */
    public MediaCodecInfo f68691a;

    /* renamed from: b  reason: collision with root package name */
    public int f68692b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, Integer> f68688c = new TreeMap(String.CASE_INSENSITIVE_ORDER);

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, MediaCodecInfo> f68690e = new HashMap();

    static {
        f68688c.put("OMX.Nvidia.h264.decode", 800);
        f68688c.put("OMX.Nvidia.h264.decode.secure", 300);
        f68688c.put("OMX.Intel.hw_vd.h264", 801);
        f68688c.put("OMX.Intel.VideoDecoder.AVC", 800);
        f68688c.put("OMX.qcom.video.decoder.avc", 800);
        f68688c.put("OMX.ittiam.video.decoder.avc", 0);
        f68688c.put("OMX.SEC.avc.dec", 800);
        f68688c.put("OMX.SEC.AVC.Decoder", 799);
        f68688c.put("OMX.SEC.avcdec", 798);
        f68688c.put("OMX.SEC.avc.sw.dec", 200);
        f68688c.put("OMX.Exynos.avc.dec", 800);
        f68688c.put("OMX.Exynos.AVC.Decoder", 799);
        f68688c.put("OMX.k3.video.decoder.avc", 800);
        f68688c.put("OMX.IMG.MSVDX.Decoder.AVC", 800);
        f68688c.put("OMX.TI.DUCATI1.VIDEO.DECODER", 800);
        f68688c.put("OMX.rk.video_decoder.avc", 800);
        f68688c.put("OMX.amlogic.avc.decoder.awesome", 800);
        f68688c.put("OMX.MARVELL.VIDEO.HW.CODA7542DECODER", 800);
        f68688c.put("OMX.MARVELL.VIDEO.H264DECODER", 200);
        f68688c.put("OMX.allwinner.video.decoder.avc", 0);
        f68688c.remove("OMX.Action.Video.Decoder");
        f68688c.remove("OMX.BRCM.vc4.decoder.avc");
        f68688c.remove("OMX.brcm.video.h264.hw.decoder");
        f68688c.remove("OMX.brcm.video.h264.decoder");
        f68688c.remove("OMX.cosmo.video.decoder.avc");
        f68688c.remove("OMX.duos.h264.decoder");
        f68688c.remove("OMX.hantro.81x0.video.decoder");
        f68688c.remove("OMX.hantro.G1.video.decoder");
        f68688c.remove("OMX.hisi.video.decoder");
        f68688c.remove("OMX.LG.decoder.video.avc");
        f68688c.remove("OMX.MS.AVC.Decoder");
        f68688c.remove("OMX.RENESAS.VIDEO.DECODER.H264");
        f68688c.remove("OMX.RTK.video.decoder");
        f68688c.remove("OMX.sprd.h264.decoder");
        f68688c.remove("OMX.ST.VFM.H264Dec");
        f68688c.remove("OMX.vpu.video_decoder.avc");
        f68688c.remove("OMX.WMT.decoder.avc");
        f68688c.remove("OMX.bluestacks.hw.decoder");
        f68688c.put("OMX.google.h264.decoder", 200);
        f68688c.put("OMX.google.h264.lc.decoder", 200);
        f68688c.put("OMX.k3.ffmpeg.decoder", 200);
        f68688c.put("OMX.ffmpeg.video.decoder", 200);
        f68688c.put("OMX.sprd.soft.h264.decoder", 200);
        f68688c.put("OMX.google.hevc.decoder", 200);
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
                    Integer num = f68688c.get(lowerCase);
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
        dVar.f68691a = mediaCodecInfo;
        dVar.f68692b = i2;
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
            CyberLog.d("CyberMediaCodecInfo", "decoder not support [" + e2.getName() + "," + i2 + "," + i3 + "," + d2 + PreferencesUtil.RIGHT_MOUNT);
            return null;
        }
        return null;
    }

    public static synchronized void d() {
        synchronized (d.class) {
            if (f68689d != null) {
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
                f68689d = (MediaCodecInfo[]) arrayList.toArray(new MediaCodecInfo[arrayList.size()]);
            } else {
                f68689d = new MediaCodecList(0).getCodecInfos();
            }
            e("video/avc");
            e("video/hevc");
        }
    }

    public static MediaCodecInfo e(String str) {
        String[] supportedTypes;
        d a2;
        MediaCodecInfo mediaCodecInfo = f68690e.get(str);
        if (mediaCodecInfo != null) {
            return mediaCodecInfo;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            MediaCodecInfo[] mediaCodecInfoArr = f68689d;
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
            if (dVar2.f68692b > dVar.f68692b) {
                dVar = dVar2;
            }
        }
        if (dVar.f68692b < 600) {
            return null;
        }
        f68690e.put(str, dVar.f68691a);
        return dVar.f68691a;
    }
}
