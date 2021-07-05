package com.squareup.wire;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.alipay.sdk.encrypt.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
/* loaded from: classes7.dex */
public final class WireOutput {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] buffer;
    public final int limit;
    public int position;

    public WireOutput(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.buffer = bArr;
        this.position = i2;
        this.limit = i2 + i3;
    }

    public static int int32Size(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (i2 >= 0) {
                return varint32Size(i2);
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

    public static int makeTag(int i2, WireType wireType) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i2, wireType)) == null) ? (i2 << 3) | wireType.value() : invokeIL.intValue;
    }

    public static int messageHeaderSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65540, null, i2, i3)) == null) ? tagSize(i2, WireType.LENGTH_DELIMITED) + int32Size(i3) : invokeII.intValue;
    }

    public static int messageSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.AD_TEXT_ID, null, i2, i3)) == null) ? tagSize(i2, WireType.LENGTH_DELIMITED) + int32Size(i3) + i3 : invokeII.intValue;
    }

    public static WireOutput newInstance(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bArr)) == null) ? newInstance(bArr, 0, bArr.length) : (WireOutput) invokeL.objValue;
    }

    public static int tagSize(int i2, WireType wireType) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65544, null, i2, wireType)) == null) ? int32Size(makeTag(i2, wireType)) : invokeIL.intValue;
    }

    public static int varint32Size(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) {
            if ((i2 & a.f1888g) == 0) {
                return 1;
            }
            if ((i2 & (-16384)) == 0) {
                return 2;
            }
            if (((-2097152) & i2) == 0) {
                return 3;
            }
            return (i2 & Label.FORWARD_REFERENCE_TYPE_MASK) == 0 ? 4 : 5;
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

    public static int varintTagSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) ? varint32Size(makeTag(i2, WireType.VARINT)) : invokeI.intValue;
    }

    public static int writeMessageHeader(int i2, byte[] bArr, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            int writeTag = writeTag(i2, WireType.LENGTH_DELIMITED, bArr, i3) + i3;
            return (writeTag + writeVarint(i4, bArr, writeTag)) - i3;
        }
        return invokeCommon.intValue;
    }

    public static int writeTag(int i2, WireType wireType, byte[] bArr, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i2), wireType, bArr, Integer.valueOf(i3)})) == null) ? writeVarint(makeTag(i2, wireType), bArr, i3) : invokeCommon.intValue;
    }

    public static int writeVarint(long j, byte[] bArr, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Long.valueOf(j), bArr, Integer.valueOf(i2)})) == null) {
            int i3 = i2;
            while (((-128) & j) != 0) {
                bArr[i3] = (byte) ((127 & j) | 128);
                j >>>= 7;
                i3++;
            }
            bArr[i3] = (byte) j;
            return (i3 + 1) - i2;
        }
        return invokeCommon.intValue;
    }

    public static int zigZag32(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i2)) == null) ? (i2 >> 31) ^ (i2 << 1) : invokeI.intValue;
    }

    public static long zigZag64(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65552, null, j)) == null) ? (j >> 63) ^ (j << 1) : invokeJ.longValue;
    }

    public void writeFixed32(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            writeRawByte(i2 & 255);
            writeRawByte((i2 >> 8) & 255);
            writeRawByte((i2 >> 16) & 255);
            writeRawByte((i2 >> 24) & 255);
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

    public void writeRawByte(byte b2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(Constants.METHOD_SEND_USER_MSG, this, b2) == null) {
            int i2 = this.position;
            if (i2 != this.limit) {
                byte[] bArr = this.buffer;
                this.position = i2 + 1;
                bArr[i2] = b2;
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

    public void writeSignedVarint32(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (i2 >= 0) {
                writeVarint32(i2);
            } else {
                writeVarint64(i2);
            }
        }
    }

    public void writeVarint32(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            while ((i2 & a.f1888g) != 0) {
                writeRawByte((i2 & 127) | 128);
                i2 >>>= 7;
            }
            writeRawByte(i2);
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

    public static WireOutput newInstance(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, bArr, i2, i3)) == null) ? new WireOutput(bArr, i2, i3) : (WireOutput) invokeLII.objValue;
    }

    public void writeRawBytes(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, bArr, i2, i3) == null) {
            int i4 = this.limit;
            int i5 = this.position;
            if (i4 - i5 >= i3) {
                System.arraycopy(bArr, i2, this.buffer, i5, i3);
                this.position += i3;
                return;
            }
            throw new IOException("Out of space: position=" + this.position + ", limit=" + this.limit);
        }
    }

    public void writeTag(int i2, WireType wireType) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i2, wireType) == null) {
            writeVarint32(makeTag(i2, wireType));
        }
    }

    public void writeRawByte(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            writeRawByte((byte) i2);
        }
    }
}
