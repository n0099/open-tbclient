package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Util;
import com.google.android.material.internal.ManufacturerUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public final class MediaCodecUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final SparseIntArray AVC_LEVEL_NUMBER_TO_CONST;
    public static final SparseIntArray AVC_PROFILE_NUMBER_TO_CONST;
    public static final String CODEC_ID_AVC1 = "avc1";
    public static final String CODEC_ID_AVC2 = "avc2";
    public static final String CODEC_ID_HEV1 = "hev1";
    public static final String CODEC_ID_HVC1 = "hvc1";
    public static final String GOOGLE_RAW_DECODER_NAME = "OMX.google.raw.decoder";
    public static final Map HEVC_CODEC_STRING_TO_PROFILE_LEVEL;
    public static final String MTK_RAW_DECODER_NAME = "OMX.MTK.AUDIO.DECODER.RAW";
    public static final MediaCodecInfo PASSTHROUGH_DECODER_INFO;
    public static final Pattern PROFILE_PATTERN;
    public static final String TAG = "MediaCodecUtil";
    public static final HashMap decoderInfosCache;
    public static int maxH264DecodableFrameSize;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.google.android.exoplayer2.mediacodec.MediaCodecUtil$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public interface MediaCodecListCompat {
        int getCodecCount();

        android.media.MediaCodecInfo getCodecInfoAt(int i);

        boolean isSecurePlaybackSupported(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean secureDecodersExplicit();
    }

    public static int avcLevelToMaxFrameSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i == 1 || i == 2) {
                return 25344;
            }
            switch (i) {
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

    /* loaded from: classes7.dex */
    public final class CodecKey {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String mimeType;
        public final boolean secure;

        public CodecKey(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mimeType = str;
            this.secure = z;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || obj.getClass() != CodecKey.class) {
                    return false;
                }
                CodecKey codecKey = (CodecKey) obj;
                if (TextUtils.equals(this.mimeType, codecKey.mimeType) && this.secure == codecKey.secure) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            int hashCode;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String str = this.mimeType;
                if (str == null) {
                    hashCode = 0;
                } else {
                    hashCode = str.hashCode();
                }
                int i2 = (hashCode + 31) * 31;
                if (this.secure) {
                    i = 1231;
                } else {
                    i = 1237;
                }
                return i2 + i;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class DecoderQueryException extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ DecoderQueryException(Throwable th, AnonymousClass1 anonymousClass1) {
            this(th);
        }
    }

    /* loaded from: classes7.dex */
    public final class MediaCodecListCompatV16 implements MediaCodecListCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean secureDecodersExplicit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public MediaCodecListCompatV16() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public int getCodecCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return MediaCodecList.getCodecCount();
            }
            return invokeV.intValue;
        }

        public /* synthetic */ MediaCodecListCompatV16(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public android.media.MediaCodecInfo getCodecInfoAt(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return MediaCodecList.getCodecInfoAt(i);
            }
            return (android.media.MediaCodecInfo) invokeI.objValue;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean isSecurePlaybackSupported(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, codecCapabilities)) == null) {
                return "video/avc".equals(str);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class MediaCodecListCompatV21 implements MediaCodecListCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int codecKind;
        public android.media.MediaCodecInfo[] mediaCodecInfos;

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean secureDecodersExplicit() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public MediaCodecListCompatV21(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.codecKind = z ? 1 : 0;
        }

        private void ensureMediaCodecInfosInitialized() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.mediaCodecInfos == null) {
                this.mediaCodecInfos = new MediaCodecList(this.codecKind).getCodecInfos();
            }
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public int getCodecCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ensureMediaCodecInfosInitialized();
                return this.mediaCodecInfos.length;
            }
            return invokeV.intValue;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public android.media.MediaCodecInfo getCodecInfoAt(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                ensureMediaCodecInfosInitialized();
                return this.mediaCodecInfos[i];
            }
            return (android.media.MediaCodecInfo) invokeI.objValue;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat
        public boolean isSecurePlaybackSupported(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, codecCapabilities)) == null) {
                return codecCapabilities.isFeatureSupported("secure-playback");
            }
            return invokeLL.booleanValue;
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
        PASSTHROUGH_DECODER_INFO = MediaCodecInfo.newPassthroughInstance(GOOGLE_RAW_DECODER_NAME);
        PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");
        decoderInfosCache = new HashMap();
        maxH264DecodableFrameSize = -1;
        SparseIntArray sparseIntArray = new SparseIntArray();
        AVC_PROFILE_NUMBER_TO_CONST = sparseIntArray;
        sparseIntArray.put(66, 1);
        AVC_PROFILE_NUMBER_TO_CONST.put(77, 2);
        AVC_PROFILE_NUMBER_TO_CONST.put(88, 4);
        AVC_PROFILE_NUMBER_TO_CONST.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        AVC_LEVEL_NUMBER_TO_CONST = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        AVC_LEVEL_NUMBER_TO_CONST.put(11, 4);
        AVC_LEVEL_NUMBER_TO_CONST.put(12, 8);
        AVC_LEVEL_NUMBER_TO_CONST.put(13, 16);
        AVC_LEVEL_NUMBER_TO_CONST.put(20, 32);
        AVC_LEVEL_NUMBER_TO_CONST.put(21, 64);
        AVC_LEVEL_NUMBER_TO_CONST.put(22, 128);
        AVC_LEVEL_NUMBER_TO_CONST.put(30, 256);
        AVC_LEVEL_NUMBER_TO_CONST.put(31, 512);
        AVC_LEVEL_NUMBER_TO_CONST.put(32, 1024);
        AVC_LEVEL_NUMBER_TO_CONST.put(40, 2048);
        AVC_LEVEL_NUMBER_TO_CONST.put(41, 4096);
        AVC_LEVEL_NUMBER_TO_CONST.put(42, 8192);
        AVC_LEVEL_NUMBER_TO_CONST.put(50, 16384);
        AVC_LEVEL_NUMBER_TO_CONST.put(51, 32768);
        AVC_LEVEL_NUMBER_TO_CONST.put(52, 65536);
        HashMap hashMap = new HashMap();
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL = hashMap;
        hashMap.put("L30", 1);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L60", 4);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L63", 16);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L90", 64);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L93", 256);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L120", 1024);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L123", 4096);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L150", 16384);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L153", 65536);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L156", 262144);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L180", 1048576);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L183", 4194304);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("L186", 16777216);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H30", 2);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H60", 8);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H63", 32);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H90", 128);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H93", 512);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H120", 2048);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H123", 8192);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H150", 32768);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H153", 131072);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H156", 524288);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H180", 2097152);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H183", 8388608);
        HEVC_CODEC_STRING_TO_PROFILE_LEVEL.put("H186", 33554432);
    }

    public MediaCodecUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static MediaCodecInfo getPassthroughDecoderInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return PASSTHROUGH_DECODER_INFO;
        }
        return (MediaCodecInfo) invokeV.objValue;
    }

    public static void applyWorkarounds(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, list) == null) && Util.SDK_INT < 26) {
            if (list.size() > 1 && MTK_RAW_DECODER_NAME.equals(((MediaCodecInfo) list.get(0)).name)) {
                for (int i = 1; i < list.size(); i++) {
                    MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) list.get(i);
                    if (GOOGLE_RAW_DECODER_NAME.equals(mediaCodecInfo.name)) {
                        list.remove(i);
                        list.add(0, mediaCodecInfo);
                        return;
                    }
                }
            }
        }
    }

    public static boolean codecNeedsDisableAdaptationWorkaround(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (Util.SDK_INT <= 22 && ((Util.MODEL.equals("ODROID-XU3") || Util.MODEL.equals("Nexus 10")) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str)))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static Pair getAvcProfileAndLevel(String str, String[] strArr) {
        InterceptResult invokeLL;
        Integer valueOf;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, strArr)) == null) {
            if (strArr.length < 2) {
                Log.w(TAG, "Ignoring malformed AVC codec string: " + str);
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
                    Log.w(TAG, "Ignoring malformed AVC codec string: " + str);
                    return null;
                }
                Integer valueOf3 = Integer.valueOf(AVC_PROFILE_NUMBER_TO_CONST.get(num.intValue()));
                if (valueOf3 == null) {
                    Log.w(TAG, "Unknown AVC profile: " + num);
                    return null;
                }
                Integer valueOf4 = Integer.valueOf(AVC_LEVEL_NUMBER_TO_CONST.get(valueOf.intValue()));
                if (valueOf4 == null) {
                    Log.w(TAG, "Unknown AVC level: " + valueOf);
                    return null;
                }
                return new Pair(valueOf3, valueOf4);
            } catch (NumberFormatException unused) {
                Log.w(TAG, "Ignoring malformed AVC codec string: " + str);
                return null;
            }
        }
        return (Pair) invokeLL.objValue;
    }

    public static List getDecoderInfosInternal(CodecKey codecKey, MediaCodecListCompat mediaCodecListCompat) throws DecoderQueryException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, codecKey, mediaCodecListCompat)) == null) {
            MediaCodecListCompat mediaCodecListCompat2 = mediaCodecListCompat;
            try {
                ArrayList arrayList = new ArrayList();
                String str = codecKey.mimeType;
                int codecCount = mediaCodecListCompat.getCodecCount();
                boolean secureDecodersExplicit = mediaCodecListCompat.secureDecodersExplicit();
                int i = 0;
                while (i < codecCount) {
                    android.media.MediaCodecInfo codecInfoAt = mediaCodecListCompat2.getCodecInfoAt(i);
                    String name = codecInfoAt.getName();
                    if (isCodecUsableDecoder(codecInfoAt, name, secureDecodersExplicit)) {
                        String[] supportedTypes = codecInfoAt.getSupportedTypes();
                        int length = supportedTypes.length;
                        int i2 = 0;
                        while (i2 < length) {
                            String str2 = supportedTypes[i2];
                            if (str2.equalsIgnoreCase(str)) {
                                try {
                                    MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str2);
                                    boolean isSecurePlaybackSupported = mediaCodecListCompat2.isSecurePlaybackSupported(str, capabilitiesForType);
                                    boolean codecNeedsDisableAdaptationWorkaround = codecNeedsDisableAdaptationWorkaround(name);
                                    if (secureDecodersExplicit) {
                                        if (codecKey.secure != isSecurePlaybackSupported) {
                                        }
                                        arrayList.add(MediaCodecInfo.newInstance(name, str, capabilitiesForType, codecNeedsDisableAdaptationWorkaround, false));
                                    }
                                    if (!secureDecodersExplicit && !codecKey.secure) {
                                        arrayList.add(MediaCodecInfo.newInstance(name, str, capabilitiesForType, codecNeedsDisableAdaptationWorkaround, false));
                                    } else if (!secureDecodersExplicit && isSecurePlaybackSupported) {
                                        arrayList.add(MediaCodecInfo.newInstance(name + ".secure", str, capabilitiesForType, codecNeedsDisableAdaptationWorkaround, true));
                                        return arrayList;
                                    }
                                } catch (Exception e) {
                                    if (Util.SDK_INT <= 23 && !arrayList.isEmpty()) {
                                        Log.e(TAG, "Skipping codec " + name + " (failed to query capabilities)");
                                    } else {
                                        Log.e(TAG, "Failed to query codec " + name + " (" + str2 + SmallTailInfo.EMOTION_SUFFIX);
                                        throw e;
                                    }
                                }
                            }
                            i2++;
                            mediaCodecListCompat2 = mediaCodecListCompat;
                        }
                        continue;
                    }
                    i++;
                    mediaCodecListCompat2 = mediaCodecListCompat;
                }
                return arrayList;
            } catch (Exception e2) {
                throw new DecoderQueryException(e2, null);
            }
        }
        return (List) invokeLL.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r3.equals(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CODEC_ID_HEV1) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair getCodecProfileAndLevel(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (str == null) {
                return null;
            }
            String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
            char c = 0;
            String str2 = split[0];
            switch (str2.hashCode()) {
                case 3006243:
                    if (str2.equals("avc1")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 3006244:
                    if (str2.equals(CODEC_ID_AVC2)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3199032:
                    break;
                case 3214780:
                    if (str2.equals(CODEC_ID_HVC1)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0 && c != 1) {
                if (c != 2 && c != 3) {
                    return null;
                }
                return getAvcProfileAndLevel(str, split);
            }
            return getHevcProfileAndLevel(str, split);
        }
        return (Pair) invokeL.objValue;
    }

    public static MediaCodecInfo getDecoderInfo(String str, boolean z) throws DecoderQueryException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, str, z)) == null) {
            List decoderInfos = getDecoderInfos(str, z);
            if (decoderInfos.isEmpty()) {
                return null;
            }
            return (MediaCodecInfo) decoderInfos.get(0);
        }
        return (MediaCodecInfo) invokeLZ.objValue;
    }

    public static void warmDecoderInfoCache(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65550, null, str, z) == null) {
            try {
                getDecoderInfos(str, z);
            } catch (DecoderQueryException e) {
                Log.e(TAG, "Codec warming failed", e);
            }
        }
    }

    public static synchronized List getDecoderInfos(String str, boolean z) throws DecoderQueryException {
        InterceptResult invokeLZ;
        MediaCodecListCompat mediaCodecListCompatV16;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65544, null, str, z)) == null) {
            synchronized (MediaCodecUtil.class) {
                CodecKey codecKey = new CodecKey(str, z);
                List list = (List) decoderInfosCache.get(codecKey);
                if (list != null) {
                    return list;
                }
                if (Util.SDK_INT >= 21) {
                    mediaCodecListCompatV16 = new MediaCodecListCompatV21(z);
                } else {
                    mediaCodecListCompatV16 = new MediaCodecListCompatV16(null);
                }
                List decoderInfosInternal = getDecoderInfosInternal(codecKey, mediaCodecListCompatV16);
                if (z && decoderInfosInternal.isEmpty() && 21 <= Util.SDK_INT && Util.SDK_INT <= 23) {
                    decoderInfosInternal = getDecoderInfosInternal(codecKey, new MediaCodecListCompatV16(null));
                    if (!decoderInfosInternal.isEmpty()) {
                        Log.w(TAG, "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((MediaCodecInfo) decoderInfosInternal.get(0)).name);
                    }
                }
                applyWorkarounds(decoderInfosInternal);
                List unmodifiableList = Collections.unmodifiableList(decoderInfosInternal);
                decoderInfosCache.put(codecKey, unmodifiableList);
                return unmodifiableList;
            }
        }
        return (List) invokeLZ.objValue;
    }

    public static Pair getHevcProfileAndLevel(String str, String[] strArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, strArr)) == null) {
            if (strArr.length < 4) {
                Log.w(TAG, "Ignoring malformed HEVC codec string: " + str);
                return null;
            }
            Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
            if (!matcher.matches()) {
                Log.w(TAG, "Ignoring malformed HEVC codec string: " + str);
                return null;
            }
            String group = matcher.group(1);
            if ("1".equals(group)) {
                i = 1;
            } else if ("2".equals(group)) {
                i = 2;
            } else {
                Log.w(TAG, "Unknown HEVC profile string: " + group);
                return null;
            }
            Integer num = (Integer) HEVC_CODEC_STRING_TO_PROFILE_LEVEL.get(strArr[3]);
            if (num == null) {
                Log.w(TAG, "Unknown HEVC level string: " + matcher.group(1));
                return null;
            }
            return new Pair(Integer.valueOf(i), num);
        }
        return (Pair) invokeLL.objValue;
    }

    public static boolean isCodecUsableDecoder(android.media.MediaCodecInfo mediaCodecInfo, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65548, null, mediaCodecInfo, str, z)) == null) {
            if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
                return false;
            }
            if (Util.SDK_INT < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
                return false;
            }
            if (Util.SDK_INT < 18 && "OMX.SEC.MP3.Decoder".equals(str)) {
                return false;
            }
            if (Util.SDK_INT < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str) && ("a70".equals(Util.DEVICE) || ("Xiaomi".equals(Util.MANUFACTURER) && Util.DEVICE.startsWith("HM")))) {
                return false;
            }
            if (Util.SDK_INT == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) && ("dlxu".equals(Util.DEVICE) || "protou".equals(Util.DEVICE) || "ville".equals(Util.DEVICE) || "villeplus".equals(Util.DEVICE) || "villec2".equals(Util.DEVICE) || Util.DEVICE.startsWith("gee") || "C6602".equals(Util.DEVICE) || "C6603".equals(Util.DEVICE) || "C6606".equals(Util.DEVICE) || "C6616".equals(Util.DEVICE) || "L36h".equals(Util.DEVICE) || "SO-02E".equals(Util.DEVICE))) {
                return false;
            }
            if (Util.SDK_INT == 16 && "OMX.qcom.audio.decoder.aac".equals(str) && ("C1504".equals(Util.DEVICE) || "C1505".equals(Util.DEVICE) || "C1604".equals(Util.DEVICE) || "C1605".equals(Util.DEVICE))) {
                return false;
            }
            if (Util.SDK_INT < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && Util.MANUFACTURER.equals(ManufacturerUtils.SAMSUNG) && (Util.DEVICE.startsWith("zeroflte") || Util.DEVICE.startsWith("zerolte") || Util.DEVICE.startsWith("zenlte") || Util.DEVICE.equals("SC-05G") || Util.DEVICE.equals("marinelteatt") || Util.DEVICE.equals("404SC") || Util.DEVICE.equals("SC-04G") || Util.DEVICE.equals("SCV31")))) {
                return false;
            }
            if (Util.SDK_INT <= 19 && "OMX.SEC.vp8.dec".equals(str) && ManufacturerUtils.SAMSUNG.equals(Util.MANUFACTURER) && (Util.DEVICE.startsWith("d2") || Util.DEVICE.startsWith("serrano") || Util.DEVICE.startsWith("jflte") || Util.DEVICE.startsWith("santos") || Util.DEVICE.startsWith("t0"))) {
                return false;
            }
            if (Util.SDK_INT <= 19 && Util.DEVICE.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
                return false;
            }
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    public static int maxH264DecodableFrameSize() throws DecoderQueryException {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (maxH264DecodableFrameSize == -1) {
                int i2 = 0;
                MediaCodecInfo decoderInfo = getDecoderInfo("video/avc", false);
                if (decoderInfo != null) {
                    MediaCodecInfo.CodecProfileLevel[] profileLevels = decoderInfo.getProfileLevels();
                    int length = profileLevels.length;
                    int i3 = 0;
                    while (i2 < length) {
                        i3 = Math.max(avcLevelToMaxFrameSize(profileLevels[i2].level), i3);
                        i2++;
                    }
                    if (Util.SDK_INT >= 21) {
                        i = 345600;
                    } else {
                        i = 172800;
                    }
                    i2 = Math.max(i3, i);
                }
                maxH264DecodableFrameSize = i2;
            }
            return maxH264DecodableFrameSize;
        }
        return invokeV.intValue;
    }
}
