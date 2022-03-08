package com.google.android.exoplayer2.extractor;

import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.face.platform.utils.FileUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.exoplayer2.util.MimeTypes;
import com.googlecode.mp4parser.authoring.tracks.MP3TrackImpl;
import com.kuaishou.weapon.un.w0;
/* loaded from: classes7.dex */
public final class MpegAudioHeader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] BITRATE_V1_L1;
    public static final int[] BITRATE_V1_L2;
    public static final int[] BITRATE_V1_L3;
    public static final int[] BITRATE_V2;
    public static final int[] BITRATE_V2_L1;
    public static final int MAX_FRAME_SIZE_BYTES = 4096;
    public static final String[] MIME_TYPE_BY_LAYER;
    public static final int[] SAMPLING_RATE_V1;
    public transient /* synthetic */ FieldHolder $fh;
    public int bitrate;
    public int channels;
    public int frameSize;
    public String mimeType;
    public int sampleRate;
    public int samplesPerFrame;
    public int version;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1325991162, "Lcom/google/android/exoplayer2/extractor/MpegAudioHeader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1325991162, "Lcom/google/android/exoplayer2/extractor/MpegAudioHeader;");
                return;
            }
        }
        MIME_TYPE_BY_LAYER = new String[]{MimeTypes.AUDIO_MPEG_L1, MimeTypes.AUDIO_MPEG_L2, MimeTypes.AUDIO_MPEG};
        SAMPLING_RATE_V1 = new int[]{44100, 48000, 32000};
        BITRATE_V1_L1 = new int[]{32, 64, 96, 128, 160, 192, 224, 256, 288, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 352, 384, 416, FileUtils.S_IRWXU};
        BITRATE_V2_L1 = new int[]{32, 48, 56, 64, 80, 96, 112, 128, Cea708Decoder.COMMAND_SPA, 160, 176, 192, 224, 256};
        BITRATE_V1_L2 = new int[]{32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 384};
        BITRATE_V1_L3 = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP};
        BITRATE_V2 = new int[]{8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, Cea708Decoder.COMMAND_SPA, 160};
    }

    public MpegAudioHeader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int getFrameSize(int i2) {
        InterceptResult invokeI;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if ((i2 & (-2097152)) != -2097152 || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
                return -1;
            }
            int i8 = SAMPLING_RATE_V1[i6];
            if (i3 == 2) {
                i8 /= 2;
            } else if (i3 == 0) {
                i8 /= 4;
            }
            int i9 = (i2 >>> 9) & 1;
            if (i4 == 3) {
                return ((((i3 == 3 ? BITRATE_V1_L1[i5 - 1] : BITRATE_V2_L1[i5 - 1]) * w0.X3) / i8) + i9) * 4;
            }
            if (i3 == 3) {
                i7 = i4 == 2 ? BITRATE_V1_L2[i5 - 1] : BITRATE_V1_L3[i5 - 1];
            } else {
                i7 = BITRATE_V2[i5 - 1];
            }
            if (i3 == 3) {
                return ((i7 * 144000) / i8) + i9;
            }
            return (((i4 == 1 ? DefaultOggSeeker.MATCH_RANGE : 144000) * i7) / i8) + i9;
        }
        return invokeI.intValue;
    }

    public static boolean populateHeader(int i2, MpegAudioHeader mpegAudioHeader) {
        InterceptResult invokeIL;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i2, mpegAudioHeader)) == null) {
            if ((i2 & (-2097152)) != -2097152 || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
                return false;
            }
            int i10 = SAMPLING_RATE_V1[i6];
            if (i3 == 2) {
                i10 /= 2;
            } else if (i3 == 0) {
                i10 /= 4;
            }
            int i11 = i10;
            int i12 = (i2 >>> 9) & 1;
            int i13 = MP3TrackImpl.SAMPLES_PER_FRAME;
            if (i4 == 3) {
                i7 = i3 == 3 ? BITRATE_V1_L1[i5 - 1] : BITRATE_V2_L1[i5 - 1];
                i8 = (((i7 * w0.X3) / i11) + i12) * 4;
                i9 = 384;
            } else {
                if (i3 == 3) {
                    i7 = i4 == 2 ? BITRATE_V1_L2[i5 - 1] : BITRATE_V1_L3[i5 - 1];
                    i8 = ((144000 * i7) / i11) + i12;
                    i9 = MP3TrackImpl.SAMPLES_PER_FRAME;
                } else {
                    i7 = BITRATE_V2[i5 - 1];
                    if (i4 == 1) {
                        i13 = 576;
                    }
                    i8 = (((i4 == 1 ? DefaultOggSeeker.MATCH_RANGE : 144000) * i7) / i11) + i12;
                    i9 = i13;
                }
            }
            mpegAudioHeader.setValues(i3, MIME_TYPE_BY_LAYER[3 - i4], i8, i11, ((i2 >> 6) & 3) == 3 ? 1 : 2, i7 * 1000, i9);
            return true;
        }
        return invokeIL.booleanValue;
    }

    private void setValues(int i2, String str, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            this.version = i2;
            this.mimeType = str;
            this.frameSize = i3;
            this.sampleRate = i4;
            this.channels = i5;
            this.bitrate = i6;
            this.samplesPerFrame = i7;
        }
    }
}
