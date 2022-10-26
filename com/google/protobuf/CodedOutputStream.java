package com.google.protobuf;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes7.dex */
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

    public static int computeBoolSizeNoTag(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, null, z)) == null) {
            return 1;
        }
        return invokeZ.intValue;
    }

    public static int computeDoubleSizeNoTag(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Double.valueOf(d)})) == null) {
            return 8;
        }
        return invokeCommon.intValue;
    }

    public static int computeFixed32SizeNoTag(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) {
            return 4;
        }
        return invokeI.intValue;
    }

    public static int computeFixed64SizeNoTag(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65549, null, j)) == null) {
            return 8;
        }
        return invokeJ.intValue;
    }

    public static int computeFloatSizeNoTag(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65551, null, f)) == null) {
            return 4;
        }
        return invokeF.intValue;
    }

    public static int computePreferredBufferSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65564, null, i)) == null) {
            if (i > 4096) {
                return 4096;
            }
            return i;
        }
        return invokeI.intValue;
    }

    public static int computeRawVarint32Size(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65566, null, i)) == null) {
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

    public static int computeSFixed32SizeNoTag(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65569, null, i)) == null) {
            return 4;
        }
        return invokeI.intValue;
    }

    public static int computeSFixed64SizeNoTag(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65571, null, j)) == null) {
            return 8;
        }
        return invokeJ.intValue;
    }

    public static int encodeZigZag32(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65585, null, i)) == null) ? (i >> 31) ^ (i << 1) : invokeI.intValue;
    }

    public static long encodeZigZag64(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65586, null, j)) == null) ? (j >> 63) ^ (j << 1) : invokeJ.longValue;
    }

    /* loaded from: classes7.dex */
    public class OutOfSpaceException extends IOException {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {outputStream, bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public CodedOutputStream(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.output = null;
        this.buffer = bArr;
        this.position = i;
        this.limit = i + i2;
    }

    public static int computeBoolSize(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            return computeTagSize(i) + computeBoolSizeNoTag(z);
        }
        return invokeCommon.intValue;
    }

    public static int computeBytesSize(int i, ByteString byteString) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, byteString)) == null) {
            return computeTagSize(i) + computeBytesSizeNoTag(byteString);
        }
        return invokeIL.intValue;
    }

    public static int computeDoubleSize(int i, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Integer.valueOf(i), Double.valueOf(d)})) == null) {
            return computeTagSize(i) + computeDoubleSizeNoTag(d);
        }
        return invokeCommon.intValue;
    }

    public static int computeEnumSize(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65544, null, i, i2)) == null) {
            return computeTagSize(i) + computeEnumSizeNoTag(i2);
        }
        return invokeII.intValue;
    }

    public static int computeFixed32Size(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65546, null, i, i2)) == null) {
            return computeTagSize(i) + computeFixed32SizeNoTag(i2);
        }
        return invokeII.intValue;
    }

    public static int computeFixed64Size(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return computeTagSize(i) + computeFixed64SizeNoTag(j);
        }
        return invokeCommon.intValue;
    }

    public static int computeFloatSize(int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            return computeTagSize(i) + computeFloatSizeNoTag(f);
        }
        return invokeCommon.intValue;
    }

    public static int computeGroupSize(int i, MessageLite messageLite) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65552, null, i, messageLite)) == null) {
            return (computeTagSize(i) * 2) + computeGroupSizeNoTag(messageLite);
        }
        return invokeIL.intValue;
    }

    public static int computeInt32Size(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65554, null, i, i2)) == null) {
            return computeTagSize(i) + computeInt32SizeNoTag(i2);
        }
        return invokeII.intValue;
    }

    public static int computeInt64Size(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return computeTagSize(i) + computeInt64SizeNoTag(j);
        }
        return invokeCommon.intValue;
    }

    public static int computeLazyFieldMessageSetExtensionSize(int i, LazyField lazyField) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65558, null, i, lazyField)) == null) {
            return (computeTagSize(1) * 2) + computeUInt32Size(2, i) + computeLazyFieldSize(3, lazyField);
        }
        return invokeIL.intValue;
    }

    public static int computeLazyFieldSize(int i, LazyField lazyField) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65559, null, i, lazyField)) == null) {
            return computeTagSize(i) + computeLazyFieldSizeNoTag(lazyField);
        }
        return invokeIL.intValue;
    }

    public static int computeMessageSetExtensionSize(int i, MessageLite messageLite) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65561, null, i, messageLite)) == null) {
            return (computeTagSize(1) * 2) + computeUInt32Size(2, i) + computeMessageSize(3, messageLite);
        }
        return invokeIL.intValue;
    }

    public static int computeMessageSize(int i, MessageLite messageLite) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65562, null, i, messageLite)) == null) {
            return computeTagSize(i) + computeMessageSizeNoTag(messageLite);
        }
        return invokeIL.intValue;
    }

    public static int computeRawMessageSetExtensionSize(int i, ByteString byteString) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65565, null, i, byteString)) == null) {
            return (computeTagSize(1) * 2) + computeUInt32Size(2, i) + computeBytesSize(3, byteString);
        }
        return invokeIL.intValue;
    }

    public static int computeSFixed32Size(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65568, null, i, i2)) == null) {
            return computeTagSize(i) + computeSFixed32SizeNoTag(i2);
        }
        return invokeII.intValue;
    }

    public static int computeSFixed64Size(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65570, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return computeTagSize(i) + computeSFixed64SizeNoTag(j);
        }
        return invokeCommon.intValue;
    }

    public static int computeSInt32Size(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65572, null, i, i2)) == null) {
            return computeTagSize(i) + computeSInt32SizeNoTag(i2);
        }
        return invokeII.intValue;
    }

    public static int computeSInt64Size(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65574, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return computeTagSize(i) + computeSInt64SizeNoTag(j);
        }
        return invokeCommon.intValue;
    }

    public static int computeStringSize(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65576, null, i, str)) == null) {
            return computeTagSize(i) + computeStringSizeNoTag(str);
        }
        return invokeIL.intValue;
    }

    public static int computeUInt32Size(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65579, null, i, i2)) == null) {
            return computeTagSize(i) + computeUInt32SizeNoTag(i2);
        }
        return invokeII.intValue;
    }

    public static int computeUInt64Size(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65581, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            return computeTagSize(i) + computeUInt64SizeNoTag(j);
        }
        return invokeCommon.intValue;
    }

    @Deprecated
    public static int computeUnknownGroupSize(int i, MessageLite messageLite) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65583, null, i, messageLite)) == null) {
            return computeGroupSize(i, messageLite);
        }
        return invokeIL.intValue;
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65588, null, outputStream, i)) == null) {
            return new CodedOutputStream(outputStream, new byte[i]);
        }
        return (CodedOutputStream) invokeLI.objValue;
    }

    public void writeBool(int i, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            writeTag(i, 0);
            writeBoolNoTag(z);
        }
    }

    public void writeBytes(int i, ByteString byteString) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, byteString) == null) {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }
    }

    public void writeDouble(int i, double d) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Double.valueOf(d)}) == null) {
            writeTag(i, 1);
            writeDoubleNoTag(d);
        }
    }

    public void writeEnum(int i, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            writeTag(i, 0);
            writeEnumNoTag(i2);
        }
    }

    public void writeFixed32(int i, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            writeTag(i, 5);
            writeFixed32NoTag(i2);
        }
    }

    public void writeFixed64(int i, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            writeTag(i, 1);
            writeFixed64NoTag(j);
        }
    }

    public void writeFloat(int i, float f) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            writeTag(i, 5);
            writeFloatNoTag(f);
        }
    }

    public void writeGroup(int i, MessageLite messageLite) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048593, this, i, messageLite) == null) {
            writeTag(i, 3);
            writeGroupNoTag(messageLite);
            writeTag(i, 4);
        }
    }

    public void writeInt32(int i, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i, i2) == null) {
            writeTag(i, 0);
            writeInt32NoTag(i2);
        }
    }

    public void writeInt64(int i, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            writeTag(i, 0);
            writeInt64NoTag(j);
        }
    }

    public void writeMessage(int i, MessageLite messageLite) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048599, this, i, messageLite) == null) {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }
    }

    public void writeMessageSetExtension(int i, MessageLite messageLite) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048601, this, i, messageLite) == null) {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }
    }

    public void writeRawMessageSetExtension(int i, ByteString byteString) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048610, this, i, byteString) == null) {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }
    }

    public void writeSFixed32(int i, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048613, this, i, i2) == null) {
            writeTag(i, 5);
            writeSFixed32NoTag(i2);
        }
    }

    public void writeSFixed64(int i, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            writeTag(i, 1);
            writeSFixed64NoTag(j);
        }
    }

    public void writeSInt32(int i, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048617, this, i, i2) == null) {
            writeTag(i, 0);
            writeSInt32NoTag(i2);
        }
    }

    public void writeSInt64(int i, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            writeTag(i, 0);
            writeSInt64NoTag(j);
        }
    }

    public void writeString(int i, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048621, this, i, str) == null) {
            writeTag(i, 2);
            writeStringNoTag(str);
        }
    }

    public void writeTag(int i, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048623, this, i, i2) == null) {
            writeRawVarint32(WireFormat.makeTag(i, i2));
        }
    }

    public void writeUInt32(int i, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048624, this, i, i2) == null) {
            writeTag(i, 0);
            writeUInt32NoTag(i2);
        }
    }

    public void writeUInt64(int i, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            writeTag(i, 0);
            writeUInt64NoTag(j);
        }
    }

    @Deprecated
    public void writeUnknownGroup(int i, MessageLite messageLite) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048628, this, i, messageLite) == null) {
            writeGroup(i, messageLite);
        }
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, byteString)) == null) {
            return computeRawVarint32Size(byteString.size()) + byteString.size();
        }
        return invokeL.intValue;
    }

    public static int computeEnumSizeNoTag(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            return computeInt32SizeNoTag(i);
        }
        return invokeI.intValue;
    }

    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, messageLite)) == null) {
            return messageLite.getSerializedSize();
        }
        return invokeL.intValue;
    }

    public static int computeInt32SizeNoTag(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65555, null, i)) == null) {
            if (i >= 0) {
                return computeRawVarint32Size(i);
            }
            return 10;
        }
        return invokeI.intValue;
    }

    public static int computeInt64SizeNoTag(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65557, null, j)) == null) {
            return computeRawVarint64Size(j);
        }
        return invokeJ.intValue;
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

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, messageLite)) == null) {
            int serializedSize = messageLite.getSerializedSize();
            return computeRawVarint32Size(serializedSize) + serializedSize;
        }
        return invokeL.intValue;
    }

    public static int computeSInt32SizeNoTag(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65573, null, i)) == null) {
            return computeRawVarint32Size(encodeZigZag32(i));
        }
        return invokeI.intValue;
    }

    public static int computeSInt64SizeNoTag(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65575, null, j)) == null) {
            return computeRawVarint64Size(encodeZigZag64(j));
        }
        return invokeJ.intValue;
    }

    public static int computeStringSizeNoTag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, str)) == null) {
            try {
                byte[] bytes = str.getBytes("UTF-8");
                return computeRawVarint32Size(bytes.length) + bytes.length;
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UTF-8 not supported.", e);
            }
        }
        return invokeL.intValue;
    }

    public static int computeTagSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65578, null, i)) == null) {
            return computeRawVarint32Size(WireFormat.makeTag(i, 0));
        }
        return invokeI.intValue;
    }

    public static int computeUInt32SizeNoTag(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65580, null, i)) == null) {
            return computeRawVarint32Size(i);
        }
        return invokeI.intValue;
    }

    public static int computeUInt64SizeNoTag(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65582, null, j)) == null) {
            return computeRawVarint64Size(j);
        }
        return invokeJ.intValue;
    }

    @Deprecated
    public static int computeUnknownGroupSizeNoTag(MessageLite messageLite) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, messageLite)) == null) {
            return computeGroupSizeNoTag(messageLite);
        }
        return invokeL.intValue;
    }

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65587, null, outputStream)) == null) {
            return newInstance(outputStream, 4096);
        }
        return (CodedOutputStream) invokeL.objValue;
    }

    public void writeBoolNoTag(boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            writeRawByte(z ? 1 : 0);
        }
    }

    public void writeBytesNoTag(ByteString byteString) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, byteString) == null) {
            writeRawVarint32(byteString.size());
            writeRawBytes(byteString);
        }
    }

    public void writeDoubleNoTag(double d) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d)}) == null) {
            writeRawLittleEndian64(Double.doubleToRawLongBits(d));
        }
    }

    public void writeEnumNoTag(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            writeInt32NoTag(i);
        }
    }

    public void writeFixed32NoTag(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            writeRawLittleEndian32(i);
        }
    }

    public void writeFixed64NoTag(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            writeRawLittleEndian64(j);
        }
    }

    public void writeFloatNoTag(float f) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f) == null) {
            writeRawLittleEndian32(Float.floatToRawIntBits(f));
        }
    }

    public void writeGroupNoTag(MessageLite messageLite) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, messageLite) == null) {
            messageLite.writeTo(this);
        }
    }

    public void writeInt32NoTag(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            if (i >= 0) {
                writeRawVarint32(i);
            } else {
                writeRawVarint64(i);
            }
        }
    }

    public void writeInt64NoTag(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
            writeRawVarint64(j);
        }
    }

    public void writeMessageNoTag(MessageLite messageLite) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, messageLite) == null) {
            writeRawVarint32(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }
    }

    public void writeRawByte(byte b) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048602, this, b) == null) {
            if (this.position == this.limit) {
                refreshBuffer();
            }
            byte[] bArr = this.buffer;
            int i = this.position;
            this.position = i + 1;
            bArr[i] = b;
        }
    }

    public void writeRawBytes(ByteString byteString) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, byteString) == null) {
            writeRawBytes(byteString, 0, byteString.size());
        }
    }

    public void writeRawLittleEndian32(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            writeRawByte(i & 255);
            writeRawByte((i >> 8) & 255);
            writeRawByte((i >> 16) & 255);
            writeRawByte((i >> 24) & 255);
        }
    }

    public void writeRawVarint32(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            while ((i & (-128)) != 0) {
                writeRawByte((i & 127) | 128);
                i >>>= 7;
            }
            writeRawByte(i);
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

    public void writeSFixed32NoTag(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            writeRawLittleEndian32(i);
        }
    }

    public void writeSFixed64NoTag(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048616, this, j) == null) {
            writeRawLittleEndian64(j);
        }
    }

    public void writeSInt32NoTag(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            writeRawVarint32(encodeZigZag32(i));
        }
    }

    public void writeSInt64NoTag(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048620, this, j) == null) {
            writeRawVarint64(encodeZigZag64(j));
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

    public void writeUInt32NoTag(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            writeRawVarint32(i);
        }
    }

    public void writeUInt64NoTag(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048627, this, j) == null) {
            writeRawVarint64(j);
        }
    }

    @Deprecated
    public void writeUnknownGroupNoTag(MessageLite messageLite) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, messageLite) == null) {
            writeGroupNoTag(messageLite);
        }
    }

    public static CodedOutputStream newInstance(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, bArr)) == null) {
            return newInstance(bArr, 0, bArr.length);
        }
        return (CodedOutputStream) invokeL.objValue;
    }

    public void writeRawByte(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            writeRawByte((byte) i);
        }
    }

    public void writeRawBytes(byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bArr) == null) {
            writeRawBytes(bArr, 0, bArr.length);
        }
    }

    public static CodedOutputStream newInstance(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65590, null, bArr, i, i2)) == null) {
            return new CodedOutputStream(bArr, i, i2);
        }
        return (CodedOutputStream) invokeLII.objValue;
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
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || spaceLeft() == 0) {
            return;
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.output != null) {
            refreshBuffer();
        }
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

    public void writeRawBytes(ByteString byteString, int i, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048605, this, byteString, i, i2) == null) {
            int i3 = this.limit;
            int i4 = this.position;
            if (i3 - i4 >= i2) {
                byteString.copyTo(this.buffer, i, i4, i2);
                this.position += i2;
                return;
            }
            int i5 = i3 - i4;
            byteString.copyTo(this.buffer, i, i4, i5);
            int i6 = i + i5;
            int i7 = i2 - i5;
            this.position = this.limit;
            refreshBuffer();
            if (i7 <= this.limit) {
                byteString.copyTo(this.buffer, i6, 0, i7);
                this.position = i7;
                return;
            }
            InputStream newInput = byteString.newInput();
            long j = i6;
            if (j == newInput.skip(j)) {
                while (i7 > 0) {
                    int min = Math.min(i7, this.limit);
                    int read = newInput.read(this.buffer, 0, min);
                    if (read == min) {
                        this.output.write(this.buffer, 0, read);
                        i7 -= read;
                    } else {
                        throw new IllegalStateException("Read failed? Should never happen");
                    }
                }
                return;
            }
            throw new IllegalStateException("Skip failed? Should never happen.");
        }
    }

    public void writeRawBytes(byte[] bArr, int i, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048607, this, bArr, i, i2) == null) {
            int i3 = this.limit;
            int i4 = this.position;
            if (i3 - i4 >= i2) {
                System.arraycopy(bArr, i, this.buffer, i4, i2);
                this.position += i2;
                return;
            }
            int i5 = i3 - i4;
            System.arraycopy(bArr, i, this.buffer, i4, i5);
            int i6 = i + i5;
            int i7 = i2 - i5;
            this.position = this.limit;
            refreshBuffer();
            if (i7 <= this.limit) {
                System.arraycopy(bArr, i6, this.buffer, 0, i7);
                this.position = i7;
                return;
            }
            this.output.write(bArr, i6, i7);
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
}
