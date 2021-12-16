package io.flutter.plugin.common;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.common.StringUtils;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class StandardMessageCodec implements MessageCodec<Object> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte BIGINT = 5;
    public static final byte BYTE_ARRAY = 8;
    public static final byte DOUBLE = 6;
    public static final byte DOUBLE_ARRAY = 11;
    public static final byte FALSE = 2;
    public static final byte FLOAT_ARRAY = 14;
    public static final StandardMessageCodec INSTANCE;
    public static final byte INT = 3;
    public static final byte INT_ARRAY = 9;
    public static final byte LIST = 12;
    public static final boolean LITTLE_ENDIAN;
    public static final byte LONG = 4;
    public static final byte LONG_ARRAY = 10;
    public static final byte MAP = 13;
    public static final byte NULL = 0;
    public static final byte STRING = 7;
    public static final String TAG = "StandardMessageCodec#";
    public static final byte TRUE = 1;
    public static final Charset UTF8;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static final class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ExposedByteArrayOutputStream() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public byte[] buffer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((ByteArrayOutputStream) this).buf : (byte[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1591524759, "Lio/flutter/plugin/common/StandardMessageCodec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1591524759, "Lio/flutter/plugin/common/StandardMessageCodec;");
                return;
            }
        }
        INSTANCE = new StandardMessageCodec();
        LITTLE_ENDIAN = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
        UTF8 = Charset.forName(StringUtils.UTF8);
    }

    public StandardMessageCodec() {
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

    public static final void readAlignment(ByteBuffer byteBuffer, int i2) {
        int position;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65538, null, byteBuffer, i2) == null) || (position = byteBuffer.position() % i2) == 0) {
            return;
        }
        byteBuffer.position((byteBuffer.position() + i2) - position);
    }

    public static final byte[] readBytes(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, byteBuffer)) == null) {
            byte[] bArr = new byte[readSize(byteBuffer)];
            byteBuffer.get(bArr);
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static final int readSize(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, byteBuffer)) == null) {
            if (byteBuffer.hasRemaining()) {
                int i2 = byteBuffer.get() & 255;
                if (i2 < 254) {
                    return i2;
                }
                if (i2 == 254) {
                    return byteBuffer.getChar();
                }
                return byteBuffer.getInt();
            }
            throw new IllegalArgumentException("Message corrupted");
        }
        return invokeL.intValue;
    }

    public static final void writeAlignment(ByteArrayOutputStream byteArrayOutputStream, int i2) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65541, null, byteArrayOutputStream, i2) == null) || (size = byteArrayOutputStream.size() % i2) == 0) {
            return;
        }
        for (int i3 = 0; i3 < i2 - size; i3++) {
            byteArrayOutputStream.write(0);
        }
    }

    public static final void writeBytes(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, byteArrayOutputStream, bArr) == null) {
            writeSize(byteArrayOutputStream, bArr.length);
            byteArrayOutputStream.write(bArr, 0, bArr.length);
        }
    }

    public static final void writeChar(ByteArrayOutputStream byteArrayOutputStream, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, byteArrayOutputStream, i2) == null) {
            if (LITTLE_ENDIAN) {
                byteArrayOutputStream.write(i2);
                byteArrayOutputStream.write(i2 >>> 8);
                return;
            }
            byteArrayOutputStream.write(i2 >>> 8);
            byteArrayOutputStream.write(i2);
        }
    }

    public static final void writeDouble(ByteArrayOutputStream byteArrayOutputStream, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{byteArrayOutputStream, Double.valueOf(d2)}) == null) {
            writeLong(byteArrayOutputStream, Double.doubleToLongBits(d2));
        }
    }

    public static final void writeFloat(ByteArrayOutputStream byteArrayOutputStream, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65545, null, byteArrayOutputStream, f2) == null) {
            writeInt(byteArrayOutputStream, Float.floatToIntBits(f2));
        }
    }

    public static final void writeInt(ByteArrayOutputStream byteArrayOutputStream, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, null, byteArrayOutputStream, i2) == null) {
            if (LITTLE_ENDIAN) {
                byteArrayOutputStream.write(i2);
                byteArrayOutputStream.write(i2 >>> 8);
                byteArrayOutputStream.write(i2 >>> 16);
                byteArrayOutputStream.write(i2 >>> 24);
                return;
            }
            byteArrayOutputStream.write(i2 >>> 24);
            byteArrayOutputStream.write(i2 >>> 16);
            byteArrayOutputStream.write(i2 >>> 8);
            byteArrayOutputStream.write(i2);
        }
    }

    public static final void writeLong(ByteArrayOutputStream byteArrayOutputStream, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65547, null, byteArrayOutputStream, j2) == null) {
            if (LITTLE_ENDIAN) {
                byteArrayOutputStream.write((byte) j2);
                byteArrayOutputStream.write((byte) (j2 >>> 8));
                byteArrayOutputStream.write((byte) (j2 >>> 16));
                byteArrayOutputStream.write((byte) (j2 >>> 24));
                byteArrayOutputStream.write((byte) (j2 >>> 32));
                byteArrayOutputStream.write((byte) (j2 >>> 40));
                byteArrayOutputStream.write((byte) (j2 >>> 48));
                byteArrayOutputStream.write((byte) (j2 >>> 56));
                return;
            }
            byteArrayOutputStream.write((byte) (j2 >>> 56));
            byteArrayOutputStream.write((byte) (j2 >>> 48));
            byteArrayOutputStream.write((byte) (j2 >>> 40));
            byteArrayOutputStream.write((byte) (j2 >>> 32));
            byteArrayOutputStream.write((byte) (j2 >>> 24));
            byteArrayOutputStream.write((byte) (j2 >>> 16));
            byteArrayOutputStream.write((byte) (j2 >>> 8));
            byteArrayOutputStream.write((byte) j2);
        }
    }

    public static final void writeSize(ByteArrayOutputStream byteArrayOutputStream, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, null, byteArrayOutputStream, i2) == null) {
            if (i2 < 254) {
                byteArrayOutputStream.write(i2);
            } else if (i2 <= 65535) {
                byteArrayOutputStream.write(254);
                writeChar(byteArrayOutputStream, i2);
            } else {
                byteArrayOutputStream.write(255);
                writeInt(byteArrayOutputStream, i2);
            }
        }
    }

    @Override // io.flutter.plugin.common.MessageCodec
    public Object decodeMessage(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, byteBuffer)) == null) {
            if (byteBuffer == null) {
                return null;
            }
            byteBuffer.order(ByteOrder.nativeOrder());
            Object readValue = readValue(byteBuffer);
            if (byteBuffer.hasRemaining()) {
                throw new IllegalArgumentException("Message corrupted");
            }
            return readValue;
        }
        return invokeL.objValue;
    }

    @Override // io.flutter.plugin.common.MessageCodec
    public ByteBuffer encodeMessage(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj == null) {
                return null;
            }
            ExposedByteArrayOutputStream exposedByteArrayOutputStream = new ExposedByteArrayOutputStream();
            writeValue(exposedByteArrayOutputStream, obj);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
            allocateDirect.put(exposedByteArrayOutputStream.buffer(), 0, exposedByteArrayOutputStream.size());
            return allocateDirect;
        }
        return (ByteBuffer) invokeL.objValue;
    }

    public final Object readValue(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer)) == null) {
            if (byteBuffer.hasRemaining()) {
                return readValueOfType(byteBuffer.get(), byteBuffer);
            }
            throw new IllegalArgumentException("Message corrupted");
        }
        return invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x005d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.util.Map, java.util.HashMap] */
    public Object readValueOfType(byte b2, ByteBuffer byteBuffer) {
        InterceptResult invokeCommon;
        ?? arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Byte.valueOf(b2), byteBuffer})) == null) {
            int i2 = 0;
            switch (b2) {
                case 0:
                    return null;
                case 1:
                    return Boolean.TRUE;
                case 2:
                    return Boolean.FALSE;
                case 3:
                    return Integer.valueOf(byteBuffer.getInt());
                case 4:
                    return Long.valueOf(byteBuffer.getLong());
                case 5:
                    return new BigInteger(new String(readBytes(byteBuffer), UTF8), 16);
                case 6:
                    readAlignment(byteBuffer, 8);
                    return Double.valueOf(byteBuffer.getDouble());
                case 7:
                    return new String(readBytes(byteBuffer), UTF8);
                case 8:
                    return readBytes(byteBuffer);
                case 9:
                    int readSize = readSize(byteBuffer);
                    int[] iArr = new int[readSize];
                    readAlignment(byteBuffer, 4);
                    byteBuffer.asIntBuffer().get(iArr);
                    byteBuffer.position(byteBuffer.position() + (readSize * 4));
                    return iArr;
                case 10:
                    int readSize2 = readSize(byteBuffer);
                    long[] jArr = new long[readSize2];
                    readAlignment(byteBuffer, 8);
                    byteBuffer.asLongBuffer().get(jArr);
                    byteBuffer.position(byteBuffer.position() + (readSize2 * 8));
                    return jArr;
                case 11:
                    int readSize3 = readSize(byteBuffer);
                    double[] dArr = new double[readSize3];
                    readAlignment(byteBuffer, 8);
                    byteBuffer.asDoubleBuffer().get(dArr);
                    byteBuffer.position(byteBuffer.position() + (readSize3 * 8));
                    return dArr;
                case 12:
                    int readSize4 = readSize(byteBuffer);
                    arrayList = new ArrayList(readSize4);
                    while (i2 < readSize4) {
                        arrayList.add(readValue(byteBuffer));
                        i2++;
                    }
                    break;
                case 13:
                    int readSize5 = readSize(byteBuffer);
                    arrayList = new HashMap();
                    while (i2 < readSize5) {
                        arrayList.put(readValue(byteBuffer), readValue(byteBuffer));
                        i2++;
                    }
                    break;
                case 14:
                    int readSize6 = readSize(byteBuffer);
                    float[] fArr = new float[readSize6];
                    readAlignment(byteBuffer, 4);
                    byteBuffer.asFloatBuffer().get(fArr);
                    byteBuffer.position(byteBuffer.position() + (readSize6 * 4));
                    return fArr;
                default:
                    throw new IllegalArgumentException("Message corrupted");
            }
            return arrayList;
        }
        return invokeCommon.objValue;
    }

    public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, byteArrayOutputStream, obj) == null) {
            int i2 = 0;
            if (obj != null && !obj.equals(null)) {
                if (obj instanceof Boolean) {
                    byteArrayOutputStream.write(((Boolean) obj).booleanValue() ? 1 : 2);
                    return;
                } else if (obj instanceof Number) {
                    if (!(obj instanceof Integer) && !(obj instanceof Short) && !(obj instanceof Byte)) {
                        if (obj instanceof Long) {
                            byteArrayOutputStream.write(4);
                            writeLong(byteArrayOutputStream, ((Long) obj).longValue());
                            return;
                        } else if (!(obj instanceof Float) && !(obj instanceof Double)) {
                            if (obj instanceof BigInteger) {
                                byteArrayOutputStream.write(5);
                                writeBytes(byteArrayOutputStream, ((BigInteger) obj).toString(16).getBytes(UTF8));
                                return;
                            }
                            throw new IllegalArgumentException("Unsupported Number type: " + obj.getClass());
                        } else {
                            byteArrayOutputStream.write(6);
                            writeAlignment(byteArrayOutputStream, 8);
                            writeDouble(byteArrayOutputStream, ((Number) obj).doubleValue());
                            return;
                        }
                    }
                    byteArrayOutputStream.write(3);
                    writeInt(byteArrayOutputStream, ((Number) obj).intValue());
                    return;
                } else if (obj instanceof CharSequence) {
                    byteArrayOutputStream.write(7);
                    writeBytes(byteArrayOutputStream, obj.toString().getBytes(UTF8));
                    return;
                } else if (obj instanceof byte[]) {
                    byteArrayOutputStream.write(8);
                    writeBytes(byteArrayOutputStream, (byte[]) obj);
                    return;
                } else if (obj instanceof int[]) {
                    byteArrayOutputStream.write(9);
                    int[] iArr = (int[]) obj;
                    writeSize(byteArrayOutputStream, iArr.length);
                    writeAlignment(byteArrayOutputStream, 4);
                    int length = iArr.length;
                    while (i2 < length) {
                        writeInt(byteArrayOutputStream, iArr[i2]);
                        i2++;
                    }
                    return;
                } else if (obj instanceof long[]) {
                    byteArrayOutputStream.write(10);
                    long[] jArr = (long[]) obj;
                    writeSize(byteArrayOutputStream, jArr.length);
                    writeAlignment(byteArrayOutputStream, 8);
                    int length2 = jArr.length;
                    while (i2 < length2) {
                        writeLong(byteArrayOutputStream, jArr[i2]);
                        i2++;
                    }
                    return;
                } else if (obj instanceof double[]) {
                    byteArrayOutputStream.write(11);
                    double[] dArr = (double[]) obj;
                    writeSize(byteArrayOutputStream, dArr.length);
                    writeAlignment(byteArrayOutputStream, 8);
                    int length3 = dArr.length;
                    while (i2 < length3) {
                        writeDouble(byteArrayOutputStream, dArr[i2]);
                        i2++;
                    }
                    return;
                } else if (obj instanceof List) {
                    byteArrayOutputStream.write(12);
                    List<Object> list = (List) obj;
                    writeSize(byteArrayOutputStream, list.size());
                    for (Object obj2 : list) {
                        writeValue(byteArrayOutputStream, obj2);
                    }
                    return;
                } else if (obj instanceof Map) {
                    byteArrayOutputStream.write(13);
                    Map map = (Map) obj;
                    writeSize(byteArrayOutputStream, map.size());
                    for (Map.Entry entry : map.entrySet()) {
                        writeValue(byteArrayOutputStream, entry.getKey());
                        writeValue(byteArrayOutputStream, entry.getValue());
                    }
                    return;
                } else if (obj instanceof float[]) {
                    byteArrayOutputStream.write(14);
                    float[] fArr = (float[]) obj;
                    writeSize(byteArrayOutputStream, fArr.length);
                    writeAlignment(byteArrayOutputStream, 4);
                    int length4 = fArr.length;
                    while (i2 < length4) {
                        writeFloat(byteArrayOutputStream, fArr[i2]);
                        i2++;
                    }
                    return;
                } else {
                    throw new IllegalArgumentException("Unsupported value: '" + obj + "' of type '" + obj.getClass() + "'");
                }
            }
            byteArrayOutputStream.write(0);
        }
    }
}
