package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.googlecode.mp4parser.boxes.AC3SpecificBox;
import com.googlecode.mp4parser.boxes.EC3SpecificBox;
/* loaded from: classes6.dex */
public final class MimeTypes {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APPLICATION_CAMERA_MOTION = "application/x-camera-motion";
    public static final String APPLICATION_CEA608 = "application/cea-608";
    public static final String APPLICATION_CEA708 = "application/cea-708";
    public static final String APPLICATION_DVBSUBS = "application/dvbsubs";
    public static final String APPLICATION_EMSG = "application/x-emsg";
    public static final String APPLICATION_EXIF = "application/x-exif";
    public static final String APPLICATION_ID3 = "application/id3";
    public static final String APPLICATION_M3U8 = "application/x-mpegURL";
    public static final String APPLICATION_MP4 = "application/mp4";
    public static final String APPLICATION_MP4CEA608 = "application/x-mp4-cea-608";
    public static final String APPLICATION_MP4VTT = "application/x-mp4-vtt";
    public static final String APPLICATION_PGS = "application/pgs";
    public static final String APPLICATION_RAWCC = "application/x-rawcc";
    public static final String APPLICATION_SCTE35 = "application/x-scte35";
    public static final String APPLICATION_SUBRIP = "application/x-subrip";
    public static final String APPLICATION_TTML = "application/ttml+xml";
    public static final String APPLICATION_TX3G = "application/x-quicktime-tx3g";
    public static final String APPLICATION_VOBSUB = "application/vobsub";
    public static final String APPLICATION_WEBM = "application/webm";
    public static final String AUDIO_AAC = "audio/mp4a-latm";
    public static final String AUDIO_AC3 = "audio/ac3";
    public static final String AUDIO_ALAC = "audio/alac";
    public static final String AUDIO_ALAW = "audio/g711-alaw";
    public static final String AUDIO_AMR_NB = "audio/3gpp";
    public static final String AUDIO_AMR_WB = "audio/amr-wb";
    public static final String AUDIO_DTS = "audio/vnd.dts";
    public static final String AUDIO_DTS_EXPRESS = "audio/vnd.dts.hd;profile=lbr";
    public static final String AUDIO_DTS_HD = "audio/vnd.dts.hd";
    public static final String AUDIO_E_AC3 = "audio/eac3";
    public static final String AUDIO_FLAC = "audio/flac";
    public static final String AUDIO_MLAW = "audio/g711-mlaw";
    public static final String AUDIO_MP4 = "audio/mp4";
    public static final String AUDIO_MPEG = "audio/mpeg";
    public static final String AUDIO_MPEG_L1 = "audio/mpeg-L1";
    public static final String AUDIO_MPEG_L2 = "audio/mpeg-L2";
    public static final String AUDIO_MSGSM = "audio/gsm";
    public static final String AUDIO_OPUS = "audio/opus";
    public static final String AUDIO_RAW = "audio/raw";
    public static final String AUDIO_TRUEHD = "audio/true-hd";
    public static final String AUDIO_UNKNOWN = "audio/x-unknown";
    public static final String AUDIO_VORBIS = "audio/vorbis";
    public static final String AUDIO_WEBM = "audio/webm";
    public static final String BASE_TYPE_APPLICATION = "application";
    public static final String BASE_TYPE_AUDIO = "audio";
    public static final String BASE_TYPE_TEXT = "text";
    public static final String BASE_TYPE_VIDEO = "video";
    public static final String TEXT_SSA = "text/x-ssa";
    public static final String TEXT_VTT = "text/vtt";
    public static final String VIDEO_H263 = "video/3gpp";
    public static final String VIDEO_H264 = "video/avc";
    public static final String VIDEO_H265 = "video/hevc";
    public static final String VIDEO_MP4 = "video/mp4";
    public static final String VIDEO_MP4V = "video/mp4v-es";
    public static final String VIDEO_MPEG2 = "video/mpeg2";
    public static final String VIDEO_UNKNOWN = "video/x-unknown";
    public static final String VIDEO_VC1 = "video/wvc1";
    public static final String VIDEO_VP8 = "video/x-vnd.on2.vp8";
    public static final String VIDEO_VP9 = "video/x-vnd.on2.vp9";
    public static final String VIDEO_WEBM = "video/webm";
    public transient /* synthetic */ FieldHolder $fh;

