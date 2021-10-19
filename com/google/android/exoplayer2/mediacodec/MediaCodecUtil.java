package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.google.android.material.internal.ManufacturerUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@SuppressLint({"InlinedApi"})
@TargetApi(16)
/* loaded from: classes9.dex */
public final class MediaCodecUtil {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final c.i.b.a.b0.a f70448a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f70449b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<b, List<c.i.b.a.b0.a>> f70450c;

    /* renamed from: d  reason: collision with root package name */
    public static final SparseIntArray f70451d;

    /* renamed from: e  reason: collision with root package name */
    public static final SparseIntArray f70452e;

    /* renamed from: f  reason: collision with root package name */
    public static final Map<String, Integer> f70453f;

    /* renamed from: g  reason: collision with root package name */
    public static int f70454g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class DecoderQueryException extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ DecoderQueryException(Throwable th, a aVar) {
            this(th);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f70455a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f70456b;

        public b(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70455a = str;
            this.f70456b = z;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || obj.getClass() != b.class) {
                    return false;
                }
                b bVar = (b) obj;
                return TextUtils.equals(this.f70455a, bVar.f70455a) && this.f70456b == bVar.f70456b;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String str = this.f70455a;
                return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.f70456b ? 1231 : 1237);
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        MediaCodecInfo a(int i2);

        boolean b(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        int c();

        boolean d();
    }

