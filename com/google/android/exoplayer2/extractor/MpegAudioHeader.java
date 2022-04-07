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
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.ogg.DefaultOggSeeker;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.exoplayer2.util.MimeTypes;
import com.googlecode.mp4parser.authoring.tracks.MP3TrackImpl;
import com.kuaishou.weapon.un.w0;
/* loaded from: classes4.dex */
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
        BITRATE_V2_L1 = new int[]{32, 48, 56, 64, 80, 96, 112, 128, Cea708Decoder.COMMAND_SPA, 160, MatroskaExtractor.ID_PIXEL_WIDTH, 192, 224, 256};
        BITRATE_V1_L2 = new int[]{32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, 384};
        BITRATE_V1_L3 = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP};
        BITRATE_V2 = new int[]{8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, Cea708Decoder.COMMAND_SPA, 160};
    }

    public MpegAudioHeader() {
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

    public static int getFrameSize(int i) {
        InterceptResult invokeI;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if ((i & (-2097152)) != -2097152 || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
                return -1;
            }
            int i7 = SAMPLING_RATE_V1[i5];
            if (i2 == 2) {
                i7 /= 2;
            } else if (i2 == 0) {
                i7 /= 4;
            }
            int i8 = (i >>> 9) & 1;
            if (i3 == 3) {
                return ((((i2 == 3 ? BITRATE_V1_L1[i4 - 1] : BITRATE_V2_L1[i4 - 1]) * w0.X3) / i7) + i8) * 4;
            }
            if (i2 == 3) {
                i6 = i3 == 2 ? BITRATE_V1_L2[i4 - 1] : BITRATE_V1_L3[i4 - 1];
            } else {
                i6 = BITRATE_V2[i4 - 1];
            }
            if (i2 == 3) {
                return ((i6 * 144000) / i7) + i8;
            }
            return (((i3 == 1 ? DefaultOggSeeker.MATCH_RANGE : 144000) * i6) / i7) + i8;
        }
        return invokeI.intValue;
    }

    public static boolean populateHeader(int i, MpegAudioHeader mpegAudioHeader) {
        InterceptResult invokeIL;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i, mpegAudioHeader)) == null) {
            if ((i & (-2097152)) != -2097152 || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
                return false;
            }
            int i9 = SAMPLING_RATE_V1[i5];
            if (i2 == 2) {
                i9 /= 2;
            } else if (i2 == 0) {
                i9 /= 4;
            }
            int i10 = i9;
            int i11 = (i >>> 9) & 1;
            int i12 = MP3TrackImpl.SAMPLES_PER_FRAME;
            if (i3 == 3) {
                i6 = i2 == 3 ? BITRATE_V1_L1[i4 - 1] : BITRATE_V2_L1[i4 - 1];
                i7 = (((i6 * w0.X3) / i10) + i11) * 4;
                i8 = 384;
            } else {
                if (i2 == 3) {
                    i6 = i3 == 2 ? BITRATE_V1_L2[i4 - 1] : BITRATE_V1_L3[i4 - 1];
                    i7 = ((144000 * i6) / i10) + i11;
                    i8 = MP3TrackImpl.SAMPLES_PER_FRAME;
                } else {
                    i6 = BITRATE_V2[i4 - 1];
                    if (i3 == 1) {
                        i12 = 576;
                    }
                    i7 = (((i3 == 1 ? DefaultOggSeeker.MATCH_RANGE : 144000) * i6) / i10) + i11;
                    i8 = i12;
                }
            }
            mpegAudioHeader.setValues(i2, MIME_TYPE_BY_LAYER[3 - i3], i7, i10, ((i >> 6) & 3) == 3 ? 1 : 2, i6 * 1000, i8);
            return true;
        }
        return invokeIL.booleanValue;
    }

    private void setValues(int i, String str, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            this.version = i;
            this.mimeType = str;
            this.frameSize = i2;
            this.sampleRate = i3;
            this.channels = i4;
            this.bitrate = i5;
            this.samplesPerFrame = i6;
        }
    }
}
