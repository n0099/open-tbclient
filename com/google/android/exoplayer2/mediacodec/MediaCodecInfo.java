package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
@TargetApi(16)
/* loaded from: classes7.dex */
public final class MediaCodecInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MediaCodecInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean adaptive;
    public final MediaCodecInfo.CodecCapabilities capabilities;
    public final String mimeType;
    public final String name;
    public final boolean secure;
    public final boolean tunneling;

    public MediaCodecInfo(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, codecCapabilities, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.name = (String) Assertions.checkNotNull(str);
        this.mimeType = str2;
        this.capabilities = codecCapabilities;
        boolean z3 = true;
        this.adaptive = (z || codecCapabilities == null || !isAdaptive(codecCapabilities)) ? false : true;
        this.tunneling = codecCapabilities != null && isTunneling(codecCapabilities);
        if (!z2 && (codecCapabilities == null || !isSecure(codecCapabilities))) {
            z3 = false;
        }
        this.secure = z3;
    }

    public static int adjustMaxInputChannelCount(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, str, str2, i2)) == null) {
            if (i2 > 1 || ((Util.SDK_INT >= 26 && i2 > 0) || MimeTypes.AUDIO_MPEG.equals(str2) || MimeTypes.AUDIO_AMR_NB.equals(str2) || MimeTypes.AUDIO_AMR_WB.equals(str2) || "audio/mp4a-latm".equals(str2) || MimeTypes.AUDIO_VORBIS.equals(str2) || MimeTypes.AUDIO_OPUS.equals(str2) || MimeTypes.AUDIO_RAW.equals(str2) || MimeTypes.AUDIO_FLAC.equals(str2) || MimeTypes.AUDIO_ALAW.equals(str2) || MimeTypes.AUDIO_MLAW.equals(str2) || MimeTypes.AUDIO_MSGSM.equals(str2))) {
                return i2;
            }
            if (MimeTypes.AUDIO_AC3.equals(str2)) {
                i3 = 6;
            } else {
                i3 = MimeTypes.AUDIO_E_AC3.equals(str2) ? 16 : 30;
            }
            String str3 = "AssumedMaxChannelAdjustment: " + str + ", [" + i2 + " to " + i3 + PreferencesUtil.RIGHT_MOUNT;
            return i3;
        }
        return invokeLLI.intValue;
    }

    @TargetApi(21)
    public static boolean areSizeAndRateSupportedV21(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{videoCapabilities, Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d2)})) == null) {
            if (d2 != -1.0d && d2 > 0.0d) {
                return videoCapabilities.areSizeAndRateSupported(i2, i3, d2);
            }
            return videoCapabilities.isSizeSupported(i2, i3);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isAdaptive(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, codecCapabilities)) == null) ? Util.SDK_INT >= 19 && isAdaptiveV19(codecCapabilities) : invokeL.booleanValue;
    }

    @TargetApi(19)
    public static boolean isAdaptiveV19(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, codecCapabilities)) == null) ? codecCapabilities.isFeatureSupported("adaptive-playback") : invokeL.booleanValue;
    }

    public static boolean isSecure(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, codecCapabilities)) == null) ? Util.SDK_INT >= 21 && isSecureV21(codecCapabilities) : invokeL.booleanValue;
    }

    @TargetApi(21)
    public static boolean isSecureV21(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, codecCapabilities)) == null) ? codecCapabilities.isFeatureSupported("secure-playback") : invokeL.booleanValue;
    }

    public static boolean isTunneling(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, codecCapabilities)) == null) ? Util.SDK_INT >= 21 && isTunnelingV21(codecCapabilities) : invokeL.booleanValue;
    }

    @TargetApi(21)
    public static boolean isTunnelingV21(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, codecCapabilities)) == null) ? codecCapabilities.isFeatureSupported("tunneled-playback") : invokeL.booleanValue;
    }

    private void logAssumedSupport(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, str) == null) {
            String str2 = "AssumedSupport [" + str + "] [" + this.name + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.mimeType + "] [" + Util.DEVICE_DEBUG_INFO + PreferencesUtil.RIGHT_MOUNT;
        }
    }

    private void logNoSupport(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, str) == null) {
            String str2 = "NoSupport [" + str + "] [" + this.name + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.mimeType + "] [" + Util.DEVICE_DEBUG_INFO + PreferencesUtil.RIGHT_MOUNT;
        }
    }

    public static MediaCodecInfo newInstance(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, str, str2, codecCapabilities)) == null) ? new MediaCodecInfo(str, str2, codecCapabilities, false, false) : (MediaCodecInfo) invokeLLL.objValue;
    }

    public static MediaCodecInfo newPassthroughInstance(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) ? new MediaCodecInfo(str, null, null, false, false) : (MediaCodecInfo) invokeL.objValue;
    }

    @TargetApi(21)
    public Point alignVideoSizeV21(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
            if (codecCapabilities == null) {
                logNoSupport("align.caps");
                return null;
            }
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities == null) {
                logNoSupport("align.vCaps");
                return null;
            }
            int widthAlignment = videoCapabilities.getWidthAlignment();
            int heightAlignment = videoCapabilities.getHeightAlignment();
            return new Point(Util.ceilDivide(i2, widthAlignment) * widthAlignment, Util.ceilDivide(i3, heightAlignment) * heightAlignment);
        }
        return (Point) invokeII.objValue;
    }

    public MediaCodecInfo.CodecProfileLevel[] getProfileLevels() {
        InterceptResult invokeV;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
            return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
        }
        return (MediaCodecInfo.CodecProfileLevel[]) invokeV.objValue;
    }

    @TargetApi(21)
    public boolean isAudioChannelCountSupportedV21(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
            if (codecCapabilities == null) {
                logNoSupport("channelCount.caps");
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                logNoSupport("channelCount.aCaps");
                return false;
            } else if (adjustMaxInputChannelCount(this.name, this.mimeType, audioCapabilities.getMaxInputChannelCount()) < i2) {
                logNoSupport("channelCount.support, " + i2);
                return false;
            } else {
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    @TargetApi(21)
    public boolean isAudioSampleRateSupportedV21(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
            if (codecCapabilities == null) {
                logNoSupport("sampleRate.caps");
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                logNoSupport("sampleRate.aCaps");
                return false;
            } else if (audioCapabilities.isSampleRateSupported(i2)) {
                return true;
            } else {
                logNoSupport("sampleRate.support, " + i2);
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public boolean isCodecSupported(String str) {
        InterceptResult invokeL;
        String mediaMimeType;
        MediaCodecInfo.CodecProfileLevel[] profileLevels;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null || this.mimeType == null || (mediaMimeType = MimeTypes.getMediaMimeType(str)) == null) {
                return true;
            }
            if (!this.mimeType.equals(mediaMimeType)) {
                logNoSupport("codec.mime " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + mediaMimeType);
                return false;
            }
            Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(str);
            if (codecProfileAndLevel == null) {
                return true;
            }
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : getProfileLevels()) {
                if (codecProfileLevel.profile == ((Integer) codecProfileAndLevel.first).intValue() && codecProfileLevel.level >= ((Integer) codecProfileAndLevel.second).intValue()) {
                    return true;
                }
            }
            logNoSupport("codec.profileLevel, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + mediaMimeType);
            return false;
        }
        return invokeL.booleanValue;
    }

    @TargetApi(21)
    public boolean isVideoSizeAndRateSupportedV21(int i2, int i3, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d2)})) == null) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
            if (codecCapabilities == null) {
                logNoSupport("sizeAndRate.caps");
                return false;
            }
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities == null) {
                logNoSupport("sizeAndRate.vCaps");
                return false;
            } else if (areSizeAndRateSupportedV21(videoCapabilities, i2, i3, d2)) {
                return true;
            } else {
                if (i2 < i3 && areSizeAndRateSupportedV21(videoCapabilities, i3, i2, d2)) {
                    logAssumedSupport("sizeAndRate.rotated, " + i2 + "x" + i3 + "x" + d2);
                    return true;
                }
                logNoSupport("sizeAndRate.support, " + i2 + "x" + i3 + "x" + d2);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static MediaCodecInfo newInstance(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{str, str2, codecCapabilities, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? new MediaCodecInfo(str, str2, codecCapabilities, z, z2) : (MediaCodecInfo) invokeCommon.objValue;
    }
}
