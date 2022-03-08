package com.google.android.exoplayer2.extractor.mkv;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;
/* loaded from: classes7.dex */
public final class VarintReader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATE_BEGIN_READING = 0;
    public static final int STATE_READ_CONTENTS = 1;
    public static final long[] VARINT_LENGTH_MASKS;
    public transient /* synthetic */ FieldHolder $fh;
    public int length;
    public final byte[] scratch;
    public int state;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(632981232, "Lcom/google/android/exoplayer2/extractor/mkv/VarintReader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(632981232, "Lcom/google/android/exoplayer2/extractor/mkv/VarintReader;");
                return;
            }
        }
        VARINT_LENGTH_MASKS = new long[]{128, 64, 32, 16, 8, 4, 2, 1};
    }

    public VarintReader() {
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
        this.scratch = new byte[8];
    }

    public static long assembleVarint(byte[] bArr, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{bArr, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            long j2 = bArr[0] & 255;
            if (z) {
                j2 &= ~VARINT_LENGTH_MASKS[i2 - 1];
            }
            for (int i3 = 1; i3 < i2; i3++) {
                j2 = (j2 << 8) | (bArr[i3] & 255);
            }
            return j2;
        }
        return invokeCommon.longValue;
    }

    public static int parseUnsignedVarintLength(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(65539, null, i2)) != null) {
            return invokeI.intValue;
        }
        int i3 = 0;
        while (true) {
            long[] jArr = VARINT_LENGTH_MASKS;
            if (i3 >= jArr.length) {
                return -1;
            }
            if ((jArr[i3] & i2) != 0) {
                return i3 + 1;
            }
            i3++;
        }
    }

    public int getLastLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.length : invokeV.intValue;
    }

    public long readUnsignedVarint(ExtractorInput extractorInput, boolean z, boolean z2, int i2) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{extractorInput, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            if (this.state == 0) {
                if (!extractorInput.readFully(this.scratch, 0, 1, z)) {
                    return -1L;
                }
                int parseUnsignedVarintLength = parseUnsignedVarintLength(this.scratch[0] & 255);
                this.length = parseUnsignedVarintLength;
                if (parseUnsignedVarintLength != -1) {
                    this.state = 1;
                } else {
                    throw new IllegalStateException("No valid varint length mask found");
                }
            }
            int i3 = this.length;
            if (i3 > i2) {
                this.state = 0;
                return -2L;
            }
            if (i3 != 1) {
                extractorInput.readFully(this.scratch, 1, i3 - 1);
            }
            this.state = 0;
            return assembleVarint(this.scratch, this.length, z2);
        }
        return invokeCommon.longValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.state = 0;
            this.length = 0;
        }
    }
}