    public MimeTypes() {
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

    public static String getAudioMediaMimeType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str == null) {
                return null;
            }
            for (String str2 : str.split(",")) {
                String mediaMimeType = getMediaMimeType(str2);
                if (mediaMimeType != null && isAudio(mediaMimeType)) {
                    return mediaMimeType;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getMediaMimeType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null) {
                return null;
            }
            String trim = str.trim();
            if (trim.startsWith("avc1") || trim.startsWith(VisualSampleEntry.TYPE4)) {
                return "video/avc";
            }
            if (trim.startsWith(MediaCodecUtil.CODEC_ID_HEV1) || trim.startsWith(MediaCodecUtil.CODEC_ID_HVC1)) {
                return VIDEO_H265;
            }
            if (trim.startsWith("vp9") || trim.startsWith("vp09")) {
                return "video/x-vnd.on2.vp9";
            }
            if (trim.startsWith("vp8") || trim.startsWith("vp08")) {
                return "video/x-vnd.on2.vp8";
            }
            if (trim.startsWith(AudioSampleEntry.TYPE3)) {
                return "audio/mp4a-latm";
            }
            if (trim.startsWith(AudioSampleEntry.TYPE8) || trim.startsWith(AC3SpecificBox.TYPE)) {
                return AUDIO_AC3;
            }
            if (trim.startsWith(AudioSampleEntry.TYPE9) || trim.startsWith(EC3SpecificBox.TYPE)) {
                return AUDIO_E_AC3;
            }
            if (trim.startsWith("dtsc") || trim.startsWith(AudioSampleEntry.TYPE13)) {
                return AUDIO_DTS;
            }
            if (trim.startsWith(AudioSampleEntry.TYPE12) || trim.startsWith(AudioSampleEntry.TYPE11)) {
                return AUDIO_DTS_HD;
            }
            if (trim.startsWith("opus")) {
                return AUDIO_OPUS;
            }
            if (trim.startsWith("vorbis")) {
                return AUDIO_VORBIS;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getTopLevelType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return null;
            }
            int indexOf = str.indexOf(47);
            if (indexOf != -1) {
                return str.substring(0, indexOf);
            }
            throw new IllegalArgumentException("Invalid mime type: " + str);
        }
        return (String) invokeL.objValue;
    }

    public static int getTrackType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            if (isAudio(str)) {
                return 1;
            }
            if (isVideo(str)) {
                return 2;
            }
            if (isText(str) || APPLICATION_CEA608.equals(str) || APPLICATION_CEA708.equals(str) || APPLICATION_MP4CEA608.equals(str) || APPLICATION_SUBRIP.equals(str) || APPLICATION_TTML.equals(str) || APPLICATION_TX3G.equals(str) || APPLICATION_MP4VTT.equals(str) || APPLICATION_RAWCC.equals(str) || APPLICATION_VOBSUB.equals(str) || APPLICATION_PGS.equals(str) || APPLICATION_DVBSUBS.equals(str)) {
                return 3;
            }
            return (APPLICATION_ID3.equals(str) || APPLICATION_EMSG.equals(str) || APPLICATION_SCTE35.equals(str) || APPLICATION_CAMERA_MOTION.equals(str)) ? 4 : -1;
        }
        return invokeL.intValue;
    }

    public static int getTrackTypeOfCodec(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? getTrackType(getMediaMimeType(str)) : invokeL.intValue;
    }

    public static String getVideoMediaMimeType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (str == null) {
                return null;
            }
            for (String str2 : str.split(",")) {
                String mediaMimeType = getMediaMimeType(str2);
                if (mediaMimeType != null && isVideo(mediaMimeType)) {
                    return mediaMimeType;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean isApplication(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? BASE_TYPE_APPLICATION.equals(getTopLevelType(str)) : invokeL.booleanValue;
    }

    public static boolean isAudio(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? "audio".equals(getTopLevelType(str)) : invokeL.booleanValue;
    }

    public static boolean isText(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? "text".equals(getTopLevelType(str)) : invokeL.booleanValue;
    }

    public static boolean isVideo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? "video".equals(getTopLevelType(str)) : invokeL.booleanValue;
    }
}
