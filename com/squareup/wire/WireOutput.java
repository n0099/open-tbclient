package com.squareup.wire;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
/* loaded from: classes8.dex */
public final class WireOutput {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] buffer;
    public final int limit;
    public int position;

    public WireOutput(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.buffer = bArr;
        this.position = i;
        this.limit = i + i2;
    }

    public static int int32Size(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i >= 0) {
                return varint32Size(i);
            }
            return 10;
        }
        return invokeI.intValue;
    }

    public static int int64Size(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) {
            if (j >= 0) {
                return varint64Size(j);
            }
            return 10;
        }
        return invokeJ.intValue;
    }

    public static int makeTag(int i, WireType wireType) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i, wireType)) == null) ? (i << 3) | wireType.value() : invokeIL.intValue;
    }

    public static int messageHeaderSize(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2)) == null) ? tagSize(i, WireType.LENGTH_DELIMITED) + int32Size(i2) : invokeII.intValue;
    }

    public static int messageSize(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65541, null, i, i2)) == null) ? tagSize(i, WireType.LENGTH_DELIMITED) + int32Size(i2) + i2 : invokeII.intValue;
    }

    public static WireOutput newInstance(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) ? newInstance(bArr, 0, bArr.length) : (WireOutput) invokeL.objValue;
    }

    public static int tagSize(int i, WireType wireType) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65544, null, i, wireType)) == null) ? int32Size(makeTag(i, wireType)) : invokeIL.intValue;
    }

    public static int varint32Size(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            if ((i & (-128)) == 0) {
                return 1;
            }
            if ((i & (-16384)) == 0) {
                return 2;
            }
            if (((-2097152) & i) == 0) {
                return 3;
            }
            return (i & (-268435456)) == 0 ? 4 : 5;
        }
        return invokeI.intValue;
    }

    public static int varint64Size(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65546, null, j)) == null) {
            if (((-128) & j) == 0) {
                return 1;
            }
            if (((-16384) & j) == 0) {
                return 2;
            }
            if ((CoroutineScheduler.PARKED_VERSION_MASK & j) == 0) {
                return 3;
            }
            if (((-268435456) & j) == 0) {
                return 4;
            }
            if (((-34359738368L) & j) == 0) {
                return 5;
            }
            if (((-4398046511104L) & j) == 0) {
                return 6;
            }
            if (((-562949953421312L) & j) == 0) {
                return 7;
            }
            if (((-72057594037927936L) & j) == 0) {
                return 8;
            }
            return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
        }
        return invokeJ.intValue;
    }

    public static int varintTagSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) ? varint32Size(makeTag(i, WireType.VARINT)) : invokeI.intValue;
    }

    public static int writeMessageHeader(int i, byte[] bArr, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Integer.valueOf(i), bArr, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int writeTag = writeTag(i, WireType.LENGTH_DELIMITED, bArr, i2) + i2;
            return (writeTag + writeVarint(i3, bArr, writeTag)) - i2;
        }
        return invokeCommon.intValue;
    }

    public static int writeTag(int i, WireType wireType, byte[] bArr, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i), wireType, bArr, Integer.valueOf(i2)})) == null) ? writeVarint(makeTag(i, wireType), bArr, i2) : invokeCommon.intValue;
    }

    public static int writeVarint(long j, byte[] bArr, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Long.valueOf(j), bArr, Integer.valueOf(i)})) == null) {
            int i2 = i;
            while (((-128) & j) != 0) {
                bArr[i2] = (byte) ((127 & j) | 128);
                j >>>= 7;
                i2++;
            }
            bArr[i2] = (byte) j;
            return (i2 + 1) - i;
        }
        return invokeCommon.intValue;
    }

    public static int zigZag32(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i)) == null) ? (i >> 31) ^ (i << 1) : invokeI.intValue;
    }

    public static long zigZag64(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65552, null, j)) == null) ? (j >> 63) ^ (j << 1) : invokeJ.longValue;
    }

    public void writeFixed32(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            writeRawByte(i & 255);
            writeRawByte((i >> 8) & 255);
            writeRawByte((i >> 16) & 255);
            writeRawByte((i >> 24) & 255);
        }
    }

    public void writeFixed64(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            writeRawByte(((int) j) & 255);
            writeRawByte(((int) (j >> 8)) & 255);
            writeRawByte(((int) (j >> 16)) & 255);
            writeRawByte(((int) (j >> 24)) & 255);
            writeRawByte(((int) (j >> 32)) & 255);
            writeRawByte(((int) (j >> 40)) & 255);
            writeRawByte(((int) (j >> 48)) & 255);
            writeRawByte(((int) (j >> 56)) & 255);
        }
    }

    public void writeRawByte(byte b) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(Constants.METHOD_SEND_USER_MSG, this, b) == null) {
            int i = this.position;
            if (i != this.limit) {
                byte[] bArr = this.buffer;
                this.position = i + 1;
                bArr[i] = b;
                return;
            }
            throw new IOException("Out of space: position=" + this.position + ", limit=" + this.limit);
        }
    }

    public void writeRawBytes(byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) {
            writeRawBytes(bArr, 0, bArr.length);
        }
    }

    public void writeSignedVarint32(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (i >= 0) {
                writeVarint32(i);
            } else {
                writeVarint64(i);
            }
        }
    }

    public void writeVarint32(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            while ((i & (-128)) != 0) {
                writeRawByte((i & 127) | 128);
                i >>>= 7;
            }
            writeRawByte(i);
        }
    }

    public void writeVarint64(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            while (((-128) & j) != 0) {
                writeRawByte((((int) j) & 127) | 128);
                j >>>= 7;
            }
            writeRawByte((int) j);
        }
    }

    public static WireOutput newInstance(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, bArr, i, i2)) == null) ? new WireOutput(bArr, i, i2) : (WireOutput) invokeLII.objValue;
    }

    public void writeRawBytes(byte[] bArr, int i, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, bArr, i, i2) == null) {
            int i3 = this.limit;
            int i4 = this.position;
            if (i3 - i4 >= i2) {
                System.arraycopy(bArr, i, this.buffer, i4, i2);
                this.position += i2;
                return;
            }
            throw new IOException("Out of space: position=" + this.position + ", limit=" + this.limit);
        }
    }

    public void writeTag(int i, WireType wireType) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, wireType) == null) {
            writeVarint32(makeTag(i, wireType));
        }
    }

    public void writeRawByte(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            writeRawByte((byte) i);
        }
    }
}