    /* loaded from: classes9.dex */
    public static final class d implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public MediaCodecInfo a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? MediaCodecList.getCodecInfoAt(i2) : (MediaCodecInfo) invokeI.objValue;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean b(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, codecCapabilities)) == null) ? "video/avc".equals(str) : invokeLL.booleanValue;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? MediaCodecList.getCodecCount() : invokeV.intValue;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    @TargetApi(21)
    /* loaded from: classes9.dex */
    public static final class e implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f70457a;

        /* renamed from: b  reason: collision with root package name */
        public MediaCodecInfo[] f70458b;

        public e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70457a = z ? 1 : 0;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public MediaCodecInfo a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                e();
                return this.f70458b[i2];
            }
            return (MediaCodecInfo) invokeI.objValue;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean b(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, codecCapabilities)) == null) ? codecCapabilities.isFeatureSupported("secure-playback") : invokeLL.booleanValue;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                e();
                return this.f70458b.length;
            }
            return invokeV.intValue;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f70458b == null) {
                this.f70458b = new MediaCodecList(this.f70457a).getCodecInfos();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(750018856, "Lcom/google/android/exoplayer2/mediacodec/MediaCodecUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(750018856, "Lcom/google/android/exoplayer2/mediacodec/MediaCodecUtil;");
                return;
            }
        }
        f70448a = c.i.b.a.b0.a.r("OMX.google.raw.decoder");
        f70449b = Pattern.compile("^\\D?(\\d+)$");
        f70450c = new HashMap<>();
        f70454g = -1;
        SparseIntArray sparseIntArray = new SparseIntArray();
        f70451d = sparseIntArray;
        sparseIntArray.put(66, 1);
        f70451d.put(77, 2);
        f70451d.put(88, 4);
        f70451d.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f70452e = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        f70452e.put(11, 4);
        f70452e.put(12, 8);
        f70452e.put(13, 16);
        f70452e.put(20, 32);
        f70452e.put(21, 64);
        f70452e.put(22, 128);
        f70452e.put(30, 256);
        f70452e.put(31, 512);
        f70452e.put(32, 1024);
        f70452e.put(40, 2048);
        f70452e.put(41, 4096);
        f70452e.put(42, 8192);
        f70452e.put(50, 16384);
        f70452e.put(51, 32768);
        f70452e.put(52, 65536);
        HashMap hashMap = new HashMap();
        f70453f = hashMap;
        hashMap.put("L30", 1);
        f70453f.put("L60", 4);
        f70453f.put("L63", 16);
        f70453f.put("L90", 64);
        f70453f.put("L93", 256);
        f70453f.put("L120", 1024);
        f70453f.put("L123", 4096);
        f70453f.put("L150", 16384);
        f70453f.put("L153", 65536);
        f70453f.put("L156", 262144);
        f70453f.put("L180", 1048576);
        f70453f.put("L183", 4194304);
        f70453f.put("L186", 16777216);
        f70453f.put("H30", 2);
        f70453f.put("H60", 8);
        f70453f.put("H63", 32);
        f70453f.put("H90", 128);
        f70453f.put("H93", 512);
        f70453f.put("H120", 2048);
        f70453f.put("H123", 8192);
        f70453f.put("H150", 32768);
        f70453f.put("H153", 131072);
        f70453f.put("H156", 524288);
        f70453f.put("H180", 2097152);
        f70453f.put("H183", 8388608);
        f70453f.put("H186", 33554432);
    }

    public static void a(List<c.i.b.a.b0.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || v.f33865a >= 26) {
            return;
        }
        if (list.size() <= 1 || !"OMX.MTK.AUDIO.DECODER.RAW".equals(list.get(0).f33001a)) {
            return;
        }
        for (int i2 = 1; i2 < list.size(); i2++) {
            c.i.b.a.b0.a aVar = list.get(i2);
            if ("OMX.google.raw.decoder".equals(aVar.f33001a)) {
                list.remove(i2);
                list.add(0, aVar);
                return;
            }
        }
    }

    public static int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 == 1 || i2 == 2) {
                return 25344;
            }
            switch (i2) {
                case 8:
                case 16:
                case 32:
                    return 101376;
                case 64:
                    return 202752;
                case 128:
                case 256:
                    return 414720;
                case 512:
                    return 921600;
                case 1024:
                    return 1310720;
                case 2048:
                case 4096:
                    return 2097152;
                case 8192:
                    return 2228224;
                case 16384:
                    return 5652480;
                case 32768:
                case 65536:
                    return 9437184;
                default:
                    return -1;
            }
        }
        return invokeI.intValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? v.f33865a <= 22 && (v.f33868d.equals("ODROID-XU3") || v.f33868d.equals("Nexus 10")) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str)) : invokeL.booleanValue;
    }

    public static Pair<Integer, Integer> d(String str, String[] strArr) {
        InterceptResult invokeLL;
        Integer valueOf;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, strArr)) == null) {
            if (strArr.length < 2) {
                String str2 = "Ignoring malformed AVC codec string: " + str;
                return null;
            }
            try {
                if (strArr[1].length() == 6) {
                    num = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                    valueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
                } else if (strArr.length >= 3) {
                    Integer valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1]));
                    valueOf = Integer.valueOf(Integer.parseInt(strArr[2]));
                    num = valueOf2;
                } else {
                    String str3 = "Ignoring malformed AVC codec string: " + str;
                    return null;
                }
                Integer valueOf3 = Integer.valueOf(f70451d.get(num.intValue()));
                if (valueOf3 == null) {
                    String str4 = "Unknown AVC profile: " + num;
                    return null;
                }
                Integer valueOf4 = Integer.valueOf(f70452e.get(valueOf.intValue()));
                if (valueOf4 == null) {
                    String str5 = "Unknown AVC level: " + valueOf;
                    return null;
                }
                return new Pair<>(valueOf3, valueOf4);
            } catch (NumberFormatException unused) {
                String str6 = "Ignoring malformed AVC codec string: " + str;
                return null;
            }
        }
        return (Pair) invokeLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r3.equals("hev1") != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Integer> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (str == null) {
                return null;
            }
            String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            char c2 = 0;
            String str2 = split[0];
            switch (str2.hashCode()) {
                case 3006243:
                    if (str2.equals(VisualSampleEntry.TYPE3)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3006244:
                    if (str2.equals("avc2")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3199032:
                    break;
                case 3214780:
                    if (str2.equals("hvc1")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0 || c2 == 1) {
                return i(str, split);
            }
            if (c2 == 2 || c2 == 3) {
                return d(str, split);
            }
            return null;
        }
        return (Pair) invokeL.objValue;
    }

    public static c.i.b.a.b0.a f(String str, boolean z) throws DecoderQueryException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, null, str, z)) == null) {
            List<c.i.b.a.b0.a> g2 = g(str, z);
            if (g2.isEmpty()) {
                return null;
            }
            return g2.get(0);
        }
        return (c.i.b.a.b0.a) invokeLZ.objValue;
    }

    public static synchronized List<c.i.b.a.b0.a> g(String str, boolean z) throws DecoderQueryException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, str, z)) == null) {
            synchronized (MediaCodecUtil.class) {
                b bVar = new b(str, z);
                List<c.i.b.a.b0.a> list = f70450c.get(bVar);
                if (list != null) {
                    return list;
                }
                List<c.i.b.a.b0.a> h2 = h(bVar, v.f33865a >= 21 ? new e(z) : new d(null));
                if (z && h2.isEmpty() && 21 <= v.f33865a && v.f33865a <= 23) {
                    h2 = h(bVar, new d(null));
                    if (!h2.isEmpty()) {
                        String str2 = "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + h2.get(0).f33001a;
                    }
                }
                a(h2);
                List<c.i.b.a.b0.a> unmodifiableList = Collections.unmodifiableList(h2);
                f70450c.put(bVar, unmodifiableList);
                return unmodifiableList;
            }
        }
        return (List) invokeLZ.objValue;
    }

    public static List<c.i.b.a.b0.a> h(b bVar, c cVar) throws DecoderQueryException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, bVar, cVar)) == null) {
            c cVar2 = cVar;
            try {
                ArrayList arrayList = new ArrayList();
                String str = bVar.f70455a;
                int c2 = cVar.c();
                boolean d2 = cVar.d();
                int i2 = 0;
                while (i2 < c2) {
                    MediaCodecInfo a2 = cVar2.a(i2);
                    String name = a2.getName();
                    if (k(a2, name, d2)) {
                        String[] supportedTypes = a2.getSupportedTypes();
                        int length = supportedTypes.length;
                        int i3 = 0;
                        while (i3 < length) {
                            String str2 = supportedTypes[i3];
                            if (str2.equalsIgnoreCase(str)) {
                                try {
                                    MediaCodecInfo.CodecCapabilities capabilitiesForType = a2.getCapabilitiesForType(str2);
                                    boolean b2 = cVar2.b(str, capabilitiesForType);
                                    boolean c3 = c(name);
                                    if (d2) {
                                        if (bVar.f70456b != b2) {
                                        }
                                        arrayList.add(c.i.b.a.b0.a.q(name, str, capabilitiesForType, c3, false));
                                    }
                                    if (!d2 && !bVar.f70456b) {
                                        arrayList.add(c.i.b.a.b0.a.q(name, str, capabilitiesForType, c3, false));
                                    } else if (!d2 && b2) {
                                        arrayList.add(c.i.b.a.b0.a.q(name + ".secure", str, capabilitiesForType, c3, true));
                                        return arrayList;
                                    }
                                } catch (Exception e2) {
                                    if (v.f33865a <= 23 && !arrayList.isEmpty()) {
                                        String str3 = "Skipping codec " + name + " (failed to query capabilities)";
                                    } else {
                                        String str4 = "Failed to query codec " + name + " (" + str2 + SmallTailInfo.EMOTION_SUFFIX;
                                        throw e2;
                                    }
                                }
                            }
                            i3++;
                            cVar2 = cVar;
                        }
                        continue;
                    }
                    i2++;
                    cVar2 = cVar;
                }
                return arrayList;
            } catch (Exception e3) {
                throw new DecoderQueryException(e3, null);
            }
        }
        return (List) invokeLL.objValue;
    }

    public static Pair<Integer, Integer> i(String str, String[] strArr) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, strArr)) == null) {
            if (strArr.length < 4) {
                String str2 = "Ignoring malformed HEVC codec string: " + str;
                return null;
            }
            Matcher matcher = f70449b.matcher(strArr[1]);
            if (!matcher.matches()) {
                String str3 = "Ignoring malformed HEVC codec string: " + str;
                return null;
            }
            String group = matcher.group(1);
            if ("1".equals(group)) {
                i2 = 1;
            } else if (!"2".equals(group)) {
                String str4 = "Unknown HEVC profile string: " + group;
                return null;
            } else {
                i2 = 2;
            }
            Integer num = f70453f.get(strArr[3]);
            if (num == null) {
                String str5 = "Unknown HEVC level string: " + matcher.group(1);
                return null;
            }
            return new Pair<>(Integer.valueOf(i2), num);
        }
        return (Pair) invokeLL.objValue;
    }

    public static c.i.b.a.b0.a j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? f70448a : (c.i.b.a.b0.a) invokeV.objValue;
    }

    public static boolean k(MediaCodecInfo mediaCodecInfo, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65547, null, mediaCodecInfo, str, z)) == null) {
            if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
                return false;
            }
            if (v.f33865a >= 21 || !("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
                if (v.f33865a >= 18 || !"OMX.SEC.MP3.Decoder".equals(str)) {
                    if (v.f33865a < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str) && ("a70".equals(v.f33866b) || ("Xiaomi".equals(v.f33867c) && v.f33866b.startsWith("HM")))) {
                        return false;
                    }
                    if (v.f33865a == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) && ("dlxu".equals(v.f33866b) || "protou".equals(v.f33866b) || "ville".equals(v.f33866b) || "villeplus".equals(v.f33866b) || "villec2".equals(v.f33866b) || v.f33866b.startsWith("gee") || "C6602".equals(v.f33866b) || "C6603".equals(v.f33866b) || "C6606".equals(v.f33866b) || "C6616".equals(v.f33866b) || "L36h".equals(v.f33866b) || "SO-02E".equals(v.f33866b))) {
                        return false;
                    }
                    if (v.f33865a == 16 && "OMX.qcom.audio.decoder.aac".equals(str) && ("C1504".equals(v.f33866b) || "C1505".equals(v.f33866b) || "C1604".equals(v.f33866b) || "C1605".equals(v.f33866b))) {
                        return false;
                    }
                    if (v.f33865a >= 24 || !(("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && v.f33867c.equals(ManufacturerUtils.SAMSUNG) && (v.f33866b.startsWith("zeroflte") || v.f33866b.startsWith("zerolte") || v.f33866b.startsWith("zenlte") || v.f33866b.equals("SC-05G") || v.f33866b.equals("marinelteatt") || v.f33866b.equals("404SC") || v.f33866b.equals("SC-04G") || v.f33866b.equals("SCV31")))) {
                        if (v.f33865a <= 19 && "OMX.SEC.vp8.dec".equals(str) && ManufacturerUtils.SAMSUNG.equals(v.f33867c) && (v.f33866b.startsWith("d2") || v.f33866b.startsWith("serrano") || v.f33866b.startsWith("jflte") || v.f33866b.startsWith("santos") || v.f33866b.startsWith("t0"))) {
                            return false;
                        }
                        return (v.f33865a <= 19 && v.f33866b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) ? false : true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public static int l() throws DecoderQueryException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (f70454g == -1) {
                int i2 = 0;
                c.i.b.a.b0.a f2 = f("video/avc", false);
                if (f2 != null) {
                    MediaCodecInfo.CodecProfileLevel[] d2 = f2.d();
                    int length = d2.length;
                    int i3 = 0;
                    while (i2 < length) {
                        i3 = Math.max(b(d2[i2].level), i3);
                        i2++;
                    }
                    i2 = Math.max(i3, v.f33865a >= 21 ? 345600 : 172800);
                }
                f70454g = i2;
            }
            return f70454g;
        }
        return invokeV.intValue;
    }
}
