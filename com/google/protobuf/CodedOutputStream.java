package com.google.protobuf;

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
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
/* loaded from: classes6.dex */
public final class CodedOutputStream {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    public static final int LITTLE_ENDIAN_64_SIZE = 8;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] buffer;
    public final int limit;
    public final OutputStream output;
    public int position;

    /* loaded from: classes6.dex */
    public static class OutOfSpaceException extends IOException {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -6947486886997889499L;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public CodedOutputStream(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.output = null;
        this.buffer = bArr;
        this.position = i2;
        this.limit = i2 + i3;
    }

    public static int computeBoolSize(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? computeTagSize(i2) + computeBoolSizeNoTag(z) : invokeCommon.intValue;
    }

    public static int computeBoolSizeNoTag(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, null, z)) == null) {
            return 1;
        }
        return invokeZ.intValue;
    }

    public static int computeBytesSize(int i2, ByteString byteString) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, byteString)) == null) ? computeTagSize(i2) + computeBytesSizeNoTag(byteString) : invokeIL.intValue;
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, byteString)) == null) ? computeRawVarint32Size(byteString.size()) + byteString.size() : invokeL.intValue;
    }

    public static int computeDoubleSize(int i2, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Integer.valueOf(i2), Double.valueOf(d2)})) == null) ? computeTagSize(i2) + computeDoubleSizeNoTag(d2) : invokeCommon.intValue;
    }

    public static int computeDoubleSizeNoTag(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Double.valueOf(d2)})) == null) {
            return 8;
        }
        return invokeCommon.intValue;
    }

    public static int computeEnumSize(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65544, null, i2, i3)) == null) ? computeTagSize(i2) + computeEnumSizeNoTag(i3) : invokeII.intValue;
    }

    public static int computeEnumSizeNoTag(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) ? computeInt32SizeNoTag(i2) : invokeI.intValue;
    }

    public static int computeFixed32Size(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65546, null, i2, i3)) == null) ? computeTagSize(i2) + computeFixed32SizeNoTag(i3) : invokeII.intValue;
    }

    public static int computeFixed32SizeNoTag(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) {
            return 4;
        }
        return invokeI.intValue;
    }

    public static int computeFixed64Size(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) ? computeTagSize(i2) + computeFixed64SizeNoTag(j) : invokeCommon.intValue;
    }

    public static int computeFixed64SizeNoTag(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65549, null, j)) == null) {
            return 8;
        }
        return invokeJ.intValue;
    }

    public static int computeFloatSize(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) ? computeTagSize(i2) + computeFloatSizeNoTag(f2) : invokeCommon.intValue;
    }

    public static int computeFloatSizeNoTag(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65551, null, f2)) == null) {
            return 4;
        }
        return invokeF.intValue;
    }

    public static int computeGroupSize(int i2, MessageLite messageLite) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65552, null, i2, messageLite)) == null) ? (computeTagSize(i2) * 2) + computeGroupSizeNoTag(messageLite) : invokeIL.intValue;
    }

    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, messageLite)) == null) ? messageLite.getSerializedSize() : invokeL.intValue;
    }

    public static int computeInt32Size(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65554, null, i2, i3)) == null) ? computeTagSize(i2) + computeInt32SizeNoTag(i3) : invokeII.intValue;
    }

    public static int computeInt32SizeNoTag(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65555, null, i2)) == null) {
            if (i2 >= 0) {
                return computeRawVarint32Size(i2);
            }
            return 10;
        }
        return invokeI.intValue;
    }

    public static int computeInt64Size(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) ? computeTagSize(i2) + computeInt64SizeNoTag(j) : invokeCommon.intValue;
    }

    public static int computeInt64SizeNoTag(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65557, null, j)) == null) ? computeRawVarint64Size(j) : invokeJ.intValue;
    }

    public static int computeLazyFieldMessageSetExtensionSize(int i2, LazyField lazyField) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65558, null, i2, lazyField)) == null) ? (computeTagSize(1) * 2) + computeUInt32Size(2, i2) + computeLazyFieldSize(3, lazyField) : invokeIL.intValue;
    }

    public static int computeLazyFieldSize(int i2, LazyField lazyField) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65559, null, i2, lazyField)) == null) ? computeTagSize(i2) + computeLazyFieldSizeNoTag(lazyField) : invokeIL.intValue;
    }

    public static int computeLazyFieldSizeNoTag(LazyField lazyField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, lazyField)) == null) {
            int serializedSize = lazyField.getSerializedSize();
            return computeRawVarint32Size(serializedSize) + serializedSize;
        }
        return invokeL.intValue;
    }

    public static int computeMessageSetExtensionSize(int i2, MessageLite messageLite) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65561, null, i2, messageLite)) == null) ? (computeTagSize(1) * 2) + computeUInt32Size(2, i2) + computeMessageSize(3, messageLite) : invokeIL.intValue;
    }

    public static int computeMessageSize(int i2, MessageLite messageLite) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65562, null, i2, messageLite)) == null) ? computeTagSize(i2) + computeMessageSizeNoTag(messageLite) : invokeIL.intValue;
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, messageLite)) == null) {
            int serializedSize = messageLite.getSerializedSize();
            return computeRawVarint32Size(serializedSize) + serializedSize;
        }
        return invokeL.intValue;
    }

    public static int computePreferredBufferSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65564, null, i2)) == null) {
            if (i2 > 4096) {
                return 4096;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public static int computeRawMessageSetExtensionSize(int i2, ByteString byteString) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65565, null, i2, byteString)) == null) ? (computeTagSize(1) * 2) + computeUInt32Size(2, i2) + computeBytesSize(3, byteString) : invokeIL.intValue;
    }

    public static int computeRawVarint32Size(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65566, null, i2)) == null) {
            if ((i2 & a.f1889g) == 0) {
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

    public static int computeRawVarint64Size(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65567, null, j)) == null) {
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

    public static int computeSFixed32Size(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65568, null, i2, i3)) == null) ? computeTagSize(i2) + computeSFixed32SizeNoTag(i3) : invokeII.intValue;
    }

    public static int computeSFixed32SizeNoTag(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65569, null, i2)) == null) {
            return 4;
        }
        return invokeI.intValue;
    }

    public static int computeSFixed64Size(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65570, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) ? computeTagSize(i2) + computeSFixed64SizeNoTag(j) : invokeCommon.intValue;
    }

    public static int computeSFixed64SizeNoTag(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65571, null, j)) == null) {
            return 8;
        }
        return invokeJ.intValue;
    }

    public static int computeSInt32Size(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65572, null, i2, i3)) == null) ? computeTagSize(i2) + computeSInt32SizeNoTag(i3) : invokeII.intValue;
    }

    public static int computeSInt32SizeNoTag(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65573, null, i2)) == null) ? computeRawVarint32Size(encodeZigZag32(i2)) : invokeI.intValue;
    }

    public static int computeSInt64Size(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65574, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) ? computeTagSize(i2) + computeSInt64SizeNoTag(j) : invokeCommon.intValue;
    }

    public static int computeSInt64SizeNoTag(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65575, null, j)) == null) ? computeRawVarint64Size(encodeZigZag64(j)) : invokeJ.intValue;
    }

    public static int computeStringSize(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65576, null, i2, str)) == null) ? computeTagSize(i2) + computeStringSizeNoTag(str) : invokeIL.intValue;
    }

    public static int computeStringSizeNoTag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, str)) == null) {
            try {
                byte[] bytes = str.getBytes("UTF-8");
                return computeRawVarint32Size(bytes.length) + bytes.length;
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException("UTF-8 not supported.", e2);
            }
        }
        return invokeL.intValue;
    }

    public static int computeTagSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65578, null, i2)) == null) ? computeRawVarint32Size(WireFormat.makeTag(i2, 0)) : invokeI.intValue;
    }

    public static int computeUInt32Size(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65579, null, i2, i3)) == null) ? computeTagSize(i2) + computeUInt32SizeNoTag(i3) : invokeII.intValue;
    }

    public static int computeUInt32SizeNoTag(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65580, null, i2)) == null) ? computeRawVarint32Size(i2) : invokeI.intValue;
    }

    public static int computeUInt64Size(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65581, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) ? computeTagSize(i2) + computeUInt64SizeNoTag(j) : invokeCommon.intValue;
    }

    public static int computeUInt64SizeNoTag(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65582, null, j)) == null) ? computeRawVarint64Size(j) : invokeJ.intValue;
    }

    @Deprecated
    public static int computeUnknownGroupSize(int i2, MessageLite messageLite) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65583, null, i2, messageLite)) == null) ? computeGroupSize(i2, messageLite) : invokeIL.intValue;
    }

    @Deprecated
    public static int computeUnknownGroupSizeNoTag(MessageLite messageLite) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65584, null, messageLite)) == null) ? computeGroupSizeNoTag(messageLite) : invokeL.intValue;
    }

    public static int encodeZigZag32(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65585, null, i2)) == null) ? (i2 >> 31) ^ (i2 << 1) : invokeI.intValue;
    }

    public static long encodeZigZag64(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65586, null, j)) == null) ? (j >> 63) ^ (j << 1) : invokeJ.longValue;
    }

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65587, null, outputStream)) == null) ? newInstance(outputStream, 4096) : (CodedOutputStream) invokeL.objValue;
    }

    private void refreshBuffer() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65591, this) == null) {
            OutputStream outputStream = this.output;
            if (outputStream != null) {
                outputStream.write(this.buffer, 0, this.position);
                this.position = 0;
                return;
            }
            throw new OutOfSpaceException();
        }
    }

    public void checkNoSpaceLeft() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && spaceLeft() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.output == null) {
            return;
        }
        refreshBuffer();
    }

    public int spaceLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.output == null) {
                return this.limit - this.position;
            }
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
        }
        return invokeV.intValue;
    }

    public void writeBool(int i2, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            writeTag(i2, 0);
            writeBoolNoTag(z);
        }
    }

    public void writeBoolNoTag(boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            writeRawByte(z ? 1 : 0);
        }
    }

    public void writeBytes(int i2, ByteString byteString) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, byteString) == null) {
            writeTag(i2, 2);
            writeBytesNoTag(byteString);
        }
    }

    public void writeBytesNoTag(ByteString byteString) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, byteString) == null) {
            writeRawVarint32(byteString.size());
            writeRawBytes(byteString);
        }
    }

    public void writeDouble(int i2, double d2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2)}) == null) {
            writeTag(i2, 1);
            writeDoubleNoTag(d2);
        }
    }

    public void writeDoubleNoTag(double d2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d2)}) == null) {
            writeRawLittleEndian64(Double.doubleToRawLongBits(d2));
        }
    }

    public void writeEnum(int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            writeTag(i2, 0);
            writeEnumNoTag(i3);
        }
    }

    public void writeEnumNoTag(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            writeInt32NoTag(i2);
        }
    }

    public void writeFixed32(int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            writeTag(i2, 5);
            writeFixed32NoTag(i3);
        }
    }

    public void writeFixed32NoTag(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            writeRawLittleEndian32(i2);
        }
    }

    public void writeFixed64(int i2, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            writeTag(i2, 1);
            writeFixed64NoTag(j);
        }
    }

    public void writeFixed64NoTag(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            writeRawLittleEndian64(j);
        }
    }

    public void writeFloat(int i2, float f2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            writeTag(i2, 5);
            writeFloatNoTag(f2);
        }
    }

    public void writeFloatNoTag(float f2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            writeRawLittleEndian32(Float.floatToRawIntBits(f2));
        }
    }

    public void writeGroup(int i2, MessageLite messageLite) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048593, this, i2, messageLite) == null) {
            writeTag(i2, 3);
            writeGroupNoTag(messageLite);
            writeTag(i2, 4);
        }
    }

    public void writeGroupNoTag(MessageLite messageLite) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, messageLite) == null) {
            messageLite.writeTo(this);
        }
    }

    public void writeInt32(int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i2, i3) == null) {
            writeTag(i2, 0);
            writeInt32NoTag(i3);
        }
    }

    public void writeInt32NoTag(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (i2 >= 0) {
                writeRawVarint32(i2);
            } else {
                writeRawVarint64(i2);
            }
        }
    }

    public void writeInt64(int i2, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            writeTag(i2, 0);
            writeInt64NoTag(j);
        }
    }

    public void writeInt64NoTag(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
            writeRawVarint64(j);
        }
    }

    public void writeMessage(int i2, MessageLite messageLite) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048599, this, i2, messageLite) == null) {
            writeTag(i2, 2);
            writeMessageNoTag(messageLite);
        }
    }

    public void writeMessageNoTag(MessageLite messageLite) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, messageLite) == null) {
            writeRawVarint32(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }
    }

    public void writeMessageSetExtension(int i2, MessageLite messageLite) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048601, this, i2, messageLite) == null) {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }
    }

    public void writeRawByte(byte b2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048602, this, b2) == null) {
            if (this.position == this.limit) {
                refreshBuffer();
            }
            byte[] bArr = this.buffer;
            int i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = b2;
        }
    }

    public void writeRawBytes(ByteString byteString) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, byteString) == null) {
            writeRawBytes(byteString, 0, byteString.size());
        }
    }

    public void writeRawLittleEndian32(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            writeRawByte(i2 & 255);
            writeRawByte((i2 >> 8) & 255);
            writeRawByte((i2 >> 16) & 255);
            writeRawByte((i2 >> 24) & 255);
        }
    }

    public void writeRawLittleEndian64(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048609, this, j) == null) {
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

    public void writeRawMessageSetExtension(int i2, ByteString byteString) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048610, this, i2, byteString) == null) {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }
    }

    public void writeRawVarint32(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            while ((i2 & a.f1889g) != 0) {
                writeRawByte((i2 & 127) | 128);
                i2 >>>= 7;
            }
            writeRawByte(i2);
        }
    }

    public void writeRawVarint64(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048612, this, j) == null) {
            while (((-128) & j) != 0) {
                writeRawByte((((int) j) & 127) | 128);
                j >>>= 7;
            }
            writeRawByte((int) j);
        }
    }

    public void writeSFixed32(int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048613, this, i2, i3) == null) {
            writeTag(i2, 5);
            writeSFixed32NoTag(i3);
        }
    }

    public void writeSFixed32NoTag(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            writeRawLittleEndian32(i2);
        }
    }

    public void writeSFixed64(int i2, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            writeTag(i2, 1);
            writeSFixed64NoTag(j);
        }
    }

    public void writeSFixed64NoTag(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048616, this, j) == null) {
            writeRawLittleEndian64(j);
        }
    }

    public void writeSInt32(int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048617, this, i2, i3) == null) {
            writeTag(i2, 0);
            writeSInt32NoTag(i3);
        }
    }

    public void writeSInt32NoTag(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            writeRawVarint32(encodeZigZag32(i2));
        }
    }

    public void writeSInt64(int i2, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            writeTag(i2, 0);
            writeSInt64NoTag(j);
        }
    }

    public void writeSInt64NoTag(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048620, this, j) == null) {
            writeRawVarint64(encodeZigZag64(j));
        }
    }

    public void writeString(int i2, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048621, this, i2, str) == null) {
            writeTag(i2, 2);
            writeStringNoTag(str);
        }
    }

    public void writeStringNoTag(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            byte[] bytes = str.getBytes("UTF-8");
            writeRawVarint32(bytes.length);
            writeRawBytes(bytes);
        }
    }

    public void writeTag(int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048623, this, i2, i3) == null) {
            writeRawVarint32(WireFormat.makeTag(i2, i3));
        }
    }

    public void writeUInt32(int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048624, this, i2, i3) == null) {
            writeTag(i2, 0);
            writeUInt32NoTag(i3);
        }
    }

    public void writeUInt32NoTag(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            writeRawVarint32(i2);
        }
    }

    public void writeUInt64(int i2, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            writeTag(i2, 0);
            writeUInt64NoTag(j);
        }
    }

    public void writeUInt64NoTag(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048627, this, j) == null) {
            writeRawVarint64(j);
        }
    }

    @Deprecated
    public void writeUnknownGroup(int i2, MessageLite messageLite) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048628, this, i2, messageLite) == null) {
            writeGroup(i2, messageLite);
        }
    }

    @Deprecated
    public void writeUnknownGroupNoTag(MessageLite messageLite) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, messageLite) == null) {
            writeGroupNoTag(messageLite);
        }
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65588, null, outputStream, i2)) == null) ? new CodedOutputStream(outputStream, new byte[i2]) : (CodedOutputStream) invokeLI.objValue;
    }

    public void writeRawBytes(byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bArr) == null) {
            writeRawBytes(bArr, 0, bArr.length);
        }
    }

    public static CodedOutputStream newInstance(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65589, null, bArr)) == null) ? newInstance(bArr, 0, bArr.length) : (CodedOutputStream) invokeL.objValue;
    }

    public void writeRawBytes(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048607, this, bArr, i2, i3) == null) {
            int i4 = this.limit;
            int i5 = this.position;
            if (i4 - i5 >= i3) {
                System.arraycopy(bArr, i2, this.buffer, i5, i3);
                this.position += i3;
                return;
            }
            int i6 = i4 - i5;
            System.arraycopy(bArr, i2, this.buffer, i5, i6);
            int i7 = i2 + i6;
            int i8 = i3 - i6;
            this.position = this.limit;
            refreshBuffer();
            if (i8 <= this.limit) {
                System.arraycopy(bArr, i7, this.buffer, 0, i8);
                this.position = i8;
                return;
            }
            this.output.write(bArr, i7, i8);
        }
    }

    public static CodedOutputStream newInstance(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65590, null, bArr, i2, i3)) == null) ? new CodedOutputStream(bArr, i2, i3) : (CodedOutputStream) invokeLII.objValue;
    }

    public void writeRawByte(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            writeRawByte((byte) i2);
        }
    }

    public CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream, bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.output = outputStream;
        this.buffer = bArr;
        this.position = 0;
        this.limit = bArr.length;
    }

    public void writeRawBytes(ByteString byteString, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048605, this, byteString, i2, i3) == null) {
            int i4 = this.limit;
            int i5 = this.position;
            if (i4 - i5 >= i3) {
                byteString.copyTo(this.buffer, i2, i5, i3);
                this.position += i3;
                return;
            }
            int i6 = i4 - i5;
            byteString.copyTo(this.buffer, i2, i5, i6);
            int i7 = i2 + i6;
            int i8 = i3 - i6;
            this.position = this.limit;
            refreshBuffer();
            if (i8 <= this.limit) {
                byteString.copyTo(this.buffer, i7, 0, i8);
                this.position = i8;
                return;
            }
            InputStream newInput = byteString.newInput();
            long j = i7;
            if (j != newInput.skip(j)) {
                throw new IllegalStateException("Skip failed? Should never happen.");
            }
            while (i8 > 0) {
                int min = Math.min(i8, this.limit);
                int read = newInput.read(this.buffer, 0, min);
                if (read == min) {
                    this.output.write(this.buffer, 0, read);
                    i8 -= read;
                } else {
                    throw new IllegalStateException("Read failed? Should never happen");
                }
            }
        }
    }
}
