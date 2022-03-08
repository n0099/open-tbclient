package com.google.android.exoplayer2.extractor.ogg;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.ContentUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public final class OpusReader extends StreamReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_SEEK_PRE_ROLL_SAMPLES = 3840;
    public static final int OPUS_CODE;
    public static final byte[] OPUS_SIGNATURE;
    public static final int SAMPLE_RATE = 48000;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean headerRead;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2051370672, "Lcom/google/android/exoplayer2/extractor/ogg/OpusReader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2051370672, "Lcom/google/android/exoplayer2/extractor/ogg/OpusReader;");
                return;
            }
        }
        OPUS_CODE = Util.getIntegerCodeForString("Opus");
        OPUS_SIGNATURE = new byte[]{79, 112, ContentUtil.GZIP_HEAD_1, 115, 72, Constants.SHORT_PING_CMD_TYPE, 97, 100};
    }

    public OpusReader() {
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

    private long getPacketDurationUs(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, bArr)) == null) {
            int i2 = bArr[0] & 255;
            int i3 = i2 & 3;
            int i4 = 2;
            if (i3 == 0) {
                i4 = 1;
            } else if (i3 != 1 && i3 != 2) {
                i4 = bArr[1] & 63;
            }
            int i5 = i2 >> 3;
            int i6 = i5 & 3;
            return i4 * (i5 >= 16 ? 2500 << i6 : i5 >= 12 ? 10000 << (i6 & 1) : i6 == 3 ? 60000 : 10000 << i6);
        }
        return invokeL.longValue;
    }

    private void putNativeOrderLong(List<byte[]> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, this, list, i2) == null) {
            list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((i2 * C.NANOS_PER_SECOND) / 48000).array());
        }
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, parsableByteArray)) == null) {
            int bytesLeft = parsableByteArray.bytesLeft();
            byte[] bArr = OPUS_SIGNATURE;
            if (bytesLeft < bArr.length) {
                return false;
            }
            byte[] bArr2 = new byte[bArr.length];
            parsableByteArray.readBytes(bArr2, 0, bArr.length);
            return Arrays.equals(bArr2, OPUS_SIGNATURE);
        }
        return invokeL.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public long preparePayload(ParsableByteArray parsableByteArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parsableByteArray)) == null) ? convertTimeToGranule(getPacketDurationUs(parsableByteArray.data)) : invokeL.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public boolean readHeaders(ParsableByteArray parsableByteArray, long j2, StreamReader.SetupData setupData) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{parsableByteArray, Long.valueOf(j2), setupData})) == null) {
            if (!this.headerRead) {
                byte[] copyOf = Arrays.copyOf(parsableByteArray.data, parsableByteArray.limit());
                int i2 = copyOf[9] & 255;
                ArrayList arrayList = new ArrayList(3);
                arrayList.add(copyOf);
                putNativeOrderLong(arrayList, ((copyOf[11] & 255) << 8) | (copyOf[10] & 255));
                putNativeOrderLong(arrayList, 3840);
                setupData.format = Format.createAudioSampleFormat(null, MimeTypes.AUDIO_OPUS, null, -1, -1, i2, 48000, arrayList, null, 0, null);
                this.headerRead = true;
                return true;
            }
            boolean z = parsableByteArray.readInt() == OPUS_CODE;
            parsableByteArray.setPosition(0);
            return z;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void reset(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            super.reset(z);
            if (z) {
                this.headerRead = false;
            }
        }
    }
}
