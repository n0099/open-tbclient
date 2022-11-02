package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
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
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, codecCapabilities, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.name = (String) Assertions.checkNotNull(str);
        this.mimeType = str2;
        this.capabilities = codecCapabilities;
        boolean z5 = true;
        if (!z && codecCapabilities != null && isAdaptive(codecCapabilities)) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.adaptive = z3;
        if (codecCapabilities != null && isTunneling(codecCapabilities)) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.tunneling = z4;
        if (!z2 && (codecCapabilities == null || !isSecure(codecCapabilities))) {
            z5 = false;
        }
        this.secure = z5;
    }

    public static int adjustMaxInputChannelCount(String str, String str2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, str, str2, i)) == null) {
            if (i <= 1 && ((Util.SDK_INT < 26 || i <= 0) && !MimeTypes.AUDIO_MPEG.equals(str2) && !MimeTypes.AUDIO_AMR_NB.equals(str2) && !MimeTypes.AUDIO_AMR_WB.equals(str2) && !"audio/mp4a-latm".equals(str2) && !MimeTypes.AUDIO_VORBIS.equals(str2) && !MimeTypes.AUDIO_OPUS.equals(str2) && !MimeTypes.AUDIO_RAW.equals(str2) && !MimeTypes.AUDIO_FLAC.equals(str2) && !MimeTypes.AUDIO_ALAW.equals(str2) && !MimeTypes.AUDIO_MLAW.equals(str2) && !MimeTypes.AUDIO_MSGSM.equals(str2))) {
                if (MimeTypes.AUDIO_AC3.equals(str2)) {
                    i2 = 6;
                } else if (MimeTypes.AUDIO_E_AC3.equals(str2)) {
                    i2 = 16;
                } else {
                    i2 = 30;
                }
                Log.w(TAG, "AssumedMaxChannelAdjustment: " + str + ", [" + i + " to " + i2 + PreferencesUtil.RIGHT_MOUNT);
                return i2;
            }
            return i;
        }
        return invokeLLI.intValue;
    }

    @TargetApi(21)
    public boolean isVideoSizeAndRateSupportedV21(int i, int i2, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d)})) == null) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
            if (codecCapabilities == null) {
                logNoSupport("sizeAndRate.caps");
                return false;
            }
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities == null) {
                logNoSupport("sizeAndRate.vCaps");
                return false;
            } else if (!areSizeAndRateSupportedV21(videoCapabilities, i, i2, d)) {
                if (i < i2 && areSizeAndRateSupportedV21(videoCapabilities, i2, i, d)) {
                    logAssumedSupport("sizeAndRate.rotated, " + i + "x" + i2 + "x" + d);
                    return true;
                }
                logNoSupport("sizeAndRate.support, " + i + "x" + i2 + "x" + d);
                return false;
            } else {
                return true;
            }
        }
        return invokeCommon.booleanValue;
    }

    @TargetApi(21)
    public static boolean areSizeAndRateSupportedV21(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{videoCapabilities, Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d)})) == null) {
            if (d != -1.0d && d > 0.0d) {
                return videoCapabilities.areSizeAndRateSupported(i, i2, d);
            }
            return videoCapabilities.isSizeSupported(i, i2);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isAdaptive(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, codecCapabilities)) == null) {
            if (Util.SDK_INT >= 19 && isAdaptiveV19(codecCapabilities)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @TargetApi(19)
    public static boolean isAdaptiveV19(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, codecCapabilities)) == null) {
            return codecCapabilities.isFeatureSupported("adaptive-playback");
        }
        return invokeL.booleanValue;
    }

    public static boolean isSecure(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, codecCapabilities)) == null) {
            if (Util.SDK_INT >= 21 && isSecureV21(codecCapabilities)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @TargetApi(21)
    public static boolean isSecureV21(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, codecCapabilities)) == null) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }
        return invokeL.booleanValue;
    }

    public static boolean isTunneling(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, codecCapabilities)) == null) {
            if (Util.SDK_INT >= 21 && isTunnelingV21(codecCapabilities)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @TargetApi(21)
    public static boolean isTunnelingV21(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, codecCapabilities)) == null) {
            return codecCapabilities.isFeatureSupported("tunneled-playback");
        }
        return invokeL.booleanValue;
    }

    public static MediaCodecInfo newPassthroughInstance(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            return new MediaCodecInfo(str, null, null, false, false);
        }
        return (MediaCodecInfo) invokeL.objValue;
    }

    private void logAssumedSupport(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, str) == null) {
            Log.d(TAG, "AssumedSupport [" + str + "] [" + this.name + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.mimeType + "] [" + Util.DEVICE_DEBUG_INFO + PreferencesUtil.RIGHT_MOUNT);
        }
    }

    private void logNoSupport(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, str) == null) {
            Log.d(TAG, "NoSupport [" + str + "] [" + this.name + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.mimeType + "] [" + Util.DEVICE_DEBUG_INFO + PreferencesUtil.RIGHT_MOUNT);
        }
    }

    @TargetApi(21)
    public boolean isAudioChannelCountSupportedV21(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
            if (codecCapabilities == null) {
                logNoSupport("channelCount.caps");
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                logNoSupport("channelCount.aCaps");
                return false;
            } else if (adjustMaxInputChannelCount(this.name, this.mimeType, audioCapabilities.getMaxInputChannelCount()) < i) {
                logNoSupport("channelCount.support, " + i);
                return false;
            } else {
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    public static MediaCodecInfo newInstance(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, str, str2, codecCapabilities)) == null) {
            return new MediaCodecInfo(str, str2, codecCapabilities, false, false);
        }
        return (MediaCodecInfo) invokeLLL.objValue;
    }

    public static MediaCodecInfo newInstance(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{str, str2, codecCapabilities, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return new MediaCodecInfo(str, str2, codecCapabilities, z, z2);
        }
        return (MediaCodecInfo) invokeCommon.objValue;
    }

    @TargetApi(21)
    public Point alignVideoSizeV21(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
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
            return new Point(Util.ceilDivide(i, widthAlignment) * widthAlignment, Util.ceilDivide(i2, heightAlignment) * heightAlignment);
        }
        return (Point) invokeII.objValue;
    }

    public MediaCodecInfo.CodecProfileLevel[] getProfileLevels() {
        InterceptResult invokeV;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
            if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                return new MediaCodecInfo.CodecProfileLevel[0];
            }
            return codecProfileLevelArr;
        }
        return (MediaCodecInfo.CodecProfileLevel[]) invokeV.objValue;
    }

    @TargetApi(21)
    public boolean isAudioSampleRateSupportedV21(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
            if (codecCapabilities == null) {
                logNoSupport("sampleRate.caps");
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                logNoSupport("sampleRate.aCaps");
                return false;
            } else if (!audioCapabilities.isSampleRateSupported(i)) {
                logNoSupport("sampleRate.support, " + i);
                return false;
            } else {
                return true;
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
}
