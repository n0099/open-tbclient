package d.a.b0.a;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static Map<String, Integer> f43809c;

    /* renamed from: d  reason: collision with root package name */
    public static MediaCodecInfo[] f43810d;

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, MediaCodecInfo> f43811e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MediaCodecInfo f43812a;

    /* renamed from: b  reason: collision with root package name */
    public int f43813b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(547516097, "Ld/a/b0/a/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(547516097, "Ld/a/b0/a/d;");
                return;
            }
        }
        f43809c = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        f43811e = new HashMap();
        f43809c.put("OMX.Nvidia.h264.decode", 800);
        f43809c.put("OMX.Nvidia.h264.decode.secure", 300);
        f43809c.put("OMX.Intel.hw_vd.h264", 801);
        f43809c.put("OMX.Intel.VideoDecoder.AVC", 800);
        f43809c.put("OMX.qcom.video.decoder.avc", 800);
        f43809c.put("OMX.ittiam.video.decoder.avc", 0);
        f43809c.put("OMX.SEC.avc.dec", 800);
        f43809c.put("OMX.SEC.AVC.Decoder", 799);
        f43809c.put("OMX.SEC.avcdec", 798);
        f43809c.put("OMX.SEC.avc.sw.dec", 200);
        f43809c.put("OMX.Exynos.avc.dec", 800);
        f43809c.put("OMX.Exynos.AVC.Decoder", 799);
        f43809c.put("OMX.k3.video.decoder.avc", 800);
        f43809c.put("OMX.IMG.MSVDX.Decoder.AVC", 800);
        f43809c.put("OMX.TI.DUCATI1.VIDEO.DECODER", 800);
        f43809c.put("OMX.rk.video_decoder.avc", 800);
        f43809c.put("OMX.amlogic.avc.decoder.awesome", 800);
        f43809c.put("OMX.MARVELL.VIDEO.HW.CODA7542DECODER", 800);
        f43809c.put("OMX.MARVELL.VIDEO.H264DECODER", 200);
        f43809c.put("OMX.allwinner.video.decoder.avc", 0);
        f43809c.remove("OMX.Action.Video.Decoder");
        f43809c.remove("OMX.BRCM.vc4.decoder.avc");
        f43809c.remove("OMX.brcm.video.h264.hw.decoder");
        f43809c.remove("OMX.brcm.video.h264.decoder");
        f43809c.remove("OMX.cosmo.video.decoder.avc");
        f43809c.remove("OMX.duos.h264.decoder");
        f43809c.remove("OMX.hantro.81x0.video.decoder");
        f43809c.remove("OMX.hantro.G1.video.decoder");
        f43809c.remove("OMX.hisi.video.decoder");
        f43809c.remove("OMX.LG.decoder.video.avc");
        f43809c.remove("OMX.MS.AVC.Decoder");
        f43809c.remove("OMX.RENESAS.VIDEO.DECODER.H264");
        f43809c.remove("OMX.RTK.video.decoder");
        f43809c.remove("OMX.sprd.h264.decoder");
        f43809c.remove("OMX.ST.VFM.H264Dec");
        f43809c.remove("OMX.vpu.video_decoder.avc");
        f43809c.remove("OMX.WMT.decoder.avc");
        f43809c.remove("OMX.bluestacks.hw.decoder");
        f43809c.put("OMX.google.h264.decoder", 200);
        f43809c.put("OMX.google.h264.lc.decoder", 200);
        f43809c.put("OMX.k3.ffmpeg.decoder", 200);
        f43809c.put("OMX.ffmpeg.video.decoder", 200);
        f43809c.put("OMX.sprd.soft.h264.decoder", 200);
        f43809c.put("OMX.google.hevc.decoder", 200);
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f43813b = 0;
    }

    @TargetApi(16)
    public static d a(MediaCodecInfo mediaCodecInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, mediaCodecInfo, str)) == null) {
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
                        Integer num = f43809c.get(lowerCase);
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
            dVar.f43812a = mediaCodecInfo;
            dVar.f43813b = i2;
            return dVar;
        }
        return (d) invokeLL.objValue;
    }

    public static synchronized String b(String str) {
        InterceptResult invokeL;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            synchronized (d.class) {
                c2 = c(str, -1, -1, 0.0d);
            }
            return c2;
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str, int i2, int i3, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d2)})) == null) {
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
        return (String) invokeCommon.objValue;
    }

    public static synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            synchronized (d.class) {
                if (f43810d != null) {
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
                    f43810d = (MediaCodecInfo[]) arrayList.toArray(new MediaCodecInfo[arrayList.size()]);
                } else {
                    f43810d = new MediaCodecList(0).getCodecInfos();
                }
                e("video/avc");
                e("video/hevc");
            }
        }
    }

    public static MediaCodecInfo e(String str) {
        InterceptResult invokeL;
        String[] supportedTypes;
        d a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            MediaCodecInfo mediaCodecInfo = f43811e.get(str);
            if (mediaCodecInfo != null) {
                return mediaCodecInfo;
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                MediaCodecInfo[] mediaCodecInfoArr = f43810d;
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
                if (dVar2.f43813b > dVar.f43813b) {
                    dVar = dVar2;
                }
            }
            if (dVar.f43813b < 600) {
                return null;
            }
            f43811e.put(str, dVar.f43812a);
            return dVar.f43812a;
        }
        return (MediaCodecInfo) invokeL.objValue;
    }
}
