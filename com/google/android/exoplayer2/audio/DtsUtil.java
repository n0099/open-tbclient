package com.google.android.exoplayer2.audio;

import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.face.platform.utils.FileUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.googlecode.mp4parser.authoring.tracks.MP3TrackImpl;
import com.kuaishou.weapon.un.w0;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public final class DtsUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] CHANNELS_BY_AMODE;
    public static final int[] SAMPLE_RATE_BY_SFREQ;
    public static final int[] TWICE_BITRATE_KBPS_BY_RATE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1425597139, "Lcom/google/android/exoplayer2/audio/DtsUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1425597139, "Lcom/google/android/exoplayer2/audio/DtsUtil;");
                return;
            }
        }
        CHANNELS_BY_AMODE = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
        SAMPLE_RATE_BY_SFREQ = new int[]{-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, w0.X3, 24000, 48000, -1, -1};
        TWICE_BITRATE_KBPS_BY_RATE = new int[]{64, 112, 128, 192, 224, 256, 384, FileUtils.S_IRWXU, 512, 640, 768, 896, 1024, MP3TrackImpl.SAMPLES_PER_FRAME, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};
    }

    public DtsUtil() {
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

    public static int getDtsFrameSize(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? (((bArr[7] & 240) >> 4) | ((bArr[5] & 2) << 12) | ((bArr[6] & 255) << 4)) + 1 : invokeL.intValue;
    }

    public static int parseDtsAudioSampleCount(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) ? ((((bArr[5] & Cea608Decoder.CC_IMPLICIT_DATA_HEADER) >> 2) | ((bArr[4] & 1) << 6)) + 1) * 32 : invokeL.intValue;
    }

    public static Format parseDtsFormat(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, bArr, str, str2, drmInitData)) == null) {
            ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
            parsableBitArray.skipBits(60);
            int i = CHANNELS_BY_AMODE[parsableBitArray.readBits(6)];
            int i2 = SAMPLE_RATE_BY_SFREQ[parsableBitArray.readBits(4)];
            int readBits = parsableBitArray.readBits(5);
            int[] iArr = TWICE_BITRATE_KBPS_BY_RATE;
            int i3 = readBits >= iArr.length ? -1 : (iArr[readBits] * 1000) / 2;
            parsableBitArray.skipBits(10);
            return Format.createAudioSampleFormat(str, MimeTypes.AUDIO_DTS, null, i3, -1, i + (parsableBitArray.readBits(2) > 0 ? 1 : 0), i2, null, drmInitData, 0, str2);
        }
        return (Format) invokeLLLL.objValue;
    }

    public static int parseDtsAudioSampleCount(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, byteBuffer)) == null) {
            int position = byteBuffer.position();
            return ((((byteBuffer.get(position + 5) & Cea608Decoder.CC_IMPLICIT_DATA_HEADER) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) * 32;
        }
        return invokeL.intValue;
    }
}
